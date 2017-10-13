app.controller("CustomerRegistrationController",function($scope,$http,$state,$stateParams,baProgressModal,$uibModal ){
	
	
	$scope.allConsignees=[];
	$scope.selectedConsignee={};
	$scope.customer={};
	$scope.customer.consignees=[];
	$scope.consignee={};
	$scope.searchConsignee=function(item){
		$scope.selectedConsignee.selected = item;
	}
	
	const getBuyer=function(id){
		
		$http.get("/gst/buyer/"+id).then(function(response){
			console.log(response)
			$scope.customer=response.data;
			//$state.go("master.product.productRegistration", { "id": productId });
			
		},function(error){
			console.log("error",error);
		});
	}
	
	
	const getConsignee=function(id){
		$http.get("/gst/consigneeByBuyerId/"+id).then(function(response){
			console.log(response)
			$scope.consignees=response.data;
			//$state.go("master.product.productRegistration", { "id": productId });
			
		},function(error){
			console.log("error",error);
		});
	}
	
	$scope.init=function(){
		
		if($stateParams.id){
			getBuyer($stateParams.id);
			getConsignee($stateParams.id);
		}
		
	}
	
	$scope.saveCustomer=function(){
		console.log("Consignee ",$scope.consignee)
		if($scope.consignee){
			$scope.customer.consignees.push($scope.consignee);
			
		}
		
		$http.post("/gst/buyer",$scope.customer).then(function(response){
			console.log(response)
			
			console.log(response)
			const toasterTitle="Customer";
			const toasterMsg=$scope.customer.id ?"updated":"registered"+" successfully";
			const messageType="success";
			$scope.openToast(toasterTitle,toasterMsg,messageType);
			$scope.customer=response.data;
			$scope.consignee={}
			//$state.go("master.cutomer.customerRegistration", { "id": productId });
			$scope.goToCustomerList()
		},function(error){
			console.log("error",error);
		});
		
	}
	$scope.goToCustomerList=function(){
		$state.go("master.customer.customerList");
	}
	
	
	
	$scope.showConsignee=function(){
		console.log("consigneee in show consignee     ",$scope.consignee)
		
		
	}
	$scope.open = function (page, size) {
	      $uibModal.open({
	        animation: true,
	        templateUrl: page,
	        size: size,
	        resolve: {
	          items: function () {
	        	  
	        	  console.log("$scope.items  ",$scope.consignee)
	            return $scope.items;
	          }
	        }
	      });
	      
	      console.log("consigneee in show consignee     ",$scope.consignee)
	    };
	    
	  
	
});