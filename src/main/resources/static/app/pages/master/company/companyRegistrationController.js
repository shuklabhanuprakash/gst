app.controller("CompanyRegistrationController",function($scope,$http,$stateParams,$state ){
	
	
	$scope.init=function(){
		
		if($stateParams.id){
			$http.get("/gst/seller/"+$stateParams.id).then(function(response){
				console.log(response)
				$scope.company=response.data;
				//$state.go("master.product.productRegistration", { "id": productId });
				
			},function(error){
				console.log("error",error);
			});
		}
	}
	
	$scope.saveCompany=function(){
		$http.post("/gst/seller",$scope.company).then(function(response){
			console.log(response)
			$scope.company=response.data;
			$state.go("master.company.companyList");
			
			
		},function(error){
			console.log("error",error);
		});
		
	}
	
});