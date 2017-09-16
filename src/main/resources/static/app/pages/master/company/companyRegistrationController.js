app.controller("CompanyRegistrationController",function($scope,$http,$stateParams ){
	
	
	$scope.init=function(){
		
		if($stateParams.id){
			$http.get("/gst/company/"+$stateParams.id).then(function(response){
				console.log(response)
				$scope.product=response.data;
				//$state.go("master.product.productRegistration", { "id": productId });
				
			},function(error){
				console.log("error",error);
			});
		}
	}
	
	$scope.saveProduct=function(){
		$http.post("/gst/company",$scope.product).then(function(response){
			console.log(response)
			$scope.product=response.data;
			//$state.go("master.product.productRegistration", { "id": productId });
			
		},function(error){
			console.log("error",error);
		});
		
	}
	
});