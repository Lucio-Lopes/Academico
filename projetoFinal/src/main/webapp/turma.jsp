<%@page import="model.Turmas" %>
<%@page import="java.util.ArrayList" %>

<%

	ArrayList<Turmas> lista = (ArrayList<Turmas>) request.getAttribute("turmas");

%>

<!DOCTYPE html>
<html lang="pt-BR">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
	<title>Turmas</title>
	</head>
	<body>
		<div class="tabelas">
		<div class="cabecalho">
		
			<h1>Turmas</h1>
			<a href="novaTurma" class="nova">Nova Turma</a>
		</div>
		
		<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Sala</th>
				<th>Alunos</th>
				<th>Disciplina</th>
				<th>Professor</th>
				<th>Opções</th>
			<tbody>
					<%for(int i =0; i<lista.size();i++){%>
						<tr>
							<td><%=lista.get(i).getId()%></td>
							<td><%=lista.get(i).getSala()%></td>
							<td><%=lista.get(i).getQuant()%></td>
							<td><%=lista.get(i).getDisc()%></td>
							<td><%=lista.get(i).getProf()%></td>
							<td><a href="selectTurma?id=<%=lista.get(i).getId()%>">Editar</a> | <a href="javascript:confirmarTurma(<%=lista.get(i).getId()%>)">Excluir</a></td>
						</tr>
					<%} %>
			</tbody>
		</thead>
	</table>
	<a href="index.html" class="voltar">Voltar ></a>
	</div>
	<script src="confirmador.js"></script>
	</body>
</html>