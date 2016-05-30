
class PageController {

    /*@ngInject*/
    constructor($scope, $stateParams, contentService) {
        this.$scope = $scope;
        this.$stateParams = $stateParams;
        this.contentService = contentService;
        this.load();
    }

    load() {
        return this.contentService.getPageByUrlKey(this.$stateParams.urlKey).then((success) => {
            this.data = success.data;
        });
    }

}

module.exports = PageController;