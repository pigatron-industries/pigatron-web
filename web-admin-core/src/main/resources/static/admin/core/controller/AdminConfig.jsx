
var adminThemeConfig = require('./AdminThemeConfig');

window.constants = {
    URL_BASE: $("base").attr("href"),
    routes: {},
    events: {
        EVENT_ADMIN_SAVE: 'event.form.save',
        EVENT_FORM_DIRTY: 'event.form.dirty',
        EVENT_FORM_PRISTINE: 'event.form.pristine'
    }
};

/*@ngInject*/
var AdminConfig = function($mdThemingProvider, $stateProvider, $locationProvider, $urlRouterProvider, hotkeysProvider,
         $httpProvider, $provide, $compileProvider) {

    adminThemeConfig($mdThemingProvider);
    $compileProvider.debugInfoEnabled(false);
    $locationProvider.html5Mode(true);
    $urlRouterProvider.otherwise("/");

    hotkeysProvider.cheatSheetHotkey = 'meta+/';

    $httpProvider.interceptors.push("httpInterceptor");

    //$provide.decorator("$exceptionHandler", ['$delegate', function($delegate) {
    //    return function(exception, cause) {
    //        $delegate(exception, cause);
    //        window.$rootScope.notifyError(exception);
    //    };
    //}]);
};

module.exports = AdminConfig;