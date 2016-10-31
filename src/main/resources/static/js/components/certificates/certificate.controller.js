angular.module("certificateModule").controller("certificateCtrl", ['$scope', 'certificateService', function($scope, certificateService){
	$scope.certificateList = [];
	$scope.filteredList = [];
	
	$scope.currCertificate={};
	$scope.administrators = [];
	
	//pagination logic starts
	  $scope.currentPage = 1;
	
	  $scope.setPage = function (pageNo) {
	    $scope.currentPage = pageNo;
	  };
	
	  $scope.pageChanged = function() {
		   console.log('Page changed to: ' + $scope.currentPage);
	  };
	
	  $scope.maxSize = 10;
	//pagination logic ends
	
	$scope.getCertificateList = function () {
		certificateService.fetchCertificateList()
			.then(function(response){
				var status = response.data.status;
				if(angular.isDefined(status) && angular.equals(status, "success")){
					$scope.certificateList = response.data.successResponse;
					$scope.totalItems= $scope.certificateList.length;
					console.log("success : " + response.data.successResponse);
				}else {
					$scope.certificateList = [];
					console.log("failure : " + response.data.failureResponse);
				}
			}, function(error){
				$scope.certificateList = [];
				console.error(error);
			});
	};

	//load list of companies available.
	$scope.getCertificateList();
}]);