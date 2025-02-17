<%@page import="model.Disciplina" %>
<%@page import="model.Professor" %>
<%@page import="java.util.ArrayList" %>

<%

	ArrayList<Disciplina> disc = (ArrayList<Disciplina>) request.getAttribute("disciplinas");
	ArrayList<Professor> prof = (ArrayList<Professor>) request.getAttribute("professores");

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="style.css">
		<title>Disciplinas ministradas</title>
	</head>
	<body>
		<div class="edit">
		
			<form name="formPD" action="insertProfDisc">
				
				<select name="professor">
					<%for(int i=0; i<prof.size();i++){%>
						
						<option value="<%out.print(prof.get(i).getId());%>"><%=prof.get(i).getNome()%></option>
						
					<%} %>
				</select>
				<h4>Ministra</h4>
				<select name="disciplina">
					<%for(int i=0; i<disc.size();i++){%>
						
						<option value="<%out.print(disc.get(i).getId());%>"><%=disc.get(i).getNome()%></option>
						
					<%} %>
				</select>
				<input type="submit" value="enviar" class="enviar">
			</form>
		
		</div>
	</body>
</html>