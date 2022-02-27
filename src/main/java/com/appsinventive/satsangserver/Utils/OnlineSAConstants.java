package com.appsinventive.satsangserver.Utils;
import java.util.HashMap;

import org.json.JSONObject;

public interface OnlineSAConstants {
	String RETURN_CODE = "returnCode";
	String USER_JSON = "userJSON";
	String USER_JSON_OBJECT = "userJSONObject";
	String RITWIK_JSON_OBJECT = "ritwikJSONObject";
	String DPST_SMRY_OBJECT = "depositSmryJSONObject";
	String ISHT_REF_OBJECT = "ishtRefValObject";
	String TERM_REF_OBJECT = "termValObject";
	String DPST_SMRY_BAL = "depositSmryBal";
	String INC_BAL_WRAPPER = "incomeBalWrapper";
	String EXP_BAL_WRAPPER = "expenseBalWrapper";
	String RITVIK_JSON_OBJECT = "ritvikJSONObject";
	String USER_NAME = "userName";
	String ISHT_TRAN_OBJECT = "ishtTranObject";
	String ARGH_TRAN_OBJECT = "arghTranObject";
	String RETURN_ERROR_MSG_CODE = "errMsgCode";
	String RETURN_MESSAGE = "returnMessage";
	String ERROR_FLAG = "error";
	String SUCCESS_FLAG = "success";
	String ROOT_COLLECTION= "Root";
	String ISHT_COLLECTION= "Isht";
	String ARGHYA_ISHT_COLLECTION= "ArghIsht";
	String ISHT_REF_VAL= "IshtRefVal";
	String RITVIK_COLLECTION= "Ritvik";
	String DATE_TIME_FORMAT_MONGO = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	String DATE_TIME_FORMAT_MONGO1="E MMM dd HH:mm:ss Z yyyy";
	String DATE_FORMAT_MONGO = "MM/dd/yyyy";
	String DATE_FORMAT_MONGO1 = "MM-dd-yyyy";
	String APPLICATION_FLOW = "applicationFlow";
	String USER_TYPE= "userType";
	String ADMIN_USER = "adminUser";
	String PORTAL_USER = "portalUser";
	String USER_ROLE_SUPER_USER = "superUserRole";
	String USER_ROLE_ADMIN_USER = "adminUserRole";
	String USER_ROLE_SPR_USER = "sprUserRole";
	String YES="Y";
	String NO="N";
	String ADMIN_FLOW= "adminFlow";
	String USER_FLOW= "userFlow";
	String CONFIRMATION_MESSAGE= "Member added successfully. Please click on the Add Primary user link to add new Member";
	String MODIFY_FAMILY_CONFIRMATION_MESSAGE= "Family Member modified successfully.";
	String ADD_FAMILY_CONFIRMATION_MESSAGE= "Family Member added successfully.";

	String APPROVER_1="gs.gsgiri@gmail.com";
	String APPROVER_2="satsangbayareausa@gmail.com";
	String APPROVER_3="gsgiri143@yahoo.com";
	String INC_CODE_SEQ = "INCCODE";
	String INC_SUB_CODE_SEQ = "INCSUBCODE";
	String INC_SUB_CAT_CODE_SEQ = "INCSUBCATCODE";
	
	String INCOME_CODE_SEQ_NAME = "IncomeCode";
	String INCOME_SUB_CODE_SEQ_NAME = "IncomeSubCode";
	String INCOME_SUB_CAT_CODE_SEQ_NAME = "IncomeSubCatCode";
	
	String EXPN_CODE_SEQ = "EXPNCODE";
	String EXPN_SUB_CODE_SEQ = "EXPNSUBCODE";
	String EXPN_CODE_SEQ_NAME = "ExpenseCode";
	String EXPN_SUB_CODE_SEQ_NAME = "ExpenseSubCode";
	String EXPN_SUB_CAT_CODE_SEQ_NAME = "ExpenseSubCatCode";
	
	//Email creds
	final String EMAIL_ID="satsangamericatest@gmail.com";
    final String CREDENTIALS="AmericaSatsang123$";	
    final String SENDER_EMAIL_ID2="Satsang America Test <satsangamericatest@gmail.com>";
    final String SENDER_EMAIL_ID1="Satsang America Test <satsangamericatest@gmail.com>";
    final String IMAGE_URL="https://secure.satsangamerica.org/images/";
    
    final String SQL_DB_LOCAL = "jdbc:mysql://127.0.0.1:3306/istavrity";
	final String SQL_DB_LOCAL_USER = "root";
	final String SQL_DB_LOCAL_PASS = "!stavrity$";
	
	final String ISHT_PROP="ishtProp";
	final String COMM_PROP="commProp";
	final String TERM_PROP="termProp";
	
	public static final HashMap<String, JSONObject> ritvikHashMapCache = new HashMap<String, JSONObject>();
	final String TECH_SUPPORT="techsupport@satsangamerica.org";
	//String TECH_SUPPORT="plukhi17@gmail.com";
	//String TECH_SUPPORT="gs.gsgiri@gmail.com";
	final String DEF_MEMO_CODE = "SATSANG CENTER";
	final String MAINTENANCE_CODE="SATSANG CENTER MAINTENANCE";
	final String UTSAV_CODE_2020="ANNUAL UTSAV 2020";
	final String COVID19_CODE="COVID-19 DONATIONS";
	final String BHOG_CODE="SRI SRI THAKUR BHOG";
	final String RENOVATION_CODE="SATSANG CENTER RENOVATION";
	//Copy from NoSQLBooster for MongoDB free edition. This message does not appear if you are using a registered version.
	 
	final String MailHost ="mail.host";
	final String MailHostValue="imap.googlemail.com";
	final String MailPort= "mail.port";
	final String MailPortValue="993";
	final String MailProtocol="mail.transport.protocol";
	final String MailProtocalValue="imaps";

	
	
}
