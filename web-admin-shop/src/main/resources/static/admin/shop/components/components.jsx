
class FormatCurrency extends AbstractController {

    /*@ngInject*/
    constructor($services, $filter, $browser) {
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

    modelToView(modelValue) {
        if(modelValue) {
            let dps = this.countDPs(modelValue);
            if (dps < 2) dps = 2;
            return parseFloat(modelValue).toFixed(dps);
        }
    }

    viewToModel(viewValue) {
        return parseFloat(viewValue);
    }

    countDPs(value) {
        let parts = value.toString().split('.');
        if(parts.length > 1) {
            return parts[1].length;
        } else {
            return 0;
        }
    }

}

angular.module('admin.shop.components', []);
register('admin.shop.components')
    .directive("pgFormatCurrency", FormatCurrency);
