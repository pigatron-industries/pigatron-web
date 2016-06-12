
var AbstractController = require('./AbstractController');

class AbstractFormController extends AbstractController {

    constructor($scope, $services, dataService) {
        super($scope, $services);
        this.dataService = dataService;
        if(this.$stateParams.id == 'new') {
            this.create();
        } else {
            this.load(this.$stateParams.id);
        }
    }

    load(id) {
        return this.dataService.get(id)
            .then((success) => {
                this.formData = success.data;
                this.setPristine();
                return success;
            });
    }

    create() {
        this.formData = {};
    }

    save() {
        return this.dataService.save(this.formData)
            .then((success) => {
                this.$state.go(this.$state.current.name, {id: success.data.id});
                this.formData = success.data;
                this.setPristine();
                return success;
            }, (error) => {
                console.log(error);
                return error;
            });
    }

}

module.exports = AbstractFormController;
