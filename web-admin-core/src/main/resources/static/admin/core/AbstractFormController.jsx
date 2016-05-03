
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
        this.$scope.$on(EVENT_FORM_DIRTY, () => {this.setDirty();});
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

    setPristine() {
        this.$scope.form.$setPristine();
    }

    setDirty() {
        this.$scope.form.$setDirty();
    }

}