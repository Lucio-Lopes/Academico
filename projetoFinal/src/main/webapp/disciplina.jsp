<%@page import="model.Disciplina" %>
<%@page import="java.util.ArrayList" %>
<%

	ArrayList<Disciplina> lista = (ArrayList<Disciplina>) request.getAttribute("disciplinas");

%>
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
	<title>Disciplinas</title>
	</head>
	<body>
		<div class="tabelas">
		<div class="cabecalho">
		
			<h1>Disciplinas</h1>
			<a href="novaDisciplina.html" class="nova">Nova Disciplina</a>
		</div>
		
		<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Semestre</th>
				<th>Horas</th>
				<th>Opções</th>		
			<tbody>
					<%for(int i =0; i<lista.size();i++){%>
						<tr>
							<td><%=lista.get(i).getId()%></td>
							<td><%=lista.get(i).getNome()%></td>
							<td><%=lista.get(i).getSemestre()%></td>
							<td><%=lista.get(i).getCarga_horaria()%></td>
							<td><a href="selectDisc?id=<%=lista.get(i).getId()%>">Editar</a> | <a href="javascript:confirmarDisc(<%=lista.get(i).getId()%>)">Excluir</a></td>
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