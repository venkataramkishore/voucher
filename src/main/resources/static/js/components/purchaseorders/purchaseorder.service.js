angular.module("purchaseorderModule").service("purchaseorderService", ['$http', function($http){
	
	var self = this;
	
	self.fetchPurchaseorderList = function () {
		return $http.get("/purchaseorders");
	};
	
	self.fetchVouchers = function (code, orderDate) {
		return $http.get('/povouchers/'+code+'/'+orderDate);
	};
	
	self.exportXLSData= function (code, orderDate) {
		//$window.open($location.path+'/povouchersxls/'+code+'/'+orderDate));
		return $http({
		    url: '/povouchersxls/'+code+'/'+orderDate,
		    method: "GET",
		    headers: {
		       'Content-type': 'application/json'
		    },
		    responseType: 'arraybuffer'
		});
	};
	
	self.exportPDFData= function (code, orderDate) {
		return $http({
			    url: '/povoucherspdf/'+code+'/'+orderDate,
			    method: "GET",
			    headers: {
			       'Content-type': 'application/json'
			    },
			    responseType: 'arraybuffer'
			});
	};
	
	self.savePurchaseOrder = function ( data ) {
		return $http.post("/purchaseorders", data);
	};
	
}]);