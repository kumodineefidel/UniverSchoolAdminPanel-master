<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Blog</title>
<script type="text/javascript">
var id;
function blogs(id){
	var ID=id;
	window.location.href="${pageContext.request.contextPath}/Teacher/blogs?classId="+ID;
}
</script>
</head>
<body>
<button id = "1 A" type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal"  onClick="blogs(this.id);" data-backdrop="static"  value = "1 A" data-keyboard="false"><i class="fa fa-plus-circle"></i>  1 A</button>   
</body>
</html>