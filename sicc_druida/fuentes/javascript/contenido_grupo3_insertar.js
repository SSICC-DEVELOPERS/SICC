//--------------------------------------------------------------------------------------------------------------------
//globales
var formName = "frmInsertarCliente";
var lista1Limpiar;
var lista2Limpiar;
var lista3Limpiar;

var INTERVALO_DEFECTO = "Lunes a Domingo";

/* --------------------------------------------------------------------------------------------------------------------------------------- */
function onLoadPag(){
	 var ini = null;
	 var fin = null;
	configurarMenuSecundario(formName);
	setTimeout("ensanchaListas()", 100);
	
	if(!fMostrarMensajeError())	{

		cargarComboIntervaloComunicacion();// carga internacionalizada
		cargarComboDiaComunicacion();// carga internacionalizada
		listado2.repinta();
		modificacionesGeoReferenciador(); //esto muestra y oculta ciertos campos segun si  usa georeferenciador	

		if ( get(formName + ".casoDeUso") == "ModificarCliente"){
			//ini = new Date();
			seteaListas();
			//fin = new Date();
		}else{
			// caso de uso Insertar clientes
			recargarValores();
			if( get(formName + ".comboTipoDireccion") == "" ){
				setTipoDireccionDefecto();
			}
		}
		// foco al primer campo
		foco();
		seteaVarsLimpiar();
	}

     if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
        btnProxy(2,1);  // boton 'volver', habilitado
        btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
    }
	 /* alert("Funcion seteaListas: " + (fin.getTime() - ini.getTime() ) );  */

}

 /* --------------------------------------------------------------------------------------------------------------------------------------- */

	function fVolver(){     
					  window.close();
	}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */

function foco(){
   var foco = get('frmInsertarCliente.hidFocusPrimerComponente');
         
   if(foco == 'false'){
      focalizaBotonHTML('botonContenido', 'btnSiguiente');
   }else{
      focaliza(formName + ".comboTipoDireccion");
   }
}

/* --------------------------------------------------------------------------------------------------------------------------------------- */
function SetearPestanyaParaCadaCasoDeUso(){
	if(get(formName+'.casoDeUso')=="ModificarCliente"||get(formName+'.casoDeUso')=="Insertar Cliente")
	{
			var p1=document.getElementById("InsertarP1");
			var p2=document.getElementById("InsertarP2");
			var p3=document.getElementById("InsertarP3");
			var p4=document.getElementById("InsertarP4");
			p1.style.visibility="visible";
			p1.left="632";
			p2.style.visibility="visible";
			p2.left="722";				
			p3.style.visibility="visible";
			p3.left="812";				
			p4.style.visibility="visible";
			p4.left="902";
		}else
		{
			//crea las pestañas del insertar
			var p1=document.getElementById("InsertarP1");
			var p2=document.getElementById("InsertarP2");
			var p3=document.getElementById("InsertarP3");
			p1.style.visibility="visible";
			p2.style.visibility="visible";
			p3.style.visibility="visible";
	  }

	  var div1 = document.getElementById("InsertarP1");
	  var div2 = document.getElementById("InsertarP2");
	  var div3 = document.getElementById("InsertarP3");
	  var div4 = document.getElementById("InsertarP4");

	  div1.innerText = GestionarMensaje("1507");
	  div2.innerText = GestionarMensaje("1508");
	  div3.innerText = GestionarMensaje("1509");
	  div4.innerText = GestionarMensaje("1510");
}

/* --------------------------------------------------------------------------------------------------------------------------------------- */
 function borrarCombo(nombreCombo){
	var elCombo = document.getElementById(nombreCombo);
	var optis = elCombo.options;
	var cant = optis.length-1;
	for(var z=cant;z>=0;z--){
		optis.remove(z);
	}
}

/* --------------------------------------------------------------------------------------------------------------------------------------- */
function fVolver(){
	if (get("frmInsertarCliente.casoDeUso") == "ModificarCliente")
	{
			window.close();
			return;
	} else
		accionP2();
}

/* --------------------------------------------------------------------------------------------------------------------------------------- */
function accionP2(){
//	alert("accionP2()");
	//var tiposDirCorrecto = validaTipoDirecciones();
	var listado = listado1.datos;
	//if ( tipoDirCorrecto ) 
	//{
			if(get(formName + '.casoDeUso')=="ModificarCliente"){
				var xml = null;
				//alert("listado1.datos: "+listado1.datos);
				obtenerDatosTablas("listado1", 14);//18

				xml = this.listaToXML("listado2");
				set("frmInsertarCliente.hidListaComunicacion", xml);

				obtenerDatosTablas("listado3", 2);
				set(formName + '.conectorAction','LPModificarCliente');		
				set(formName + '.accion','Validar');
			}
			if(get(formName + '.casoDeUso')=="Insertar Cliente"){
				recolectarValoresP3();
				set(formName + '.conectorAction','LPInsertarCliente');		
				set(formName + '.accion','Siguiente1_Validar');
			}
			set(formName + '.hidFocusPrimerComponente', 'false');
			enviaSICC('frmInsertarCliente', '', '', 'N');
	//}

}

/* --------------------------------------------------------------------------------------------------------------------------------------- */
function accionP4(){
	//alert("accionP4()");
	var miLista = listado1.datos;
	if(validar()){
		if(get(formName + '.casoDeUso')=="ModificarCliente") {
			var xml = null;
			//alert("listado1.datos: "+listado1.datos);
			obtenerDatosTablas("listado1", 14);//18
			//alert(miLista);
			// obtenerDatosTablas("listado2", 8);
			xml = this.listaToXML("listado2");
			set("frmInsertarCliente.hidListaComunicacion", xml);

			obtenerDatosTablas("listado3", 2);
			set(formName + '.conectorAction','LPModificarCliente');		
		}
		if(get(formName + '.casoDeUso')=="Insertar Cliente"){
			recolectarValoresP3();
			set(formName + '.conectorAction','LPInsertarCliente');		
		}
		//Enviamos el formulario de forma oculta con la accion = "Siguiente4"
		setMV(formName + ".comboNombreVia", "c");
    set(formName + '.hidFocusPrimerComponente', 'true');
		set(formName + '.accion','Siguiente4');
    enviaSICC('frmInsertarCliente', '', '', 'N');
		
	}
}

/* --------------------------------------------------------------------------------------------------------------------------------------- */
function validar(){
//Debe haber elegido una clasificacion, es decir, los campos: marcaClasificacion, canalClasificacion, tipoClasificacion, clasificacion. De lo contrario se muestra el mensaje: MAE-0010 (El cliente debe tener por lo menos clasificacion) y no se continua. 
// Mal en el modelo, de pestanya 4

//Debe hacer introducido al menos una dirección principal: por lo tanto si no hay una direccion con todos los campos completos y marcada como principal se muestra el mensaje: MAE-0016 (Debe introducir al menos una dirección principal para el cliente.) y no se continua. 
	if(!validarHayDireccionPrincipal()){
		return false;
	}
//Validamos que la fecha de comunicacionHoraDesde es anterior a la correpondiente comunicacionHoraHasta de cada fila en listadoComunicaciones, de lo contrario mostramos el mensaje: MAE-0018 (La hora desde debe de ser anterior a la hora hasta) y no continuamos 
	if(!validarComunicacion())
	{
		//alert("comunic");
		return false;
	}

//Al menos uno de los combos marca tiene que tener un valor de lo contrario se muestra el mensaje: MAE-0010 (El cliente debe tener al menos una marca) y no se continua. 
	if(!validarMarca()){
    ////alert('entro a validar marca');
		return false;
	}

	if (!validaTipoDirecciones() ){
			return false;
	}
// aca valido que solo hay una comunicacion principal

  if(!validarCheckComunicacion()){
     return false;

  }
  
//Cuando se envia la página, debemos enviar en campos ocultos los elementos elegidos en los combos marcas, ya que nos necesitaremos en la siguiente pantalla. Los nombres de los campos ocultos serán: "NombreMarca1" para el combo marca1, "NombreMarca2" para el segundo y así sucesivamente. 
//Por ejemplo: si en combo se selecciona "Ebel" cuyo valor es 3432434, sólo el 3432434 que es el value se enviará, pero en la siguiente pantalla queremos rellenar un combo de marcas con las marcas que ha elegido en esta pestanya y por eso necesitamos la descripción del elemento elegido (p.e "Ebel"). 
	return true;
}

