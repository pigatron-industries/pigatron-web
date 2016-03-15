
var API_ADMIN_CATEGORY = '/shopadmin/api/catalogue/category';
var ROOT_ID = 'root';
var PLACEHOLDER_ID = 'new';
var PLACEHOLDER_NAME = "New Category";

/**
 * Scope variables:
 *  ProductCategory[] categories : Full category tree starting at root.
 */

app.controller('categories', function($scope, $stateParams, $state, $http) {
    window.$categories = $scope;
    $scope.editingCategory = null;
    $scope.editingCategoryParent = null;
    $scope.treeOptions = {
        removed: function(scope) { $scope.deleteCategory(scope.$modelValue.id); },
        dropped: function(event) { $scope.moveCategory(event); }
    };

    $scope.loadCategories = function(callback) {
        $http.get(API_ADMIN_CATEGORY + "/" + ROOT_ID).success(function(data) {
            $scope.categories = data.subcategories;
            if(callback) { callback(); }
        });
    };

    $scope.newSubcategory = function(scope) {
        var category = scope.$modelValue;
        category.subcategories.push({
            id: PLACEHOLDER_ID,
            name: PLACEHOLDER_NAME,
            subcategories: []
        });
        $category.newCategory(category.id);
    };

    $scope.deleteCategory = function(categoryId) {
        $http.delete(API_ADMIN_CATEGORY + "/" + categoryId).success(function() {
            if($category.editingCategory.id == categoryId) {
                $state.go('categories');
            }
        });
    };

    $scope.moveCategory = function(event) {
        console.log('moved');
        //TODO
    };

    $scope.loadCategories();
});


/**
 * Scope variables:
 *  ProductCategory editingCategory : The category being edited
 */
app.controller('category', function($scope, $stateParams, $state, $http, $timeout) {
    window.$category = $scope;

    $scope.loadCategory = function() {
        $http.get(API_ADMIN_CATEGORY + "/" + $stateParams.categoryId).success(function (data) {
            $scope.editingCategory = data;
            $scope.categoryForm.$setPristine();
            $("#categoryName").focus();
            //$timeout(function () {
            //    $categories.selectCategory($stateParams.categoryId);
            //}, 1);
        });
    };

    $scope.newCategory = function(parentCategoryId) {
        $scope.editingCategory = {id:null, name:'', subcategories:[]};
        $scope.editingParentId = parentCategoryId;
        $scope.categoryForm.$setPristine();
        $("#categoryName").focus();
    };

    $scope.saveCategory = function() {
        var url;
        if($scope.editingCategory.id == null) {
            url = API_ADMIN_CATEGORY + '/' + $scope.editingParentId;
        } else {
            url = API_ADMIN_CATEGORY;
        }

        $http.post(url, $scope.editingCategory)
            .success(function (data) {
                $scope.categoryForm.$setPristine();
                $categories.loadCategories(function() {
                    $state.go("categories.category", {categoryId: data.id});
                    //$categories.selectCategoryInTree(data.id);
                });
                $rootScope.notifySuccess('Category Saved');
            });
    };

    window.save = $scope.saveCategory;

    $scope.loadCategory($stateParams.categoryId);
});