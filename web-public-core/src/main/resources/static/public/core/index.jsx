
require('./lib/md-colours');
var register = require('./lib/register');
var PublicConfig = require('./PublicConfig');
var PublicController = require('./PublicController');

module.exports = {
    AbstractRestService: require('./abstract/AbstractRestService')
};

var submodules = [];
if($("meta[name='_submodules']").attr("content")) {
    submodules = $("meta[name='_submodules']").attr("content").split(',');
}
angular.module('public', ['ngMaterial','ngMessages','ngAnimate','ui.router','mdColors'].concat(submodules))
    .config(PublicConfig);
register('public')
    .controller('PublicController', PublicController);
