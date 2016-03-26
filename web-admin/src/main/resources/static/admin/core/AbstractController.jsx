
class AbstractController {

    constructor($scope, $services) {
        this.$scope = $scope;
        this.$services = $services;
        this.$state = $services.$state;
        this.$stateParams = $services.$stateParams;
        this.$timeout = $services.$timeout;
        this.$animate = $services.$animate;
    }

    eventOnOff(element, event, func) {
        element.on(event, func);
        this.$scope.$on('$destroy', () => {
            element.off(event, func);
        });
    }

    eventOnOffNow(element, event, func) {
        this.$timeout(func, 1);
        this.eventOnOff(element, event, func);
    }
}
