
class AbstractRestService {

    constructor($http, baseUrl) {
        this.$http = $http;
        this.baseUrl = baseUrl;
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

    save(data) {
        return this.$http.post(this.getUrl(), data);
    }

    delete(id) {
        this.$http.delete(this.getUrl(id));
    }

}
