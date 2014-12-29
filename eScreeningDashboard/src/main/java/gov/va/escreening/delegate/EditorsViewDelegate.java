package gov.va.escreening.delegate;

import gov.va.escreening.dto.ae.Page;
import gov.va.escreening.dto.editors.BatteryInfo;
import gov.va.escreening.dto.editors.SurveyInfo;
import gov.va.escreening.dto.editors.SurveyPageInfo;
import gov.va.escreening.dto.editors.SurveySectionInfo;

import java.util.List;

public interface EditorsViewDelegate {

    BatteryInfo createBattery(BatteryInfo batteryInfo);
    BatteryInfo getBattery(int batteryId);
    List<BatteryInfo> getBatteries();
    void updateBattery(BatteryInfo batteryInfo);
    void deleteBattery(Integer batteryId);
    
    List<SurveyInfo> getSurveys();
    SurveyInfo getSurvey(int surveyId);
    SurveyInfo updateSurvey(SurveyInfo surveyInfo);
    
    Integer createSection(SurveySectionInfo surveySection);
   	SurveySectionInfo getSection(Integer sectionId);
   	List<SurveySectionInfo> getSections();
    SurveySectionInfo updateSection(SurveySectionInfo surveySectionInfo);
   	void deleteSection(Integer surveySectionId);
   	
   	void removeQuestionFromSurvey(Integer surveyId, Integer questionId);
	void createSurveyPage(Integer surveyId, Page surveyPage);
	void updateSurveyPages(Integer surveyId, List<SurveyPageInfo> surveyPageInfo);
	List<SurveyPageInfo> getSurveyPages(Integer surveyId);
	SurveyInfo createSurvey(SurveyInfo survey);
}
