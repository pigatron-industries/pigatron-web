var createConfig = require('../webpack.common.config.js');
module.exports = createConfig(__dirname, "admin", "cms", false, false,
    function(context, request, callback) {
        if(request.indexOf("@angular") != -1 ||
            request.indexOf("@swimlane") != -1 ||
            request.indexOf("rxjs") != -1 ||
            request.indexOf("web-admin-core") != -1)
            return callback(null, "var window.pigatron.admin_core");
        callback();
    }
);
