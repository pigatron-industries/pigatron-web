var gulp = require('gulp');
var concat = require("gulp-concat");
var babel = require("gulp-babel");
var ngAnnotate = require("gulp-ng-annotate");
var webpackStream = require('webpack-stream');
var webpack = require('webpack');
var mainBowerFiles = require('main-bower-files');
var filter = require('gulp-filter');
var order = require("gulp-order");
var minify = require('gulp-minify');
var addsrc = require("gulp-add-src");

var module = 'shop';
var paths = {
    src: 'src/main/resources/static',
    dst: './build/resources/main/static'
};
paths.jsDestPath = paths.dst+'/public/'+module+'/';
paths.bundleDestPath = paths.dst + '/public/';
paths.fontDestPath = paths.dst+'/fonts/';
var files = {
    jsAllJsx: paths.src+'/public/'+module+'/**/*.jsx',
    jsIndex: paths.dst+'/public/'+module+'/index.js',
    jsBundleLibDestFile: 'web-public-'+module+'-lib.js',
    cssBundleLibDestFile: 'web-public-'+module+'-lib.css'
};
var babelOptions = { presets: ['es2015'] };
var webpackOptions = {
    output: {
        filename: 'web-public-'+module+'.js',
        libraryTarget: "var",
        library: "webpublic"+module
    }
};



gulp.task('jsBabel', function() {
    return gulp.src(files.jsAllJsx)
        .pipe(babel(babelOptions))
        .pipe(ngAnnotate())
        .pipe(gulp.dest(paths.jsDestPath));
});

gulp.task('jsWebpack', ['jsBabel'], function() {
    return gulp.src(files.jsIndex)
        .pipe(webpackStream(webpackOptions))
        .pipe(gulp.dest(paths.bundleDestPath));
});

// gulp.task('jsLib', function() {
//     return gulp.src(mainBowerFiles())
//         .pipe(filter('**/*.js'))
//         .pipe(order(["**/jquery.js", "**/angular.js", "**/*.js"]))
//         .pipe(concat(files.jsBundleLibDestFile))
//         //.pipe(minify())
//         .pipe(gulp.dest(paths.bundleDestPath));
// });
//
// gulp.task('cssLib', function() {
//     return gulp.src(mainBowerFiles())
//         .pipe(addsrc('./bower_components/font-awesome/css/*'))
//         .pipe(filter('**/*.css'))
//         .pipe(concat(files.cssBundleLibDestFile))
//         .pipe(gulp.dest(paths.bundleDestPath));
// });
//
// gulp.task('fonts', function() {
//     return gulp.src(mainBowerFiles())
//         .pipe(filter(['**/*.woff2','**/*.woff','**/*.ttf']))
//         .pipe(gulp.dest(paths.fontDestPath));
// });

gulp.task('localBuild', ['jsBabel', 'jsWebpack']);
gulp.task('libBuild', []);
gulp.task('build', ['localBuild']); //'libBuild'

