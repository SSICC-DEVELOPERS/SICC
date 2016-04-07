/**
* Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
var FORMULARIO = 'formulario';
//Modificado por incidencia BELC300013227
function onLoadPag(){
    configurarMenuSecundario(FORMULARIO);
    
    DrdEnsanchaConMargenDcho('listado1',12);
    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    document.all["separaDiv"].style.visibility='';
    document.all["primera1Div"].style.visibility='';
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';
    
    eval (ON_RSZ);  
    
    
    if (get(FORMULARIO+'.errDescripcion')!='') {		
                  var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
         }
         
   var oidCliente=get(FORMULARIO+'.oidCliente');
  
  //alert('Antes del configurarpaginado   oidCliente= '+ get(FORMULARIO+'.lbldtCodConsultora'));
   var idioma = get(FORMULARIO+'.idioma');
   var pais   = get(FORMULARIO+'.pais');
/*hecho en la lp
DOTOID dto = new DTOOID();
	dto.setOidPais(this.pais);
    dto.setOidCliente(this.oidCliente);
	dto.setOidIdioma(this.idioma);
	paramEntrada.add(dto);
 	paramEntrada.add(new MareBusinessID("CALConsultarConsultorasHijas"));
	conector = conectar("ConectorConsultarConsultorasHijas", paramEntrada);
	asignar("LISTAEDITABLE", "listado1", conector, "dtoSalida.resultado_ROWSET");*/
 
              
 //configurarPaginado(mipgndo, "CALConsultarConsultorasHijas", "ConectorConsultarConsultorasHijas", "es.indra.sicc.dtos.cal.DTODatosClien", [["oidIdioma", idioma],["oidPais", pais],["oidCliente", oidCliente]] );        
//alert("Despues del configurarPaginado.oidCliente "+ oidCliente);
  
        

}	


function muestraLista( ultima, rowset){
         
       /*  var tamano = rowset.length;
         if (tamano > 0) {
                  visibleLista();
                  

                  return true;
         } else {
                  invisibleLista();		
                  
                  return false;
         }*/
}

function visibleLista() {
         
         if (!get_visibilidad("capaLista")){
                  visibilidad('capaLista','V');
                  DrdEnsanchaConMargenDcho('listado1',12);
                  eval (ON_RSZ);  
         }
}

 function fVolver(){
 	window.returnValue=get(FORMULARIO+'.oidContacto');
 	window.close();            
 }

 

  function unLoadPag(){
	window.returnValue=get(FORMULARIO+'.oidContacto');
 }

 



function invisibleLista() {
         
         if (get_visibilidad("capaLista")){
                  visibilidad('capaLista','O');
         }
}

 