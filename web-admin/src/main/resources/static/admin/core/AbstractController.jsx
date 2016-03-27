
class AbstractController extends AbstractServiceBundleConsumer {

    constructor($scope, $services) {
        super($services);
        this.$scope = $scope;
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
