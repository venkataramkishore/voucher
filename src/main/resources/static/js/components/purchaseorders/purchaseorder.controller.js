angular.module("purchaseorderModule").controller("purchaseorderCtrl", ['$scope', '$location', 'purchaseorderService', function($scope, $location, purchaseorderService){
	
	$scope.purchaseorderList = [];
	$scope.selectedPOrder=null;
	$scope.vouchers = null;
	
	$scope.poChange = function () {
		if( $scope.selectedPOrder ){
			purchaseorderService.fetchVouchers( $scope.selectedPOrder.code,  $scope.selectedPOrder.orderdate)
			.then(function(response){
				var status = response.data.status;
				if(angular.isDefined(status) && angular.equals(status, "success")){
					$scope.vouchers = response.data.successResponse;
					$scope.totalItems= $scope.vouchers.length;
				}else {
					$scope.vouchers = [];
				}
			}, function(error){
				$scope.vouchers = [];
				console.error(error);
			});
		}
	};
	
	$scope.exportXLSData = function () {
		var absUrl = $location.absUrl().substring(0, $location.absUrl().indexOf('#'));
		console.log(absUrl);
		window.open(absUrl+ '/povouchersxls/'+$scope.selectedPOrder.code+'/'+$scope.selectedPOrder.orderdate);
		/*purchaseorderService.exportXLSData($scope.selectedPOrder.code,  $scope.selectedPOrder.orderdate)
        .then(function (data, status, headers, config) {
            var blob = new Blob([data], {type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"});
            var objectUrl = URL.createObjectURL(blob);
            window.open(absUrl+ '/povouchersxls/'+code+'/'+orderDate);
        },function (data, status, headers, config) {
            //upload failed
        });*/
    };
    
    $scope.exportPDFData = function () {
    	var absUrl = $location.absUrl().substring(0, $location.absUrl().indexOf('#'));
		console.log(absUrl);
		window.open(absUrl+ '/povoucherspdf/'+$scope.selectedPOrder.code+'/'+$scope.selectedPOrder.orderdate);
		
    };
    
	$scope.fetchPurchaseorderList = function() {
		purchaseorderService.fetchPurchaseorderList()
		.then(function(response){
			var status = response.data.status;
			if(angular.isDefined(status) && angular.equals(status, "success")){
				$scope.purchaseorderList = response.data.successResponse;
			}else {
				$scope.purchaseorderList = [];
			}
		}, function(error){
			$scope.purchaseorderList = [];
			console.error(error);
		});
	};
	$scope.fetchPurchaseorderList();
}]);
