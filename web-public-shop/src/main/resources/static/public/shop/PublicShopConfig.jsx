
/*@ngInject*/
var PublicShopConfig = function($mdThemingProvider, $stateProvider) {

    $stateProvider.state('category', {
        url: "/category/{urlKey}",
        templateUrl: "/public/shop/category.html"
    });
    $stateProvider.state('product', {
        url: "/product/{urlKey}",
        templateUrl: "/public/shop/product.html"
    });

};

module.exports = PublicShopConfig;

