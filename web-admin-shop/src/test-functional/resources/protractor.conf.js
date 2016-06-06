exports.config = {
    baseUrl:"http://localhost:8081/shopadmin",
    specs:[
        "specs/CategoriesTest.js"
    ],
    multiCapabilities: [
        {'browserName': 'chrome'}
        //,{'browserName': 'firefox'}
    ],
    maxSessions: 1
};
