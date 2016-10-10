/**
 * controller
 */

'use strict';

App.controller('ProjectController', ['$scope','$location', 'ProjectService','ResourceService', function($scope, $location,ProjectService,ResourceService) {
	
	var self = this;
    self.pId={projectId:null};
    self.tId={teamId:null};
    self.team={teamName:'',teamStatus:'',startDate:'',endDate:''}
    self.project={projectName:''};
    self.rId={resourceId:null};
    self.resources=[];
    self.showForm=true;
    self.showResource=false;
    self.showDetails=false;
    self.model={projectName:'',teamId:'',teamName:'',teamStatus:'',startDate:'',endDate:'',resourceList:[]};
    self.roleModel={resourceId:'',roleName:'',roleType:'',startDate:'',endDate:''}
    
    self.enableFinish=false;
    
    self.fetchAllResources = function(){
    	
       
       	ResourceService.fetchAllResources()
               .then(
    	                 function(d) {
    	                	
    	                      self.resources = d;
    	                 },
    	                  function(errResponse){
    	                      console.error('Error while fetching resources');
    	                 }
                    );
       };
    
    
    self.createProject= function(project){
    	
    	ProjectService.createProject(project)
    		.then(
    				function(d){
    						self.project = d;
    						
    						self.createTeam(self.team)
    				},
    					function(errResponse){
    					console.error('Error while creating resource.');
    				}
    		);
    };
    self.createTeam = function(team){
    	
    	ProjectService.createTeam(team)
    		.then(
    				function(d){
    					self.team = d;
    					
    					self.assignTeam(self.team,self.project)
						},
    					function(errResponse){
    					console.error('Error while creating team.');
    				}
    		);
    };
    
    self.assignTeam = function(team,project){
    	
    	ProjectService.assignTeam(team,project)
    		.then(
    				function(d){
    					
						},
    					function(errResponse){
    					console.error('Error while creating team.');
    				}
    		);
    };
    
    
    self.fetchProject = function(project){
    	
    	ProjectService.fetchProject(project)
    		.then(
    				function(d){
    					
    					self.model = d;
    				},
    				function(errResponse){
    					console.error('No project find by this id');
    				}
    		);
    };
   
    
    self.addRoleToResource = function(roleModel){
    	
    	ProjectService.addRoleToResource(roleModel)
    		.then(
    				function(d){
    					
    					
    				},
    				function(errResponse){
    					console.error('No resource find by this id');
    				}
    				
    		
    		);
    };
    
   self.assignResource = function(rId){
	  
	   self.enableFinish=true;
	   ProjectService.assignResource(rId,self.team)
		.then(
				self.fetchAllResources,
				function(d){
					
					
					},
					function(errResponse){
					console.error('Error while assign resources.');
				}
		);
	   
	   
   };
   
   
   
   	self.fetchAllResources();
   
    self.submit = function(){
            self.createProject(self.project);
            self.showForm=false;
            self.showResource=true;     
    };
    
    self.addRoleButton=function(resId){
    	self.roleModel.resourceId=resId;
    	self.addRoleToResource(self.roleModel);
    };
    
    self.reset = function(){
    	self.team={teamName:'',teamStatus:'',startDate:'',endDate:''}
        self.project={projectName:''};
        $scope.myForm.$setPristine(); //reset Form
    };
    
    
    self.finish = function(){
    	self.showResource=false;
        self.showDetails=true;
        self.enableFinish=false;
        self.fetchProject(self.project);
    };
    
    
}]);