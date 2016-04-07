var datosSublineas = null;
var seq = 1;

function onLoadPag(){  
    configurarMenuSecundario('formulario');    
    opcionMenu = get('formulario.opcionMenu');
    
    if(!fMostrarMensajeError()){
       if(opcionMenu == "insertar"){
          onLoadPagInsertar();
       } if(opcionMenu == "modificar" || opcionMenu == "consultar"){
          onLoadPagModificarConsultar();
       }
    }
}

function onLoadPagModificarConsultar(opcionMenu){  

    listaDetalles();
    
    // Cargo la cabecera
    set_combo('formulario.cbCentroDistribucion', armaComboDetalle(get('formulario.cbCentroDistribucion_detalle')));
    accion('formulario.cbCentroDistribucion', '.disabled=true');
        
    set_combo('formulario.cbMapaCentroDistribucion', armaComboDetalle(get('formulario.cbMapaCentroDistribucion_detalle')));
    accion('formulario.cbMapaCentroDistribucion', '.disabled=true');
    
    set_combo('formulario.cbLineas', armaComboDetalle(get('formulario.cbLineas_detalle')));
    accion('formulario.cbLineas', '.disabled=true');
    
    set('formulario.txtMapaZonas', get('formulario.txtMapaZonas_detalle'));
    
    if(get('formulario.chkValorDefecto_detalle')=="1"){
        set('formulario.ChkValorDefecto', 'S');
    }
    
    opcionMenu = get('formulario.opcionMenu');
    
    if(opcionMenu == "modificar"){
        deshabilitarDetallesGuardados();
        focaliza("formulario.ChkValorDefecto");
                
    } else if(opcionMenu == "consultar"){
        accion('formulario.txtMapaZonas', '.disabled=true');
        accion('formulario.ChkValorDefecto', '.disabled=true');
        
        deshabilitarListaBotones();
    }
}

function deshabilitarDetallesGuardados(){  
    var codigos = listado1.codigos();
    eval("listado1.preparaCamposDR()");
    
    for(var i=0; i<codigos.length; i++){
        if(listado1.extraeDato(codigos[i], 4)!="BLANCO") {
          accion('frm'+'listado1'+'.'+'comboSubLinea'+'_'+i, '.disabled=true');
          accion('frm'+'listado1'+'.'+'txtZona'+'_'+i, '.disabled=true');
          accion('frm'+'listado1'+'.'+'txtBahiaInicial'+'_'+i, '.disabled=true');
        }
    }
}


function deshabilitarListaBotones(){  
    listado1.tiposCol[0][8]=true;
    listado1.tiposCol[1][8]=true;
    listado1.tiposCol[2][8]=true;
    listado1.tiposCol[3][8]=true;
    
    listado1.actualizaDat();
    listado1.repinta();
    
    deshabilitarHabilitarBoton('botonContenido','Aniadir','D')
    deshabilitarHabilitarBoton('botonContenido','Eliminar','D')
}

function onLoadPagInsertar(){  

    listaDetalles();
        
    accion('formulario.cbMapaCentroDistribucion', '.disabled=true');
    accion('formulario.cbLineas', '.disabled=true');
  
    set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);
    
    if (get('formulario.hCbCentroDistribucion')!=''){
        onChangeCentroDistribucion();    
    }
    
    focaliza("formulario.cbCentroDistribucion");
}

function cargaArray(datos){
    var seteo = new Array(datos.length + 1);
    seteo[0] = ['' , '']
    for(i = 0; i < datos.length; i++){
      seteo[i+1] = [ datos[i][0], datos[i][1] ]
    }
    return seteo;
}
    
function arrayVacio(){  
    var array = new Array();             
        array[0] = new Array('','');
  
    return array;
}

function armaComboDetalle(valores){
    
    valoresArray= valores.split(",");
    var seteo = new Array(1);
    seteo[0] = [valoresArray[0] , valoresArray[1]]
    
    return seteo;
}

