import {Configuration} from 'webpack';

const config: Configuration = {
    mode: 'development',
    module: {
        rules: [
            {
                exclude: /(node_modules)/,
                loader: 'babel-loader',
                test: /\.[tj]sx?$/,
            },
        ],
    },
    resolve: {
        extensions: ['.js', '.jsx', '.ts', '.tsx'],
    },
};

export default config;