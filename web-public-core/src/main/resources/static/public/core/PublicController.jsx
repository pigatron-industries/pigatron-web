
class PublicController {

    /*@ngInject*/
    constructor($scope, $timeout) {
        this.$scope = $scope;
        this.$timeout = $timeout;
        this.moveTabClasses();
    }

    moveTabClasses() {
        this.$timeout(function() {
            let tabItems = $("md-tab-item");
            $("md-tab").each(function(i) {
                let classes = $(this).attr("class").split(" ");
                for(var j = 0; j < classes.length; j++) {
                    tabItems.eq(i).addClass(classes[j]);
                }
            });
        }, 1);
    }

}

module.exports = PublicController;