function onChangeCentroDistribucion(){

    if(get('formulario.cbCentroDistribucion') != ''){
        accion('formulario.cbMapaCentroDistribucion', '.disabled=false');
        
        set_combo('formulario.cbLineas', arrayVacio());
        accion('formulario.cbLineas', '.disabled=true');        
        comboSubLineaVacio();
        
        recargaCombo('formulario.cbMapaCentroDistribucion', 'APEObtenerMapasCDPorCD', 
          'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbCentroDistribucion')], ['oidIdioma', get('formulario.hIdioma')]]);
    } else {
        set_combo('formulario.cbMapaCentroDistribucion', arrayVacio());
        accion('formulario.cbMapaCentroDistribucion', '.disabled=true');
        set_combo('formulario.cbLineas', arrayVacio());
        accion('formulario.cbLineas', '.disabled=true');
        
        comboSubLineaVacio();
    }
      
}

function onChangeMapaCentro(){
    if(get('formulario.cbMapaCentroDistribucion') != ''){
        accion('formulario.cbLineas', '.disabled=false');
        recargaCombo('formulario.cbLineas', 'APEObtenerLineasMapaCD', 
          'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbMapaCentroDistribucion')], ['oidIdioma', get('formulario.hIdioma')]]
          ,'recargaLineas(datos)');
    } else {        
        set_combo('formulario.cbLineas', arrayVacio());
        accion('formulario.cbLineas', '.disabled=true');
        comboSubLineaVacio();
    }
}

function recargaLineas(datos){
    lineaDef = obtenerLineaDef(datos);
    
    seteo = cargaArray(datos);
    set_combo('formulario.cbLineas', seteo);
    set('formulario.cbLineas', [lineaDef]);
    
    onChangeLinea();
}

function obtenerLineaDef(datos){
    valoresLineasDef = get('formulario.hCbLineasCDDef').split(",");
    //alert("valoresLineasDef: " + valoresLineasDef);
    if(datos != "" && valoresLineasDef != ""){
    
        for(i = 0; i < datos.length; i++){
          oidLinea = datos[i][0];
          for(j = 0; j < valoresLineasDef.length; j++){  
            if(valoresLineasDef[j]==oidLinea){
                return oidLinea;
            }
          }
        } 
        return "";
        
    } else {
        return "";
    }
}

function onChangeLinea(){
    if(get('formulario.cbLineas') != ''){
      recargaCombo('', 'APEObtenerSublineasLinea', 
        'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbLineas')], ['oidIdioma', get('formulario.hIdioma')]]
        ,'recargaSubLineas(datos)');
    } else {              
       comboSubLineaVacio();
   }
}

function comboSubLineaVacio(){
    listado1.tiposCol[0][2] = arrayVacio();
    datosSublineas = "";
    listado1.repinta();
}

function recargaSubLineas(datos){
    //alert("datos: " + datos);
    seteo = cargaArray(datos);     
    listado1.tiposCol[0][2] = seteo;
    listado1.repinta();
}

function onClickEliminarDetalle(){
     var cantElementos = listado1.codSeleccionados();

     if(cantElementos.length == 0 ){
        GestionarMensaje("4", null, null, null);
     } else {
        actualizarDetallesEliminados(cantElementos);
        listado1.eliminarSelecc();
        if(listado1.codigos().length == 0){
            onClickAyadirDetalle();
        }
        
        deshabilitarDetallesGuardados();
     }
}

function actualizarDetallesEliminados(codSeleccionados){
    
    detallesEliminados = get('formulario.hDetallesEliminados');
    //alert("codSeleccionados: " + codSeleccionados);
        
    for (var i=0; i<codSeleccionados.length ; i++){        
        if(listado1.extraeDato(codSeleccionados[i], 4)!="BLANCO") {
            if(detallesEliminados==""){
               detallesEliminados = detallesEliminados + listado1.extraeDato(codSeleccionados[i], 4); 
            } else {
               detallesEliminados = detallesEliminados + "," + listado1.extraeDato(codSeleccionados[i], 4); 
            }
        }
    }
    //alert("detallesEliminados: " + detallesEliminados);
    set('formulario.hDetallesEliminados', detallesEliminados)
}

