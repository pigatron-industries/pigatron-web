
let skuUniqueValidator = function($q, productService) {
    return {
        restrict: "A",

        require: "ngModel",

        link: function(scope, element, attributes, ngModel) {

            ngModel.$asyncValidators.skuUnique = function(modelValue, viewValue) {
                var deferred = $q.defer();
                productService.countBySku(viewValue).then((success) => {
                    if(success.data === 1) {
                        deferred.reject();
                    } else {
                        deferred.resolve();
                    }
                });
                return deferred.promise;
            };

        }
    };
};

