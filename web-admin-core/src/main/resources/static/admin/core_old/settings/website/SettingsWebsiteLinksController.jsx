
var AbstractTableController = require('../../abstract/AbstractTableController');

class SettingsWebsiteLinksController extends AbstractTableController {

    /*@ngInject*/
    constructor($scope, $services) {
        super($scope, $services);
        this.enableGridMenu(false);
        this.enableSorting(false);
        this.enableRowSelection(false);
        this.enableFiltering(false);
        this.enableDraggableRows();
    }

    load() {
        this.table = {};
        this.table.data = this.$scope.websiteSettings.formData.links;
    }

    defineColumns() {
        super.defineColumns();
        this.table.columnDefs.push(this.column({ name:'title',    enableColumnMenu:false }));
        this.table.columnDefs.push(this.column({ name:'position', enableColumnMenu:false, editableCellTemplate: 'ui-grid/dropdownEditor',
            editDropdownOptionsArray:[{id:'TOP_LEFT', value:'Top Left'}, {id:'TOP_RIGHT', value:'Top Right'}] }));
        this.table.columnDefs.push(this.column({ name:'type',     enableColumnMenu:false, editableCellTemplate: 'ui-grid/dropdownEditor',
            editDropdownOptionsArray:[{id:'ROUTE', value:'Route'}, {id:'JS', value:'JavaScript'}, {id:'URL', value:'URL'}] }));
        this.table.columnDefs.push(this.column({ name:'action', enableColumnMenu:false }));
    }

}

module.exports = SettingsWebsiteLinksController;
