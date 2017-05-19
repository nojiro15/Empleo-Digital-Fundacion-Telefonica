//Javascript Document
//cuando ha cargado el documento, arranca la función X


$(document).ready(function()){
	$("body").delay(5000).fadeIn("slow",function(){ventana_modal()});
	//$(elemento body de HTML).retraso(5 milisegundos).animación(duración lenta,función determinada)
	//fadeIn = transición de entrada por eso se pone el tiempo y lo que hará tras ese tiempo.
});

//funcion iniciar(){
	//$(".vmodal").delay(5000).fadeIn(2000,ventana_modal);
//}

function ventana_modal(){
	//$(".vmodal").append("<style='margin-left:75px'>" + $(this).text() + "</p>");
	/*$("elemento es una clase css").añadir("estilo CSS='margem izq= 75px'>"
	+ $(este elemento))
	*/
	$(".vmodal").append("<div class='boton'><a href='#'>Cierra</a></div>");
	
	$(".boton").click(function(){$(".vmodal, .velo").fadeOut(2000)});
}	