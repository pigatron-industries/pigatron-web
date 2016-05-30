
const API_CONTENT = "api/cms/content";

class ContentService extends webpubliccore.AbstractRestService {

    /*@ngInject*/
    constructor($http) {
        super($http, API_CONTENT);
    }

    getPageByUrlKey(urlKey) {
        return this.$http.get(this.baseUrl + "/page?urlKey=" + urlKey);
    }

}

module.exports = ContentService;