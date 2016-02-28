
var API_ADMIN_CATEGORIES = '/shopadmin/api/catalogue/category';

app.controller('categories', function($scope, $routeParams, $http) {
    $scope.$routeParams = $routeParams;

    $http.get(API_ADMIN_CATEGORIES).success(function(data) {
        $scope.categories = data;
    });

});
