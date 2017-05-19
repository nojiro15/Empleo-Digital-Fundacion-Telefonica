
function oscurecer(){
	document.getElementById('velo').style.background = "rgba(0,0,0,0.7)";
	
}
function aclarar(){
	document.getElementById('velo').style.background = "rgba(0,0,0,0)";
	
}
var entrantes = new Array();
	entrantes[0] = "img/entremeses4.jpg";
	entrantes[1] = "img/entremeses5.jpg";
	entrantes[2] = "img/durian-pancake.jpg";

var primero = new Array();
	primero[0] = "img/noodles.jpg";
	primero[1] = "img/primerPlato2.jpg";
	primero[2] = "img/arroz.jpg";

var segundos = new Array();
	segundos[0] = "img/fish.jpg";
	segundos[1] = "img/hamburger.jpg";
	segundos[2] = "img/platoVerduras.jpg";

var postres = new Array();
	postres[0] = "img/cake.jpg";
	postres[1] = "img/eszterhazyschnitte.jpg";
	postres[2] = "img/chocolate-cupcake.jpg";

var indice = 0;

function cargaImagenEntrantes(){
	document.entrantes.src = entrantes[indice];

}
function siguienteEntrante(){
	indice +=1;
	if(indice > entrantes.length-1){
		indice = 0;}
		cargaImagenEntrantes();
}
function cargaImagenPrim(){
	document.primero.src = primero[indice];

}
function siguientePrim(){
	indice +=1;
	if(indice > primero.length-1){
		indice = 0;}
		cargaImagenPrim();
}
function cargaImagenSegun(){
	document.segundos.src = segundos[indice];

}
function siguienteSegun(){
	indice +=1;
	if(indice > segundos.length-1){
		indice = 0;}
		cargaImagenSegun();
}
function cargaImagenPostres(){
	document.postres.src = postres[indice];

}
function siguientePostres(){
	indice +=1;
	if(indice > postres.length-1){
		indice = 0;}
		cargaImagenPostres();
}
