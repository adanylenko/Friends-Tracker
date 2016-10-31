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
	<td width="50%">
	<div class="container">
		<table id="citiesTable">
			<tr>
				<th>City Name</th>
				<th>photo</th>
			</tr>

		</table>
	</div>
	<button onclick="location.href = 'addCity.jsp'">Add city</button>
	<button onclick="changeCity()">Change city</button>
	<button onclick="deleteCity()">Delete city</button>
	</td>

	</tr>
	</table>
</body>
<script>
	var selectedCityId = -1;
	function changeCity() {
		if (selectedCityId === -1) {
			alert("first select city!");
			return;
		}
		window.location = 'addCity.jsp?id=' + selectedCityId;
	}

	function deleteCity() {
		if (selectedCityId === -1) {
			alert("first select city!");
			return;
		}
		$.ajax({
			url : './rest/' + selectedCityId,
			method : "DELETE",
			success : location.reload()
		});
	}

	function requestCities() {
		$.ajax({
			url : './rest/',
			accepts : {
				json : "application/json;odata=verbose"
			},
			method : "GET",
			success : onQuerySuccess,
			error : onQueryError
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
		cell.setAttribute("data-city-name", current.cityName, 0);
		cell.setAttribute("data-city-lat", current.locationLat, 0);
		cell.setAttribute("data-city-lng", current.locationLng, 0);

		cell.innerHTML = current.cityName;
		//  var cell = row.insertCell(1);
		//  cell.innerHTML = current.cityName;
		//  var cell = row.insertCell(2);
		//  cell.innerHTML = current.locationLat;
		//  var cell = row.insertCell(3);
		// cell.innerHTML = current.locationLng;

		var cell = row.insertCell(1);
		var img = document.createElement('img');
		img.setAttribute("id", "imageIcon");
		img.src = current.photo;
		cell.appendChild(img);

		var createClickHandler = function() {
			return function() {
				$(this).addClass('selected').siblings().removeClass('selected');
				selectedCityId=$(this).find('#city-1').data('city-id');
				var cityLat = $(this).find('#city-1').data('city-lat');
				var cityLng = $(this).find('#city-1').data('city-lng');
				var myLatLng = {
					lat : cityLat.valueOf(),
					lng : cityLng.valueOf()
				};
				window.moveMarker = myLatLng;
			};
		};
		row.onclick = createClickHandler(row);
	}

	function onQueryError(error) {
		alert("error " + JSON.parse(error));
	}
</script>
</html>
