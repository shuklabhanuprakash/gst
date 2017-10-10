app.controller("CustomerRegistrationController",function($scope,$http,$stateParams,baProgressModal,$uibModal ){
	
	
	$scope.allConsignees=[];
	
	$scope.selectedConsignee={};
	
	
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
		$http.get("/gst/buyer/"+id).then(function(response){
			console.log(response)
			$scope.customer=response.data;
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
	
	$scope.saveProduct=function(){
		$http.post("/gst/buyer",$scope.product).then(function(response){
			console.log(response)
			$scope.product=response.data;
			//$state.go("master.product.productRegistration", { "id": productId });
			
		},function(error){
			console.log("error",error);
		});
		
	}
	
	
	$scope.open = function (page, size) {
	      $uibModal.open({
	        animation: true,
	        templateUrl: page,
	        size: size,
	        resolve: {
	          items: function () {
	            return $scope.items;
	          }
	        }
	      });
	    };
	
});