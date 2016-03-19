

class CategoryController {

    constructor($scope, $rootScope, $http, $state, $stateParams) {
        window.$category = this;
        this.$scope = $scope;
        this.$http = $http;
        this.$state = $state;
        this.$stateParams = $stateParams;
        this.$rootScope = $rootScope;
        this.load($stateParams.categoryId);
        window.save = () => this.saveCategory;
    }

    load() {
        this.$http.get(API_ADMIN_CATEGORY + "/" + this.$stateParams.categoryId)
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
        var url;
        if(this.editingCategory.id == null) {
            url = API_ADMIN_CATEGORY + '/' + this.editingParentId;
        } else {
            url = API_ADMIN_CATEGORY;
        }

        this.$http.post(url, this.editingCategory)
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


