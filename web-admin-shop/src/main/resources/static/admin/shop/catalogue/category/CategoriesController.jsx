
var API_ADMIN_CATEGORY = '/shopadmin/api/catalogue/category';
var ROOT_ID = 'root';
var PLACEHOLDER_ID = 'new';
var PLACEHOLDER_NAME = "New Category";

class CategoriesController extends AbstractServiceBundleConsumer {

    /*@ngInject*/
    constructor($scope, $services, categoryService) {
        super($scope, $services);
        window.$categories = this;
        this.categoryService = categoryService;
        this.treeOptions = {
            removed: (scope) => { this.remove(scope.$modelValue.id); },
            dropped: (event) => { this.moveCategory(event); }
        };
        this.load();
    }

    //TODO should use promise instead of callback
    load(callback) {
        this.categoryService.getRoot()
            .then((success) => {
                this.categories = success.data.subcategories;
                if(callback) { callback(); }
            });
    }

    newSubcategory(scope) {
        var category = scope.$modelValue;
        category.subcategories.push({
            id: PLACEHOLDER_ID,
            name: PLACEHOLDER_NAME,
            subcategories: []
        });
        window.$category.newSubcategory(category.id);
    }

    remove(categoryId) {
        this.categoryService.remove(categoryId)
            .then((success) => {
                // If the deleted category was open the close the form
                if(window.$category.formData.id == categoryId) {
                    this.$state.go('categories');
                }
            });
    }

    moveCategory(event) {
        console.log('moved');
        //TODO
    }
}
