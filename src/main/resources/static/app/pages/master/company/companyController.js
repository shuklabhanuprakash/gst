app.controller("CompanyController",function($scope,$http,$state){
	
	$scope.sellers=[];
	
	
	$scope.$on('$stateChangeStart', function() {getSellers(); });
	
	const getSellers =function(){
		$http.get("/gst/sellers").then(function(response){
			console.log(response)
			$scope.sellers=response.data;
			
		},function(error){
			console.log("error",error);
		});
		
	}
	
	$scope.deleteCompany=function(id){
		$http.get("/gst/deleteSeller/"+id).then(function(response){
			console.log(response)
			$scope.sellers=response.data;
			
		},function(error){
			console.log("error",error);
		});
	}
	
	
	$scope.editCompany=function(sellerId){
		$state.go("master.company.companyRegistration", { "id": sellerId });
		
		
	}
	
	$scope.init=function(){
		getSellers();
		$state.go("master.company.companyList");
	}
	
	
	
	
	
	
	
});