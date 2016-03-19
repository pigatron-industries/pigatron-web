
var AdminShopConfig = function($stateProvider) {

    $stateProvider.state('home', {
        url: "/",
        templateUrl: "/admin/views/home.html"
    });
    $stateProvider.state('categories', {
        url: "/categories",
        templateUrl: "/admin/catalogue/views/categories.html"
    });
    $stateProvider.state('categories.category', {
        url: "/:categoryId",
        templateUrl: "/admin/catalogue/views/categories.category.html"
    });
    $stateProvider.state('products', {
        url: "/products",
        templateUrl: "/admin/catalogue/views/products.html"
    });

};
