angular.module("companyModule").controller("companyCtrl", ['$scope', 'companyService', 'applicationService', 
                                                           function($scope, companyService, applicationService){
	$scope.companyList = [];
	
	$scope.currCompany={};
	$scope.editOpr = false;
	
	//pagination logic starts
	$scope.filter = {
		    options: {
		      debounce: 500
		    }
		  };

		  $scope.query = {
		    filter: '',
		    limit: '5',
		    order: 'name',
		    page: 1
		  };
		  $scope.limitOptions = [5, 10, 15, {
			  label: 'All',
			  value: function () {
			    return $scope.companyList.length;
			  }
			}];
	//pagination logic ends
	$scope.getCompanyList = function () {
		companyService.fetchCompanyList()
			.then(function(response){
				var status = response.data.status;
				if(angular.isDefined(status) && angular.equals(status, "success")){
					$scope.companyList = response.data.successResponse;
				}else {
					$scope.companyList = [];
					applicationService.showToast("No company(s) to show.");
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
	
	$scope.editCompany = function ( company ) {
		$scope.editOpr = true;
		angular.merge($scope.currCompany, company);
	};
	
	$scope.deleteCompany = function ( company ) {
		companyService.deleteCompany( company )
		.then(function(response){
			var status = response.data.status;
			if(angular.isDefined(status) && angular.equals(status, "success")){
				$scope.getCompanyList();
				applicationService.showToast("Company deleted ..!");
			}else {
				applicationService.showToast("No company(s) to show.");
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
	//load list of companies available.
	$scope.getCompanyList();
}]);