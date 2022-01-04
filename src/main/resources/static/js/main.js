function MostrarBarraProgresso(el) {
//    document.getElementById(el).style.display = 'flex';

  var display = document.getElementById(el).style.display;
  if (display == "none"){
    document.getElementById(el).style.display = 'flex';
  }else{
    document.getElementById(el).style.display = 'none';
  }
}


function GerarMatricula() {

	var txt = "ACA";
	var aleatorio = Math.floor(Math.random() * 1500000);

	document.getElementById('matricula').value = (txt + aleatorio);

}

function MostrarBotaoAlterarSenha(){
	if(document.getElementById("codigoSenha").readOnly == true){
		document.getElementById("codigoSenha").readOnly = false;
		document.getElementById('btnAlterarSenha').style.display = 'none';
	}
}

