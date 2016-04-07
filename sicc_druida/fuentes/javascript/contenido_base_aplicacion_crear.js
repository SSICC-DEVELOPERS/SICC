var arrLimpia = new Array();
var btnBuscarHab = 'S';

var vBADM = 'N'; // Inicialmente No esta habilitado
var vBADUN= 'N';
var vBADN = 'N';
var vBADSG= 'N';
var vBADG = 'N';     
 
var arrComboTipoOferta;
var arrComboCicloVida ;

function onLoadPag() {     

	guardoConExito();
	DrdEnsanchaConMargenDcho('listado1',24);
	document.all["Cplistado1"].style.visibility='';
	document.all["CpLin1listado1"].style.visibility='';
	document.all["CpLin2listado1"].style.visibility='';
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';
	document.all["separaDiv"].style.visibility='hidden';
	document.all["primera1Div"].style.visibility='hidden';
	document.all["ret1Div"].style.visibility='hidden';
	document.all["ava1Div"].style.visibility='hidden';
	document.all["btnBuscarDiv"].style.visibility='';
	document.all["btnEliminarDiv"].style.visibility='';

	DrdEnsanchaConMargenDcho('listado2',12);
	document.all["Cplistado2"].style.visibility='';
	document.all["CpLin1listado2"].style.visibility='';
	document.all["CpLin2listado2"].style.visibility='';
	document.all["CpLin3listado2"].style.visibility='';
	document.all["CpLin4listado2"].style.visibility='';
	document.all["separa2Div"].style.visibility='hidden';
	document.all["primera2Div"].style.visibility='hidden';
	document.all["ret2Div"].style.visibility='hidden';
	document.all["ava2Div"].style.visibility='hidden';
	document.all["btnEliminar2Div"].style.visibility='';

	DrdEnsanchaConMargenDcho('listado3',24);
	document.all["Cplistado3"].style.visibility='';
	document.all["CpLin1listado3"].style.visibility='';
	document.all["CpLin2listado3"].style.visibility='';
	document.all["CpLin3listado3"].style.visibility='';
	document.all["CpLin4listado3"].style.visibility='';
	document.all["separa3Div"].style.visibility='hidden';
	document.all["primera3Div"].style.visibility='hidden';
	document.all["ret3Div"].style.visibility='hidden';
	document.all["ava3Div"].style.visibility='hidden';
	document.all["btnAnadir3Div"].style.visibility='';
	document.all["btnEliminar3Div"].style.visibility='';
	eval (ON_RSZ);  
	set("formulario.secuencia","1");

	configurarMenuSecundario('formulario');
	fMostrarMensajeError();
	seteaValoresMatriz();
	document.getElementById("InsertarP5").style.backgroundColor = "#496A9A";
	document.getElementById("InsertarP5").style.color = "#FFFFFF";      
	btnProxy(2,"1");
	
	if (get('formulario.casoDeUso') == 'consultar' || get('formulario.casoDeUso') == 'modificar') {
		var varNoLimpiarSICC = true;
		seleccionaComponenetes();
		if (get('formulario.casoDeUso') == 'modificar' ) {
			deshabilitarHabilitarBoton('botonContenido','btnSiguiente','D');
		}
	} else if (get('formulario.casoDeUso') == 'insertar' ) {
        deshabilitarHabilitarBoton('botonContenido','btnSiguiente','D');
		set("formulario.cbTipoOferta",0);
		set("formulario.cbCicloVida",0);
	}

	tomarDatosPagina();

	if(get("formulario.VisibleBADM")=="S"){
		vBADM = 'S';
	}
	if(get("formulario.VisibleBADUN")=="S"){
		accion("formulario.cbUnidadNegocio",".disabled=true");
		vBADUN = 'S';
	}
	if(get("formulario.VisibleBADN")=="S"){
		accion("formulario.cbNegocio",".disabled=true");
		vBADN = 'S';
	}    
	if(get("formulario.VisibleBADG")=="S")	{
		accion("formulario.cbGenerico",".disabled=true");
		vBADG = 'S';
	}    
	if(get("formulario.VisibleBADSG")=="S")	{
		accion("formulario.cbSupergenerico",".disabled=true");
		vBADSG = 'S';
	}    
	if ( get('formulario.casoDeUso')!='consultar')
		validaBotonBuscar();    

	marcaOnChange();
	if (get('formulario.casoDeUso') == 'consultar')	{
		configuraPagina();
		//focalizaBotonHTML('botonContenido','btnSiguiente');
	}

	if (get('formulario.casoDeUso') != 'consultar')	{
		if(get("formulario.VisibleBADM")=="S")
			focaliza("formulario.cbMarca");
		else if(get("formulario.VisibleBADUN")=="S")
			focaliza("formulario.cbUnidadNegocio");
		else if(get("formulario.VisibleBADN")=="S")
			focaliza("formulario.cbNegocio");               
		else if(get("formulario.VisibleBADSG")=="S")
            focaliza("formulario.cbSupergenerico");
        else if(get("formulario.VisibleBADG")=="S")
			focaliza("formulario.cbGenerico");
		else            
			focaliza("formulario.ExclusionTipoOferta");
	}    

	var varNoLimpiarSICC = true;
	focoInicio();
}

function seleccionaComponenetes(){
	set("formulario.cbMarca",new Array(get("formulario.hidMarcasSel")));
	set("formulario.cbUnidadNegocio",new Array(get("formulario.hidUniNegSel")));
	set("formulario.cbNegocio",new Array(get("formulario.hidNegocioSel")));
	set("formulario.cbSupergenerico",new Array(get("formulario.hidSuperGenericoSel")));
	set("formulario.cbGenerico",new Array(get("formulario.hidGenericoSel")));
	//set("formulario.ExclusionTipoOferta",get("formulario.hidETO"));
	if(get("formulario.hidETO")=="true") 
		set("formulario.ExclusionTipoOferta","S");
	else 
		set("formulario.ExclusionTipoOferta","N");

	var selTO = get("formulario.selTipoOferta"); 
	selTO = selTO.split(",");
	set("formulario.cbTipoOferta",selTO);
	var selCV = get("formulario.selCicloVida");
	selCV = selCV.split(",");
	set("formulario.cbCicloVida",selCV);
}

