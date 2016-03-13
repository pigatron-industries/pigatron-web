
app.config(function($stateProvider) {

    $stateProvider.state('home', {
        url: "/",
        templateUrl: "/admin/views/home.html"
    });
    $stateProvider.state('categories', {
        url: "/categories",
        templateUrl: "/admin/views/categories.html"
    });
    $stateProvider.state('categories.category', {
        url: "/:categoryId",
        templateUrl: "/admin/views/categories.category.html"
    });
    $stateProvider.state('products', {
        url: "/products",
        templateUrl: "/admin/views/products.html"
    });

});
