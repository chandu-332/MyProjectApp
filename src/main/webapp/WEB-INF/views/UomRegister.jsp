<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
	<h3>UOM REGISTER</h3>
	<form:form action="save" method="POST" modelAttribute="uom">
		<pre>
Uom Type:<form:select path="uomType">
<form:option value="">------select------</form:option>
<form:option value="Packing">PACKING</form:option>
<form:option value="No-Packing">NO-PACKING</form:option>
<form:option value="-NA-">-NA-</form:option>
</form:select>

Uom Model:<form:input path="uomModel" />

Description:
<form:textarea path="uomDesc" />
<input type="submit" value="Create" />
</pre>
	</form:form>
	${message}
</body>
</html>

