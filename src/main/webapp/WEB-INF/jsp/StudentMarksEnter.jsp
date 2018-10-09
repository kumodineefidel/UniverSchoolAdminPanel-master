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

	var studentId = '${studentToExamId}';
	$("#studentToExamId").val(studentId);
}
</script>
<script type="text/javascript">
function minmax(value, min, max) 
{
    if(parseInt(value) < min || isNaN(value)) {
    	alert("Not less than 0");
    	return 0; 
    }
    else if(parseInt(value) > max) {
    	alert("Not greater than"+max);
    	return max; 
    }
    else{
    	return value;
    }
}
</script>
</head>
<body onload="getStudentId()">
<form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/Teacher/addedMarksInStudent">
		
		<div class="form-group">
			<input type="hidden" name="studentToExamId" id="studentToExamId" value="">
			<c:if test= "${not empty studentToExam.subject1}">    
			<label for="subject1" >Subject
			<input type="text" value="${studentToExam.subject1}"  name="subject1" id="subject1" readonly>
			<label for="subject1min" >Min   
			<input type="text" value="${studentToExam.subject1min}" name="subject1min" id="subject1min" readonly>
			<label for="subject1max" >Max
			<input type="text" value="${studentToExam.subject1max}" name="subject1max" id="subject1max" readonly>
			<label for="subject1obtained" >Obtained
			<input type="text" value="${studentToExam.subject1obtained}" name="subject1obtained" id="subject1obtained" onkeyup="this.value = minmax(this.value, 0, ${studentToExam.subject1max})">
			</c:if>
		</div>
		<div class="form-group">
			<c:if test= "${not empty studentToExam.subject2}">    
			<label for="subject2" >Subject
			<input type="text" value="${studentToExam.subject2}" name="subject2" id="subject2" readonly>
			<label for="subject2min" >Min   
			<input type="text" value="${studentToExam.subject2min}" name="subject2min" id="subject2min" readonly>
			<label for="subject2max" >Max
			<input type="text" value="${studentToExam.subject2max}" name="subject2max" id="subject2max" readonly>
			<label for="subject2obtained" >Obtained
			<input type="text" value="${studentToExam.subject2obtained}" name="subject2obtained" id="subject2obtained" onkeyup="this.value = minmax(this.value, 0, ${studentToExam.subject2max})">
			</c:if>
		</div>
		<div class="form-group">
			<c:if test= "${not empty studentToExam.subject3}"> 
			<label for="subject3" >Subject   
			<input type="text" value="${studentToExam.subject3}" name="subject3" id="subject3" readonly>
			<label for="subject3min" >Min   
			<input type="text" value="${studentToExam.subject3min}" name="subject3min" id="subject3min" readonly>
			<label for="subject3max" >Max
			<input type="text" value="${studentToExam.subject3max}" name="subject3max" id="subject3max" readonly>
			<label for="subject3obtained" >Obtained
			<input type="text" value="${studentToExam.subject3obtained}" name="subject3obtained" id="subject3obtained" onkeyup="this.value = minmax(this.value, 0, ${studentToExam.subject3max})">
			</c:if>
		</div>
		<div class="form-group">
			<c:if test= "${not empty studentToExam.subject4}">  
			<label for="subject4" >Subject  
			<input type="text" value="${studentToExam.subject4}" name="subject4" id="subject4" readonly>
			<label for="subject4min" >Min   
			<input type="text" value="${studentToExam.subject4min}" name="subject4min" id="subject4min" readonly>
			<label for="subject4max" >Max
			<input type="text" value="${studentToExam.subject4max}" name="subject4max" id="subject4max" readonly>
			<label for="subject4obtained" >Obtained
			<input type="text" value="${studentToExam.subject4obtained}" name="subject4obtained" id="subject4obtained" onkeyup="this.value = minmax(this.value, 0, ${studentToExam.subject4max})">
			</c:if>
		</div>
		<div class="form-group">
			<c:if test= "${not empty studentToExam.subject5}">  
			<label for="subject5" >Subject  
			<input type="text" value="${studentToExam.subject5}" name="subject5" id="subject5" readonly>
			<label for="subject5min" >Min   
			<input type="text" value="${studentToExam.subject5min}" name="subject5min" id="subject5min" readonly>
			<label for="subject5max" >Max
			<input type="text" value="${studentToExam.subject5max}" name="subject5max" id="subject5max" readonly>
			<label for="subject5obtained" >Obtained
			<input type="text" value="${studentToExam.subject5obtained}" name="subject5obtained" id="subject5obtained" onkeyup="this.value = minmax(this.value, 0, ${studentToExam.subject5max})">
			</c:if>
		</div>
		<div class="form-group">
			<c:if test= "${not empty studentToExam.subject6}">  
			<label for="subject6" >Subject  
			<input type="text" value="${studentToExam.subject6}" name="subject6" id="subject6" readonly>
			<label for="subject6min" >Min   
			<input type="text" value="${studentToExam.subject6min}" name="subject6min" id="subject6min" readonly>
			<label for="subject6max" >Max
			<input type="text" value="${studentToExam.subject6max}" name="subject6max" id="subject6max" readonly>
			<label for="subject6obtained" >Obtained
			<input type="text" value="${studentToExam.subject6obtained}" name="subject6obtained" id="subject6obtained" onkeyup="this.value = minmax(this.value, 0, ${studentToExam.subject6max})">
			</c:if>
		</div>
		<div class="form-group">
			<c:if test= "${not empty studentToExam.subject7}">  
			<label for="subject7" >Subject  
			<input type="text" value="${studentToExam.subject7}" name="subject7" id="subject7" readonly>
			<label for="subject7min" >Min   
			<input type="text" value="${studentToExam.subject1min}" name="subject7min" id="subject7min" readonly>
			<label for="subject7max" >Max
			<input type="text" value="${studentToExam.subject1max}" name="subject7max" id="subject7max" readonly>
			<label for="subject7obtained" >Obtained
			<input type="text" value="${studentToExam.subject1obtained}" name="subject7obtained" id="subject7obtained" onkeyup="this.value = minmax(this.value, 0, ${studentToExam.subject7max})">
			</c:if>
		</div>
		<div class="form-group">
			<c:if test= "${not empty studentToExam.subject8}"> 
			<label for="subject8" >Subject   
			<input type="text" value="${studentToExam.subject8}" name="subject8" id="subject8" readonly>
			<label for="subject8min" >Min   
			<input type="text" value="${studentToExam.subject8min}" name="subject8min" id="subject8min" readonly>
			<label for="subject8max" >Max
			<input type="text" value="${studentToExam.subject8max}" name="subject8max" id="subject8max" readonly>
			<label for="subject8obtained" >Obtained
			<input type="text" value="${studentToExam.subject8obtained}" name="subject8obtained" id="subject8obtained" onkeyup="this.value = minmax(this.value, 0, ${studentToExam.subject8max})">
			</c:if>
		</div>
		<div class="form-group">
			<c:if test = "${not empty studentToExam.subject9}">
			<label for="subject9" >Subject    
			<input type="text" value="${studentToExam.subject9}" name="subject9" id="subject9" readonly>
			<label for="subject9min" >Min   
			<input type="text" value="${studentToExam.subject9min}" name="subject9min" id="subject9min" readonly>
			<label for="subject9max" >Max
			<input type="text" value="${studentToExam.subject9max}" name="subject9max" id="subject9max" readonly>
			<label for="subject9obtained" >Obtained
			<input type="text" value="${studentToExam.subject9obtained}" name="subject9obtained" id="subject9obtained" onkeyup="this.value = minmax(this.value, 0, ${studentToExam.subject9max})">
			</c:if>
		</div>
		<div class="form-group">
			<c:if test = "${not empty studentToExam.subject10}">   
			<label for="subject10" >Subject 
			<input type="text" value="${studentToExam.subject10}" name="subject10" id="subject10" readonly>
			<label for="subject10min" >Min   
			<input type="text" value="${studentToExam.subject10min}" name="subject10min" id="subject10min" readonly>
			<label for="subject10max" >Max
			<input type="text" value="${studentToExam.subject10max}" name="subject10max" id="subject10max" readonly>
			<label for="subject10obtained" >Obtained
			<input type="text" value="${studentToExam.subject10obtained}" name="subject10obtained" id="subject10obtained" onkeyup="this.value = minmax(this.value, 0, ${studentToExam.subject10max})">
			</c:if>
		</div>
	    <input type="submit" class="btn btn-sky btn-sm"  value="Save" >
	</form>
</body>
</html>