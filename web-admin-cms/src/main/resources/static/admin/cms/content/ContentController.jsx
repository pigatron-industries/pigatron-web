class ContentController extends webadmincore.AbstractFormController {

    /*@ngInject*/
    constructor($scope, $services, $mdDialog, contentService) {
        super($scope, $services, contentService);
        this.$mdDialog = $mdDialog;
        this.editorOptions = {};
    }

    create() {
        super.create();
        this.formData.type = this.$stateParams.type; //Type passed in to route
    }

    showImageDialog(ev) {
        this.$mdDialog.show({
            controller: 'ImageDialogController',
            controllerAs: 'images',
            templateUrl: '/admin/cms/content/imageDialog.html',
            scope: this.$scope,
            preserveScope: true,
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose: true
        }).then(function(answer) {
            console.log(answer);
        }, function() {
            //cancelled the dialog
        });
    }


}

module.exports = ContentController;