function seteaValoresMatriz(){    		
	//marca
	//set("formulario.VisibleBADM", "N");

	if(get("formulario.VisibleBADM")=="N"){
		document.getElementById("lblMarca").style.visibility='hidden';        
		document.getElementById("cbMarca").style.visibility='hidden';        
	}
	if(get("formulario.ObligatorioBADM")=="S")
		sicc_cambiar_estado("cbMarca",true);    
	if(get("formulario.ModificableBADM")=="N")
		accion("formulario.cbMarca",".disabled=true");
    
	//unidad de negocio
	if(get("formulario.VisibleBADUN")=="N"){ 
		document.getElementById("lblUnidadNegocio").style.visibility='hidden';        
		document.getElementById("cbUnidadNegocio").style.visibility='hidden';        
	}        
	if(get("formulario.ObligatorioBADUN")=="S") 
		sicc_cambiar_estado("cbUnidadNegocio",true);        

	if(get("formulario.ModificableBADUN")=="N") 
		accion("formulario.cbUnidadNegocio",".disabled=true");    

	//negocio
	if(get("formulario.VisibleBADN")=="N"){
		document.getElementById("lblNegocio").style.visibility='hidden';        
		document.getElementById("cbNegocio").style.visibility='hidden';        
	}        
	if(get("formulario.ObligatorioBADN")=="S")
		sicc_cambiar_estado("cbNegocio",true);        
	if(get("formulario.ModificableBADN")=="N")
		accion("formulario.cbNegocio",".disabled=true");    
    
	//super generico
	if(get("formulario.VisibleBADSG")=="N"){
		document.getElementById("lblSupergenerico").style.visibility='hidden';        
		document.getElementById("cbSupergenerico").style.visibility='hidden';        
	}        
	if(get("formulario.ObligatorioBADSG")=="S") 
		sicc_cambiar_estado("cbSupergenerico",true);    
	if(get("formulario.ModificableBADSG")=="N")
		accion("formulario.cbSupergenerico",".disabled=true");
    
	//generico
	if(get("formulario.VisibleBADG")=="N"){ 
		document.getElementById("lblGenerico").style.visibility='hidden';        
		document.getElementById("cbGenerico").style.visibility='hidden';        
	}        
	if(get("formulario.ObligatorioBADG")=="S") 
		sicc_cambiar_estado("cbGenerico",true);    
	if(get("formulario.ModificableBADG")=="N")
		accion("formulario.cbGenerico",".disabled=true");

}

function accionBuscarProductos() {

	if (!validaExclusion()){
		GestionarMensaje(1394,null,null,null);
		return false;
	}

	var obj = new Object();
	obj.oidMarcaCorporativa = get('formulario.oidMarcaCorporativa');
	var whnd = mostrarModalSICC('LPBuscarProductosDTO','',obj,null, 570);

	if(whnd!=null){
		accion("formulario.cbMarca",".disabled=false");
		accion("formulario.cbUnidadNegocio",".disabled=false");
		accion("formulario.cbNegocio",".disabled=false");
		accion("formulario.cbGenerico",".disabled=false");
		accion("formulario.cbSupergenerico",".disabled=false");

		actualizaListado(whnd[0]);

		if (whnd[1] != '' && whnd[1] != null ){//Marca
			set('formulario.cbMarca',whnd[1]);
		}
    
		if (whnd[2] != '' && whnd[2] != null ){ //Unidad De Negocio
			set('formulario.cbUnidadNegocio',whnd[2]);
		}

		/*
		accion("formulario.cbMarca",".disabled=true");
		accion("formulario.cbUnidadNegocio",".disabled=true");
		accion("formulario.cbNegocio",".disabled=true");
		accion("formulario.cbGenerico",".disabled=true");
		accion("formulario.cbSupergenerico",".disabled=true");   
		*/
		if(get("formulario.VisibleBADM")=="S")
			accion("formulario.cbMarca",".disabled=false");
		if(get("formulario.VisibleBADUN")=="S")
			accion("formulario.cbUnidadNegocio",".disabled=true");
		if(get("formulario.VisibleBADN")=="S")
			accion("formulario.cbNegocio",".disabled=true");
		if(get("formulario.VisibleBADG")=="S")                
			accion("formulario.cbGenerico",".disabled=true");
		if(get("formulario.VisibleBADSG")=="S")
			accion("formulario.cbSupergenerico",".disabled=true");
    
	}
}

function actualizaListado(listaItems){
	var fila = listaItems.split('$');
	for(i=0;i<fila.length;i++){
		if (fila[i] != ''){
			var newRow = new Array();
			newRow = fila[i].split("|");
			listado1.insertar(newRow);
		}
	}
}

    
function accionEliminar(listado) {

	if(listado == '1'){
		var vMostrarMensaje ='';
		var cantElementosL1 = listado1.codSeleccionados();		
		if ( cantElementosL1.length == 0){
			GestionarMensaje("4", null, null, null);
			return;
		}
		if ( cantElementosL1.length > 0 )
			listado1.eliminarSelecc();
	} else {
		var vMostrarMensaje ='';
		var cantElementosL3 = listado2.codSeleccionados();		
		if ( cantElementosL3.length == 0){
			GestionarMensaje("4", null, null, null);
			return;
		}
		if ( cantElementosL3.length > 0 ) {
			listado2.eliminarSelecc();

			if(get("formulario.VisibleBADM")=="S")
				accion("formulario.cbMarca",".disabled=false");
			
			if(get("formulario.VisibleBADUN")=="S")
				accion("formulario.cbUnidadNegocio",".disabled=false");

			if(get("formulario.VisibleBADN")=="S")
				accion("formulario.cbNegocio",".disabled=false");                

			if(get("formulario.VisibleBADG")=="S")                
				accion("formulario.cbGenerico",".disabled=false");
		    
			if(get("formulario.VisibleBADSG")=="S")
				accion("formulario.cbSupergenerico",".disabled=false");

            if((btnBuscarHab =='N') && (get("formulario.VisibleBADP") == 'S') && (get("formulario.ModificableBADP") == 'S')) {
			    deshabilitarHabilitarBoton('botonContenido','btnBuscar','A');
			    btnBuscarHab ='S';
			}
		}    
	}
  }

function accionEliminar2() {
	var vMostrarMensaje ='';
	var cantElementosL1 = listado3.codSeleccionados();		
	if ( cantElementosL1.length == 0){
		GestionarMensaje("4", null, null, null);
		return;
	}
	if ( cantElementosL1.length > 0 )
		listado3.eliminarSelecc();
}

function accionAnadirEscala()  {
	var obj = new Object();
	var whnd = mostrarModalSICC('LPMantenimientoBaseAplicacion','aniadirEscala',obj,null, 200);
	if(whnd!=null){
		if (validaEscalas(cdos_trim(whnd[0]),cdos_trim(whnd[1])) == true){
			var posi = parseInt(get('formulario.secuencia'), 10);
			var codigo = listado3.generaCodigo( posi );
			set('formulario.secuencia', codigo);
			
			/*var wh = codigo + "|" + whnd;
			var newRow = new Array();
			newRow = wh.split("|");    
			listado3.insertar(newRow);*/


			var colOcu = whnd[0];
			var entero = colOcu.split(".");
			var largo = entero[0].length;
			var largomax = '16';
			if (largo < largomax) {
				var diferencia = largomax - largo;
				var ceros = '';
				for (var i=0; i<diferencia;i++) {
					ceros += '0'; 
				}
				var colOcu = ceros + colOcu;
			}
			
			var datos = codigo + "|" + whnd[0] + "|" +  whnd[1] +  "|" +  whnd[2] + "|" + colOcu;
			var newRow = new Array();
			newRow = datos.split("|");
			listado3.insertar(newRow);
			listado3.ordenaPorColumna(3);
		
			var cod = listado3.codigos();
			var pri = listado3.extraeDato(cod[0],3);
			//var j = cod.length;
			var ult = listado3.extraeDato(cod[cod.length-1],3);
			if(pri>ult){
				listado3.ordenaPorColumna(3);
			}

		}
	}
}

