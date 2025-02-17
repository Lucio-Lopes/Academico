
<%@page import="model.Disciplina" %>
<%@page import="model.Professor" %>
<%@page import="java.util.ArrayList" %>

<%

	ArrayList<Professor> lista = (ArrayList<Professor>) request.getAttribute("prof");

%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="style.css">
		<title>Professor</title>
	</head>
	<body>
		<div class="tabelas">
			<div class="cabecalho">
				<h1><%out.print(lista.get(0).getId());%></h1>
				<a href="listarProf" class="voltar">Voltar ></a>
			</div>
			<table id="tabela">
		<thead>
			<tr>
				<th>Disciplinas ministradas</th>
				<th>Total horas</th>
				<th>Total alunos</th>
			<tbody>
					<%for(int i =0; i<lista.size();i++){%>
						<tr>
						
							<td><%=lista.get(i).getNome()%></td>
							<td><%=lista.get(i).getFone()%></td>
							<td><%=lista.get(i).getEmail()%></td>
							
						</tr>
					<%} %>
			</tbody>
		</thead>
	</table>
		
	</div>
	</body>
</html>