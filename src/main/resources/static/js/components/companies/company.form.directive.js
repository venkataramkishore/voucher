angular.module("companyModule").directive("companyForm", function () {
    return {
        restrict: 'E', //E = element, A = attribute, C = class, M = comment         
        scope:{
        	company:'=',
        	editOpr:'='
        },
        templateUrl: 'js/components/companies/company.form.directive.html',
        controller: ['$scope','companyService', 'employeeService','applicationService', 
                     function($scope, companyService, employeeService, applicationService) {
        	
        	$scope.activeList = [{key:'Active', value:'ACTIVE'}, {key:'Inactive', value:'INACTIVE'}];
        	
        	$scope.managerList = [];
        	$scope.fetchAdmins = function(){
        		employeeService.fetchAdminList()
        		.then(function(response){
        			var status = response.data.status;
        			if(angular.isDefined(status) && angular.equals(status, "success")){
        				$scope.managerList = response.data.successResponse;
        			}else {
        				$scope.managerList = [];
        				applicationService.showToast("No Admin(s) to show.");
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
        	
        	$scope.fetchAdmins();
        	
        	$scope.create = function() {
        		companyService.saveCompany().
        		then(function(response){
        			var status = response.data.status;
    				if(angular.defined(status) && angular.equals(status, "success")){
    					$scope.reset();
    					$scope.$parent.getCompanyList();
    				}else {
    					applicationService.showToast("Unable to create Company : " + response.data.failureResponse);
    				}
        		}, function(error){
        			if(error.status == 401){
        				applicationService.redirectToLogin();
        			}else {
        				console.error(error);
        			}
        		});
        	};
        	$scope.update = function() {
        		companyService.updateCompany().
        		then(function(response){
        			var status = response.data.status;
    				if(angular.defined(status) && angular.equals(status, "success")){
    					$scope.reset();
    					$scope.$parent.getCompanyList();
    				}else {
    					applicationService.showToast("Unable to create Company : " + response.data.failureResponse);
    				}
        		}, function(error){
        			if(error.status == 401){
        				applicationService.redirectToLogin();
        			}else {
        				console.error(error);
        			}
        		});
        	};
        	
        	$scope.reset = function() {
        		$scope.company={};
        		$scope.editOpr = false;
        	};
        }],
        link: function ($scope, element, attrs) { 
        	
        } //DOM manipulation
    }
});