function GerarMatricula() {

	var txt = "ACA";
	var aleatorio = Math.floor(Math.random() * 1500000);

	document.getElementById('matricula').value = (txt + aleatorio);

}

function SubstituirMatricula() {

	if (document.getElementById('matricula').value != "") {
		if (window.confirm("A matrícula já está preeenchida. Deseja substituir?")) {
			GerarMatricula();
		}
	}
	else {
		GerarMatricula();
	}
}


function AlterarSenha(){
	if(document.getElementById("codigoSenha").readOnly == true){
		document.getElementById("codigoSenha").readOnly = false;
		document.getElementById('btnAlterarSenha').style.display = 'none';
	}
}



setTimeout(function() {
	document.getElementById('msgSucesso').style.display = 'none';
}, 9000);

