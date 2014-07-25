package com.netsol.utility;

import java.util.ResourceBundle;

public class UrlConstants {
	
	private static final ResourceBundle appURL = ResourceBundle.getBundle("urls");
	  
	public static final String DASHBOARD_URL = appURL.getString("baseUrl") + appURL.getString("dashboardUrl");
	public static final String TESTS_TO_WATCH = appURL.getString("baseUrl") + appURL.getString("testsToWatch");
	public static final String TRENDS_ORGAN_HEALTH_URL = appURL.getString("baseUrl") + appURL.getString("trendsOrganHealthUrl");
	
	public static final String LOGIN_URL = appURL.getString("baseUrl") + appURL.getString("loginUrl");
	public static final String QUESTION_URL = appURL.getString("baseUrl") + appURL.getString("questionsUrl");
	public static final String ARTICLES_URL = appURL.getString("baseUrl") + appURL.getString("articlesUrl");
	public static final String DEFINITION_URL = appURL.getString("baseUrl") + appURL.getString("definitionUrl");
	public static final String LAB_URL = appURL.getString("baseUrl") + appURL.getString("labUrl");
	public static final String LAB_REPORT_URL = appURL.getString("baseUrl") + appURL.getString("labReportUrl");
	public static final String PDF_URL = appURL.getString("baseUrl") + appURL.getString("pdfreporturl");
	
	public static final String REQUESTED_PASSWORD_URL = appURL.getString("baseUrl") + appURL.getString("requestForPassword");
	public static final String PASSWORD_UPDATE_URL = appURL.getString("baseUrl") + appURL.getString("passwordUpdate");
	public static final String MEDIA_URL1 = appURL.getString("baseUrl") + appURL.getString("mediaUrl1");
	public static final String MEDIA_URL2 = appURL.getString("baseUrl") + appURL.getString("mediaUrl2");
	
	public static final String PATIENT_INFORMATION = appURL.getString("baseUrl") + appURL.getString("patientinfo");
	public static final String SIGNUP_URL_1=appURL.getString("baseUrl") + appURL.getString("signup1_url");
	public static final String MAIL_COUNT= appURL.getString("baseUrl") + appURL.getString("mail_count");
	
	public static final String BASE_URL_FOR_TRENDS = appURL.getString("baseUrlForTrends");
   
}

