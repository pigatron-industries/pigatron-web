
var AbstractFormController = require("../../abstract/AbstractFormController");

class SettingsController extends AbstractFormController {

    /*@ngInject*/
    constructor($scope, $services, settingsService) {
        super($scope, $services, settingsService);
    }

}

module.exports = SettingsController;
