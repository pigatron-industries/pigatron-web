
class ProductController extends AbstractFormController {

    /*@ngInject*/
    constructor($scope, $services, $mdSidenav, productService, imageService, categoryService) {
        super($scope, $services, productService);
        this.$mdSidenav = $mdSidenav;
        this.imageService = imageService;
        this.categoryService = categoryService;
        this.$scope.sidebarOpen = false;
        this.sortableOptions = {
            containment: '#sortableImages',
            orderChanged: (event) => { this.onImageOrderChanged(); }
        };
        this.imagesToDelete = [];

        this.optionTypes = {}; //TODO populate dynamically
        this.optionTypes['SelectValue'] =   {display:'Simple Select',  template: '/admin/shop/catalogue/product/options/SelectValue.html'};
        this.optionTypes['SelectProduct'] = {display:'Product Select', template: '/admin/shop/catalogue/product/options/SelectProduct.html'};

        this.$scope.$watch('thumbnailImageId', () => { this.onThumbnailChange(); });
        this.$scope.$on(EVENT_SHOP_CATALOGUE_PRODUCT_SELECTOR_OPEN, (event, args) => {this.openProductSelector(event, args)});
    }

    /**
     * Load product by id
     * @param id Product id
     */
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

    /**
     * Create a new product
     */
    create() {
        this.formData = {
            images: [],
            categories: [],
            options: []
        };
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

    /**
     * Save product
     */
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

    /* Images */

    onThumbnailChange() {
        if(!this.formData || this.formData.images.length==0) { return; }

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

    /* Categories */

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

    /* Options */

    addOption() {
        if(!this.formData.options) {
            this.formData.options = [];
        }
        this.formData.options.push({});
    }

    removeOption(index) {
        this.formData.options.splice(index, 1);
        this.setDirty();
    }

    openProductSelector(event, args) {
        this.$scope.selectorOptions = args;
        this.$scope.selectorOptions.exclude.push(this.formData.id); //exclude current product
        this.$mdSidenav("sidenav-right").open();
    }

}