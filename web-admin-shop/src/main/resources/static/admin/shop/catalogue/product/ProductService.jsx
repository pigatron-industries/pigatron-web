
const API_ADMIN_PRODUCT = "/shopadmin/api/catalogue/product";

class ProductService extends AbstractRestService {

    constructor($http) {
        super($http, API_ADMIN_PRODUCT);
    }

    countBySku(sku) {
        return this.$http.get(this.baseUrl + "/count?sku=" + sku);
    }

}