function validarCheckComunicacion(){
   var cont = 0;

         for(var x=0;x<listado2.datos.length;x++){
              
                  var radio="ckComunicacionPrincipal_"+x;
                  var radio = document.getElementById(radio);
                  if(radio.checked==true){
                     cont = cont + 1;
                  }
         }       

         if (cont > 1 ){
         
            GestionarMensaje('1198');
            return false;     
         }

    return true;
}

/* --------------------------------------------------------------------------------------------------------------------------------------- */
function verificaAniadir(){
	//alert("verificaAniadir");
	var chkPrincipal = document.getElementById("ckDireccionPrincipal");
	var siI18N = GestionarMensaje("84");
	var noI18N = GestionarMensaje("86");
	//alert(chkPrincipal.checked);
	if(chkPrincipal.checked){
		if(listado1.datos.length>0){
			for(var f=0;f<listado1.datos.length;f++){
				if(listado1.datos[f][9]==siI18N){
					if(cdos_mostrarConfirm(GestionarMensaje("UIMAE0003"))==true){
						listado1.datos[f][9]= noI18N;
						listado1.repintaDat();
						//alert("retorna true");
						return true;
					} else{
						//alert("retorna false");
						return false;
					}
				}
			}
		} else {
			//alert("es la 1era que se inserta...");
			return true;
		}
	} else {
		return true;
	}

}


/* --------------------------------------------------------------------------------------------------------------------------------------- */
function validarHayDireccionPrincipal(){
	var res = false;
	var resind;// indice direccion completa
	var siI18N = GestionarMensaje("84");	
	var cantDirPpales = 0;

	for(var f=0;f<listado1.datos.length;f++)
	{
//		if(listado1.datos[f][13]==siI18N) - Cleal

		if(listado1.datos[f][9]==siI18N)
		{

			res =true;
			resind=f;
			cantDirPpales++;
		}
	}


	if(!res){
		//alert("Debe marcar una  direccion como principal");
		GestionarMensaje("1079");
		return;
	}
	if (cantDirPpales > 1) 
	{
		GestionarMensaje("1193");
		return;
	}

	return true;
}


/* --------------------------------------------------------------------------------------------------------------------------------------- */
function validarComunicacion()
{
	
	//Validamos que la fecha de comunicacionHoraDesde es anterior a la correpondiente comunicacionHoraHasta de cada fila en listadoComunicaciones, de lo contrario mostramos el mensaje: MAE-0018 (La hora desde debe de ser anterior a la hora hasta) y no continuamos 

	for(var f=0;f<listado2.datos.length;f++)
	{
		var tipoComu= document.getElementById("comboTipoComunicacion_" + f);
		if(tipoComu.selectedIndex==-1||tipoComu.value==-1){

			GestionarMensaje("2534"); 
			tipoComu.focus();
			return false;
		}
		//listado2.actualizaDat();
		// por ahora pedorra validacion, espera que hora sea un numero y que sea entre 0 y 24
		var horaDesde =  document.getElementById("TextoHoraDesde_" + f);
		var horaHasta =  document.getElementById("TextoHoraHasta_" + f);

		// Valida que Hora Desde sea numérico.
		var horaDesdeValue = horaDesde.value;
		var horaHastaValue = horaHasta.value;
		if ( horaDesdeValue != "")
		{	
			valido = validaFormatoHora(horaDesdeValue);
			if ( valido == false)
			{
				GestionarMensaje("1514", null, null, null);
				horaDesde.focus();
				return valido;
			}
		}

		// Valida que Hora Hasta sea numérico
		if (horaHastaValue != "")
		{
			valido = validaFormatoHora(horaHastaValue);
			if (valido == false)
			{
				GestionarMensaje("1514", null, null, null);
				horaHasta.focus();
				return valido;
			}
		}


		if (horaHastaValue != "" && horaDesdeValue != "")
		{
				// En este punto, ya se valido que el formato de la hora es correcto, así
				// que el formato a tomar es HH:mm
				hastaArray = horaHastaValue.split(":");
				desdeArray = horaDesdeValue.split(":");
				desdeNuevo = desdeArray[0] + desdeArray[1];
				hastaNuevo = hastaArray[0] + hastaArray[1];

				//alert(desdeNuevo + " < " + hastaNuevo + "? ");
				if ( parseInt(desdeNuevo,10) >= parseInt(hastaNuevo, 10) )
				{

					GestionarMensaje("MAE0018");
					horaDesde.focus();
					return false;
				}
		}


	}
	
	return true;
}

/* --------------------------------------------------------------------------------------------------------------------------------------- */
function validarMarca(){
  ////alert('en validar marca');
	for(var t=0;t<listado3.datos.length;t++){
		var cbMarc = document.getElementById("comboMarca_" + t);
    ////alert('entro a validar marca ' + cbMarc.value);
		if(cbMarc.value == ''){
			//alert("Marca vacia");
			GestionarMensaje("63");
			cbMarc.focus();
			return false;
		}
	}
	return true;
}

