angular.module("companyModule").controller("companyCtrl", ['$scope', 'companyService', function($scope, companyService){
	$scope.companyList = [];
	
	$scope.currCompany={};
	$scope.administrators = [];
	
	$scope.getCompanyList = function () {
		companyService.fetchCompanyList()
			.then(function(response){
				var status = response.data.status;
				if(angular.isDefined(status) && angular.equals(status, "success")){
					$scope.companyList = response.data.successResponse;
					console.log("success : " + response.data.successResponse);
				}else {
					$scope.companyList = [];
					console.log("success : " + response.data.failureResponse);
				}
			}, function(error){
				$scope.companyList = [];
				console.error(error);
			});
	};
	
	$scope.getAdministrators = function () {
		
	};
		
	//load list of companies available.
	$scope.getCompanyList();
}]);