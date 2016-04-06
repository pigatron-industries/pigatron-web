
class ProductController extends AbstractFormController {

    /*@ngInject*/
    constructor($scope, $services, productService, imageService) {
        super($scope, $services, productService);
        this.imageService = imageService;
        this.sortableOptions = {
            containment: '#sortableImages',
            orderChanged: (event) => { this.onImageOrderChanged(); }
        };
        this.$scope.$watch('thumbnailImageId', () => { this.onThumbnailChange(); });
    }

    load(id) {
        super.load(id).then((success) => {
            // Set selected thumbnail
            this.formData.images.forEach((productImage) => {
                if(productImage.thumbnail) {
                    this.$scope.thumbnailImageId = productImage.image.id;
                }
            });
        });
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

    onThumbnailChange() {
        if(!this.formData) { return; }

        // Move selected thumbnail to front of array
        let thumbnailImageId = this.$scope.thumbnailImageId;
        let thumbnailImageIndex = null;
        let thumbnailImage = null;

        this.formData.images.forEach((productImage, i) => {
            if(productImage.image && productImage.image.id == thumbnailImageId) {
                productImage.thumbnail = true;
                thumbnailImage = productImage;
                thumbnailImageIndex = i;
            } else {
                productImage.thumbnail = false;
            }
        });

        this.formData.images.splice(thumbnailImageIndex, 1);
        this.formData.images.unshift(thumbnailImage);
    }

    onImageOrderChanged() {
        this.setDirty();
    }

}