
var PublicCmsConfig = function($mdThemingProvider, $stateProvider) {

    $stateProvider.state('page', {
        url: "/page/{urlKey}",
        templateUrl: "/public/cms/page.html"
    });

};

module.exports = PublicCmsConfig;

