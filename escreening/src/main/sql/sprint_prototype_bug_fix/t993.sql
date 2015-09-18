INSERT INTO `template_type` (`template_type_id`, `name`, `description`)
VALUES (20, 'TBI Consult Reason', 'Template used to generate the TBI Consult reason text');

INSERT INTO `template` (`template_id`,`template_type_id`,`name`,`description`,`template_file`,`date_created`,`is_graphical`,`json_file`,`date_modified`,`graph_params`) VALUES (3710,20,'TBI Consult Reason',NULL,'<#include \"clinicalnotefunctions\">\n<#-- generated file. Do not change -->\n${MODULE_START}\n<#-- NAME:full text             -->\n<#-- SECTION:1 -->\n<#-- SUMMARY:Veteran not previously seen by the San Diego VA TBI clinic OIF/OEF VeteranOIF/OEF Veteran with: OIF/OEF deployment-related, suspected TBI.Persistent symptoms.Positive OIF/OEF TBI screen.OIF/OEF TBI screen completed date:   -->\n<p></p>Veteran not previously seen by the San Diego VA TBI clinic${NBSP}<div><div>OIF/OEF Veteran</div></div><div><p><span style=\"font-family: inherit; line-height: 1.42857;\">OIF/OEF Veteran with:</span><br></p><p></p><blockquote style=\"margin: 0 0 0 40px; border: none; padding: 0px;\"><p></p></blockquote><p></p><blockquote style=\"margin: 0 0 0 40px; border: none; padding: 0px;\">OIF/OEF deployment-related, suspected TBI.</blockquote><p></p><blockquote style=\"margin: 0 0 0 40px; border: none; padding: 0px;\"><p></p></blockquote><p></p><blockquote style=\"margin: 0 0 0 40px; border: none; padding: 0px;\">Persistent symptoms.</blockquote><p></p><blockquote style=\"margin: 0 0 0 40px; border: none; padding: 0px;\">Positive OIF/OEF TBI screen.</blockquote><div><p>OIF/OEF TBI screen completed date:${NBSP}${getCustomValue(var7)}</p><p>When &amp; Where did the TBI occur: <br></p><p>${NBSP}${NBSP} ${getResponse(var3460)}, ${getResponse(var3450)} <br></p><p>How did the TBI occur:</p><p>${NBSP}${NBSP} ${getResponse(var3470)}</p><p>GOALS for TBI clinic evaluation:<br></p><blockquote style=\"margin: 0 0 0 40px; border: none; padding: 0px;\"><p>Please evaluate and refer on for additional services as necessary</p></blockquote><p><br></p><p><br></p></div></div>\n${MODULE_END}\n','2015-09-13 19:58:38',0,'[{\"summary\":\"Veteran not previously seen by the San Diego VA TBI clinic OIF/OEF VeteranOIF/OEF Veteran with: OIF/OEF deployment-related, suspected TBI.Persistent symptoms.Positive OIF/OEF TBI screen.OIF/OEF TBI screen completed date:  \",\"name\":\"full text             \",\"section\":\"1\",\"children\":[],\"contents\":[{\"type\":\"text\",\"content\":\"<p></p>Veteran not previously seen by the San Diego VA TBI clinic&nbsp;<div><div>OIF/OEF Veteran</div></div><div><p><span style=\\\"font-family: inherit; line-height: 1.42857;\\\">OIF/OEF Veteran with:</span><br></p><p></p><blockquote style=\\\"margin: 0 0 0 40px; border: none; padding: 0px;\\\"><p></p></blockquote><p></p><blockquote style=\\\"margin: 0 0 0 40px; border: none; padding: 0px;\\\">OIF/OEF deployment-related, suspected TBI.</blockquote><p></p><blockquote style=\\\"margin: 0 0 0 40px; border: none; padding: 0px;\\\"><p></p></blockquote><p></p><blockquote style=\\\"margin: 0 0 0 40px; border: none; padding: 0px;\\\">Persistent symptoms.</blockquote><p></p><blockquote style=\\\"margin: 0 0 0 40px; border: none; padding: 0px;\\\">Positive OIF/OEF TBI screen.</blockquote><div><p>OIF/OEF TBI screen completed date:&nbsp;\"},{\"type\":\"var\",\"content\":{\"id\":7,\"name\":\"Assessment Completion\",\"displayName\":\"CUSTOM_TODAYS_DATE\",\"typeId\":3,\"measureId\":null,\"measureTypeId\":null,\"measureAnswerId\":null,\"transformations\":[]}},{\"type\":\"text\",\"content\":\"</p><p>When &amp; Where did the TBI occur: <br></p><p>&nbsp;&nbsp; \"},{\"type\":\"var\",\"content\":{\"id\":3460,\"name\":\"TBI_consult_when\",\"displayName\":\"What year did it occur?\",\"typeId\":1,\"measureId\":445,\"measureTypeId\":1,\"measureAnswerId\":null,\"transformations\":[]}},{\"type\":\"text\",\"content\":\", \"},{\"type\":\"var\",\"content\":{\"id\":3450,\"name\":\"TBI_consult_where\",\"displayName\":\"Where were you deployed when the head injury occurred?\",\"typeId\":1,\"measureId\":444,\"measureTypeId\":1,\"measureAnswerId\":null,\"transformations\":[]}},{\"type\":\"text\",\"content\":\" <br></p><p>How did the TBI occur:</p><p>&nbsp;&nbsp; \"},{\"type\":\"var\",\"content\":{\"id\":3470,\"name\":\"TBI_consult_how\",\"displayName\":\"How did the head injury occur?\",\"typeId\":1,\"measureId\":446,\"measureTypeId\":1,\"measureAnswerId\":null,\"transformations\":[]}},{\"type\":\"text\",\"content\":\"</p><p>GOALS for TBI clinic evaluation:<br></p><blockquote style=\\\"margin: 0 0 0 40px; border: none; padding: 0px;\\\"><p>Please evaluate and refer on for additional services as necessary</p></blockquote><p><br></p><p><br></p></div></div>\"}],\"type\":\"text\"}]','2015-09-16 17:42:36',NULL);

