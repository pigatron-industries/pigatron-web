
class ProductController extends AbstractFormController {

    /*@ngInject*/
    constructor($scope, $services, productService, imageService, categoryService) {
        super($scope, $services, productService);
        this.imageService = imageService;
        this.categoryService = categoryService;
        this.sortableOptions = {
            containment: '#sortableImages',
            orderChanged: (event) => { this.onImageOrderChanged(); }
        };
        this.imagesToDelete = [];
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

            // load categories
            this.categoryService.getRoot().then((success) => {
                this.categories = [success.data];
                this.formData.categories.forEach((category) => {
                    let categoryToSelect = this.findCategoryById(category.id);
                    categoryToSelect.selected = true;
                });
            });
        });
    }

    findCategoryById(id) {
        let findCategory = (categories) => {
            for(var category of categories) {
                if(category.id == id) {
                    return category;
                } else {
                    var found = findCategory(category.subcategories);
                    if(found) {
                        return found;
                    }
                }
            }
        };
        return findCategory(this.categories);
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

    removeImage(index) {
        this.imagesToDelete.push(this.formData.images[index]);
        this.formData.images.splice(index, 1);
        this.setDirty();
    }

    selectCategory(category) {
        this.$timeout(() => {
            if(category.selected) {
                this.formData.categories.push({id:category.id});
            } else {
                let i = this.formData.categories.findIndex(item => item.id == category.id);
                this.formData.categories.splice(i, 1);
            }
        }, 1);
    }

}