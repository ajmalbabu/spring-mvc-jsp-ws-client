 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page isELIgnored="false"%>
 
<html>
<head>
	<title>Application using SOAP Web services</title>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

	<script type="text/javascript">

		//var loadTime = window.performance.timing.domContentLoadedEventEnd- window.performance.timing.navigationStart;
		var startTime = new Date(<c:out value="${model.starttime}"/>)
	</script>

	<style type="text/css">
		/*table tr:nth-child(odd) td{*/
			/*background-color:green;*/
		/*}*/
		/*table tr:nth-child(even) td{*/
			/*background-color:white;*/
		/*}*/
		h2 {
			text-align: left;
		}
		a {
			text-align: left;
		}
		h2,h3,a {
			text-align: left;
		}
	</style>



</head>
<body>

	<script type="text/javascript">

		$(document).ready(function() {
			console.log("Time until DOMready in millies: ", Date.now()- startTime);
		});
		$(window).load(function() {
			console.log("Time until everything loaded in millies: ", Date.now()- startTime);
			$("#timelabel").text((Date.now()- startTime) / 1000);
		});

		function searchKeyPress(e)
		{
			// look for window.event in case event isn't passed in
			e = e || window.event;
			if (e.keyCode == 13)
			{
				$("#searchLink").click();
			}
		}

//		function blinker() {
//			$('#timelabel').fadeOut(500).fadeIn(500);
//		}
//
//		setInterval(blinker, 500);
	</script>

	<div style="text-align:center">

		<h2>
			Application using SOAP Web services.
		</h2>
		<form id="form1" action="fetch.html" method="post">
			<h3>
				<label>Number of records: </label>
				<input type="text" onkeypress="searchKeyPress(event);" id="count" name="count" value="<c:out value="${model.count}"/>">
				<input type="hidden" id="starttime" name="starttime" value="">
				</br>
				</br>
				<a href="javascript:;" id="searchLink" onclick="
								document.getElementById('starttime').value = Date.now();
								document.getElementById('form1').submit();">
					Fetch </a>
			</h3>
		</form>


		<div style="text-align:left">
			<label>Time to process data by SOAP services in seconds: </label><label style="color: red; font-weight: bold" id="backEndtimelabel"><c:out value="${model.backEndTime}"/></label>
			<br>
			<br>
			<label>Total time to render application in seconds: </label><label style="color: red; font-weight: bold" id="timelabel"></label>
		</div>

		<br>

		<table border=1>
			<tr>
				<th>Country Name</th>
    			<th>Population</th>
    			<th>Capital</th>
				<th>Currency</th>
			</tr>
			<c:forEach items="${model.result}" var="r">
			  <tr>
				  <td>${r.name}</td>
				  <td>${r.population}</td>
				  <td>${r.capital}</td>
				  <td>${r.currency}</td>
			  </tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>