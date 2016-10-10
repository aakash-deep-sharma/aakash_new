  	<div class="panel panel-info">
						<div class="panel-heading" style="text-align: center;"><span class="lead" >List of Teams </span></div>
						<div class="tablecontainer">
						
						<br>
						<div class="col-md-4 col-md-offset-4">
						   <input type="text" ng-model="ctrl.search.field" name="search" class="form-control input-sm" placeholder="Search Teams"/>
						</div>
						<br>
							<table class="table table-hover">
								<thead>
			                       <tr>
			                           <th>Team ID.</th>
			                           <th>Team Name</th>
			                           <th>Team Status</th>
			                           <th>Start Date</th>
			                           <th>End Date</th>
			                           <th>Details</th>
			                                                 		
			                           <th width="10%"></th>
			                       </tr>
			                    </thead>
			                    <tbody>
			                        <tr ng-repeat="r in ctrl.teams | filter:ctrl.search.field">
			                            <td><span ng-bind="r.teamId"></span></td>
			                            <td><span ng-bind="r.teamName"></span></td>
			                            <td><span ng-bind="r.teamStatus"></span></td>
			                            <td><span ng-bind="r.startDate"></span></td>
			                            <td><span ng-bind="r.endDate"></span></td>
			                            <td>
										    <div ng-hide="r.projects">
											  <h5>NA</h5>
								            </div> 
								         	<div ng-show="r.projects">
								         	<!-- <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Show projects</button> -->
								              <a ng-href="{{'#team' + $index}}" class="btn btn-info" data-toggle="modal">Details</a>
								                <div class="modal fade" id="{{ 'team' + $index }}" role="dialog">
												    <div class="modal-dialog">
												    
												      <!-- Modal content-->
												      <div class="modal-content">
												        <div class="modal-header">
												          <button type="button" class="close" data-dismiss="modal">&times;</button>
												          <h4 class="modal-title">Projects</h4>
												        </div>
												        <div class="modal-body">
												         <table class="table table-hover">
													         <thead>
													            <th>id</th>
													            <th>name</th>
															</thead>
													   		<tbody>
										 		             	<tr ng-repeat="project in r.projects">
														           		 <td><span ng-bind="project.projectId"></span></td>
																		 <td><span ng-bind="project.projectName"></span></td>
													           	</tr>
													    	<tbody>
											       		 </table>
											       		 <div class="modal-header">
												          <!-- <button type="button" class="close" data-dismiss="modal">&times;</button> -->
												          <h4 class="modal-title">Resources</h4>
												        </div>
											       		 <table class="table table-hover">
										                   	<thead>
													            <th>id</th>
													            <th>name</th>
													             <th>status</th>
															</thead>
													   		<tbody>
										 		             	<tr ng-repeat="resource in r.resources">
														           		 <td><span ng-bind="resource.resourceId"></span></td>
																		 <td><span ng-bind="resource.resourceName"></span></td>
													           			<td><span ng-bind="resource.resourceStatus"></span></td>
													           </tr>
													    	<tbody>
											        	</table>
												        </div>
												        <div class="modal-footer">
												          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
												        </div>
												      </div>
												      
												    </div>
												  </div>
										  </div>  																					              																	                        
			                           </td>
			                           
			                        
			                        </tr>
			                    </tbody>
							</table>
						</div>
</div>
					
			
	