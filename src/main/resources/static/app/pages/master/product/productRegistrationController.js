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
		$http.post("/gst/buyer",$scope.product).then(function(response){
			console.log(response)
			const toasterTitle="Product";
			const toasterMsg="registered successfully";
			const messageType="success";
			$scope.openToast(toasterTitle,toasterMsg,messageType);
			$scope.product=response.data;
			$scope.goToProductList()
		},function(error){
			console.log("error",error);
			const toasterTitle="Product registration failed";
			const toasterMsg="please try again later.";
			const messageType="error";
			$scope.openToast(toasterTitle,toasterMsg,messageType);
		});
		
	}
	
	
	$scope.goToProductList=function(){
		$state.go("master.product.productList");
	}
	
});