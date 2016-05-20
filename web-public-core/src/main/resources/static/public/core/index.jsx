
require('./lib/md-colours');
var register = require('./lib/register');
var PublicConfig = require('./PublicConfig');
var PublicController = require('./PublicController');

angular.module('public', ['ngMaterial','ngMessages','ngAnimate','ui.router','mdColors'])
    .config(PublicConfig);
register('public')
    .controller('PublicController', PublicController);
