
/*@ngInject*/
var CmsConfig = function($stateProvider) {

    constants.routes.CMS_CONTENTS = 'contents';
    constants.routes.CMS_CONTENT = 'content';
    constants.routes.CMS_IMAGES = 'images';

    $stateProvider.state(constants.routes.CMS_CONTENTS, {
        url: "/content",
        templateUrl: "/admin/cms/content/contents.html"
    });
    $stateProvider.state(constants.routes.CMS_CONTENT, {
        url: "/content/:id",
        templateUrl: "/admin/cms/content/content.html",
        params : { type: null }
    });
    $stateProvider.state(constants.routes.CMS_IMAGES, {
        url: "/image",
        templateUrl: "/admin/cms/image/images.html"
    });

};

module.exports = CmsConfig;