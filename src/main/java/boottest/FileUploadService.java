package main.java.boottest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import main.java.boottest.dao.FileUploadVO;
import main.java.boottest.dao.MysqlDao;

@RestController
public class FileUploadService {
	
	@RequestMapping("/uploadfile")
	public String fileUpload(@RequestParam("file") MultipartFile uploadfile)  {
		String status ="failure";
		try{
			if (uploadfile.isEmpty()) {
				return "emptyfile";
			}
			if(uploadfile !=null && uploadfile.getSize()>0){
				String fileType = uploadfile.getContentType();
				byte[] uploadedFileByteArray = uploadfile.getBytes();
				long fileSize =  uploadfile.getSize();
				int random = (int )(Math.random() * 1000 + 1);
				String fileName = "File"+random;
				
				FileUploadVO vo = new FileUploadVO();
				vo.setFileName(fileName);
				vo.setFileSize(fileSize);
				vo.setFileType(fileType);
				vo.setUploadedFileByteArray(uploadedFileByteArray);
				
				MysqlDao dao = new MysqlDao();
				status = dao.insertFile(vo);
			}
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		return status;
	}
	

	@RequestMapping("/")
	public String home() {
	
		return "fileupload";
	}

}
