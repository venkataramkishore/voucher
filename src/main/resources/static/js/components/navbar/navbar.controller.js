angular.module("navbarModule").controller("navbarCtrl", ['$scope', '$rootScope', '$http', '$location', function($scope, $rootScope, $http, $location){
	
	$rootScope.authenticated = false;
	
	$scope.menuList = [
	                   //{key:'login', name:'Login', link:'#/login', iconTag:'fa fa-sign-in', expose:true, auth:false, dropdown:false, dropdownItems:[]},
	                   {key:'home', name:'Home', link:'#/home', iconTag:'fa fa-home', expose:true, auth:true, dropdown:false, 
	                	   dropdownItems:[]},
	                   {key:'team', name:'Team', link:'', iconTag:'fa fa-users fa-fw', expose:true, auth:true, dropdown:true, 
	                	   dropdownItems:[
	                	                  {key:'myteam', name:'My Team', link:'#/myteam', iconTag:'fa fa-handshake-o', expose:true, auth:true, dropdown:false, dropdownItems:[]},
	                                      {key:'teamhome', name:'Activities', link:'#/teamactivities', iconTag:'fa fa-pencil-square-o', expose:true, auth:false, dropdown:false, dropdownItems:[]},
	                                      {key:'teamoverall', name:'Overall', link:'#/teamoverall', iconTag:'fa fa-book', expose:true, auth:false, dropdown:false, dropdownItems:[]}
	                                     ]
	                   },
	                   {key:'administrator', name:'Administrator', link:undefined, iconTag:'fa fa-cog fa-fw', expose:true, auth:true, dropdown:true, 
	                	   dropdownItems:[
	                	                  {key:'appparameters', name:'Application Parameters', link:'#/parameters', iconTag:'fa fa-pencil fa-fw', expose:true, auth:true, dropdown:false, dropdownItems:[]},
	                                      {key:'companies', name:'Companies', link:'#/companies', iconTag:'fa fa-globe fa-fw', expose:true, auth:true, dropdown:false, dropdownItems:[]},
	                                      {key:'employees', name:'Employees', link:'#/employees', iconTag:'fa fa-users fa-fw', expose:true, auth:true, dropdown:false, dropdownItems:[]},
	                                      {key:'certificates', name:'Certificates', link:'#/certificates', iconTag:'fa fa-certificate fa-fw', expose:true, auth:true, dropdown:false, dropdownItems:[]},
	                                      {key:'purchaseorders', name:'Purchase orders', link:'#/purchaseorders', iconTag:'fa fa-cart-arrow-down fa-fw', expose:true, auth:true, dropdown:false, dropdownItems:[]},
	                                      {key:'vouchers', name:'Vouchers', link:'#/vouchers', iconTag:'fa fa-folder-open fa-fw', expose:true, auth:true, dropdown:false, dropdownItems:[]},
	                                      {key:'emailtemplates', name:'E-mail Templates', link:'#/emailtemplates', iconTag:'fa fa-envelope-o fa-fw', expose:true, auth:true, dropdown:false, dropdownItems:[]},
	                                      {key:'addemployee', name:'Add Employee', link:'#/addemployee', iconTag:'fa fa-user-plus fa-fw', expose:true, auth:true, dropdown:false, dropdownItems:[]},
	                                     ]
	                   },
	                   {key:'logout', name:'Logout', link:'#/logout', iconTag:'fa fa-sign-out', expose:true, auth:true, dropdown:false, dropdownItems:[]},
	                   ];
	



	  var authenticate = function(credentials, callback) {

	    var headers = credentials ? {authorization : "Basic "
	        + btoa(credentials.username + ":" + credentials.password)
	    } : {};

	    $http.get('user', {headers : headers}).then(function(response) {
	      if (response.data.name) {
	        $rootScope.authenticated = true;
	      } else {
	        $rootScope.authenticated = false;
	      }
	      callback && callback();
	    }, function() {
	      $rootScope.authenticated = false;
	      callback && callback();
	    });

	  }

	  //authenticate();
	  $scope.credentials = {username:"", password:""};
	  
	  $scope.login = function() {
	      authenticate($scope.credentials, function() {
	        if ($rootScope.authenticated) {
	          $location.path("/home");
	          $scope.error = false;
	        } else {
	          $location.path("/login");
	          $scope.error = true;
	        }
	      });
	  };
	  
	  $scope.logout = function() {
		  $http.post('logout', {}).finally(function() {
		    $rootScope.authenticated = false;
		    $location.path("/login");
		  });
		};
		
	
}]);