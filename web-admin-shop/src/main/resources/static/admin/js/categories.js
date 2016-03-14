
var API_ADMIN_CATEGORY = '/shopadmin/api/catalogue/category';
var ROOT_ID = 'root';
var PLACEHOLDER_ID = 'new';
var PLACEHOLDER_NAME = "New Category";

/**
 * Scope variables:
 *  ProductCategory[] categories: Full category tree starting at root.
 *  ProductCategory selectedCategory: The selected category in the tree.
 *  ProductCategory selectedCategoryParent: The parent of the selected category in the tree.
 *  ProductCategory editingCategory: A copy of the selected category that is currently being edited.
 */

app.controller('categories', function($scope, $stateParams, $state, $http, $timeout) {
    window.$categories = $scope;
    $scope.editingCategory = null;
    $scope.editingCategoryParent = null;
    $scope.treeOptions = {
        nodeChildren: "subcategories",
        dirSelectable: true,
        injectClasses: {
            ul: "a1",
            li: "a2",
            liSelected: "a7",
            iExpanded: "a3",
            iCollapsed: "a4",
            iLeaf: "a5",
            label: "a6",
            labelSelected: "a8"
        }
    };

    $scope.loadCategoriesInTree = function(callback) {
        $http.get(API_ADMIN_CATEGORY + "/" + ROOT_ID).success(function(data) {
            $scope.categories = [data];
            if(callback) { callback(); }
        });
    };

    $scope.onCategorySelect = function() {
        $timeout(function() {
            if($scope.selectedCategory) {
                $state.go("categories.category", {categoryId: $scope.selectedCategory.id});
            } else {
                $state.go("categories");
            }
        }, 1);
    };

    $scope.selectCategoryInTree = function(categoryIdToSelect) {
        function selectCategory(categories) {
            for(var i=0; i<categories.length; i++) {
                var currentCategory = categories[i];
                if(currentCategory.id == categoryIdToSelect) {
                    $scope.selectedCategory = currentCategory;
                    return true;
                }
                if(selectCategory(currentCategory.subcategories)) {
                    $scope.expandedCategories.push(currentCategory);
                    return true;
                }
            }
            return false;
        }
        selectCategory($scope.categories);
    };

    $scope.addSubcategory = function() {
        if($scope.selectedCategory.subcategories == undefined) {
            $scope.selectedCategory.subcategories = [];
        }
        var categoryTreePlaceholder = { id:PLACEHOLDER_ID, name:PLACEHOLDER_NAME };
        $scope.selectedCategory.subcategories.push(categoryTreePlaceholder);
        $scope.selectCategoryInTree(PLACEHOLDER_ID);
    };


    $scope.loadCategoriesInTree();
});

app.controller('category', function($scope, $stateParams, $state, $http, $timeout) {
    window.$category = $scope;

    $scope.loadCategoryInForm = function() {
        $http.get(API_ADMIN_CATEGORY + "/" + $stateParams.categoryId).success(function(data) {
            $scope.editingCategory = data;
            $scope.categoryForm.$setPristine();
            $("#categoryName").focus();
            $timeout(function() {
                $categories.selectCategoryInTree($stateParams.categoryId);
            }, 1);
        });
    };

    $scope.saveCategory = function() {
        var url;
        if($scope.editingCategory.id == null) {
            url = API_ADMIN_CATEGORY + '/' + $scope.editingCategoryParent.id;
        } else {
            url = API_ADMIN_CATEGORY;
        }

        $http.post(url, $scope.editingCategory)
            .success(function (data) {
                $scope.categoryForm.$setPristine();
                $categories.loadCategoriesInTree(function() {
                    $state.go("categories.category", {categoryId: data.id});
                    $categories.selectCategoryInTree(data.id);
                });
                $rootScope.notifySuccess('Category Saved');
            });
    };

    window.save = $scope.saveCategory;

    $scope.addSubcategory = function() {
        $categories.addSubcategory();
        var categoryEditNew = { id:null, name:"" }
        $scope.editingCategoryParent = $scope.editingCategory;
        $scope.editingCategory = categoryEditNew;
        $("#categoryName").focus();
    };

    $scope.deleteCategory = function() {
        if($scope.editingCategory.id != null) {
            $http.delete(API_ADMIN_CATEGORY + "/" + $scope.editingCategory.id)
                .success(function() {
                    $categories.loadCategoriesInTree();
                    $state.go('categories');
                });
        } else {
            $categories.loadCategoriesInTree();
            $state.go('categories');
        }
    };

    $scope.loadCategoryInForm($stateParams.categoryId);
});