--INSERT INTO `template` (`template_id`,`template_type_id`,`name`,`description`,`template_file`,`date_created`,`is_graphical`,`json_file`,`date_modified`,`graph_params`) VALUES (3710,20,'TBI Consult Reason',NULL,'<#include \"clinicalnotefunctions\">\n<#-- generated file. Do not change -->\n${MODULE_START}\n<#-- NAME:full text          -->\n<#-- SECTION:1 -->\n<#-- SUMMARY:Veteran not previously seen by the San Diego VA TBI clinic OIF/OEF VeteranOIF/OEF Veteran with: OIF/OEF deployment-related, suspected TBI.Persistent symptoms.Positive OIF/OEF TBI screen.OIF/OEF TBI screen completed date:   -->\n<p></p>Veteran not previously seen by the San Diego VA TBI clinic${NBSP}<div><div>OIF/OEF Veteran</div></div><div><p><span style=\"font-family: inherit; line-height: 1.42857;\">OIF/OEF Veteran with:</span><br></p><p></p><blockquote style=\"margin: 0 0 0 40px; border: none; padding: 0px;\"><p></p></blockquote><p></p><blockquote style=\"margin: 0 0 0 40px; border: none; padding: 0px;\">OIF/OEF deployment-related, suspected TBI.</blockquote><p></p><blockquote style=\"margin: 0 0 0 40px; border: none; padding: 0px;\"><p></p></blockquote><p></p><blockquote style=\"margin: 0 0 0 40px; border: none; padding: 0px;\">Persistent symptoms.</blockquote><p></p><blockquote style=\"margin: 0 0 0 40px; border: none; padding: 0px;\">Positive OIF/OEF TBI screen.</blockquote><div><p>OIF/OEF TBI screen completed date:${NBSP}${getCustomValue(var4)}</p><p>When &amp; Where did the TBI occur:${NBSP}<br></p></div></div><#-- NAME:tbi consult when-->\n<#-- SECTION:2 -->\n<#-- SUMMARY:What year did it occur? nanswered  -->\n<#if (wasntAnswered(var3460)) >\n<#-- NAME:unknown year -->\n<#-- SECTION:2.1 -->\n<#-- SUMMARY:Year not provided to determine when  -->\n<p>Year not provided to determine when</p>\n<#else>\n<#-- NAME: (TBI_consult_when)   -->\n<#-- SECTION:2.2.1 -->\n<#-- SUMMARY: (TBI_consult_when)    -->\n<p>${getResponse(var3460)}<br></p>\n</#if>\n<#-- NAME:How did the TBI occur:  -->\n<#-- SECTION:3 -->\n<#-- SUMMARY:How did the TBI occur:   -->\n<p>How did the TBI occur:</p><p><br></p><#-- NAME:if_How did the head injury occur?_nanswered_-->\n<#-- SECTION:4 -->\n<#-- SUMMARY:How did the head injury occur? nanswered  -->\n<#if (wasntAnswered(var3470)) >\n<#-- NAME:Not Provided -->\n<#-- SECTION:4.1 -->\n<#-- SUMMARY:Not Provided  -->\n<blockquote style=\"margin: 0 0 0 40px; border: none; padding: 0px;\"><p>Not Provided</p></blockquote>\n<#else>\n<#-- NAME: (TBI_consult_how)    -->\n<#-- SECTION:4.2.1 -->\n<#-- SUMMARY: (TBI_consult_how)     -->\n<p>${getResponse(var3470)}<br></p><p><br></p>\n</#if>\n<#-- NAME:GOALS for TBI clinic evaluatio-->\n<#-- SECTION:5 -->\n<#-- SUMMARY:GOALS for TBI clinic evaluation: Please evaluate and refer on for additional services as necessary   -->\n<p>GOALS for TBI clinic evaluation:<br></p><blockquote style=\"margin: 0 0 0 40px; border: none; padding: 0px;\"><p>Please evaluate and refer on for additional services as necessary</p><p><br></p></blockquote>\n${MODULE_END}\n','2015-09-13 19:58:38',0,'[{\"summary\":\"Veteran not previously seen by the San Diego VA TBI clinic OIF/OEF VeteranOIF/OEF Veteran with: OIF/OEF deployment-related, suspected TBI.Persistent symptoms.Positive OIF/OEF TBI screen.OIF/OEF TBI screen completed date:  \",\"name\":\"full text          \",\"section\":\"1\",\"children\":[],\"contents\":[{\"type\":\"text\",\"content\":\"<p></p>Veteran not previously seen by the San Diego VA TBI clinic&nbsp;<div><div>OIF/OEF Veteran</div></div><div><p><span style=\\\"font-family: inherit; line-height: 1.42857;\\\">OIF/OEF Veteran with:</span><br></p><p></p><blockquote style=\\\"margin: 0 0 0 40px; border: none; padding: 0px;\\\"><p></p></blockquote><p></p><blockquote style=\\\"margin: 0 0 0 40px; border: none; padding: 0px;\\\">OIF/OEF deployment-related, suspected TBI.</blockquote><p></p><blockquote style=\\\"margin: 0 0 0 40px; border: none; padding: 0px;\\\"><p></p></blockquote><p></p><blockquote style=\\\"margin: 0 0 0 40px; border: none; padding: 0px;\\\">Persistent symptoms.</blockquote><p></p><blockquote style=\\\"margin: 0 0 0 40px; border: none; padding: 0px;\\\">Positive OIF/OEF TBI screen.</blockquote><div><p>OIF/OEF TBI screen completed date:&nbsp;\"},{\"type\":\"var\",\"content\":{\"id\":4,\"name\":\"Today\'s date\",\"displayName\":\"CUSTOM_TODAYS_DATE\",\"typeId\":3,\"measureId\":null,\"measureTypeId\":null,\"measureAnswerId\":null,\"transformations\":[]}},{\"type\":\"text\",\"content\":\"</p><p>When &amp; Where did the TBI occur:&nbsp;<br></p></div></div>\"}],\"type\":\"text\"},{\"summary\":\"What year did it occur? nanswered \",\"name\":\"tbi consult when\",\"section\":\"2\",\"children\":[{\"type\":\"text\",\"summary\":\"Year not provided to determine when \",\"name\":\"unknown year \",\"section\":\"2.1\",\"children\":[],\"contents\":[{\"type\":\"text\",\"content\":\"<p>Year not provided to determine when</p>\"}],\"type\":\"text\"},{\"type\":\"else\",\"section\":\"2.2\",\"children\":[{\"type\":\"text\",\"summary\":\" (TBI_consult_when)   \",\"name\":\" (TBI_consult_when)   \",\"section\":\"2.2.1\",\"children\":[],\"contents\":[{\"type\":\"text\",\"content\":\"<p>\"},{\"type\":\"var\",\"content\":{\"id\":3460,\"name\":\"TBI_consult_when\",\"displayName\":\"What year did it occur?\",\"typeId\":1,\"measureId\":445,\"measureTypeId\":1,\"measureAnswerId\":null,\"transformations\":[]}},{\"type\":\"text\",\"content\":\"<br></p>\"}],\"type\":\"text\"}],\"type\":\"else\"}],\"operator\":\"nanswered\",\"left\":{\"type\":\"var\",\"content\":{\"id\":3460,\"name\":\"TBI_consult_when\",\"displayName\":\"What year did it occur?\",\"typeId\":1,\"measureId\":445,\"measureTypeId\":1,\"measureAnswerId\":null,\"transformations\":[]}},\"right\":{\"type\":\"text\",\"content\":\"\"},\"conditions\":[],\"type\":\"if\"},{\"summary\":\"How did the TBI occur:  \",\"name\":\"How did the TBI occur:  \",\"section\":\"3\",\"children\":[],\"contents\":[{\"type\":\"text\",\"content\":\"<p>How did the TBI occur:</p><p><br></p>\"}],\"type\":\"text\"},{\"summary\":\"How did the head injury occur? nanswered \",\"name\":\"if_How did the head injury occur?_nanswered_\",\"section\":\"4\",\"children\":[{\"type\":\"text\",\"summary\":\"Not Provided \",\"name\":\"Not Provided \",\"section\":\"4.1\",\"children\":[],\"contents\":[{\"type\":\"text\",\"content\":\"<blockquote style=\\\"margin: 0 0 0 40px; border: none; padding: 0px;\\\"><p>Not Provided</p></blockquote>\"}],\"type\":\"text\"},{\"type\":\"else\",\"section\":\"4.2\",\"children\":[{\"type\":\"text\",\"summary\":\" (TBI_consult_how)    \",\"name\":\" (TBI_consult_how)    \",\"section\":\"4.2.1\",\"children\":[],\"contents\":[{\"type\":\"text\",\"content\":\"<p>\"},{\"type\":\"var\",\"content\":{\"id\":3470,\"name\":\"TBI_consult_how\",\"displayName\":\"How did the head injury occur?\",\"typeId\":1,\"measureId\":446,\"measureTypeId\":1,\"measureAnswerId\":null,\"transformations\":[]}},{\"type\":\"text\",\"content\":\"<br></p><p><br></p>\"}],\"type\":\"text\"}],\"type\":\"else\"}],\"operator\":\"nanswered\",\"left\":{\"type\":\"var\",\"content\":{\"id\":3470,\"name\":\"TBI_consult_how\",\"displayName\":\"How did the head injury occur?\",\"typeId\":1,\"measureId\":446,\"measureTypeId\":1,\"measureAnswerId\":null,\"transformations\":[]}},\"right\":{\"type\":\"text\",\"content\":\"\"},\"conditions\":[],\"type\":\"if\"},{\"summary\":\"GOALS for TBI clinic evaluation: Please evaluate and refer on for additional services as necessary  \",\"name\":\"GOALS for TBI clinic evaluatio\",\"section\":\"5\",\"children\":[],\"contents\":[{\"type\":\"text\",\"content\":\"<p>GOALS for TBI clinic evaluation:<br></p><blockquote style=\\\"margin: 0 0 0 40px; border: none; padding: 0px;\\\"><p>Please evaluate and refer on for additional services as necessary</p><p><br></p></blockquote>\"}],\"type\":\"text\"}]','2015-09-13 20:26:14',NULL);

