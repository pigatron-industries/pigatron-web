
var AbstractServiceBundleConsumer = require('./AbstractServiceBundleConsumer');

class AbstractController extends AbstractServiceBundleConsumer {

    constructor($scope, $services) {
        super($services);
        this.$scope = $scope;
        if(this.$scope.$on) {
            this.$scope.$on(constants.events.EVENT_ADMIN_SAVE,    () => {this.save();});
            this.$scope.$on(constants.events.EVENT_FORM_PRISTINE, () => {this.setPristine();});
            this.$scope.$on(constants.events.EVENT_FORM_DIRTY,    () => {this.setDirty();});
        }
    }

    setPristine() {
        if(this.$scope.form) {
            this.$scope.form.$setPristine();
        } //else {
        //    this.$scope.$emit(EVENT_FORM_PRISTINE);
        //}
    }

    setDirty() {
        if(this.$scope.form) {
            this.$scope.form.$setDirty();
        } //else {
        //    this.$scope.$emit(EVENT_FORM_DIRTY);
        //}
    }

    /**
     * Bind a function to an element event and remove the binding when the controller is destroyed.
     * @param element
     * @param event
     * @param func
     */
    eventOnOff(element, event, func) {
        element.on(event, func);
        this.$scope.$on('$destroy', () => {
            element.off(event, func);
        });
    }

    /**
     * Bind a function to an element event and remove the binding when the controller is destroyed,
     * and also run the function immediately.
     * @param element
     * @param event
     * @param func
     */
    eventOnOffNow(element, event, func) {
        this.$timeout(func, 1);
        this.eventOnOff(element, event, func);
    }

    isScrolledVisible(elementId) {
        const anchorOffset = 20;
        let element = $("#"+elementId);
        let scrollTop = $(this.$window).scrollTop() - anchorOffset;
        let scrollBottom = scrollTop + $(this.$window).height() - anchorOffset;
        let elementPos = element.offset().top;
        return elementPos > scrollTop && elementPos < scrollBottom;
    }
}

module.exports = AbstractController;