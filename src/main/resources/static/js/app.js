var app =angular.module("myApp",['ui.router']) ;
app.config(function($stateProvider,$urlRouterProvider){
	$stateProvider.state('entreprises',{
		url:'/entreprises',
		templateUrl:'views/entreprises.html',
		controller:'myController'
	});
	$stateProvider.state('taxes',{
		url:'/taxes',
		templateUrl:'views/taxes.html',
		controller:'TaxeController'
	});
	
});
app.controller("TaxeController", function($scope,$http){});


app.controller("myController", function($scope,$http){
	$scope.nom="";
	
	$scope.pageEntreprises=null ;
	$scope.page=0;  
	$scope.size=5; 
	$scope.pages=[];
  $scope.chercher=function() {
	  
	  $http.get('http://localhost:8080/ListEntreprises?nom='+$scope.nom+'&page='+$scope.page+'&size='+$scope.size).then(successCallback, errorCallback);

	  function successCallback(response){
	      //success code
		  $scope.pageEntreprises = response.data; 
		  $scope.pages=new Array(response.data.totalPages);  
	  }
	  function errorCallback(error){
	      Console.log(error);  }
  }
  $scope.chercher();
  $scope.gotoPage = function  (i){
		$scope.page =i;
		$scope.chercher();}
});