
require("./ckeditor/ng-ckeditor");

var CmsConfig = require("./CmsConfig");
var ContentsController = require("./content/ContentsController");
var ContentController = require("./content/ContentController");
var ContentService = require("./content/ContentService");
var ContentValidators = require("./content/ContentValidators");
var ImageDialogController = require("./content/ImageDialogController");

var ImagesController = require("./image/ImagesController");
var ImageService = require("./image/ImageService");


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
    .controller('ImageDialogController', ImageDialogController)
    .service('contentService', ContentService)
    .controller('ImagesController', ImagesController)
    .service('imageService', ImageService)
    .directive('pageUrlUnique', ContentValidators.PageUrlUniqueValidator);
