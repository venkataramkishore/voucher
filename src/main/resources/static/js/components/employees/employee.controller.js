angular.module("employeeModule").controller("employeeCtrl", ['$scope','employeeService', function( $scope, employeeService) {
	
	$scope.employeeList=[];
	
	//pagination logic starts
	  $scope.currentPage = 1;
	
	  $scope.setPage = function (pageNo) {
	    $scope.currentPage = pageNo;
	  };
	
	  $scope.pageChanged = function() {
		   
	  };
	
	  $scope.maxSize = 25;
	//pagination logic ends
	  $scope.selectView="inservice";
	$scope.changeView = function ( view ) {
		$scope.selectView = view;
	};
	
	$scope.getEmployeeList = function () {
		employeeService.fetchEmployeeList()
		.then(function(response){
			var status = response.data.status;
			if(angular.isDefined(status) && angular.equals(status, "success")){
				$scope.employeeList = response.data.successResponse;
				$scope.totalItems= $scope.employeeList.length;
			}else {
				$scope.employeeList = [];
			}
		}, function(error){
			$scope.employeeList = [];
			console.error(error);
		});
	};
	
	$scope.getEmployeeList();
	
}]);