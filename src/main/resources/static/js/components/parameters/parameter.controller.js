angular.module("parameterModule").controller("parameterCtrl", ['$scope', 'parameterService', function($scope, parameterService){
	$scope.parameterList = [];
	
	$scope.currParameter={};
	$scope.administrators = [];
	
	$scope.getParameterList = function () {
		parameterService.fetchParameterList()
			.then(function(response){
				var status = response.data.status;
				if(angular.isDefined(status) && angular.equals(status, "success")){
					$scope.parameterList = response.data.successResponse;
					console.log("success : " + response.data.successResponse);
				}else {
					$scope.parameterList = [];
					console.log("success : " + response.data.failureResponse);
				}
			}, function(error){
				$scope.parameterList = [];
				console.error(error);
			});
	};

	//load list of companies available.
	$scope.getParameterList();
}]);