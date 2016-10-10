/**
 * team controller
 */

'use strict';

App.controller('TeamController', ['$scope', 'TeamService', function($scope,TeamService) {
	
	var self = this;
    self.team={teamId:null,teamName:'',teamStatus:'',startDate:'',endDate:''};
    self.teams=[];
    self.search={field:''}
    
    self.fetchAllTeams = function(){
    	
    	TeamService.fetchAllTeams()
            .then(
	                 function(d) {
	                	
	                      self.teams = d;
	                 },
	                  function(errResponse){
	                      console.error('Error while fetching teams');
	                 }
                 );
    };
    
    self.fetchAllTeams();
    
    self.fetchTeam = function(id){
    	TeamService.fetchTeam(id)
    		.then(
    				function(d){
    					
    					self.team = d;
    				},
    				function(errResponse){
    					console.error('No team find by this id');
    				}
    				
    		
    		);
    };
    
}]);