
var SecurityConfig = require("./SecurityConfig");
var UsersController = require("./users/UsersController");
var UserService = require("./users/UserService");

angular.module('admin.security', [
        'admin.components',
        'ngAnimate',
        'ngMaterial',
        'ngMessages',
        'ui.grid',
        'ui.grid.edit',
        'ui.grid.rowEdit',
        'ui.grid.cellNav',
        'ui.grid.pinning',
        'ui.grid.resizeColumns',
        'ui.grid.selection',
        'ui.grid.draggable-rows'])
    .config(SecurityConfig);

register('admin.security')
    .controller('usersController', UsersController)
    .service('userService', UserService);