function accionOtraBase() {
	if(accionValidacion()){//Llamar a la LPMantenimientoBaseAplicacion con accion = "guardarBaseAplicacion"
		if(validacion()) {
			tomaValoresListaCriterios();
			set('formulario.conectorAction', 'LPMantenimientoBaseAplicacion');
			set('formulario.accion', 'otraBase');
			enviaSICC('formulario');
		}
	}
}

function fGuardar(){
	accionGuardar();
}


function accionGuardar()  {
	//Llamar a la LPMantenimientoBaseAplicacion con accion = "guardarBaseAplicacion"
	if(accionValidacion()){
		if(validacion()){
			tomaValoresListaCriterios()
			set('formulario.conectorAction', 'LPMantenimientoBaseAplicacion');
			set('formulario.casoDeUso', get('formulario.casoDeUso'));
			//eval('formulario').oculto="S"; 
			set('formulario.accion', 'guardarBaseAplicacion');              
			enviaSICC('formulario');
		}
	}
}

function accionValidacion() {
	if(sicc_validaciones_generales()) {
		return true;
	} else 
		return false;    
}
	 
function accionAniadir() {
	var vExcluyeTipoOfe = get('formulario.ExclusionTipoOferta');
	var vTipoOfertaSel  = get('formulario.cbTipoOferta');

	var vCicloVidaSel   = get('formulario.cbCicloVida');

	if (vCicloVidaSel =='' || vCicloVidaSel == null) {
		GestionarMensaje('1201','Ciclo de Vida');
		focaliza('formulario.cbCicloVida');
		return false;
	}    
    
	//if (vExcluyeTipoOfe == 'S' ) ver DECU
	if (vExcluyeTipoOfe == 'N' ) {
		if(vTipoOfertaSel =='' || vTipoOfertaSel == null) {
			GestionarMensaje('1415');
			focaliza('formulario.cbTipoOferta');
			return false;
		}
	}

	var codigo = listado1.codigos();
	if( codigo.length > 0  )
		armaCriterioDeProductos();
	else
		armaCriterioBloqueUno();
}
		

function pasaListaTemporal(codigo, dato){
	var codigosTemporal = listado2.codigos();
	var match = rowMatch(codigo, codigosTemporal);
	if (match){
		//muestraMsg = true;
	} else {
		var dat = verificoCampos();
		//datos = codigo + "|" + dat + "|" + datos;  // Agrega el codigo al String de valores. 
		datos = codigo;
		datos = datos + "|";    //oidMarca
		datos = datos + "|";
		datos = datos + "|";
		datos = datos + "|";    //oidUnidadNegocio
		datos = datos + "|";
		datos = datos + "|";    //oidNegocio
		datos = datos + "|";
		datos = datos + "|";    //oidSupergenerico
		datos = datos + "|";
		datos = datos + "|";    //oidGenerico
		datos = datos + "|" + dat;  
		datos = datos + "|" + dato;
				
		var newRow = new Array();
		newRow = datos.split("|");

		listado2.insertar(newRow);
	}
}
		

function armaCriterioBloqueUno() {

	var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);
	var codigo = listado2.generaCodigo( posi );

	set('formulario.hidUltimoElementoEnLaLista', codigo);

	// ------------- Toma de datos -----------------
	var oidMarSel       = get('formulario.cbMarca','V');
	var desMarSel       = get('formulario.cbMarca','T');

	var oidUnidNegSel   = get('formulario.cbUnidadNegocio','V');
	var desUnidNegSel   = get('formulario.cbUnidadNegocio','T');

	var oidNegSel       = get('formulario.cbNegocio','V');
	var desNegSel       = get('formulario.cbNegocio','T');

	var oidSuperGenSel  = get('formulario.cbSupergenerico','V');
	var desSuperGenSel  = get('formulario.cbSupergenerico','T');

	var oidGenSel       = get('formulario.cbGenerico','V');
	var desGenSel       = get('formulario.cbGenerico','T');

	var vExcluyeTipoOfe = get('formulario.ExclusionTipoOferta');

	var vTipoOfertaSel  = get('formulario.cbTipoOferta');
	var vCicloVidaSel   = get('formulario.cbCicloVida');
			
	var oidT       = get('formulario.cbTipoOferta','V');
	var desT       = get('formulario.cbTipoOferta','T');
	var oidC       = get('formulario.cbCicloVida','V');
	var desC       = get('formulario.cbCicloVida','T'); 


	var vTope;

	if(vExcluyeTipoOfe =='N' && vTipoOfertaSel.length == 0){
		vTope = 1;
	} else {
		vTope = vTipoOfertaSel.length;
	}

	//pzerbino
	//INCIDENCIA DBLG500000604
	if(vExcluyeTipoOfe=='S' && vTope==0){

		for (var j = 0; j < vCicloVidaSel.length; j++){

			if (oidC[j] != '' && oidC[j] !=null ){

				var datos = codigo + "|" + oidMarSel + "|" + desMarSel;
				datos = datos + "|" + oidUnidNegSel + "|" + desUnidNegSel;
				datos = datos + "|" + oidNegSel + "|" + desNegSel;
				datos = datos + "|" + oidSuperGenSel + "|" + desSuperGenSel;
				datos = datos + "|" + oidGenSel + "|" + desGenSel + "|" + vExcluyeTipoOfe;
				datos = datos + "|" + '' + "|" + '';

				var oidCicloVida       = oidC[j];
				var desCicloVida       = desC[j];
				datos = datos + "|" + oidCicloVida + "|" + desCicloVida+ "|" +''+ "|" +'';

				if (!existeFilaCriterio(datos)){
					var newRow = new Array();
					newRow = datos.split("|");
					listado2.insertar(newRow);
					codigo = listado2.generaCodigo(codigo);
				}
			}
		}

	} else {

		for (var i = 0; i < vTope; i++){

			var oidTipoOferta       = oidT[i];
			var desTipoOferta       = desT[i];

			for (var j = 0; j < vCicloVidaSel.length; j++){

				if (oidC[j] != '' && oidC[j] !=null ) {
					var datos = codigo + "|" + oidMarSel + "|" + desMarSel;
					datos = datos + "|" + oidUnidNegSel + "|" + desUnidNegSel;
					datos = datos + "|" + oidNegSel + "|" + desNegSel;
					datos = datos + "|" + oidSuperGenSel + "|" + desSuperGenSel;
					datos = datos + "|" + oidGenSel + "|" + desGenSel + "|" + vExcluyeTipoOfe;

					if (oidTipoOferta != null)
						datos = datos + "|" + oidTipoOferta + "|" + desTipoOferta;
					else
						datos = datos + "|" + '' + "|" + '';

					var oidCicloVida       = oidC[j];
					var desCicloVida       = desC[j];
					datos = datos + "|" + oidCicloVida + "|" + desCicloVida+ "|" +''+ "|" +'';

					if (!existeFilaCriterio(datos)){
						var newRow = new Array();
						newRow = datos.split("|");
						listado2.insertar(newRow);
						codigo = listado2.generaCodigo(codigo);
					}
				}
			}
		}
	}

	var codigo = listado2.codigos();
	//alert("codigos del listado dps de ingresar una fila: " + codigo);

	set('formulario.hidUltimoElementoEnLaLista', codigo);

}
    
