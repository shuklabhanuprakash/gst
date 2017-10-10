app.controller("CustomerController",function($scope,$http,$state){
	
	$scope.customers=[];
	
	const getCustomers =function(){
		$http.get("/gst/buyers").then(function(response){
			console.log(response)
			$scope.customers=response.data;
			console.log($scope.customers);
			
		},function(error){
			console.log("error",error);
		});
		
	}
	
	$scope.deleteProduct=function(id){
		$http.get("/gst/deleteBuyer/"+id).then(function(response){
			console.log(response)
			$scope.customers=response.data;
			
		},function(error){
			console.log("error",error);
		});
	}
	
	
	$scope.editCustomer=function(customerId){
		$state.go("master.customer.customerRegistration", { "id": customerId });
		
		
	}
	
	$scope.init=function(){
		getCustomers();
		$state.go("master.customer.customerList");
	}
	
	
	
	
	
	
	
	
	
});