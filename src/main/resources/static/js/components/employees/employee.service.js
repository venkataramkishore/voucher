angular.module("employeeModule").service("employeeService",
		[ '$http', function($http) {

			var self = this;

			self.fetchEmployeeList = function() {
				return $http.get("./employees");
			};
			
			self.fetchManagerList = function() {
				return $http.get("./managers");
			};
			
			self.fetchAdminList = function(){
				return $http.get("./admins");
			};
			
			self.saveEmployee = function(data) {
				return $http.post("./employee", data);
			};

			self.getEmployee = function(empId) {
				return $http.get("./employee/" + empId);
			};

			self.updateEmployee = function(data) {
				return $http.put("./employee", data);
			};

			self.fetchActiveEmployeeList = function() {
				return $http.get("./activeemployees");
			};

			self.fetchInActiveEmployeeList = function() {
				return $http.get("./inactiveemployees");
			};
			
			self.fetchMyActiveEmployeeList = function(){
				return $http.get("./myactiveemployees");
			};

			
		} ]);