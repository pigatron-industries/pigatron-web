
class HttpInterceptor {

    /*@ngInject*/
    constructor($q, $rootScope) {
        this.$q = $q;
        this.$rootScope = $rootScope;
    }

    request(config) {
        this.$rootScope.loading = true;
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        config.headers[header] = token;
        return config;
    }

    requestError(rejection) {
        this.$rootScope.loading = false;
        return this.$q.reject(rejection);
    }

    response(response) {
        this.$rootScope.loading = false;
        return response;
    }

    responseError(rejection) {
        this.$rootScope.loading = false;
        if(rejection.status == 401) {
            location.reload();
        } else {
            window.$rootScope.notifyError(rejection.status + " " + rejection.statusText);
        }
        return this.$q.reject(rejection);
    }

}