function onClickAyadirDetalle(){

    oid = listado1.generaCodigo(seq);
    seq = oid;

	oidSublin = obtenerOidSubLineaAnt();
    
    listado1.insertar(new Array(oid, oidSublin , "" , "", "", "BLANCO" ));   
    
    deshabilitarDetallesGuardados();
}


function obtenerOidSubLineaAnt(){

	var codigos = listado1.codigos();
        
	if(codigos.length==0){           
		return "";
	}
	
	return listado1.extraeDato(codigos[codigos.length-1], 0);
}

function fGuardar(){

    if(sicc_validaciones_generales("gMapZona")) {
    
        var codigos = listado1.codigos();
        
        if(codigos.length==0){
            GestionarMensaje('2571');
            focaliza("formulario.cbCentroDistribucion");
            return;
        }
        
        for(var i=0; i<codigos.length; i++){
            codigo = codigos[i];
            // Valida obligatoriedad de comboSubLinea
            if(listado1.extraeDato(codigo, 0)=="") {
                 GestionarMensaje('2567');
                 eval("listado1.preparaCamposDR()");
                 focaliza('frm'+'listado1'+'.'+'comboSubLinea'+'_'+i,'');
                 return;
            }
            
            // Valida obligatoriedad de txtZona
            if(listado1.extraeDato(codigo, 1)=="") {
                 GestionarMensaje('2568');
                 eval("listado1.preparaCamposDR()");
                 focaliza('frm'+'listado1'+'.'+'txtZona'+'_'+i,'');
                 return;
            }
            
            // Valida obligatoriedad de txtBahiaInicial
            if(listado1.extraeDato(codigo, 2)=="") {
                 GestionarMensaje('2569');
                 eval("listado1.preparaCamposDR()");
                 focaliza('frm'+'listado1'+'.'+'txtBahiaInicial'+'_'+i,'');
                 return;
            }
            
            // Valida obligatoriedad de txtBahiaFinal
            if(listado1.extraeDato(codigo, 3)=="") {
                 GestionarMensaje('2570');
                 eval("listado1.preparaCamposDR()");
                 focaliza('frm'+'listado1'+'.'+'txtBahiaFinal'+'_'+i,'');
                 return;
            }
            
            // Valida formato de txtZona
            if(!sicc_valida_numero_lista(listado1.extraeDato(codigo, 1), GestionarMensaje('2572'),1, 99)) {
                 eval("listado1.preparaCamposDR()");
                 focaliza('frm'+'listado1'+'.'+'txtZona'+'_'+i,'');
                 return;
            }
      
            // Valida formato de txtBahiaInicial
            if(!sicc_valida_numero_lista(listado1.extraeDato(codigo, 2), GestionarMensaje('2573'),1, 99)) {
                 eval("listado1.preparaCamposDR()");
                 focaliza('frm'+'listado1'+'.'+'txtBahiaInicial'+'_'+i,'');
                 return;
            }
            
            // Valida formato de txtBahiaFinal
            if(!sicc_valida_numero_lista(listado1.extraeDato(codigo, 3), GestionarMensaje('2574'),1, 99)) {
                 eval("listado1.preparaCamposDR()");
                 focaliza('frm'+'listado1'+'.'+'txtBahiaFinal'+'_'+i,'');
                 return;
            }            
         }
                 
         if(validarSublineas() && validarTodasSublineas()){  // validarTodasSublineas (agregado Inc. BELC400000584)
            // Informa que ya no hay valor por defecto
            if(get('formulario.chkValorDefecto_detalle')=="1" && get('formulario.ChkValorDefecto')=="N"){
                GestionarMensaje('APEUI058');
            }
         
            eval('formulario').oculto = 'S';
            set('formulario.hDescCD', get('formulario.cbCentroDistribucion','T'));  
            set('formulario.hDescMapaCD', get('formulario.cbMapaCentroDistribucion','T'));  
            set('formulario.listaDetalles', armarListaDetalles());   
            set('formulario.conectorAction', 'LPMantenimientoMapaZonasLineasArmado');
            set('formulario.accion', 'guardar');
            enviaSICC('formulario', null, null, 'N');
         }
         
    }
}


