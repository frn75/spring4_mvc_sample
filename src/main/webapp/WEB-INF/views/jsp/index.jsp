<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp" />

<div class="jumbotron  bg-info">
	<div class="container">
		<h4>${title}</h4>
		<p>
		    Server statistics &nbsp;
		</p>
	</div>
</div>

<div class="container">

	<div class="row">
		<div class="col-md-4 ">
			<p>DATA Usage</p>
			<p>
				<a class="btn btn-default" href="data_usage" role="button"># Go</a>
			</p>
		</div>
		<div class="col-md-4">
			<p>Schemas</p>
			<p>
				<a class="btn btn-success" href="schemas" role="button"># Go</a>
			</p>
		</div>
		<div class="col-md-4">
			<p>Sessions</p>
			<p>
				<a class="btn btn-info" href="#" role="button"># Go</a>
			</p>
		</div>
	</div>

	<hr>
</div>

<jsp:include page="footer.jsp" />