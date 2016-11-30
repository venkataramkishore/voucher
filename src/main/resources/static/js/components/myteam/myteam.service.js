angular.module("myteamModule").service("myteamService", ['$http', function($http){
	
	var self = this;
	
	self.fetchResults = function ( reqUrl ) {
		return $http.get( reqUrl );
	};
}]);