
class PageController {

    /*@ngInject*/
    constructor($scope, $stateParams, $sce, contentService) {
        this.$scope = $scope;
        this.$stateParams = $stateParams;
        this.$sce = $sce;
        this.contentService = contentService;
        this.load();
    }

    load() {
        return this.contentService.getPageByUrlKey(this.$stateParams.urlKey).then((success) => {
            this.data = success.data;
            this.data.content = this.$sce.trustAsHtml(this.data.content);
        });
    }

}

module.exports = PageController;