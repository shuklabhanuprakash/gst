app.controller("CompanyController",function($scope,$http,$state,toastr,
		toastrConfig){
	
	$scope.sellers=[];
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
	
	
	$scope.$on('$stateChangeStart', function() {getSellers(); });
	
	const getSellers =function(){
		$http.get("/gst/sellers").then(function(response){
			console.log(response)
			$scope.sellers=response.data;
			
		},function(error){
			console.log("error",error);
		});
		
	}
	
	$scope.deleteCompany=function(id){
		$http.get("/gst/deleteSeller/"+id).then(function(response){
			console.log(response)
			const toasterTitle="Company";
			const toasterMsg="deleted successfully";
			const messageType="success";
			$scope.openToast(toasterTitle,toasterMsg,messageType);
			$scope.sellers=response.data;
			
		}, function(error) {
			console.log("error", error);
			const toasterTitle="Failed to delete company";
			const toasterMsg="please try again later.";
			const messageType="error";
			$scope.openToast(toasterTitle,toasterMsg,messageType);
		});
	}
	
	
	$scope.editCompany=function(sellerId){
		$state.go("master.company.companyRegistration", { "id": sellerId });
		
		
	}
	
	$scope.init=function(){
		getSellers();
		$state.go("master.company.companyList");
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