<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script>
function getStudentId(){

	var studentId = '${studentId}';
	$("#studentId").val(studentId);
}
</script>
</head>
<body onload="getStudentId()">

	<%-- <form:form id="frm" class="form-horizontal" method="POST" name="frm"
		action="${pageContext.request.contextPath}/Teacher/examforstudent"
		commandName="examObj">
		<div class="form-group">
			<form:label path="examName" class="col-sm-3 control-label">&#42; Exam Name</form:label>
			<div class="col-sm-8">
				<form:select path="examName" id="examName"
					class="form-control">
					<form:option value="">Select</form:option>
					<c:forEach var="exam" items="${examList}">
						<form:option value="${exam.examId}">${exam.examName}</form:option>
					</c:forEach>
				</form:select>
			</div>
		</div>

	</form:form> --%>

	<form id="frm" class="form-horizontal" method="POST" name="frm"
		action="${pageContext.request.contextPath}/Teacher/examforstudent"
		>
		<input type="hidden" name="studentId" id="studentId" value="">
		<div class="form-group">
			<label for="examName" class="col-sm-8">&#42; Exam Name</label>
			<div class="col-sm-8">
				<select name="examName" id="examName"
					class="form-control">
					<option value="">Select</option>
					<c:forEach var="exam" items="${examList}">
						<option value="${exam.examId}">${exam.examName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
	<input type="submit" class="btn btn-sky btn-sm"  value="Save" >
	</form>


</body>
</html>