function existeFilaCriterio(datos){
	var codigo = listado2.codigos();
	var newRow = new Array();
	newRow = datos.split("|");
	var flag = false;
	var a = 0;

	while( (a < codigo.length ) && (flag == false) ){
	    if( newRow[1] ==listado2.extraeDato(codigo[a], 0)!="") {//oidMarca
	     if( newRow[3] == cdos_trim(listado2.extraeDato(codigo[a], 2))){//oidUnidadNegocio
	      if( newRow[5] == cdos_trim(listado2.extraeDato(codigo[a], 4))){//oidNegocio
	       if( newRow[7] == cdos_trim(listado2.extraeDato(codigo[a], 6))){//oidSupergenerico
		if( newRow[9] == cdos_trim(listado2.extraeDato(codigo[a], 8))){//oidGenerico
		 if( newRow[11] == cdos_trim(listado2.extraeDato(codigo[a], 10))){//Exclusión tipo oferta
		  if( newRow[12] == cdos_trim(listado2.extraeDato(codigo[a], 11))){//oidTipoOferta
		   if( newRow[14] == cdos_trim(listado2.extraeDato(codigo[a], 13))){//oidCicloVida
		       flag = true;
		   }
		  }
		 }
		}
	       }
	      }
	     }
	    }
	    a++;
	}//while
	return flag;
}

function validaExclusion() {
	var codigo = listado1.codigos();
	if ( ( (get('formulario.cbMarca','V') != '') || 
		(get('formulario.cbMarca','V') != '') ||
		(get('formulario.cbUnidadNegocio','V') != '') ||
		(get('formulario.cbNegocio','V') != '') ||
		(get('formulario.cbSupergenerico','V') != '') ||
		(get('formulario.cbGenerico','V') !='' ))){
		return false;
	}
	return true;
}

function armaCriterioDeProductos() {
	var cant = listado1.numSelecc();
	var cantTemporal = listado2.codigos().length;  // Cantidad de elementos en la lista destino
	var toAdd = "";
	var codigo = "";

	if ( cant == 0 ){
		GestionarMensaje("UIDTO0001");
	} else {
		codigo = listado1.codSeleccionados();

		var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);
		for(var a = 0; a < codigo.length ; a++){
			var exTO= get("formulario.ExclusionTipoOferta");
			var to = get("formulario.cbTipoOferta");
			var toD = get("formulario.cbTipoOferta","T");
			var cv = get("formulario.cbCicloVida");
			var cvD = get("formulario.cbCicloVida","T");					
			var datos = "";

			datos = "||||||||||";                    
			datos = datos + "|" + exTO;

			var vCantidadTiposOferta = 0;

			if (to.length == '' || to.length == 0 )
				vCantidadTiposOferta = 1;
			else
				vCantidadTiposOferta = to.length;

			var datos1;
			for(var j = 0; j < vCantidadTiposOferta; j++){
				if( to[j] != null && toD[j] != null)                    
					datos1 = datos + "|" + to[j] + "|" + toD[j];
				else
					datos1 = datos + "|" + '' + "|" + '';

				for(var i = 0; i < cv.length; i++){
					var codig = listado2.generaCodigo( posi);
					var dat = codig + datos1 + "|" + cv[i] + "|" + cvD[i] + "|" + codigo[a] + "|" + listado1.extraeDato(codigo[a], 0);

					if(!existeFilaProducto(dat)) {
						var newRow = new Array();
						newRow = dat.split("|");

						listado2.insertar(newRow);
						posi++;
					}
				}
			}
		}

		GestionarMensaje("000000000000079", null,null,null);
	}
}
    
function existeFilaProducto(datos) {
	var codigo = listado2.codigos();
	var newRow = new Array();
	newRow = datos.split("|");
	var flag = false;
	var a = 0;

	while( (a < codigo.length ) && (flag == false) ) {
    
		if( newRow[11] == cdos_trim(listado2.extraeDato(codigo[a], 10)) ) {////Exclusión tipo oferta
			if( newRow[12] == cdos_trim(listado2.extraeDato(codigo[a], 11))) {//oidTipoOferta
	    if( newRow[14] == cdos_trim(listado2.extraeDato(codigo[a], 13)))
	    {//oidCicloVida
		if( newRow[16] == cdos_trim(listado2.extraeDato(codigo[a], 15)))
		{//oidProducto
		    flag = true;
		}
	    }
	}
    }
    a++;
	}//while
return flag;
}
    
function pasaListaTemporal(codigo, dato){
	var codigosTemporal = listado2.codigos();
	var match = rowMatch(codigo, codigosTemporal);
	if (match){
		//muestraMsg = true;
	}else{
		var dat = verificoCampos();
		//datos = codigo + "|" + dat + "|" + datos;  // Agrega el codigo al String de valores. 
		datos = codigo;
		datos = datos + "|";    //oidMarca
		datos = datos + "|";
		datos = datos + "|";
		datos = datos + "|";    //oidUnidadNegocio
		datos = datos + "|";
		datos = datos + "|";    //oidNegocio
		datos = datos + "|";
		datos = datos + "|";    //oidSupergenerico
		datos = datos + "|";
		datos = datos + "|";    //oidGenerico
		datos = datos + "|" + dat;  
		datos = datos + "|" + dato;

		var newRow = new Array();
		newRow = datos.split("|");

		listado2.insertar(newRow);
	}
}

function verificoCampos(){
	var exTO= get("formulario.ExclusionTipoOferta");
	var to = get("formulario.cbTipoOferta");
	var toD = get("formulario.cbTipoOferta","T");
	var cv = get("formulario.cbCicloVida");
	var cvD = get("formulario.cbCicloVida","T");
	var dat  = exTO + "|" + to + "|" + toD + "|" + cv  + "|" + cvD;
	
	return dat;
}

function rowMatch(codigo, codigosTemporal){
	var flag = false;
	var i = 0;
	while ( (i < codigosTemporal.length) && (flag == false) ) {
		if ( codigo == codigosTemporal[i] )
			flag = true;	
			i++;
	}
	return flag;
}

