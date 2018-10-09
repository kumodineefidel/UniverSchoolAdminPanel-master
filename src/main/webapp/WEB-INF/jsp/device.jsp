 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><head>
 <script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>
 <script type="text/javascript">
 
 
 $(document).ready(function() {
		
		
	 	$('#addDevice').on('hidden.bs.modal', function(){
	        $(this).removeData('bs.modal');
	        $('#registerForm').bootstrapValidator('resetForm', true);
	    });
	 
	 	$('#editDevice').on('hidden.bs.modal', function(){
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
 
 function addDeviceInDeleteList(uniqueID){
	 deleteList.push(uniqueID);
 }
 
 function editDevice(uniqueID,deviceID,status,description,allowNotify){
	 
		$("#uniqueID").val(uniqueID);
		$("#deviceID").val(deviceID);
		$("#status").val(status);
		$("#description").val(description);
		$("#allowNotify").val(allowNotify);
		$('#editDevice').modal({backdrop: 'static', keyboard: false});
		$("#editDevice").modal('show');
	}

 function deleteDevice(uniqueId){
		
		if(deleteList.length > 0){
			 window.location.href = "deleteDevice?uniqueIdList="+deleteList;
			 deleteList = [];
		}else{
			 alert("Please select atleast one device for delete ");
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
                    <h1 class="page-head-text pull-left">Device</h1>  
                    
                      <c:if test="${added == 'added'}">
                   <center> <div class="alert alert-success" id="success-alert">
    					<button type="button" class="close" data-dismiss="alert">x</button>
    						<strong>Success! </strong>
   								 Device Added Successfully
					</div></center>                    	
                    </c:if>    
                    
                     <c:if test="${updated == 'updated'}">
                    <center><div class="alert alert-info" id="success-alert">
    					<button type="button" class="close" data-dismiss="alert">x</button>
    						<strong>Success! </strong>
   								 Device Updated Successfully
					</div> </center>                   	
                    </c:if>    
                      
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#addDevice" data-backdrop="static" data-keyboard="false"><i class="fa fa-plus-circle"></i>  Add Device</button>                    
                    <button type="submit" class="btn btn-brown btn-sm pull-right" onClick="deleteDevice('${device.uniqueID}')" ><i class="fa fa-trash-o"></i> Delete</button>
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
                        <span class="panel-head">Device List</span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="routeDataTable" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            	<th width="2%" class="text-center no-sort"><input type="checkbox" onClick="deleteAllRow(this)"></th>
                                <th width="20%">Device Id</th>
                                <th width="20%">Unique Id</th>
                                <th width="10%">Status</th>
                                <th width="20%">Description</th>
                                <th width="10%">AllowNotify</th>
                                <th width="30%">Action</th>
                            </tr>
                          </thead>
                            <tbody>
                                <c:forEach var="device" items="${deviceList}">
                                    <tr>
                                       <td><input type="checkbox" id="${device.uniqueID}" name="myTextEditBox" value="" onClick="addDeviceInDeleteList('${device.uniqueID}')"></td>
                                       <td>${device.deviceID}</td>  
                                       <td>${device.uniqueID}</td>  
                                       <c:choose>
                                        <c:when test="${device.isActive=='1'}">
                                        	<td>ON</td>
                                        </c:when>    
                                        <c:otherwise>
                                        	<td>OFF</td>
                                        </c:otherwise>
                                      </c:choose>
                                       <td>${device.description}</td> 
                                       <td>${device.allowNotify}</td> 
                                       <td><button type="submit" class="btn btn-default btn-sm" onClick="editDevice('${device.uniqueID}','${device.deviceID}','${device.isActive}','${device.description}','${device.allowNotify}','${device.allowNotify}');"><i class="fa fa-pencil-square-o"></i> Edit</button></td>
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

<div class="modal fade" id="editDevice" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
   	<div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">Edit Device</h4>
          </div>            
          	<form:form id="editForm" class="form-horizontal" method="post" name="registerForm" action="${pageContext.request.contextPath}/device/deviceList" commandName="device">
          	<div class="modal-body"> 
          	<input type="hidden" name="action" value="edit">
          	 <div class="form-group">
                    <form:label path="uniqueID" class="col-sm-3 control-label">* Unique Id</form:label>
                    <div class="col-sm-8">
                    	<form:input path="uniqueID" id="uniqueID"  class="form-control" readonly="true"/>
                   	</div>
                </div>
                <div class="form-group">
                    <form:label path="deviceID" class="col-sm-3 control-label">* Device Id</form:label>
                    <div class="col-sm-8">
                    	<form:input path="deviceID" id="deviceID"  class="form-control" maxlength="20"/>
                   	</div>
                </div>
    
                <div class="form-group">
                    <form:label path="isActive" class="col-sm-3 control-label">* Status</form:label>
                    <div class="col-sm-8">
                        <form:select path="isActive" id="status" class="form-control">
                            <form:option value="1">ON</form:option>
                            <form:option value="0">OFF</form:option>
                        </form:select>
                   	</div>
                </div>
                <div class="form-group">
                    <form:label path="description" class="col-sm-3 control-label">* Description</form:label>
                    <div class="col-sm-8">
                    	<form:input path="description" id="description"  class="form-control" maxlength="50"/>
                   	</div>
                </div>
                <div class="form-group">
                    <form:label path="allowNotify" class="col-sm-3 control-label">* AllowNotify</form:label>
                    <div class="col-sm-8">
                        <form:select path="allowNotify" id="allowNotify" class="form-control">
                            <form:option value="1">YES</form:option>
                            <form:option value="0">NO</form:option>
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


<div class="modal fade" id="addDevice" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
   	<div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">Add Device</h4>
          </div>            
          	<form:form id="registerForm" class="form-horizontal" method="post" name="registerForm" action="${pageContext.request.contextPath}/device/deviceList" commandName="device">
          	<div class="modal-body"> 
          		<input type="hidden" name="action" value="add">
                <div class="form-group">
                    <form:label path="deviceID" class="col-sm-3 control-label">* Device Id</form:label>
                    <div class="col-sm-8">
                    	<form:input path="deviceID"   class="form-control" maxlength="20" />
                   	</div>
                </div>
                <div class="form-group">
                    <form:label path="uniqueID" class="col-sm-3 control-label">* Unique Id</form:label>
                    <div class="col-sm-8">
                    	<form:input path="uniqueID"   class="form-control" maxlength="20" />
                   	</div>
                </div>
    
                <div class="form-group">
                    <form:label path="isActive" class="col-sm-3 control-label">* Status</form:label>
                    <div class="col-sm-8">
                        <form:select path="isActive"  class="form-control">
                        	<form:option value="">Select Status </form:option>
                            <form:option value="1">ON</form:option>
                            <form:option value="0">OFF</form:option>
                        </form:select>
                   	</div>
                </div>
                <div class="form-group">
                    <form:label path="description" class="col-sm-3 control-label">* Description</form:label>
                    <div class="col-sm-8">
                    	<form:input path="description"   class="form-control" maxlength="50" />
                   	</div>
                </div>
                <div class="form-group">
                    <form:label path="allowNotify" class="col-sm-3 control-label">* AllowNotify</form:label>
                    <div class="col-sm-8">
                        <form:select path="allowNotify"  class="form-control">
                        	<form:option value="">Select Notify </form:option>
                            <form:option value="1">YES</form:option>
                            <form:option value="0">NO</form:option>
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