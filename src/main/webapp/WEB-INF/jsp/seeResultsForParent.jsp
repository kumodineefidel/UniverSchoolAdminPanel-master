<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
</head>
<body>
<c:set var="count" value="0" scope="page" />
<c:forEach var="ste" items="${StudentToExam}">
	<div class="form-group">
		<h3>${ste.exam.examName} </h3>
			<div class="panel-body">
          		<div class="table-responsive">
          		<table id="example" class="table table-bordered table-striped table-hover">
          			<thead>
          			<tr>
          				<th width="10%">Subject</th>
          				<th width="10%">Min</th>
          				<th width="10%">Max</th>
          				<th width="10%">Obtained</th>
          			</tr>
          			</thead>
          			<tbody>
          				<c:if test = "${not empty ste.subject1}">
          				<tr>
          				<td>${ste.subject1}</td>
          				<td>${ste.subject1min}</td>
          				<td>${ste.subject1max}</td>
          				<td>${ste.subject1obtained}</td>
          				</tr>
          				</c:if>
          				<c:if test = "${not empty ste.subject2}">
          				<tr>
          				<td>${ste.subject2}</td>
          				<td>${ste.subject2min}</td>
          				<td>${ste.subject2max}</td>
          				<td>${ste.subject2obtained}</td>
          				</tr>
          				</c:if>
          				<c:if test = "${not empty ste.subject3}">
          				<tr>
          				<td>${ste.subject3}</td>
          				<td>${ste.subject3min}</td>
          				<td>${ste.subject3max}</td>
          				<td>${ste.subject3obtained}</td>
          				</tr>
          				</c:if>
          				<c:if test = "${not empty ste.subject4}">
          				<tr>
          				<td>${ste.subject4}</td>
          				<td>${ste.subject4min}</td>
          				<td>${ste.subject4max}</td>
          				<td>${ste.subject4obtained}</td>
          				</tr>
          				</c:if>
          				<c:if test = "${not empty ste.subject5}">
          				<tr>
          				<td>${ste.subject5}</td>
          				<td>${ste.subject5min}</td>
          				<td>${ste.subject5max}</td>
          				<td>${ste.subject5obtained}</td>
          				</tr>
          				</c:if>
          				<c:if test = "${not empty ste.subject6}">
          				<tr>
          				<td>${ste.subject6}</td>
          				<td>${ste.subject6min}</td>
          				<td>${ste.subject6max}</td>
          				<td>${ste.subject6obtained}</td>
          				</tr>
          				</c:if>
          				<c:if test = "${not empty ste.subject7}">
          				<tr>
          				<td>${ste.subject7}</td>
          				<td>${ste.subject7min}</td>
          				<td>${ste.subject7max}</td>
          				<td>${ste.subject7obtained}</td>
          				</tr>
          				</c:if>
          				<c:if test = "${not empty ste.subject8}">
          				<tr>
          				<td>${ste.subject8}</td>
          				<td>${ste.subject8min}</td>
          				<td>${ste.subject8max}</td>
          				<td>${ste.subject8obtained}</td>
          				</tr>
          				</c:if>
          				<c:if test = "${not empty ste.subject9}">
          				<tr>
          				<td>${ste.subject9}</td>
          				<td>${ste.subject9min}</td>
          				<td>${ste.subject9max}</td>
          				<td>${ste.subject9obtained}</td>
          				</tr>
          				</c:if>
          				<c:if test = "${not empty ste.subject10}">
          				<tr>
          				<td>${ste.subject10}</td>
          				<td>${ste.subject10min}</td>
          				<td>${ste.subject10max}</td>
          				<td>${ste.subject10obtained}</td>
          				</tr>
          				</c:if>
          				<tr>
          				<td><b>Total Marks</b></td>
          				<td><b>${minTotal[count]}</b></td>
          				<td><b>${maxTotal[count]}</b></td>
          				<td><b>${obtainedMarks[count]}</b></td>
          				</tr>
          				
          				<tr>
          				<td><b>Total Percentage</b></td>
          				<td><b>Out Of</b></td>
          				<td><b>${maxTotal[count]}</b></td>
          				<td><b>${(obtainedMarks[count]*100)/maxTotal[count]}</b></td>
          				</tr>
         		    </tbody>
         		    <c:set var="count" value="${count + 1}" scope="page"/>
          		</table>
          		</div>
			</div>
	</div>
</c:forEach>
</body>
</html>