<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
	<H3>SHIPMENTTYPE EDIT PAGE</H3>
	<form:form action="update" method="POST" modelAttribute="shipmentType">
		<pre>
ShipmentId:
<form:input path="shipId" readonly="true"/>

Shipment mode:
<form:select path="shipMode">
<form:option value="">------select------</form:option>
<form:option value="Air">Air</form:option>
<form:option value="Truck">Truck</form:option>
<form:option value="Ship">Ship</form:option>
<form:option value="Train">Train</form:option>
</form:select>

ShipmentCode:
<form:input path="shipCode" />

Enable Shipment:
<form:select path="enbship">
<form:option value="">------select------</form:option>
<form:option value="yes">YES</form:option>
<form:option value="No">No</form:option>
</form:select>

ShipGrade: 
<form:radiobutton path="shipGrad" value="A"/>A<form:radiobutton path="shipGrad" value="B"/>B<form:radiobutton path="shipGrad" value="C"/>C

Description:
<form:textarea path="shipDesc"></form:textarea>
<input type="submit" value="update"/>
</pre>
	</form:form>
	${"message"}
</body>
</html>
