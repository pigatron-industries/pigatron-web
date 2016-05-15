
var ProductsController = require('../ProductsController');

class ProductsSelectorController extends ProductsController {

    /*@ngInject*/
    constructor($scope, $services, productService) {
        super($scope, $services, productService);
        this.selectorOptions = this.$scope.selectorOptions;
        console.log(this.selectorOptions);
    }

    loadConfig() {
        this.tableConfig = {
            query: "?hasOptions=false",
            visibleFields: ['sku','name','enabled','price','quantity']
        };
    }

    load() {
        return super.load().then(() => {
            this.removeExcludedProducts();
        });
    }

    removeExcludedProducts() {
        this.table.data = this.table.data.filter((p)=>{
            return this.selectorOptions.exclude.indexOf(p.id) == -1;
        });
    }


    /**
     * Send a product selection event with the selected products
     */
    selectProducts() {
        let selection = this.gridApi.selection.getSelectedRows();
        for(var i=0; i<selection.length; i++) {
            this.selectorOptions.exclude.push(selection[i].id);
        }
        this.removeExcludedProducts();
        this.$rootScope.$broadcast(EVENT_SHOP_CATALOGUE_PRODUCT_SELECTOR_ONSELECT, selection);
    }

}


module.exports = ProductsSelectorController;