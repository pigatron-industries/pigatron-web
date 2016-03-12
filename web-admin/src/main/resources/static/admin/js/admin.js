
var app = angular.module('admin', ['ngMaterial','ngMessages','ngAnimate','ui.router','cfp.hotkeys','mdColors','treeControl']);

app.controller('admin', function($scope, $http, hotkeys) {
    window.$http = $http;

    hotkeys.add({
        combo: ['meta+s'],
        description: 'Save',
        allowIn: ['INPUT', 'SELECT', 'TEXTAREA'],
        callback: function(e) {
            if (e.preventDefault) {
                e.preventDefault();
            } else {
                // internet explorer
                e.returnValue = false;
            }
            window.save();
        }
    });

    $scope.logout = function() {
        $http.post("/logout").success(function() {
            location.reload();
        });
    }

});

app.config(function($mdThemingProvider, $stateProvider, $locationProvider, $urlRouterProvider, hotkeysProvider, $httpProvider) {
    configTheme($mdThemingProvider);

    $locationProvider.html5Mode(true);
    $urlRouterProvider.otherwise("/");

    $stateProvider.state('home', {
        url: "/",
        templateUrl: "/admin/views/home.html"
    });
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

    hotkeysProvider.cheatSheetHotkey = 'meta+/';

    $httpProvider.interceptors.push("httpInterceptor");
});

app.factory('httpInterceptor', function($q) {
    return {
        'request': function(config) {
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            config.headers[header] = token;
            return config;
        },
        'requestError': function(rejection) {
            return $q.reject(rejection);
        },
        'response': function(response) {
            return response;
        },
        'responseError': function(rejection) {
            if(rejection.status == 401) {
                location.reload();
            }
            return $q.reject(rejection);
        }
    };
});

app.factory('$exceptionHandler', function () {
    return function errorHandler(exception, cause) {Added
        console.error(exception.stack);
    };
});