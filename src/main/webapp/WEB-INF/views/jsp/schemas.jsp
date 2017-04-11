<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp" />

<div class="jumbotron  bg-info">
	<div class="container">
		<h4>${title}</h4>
		<p>
		    User list:
		</p>
	</div>
</div>

<div class="container">
    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th>#ID</th>
                <th>USER NAME</th>
                <th>DEFAULT TABLESPACE</th>
                <th>CREATED</th>
                <th>STATUS</th>
                <th>&nbsp;</th>
            </tr>
        </thead>
        <tbody>
          <%-- Loop --%>

          <c:forEach var="userInfo" items="${userList}" varStatus="loop">
            <tr>
                <td></td>
                <td>${userInfo.userName}</td>
                <td>${userInfo.defaultTablespace}</td>
                <td>${userInfo.creationDate}</td>
                <td>${userInfo.status}</td>
                <td>&nbsp;</td>
            </tr>
          </c:forEach>

        </tbody>
    </table>
</div>

<jsp:include page="footer.jsp" />