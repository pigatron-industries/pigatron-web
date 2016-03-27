
class HttpInterceptor {

    /*@ngInject*/
    constructor($q) {
        this.$q = $q;
    }

    request(config) {
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        config.headers[header] = token;
        return config;
    }

    requestError(rejection) {
        return this.$q.reject(rejection);
    }

    response(response) {
        return response;
    }

    responseError(rejection) {
        if(rejection.status == 401) {
            location.reload();
        } else {
            window.$rootScope.notifyError(rejection.status + " " + rejection.statusText);
        }
        return this.$q.reject(rejection);
    }

}
