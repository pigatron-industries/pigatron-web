
var configTheme = function ($mdThemingProvider) {
    var customPrimary = {
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
        'contrastDefaultColor': 'light'
    };
    $mdThemingProvider
        .definePalette('customPrimary',
            customPrimary);

    var customAccent = {
        '50': '#ffffff',
        '100': '#ffffff',
        '200': '#ffffff',
        '300': '#fff3f5',
        '400': '#ffd9e0',
        '500': '#ffc0cb',
        '600': '#ffa6b6',
        '700': '#ff8da1',
        '800': '#ff738c',
        '900': '#ff5a77',
        'A100': '#ffffff',
        'A200': '#ffffff',
        'A400': '#ffffff',
        'A700': '#ff4062'
    };
    $mdThemingProvider
        .definePalette('customAccent',
            customAccent);

    var customWarn = {
        '50': '#ffb280',
        '100': '#ffa266',
        '200': '#ff934d',
        '300': '#ff8333',
        '400': '#ff741a',
        '500': '#ff6400',
        '600': '#e65a00',
        '700': '#cc5000',
        '800': '#b34600',
        '900': '#993c00',
        'A100': '#ffc199',
        'A200': '#ffd1b3',
        'A400': '#ffe0cc',
        'A700': '#803200'
    };
    $mdThemingProvider
        .definePalette('customWarn',
            customWarn);

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
        .primaryPalette('customPrimary')
        .accentPalette('customAccent')
        .warnPalette('customWarn');
        //.backgroundPalette('customBackground')
};