//--------------------------------------------------------------------
function aniadirLinea(numeroLista) {
    var listaEditable = getLista(numeroLista);
    var casoUso = get("frmInsertarCliente.casoDeUso");
    var linea = new Array();
    
    if (casoUso == "ModificarCliente") {
        linea[0] = "g";
    } else {
        linea[0]= listaEditable.datos.length + 1;
    }
    
    if (numeroLista == 1) {
        aniadirDireccion();
        // si es 1 no inserto, tengo que validar si es valido
        // y luego agregar a la lista
    } else if (numeroLista == 2) {
        linea[1] = "";
        linea[2] = "";
        linea[3] = "";
        linea[4] = "false";
        linea[5] = "";
        linea[6] = "";
        linea[7] = ""; 
        
        listaEditable.insertar(linea);
		setComboValorDefecto( listaEditable.datos.length - 1, 6, INTERVALO_DEFECTO);
        //listaEditable.repintaDat();

        // vuelvo el foco al combo tipo comunicacion
        document.getElementById("comboTipoComunicacion_" + (listaEditable.datos.length - 1)).focus();
    } else if (numeroLista == 3) {
        linea[1] = "";
        
        listaEditable.insertar(linea);
        listaEditable.repintaDat();
        
        // vuelvo el foco al combo marca	
        document.getElementById("comboMarca_" + (listaEditable.datos.length - 1)).focus();
    }
}
//---------------------------------------------------------------------------------------------------------------------
function eliminarLinea(numeroLista){
	var listadoAModificar = getLista(numeroLista);
	var casoUso = get("frmInsertarCliente.casoDeUso");

	if(!listadoAModificar.numSelecc() == 0)
	{
		if (casoUso == "ModificarCliente")
		{
				var elemToDel = new Array();
				switch (numeroLista)
				{
					case 1: 
						elemToDel = elementosToDel(listado1);
						if (elemToDel != "")  // Efectivamente se elimina algo. Se añade a la variable de form. correspondiente
						{
								var varBuffer = get("frmInsertarCliente.elemToDelDir");

								if (varBuffer != "")
									varBuffer = varBuffer + "," + elemToDel;
								else
									varBuffer = elemToDel;

								elemToDel = varBuffer;


								set("frmInsertarCliente.elemToDelDir", elemToDel);
						}

						break;
					case 2:
						elemToDel = elementosToDel(listado2);
						if (elemToDel != "")  // Efectivamente se elimina algo. Se añade a la variable de form. correspondiente
						{
								var varBuffer = get("frmInsertarCliente.elemToDelComm");

								if (varBuffer != "")
									varBuffer = varBuffer + "," + elemToDel;
								else
									varBuffer = elemToDel;

								elemToDel = varBuffer;


								set("frmInsertarCliente.elemToDelComm", elemToDel);
						}
						break;
					case 3:
						elemToDel = elementosToDel(listado3);
						if (elemToDel != "")  // Efectivamente se elimina algo. Se añade a la variable de form. elemToDel
						{
								var varBuffer = get("frmInsertarCliente.elemToDelMarcas");

								if (varBuffer != "")
									varBuffer = varBuffer + "," + elemToDel;
								else
									varBuffer = elemToDel;

								elemToDel = varBuffer;


								set("frmInsertarCliente.elemToDelMarcas", elemToDel);
						}


						break;
				}
		}

		listadoAModificar.eliminarSelecc();        

		//ahora verifico si de la lista que se elimino, si es obligatorio al menos uno
		// en cuyo caso, si se elimino el ultimo agrego otro registro vacio.

		if(listadoAModificar.datos.length==0)
		{
			if(numeroLista == 3)
			{
				// la lista 3 tiene una linea obligatoria
				aniadirLinea(numeroLista);
			}
		}
	}else{
		GestionarMensaje('50');
	}
}
//--------------------------------------------------------------------------------------------------------------------
function getLista(numero){
	var listadoAModificar;
	switch(numero){
		case 1: {
			return listado1;
		}
		break;
		case 2: {
			return listado2;		
		}
		break;
		case 3: {
 			return listado3;
		}
		break;
	}
	//return listadoAModificar;
}
//----------------------------------------------------------------------------------------------------------------------
function aniadirDireccion(){
	if(validarDireccion()){
		//vengo solo si es valida la direccion a agregar.
		var cboTipoDir   = document.getElementById("comboTipoDireccion");
		var cboTipoVia  = document.getElementById("comboTipoVia");
		var cboVia        = document.getElementById("hiddenOidVia");
		var chkPrincipal = document.getElementById("ckDireccionPrincipal");
		//Cleal MAE-03
		var txtNombreVia = document.getElementById("TextoNombreVia");

	if(verificaAniadir()){
		//alert("Paso verificarAniadir...");
			var dirArray = new Array();
			if ( get('frmInsertarCliente.casoDeUso') == "ModificarCliente" ){
				dirArray[dirArray.length] = "g";
			}else{
				dirArray[dirArray.length]=dirArray.length +1;
			}

			dirArray[dirArray.length]= get(formName + ".hidtxtTerritorio");

			if(cboTipoDir.selectedIndex!=-1){
				dirArray[dirArray.length] = cboTipoDir.options[cboTipoDir.selectedIndex].text;
			}

			if(cboTipoVia.selectedIndex!=-1){
				dirArray[dirArray.length] = cboTipoVia.options[cboTipoVia.selectedIndex].text;
			}else{
				dirArray[dirArray.length] = "";
			}
			//Cleal Mae-03
			if(get(formName + ".usaGeoreferenciador")=="true"){
				var descNombreVia = get(formName + '.TextoNombreVia');
			} else{
				var descNombreVia = get(formName + '.comboNombreVia');
			}
			//alert(descNombreVia);
			dirArray[dirArray.length] = descNombreVia;
			//alert(dirArray[dirArray.length]);
			//
			if(cboVia.selectedIndex!=-1){
				dirArray[dirArray.length] = get('frmInsertarCliente.comboNombreVia');
			}else{
				dirArray[dirArray.length] = "";
			}
			dirArray[dirArray.length] = get(formName + ".txtNumeroPrincipal");
			dirArray[dirArray.length] = get(formName + ".txtCodigoPostal");
			dirArray[dirArray.length] = get(formName + ".areatxtObservaciones");
			var siI18N = GestionarMensaje("84");
			var noI18N = GestionarMensaje("86");
			if(chkPrincipal.checked){
				dirArray[dirArray.length] = siI18N;
				// entonces todos los campos deben estar llenos
			}else{
				dirArray[dirArray.length] = noI18N;
			} 
			dirArray[dirArray.length] =get(formName + ".hidOidTerritorio");
			//Cleal Mae-03
			if(get(formName + ".usaGeoreferenciador")=="true"){
				dirArray[dirArray.length] = " ";
			} else{
				dirArray[dirArray.length]  = cboVia.value;
			}

			dirArray[dirArray.length]  = cboTipoVia.value;
			dirArray[dirArray.length]  = cboTipoDir.value;


			//var listaEditable = getLista(1);

			//alert("dirArray: " + dirArray);
			//listaEditable.insertar(dirArray);
			listado1.insertar(dirArray);

			// ahora borro el form direccion
			cboTipoDir.value='';
			setTipoDireccionDefecto();

			cboTipoVia.value='';

			var aCombo = new Array(new Array("",""));
			set('frmInsertarCliente.comboNombreVia','');
			
			
			set(formName + ".TextoNombreVia",""); //Para que esta esto aca???
			set(formName + ".txtNumeroPrincipal","");
			set(formName + ".txtCodigoPostal","");

			set(formName + ".areatxtObservaciones","");
			txt_to("lblUnidadesGeograficasXX","");	
			set(formName + ".hidOidTerritorio","");
			set(formName + ".hidtxtTerritorio","");
			
			
			chkPrincipal.checked = false;

			focaliza("frmInsertarCliente.comboTipoDireccion");

	}
	}
}


// vbongiov -- SiCC 20080702 -- 8/09/2008
function validarCaracteresValidos(str){ 
	//alert(str);
	for(var i=0; i < str.length; i++) {
		if(str.charAt(i)=="'" || str.charAt(i)=="<" || str.charAt(i)==">" || str.charAt(i)==";" || str.charAt(i)=="\n"){
			GestionarMensaje('2629'); 
			return false;
		}
	}
	return true;
}

// vbongiov -- SiCC 20080702 -- 8/09/2008
function validarCaracteresValidosGrupo3(){ 

	if(!validarCaracteresValidos(get(formName + ".TextoNombreVia"))){
		focaliza("frmInsertarCliente.TextoNombreVia");
		return false;
	}

	if(!validarCaracteresValidos(get(formName + ".areatxtObservaciones"))){
		focaliza("frmInsertarCliente.areatxtObservaciones");
		return false;
	}

	return true;
}


