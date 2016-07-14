var myApp=angular.module("myApp", []);

myApp.controller("listeEtudiantController",function($scope,$http){
	$scope.pageEtudiants=null;
	$scope.pageCourante=0;
	$scope.size=5;
	
	$scope.listEtudiants=function(){
		$http.get("etudiants?page="+$scope.pageCourante+"&size="+$scope.size)
		.success(function (data) {
			$scope.pageEtudiants=data;
		})
	};
	$scope.listEtudiants();
});
myApp.controller("inscriptionController",function($scope,$http){
	$scope.etudiant={};
	$scope.errors=null;
	$scope.mode={value:"form"}	
	$scope.saveEtudiant=function(){
		$http.post("etudiants",$scope.etudiant)
		.success(function(data){
			if(!data.errors){
				$scope.etudiant=data;
				$scope.errors=null;
				$scope.mode.value="confirm";
			}
			else{
				$scope.errors=data;
		}
		});
	};
	

});

myApp.controller("indexController",function($scope,$http){
	$scope.pageEtudiants=null;
	$scope.pageCourante=0;
	$scope.size=5;
	
	$scope.listEtudiants=function(){
		$http.get("etudiants?page="+$scope.pageCourante+"&size="+$scope.size)
		.success(function (data) {
			$scope.pageEtudiants=data;
		})
	};
	$scope.listEtudiants();
});
