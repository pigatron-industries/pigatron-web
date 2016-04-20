var loginPage = require('../pages/LoginPage.js');
var categoriesPage = require('../pages/CategoriesPage.js');

describe("categories page",  function() {

    var categoryId = null;

    beforeAll(function() {
        loginPage.login();
    });

    it("should navigate to categories page", function() {
        categoriesPage.goto();

        expect(categoriesPage.getHeader()).toBe("Categories");
        expect(categoriesPage.getTreeNodes().count()).toBe(1);
        expect(categoriesPage.getTreeNodes().get(0).getText()).toBe("Shop");
    });

    it("should insert subcategory", function() {
        categoriesPage.get();
        categoriesPage.getAddButton("root").click();
        categoriesPage.getNameInput().sendKeys("Insert Category");
        categoriesPage.getSaveButton().click();

        //TODO save message causes test to fail

        expect(categoriesPage.getTreeNodes().count()).toBe(2);
        expect(categoriesPage.getTreeNodes().get(0).getText()).toBe("Shop");
        expect(categoriesPage.getTreeNodes().get(1).getText()).toBe("Insert Category");
        categoriesPage.getFormData().then(function(category) {
            expect(category.id).not.toBe(null);
            categoryId = category.id;
        });
    });

    it("should update category", function() {
        categoriesPage.get();
        categoriesPage.getSelectButton(categoryId).click();
        categoriesPage.getNameInput().clear();
        categoriesPage.getNameInput().sendKeys("Update Category");
        categoriesPage.getSaveButton().click();

        expect(categoriesPage.getTreeNodes().count()).toBe(2);
        expect(categoriesPage.getTreeNodes().get(0).getText()).toBe("Shop");
        expect(categoriesPage.getTreeNodes().get(1).getText()).toBe("Update Category");
    });

    it("should delete category", function() {
        categoriesPage.get();
        categoriesPage.getSelectButton(categoryId).click();
        categoriesPage.getDeleteButton().click();

        expect(categoriesPage.getTreeNodes().count()).toBe(1);
        expect(categoriesPage.getTreeNodes().get(0).getText()).toBe("Shop");
    })

});
