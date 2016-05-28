
require("./ckeditor/ng-ckeditor");

var CmsConfig = require("./CmsConfig");
var PagesController = require("./page/PagesController");
var PageController = require("./page/PageController");
var PageService = require("./page/PageService");

var PageValidators = require("./page/PageValidators");

angular.module('admin.cms', [
        'admin.components',
        'ngAnimate',
        'ngMaterial',
        'ngMessages',
        'ui.tree',
        'ui.grid',
        'ui.grid.edit',
        'ui.grid.rowEdit',
        'ui.grid.cellNav',
        'ui.grid.pinning',
        'ui.grid.resizeColumns',
        'ui.grid.selection',
        'ui.grid.draggable-rows',
        'ui.grid.treeView',
        'smoothScroll',
        'ngPatternRestrict',
        'ngCkeditor'])
    .config(CmsConfig);

register('admin.cms')
    .controller('PagesController', PagesController)
    .controller('PageController', PageController)
    .service('pageService', PageService)
    .directive('pageUrlUnique', PageValidators.PageUrlUniqueValidator);
