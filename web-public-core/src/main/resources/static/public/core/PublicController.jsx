
class PublicController {

    /*@ngInject*/
    constructor($scope, $rootScope, $timeout, $state) {
        this.$scope = $scope;
        this.$timeout = $timeout;
        this.$state = $state;
        this.$rootScope = $rootScope;
        this.moveTabClasses();
        this.$rootScope.$on('$stateNotFound', (event) => {
            this.$state.go('notfound');
        });
    }

    moveTabClasses() {
        // Moves class attributes from hidden tabs to visible tabs (Angular Material doesn't do this automatically)
        this.$timeout(function() {
            let tabItems = $("md-tab-item");
            $("md-tab").each(function(i) {
                if($(this).attr("class")) {
                    let classes = $(this).attr("class").split(" ");
                    for (var j = 0; j < classes.length; j++) {
                        tabItems.eq(i).addClass(classes[j]);
                    }
                }
            });
        }, 1);
    }

}

module.exports = PublicController;
