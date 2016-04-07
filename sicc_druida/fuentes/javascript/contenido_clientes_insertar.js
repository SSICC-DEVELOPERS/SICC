function onLoadPag() {
	configurarMenuSecundario("frmInsertarCliente");
	DrdEnsanchaConMargenDcho('listado1',12);

	document.all["CpLin1listado1"].style.visibility='';
	document.all["CpLin2listado1"].style.visibility='';
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';
	
	setTimeout('eval (ON_RSZ)',200);

	if ( !fMostrarMensajeError() ){
		var casoUso = get("frmInsertarCliente.casoDeUso");
		if (casoUso == "ModificarCliente") {
		    visibilidad("ModificarDiv", "O");  // TODO: Importante! Esto OCULTA el botón hasta que se implemente su funcionalidad por BELC300024082 !
		    focaliza("frmInsertarCliente.comboTipoCliente","");
		} else {
			visibilidad("ModificarDiv", "O"); // ("O") Oculto el boton Modificar 
			// caso de Uso Insertar. 
			// Si vuelvo de la pestanya 1, recargo los valores anteriores.
			var elem = get('frmInsertarCliente.elementos');
			if(elem!=""){
				recargarValor();
			}
			//pongo el foco donde corresponde
			//document.getElementById("comboTipoCliente").setActive();
            foco();
		}
	}//end if mensaje error	

	if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
        btnProxy(2,1);  // boton 'volver', habilitado
        btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
    }
}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */

	function fVolver(){     
					  window.close();
	}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */

