var createConfig = require('../webpack.common.config.js');
module.exports = createConfig(__dirname, "public", "shop", false, false,
    function(context, request, callback) {
        if(request.indexOf("@angular") != -1 ||
            request.indexOf("rxjs") != -1)
            return callback(null, "var window.pigatron.public_lib");
        else if(request.indexOf("pigatron/public/core") != -1)
            return callback(null, "var window.pigatron.public_core");
        callback();
    }
);
