
class ProductController extends AbstractFormController {

    constructor($scope, $state, $stateParams, productService) {
        super($scope, $state, $stateParams, productService);
        window.$product = this;
    }

}