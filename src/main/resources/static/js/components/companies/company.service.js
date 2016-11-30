angular.module("companyModule").service("companyService", ['$http', function($http){
	
	var self = this;
	
	self.fetchCompanyList = function () {
		return $http.get("./companies");
	};
	
	self.saveCompany = function (data) {
		return $http.post("./company", data);
	};
	
	self.getCompany = function ( compId ) {
		return $http.get("./company/"+compId);
	};
	
	self.getActiveCompanies = function(){
		return $http.get('./activecompanies');
	}
	self.updateCompany = function (data) {
		return $http.put("./company", data);
	};
	
	self.deleteCompany = function (data) {
		return $http.delete("./company/"+data.id);
	};
}]);