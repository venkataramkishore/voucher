angular.module("navbarModule").directive("appNavbar", function () {
    return {
        restrict: 'A', //E = element, A = attribute, C = class, M = comment         
        templateUrl: 'js/components/navbar/navbar.directive.html',
        controller: 'navbarCtrl',
        link: function ($scope, element, attrs) { } //DOM manipulation
    }
});