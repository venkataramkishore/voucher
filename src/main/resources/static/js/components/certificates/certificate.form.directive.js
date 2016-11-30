angular.module("certificateModule").directive("certificateForm", function () {
    return {
        restrict: 'E', //E = element, A = attribute, C = class, M = comment         
        scope:{
        	certificate:'=',
        	companyList:'=',
        	editOpr:"=",
        	fetchList:"&"
        },
        templateUrl: 'js/components/certificates/certificate.form.directive.html',
        controller: ['$scope','certificateService', '$mdToast', 'applicationService', 
                     function($scope, certificateService, $mdToast, applicationService) {
        	
        	$scope.statusList = [{key:'Issued', value:'ISSUED'}, {key:'Discontinued', value:'DISCONTINUED'}];
        	
        	$scope.update = function() {
        		certificateService.updateCertificate( $scope.certificate )
        		 .then(function(response){
     				var status = response.data.status;
     				if(angular.isDefined(status) && angular.equals(status, "success")){
     					applicationService.showToast('Updated Succesfully..!!');
     					$scope.$parent.getCertificateList();
     					$scope.reset();
     				}else {
     					applicationService.showToast('Certificate Error' + response.data.failureResponse);
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
        		certificateService.saveCertificate( $scope.certificate )
        		 .then(function(response){
      				var status = response.data.status;
      				if(angular.isDefined(status) && angular.equals(status, "success")){
      					applicationService.showToast('Created Succesfully..!!');
      					$scope.$parent.getCertificateList();
      					$scope.reset();
      				}else {
      					applicationService.showToast('Certificate Error '+response.data.failureResponse);
      				}
      			}, function(error){
      				$scope.companyList = [];
      				applicationService.showToast("Error Unable to perform operation..!!");
      				if(error.status == 401){
        				applicationService.redirectToLogin();
        			}else {
        				console.error(error);
        			}
      			});
        	};
        	
        	$scope.reset = function() {
        		$scope.certificate={};
        		$scope.editOpr = false;
        	};
        
        }],
        link: function ($scope, element, attrs) { } //DOM manipulation
    }
});