app.controller("CompanyRegistrationController",function($scope,$http,$stateParams,$state ){
	
	
	$scope.init=function(){
		
		if($stateParams.id){
			$http.get("/gst/seller/"+$stateParams.id).then(function(response){
				console.log(response)
				$scope.company=response.data;
				//$state.go("master.product.productRegistration", { "id": productId });
				
			},function(error){
				console.log("error",error);
			});
		}
	}
	
	$scope.saveCompany=function(){
		$http.post("/gst/seller",$scope.company).then(function(response){
			console.log(response)
			const toasterTitle="Company";
			const toasterMsg="registered successfully";
			const messageType="success";
			$scope.openToast(toasterTitle,toasterMsg,messageType);
			$scope.company=response.data;
			$scope.goToCompanyList();
			
			
		},function(error){
			console.log("error",error);
			const toasterTitle="Company registration failed";
			const toasterMsg="please try again later.";
			const messageType="error";
			$scope.openToast(toasterTitle,toasterMsg,messageType);
		});
		
	}
	
	$scope.goToCompanyList=function(){
		$state.go("master.company.companyList");
	}
	
});