
var app = angular.module('admin', ['ngMaterial','ngMessages','ngAnimate','ui.router','ui.tree','cfp.hotkeys','mdColors']);


class AdminController {

    constructor($scope, $http, hotkeys, $mdToast, $rootScope) {
        this.$http = $http;
        this.hotkeys = hotkeys;
        this.$mdToast = $mdToast;
        this.$rootScope = $rootScope;
        window.$rootScope = $rootScope;
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
        $rootScope.notifyError = function(message) {
            $rootScope.notify(message, 'md-default-theme md-warn md-hue-1 md-fg error-text');
        };

        $rootScope.notifyInfo = function(message) {
            $rootScope.notify(message, '');
        };

        $rootScope.notifySuccess = function(message) {
            $rootScope.notify(message, 'success-text');
        };

        $rootScope.notify = function(message, classes) {
            $mdToast.show({
                parent: angular.element(document.getElementById('content')),
                controller: 'toastController',
                template: "<md-toast><div class='md-toast-content " + classes + "'><span class='md-toast-text' flex>" + message + "</span><md-button ng-click='close()'>Close</md-button></div></md-toast>",
                position: 'top right',
                hideDelay: 10000
            });
        };

    }

    logout() {
        this.$http.post("/logout").success(function() {
            location.reload();
        });
    }
}

app.controller('AdminController', AdminController);

app.controller('toastController', function($scope, $mdToast) {
    $scope.close = function() {
        $mdToast.hide();
    };
});

app.config(function($mdThemingProvider, $stateProvider, $locationProvider, $urlRouterProvider, hotkeysProvider,
                    $httpProvider, $provide) {
    configTheme($mdThemingProvider);

    $locationProvider.html5Mode(true);
    $urlRouterProvider.otherwise("/");

    hotkeysProvider.cheatSheetHotkey = 'meta+/';

    $httpProvider.interceptors.push("httpInterceptor");

    $provide.decorator("$exceptionHandler", ['$delegate', function($delegate) {
        return function(exception, cause) {
            $delegate(exception, cause);
            window.$rootScope.notifyError(exception);
        };
    }]);
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
            } else {
                window.$rootScope.notifyError('Connection Error');
            }
            return $q.reject(rejection);
        }
    };
});
