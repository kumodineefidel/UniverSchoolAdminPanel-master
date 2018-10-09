

 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>
<script type="text/javascript">
 function seeBlogs(id){
	 var id=id;
		window.location.href="${pageContext.request.contextPath}/parent/seeBlogs?studentId="+id;	
}
 
function seeResults(id){
	 var id=id;
		window.location.href="${pageContext.request.contextPath}/parent/seeResults?studentId="+id;	
} 
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
                        <span class="panel-head">Children</span>
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
                              	<th width="10%">School</th>
                                <th width="10%">Action</th>       
                                <th width="10%">Action</th>              
                            </tr>
                          </thead>
                          <tbody>          
                            <c:forEach var="student" items="${studentList}">
                            
                              <tr>
                                <td class="text-center no-sort"><input type="checkbox" id="${student.id}"  name="myTextEditBox" value="" onClick="displayNote(event)"/></td>
                                <td>${student.name}</td>
                                <td>${student.school.schoolName}</td>
                    
                     		  <td><button type="submit" class="btn btn-default btn-sm" onClick="seeBlogs('${student.id}');"><i class="fa fa-pencil-square-o"></i> See Blogs</button></td>
                              <td><button type="submit" class="btn btn-default btn-sm" onClick="seeResults('${student.id}');"><i class="fa fa-pencil-square-o"></i> See Result</button></td>
                              </tr>
    						</c:forEach>
                      	</tbody>
                    	</table>
                    </div>
                </div>                                       
                
            </div>
        </div>
    </div>
    
