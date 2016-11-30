angular.module("overallModule").service("overallService", ['$http', function( $http ){
	
	var self = this;
	
	self.getResults = function( reqUrl ){
		return $http.get( reqUrl );
	};
	
}]);