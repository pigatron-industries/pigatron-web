
var register = require('./lib/register');
var AdminConfig = require('./AdminConfig');
var ServiceBundle = require('./abstract/ServiceBundle');
var HttpInterceptor = require('./controller/HttpInterceptor');
var StickToTop = require('./components/StickToTop');
require('./lib/md-colours');

var AdminController = require('./controller/AdminController');
var MessageController = require('./controller/MessageController');
var SettingsController = require('./settings/SettingsController');
var SettingsService = require('./settings/SettingsService');
var SettingsWebsiteController = require('./settings/website/SettingsWebsiteController');
var SettingsWebsiteLinksController = require('./settings/website/SettingsWebsiteLinksController');

module.exports = {
    adminThemeConfig: require('./AdminThemeConfig'),
    AbstractController: require('./abstract/AbstractController'),
    AbstractFormController: require('./abstract/AbstractFormController'),
    AbstractRestService: require('./abstract/AbstractRestService'),
    AbstractServiceBundleConsumer: require('./abstract/AbstractServiceBundleConsumer'),
    AbstractTableController: require('./abstract/AbstractTableController'),
    AbstractAsyncValidator: require('./components/AbstractAsyncValidator'),
    AbstractViewFormatter: require('./components/AbstractViewFormatter')
};

var submodules = [];
if($("meta[name='_submodules']").attr("content")) {
    submodules = $("meta[name='_submodules']").attr("content").split(',');
}
angular.module('admin', [
        'ngMaterial',
        'ngMessages',
        'ngAnimate',
        'cfp.hotkeys',
        'mdColors',
        'ui.router',
        'ui.tree',
        'ui.grid',
        'ui.grid.edit',
        'ui.grid.rowEdit',
        'ui.grid.resizeColumns',
        'ui.grid.draggable-rows']
    .concat(submodules))
    .config(AdminConfig);
register('admin')
    .controller('AdminController', AdminController)
    .controller('MessageController', MessageController)
    .controller('SettingsController', SettingsController)
    .controller('SettingsWebsiteController', SettingsWebsiteController)
    .controller('SettingsWebsiteLinksController', SettingsWebsiteLinksController)
    .service('$services', ServiceBundle)
    .service('httpInterceptor', HttpInterceptor)
    .service('settingsService', SettingsService);

angular.module('admin.components', []);
register('admin.components')
    .directive("stickToTop", StickToTop);