<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

#blogs{

    width: 1330px;
    margin-left: 503px;
    margin-top: 190px;

}
.btn-circle {

  text-align: center;
  padding: 5px 0;
  font-size: 20px;
  line-height: 2.00;
  border-radius: 30px;
  
    width: 91px;
    height: 60px;
  
}

.btn-circle-micro {
  width: 19px;
  height: 19px;
  text-align: center;
  padding: 1px 0;
  font-size: 13px;
  line-height: 0.1;
  border-radius: 30px;
}

.btn-circle-sm {
  width: 35px;
  height: 35px;
  text-align: center;
  padding: 2px 0;
  font-size: 20px;
  line-height: 1.65;
  border-radius: 30px;
}

.btn-circle-lg {
  width: 79px;
  height: 79px;
  text-align: center;
  padding: 13px 0;
  font-size: 30px;
  line-height: 2.00;
  border-radius: 70px;
}
</style>
</head>
<body>
	 
<div id="blogs">

        <a href="${pageContext.request.contextPath}/Teacher/addMessageBlog" data-toggle="modal"  class="btn btn-circle btn-default">Message</span></a>
        <a href="${pageContext.request.contextPath}/Teacher/addFileBlog"   class="btn btn-circle btn-info">File</span></a>
        <a href="#aboutModal" data-toggle="modal"  class="btn btn-circle btn-success">Video</span></a>
 
</div> 
</body>
</html>