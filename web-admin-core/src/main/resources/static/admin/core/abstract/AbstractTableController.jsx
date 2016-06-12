
var AbstractController = require('./AbstractController');

class AbstractTableController extends AbstractController {

    constructor($scope, $services, dataService) {
        super($scope, $services);
        this.dataService = dataService;

        this.table = {
            loaded: false,
            enableCellEditOnFocus: true,
            modifierKeysToMultiSelect: true,
            enableHorizontalScrollbar: 0,
            enableVerticalScrollbar: 0
        };
        this.enableGridMenu(true);
        this.enableSorting(true);
        this.enableFiltering(true);
        this.enableRowSelection(true);

        this.loadConfig();
        this.defineColumns();

        this.table.onRegisterApi = (gridApi) => {
            this.gridApi = gridApi;
            this.onRegisterGridApi();
        };

        this.$timeout(()=>{this.load()}, 1);
    }

    onRegisterGridApi() {
        this.$animate.enabled(this.gridApi.grid.element, false); //disable crappy menu animations
        if(this.gridApi.edit) {
            this.gridApi.edit.on.afterCellEdit(this.$scope, (rowData, colDef, newValue, oldValue) => {
                this.afterCellEdit(rowData, colDef, newValue, oldValue);
            });
        }
        if(this.gridApi.rowEdit) {
            this.gridApi.rowEdit.on.saveRow(this.$scope, (rowData) => {
                this.saveRow(rowData);
            });
        }
        if(this.gridApi.draggableRows) {
            this.gridApi.draggableRows.on.rowDropped(this.$scope, (info, dropTarget) => {
                this.setDirty();
            });
        }
    }

    enableGridMenu(enable) {
        this.table.enableGridMenu = enable;
    }

    enableRowSelection(enable) {
        this.table.enableRowSelection = enable;
        this.table.enableRowHeaderSelection = enable;
    }

    enableFiltering(enable) {
        this.table.enableFiltering = enable;
    }

    enableSorting(enable) {
        this.table.enableSorting = enable;
    }

    enableDraggableRows() {
        this.table.rowTemplate = '<div grid="grid" class="ui-grid-draggable-row" draggable="true">' +
            '<div ng-repeat="(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name" class="ui-grid-cell" ' +
            'ng-class="{ \'ui-grid-row-header-cell\': col.isRowHeader, \'custom\': true }" ui-grid-cell></div></div>';
        this.table.useUiGridDraggableRowsHandle = true;
        this.table.columnDefs.push(this.columnDrag({ name:'drag', icon:"fa-bars"}));
    }

    loadConfig() {
        console.error("No table config defined, override loadConfig() function to load table config.");
        return {};
    }

    defineColumns() {
        this.table.columnDefs = [];
    }

    column(column) {
        column.visible = true;
        if(this.tableConfig) {
            column.visible = this.tableConfig.visibleFields.indexOf(column.field) > -1;
        }
        if(column.type === 'boolean') {
            if(column.enableCellEdit == true) {
                this.$scope[column.name] = (row, colDef) => { this.afterCellEdit(row, colDef) };
                column.cellTemplate = AbstractTableController.checkboxTemplate(column);
                //column.editableCellTemplate = AbstractTableController.checkboxTemplate();
                column.enableCellEdit = false;
            } else {
                //TODO readonly checkbox
            }
            column.maxWidth = 120;
        } else {
            if(!column.editableCellTemplate) {
                column.editableCellTemplate = AbstractTableController.inputTemplate();
            }
        }
        return column;
    }

    columnAction(column) {
        column.visible = true;
        if(this.tableConfig) {
            column.visible = this.tableConfig.visibleFields.indexOf(column.name) > -1;
        }
        column.enableCellEdit = false;
        column.enableSorting = false;
        column.enableHiding = false;
        column.enableColumnMenu = false;
        column.enableFiltering = false;
        column.enableColumnResizing = false;
        column.pinnedLeft = true;
        column.displayName = "";
        column.width = 30;
        column.cellTemplate = this.actionColumnTemplate(column);
        return column;
    }

