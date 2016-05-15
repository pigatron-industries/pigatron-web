
class ServiceBundle {

    /*@ngInject*/
    constructor($rootScope, $state, $stateParams, $q, $timeout, $animate, $window) {
        this.$rootScope = $rootScope;
        this.$state = $state;
        this.$stateParams = $stateParams;
        this.$q = $q;
        this.$timeout = $timeout;
        this.$animate = $animate;
        this.$window = $window;
    }

}

module.exports = ServiceBundle;