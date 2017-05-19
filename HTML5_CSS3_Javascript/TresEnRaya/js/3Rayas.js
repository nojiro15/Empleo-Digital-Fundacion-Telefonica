 
 //Creo un array con las imágenes que voy a usar en el tablero.
 var arrImg = new Array(3);
 arrImg[0] = "img/cardBack.jpg" ;
 arrImg[1] ="img/circuloRojo.png";
 arrImg[2] = "img/cruz.jpg";


 var arrJuego = new Array(9);
 var jugada = 0;
 var ganador = false;	
 //inicializo mi array a 0 para comenzar el juego.
	function limpiar(){
		
		alert("¡Comienza el juego!");	
	    
	    for (var i = 0; i <= 9; i++) {
	     	arrJuego[i]=0;
	     	var inicio = document.getElementById("celda"+i);
	     	inicio.src = arrImg[0];
	     	jugada = 0;
	     	ganador = false;
	     } 	

	}
 //Esta misma función me servirá para comenzar el juego de nuevo.
 

 function tirada(pos){
 	if(ganador == false){
 		if (jugada < 9){
 			if (arrJuego[pos]== 0){
 				if(jugada%2 ==0){ //Así comprobamos que el número es par.
 					var jugador1 = document.getElementById("celda"+pos);
 					jugador1.src = arrImg[1];
 					arrJuego[pos]=1;
 					jugada++;
 				}else{//Es impar el número.
 					var jugador2 = document.getElementById("celda"+pos);
 					jugador2.src = arrImg[2];
 					arrJuego[pos]=2;
 					jugada++;

 				}
 				comprobarColumnas();
 				comprobarFilas();
 				comprobarDiagonal1();
 				comprobarDiagonal2();
 			}else{alert("¡Tu rival se te ha adelantado!")}

 		
 		}else {alert("El juego ha terminado.¡Empate!")}
 	}else{alert("El juego ha terminado")}
 	
 }
 function comprobarColumnas(){

 	for(i=0 ; i<2 ; i++){
 		if(arrJuego[i]!= 0){
	 		if (arrJuego[i]== arrJuego[i+3]&& arrJuego[i]==arrJuego[i+6]) {
	 			ganador = true;
	 			alert("¡Has ganado!");
	 		}	
 		}
 		
 	}
 }
function comprobarFilas(){
	for(i=0 ; i<6 ; i++){
		if(arrJuego[i]!= 0){
	 		if (arrJuego[i]== arrJuego[i+1]&& arrJuego[i]==arrJuego[i+2]) {
	 			ganador = true;
	 			alert("¡Has ganado!");
	 		}
	 	}
 	}
}
function comprobarDiagonal1(){
	
		if(arrJuego[0]!= 0){
	 		if (arrJuego[0]== arrJuego[4]&& arrJuego[0]==arrJuego[8]) {
	 			ganador = true;
	 			alert("¡Has ganado!");
	 		}
 		}
 	
}
function comprobarDiagonal2(){

	
		if(arrJuego[2]!= 0){
	 		if (arrJuego[2]== arrJuego[4]&& arrJuego[2]==arrJuego[6]) {
	 			ganador = true;
	 			alert("¡Has ganado!");
	 		}
	 	}
 	
}