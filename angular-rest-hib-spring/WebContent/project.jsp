<div class="panel panel-info" ng-show="pctrl.showForm">
			            <div class="panel-heading" style="text-align: center;"><span class="lead">Create Project And Team</span></div>
							<br>
							<br>
				<div class="formcontainer">
					 
					 <form ng-submit="pctrl.submit()" name="myForm" class="form-horizontal">
					 	<!-- <input type="hidden" ng-model="pctrl.resource.resourceId" /> -->
					 	
					 	<div class="row">
					 		<div class="form-group col-md-12">
					 			
					 			<label class="col-md-2 col-md-offset-3 control-lable"  for="pname">Project Name</label>
					 			<div class="col-md-6">
					 			<input type="text" ng-model="pctrl.project.projectName" name="pname" class="form-control input-sm" placeholder="Enter project name" required ng-minlength="3"/>
									<div class="has-error" ng-show="myForm.$dirty">
									  <span ng-show="myForm.pname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.pname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.pname.$invalid">This field is invalid </span>
									</div>			 			
					 			</div>
					 			<br>
					 			<br>
					 			<label class="col-md-2 col-md-offset-3 control-lable" for="tname">Team Name</label>
					 			<div class="col-md-6">
					 			<input type="text" ng-model="pctrl.team.teamName" name="tname" class="form-control input-sm" placeholder="Enter team name" required ng-minlength="3"/>
									<div class="has-error" ng-show="myForm.$dirty">
									  <span ng-show="myForm.tname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.tname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.tname.$invalid">This field is invalid </span>
									</div>			 			
					 			</div>
					 			<br>
					 			<br>
					 			<label class="col-md-2 col-md-offset-3 control-lable" for="tstatus">Team Status</label>
					 			<div class="col-md-6">
					 			<input type="text" ng-model="pctrl.team.teamStatus" name="tstatus" class="form-control input-sm" placeholder="Enter team status" required ng-minlength="3"/>
									<div class="has-error" ng-show="myForm.$dirty">
									  <span ng-show="myForm.tstatus.$error.required">This is a required field</span>
                                      <span ng-show="myForm.tstatus.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.tstatus.$invalid">This field is invalid </span>
									</div>			 			
					 			</div>
					 			<br>
					 			<br>
					 			<label class="col-md-2 col-md-offset-3 control-lable" for="tstartdate">Start Date</label>
					 			<div class="col-md-6">
					 			<input type="date" ng-model="pctrl.team.startDate" name="tstartdate" class="form-control input-sm" placeholder="Enter team start date" required ng-minlength="3"/>
									<div class="has-error" ng-show="myForm.$dirty">
									  <span ng-show="myForm.tstartdate.$error.required">This is a required field</span>
                                      <span ng-show="myForm.tstartdate.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.tstartdate.$invalid">This field is invalid </span>
									</div>			 			
					 			</div>
					 			<br>
					 			<br>
					 			<label class="col-md-2 col-md-offset-3 control-lable" for="tenddate">End Date</label>
					 			<div class="col-md-6">
					 			<input type="date" ng-model="pctrl.team.endDate" name="tenddate" class="form-control input-sm" placeholder="Enter team end date" required ng-minlength="3"/>
									<div class="has-error" ng-show="myForm.$dirty">
									  <span ng-show="myForm.tenddates.$error.required">This is a required field</span>
                                      <span ng-show="myForm.tenddates.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.tenddate.$invalid">This field is invalid </span>
									</div>			 			
					 			</div>
					 		</div>
					 	</div>
					 	
					 	<div class="row">
					 		 <div class="form-actions col-md-4 col-md-offset-5">
					 		 	<input type="submit"  value="Create" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
					 		 	<button type="button" ng-click="pctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          	</div>
                      </div>
                      <br>
                      <br>
                  </form>
              </div>
		</div>
					
					
		<div class="panel panel-info" ng-show="pctrl.showResource">
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
                        <tr ng-repeat="r in pctrl.resources | filter:search.field |filter:r.resourceStatus='free'">
                            <td><span ng-bind="r.resourceId"></span></td>
                            <td><span ng-bind="r.resourceName"></span></td>
                            <td><span ng-bind="r.resourceStatus"></span></td>
                            
                            <td>
	                          
	                          <button type="button" ng-click="pctrl.assignResource(r.resourceId)" class="btn btn-danger custom-width">Assign</button>
                            </td>
                        </tr>
                    </tbody>
				</table>
			</div>
			<div>
			<button type="button" ng-click="pctrl.finish()" ng-disabled="!pctrl.enableFinish" class="btn btn-warning btn-sm" >Finish</button>
			</div>
		</div>
					
					
					
		<div class="panel panel-info" ng-show="pctrl.showDetails">
						<div class="panel-heading" style="text-align: center;"><span class="lead" >Project Details </span></div>
						<div class="tablecontainer">
						
						<br>
						
						<br>
							<table class="table table-hover">
								<thead>
			                       <tr>
			                          
			                           <th width="13%">Project Name</th>
			                           <th width="11%">Team ID</th>
			                           <th width="13%">Team Name</th>
			                           <th width="13%">Team Status</th>
			                           <th width="15%">Start Date</th>
			                           <th width="15%">End Date</th>
			                           <th width="10%"></th>
			                       </tr>
			                    </thead>
			                    <tbody>
			                        <tr ><!-- ng-repeat="p in pctrl.model" -->
			                           
			                            <td><span ng-bind="pctrl.model.projectName"></span></td>
			                       	    <td><span ng-bind="pctrl.model.teamId"></span></td>
			                       	    <td><span ng-bind="pctrl.model.teamName"></span></td>
			                       	    <td><span ng-bind="pctrl.model.teamStatus"></span></td>
			                       	    <td><span ng-bind="pctrl.model.startDate"></span></td>
			                            <td><span ng-bind="pctrl.model.endDate"></span></td>
			                            <td>
			                            	<tr ng-repeat="resource in pctrl.model.resourceList">
			                            		<td><span ng-bind="resource.resourceId"></span></td>
			                            		<td><span ng-bind="resource.resourceName"></span></td>
			                            		<td width="30%">
			                            			  <a ng-href="{{'#object-' + $index}}" class="btn btn-info" data-toggle="collapse">Add Role</a>
												     <div id="{{ 'object-' + $index }}" class="collapse">
												     	
												     		<div class="formcontainer">
								 
																	 <form ng-submit="pctrl.addRoleButton(resource.resourceId)" name="myForm" class="form-horizontal">
																	 	<input type="hidden" ng-model="pctrl.resource.resourceId" />
																	 	
																	 	<div class="row" >
																	 		
																	 			
																	 			<label class="control-lable"  for="roleName">Role Name</label>
																	 			<br>
																	 			<div >
																	 			<input type="text" ng-model="pctrl.roleModel.roleName" name="roleName" class="form-control input-sm" placeholder="Enter role name" required ng-minlength="3"/>
																					<div class="has-error" ng-show="myForm.$dirty">
																					  <span ng-show="myForm.roleName.$error.required">This is a required field</span>
												                                      <span ng-show="myForm.roleName.$error.minlength">Minimum length required is 3</span>
												                                      <span ng-show="myForm.roleName.$invalid">This field is invalid </span>
																					</div>			 			
																	 			</div>
																	 			
																	 			<br>
																	 			
																	 			<label class="control-lable" for="roleType">Role Type</label>
																	 			<br>
																	 			<div>
																	 			<input type="text" ng-model="pctrl.roleModel.roleType" name="roleType" class="form-control input-sm" placeholder="Enter role type" required ng-minlength="3"/>
																					<div class="has-error" ng-show="myForm.$dirty">
																					  <span ng-show="myForm.roleType.$error.required">This is a required field</span>
												                                      <span ng-show="myForm.roleType.$error.minlength">Minimum length required is 3</span>
												                                      <span ng-show="myForm.roleType.$invalid">This field is invalid </span>
																					</div>			 			
																	 			</div>
																	 			
																	 			<br>
																	 			
																	 			<label class="control-lable"  for="startDate">Start Date</label>
																	 			<br>
																	 			<div>
																	 			<input type="date" ng-model="pctrl.roleModel.startDate" name="startDate" class="form-control input-sm" placeholder="Enter start date" required ng-minlength="3"/>
																					<div class="has-error" ng-show="myForm.$dirty">
																					  <span ng-show="myForm.startDate.$error.required">This is a required field</span>
												                                     
												                                      <span ng-show="myForm.startDate.$invalid">This field is invalid </span>
																					</div>			 			
																	 			</div>
																	 			
																	 			<br>
																	 			
																	 			<label class="control-lable"  for="endDate">Start Date</label>
																	 			<br>
																	 			<div >
																	 			<input type="date" ng-model="pctrl.roleModel.endDate" name="endDate" class="form-control input-sm" placeholder="Enter end date" required ng-minlength="3"/>
																					<div class="has-error" ng-show="myForm.$dirty">
																					  <span ng-show="myForm.endDate.$error.required">This is a required field</span>
												                                     
												                                      <span ng-show="myForm.endDate.$invalid">This field is invalid </span>
																					</div>			 			
																	 			</div>
																	 		
																	 	
																	 			<br>
																	 	
																	 		 
																	 		 	<!-- <input type="submit"  value="Assign Role" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid"> -->
																	 		 	<a ng-href="{{'#object-' + $index}}" class="btn btn-danger" data-toggle="collapse" ng-click="pctrl.addRoleButton(resource.resourceId)">Assign</a>
			
												                      </div>
												                      
												                  </form>
												              </div>
												     	
					                          		 </div>
			                            		</td>
			                            	</tr>
			                         
			                    </tbody>
							</table>
						</div>
</div>
			
		
					
					