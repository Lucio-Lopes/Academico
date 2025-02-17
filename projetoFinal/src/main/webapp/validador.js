function validarProf(){
	
	let nome = formProf.nome.value
	let fone = formProf.telefone.value
	let email = formProf.email.value
	if(nome === "" ){
		alert("preencha o campo Nome")
		formProf.nome.focus()
		return false
	} else if(fone === ""){
		
		alert("preencha o campo telefone")
				formProf.fone.focus()
				return false
		
	} else if(email === ""){
		
		alert("preencha o campo email")
				formProf.email.focus()
				return false
	} else{
		
		document.forms["formProf"].submit()
		
	}
}

function validarTurma(){
	
	let sala = formTurma.sala.value
	let quant = formTurma.quant.value
	
	if(sala === "" ){
			alert("preencha o campo sala")
			formProf.sala.focus()
			return false
		} else if(quant === ""){
			
			alert("preencha o campo quantidade alunos")
					formProf.quant.focus()
					return false
			
		} else{
			
			document.forms["formTurma"].submit()
			
		}
}

function validarDisc(){
	
	let nome = formDisc.nome.value
	let semestre = formDisc.semestre.value
	let hora = formDisc.hora.value
	
	if(nome === "" ){
			alert("preencha o campo nome")
			formDisc.nome.focus()
			return false
		} else if(semestre === ""){
			
			alert("preencha o campo semestre")
					formDisc.semestre.focus()
					return false
			
		} else if(hora === ""){
			
			alert("preencha o campo carga horária")
					formDisc.hora.focus()
					return false
		} else{
			
			document.forms["formDisc"].submit()
			
		}
}