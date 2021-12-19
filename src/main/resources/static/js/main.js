function GerarMatricula(){
	
	var txt = "ACA";
	var aleatorio = Math.floor(Math.random() * 1500000);
	
	document.getElementById('matricula').value = (txt + aleatorio);
	
}

function SubstituirMatricula(){

if(document.getElementById('matricula').value != ""){
	if (window.confirm("Academy", "A matrícula já está preeenchida. Deseja substituir?")) {
  		GerarMatricula();
	}
}
else
{
	GerarMatricula();
}	
	
}