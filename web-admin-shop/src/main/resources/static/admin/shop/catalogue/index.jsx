
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
    .service('imageService', ImageService)
    .service('categoryService', CategoryService)
    .service('productService', ProductService)
    .directive("skuUnique", SkuUniqueValidator)
    .directive("urlUnique", UrlUniqueValidator)
    .filter("listCategories", ProductsController.listCategories);