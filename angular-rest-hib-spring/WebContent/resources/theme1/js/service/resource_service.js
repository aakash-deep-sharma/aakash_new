/**
 * resource service
 */

'use strict';

App.factory('ResourceService',['$http','$q',function($http,$q){
	
	return {
        
		fetchAllResources: function()
		{
			
            return $http.get('http://localhost:8085/resource_management/admin/resources')
                    .then(
                            function(response){
                            	
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Error while fetching resources list');
                                return $q.reject(errResponse);
                            }
                    );
        },
	
	
	
		fetchResource: function(id)
		{
			
			return $http.get('http://localhost:8085/resource_management/admin/resources/'+id)
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('No resource by this id is present');
								return $q.reject(errResponse);
							}
					);
		},
		
		createResource: function(resource)
		{
			
			return $http.put('http://localhost:8085/resource_management/admin/create',resource)
					.then(
							function(response){
							
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Error while creating resource');
                                return $q.reject(errResponse);
                            }
					
					);
		},
		
		updateResource: function(resource)
		{
            return $http.post('http://localhost:8085/resource_management/admin/update',resource)
                    .then(
                            function(response){
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Error while updating resource');
                                return $q.reject(errResponse);
                            }
                    );
	    },
	    
	    deleteResource: function(resourceId){
            return $http.delete('http://localhost:8085/resource_management/admin/delete/'+resourceId)
                    .then(
                            function(response){
                            	
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Error while deleting resource');
                                return $q.reject(errResponse);
                            }
                    );
    }
	    
	    
		
	};
}]);