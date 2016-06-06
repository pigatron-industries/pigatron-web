var conf = require('../protractor.conf.js').config;

var CategoriesPage = function() {

    var header = element(by.css("h2"));

    this.goto = function() {
        browser.get(conf.baseUrl);
        element(by.id("menu-catalogue")).click();
        element(by.id("menu-categories")).click();
    };

    this.get = function() {
        browser.get(conf.baseUrl + '/categories');
    };

    this.getHeader = function() {
        return header.getText();
    };


    /* Tree */
    var treeNodes = element.all(by.css("div.tree-node"));

    this.getTreeNodes = function() {
        return treeNodes;
    };

    this.getTreeNode = function(categoryId) {
        return element(by.id("category-" + categoryId));
    };

    this.getSelectButton = function(categoryId) {
        return this.getTreeNode(categoryId).element(by.css("a.btn-select"));
    };

    this.getAddButton = function(categoryId) {
        return this.getTreeNode(categoryId).element(by.css("a.btn-add"));
    };


    /* Form */
    var form = element(by.id("form"));
    var nameInput = element(by.id("name"));
    var saveButton = element(by.id("btn-save"));
    var deleteButton = element(by.id("btn-delete"));

    this.getNameInput = function() {
        return nameInput;
    };

    this.getSaveButton = function() {
        return saveButton;
    };

    this.getDeleteButton = function() {
        return deleteButton;
    };

    this.getFormData = function() {
        return form.evaluate("category.formData");
    }
};

module.exports = new CategoriesPage();