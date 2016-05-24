
class PagesController extends webadmincore.AbstractTableController {

    /*@ngInject*/
    constructor($scope, $services, pageService) {
        super($scope, $services, pageService);
    }

}

module.exports = PagesController;