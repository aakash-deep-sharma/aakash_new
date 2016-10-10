/**
 * team service
 */

'use strict';

App.factory('TeamService',['$http','$q',function($http,$q){
	
	return {
        
		fetchAllTeams: function()
		{
			
            return $http.get('http://localhost:8085/resource_management/projectManager/listTeam')
                    .then(
                            function(response){
                            	
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Error while fetching team list');
                                return $q.reject(errResponse);
                            }
                    );
        },
        
        fetchTeam: function(id)
		{
			
			return $http.get('http://localhost:8085/resource_management/projectManager/getTeamById/'+id)
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('No team by this id is present');
								return $q.reject(errResponse);
							}
					);
		}
       
	};
}]);