angular.module("employeeModule").directive("employeeForm", function () {
    return {
        restrict: 'E', //E = element, A = attribute, C = class, M = comment         
        scope:{
        	employee:'=',
        	editOpr:"="
        },
        templateUrl: 'js/components/employees/employee.form.directive.html',
        controller: ['$scope','employeeService', 'applicationService',function($scope, employeeService, applicationService) {
        	
        	$scope.serviceList = [{key:'InService', value:'IN_SERVICE'}, {key:'OutService', value:'OUT_SERVICE'}];
        	$scope.roleList = [{key:'Employee', value:'ROLE_EMPLOYEE'}, {key:'Unit Manager', value:'ROLE_UNIT_MANAGER'}, {key:'Administrator', value:'ROLE_ADMINISTRATOR'}];
        	
        	$scope.fetchManagers = function(){
        		employeeService.fetchManagerList()
        		.then(function(response){
        			var status = response.data.status;
        			if(angular.isDefined(status) && angular.equals(status, "success")){
        				$scope.managerList = response.data.successResponse;
        			}else {
        				$scope.managerList = [];
        				applicationService.showToast("No Manager(s) to show.");
        			}
        		}, function(error){
        			$scope.managerList = [];
        			if(error.status == 401){
        				applicationService.redirectToLogin();
        			}else {
        				console.error(error);
        			}
        				
        		});
        	};
        	
        	$scope.fetchManagers();
        	
        	$scope.update = function() {
        		employeeService.updateEmployee( $scope.employee )
        		 .then(function(response){
     				var status = response.data.status;
     				if(angular.isDefined(status) && angular.equals(status, "success")){
     					applicationService.showToast('Updated Succesfully..!!');
     					$scope.$parent.getEmployeeList();
     					$scope.reset();
     				}else {
     					applicationService.showToast('Employee update error' + response.data.failureResponse);
     				}
     			}, function(error){
     				applicationService.showToast('Error Unable to perform operation..');
     				if(error.status == 401){
        				applicationService.redirectToLogin();
        			}else {
        				console.error(error);
        			}
     			});
        	};
        	
        	$scope.create = function () {
        		employeeService.saveEmployee( $scope.employee )
        		 .then(function(response){
      				var status = response.data.status;
      				if(angular.isDefined(status) && angular.equals(status, "success")){
      					applicationService.showToast('Created Succesfully..!!');
      					$scope.$parent.getEmployeeList();
      					$scope.reset();
      				}else {
      					applicationService.showToast('Employee create error '+response.data.failureResponse);
      				}
      			}, function(error){
      				applicationService.showToast("Error Unable to perform operation..!!");
      				if(error.status == 401){
        				applicationService.redirectToLogin();
        			}else {
        				console.error(error);
        			}
      			});
        	};
        	
        	$scope.reset = function() {
        		$scope.employee={};
        		$scope.editOpr = false;
        	};
        
        }],
        link: function ($scope, element, attrs) { } //DOM manipulation
    }
});