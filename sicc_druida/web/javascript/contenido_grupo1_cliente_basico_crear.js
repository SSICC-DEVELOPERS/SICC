 var primeraVez = true;
 var codigoCliente = '';
 var codigoClienteOld = '';
 
 var datosListaLimpiar;


function onLoadPag(){   
  configurarMenuSecundario("frmInsertarCliente");
         DrdEnsanchaConMargenDcho('listado1',12);
  eval (ON_RSZ);

      if(!fMostrarMensajeError()){
                           // TOIDO: hard 
                           //set("frmInsertarCliente.hidCodigoAutomatico","false");
                           cargaComboPersonaEmpresa();

      if(get('frmInsertarCliente.codigoCliente') != ''){
          txt_to('lblCodClienteActual', get('frmInsertarCliente.codigoCliente'));         
         
      }

                           var casoUso = get('frmInsertarCliente.casoDeUso');
                    
                           //alert('caso de uso: ' + get('frmInsertarCliente.casoDeUso'));
                           //if(get('frmInsertarCliente.casoDeUso')=="ModificarCliente"||get('frmInsertarCliente.casoDeUso')=="Insertar Cliente"){
                  
                  
                                    // Recargamos los valores anteriores si los habia
                                    if(get('frmInsertarCliente.hidListaIdentificacion')!=""){
                                             // hay que recargar datos
                                             recargarValor();
                                    }

                  
         
    //seteaTitulosPestanya();

                  //pongo el foco donde corresponde
              // document.getElementById("comboTipoDocId_0").setActive();
        foco();


         }	// end if si no hay error
   datosListaLimpiar = listado1.datos;
    datosListaLimpiar = duplicaArray(datosListaLimpiar);
	if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
			btnProxy(2,1);  // boton 'volver', habilitado
			btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
	}
}        //end onLoad
         
//----------------------------------------------------------------------------------------------------------------------
function cargaComboPersonaEmpresa()  {
         var lacolumna=4;// columna donde esta el combo
         var elcontenido=[ ['-1',''],['P',GestionarMensaje('1505',null,null,null)] , ['E',GestionarMensaje('1506',null,null,null)] ];
         listado1.tiposCol[lacolumna][2]=elcontenido;
         listado1.repinta();
}

//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
function actualizaCodigoCliente(newCod){
      //alert(newCod);
          var codigoClienteAutomatico = get("frmInsertarCliente.codigoAutomatico");
          var hidcodigoClienteAutomatico = get('frmInsertarCliente.hidCodigoAutomatico');
          if((codigoClienteAutomatico == "false") || (hidcodigoClienteAutomatico == "false")){
                  //  var labCodClie = document.getElementById("lblCodClienteActual");
                                                      set("frmInsertarCliente.codCliente", newCod);
                                                      set("frmInsertarCliente.hOidCliente", newCod);
             txt_to('lblCodClienteActual',newCod);        
          }
}

//----------------------------------------------------------------------------------------------------------------------

function clienteContactadoOnBlur (fila) {

         var longiCod = get("frmInsertarCliente.hidlongCliente");
         var elTexto  = listado1.datos[fila][2]
         if(elTexto.length!=0){
         //	alert(elTexto+ " debe tener " + longiCod + " caracteres de largo") ;
                  var faltantes = longiCod -  elTexto.length;
                  var resultCod=new String("");
                  if(faltantes > 0){
                           for(var t = 0 ; t<faltantes; t++){
                                    resultCod = resultCod + "0";
                           }
                  }
                  resultCod = resultCod + elTexto;
    return resultCod;
    
         }
}


