<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h1>Hi ${name} Your todos</h1>

	<table class="table" cellpadding="10px" border cellspacing="0">
		<thead>
			<tr>
				<th>DESCRIPTION</th>
				<th>PLAN DATE</th>
				<th>STATUS</th>
				<th>DELETE</th>
				<th>UPDATE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.getDescription()}</td>
					<td>${todo.getPlanDate()}</td>
					<td>${todo.getStatus()}</td>
					<td><a href="delete-todo?id=${todo.getId()}"
						class="btn btn-warning">Delete</a></td>
					<td><a href="update-todo?id=${todo.getId()}"
						class="btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</div>
<a href="add-todos" class="btn btn-success">ADD TODO</a>

<%@ include file="common/footer.jspf"%>