function armarListaDetalles(){    
      var codigos = listado1.codigos();
      var cadena = "";
      
      for (var i=0; i<codigos.length ; i++){
          if( i!= 0)
            cadena = cadena + "|";

          sublinea = listado1.extraeDato(codigos[i], 0);
          cadena = cadena + sublinea + "#";
          
          zona = listado1.extraeDato(codigos[i], 1);
          cadena = cadena + zona + "#";
          
          bahiaIni = listado1.extraeDato(codigos[i], 2);
          cadena = cadena + bahiaIni + "#";
          
          bahiaFin = listado1.extraeDato(codigos[i], 3);
          cadena = cadena + bahiaFin + "#";
          
          oidMap = listado1.extraeDato(codigos[i], 4);
          cadena = cadena + oidMap;          
      }
      return cadena;
}
                              

function validarSublineas(){

	var codigos = listado1.codigos();

	for(var i=0; i<codigos.length; i++){
		codigo = codigos[i];
    
		lineaABuscar = listado1.extraeDato(codigo, 0);
		zonaABuscar  = listado1.extraeDato(codigo, 1);

		for(var j=i+1; j<codigos.length; j++){
			codigo1 = codigos[j];
      
			linea = listado1.extraeDato(codigo1, 0);
		  zona  = listado1.extraeDato(codigo1, 1);

			if(linea==lineaABuscar && zona==zonaABuscar){
        GestionarMensaje('APE003');
				return false;
			}
		}
	}
	return true;
}


function listaDetalles(){

    DrdEnsanchaConMargenDcho('listado1',28);
    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
        
    eval (ON_RSZ);     
}


function fLimpiar(){
    opcionMenu = get('formulario.opcionMenu');
    
    if(opcionMenu == "insertar"){
    
        onChangeCentroDistribucion();
        
        set('formulario.txtMapaZonas', '');        
        set('formulario.ChkValorDefecto', 'N');  
        set_combo('formulario.cbLineas', arrayVacio());
        accion('formulario.cbLineas', '.disabled=true');
        listado1.tiposCol[0][2] = arrayVacio();
        listado1.limpia();
        limpiaI18N('formulario', 1);
        
        focaliza("formulario.cbCentroDistribucion");
        
    } if(opcionMenu == "modificar"){
          eval('formulario').oculto = 'N';
          set('formulario.conectorAction', 'LPMantenimientoMapaZonasLineasArmado');
          set('formulario.accion', 'modificar');
          enviaSICC('formulario', null, null, 'N');
    }
}

function fVolver(){
  close();
}

function cerrarModal(){
   
     var retorno = new Array();
     retorno[0] = "OK";
    
     returnValue = retorno;
     close();
}

function focalizaCD(){
    focaliza('formulario.cbCentroDistribucion','');
}

function focalizaChkValorDefecto(){
    deshabilitarDetallesGuardados();
    focaliza('formulario.ChkValorDefecto','');
}


function focalizaTab(campo){
    opcionMenu = get('formulario.opcionMenu');
    
    // Vengo de Mapa zonas
    if(campo==1 && cbLineas.disabled == false){
        focaliza('formulario.cbLineas','');
    } else if(campo==1 && cbLineas.disabled == true){
        if(listado1.codigos().length!=0){
            if(opcionMenu=='insertar'){        
                eeval("listado1.preparaCamposDR()");
                focaliza('frm'+'listado1'+'.'+'comboSubLinea'+'_0','');
            } else if(opcionMenu=='modificar'){
                eval("listado1.preparaCamposDR()");
                focaliza('frm'+'listado1'+'.'+'txtBahiaFinal'+'_0','');
            }
        } else {
            focalizaBotonHTML('botonContenido','Eliminar');
        }
    }
    
    // Vengo de Linea
    if(campo==2){
        if(listado1.codigos().length!=0){
            if(opcionMenu=='insertar'){        
                eval("listado1.preparaCamposDR()");
                focaliza('frm'+'listado1'+'.'+'comboSubLinea'+'_0','');
            } else if(opcionMenu=='modificar'){
                eval("listado1.preparaCamposDR()");
                focaliza('frm'+'listado1'+'.'+'txtBahiaFinal'+'_0','');
            }
        } else {
            focalizaBotonHTML('botonContenido','Eliminar');
        }
   }
   
   // Vengo de boton Añadir
    if(campo==3){
        if(opcionMenu=='insertar'){        
            focaliza('formulario.cbCentroDistribucion','');
        }  else if(opcionMenu=='modificar'){
            focaliza('formulario.ChkValorDefecto','');
        }
    }
}

