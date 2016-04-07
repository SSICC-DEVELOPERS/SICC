
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
	 function onLoadPag()   {
        configurarMenuSecundario("frmContenido"); 

        DrdEnsanchaConMargenDcho('listado1',12);
        eval (ON_RSZ);

		ocultarLista();

		setearCombosMarcaCanal();
		cambioMarcaCanal();
		setearCombosPeriodo();
		set('frmContenido.txtFechaRecojo', get('frmContenido.hFechaRecojo'));
		focaliza('frmContenido.cbMarca'); 
    }
	
	function cambioMarcaCanal(){
        if (get('frmContenido.cbMarca')!=''
        &&get('frmContenido.cbCanal')!=''){
            accion('frmContenido.cbPeriodoDde','.disabled=false');
            var oid = get('frmContenido.cbCanal').toString();
            var marca= get('frmContenido.cbMarca').toString();
            frmContenido.hOidCanal = oid;
            frmContenido.hOidMarca = marca;
            if(oid != "") {                    
                recargaCombo("frmContenido.cbPeriodoDde","PRECargarPeriodos","es.indra.sicc.dtos.cra.DTOPeriodo",makeParameters());
            }      
        }else{
            set_combo('frmContenido.cbPeriodoHta',new Array());
            accion('frmContenido.cbPeriodoHta','.disabled=true');
        }
    }

    function setearCombosMarcaCanal(){
        var array = new Array();
        array[0]= get('frmContenido.hOidCanal');
        set('frmContenido.cbCanal',array);
        array = new Array();
        array[0]= get('frmContenido.hOidMarca');
        set('frmContenido.cbMarca',array);
    }

    function setearCombosPeriodo(){
        var array = new Array();
        array[0]= get('frmContenido.hOidPeriodoDde');
        set('frmContenido.cbPeriodoDde',array);
    }

    function makeParameters() {
        var array = new Array();
        var i=0;
        array[i] = new Array('pais',get('frmContenido.oidPais'));
        i++;
        array[i] = new Array('marca',get('frmContenido.cbMarca'));
        i++;
        array[i] = new Array('canal',get('frmContenido.cbCanal'))
        return array;
    }

	function validaFecha() {
		if (cdos_trim(get('frmContenido.txtFechaRecojo')) != "") {
              if (EsFechaValida(get('frmContenido.txtFechaRecojo'),get('frmContenido.txtFechaRecojo'), 'frmContenido')  != 0) {
                  GestionarMensaje('947','frmContenido.txtFechaRecojo');
                  focaliza('frmContenido.txtFechaRecojo')
                  return false;
              }
        }        
        return true;    
	}	 

	function onTabMarca() {
		focaliza("frmContenido.cbCanal");
	}
	function onShTabMarca() {
		focalizaBotonHTML('botonContenido','btnBuscar');
	}
	function onTabCanal() {
		focaliza("frmContenido.cbPeriodoDde");
	}
	function onShTabCanal() {
		focaliza("frmContenido.cbMarca");
	}
	function onTabPerDde() {
		focaliza("frmContenido.cbPeriodoHta");
	}
	function onShTabPerDde() {
		focaliza("frmContenido.cbCanal");
	}
	function onTabPerHta() {
		focaliza("frmContenido.txtFechaRecojo");
	}
	function onShTabPerHta() {
		focaliza("frmContenido.cbPeriodoDde");
	}
	function onTabFechReco() {
		focalizaBotonHTML('botonContenido','btnBuscar');
	}
	function onShTabFechReco() {
		focaliza("frmContenido.cbPeriodoHta");
	}
	function onTabBot() {
		focaliza("frmContenido.cbMarca");
	}
	function onShTabBot() {
		focaliza("frmContenido.txtFechaRecojo");
	}

	function botonBuscar() {
        if (!validaFecha()) 
            return;
        if (!sicc_validaciones_generales())
            return;
		ocultarLista();

		set("frmContenido.varCbMarca", get("frmContenido.cbMarca").toString());
		set("frmContenido.varCBCanal", get("frmContenido.cbCanal").toString());
		set("frmContenido.varCbPerDde", get("frmContenido.cbPeriodoDde").toString());
		set("frmContenido.varCbPerHta", get("frmContenido.cbPeriodoHta").toString());
		set("frmContenido.varFechReco", get("frmContenido.txtFechaRecojo").toString());

		configurarPaginado(mipgndo1,"RECObtenerBoletasRecPend",
			      "ConectorBuscarBoletasRecojoPendientes",
				  "es.indra.sicc.dtos.rec.DTOGestionarBoletaRecojoPendiente",
				  armaArray());
	}

    function armaArray(){ 
        var arrDatos = new Array();
        var i=0;
        if (get('frmContenido.varCbMarca')!=''){
            arrDatos[i] = new Array('oidMarca', get('frmContenido.varCbMarca'));
            i++;
        }
        if (get('frmContenido.varCBCanal')!=''){
            arrDatos[i] = new Array('oidCanal', get('frmContenido.varCBCanal'));
            i++;
        }
        if (get('frmContenido.varCbPerDde')!=''){
            arrDatos[i] = new Array('oidPerDde', get('frmContenido.varCbPerDde'));
            i++;
        }
        if (get('frmContenido.varCbPerHta')!=''){
            arrDatos[i] = new Array('oidPerHta', get('frmContenido.varCbPerHta'));
            i++;
        }
        if (get('frmContenido.varFechReco')!=''){
            arrDatos[i] = new Array('fechaRecojo', get('frmContenido.varFechReco'));
            i++;
        }
		return arrDatos;

    }

    function onChangePeriodoDesde() {
         var periodoDesde = get('frmContenido.cbPeriodoDde');         
     
         if(periodoDesde!="") {
             recargaCombo('frmContenido.cbPeriodoHta', 'CRAObtenerPeriodosPosterioresActivos', 'es.indra.sicc.dtos.cra.DTOPeriodo', armarArrayDTOPeriodoComboHasta(), "despuesCargarComboHasta(datos);");
			 accion('frmContenido.cbPeriodoHta','.disabled=false');
         } else {
             var array = new Array();
             array[0] = ['', ''];    
             set_combo('frmContenido.cbPeriodoHta', array);          
         }  
	}

	function despuesCargarComboHasta(datos) {

         var oidPeriodoHasta = get("frmContenido.cbPeriodoHta");
		 var codPeriodoHasta = get("frmContenido.cbPeriodoHta", "T");
         var datosNuevo = new Array(); 
	     datosNuevo[0] = ["",""];
 
         for (var i = 0; i < datos.length; i++ )
              datosNuevo[i+1]  = datos[i];
         set_combo("frmContenido.cbPeriodoHta", datosNuevo);
 
         var comboHasta = document.getElementById("cbPeriodoHta");
         var longitud = comboHasta.options.length;
         var existe = "false";
 
         for(var i=0; i<longitud; i++) {                           
             var oidTemp = comboHasta.options[i].value; 
             if(oidPeriodoHasta==oidTemp) existe = "true";
         }            

         if(existe=="false") {
             //El periodo hasta no es posterior al período desde
			 GestionarMensaje('INC054', codPeriodoHasta);
         }
    }

	function armarArrayDTOPeriodoComboHasta(){

          var pais = get('frmContenido.oidPais');
          var marca = get('frmContenido.cbMarca');
          var canal = get('frmContenido.cbCanal'); 
          var periodoDesde = get('frmContenido.cbPeriodoDde');

          var array = new Array();
          var index = 0;
 
          if( pais != null && pais != '' ){
              array[index] = new Array('pais', pais);
              index++;
          }    
          if( marca != null && marca[0] != null && marca[0] != '' ){
              array[index] = new Array('marca', marca[0]);
              index++;
          }
          if( canal != null && canal != '' ){
              array[index] = new Array('canal', canal);
              index++;
          }
          if( periodoDesde != null && periodoDesde != '' ){
              array[index] = new Array('oid', periodoDesde);
              index++;
          }
          return array;
}

