function GerarMatricula(){
	
	var txt = "ACA";
	var aleatorio = Math.floor(Math.random() * 1500000);
	
	document.getElementById('matricula').value = (txt + aleatorio);
	
}