angular.module("certificateModule").service("certificateService", ['$http', function($http){
	
	var self = this;
	
	self.fetchCertificateList = function () {
		return $http.get("./certificates");
	};
	
	self.saveCertificate = function (data) {
		return $http.post("./certificate", data);
	};
	
	self.getCertificate = function ( compId ) {
		return $http.get("./certificate/"+compId);
	};
	
	self.updateCertificate = function (data) {
		return $http.put("./certificate", data);
	};
}]);