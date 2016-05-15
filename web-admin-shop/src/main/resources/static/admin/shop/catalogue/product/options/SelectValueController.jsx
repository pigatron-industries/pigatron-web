
class SelectValueController extends AbstractController {

    /*@ngInject*/
    constructor($scope, $services) {
        super($scope, $services);
        this.option = this.$scope.option;
        if(!this.option.values) {
            this.option.values = [];
        }
    }

    addOptionItem() {
        this.option.values.push("");
    }

    removeOptionItem(index) {
        this.option.values.splice(index, 1);
    }
}

module.exports = SelectValueController;