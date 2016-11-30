angular.module("employeeModule").controller("employeeCtrl", ['$scope','employeeService', 'applicationService', 
                                                             function( $scope, employeeService, applicationService) {
	
	$scope.employeeList=[];
	$scope.selectedEmployee={};
	
	//pagination logic starts
	$scope.filter = {
		    options: {
		      debounce: 500
		    }
		  };

		  $scope.query = {
		    filter: '',
		    limit: '25',
		    order: 'username',
		    page: 1
		  };
		  $scope.limitOptions = [25, 50, 75, 100, {
			  label: 'All',
			  value: function () {
			    return $scope.employeeList.length;
			  }
			}];
		 
	//pagination logic ends
	  $scope.selectView="inservice";
	$scope.changeView = function ( view ) {
		$scope.selectView = view;
	};
	
	$scope.editEmployee= function( emp ){
		$scope.editOpr = true;
		angular.merge($scope.selectedEmployee, emp );
	};
	
	
	$scope.getEmployeeList = function () {
		employeeService.fetchActiveEmployeeList()
		.then(function(response){
			var status = response.data.status;
			if(angular.isDefined(status) && angular.equals(status, "success")){
				$scope.employeeList = response.data.successResponse;
			}else {
				$scope.employeeList = [];
				applicationService.showToast("No Employee(s) to show.");
			}
		}, function(error){
			$scope.employeeList = [];
			if(error.status == 401){
				applicationService.redirectToLogin();
			}else {
				console.error(error);
			}
		});
	};
	
	$scope.getEmployeeList();
	
}]);