
const EVENT_SHOP_CATALOGUE_CATEGORIES_CHANGED        = 'shop.catalogue.categories.changed';
const EVENT_SHOP_CATALOGUE_PRODUCT_SELECTOR_ONSELECT = 'shop.catalogue.product.selector.onselect';
const EVENT_SHOP_CATALOGUE_PRODUCT_SELECTOR_OPEN     = 'shop.catalogue.product.selector.open';

const ROUTE_SHOP_CATALOGUE_CATEGORIES = 'categories';
const ROUTE_SHOP_CATALOGUE_CATEGORY = 'categories.category';
const ROUTE_SHOP_CATALOGUE_PRODUCTS = 'products';
const ROUTE_SHOP_CATALOGUE_PRODUCT = 'product';


var CatalogueConfig = function($stateProvider) {

    $stateProvider.state('home', {
        url: "/",
        templateUrl: "/admin/shop/home.html"
    });
    $stateProvider.state(ROUTE_SHOP_CATALOGUE_CATEGORIES, {
        url: "/categories",
        templateUrl: "/admin/shop/catalogue/category/categories.html"
    });
    $stateProvider.state(ROUTE_SHOP_CATALOGUE_CATEGORY, {
        url: "/:id",
        params: {parentId:null},
        templateUrl: "/admin/shop/catalogue/category/categories.category.html"
    });
    $stateProvider.state(ROUTE_SHOP_CATALOGUE_PRODUCTS, {
        url: "/products",
        templateUrl: "/admin/shop/catalogue/product/products.html"
    });
    $stateProvider.state(ROUTE_SHOP_CATALOGUE_PRODUCT, {
        url: "/products/:id",
        templateUrl: "/admin/shop/catalogue/product/product.html"
    });

};
