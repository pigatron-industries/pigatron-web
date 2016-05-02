
class AbstractViewFormatter extends AbstractServiceBundleConsumer {

    constructor($services) {
        super({}, $services);
        this.scope = {};
        this.restrict = "A";
        this.require = "ngModel";
    }

    link(scope, element, attributes, ngModel) {
        var listener = () => {
            element.val(this.modelToView(element.val()));
        };

        // This runs when we update the text field
        ngModel.$parsers.push((viewValue) => {
            return this.viewToModel(viewValue);
        });

        // This runs when the model gets updated on the scope directly and keeps our view in sync
        ngModel.$render = () => {
            element.val(this.modelToView(ngModel.$viewValue));
        };

        element.bind('change', listener);
    }

}