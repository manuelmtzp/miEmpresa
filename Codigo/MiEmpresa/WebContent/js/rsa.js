$(function(){
	var helpme = function(){
		$("#help").slideToggle();
	};
	$("#boton_help").on('click',helpme);
});

function disableEnter(event) {
	if (event.keyCode == '13') { return false; }
}

function changeFocus(input, num) {
	if (num === '0') {
		if (input.value.length == 4) {
			var id = "";
			id=input.id;
			setFocus(id, '1');
		}
	} else if (num === '1') {
		if (input.value.length == 6) {
			setFocus(input.id, '2');
		}
	}
}

function spinChangeFocus(input, field) {
	var valor = input.value;
	$("#cesionComisionActual").val(valor);
	
	if(valor > 100){
		input.value= 100.0;
	}
}
	
function setFocus(id, num) {
	id = id.substring(0, id.length-1) + num;
	var obj = document.getElementById(id);
	obj.focus();
}

function redirectLogin(ctx) {
	window.location = "http://"+window.location.host+ctx;
}

function validaComision(actionBtn) {
	var showAgentes =($("#cesionComisionActual").val() != 0
		&& ($("#cesionComisionActual").val() != $("#cesionComisionAnterior").val()));
	if (showAgentes === true) {
		dialogAgentes.show();
	} else if (actionBtn === "IMPRIMIR_COTIZACION"){
		imprimirCotizacion();
	} else if (actionBtn === "GUARDAR_COTIZACION"){
		validaSerieImpresion();
		updateComisionAnterior();
	} else if (actionBtn === "SIGUIENTE"){
		siguiente();
	} else if (actionBtn === "ACTUALIZAR_COTIZACION"){
		updateComisionAnterior();
		actualizarCotizacion();
	} else if (actionBtn === "VER_DETALLE"){
		verDetalleSilver();
		updateComisionAnterior();
	}
}

function updateComisionAnterior() {
	$("#cesionComisionAnterior").val($("#cesionComisionActual").val());
}


function checkboxIsSelected() {  
	  	$('input[type=checkbox]').each( function() {	
			if($("input[type=checkbox]:checked").length == 1){
				if(confirm("¿Estás seguro de eliminar la(s) cotización(es)?")){
					alert("si");
					
					var a = $("#hiddenFlagBorrarCotizacion").val("true");
					alert($("#hiddenFlagBorrarCotizacion").val());
				}
				else{
					alert("no");
					var a = $("#hiddenFlagBorrarCotizacion").val("false");
					alert($("#hiddenFlagBorrarCotizacion").val());
				}
			} 
			else {  
	            alert("No está activado");  
	        }  
		});

}