function accionSiguiente() {
    var cantBases = 0;
	var pos = parseInt(get("formulario.posicion"),10);
	
	if (get("formulario.longitud")=="") {
		cantBases = parseInt("0", 10);
	} else {
		cantBases = parseInt(get("formulario.longitud"), 10);
	}

	if ( !(pos < (cantBases - 1)) ) {
		errores();
		return;
    }

	if(validacion()) {
		tomaValoresListaCriterios();
		set('formulario.conectorAction', 'LPMantenimientoBaseAplicacion');
		set('formulario.accion', 'siguiente');
		enviaSICC('formulario');
	}
} 

function tomaValoresListaCriterios() {

	var listadoSeleccionado = '';
	var listadoSeleccionado2 = '';
	if (listado2.datos.length > 0){
		// Tomar valores de la lista
		listadoSeleccionado = listado2string();

		if (listado3.datos.length > 0) {
			// Tomar valores de la lista de escalas
			listadoSeleccionado2 = listado3string();
		}

		var productos = productos2string();
		set('formulario.hidDetalleProductos', productos);
		
		set('formulario.hidDetalleCriterios', listadoSeleccionado);
		set('formulario.hidDetalleCriterios2', listadoSeleccionado2);
		return true;
	}
}

function productos2string() {
	var codigo = listado1.codigos();
	var total = "";

	for(var a = 0; a < codigo.length ; a++){
		var toAdd = "";
		toAdd = "oid:"+ codigo[a];

		if(listado1.extraeDato(codigo[a], 0)!= null && listado1.extraeDato(codigo[a], 0)!="")
			toAdd = toAdd + "|" + "codigosap:" + listado1.extraeDato(codigo[a], 0);    //codigo sap
		if(listado1.extraeDato(codigo[a], 1)!= null && listado1.extraeDato(codigo[a], 1)!="")
			toAdd = toAdd + "|" + "descripcion:"  + listado1.extraeDato(codigo[a], 1);    //descripcion
	
		total = total + "$" + toAdd;
	}	
	return total;
}

function listado2string(){      
	var codigo = listado2.codigos();
	var total = "";
	lon = listado2.datos.length
	for(var a = 0; a < lon ; a++){
		var toAdd = "";   

		if(listado2.extraeDato(codigo[a], 0)!= null && listado2.extraeDato(codigo[a], 0)!="")
			toAdd = toAdd + "|" + "m:" + listado2.extraeDato(codigo[a], 0);    //oidMarca
		if(listado2.extraeDato(codigo[a], 2)!= null && listado2.extraeDato(codigo[a], 2)!="")
			toAdd = toAdd + "|" + "un:"  + listado2.extraeDato(codigo[a], 2);    //oidUnidadNegocio
		if(listado2.extraeDato(codigo[a], 4)!= null && listado2.extraeDato(codigo[a], 4)!="")
			toAdd = toAdd + "|" + "n:"  + listado2.extraeDato(codigo[a], 4);    //oidNegocio
		if(listado2.extraeDato(codigo[a], 6)!= null && listado2.extraeDato(codigo[a], 6)!="")
			toAdd = toAdd + "|" + "sg:"  + listado2.extraeDato(codigo[a], 6);    //oidSupergenerico
		if(listado2.extraeDato(codigo[a], 8)!= null && listado2.extraeDato(codigo[a], 8)!="")
			toAdd = toAdd + "|" + "g:"  + listado2.extraeDato(codigo[a], 8);    //oidGenerico
		if(listado2.extraeDato(codigo[a], 10)!= null && listado2.extraeDato(codigo[a], 10)!="")
			toAdd = toAdd + "|" + "eto:"  + listado2.extraeDato(codigo[a], 10);   //Exclusión tipo oferta
		if(listado2.extraeDato(codigo[a], 11)!= null && listado2.extraeDato(codigo[a], 11)!="")
			toAdd = toAdd + "|" + "to:"  + listado2.extraeDato(codigo[a], 11);   //oidTipoOferta
		if(listado2.extraeDato(codigo[a], 13)!= null && listado2.extraeDato(codigo[a], 13)!="")
			toAdd = toAdd + "|" + "cv:"  + listado2.extraeDato(codigo[a], 13);   //oidCicloVida
		if(listado2.extraeDato(codigo[a], 15)!= null && listado2.extraeDato(codigo[a], 15)!="")
			toAdd = toAdd + "|" + "pr:"  + listado2.extraeDato(codigo[a], 15);   //oidProducto			
		if(listado2.extraeDato(codigo[a], 1)!= null && listado2.extraeDato(codigo[a], 1)!="")
			toAdd = toAdd + "|" + "descmarca:"  + listado2.extraeDato(codigo[a], 1);//descripcion marca		    	
		if(listado2.extraeDato(codigo[a], 3)!= null && listado2.extraeDato(codigo[a], 3)!="")
			toAdd = toAdd + "|" + "descunidad:"  + listado2.extraeDato(codigo[a], 3);//descripcion unidad negocio		    	
		if(listado2.extraeDato(codigo[a], 5)!= null && listado2.extraeDato(codigo[a], 5)!="")
			toAdd = toAdd + "|" + "descnegocio:"  + listado2.extraeDato(codigo[a], 5);//descripcion negocio		    	
		if(listado2.extraeDato(codigo[a], 7)!= null && listado2.extraeDato(codigo[a], 7)!="")
			toAdd = toAdd + "|" + "descsupergenerico:"  + listado2.extraeDato(codigo[a], 7); //descripcion supergenerico		    	
		if(listado2.extraeDato(codigo[a], 9)!= null && listado2.extraeDato(codigo[a], 9)!="")
			toAdd = toAdd + "|" + "descgenerico:"  + listado2.extraeDato(codigo[a], 9); //descripcion generico		    	
		if(listado2.extraeDato(codigo[a], 12)!= null && listado2.extraeDato(codigo[a], 12)!="")
			toAdd = toAdd + "|" + "desctipooferta:"  + listado2.extraeDato(codigo[a], 12);	//descripcion tipo oferta
		if(listado2.extraeDato(codigo[a], 14)!= null && listado2.extraeDato(codigo[a], 14)!="")
			toAdd = toAdd + "|" + "descciclovida:"  + listado2.extraeDato(codigo[a], 14); //descripcion ciclo vida  		    	
		if(listado2.extraeDato(codigo[a], 16)!= null && listado2.extraeDato(codigo[a], 16)!="")
			toAdd = toAdd + "|" + "descproducto:"  + listado2.extraeDato(codigo[a], 16); //descripcion producto  

		total = total + "$" + toAdd;
	}		
	return total;
}

