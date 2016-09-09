<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="com.floriancourgey.java.cours1.models.Computer"%>
 
<jsp:include page="include/header.jsp" />

<% ArrayList<Computer> computers = (ArrayList<Computer>) request.getAttribute("computers"); %>
<% SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY"); %>
<% Computer computerAdded = (Computer) request.getAttribute("computerAdded"); %>

<div class="container-fluid">
  <div class="row">
  	<div class="col-md-12">
	<h1 id="homeTitle"><%= computers.size() %> Computers found</h1>
	</div>
  </div>
  <% if(computerAdded != null){ %>
  <div class="alert alert-success alert-dismissible" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <strong>Success</strong> The computer '<%= computerAdded.getName() %>' has been successfuly added.
</div>
  <% } %>
	<div class="row" id="actions">
		<div class="col-md-10">
		<form action="" method="GET" class="form-inline" role="form">
			<input type="search" id="searchbox" name="google" class="form-control"
				value="" placeholder="Try 'think' or 'apple'">
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
					<!-- Variable declarations for passing labels as parameters -->
					<!-- Table header for Computer Name -->
					<th>Computer Name</th>
					<th>Introduced Date</th>
					<!-- Table header for Discontinued Date -->
					<th>Discontinued Date</th>
					<!-- Table header for Company -->
					<th>Company</th>
				</tr>
			</thead>
			<tbody>
				<% for(Computer c : computers) { %>
				<tr>
					<td><%= c.getName() %></td>
					<td><%= (c.getIntroduced()==null)?"-":format.format(c.getIntroduced()) %></td>
					<td><%= (c.getDiscontinued()==null)?"-":format.format(c.getDiscontinued()) %></td>
					<td><%= (c.getCompany()==null)?"-":c.getCompany().getName() %></td>
				</tr>
				<% } %>
			</tbody>
		</table>
		</div>
	</div>
</div>

<jsp:include page="include/footer.jsp" />
