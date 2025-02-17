<%@page import="model.Disciplina" %>
<%@page import="model.Professor" %>
<%@page import="java.util.ArrayList" %>

<%

	ArrayList<Disciplina> disc = (ArrayList<Disciplina>) request.getAttribute("disc");

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
		<div class="edit">
			<h1>Criar turma</h1>
			<form name="formTurma"action="insertTurma">
				<div>
				
				<div>
				
					<label>Disciplina:</label>
					<select name="disciplina" id="disciplina">
						
						<option>Todas as disciplinas</option>
						<%for(int i=0; i<disc.size();i++){%>
							
							<option value="<%out.print(disc.get(i).getId());%>"><%=disc.get(i).getNome()%></option>
							
						<%} %>
						
					</select>
				
				</div>
				<div>
				
					<label>Professor:</label>
					<select name="professor">
						<option></option>
					</select>
					
				</div>
				
					<label for="">Sala:</label>
					<input type="text" name="sala" id="sala">
				
				</div>
				<div>
				
					<label for="">Quantidade de alunos:</label>
					<input type="text" name="quant" class="phone_with_ddd" id="quant">
					
				</div>
				
				
				<input type="button" value="Criar" class="enviar" onclick="validarTurma()">
			</form>
			<script src="turma.js"></script>
			<script src="validador.js"></script>
			<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
			<script>
			
			$('.phone_with_ddd').mask('00');
			
			
			</script>
		</div>
	</body>
</html>