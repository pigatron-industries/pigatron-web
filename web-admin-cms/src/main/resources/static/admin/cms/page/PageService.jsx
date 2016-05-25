
const API_ADMIN_PAGE = "api/cms/page";

class PageService extends webadmincore.AbstractRestService {

    /*@ngInject*/
    constructor($http) {
        super($http, API_ADMIN_PAGE);
    }

    getByUrlKey(urlKey) {
        return this.$http.get(this.baseUrl + "?urlKey=" + urlKey);
    }

}

module.exports = PageService;