function getRefCombo() {
	var combo=window.event.srcElement.getAttribute("NAME");
	var option=window.event.srcElement.options;
	for(var i=0;i<option.length;i++){
		if(option.item(i).getAttribute("selected")){
			if(option.item(i).getAttribute("value") == get('frmInsertarCliente.valueComboSelected')) {
				GestionarMensaje('1055');
				break;
			}
			set('frmInsertarCliente.nameComboSelected',combo);
			set('frmInsertarCliente.valueComboSelected',option.item(i).getAttribute("value"));
			borrarCombo();
			cargarComboEditable();
		}
	}
}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */
function cargarComboEditable(){
	var name = get('frmInsertarCliente.nameComboSelected');
	var cad = new String();
	cad=name;
	var largo = cad.length;

  var Lista = document.getElementById("comboSubtipoCliente");
  var optionVacia = document.createElement("OPTION");
  Lista.options.add(optionVacia);
  			
  optionVacia.innerText = '';
  // Version anterior ---------------------------------
  //	optionVacia.value = -1;
  // --------------------------------------------------

  // Modificación realizada por Maximiliano Dello Russo
  // Descripción:  Se modifica para que el subsistema de validación funcione correctamente.
  // 21/10/2004
	optionVacia.value = '';
  
	for(var k=0;k<Lista1.datos.longitud;k++) {

		if ( Lista1.datos.ij(k,1) == get('frmInsertarCliente.valueComboSelected')) {
			var option =  document.createElement("OPTION");
      Lista.options.add(option);
      option.innerText=Lista1.datos.ij(k,2);
			option.value= Lista1.datos.ij(k,0);
		}
	}
 
     
	activarCombo(cad.substring(largo-1,largo));
}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */
function activarCombo(obj){
	var i = Math.abs(obj)+1;
	var combos=document.getElementsByName("comboTipoCliente");
	combos.item(0).setAttribute("disabled",false);
	var combos1=document.getElementsByName("comboSubtipoCliente");
	combos1.item(0).setAttribute("disabled",false);
}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */
function borrarCombo(){
	var cad = new String;
	cad =get('frmInsertarCliente.nameComboSelected');
	//var i = Math.abs(cad.substring(cad.length-1,cad.length));
	var combo =document.getElementById("comboSubtipoCliente");
	var option = combo.options;
	for(var k=option.length;k>-1 ;k--){
		option.remove(k);
	}
}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */
function aniadirFila(){
	var linea = new Array(); 
	var cantFilas = listado1.datos.length;
	var indPrincipal = "0";
    
	if (cantFilas == 0) {
		indPrincipal = "1"
	}
	//linea.length = 4;

	var comboTipoCliente    = document.getElementById('comboTipoCliente');
	var comboSubTipoCliente = document.getElementById('comboSubTipoCliente');
	
	// Modificado por Maximiliano Dello Russo
	// Incidencia BELC300006912 
	// 21/10/2004
	if(!sicc_validaciones_generales()){
		return false;
	}

	var tipoStr    = comboTipoCliente.options[comboTipoCliente.selectedIndex].text;
	var subTipoStr = comboSubTipoCliente.options[comboSubTipoCliente.selectedIndex].text;
	var oidTipo    = comboTipoCliente.options[comboTipoCliente.selectedIndex].value;
	var oidSubTipo = comboSubTipoCliente.options[comboSubTipoCliente.selectedIndex].value;
	var repetido = false;
	linea[0] = "g";
	linea[1] = tipoStr;
	linea[2] = subTipoStr;
	linea[3] = oidTipo;
	linea[4] = oidSubTipo;
	linea[5] = indPrincipal;
    
	if((oidTipo == -1)|| (oidSubTipo == -1)){
		return;
	}
	for(var i = 0; i < cantFilas; i++) {
		if(oidTipo == listado1.datos[i][3]){
			repetido = true;
			break;
		}
	}
	if(!repetido){
		listado1.insertar(linea);
		listado1.repinta();comboTipoCliente.selectedIndex = -1;
		var aCombo = new Array(new Array("",""));
	    set_combo('frmInsertarCliente.comboSubtipoCliente',aCombo, []);

		 // Modif. por ssantana, 25/11/2004
		 // por inc. 9386 - 
		 // Nota: Se pone el focaliza en un bucle por problema de focalización de combos con Druida.
		 for (var i = 0; i < 5; i++) 
			focaliza('frmInsertarCliente.comboTipoCliente');
	}else{
		GestionarMensaje('MAE0013');
	}

}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */
function fBorrar(){
	
	if(!listado1.numSelecc() == 0){	
		var casoUso = get("frmInsertarCliente.casoDeUso");

		if ( casoUso == "ModificarCliente"){	
				// Guarda los elementos a borrar que no tengan como codigo oculta la letra "g"
				// ("g" se usa para indicar un fila que ingreso el usuario en el momento).
				var elemToDel = "";
				var codigos = listado1.codSeleccionados();

				for (var i = 0; i < codigos.length; i++) {
					if (codigos[i] != "g") {
							if (i != 0) {
								elemToDel = elemToDel + ",";
							}


							elemToDel = elemToDel + codigos[i];
					}
				 }
				if (elemToDel != "") {
						var buffer = get("frmInsertarCliente.elemToDel");
						if (buffer != 0){
							buffer = buffer + "," + elemToDel;
						}else{
							buffer = elemToDel;
						}
						set("frmInsertarCliente.elemToDel", buffer);
				}
 
		} 

		listado1.eliminarSelecc();        
  }else{
		GestionarMensaje('50');
	}
}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */
function validar(){
	if(listado1.datos.length==0){
		GestionarMensaje("2526");
		focaliza('frmInsertarCliente.comboTipoCliente');
		//alert("Debe seleccionar al menos un tipo subtipo");
		return false;
	}
  setMV('frmInsertarCliente.comboTipoCliente', 'N');
  setMV('frmInsertarCliente.comboSubtipoCliente', 'N');
	return true;
}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */
function accionInsertarP1(){
	if(validar()){
		var casoDeUsoP1 = get('frmInsertarCliente.casoDeUso');
		if(casoDeUsoP1=="ModificarCliente"){
			Siguiente1();
			return;
		}
		// seteo la accion siguiente
		set('frmInsertarCliente.accion','Siguiente1');

		if(casoDeUsoP1=="Insertar Cliente"){
			set('frmInsertarCliente.conectorAction','LPInsertarCliente');
		}else if(casoDeUsoP1==""){
		// insertar basico
			set('frmInsertarCliente.conectorAction','LPInsertarClienteBasico');
      
		}
		set('frmInsertarCliente.hidFocusPrimerComponente', 'true');
		recolectarValor();
		set('frmInsertarCliente.hidTipoClienDescripcion', listado1.datos[0][1] );
		enviaSICC('frmInsertarCliente');
	}
}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */
  function recolectarValor(){
	
	   var casoUso = get("frmInsertarCliente.casoDeUso");
	   var val = "";

		if (casoUso == "ModificarCliente") {
				/*
				for(var x=0; x < cantDatos; x++) {
					val=val  + "h_oidTupla_" + x + "=" + listado1.datos[x][0] + ";";
					val=val + "h_comboTipoCliente_"+ x + "=" + listado1.datos[x][3] +";" ;
					val=val + "h_comboSubtipoCliente_"+ x + "=" + listado1.datos[x][4] +";" ;
					val=val + "h_descTipoCliente_"+ x + "=" + listado1.datos[x][1] +";" ;
					val=val + "h_descSubtipoCliente_"+ x + "=" + listado1.datos[x][2] +";" ;
			   }*/
			   val = this.listaToXml();
		} else {
				listado1.actualizaDat();
				var cantDatos = listado1.datos.length;
				for(var x = 0; x < cantDatos; x++) {
					val=val + "h_comboTipoCliente_"+ x + "=" + listado1.datos[x][3] +";" ;
					val=val + "h_comboSubtipoCliente_"+ x + "=" + listado1.datos[x][4] +";" ;
					val=val + "h_descTipoCliente_"+ x + "=" + listado1.datos[x][1] +";" ;
					val=val + "h_descSubtipoCliente_"+ x + "=" + listado1.datos[x][2] +";" ;
			    }
		}
		set('frmInsertarCliente.elementos', val);
  	
}

