var conf = require('../protractor.conf').config;

var LoginPage = function() {

    this.get = function() {
        browser.get(conf.baseUrl + '/login');
    };

    this.login = function() {
        this.get();
        element(by.id("username")).sendKeys("admin");
        element(by.id("password")).sendKeys("password");
        element(by.css("button[type='submit']")).click();
    }

};

module.exports = new LoginPage();