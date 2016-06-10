/**
 * Aggregates dependency reports from gradle and bower
 * and shows them as a nice html table.
 */

var fs = require("fs");
var gradleDeps = require("../build/dependencyUpdates/report.json");

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

var html = htmlHeader();
html += gradleTableHeader();
html += addGradleDeps(gradleDeps.unresolved.dependencies, "unresolved");
html += addGradleDeps(gradleDeps.outdated.dependencies, "outdated");
html += addGradleDeps(gradleDeps.exceeded.dependencies, "exceeded");
html += addGradleDeps(gradleDeps.current.dependencies, "current");
html += tableFooter();
html += htmlFooter();

fs.writeFile("build/reports/dependencies.html", html);



