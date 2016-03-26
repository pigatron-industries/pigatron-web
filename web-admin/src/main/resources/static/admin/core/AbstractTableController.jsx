
class AbstractTableController extends AbstractController {

    constructor($scope, $services, dataService) {
        super($scope, $services);
        this.dataService = dataService;

        this.eventOnOffNow($(window), 'resize', () => {this.setTableHeight();});

        this.table = {
            loaded: false,
            enableSorting: true,
            enableFiltering: true,
            enableGridMenu: true,
            enableCellEditOnFocus: true,
            enableRowSelection: true,
            modifierKeysToMultiSelect: true
        };

        this.table.columnDefs = this.defineColumns();

        this.table.onRegisterApi = (gridApi) => {
            this.gridApi = gridApi;
            this.$animate.enabled(gridApi.grid.element, false); //disable crappy menu animations
            gridApi.rowEdit.on.saveRow(this.$scope, (rowData) => { this.saveRow(rowData); });
        };

        this.load();
    }

    setTableHeight() {
        this.headerHeight = $("header").height();
        this.footerHeight = $("footer").height();
        this.menubarHeight = $("md-menu-bar").height();
        let tableHeight = $(window).height() - this.headerHeight - this.footerHeight - this.menubarHeight;
        $("div.fullTable").height(tableHeight);
    }

    defineColumns() {
        console.error("No columns defined, override defineColumns() function to define columns.");
        return [];
    }

    column(columnDef) {
        if(columnDef.type === 'boolean') {
            columnDef.cellTemplate = this.checkboxTemplate();
            columnDef.editableCellTemplate = this.checkboxTemplate();
            columnDef.maxWidth = 120;
        } else {
            columnDef.editableCellTemplate = this.inputTemplate();
        }
        return columnDef;
    }

    checkboxTemplate() {
        return '<div class="ui-grid-cell-contents ui-grid-cell-checkbox">' +
            '<md-checkbox class="md-primary" ng-class="\'colt\' + col.uid" ui-grid-editor ng-model="MODEL_COL_FIELD" aria-label="Checkbox"/></div>';
    }

    inputTemplate() {
        return '<div class="ui-grid-cell-input">' +
            '<input type="INPUT_TYPE" ng-class="\'colt\' + col.uid" ui-grid-editor ng-model="MODEL_COL_FIELD" /></div>';
    }

    load() {
        this.dataService.getAll().then((success) => {
            this.table.data = success.data;
            this.table.loaded = true;
        });
    }

    saveRow(rowData) {
        let promise = this.dataService.save(rowData);
        this.gridApi.rowEdit.setSavePromise(rowData, promise);
    }

    deleteSelected() {
        let selectedRows = this.gridApi.selection.getSelectedRows();
        selectedRows.forEach((selectedRow) => {
            this.dataService.remove(selectedRow.id).then(() => {
                for(var i = 0; i < this.table.data.length ; i++) {
                    if(this.table.data[i] === selectedRow) {
                        this.gridApi.selection.unSelectRow(selectedRow);
                        this.table.data.splice(i, 1);
                    }
                }
            });
        });
    }

}