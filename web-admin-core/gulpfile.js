var gulp = require('gulp');
var concat = require("gulp-concat");
var babel = require("gulp-babel");
var ngAnnotate = require("gulp-ng-annotate");

var paths = {
    src: 'src/main/resources/static'
};

var files = {
    jsSrc: [paths.src+'/admin/core/abstract/ServiceBundle.jsx',
            paths.src+'/admin/core/abstract/*.jsx',
            paths.src+'/admin/core/components/*.jsx',
            paths.src+'/admin/core/controller/*.jsx',
            paths.src+'/admin/core/index.jsx'],
    jsDestFile: 'web-admin-core.js',
    jsDestPath: 'build/resources/main/static/admin'
};

gulp.task('babel', function() {
    return gulp.src(files.jsSrc)
        .pipe(babel({ presets: ['es2015'] }))
        .pipe(ngAnnotate())
        .pipe(concat(files.jsDestFile))
        .pipe(gulp.dest(files.jsDestPath));
});

gulp.task('build', ['babel']);