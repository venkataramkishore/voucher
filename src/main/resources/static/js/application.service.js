angular.module("voucherApp").service("applicationService",['$mdToast', '$location', function($mdToast, $location){
	
	var self = this;
	
	self.showToast = function( message ) {
		$mdToast.show($mdToast.simple()
			        .textContent( message )
			        .hideDelay(3000));
	};
	
	self.redirectToLogin= function(){
		$location.path("./login");
	};
}]);