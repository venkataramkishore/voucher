angular.module("overallModule").controller("overallCtrl", ['$scope', 'overallService', function( $scope, overallService ) {
	
	//pagination logic starts
	$scope.filter = {
		    options: {
		      debounce: 500
		    }
		  };

		  $scope.query = {
		    filter: '',
		    limit: '5',
		    order: '',
		    page: 1
		  };
		  $scope.limitOptions = [5, 10, 15, {
			  label: 'All',
			  value: function () {
			    return $scope.allPendingExamList.length;
			  }
			}];
	//pagination logic ends
		  
	$scope.allPendingExamList = [];
	$scope.expiringVouchers = [];
	$scope.successCertCntList = [];
	
	$scope.getAllPendingExamList = function () {
		overallService.getResults("./allpendingexamlist")
		.then(function(response){
			var status = response.data.status;
			if(angular.isDefined(status) && angular.equals(status, "success")){
				$scope.allPendingExamList = response.data.successResponse;
				
			}else {
				$scope.allPendingExamList = [];
			}
		}, function(error){
			$scope.allPendingExamList = [];
			if(error.status == 401){
				applicationService.redirectToLogin();
			}else {
				console.error(error);
			}
		});
	};
	
	$scope.getSoonExpiringVouchers = function () {
		overallService.getResults("./expiringvouchers")
		.then(function(response){
			var status = response.data.status;
			if(angular.isDefined(status) && angular.equals(status, "success")){
				$scope.expiringVouchers = response.data.successResponse;
			}else {
				$scope.expiringVouchers = [];
			}
		}, function(error){
			$scope.expiringVouchers = [];
			if(error.status == 401){
				applicationService.redirectToLogin();
			}else {
				console.error(error);
			}
		});
	};
	
	$scope.getSuccessCertCntList = function () {
		overallService.getResults("./certificatecountlist")
		.then(function(response){
			var status = response.data.status;
			if(angular.isDefined(status) && angular.equals(status, "success")){
				$scope.successCertCntList = response.data.successResponse;
			}else {
				$scope.successCertCntList = [];
			}
		}, function(error){
			$scope.successCertCntList = [];
			if(error.status == 401){
				applicationService.redirectToLogin();
			}else {
				console.error(error);
			}
		});
		
	};
	
	$scope.getAllPendingExamList();
	$scope.getSoonExpiringVouchers();
	$scope.getSuccessCertCntList();
	
}]);