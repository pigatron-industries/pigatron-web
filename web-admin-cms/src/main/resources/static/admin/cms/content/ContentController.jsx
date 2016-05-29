class ContentController extends webadmincore.AbstractFormController {

    /*@ngInject*/
    constructor($scope, $services, contentService) {
        super($scope, $services, contentService);
        this.editorOptions = {};
    }

    create() {
        super.create();
        this.formData.type = this.$stateParams.type; //Type passed in to route
    }


}

module.exports = ContentController;