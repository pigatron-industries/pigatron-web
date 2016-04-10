
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
            }
            else {
                let errorMessage = rejection.status + " " + rejection.statusText;
                if(rejection.status == -1) {
                    errorMessage = "Connection Lost";
                }
                this.$rootScope.notifyError(errorMessage);
            }
            return this.$q.reject(rejection);
        };
    }

}
