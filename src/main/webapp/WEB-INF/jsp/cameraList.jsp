 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><head>
 <script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>
 <script type="text/javascript">
 
 
 $(document).ready(function() {
		
		
	 	$('#addCamera').on('hidden.bs.modal', function(){
	        $(this).removeData('bs.modal');
	        $('#registerForm').bootstrapValidator('resetForm', true);
	    });
	 
	 	$('#editCamera').on('hidden.bs.modal', function(){
	        $(this).removeData('bs.modal');
	        $('#editForm').bootstrapValidator('resetForm', true);
	    });
	    $('#registerForm').formValidation({
	        framework: 'bootstrap',
	        excluded: ':disabled',
	        icon: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	uniqueID: {
	                validators: {
	                    notEmpty: {
	                        message: 'Unique ID is required'
	                    }
	                }
	            },
	            
	            deviceID: {
	                validators: {
	                    notEmpty: {
	                        message: 'device ID is required'
	                    }
	                }
	            },
	            
	            isActive: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please Select Status '
	                    }
	                }
	            },
	            
	            description: {
	                validators: {
	                    notEmpty: {
	                        message: 'Description is required '
	                    }
	                }
	            },
	            
	            allowNotify: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please Select Allow Notify '
	                    }
	                }
	            }
	        }
	    });
	    
	    $('#editForm').formValidation({
	        framework: 'bootstrap',
	        excluded: ':disabled',
	        icon: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	uniqueID: {
	                validators: {
	                    notEmpty: {
	                        message: 'Unique ID is required'
	                    }
	                }
	            },
	            
	            deviceID: {
	                validators: {
	                    notEmpty: {
	                        message: 'device ID is required'
	                    }
	                }
	            },
	            
	            isActive: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please Select Status '
	                    }
	                }
	            },
	            
	            description: {
	                validators: {
	                    notEmpty: {
	                        message: 'Description is required'
	                    }
	                }
	            },
	            
	            allowNotify: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please Select Allow Notify '
	                    }
	                }
	            }
	        }
	    });
	    
	});
 
 
 var deleteList = [];
 
 function addCameraInDeleteList(uniqueID){
	 deleteList.push(uniqueID);
 }
 
 function videoList(id){

	     alert(id);
		var id=id;
		window.location.href="${pageContext.request.contextPath}/camera/ListVideos?cameraID="+id;
		
	}
 
 function editCamera(cameraID,cameraStatus){
	 
		$("#cameraID").val(cameraID);
		$("#status").val(cameraStatus);
		$('#editCamera').modal({backdrop: 'static', keyboard: false});
		$("#editCamera").modal('show');
	}

 function deleteCamera(uniqueId){
		
		if(deleteList.length > 0){
			 window.location.href = "deleteCamera?cameraList="+deleteList;
			 deleteList = [];
		}else{
			 alert("Please select atleast one camera for delete ");
		}
		  
	}	
 
 $(document).ready(function() {

	 $("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
		    $("#success-alert").alert('close');
		});
	 
	    $('#routeDataTable').dataTable( {
	        "aaSorting": [[1,'asc']],
	         aoColumnDefs: [
	                   {
	                      bSortable: false,
	                      aTargets: [ -1 ]
	                   }
	                 ]
	      } );
	} ); 

 </script>
