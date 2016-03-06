
var app = angular.module('admin', ['ngMaterial','ui.router','cfp.hotkeys','mdColors','treeControl']);

app.controller('admin', function($scope, hotkeys) {

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

});

app.config(function($mdThemingProvider, $stateProvider, $urlRouterProvider, hotkeysProvider) {
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

    hotkeysProvider.cheatSheetHotkey = 'meta+/';
});
