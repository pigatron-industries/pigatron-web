var gulp = require('gulp');
var babel = require("gulp-babel");
var ngAnnotate = require("gulp-ng-annotate");


var paths = {
    jsx: 'src/main/resources/static/**/*.jsx',
    js: 'src/main/resources/static/**/*.js',
    dest: 'build/resources/main/static'
};

gulp.task('babel', function() {
    return gulp.src(paths.jsx)
        .pipe(babel({ presets: ['es2015'] }))
        .pipe(ngAnnotate())
        .pipe(gulp.dest(paths.dest));
});

gulp.task('build', ['babel']);