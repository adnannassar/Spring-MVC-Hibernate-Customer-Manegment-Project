
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
</head>

<body>

	<div id="wrapper">
		<div id="header" >
			<h2>
				CRM - Customer Relationship Manager
			</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content" >
			<!-- Add the HTML Table here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				 </tr>
				 
				 <!-- Loop over and print the customers from the DAO list -->
				 <c:forEach var="tempCustomer" items="${customersWichtigLink }">
				 		<tr>
				 			<td>${tempCustomer.firstName }</td>
				 			<td>${tempCustomer.lastName }</td>
				 			<td>${tempCustomer.email }</td>
				 		</tr>
				 </c:forEach>
				 
			</table>
		</div>
	</div>
	

</body>

</html>









