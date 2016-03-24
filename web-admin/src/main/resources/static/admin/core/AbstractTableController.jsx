
class AbstractTableController extends AbstractController {

    constructor($scope, $services) {
        super($scope, $services);
        this.eventOnOffNow($(window), 'resize', () => {this.setTableHeight();});
    }

    setTableHeight() {
        this.headerHeight = $("header").height();
        this.footerHeight = $("footer").height();
        this.menubarHeight = $("md-menu-bar").height();
        let tableHeight = $(window).height() - this.headerHeight - this.footerHeight - this.menubarHeight;
        $("div.dt").height(tableHeight);
        $("div.dt-body").height(tableHeight - $("div.dt-header").height());
    }

}