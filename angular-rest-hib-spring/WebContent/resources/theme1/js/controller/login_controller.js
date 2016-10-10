/**
 * login controller
 */

'use strict'

App.controller('LoginController',['$scope','$location','$cookies','LoginService','Login',function($scope,$location,$cookies,LoginService,Login){
	
	var self = this;
	self.user={username:'',password:'',role:''}
	self.message=''

	
	self.doLogout =function(){
		
		Login.doLogout();
		
	};
	
	
	self.getAuthStatus =function(){
		
			return Login.getAuthStatus();
		
	};
	
	self.getPermission =function(){
		
		var status = Login.getPermission();
		if(status == 'ADMIN')
			return true;
		else
			return false;
		
	};
	
	self.getCredentials = function(){
		
		
		LoginService.getCredentials(self.user)
			.then(
					
					function(d){
						
						self.user.role = d;
						
						if(self.user.role == 'ADMIN')
						{
							
							$cookies.put('auth',d);
							
							$location.path('/admin');
							
						}
						else if(self.user.role == 'USER')
						{
							
							$cookies.put('auth',d);
							
							$location.path('/project');
							
						}
						
					},
					function(errResponse){
						self.message='Invalid username or password !!';
						confirm("Invalid username or password !!")
						console.error('Error while checking credentials');
					}
				);
	};
	
	
	
}]);