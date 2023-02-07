<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="DisplayVets" method="get">
	<select name="vetId">
	
	<c:forEach items="${vetList}" var="vetListJSPvar">
	<option value="${vetListJSPvar.id}"
		<c:if test = "${vetListJSPvar.id == param.vetId}">selected</c:if>
		>${vetListJSPvar.vetName}</option>
	</c:forEach>
	</select>
	<button type="submit">Select</button>
	<a href="AddVet">Add Vet</a>
	</form>
	
	<form action="AddAnimal?vetId=${localVetVar.id}" method = "post">
	<table border = "1">
	<c:forEach items="${localVetVar.patientName}" var="patientList"> <!-- labeling var as JSp var to avoid confusion with similar names -->
		<tr> <!-- localVetVar comes from condition found in doGet method of DisplayVets servlet -->
			<td> <c:if test="${patientList.getIsTreated()}">
					<del>${patientList.patient} </del><!-- patient is from Animal class -->
				</c:if>
				<c:if test="${! patientList.getIsTreated()}">
					${patientList.patient}
				</c:if>
			</td>
			<td>
				<c:if test="${! patientList.getIsTreated()}">
					<a href="TreatedAnimal?vetId=${localVetVar.id}&animalId=${patientList.id}">Done</a>
				</c:if>
			</td>
		</tr>
	</c:forEach>
		<tr>
			<td><input type="text" name="addPatient"></td>
			<td><button type="submit">Add Patient</button></td>
		</tr>
	
	</table>
	
	</form>
	
</body>
</html>
