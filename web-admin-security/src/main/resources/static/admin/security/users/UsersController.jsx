

class UsersController extends webadmincore.AbstractTableController {

    /*@ngInject*/
    constructor($scope, $services, userService) {
        super($scope, $services, userService);
    }


}

module.exports = UsersController;
