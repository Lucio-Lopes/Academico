<%@page import="model.Professor" %>
<%@page import="java.util.ArrayList" %>
<%

	ArrayList<Professor> lista = (ArrayList<Professor>) request.getAttribute("professores");

%>
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
	<title>Professores</title>
	</head>
	<body>
	<div class="tabelas">
			<div class="cabecalho">
				<h1>Professores</h1>
				<a href="novoProfessor.html" class="nova">Novo Professor</a>
			</div>
			<table id="tabela">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Telefone</th>
					<th>Email</th>
					<th>Opções</th>			
				<tbody>
						<%for(int i =0; i<lista.size();i++){%>
						<tr>
							<td name="nome"><%=lista.get(i).getNome()%></td>
							<td><%=lista.get(i).getFone()%></td>
							<td><%=lista.get(i).getEmail()%></td>
							<td><a href="selectProf?id=<%=lista.get(i).getId()%>">Editar</a> | <a href="javascript:confirmarProf(<%=lista.get(i).getId()%>)">Excluir</a> | <a href="detalhes?id=<%=lista.get(i).getId()%>">Detalhes</a></td>
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