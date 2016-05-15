
var ProductsController = require('../ProductsController');

class SelectProductController extends ProductsController {

    /*@ngInject*/
    constructor($scope, $services, $mdSidenav, productService) {
        super($scope, $services, productService);
        this.enableSorting(false);
        this.enableRowSelection(false);
        this.enableFiltering(false);
        this.enableDraggableRows();
        this.$mdSidenav = $mdSidenav;
    }

    load() {
        this.option = this.$scope.option;
        if(!this.option.products) {
            this.option.products = [];
        }
        this.option.waitingSelection = false;
        this.table.data = this.option.products;
    }

    loadConfig() {
        this.tableConfig = {
            visibleFields: ['drag','unlink','sku','name','price','quantity','enabled']
        };
    }

    defineColumns() {
        super.defineColumns();
        this.table.columnDefs.push(this.columnAction({ name:'unlink', icon:"fa-chain-broken", tooltip:"Remove Option", click:(row)=>{this.removeProduct(row);} }));
    }

    removeProduct(row) {
        let index = this.table.data.indexOf(row.entity);
        this.table.data.splice(index, 1);
        this.setDirty();
    }

    openProductSelector() {
        let selectorOptions = {};
        selectorOptions.exclude = [];
        for(var i=0; i<this.table.data.length; i++) {
            selectorOptions.exclude.push(this.table.data[i].id);
        }
        this.$scope.$emit(EVENT_SHOP_CATALOGUE_PRODUCT_SELECTOR_OPEN, selectorOptions);
        this.waitForSelection();
    }

    waitForSelection() {
        this.option.waitingSelection = true;
        this.offProductSelection = this.$scope.$on(EVENT_SHOP_CATALOGUE_PRODUCT_SELECTOR_ONSELECT,
            (event, args) => { this.onProductSelection(event, args); }
        );
        this.unwatchSidebar = this.$scope.$watch(
            () => { return this.$mdSidenav('sidenav-right').isOpen(); },
            (isOpen) => { if(!isOpen) this.onSidebarClose(); }
        );
    }

    onSidebarClose() {
        this.option.waitingSelection = false;
        this.offProductSelection();
        this.unwatchSidebar();
    }

    onProductSelection(event, selection) {
        console.log(selection);
        for(var i=0; i<selection.length; i++) {
            let product = selection[i];
            this.option.products.push(product);
            this.refreshTableHeight();
            this.setDirty();
        }
    }

}


module.exports = SelectProductController;