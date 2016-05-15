
class SkuUniqueValidator extends webadmincore.AbstractAsyncValidator {

    /*@ngInject*/
    constructor($services, productService) {
        super("skuUnique", $services);
        this.productService = productService;
    }

    validate(deferred, value) {
        this.productService.getBySku(value).then((success) => {
            if(success.data.id == undefined || success.data.id == this.attributes.skuUnique) {
                deferred.resolve();
            } else {
                deferred.reject();
            }
        });
    }

}

class UrlUniqueValidator extends webadmincore.AbstractAsyncValidator {

    /*@ngInject*/
    constructor($services, productService) {
        super("urlUnique", $services);
        this.productService = productService;
    }

    validate(deferred, value) {
        this.productService.getByUrlKey(value).then((success) => {
            if(success.data.id == undefined || success.data.id == this.attributes.urlUnique) {
                deferred.resolve();
            } else {
                deferred.reject();
            }
        });
    }

}

module.exports = {
    SkuUniqueValidator: SkuUniqueValidator,
    UrlUniqueValidator: UrlUniqueValidator
};