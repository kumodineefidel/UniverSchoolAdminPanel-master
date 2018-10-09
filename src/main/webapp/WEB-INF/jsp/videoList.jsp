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
                                <th width="20%">Date</th>
      							<th width="30%">Video</th>
                            </tr>
                          </thead>
                            <tbody>
                                <c:forEach var="video" items="${videoList}">
                                    <tr>
                                       <td><input type="checkbox" id="${video.videoID}" name="myTextEditBox" value="" onClick="addCameraInDeleteList('${video.videoID}')"></td>
                                       <td>${video.videoDate}</td>  
                                       <%-- <td><button type="submit" class="btn btn-default btn-sm" onClick="videoStart(${video.videoID})"><i class="fa fa-pencil-square-o"></i> Video</button></td> --%>
                                      	<td><video width="800" controls>
  <source src="http://45.40.137.142:8080/SchoolTrackAdminPanel/resources/images/logo/440091_480p.mp4" type="video/mp4">
  
 
</video></td>
<td></td>
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