function listado3string(){
	var codigo = listado3.codigos();
	var toAdd = "";
	var total = "";

	for(var a = 0; a < codigo.length ; a++){
		toAdd = "$";

		var d0 = listado3.extraeDato(codigo[a], 0);
		if(listado3.extraeDato(codigo[a], 0) != null) {
			var vDesde =  listado3.extraeDato(codigo[a], 0);
			toAdd = toAdd + vDesde + "|";
		}

		var d1 = listado3.extraeDato(codigo[a], 1);
		if(listado3.extraeDato(codigo[a], 1) != null && listado3.extraeDato(codigo[a], 1) != "") {
		    
			var vHasta = listado3.extraeDato(codigo[a], 1);
			toAdd = toAdd + vHasta + "|";

		} else	toAdd = toAdd + "null" + "|";

		var d2 = listado3.extraeDato(codigo[a], 2);
		
		if(listado3.extraeDato(codigo[a], 2) != null && listado3.extraeDato(codigo[a], 2) != "") {
			//var vPorcentaje = Decimal2( listado3.extraeDato(codigo[a], 2) , ',');
			//toAdd = toAdd + vPorcentaje + "|";
		    
			toAdd = toAdd + listado3.extraeDato(codigo[a], 2) + "|";
		}            

		total = total + toAdd;
	}		
	return total;
}

function configuraPagina(){	
	//NOTA: aqui se deberia dejar habilitado el boton "siguiente"
	//y ademas ocultar (no deshabilitar) el boton "otra base"

	/* Segun el modelo: 
	Si (casoDeUso = "consultar") { 
		Habilitar botón "siguiente" y ocultar "otraBase" 
	}
	en otro caso {
		Habilitar los botones "siguiente" y "otraBase" 
	} */

	deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');
	deshabilitarHabilitarBoton('botonContenido','btnEliminar','D');
	deshabilitarHabilitarBoton('botonContenido','btnAnadir','D');
	deshabilitarHabilitarBoton('botonContenido','btnEliminar2','D');
	deshabilitarHabilitarBoton('botonContenido','btnOtraBase','D');
	deshabilitarHabilitarBoton('botonContenido','btnAnadir3','D');
	deshabilitarHabilitarBoton('botonContenido','btnEliminar3','D');
	//deshabilitarHabilitarBoton('botonContenido','btnSiguiente','D');

	accion('formulario.cbMarca','.disabled=true');
	accion('formulario.cbUnidadNegocio','.disabled=true');
	accion('formulario.cbNegocio','.disabled=true');
	accion('formulario.cbSupergenerico','.disabled=true');
	accion('formulario.cbGenerico','.disabled=true');
	accion('formulario.ExclusionTipoOferta','.disabled=true');
	accion('formulario.txtNumUnidadesObligatorias','.disabled=true');
	//accion('formulario.cbTipoOferta','.disabled=true');
	//accion('formulario.cbCicloVida','.disabled=true');
	
	// incidencia DBLG500000573, permitir el scroll en el combo

	arrComboTipoOferta = get('formulario.cbTipoOferta');
	arrComboCicloVida = get('formulario.cbCicloVida');
}

function tomarDatosPagina(){
		arrLimpia[0] = get("formulario.cbMarca");			
		arrLimpia[1] = get("formulario.cbUnidadNegocio");
		arrLimpia[2] = get("formulario.cbNegocio");
		arrLimpia[3] = get("formulario.cbSupergenerico");
		arrLimpia[4] = get("formulario.cbGenerico");
		arrLimpia[5] = get("formulario.cbTipoOferta");
		arrLimpia[6] = get("formulario.cbCicloVida");
		arrLimpia[7] = get("formulario.ExclusionTipoOferta");
 }

function fLimpiar(){
	set("formulario.cbMarca",new Array(arrLimpia[0]));			
	set("formulario.cbUnidadNegocio",new Array(arrLimpia[1]));
	set("formulario.cbNegocio",new Array(arrLimpia[2]));
	set("formulario.cbSupergenerico",new Array(arrLimpia[3]));
	set("formulario.cbGenerico",new Array(arrLimpia[4]));
	set("formulario.cbTipoOferta",arrLimpia[5]);
	set("formulario.cbCicloVida",arrLimpia[6]);
	set("formulario.ExclusionTipoOferta",arrLimpia[7]);

	if (get("formulario.VisibleBADM")=="S") 
		focaliza("formulario.cbMarca");            
	else {
		if(get("formulario.VisibleBADUN")=="S")
			focaliza("formulario.cbUnidadNegocio");
		else	
			if(get("formulario.VisibleBADN")=="S")
				focaliza("formulario.cbNegocio");
			else	
				if(get("formulario.VisibleBADG")=="S")                
					focaliza("formulario.cbGenerico");
				else	
					if(get("formulario.VisibleBADSG")=="S")
						focaliza("formulario.cbSupergenerico");
	}

	deshabilitarHabilitarBoton('botonContenido','btnBuscar','A');
}

function errores(){
	GestionarMensaje("1391",null,null,null);
}

function accionMensajeDeExito(){
	GestionarMensaje("1281",null,null,null);
	window.close();
}

function fVolver(){
	onClickPestanya('3');

	/*window.close();
	set("formulario.conectorAction","LPMantenimientoDTO");
	set("formulario.accion","volver");
	enviaSICC("formulario");*/
}

function navegaPestaniasDetalle(pestanya) {
	if (accionValidacion()){
	    if(validacion()){
		tomaValoresListaCriterios();
		if(get("formulario.casoDeUso")!= "insertar"){
		    if (pestanya == 4){
			set("formulario.hidPestanya", "4");
			set("formulario.posicion","-1");
			set('formulario.conectorAction', 'LPMantenimientoBaseAplicacion');
			set('formulario.accion', 'siguiente');
			enviaSICC('formulario');  
		    }
		}
	    }
	}  
}

function cambiaEstado(){
	if(get('formulario.ExclusionTipoOferta')=='S')
		sicc_cambiar_estado("cbTipoOferta",true);   
	else	
		sicc_cambiar_estado("cbTipoOferta",false);       
}

