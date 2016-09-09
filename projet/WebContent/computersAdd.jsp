<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />

<div class="container-fluid">
	<div class="row">
	<div class="col-md-12">
		<h1>Add Computer</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<form role="form" action="" method="POST">
				<c:forEach var="widget" items="${form.getWidgets()}">
					<div class="form-group ${ widget.isValid() ?"":"has-error" }">
						<label for="name">${ widget.getLabel() }</label>
						<input type="text"
							class="form-control"
							id="${ widget.getName() }" name="${ widget.getName() }"
							value="${ widget.getValue() }"
							<c:forEach var="entry" items="${ widget.getAttributes().entrySet() }" >
								${ entry.getKey() }="${ entry.getValue() }"
							</c:forEach>
						>
						<c:if test="${ !widget.isValid() }"  >
							<ul class="help-block">
								<c:forEach var="validator" items="${ widget.getValidators() }">
									<li>${ validator.getError() }</li>
								</c:forEach>
							</ul>
						</c:if>
					</div>
				</c:forEach>
				<div class="form-group">
					<label for="company">Company Name:</label>
					<div class="input">
						<select name="company" class="form-control">
						<c:forEach var="c" items="${ companies}">
							<option value="${ c.getId() }">${ c.getName() }</option>
						</c:forEach>
						</select>
					</div>
				</div>

				<div class="actions">
					<button type="submit" class="btn btn-success">Submit</button>
					or <a href="/projet-java/computers" class="btn btn-danger">Cancel</a>
				</div>
			</form>
		</div>
	</div>
</div>

<jsp:include page="include/footer.jsp" />