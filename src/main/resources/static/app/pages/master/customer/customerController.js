app.controller("CustomerController",function($scope,$http,$state,toastr,
		toastrConfig){
	
	$scope.customers=[];
	
	var openedToasts = [];
	 var defaultConfig = angular.copy(toastrConfig);
	
	$scope.options = {
		autoDismiss : false,
		positionClass : 'toast-top-center',
		type : 'success',
		timeOut : '5000',
		extendedTimeOut : '2000',
		allowHtml : false,
		closeButton : false,
		tapToDismiss : true,
		progressBar : false,
		newestOnTop : true,
		maxOpened : 0,
		preventDuplicates : false,
		preventOpenDuplicates : false,
		title : "",
		msg : ""
	};

	
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
	
	
	
	$scope.openToast = function (toasterTitle,toasterMsg,messageType) {
		$scope.options.title=toasterTitle;
		$scope.options.msg=toasterMsg;
		$scope.options.type=messageType;
	      angular.extend(toastrConfig, $scope.options);
	      openedToasts.push(toastr[$scope.options.type]($scope.options.msg, $scope.options.title));
	}
	
	$scope.clearToasts = function() {
		toastr.clear();
	};

	$scope.$on('$destroy', function iVeBeenDismissed() {
		angular.extend(toastrConfig, defaultConfig);
	})
	
	 
	
	
});