var webpack = require('webpack');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var failPlugin = require('webpack-fail-plugin');

var moduleName = "cms";

var paths = {
    src: './src/main/resources/static',
    dst: './build/resources/main/static'
};

var files = {
    tsMain: paths.src+'/public/'+moduleName+'/main.ts',
    jsOutput: paths.dst+'/public/[name].js'
};

module.exports = {
    entry: {
        //'ignore': files.tsIgnore,
        'public_cms': files.tsMain
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
            name: ['public_cms']
        })
    ],
    externals:[
        function(context, request, callback) {
            if(/^@angular/.test(request) ||
               /^rxjs/.test(request))
                return callback(null, "var window.pigatron.public_lib");
            callback();
        }
    ]
};
