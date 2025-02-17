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
			<h1>Editar disciplina</h1>
			<form name="formDisc"action="updateDisc">
				<div>
				
					<label for="">Nome:</label>
					<input type="text" name="nome" value="<%out.print(request.getAttribute("nome"));%>">
				
				</div>
				<div>
				
					<label for="">Semestre:</label>
					<input type="text" name="semestre" maxlength="1" class="semestre phone_with_ddd" value="<%out.print(request.getAttribute("semestre"));%>">
					
				</div>
				<div>
				
					<label for="">Carga horaria:</label>
					<input type="text" name="hora" maxlength="2" class="phone" value="<%out.print(request.getAttribute("carga_horaria"));%>">
					
				</div>
				
				<input type="button" value="Editar" class="enviar" onclick="validarDisc()">
			</form>
			<script src="validador.js"></script>
			<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
			<script>
			
			$('.phone_with_ddd').mask('0');
			$('.phone').mask('00');
			</script>
		</div>
	</body>
</html>