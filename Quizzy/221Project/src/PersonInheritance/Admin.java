package PersonInheritance;
import java.sql.Date;
import java.util.HashMap;

import Interface.AuditLog;

public class Admin extends Person implements AuditLog {

	private static final int ADMIN_ID = 1;
	private static final String ADMIN_PASS = "1";
	private HashMap<String,Integer> adminActivity = new HashMap<>();
	
	public Admin(){}
	

	public Admin(String type, Date dateCreated) {
		this.type = type;
		this.dateCreated = dateCreated;
	}
	

	

	public static int getAdminId() {
		return ADMIN_ID;
	}

	public static String getAdminPass() {
		return ADMIN_PASS;
	}


	public String getInfo() {
		String a = "<html>You entered as an admin now you can do<br/>&#160&#160&#160&#160&#160&#160&#160&#160&#160&#160 Candidate addition, deletion <br/>&#160&#160&#160&#160&#160&#160&#160&#160&#160&#160&#160&#160&#160 search, update ,display <br/>&#160&#160&#160&#160&#160&#160&#160&#160&#160&#160 opearations as the admin</html>";
		return a;
	}
	public String displayActivity() {
		String res = "";
		for(String obj : adminActivity.keySet()) {
			res+= obj + " this action done on candidate with id: "+adminActivity.get(obj) + "\n";
			
		}
		return res;
		
	}
	
	public void setAdminActivity(String activiy, int doneOnCandidate) {
		adminActivity.put(activiy, doneOnCandidate);
		
	}
	//set activity 
}
