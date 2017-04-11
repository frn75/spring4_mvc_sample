<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp" />

<div class="jumbotron  bg-info">
	<div class="container">
		<h4>${title}</h4>
		<p>
		    Tablespace List:
		</p>
	</div>
</div>

<div class="container">
    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th>#ID</th>
                <th>TABLESPACE NAME</th>
                <th>SPACE ALLOCATED (MB)</th>
                <th>SPACE USED (MB)</th>
                <th>SPACE FREE (MB)</th>
                <th>SPACE FREE (%)</th>
            </tr>
        </thead>
        <tbody>
            <%-- Loop --%>
          <c:forEach var="tblSpace" items="${tablespaceList}" varStatus="loop">
            <tr>
                <td></td>
                <td>${tblSpace.name}</td>
                <td>${tblSpace.spaceTotal}</td>
                <td>${tblSpace.spaceUsed}</td>
                <td>${tblSpace.spaceFree}</td>
                <td>${tblSpace.spaceFreePct}</td>
            </tr>
          </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="footer.jsp" />