const webpack = require('webpack');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;
const tsLoader = require('awesome-typescript-loader');

const path = require('path');

module.exports = function(dirname, appName, moduleName, vendor, polyfills, externals) {

    var paths = {
        src: path.resolve(dirname, './src/main/resources/static'),
        dst: path.resolve(dirname, './build/resources/main/static')
    };

    var files = {
        tsMain: paths.src+'/'+appName+'/'+moduleName+'/main.ts',
        tsVendor: paths.src+'/'+appName+'/'+moduleName+'/lib.ts',
        jsOutput: paths.dst+'/'+appName+'/[name].js'
    };

    var entry = {};
    if(vendor)
        entry[appName+'_'+moduleName+'_lib'] = files.tsVendor;
    entry[appName+'_'+moduleName] = files.tsMain;

    var names = [];
    names.push(appName+'_'+moduleName);
    if(vendor)
        names.push(appName+'_'+moduleName+'_lib');

    return {
        entry: entry,
        output: {
            path: paths.dst+'/'+appName+'/',
            filename: '[name].js',
            publicPath: '/'+appName+'/',
            library: ['pigatron', '[name]'],
            libraryTarget: 'var'
        },
        resolve: {
            extensions: ['.js', '.ts'],
            plugins: [
                new tsLoader.TsConfigPathsPlugin()
            ]
        },
        module: {
            rules: [
                {
                    test: /\.ts$/,
                    use: 'ts-loader'
                },
                {
                    test: /\.html$/,
                    use: 'html-loader'
                },
                {
                    test: /\.(png|jpe?g|gif|svg|woff|woff2|ttf|eot|ico)(\?v=\d+\.\d+\.\d+)?$/,
                    use: 'file-loader?name=assets/[name].[hash].[ext]'
                },
                {
                    test:/\.(s*)css$/,
                    use: ExtractTextPlugin.extract({ fallback: 'style-loader', use: ['css-loader','sass-loader'] })
                }
            ]
        },
        plugins: [
            new ExtractTextPlugin('[name].css'),
            new webpack.optimize.CommonsChunkPlugin({
                name: names
            }),
            new BundleAnalyzerPlugin({
                analyzerMode: 'static',
                openAnalyzer: false
            })
        ],
        externals: externals
    };
};