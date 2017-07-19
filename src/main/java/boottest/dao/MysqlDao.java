package main.java.boottest.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlDao {


	public String insertFile( FileUploadVO vo){
		String status = "failure";
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
			
			String fileType = vo.getFileType() ;
			byte[] uploadedFileByteArray = vo.getUploadedFileByteArray();
			long fileSize  = vo.getFileSize();
			String fileName = vo.getFileName();
			
	
			String query = "INSERT INTO Filerepository ('filename','filetype','filesize','filecontent') VALUES (?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fileName);
			pstmt.setString(2, fileType);
			pstmt.setLong(3, fileSize);
			pstmt.setBytes(2, uploadedFileByteArray);
			pstmt.execute();
			status ="success";
		} catch (Exception e) {
			status ="failure";
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try { conn.close(); } catch (SQLException e) {}
			}
		}
		
		return  status;
	}
}

