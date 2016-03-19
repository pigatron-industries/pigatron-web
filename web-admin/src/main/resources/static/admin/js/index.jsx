
const submodules = $("meta[name='_submodules']").attr("content").split(',');
angular.module('admin', ['ngMaterial','ngMessages','ngAnimate','ui.router','ui.tree','cfp.hotkeys','mdColors'].concat(submodules))
    .config(AdminConfig)
    .controller('AdminController', AdminController)
    .controller('MessageController', MessageController)
    .service('httpInterceptor', HttpInterceptor);
