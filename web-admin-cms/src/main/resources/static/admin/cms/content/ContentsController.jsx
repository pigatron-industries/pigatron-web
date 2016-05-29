
class ContentsController extends webadmincore.AbstractTableController {

    /*@ngInject*/
    constructor($scope, $services, contentService) {
        super($scope, $services, contentService);
    }

    loadConfig() {
        this.tableConfig = {
            query: "",
            visibleFields: ['edit','type','title','enabled']
        };
    }

    defineColumns() {
        super.defineColumns();
        this.table.columnDefs.push(this.column({ field: 'id',               enableCellEdit: false }));
        this.table.columnDefs.push(this.column({ field: 'type',             enableCellEdit: false, width: 120}));
        this.table.columnDefs.push(this.column({ field: 'title',            enableCellEdit: true  }));
        this.table.columnDefs.push(this.column({ field: 'enabled',          enableCellEdit: true,  type:'boolean' }));
    }

    onRegisterGridApi() {
        super.onRegisterGridApi();
        this.gridApi.core.addRowHeaderColumn(this.columnAction({ name:'edit', icon:"fa-pencil-square-o", sref:"content({id:row.entity.id})", tooltip:"Edit" }));
    }


}

module.exports = ContentsController;