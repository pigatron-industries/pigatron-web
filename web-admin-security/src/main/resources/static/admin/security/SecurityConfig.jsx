
const ROUTE_SECURITY_USERS = 'users';

var SecurityConfig = function($stateProvider) {

    $stateProvider.state(ROUTE_SECURITY_USERS, {
        url: "/users",
        templateUrl: "/admin/security/users/users.html"
    });

};

module.exports = SecurityConfig;
