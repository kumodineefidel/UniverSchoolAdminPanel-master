

 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>
<script type="text/javascript">
function addMarks(id){
	 var id=id;
		window.location.href="${pageContext.request.contextPath}/Teacher/addStudentMarks?studentId="+id;	
}
 
function seeResults(id){
	 var id=id;
		window.location.href="${pageContext.request.contextPath}/Teacher/seeResults?studentId="+id;	
}

function seeGraphs(id){
	 var id=id;
		window.location.href="${pageContext.request.contextPath}/Teacher/seeGraphs?studentId="+id;	
}
$(function() {
    $( "#dateFrom" ).datepicker();
});
$(function() {
    $( "#dateTo" ).datepicker();
});
</script>


                      <c:if test="${edit == 'edit'}">
                    <center><div class="alert alert-info" id="success-alert">
    					<button type="button" class="close" data-dismiss="alert">x</button>
    						<strong>Success! </strong>
   								  Successfully
					</div> </center>                   	
                    </c:if>  
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#AddExam" data-backdrop="static" data-keyboard="false"><i class="fa fa-plus-circle"></i>  Add Exam</button>                    
                    <button type="submit" class="btn btn-brown btn-sm pull-right" onClick="showBtn()" ><i class="fa fa-trash-o"></i> Delete</button>
                   
  

<div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                   <div class="panel-name">
                        <span class="panel-head">Students List</span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            	<th width="3%" class="text-center no-sort"><input type="checkbox" onClick="deleteAllRow(this)"></th>
                              	<th width="10%">Name</th>
                              	<th width="10%">City</th>
                                <th width="10%">Action</th>       
                                <th width="10%">Action</th>   
                                <th width="10%">Action</th>              
                            </tr>
                          </thead>
                          <tbody>          
                            <c:forEach var="schoolAdmin" items="${schoolAdminList}">
                            
                              <tr>
                                <td class="text-center no-sort"><input type="checkbox" id="${schoolAdmin.id}"  name="myTextEditBox" value="" onClick="displayNote(event)"/></td>
                                <td>${schoolAdmin.name}</td>
                                <td>${schoolAdmin.city}</td>
                    
                     		  <td><button type="submit" class="btn btn-default btn-sm" onClick="addMarks('${schoolAdmin.id}');"><i class="fa fa-pencil-square-o"></i> Add Result</button></td>
                              <td><button type="submit" class="btn btn-default btn-sm" onClick="seeResults('${schoolAdmin.id}');"><i class="fa fa-pencil-square-o"></i> See Result</button></td>
                              <td><button type="submit" class="btn btn-default btn-sm" onClick="seeGraphs('${schoolAdmin.id}');"><i class="fa fa-pencil-square-o"></i> See Graph</button></td>
                              </tr>
    						</c:forEach>
                      	</tbody>
                    	</table>
                    </div>
                </div>                                       
                
            </div>
        </div>
    </div>
    
<div class="modal fade" id="addMarksForm" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
   	<div class="modal-dialog">
		<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">Add Exam</h4>
			  </div>
              <form id="formAdd" action="${pageContext.request.contextPath}/Teacher/addMarks" method="post">
			  <div class="modal-body">              	
        		<div class="form-horizontal">
        		
				    <div class="form-group">
                        <label class="col-sm-3 control-label">* Student Id :</label>
                        <div class="col-sm-8">
                            <input type="text" name="studentId" id="studentId" value= "" class="form-control" readOnly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">* Exam Name :</label>
                        <div class="col-sm-8">
                            <input type="text" name="ExamName" id="ExamName" value= "" class="form-control" >
                        </div>
                    </div>
				
                    <div class="form-group">
                        <label class="col-sm-3 control-label">* Date:</label>
                        <div class="col-sm-8">
                            <input type="text" name="Date" id="Date" class="form-control" maxlength="20">
                        </div>
                    </div>
				
                    <div class="form-group">
                        <label class="col-sm-3 control-label">* Subject :</label>
                        <div class="col-sm-8">
                            <input type="text"  name="Subject" id="Subject" class="form-control" maxlength="10">
                        </div>
                    </div>
				
                    <div class="form-group">
                        <label class="col-sm-3 control-label">* MinMarks :</label>
                        <div class="col-sm-8">
                            <input type="text" step="0.01" name="MinMarks" id="MinMarks" class="form-control" maxlength="10">
                        </div>
                    </div>
                   <div class="form-group">
                        <label class="col-sm-3 control-label">* MaxMarks :</label>
                        <div class="col-sm-8">
                            <input type="text" step="0.01" name="MaxMarks" id="MaxMarks" class="form-control" maxlength="10">
                        </div>
                    </div>
              	</div>
            </div>
             <div class="modal-footer text-center">
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
                <input type="submit" class="btn btn-sky btn-sm"  value="Save">
            </div>
           </form>            
     	</div>
   	</div>
</div>

<div class="modal fade" id="AddExam" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
   	<div class="modal-dialog">
		<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">Add Bus Stop</h4>
			  </div>
              <form id="formAdd" action="${pageContext.request.contextPath}/Teacher/addExam" method="post">
			  <div class="modal-body">              	
        		<div class="form-horizontal">
        		
				    <div class="form-group">
                        <label class="col-sm-3 control-label">* Exam Id :</label>
                        <div class="col-sm-8">
                            <input type="text" name="examId" id="examId" value= "" class="form-control" readOnly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">* Exam Name :</label>
                        <div class="col-sm-8">
                            <input type="text" name="examName" id="examName" value= "" class="form-control" >
                        </div>
                    </div>
				
                    <div class="form-group">
                        <label class="col-sm-3 control-label">* DateFrom:</label>
                        <div class="col-sm-8">
                            <input type="text" name="dateFrom" id="dateFrom" class="form-control" maxlength="20">
                        </div>
                    </div>
				
					 <div class="form-group">
                        <label class="col-sm-3 control-label">* DateTo:</label>
                        <div class="col-sm-8">
                            <input type="text" name="dateTo" id="dateTo" class="form-control" maxlength="20">
                        </div>
                    </div>
				
                    <div class="form-group">
                        <label class="col-sm-3 control-label">* Subject No:</label>
                        <div class="col-sm-8">
                            <input type="text"  name="subjectNo" id="subjectNo" class="form-control" maxlength="10">
                        </div>
                    </div>
				
                   
              	</div>
            </div>
             <div class="modal-footer text-center">
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
                <input type="submit" class="btn btn-sky btn-sm"  value="Save">
            </div>
           </form>            
     	</div>
   	</div>
</div>             