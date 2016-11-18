/**
 * login service
 */

'use strict';

App.factory('LoginService',['$http','$q',function($http,$q){
	
	
	
	return{
		
		getCredentials : function(user){
			
			return $http.post('http://localhost:8085/resource_management/login/user',user)
				.then(
						function(response){
							
							/*alert('2 '+response.data)*/
                            return response.data;
                        }, 
                        function(errResponse){
                            console.error('Error while checking credentials');
                            return $q.reject(errResponse);
                        }
					);
		}
		
	}	
		
}]);

App.factory('Login',['$cookies','$state',function($cookies,$state){
	
	
	
	return{
		
		getAuthStatus : function(){
			
			var status = $cookies.get('auth');
			if(status)
				{
				return true;
				}
			else
				{
				return false;
				}
		},
		
	
		doLogout :function(){
			
			$cookies.remove('auth');
			$state.transitionTo('login');
			
		},
		
		getPermission : function(){
			
			var status = $cookies.get('auth');
			return status;
		}
	}	
		
}]);