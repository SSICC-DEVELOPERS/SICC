var formulario = "Formulario";
 function onLoad(){
      configurarMenuSecundario('Formulario');
      fMostrarMensajeError();
      setTimeout('focaliza(\''+  formulario  + '.txtCodConsultora\')',200);    
	
	 // Si es modal (se abrió mediante showModalDialog) DBLG500000915
	  if (window.dialogArguments) { 
		 btnProxy(2,1);  // boton 'volver', habilitado
		 btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
	 }
            
   }
//------------------------------------------------------------------------------   
	 function fVolver(){     
			 window.close();
	 }

//------------------------------------------------------------------------------      
   function generarInforme(){
      if(sicc_validaciones_generales()){


                           var objParamsInt = new Object();
                           var listaModif = new Object();
                           objParamsInt.opener = window;
                           objParamsInt.destino ='CCCConsultaCC';
                           objParamsInt.conectorAction= 'CCCConsultaCC';
                           listaModif.accion = 'generarConsulta'; 
                           listaModif.codigoConsultora = get('Formulario.txtCodConsultora');
                           listaModif.numeroCargo = get('Formulario.txtNumCargo');
                           listaModif.camposBusqueda = get('Formulario.cbCamposBusqueda');
                           objParamsInt.parametros = listaModif;
                           setValues(objParamsInt);
                           
      }

   }

//------------------------------------------------------------------------------  
  function buscarCliente(){ 
      //var obj = new Object();

      var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',new Object());
    
      if(whnd!=null){
           set('Formulario.txtCodConsultora', whnd[1])
      }           
   }

//------------------------------------------------------------------------------          

  function clienteOnBlur() {

          
          var elTexto  = get('Formulario.txtCodConsultora');
                   var resultCod = new String("");
          if(elTexto.length!=0){
                           var longiCod = get('Formulario.hLongCliente');
             var faltantes = longiCod -  elTexto.length;
             if(faltantes > 0){
                  for(var t = 0 ; t<faltantes; t++){
                      resultCod = resultCod + "0";
                  }
           }
          
           set('Formulario.txtCodConsultora', resultCod + elTexto);
          }
                
   }

//------------------------------------------------------------------------------

   function recolectarParametros(){
            
      set('Formulario.codigoConsultora', get('Formulario.txtCodConsultora'));
      set('Formulario.numeroCargo', get('Formulario.txtNumCargo'));
      set('Formulario.camposBusqueda', get('Formulario.cbCamposBusqueda'));
                
   }

   
//------------------------------------------------------------------------------  


   function fLimpiar(){
     focaliza('Formulario.txtCodConsultora');
   }

function setValues(objParams){
         if(objParams.parametros){

                  var atributos;
                  eliminaElementosDinamicos();
                  for(atributos in objParams.parametros){
                           if(atributos != "window"){
                                    var hidden = document.createElement("INPUT");
                                    hidden.type = "hidden";
                                    hidden.insertado = "1";
                                    hidden.name = atributos;
                                    hidden.value = (objParams.parametros[atributos]==null)?"":objParams.parametros[atributos];
                                    document.forms["frmContenidoEnvia"].appendChild(hidden);
                           }
                  }
         set('frmContenidoEnvia.conectorAction', objParams.conectorAction);
         enviaSICC("frmContenidoEnvia");
         }

}
function eliminaElementosDinamicos(){
         var elementos = document.forms["frmContenidoEnvia"].elements;
         var longitud = elementos.length;
         for ( i = 0;i < longitud; i++ ){
                  var oChild=document.forms["frmContenidoEnvia"].children(i);	
                  if (oChild!= null && oChild.insertado=="1"){
                           document.forms["frmContenidoEnvia"].removeChild(oChild);
                           i = i-1;
                  }
         }
}
                  

