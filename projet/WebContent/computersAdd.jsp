<%@page import="com.floriancourgey.java.cours1.tools.form.FormValidator"%>
<%@page import="com.floriancourgey.java.cours1.tools.form.FormGenerator"%>
<%@page import="com.floriancourgey.java.cours1.tools.form.FormWidget"%>
<%@page import="java.util.*"%>
<%@page import="com.floriancourgey.java.cours1.models.Company"%>

<jsp:include page="include/header.jsp" />

<% ArrayList<Company> companies = (ArrayList<Company>) request.getAttribute("companies"); %>
<% FormGenerator form = (FormGenerator) request.getAttribute("form"); %>

<div class="container-fluid">
	<div class="row">
	<div class="col-md-12">
		<h1>Add Computer</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<form role="form" action="" method="POST">
				<% for(FormWidget widget : form.getWidgets()){ %>
					<div class="form-group <%= (widget.isValid())?"":"has-error" %>">
						<label for="name"><%= widget.getLabel() %></label>
						<input type="text"
							class="form-control"
							id="<%= widget.getName() %>" name="<%= widget.getName() %>"
							value="<%= widget.getValue() %>"
							<% for (Map.Entry<String, String> entry : widget.getAttributes().entrySet()) { %>
								<%= entry.getKey() %>="<%= entry.getValue() %>"
							<% } %>
						>
						<% if(!widget.isValid()) { %>
							<ul class="help-block">
								<% for(FormValidator validator : widget.getValidators()){ %>
									<li><%= validator.getError() %></li>
								<% } %>
							</ul>
						<% } %>
					</div>
				<% } %>
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