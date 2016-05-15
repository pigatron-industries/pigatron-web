
var API_ADMIN_CATEGORY = '/shopadmin/api/catalogue/category';
var ROOT_ID = 'root';
var PLACEHOLDER_ID = 'new';
var PLACEHOLDER_NAME = "New Category";

class CategoriesController extends AbstractController {

    /*@ngInject*/
    constructor($scope, $services, categoryService) {
        super($scope, $services);
        window.$categories = this;
        this.categoryService = categoryService;
        this.treeOptions = {
            dropped: (event) => { this.moveCategory(event); }
        };
        this.$scope.$on(EVENT_SHOP_CATALOGUE_CATEGORIES_CHANGED, () => {this.load();});
        this.load();
    }

    //TODO should use promise instead of callback
    load(callback) {
        this.categoryService.getRoot()
            .then((success) => {
                this.categories = [ success.data ];
                if(callback) { callback(); }
            });
    }

    newSubcategory(scope) {
        let category = scope.$modelValue;
        category.subcategories.push({
            id: PLACEHOLDER_ID,
            name: PLACEHOLDER_NAME,
            subcategories: []
        });
        this.selectCategory("new", category.id);
    }

    selectCategory(id, parentId) {
        this.selectedCategoryId = id;
        this.$state.go('categories.category', {id:id, parentId:parentId});
    }

    moveCategory(event) {
        console.log('moved');
        //TODO
    }
}

module.exports = CategoriesController;