
require("./ckeditor/ng-ckeditor");

var CmsConfig = require("./CmsConfig");
var ContentsController = require("./content/ContentsController");
var ContentController = require("./content/ContentController");
var ContentService = require("./content/ContentService");

var ContentValidators = require("./content/ContentValidators");

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
    .controller('ContentsController', ContentsController)
    .controller('ContentController', ContentController)
    .service('contentService', ContentService)
    .directive('pageUrlUnique', ContentValidators.PageUrlUniqueValidator);
