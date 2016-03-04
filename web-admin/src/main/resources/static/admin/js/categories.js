
var API_ADMIN_CATEGORY = '/shopadmin/api/catalogue/category';
var ROOT_ID = 'root';
var PLACEHOLDER_ID = 'new';
var PLACEHOLDER_NAME = "New Category";

app.controller('categories', function($scope, $routeParams, $http, $timeout) {
    window.$scope = $scope;
    $scope.$routeParams = $routeParams;
    $scope.editingCategory = null;
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

    $scope.loadCategories = function() {
        $http.get(API_ADMIN_CATEGORY + "/" + ROOT_ID).success(function(data) {
            $scope.categories = [data];
        });
    };

    $scope.onCategorySelect = function() {
        $timeout(function() {
            $scope.editingCategory = angular.copy($scope.selectedCategory);
        }, 1);
    };

    $scope.saveCategory = function() {
        $http.post(API_ADMIN_CATEGORY + '/' + $scope.editingCategoryParent.id, $scope.editingCategory)
             .success($scope.loadCategories);
    };

    $scope.addSubcategory = function() {
        if($scope.selectedCategory.subcategories == undefined) {
            $scope.selectedCategory.subcategories = [];
        }
        var categoryPlaceholder = { id:PLACEHOLDER_ID, name:PLACEHOLDER_NAME };
        $scope.editingCategoryParent = $scope.selectedCategory;
        $scope.editingCategoryParent.subcategories.push(categoryPlaceholder);
        $scope.selectedCategory = categoryPlaceholder;
        $scope.editingCategory = { name:"" };

        //TODO expand parent category in tree
    };

    $scope.deleteCategory = function() {
        if($scope.selectedCategory.id != "new") {
            $http.delete(API_ADMIN_CATEGORY + "/" + $scope.editingCategory.id)
                 .success($scope.loadCategories);
        } else {
            //TODO delete placeholder
        }
    };

    $scope.loadCategories();
});
