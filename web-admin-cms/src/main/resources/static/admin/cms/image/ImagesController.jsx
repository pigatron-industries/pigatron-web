
class ImagesController extends webadmincore.AbstractController {

    /*@ngInject*/
    constructor($scope, $services, imageService) {
        super($scope, $services);
        this.imageService = imageService;
        this.load();
    }

    load() {
        return this.imageService.getAll().then((success) => {
            this.formData = success.data;
        });
    }

    upload() {
        // Upload images
        this.imageService.uploadAll(this.imagesToUpload).then((successes) => {
            this.uploadApi.removeAll();
            this.load();
        }, (fail) => {
        });
    }
    
    remove(index) {
        this.imageService.remove(this.formData[index].id).then((success) => {
            this.load();
        });
    }

    clearCache() {
        this.imageService.clearCache().then((success) => {
            this.load();
        });
    }

}

module.exports = ImagesController;