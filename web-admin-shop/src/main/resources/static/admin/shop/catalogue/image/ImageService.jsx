
const API_ADMIN_IMAGE = "api/catalogue/image";

class ImageService extends AbstractRestService {

    /*@ngInject*/
    constructor($http, $q) {
        super($http, API_ADMIN_IMAGE);
        this.$q = $q;
    }

    uploadAll(uploadFiles) {
        let promises = [];
        for(var i = 0; i < uploadFiles.length; i++) {
            promises.push(this.upload(uploadFiles[i]));
        }

        return this.$q.all(promises);
    }

    upload(uploadFile) {
        let fileData = uploadFile.lfFile;
        let fileName = uploadFile.lfFileName;
        let mimeType = "text/plain";
        if(fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
            mimeType = "image/jpg";
        } else if(fileName.endsWith(".gif")) {
            mimeType = "image/gif";
        } else if(fileName.endsWith(".png")) {
            mimeType = "image/png";
        }

        return this.$http.post(this.getUrl(), fileData, {headers: {"Content-Type": mimeType}});
    }

}