
class HttpInterceptor {

    /*@ngInject*/
    constructor($q, $rootScope) {
        this.$q = $q;
        this.$rootScope = $rootScope;

        this.request = (config) => {
            this.$rootScope.loading = true;
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            config.headers[header] = token;
            return config;
        };

        this.requestError = (rejection) => {
            this.$rootScope.loading = false;
            return this.$q.reject(rejection);
        };

        this.response = (response) => {
            this.$rootScope.loading = false;
            return response;
        };

        this.responseError = (rejection) => {
            this.$rootScope.loading = false;
            if (rejection.status == 401) {
                this.$rootScope.notifyError("Logging In...");
                location.reload();
            } else if (rejection.status > 404) {
                let errorMessage = rejection.status + " " + rejection.statusText;
                this.$rootScope.notifyError(errorMessage);
            } else if(rejection.status == -1) {
                let errorMessage = "Connection Lost";
                this.$rootScope.notifyError(errorMessage);
            }
            return this.$q.reject(rejection);
        };
    }

}

module.exports = HttpInterceptor;