<div class="container">
  <div class="row">
    <div class="Absolute-Center is-Responsive">
      <div class="panel panel-primary " >
      	  <div class="panel-heading"><span style="padding-left: 1.3cm;">RESOURCE MANAGEMENT</span></div>
	      <div class="col-sm-12 col-md-10 col-md-offset-1">
	      
		      <div class="panel-body" >
		        <div class="has-error">{{ctrl.message}}</div>
		        <form ng-submit="ctrl.getCredentials()" name="loginForm">
		          
		          <div class="form-group input-group">
		            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
		            <input class="form-control" ng-model="ctrl.user.username"type="text" name='username' placeholder="username" required ng-minlength="3"/>          	
		          </div>
		          <div class="has-error" ng-show="loginForm.$dirty">
						  <span ng-show="loginForm.username.$error.required">This is a required field</span>
                                <span ng-show="loginForm.username.$error.minlength">Minimum length required is 3</span>
				  </div>
		          
		          <div class="form-group input-group">
		            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
		            <input class="form-control" ng-model="ctrl.user.password" type="password" name='password' placeholder="password" required ng-minlength="3"/>     	
		          </div>
		          <div class="has-error" ng-show="loginForm.$dirty">
					  <span ng-show="loginForm.password.$error.required">This is a required field</span>
                            <span ng-show="loginForm.password.$error.minlength">Minimum length required is 3</span>
				  </div>
		          <div class="form-group">
		          	<input type="submit"  value="LOGIN" class="btn btn-info btn-block" ng-disabled="loginForm.$invalid">
		          </div>
		          
		        </form>
		                
		      </div>
		       
	      </div>
	 </div> 
    </div>    
  </div>
</div>
