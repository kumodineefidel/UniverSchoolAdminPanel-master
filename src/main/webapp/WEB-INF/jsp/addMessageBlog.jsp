<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

var blogMessageIdList;

function editMessage(blogId,message,studentClass){
	$("#blogId").val(blogId);
	$("#message").val(message);
	$("#studentClass").val(studentClass);
	$("#edit").modal('show');
}
function deleteAllRow(source){  	
	 blogMessageIdList="";
	
	 checkboxes = document.getElementsByName('myTextEditBox');
	 var flag=false;
	  for(var i=0, n=checkboxes.length;i<n;i++) {
		var id = checkboxes[i].getAttribute('id' );
		var res = checkboxes[i].checked;
		
	    if(res){
	    	
            flag=true;
            blogMessageIdList=blogMessageIdList+id+",";
	    }  
	  }	
	  if(flag){
		  var result = confirm("Are you sure, you want to delete ?");
			 if(result){
				  window.location.href = "${pageContext.request.contextPath}/Teacher/deleteBlogMessageList?blogMessageIdList="+blogMessageIdList;		 
			 } 
	  }
}
</script>
</head>
<body>
 <form:form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/Teacher/addMessageBlog" commandName="messageBlog">

    <input type="hidden" name="action" id="action" value="Add">

	<div class="form-group">
		<form:label path="message" class="col-sm-3 control-label"> &#42;Message </form:label>
		<div class="col-sm-8">
			<form:textarea type="text" path="message" id="msg" value=""
				class="form-control" maxlength="20"
				 />
		</div>
	</div>

	<div class="form-group">
		<form:label path="studentClass" class="col-sm-3 control-label">&#42; Class </form:label>
		<div class="col-sm-8">
			<form:select path="studentClass" id="class" class="form-control" >
				<form:option value="">Select</form:option>

				<form:option value="1A">1A</form:option>
				<form:option value="1B">1B</form:option>
				<form:option value="1B">1C</form:option>
				<form:option value="1B">1D</form:option>
				
			</form:select>
		</div>
	</div>
	
	<button type="submit" class="btn btn-sky btn-sm" >Save</button>
</form:form> 

</br> 
<div class="row">     
 <button type="submit" class="btn btn-brown btn-sm pull-right" onClick="deleteAllRow(this)" ><i class="fa fa-trash-o"></i> Delete</button>                   
        <div class="col-md-12">        
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                   <div class="panel-name">
                        <span class="panel-head">Message List</span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            	<th width="3%" class="text-center no-sort"><input  type="checkbox" ></th>
                              	<th width="20%">Message</th>
                              	<th width="2%">Student Class</th>  
                              	<th width="3%">Date</th>        
                                <th width="1%">Edit</th>    
                            </tr>
                          </thead>
                          <tbody>          
                            <c:forEach var="messageBlog" items="${messageBlogList}">
                            
                              <tr>
                                <td class="text-center no-sort"><input type="checkbox" id="${messageBlog.blogId}"  name="myTextEditBox" value="" /></td>
                                <td>${messageBlog.message}</td>
                                <td>${messageBlog.studentClass}</td>
                                <td>${messageBlog.blogDate}</td>
                    
                     		  <td><button type="submit" class="btn btn-default btn-sm" onClick="editMessage('${messageBlog.blogId}','${messageBlog.message}','${messageBlog.studentClass}');"><i class="fa fa-pencil-square-o"></i> Edit</button></td>
                              </tr>
    						</c:forEach>
                      	</tbody>
                    	</table>
                    </div>
                </div>                                       
                
            </div>
        </div>
    </div>
    
<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
   	<div class="modal-dialog">
        <div class="modal-content">
        <form:form id="editForm" class="form-horizontal" method="post" name="registerForm" action="${pageContext.request.contextPath}/Teacher/addMessageBlog" commandName="messageBlog">
           <input type="hidden" name="action" id="action" value="Add">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title"><center>Edit Driver</center></h4>
          </div>
          <div class="modal-body">   
          	<div class="form-horizontal"> 	
          	    <div class="form-group">
                    <form:hidden path="blogId" id="blogId"/>
                </div>		  
			    <div class="form-group">
                    <form:label path="message" class="col-sm-3 control-label">* Message : </form:label>
                    <div class="col-sm-8">
                    	<form:textarea  path="message" id="message" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('driverName').value)"/>
                   	</div>
                </div>
                <div class="form-group">
                    <form:label path="studentClass" class="col-sm-3 control-label">* Class : </form:label>
                    <div class="col-sm-8">
                    	<form:select path="studentClass" id="studentClass" class="form-control" >
				         <form:option value="">Select</form:option>
           			     <form:option value="1A">1A</form:option>
		             	 <form:option value="1B">1B</form:option>
				         <form:option value="1B">1C</form:option>
				         <form:option value="1B">1D</form:option>				
            			</form:select>
                   	</div>
              	</div>

           	</div>
      	</div>
    	<div class="modal-footer text-center">
            <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
            <button type="submit" class="btn btn-sky btn-sm" >Update</button>
        </div></form:form>
    </div>
  </div>
</div>
    
</body>
</html>