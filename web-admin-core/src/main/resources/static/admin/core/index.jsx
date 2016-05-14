
const URL_BASE = angular.element("base").attr("href");

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