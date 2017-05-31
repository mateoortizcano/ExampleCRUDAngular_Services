app.controller("personCtrl",  ["$scope",  "personService", function personCtrl($scope, personService) {
	$scope.id ="";	
	$scope.personOut = {};	
	$scope.personIn= {};
	$scope.search = function(id){		
		if(id==""){
			alert("Ingrese algun valor de identidad");
		}else{
			personService.login(id).then(function (message) {	
				$scope.personOut={"nombre":message.data.nombre,"apellidos":message.data.apellidos,"telefono":message.data.telefono};			        	
				if(message.data==""){
	        		alert("El usuario no existe");
	        	}
	        })
		}
	}
	$scope.peoplelist={};
	$scope.getList=function(){
		personService.getList().then(function (message){
			$scope.peoplelist=message.data;
			if(message.data==""){
				alert("No hay ningun usuario registrado");
			}
		})
	}
	$scope.deleteperson=function(id){	
		personService.deletePerson(id).then(function(message){
			$scope.getList();
			alert(message.data+" El usuario ha sido eliminado");
		});
	}
	$scope.person={};
	$scope.save=function(personIn){		
		if(personIn.nombre==null || personIn.apellidos==null || personIn.telefono==null){
			alert("Debe ingresar todos los campos")
		}else{
			person={"id":personIn.id,"nombre": personIn.nombre,"apellidos":personIn.apellidos,"telefono":personIn.telefono};		
			personService.save(person).then(function(message){
				$scope.getList();
				alert(message.data+" El usuario ha sido almacenado");
			})
		}
	}
	$scope.update= function(personIn){
		if(personIn.nombre==null || personIn.apellidos==null || personIn.telefono==null){
			alert("Debe ingresar todos los campos")
		}else{
			person={"id":personIn.id,"nombre": personIn.nombre,"apellidos":personIn.apellidos,"telefono":personIn.telefono};
			personService.update(person).then(function(message){
				$scope.getList();
				alert(message.data+" Los datos del usuario han sido actualizados");
			})
		}
	}
	$scope.editperson= function(persona){	
		$scope.personIn.id=persona.id;
		$scope.personIn.nombre=persona.nombre;
		$scope.personIn.apellidos=persona.apellidos;
		$scope.personIn.telefono=persona.telefono;
	}
}]);