angular.module("certificateModule").controller("certificateCtrl", ['$scope', 'certificateService', 'companyService', function($scope, certificateService, companyService){
	$scope.certificateList = [];
	$scope.filteredList = [];
	
	$scope.currCertificate={};
	$scope.companyList = [];
	$scope.editOpr = false;
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
	
	  $scope.fetchCompanyList = function () {
		  companyService.fetchCompanyList()
		  .then(function(response){
				var status = response.data.status;
				if(angular.isDefined(status) && angular.equals(status, "success")){
					$scope.companyList = response.data.successResponse;
				}else {
					$scope.companyList = [];
				}
			}, function(error){
				$scope.companyList = [];
				console.error(error);
			});
	  };
	  
	$scope.getCertificateList = function () {
		certificateService.fetchCertificateList()
			.then(function(response){
				var status = response.data.status;
				if(angular.isDefined(status) && angular.equals(status, "success")){
					$scope.certificateList = response.data.successResponse;
					$scope.totalItems= $scope.certificateList.length;
				}else {
					$scope.certificateList = [];
				}
			}, function(error){
				$scope.certificateList = [];
				console.error(error);
			});
	};
	
	$scope.editCertificate = function( certificate ){
		$scope.editOpr = true;
		certificate.companyId = certificate.company.id;
		
		angular.merge($scope.currCertificate, certificate );
	};
	//load list of companies available.
	$scope.getCertificateList();
	$scope.fetchCompanyList();
}]);