function flagRadio(fila){

  listado1.actualizaDat();
  
  var tex = clienteContactadoOnBlur(fila);//("TextoNDoc_" + fila);
  var radio = document.getElementById('RbDocPrincipal_' + fila)
 
  if (tex == ''){
     radio.checked = false;
  }
  
  if(radio.checked){
         
     if(primeraVez){
         primeraVez = false;
     }
      
     codigoClienteOld = codigoCliente;
     codigoCliente = tex;  
     
     actualizaCodigoCliente(codigoCliente);
     
  }else{
   
     if(listado1.datos.length > 1){
        actualizaCodigoCliente(codigoClienteOld);
     }else{
        actualizaCodigoCliente('');
     } 
  }
  
  //alert('el parametro a pasar es ' + tex);
         
}
//----------------------------------------------------------------------------------------------------------------------
function aniadirFila(){
         var linea = new Array(); 
         linea.length = 6;
         //linea[0] = listado1.generaCodigo('');
         linea[0] = "g";
         linea[1] = '';
         linea[2] = '';
         linea[3] = '';
         linea[4] = 'N';
         linea[5] = '';
         listado1.insertar(linea);
         var ind = listado1.datos.length -1;
         document.getElementById("comboTipoDocId_"+ind).setActive();
}
//----------------------------------------------------------------------------------------------------------------------
  function fBorrar(){

                  var casoUso = get("frmInsertarCliente.casoDeUso");

     if(!listado1.numSelecc() == 0){    
         listado1.eliminarSelecc();
      
                      if(listado1.datos.length==0){  	//es obligatorio al menos una identificacion
            txt_to('lblCodClienteActual','');    
                                aniadirFila();
         }
     }else{
          GestionarMensaje('50');
     }
  }
  //----------------------------------------------------------------------------------------------------------------------
  function fVolver(){
                  // lo deje en una func aparte por las dudas que necesitemos algo mas en el futuro
                  
                           volver();
                  
  }
//----------------------------------------------------------------------------------------------------------------------
function validacion(){
         var chequeado  = false;
         var desiguales = false;
  var cont = 0;

         for(var x=0;x<listado1.datos.length;x++){
                  var combo_1="comboTipoDocId_" + x;
                  var combo_2="comboPersonaEmpresa_" + x;
                  var ctexto_1="TextoNDoc_"+x;
                  var ctexto_2="TextoConfirmacionDoc_" + x;
                  var radio="RbDocPrincipal_"+x;
                  var combo1 = document.getElementById(combo_1);
                  var combo2 = document.getElementById(combo_2);
                  var ctexto1 = document.getElementById(ctexto_1);
                  var ctexto2 = document.getElementById(ctexto_2);
                  var radio = document.getElementById(radio);

                  //if(combo1.value=="-1"){
                  if(combo1.value==""){ //inc. 15380
                           GestionarMensaje('2527');
                           //alert("Debe ingresar tipo de docu");
                           combo1.setActive();
                           return;
                  }

                  if(ctexto1.value==""){
                           GestionarMensaje('2528');
                           //alert("Debe ingresar numero de doc");
                           ctexto1.setActive();
                           return;
                  }

                  if(ctexto2.value==""){
                           GestionarMensaje('2529');
                           //alert("Debe ingresar confirm numero de doc");
                           ctexto2.setActive();
                           return;
                  }

                  if(ctexto1.value != ctexto2.value){
                           GestionarMensaje('1060');
                           ctexto2.setActive();
                           return;
                  }

                  if(radio.checked==true){
                           // esto indica que3 hay por lo menos una prinicpal
                           chequeado = true;
      cont = cont + 1;
                  }
                  
                  if(combo2.value=="-1"){
                           GestionarMensaje('2530');
                           //alert("Debe ingresar Persona Empresa");
                           combo2.setActive();
                           return;
                  }


         }
         if(!chequeado){
                  GestionarMensaje('1061');
                  return;
         }

  if (cont > 1 ){
     GestionarMensaje('1126');
     return;     
  }

         return true;
}


