
class StickToTop extends AbstractController {

    /*@ngInject*/
    constructor($services) {
        super({}, $services);
        this.restrict = "A";
    }

    link(scope, element, attributes) {
        this.$scope = scope;
        var spacer = angular.element("<div class='spacer'></div>");
        spacer.insertAfter(element);
        element.css("top", "0");

        this.eventOnOff(angular.element(this.$window), "scroll", () => {
            if(angular.element(this.$window).scrollTop() > spacer.offset().top) {
                spacer.width(element.outerWidth());
                element.css("position", "fixed");
            } else {
                spacer.width(0);
                element.css("position", "static");
            }
        });
    }

}
