
var AbstractRestService = require("../abstract/AbstractRestService");

const API_ADMIN_SETTINGS = "api/settings";

class SettingsService extends AbstractRestService {

    /*@ngInject*/
    constructor($http) {
        super($http, API_ADMIN_SETTINGS);
    }

}

module.exports = SettingsService;