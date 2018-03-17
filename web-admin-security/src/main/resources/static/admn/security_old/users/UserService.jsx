
const API_ADMIN_USER = "api/security/user";

class UserService extends webadmincore.AbstractRestService {

    /*@ngInject*/
    constructor($http) {
        super($http, API_ADMIN_USER);
    }

}

module.exports = UserService;