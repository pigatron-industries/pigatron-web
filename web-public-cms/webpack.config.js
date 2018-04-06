var createConfig = require('../webpack.common.config.js');
module.exports = createConfig(__dirname, "public", "cms", false, false,
    function(context, request, callback) {
        if(request.indexOf("@angular") != -1 ||
            request.indexOf("rxjs") != -1)
            return callback(null, "var window.pigatron.public_lib");
        else if(request.indexOf("web-public-core") != -1)
            return callback(null, "var window.pigatron.public_core");
        callback();
    }
);
