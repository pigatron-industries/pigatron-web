
class AbstractServiceBundleConsumer {

    constructor($services) {
        this.$services = $services;
        this.$rootScope = $services.$rootScope;
        this.$state = $services.$state;
        this.$stateParams = $services.$stateParams;
        this.$q = $services.$q;
        this.$timeout = $services.$timeout;
        this.$animate = $services.$animate;
        this.$window = $services.$window;
    }

}

module.exports = AbstractServiceBundleConsumer;
