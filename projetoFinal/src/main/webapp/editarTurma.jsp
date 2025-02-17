<!DOCTYPE html>
<html lang="pt-BR">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
	<title>Turma</title>
	</head>
	<body>
		<div class="edit">
			<h1>Editar turma</h1>
			<form name="formTurma"action="updateTurma">
				<div>
				
					<label for="">Sala:</label>
					<input type="text" name="sala" value="<%out.print(request.getAttribute("sala"));%>">
				
				</div>
				<div>
				
					<label for="">Quantidade de alunos:</label>
					<input type="text" name="quant" class="phone_with_ddd" value="<%out.print(request.getAttribute("quant"));%>">
					
				</div>
				
				<input type="button" value="Editar" class="enviar" onclick="validarTurma()">
			</form>
			<script src="validador.js"></script>
			<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
			<script>
			
			$('.phone_with_ddd').mask('00');
			
			</script>
		</div>
	</body>
</html>