function focalizaListaTab(FILAEVENTO) {
    if(FILAEVENTO == (listado1.datos.length - 1)) {
      setTimeout("focalizaBotonHTML_XY('Eliminar')",10); 
    }
}


function focalizaShTab(campo){
    opcionMenu = get('formulario.opcionMenu');
    
    // Vengo del boton Eliminar
    if(campo==1){
        if(listado1.codigos().length!=0){
            var indiceFila = listado1.datos.length - 1;
            eval("listado1.preparaCamposDR()");
            focaliza('frm'+'listado1'+'.'+'txtBahiaFinal'+'_'+indiceFila,'');            
        } else {
            if(cbLineas.disabled == true){
                focaliza('formulario.txtMapaZonas','');
            } else {
                focaliza('formulario.cbLineas','');
            }            
        }
    } 
    
    // Vengo del Valor por defecto
    if(campo==2){
        if(opcionMenu=='insertar'){        
              focaliza('formulario.cbMapaCentroDistribucion','');
          } else if(opcionMenu=='modificar'){
              focalizaBotonHTML_XY('Aniadir');
          }
    }
    
    // Vengo del CD
    if(campo==3){
        focalizaBotonHTML_XY('Aniadir');
    }    
}

function focalizaListaShTab(FILAEVENTO) {
    if(FILAEVENTO == 0){     	
        if(cbLineas.disabled == true){
            setTimeout("focaliza('formulario.txtMapaZonas','')",10);       
        } else {
            setTimeout("focaliza('formulario.cbLineas','')",10);  
        }           
    }        
}

function focalizaListaShTabMod(FILAEVENTO) {
    if(FILAEVENTO == 0 && get('formulario.opcionMenu')=='modificar'){  
        if(cbLineas.disabled == true){
            setTimeout("focaliza('formulario.txtMapaZonas','')",10);       
        } else {
            setTimeout("focaliza('formulario.cbLineas','')",10);  
        }  
    }
}


