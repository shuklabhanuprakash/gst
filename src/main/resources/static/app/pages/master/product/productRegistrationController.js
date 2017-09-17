app.controller("ProductRegistrationController",function($scope,$http,$stateParams,$state ){
	
	
	$scope.init=function(){
		
		if($stateParams.id){
			$http.get("/gst/product/"+$stateParams.id).then(function(response){
				console.log(response)
				$scope.product=response.data;
				//$state.go("master.product.productRegistration", { "id": productId });
				
			},function(error){
				console.log("error",error);
			});
		}
		
		
		
	}
	
	$scope.saveProduct=function(){
		$http.post("/gst/product",$scope.product).then(function(response){
			console.log(response)
			$scope.product=response.data;
			$state.go("master.product.productList");
			
		},function(error){
			console.log("error",error);
		});
		
	}
	
});