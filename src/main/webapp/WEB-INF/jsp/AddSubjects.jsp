<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function getSubjectNo()
{
	var subjectNo = '${subjects}';
	alert(subjectNo);
	var examIDD = '${examIDD}'
	var i;
	var html;
	html = '<form id="formAdd" action="${pageContext.request.contextPath}/Teacher/addSubject" method="post">';
	html += '<div class="form-horizontal">';
	html += '<input type="hidden" name="subjectNo" value="'+subjectNo+'">';
	html += '<input type="hidden" name="examIDD" value="'+examIDD+'">';
	for(i=0;i<subjectNo;i++)
	{
		var Varname = "subjectId"+i;
		var Varmin = "min"+i;
		var Varmax = "max"+i;
		html += '<div class="form-group">';
		html += '<label class="col-sm-3 control-label">* Subject Name :</label>';
		html += '<div class="col-sm-8">';
		html += '<input type="text" name="'+Varname+'" id="'+Varname+'" value= "" class="form-control" >';
		html += '</div>';
		html += '<label class="col-sm-3 control-label">* Min Marks :</label>';
		html += '<div class="col-sm-8">';
		html += '<input type="text" name="'+Varmin+'" id="'+Varmin+'" value= "" class="form-control" >';
		html += '</div>';
		html += '<label class="col-sm-3 control-label">* Max Marks :</label>';
		html += '<div class="col-sm-8">';
		html += '<input type="text" name="'+Varmax+'" id="'+Varmax+'" value= "" class="form-control" >';
		html += '</div>';
		html += '</div>';		
	}
	
	html += '</div>';
	html += '<input type="submit" class="btn btn-sky btn-sm"  value="Save" >';
	html += '</form>';
	$("#CarList").html( html );
		
	
	
}


</script>
</head>
<body onload="getSubjectNo()">

<p id="CarList">
</p>

</body>
</html>