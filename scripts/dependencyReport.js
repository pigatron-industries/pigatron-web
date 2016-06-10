/**
 * Aggregates dependency reports from gradle and bower
 * and shows them as a nice html table.
 */

var fs = require("fs");
var gradleDeps = require("../build/dependencyUpdates/report.json");
var bowerDepsAdminCore = require("../build/dependencyUpdates/report_web-admin-core.json");
var bowerDepsAdminSecurity = require("../build/dependencyUpdates/report_web-admin-security.json");
var bowerDepsAdminCms = require("../build/dependencyUpdates/report_web-admin-cms.json");
var bowerDepsAdminShop = require("../build/dependencyUpdates/report_web-admin-shop.json");
var bowerDepsPublicCore = require("../build/dependencyUpdates/report_web-public-core.json");
var bowerDepsPublicCms = require("../build/dependencyUpdates/report_web-public-cms.json");
var bowerDepsPublicShop = require("../build/dependencyUpdates/report_web-public-shop.json");


function htmlHeader() {
    return "<html>" +
        "<head>" +
            '<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">' +
        "</head>" +
        "<body>";
}

function htmlFooter() {
    return "</body></html>"
}

function gradleTableHeader() {
    return "<h1>Gradle Dependencies</h1>" +
        "<table class='table'><tr><th>group:name</th><th>current version</th><th>available version</th><th>status</th></tr>";
}

function bowerTableHeader() {
    return "<h1>Bower Dependencies</h1>" +
        "<table class='table'><tr><th>module</th><th>name</th><th>current version</th><th>available version</th><th>status</th></tr>";
}

function tableFooter() {
    return "</table>";
}

function addGradleDeps(deps, type) {
    var trs = "";
    for(var i = 0; i < deps.length; i++) {
        var dep = deps[i];
        var availableVersion = "";
        if(dep.available && dep.available.release != null) {
            availableVersion += dep.available.release;
        } else if (dep.available && dep.available.milestone != null) {
            availableVersion += dep.available.milestone;
        }
        trs += "<tr class='" + (type==="outdated"?"warning":(type==="unresolved"?"danger":"")) + "'>" +
            "<td>" + dep.group + ":" + dep.name + "</td>" +
            "<td>" + dep.version + "</td>" +
            "<td>" + availableVersion + "</td>" +
            "<td>" + type + "</td>" +
        "</tr>";
    }
    return trs;
}

function addBowerDeps(module, deps) {
    var trs = "";
    for(var depName in deps) {
        var dep = deps[depName];
        var currentVersion = "";
        if(dep.pkgMeta.version) {
            currentVersion = dep.pkgMeta.version;
        } else if(dep.endpoint.target) {
            currentVersion = dep.endpoint.target;
        }
        var latestVersion = "";
        if(dep.update) {
            latestVersion = dep.update.latest;
        } else if (dep.versions[0]) {
            latestVersion = dep.versions[0];
        }
        trs += "<tr class='" + (currentVersion === latestVersion ? "" : "warning" ) + "' >" +
                "<td>" + module + "</td>" +
                "<td>" + depName + "</td>" +
                "<td>" + currentVersion + "</td>" +
                "<td>" + latestVersion + "</td>" +
                "<td>" + (currentVersion === latestVersion ? "current" : "outdated" ) + "</td>" +
            "</tr>"
    }
    return trs;
}

var html = htmlHeader();

html += gradleTableHeader();
html += addGradleDeps(gradleDeps.unresolved.dependencies, "unresolved");
html += addGradleDeps(gradleDeps.outdated.dependencies, "outdated");
html += addGradleDeps(gradleDeps.exceeded.dependencies, "exceeded");
html += addGradleDeps(gradleDeps.current.dependencies, "current");
html += tableFooter();

html += bowerTableHeader();
html += addBowerDeps("web-admin-core", bowerDepsAdminCore.dependencies);
html += addBowerDeps("web-admin-security", bowerDepsAdminSecurity.dependencies);
html += addBowerDeps("web-admin-cms", bowerDepsAdminCms.dependencies);
html += addBowerDeps("web-admin-shop", bowerDepsAdminShop.dependencies);
html += addBowerDeps("web-public-core", bowerDepsPublicCore.dependencies);
html += addBowerDeps("web-public-cms", bowerDepsPublicCms.dependencies);
html += addBowerDeps("web-public-shop", bowerDepsPublicShop.dependencies);
html += tableFooter();

html += htmlFooter();

fs.writeFile("build/reports/dependencies.html", html);



