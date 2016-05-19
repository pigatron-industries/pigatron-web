
var register = require('./lib/register');
var AdminConfig = require('./controller/AdminConfig');
var AdminController = require('./controller/AdminController');
var MessageController = require('./controller/MessageController');
var ServiceBundle = require('./abstract/ServiceBundle');
var HttpInterceptor = require('./controller/HttpInterceptor');
var StickToTop = require('./components/StickToTop');
require('./lib/md-colours');

module.exports = {
    adminThemeConfig: require('./controller/AdminThemeConfig'),
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
angular.module('admin', ['ngMaterial','ngMessages','ngAnimate','ui.router','ui.tree','cfp.hotkeys','mdColors'].concat(submodules))
    .config(AdminConfig);
register('admin')
    .controller('AdminController', AdminController)
    .controller('MessageController', MessageController)
    .service('$services', ServiceBundle)
    .service('httpInterceptor', HttpInterceptor);

angular.module('admin.components', []);
register('admin.components')
    .directive("stickToTop", StickToTop);