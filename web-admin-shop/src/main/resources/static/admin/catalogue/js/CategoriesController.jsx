
var API_ADMIN_CATEGORY = '/shopadmin/api/catalogue/category';
var ROOT_ID = 'root';
var PLACEHOLDER_ID = 'new';
var PLACEHOLDER_NAME = "New Category";

class CategoriesController {

    constructor($stateParams, $state, categoryService) {
        window.$categories = this;
        this.categoryService = categoryService;
        this.$stateParams = $stateParams;
        this.$state = $state;
        this.treeOptions = {
            removed: (scope) => { this.deleteCategory(scope.$modelValue.id); },
            dropped: (event) => { this.moveCategory(event); }
        };
        this.load();
    }

    //TODO should use promise instead of callback
    load(callback) {
        this.categoryService.getRoot()
            .success((data) => {
                this.categories = data.subcategories;
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
        window.$category.newCategory(category.id);
    }

    deleteSubcategory(categoryId) {
        this.categoryService.delete(categoryId)
            .success(() => {
                if(window.$category.editingCategory.id == categoryId) {
                    this.$state.go('categories');
                }
            });
    }

    moveCategory(event) {
        console.log('moved');
        //TODO
    }
}