function validaEscalas(EscalaDesde, EscalaHasta){
	var codigo   = listado3.codigos();
	var vDesde   = "";
	var vHasta   = "";
	var vMensaje = "";

	escalaDesde = new Number(EscalaDesde);
	escalaHasta = new Number(EscalaHasta);

	if(escalaDesde < 0 && codigo.length > 0){
		vMensaje = GestionarMensaje('256');
		cdos_mostrarAlert (vMensaje);
		return false;
	}
	 
	if(codigo.length > 0){
		if( (listado3.extraeDato (codigo[0], 0) < 0)){
			vMensaje = GestionarMensaje('256');
			cdos_mostrarAlert (vMensaje);
			return false;
		}
	}

	// Modificado para que valide el ingreso de escalas decimales,
	// ya que se estan definiendo escalas de dinero y no de números
	// Inc 9101. Cintia Verónica Argain - 01/2005

	escalaDesde = Decimal2(EscalaDesde,'.');
	for(var a = 0; a < codigo.length ; a++) { 
		vDesde = Decimal2(listado3.extraeDato (codigo[a], 0),'.');
		vHasta = Decimal2(listado3.extraeDato (codigo[a], 1),'.');
      
		if((parseFloat(escalaDesde) >= parseFloat(vDesde)) && 
			(parseFloat(escalaDesde) <= parseFloat(vHasta))) { 
			vMensaje = GestionarMensaje('256'); 
			cdos_mostrarAlert (vMensaje); 
			return false; 
		} 
	}

	escalaHasta = Decimal2(EscalaHasta,'.');
	for(var a = 0; a < codigo.length ; a++) { 
		vDesde = Decimal2(listado3.extraeDato (codigo[a], 0),'.');
		vHasta = Decimal2(listado3.extraeDato (codigo[a], 1),'.');

		if((parseFloat(escalaHasta) >= parseFloat(vDesde)) && 
			(parseFloat(escalaHasta) <= parseFloat(vHasta))) { 
			vMensaje = GestionarMensaje('256'); 
			cdos_mostrarAlert (vMensaje); 
			return false; 
		} 
	}

	if(codigo.length > 0){
		//alert("bandera: false");
		var bandera = 'false';
	} else {
		//alert("bandera: true");
		var bandera = 'true';
	}

	var largocodi = codigo.length;
	var vh = "";
	var vd = "";	
	
	var arrdatos = listado3.datos;
	
	if(arrdatos.length > 0){
		var lrg = arrdatos.length-1;
		var minim = Decimal2(arrdatos[0][1],'.');
		var maxim = Decimal2(arrdatos[arrdatos.length-1][2],'.');
	}
	
	for(var a = 0; a < largocodi ; a++) { 
		vDesde = Decimal2(listado3.extraeDato (codigo[a], 0),'.');
		vHasta = Decimal2(listado3.extraeDato (codigo[a], 1),'.');

		if(escalaHasta == "" || ((parseFloat(escalaHasta)+0.01) == parseFloat(vDesde))){
			if((parseFloat(escalaDesde)) <= parseFloat(minim)){
				bandera = 'true';
			}
			for(var b = 0; b < largocodi ; b++) { 
				vh = Decimal2(listado3.extraeDato(codigo[b], 1),'.');
				if((parseFloat(escalaDesde)-0.01) == parseFloat(vh)){
					bandera = 'true';
				}
			}
		}
		
		if((parseFloat(escalaDesde)-0.01) == parseFloat(vHasta)){
			if((parseFloat(escalaHasta)) >= parseFloat(maxim)){
				bandera = 'true';
			}
			for(var c = 0; c < largocodi ; c++) { 			
				vd = Decimal2(listado3.extraeDato(codigo[c], 0),'.');
				if((parseFloat(escalaHasta)+0.01) == parseFloat(vd)){
					bandera = 'true';
				}
			}
		}

		

	}	
	if(bandera=='true'){
		return true;
	}

	GestionarMensaje('1267'); 
	return true;
}


function marcaOnChange(){

	var oidMarSel = get('formulario.cbMarca','V');

	if ( oidMarSel!='' && oidMarSel != null ){

		if(get("formulario.VisibleBADUN")=="S"){
			accion("formulario.cbUnidadNegocio",".disabled=false");
			vBADUN = 'N';
		}

		if(get("formulario.VisibleBADG")=="S" ){
			accion("formulario.cbGenerico",".disabled=false");
			vBADG= 'N';
		}
    
		if(get("formulario.VisibleBADSG")=="S"){
			accion("formulario.cbSupergenerico",".disabled=false");
			vBADSG= 'N';
		}

		deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');
		btnBuscarHab ='N';    

	} else {

		var datosNuevo = new Array();
		datosNuevo[0] = ["",""];    
		set("formulario.cbUnidadNegocio", datosNuevo);
		set("formulario.cbGenerico", datosNuevo);
		set("formulario.cbSupergenerico", datosNuevo);

		if(get("formulario.VisibleBADUN")=="S"){
			accion("formulario.cbUnidadNegocio",".disabled=true");
			vBADUN= 'S';
		}

		if(get("formulario.VisibleBADG")=="S" ){
			accion("formulario.cbGenerico",".disabled=true");
			vBADG= 'S';
		}

		if(get("formulario.VisibleBADSG")=="S" ){
			accion("formulario.cbSupergenerico",".disabled=true");
			vBADSG= 'S';
		}

		unidadNegocioOnChange();
	}
	NegocioOnChange();

}

function CicloVidaOnChange(){
	if (get('formulario.casoDeUso') == 'consultar' ) {	
		set('formulario.cbCicloVida',arrComboCicloVida);
	}
}

function TipoOfertaOnChange(){
	if (get('formulario.casoDeUso') == 'consultar' ) {	
		set('formulario.cbTipoOferta',arrComboTipoOferta);						
	}
}

function unidadNegocioOnChange() {
	var oidUniNegSel = get('formulario.cbUnidadNegocio','V');

	if ( oidUniNegSel!='' && oidUniNegSel != null ){
		if(get("formulario.VisibleBADN")=="S" ){
			accion("formulario.cbNegocio",".disabled=false");
			vBADN ="N";
		}

		btnBuscarHab ='N';

	} else {

		var datosNuevo = new Array();
		datosNuevo[0] = ["",""];            
		set("formulario.cbNegocio", datosNuevo);
		if(get("formulario.VisibleBADN")=="S" ){
			accion("formulario.cbNegocio",".disabled=true");
			vBADN ="S";
		}
	}

	NegocioOnChange();
}


function NegocioOnChange(){
	validaBotonBuscar();
}

function validaBotonBuscar() {

	var oidUniNegSel = get('formulario.cbUnidadNegocio','V');
	var oidMarca = get('formulario.cbMarca','V');
	var oidNegocio = get('formulario.cbNegocio','V');
	var oidGenerico = get('formulario.cbGenerico','V');
	var oidSuperGen = get('formulario.cbSupergenerico','V');

	if(get("formulario.VisibleBADP")=="S"){
		if(( oidMarca!='' && oidMarca != null ) ||
			( oidUniNegSel!='' && oidUniNegSel != null ) ||
			( oidGenerico!='' && oidGenerico != null ) ||
			( oidNegocio!='' && oidNegocio != null ) ||
			( oidSuperGen!='' && oidSuperGen != null ) ) {

			deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');
			btnBuscarHab ='N';

		} else {

			if(( oidMarca == '' ) &&  ( oidUniNegSel == '' ) &&
				( oidGenerico == '' ) &&  ( oidNegocio == '' ) &&
				( oidSuperGen == '' ) ){
				//deshabilitarHabilitarBoton('botonContenido','btnBuscar','A');
				//btnBuscarHab ='S';
			}
		}
	} else {
		deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');
		btnBuscarHab ='N';
	}

}

