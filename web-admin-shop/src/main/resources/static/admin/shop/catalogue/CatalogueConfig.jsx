
/*@ngInject*/
var CatalogueConfig = function($stateProvider) {

    constants.routes.SHOP_CATALOGUE_CATEGORIES = 'categories';
    constants.routes.SHOP_CATALOGUE_CATEGORY   = 'categories.category';
    constants.routes.SHOP_CATALOGUE_PRODUCTS   = 'products';
    constants.routes.SHOP_CATALOGUE_PRODUCT    = 'product';
    constants.events.SHOP_CATALOGUE_CATEGORIES_CHANGED        = 'shop.catalogue.categories.changed';
    constants.events.SHOP_CATALOGUE_PRODUCT_SELECTOR_ONSELECT = 'shop.catalogue.product.selector.onselect';
    constants.events.SHOP_CATALOGUE_PRODUCT_SELECTOR_OPEN     = 'shop.catalogue.product.selector.open';

    $stateProvider.state('home', {
        url: "/",
        templateUrl: "/admin/shop/home.html"
    });
    $stateProvider.state(constants.routes.SHOP_CATALOGUE_CATEGORIES, {
        url: "/categories",
        templateUrl: "/admin/shop/catalogue/category/categories.html"
    });
    $stateProvider.state(constants.routes.SHOP_CATALOGUE_CATEGORY, {
        url: "/:id",
        params: {parentId:null},
        templateUrl: "/admin/shop/catalogue/category/categories.category.html"
    });
    $stateProvider.state(constants.routes.SHOP_CATALOGUE_PRODUCTS, {
        url: "/products",
        templateUrl: "/admin/shop/catalogue/product/products.html"
    });
    $stateProvider.state(constants.routes.SHOP_CATALOGUE_PRODUCT, {
        url: "/products/:id",
        templateUrl: "/admin/shop/catalogue/product/product.html"
    });

};

module.exports = CatalogueConfig;