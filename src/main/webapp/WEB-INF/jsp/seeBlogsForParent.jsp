<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<c:forEach var="blog" items="${blogs}">
<label style="margin-bottom: 0px;"><h5>From : ${blog.schoolAdmin.name}</h5></label>
<br>
<label style="margin-bottom: 0px;"><h5>When : ${blog.blogDate}</h5></label>
<br>
<label style="margin-bottom: 0px;"><h5>Message : ${blog.message}</h5></label>
<hr style="margin-bottom: 0px; margin-top: 0px;">
</c:forEach>
</body>
</html>