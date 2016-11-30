angular.module("homeModule").controller("homeCtrl", ['$scope', 'homeService', 'applicationService', 
                                                     function($scope, homeService, applicationService){
	$scope.certificateList = [];
		
	//pagination logic starts
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
	//Datepicker logic starts
		  $scope.myDate = new Date();
		  $scope.minDate = new Date();
		  $scope.maxDate = new Date(
		      $scope.myDate.getFullYear(),
		      $scope.myDate.getMonth(),
		      $scope.myDate.getDate() + 14);
	//Datepicker logic ends
	$scope.getIssuedCertificateList = function () {
		homeService.fetchIssuedCertificateList()
			.then(function(response){
				var status = response.data.status;
				if(angular.isDefined(status) && angular.equals(status, "success")){
					$scope.certificateList = response.data.successResponse;
				}else {
					$scope.certificateList = [];
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
	
	//load list of issued certificates available.
	$scope.getIssuedCertificateList();
	
	
}]);