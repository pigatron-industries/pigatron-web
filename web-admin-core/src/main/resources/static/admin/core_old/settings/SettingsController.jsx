
var AbstractServiceBundleConsumer = require("../abstract/AbstractServiceBundleConsumer");

class SettingsController extends AbstractServiceBundleConsumer {

    /*@ngInject*/
    constructor($scope, $services, settingsService) {
        super($services);
        this.$scope = $scope;
        this.settingsService = settingsService;
        this.load();
    }

    load() {
        return this.settingsService.getAll().then((success) => {
            this.names = success.data;
        });
    }

    save() {
        this.$scope.$broadcast(constants.events.EVENT_ADMIN_SAVE);
    }

}

module.exports = SettingsController;
