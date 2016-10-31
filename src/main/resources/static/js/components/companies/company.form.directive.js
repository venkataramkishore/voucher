angular.module("companyModule").directive("companyForm", function () {
    return {
        restrict: 'E', //E = element, A = attribute, C = class, M = comment         
        scope:{
        	company:'=',
        	administrators:'='
        },
        templateUrl: 'js/components/companies/company.form.directive.html',
        controller: ['$scope','companyService', function($scope, companyService) {
        	$scope.tabs = [
        	               { title:'AM Hours' },
        	               { title:'KT Hours'},
        	               { title:'Fixed Hours' }
        	             ];
        	
        	$scope.save = function() {
        		companyService.save().
        		then(function(response){
        			var status = response.data.status;
    				if(angular.defined(status) && angular.equals(status, "success")){
    					$scope.company = {};
    					$parent.getCompanyList();
    				}else {
    					$scope.companyList = [];
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