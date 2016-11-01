angular.module("employeeModule").service("employeeService",
		[ '$http', function($http) {

			var self = this;

			self.fetchEmployeeList = function() {
				return $http.get("./employees");
			};

			self.saveEmployee = function(data) {
				return $http.post("./employees", data);
			};

			self.getEmployee = function(compId) {
				return $http.get("./employee/" + compId);
			};

			self.updateEmployee = function(data) {
				return $http.put("./update", data);
			};

			self.saveEmployee = function(data) {
				return $http.post("./employees", data);
			};
		} ]);