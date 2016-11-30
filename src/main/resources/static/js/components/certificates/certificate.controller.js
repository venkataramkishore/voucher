angular.module("certificateModule").controller("certificateCtrl", ['$scope', 'certificateService', 'companyService', 'applicationService', 
                                                                   function($scope, certificateService, companyService, applicationService){
	$scope.certificateList = [];
	$scope.filteredList = [];
	
	$scope.currCertificate={};
	$scope.companyList = [];
	$scope.editOpr = false;
	//pagination logic starts
	$scope.selected = [];

	$scope.filter = {
		    options: {
		      debounce: 500
		    }
		  };

		  $scope.query = {
		    filter: '',
		    limit: '10',
		    order: 'name',
		    page: 1
		  };
	  $scope.limitOptions = [5, 10, 15, {
		  label: 'All',
		  value: function () {
		    return $scope.certificateList.length;
		  }
		}];
	//pagination logic ends
	
	  $scope.fetchCompanyList = function () {
		  companyService.fetchCompanyList()
		  .then(function(response){
				var status = response.data.status;
				if(angular.isDefined(status) && angular.equals(status, "success")){
					$scope.companyList = response.data.successResponse;
				}else {
					$scope.companyList = [];
					applicationService.showToast("No Company(s) to show.");
				}
			}, function(error){
				$scope.companyList = [];
				if(error.status == 401){
    				applicationService.redirectToLogin();
    			}else {
    				console.error(error);
    			}
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
					applicationService.showToast("No Certificate(s) to show.");
				}
			}, function(error){
				$scope.certificateList = [];
				if(error.status == 401){
    				applicationService.redirectToLogin();
    			}else {
    				console.error(error);
    			}
			});
	};
	$scope.getPaginatedCertificateList = function () {
		return $scope.certificateList;
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