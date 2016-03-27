
var wroConfig = "wro_shop.json";

var resourceDir = "src/main/resources/";
var srcDir = "src/main/resources/static";
var buildDir = "build/resources/main/static";
var wroConfig = require("./" + resourceDir + "/" + wroConfig);

// Build list of files for babel conversion
var babelFiles = {};
var annotateFiles = [];
for (var group in wroConfig) {
    if (wroConfig.hasOwnProperty(group)) {
        var prefix = wroConfig[group].prefix;
        if(wroConfig[group].jsx) {
            for (var i = 0; i < wroConfig[group].jsx.length; i++) {
                var src = srcDir + prefix + wroConfig[group].jsx[i] + ".jsx";
                var dest = buildDir + prefix + wroConfig[group].jsx[i] + ".js";
                babelFiles[dest] = src;
                annotateFiles.push(dest);
            }
        }
    }
}

module.exports = function(grunt) {
    require('load-grunt-tasks')(grunt);
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-ng-annotate');

    grunt.initConfig({
        "babel": {
            options: {
                sourceMap: true
            },
            dist: {
                files: babelFiles
            }
        },
        ngAnnotate: {
            options: {
                // Task-specific options go here.
            },
            dist: {
                files: [{
                    expand: true,
                    src: annotateFiles,
                    ext: '.js', // Dest filepaths will have this extension.
                    extDot: 'last'       // Extensions in filenames begin after the last dot
                }]
            }
        }
    });

    grunt.registerTask('build', ['babel:dist','ngAnnotate:dist']);
};