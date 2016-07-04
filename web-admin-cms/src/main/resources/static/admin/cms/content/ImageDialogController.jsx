
var ImagesController = require("../image/ImagesController");

class ImageDialogController extends ImagesController {

    /*@ngInject*/
    constructor($scope, $services, imageService) {
        super($scope, $services, imageService);
    }

}

module.exports = ImageDialogController;

