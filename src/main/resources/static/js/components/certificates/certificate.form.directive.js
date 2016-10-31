angular.module("certificateModule").directive("certificateForm", function () {
    return {
        restrict: 'E', //E = element, A = attribute, C = class, M = comment         
        scope:{
        	certificate:'=',
        	administrators:'='
        },
        templateUrl: 'js/components/certificates/certificate.form.directive.html',
        controller: ['$scope','certificateService', function($scope, certificateService) {
        	$scope.tabs = [
        	               { title:'AM Hours' },
        	               { title:'KT Hours'},
        	               { title:'Fixed Hours' }
        	             ];
        	
        	$scope.save = function() {
        		certificateService.save().
        		then(function(response){
        			var status = response.data.status;
    				if(angular.defined(status) && angular.equals(status, "success")){
    					$scope.certificate = {};
    					$parent.getCertificateList();
    				}else {
    					$scope.certificateList = [];
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