class PageController extends webadmincore.AbstractFormController {

    /*@ngInject*/
    constructor($scope, $services, pageService) {
        super($scope, $services, pageService);
    }

}

module.exports = PageController;