var gulp = require('gulp');
var concat = require("gulp-concat");
var babel = require("gulp-babel");
var ngAnnotate = require("gulp-ng-annotate");
var webpackStream = require('webpack-stream');
var webpack = require('webpack');
var filter = require('gulp-filter');
var order = require("gulp-order");
var minify = require('gulp-minify');

var module = 'cms';
var paths = {
    src: 'src/main/resources/static',
    dst: './build/resources/main/static'
};
paths.jsDestPath = paths.dst+'/admin/'+module+'/';
paths.bundleDestPath = paths.dst + '/admin/';
paths.fontDestPath = paths.dst+'/fonts/';
var files = {
    jsAllJsx: paths.src+'/admin/'+module+'/**/*.jsx',
    jsIndex: paths.dst+'/admin/'+module+'/index.js',
    jsBundleLibDestFile: 'web-admin-'+module+'-lib.js',
    cssBundleLibDestFile: 'web-admin-'+module+'-lib.css'
};
var babelOptions = { presets: ['es2015'] };
var webpackOptions = {
    output: {
        filename: 'web-admin-'+module+'.js',
        libraryTarget: "var",
        library: "webadmin"+module
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

gulp.task('localBuild', ['jsBabel', 'jsWebpack']);
gulp.task('build', ['localBuild']);

