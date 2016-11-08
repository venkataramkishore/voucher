angular
		.module("voucherApp")
		.config(
				function($routeProvider, $httpProvider) {

					$routeProvider
							.when('/', {
								templateUrl : 'js/components/home/home.component.html',
								controller : 'homeCtrl',
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
									'/purchaseorders',
									{
										templateUrl : 'js/components/purchaseorders/purchaseorder.component.html',
										controller : 'purchaseorderCtrl'
									})
							.when(
									'/certificates',
									{
										templateUrl : 'js/components/certificates/certificate.component.html',
										controller : 'certificateCtrl'
									})
							.when('/login', {
								templateUrl : 'login.html',
								controller : 'navigation',
								controllerAs : 'controller'
							}).when('/error', {
								templateUrl : './error.html',
								controller : 'error',
							}).otherwise('/');

					$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

				});