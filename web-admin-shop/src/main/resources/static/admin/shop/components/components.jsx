
class FormatCurrency extends AbstractViewFormatter {

    /*@ngInject*/
    constructor($services) {
        super($services);
    }

    modelToView(modelValue) {
        return FormatCurrency.formatCurrency(modelValue);
    }

    viewToModel(viewValue) {
        return parseFloat(viewValue);
    }

    static formatCurrency(value) {
        if(value) {
            let dps = FormatCurrency.countDPs(value);
            if (dps < 2) dps = 2;
            return parseFloat(value).toFixed(dps);
        }
    }

    static countDPs(value) {
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
    .directive("pgFormatCurrency", FormatCurrency)
    .filter("currency", FormatCurrency.formatCurrency);

module.exports = {
    FormatCurrency: FormatCurrency
};