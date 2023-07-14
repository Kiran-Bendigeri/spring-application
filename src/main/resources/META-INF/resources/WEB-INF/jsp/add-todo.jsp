
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h1>Hi ${name} Add Your todos</h1>

	<s:form method="post" modelAttribute="todo">


			<s:input type="hidden" path="id" readonly="true" />


		<fieldset>
			<s:label path="description">Description</s:label>
			<s:input type="text" path="description" required="required" />
			<s:errors path="description" cssClass="text-warning" />
		</fieldset>

		<fieldset>
			<s:label path="planDate">Plan Date</s:label>
			<s:input type="date" path="planDate" />
			<s:errors path="planDate" cssClass="text-warning" />
		</fieldset>

			<s:input type="hidden" path="status" readonly="true"/>



		<button type="submit">Submit</button>
	</s:form>
</div>

<%@ include file="common/footer.jspf"%>

<script type="text/javascript">
	$('#planDate').datepicker({
		format : 'yyyy-mm-dd'
	});
</script>

