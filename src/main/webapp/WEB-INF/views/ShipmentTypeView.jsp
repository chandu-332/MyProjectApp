<html>
<body>
	<H3>WELCOME TO SHIPMENTTYPE VIEW PAGE</H3>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.shipId}</td>
		</tr>
		<tr>
			<th>MODE</th>
			<td>${ ob.shipMode}</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.shipCode}</td>
		</tr>
		<tr>
			<th>ENABLE</th>
			<td>${ob.enbship}</td>
		</tr>
		<tr>
			<th>GRADE</th>
			<td>${ob.shipGrad}</td>
		</tr>
		<tr>
			<th>Description</th>
			<td>${ob.shipDesc}</td>
		</tr>
		 <a href="excel?id=${ob.shipId}">Excel Export</a>|<a href="pdf?id=${ob.shipId}">Pdf Export</a>
	</table>
</body>
</html>