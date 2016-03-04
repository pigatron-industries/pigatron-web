
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

app.controller('categories', function($scope, $routeParams, $http, $timeout) {
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

    $scope.loadCategories = function(selectCategoryId) {
        $http.get(API_ADMIN_CATEGORY + "/" + ROOT_ID).success(function(data) {
            $scope.categories = [data];
            $scope.selectCategory(selectCategoryId);
        });
    };

    $scope.onCategorySelect = function() {
        $timeout(function() {
            $scope.editingCategory = angular.copy($scope.selectedCategory);
            $("#categoryName").focus();
        }, 1);
    };

    $scope.selectCategory = function(selectCategoryId) {
        //TODO
        delete $scope.selectedCategory;
        $scope.editingCategory = null;
        $scope.editingCategoryParent = null;
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
                $scope.loadCategories(data.id);
            });
    };

    $scope.addSubcategory = function() {
        if($scope.selectedCategory.subcategories == undefined) {
            $scope.selectedCategory.subcategories = [];
        }
        var categoryPlaceholder = { id:PLACEHOLDER_ID, name:PLACEHOLDER_NAME };
        $scope.editingCategoryParent = $scope.selectedCategory;
        $scope.editingCategoryParent.subcategories.push(categoryPlaceholder);
        $scope.selectedCategory = categoryPlaceholder;
        $scope.editingCategory = { id:null,name:"" };

        //expand parent category in tree
        $scope.expandedCategories.push($scope.editingCategoryParent);
        $("#categoryName").focus();
    };

    $scope.deleteCategory = function() {
        if($scope.selectedCategory.id != "new") {
            $http.delete(API_ADMIN_CATEGORY + "/" + $scope.editingCategory.id)
                 .success(function() {
                     $scope.loadCategories();
                 });
        } else {
            $scope.loadCategories();
        }
    };

    $scope.loadCategories();
});
