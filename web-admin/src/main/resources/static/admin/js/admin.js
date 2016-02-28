
var app = angular.module('admin', ['ngMaterial','ngRoute','ngMdIcons']);

app.controller('admin', function($scope,  $route, $routeParams, $location) {
    $scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;
});

app.config(function($mdThemingProvider, $routeProvider, $locationProvider) {
    configTheme($mdThemingProvider);
    $routeProvider.when('/categories', {
        templateUrl: '/admin/pages/categories.html',
        controller: 'categories'
    });
    $routeProvider.when('/products', {
        templateUrl: '/admin/pages/products.html',
        controller: 'products'
    });
});
