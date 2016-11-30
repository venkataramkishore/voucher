angular
		.module('voucherApp')
		.controller(
				'home',
				[
				'$scope',
				'$rootScope',
				'$http',
				function($scope, $rootScope, $http) {
					var self = this;
					if ($rootScope.authenticated) {
						$http
								.get('/authenticate')
								.then(
										function(response) {
											var status = response.data.status;
											if (angular.isDefined(status)
													&& angular.equals(status,"success")) {
												$rootScope.user = response.data.successResponse;
												console.log("success : "+ response.data.successResponse);
											} else {
												$rootScope.user = {};
												console.log("success : "+ response.data.failureResponse);
											}

										}, function(error) {
											$rootScope.user = {};
										});
					}

		} ]).controller('error', function($http) {
			var self = this;
			$scope.message = "There is error processing your request.";
		});