    actionColumnTemplate(column) {
        let template = "<a class='ui-grid-cell-contents' ";
        if(column.sref !== undefined) {
            template += "ui-sref='" + column.sref + "'>";
        } else if(column.click !== undefined) {
            this.$scope[column.name] = column.click;
            template += "ng-click='grid.appScope." + column.name + "(row)'>";
        } else {
            template += ">";
        }
        if(column.tooltip) {
            template += "<md-tooltip md-direction='bottom'>" + column.tooltip + "</md-tooltip>";
        }
        template += "<span class='fa fa-lg " + column.icon + "'></span></a>";
        return template;
    }

    columnDrag(column) {
        column = this.columnAction(column);
        column.cellTemplate = AbstractTableController.dragColumnTemplate(column);
        return column;
    }

    static dragColumnTemplate(column) {
        let template = "<a class='ui-grid-cell-contents ui-grid-draggable-row-handle'>";
        template += "<span class='fa fa-lg " + column.icon + "'></span></a>";
        return template;
    }

    static checkboxTemplate(column) {
        return '<div class="ui-grid-cell-contents ui-grid-cell-checkbox">' +
            '<md-checkbox class="md-primary" ng-class="\'colt\' + col.uid" ui-grid-editor ng-model="MODEL_COL_FIELD" ' +
            'ng-click="grid.appScope.' + column.name + '(row.entity, col.colDef)" aria-label="Checkbox"/></div>';
    }

    static inputTemplate() {
        return '<div class="ui-grid-cell-input">' +
            '<input type="INPUT_TYPE" ng-class="\'colt\' + col.uid" ui-grid-editor ng-model="MODEL_COL_FIELD" /></div>';
    }

    setTableHeight() {
        this.headerHeight = $("header").height();
        this.footerHeight = $("footer").height();
        this.menubarHeight = $("md-menu-bar").height();
        let tableHeight = $(window).height() - this.headerHeight - this.footerHeight - this.menubarHeight;
        $("div.fullTable").height(tableHeight);
    }

    /**
     * Get preferred height of table to fit all rows in.
     * @return Object height as css style
     */
    getTableHeight() {
        var rowHeight = 30;
        var headerHeight;
        if(this.table.enableFiltering) {
            headerHeight = 55;
        } else {
            headerHeight = 30;
        }
        var tableHeight = this.table.data.length * rowHeight + headerHeight;
        return {
            height: tableHeight+"px"
        };
    }

    load() {
        return this.dataService.getQuery(this.tableConfig.query).then((success) => {
            this.table.data = success.data;
            this.eventOnOffNow($(window), 'resize', () => {this.setTableHeight();});
            this.$timeout(() => {this.table.loaded = true}, 100);
        });
    }

    afterCellEdit(rowData, colDef, newValue, oldValue) {
        if(newValue != oldValue || colDef.type == "boolean") {
            rowData.$dirty = true;
        }
    }

    save() {
        if(this.dataService) {
            let promises = [];
            this.table.data.forEach((rowData) => {
                if (rowData.$dirty == true) {
                    promises.push(this.saveRow(rowData).then((success) => {
                        //TODO reload row success.data
                    }));
                }
            });
            this.$q.all(promises).then(() => {
                this.setPristine();
            });
        }
    }

    /**
     * Called automatically after editing row when using ui-grid-row-edit,
     * or manually via save() when using ui-grid-edit
     * @param rowData
     */
    saveRow(rowData) {
        let promise = this.dataService.save(rowData);
        if(this.gridApi.rowEdit) {
            this.gridApi.rowEdit.setSavePromise(rowData, promise);
        }
        return promise;
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

    newRow() {
        console.log("new Row");
        this.table.data.push({});
        this.refreshTableHeight();
    }

    refreshTableHeight() {
        this.$timeout(() => {
            this.gridApi.core.handleWindowResize();
        }, 1);
    }

}

module.exports = AbstractTableController;