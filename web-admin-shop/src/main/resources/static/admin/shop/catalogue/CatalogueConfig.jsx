
var CatalogueConfig = function($stateProvider) {

    $stateProvider.state('home', {
        url: "/",
        templateUrl: "/admin/shop/home.html"
    });
    $stateProvider.state('categories', {
        url: "/categories",
        templateUrl: "/admin/shop/catalogue/category/categories.html"
    });
    $stateProvider.state('categories.category', {
        url: "/:id",
        templateUrl: "/admin/shop/catalogue/category/categories.category.html"
    });
    $stateProvider.state('products', {
        url: "/products",
        templateUrl: "/admin/shop/catalogue/product/products.html"
    });
    $stateProvider.state('product', {
        url: "/products/:id",
        templateUrl: "/admin/shop/catalogue/product/product.html"
    });

};
