
class ProductsSelectorController extends ProductsController {

    /*@ngInject*/
    constructor($scope, $services, productService) {
        super($scope, $services, productService);
    }

    loadConfig() {
        this.tableConfig = {
            query: "?hasOptions=false",
            visibleFields: ['sku','name','enabled','price','quantity']
        };
    }

    /**
     * Send a product selection event with the selected products
     */
    selectProducts() {
        let selection = this.gridApi.selection.getSelectedRows();
        this.$rootScope.$broadcast(EVENT_SHOP_CATALOGUE_PRODUCT_SELECTION, selection);
    }

}
