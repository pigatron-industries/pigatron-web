class AbstractRestService {

    constructor($http, baseUrl) {
        this.$http = $http;
        this.baseUrl = constants.URL_BASE + baseUrl;
    }

    getUrl(id) {
        return id ? (this.baseUrl + "/" + id) : this.baseUrl;
    }

    get(id) {
        return this.$http.get(this.getUrl(id));
    }

    getAll() {
        return this.$http.get(this.getUrl());
    }

    getQuery(query) {
        return this.$http.get(this.getUrl() + query);
    }

    save(data) {
        return this.$http.post(this.getUrl(), data);
    }

    remove(id) {
        return this.$http.delete(this.getUrl(id));
    }

}

module.exports = AbstractRestService;