<div class="form-horizontal">
    <div class="row">
        <div class="col-lg-12">
            <div class="fixed-page-header">
                <div class="page-header clearfix">
                    <h1 class="page-head-text pull-left">Camera</h1>  
                    
                      <c:if test="${added == 'added'}">
                   <center> <div class="alert alert-success" id="success-alert">
    					<button type="button" class="close" data-dismiss="alert">x</button>
    						<strong>Success! </strong>
   								 Camera Added Successfully
					</div></center>                    	
                    </c:if>    
                    
                     <c:if test="${updated == 'updated'}">
                    <center><div class="alert alert-info" id="success-alert">
    					<button type="button" class="close" data-dismiss="alert">x</button>
    						<strong>Success! </strong>
   								 Camera Updated Successfully
					</div> </center>                   	
                    </c:if>    
                      
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#addCamera" data-backdrop="static" data-keyboard="false"><i class="fa fa-plus-circle"></i>  Add Camera</button>                    
                    <button type="submit" class="btn btn-brown btn-sm pull-right" onClick="deleteCamera('${camera.cameraID}')" ><i class="fa fa-trash-o"></i> Delete</button>
                </div>                                    
            </div>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
           
    <div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                   <div class="panel-name">
                        <span class="panel-head">Camera List</span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="routeDataTable" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            	<th width="2%" class="text-center no-sort"><input type="checkbox" onClick="deleteAllRow(this)"></th>
                                <th width="20%">Camera Id</th>
                                <th width="20%">Vehicle Id</th>
                                <th width="10%">Status</th>
      							<th width="30%">Video</th>
                                <th width="30%">Action</th>
                            </tr>
                          </thead>
                            <tbody>
                                <c:forEach var="camera" items="${cameraList}">
                                    <tr>
                                       <td><input type="checkbox" id="${camera.cameraID}" name="myTextEditBox" value="" onClick="addCameraInDeleteList('${camera.cameraID}')"></td>
                                       <td>${camera.cameraID}</td>  
                                       <td>${camera.vehicleID}</td> 
                                       <c:choose>
                                        <c:when test="${camera.cameraStatus=='true'}">
                                        	<td>ON</td>
                                        </c:when>    
                                        <c:otherwise>
                                        	<td>OFF</td>
                                        </c:otherwise>
                                      </c:choose>
                                       <td><button type="submit" class="btn btn-default btn-sm" onClick="videoList(${camera.cameraID})"><i class="fa fa-pencil-square-o"></i> Video</button></td>
                                       <td><button type="submit" class="btn btn-default btn-sm" onClick="editCamera('${camera.cameraID}','${camera.cameraStatus}');"><i class="fa fa-pencil-square-o"></i> Edit</button></td>
                                      </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>                                    
            </div>
        </div>
    </div>
<!-- / row -->   
</div>

<div class="modal fade" id="editCamera" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
   	<div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">Edit Camera</h4>
          </div>            
          	<form:form id="editForm" class="form-horizontal" method="post" name="registerForm" action="${pageContext.request.contextPath}/camera/cameraList" commandName="camera">
          	<div class="modal-body"> 
          	<input type="hidden" name="action" value="edit">
          	 <div class="form-group">
                    <form:label path="cameraID" class="col-sm-3 control-label">* Camera Id</form:label>
                    <div class="col-sm-8">
                    	<form:input path="cameraID" id="cameraID"  class="form-control" readonly="true"/>
                   	</div>
                </div>
                
    
                <div class="form-group">
                    <form:label path="cameraStatus" class="col-sm-3 control-label">* Status</form:label>
                    <div class="col-sm-8">
                        <form:select path="cameraStatus" id="status" class="form-control">
                            <form:option value="1">ON</form:option>
                            <form:option value="0">OFF</form:option>
                        </form:select>
                   	</div>
                </div>
                
           	</div>
			<div class="modal-footer text-center">
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>                    
                <button type="submit" class="btn btn-sky btn-sm" />Save</button>
            </div>
         </form:form>
    	</div>
	</div>
</div>

 <div class="modal fade" id="addCamera" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
   	<div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">Add Camera</h4>
          </div>            
          	<form:form id="registerForm" class="form-horizontal" method="post" name="registerForm" action="${pageContext.request.contextPath}/camera/cameraList" commandName="camera">
          	<div class="modal-body"> 
          		<input type="hidden" name="action" value="add">
                <div class="form-group">
                    <form:label path="cameraID" class="col-sm-3 control-label">* Camera Id</form:label>
                    <div class="col-sm-8">
                    	<form:input path="cameraID"   class="form-control" maxlength="20" />
                   	</div>
                </div>
               
    
                <div class="form-group">
                    <form:label path="cameraStatus" class="col-sm-3 control-label">* Status</form:label>
                    <div class="col-sm-8">
                        <form:select path="cameraStatus"  class="form-control">
                        	<form:option value="">Select Status </form:option>
                            <form:option value="1">ON</form:option>
                            <form:option value="0">OFF</form:option>
                        </form:select>
                   	</div>
                </div>
                
           	</div>
			<div class="modal-footer text-center">
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>                    
                <button type="submit" class="btn btn-sky btn-sm" />Save</button>
            </div>
         </form:form>
    	</div>
	</div>
</div>