
class MessageController {

    /*@ngInject*/
    constructor($mdToast) {
        this.$mdToast = $mdToast;
    }

    close() {
        this.$mdToast.hide();
    }

}
