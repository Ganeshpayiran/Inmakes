$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Final.feature");
formatter.feature({
  "name": "To check the login functionality of amazon application",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "To login the amazon app",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "To launch the chrome browser and maximise window",
  "keyword": "Given "
});
formatter.match({
  "location": "AmozonLogin.to_launch_the_chrome_browser_and_maximise_window()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To launch the url of amazon app",
  "keyword": "When "
});
formatter.match({
  "location": "AmozonLogin.to_launch_the_url_of_amazon_app()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To click the login button",
  "keyword": "And "
});
formatter.match({
  "location": "AmozonLogin.to_click_the_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To pass the valid email in email field",
  "keyword": "And "
});
formatter.match({
  "location": "AmozonLogin.to_pass_the_valid_email_in_email_field()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To pass the password in password field",
  "keyword": "And "
});
formatter.match({
  "location": "AmozonLogin.to_pass_the_password_in_password_field()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To click signin button",
  "keyword": "And "
});
formatter.match({
  "location": "AmozonLogin.to_click_signin_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "AmozonLogin.to_close_the_browser()"
});
formatter.result({
  "status": "passed"
});
});