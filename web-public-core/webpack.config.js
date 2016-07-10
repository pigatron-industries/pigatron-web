var webpack = require('webpack');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var failPlugin = require('webpack-fail-plugin');

var moduleName = "core";

var paths = {
    src: './src/main/resources/static',
    dst: './build/resources/main/static'
};

var files = {
    tsMain: paths.src+'/public/'+moduleName+'/main.ts',
    tsVendor: paths.src+'/public/'+moduleName+'/lib.ts',
    tsPolyfills: paths.src+'/public/'+moduleName+'/polyfill.ts',
    jsOutput: paths.dst+'/public/[name].js'
};

module.exports = {
    entry: {
        'polyfill': files.tsPolyfills,
        'public_lib': files.tsVendor,
        'public_core': files.tsMain
    },
    output: {
        path: paths.dst+'/public/',
        filename: '[name].js',
        publicPath: '/public/',
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
                test: /\.(png|jpe?g|gif|svg|woff|woff2|ttf|eot|ico)$/,
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
            name: ['public_core', 'public_lib', 'polyfill']
        })
    ]
};
