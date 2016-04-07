var primeraVez = true;
 var codigoCliente = '';
 var datosListaLimpiar;

 var DOC_DEFECTO;
 var EMPRESA = "E";
 var PERSONA = "P";
 var PER_DEFECTO = PERSONA;

 
// -----------------------------------------------------------------------------------------------------------------------------------

 //----------------------------------------------------------------------------------------------------------------------
function onLoadPag() {
		 DOC_DEFECTO = get('frmInsertarCliente.hOidDefTipoDoc');
         configurarMenuSecundario("frmInsertarCliente");
         DrdEnsanchaConMargenDcho('listado1',12);
         setTimeout('eval (ON_RSZ)',200);
	     if (!fMostrarMensajeError()) {
 		    var casoUso = get('frmInsertarCliente.casoDeUso');
			cargaComboPersonaEmpresa();

			if (get('frmInsertarCliente.codigoCliente') != ''){
				txt_to('lblCodClienteActual', get('frmInsertarCliente.codigoCliente'));	
			}

			if (casoUso == "ModificarCliente") {
				seteaComboPersonaEmpresa(); 
				actualizaChkIndActivo();
				if (listado1.datos == 0) { // Al modificar un cliente de lote (sin datos)
					aniadirFila();
				}
				
            } else {
				 // Recargamos los valores anteriores si los habia
				 if (get('frmInsertarCliente.hidListaIdentificacion')!="") {
					 // hay que recargar datos
					 recargarValor();
				 }else{
					setComboValorDefecto( 0, 1, DOC_DEFECTO );
					setComboValorDefecto( 0, 5, PER_DEFECTO );
					listado1.repintaDat();
				 }
				ocultarCbIndActivo();
             }
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
         var elcontenido=[ ['-1',''], [ EMPRESA ,GestionarMensaje('1506',null,null,null)], [ PERSONA ,GestionarMensaje('1505',null,null,null)] ];
         listado1.tiposCol[lacolumna][2]=elcontenido;
         listado1.repinta();
}


//----------------------------------------------------------------------------------------------------------------------
function actualizaCodigoCliente(newCod){
      //alert(newCod);
          var codigoClienteAutomatico = get("frmInsertarCliente.codigoAutomatico");
          var hidcodigoClienteAutomatico = get('frmInsertarCliente.hidCodigoAutomatico');
          if ((codigoClienteAutomatico == "false") || 
					(hidcodigoClienteAutomatico == "false")){
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
  //alert("el codigo es " + tex);
  var radio = document.getElementById('RbDocPrincipal_' + fila)
 
  if (tex == ''){
    radio.checked = false;
  }
  
  if(radio.checked){
    
     if (primeraVez){
          primeraVez = false;
     }
    
     codigoCliente = tex;  
    
     actualizaCodigoCliente(codigoCliente);
  }else{
   
     if(listado1.datos.length > 1){
   
        actualizaCodigoCliente(codigoCliente);
     }else{
   
        actualizaCodigoCliente('');
     } 
  }
}
//----------------------------------------------------------------------------------------------------------------------
function aniadirFila(){
         var linea = new Array(); 
         linea.length = 6;
         //linea[0] = listado1.generaCodigo('');
         linea[0] = "g";
         //linea[1] = '';
		 linea[1] = DOC_DEFECTO;
		 linea[2] = '';
         linea[3] = '';
         linea[4] = 'N';
         //linea[5] = '';
		 linea[5] = PER_DEFECTO;
         listado1.insertar(linea);
         var ind = listado1.datos.length -1;
         document.getElementById("comboTipoDocId_"+ind).setActive();
		 listado1.repintaDat();

}
//----------------------------------------------------------------------------------------------------------------------
  function fBorrar(){

                  var casoUso = get("frmInsertarCliente.casoDeUso");

     if(!listado1.numSelecc() == 0){    

                    if ( casoUso == "ModificarCliente"){
                                    var elemToDel = "";
                                    var codigos = listado1.codSeleccionados();

                                    for ( var i = 0; i<codigos.length; i++){
                                                      if (codigos[i] != "g"){
                                                                         if ( i != 0)
                                                                                  elemToDel = elemToDel + ",";

                                                                         elemToDel = elemToDel + codigos[i];
                                                      }
                                    }

                                    if (elemToDel != ""){
                                                      var buffer = get("frmInsertarCliente.elemToDelP2");
                                                      if (buffer != 0)
                                                                buffer = buffer + "," + elemToDel;
                                                      else
                                                                buffer = elemToDel;
         
                                                      set("frmInsertarCliente.elemToDelP2", buffer);
                                    }

                    }

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
                  if (get("frmInsertarCliente.casoDeUso") == "ModificarCliente"){
                                    window.close();
                  }else{
                           volver();
                  }
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
         //alert("Caso de uso: "+get('frmInsertarCliente.casoDeUso'));
         // parte matias.
         if(get('frmInsertarCliente.casoDeUso')==""){
                  if(get('frmInsertarCliente.back')=="volver"){
                           if(validacion()){
									//alert("1.-");
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
							//alert("2.-");
							eval('frmInsertarCliente').oculto="S";
							set('frmInsertarCliente.conectorAction','LPInsertarClienteBasico');
							enviaSICC('frmInsertarCliente');
						  }else{
								return;
							   }
						}
         }
         // parte  coco y seba

         if(get('frmInsertarCliente.casoDeUso')=="ModificarCliente") {
                  if  ( validacion() ) {
					  listado1.actualizaDat();
					  var xmlLista = this.listaToXml();
					  set("frmInsertarCliente.hidListaIdentificacion", xmlLista);
					  set('frmInsertarCliente.conectorAction','LPModificarCliente');

                      if  (get('frmInsertarCliente.hidCodigoAutomatico') == 'false' || 
										get('frmInsertarCliente.codigoAutomatico') == 'false') {
                         set('frmInsertarCliente.codigoCliente', codigoCliente);
                      }
					  eval('frmInsertarCliente').oculto="N";
					  set('frmInsertarCliente.accion','Validar');
					  enviaSICC('frmInsertarCliente');
                  }
                  
         }

         if(get('frmInsertarCliente.casoDeUso')=="Insertar Cliente"){
                  recolectarValor();

                  if(get('frmInsertarCliente.hidCodigoAutomatico') == 'false' || get('frmInsertarCliente.codigoAutomatico') == 'false'){
                     set('frmInsertarCliente.codigoCliente', codigoCliente);
                  }
                  set('frmInsertarCliente.hidFocusPrimerComponente', 'true');
                           set('frmInsertarCliente.conectorAction','LPInsertarCliente');
                           
                           if(validacion()){
                                     if(get('frmInsertarCliente.hidCodigoAutomatico') == 'false' || get('frmInsertarCliente.codigoAutomatico') == 'false'){
                                              
                                             set('frmInsertarCliente.codigoCliente', codigoCliente);
                                     }
                                                      //alert("Antes de envia oculto");
                                                      eval('frmInsertarCliente').oculto="S";
                                                      set('frmInsertarCliente.conectorAction','LPInsertarCliente');
                                                      set('frmInsertarCliente.accion','Validar');
                                                      enviaSICC('frmInsertarCliente');
                           }
                           //alert("Despues de if validacion...");
         }

         //alert("Finalizo accionP2()");	
}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */
function mostrarerror(nroDoc){
		//alert("En mostrarerror");
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
						  set('frmInsertarCliente.conectorAction','LPInsertarCliente');
						  set('frmInsertarCliente.accion','');
						  enviaSICC('frmInsertarCliente');
                  }
                  return true;   
}


/* -------------------------------------------------------------------------------------------------------------------------------------------- */
function accionExitosa(){
         //alert("*** Accion exitosa");
         if(get('frmInsertarCliente.casoDeUso')=="Insertar Cliente"){
                  recolectarValor();

                  if(get('frmInsertarCliente.hidCodigoAutomatico') == 'false' || get('frmInsertarCliente.codigoAutomatico') == 'false'){
                     set('frmInsertarCliente.codigoCliente', codigoCliente);
                  }
                  set('frmInsertarCliente.hidFocusPrimerComponente', 'true');
                           set('frmInsertarCliente.conectorAction','LPInsertarCliente');		
         }

         if(validacion()){
     
     if(get('frmInsertarCliente.hidCodigoAutomatico') == 'false' || get('frmInsertarCliente.codigoAutomatico') == 'false'){
          
         set('frmInsertarCliente.codigoCliente', codigoCliente);
     }
                           eval('frmInsertarCliente').oculto="N";
                           set('frmInsertarCliente.accion','Siguiente1_Validar');
                           enviaSICC('frmInsertarCliente');
         }
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
function recargarValor() {
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
         
         set('frmInsertarCliente.accion','');

         if(get('frmInsertarCliente.casoDeUso')==""){
			      recolectarValor();
                  set('frmInsertarCliente.conectorAction','LPInsertarClienteBasico');
         }
  
         if(get('frmInsertarCliente.casoDeUso')=="Insertar Cliente"){
				  recolectarValor();
                  set('frmInsertarCliente.conectorAction','LPInsertarCliente');
         }  

         if(get('frmInsertarCliente.casoDeUso')=="ModificarCliente"){
				 listado1.actualizaDat();
 				  var xmlLista = this.listaToXml();
				  set("frmInsertarCliente.hidListaIdentificacion", xmlLista);
                  set('frmInsertarCliente.accion',"");
                  set('frmInsertarCliente.conectorAction','LPModificarCliente');
         }

		  if (get('frmInsertarCliente.hidCodigoAutomatico') == 'false' || 
						get('frmInsertarCliente.codigoAutomatico') == 'false') {
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
function seteaTitulosPestanya(){
      
                           var tituloP = GestionarMensaje("1507");
      document.getElementById("InsertarP1").innerText = tituloP;

                           var tituloP = GestionarMensaje("1508");
                           document.getElementById("InsertarP2").innerText = tituloP;

                           var tituloP = GestionarMensaje("1509");
                           document.getElementById("InsertarP3").innerText = tituloP;

                           var tituloP = GestionarMensaje("1510");
                           document.getElementById("InsertarP4").innerText = tituloP;
         

         }

//----------------------------------------------------------------------------------------------------------------------         
function fLimpiar(){
 casoDeUso = get('frmInsertarCliente.casoDeUso');
   if(casoDeUso == 'ModificarCliente'){
      //alert('entro en limpiar modificar');

      set('frmInsertarCliente.hidPestanya', '0'); 
      set('frmInsertarCliente.hPestanya', '-1');
      set('frmInsertarCliente.dtoOid', get('frmInsertarCliente.hiddenOid'));
      //alert('el oid ' + get('frmInsertarCliente.hiddenOid'))
      set('frmInsertarCliente.hidCodigoCliente', get('frmInsertarCliente.hiddenCodigo'));
     // alert('el codigo es '+  get('frmInsertarCliente.hiddenCodigo'));
      set('frmInsertarCliente.accion', '');
      set('frmInsertarCliente.conectorAction', 'LPModificarCliente');
      enviaSICC('frmInsertarCliente', '', '', 'N');
      }else{
         listado1.setDatos(datosListaLimpiar);
         datosListaLimpiar = duplicaArray(datosListaLimpiar);
  }
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

// ------------------------------------------------------------------------------------------------------------------------
function shiftTab(filaEvento)
{

         if (filaEvento == 0)
         {
                  setTimeout("focalizaBotonHTML('botonContenido', 'Anterior' );", 10);
                  focalizaBotonHTML("botonContenido", "Anterior" );

         }
}

//Cleal - Inc 21251
function actualizaChkIndActivo(){
//      alert("frmInsertarCliente.hIndActivoP2: "+get("frmInsertarCliente.hIndActivoP2"));
         if(get("frmInsertarCliente.hIndActivoP2")== "1"){
                  set('frmInsertarCliente.ckIndActivoP2','S');
                  
         } else{
                           set('frmInsertarCliente.ckIndActivoP2','N');
                                    
         }
         
         document.getElementById("ckIndActivoP2").disabled = true;
}

//Cleal - Inc 21251
function ocultarCbIndActivo(){
         document.getElementById("ckIndActivoP2").style.visibility='hidden';
         document.getElementById("lblIndActivo").style.visibility='hidden';
}

/* ------------------------------------------------------------------------------------------------------------------------------------------ */
function listaToXml() {
	var xmlDoc = "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?>";
	xmlDoc = xmlDoc + "<DOC>";
	var datos = listado1.datos;
	var cantFilas = datos.length;
	/* Recorre las filas */ 
	for (var i = 0; i < cantFilas; i++) {
		var linea = datos[i]; 
		xmlDoc = xmlDoc + "<ROW>";
		/* Recorre los campos dentro de la fila */
		var cantCampos = linea.length;
		for (var j = 0; j < cantCampos; j++ ) {
			/* Quito formato local de numero */ 
			var campo = linea[j];
			xmlDoc = xmlDoc + "<CAMPO>" + DrdEscXML(campo) + "</CAMPO>";
		}
		xmlDoc = xmlDoc + "</ROW>"
	}
	xmlDoc = xmlDoc + "</DOC>";
	return xmlDoc; 
}

/* ------------------------------------------------------------------------------------------------------------------------------------------ */
function seteaComboPersonaEmpresa() {
	var cadena = get("frmInsertarCliente.columnaPersonaEmpresa");
	var array = cadena.split(","); 
	
	if (cadena != "") {
		var cantCampos = array.length;
		var campo = null;
		for (var i = 0; i < cantCampos; i++) {
			campo = array[i]; 
			listado1.datos[i][5] = campo;
		}
	}

	listado1.repintaDat();
}

/* ------------------------------------------------------------------------------------------------------------------------------------------ */
function setComboValorDefecto( iFila, iColumna, descDefecto){
	listado1.datos[iFila][iColumna] = descDefecto;
}