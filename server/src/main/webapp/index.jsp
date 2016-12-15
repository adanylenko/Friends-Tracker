<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
#centralTable {
	width: 100%;
	height: 100%;
}

body {
	width: 100%;
	height: 100%;
}

#cityName, th, td {
	border: 1px solid black;
}

#imageIcon {
	height: 100px;
	width: 100px;
	border: 1px solid black;
}

td {
	border: 1px #DDD solid;
	padding: 5px;
	cursor: pointer;
}

.selected {
	background-color: brown;
	color: #FFF;
}

button {
	width: 150px;
	height: 25px;
}

.container {
	height: 100%;
	overflow: scroll;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>To visit</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

</head>
<body onload="requestCities()">
	<h1>To visit</h1>
	<table id="centralTable">
		<tr>
			<td width="50%" height="100%">
				
					<table id="citiesTable">
						<tr>
							<th>id</th>
							<th>login</th>
							<th>password</th>
						</tr>

					</table>
					<button onclick="login()">login alex </button>
				
			</td>
		</tr>
	</table>
</body>
<script>

	function requestCities() {
		$.ajax({
			url : './user/',
			accepts : {
				json : "application/json;odata=verbose"
			},
			method : "GET",
			success : onQuerySuccess,
			error : onQueryError
		});
	}
	
	function login() {
		var jSonObject = {
				"login" : "alex",
				"password" : "230395",
				"token":null,
				"id":null,
				"id_user":"1",
				"lat":"111",
				"lng":"222"
			};
		$.ajax({
			url : './user/login',
			data : JSON.stringify(jSonObject),
			contentType : "application/json; charset=utf-8",
			method : "POST",
			success : function(data) {
				alert("success:"+data);
			},
			error : function(data) {
				alert("ERROR: " + data);
			}
		});
	}

	function onQuerySuccess(data) {
		if (data) {
			var jsonMas = data;
			for ( var i in jsonMas) {
				var currentString = JSON.stringify(jsonMas[i]);
				var currentJson = JSON.parse(currentString);
				printTable(currentJson);
			}
		}
	}

	function printTable(current) {
		var table = document.getElementById("citiesTable");
		var header = table.createTFoot();
		var row = header.insertRow(0);

		var cell = row.insertCell(0);

		cell.setAttribute("id", "city-1", 0);
		cell.setAttribute("data-city-id", current.id, 0);
		cell.setAttribute("data-city-name", current.login, 0);

		cell.innerHTML = current.id;
		
		cell=row.insertCell(1);
		cell.innerHTML=current.login;
		
		cell=row.insertCell(2);
		cell.innerHTML=current.password;
	}

	function onQueryError(error) {
		alert("error " + JSON.parse(error));
	}
</script>
</html>
