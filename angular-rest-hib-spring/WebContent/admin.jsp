<div>
	<div class="panel panel-info">
           <div class="panel-heading" style="text-align: center;"><span class="lead">RESOURCE MANAGER </span></div>
			<br>
			<br>
			<div class="formcontainer">
				 
				 <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
				 	<input type="hidden" ng-model="ctrl.resource.resourceId" />
				 	
				 	<div class="row">
				 		<div class="form-group col-md-12">
				 			
				 			<label class="col-md-2 col-md-offset-3 control-lable"  for="rname">Resource Name</label>
				 			<div class="col-md-6">
				 			<input type="text" ng-model="ctrl.resource.resourceName" name="rname" class="form-control input-sm" placeholder="Enter resource name" required ng-minlength="3"/>
								<div class="has-error" ng-show="myForm.$dirty">
								  <span ng-show="myForm.rname.$error.required">This is a required field</span>
                                     <span ng-show="myForm.rname.$error.minlength">Minimum length required is 3</span>
                                     <span ng-show="myForm.rname.$invalid">This field is invalid </span>
								</div>			 			
				 			</div>
				 			
				 			<br>
				 			<br>
				 			<label class="col-md-2 col-md-offset-3 control-lable" for="rstatus">Resource Status</label>
				 			<div class="col-md-6">
				 			<input type="text" ng-model="ctrl.resource.resourceStatus" name="rstatus" class="form-control input-sm" placeholder="Enter resource status" required ng-minlength="3"/>
								<div class="has-error" ng-show="myForm.$dirty">
								  <span ng-show="myForm.rstatus.$error.required">This is a required field</span>
                                     <span ng-show="myForm.rstatus.$error.minlength">Minimum length required is 3</span>
                                     <span ng-show="myForm.rstatus.$invalid">This field is invalid </span>
								</div>			 			
				 			</div>
				 			
				 		</div>
				 	</div>
				 	
				 	<div class="row">
				 		 <div class="form-actions col-md-4 col-md-offset-5">
				 		 	<input type="submit"  value="{{!ctrl.resource.resourceId ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
				 		 	<button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                         </div>
                     </div>
                     <br>
                     <br>
                 </form>
             </div>
	</div>
	<div class="panel panel-info">
		<div class="panel-heading" style="text-align: center;"><span class="lead" >List of Resources </span></div>
		<div class="tablecontainer">
		
		<br>
		
		<div class="form-group input-group col-md-4 col-md-offset-4">
			<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
		 	<input type="text" ng-model="search.field" name="search" class="form-control input-sm" placeholder="Search Resources"/>
		   
		</div>
		
		<br>
			<table class="table table-hover">
				<thead>
                      <tr>
                          <th width="11%">Resource ID.</th>
                          <th width="13%">Resource Name</th>
                          <th width="15%">Resource Status</th>
                          <th width="10%"></th>
                      </tr>
                   </thead>
                   <tbody>
                       <tr ng-repeat="r in ctrl.resources | filter:search.field">
                           <td><span ng-bind="r.resourceId"></span></td>
                           <td><span ng-bind="r.resourceName"></span></td>
                           <td><span ng-bind="r.resourceStatus"></span></td>
                           <td>
                          		  
							 
							 	 <div ng-hide="r.roles">
						                <h5>NA</h5>
						         </div>
						         
						         <div ng-show="r.roles">
						        <a ng-href="{{'#resource' + $index}}" class="btn btn-info" data-toggle="collapse">Show Roles</a>
								     <div id="{{ 'resource' + $index }}" class="collapse">
								     <table class="table table-hover">
			                            <thead>
			                         		<th>Role Name</th>
		                          			<th>Role Type</th>
		                           			<th>Start Date</th>
		                          			<th>End Date</th>
		                          		</thead>
			                    		
			                    		<tbody>
				                            	<tr ng-repeat="role in r.roles">
				                            		 <td><span ng-bind="role.roleName"></span></td>
				                            		 <td><span ng-bind="role.roleType"></span></td>
				                            		 <td><span ng-bind="role.startDate"></span></td>
				                            		 <td><span ng-bind="role.endDate"></span></td>
				                            	</tr>
		                            	<tbody>
		                            </table>
	                            </div>
							  </div>
                            </td>
                           <td style="position: absolute; right: 5px">
                          <button type="button" ng-click="ctrl.edit(r.resourceId)" class="btn btn-success custom-width">Edit</button> 
                          <button type="button" ng-click="ctrl.remove(r.resourceId)" class="btn btn-danger custom-width">Remove</button>
                           </td>
                       </tr>
                   </tbody>
			</table>
		</div>
	</div>
					
</div>
		
		

					
