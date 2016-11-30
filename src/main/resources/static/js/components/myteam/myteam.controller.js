angular.module("myteamModule").controller("myteamCtrl", [ '$scope', 'myteamService', 'companyService', 'employeeService', 'certificateService', 'applicationService', 
                                                          function ($scope, myteamService, companyService, employeeService, certificateService, applicationService){
	
	$scope.companyList = [];
	$scope.selectedCompany;
	
	$scope.pendingExamList=[];
	$scope.examResultList=[];
	
	$scope.employeeList = [];
	$scope.selectedEmp ;
	
	$scope.certificateList=[];
	$scope.selectedCertificate;
	
	$scope.getCertificateList = function () {
		certificateService.fetchCertificateList()
			.then(function(response){
				var status = response.data.status;
				if(angular.isDefined(status) && angular.equals(status, "success")){
					$scope.certificateList = response.data.successResponse;
				}else {
					$scope.certificateList = [];
				}
			}, function(error){
				$scope.certificateList = [];
				if(error.status == 401){
    				applicationService.redirectToLogin();
    			}else {
    				console.error(error);
    			}
			});
	};
	
	$scope.fetchEmployeeList = function () {
		employeeService.fetchMyActiveEmployeeList()
		.then(function(response){
			var status = response.data.status;
			if(angular.isDefined(status) && angular.equals(status, "success")){
				$scope.employeeList = response.data.successResponse;
			}else {
				$scope.employeeList = [];
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
	
	$scope.getCompanyList = function () {
		companyService.fetchCompanyList()
			.then(function(response){
				var status = response.data.status;
				if(angular.isDefined(status) && angular.equals(status, "success")){
					$scope.companyList = response.data.successResponse;
				}else {
					$scope.companyList = [];
				}
			}, function(error){
				$scope.companyList = [];
				if(error.status == 401){
    				applicationService.redirectToLogin();
    			}else {
    				console.error(error);
    			}
			});
	};
	
	$scope.getMonthList = function() {
		if( $scope.filterPerMonth ){
			if(angular.isUndefined($scope.monthList) || $scope.monthList.length == 0){
				myteamService.fetchResults("./monthlist")
				.then(function(response){
					var status = response.data.status;
					if(angular.isDefined(status) && angular.equals(status, "success")){
						$scope.monthList = response.data.successResponse;
					}else {
						$scope.monthList = [];
						applicationService.showToast("No Exam result(s) to show.");
					}
				}, function(error){
					$scope.monthList = [];
					if(error.status == 401){
						applicationService.redirectToLogin();
					}else {
						console.error(error);
					}
				});
			}
		}
		
	};
	
	$scope.changeEmployee = function () {
		$scope.selectedEmp;
		var url = "./";
		if(angular.isDefined($scope.selectedEmp)){
			if(angular.equals($scope.selectedEmp, "*")){
				url = url+"-1";
			}else if($scope.selectedEmp.id > 0 ){
				url = url+$scope.selectedEmp.id;
			}
			myteamService.fetchResults(url)
			.then(function(response){
				var status = response.data.status;
				if(angular.isDefined(status) && angular.equals(status, "success")){
					$scope.examResultList = response.data.successResponse;
				}else {
					$scope.examResultList = [];
					applicationService.showToast("No Exam result(s) to show.");
				}
			}, function(error){
				$scope.examResultList = [];
				if(error.status == 401){
    				applicationService.redirectToLogin();
    			}else {
    				console.error(error);
    			}
			});
		}
	};
	
	$scope.changeCertificate = function () {
		$scope.selectedCertificate;
		var url = "./employeespendingexamlist/";
		if(angular.isDefined($scope.selectedCertificate)){
			if(angular.equals($scope.selectedCertificate, "*")){
				url = url+"-1";
			}else if($scope.selectedCertificate.id > 0 ){
				url = url+$scope.selectedCertificate.id;
			}
			myteamService.fetchResults(url)
			.then(function(response){
				var status = response.data.status;
				if(angular.isDefined(status) && angular.equals(status, "success")){
					$scope.examResultList = response.data.successResponse;
				}else {
					$scope.examResultList = [];
					applicationService.showToast("No Exam result(s) to show.");
				}
			}, function(error){
				$scope.examResultList = [];
				if(error.status == 401){
    				applicationService.redirectToLogin();
    			}else {
    				console.error(error);
    			}
			});
		}
	};
	
	$scope.changeCompany = function () {
		$scope.selectedCompany;
		var url = "./employeespendingexamlist/";
		if(angular.isDefined($scope.selectedCompany)){
			if(angular.equals($scope.selectedCompany, "*")){
				url = url+"-1";
			}else if($scope.selectedCompany.id > 0 ){
				url = url+$scope.selectedCompany.id;
			}
			myteamService.fetchResults(url)
			.then(function(response){
				var status = response.data.status;
				if(angular.isDefined(status) && angular.equals(status, "success")){
					$scope.pendingExamList = response.data.successResponse;
				}else {
					$scope.pendingExamList = [];
					applicationService.showToast("No Pending Exam(s) to show.");
				}
			}, function(error){
				$scope.pendingExamList = [];
				if(error.status == 401){
    				applicationService.redirectToLogin();
    			}else {
    				console.error(error);
    			}
			});
		}
	};
	
	$scope.getCompanyList();
	$scope.getCertificateList();
	$scope.fetchEmployeeList();
	
	
}]);