//----------------------------------------------------------------------------------------------------------------------
function accionP2(){
	// parte matias.

	if(get('frmInsertarCliente.casoDeUso')==""){
		if(get('frmInsertarCliente.back')=="volver"){
			if(validacion()){

				recolectarValor();
				set('frmInsertarCliente.accion','BackPestania2'); 
				set('frmInsertarCliente.conectorAction','LPInsertarClienteBasico');
				set('frmInsertarCliente.envia','Pag1');
				set('frmInsertarCliente.hidFocusPrimerComponente', 'true');
				enviaSICC('frmInsertarCliente');

			}else{ 
				return;
			}
		}else{
			if(validacion()){	
				recolectarValor();
				set('frmInsertarCliente.accion','Validar');
				set('frmInsertarCliente.hidFocusPrimerComponente', 'true');

				if(get('frmInsertarCliente.hidCodigoAutomatico') == 'false' || get('frmInsertarCliente.codigoAutomatico') == 'false'){
					set('frmInsertarCliente.codigoCliente', codigoCliente);
				}
		
				//alert(get('frmInsertarCliente.codigoCliente'));
				/*eval('frmInsertarCliente').oculto="S"; 
				set('frmInsertarCliente.conectorAction','LPInsertarClienteBasico');
				enviaSICC('frmInsertarCliente');*/
			}else{
				return;
			}
		}
	}
	// parte  coco y seba

	if(validacion()){

		if(get('frmInsertarCliente.hidCodigoAutomatico') == 'false' || get('frmInsertarCliente.codigoAutomatico') == 'false'){

			set('frmInsertarCliente.codigoCliente', codigoCliente);
		}

		eval('frmInsertarCliente').oculto="S"; 
		set('frmInsertarCliente.accion','Validar');
		set('frmInsertarCliente.conectorAction','LPInsertarClienteBasico');

		/*alert("conectorAction: " + get('frmInsertarCliente.conectorAction'));*/

		enviaSICC('frmInsertarCliente');
	}
}

function mostrarerror(nroDoc){
//         GestionarMensaje('MAE0002BIS');

	 var	elmn = nroDoc.split("|");

			  if (nroDoc.length>1 && elmn[1]!=""){
					   GestionarMensaje('MAE0006',elmn[1]);
			  } else {
                     GestionarMensaje('MAE0002BIS');	

  				     //Aca va la llamada al modificar dtoOid / hidCodigoCliente

                     var obj = new Object();
  
                     obj.dtoOid = elmn[2];
					 obj.hidCodigoCliente = elmn[3];
					 obj.hPestanya = '';
					 obj.accion = '';
  
                     mostrarModalSICC('LPModificarCliente','',obj);

				    for( i = 0; i < document.forms['frmInsertarCliente'].all.tags('INPUT').length; i++){
					   if(document.forms['frmInsertarCliente'].all.tags('INPUT')[i].type != null &&
					      document.forms['frmInsertarCliente'].all.tags('INPUT')[i].type.toUpperCase() == 'HIDDEN'){
  					      document.forms['frmInsertarCliente'].all.tags('INPUT')[i].value = '';
					   }
				     }

					 eval('frmInsertarCliente').oculto="N";
					 set('frmInsertarCliente.conectorAction','LPInsertarClienteBasico');
					 set('frmInsertarCliente.accion','');
					 enviaSICC('frmInsertarCliente');
			  }
			  return true;   
}

function accionExitosa(){
         eval('frmInsertarCliente').oculto="N";
         set('frmInsertarCliente.accion','siguiente1_validar');
         enviaSICC('frmInsertarCliente');
         
}
//----------------------------------------------------------------------------------------------------------------------
function recolectarValor(){
         set('frmInsertarCliente.hidListaIdentificacion',"");
         for(var x=0;x<listado1.datos.length;x++){
                  var val=get('frmInsertarCliente.hidListaIdentificacion');
                  var combo1=document.getElementById("comboTipoDocId_"+x);
                  val=val + "h_"+combo1.name + "=" + combo1.value +";" ;
                  var text1=document.getElementById("TextoNDoc_"+x);
                  val=val + "h_"+text1.name + "=" + text1.value +";" ;
                  var text2=document.getElementById("TextoConfirmacionDoc_"+x);
                  val=val + "h_"+text2.name + "=" + text2.value +";" ;
                  var radio=document.getElementById("RbDocPrincipal_"+x);
                  val=val + "h_"+radio.name + "=" + radio.checked +";" ;
                  var combo2=document.getElementById("comboPersonaEmpresa_"+x);
                  val=val + "h_"+combo2.name + "=" + combo2.value +";" ;
                  set('frmInsertarCliente.hidListaIdentificacion',val);
         }
}
 //-------------------------------------------------------------------------------------------------------------------------------------------------------
