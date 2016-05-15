
class ProductsController extends webadmincore.AbstractTableController {

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
        super.defineColumns();
        this.table.columnDefs.push(this.column({ field: 'id',               enableCellEdit: false }));
        this.table.columnDefs.push(this.column({ field: 'enabled',          enableCellEdit: true,  type:'boolean' }));
        this.table.columnDefs.push(this.column({ field: 'sku',              enableCellEdit: true  }));
        this.table.columnDefs.push(this.column({ field: 'name',             enableCellEdit: true  }));
        this.table.columnDefs.push(this.column({ field: 'shortDescription', enableCellEdit: true  }));
        this.table.columnDefs.push(this.column({ field: 'description',      enableCellEdit: true  }));
        this.table.columnDefs.push(this.column({ field: 'location',         enableCellEdit: true  }));
        this.table.columnDefs.push(this.column({ field: 'price',            enableCellEdit: true,  cellFilter: "currency" }));
        this.table.columnDefs.push(this.column({ field: 'taxClass',         enableCellEdit: false }));
        this.table.columnDefs.push(this.column({ field: 'metaTitle',        enableCellEdit: true  }));
        this.table.columnDefs.push(this.column({ field: 'metaKeywords',     enableCellEdit: true  }));
        this.table.columnDefs.push(this.column({ field: 'metaDescription',  enableCellEdit: true  }));
        this.table.columnDefs.push(this.column({ field: 'quantity',         cellEditableCondition: ProductsController.quantityEditable  }));
        this.table.columnDefs.push(this.column({ field: 'allowBackorders',  enableCellEdit: true  }));
        this.table.columnDefs.push(this.column({ field: 'maxInCart',        enableCellEdit: true  }));
        this.table.columnDefs.push(this.column({ field: 'categories',       enableCellEdit: false, cellFilter: "listCategories" }));
        this.table.columnDefs.push(this.column({ field: 'supplierInfo',     enableCellEdit: false, cellTemplate: ProductsController.supplierLinkTemplate() }));
        this.table.columnDefs.push(this.column({ field: 'supplierName',     enableCellEdit: true  }));
        this.table.columnDefs.push(this.column({ field: 'supplierItemCode', enableCellEdit: true  }));
        this.table.columnDefs.push(this.column({ field: 'supplierItemLink', enableCellEdit: true  }));
        this.table.columnDefs.push(this.column({ field: 'supplierPrice',    enableCellEdit: true,  cellFilter: "currency"}));
        this.table.columnDefs.push(this.column({ field: 'supplierNotes',    enableCellEdit: false }));
        this.table.columnDefs.push(this.column({ field: 'quantityOnOrder',  enableCellEdit: true  }));
    }

    onRegisterGridApi() {
        super.onRegisterGridApi();
        this.gridApi.core.addRowHeaderColumn(this.columnAction({ name:'edit', icon:"fa-pencil-square-o", sref:"product({id:row.entity.id})", tooltip:"Edit" }));
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

    load() {
        return super.load().then(() => {
            this.table.data.forEach((product) => {
                if(!product.isOption) {
                    product.$$treeLevel = 0;
                }
            });
            if(this.gridApi.treeBase) {
                this.$timeout(()=>{this.gridApi.treeBase.expandAllRows()}, 1);
            }
        });
    }


}

module.exports = ProductsController;