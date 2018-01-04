<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>View Transaction History</title>
        <jsp:include page="css.jsp" />
    </head>   
    <body>
      <div id = "wrapper">
        <jsp:include page="header.jsp" />
        <jsp:include page="employeeNav.jsp"/>
      <main>
         <div class = "panel">
			<h2>Messages</h2>
			<c:forEach var="message" items="${messages}">
				<h3 style="color:blue"> ${message} </h3>
			</c:forEach>
		</div>
	</div>
<jsp:include page="footer.jsp" />