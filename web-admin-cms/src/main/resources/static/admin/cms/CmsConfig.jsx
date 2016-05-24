
var CmsConfig = function($stateProvider) {

    constants.routes.CMS_PAGES = 'pages';
    constants.routes.CMS_PAGE = 'page';

    $stateProvider.state(constants.routes.CMS_PAGES, {
        url: "/pages",
        templateUrl: "/admin/cms/page/pages.html"
    });
    $stateProvider.state(constants.routes.CMS_PAGE, {
        url: "/pages/:id",
        templateUrl: "/admin/cms/page/page.html"
    });

};

module.exports = CmsConfig;