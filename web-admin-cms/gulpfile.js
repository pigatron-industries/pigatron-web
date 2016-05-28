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
var inject = require('gulp-inject-string');

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

gulp.task('jsLib', function() {
    return gulp.src(mainBowerFiles())
        .pipe(filter('**/*.js'))
        .pipe(order(["**/*.js"]))
        .pipe(concat(files.jsBundleLibDestFile))
        //.pipe(minify())
        .pipe(inject.prepend("window.CKEDITOR_BASEPATH = '/admin/ckeditor/';\n"))
        .pipe(gulp.dest(paths.bundleDestPath));
});

gulp.task('cssLib', function() {
    return gulp.src(mainBowerFiles())
        .pipe(filter('**/*.css'))
        .pipe(concat(files.cssBundleLibDestFile))
        .pipe(gulp.dest(paths.bundleDestPath));
});

gulp.task('fonts', function() {
    return gulp.src(mainBowerFiles())
        .pipe(filter(['**/*.woff2','**/*.woff','**/*.ttf']))
        .pipe(gulp.dest(paths.fontDestPath));
});

gulp.task('ckeditor', function() {
    return gulp.src(['./bower_components/ckeditor/ckeditor.js',
                     './bower_components/ckeditor/styles.js',
                     './bower_components/ckeditor/contents.css',
                     './bower_components/ckeditor/lang/*',
                     './bower_components/ckeditor/skins/**/*',
                     './bower_components/ckeditor/plugins/**/*',
                     './bower_components/ckeditor/samples/**/*'],
                    {base:"./bower_components/"})
        .pipe(gulp.dest(paths.bundleDestPath));
});

gulp.task('localBuild', ['jsBabel', 'jsWebpack']);
gulp.task('libBuild', ['jsLib', 'cssLib', 'fonts', 'ckeditor']);
gulp.task('build', ['localBuild', 'libBuild']);

