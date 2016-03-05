
var API_ADMIN_CATEGORY = '/shopadmin/api/catalogue/category';
var ROOT_ID = 'root';
var PLACEHOLDER_ID = 'new';
var PLACEHOLDER_NAME = "New Category";

/**
 * Scope variables:
 *  ProductCategory categories: Full category tree starting at root.
 *  ProductCategory selectedCategory: The selected category in the tree.
 *  ProductCategory selectedCategoryParent: The parent of the selected category in the tree.
 *  ProductCategory editingCategory: A copy of the selected category that is currently being edited.
 */

app.controller('categories', function($scope, $routeParams, $location, $http, $timeout) {
    window.$scope = $scope;
    $scope.$routeParams = $routeParams;
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

    $scope.loadPage = function() {
        $scope.loadCategoriesInTree(function() {
            if($routeParams.categoryId) {
                $scope.loadCategoryInForm($routeParams.categoryId);
            }
        });
    };

    $scope.loadCategoriesInTree = function(callback) {
        $http.get(API_ADMIN_CATEGORY + "/" + ROOT_ID).success(function(data) {
            $scope.categories = [data];
            if(callback) { callback(); }
        });
    };

    $scope.onCategorySelect = function() {
        $timeout(function() {
            $scope.loadCategoryInForm($scope.selectedCategory.id);
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

    $scope.loadCategoryInForm = function(categoryId) {
        $http.get(API_ADMIN_CATEGORY + "/" + categoryId).success(function(data) {
            $scope.editingCategory = data;
            $scope.selectCategoryInTree(categoryId);
            $location.path('/categories/'+categoryId);
            $("#categoryName").focus();
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
                $scope.loadPage();
            });
    };

    $scope.addSubcategory = function() {
        if($scope.selectedCategory.subcategories == undefined) {
            $scope.selectedCategory.subcategories = [];
        }
        var categoryTreePlaceholder = { id:PLACEHOLDER_ID, name:PLACEHOLDER_NAME };
        var categoryEditNew = { id:null, name:"" }
        $scope.selectedCategory.subcategories.push(categoryTreePlaceholder);
        $scope.editingCategoryParent = $scope.editingCategory;
        $scope.editingCategory = categoryEditNew;
        $("#categoryName").focus();
        $timeout(function() {
            $scope.selectCategoryInTree(categoryTreePlaceholder.id);
        }, 1);
    };

    $scope.deleteCategory = function() {
        if($scope.selectedCategory.id != "new") {
            $http.delete(API_ADMIN_CATEGORY + "/" + $scope.editingCategory.id)
                 .success(function() {
                     $location.path('/categories');
                     $scope.loadPage();
                 });
        } else {
            $scope.loadPage();
        }
    };

    $scope.loadPage();
});
