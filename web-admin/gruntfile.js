
var wroConfig = "wro.json";

var resourceDir = "src/main/resources/";
var srcDir = "src/main/resources/static";
var buildDir = "build/resources/main/static";
var wroConfig = require("./" + resourceDir + "/" + wroConfig);

var files = {};
for (var group in wroConfig) {
    if (wroConfig.hasOwnProperty(group)) {
        var prefix = wroConfig[group].prefix;
        if(wroConfig[group].jsx) {
            for (var i = 0; i < wroConfig[group].jsx.length; i++) {
                var src = srcDir + prefix + wroConfig[group].jsx[i] + ".jsx";
                var dest = buildDir + prefix + wroConfig[group].jsx[i] + ".js";
                files[dest] = src;
            }
        }
    }
}

module.exports = function(grunt) {
    require('load-grunt-tasks')(grunt);
    grunt.loadNpmTasks('grunt-contrib-copy');

    grunt.initConfig({
        "babel": {
            options: {
                sourceMap: true
            },
            dist: {
                files: files
            }
        },
        copy: {
            "angular-data-table": {
                files: [{
                    cwd: "node_modules/angular-data-table/release/",
                    src: ["**"],
                    dest: "build/resources/main/static/lib/angular-data-table/",
                    expand: true
                }]
            }
        }
    });

    grunt.registerTask('build', ['babel','copy:angular-data-table']);
};