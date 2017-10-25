<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>上传研报</title>
</head>
<form action="/downloadReports/upload.do" method="post" enctype="multipart/form-data">
    企业名称：<input type="text" name="companyName">
    <input type="file" name="file" />
    <br>
    <input type="submit" value="Submit" /></form>
</body>
</html>
