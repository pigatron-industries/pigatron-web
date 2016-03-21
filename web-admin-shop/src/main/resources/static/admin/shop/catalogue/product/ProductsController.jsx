
class ProductsController {

    constructor(productService) {
        window.$products = this;
        this.productService = productService;
        this.loadTableOptions();
        this.tableData = undefined;
        productService.getAll().then((success) => {
            this.tableData = success.data;
        });
    }

    loadTableOptions() {
        this.tableOptions = {
            headerHeight: 40,
            footerHeight: false,
            scrollbarV: false,
            checkboxSelection: true,
            selectable: true,
            multiSelect: true,
            columns: this.createColumns()
        };
    }

    createColumns() {
        let columns = [];
        columns.push(this.createColumn("ID", "id"));
        columns.push(this.createColumn("Name", "name"));
        columns.push(this.createColumn("Quantity", "quantity"));
        return columns;
    }

    createColumn(name, prop) {
        let column = {};
        column.name = name;
        column.prop = prop;
        column.headerRenderer = (scope, elm) => {
            return this.getHeaderTemplate(prop);
        };
        return column;
    }

    getHeaderTemplate(prop) {
        return "<div>{{$header}}</div>"; //+
            //"<input type='text' ng-model-options='{ debounce: 100 }' placeholder='Filter names' ng-click='prev($event)' ng-model='$parent.filterKeywords' />";
    }

}
