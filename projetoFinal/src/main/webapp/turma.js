const select = document.getElementById("disciplina");



select.addEventListener('change', function(e) {
	location.href="atualizar?id="+select.value
	
 });