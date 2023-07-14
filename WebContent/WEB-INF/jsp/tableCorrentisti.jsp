<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page language="java" import="java.util.ArrayList"%>

<%@ page import="objects.Anagrafica"%>
<%
	ArrayList<Anagrafica> listaAnagrafica = new ArrayList<>();
	request.getAttribute("listaAnagrafica");
%>
<head>
	<script>
		function mostraDettagli(cognome, nome, rag_soc, telefono) {
			var details = "Cognome: " + cognome + "\n" + "Nome: " + nome + "\n" + "Ragione Sociale: " + rag_soc + "\n"
					+ "Telefono: " + telefono;
			alert(details);
		}

		function mostraPopup() {
			var confirmation = confirm("La modifica è stata eseguita correttamente.");
			if (confirmation) {
				document.getElementById("myForm").submit();
			}
		}
	</script>
	
</head>

<div class="row justify-content-center">
	<h1 class="m-1"><span>Tabella</span><span> Correntisti</span></h1>
</div>

<div id="tabellaCard" class="card m-5" style="top:50px">
	<div class="card-body">
		<form id="myForm" method="POST" action="saveData.jsp">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="monospace" scope="col">Cognome</th>
						<th scope="col">Nome</th>
						<th scope="col">Ragione Sociale</th>
						<th scope="col">Telefono</th>
						<th scope="col" class="column-small">Info</th>
					</tr>
				</thead>
				<tbody id="corpoTab">
					<c:forEach var="anagrafica" items="${listaAnagrafica}">
						<tr class="table-info">
							<td>${anagrafica.getCognome()}</td>
							<td>${anagrafica.getNome()}</td>
							<td>${anagrafica.getRag_soc()}</td>
							<td>${anagrafica.getTelefono1()}</td>
							<td class="column-small">
								<i class="fas fa-search" onclick="mostraDettagli('${anagrafica.getCognome()}', '${anagrafica.getNome()}', '${anagrafica.getRag_soc()}', '${anagrafica.getTelefono1()}')">&#x1F50D;</i>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="row justify-content-center">
				<button type="button" onclick="mostraPopup()" class="btn btn-primary">Save</button>
			</div>
		</form>
	</div>
</div>
