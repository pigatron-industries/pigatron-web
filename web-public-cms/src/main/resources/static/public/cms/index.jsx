
var PublicCmsConfig = require("./PublicCmsConfig");
var PageController = require("./content/PageController");
var ContentService = require("./content/ContentService");

angular.module('public.cms', ['ngMaterial','ngMessages','ngAnimate','ui.router','mdColors'])
    .config(PublicCmsConfig);

register("public.cms")
    .controller('PageController', PageController)
    .service("contentService", ContentService);
