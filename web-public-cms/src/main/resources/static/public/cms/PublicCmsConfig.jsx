
var PublicCmsConfig = function($mdThemingProvider, $stateProvider) {

    $stateProvider.state('page', {
        url: "/content/{urlKey}",
        templateUrl: "/public/cms/content.html"
    });

};

module.exports = PublicCmsConfig;

