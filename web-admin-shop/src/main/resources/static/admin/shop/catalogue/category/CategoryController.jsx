

class CategoryController extends AbstractFormController {

    /*@ngInject*/
    constructor($scope, $services, $rootScope, categoryService) {
        super($scope, $services, categoryService);
        this.$rootScope = $rootScope;
        window.$category = this;
    }

    newSubcategory(parentCategoryId) {
        this.formData = {id:null, name:'', subcategories:[]};
        this.parentId = parentCategoryId;
        this.setPristine();
        $("#name").focus();
    }

    save() {
        this.dataService.save(this.formData, this.parentId)
            .success((data) => {
                this.setPristine();
                // TODO should not call controller directly
                window.$categories.load(() => {
                    this.$state.go("categories.category", {id: data.id});
                    //$categories.selectCategory(data.id);
                });
                this.$rootScope.notifySuccess('Category Saved');
            });
    }

}


