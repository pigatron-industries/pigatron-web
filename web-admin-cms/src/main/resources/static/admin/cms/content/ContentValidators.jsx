
class PageUrlUniqueValidator extends webadmincore.AbstractAsyncValidator {

    /*@ngInject*/
    constructor($services, contentService) {
        super("pageUrlUnique", $services);
        this.contentService = contentService;
    }

    validate(deferred, value) {
        if(value == "") {
            deferred.resolve();
            return;
        }
        this.contentService.getByUrlKey(value).then((success) => {
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