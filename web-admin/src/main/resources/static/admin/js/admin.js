
var app = angular.module('admin', ['ngMaterial','ngRoute','mdColors','treeControl']);

app.controller('admin', function($scope,  $route, $routeParams, $location) {
    $scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;
});

app.config(function($mdThemingProvider, $routeProvider, $locationProvider) {
    configTheme($mdThemingProvider);
    $routeProvider.when('/categories', {
        templateUrl: '/admin/pages/categories.html',
        controller: 'categories',
        reloadOnSearch: false
    });
    $routeProvider.when('/categories/:categoryId', {
        templateUrl: '/admin/pages/categories.html',
        controller: 'categories',
        reloadOnSearch: false
    });
    $routeProvider.when('/products', {
        templateUrl: '/admin/pages/products.html',
        controller: 'products'
    });
    $locationProvider.html5Mode(true);
});
