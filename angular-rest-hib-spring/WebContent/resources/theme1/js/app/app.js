/**
 *  app
 */

'use strict';

var App = angular.module('myApp',["ngRoute","ui.router","ngCookies"]);




App.config(function ($stateProvider,$urlRouterProvider,$urlMatcherFactoryProvider) {

	/*$urlRouterProvider.otherwise('/project');*/
	/*$urlMatcherFactoryProvider.strictMode(true);*/
	$urlMatcherFactoryProvider.caseInsensitive(true);
	
    $stateProvider.state('login', {
      url:'/',
      templateUrl: 'login.jsp',
      controller:'LoginController',
	  controllerAs: 'ctrl'
    })
    .state('teams',{
    	url:'/teams',
    	templateUrl:'team.jsp',
		controller:'TeamController',
		controllerAs: 'ctrl',
		authenticated:true
    })
    .state('project',{
    	url:'/project',
    	templateUrl:'project.jsp',
		controller:'ProjectController',
		controllerAs:'pctrl',
		authenticated:true
    })
    .state('admin',{
    	url:'/admin',
    	templateUrl:'admin.jsp',
		controller:'ResourceController',
		controllerAs: 'ctrl',
		authenticated:true
    })
    .state('resource',{
    	url:'/resource/:no',
    	templateUrl:"admin.jsp",
		controller:"ResourceController",
		controllerAs: "ctrl",
		authenticated:true
    });
});


App.run(function($state,$location,$rootScope,Login,ProjectService){
	
	$rootScope.$on('$stateChangeStart',function(event,next,current,previous){
		
		console.log(event)
		console.log(next)
		console.log(current)
		console.log(previous)
		if(next.url == '/admin'){
			
			if(Login.getPermission() == 'USER')
				{
					alert("Access denied !!")
					$state.transitionTo(previous.name);
				}
		}
		
		if(next.url == '/admin' && previous.url=='/project')
		{
		if(!confirm("are you sure that you want to leave this page ?"))
			{
				event.preventDefault()
			}
		else{
				
				
			    ProjectService.deleteProject();
				ProjectService.deleteTeam();
			    
			    
			}
		}
		
		if(next.url == '/teams' && previous.url=='/project')
		{
		if(!confirm("are you sure that you want to leave this page ?"))
			{
				event.preventDefault()
			}
		else{
				
			    ProjectService.deleteProject();
			    ProjectService.deleteTeam();
			    
			}
		}
		
		
		
		
	})
	
	
	$rootScope.$on('$stateChangeSuccess',function(event,next,current,previous){
		
		
		/*if(next.url == '/admin'){
			
			if(Login.getPermission() == 'USER')
				{
					//alert("Access denied !!")
					$state.transitionTo(previous.name);
				}
		}*/
		
		if(next.authenticated){
			
			if(!Login.getAuthStatus())
				{
					$state.transitionTo('login');
				}
			
		}
		if(next.url == '/'){
			
			if(Login.getAuthStatus())
				{
					$state.transitionTo(previous.name);
				}
		}
		
		
		
	})
	
	
	
});


