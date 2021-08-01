$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/PurchaseForeignCurrency.feature");
formatter.feature({
  "name": "Purchase Foreign Currency",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Available currencies",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "navigate login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.LoginStepDefinitions.navigate_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.LoginStepDefinitions.the_user_is_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on \"Pay Bills\" module",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.AddNewPayeeStepDefinitions.the_user_clicks_on_module(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigate \"Purchase Foreign Currency\" tab",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.AddNewPayeeStepDefinitions.navigate_tab(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "following currencies should be available",
  "rows": [
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.PurchaseForeignCurrencyStepDefinitions.following_currencies_should_be_available(java.util.List\u003cjava.lang.String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});