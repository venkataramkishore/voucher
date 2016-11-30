angular
		.module("voucherApp")
		.config(
				function($routeProvider, $httpProvider, $mdThemingProvider) {

					$mdThemingProvider
				    .theme('default')
				    .primaryPalette('red')
				    .accentPalette('blue')
				    .warnPalette('orange')
				    .backgroundPalette('grey');
					
					$routeProvider
							.when('/', {
								templateUrl : 'login.html',
								controller : 'navbarCtrl',
								controllerAS: "controller"
							})
							.when(
									'/home',
									{
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
							.when(
									'/teamoverall',
									{
										templateUrl : 'js/components/overall/overall.component.html',
										controller : 'overallCtrl'
									})
							.when(
									'/myteam',
									{
										templateUrl : 'js/components/myteam/myteam.component.html',
										controller : 'myteamCtrl'
									})
							.when('/login', {
								templateUrl : 'login.html',
								controller : 'navbarCtrl',
								controllerAS: "controller"
							})
							.when('/logout', {
								controller : 'logoutCtrl',
							})
							.when('/error', {
								templateUrl : './error.html',
								controller : 'error',
							}).otherwise('/');

					$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

				});