//---------------------------------------------------------------------------------------------------------------------
//Obligatoorios -> tipoDireccion, tipoVia, nombreVia, via y el campo oculto oidUnidadGeografica. (si visibles)
function validarDireccion(){
	var cboTipoDir = document.getElementById("comboTipoDireccion");
	var cboTipoVia = document.getElementById("comboTipoVia");
	var cboVia = document.getElementById("comboNombreVia");
	var txtNombreVia = document.getElementById("TextoNombreVia");
	var oidTerr = get (formName + ".hidOidTerritorio");
	var chkPrincipal = document.getElementById("ckDireccionPrincipal");

	
	if(cboTipoDir.value == '' || cboTipoDir.selectedIndex == '')
	{
		//alert("Falta tipo dir");
		GestionarMensaje("2536");
		focaliza("frmInsertarCliente.comboTipoDireccion");
		return;
	}
	
	if(get(formName + ".usaGeoreferenciador")=="true")
	{
		if(TextoNombreVia.value=="")
		{
			//alert("Falta nombre via");
			GestionarMensaje("1082");
			focaliza("frmInsertarCliente.TextoNombreVia");
			return;
		}
		//Cleal
		if((cboTipoVia.value == '') || (cboTipoVia.selectedIndex == '' ))
		{
			//alert("Falta tipo via");
			GestionarMensaje("1081");
	      focaliza("frmInsertarCliente.comboTipoVia");
			return;
		}

		// vbongiov -- SiCC 20080702 -- 26/08/2008
		if(!validarCaracteresValidosGrupo3()){ 
			  return false; 
		}  

	}else
	{
		if((cboTipoVia.value == '') || (cboTipoVia.selectedIndex == '' ))
		{
			//alert("Falta tipo via");
			GestionarMensaje("1081");
	      focaliza("frmInsertarCliente.comboTipoVia");
			return;
		}
		if((cboVia.value == '') || (cboVia.selectedIndex == '' ))
		{
			//alert("Falta via");
			GestionarMensaje("2537");
			focaliza("frmInsertarCliente.comboTipoVia");
			return;
		}
	}

   var dirPrincipal  = document.getElementById('ckDireccionPrincipal');
   var nPrincipal    = document.getElementById('txtNumeroPrincipal');
   var codPostal     = document.getElementById('txtCodigoPostal');


	// Si es Direccion principal, Numero Principal no puede ser vacío.
/*	if (dirPrincipal.checked)  
	{*/

	/* Modificado BELC300024273 

	if(get(formName + ".txtNumeroPrincipal")=="")		
	{
			 GestionarMensaje('1125'); 
			 focaliza('frmInsertarCliente.txtNumeroPrincipal');
			 return;
	}*/

//	}

	if ( get(formName + ".txtNumeroPrincipal") != "" )
	{//Cleal - MAE-005
		//alert(get(formName + ".txtNumeroPrincipal"));
//			if(fValidarNumero(get(formName + ".txtNumeroPrincipal"), 6, 0, 9999)!="OK")
			if(!sicc_validaciones_generales())
			{
				//alert("Numero invalido en txtNumeroPrincipal");
				//GestionarMensaje("405");
				focaliza("frmInsertarCliente.txtNumeroPrincipal");
				return;
			}
	}

	// Si es Direccion principal, Codigo Postal no puede ser vacío.

	/*Comentado mamontie 20/02/06 Consesuado con Gladys vs Manuel Rivas
	if (dirPrincipal.checked)  
	{
		if(get(formName + ".txtCodigoPostal")=="")		
		{
				 GestionarMensaje('1120'); 
				 focaliza('frmInsertarCliente.txtCodigoPostal');
				 return;
		}
	}*/


/*SICC-GCC-MAE-005 - Cleal
  if(get(formName + ".txtInterior") != '')
  {
    if(fValidarNumero(get(formName + ".txtInterior"), 3, 0, 999)!="OK"){
      //alert("Numero invalido en txtInterior");
      GestionarMensaje("405");
      focaliza("frmInsertarCliente.txtInterior");
      return;
    }
	}

  if(get(formName + ".txtManzana") != ''){
    if(fValidarNumero(get(formName + ".txtManzana"), 3, 0, 999)!="OK"){
      //alert("Numero invalido en txtManzana");
      GestionarMensaje("405");
      focaliza("frmInsertarCliente.txtManzana");
      return;
    }
	}

  if(get(formName + ".txtLote") != ''){
    if(fValidarNumero(get(formName + ".txtLote"), 3, 0, 999)!="OK"){
      //alert("Numero invalido en txtLote");
      GestionarMensaje("405");
      focaliza("frmInsertarCliente.txtLote");
      return;
    }
  }

  if(get(formName + ".txtKm") != ''){
    if(fValidarNumero(get(formName + ".txtKm"), 3, 0, 999)!="OK"){
      //alert("Numero invalido en txtKm");
      GestionarMensaje("405");
      focaliza("frmInsertarCliente.txtKm");
      return;
    }
  }
	*/
	// valido territorio
	var txtTerri=	get(formName + ".hidtxtTerritorio");
	var oidTerri = get(formName + ".hidOidTerritorio");
	if(oidTerri==""||txtTerri==""){
		// falta seleccionar unidad geografica
		//alert("Seleccione unidad geografica para el territorio");
		GestionarMensaje("1078");
		return;
	}

	return true;
}
//----------------------------------------------------------------------------------------------------------------------
function cargarComboIntervaloComunicacion(){
         //Los combos intervaloComunicacion tiene dos elementos: "Lunes a Viernes" y "Lunes a Domingo" 
         //(en el idioma del usuario) con los valores false y true respectivamente. 
      var lacolumna=6;// columna donde esta el combo
         var opciones = new Array();
         opciones[0]=['-1',''];
         opciones[1]=['true',GestionarMensaje('1504',null,null,null)];
		 opciones[2]=['false',GestionarMensaje('1503',null,null,null)];
         listado2.tiposCol[lacolumna][2]=opciones;
         //listado2.repinta();
}
//-----------------------------------------------------------------------
function cargarComboDiaComunicacion(){
      var lacolumna=1;// columna donde esta el combo
         var opciones = new Array();
         opciones[0]=['-','             '];
         opciones[1]=['L',GestionarMensaje('1035',null,null,null)];
         opciones[2]=['M',GestionarMensaje('1036',null,null,null)];
         opciones[3]=['I',GestionarMensaje('1037',null,null,null)];
         opciones[4]=['J',GestionarMensaje('1038',null,null,null)];
         opciones[5]=['V',GestionarMensaje('1039',null,null,null)];
         opciones[6]=['S',GestionarMensaje('1040',null,null,null)];
         opciones[7]=['D',GestionarMensaje('1034',null,null,null)];

         listado2.tiposCol[lacolumna][2]=opciones;
         //listado2.repinta();

}
//----------------------------------------------------------------------------------------------------------------------

