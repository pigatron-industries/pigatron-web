
var API_ADMIN_CATEGORIES = '/shopadmin/api/catalogue/category';

app.controller('categories', function($scope, $routeParams, $http) {
    $scope.$routeParams = $routeParams;
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
    }

    $http.get(API_ADMIN_CATEGORIES).success(function(data) {
        $scope.categories = data;
    });

});
