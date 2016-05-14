
class AbstractAsyncValidator extends AbstractServiceBundleConsumer {

    constructor(name, $services) {
        super($services);
        this.name = name;
        this.scope = {};
        this.restrict = "A";
        this.require = "ngModel";
    }

    link(scope, element, attributes, ngModel) {
        this.scope = scope;
        this.element = element;
        this.attributes = attributes;
        this.ngModel = ngModel;
        this.ngModel.$asyncValidators[this.name] = (modelValue, viewValue) => {
            var deferred = this.$q.defer();
            this.validate(deferred, modelValue, viewValue);
            return deferred.promise;
        };
    }

}
