var srcDir = "src/main/resources/static/admin/js/";
var buildDir = "build/resources/main/static/admin/js/";

var files = {};
files[buildDir+"admin.js"] = srcDir+"admin.jsx";
files[buildDir+"AdminController.js"] = srcDir+"AdminController.jsx";
files[buildDir+"AdminConfig.js"] = srcDir+"AdminConfig.jsx";
files[buildDir+"MessageController.js"] = srcDir+"MessageController.jsx";
files[buildDir+"HttpInterceptor.js"] = srcDir+"HttpInterceptor.jsx";

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