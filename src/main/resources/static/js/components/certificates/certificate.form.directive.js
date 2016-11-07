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
        controller: ['$scope','certificateService', 'toastr',function($scope, certificateService, toastr) {
        	
        	$scope.statusList = [{key:'Issued', value:'ISSUED'}, {key:'Discontinued', value:'DISCONTINUED'}];
        	
        	$scope.update = function() {
        		certificateService.updateCertificate( $scope.certificate )
        		 .then(function(response){
     				var status = response.data.status;
     				if(angular.isDefined(status) && angular.equals(status, "success")){
     					toastr.success('Certificate', 'Updated Succesfully..!!');
     					$scope.$parent.getCertificateList();
     					$scope.reset();
     				}else {
     					$scope.companyList = [];
     					toastr.error('Certificate Error', response.data.failureResponse);
     				}
     			}, function(error){
     				$scope.companyList = [];
     				toastr.error('Error', "Unable to perform operation..!!");
     			});
        	};
        	
        	$scope.create = function () {
        		certificateService.saveCertificate( $scope.certificate )
        		 .then(function(response){
      				var status = response.data.status;
      				if(angular.isDefined(status) && angular.equals(status, "success")){
      					toastr.success('Certificate', 'Created Succesfully..!!');
      					$scope.$parent.getCertificateList();
      					$scope.reset();
      				}else {
      					$scope.companyList = [];
      					toastr.error('Certificate Error', response.data.failureResponse);
      				}
      			}, function(error){
      				$scope.companyList = [];
      				toastr.error('Error', "Unable to perform operation..!!");
      			});
        	};
        	
        	$scope.reset = function() {
        		$scope.certificate={};
        		$scope.editOpr = false;
        	};
        
        }],
        link: function ($scope, element, attrs) { 
        	console.log('running certificate link function');
        } //DOM manipulation
    }
});