/* ------------------------------------------------------------------------------------------------------------------------------------------ */
function listaToXml() {

	var arrayNombreCampos = new Array();
	arrayNombreCampos[0] = "oid";
	arrayNombreCampos[1] = "tipoClienteDesc";
	arrayNombreCampos[2] = "subtipoClienteDesc";
	arrayNombreCampos[3] = "tipoClienteOid";
	arrayNombreCampos[4] = "subtipoClienteOid";

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
			xmlDoc = xmlDoc + "<CAMPO nombre='" + arrayNombreCampos[j] + "'>" + DrdEscXML(campo) + "</CAMPO>";
		}
		xmlDoc = xmlDoc + "</ROW>"
	}
	xmlDoc = xmlDoc + "</DOC>";

	return xmlDoc; 
}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */
 function recargarValor(){

	var val = get('frmInsertarCliente.elementos');
	var elems = val.split(";");
	var cant = Math.round((elems.length-1) / 4);
	var listaTipoSubtipo = new Array(cant);
	for(var t=0;t<cant;t++){
		listaTipoSubtipo[t] = new Array(5);
		listaTipoSubtipo[t][0] = t+1;
	}
	for(var x=0;x<elems.length;x++){
		var line = elems[x].split("=");
		//line[0] = h_comboTipo_0
		//line[1] = 1 - codigo o valor
		var elem = line[0].split("_");
		//elem[0] tiene h
		//elem[1] tiene comboTipoCliente
		//elem[2] el indice del combo
		var ind = Math.abs(elem[2]);
		if(elem[1]=="comboTipoCliente"){
			listaTipoSubtipo[ind][1]= obtenerStringTipo(line[1]);
			listaTipoSubtipo[ind][3]= line[1];
		}else if(elem[1]=="comboSubtipoCliente"){
			listaTipoSubtipo[ind][2]= obtenerStringSubtipo(line[1]);
			listaTipoSubtipo[ind][4]= line[1];
		}
	}
	for(var g=0;g<cant;g++){
		listado1.insertar(listaTipoSubtipo[g],true); //[1] se le agrega el true para que no repinte en cada insertar
	}
      listado1.repinta();
}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */
function obtenerStringTipo(valor){
	var comboTipo = document.getElementById("comboTipoCliente");
	var result = "";
	for(var y=0;y<comboTipo.options.length;y++){
		if(comboTipo.options.item(y).value==valor){
			//encontrado
			return comboTipo.options.item(y).text;
		}
	}
	return result;
}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */
function obtenerStringSubtipo(valor){

	var result = "";
	for(var y=0;y<Lista1.datos.longitud;y++){
		if(Lista1.datos.ij(y,0)==valor){
			//encontrado
			return Lista1.datos.ij(y,2);
		}
	}
	//			 option.innerText=Lista1.datos.ij(k,2);
//			 option.value= Lista1.datos.ij(k,0);
	return result;
}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */
function Siguiente1(){

	recolectarValor();

	// Toma la descripcion del tipo de la primer fila de la lista, y su codigo.
	listado1.actualizaDat();
	//var datosLista = listado1.datos;

	var descTipo  = listado1.datos[0][1];// [1] datosLista[0][1];
	//alert("descTipo: " + descTipo);
	set('frmInsertarCliente.hDescripcionTipo', descTipo);

	set('frmInsertarCliente.accion',"Siguiente1");
	set('frmInsertarCliente.conectorAction',"LPModificarCliente");
	//alert("elementos: " + get("frmInsertarCliente.elementos") );
	enviaSICC('frmInsertarCliente');
}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */
function foco(){
   var foco = get('frmInsertarCliente.hidFocusPrimerComponente');

   if(foco == 'false'){
      focalizaBotonHTML('botonContenido','btnSiguiente');
   }else{
      focaliza('frmInsertarCliente.comboTipoCliente'); 
   }


}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */
function fVolver() {	
    window.close();
    return;
}


/* -------------------------------------------------------------------------------------------------------------------------------------------- */
function fLimpiar(){
    casoDeUso = get('frmInsertarCliente.casoDeUso');

   if(casoDeUso == 'ModificarCliente'){
      set('frmInsertarCliente.hidPestanya', '0'); 
      set('frmInsertarCliente.hPestanya', '-1');
      set('frmInsertarCliente.dtoOid', get('frmInsertarCliente.hiddenOid'));
      set('frmInsertarCliente.hidCodigoCliente', get('frmInsertarCliente.hiddenCodigo'));
      set('frmInsertarCliente.accion', '');
      set('frmInsertarCliente.conectorAction', 'LPModificarCliente');
      enviaSICC('frmInsertarCliente', '', '', 'N');
   }else{
      var aCombo = new Array(new Array("",""));
      set_combo('frmInsertarCliente.comboSubtipoCliente',aCombo, []);
      listado1.setDatos(new Array());
      focaliza('frmInsertarCliente.comboTipoCliente')
   }
     
}