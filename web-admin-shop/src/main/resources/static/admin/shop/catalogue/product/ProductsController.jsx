
class ProductsController extends AbstractTableController {

    constructor($scope, $services, productService) {
        super($scope, $services);
        window.$products = this;
        this.productService = productService;
        this.loadTableOptions();
        productService.getAll().then((success) => {
            this.tableData = success.data;
        });
    }

    loadTableOptions() {
        this.tableOptions = {
            rowHeight: 40,
            headerHeight: 40,
            footerHeight: false,
            selectable: true,
            multiSelect: true,
            scrollbarV: true,
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
        return "<span>{{$header}}</span>"; //+
            //"<input type='text' ng-model-options='{ debounce: 100 }' placeholder='Filter names' ng-click='prev($event)' ng-model='$parent.filterKeywords' />";
    }

}
