
var MessageController = require('./MessageController');
var AbstractServiceBundleConsumer = require('../abstract/AbstractServiceBundleConsumer');


class AdminController extends AbstractServiceBundleConsumer {

    /*@ngInject*/
    constructor($scope, $services, hotkeys, $mdToast) {
        super($services);
        this.$scope = $scope;
        this.hotkeys = hotkeys;
        this.$mdToast = $mdToast;
        this.$rootScope.urlBase = constants.URL_BASE;
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
                this.$scope.$broadcast(constants.events.EVENT_ADMIN_SAVE);
            }
        });
        this.$rootScope.notifyError = (message) => {
            this.$rootScope.notify(message, 'md-default-theme md-warn md-hue-1 md-fg error-text');
        };

        this.$rootScope.notifyInfo = (message) => {
            this.$rootScope.notify(message, '');
        };

        this.$rootScope.notifySuccess = (message) => {
            this.$rootScope.notify(message, 'success-text');
        };

        this.$rootScope.notify = (message, classes) => {
            this.$mdToast.show({
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

module.exports = AdminController;
