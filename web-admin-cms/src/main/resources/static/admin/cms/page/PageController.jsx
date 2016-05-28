class PageController extends webadmincore.AbstractFormController {

    /*@ngInject*/
    constructor($scope, $services, pageService) {
        super($scope, $services, pageService);
        this.editorOptions = {
        };
    }

}

module.exports = PageController;