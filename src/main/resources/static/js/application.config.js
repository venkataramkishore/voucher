angular
		.module("voucherApp")
		.config(
				function($routeProvider, $httpProvider) {

					$routeProvider
							.when('/', {
								templateUrl : 'home.html',
								controller : 'home',
								controllerAs : 'controller'
							})
							.when(
									'/companies',
									{
										templateUrl : 'js/components/companies/company.component.html',
										controller : 'companyCtrl'
									})
							.when(
									'/parameters',
									{
										templateUrl : 'js/components/parameters/parameter.component.html',
										controller : 'parameterCtrl'
									})
							.when(
									'/employees',
									{
										templateUrl : 'js/components/employees/employee.component.html',
										controller : 'employeeCtrl'
									})
							.when(
									'/certificates',
									{
										templateUrl : 'js/components/certificates/certificate.component.html',
										controller : 'certificateCtrl'
									}).when('/login', {
								templateUrl : 'login.html',
								controller : 'navigation',
								controllerAs : 'controller'
							}).when('/error', {
								templateUrl : './error.html',
								controller : 'error',
							}).otherwise('/');

					$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

				});