var createConfig = require('../webpack.common.config.js');
module.exports = createConfig(__dirname, "public", "core", true, true);
