<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>
<body>
<form action="http://localhost:8080/uploadfile" method="post" enctype="multipart/form-data">
  <p><input type="text" name="text" value="upload file">
  <p><input type="file" name="file">

  <p><button type="submit">Submit</button>
</form>
</body>
</html>