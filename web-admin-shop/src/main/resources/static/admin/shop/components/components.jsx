
class FormatCurrency extends AbstractViewFormatter {

    /*@ngInject*/
    constructor($services) {
        super($services);
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
