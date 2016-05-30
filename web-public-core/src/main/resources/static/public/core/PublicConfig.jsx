
window.constants = {
    URL_BASE: $("base").attr("href"),
    routes: {},
    events: {}
};

var PublicConfig = function($mdThemingProvider, $stateProvider, $locationProvider, $urlRouterProvider) {
    configTheme($mdThemingProvider);
    $locationProvider.html5Mode(true);
    $urlRouterProvider.otherwise("/");

    $stateProvider.state('home', {
        url: "/",
        templateUrl: "/public/core/home/home.html"
    });
    
};

module.exports = PublicConfig;


var configTheme = function ($mdThemingProvider) {
    var arapawa = {
        '50': '#41a0c2',
        '100': '#3991b1',
        '200': '#33829e',
        '300': '#2c728b',
        '400': '#266277',
        '500': '#205264',
        '600': '#1a4251',
        '700': '#14323d',
        '800': '#0d222a',
        '900': '#071317',
        'A100': '#55aac8',
        'A200': '#68b3cf',
        'A400': '#7bbdd5',
        'A700': '#010303',
        'default': '500',
        'hue-1': '400',
        'contrastDefaultColor': 'light'
    };
    var midnight = {
        '50': '#597ea2',
        '100': '#507192',
        '200': '#476481',
        '300': '#3e5771',
        '400': '#354b60',
        '500': '#2c3e50',
        '600': '#233140',
        '700': '#1a242f',
        '800': '#11181f',
        '900': '#080b0e',
        'A100': '#698aac',
        'A200': '#7997b5',
        'A400': '#8aa4be',
        'A700': '#000000',
        'default': '500',
        'hue-1': '400',
        'contrastDefaultColor': 'light'
    };
    $mdThemingProvider.definePalette('arapawa', arapawa);
    $mdThemingProvider.definePalette('midnight', midnight);

    var pink = {
        '50': '#f492b3',
        '100': '#f27ba3',
        '200': '#f06493',
        '300': '#ee4c83',
        '400': '#eb3573',
        '500': '#E91E63',
        '600': '#d81557',
        '700': '#c1134e',
        '800': '#aa1145',
        '900': '#930e3b',
        'A100': '#f7a9c4',
        'A200': '#d81557',
        'A400': '#fbd8e4',
        'A700': '#7b0c32',
        'default': '500',
        'hue-1': '400',
        'contrastDefaultColor': 'light'
    };
    $mdThemingProvider.definePalette('pink', pink);

    var warn = {
        '50': '#ff7b82',
        '100': '#ff626a',
        '200': '#ff4852',
        '300': '#ff2f3a',
        '400': '#ff1522',
        '500': '#fb000d',
        '600': '#e1000c',
        '700': '#c8000a',
        '800': '#ae0009',
        '900': '#950008',
        'A100': '#ff959a',
        'A200': '#ffaeb3',
        'A400': '#ffc8cb',
        'A700': '#7b0006',
        'hue-1': '100',
        'hue-2': '900',
        'contrastDefaultColor': 'light'
    };
    $mdThemingProvider.definePalette('warn', warn);

    var customBackground = {
        '50': '#c8c8c8',
        '100': '#bbbbbb',
        '200': '#aeaeae',
        '300': '#a1a1a1',
        '400': '#959595',
        '500': '#888888',
        '600': '#7b7b7b',
        '700': '#6e6e6e',
        '800': '#626262',
        '900': '#555555',
        'A100': '#d4d4d4',
        'A200': '#e1e1e1',
        'A400': '#eeeeee',
        'A700': '#484848'
    };
    $mdThemingProvider
        .definePalette('customBackground',
            customBackground);

    $mdThemingProvider.theme('default')
        .primaryPalette('midnight')
        .accentPalette('pink', { 'default': '400'})
        .warnPalette('warn');
    //.backgroundPalette('customBackground')
};
