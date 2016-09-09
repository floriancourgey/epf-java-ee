<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />

<div class="container-fluid">
  <div class="row">
  	<div class="col-md-12">
	<h1 id="homeTitle">${computers.size()} Computers found</h1>
	</div>
  </div>
  <c:if test="${not empty computerAdded}">
	  <div class="alert alert-success alert-dismissible" role="alert">
	    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<strong>Success</strong> The computer '${computerAdded.getName()}' has been successfuly added.
	</div>
  </c:if>
	<div class="row" id="actions">
		<div class="col-md-10">
		<form action="" method="GET" class="form-inline" role="form">
			<input type="search" id="searchbox" name="google" class="form-control"
				value="${ google }" placeholder="Try 'think' or 'apple'">
			<input type="submit" id="searchsubmit"
				required="required"
				value="Google"
				class="btn btn-primary">
		</form>
		</div>
		<div>
		</div>
		<div class="col-md-2">
		<a id="add" href="computers/add" role="button" class="btn btn-success pull-right">Add Computer</a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
		<table class="computers table table-striped table-bordered">
			<thead>
				<tr>
					<th>Computer Name</th>
					<th>Introduced Date</th>
					<th>Discontinued Date</th>
					<th>Company</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${computers}" >
				<tr>
					<td>${ c.getName()}</td>
					<td>${ empty c.getIntroduced()?"-":format.format(c.getIntroduced()) }</td>
					<td>${ empty c.getDiscontinued()? "-":format.format(c.getDiscontinued()) }</td>
					<td>${ empty c.getCompany()?"-":c.getCompany().getName() }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
</div>

<jsp:include page="include/footer.jsp" />
