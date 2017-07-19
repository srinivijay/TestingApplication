package main.java.boottest.dao;

import java.io.Serializable;

public class FileUploadVO implements Serializable{
	
	private String fileType ;
	private byte[] uploadedFileByteArray ;
	private long fileSize ;
	private String fileName ;
	
	
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public byte[] getUploadedFileByteArray() {
		return uploadedFileByteArray;
	}
	public void setUploadedFileByteArray(byte[] uploadedFileByteArray) {
		this.uploadedFileByteArray = uploadedFileByteArray;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


}
