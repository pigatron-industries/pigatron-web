

class CategoryController {

    constructor($scope, $rootScope, $http, $state, $stateParams, categoryService) {
        window.$category = this;
        this.$scope = $scope;
        this.$http = $http;
        this.$state = $state;
        this.$stateParams = $stateParams;
        this.$rootScope = $rootScope;
        this.categoryService = categoryService;
        this.load($stateParams.categoryId);
        window.save = () => this.saveCategory;
    }

    load() {
        this.categoryService.get(this.$stateParams.categoryId)
            .success((data) => {
                this.editingCategory = data;
                this.setPristine();
                $("#categoryName").focus();
                //$timeout(function () {
                //    $categories.selectCategory($stateParams.categoryId);
                //}, 1);
            });
    }

    newCategory(parentCategoryId) {
        this.editingCategory = {id:null, name:'', subcategories:[]};
        this.editingParentId = parentCategoryId;
        this.setPristine();
        $("#categoryName").focus();
    }

    saveCategory() {
        this.categoryService.save(this.editingCategory, this.editingParentId)
            .success((data) => {
                this.setPristine();
                // TODO should not call controller directly
                window.$categories.load(() => {
                    this.$state.go("categories.category", {categoryId: data.id});
                    //$categories.selectCategory(data.id);
                });
                this.$rootScope.notifySuccess('Category Saved');
            });
    }

    setPristine() {
        this.$scope.categoryForm.$setPristine();
    }

}


