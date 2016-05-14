var gulp = require('gulp');
var concat = require("gulp-concat");
var babel = require("gulp-babel");
var ngAnnotate = require("gulp-ng-annotate");
var webpack = require('webpack-stream');

var paths = {
    src: 'src/main/resources/static'
};

var files = {
    jsAllSrc: paths.src+'/admin/shop/**/*.jsx',
    jsSrc: [paths.src+'/admin/shop/components/**/*.jsx',
            paths.src+'/admin/shop/catalogue/image/ImageService.jsx',
            paths.src+'/admin/shop/catalogue/category/*.jsx',
            paths.src+'/admin/shop/catalogue/product/*.jsx',
            paths.src+'/admin/shop/catalogue/product/selector/*.jsx',
            paths.src+'/admin/shop/catalogue/product/options/*.jsx',
            paths.src+'/admin/shop/catalogue/CatalogueConfig.jsx',
            paths.src+'/admin/shop/index.jsx'],
    jsDestFile: 'web-admin-shop.js',
    jsDestPath: 'build/resources/main/static/admin'
};

gulp.task('babel', function() {
    return gulp.src(files.jsSrc)
        .pipe(babel({ presets: ['es2015'] }))
        .pipe(ngAnnotate())
        //.pipe(gulp.dest(files.jsDestPath + '/shop'));
        .pipe(concat(files.jsDestFile))
        .pipe(gulp.dest(files.jsDestPath))
});

gulp.task('build', ['babel']);
