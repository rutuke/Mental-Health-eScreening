package gov.va.escreening.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import gov.va.escreening.delegate.ReportFunctionCommon;
import gov.va.escreening.delegate.ScoreMap;
import gov.va.escreening.entity.AssessmentVariable;
import gov.va.escreening.entity.Survey;
import gov.va.escreening.entity.SurveyScoreInterval;
import gov.va.escreening.repository.SurveyRepository;
import gov.va.escreening.repository.SurveyScoreIntervalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by kliu on 3/6/15.
 */
@Service
public class SurveyScoreIntervalServiceImpl implements SurveyScoreIntervalService {

    @Autowired
    private SurveyScoreIntervalRepository intervalRepository;

    @Resource(type = SurveyRepository.class)
    SurveyRepository sr;

    @Resource(name = "assessmentVariableService")
    AssessmentVariableService avs;

    @Resource(type = ReportFunctionCommon.class)
    private ReportFunctionCommon reportsHelper;

    @Resource(name = "scoreMap")
    ScoreMap scoreMap;

    @Transactional(readOnly = true)
    @Override
    public String getScoreMeaning(Integer surveyId, Number score) {

        List<SurveyScoreInterval> intervals = intervalRepository.getIntervalsBySurvey(surveyId);

        for (SurveyScoreInterval interval : intervals) {

            if (score.floatValue() >= Float.parseFloat(interval.getMin())
                    &&
                    score.floatValue() <= Float.parseFloat(interval.getMax())) {
                return interval.getMeaning();
            }
        }
        return null;

    }


    @Transactional(readOnly = true)
    @Override
    public Map<String, Object> generateMetadata(Integer surveyId, Integer veteranId, String avName, Integer clinicId) {

        List<SurveyScoreInterval> intervals = intervalRepository.getIntervalsBySurvey(surveyId);
        if (intervals == null || intervals.isEmpty()) {
            return null;
        }

        String max = "-1";
        String min = "100000";

        Map<String, Object> metaDataMap = createTemplateMetaData(surveyId, veteranId, avName, clinicId);
        List<Float> ticks = Lists.newArrayList();
        Map<String, Object> intervalsMap = Maps.newLinkedHashMap();


        for (SurveyScoreInterval interval : intervals) {

            if (!interval.isException()) {
                if (Float.parseFloat(min) > Float.parseFloat(interval.getMin())) {
                    min = interval.getMin();
                }
                if (Float.parseFloat(max) < Float.parseFloat(interval.getMax())) {
                    max = interval.getMax();
                }

                ticks.add(Float.valueOf(interval.getMin()));
                intervalsMap.put(interval.getMeaning(), Float.valueOf(interval.getMin()));
            }
        }

        ticks.add(Float.valueOf(max));

        metaDataMap.put("ticks", ticks);
        metaDataMap.put("intervals", intervalsMap);
        metaDataMap.put("maxXPoint", Float.valueOf(max));
        return metaDataMap;
    }

    private Map<String, Object> createTemplateMetaData(int surveyId,  Integer veteranId, String avName, Integer clinicId) {
        Map<String, Object> metaDataMap = Maps.newHashMap();
        metaDataMap.put("footer", ""); //todo what to do here?
        String title = reportsHelper.getModuleName(surveyId, avName, this.scoreMap.getAvMap());
        metaDataMap.put("title", title);
        metaDataMap.put("chartId", reportsHelper.createChartId(surveyId, avName, veteranId, clinicId));
        metaDataMap.put("numberOfMonths", 12); //todo find a logic to assign the right number here
        return metaDataMap;
    }
}