function SuperGenericoOnChange() {
	if(btnBuscarHab =='N')
		NegocioOnChange();
}

function GenericoOnChange() {
	if(btnBuscarHab =='N')
		NegocioOnChange();
}


/*-------- Inc 11429 -------*/
function validacion() {

	if (validarCriteriosSeleccionados()) 
		return true; 
	else
		return false;
}

function validarCriteriosSeleccionados() {

	if (listado2.datos.length == 0) {
		GestionarMensaje("1442");
		return false;
	}

	if (listado3.datos.length == 0) {
		GestionarMensaje("1266");
		return false;
	}

	return true;

}

/*-------- Inc 11429 -------*/

function onTabEliminar() {

	if (btnBuscarHab == 'N') {
		focalizaBotonHTML('botonContenido','btnAnadir');
	} else {
		focalizaBotonHTML('botonContenido','btnBuscar');
	}

}

function onShTabAnadir() {

	if (btnBuscarHab == 'N'){
		focalizaBotonHTML('botonContenido','btnEliminar');
	} else {
		focalizaBotonHTML('botonContenido','btnBuscar');
	}
}

function onTabSiguiente() {
	focoInicio();
}

function onTabOtraBase()  {
	if (get('formulario.casoDeUso') == 'insertar' ) {
		focalizaBotonHTML('botonContenido','btnSiguiente')
	} else {
		focoInicio();
	}
}

//Agregado por Cristian Valenzuela - 2/11/2005
//(Cambios de incidencia BELC300014763)
function onClickPestanya(pestanya) {
	set("formulario.idPestanyaDest", pestanya);
	
	if (get('formulario.casoDeUso') != 'consultar') {
		if(validacion()) {				
			if(accionValidacion())	{
				tomaValoresListaCriterios()
				set('formulario.conectorAction', 'LPMantenimientoBaseAplicacion');
				set('formulario.casoDeUso', get('formulario.casoDeUso'));
				set('formulario.hidOidBase', get('formulario.hidOidBase'));
				set('formulario.accion', 'almacenar');              
				enviaSICC('formulario');
			}						
		}	
	}
	else { 
		set('formulario.conectorAction', 'LPMantenimientoBaseAplicacion');
		set('formulario.casoDeUso', get('formulario.casoDeUso'));
		set('formulario.hidOidBase', get('formulario.hidOidBase'));
		set('formulario.accion', 'redirigir');              
		enviaSICC('formulario');
	}
}

function ontabComboMarca() {
	if(document.getElementById("cbUnidadNegocio").style.visibility!='hidden') {
		if(document.getElementById("cbUnidadNegocio").disabled!=true) {
			focaliza("formulario.cbUnidadNegocio");
		} else {
			ontabComboUnidadNegocio();
		}
	} else {
		ontabComboUnidadNegocio();
	}
}

function ontabComboUnidadNegocio() {
	if(document.getElementById("cbNegocio").style.visibility!='hidden') {
		if(document.getElementById("cbNegocio").disabled!=true) {
			focaliza("formulario.cbNegocio");
		} else {
			ontabComboNegocio();
		}
	} else {
		ontabComboNegocio();
	}		
}

function ontabComboNegocio() {
	if(document.getElementById("cbSupergenerico").style.visibility!='hidden') {
		if(document.getElementById("cbSupergenerico").disabled!=true) {
			focaliza("formulario.cbSupergenerico");
		} else {
			ontabComboSuperGenerico();
		}
	} else {
		ontabComboSuperGenerico();
	}		
}

function ontabComboSuperGenerico() {
	if(document.getElementById("cbGenerico").style.visibility!='hidden') {
		if(document.getElementById("cbGenerico").disabled!=true) {
			focaliza("formulario.cbGenerico");
		} else {
			ontabComboGenerico();
		}
	} else {
		ontabComboGenerico();
	}		
}

function ontabComboGenerico() {
    focaliza("formulario.ExclusionTipoOferta");
}

function onshtabCicloVida() {
	if(document.getElementById("cbTipoOferta").style.visibility!='hidden') {
		if(document.getElementById("cbTipoOferta").disabled!=true) {
			focaliza("formulario.cbTipoOferta");
		} else {
			onshtabTipoOferta();
		}
	} else {
		onshtabTipoOferta();
	}				
}

function onshtabTipoOferta() {
	if(document.getElementById("ExclusionTipoOferta").style.visibility!='hidden') {
		if(document.getElementById("ExclusionTipoOferta").disabled!=true) {
			focaliza("formulario.ExclusionTipoOferta");
		} else {
			onshtabExclusionTipoOferta();
		}
	} else {
		onshtabExclusionTipoOferta();
	}			
}

function onshtabExclusionTipoOferta() {
	if(document.getElementById("cbGenerico").style.visibility!='hidden') {
		if(document.getElementById("cbGenerico").disabled!=true) {
			focaliza("formulario.cbGenerico");
		} else {
			onshtabGenerico();
		}
	} else {
		onshtabGenerico();
	}			
}

function onshtabGenerico() {
	if(document.getElementById("cbSupergenerico").style.visibility!='hidden') {
		if(document.getElementById("cbSupergenerico").disabled!=true) {
			focaliza("formulario.cbSupergenerico");
		} else {
			onshtabSuperGenerico();
		}
	} else {
		onshtabSuperGenerico();
	}			
}

function onshtabSuperGenerico() {
	if(document.getElementById("cbNegocio").style.visibility!='hidden') {
		if(document.getElementById("cbNegocio").disabled!=true) {
			focaliza("formulario.cbNegocio");
		} else {
			onshtabNegocio();
		}
	} else {
		onshtabNegocio();
	}		
}

function onshtabNegocio() {
	if(document.getElementById("cbUnidadNegocio").style.visibility!='hidden') {
		if(document.getElementById("cbUnidadNegocio").disabled!=true) {
			focaliza("formulario.cbUnidadNegocio");
		} else {
			onshtabUnidadNegocio();
		}
	 } else {
		onshtabUnidadNegocio();
	 }		
}

function onshtabUnidadNegocio() {
	if(document.getElementById("cbMarca").style.visibility!='hidden') {
		if(document.getElementById("cbMarca").disabled!=true) {
			focaliza("formulario.cbMarca");
		} else {
			onshtabMarca();
		}
	} else {
		onshtabMarca();
	}		
}

function onshtabMarca() {
	focalizaBotonHTML('botonContenido','btnSiguiente')

}

function focoInicio() {
	if ( get('formulario.casoDeUso')!='consultar') {
		if(document.getElementById("cbMarca").style.visibility!='hidden') {
			if(document.getElementById("cbMarca").disabled!=true) {
				focaliza("formulario.cbMarca");
			} else {
				ontabComboMarca();
			}
		} else {
			ontabComboMarca();
		}
	}
}

function onshtabBotonSiguiente() {
	focalizaBotonHTML('botonContenido','btnOtraBase');
}

