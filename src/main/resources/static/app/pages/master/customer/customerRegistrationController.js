app.controller("CustomerRegistrationController",function($scope,$http,$stateParams,baProgressModal,$uibModal ){
	
	
	$scope.allConsignees=[
		{
			color: "red",
			value: "#f00"
		},
		{
			color: "green",
			value: "#0f0"
		},
		{
			color: "blue",
			value: "#00f"
		},
		{
			color: "cyan",
			value: "#0ff"
		},
		{
			color: "magenta",
			value: "#f0f"
		},
		{
			color: "yellow",
			value: "#ff0"
		},
		{
			color: "black",
			value: "#000"
		}
	];
	
	$scope.selectedConsignee={};
	
	
	$scope.searchConsignee=function(item){
		$scope.selectedConsignee.selected = item;
	}
	
	$scope.init=function(){
		
		if($stateParams.id){
			$http.get("/gst/buyer/"+$stateParams.id).then(function(response){
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