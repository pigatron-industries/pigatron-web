
angular.module('public', ['ngMaterial','ngMessages','ngAnimate','ui.router','mdColors'])
    .config(PublicConfig);
register('public')
    .controller('PublicController', PublicController);