INSERT INTO `survey_template`(`survey_id`,`template_id`) VALUES (29, 3710);

INSERT INTO `variable_template` (`assessment_variable_id`,`template_id`,`override_display_value`,`date_created`) VALUES (7,3710,NULL,'2015-09-16 17:38:27');
INSERT INTO `variable_template` (`assessment_variable_id`,`template_id`,`override_display_value`,`date_created`) VALUES (3460,3710,NULL,'2015-09-16 17:38:27');
INSERT INTO `variable_template` (`assessment_variable_id`,`template_id`,`override_display_value`,`date_created`) VALUES (3461,3710,NULL,'2015-09-16 17:38:27');
INSERT INTO `variable_template` (`assessment_variable_id`,`template_id`,`override_display_value`,`date_created`) VALUES (3450,3710,NULL,'2015-09-16 17:38:27');
INSERT INTO `variable_template` (`assessment_variable_id`,`template_id`,`override_display_value`,`date_created`) VALUES (3451,3710,NULL,'2015-09-16 17:38:27');
INSERT INTO `variable_template` (`assessment_variable_id`,`template_id`,`override_display_value`,`date_created`) VALUES (3470,3710,NULL,'2015-09-16 17:38:27');
INSERT INTO `variable_template` (`assessment_variable_id`,`template_id`,`override_display_value`,`date_created`) VALUES (3471,3710,NULL,'2015-09-16 17:38:27');
