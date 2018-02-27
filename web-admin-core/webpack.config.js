var webpack = require('webpack');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var failPlugin = require('webpack-fail-plugin');

var moduleName = "core";

var paths = {
    src: './src/main/resources/static',
    dst: './build/resources/main/static'
};

var files = {
    tsMain: paths.src+'/admin/'+moduleName+'/main.ts',
    tsVendor: paths.src+'/admin/'+moduleName+'/lib.ts',
    tsPolyfills: paths.src+'/admin/'+moduleName+'/polyfill.ts',
    jsOutput: paths.dst+'/admin/[name].js'
};

module.exports = {
    entry: {
        'polyfill': files.tsPolyfills,
        'admin_lib': files.tsVendor,
        'admin_core': files.tsMain
    },
    output: {
        path: paths.dst+'/admin/',
        filename: '[name].js',
        publicPath: '/admin/',
        library: ['pigatron', '[name]'],
        libraryTarget: 'var'
    },
    resolve: {
        extensions: ['', '.js', '.ts']
    },
    module: {
        loaders: [
            {
                test: /\.ts$/,
                loader: 'ts'
            },
            {
                test: /\.html$/,
                loader: 'html'
            },
            {
                test: /\.(png|jpe?g|gif|svg|woff|woff2|ttf|eot|ico)(\?v=\d+\.\d+\.\d+)?$/,
                loader: 'file?name=assets/[name].[hash].[ext]'
            },
            {
                test: /\.css$/,
                exclude: paths.src,
                loader: ExtractTextPlugin.extract('style', 'css?sourceMap')
            },
            {
                test: /\.css$/,
                include: paths.src,
                loader: 'raw'
            }
        ]
    },
    plugins: [
        failPlugin,
        new ExtractTextPlugin('[name].css'),
        //new webpack.optimize.DedupePlugin(),
        //new webpack.optimize.UglifyJsPlugin(),
        new webpack.optimize.CommonsChunkPlugin({
            name: ['admin_core', 'admin_lib', 'polyfill']
        })
    ]
};
