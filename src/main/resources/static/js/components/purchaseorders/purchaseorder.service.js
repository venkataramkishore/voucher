angular.module("purchaseorderModule").service("purchaseorderService", ['$http', function($http){
	
	var self = this;
	
	self.fetchPurchaseorderList = function () {
		return $http.get("/purchaseorders");
	};
	
	self.fetchVouchers = function (code, orderDate) {
		return $http.get('/povouchers/'+code+'/'+orderDate);
	};
	
	self.savePurchaseOrder = function ( data ) {
		return $http.post("/purchaseorders", data);
	};
	
}]);