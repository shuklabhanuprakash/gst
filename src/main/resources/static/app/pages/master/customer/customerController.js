app.controller("CustomerController",function($scope,$http,$state){
	
	$scope.customers=[];
	
	const getCustomers =function(){
		$http.get("/gst/products").then(function(response){
			console.log(response)
			$scope.customers=response.data;
			
		},function(error){
			console.log("error",error);
		});
		
	}
	
	$scope.deleteProduct=function(id){
		$http.get("/gst/deleteProduct/"+id).then(function(response){
			console.log(response)
			$scope.customers=response.data;
			
		},function(error){
			console.log("error",error);
		});
	}
	
	
	$scope.editProduct=function(customerId){
		$state.go("master.customer.customerRegistration", { "id": customerId });
		
		
	}
	
	$scope.init=function(){
		getCustomers();
		$state.go("master.customer.customerList");
	}
	
	
	
	
	
	
	
});