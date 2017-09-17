app.controller("ProductController", function($scope, $http, $state,toastr,
		toastrConfig) {

	$scope.products = [];
	var openedToasts = [];
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

	$scope.$on('$stateChangeStart', function() {
		getProducts();
	});

	const getProducts = function() {
		$http.get("/gst/products").then(function(response) {
			console.log(response)
			$scope.products = response.data;

		}, function(error) {
			console.log("error", error);
		});

	}

	$scope.deleteProduct = function(id) {
		$http.get("/gst/deleteProduct/" + id).then(function(response) {
			console.log(response)
			const toasterTitle="Product";
			const toasterMsg="deleted successfully";
			const messageType="success";
			$scope.openToast(toasterTitle,toasterMsg,messageType);
			$scope.products = response.data;

		}, function(error) {
			console.log("error", error);
			const toasterTitle="Failed to delete product";
			const toasterMsg="please try again later.";
			const messageType="error";
			$scope.openToast(toasterTitle,toasterMsg,messageType);
		});
	}

	$scope.editProduct = function(productId) {
		$state.go("master.product.productRegistration", {
			"id" : productId
		});

	}

	$scope.init = function() {
		getProducts();
		$state.go("master.product.productList");
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