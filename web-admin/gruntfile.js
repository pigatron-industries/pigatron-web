var srcDir = "src/main/resources/static/admin/js/";
var buildDir = "build/resources/main/static/admin/js/";

var files = {};
files[buildDir+"admin.js"] = srcDir+"admin.jsx";

module.exports = function(grunt) {
    require('load-grunt-tasks')(grunt);
    grunt.initConfig({
        "babel": {
            options: {
                sourceMap: true
            },
            dist: {
                files: files
            }
        }
    });

    grunt.registerTask('build', ['babel']);
};