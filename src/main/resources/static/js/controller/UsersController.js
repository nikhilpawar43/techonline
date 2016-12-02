app.controller('UsersController', function($scope, $http) {
	$scope.message = 'Welcome to users page !';
	
	$http.get('/users').then(function(response) {
		
		$scope.users = response.data;
	});
})