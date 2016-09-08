<%@page import="java.util.*"%>
<%@page import="com.floriancourgey.java.cours1.models.Company"%>

<jsp:include page="include/header.jsp" />

<% ArrayList<Company> companies = (ArrayList<Company>) request.getAttribute("companies"); %>

<div class="container-fluid">
	<div class="row">
	<div class="col-md-12">
		<h1>Add Computer</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<form role="form" action="" method="POST">
				<div class="form-group">
					<label for="name">Computer name</label>
					<input type="text" name="name"
						class="form-control" id="name" placeholder="Enter name">
					<p class="help-block">Required</p>
				</div>
				<div class="form-group">
					<label for="introduced">Introduced date</label>
					<input type="date" name="introduced"
						class="form-control" id="introduced" pattern="\d{4}-\d{2}-\d{2}"
						placeholder="Introduced"> <span class="help-block">YYYY-MM-DD</span>
				</div>
				<div class="form-group">
					<label for="discontinued">Discontinued date</label>
					<input
						type="date" class="form-control" id="discontinued"
						pattern="YY-MM-dd" placeholder="Discontinued"> <span
						class="help-block" name="discontinued">YYYY-MM-DD</span>
				</div>
				<div class="form-group">
					<label for="company">Company Name:</label>
					<div class="input">
						<select name="company" class="form-control">
						<% for(Company c : companies){ %>
							<option value="<%= c.getId() %>"><%= c.getName() %></option>
						<% } %>
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