function cambioMarca(){
          // esta funcion se llama al cambiar el combo marca.
          var comboname=window.event.srcElement.getAttribute("NAME");
          var combo=window.event.srcElement;
          var selectedValue=window.event.srcElement.getAttribute("VALUE");                 
          var sOptions=window.event.srcElement.all;                
          /* [1]var selectedOption ;
          for(var t=0;t<sOptions.length;t++){
                    if(sOptions.item(t).selected){
                              selectedOption = sOptions.item(t);
							  break;
                    }
          }[1]*/
          var option=window.event.srcElement.options;
          var tempArray = new Array();
          //tempArray[1] va a contener el indice del combo Marca seleccionado    
          tempArray = comboname.split('_');
          //esto indica si se selecciono un valor distinto de vacio
          if(selectedValue>-1){ // -1 es el value del valor '"" 
                    //verifico si estaba repetida la marca
                    var colection = document.getElementById('tblDatlistado3');
                    var combosMarca = colection.all.tags("SELECT");
                    var marcaRepetida= false;
                    for(var x=0;x<combosMarca.length;x++){
                              //veo si no es la que cambio a ver si esta repetida
                              if(selectedValue ==  combosMarca.item(x).value && tempArray[1] != x ) {// esta repetida la marca
                                         // tengo qeu seleccionar el blanco
                                         marcaRepetida=true;
                                         combo.value = '';
                                         //alert("Mensaje Marca repetida");
						     GestionarMensaje("000000000000078");
                                         break;
                              }
                    }     
                    //alert('repetido :' + marcaRepetida);
          }               
}
//---------------------------------------------------------------------------------------------------------------------------------
function seleccionarTerritorioLinea(){
	var oidTerr ;
	var strTerritorio; 
	// Selleccionamos Territorio
	var obj = new Object();
  
  obj.casoDeUso = get(formName + '.casoDeUso');
  
  
	var vWnd = mostrarModalSICC('LPSeleccionTerritorio','InsertarCliente',obj,490,518);
	if (vWnd != null && vWnd != "") {
		oidTerr = vWnd[0];

		strTerritorioOld = vWnd[1];   
		strTerritorio = vWnd[2];

//		txt_to("lblUnidadesGeograficasXX",strTerritorio);	
		txt_to("lblUnidadesGeograficasXX",strTerritorioOld);	
		
		set(formName + ".hidtxtTerritorio",strTerritorio);
		set(formName + ".hidOidTerritorio",oidTerr);
	}else{
		return false;
	}
}
//----------------------------------------------------------------------------------------------------------------------
function modificacionesGeoReferenciador(){
	if(get(formName + ".usaGeoreferenciador")=="true"){
		//	se oculta el combo tipoVia (que no se rellena) 
		//var lblTipoVia = 
		/*document.getElementById("lblTipoVia").style.visibility='hidden';
		document.getElementById("comboTipoVia").style.visibility='hidden';
	
		//	se muestran el combo nombreVia y se oculta el de via 
		document.getElementById("lblVia").style.visibility='hidden';
		document.getElementById("comboNombreVia").style.visibility='hidden';
		//	En listadoDirecciones mostramos la columna nombreVia y ocultamos via y tipoVia 	
		listado1.alternaVerColumna(2,false);
		listado1.alternaVerColumna(4,false);
*/
		// las muevo
		//en el listado mostramos la columna nombre via y ocultamos via y tipovia
           //listado1.alternaVerColumna(2,false); //Cleal
           listado1.alternaVerColumna(4,false);
           //document.all["capaComboTipoVia"].style.visibility = 'hidden';//Cleal
           //document.all["capalblTipoVia"].style.visibility = 'hidden';//Cleal
		   document.all["capaComboTipoVia"].style.visibility = 'visible';
           document.all["capalblTipoVia"].style.visibility = 'visible';

           document.all["capaTextoNombreVia"].style.visibility = 'visible';
           document.all["capalblNombreVia"].style.visibility = 'visible';
           document.all["capaComboVia"].style.visibility = 'hidden';
           document.all["capalblVia"].style.visibility = 'hidden';

	}else{
		//	se muestran el combo tipoVia y se rellenan con el atributo del mismo nombre 
		//	se muestran el comboVia, que no se cargan ahora sino que se recargará con DruidaTransaction según cambie el combo tipoVia. 
		   //en el listado ocultamos la columna nombre via y mostramos via y tipo via
           listado1.alternaVerColumna(3,false);
           document.all["capaComboTipoVia"].style.visibility = 'visible';
           document.all["capalblTipoVia"].style.visibility = 'visible';
           document.all["capaTextoNombreVia"].style.visibility = 'hidden';
           document.all["capalblNombreVia"].style.visibility = 'hidden';
           document.all["capaComboVia"].style.visibility = 'visible';
		   document.all["capalblVia"].style.visibility = 'visible';
		   accion('frmInsertarCliente.comboNombreVia', '.disabled=true'); 

	}
}

//--------------------------------------------------------------------------------------------------------------------
/*Se agrega la busqueda de via dado que cuando intenta cargar el combo con muchos registros el sistema se paraliza
mdolce 18/10/2006
*/

function buscarVia(){
	var tipoVia = get("frmInsertarCliente.comboTipoVia") ;

	if(tipoVia != ''){
		 var datos= new Object();
		 var arr = new Array();
		 arr[arr.length] = ["codigoVia", tipoVia[0]];

         datos.dto = "es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOGenBusquedaVias";
         datos.conector = "ConectorGENBusquedaProducto";
		 datos.buscarInicio = true;
		 datos.array = arr;
		 datos.esMultiple=false;
         var salida = abrirBusquedaGenerica(datos, "","0075");
         var oid = "";
         var descripcion = "";
         if(salida){
                  oid = salida[0][0];
                  descripcion = salida [0][2];
         }
         set('frmInsertarCliente.hiddenOidVia',oid);
         set('frmInsertarCliente.comboNombreVia',descripcion);	
      }
}

//--------------------------------------------------------------------------------------------------------------------
function TipoViaOnChange(){
    set("frmInsertarCliente.comboNombreVia",'');   
    set("frmInsertarCliente.hiddenOidVia",'');
}



