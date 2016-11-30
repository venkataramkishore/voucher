angular.module("parameterModule").directive("parameterForm", function () {
    return {
        restrict: 'E', //E = element, A = attribute, C = class, M = comment         
        scope:{
        	parameter:'=',
        	editOpr:'='
        },
        templateUrl: 'js/components/parameters/parameter.form.directive.html',
        controller: ['$scope','parameterService', 'applicationService', function($scope, parameterService, applicationService) {
        	
        	$scope.create = function() {
        		parameterService.saveParameter( $scope.parameter ).
        		then(function(response){
        			var status = response.data.status;
    				if(angular.isDefined(status) && angular.equals(status, "success")){
    					$scope.reset();
    					$scope.$parent.getParameterList();
    				}else {
    					applicationService.showToast('Parameter create error '+response.data.failureResponse);
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
        		parameterService.updateParameter(  $scope.parameter ).
        		then(function(response){
        			var status = response.data.status;
    				if(angular.isDefined(status) && angular.equals(status, "success")){
    					$scope.reset();
    					$scope.$parent.getParameterList();
    				}else {
    					applicationService.showToast('Parameter update error '+response.data.failureResponse);
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
        		$scope.parameter={};
        		$scope.editOpr = false;
        	};
        
        }],
        link: function ($scope, element, attrs) { 
        	
        } //DOM manipulation
    }
});