function ocultarLista(){
    document.all["Cplistado1"].style.visibility='hidden';
	document.all["separa1Div"].style.visibility='hidden';
	document.all["primera1Div"].style.visibility='hidden';     
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';

	document.all["NoExitoso"].style.visibility='hidden';
	document.all["Anular"].style.visibility='hidden';
	document.all["Detalle"].style.visibility='hidden';
	
}

function mostrarLista(){
   
    document.all["Cplistado1"].style.visibility='';
	document.all["separa1Div"].style.visibility='';
	document.all["primera1Div"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';

	document.all["NoExitoso"].style.visibility='';
	document.all["Anular"].style.visibility='';
	document.all["Detalle"].style.visibility='';
	
}

function prueba(ultima, rowset, error){
    var tamano = rowset.length;
    
    if (tamano > 0) {
        mostrarLista();
        return true;
    }else{
        ocultarLista(); 
        cdos_mostrarAlert(error);
        return false;
    }
}

function botonNoExitoso() {
	if (listado1.numSelecc()== 0){
		GestionarMensaje('4');
	}else{
        set('frmContenido.accion','no exitoso');

        var seleccionados = listado1.codSeleccionados();
      
	    mide=seleccionados.length;
		var aux = "";
		var aux1 = "";
		var aux2 = "";
		var aux3 = ""; 
		codigo = listado1.codSeleccionados();
        for(var a = 0; a < mide ; a++){
			aux = aux + seleccionados[a] + "|" ;
			aux = aux + "&";

			aux1 = aux1 + listado1.extraeDato(codigo[a], 0) + "|" ;
			aux1 = aux1 + "&";

			aux3 = aux3 + listado1.extraeDato(codigo[a], 1) + "|" ;
			aux3 = aux3 + "&";	
			
			aux2 = aux2 + listado1.extraeDato(codigo[a], 9) + "|" ;
			aux2 = aux2 + "&";

			

		}
		set("frmContenido.elemSelecc", aux);
		set("frmContenido.numsAten", aux1);
		set("frmContenido.numsRecoj", aux2);		
		set("frmContenido.numBoletaRecojo", aux3);
		eval('frmContenido').oculto = 'S';
        enviaSICC('frmContenido');
	}
}

function botonAnular() {
	if (listado1.numSelecc()== 0){
		GestionarMensaje('4');
	}else{
        set('frmContenido.accion','anular');

        var seleccionados = listado1.codSeleccionados();
      
	    mide=seleccionados.length;
		var aux = "";
		var aux1 = "";
		codigo = listado1.codSeleccionados();
        for(var a = 0; a < mide ; a++){
			aux = aux + seleccionados[a] + "|" ;
			aux = aux + "&";

			aux1 = aux1 + listado1.extraeDato(codigo[a], 0) + "|" ;
			aux1 = aux1 + "&";
		}
		set("frmContenido.elemSelecc", aux);
		set("frmContenido.numsAten", aux1);
		eval('frmContenido').oculto = 'S';
        enviaSICC('frmContenido');
	}
}

function guardoAnularOk() {
  eval('frmContenido').oculto = 'N';
  fLimpiar();
}


function guardoNoExitososOk() {
  eval('frmContenido').oculto = 'N';
  fLimpiar();
}

function quitaEsp(a){
	if (a == ' '){
		return '';
	}else{
		return a;
  }
}

function botonDetalle() {
	if (listado1.numSelecc()== 1){
		var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);		 
		set("frmContenido.txtCodigoCliente", listado1.datos[posicion][2]);
		set("frmContenido.accion", 'consultar reclamo');
	    /*set("frmContenido.conectorAction","LPConsultarInforme");
		enviaSICC('frmContenido');*/

        var obj = new Object();
		obj.txtCodigoCliente = listado1.datos[posicion][2];
        mostrarModalSICC('LPConsultarInforme','consultar reclamo',obj,780,500);

	}else{
	    if (listado1.numSelecc() > 1) {
		   GestionarMensaje('2525');
  		   var cant = listado1.numSelecc();
		   var arrSel = listado1.codSeleccionados();
		   var fila;
		   for (i = 0; i < cant; i ++) {
			  fila=DrIndiceEnArray(listado1.datos,arrSel[i],0);
			  listado1.deselecciona(fila);
		   }
	  } else {
		 GestionarMensaje('4');
	  }
	}
}

function fLimpiar(){
	set("formulario.txtFechaRecojo",""); 
	set("formulario.cbPeriodoHta","");
	set("formulario.cbPeriodoDde","");
	set("formulario.cbCanal","");
	set("formulario.cbMarca","");
	ocultarLista();
    set_combo('frmContenido.cbPeriodoHta',new Array());
    accion('frmContenido.cbPeriodoHta','.disabled=true');
	set_combo('frmContenido.cbPeriodoDde',new Array());
	setearCombosMarcaCanal();
	cambioMarcaCanal();
	setearCombosPeriodo();

	set('frmContenido.txtFechaRecojo', get('frmContenido.hFechaRecojo'));
	focaliza('frmContenido.cbMarca'); 
}