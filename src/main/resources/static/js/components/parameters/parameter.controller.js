angular.module("parameterModule").controller("parameterCtrl", ['$scope', 'parameterService', 'applicationService', 
                                                               function($scope, parameterService, applicationService){
	$scope.parameterList = [];
	
	$scope.currParameter={};
	$scope.editOpr=false;
	
	//pagination logic starts
	$scope.filter = {
		    options: {
		      debounce: 500
		    }
		  };

		  $scope.query = {
		    filter: '',
		    limit: '5',
		    order: 'key',
		    page: 1
		  };
		  $scope.limitOptions = [5, 10, 15, {
			  label: 'All',
			  value: function () {
			    return $scope.parameterList.length;
			  }
			}];
	//pagination logic ends
		  
	$scope.getParameterList = function () {
		parameterService.fetchParameterList()
			.then(function(response){
				var status = response.data.status;
				if(angular.isDefined(status) && angular.equals(status, "success")){
					$scope.parameterList = response.data.successResponse;
					applicationService.showToast('Parameters list updated.');
				}else {
					$scope.parameterList = [];
					applicationService.showToast('Parameters list failure: '+response.data.failureResponse);
				}
			}, function(error){
				$scope.parameterList = [];
				if(error.status == 401){
    				applicationService.redirectToLogin();
    			}else {
    				console.error(error);
    			}
			});
	};

	$scope.editParameter = function ( parameter ) {
		$scope.editOpr = true;
		angular.merge($scope.currParameter, parameter );
	};
	//load list of companies available.
	$scope.getParameterList();
}]);