package gov.va.escreening.view;

import gov.va.escreening.dto.dashboard.AssessmentDataExport;
import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.service.export.ExportLogService;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

public class AssessmentDataExportCsvView extends AbstractView {

	private static final Logger logger = LoggerFactory.getLogger(AssessmentDataExportCsvView.class);

	private final String defaultErrorMsg = "An error occured while generating the requested export.  Please contact technical support for assistance.";

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {

		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(response.getWriter());

			AssessmentDataExport dataExport = (AssessmentDataExport) model.get("dataExportList");

			String csvFileName = dataExport.getFilterOptions().getFilePath();
			response.setHeader("Content-Disposition", "attachment; filename=\"" + csvFileName + "\"");

			setCsvHeader(writer, dataExport.getHeader(), csvFileName);
			setCsvRows(writer, dataExport.getData(), csvFileName);

		} catch (IOException ioe) {
			throw new IllegalStateException(defaultErrorMsg);
		} finally {
			if (writer != null) {
				try {
					writer.flush();
					writer.close();
				} catch (IOException e) {
					throw new IllegalStateException(defaultErrorMsg);
				}
			}
		}
	}

	private void setCsvRows(BufferedWriter writer, List<String> data,
			String fileName) throws IOException {
		for (String row : data) {
			writer.write(row);
			writer.newLine();
			if (logger.isDebugEnabled()) {
				logger.debug(String.format("row written for %s [%s]", fileName, row));
			}
		}
	}

	private void setCsvHeader(BufferedWriter writer, String header,
			String fileName) throws IOException {
		writer.write(header);
		writer.newLine();
		if (logger.isDebugEnabled()) {
			logger.debug(String.format("header written for %s [%s]", fileName, header));
		}
	}

}