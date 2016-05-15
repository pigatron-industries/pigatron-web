
var CatalogueConfig = require('./CatalogueConfig');

var CategoryController = require('./category/CategoryController');
var CategoriesController = require('./category/CategoriesController');
var CategoryService = require('./category/CategoryService');

var ImageService = require('./image/ImageService');

var ProductsController = require('./product/ProductsController');
var ProductController = require('./product/ProductController');
var ProductService = require('./product/ProductService');
var ProductsSelectorController = require('./product/selector/ProductsSelectorController');
var productValidators = require('./product/ProductValidators');

var SelectProductController = require('./product/options/SelectProductController');
var SelectValueController = require('./product/options/SelectValueController');


angular.module('admin.shop.catalogue', [
        'admin.components',
        'admin.shop.components',
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
    .config(CatalogueConfig);

register('admin.shop.catalogue')
    .controller('CategoriesController', CategoriesController)
    .controller('CategoryController', CategoryController)
    .controller('ProductsController', ProductsController)
    .controller('ProductController', ProductController)
    .controller('ProductsSelectorController', ProductsSelectorController)
    .controller('selectProductController', SelectProductController)
    .controller('selectValueController', SelectValueController)
    .service('imageService', ImageService)
    .service('categoryService', CategoryService)
    .service('productService', ProductService)
    .directive("skuUnique", productValidators.SkuUniqueValidator)
    .directive("urlUnique", productValidators.UrlUniqueValidator)
    .filter("listCategories", ProductsController.listCategories);
