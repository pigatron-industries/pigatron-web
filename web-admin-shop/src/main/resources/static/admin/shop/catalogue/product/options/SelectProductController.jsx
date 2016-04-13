
class SelectProductController extends AbstractController {

    /*@ngInject*/
    constructor($scope, $services, $mdSidenav) {
        super($scope, $services);
        this.$mdSidenav = $mdSidenav;
        this.option = this.$scope.option;
    }

    addProduct() {
        console.log('add');
    }

}

register('admin.shop.catalogue').controller('selectProductController', SelectProductController);
