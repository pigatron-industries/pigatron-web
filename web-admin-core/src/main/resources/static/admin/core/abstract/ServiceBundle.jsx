
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


class AbstractServiceBundleConsumer {

    constructor($services) {
        this.$services = $services;
        this.$rootScope = $rootScope;
        this.$state = $services.$state;
        this.$stateParams = $services.$stateParams;
        this.$q = $services.$q;
        this.$timeout = $services.$timeout;
        this.$animate = $services.$animate;
        this.$window = $services.$window;
    }

}