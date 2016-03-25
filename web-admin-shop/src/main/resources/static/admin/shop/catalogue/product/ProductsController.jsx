
class ProductsController extends AbstractTableController {

    constructor($scope, $services, productService) {
        super($scope, $services);
        window.$products = this;
        this.productService = productService;

        this.table = {
            loaded: false,
            enableSorting: true,
            enableFiltering: true,
            columnDefs: this.defineColumns(),
            onRegisterApi: (gridApi) => {
                this.gridApi = gridApi;
            }
        };

        productService.getAll().then((success) => {
            this.table.data = success.data;
            this.table.loaded = true;
        });
    }

    defineColumns() {
        return [
            { field: 'id' },
            { field: 'name' },
            { field: 'sku' }
        ];
    }

}
