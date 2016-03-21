
abstract form controllerclass AbstractFormController {

    constructor($scope, $state, $stateParams, dataService) {
        this.$scope = $scope;
        this.$state = $state;
        this.$stateParams = $stateParams;
        this.dataService = dataService;
        if($stateParams.id == 'new') {
            this.formData = {};
        } else {
            this.load($stateParams.id);
        }
    }

    load(id) {
        this.dataService.get(id)
            .then((success) => {
                this.formData = success.data;
                this.setPristine();
            });
    }

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