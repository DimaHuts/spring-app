const webpack = require('webpack'),
    path  = require('path'),
    ExtractTextPlugin = require('extract-text-webpack-plugin'),
    UglifyJsPlugin = require('uglifyjs-webpack-plugin'),
    OptimizeCssAssetsPlugin = require('optimize-css-assets-webpack-plugin'),
    cssnano = require('cssnano');

module.exports = {
    devtool: 'cheap-module-eval-source-map',
    entry: [
        'babel-polyfill',
        './src/main/js/index.js',
    ],
    output: {
    	path: __dirname,
        filename: './src/main/resources/static/built/bundle.js',
        publicPath: '/static/'
    },

    module: {
        loaders: [
            {
                loaders: ['react-hot-loader/webpack', 'babel-loader'],
                include: [
                    path.resolve(__dirname, 'src/main/js'),
                ],
                test: /\.js$/
            },
            // {
            //     test: /\.css$/,
            //     loader: 'style-loader!css-loader?modules&importLoaders=1&localIdentName=[name]__[local]___[hash:base64:5]'
            // },
            {
                test: /\.sass$/,
                use: [
                    'style-loader',
                    'css-loader?importLoaders=1&modules&localIdentName=[hash:base64:5]',
                    'sass-loader',
                ],
            }
        ],
    },

    plugins: [
        new webpack.optimize.OccurrenceOrderPlugin(),
        new webpack.HotModuleReplacementPlugin(),
        new webpack.NoEmitOnErrorsPlugin(),
        new ExtractTextPlugin('index.css'),
        new OptimizeCssAssetsPlugin({
            cssProcessor: cssnano,
            cssProcessorOptions: { discardComments: {removeAll: true }, safe: true },
            canPrint: true
        }),
        new UglifyJsPlugin()
    ],
};