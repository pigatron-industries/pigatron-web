
const submodules = $("meta[name='_submodules']").attr("content").split(',');
var app = angular.module('admin', ['ngMaterial','ngMessages','ngAnimate','ui.router','ui.tree','cfp.hotkeys','mdColors']
    .concat(submodules));
app.controller('AdminController', AdminController);
app.controller('MessageController', MessageController);
app.service('httpInterceptor', HttpInterceptor);
app.config(AdminConfig);
