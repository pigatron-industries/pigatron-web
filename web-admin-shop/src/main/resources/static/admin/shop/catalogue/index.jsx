
angular.module('admin.shop.catalogue', [
        'ngMaterial',
        'ngMessages',
        'ui.tree',
        'ui.grid',
        'ui.grid.edit',
        'ui.grid.rowEdit',
        'ui.grid.cellNav',
        'ui.grid.pinning',
        'ui.grid.resizeColumns',
        'ui.grid.selection'])
    .config(CatalogueConfig)
    .controller('CategoriesController', CategoriesController)
    .controller('CategoryController', CategoryController)
    .controller('ProductsController', ProductsController)
    .controller('ProductController', ProductController)
    .service('categoryService', CategoryService)
    .service('productService', ProductService)
    .directive("skuUnique", skuUniqueValidator);
