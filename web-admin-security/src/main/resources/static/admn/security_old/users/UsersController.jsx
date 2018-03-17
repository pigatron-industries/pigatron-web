

class UsersController extends webadmincore.AbstractTableController {

    /*@ngInject*/
    constructor($scope, $services, userService) {
        super($scope, $services, userService);
    }

    loadConfig() {
        this.tableConfig = {
            query: "",
            visibleFields: ['changePassword', 'username','roles[0].authority','locked']
        };
    }

    defineColumns() {
        super.defineColumns();
        this.table.columnDefs.push(this.column({ field: 'id',       enableCellEdit: false }));
        this.table.columnDefs.push(this.column({ field: 'username', enableCellEdit: true  }));
        this.table.columnDefs.push(this.column({ field: 'roles[0].authority',    enableCellEdit: false, name:"Role" }));
        this.table.columnDefs.push(this.column({ field: 'locked',   enableCellEdit: true,  type:'boolean' }));
    }

    onRegisterGridApi() {
        super.onRegisterGridApi();
        this.gridApi.core.addRowHeaderColumn(this.columnAction({ name:'changePassword', icon:"fa-pencil-square-o", tooltip:"Change Password",
                                             click:(row)=>{this.changePassword(row)} }));
    }

    changePassword() {
        console.log("changePassword TODO");
        //TODO
    }

    newUser() {
        console.log("newUser TODO");
        //TODO
    }


}

module.exports = UsersController;