function sicc_valida_numero_lista(strValor, strMostrar, valorMinimo, valorMaximo) {
          var formulario_local = getFormularioSICC();
          var valorTest = strValor;
          if(valorTest==""){
                    return true;
          }        
                  
          strCantDec="0";
          strSepDec = get(formulario_local+".hSeparadorDecimalPais");
          strSepMil = get(formulario_local+".hSeparadorMilesPais");
          

          //Primero me fijo si es un numero, para eso
          //le saco todos los separadores
          var strCleaned = valorTest.split(strSepDec).join("");
          strCleaned = strCleaned.split(strSepMil).join("")+"";
          
          if(!parseInt(strCleaned.substr(0,1),10) && parseInt(strCleaned.substr(0,1),10)!=0){//si el primero no es un numero, puede ser solo el simbolo negativo
                    if(strCleaned.substr(0,1)!="-"){
                              cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
                              return false;
                    }else{//tambien lo saco para testear el numero
                              strCleaned = strCleaned.substr(1);
                    }
          }

          var RegInteger = /^\d+$/; //Solo numeros
          if(!RegInteger.test(strCleaned)){
                    cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
                    return false;
          }
          
          //Ahora se que es un numero, primero valido los decimales
          //el ultimo debe ser un numero
          if(isNaN(parseInt(valorTest.substr(valorTest.length-1),10))){
                              cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
                              return false;
          }

          //me fijo el largo de los decimales
          var arrTest = valorTest.split(strSepDec);
          if(arrTest.length ==2 && arrTest[1]!=null && arrTest[1]!=""){//si tiene decimales
                    if(parseInt(strCantDec,10)==0){
                              cdos_mostrarAlert(GestionarMensaje("000000000000104"));
                              return false;
                    }
                    var strDecimales = arrTest[arrTest.length-1]+"";
                    if(strDecimales.length > parseInt(strCantDec,10)){//me fijo cuantos son
                              cdos_mostrarAlert(GestionarMensaje("000000000000101" ,  strMostrar,parseInt(strCantDec,10)));
                              return false;
                    }
          }else{
                    if(arrTest.length > 2){//sino
                              cdos_mostrarAlert(GestionarMensaje("000000000000102" ,  strMostrar));
                              return false;
                    }
          }
          //ahora voy por la parte entera

          var strInteger = arrTest[0]+"";
          
          if(strInteger.indexOf(strSepMil) >- 1){//si tiene separadores de miles
                    var arrInteger = strInteger.split(strSepMil);
                    //en todo el array los numero son de a 3 digitos
                    //excepto en la primera posicion, 
                    //donde solo no pueden ser 4 digitos
                    for(var i=0; i < arrInteger.length; i++){
                              if(i==0){
                                         if((arrInteger[i]+"").length>3){
                                                   cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
                                                   return false;
                                         }
                              }else{
                                         if((arrInteger[i]+"").length!=3){
                                                   cdos_mostrarAlert(GestionarMensaje("000000000000105",strSepMil));
                                                   return false;
                                         }
                              }
                    }
          }


          //por ultimo valido el rango del valor
          //saco el separador de miles
          var strNumeroTest = valorTest.split(strSepMil).join("");
          //si el separador decimal es el punto, lo dejo, sino, lo reemplazo por el punto
          if(strSepDec!="."){
                    strNumeroTest  = strNumeroTest.split(strSepDec).join(".")
          }
          
          if(valorMinimo!=""){
                    if(parseFloat(strNumeroTest )<parseFloat(valorMinimo)){
                              cdos_mostrarAlert(GestionarMensaje("000000000000103" ,  strMostrar,parseFloat(valorMinimo),parseFloat(valorMaximo)));                              
                              return false;
                    }
          }      
          if(valorMaximo!=""){
                    if(parseFloat(strNumeroTest)>parseFloat(valorMaximo)){
                              cdos_mostrarAlert(GestionarMensaje("000000000000103" ,  strMostrar,parseFloat(valorMinimo),parseFloat(valorMaximo)));                              
                              return false;
                    }
          }
          return true;
  }

/* Metodo agregado por BELC400000584 */
function validarTodasSublineas() { 
    var cantFilasDetalle = listado1.datos.length;
    var oidSublineaCombo;
    var oidSublineaDetalle;
    
    var oidsSublineasCombo = obtenerOidsOpcionesCombo('frmlistado1.comboSubLinea_0');
    var cantOidsSublineasCombo = oidsSublineasCombo.length;
    
    for (var i = 0; i < cantOidsSublineasCombo; i++) {
        oidSublineacombo = oidsSublineasCombo[i];
        var sublineaZonificada = false;
        
        for (var j = 0; j < cantFilasDetalle; j++) {
            oidSublineaDetalle = listado1.datos[j][1];
            
            if (oidSublineacombo == oidSublineaDetalle) {
                sublineaZonificada = true;
                break;
            }
        }
        if (!sublineaZonificada) {
            GestionarMensaje("APEUI061"); // "No se ha definido zona para todas las bahías de la línea"
            return false; // La linea tiene sublineas que no fueron agregadas al detalle del Mapa de Zonas
        }
		
	}
    return true;
}

function obtenerOidsOpcionesCombo(nombreCombo) {
    var cantElementosCombo = combo_get(nombreCombo, 'L');
    var arrayOidsOpciones = new Array();
    var oidOpcion;
    
    for (var i = 0; i < cantElementosCombo; i++) {
        oidOpcion = combo_get(nombreCombo, 'V', i);
        
        if (oidOpcion != '') {
            arrayOidsOpciones[arrayOidsOpciones.length] = oidOpcion;
        }
    }
    return arrayOidsOpciones;
}