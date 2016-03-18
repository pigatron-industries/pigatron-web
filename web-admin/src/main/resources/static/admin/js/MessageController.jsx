
class MessageController {
    constructor($mdToast) {
        this.$mdToast = $mdToast;
    }
    close() {
        this.$mdToast.hide();
    }
}
