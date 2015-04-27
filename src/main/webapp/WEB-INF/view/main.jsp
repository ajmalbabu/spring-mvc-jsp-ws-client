<html>
<head>
	<title>Application using SOAP Web services.</title>

	<style type="text/css">
		h2,h3,a {
			text-align: left;
		}
	</style>
</head>
<body>
	<br>
	<div style="text-align:center">
		<h2>
			Application using SOAP Web services.
		</h2>
		<form id="form1" action="fetch.html" method="post">
			<h3>
				<label>Number of records: </label>
				<input type="text" id="count" name="count" value="10">
				<input type="hidden" id="starttime" name="starttime" value="">
				</br>
				</br>
				<a href="javascript:;" onclick="
								document.getElementById('starttime').value = Date.now();
								document.getElementById('form1').submit();">
						Fetch </a>
			</h3>
		</form>
	</div>
</body>
</html>