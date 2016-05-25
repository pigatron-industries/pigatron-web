
class PagesController extends webadmincore.AbstractTableController {

    /*@ngInject*/
    constructor($scope, $services, pageService) {
        super($scope, $services, pageService);
    }

    loadConfig() {
        this.tableConfig = {
            query: "",
            visibleFields: ['edit','title','enabled','static']
        };
    }

    defineColumns() {
        super.defineColumns();
        this.table.columnDefs.push(this.column({ field: 'id',               enableCellEdit: false }));
        this.table.columnDefs.push(this.column({ field: 'title',            enableCellEdit: true  }));
        this.table.columnDefs.push(this.column({ field: 'enabled',          enableCellEdit: true,  type:'boolean' }));
        this.table.columnDefs.push(this.column({ field: 'static',           enableCellEdit: false, type:'boolean' }));
    }

    onRegisterGridApi() {
        super.onRegisterGridApi();
        this.gridApi.core.addRowHeaderColumn(this.columnAction({ name:'edit', icon:"fa-pencil-square-o", sref:"page({id:row.entity.id})", tooltip:"Edit" }));
    }


}

module.exports = PagesController;