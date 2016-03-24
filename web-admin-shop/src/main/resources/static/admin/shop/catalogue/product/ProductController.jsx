
class ProductController extends AbstractFormController {

    constructor($scope, $services, productService) {
        super($scope, $services, productService);
        window.$product = this;
    }

}