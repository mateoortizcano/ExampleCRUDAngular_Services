app.factory("personService", function($q, $http) {
	return {
		login : function(identification) {
			return $http.get('http://localhost:8080/PersonaCRUD/rest/services/findById/'+identification).then(function(data) {				          
			var received = angular.fromJson(data);				
				return received;				
			}).catch(function (data) {
				console.log(data);
			});
		},
		getList : function(){
			return $http.get('http://localhost:8080/PersonaCRUD/rest/services/getlist').then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		deletePerson :function(identification){
			return $http.get('http://localhost:8080/PersonaCRUD/rest/services/deletePerson/'+identification).then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		save: function(person){			
			return $http.put('http://localhost:8080/PersonaCRUD/rest/services/addPerson', person).then(function(data){
				var received=angular.fromJson(data);				
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		update: function(person){
			return $http.post('http://localhost:8080/PersonaCRUD/rest/services/updatePerson', person).then(function(data){
				var received=angular.fromJson(data);
				return received;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});
	