package com.dylanc.db.md.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Addbatch {

	public static final String url = "jdbc:mysql://127.0.0.1/test";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "chen";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Addbatch ab = new Addbatch();
		
		Connection conn = null;
		Class.forName(name);
        conn = DriverManager.getConnection(url, user, password);//获取连接  
        try {
        	ab.insertUUID(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(conn != null){
				conn.close();
			}
		}
	}
	
	public void insertUUID(Connection conn) throws SQLException{
		
	    PreparedStatement pst = null;
	    
		String idstr = "'123','213','321', 'ff', 'dd'";
		
		String[] ids = idstr.split(",");
		
		
		String insertSQL = "insert into excel(uuid, name) VALUES (?, ?)";
		try {
            pst = conn.prepareStatement(insertSQL);//准备执行语句  
            
            for (int i = 0; i < ids.length; i++) {
    			pst.setString(1, "'sdfsd'".trim().replace("'", ""));
    			pst.setString(2, ids[i].trim().replace("'", ""));
    			pst.addBatch();
    			if(0 == i % 3){
    				System.out.println("DD");
    				pst.executeBatch();
    			}
            }
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {
			if(pst != null){
				pst.close();
			}
		}
	}
}
