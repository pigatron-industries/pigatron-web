
var PublicCmsConfig = require("./PublicCmsConfig");

angular.module('public.cms', ['ngMaterial','ngMessages','ngAnimate','ui.router','mdColors'])
    .config(PublicCmsConfig);
