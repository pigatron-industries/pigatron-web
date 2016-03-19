
angular.module('admin.shop.catalogue', ['ui.tree'])
    .config(AdminShopConfig)
    .controller('CategoriesController', CategoriesController)
    .controller('CategoryController', CategoryController)
    .controller('ProductsController', ProductsController)
    .service('categoryService', CategoryService);
