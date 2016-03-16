module.exports = function(grunt) {
    require('load-grunt-tasks')(grunt);
    grunt.initConfig({
        "babel": {
            options: {
                sourceMap: true
            },
            dist: {
                files: {
                    "build/resources/main/static/admin/js/admin.js": "src/main/resources/static/admin/js/admin.js"
                }
            }
        }
    });

    grunt.registerTask('build', ['babel']);
};