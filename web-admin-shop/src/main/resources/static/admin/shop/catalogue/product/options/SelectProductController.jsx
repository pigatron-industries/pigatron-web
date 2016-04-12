
class SelectProductController extends AbstractController {

    /*@ngInject*/
    constructor($scope, $services) {
        super($scope, $services);
        this.option = this.$scope.option;
    }

    addProduct() {
        console.log('add');
    }
}

register('admin.shop.catalogue').controller('selectProductController', SelectProductController);
