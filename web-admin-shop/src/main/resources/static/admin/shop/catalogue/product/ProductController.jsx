
class ProductController extends AbstractFormController {

    /*@ngInject*/
    constructor($scope, $services, productService) {
        super($scope, $services, productService);
        window.$product = this;
    }

}