//-------------------------------------------------------------------------------------------- 
function recolectarValoresP3(){
	//alert("recolectarValores()");
	// obtengo datos de lista 1, direcciones

	var datosLista1= new String();

	for(var x=0;x<listado1.datos.length;x++){
		datosLista1 = datosLista1 + 'h_uniGeo_' + x +  '=' + listado1.datos[x][1] + ';';
		datosLista1 = datosLista1 + 'h_textoTipoDir_' + x +  '=' + listado1.datos[x][2] + ';';

		datosLista1 = datosLista1 + 'h_comboTipoDireccion_' + x +  '=' + listado1.datos[x][13] + ';';//11
		//Cleal
		datosLista1 = datosLista1 + 'h_comboTipoVia_' + x +  '=' + listado1.datos[x][12] + ';';
		datosLista1 = datosLista1 + 'h_textTipoVia_' + x +  '=' + listado1.datos[x][3] + ';';

		//alert("h_comboTipoDireccion_: "+listado1.datos[x][11]);
        if(get('frmInsertarCliente.usaGeoreferenciador')=='true'){
			datosLista1 = datosLista1 + 'h_TextoNombreVia_' + x +  '=' + listado1.datos[x][4] + ';';
		}else{
			datosLista1 = datosLista1 + 'h_textNombreVia_' + x +  '=' + listado1.datos[x][5] + ';';
			datosLista1 = datosLista1 + 'h_comboNombreVia_' + x +  '=' + listado1.datos[x][11] + ';'; //13
		}
	      datosLista1 = datosLista1 + 'h_TextoNumeroPrincipal_' + x +  '=' + listado1.datos[x][6] + ';';
		  datosLista1 = datosLista1 + 'h_TextoCodPostal_' + x +  '=' + listado1.datos[x][7] + ';';
		  datosLista1 = datosLista1 + 'h_AreaTxtObservaciones_' + x +  '=' + listado1.datos[x][8] + ';';
		  datosLista1 = datosLista1 + 'h_RbDireccionPrincipal_' + x +  '=' + listado1.datos[x][9] + ';';
		  datosLista1 = datosLista1 + 'h_hiddenTerritorioOculto_' + x +  '=' + listado1.datos[x][10] + ';';
	}
	// obtengo datos de lista 2, comunicaciones
	var datosLista2= new String();
	listado2.actualizaDat();
	for(var x=0;x<listado2.datos.length;x++){
		datosLista2 = datosLista2 + 'h_comboTipoComunicacion_' + x +  '=' + listado2.datos[x][1] + ';';		
		datosLista2 = datosLista2 + 'h_comboDiaComunicacion_' + x +  '=' + listado2.datos[x][2] + ';';
		datosLista2 = datosLista2 + 'h_AreaTxtTextoComunicacion_' + x +  '=' + listado2.datos[x][3] + ';'; 
		datosLista2 = datosLista2 + 'h_RbComunicacionPrincipal_' + x +  '=' + listado2.datos[x][4] + ';';
		datosLista2 = datosLista2 + 'h_TextoHoraDesde_' + x +  '=' + listado2.datos[x][5] + ';';
		datosLista2 = datosLista2 + 'h_TextoHoraHasta_' + x +  '=' + listado2.datos[x][6] + ';';
		datosLista2 = datosLista2 + 'h_comboIntervaloComunicacion_' + x +  '=' + listado2.datos[x][7] + ';';
	}

	//alert(datosLista2);
	var datosLista3 = new String(); 
	var TextosValor = new String("");
	for(var xxx=0;xxx<listado3.datos.length;xxx++){
            var ComboMarca =document.getElementById("comboMarca_" + xxx);
		if(ComboMarca.SelectedIndex!=-1&&ComboMarca.value!="-1"){
			datosLista3 = datosLista3 +  'h_comboMarca_' + xxx + '=' + ComboMarca.value + ';';
	            TextosValor =TextosValor +  ComboMarca.options.item(ComboMarca.selectedIndex).innerText + "|" +ComboMarca.value + ";";
            }
	}
	
	set(formName + ".hidMarcaValor",TextosValor);
	set(formName + ".elementosP3",datosLista1 + datosLista2 + datosLista3);
	set(formName + ".hidListaDirecciones", datosLista1);
	set(formName + ".hidListaComunicacion",datosLista2);
	set(formName + ".hidListaMarca",datosLista3);
	
}
//-------------------------------------------------------------------------------------------- 
function recargarValores(){


	var datosLista1= get(formName + ".hidListaDirecciones");
	var datosLista2= get(formName + ".hidListaComunicacion");
	var datosLista3= get(formName + ".hidListaMarca");
	//alert("recargarValores(): " + datosLista1);
	var arrayDirecciones = new Array();
	if(datosLista1!=""){

		var elems = datosLista1.split(";");
		for(var x=0;x<elems.length - 1;x++){

			var items = elems[x].split("=");
			var comp = items[0];
			var valor =  items[1];
			var tempArray = comp.split("_");
			var nombre = tempArray[1];
			//alert(tempArray );
			var indic= Math.abs(tempArray[2]);

			if(arrayDirecciones[indic]==null){
				arrayDirecciones[indic] = new Array();
				arrayDirecciones[indic][0] = "cod";
				//alert("arrayDirecciones " + indic + " era null");
			}
			if(nombre == "comboTipoDireccion"){
				arrayDirecciones[indic][13] = valor; //antes 11, modificado por Sapaza, incidencia SiCC-20070039
			}else if(nombre == "TextoNombreVia"){
				arrayDirecciones[indic][4] = valor;
			}else if(nombre == "comboTipoVia"){
				arrayDirecciones[indic][12] = valor;
			}else if(nombre == "comboNombreVia"){
				arrayDirecciones[indic][11] = valor; //antes 13, modificado por Sapaza, incidencia SiCC-20070039
			}else if(nombre == "TextoNumeroPrincipal"){
				arrayDirecciones[indic][6] = valor;
			}else if(nombre == "TextoCodPostal"){
				arrayDirecciones[indic][7] = valor;
			}else if(nombre == "AreaTxtObservaciones"){
				arrayDirecciones[indic][8] = valor;//12
			}else if(nombre == "RbDireccionPrincipal"){
				arrayDirecciones[indic][9] = valor;//13
			}else if(nombre == "hiddenTerritorioOculto"){
				arrayDirecciones[indic][10] = valor;//14
			}else if(nombre == "textoTipoDir"){
				arrayDirecciones[indic][2] = valor;
			}else if(nombre == "textTipoVia"){
				arrayDirecciones[indic][3] = valor;
			}else if(nombre == "textNombreVia"){
				arrayDirecciones[indic][5] = valor;
			}else if(nombre == "uniGeo"){
				arrayDirecciones[indic][1] = valor;
			}
		}
				
		for(var j=0;j<arrayDirecciones.length;j++){
			listado1.insertar(arrayDirecciones[j],true);
		}
		listado1.repinta();
		listado1.repintaDat();
		//alert("listado1.datos: "+listado1.datos);
	}

//	alert("recolectarValores()");
	// obtengo datos de lista 1, direcicones

	var arrayComu = new Array();
	if(datosLista2!=""){
		var elems = datosLista2.split(";");
		for(var x=0;x<elems.length - 1;x++){
			var items = elems[x].split("=");
			var comp = items[0];
			var valor =  items[1];
			var tempArray = comp.split("_");
			var nombre = tempArray[1];
			//alert(tempArray );
			var indic= Math.abs(tempArray[2]);

			if(arrayComu[indic]==null){
				arrayComu[indic] = new Array();
				arrayComu[indic][0] = "cod";
				//alert("arrayComu " + indic + " era null");
			}
			if(nombre == "comboTipoComunicacion"){
				arrayComu[indic][1] = valor;
			}else if(nombre == "comboDiaComunicacion"){
				arrayComu[indic][2] = valor;
			}else if(nombre == "AreaTxtTextoComunicacion"){
				arrayComu[indic][3] = valor;
			}else if(nombre == "RbComunicacionPrincipal"){
				arrayComu[indic][4] = valor;
			}else if(nombre == "TextoHoraDesde"){
				arrayComu[indic][5] = valor;
			}else if(nombre == "TextoHoraHasta"){
				arrayComu[indic][6] = valor;
			}else if(nombre == "comboIntervaloComunicacion"){
				arrayComu[indic][7] = valor;
			}
			
		}
		for(var j=0;j<arrayComu.length;j++){
			listado2.insertar(arrayComu[j],true);
		}
		listado2.repintaDat();
		listado2.repinta();
	}

	
	var arrayMarc = new Array();
	if(datosLista3!=""){
		var elems = datosLista3.split(";");
		for(var x=0;x<elems.length - 1;x++){
			var items = elems[x].split("=");
			var comp = items[0];
			var valor =  items[1];
			var tempArray = comp.split("_");
			var nombre = tempArray[1];
			//alert(tempArray );
			var indic= Math.abs(tempArray[2]);

			if(arrayMarc[indic]==null){
				arrayMarc[indic] = new Array();
				arrayMarc[indic][0] = "cod";
				//alert("arrayMarc " + indic + " era null");
			}
			if(nombre == "comboMarca"){
				arrayMarc[indic][1] = valor;
			}
		}
		listado3.datos = new Array();
		for(var j=0;j<arrayMarc.length;j++){
			listado3.insertar(arrayMarc[j],true);
		}
		listado3.repintaDat();
		listado3.repinta();
	}
/*

	

	//alert(datosLista2);
	var datosLista3 = new String(); 
	var TextosValor = new String("");
	for(var xxx=0;xxx<listado3.datos.length;xxx++){
            var ComboMarca =document.getElementById("comboMarca_" + xxx);
		if(ComboMarca.SelectedIndex!=-1&&ComboMarca.value!="-1"){
			datosLista3 = datosLista3 +  'h_comboMarca_' + xxx + '=' + ComboMarca.value + ';';
	            TextosValor =TextosValor +  ComboMarca.options.item(ComboMarca.selectedIndex).innerText + "|" +ComboMarca.value + ";";
            }
	}*/
}
//----------------------------------------------------------------------------------------------------------------------

