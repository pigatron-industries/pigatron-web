
class AdminController {

    /*@ngInject*/
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
}
