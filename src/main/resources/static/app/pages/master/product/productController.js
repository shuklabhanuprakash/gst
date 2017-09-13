app.controller("ProductController",function($scope,$http){
	
	
	$scope.getProducts =function(){
		$http.get("gst/products").then(function(response){
			console.log(response)
			$scope.products=response.data;
			
		},function(error){
			console.log("error",error);
		});
		
	}
	
	
	
	$scope.init=function(){
		$scope.getProducts();
	}
	
	
	
	
	
	
	
});