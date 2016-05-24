
var CmsConfig = require("./CmsConfig");

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
        'as.sortable',
        'lfNgMdFileInput',
        'smoothScroll',
        'ngPatternRestrict'])
    .config(CmsConfig);


