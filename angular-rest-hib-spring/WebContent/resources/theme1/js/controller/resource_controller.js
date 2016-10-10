/**
 * controller
 */

'use strict';

App.controller('ResourceController', ['$scope', 'ResourceService', function($scope, ResourceService) {
	
	var self = this;
    self.resource={resourceId:null,resourceName:'',resourceStatus:''};
    self.resources=[];
    self.search={field:''}
    
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
	
    self.fetchResource = function(id){
    	ResourceService.fetchResource(id)
    		.then(
    				function(d){
    					
    					self.resource = d;
    				},
    				function(errResponse){
    					console.error('No resource find by this id');
    				}
    				
    		
    		);
    };
    
    
    self.createResource = function(resource){
    
    	ResourceService.createResource(resource)
    		.then(
    				self.fetchAllResources,
    				function(errResponse){
    					console.error('Error while creating resource.');
    				}
    		);
    };
    
    
    self.updateResource = function(resource){
        ResourceService.updateResource(resource)
                .then(
                        self.fetchAllResources, 
                        function(errResponse){
                             console.error('Error while updating resource.');
                        } 
            );
    };

   self.deleteResource = function(resourceId){
	  
        ResourceService.deleteResource(resourceId)
                .then(
                        self.fetchAllResources, 
                        function(errResponse){
                             console.error('Error while deleting resource.');
                        } 
            );
    };
    
    self.fetchAllResources();
    
    self.submit = function(){
    	if(self.resource.resourceId===null){
               
            self.createResource(self.resource);
        }else{
            self.updateResource(self.resource);
            console.log('Resource updated with id ', self.resource.resourceId);
        }
        self.reset();
    	
    };
    
    
    self.edit = function(resourceId){
    	
        console.log('id to be edited', resourceId);
        for(var i = 0; i < self.resources.length; i++){
            if(self.resources[i].resourceId == resourceId) {
               self.resource = angular.copy(self.resources[i]);
               break;
            }
        }
    };
    
    self.remove = function(resourceId){
    	
        console.log('id to be deleted', resourceId);
        if(self.resource.resourceId == resourceId) {//clean form if the resource to be deleted is shown there.
           self.reset();
        }
        self.deleteResource(resourceId);
    };
    
    
    self.reset = function(){
        self.resource={resourceId:null,resourceName:'',resourceStatus:''};
        $scope.myForm.$setPristine(); //reset Form
    };
    
}]);