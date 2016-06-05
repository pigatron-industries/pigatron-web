
/*@ngInject*/
var PublicCmsConfig = function($mdThemingProvider, $stateProvider) {

    $stateProvider.state('page', {
        url: "/page/{urlKey}",
        views: {
            'content': {
                templateUrl: "/public/cms/content/page.html"
            }
        }
    });

};

module.exports = PublicCmsConfig;

