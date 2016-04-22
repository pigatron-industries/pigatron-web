
class ProductsController extends AbstractTableController {

    /*@ngInject*/
    constructor($scope, $services, productService) {
        super($scope, $services, productService);
    }

    loadConfig() {
        this.tableConfig = {
            query: "",
            visibleFields: ['edit','sku','name','location','enabled','price','quantity','categories','supplierInfo']
        };
    }

    defineColumns() {
        return [
            this.columnAction({ name:'edit', icon:"fa-pencil-square-o", sref:"product({id:row.entity.id})" }),
            this.column({ field: 'id',               enableCellEdit: false }),
            this.column({ field: 'sku',              enableCellEdit: true  }),
            this.column({ field: 'name',             enableCellEdit: true  }),
            this.column({ field: 'shortDescription', enableCellEdit: true  }),
            this.column({ field: 'description',      enableCellEdit: true  }),
            this.column({ field: 'location',         enableCellEdit: true  }),
            this.column({ field: 'enabled',          enableCellEdit: true,  type:'boolean' }),
            this.column({ field: 'price',            enableCellEdit: true,  cellFilter: "currency" }),
            this.column({ field: 'taxClass',         enableCellEdit: false }),
            this.column({ field: 'metaTitle',        enableCellEdit: true  }),
            this.column({ field: 'metaKeywords',     enableCellEdit: true  }),
            this.column({ field: 'metaDescription',  enableCellEdit: true  }),
            this.column({ field: 'quantity',         cellEditableCondition: ProductsController.quantityEditable  }),
            this.column({ field: 'allowBackorders',  enableCellEdit: true  }),
            this.column({ field: 'maxInCart',        enableCellEdit: true  }),
            this.column({ field: 'categories',       enableCellEdit: false, cellFilter: "listCategories" }),
            this.column({ field: 'supplierInfo',     enableCellEdit: false, cellTemplate: ProductsController.supplierLinkTemplate() }),
            this.column({ field: 'supplierName',     enableCellEdit: true  }),
            this.column({ field: 'supplierItemCode', enableCellEdit: true  }),
            this.column({ field: 'supplierItemLink', enableCellEdit: true  }),
            this.column({ field: 'supplierPrice',    enableCellEdit: true,  cellFilter: "currency"}),
            this.column({ field: 'supplierNotes',    enableCellEdit: false }),
            this.column({ field: 'quantityOnOrder',  enableCellEdit: true  })
        ];
    }

    static quantityEditable(scope) {
        return !scope.row.entity.useQuantityOnOptions;
    }

    static listCategories(categories) {
        let list = "";
        for(let i = 0; i < categories.length; i++) {
            if(i > 0) {
                list += ", ";
            }
            list += categories[i].name;
        }
        return list;
    }

    static supplierLinkTemplate() {
        return '<div class="ui-grid-cell-input">' +
            '<a ng-class="\'colt\' + col.uid" class="ui-grid-cell-contents" ng-href="{{row.entity.supplierItemLink}}" target="_new">' +
            '{{row.entity.supplierName}} {{row.entity.supplierItemCode}}</a></div>';
    }

    /**
     * Create new product directly in the table
     */
    newProduct() {
        //TODO
    }

    /**
     * Copy a product directly in the table
     */
    copyProduct() {
        //TODO
    }

}
