angular.module("homeModule").service("homeService", ['$http', function($http){
	
	var self = this;
	
	self.fetchIssuedCertificateList = function () {
		return $http.get("./issuecertificates");
	};
	
	self.saveCertificate = function (data) {
		return $http.post("./certificate", data);
	};

}]);