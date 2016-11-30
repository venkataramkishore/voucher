angular.module("parameterModule").service("parameterService", ['$http', function($http){
	
	var self = this;
	
	self.fetchParameterList = function () {
		return $http.get("./parameters");
	};
	
	self.saveParameter = function (data) {
		return $http.post("./parameter", data);
	};
	
	self.getParameter = function ( compId ) {
		return $http.get("./parameter/"+compId);
	};
	
	self.updateParameter = function (data) {
		return $http.put("./parameter", data);
	};
	
}]);