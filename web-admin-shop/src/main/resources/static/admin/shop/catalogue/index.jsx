
angular.module('admin.shop.catalogue', ['ngMaterial','ngMessages','ui.tree','data-table'])
    .config(CatalogueConfig)
    .controller('CategoriesController', CategoriesController)
    .controller('CategoryController', CategoryController)
    .controller('ProductsController', ProductsController)
    .controller('ProductController', ProductController)
    .service('categoryService', CategoryService)
    .service('productService', ProductService);
