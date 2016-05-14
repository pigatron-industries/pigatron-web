var gulp = require('gulp');
var concat = require("gulp-concat");
var babel = require("gulp-babel");
var ngAnnotate = require("gulp-ng-annotate");

var paths = {
    src: 'src/main/resources/static'
};

var files = {
    jsSrc: [paths.src+'/admin/security/**/*.jsx'],
    jsDestFile: 'web-admin-security.js',
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