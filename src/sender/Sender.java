package sender;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;

import org.json.JSONObject;
import org.json.JSONTokener;
/**
 * @author madhab452
 */
public class Sender {
	

	
	public static void main(String args[]){
		
		final String con_url = "jdbc:mysql://localhost/sbase";
		final String con_user = "root";
		final String con_password = "root";
		
		final String sms123_username = "madhab452";
		final String sms123_password = "madhab452";
		final String sms123_url = "http://mobile.sms123go.com/http.aspx?";	
		
		String sql = "SELECT r.number, s.message, s.status, u.service_id "
				+ "FROM receiver r LEFT JOIN sender s ON s.id = r.sender_id "
				+ "LEFT JOIN fos_user u ON u.id = s.sender_id "
				+ "LEFT JOIN sms_vendor sv ON u.service_id = sv.id";
		try{
			
			
			Connection con = DriverManager.getConnection( con_url, con_user, con_password );
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()){
					
					String mobile_number = rs.getString("number");
					String country_code = "+977";
					String message = rs.getString("message");

					URL obj = new URL("http://localhost/extlar/public/version/all");
				    
					HttpURLConnection con1 = (HttpURLConnection) obj.openConnection();
				    
					con1.setRequestMethod("GET");
				    
				    int responseCode = con1.getResponseCode();
				    
				    System.out.print(responseCode);
				    
//				    System.out.println("Response Code : " + responseCode );
//					System.out.print(rs.getString("number") + "--");
//					System.out.print(rs.getInt("status") + "--");
//					System.out.print(rs.getInt("service_id")  + "--");
//					System.out.print(rs.getString("message") + "--");
//					System.out.println("");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			
			//send me mail and sms
		
		}
		
		
		displayResult();
	}
	public static void displayResult(){
		try {
			URL obj = new URL("http://localhost/extlar/public/version/all");

			try {
				
				HttpURLConnection request  = (HttpURLConnection) obj.openConnection();
				request.connect();
				
				JSONTokener tokener = new JSONTokener(obj.openStream());
				JSONObject root = new JSONObject(tokener);

				
				int responseCode = request.getResponseCode();
				System.out.println(responseCode);
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	
}