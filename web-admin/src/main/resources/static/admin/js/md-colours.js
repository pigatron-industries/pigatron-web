/* Inspired from https://github.com/angular/material/pull/1599 and https://gist.github.com/SimeonC/1f6b6e52c9b14c4c7b63*/
(function () {
    "use strict";
    /**
     * @ngdoc run
     * @module mdColors
     *
     * @description
     *  This builds css styles like "md-default-theme md-accent md-fg" to allow use of the accent class to the foreground (css color attribute) where 'default' is the theme name
     *  Similarly, you can use "md-default-theme md-primary md-bg" to apply the primary class to background-color. Here, 'default' is the theme name.
     *  The classes are .md-fg, .md-bg, .md-bdr to apply color, background-color and border-color to an element respectively
     *  These classes can be combined with md-primary, md-accent, md-hue-1, md-hue-2, md-hue-3
     **/

    var _$mdThemingProvider;

    angular
        .module('mdColors',['mdColors'])
        .config(['$mdThemingProvider', function($mdThemingProvider){
            _$mdThemingProvider = $mdThemingProvider;
        }])
        .run(['$interpolate', '$document', function($interpolate, $document){
            function buildCssSelectors(selectors) {
                var result = selectors.join('');
                return result;
            }
            var fgDefault = $interpolate(buildCssSelectors(['.md-{{theme}}-theme','.md-fg']) + ' { color:{{value}};}');
            var bgDefault = $interpolate(buildCssSelectors(['.md-{{theme}}-theme','.md-bg']) + ' { background-color:{{value}};}');
            var bdrDefault = $interpolate(buildCssSelectors(['.md-{{theme}}-theme','.md-bdr']) + ' { border-color:{{value}};}');
            var fgDefaultHue = $interpolate(buildCssSelectors(['.md-{{theme}}-theme','.md-{{hue}}','.md-fg']) + ' { color:{{value}};}');
            var bgDefaultHue = $interpolate(buildCssSelectors(['.md-{{theme}}-theme','.md-{{hue}}','.md-bg']) + ' { background-color:{{value}};}');
            var fgColor = $interpolate(buildCssSelectors(['.md-{{theme}}-theme','.md-{{palette}}','.md-fg']) + ' { color:{{value}};}');
            var bgColor = $interpolate(buildCssSelectors(['.md-{{theme}}-theme','.md-{{palette}}','.md-bg']) + ' { background-color:{{value}};}');
            var bdrColor = $interpolate(buildCssSelectors(['.md-{{theme}}-theme','.md-{{palette}}','.md-bdr']) + ' { border-color:{{value}};}');
            var fgHue = $interpolate(buildCssSelectors(['.md-{{theme}}-theme','.md-{{palette}}.md-{{hue}}','.md-fg']) + ' { color:{{value}};}');
            var bgHue = $interpolate(buildCssSelectors(['.md-{{theme}}-theme','.md-{{palette}}.md-{{hue}}','.md-bg']) + ' { background-color:{{value}};}');
            var customSheet = getStyleSheet();
            var index       = 0;

            // clear out old rules from stylesheet
            while (customSheet.cssRules.length > 0 ) {
                customSheet.deleteRule(0);
            }
            angular.forEach(_$mdThemingProvider._THEMES, function(theme, themeName){
                //Add default selectors - primary is the default palette
                addRule(fgDefault, bgDefault, themeName, 'primary', _$mdThemingProvider._PALETTES[theme.colors['primary'].name][theme.colors['primary'].hues.default]);
                addRule(fgDefaultHue,  bgDefaultHue,  themeName,  'primary', _$mdThemingProvider._PALETTES[theme.colors['primary'].name][theme.colors['primary'].hues['hue-2'] ], 'hue-2');
                addRule(fgDefaultHue,  bgDefaultHue,  themeName,  'primary', _$mdThemingProvider._PALETTES[theme.colors['primary'].name][theme.colors['primary'].hues['hue-3'] ], 'hue-3');
                addRule(fgDefaultHue,  bgDefaultHue,  themeName,  'primary', _$mdThemingProvider._PALETTES[theme.colors['primary'].name][theme.colors['primary'].hues['hue-1'] ], 'hue-1');
                addBorderRule(bdrDefault, themeName, 'primary', _$mdThemingProvider._PALETTES[theme.colors['primary'].name][theme.colors['primary'].hues.default]);

                //Add selectors for palettes - accent, background, primary and warn
                angular.forEach(theme.colors, function(color, paletteName){
                    addRule(fgColor, bgColor, themeName, paletteName, _$mdThemingProvider._PALETTES[color.name][color.hues.default]);
                    addBorderRule(bdrColor, themeName, paletteName, _$mdThemingProvider._PALETTES[color.name][color.hues.default]);
                    addRule(fgHue,  bgHue,  themeName,  paletteName, _$mdThemingProvider._PALETTES[color.name][color.hues['hue-2'] ], 'hue-2');
                    addRule(fgHue,  bgHue,  themeName,  paletteName, _$mdThemingProvider._PALETTES[color.name][color.hues['hue-3'] ], 'hue-3');
                    addRule(fgHue,  bgHue,  themeName,  paletteName, _$mdThemingProvider._PALETTES[color.name][color.hues['hue-1'] ], 'hue-1');
                });
            });

            function addRule(fgInterpolate, bgInterpolate, themeName, paletteName, colorArray, hueName){
                // set up interpolation functions to build css rules.
                if(!colorArray) return;
                var colorValue = 'rgb(' + colorArray.value[0] + ',' + colorArray.value[1] + ',' + colorArray.value[2] + ')';
                customSheet.insertRule(fgInterpolate({
                    theme: themeName,
                    palette: paletteName,
                    value: colorValue,
                    hue: hueName
                }), index);
                index += 1;
                // insert background color rule
                customSheet.insertRule(bgInterpolate({
                    theme: themeName,
                    palette: paletteName,
                    value: colorValue,
                    hue: hueName
                }), index);
                index += 1;
            }

            function addBorderRule(bdrInterpolate, themeName, paletteName, colorArray, hueName){
                // set up interpolation functions to build css rule for border color.
                if(!colorArray) return;
                var colorValue = 'rgb(' + colorArray.value[0] + ',' + colorArray.value[1] + ',' + colorArray.value[2] + ')';
                customSheet.insertRule(bdrInterpolate({
                    theme: themeName,
                    palette: paletteName,
                    value: colorValue,
                    hue: hueName
                }), index);
                index += 1;
            }

            function getStyleSheet() {
                // function to add a dynamic style-sheet to the document
                var style = $document[0].head.querySelector('style[title="Dynamic-Generated-by-mdColors"]');
                if (style === null) {
                    style = $document[0].createElement('style');
                    style.title = 'Dynamic-Generated-by-mdColors';
                    // WebKit hack... (not sure if still needed)
                    style.appendChild($document[0].createTextNode(''));
                    $document[0].head.appendChild(style);
                }
                return style.sheet;
            }
        }]);
}());