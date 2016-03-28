
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
            this.column({ field: 'location',         visible:true, enableCellEdit: true  }),
            this.column({ field: 'enabled',          visible:true,  enableCellEdit: true, type:'boolean' }),
            this.column({ field: 'price',            visible:true,  enableCellEdit: true  }),
            this.column({ field: 'taxClass',         visible:false, enableCellEdit: false }),
            this.column({ field: 'metaTitle',        visible:false, enableCellEdit: true  }),
            this.column({ field: 'metaKeywords',     visible:false, enableCellEdit: true  }),
            this.column({ field: 'metaDescription',  visible:false, enableCellEdit: true  }),
            this.column({ field: 'quantity',         visible:true,  enableCellEdit: true  }),
            this.column({ field: 'allowBackorders',  visible:false, enableCellEdit: true  }),
            this.column({ field: 'maxInCart',        visible:false, enableCellEdit: true  }),
            this.column({ field: 'categories',       visible:true,  enableCellEdit: false })
        ];
    }

}
