/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/ 

/*
    INDRA/CAR/PROY
    $Id: contenido_historico_cursos_generar.js,v 1.1 2009/12/03 19:02:10 pecbazalar Exp $
    DESC
*/
var FORMULARIO = "formulario";
function onLoadPag()   
    {           
      DrdEnsanchaConMargenDcho('listado1',12); 
      configurarMenuSecundario(FORMULARIO);
      document.all["Cplistado1"].style.visibility=''; 
      document.all["CpLin1listado1"].style.visibility='';  
      document.all["CpLin2listado1"].style.visibility=''; 
      document.all["CpLin3listado1"].style.visibility='';
      document.all["CpLin4listado1"].style.visibility='';  
      document.all["primera1Div"].style.visibility=''; 
      document.all["ret1Div"].style.visibility='';
      document.all["ava1Div"].style.visibility='';  
      document.all["separaDiv"].style.visibility=''; 
      document.all["GenerarHistoricoDiv"].style.visibility='';     
      eval (ON_RSZ);
      var errDescripcion = get(FORMULARIO +'.errDescripcion');
           if (errDescripcion !='') {             
                    var errCodigo = get(FORMULARIO+'.errCodigo');
                    var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
           } 
      focaliza(FORMULARIO+'.cbMarca');  
   }
function muestraLista( ultima, rowset){
		
          var tamano = rowset.length;
          if (tamano > 0) {
                    visibleLista();
                    return true;
          } else {
                    invisibleLista();              
                    return false;
          }
}
/*function combinar() {
	alert('combinar');
           if (!get_visibilidad("capaLista")){
                    visibilidad('capaLista','V');
           }else{
                    visibilidad('capaLista','O');
           }
} */ 
function visibleLista(){
	
          if (!get_visibilidad('capaLista')){
                    visibilidad('capaLista','V');
          }
}

function invisibleLista() {
	
          if (get_visibilidad('capaLista')){
                    visibilidad('capaLista','O');
          }
}     
function desplazar(){
       
         if(get_visibilidad("capaLista")){
                  
                  document.all['GenerarHistorico'].focus();
         }else{
                  focaliza(FORMULARIO+'.cbMarca','');
         }
}
function desplazarSift(){
        
         if(get_visibilidad("capaLista")){
                  
                  document.all['GenerarHistorico'].focus();
         }else{
                  document.all['btnBuscar'].focus();
                 // focaliza(FORMULARIO+'.btnBuscar','');
         }
         
}
function desplazarONStab(){
		document.all['btnBuscar'].focus();
}
function onSeleccionaMarca (){
		
	var marca = get(FORMULARIO+'.cbMarca');
	var idioma = get(FORMULARIO+'.idioma');
	var pais = get(FORMULARIO+'.pais');
	
	var DTODruida ='es.indra.sicc.dtos.edu.DTODruidaBusqueda';
	if(marca != 0){
		recargaCombo(FORMULARIO+'.cbTipoCurso','CMNObtieneTiposCurso',DTODruida, [ ['oidMarca', marca],['oidIdioma',idioma],['oidPais',pais] ]); 
		focaliza(FORMULARIO+'.cbTipoCurso');
	} else{
		set_combo(FORMULARIO+'.cbTipoCurso',[['','']],['']);
		focaliza(FORMULARIO+'.cbMarca'); 
	}
	
}
function onClickBuscar(){
         
         var canal = get(FORMULARIO+'.cbCanal');
         var marca = get(FORMULARIO+'.cbMarca');
         var textCodCurso = get(FORMULARIO+'.txtCodCurso');
         var textNomCurso = get(FORMULARIO+'.txtNombreCurso');
         var tipoCurso = get(FORMULARIO+'.cbTipoCurso');
         //var indOrigen = get(FORMULARIO+'.indOrigen');	
         var pais = get(FORMULARIO+'.pais');
         var idioma = get(FORMULARIO+'.idioma');
         
         var fecCurso= get(FORMULARIO+'.txtFechaCurso');
         if(fecCurso!=""){
         	comprobarFecha();
         }
        /*function EsFechaValida_SICC(fecCurso, formName)   
	que se encuentra en sicc_util.js.  
	Antes de llamar a esta función, 
	en la LP hay que llamar al método generarHiddenFormatoFecha() que está en LPSICCBase. 
	Este método genera un campo hidden con el formato de fecha, que es utilizado por la función  javascript.
	*/	
       configurarPaginado(mipgndo,"EDUBusquedaPasoHistorico","ConectorConsultaPasoHistorico","es.indra.sicc.dtos.edu.DTOConsultaPasoHistorico",[["oidPais", pais],["oidIdioma", idioma],["marca", marca],["canal", canal],["tipoCurso", tipoCurso],["codigo", textCodCurso],["nombre", textNomCurso],["fecCurso", fecCurso]]);
}//funcion
function validarCodCurso(){
    var num = get(FORMULARIO+'.txtCodCurso'); 
	if(num != ""){
		var val = allTrim(num);             
    	//Como no nos interesa validar el número de dígitos que tiene el 
    	//entero ponemos uno suficientemente grande. 
		if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) {
			GestionarMensaje('747', null, null, null);
			focaliza(FORMULARIO+'.txtCodCurso');
			return false;
		}
	}
}
function allTrim(sStr){ 
         return rTrim(lTrim(sStr)); 
}
function lTrim(sStr){ 
         while (sStr.charAt(0) == " "){
                  sStr = sStr.substr(1, sStr.length - 1); 
         }
         return sStr; 
} 
function rTrim(sStr){ 
         while (sStr.charAt(sStr.length - 1) == " ") {
                  sStr = sStr.substr(0, sStr.length - 1); 
         }
         return sStr; 
}                            

function comprobarFecha(){ 
	 var fecha= get(FORMULARIO+'.txtFechaCurso');
	 if(fecha != ""){
	 		var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
	 		if(resul==1 || resul==2){  
         		GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais')); 
				focaliza(FORMULARIO+'.txtFechaCurso');
         	}
     }
}

function onClickPasoHistorico() {
	 
	/*Al pulsar sobre btnGenerar, si hay un elemento seleccionado en la lista lstCursos, 
	se llama a LPHistoricoCursos a través de un EnviarOculto con accion="Historico"*/
          if (listado1.numSelecc() == 0) {
                    // Muestra el mensaje: "Debe seleccionar un elemento de la lista"
                    GestionarMensaje('50');
          } else {
                    if (listado1.numSelecc() != 1 ) {
                              //Muesta el mensaje: "Debe seleccionar un solo registro"
                              GestionarMensaje('8');
                                                //Se limpia la lista editable
                  		var seleccion=listado1.codigos();
                  		var i=0;
                  		while(seleccion[i]!=null){
                  			listado1.deselecciona(i); 
                  			i++;           
                  		}

                   } else {
                           //var objParams = new Object();
                           //objParams.oidSeleccionado = listado1.codSeleccionados();
                           var oidSeleccionado=listado1.codSeleccionados();
                            set(FORMULARIO+'.oidSeleccionado', oidSeleccionado);
                           
                           //alert('oidselecionado= 'get(FORMULARIO+'.oidSeleccionado'));
                           
                           set(FORMULARIO+'.conectorAction',"LPHistoricoCursos"); //le pasamos a la Lp que debe de llamar
         		   set(FORMULARIO+'.accion',"Historico");//le pasamos la accion que ve a ejecutar
         		   
         		   //alert(objParams.oidSeleccionado);
         		   enviaSICC(FORMULARIO); //Enviamos el formulario completo
         		   
         		}
         	}
        }//funcion                      
								