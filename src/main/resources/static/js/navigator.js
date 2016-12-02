app.config(function($routeProvider) {
	
	$routeProvider.when('/', {
		templateUrl: "/partials/home.html",
		controller: "HomeController"
	}).when('/home', {
		templateUrl: "/partials/home.html",
		controller: "HomeController"
	}).when('/users', {
		templateUrl: "/partials/users.html",
		controller: "UsersController"
	}).otherwise('/');
});