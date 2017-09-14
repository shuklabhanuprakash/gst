app.controller("ProductController",function($scope,$http,$state){
	
	const getProducts =function(){
		$http.get("/gst/products").then(function(response){
			console.log(response)
			$scope.products=response.data;
			
		},function(error){
			console.log("error",error);
		});
		
	}
	
	$scope.deleteProduct=function(id){
		$http.get("/gst/deleteProduct/"+id).then(function(response){
			console.log(response)
			$scope.products=response.data;
			
		},function(error){
			console.log("error",error);
		});
	}
	
	$scope.init=function(){
		getProducts();
		$state.go("master.product.productList");
	}
	
	
	
	
	
	
	
});