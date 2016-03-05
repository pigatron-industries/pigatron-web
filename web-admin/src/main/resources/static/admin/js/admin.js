
var app = angular.module('admin', ['ngMaterial','ui.router','mdColors','treeControl']);

app.controller('admin', function($scope) {
    //$scope.$route = $route;
    //$scope.$location = $location;
    //$scope.$routeParams = $routeParams;
});

app.config(function($mdThemingProvider, $stateProvider, $urlRouterProvider) {
    configTheme($mdThemingProvider);

    $urlRouterProvider.otherwise("/");

    $stateProvider.state('categories', {
        url: "/categories",
        templateUrl: "/admin/views/categories.html"
    });
    $stateProvider.state('categories.category', {
        url: "/:categoryId",
        templateUrl: "/admin/views/categories.category.html"
    });
    $stateProvider.state('products', {
        url: "/products",
        templateUrl: "/admin/views/products.html"
    });
});
