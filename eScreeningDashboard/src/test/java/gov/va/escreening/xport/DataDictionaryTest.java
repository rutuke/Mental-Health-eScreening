package gov.va.escreening.xport;

import com.google.common.collect.TreeBasedTable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gov.va.escreening.service.export.DataDictionaryService;
import gov.va.escreening.view.DataDictionaryExcelView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.StaticWebApplicationContext;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.google.common.collect.Maps;
import com.google.common.collect.Table;

@Transactional
// this is to ensure all tests do not leave trace, so they are repeatable.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DataDictionaryTest {
    Logger logger = LoggerFactory.getLogger(DataDictionaryTest.class);

    @Resource(type = DataDictionaryService.class)
    DataDictionaryService dds;

    private MockServletContext servletCtx;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private StaticWebApplicationContext webAppCtx;

    @Before
    public void setUp() {
        servletCtx = new MockServletContext("org/springframework/web/servlet/view/document");
        request = new MockHttpServletRequest(servletCtx);
        response = new MockHttpServletResponse();
        webAppCtx = new StaticWebApplicationContext();
        webAppCtx.setServletContext(servletCtx);
    }

    @Test
    public void createDataDictionary() throws Exception {
        Map<String, Table<String, String, String>> dataDictionary = dds.createDataDictionary();
        Gson gson = new GsonBuilder().create();
        String ddAsString = gson.toJson(dataDictionary);
        int ddSize = ddAsString.length();

        Map<String, Table<String, String, String>> dataDictionary1 = reconstructDataDictionary(ddAsString);
        Gson gson1 = new GsonBuilder().create();
        String dd1AsString = gson1.toJson(dataDictionary1);

        int dd1Size = dd1AsString.length();

        Assert.assertEquals(dataDictionary, dataDictionary1);

        logDataDictionary(dataDictionary);

        viewDataDictionaryAsExcel(dataDictionary);
        viewDataDictionaryAsExcel(dataDictionary1);
    }

    private Map<String, Table<String, String, String>> reconstructDataDictionary(String ddAsString) {
        Gson gson1 = new GsonBuilder().create();
        Map raw = gson1.fromJson(ddAsString, Map.class);

        Map<String, Table<String, String, String>> dd = Maps.newLinkedHashMap();

        for (Object o : raw.keySet()) {
            String moduleName = (String) o;
            Table<String, String, String> t = TreeBasedTable.create();
            Map m = (Map) raw.get(moduleName);
            Map m1 = (Map) m.get("backingMap");
            for (Object k : m1.keySet()) {
                String key = (String) k;
                Map<String, String> m2 = (Map<String, String>) m1.get(key);
                for (String key1 : m2.keySet()) {
                    t.put(key, key1, m2.get(key1));
                }
            }
            dd.put(moduleName, t);
        }
        return dd;
    }

    @Test
    public void zipDirTest() throws Exception {
        String documentDirName = System.getProperty("user.home") + File.separator + "Documents";
        String zipFileName = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "ddPlusExport_" + ISODateTimeFormat.dateTime().print(DateTime.now()) + ".zip";

        zipDirectory(documentDirName, zipFileName);
    }

    /**
     * Zip the contents of the directory, and save it in the zipfile
     */
    public static void zipDirectory(String dir, String zipfile)
            throws IOException, IllegalArgumentException {
        // Check that the directory is a directory, and get its contents
        File d = new File(dir);
        if (!d.isDirectory())
            throw new IllegalArgumentException("Not a directory:  "
                    + dir);
        String[] entries = d.list();
        byte[] buffer = new byte[4096]; // Create a buffer for copying
        int bytesRead;

        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));

        for (int i = 0; i < entries.length; i++) {
            File f = new File(d, entries[i]);
            if (f.isDirectory())
                continue;//Ignore directory
            FileInputStream in = new FileInputStream(f); // Stream to read file
            ZipEntry entry = new ZipEntry(f.getPath()); // Make a ZipEntry
            out.putNextEntry(entry); // Store entry
            while ((bytesRead = in.read(buffer)) != -1)
                out.write(buffer, 0, bytesRead);
            in.close();
        }
        out.close();
    }

    private void viewDataDictionaryAsExcel(
            Map<String, Table<String, String, String>> dataDictionary) throws Exception {

        AbstractExcelView excelView = new DataDictionaryExcelView();

        Map<String, Map<String, Table<String, String, String>>> model = Maps.newHashMap();
        model.put("dataDictionary", dataDictionary);
        excelView.render(model, request, response);

        String documentDirName = System.getProperty("user.home") + File.separator + "Documents";
        writeAsExcelFile(documentDirName + File.separator + "data_dict_test_" + System.nanoTime() + ".xls", response);
    }

    @Test
    public void removeTernaryTest() {
        String ternary = "(([tbi_week_memory]?1:0) + ([tbi_week_balance]?1:0) + ([tbi_week_light]?1:0) + ([tbi_week_irritable]?1:0) + ([tbi_week_headache]?1:0) + ([tbi_week_sleep]?1:0))";
        String refined = ternary.replaceAll("[?]", "").replaceAll("1:0", "");
        int i = 0;
    }

    private void writeAsExcelFile(String excelFile,
                                  MockHttpServletResponse response) throws IOException {
        File dest = new File(excelFile);
        FileOutputStream byteSink = new FileOutputStream(dest);
        byteSink.write(response.getContentAsByteArray());
        byteSink.flush();
        byteSink.close();
        //Assert.assertSame(Files.toByteArray(dest), response.getContentAsByteArray());
    }

    private void logDataDictionary(
            Map<String, Table<String, String, String>> dataDictionary) {
        // for each row key
        for (String surveyName : dataDictionary.keySet()) {
            logger.info("Survey name:" + surveyName);
            Table<String, String, String> measuresTable = dataDictionary.get(surveyName);
            for (String measureRowNum : measuresTable.rowKeySet()) {
                StringBuilder measureColumns = new StringBuilder();
                for (Entry<String, String> rowData : measuresTable.row(measureRowNum).entrySet()) {
                    measureColumns.append(String.format("%s:%s$", rowData.getKey(), rowData.getValue()));
                }
                logger.info(measureColumns.toString());
            }
        }
    }
}