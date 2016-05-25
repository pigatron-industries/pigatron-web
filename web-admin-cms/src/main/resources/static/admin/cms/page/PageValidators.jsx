
class PageUrlUniqueValidator extends webadmincore.AbstractAsyncValidator {

    /*@ngInject*/
    constructor($services, pageService) {
        super("pageUrlUnique", $services);
        this.productService = pageService;
    }

    validate(deferred, value) {
        this.productService.getByUrlKey(value).then((success) => {
            if(success.data.id == undefined || success.data.id == this.attributes.pageUrlUnique) {
                deferred.resolve();
            } else {
                deferred.reject();
            }
        });
    }

}

module.exports = {
    PageUrlUniqueValidator: PageUrlUniqueValidator
};