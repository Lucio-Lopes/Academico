function confirmarProf(id){
	
	let resposta = confirm("Confirma a exclusao desse professor?")
	
	if(resposta === true){

		window.location.href="deleteProf?id="+id
	}else{
		
		
		
	}
	
}

function confirmarDisc(id){
	
	let resposta = confirm("Confirma a exclusao dessa disciplina?")
	
	if(resposta === true){

		window.location.href="deleteDisc?id="+id
	}else{
		
		
		
	}
	
}

function confirmarTurma(id){
	
	let resposta = confirm("Confirma a exclusao dessa turma?")
	
	if(resposta === true){

		window.location.href="deleteTurma?id="+id
	}else{
		
		
		
	}
	
}