function seteaListas()
{
		var dirIni = new Date();
		seteaListaDir();
		var dirFin = new Date();

		var comuIni = new Date();
		seteaListaComunicacion();
		var comuFin = new Date();

		var marcaIni = new Date();
		seteaListaMarcas();
		var marcaFin = new Date();

/*		var cadenaAlert = "Lista Direccion: " + (dirFin.getTime() - dirIni.getTime()) + " milisegundos\n";
		cadenaAlert = cadenaAlert + "Lista Comunicacion: " + (comuFin.getTime() - comuIni.getTime()) + " milisegundos\n";
		cadenaAlert = cadenaAlert + "Lista Marca: " + (marcaFin.getTime() - marcaIni.getTime()) + " milisegundos";
		alert(cadenaAlert);*/

}


function seteaListaComunicacion()
{
		// Setea la lista comunicacion de acuerdo a la cadena que se forma en la LP.
		var cadenaComm = get("frmInsertarCliente.hidListaComunicacion");


		if (cadenaComm != "")
		{
				var lineas = cadenaComm.split("|");

				var lineToInsert = new Array();
				var linea = "";

				for (var i = 0; i < lineas.length; i++)
				{
						lineToInsert = new Array();
						linea = lineas[i].split(";");
						lineToInsert[0] = linea[0];
						lineToInsert[1] = linea[1];
						lineToInsert[2] = linea[2];
						lineToInsert[3] = linea[3];

						if (linea[4] == "true")
								lineToInsert[4] = "S";
						else
								lineToInsert[4] = "N";

						lineToInsert[5] = linea[5];
						lineToInsert[6] = linea[6];
						lineToInsert[7] = linea[7];

						listado2.insertar(lineToInsert,true);
				}
				listado2.repinta();

		}

}

// -------------------------------------------------------------------------------------------

function seteaListaMarcas() {
    // Setea la lista Marcas de acuerdo a la cadena que se forma en la LP.
	// Primero borra la fila existente vacía.
	// Solo se utiliza para CU Modificar

	var cadenaMarca = get("frmInsertarCliente.hidListaMarca");
	if ( cadenaMarca != "") {
		/*var nuevosDatos = new Array();
		listado3.setDatos(nuevosDatos);*/

		listado3.datos = new Array();
		
		// Ahora sí seteo Marcas. 
		var lineas = cadenaMarca.split("|");
		var lineToInsert = new Array();
		var linea = "";

		for (var i = 0; i < lineas.length; i++) {
		    lineToInsert = new Array();
			linea = lineas[i].split(";");

			lineToInsert[0] = linea[0];
			lineToInsert[1] = linea[1];

			listado3.insertar(lineToInsert,true);
		}
		listado3.repinta();
	} else {
		// El cliente no tenia ninguna marca
		listado3.datos[0][0] = "g";  // Inicializo la primera marca que debe guardarse
	}

}

// -------------------------------------------------------------------------------------------
function seteaListaDir()
{
		var cadenaDir = get("frmInsertarCliente.hidListaDirecciones");
		//alert("cadenDir: " + cadenaDir);
		
		if ( cadenaDir  != "")
		{

				var lineas = cadenaDir.split("|");

				var lineToInsert = new Array();
				var linea = "";
				var si = GestionarMensaje("84");
				var no = GestionarMensaje("86");

				for ( var i = 0; i < lineas.length; i++)
				{		
						
						lineToInsert = new Array();
						linea = lineas[i].split(";");

						lineToInsert[0] = linea[0];
						//alert("linea[0]: "+ linea[0]);

						lineToInsert[1] = linea[1];
						//alert("linea[1]: "+ linea[1]);

						lineToInsert[2] = linea[2];
						//alert("linea[2]: "+ linea[2]);

						lineToInsert[3] = linea[3];
						//alert("linea[3]: "+ linea[3]);

						lineToInsert[4] = linea[4];
						//alert("linea[4]: "+ linea[4]);

						//alert("linea[5]: "+ linea[5]);
						lineToInsert[5] = linea[5];

						lineToInsert[6] = linea[6];
						//alert("linea[6]: "+ linea[6]);

						lineToInsert[7] = linea[7];
						//alert("linea[7]: "+ linea[7]);

						lineToInsert[8] = linea[8];
						//alert("linea[8]: "+ linea[8]);

						//lineToInsert[9] = linea[9];
						//alert("linea[9]: "+ linea[9]);
						if (linea[9] == "true")
							lineToInsert[9] = si
						else
							lineToInsert[9] = no


						lineToInsert[10] = linea[10];
						//alert("linea[10]: "+ linea[10]);
						lineToInsert[11] = linea[11];
						//alert("linea[11]: "+ linea[11]);

						lineToInsert[12] = linea[12];
						//alert("linea[12]: "+ linea[12]);
						/*
						if (linea[13] == "true")
							lineToInsert[13] = si
						else
							lineToInsert[13] = no*/
						lineToInsert[13] = linea[13];
						//alert("linea[13]: "+ linea[13]);
						/*
						lineToInsert[14] = linea[14];
						lineToInsert[15] = linea[15];
						lineToInsert[16] = linea[16];		
						lineToInsert[17] = linea[17];*/

						listado1.insertar(lineToInsert,true);
				}
				listado1.repinta();

			}

			poneDescripcionDirecciones();

		

}

// -------------------------------------------------------------------------------------------
function elementosToDel(lista)
{

		// Devuelve un array con los elementos a eliminar en la base de datos. 
		// Aquellos elementos que loguea son los que tienen distinto de "g" en su codigo oculto
		// (recordar que "g" es para filas generadas en el momento x el usuario, que todavia no 
		// tienen correspondencia en la base de datos).

		var elementosBorrar = new Array();
		var elemSeleccionados = lista.codSeleccionados();



		for (var i = 0; i < elemSeleccionados.length; i++)
		{
				if (elemSeleccionados[i] != "g")
					elementosBorrar[i] = elemSeleccionados[i];
		}



		return elementosBorrar;

}

// -------------------------------------------------------------------------------------------
function obtenerDatosTablas(nombreTabla, cantCols)
{
	//alert("obtenerDatosTablas()");

		// Obtiene los datos existentes en las tres tablas, y 
		// los guarda en las variables de form. correspondientes.

		var cadena; 
		var datosLista = eval(nombreTabla + ".datos;");
		//alert("datosLista: "+datosLista);

		var si = GestionarMensaje("84");
		var no = GestionarMensaje("86");

		listado2.actualizaDat();
		listado3.actualizaDat();
		var cadena = "";

		for ( var i = 0; i<datosLista.length; i++)
		{
				if ( i != 0)
						cadena	= cadena + "|";

				for ( var j = 0; j < parseInt(cantCols, 10); j++)
				{

					if ( datosLista[i][j] == si )
						cadena = cadena + "true";
					else if (datosLista[i][j] == no)
						cadena = cadena + "false";
					else if ( datosLista[i][j] == "")
						cadena = cadena + " ";
					else
						cadena = cadena + datosLista[i][j];

					if ( j != (parseInt(cantCols, 10) - 1) )
						cadena = cadena + ";";

				}

		}


		if (nombreTabla == "listado1"){
				set("frmInsertarCliente.hidListaDirecciones", cadena);
				//alert("cadena: "+cadena);
			}
		else if (nombreTabla == "listado2")
				set("frmInsertarCliente.hidListaComunicacion", cadena);
		else if (nombreTabla == "listado3")
				set("frmInsertarCliente.hidListaMarca", cadena);



}


