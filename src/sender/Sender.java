package sender;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
/**
 * @author madhab452
 */
public class Sender {
	
	public static void main(String args[]){
		String sql = "SELECT r.number, s.message, s.status, u.service_id "
				+ "FROM receiver r LEFT JOIN sender s ON s.id = r.sender_id "
				+ "LEFT JOIN fos_user u ON u.id = s.sender_id "
				+ "LEFT JOIN sms_vendor sv ON u.service_id = sv.id";
		try{
			String sms123_username = "madhab452";
			String sms123_password = "madhab452";
			String sms123_url = "http://mobile.sms123go.com/http.aspx?";
			
					
			String url = "jdbc:mysql://localhost/sbase";
			String user = "root";
			String password = "root";
			
			Connection con = DriverManager.getConnection( url, user, password );
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()){
					
					String mobile_number = rs.getString("number");
					String country_code = "+977";
					String message = rs.getString("message");
					
//					String res = curl_exec(String curl);
					
					URL url1 = new URL("http://madhab-acharya.com.np");
				    HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
				    System.out.println(con1);
					
//					System.out.print(rs.getString("number") + "--");
//					System.out.print(rs.getInt("status") + "--");
//					System.out.print(rs.getInt("service_id")  + "--");
//					System.out.print(rs.getString("message") + "--");
//					System.out.println("");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}	

	}
	
}