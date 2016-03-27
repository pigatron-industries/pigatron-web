
class ServiceBundle {

    /*@ngInject*/
    constructor($state, $stateParams, $q, $timeout, $animate) {
        this.$state = $state;
        this.$stateParams = $stateParams;
        this.$q = $q;
        this.$timeout = $timeout;
        this.$animate = $animate;
    }

}


class AbstractServiceBundleConsumer {

    constructor($services) {
        this.$services = $services;
        this.$state = $services.$state;
        this.$stateParams = $services.$stateParams;
        this.$q = $services.$q;
        this.$timeout = $services.$timeout;
        this.$animate = $services.$animate;
    }

}