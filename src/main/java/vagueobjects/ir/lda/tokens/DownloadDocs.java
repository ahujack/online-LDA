package vagueobjects.ir.lda.tokens;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.*;

public class DownloadDocs {

	public static void main(String[] args){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://172.16.201.151/rssapp";
		String user = "root";
		String password = "123456";
		try{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,password);
			 if(!conn.isClosed()) 
	             System.out.println("Succeeded connecting to the Database!");
			 Statement statement = conn.createStatement();
			 String sql = "select * from rss_items;";
			 ResultSet rs = statement.executeQuery(sql);
			 while(rs.next()){
			 String savepath = "D://data//raw_corpus/";
			 File fileid = new File(savepath+rs.getString(1));
			 BufferedWriter bf = new BufferedWriter(new FileWriter(fileid));
			 bf.write(rs.getString(13));
			 bf.flush();
			 bf.close();
			 System.out.println(rs.getString(13));
			 }
			 rs.close();
			 conn.close();
		} catch(ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!"); 
            e.printStackTrace();
           }catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