function recargarValor(){
         listado1.eliminar(0,1);
         var val=get('frmInsertarCliente.hidListaIdentificacion');
         //alert(val);
         var elems = val.split(";");
//      alert(elems.length);
         var cant = Math.round((elems.length-1) / 5 );

         var listaIdent = new Array(cant);
         for(var t=0;t<cant;t++){
                  listaIdent[t] = new Array(6);
                  listaIdent[t][0] = t+1;
         }
         //h_comboTipoDocId_0=11;h_TextoNDoc_0=2121;h_TextoConfirmacionDoc_0=2121;h_RbDocPrincipal_0=false;h_comboPersonaEmpresa_0=E
         for(var x=0;x<elems.length;x++){
                  var line = elems[x].split("=");
                  //line[0] = h_comboTipo_0
                  //line[1] = 1 - codigo o valor
                  var elem = line[0].split("_");
                  //elem[0] tiene h
                  //elem[1] tiene comboTipoCliente
                  //elem[2] el indice del combo
                  var ind = Math.abs(elem[2]);
                  if(elem[1]=="comboTipoDocId"){
                           listaIdent[ind][1]= line[1];
                  }
                  if(elem[1]=="TextoNDoc"){
                           listaIdent[ind][2]= line[1];		
                  }
                  if(elem[1]=="TextoConfirmacionDoc"){
                           listaIdent[ind][3]= line[1];		
                  }
                  if(elem[1]=="RbDocPrincipal"){
                           if(line[1]=="true"){
                                    listaIdent[ind][4]= "S";		
                           }else{
                                    listaIdent[ind][4]= "N";		
                           }
                  }
                  if(elem[1]=="comboPersonaEmpresa"){
                           listaIdent[ind][5]= line[1];
                  }
         }

         for(var g=0;g<cant;g++){
         //	alert(listaIdent[g]);
                  //alert("listaIdent[" + g +"]: " + listaIdent[g] );
                  listado1.insertar(listaIdent[g]);

         }
      listado1.repinta();
}
//----------------------------------------------------------------------------------------------------------------------
function volver(){
         
         recolectarValor();
         set('frmInsertarCliente.accion','');
  
         if(get('frmInsertarCliente.casoDeUso')==""){
                  set('frmInsertarCliente.conectorAction','LPInsertarClienteBasico');
         }

  if(get('frmInsertarCliente.hidCodigoAutomatico') == 'false' || get('frmInsertarCliente.codigoAutomatico') == 'false'){
      set('frmInsertarCliente.codigoCliente', codigoCliente);
  }
  
  set('frmInsertarCliente.hidFocusPrimerComponente', 'false');
         set('frmInsertarCliente.atrasTipoSubtipo', 'true');
         enviaSICC('frmInsertarCliente');  
}
//----------------------------------------------------------------------------------------------------------------------         
function foco(){
   var foco = get('frmInsertarCliente.hidFocusPrimerComponente');

   if(foco == 'false'){
      focalizaBotonHTML('botonContenido','Validar');
   }else{
      document.getElementById("comboTipoDocId_0").focus();
   }
}

         
//----------------------------------------------------------------------------------------------------------------------         
function fLimpiar(){
         listado1.setDatos(datosListaLimpiar);
         datosListaLimpiar = duplicaArray(datosListaLimpiar);
}

//----------------------------------------------------------------------------------------------------------------------         
function duplicaArray(param){
         var valorToReturn = new Array();
         if ( param != "")	{
                  var cantFilas = param.length;
                  var cantCols = param[0].length;

                  for (var i = 0; i < cantFilas; i++){
                           var nuevaFila = new Array();
                           for (var j = 0; j < cantCols; j++){	
                                    var dato = param[i][j];
                                    nuevaFila[j] = dato;
                           }
                           valorToReturn[i] = nuevaFila;
                  }
         }
         return valorToReturn;

}

// ----------------------------------------------------------------------------------------------------------------------
function shiftTabLista(FILAEVENTO)
{
         if (FILAEVENTO == 0) 
                           volver();		
}




