app.controller("SalesInvoiceController",function($scope,$http,$state,toastr,
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
	
	
	$scope.$on('$stateChangeStart', function() {getsalesInvoices(); });
	
	const getsalesInvoices =function(){
		$http.get("/gst/salesInvoices").then(function(response){
			console.log(response)
			$scope.salesInvoice=response.data;
			
		},function(error){
			console.log("error",error);
		});
		
	}
	
	$scope.deleteCompany=function(id){
		$http.get("/gst/deleteSalesInvoice/"+id).then(function(response){
			console.log(response)
			const toasterTitle="Sales Invoice";
			const toasterMsg="deleted successfully";
			const messageType="success";
			$scope.openToast(toasterTitle,toasterMsg,messageType);
			$scope.salesInvoice=response.data;
			
		}, function(error) {
			console.log("error", error);
			const toasterTitle="Failed to delete sales invoice";
			const toasterMsg="please try again later.";
			const messageType="error";
			$scope.openToast(toasterTitle,toasterMsg,messageType);
		});
	}
	
	
	/*$scope.editCompany=function(sellerId){
		$state.go("master.company.companyRegistration", { "id": sellerId });
		
		
	}*/
	
	$scope.init=function(){
		getsalesInvoices();
		$state.go("invoices.salesInvoice.salesInvoiceList");
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