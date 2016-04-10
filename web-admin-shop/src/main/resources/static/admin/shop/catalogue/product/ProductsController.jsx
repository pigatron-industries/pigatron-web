
class ProductsController extends AbstractTableController {

    /*@ngInject*/
    constructor($scope, $services, productService) {
        super($scope, $services, productService);
    }

    defineColumns() {
        return [
            this.columnAction({ name:'edit', icon:"fa-pencil-square-o", sref:"product({id:row.entity.id})" }),
            this.column({ field: 'id',               visible:false, enableCellEdit: false }),
            this.column({ field: 'sku',              visible:true,  enableCellEdit: true  }),
            this.column({ field: 'name',             visible:true,  enableCellEdit: true  }),
            this.column({ field: 'shortDescription', visible:false, enableCellEdit: true  }),
            this.column({ field: 'description',      visible:false, enableCellEdit: true  }),
            this.column({ field: 'location',         visible:true,  enableCellEdit: true  }),
            this.column({ field: 'enabled',          visible:true,  enableCellEdit: true,  type:'boolean' }),
            this.column({ field: 'price',            visible:true,  enableCellEdit: true,  cellFilter: "currency" }),
            this.column({ field: 'taxClass',         visible:false, enableCellEdit: false }),
            this.column({ field: 'metaTitle',        visible:false, enableCellEdit: true  }),
            this.column({ field: 'metaKeywords',     visible:false, enableCellEdit: true  }),
            this.column({ field: 'metaDescription',  visible:false, enableCellEdit: true  }),
            this.column({ field: 'quantity',         visible:true,  cellEditableCondition: ProductsController.quantityEditable  }),
            this.column({ field: 'allowBackorders',  visible:false, enableCellEdit: true  }),
            this.column({ field: 'maxInCart',        visible:false, enableCellEdit: true  }),
            this.column({ field: 'categories',       visible:true,  enableCellEdit: false, cellFilter: "listCategories" }),
            this.column({ field: 'supplierName',     visible:false, enableCellEdit: true  }),
            this.column({ field: 'supplierItemCode', visible:false, enableCellEdit: true  }),
            this.column({ field: 'supplierItemLink', visible:false, enableCellEdit: false }), //TODO make hyperlink
            this.column({ field: 'supplierPrice',    visible:false, enableCellEdit: true,  cellFilter: "currency"}),
            this.column({ field: 'supplierNotes',    visible:false, enableCellEdit: false }),
            this.column({ field: 'quantityOnOrder',  visible:false, enableCellEdit: true  })
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

}
