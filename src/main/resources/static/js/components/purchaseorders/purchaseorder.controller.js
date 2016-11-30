angular.module("purchaseorderModule").controller("purchaseorderCtrl", ['$scope', '$location', 'purchaseorderService', 'applicationService', 
                                                                       function($scope, $location, purchaseorderService, applicationService){
	
	$scope.purchaseorderList = [];
	$scope.selectedPOrder=null;
	$scope.vouchers = null;
	
	//pagination logic starts
	$scope.filter = {
		    options: {
		      debounce: 500
		    }
		  };

		  $scope.query = {
		    filter: '',
		    limit: '25',
		    order: 'username',
		    page: 1
		  };
		  $scope.limitOptions = [5, 10, 15, {
			  label: 'All',
			  value: function () {
			    return $scope.purchaseorderList.length;
			  }
			}];
	//pagination logic ends

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
				if(error.status == 401){
    				applicationService.redirectToLogin();
    			}else {
    				console.error(error);
    			}
			});
		}
	};
	
	$scope.exportXLSData = function () {
		var absUrl = $location.absUrl().substring(0, $location.absUrl().indexOf('#'));
		console.log(absUrl);
		window.open(absUrl+ '/povouchersxls/'+$scope.selectedPOrder.code+'/'+$scope.selectedPOrder.orderdate);
		
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
			if(error.status == 401){
				applicationService.redirectToLogin();
			}else {
				console.error(error);
			}
		});
	};
	$scope.fetchPurchaseorderList();
}]);