// -------------------------------------------------------------------------------------------
function validaTipoDirecciones()
{
	// Chequea si hay dos tipos de direcciones iguales. en cuyo caso tira un error. 

	var datosListaDireccion = listado1.datos;
	var arrayTipos = new Array();
	var n = 0;

	if (datosListaDireccion.length > 1 )
	{
			for ( var i = 0; i < datosListaDireccion.length; i++)
			{
					var tipo = datosListaDireccion[i][13]; //cleal - 15
					//alert("Tipo de direccion en linea " + i + ": " + tipo);

					// Recorre arrayTipos buscando coincidencia. 
					for (var j = 0; j < arrayTipos.length; j++)
					{
							if ( arrayTipos[j] == tipo)
							{
										GestionarMensaje("1103", null, null, null);
										//alert("No puede haber mas de una dirección de un mismo tipo");									
										return false;
							}

					}

					// Como no se encontro match, se agrega ese tipo al array.
					arrayTipos[n++] = tipo;
			}

    }
 	 return true;

}

// -------------------------------------------------------------------------------------------

function duplicaArray(param)
{
	var valorToReturn = new Array();
	if ( param != "")
	{
		var cantFilas = param.length;
		var cantCols = param[0].length;

		for (var i = 0; i < cantFilas; i++)
		{
			var nuevaFila = new Array();
			for (var j = 0; j < cantCols; j++)
			{	
				var dato = param[i][j];
				nuevaFila[j] = dato;
			}
			valorToReturn[i] = nuevaFila;
		}
	}
	return valorToReturn;

}

// -------------------------------------------------------------------------------------------
function fLimpiar(){
 casoDeUso = get('frmInsertarCliente.casoDeUso');
   if(casoDeUso == 'ModificarCliente'){
      //alert('entro en limpiar modificar');

      set('frmInsertarCliente.hidPestanya', '0'); 
      set('frmInsertarCliente.hPestanya', '-1');
      set('frmInsertarCliente.dtoOid', get('frmInsertarCliente.hiddenOid'));
      //alert('el oid ' + get('frmInsertarCliente.hiddenOid'))
      set('frmInsertarCliente.hidCodigoCliente', get('frmInsertarCliente.hiddenCodigo'));
    //  alert('el codigo es '+  get('frmInsertarCliente.hiddenCodigo'));
      set('frmInsertarCliente.accion', '');
      set('frmInsertarCliente.conectorAction', 'LPModificarCliente');
      enviaSICC('frmInsertarCliente', '', '', 'N');
    }else{ 
      listado1.setDatos(lista1Limpiar);
      listado2.setDatos(lista2Limpiar);
      listado3.setDatos(lista3Limpiar);

      lista1Limpiar = duplicaArray(lista1Limpiar);
      lista2Limpiar = duplicaArray(lista2Limpiar);
      lista3Limpiar = duplicaArray(lista3Limpiar);
    }
}

// -------------------------------------------------------------------------------------------
function seteaVarsLimpiar()
{
		// Llena las variables de listas que se usan para el limpiar (para inc. 4904)
		// by ssantana

		lista1Limpiar = duplicaArray(listado1.datos);
		lista2Limpiar = duplicaArray(listado2.datos);
		lista3Limpiar = duplicaArray(listado3.datos);

}

// -------------------------------------------------------------------------------------------
function poneDescripcionDirecciones()
{
		// by Ssantana
		var datosLista = listado1.datos;

		if ( datosLista.length > 0 )
		{
					for (var i = 0; i < datosLista.length; i++)
					{


						var valorDireccion = datosLista[i][2]; 
						var valorVia = datosLista[i][3]; 

						var descDireccion =  obtieneDescCombo("frmInsertarCliente.comboTipoDireccion", valorDireccion); 
						var descVia =  obtieneDescCombo("frmInsertarCliente.comboTipoVia", valorVia ); 

						if (descDireccion != "")  // En caso de que no se haya encontrado match (no deberia pasar, pero......)
							datosLista[i][2] = descDireccion;

						if ( descVia != "")   // Idem anterior, pero para via.
							datosLista[i][3] = descVia;

					}
					//listado1.setDatos(datosLista);
					listado1.datos = datosLista;
					listado1.repinta();
		}

}

// -------------------------------------------------------------------------------------------
function obtieneDescCombo(combo, codigo)
{
		// Obtiene descripcion de combo

		var longCombo = combo_get(combo, "L", "");
		var i = 0; 
		var match = false;
		var desc = "";
		while ( (match == false) && (i < longCombo) )
		{

			  if ( combo_get(combo, "V", i)  ==codigo )
			  {
					// Match 
					match = true;
					desc = combo_get(combo, "T", i);
					return desc;
			  }
			  i++;
		}

		return desc;

}

// -------------------------------------------------------------------------------------------------------------------------------------
function validaFormatoHora(hora)
{
		// Valida hora con el formato establecido para la hora: HH:mm (Hora de 0 a 23, min de 00 a 59, ":" separa ambos numeros)
		var horaArray = hora.split(":");

		if (horaArray.length != 2)
			return false;

		// ------------------------- Hora ------------------------------------------------------------------------------------
		// Valida que hora sea un numero y de 1 o 2 digitos.
		if (esNumero(horaArray[0]) == -1 || (horaArray[0].length != 1 && horaArray[0].length != 2))
			return false;

		// Valida que hora este entre 0 y 23
		if ( parseInt(horaArray[0], 10) > 23 )
					return false;

		// ---------------------------------- Minutos ----------------------------------------------------
		// Valida que minuto sea numerico y tenga 2 digitos siempre
		if ( esNumero(horaArray[1]) == -1 || horaArray[1].length != 2)
					return false;

		// Valida que minuto este entre 0 y 59
		if ( parseInt(horaArray[1], 10) > 59 )
					return false;

		return true;

}

/* ------------------------------------------------------------------------------------------------------------------------------------------------- */
function ensanchaListas() {
	DrdEnsanchaConMargenDcho('listado1',12);
	DrdEnsanchaConMargenDcho('listado2',12);	    
	DrdEnsanchaConMargenDcho('listado3',12);
	eval (ON_RSZ);  
}


// -------------------------------------------------------------------------------------------------------------------------------------
function listaToXML(lista) {
	var xmlDoc = "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?>";
	xmlDoc = xmlDoc + "<DOC>";
	var datos = eval(lista).datos;
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
			xmlDoc = xmlDoc + "<CAMPO>" + SICC_DrdEscXML(campo) + "</CAMPO>";
		}
		xmlDoc = xmlDoc + "</ROW>"
	}
	xmlDoc = xmlDoc + "</DOC>";

	return xmlDoc; 
}
/* ------------------------------------------------------------------------------------------------------------------------------------------ */
function setTipoDireccionDefecto(){
	set( formName +".comboTipoDireccion", [ get( formName +".valDefTipoDirr" ) ]);
}
/* ------------------------------------------------------------------------------------------------------------------------------------------ */
// El iColumna es para el tipo de Dato, y es uno menor que la columna de datos. ( por no tener tipo para la columna del oid )
function setComboValorDefecto( iFila, iColumna, descDefecto){
	var listado1 = getLista(2);
	var combo = listado1.tiposCol[iColumna][2];
	for( var i = 0; i < combo.length; i++ ){
		if ( combo[i][1] == descDefecto ){
			listado1.datos[iFila][iColumna+1] = combo[i][0];
		}
	}
	listado1.repinta();
}