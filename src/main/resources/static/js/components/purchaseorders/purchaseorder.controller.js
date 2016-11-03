angular.module("purchaseorderModule").controller("purchaseorderCtrl", ['$scope','purchaseorderService', function($scope, purchaseorderService){
	
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
        var blob = new Blob([document.getElementById('exportable').innerHTML], {
            type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
        });
        saveAs(blob, $scope.selectedPOrder.code+"-"+$scope.selectedPOrder.orderdate+".xls");
    };
    $scope.exportPDFData = function () {
        var blob = new Blob([document.getElementById('exportable').innerHTML], {
            type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
        });
        saveAs(blob, $scope.selectedPOrder.code+"-"+$scope.selectedPOrder.orderdate+".pdf");
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
