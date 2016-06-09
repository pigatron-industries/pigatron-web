/**
 * Aggregates dependency reports from gradle and bower
 * and shows them as a nice html table.
 */

var fs = require("fs");
var gradleDeps = require("../build/dependencyUpdates/report.json");

function tableHeader() {
    return "<html><table><tr><th>group:name</th><th>current version</th><th>available version</th><th>status</th></tr>";
}

function tableFooter() {
    return "</table></html>";
}

function addGradleDeps(deps, type) {
    var trs = "";
    for(var i = 0; i < deps.length; i++) {
        var dep = deps[i];
        trs += "<tr class='" + type + "'>" +
            "<td>" + dep.group + ":" + dep.name + "</td>" +
            "<td>" + dep.version + "</td>" +
            "<td>" + (dep.available ? dep.available.release : "") + "</td>" +
            "<td>" + type + "</td>" +
        "</tr>";
    }
    return trs;
}

var html = tableHeader();
html += addGradleDeps(gradleDeps.unresolved.dependencies, "unresolved");
html += addGradleDeps(gradleDeps.outdated.dependencies, "outdated");
html += addGradleDeps(gradleDeps.exceeded.dependencies, "exceeded");
html += addGradleDeps(gradleDeps.current.dependencies, "current");
html += tableFooter();

fs.writeFile("build/reports/dependencies.html", html);



