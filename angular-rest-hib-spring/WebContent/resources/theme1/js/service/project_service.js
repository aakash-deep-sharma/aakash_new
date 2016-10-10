/**
 * resource service
 */

'use strict';

App.factory('ProjectService',['$http','$q',function($http,$q){
	
	var self= this;
	self.isTeamCreated=false;
	self.isProjectCreated=false;
	self.teamId;
	self.projectId;
	self.isResourceAssigned=false;
	return {
        
		
		createProject: function(project)
		{
			self.isProjectCreated=true;
			return $http.put('http://localhost:8085/resource_management/projectManager/createProject',project)
					.then(
							function(response){
								self.projectId=response.data.projectId;
								console.info(self.projectId)  
								return response.data;
                            }, 
                            function(errResponse){
                                console.error('Error while creating project');
                                return $q.reject(errResponse);
                            }
					
					);
		},
		createTeam: function(team)
		{
			self.isTeamCreated=true;
			return $http.put('http://localhost:8085/resource_management/projectManager/createTeam',team)
					.then(
							function(response){
								self.teamId=response.data.teamId;
								console.info(self.teamId)
	                            return response.data;
	                        }, 
	                        function(errResponse){
	                            console.error('Error while creating team');
	                            return $q.reject(errResponse);
	                        }
					
					);
		},
		
		
		deleteTeam: function()
		{
			console.debug(self.teamId)
			if(self.isTeamCreated)
			{
					if(!self.isResourceAssigned)
						{
							self.isTeamCreated=false;
							return $http.delete('http://localhost:8085/resource_management/projectManager/deleteTeam/'+self.teamId)
									.then(
											function(response){
												
												
					                            return response.data;
					                        }, 
					                        function(errResponse){
					                            console.error('Error while deleting team');
					                            return $q.reject(errResponse);
					                        }
									
									);
						}
					else
					{
						return null;
					}
			}
		},
		
		
		deleteProject: function()
		{
			console.debug(self.projectId)
			
			if(self.isTeamCreated)
			{
				if(!self.isResourceAssigned)
					{
					    self.isProjectCreated=false;
						return $http.delete('http://localhost:8085/resource_management/projectManager/deleteProject/'+self.projectId)
								.then(
										function(response){
											
											
				                            return response.data;
				                        }, 
				                        function(errResponse){
				                            console.error('Error while deleting project');
				                            return $q.reject(errResponse);
				                        }
								
								);
					}
				else
					{
						return null;
					}
			}
		},
		
		
		
		
		assignTeam: function(team,project)
		{
			
			return $http.post('http://localhost:8085/resource_management/projectManager/allocateProjectToTeam/'+project.projectId+"/"+team.teamId)
					.then(
							function(response){
								
	                            return response.data;
	                        }, 
	                        function(errResponse){
	                            console.error('Error while creating team');
	                            return $q.reject(errResponse);
	                        }
					
					);
		},
		
		assignResource:function(rId,team)
		{
			self.isResourceAssigned=true;
			return $http.get('http://localhost:8085/resource_management/projectManager/addResourceToTeam/'+rId+"/"+team.teamId)
					.then(
							function(response){
								
	                            return response.data;
	                        }, 
	                        function(errResponse){
	                            console.error('Error while assigning resource');
	                            return $q.reject(errResponse);
	                        }
					
					);
			
		},
		
		fetchProject: function(project)
		{
			alert("1")
			self.isTeamCreated=false;
			self.isProjectCreated=false;
			return $http.get('http://localhost:8085/resource_management/projectManager/getProjectById/'+project.projectId)
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('No project by this id is present');
								return $q.reject(errResponse);
							}
					);
		},
		
		addRoleToResource: function(roleModel)
		{
			
			return $http.put('http://localhost:8085/resource_management/projectManager/addRoleToResource',roleModel)
					.then(
							function(response){
						            return response.data;
	                        }, 
	                        function(errResponse){
	                            console.error('Error while adding role to resource');
	                            return $q.reject(errResponse);
	                        }
					
					);
		}
	};
}]);