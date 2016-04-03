
class ProductController extends AbstractFormController {

    /*@ngInject*/
    constructor($scope, $services, productService, imageService) {
        super($scope, $services, productService);
        this.imageService = imageService;
    }

    load(id) {
        super.load(id);
    }

    save() {
        // Upload images
        this.imageService.uploadAll(this.imagesToUpload).then((successes) => {
            successes.forEach((success) => {
                this.formData.images.push({ image:success.data });
            });
            this.uploadApi.removeAll();
            super.save();
        }, (fail) => {
        });
    }

}