app.controller("CompanyController",function($scope,$http,$state){
	
	$scope.products=[];
	
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
	
	
	$scope.editProduct=function(productId){
		$state.go("master.product.productRegistration", { "id": productId });
		
		
	}
	
	$scope.init=function(){
		getProducts();
		$state.go("master.company.companyList");
	}
	
	
	
	
	
	
	
});