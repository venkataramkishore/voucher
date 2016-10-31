angular.module("parameterModule").directive("parameterForm", function () {
    return {
        restrict: 'E', //E = element, A = attribute, C = class, M = comment         
        scope:{
        	parameter:'=',
        	administrators:'='
        },
        templateUrl: 'js/components/parameters/parameter.form.directive.html',
        controller: ['$scope','parameterService', function($scope, parameterService) {
        	$scope.tabs = [
        	               { title:'AM Hours' },
        	               { title:'KT Hours'},
        	               { title:'Fixed Hours' }
        	             ];
        	
        	$scope.save = function() {
        		parameterService.save().
        		then(function(response){
        			var status = response.data.status;
    				if(angular.defined(status) && angular.equals(status, "success")){
    					$scope.parameter = {};
    					$parent.getparameterList();
    				}else {
    					$scope.parameterList = [];
    					console.log("success : " + response.data.failureResponse);
    				}
        		}, function(error){
        			
        		});
        	};
        
        }],
        link: function ($scope, element, attrs) { 
        	
        } //DOM manipulation
    }
});