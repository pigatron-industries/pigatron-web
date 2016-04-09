
class AdminController {

    /*@ngInject*/
    constructor($scope, $http, hotkeys, $mdToast, $rootScope, $window) {
        this.$scope = $scope;
        this.$http = $http;
        this.hotkeys = hotkeys;
        this.$mdToast = $mdToast;
        this.$rootScope = $rootScope;
        this.$rootScope.urlBase = URL_BASE;
        this.$window = $window;
        window.$rootScope = $rootScope;
        hotkeys.add({
            combo: ['ctrl+s','command+s'],
            description: 'Save',
            allowIn: ['INPUT', 'SELECT', 'TEXTAREA'],
            callback: (e) => {
                if (e.preventDefault) {
                    e.preventDefault();
                } else {
                    // internet explorer
                    e.returnValue = false;
                }
                this.$scope.$broadcast(EVENT_ADMIN_SAVE);
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
                controller: MessageController,
                controllerAs: 'message',
                template: "<md-toast><div class='md-toast-content " + classes + "'><span class='md-toast-text' flex>" + message + "</span><md-button ng-click='message.close()'>Close</md-button></div></md-toast>",
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

    open(url) {
        this.$window.open(url);
    }
}
