
class AbstractFormController extends AbstractController {

    constructor($scope, $services, dataService) {
        super($scope, $services);
        this.dataService = dataService;
        if(this.$stateParams.id == 'new') {
            this.create();
        } else {
            this.load(this.$stateParams.id); //TODO load after timeout
        }
        this.$scope.$on(EVENT_ADMIN_SAVE, () => {this.save();});
    }

    //TODO return promise from load
    load(id) {
        this.dataService.get(id)
            .then((success) => {
                this.formData = success.data;
                this.setPristine();
            });
    }

    create() {
        this.formData = {};
    }

    //TODO return promise from save
    save() {
        this.dataService.save(this.formData)
            .then((success) => {
                this.$state.go(this.$state.current.name, {id: success.data.id});
                this.setPristine();
            }, (error) => {
                console.log(error);
                //TODO handle errors
            });
    }

    setPristine() {
        this.$scope.form.$setPristine();
    }

}