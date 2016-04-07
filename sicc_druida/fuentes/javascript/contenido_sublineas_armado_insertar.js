//array de elementos que pueden tener el foco con TAB/SHTAB
var elementos = new Array('cbCentroDistribucion','cbLineaArmado',
                'txtDescripcion', 'cbCodigoImpresora', 'cbSistemaPicado',
                'chkSublineaPostVenta', 'cbLetraAnaquel', 'chkImprimirListaPicado', 
                'chkFrenteEspalda', 'txtBahiasSublineaFrente', 'txtBahiasSublineaEspalda', 
                'txtNroNivelesFrente', 'txtNroNivelesEspalda', 'txtNroColumnasBahiaFrente', 
                'txtNroColumnasBahiaEspalda', 'txtNroOrdenBalanceo', 'Aniadir','Eliminar');
                
var seq = 1;

function onLoadPag(){  
    configurarMenuSecundario('formulario');    
    opcionMenu = get('formulario.opcionMenu');
    eval (ON_RSZ); 
    fMostrarMensajeError();
    listaDetalles();  
       if(opcionMenu == "insertar"){
          onLoadPagInsertar();
       } if(opcionMenu == "modificar" || opcionMenu == "consultar" || opcionMenu == "eliminar"){
          onLoadPagModificarConsultar();
       
    }
    
    sistemaPicadoOnChange();
}

function onLoadPagInsertar(){  
    set('formulario.cbCentroDistribucion',new Array(get('formulario.hOidCentroDistribucionDefecto')));
    onChangeCentroDistribucion();
    set('formulario.txtCodigoSublinea',get('formulario.hTxtCodigoSublinea'));
	accion('formulario'+'.'+'txtCodigoSublinea', '.disabled=true');
    cargaCbLetraAnaquel();
	onCheckChkFrenteEspalda();
    
    focaliza("formulario.cbCentroDistribucion");
}

function onLoadPagModificarConsultar(){  

    // Cargo cbCentroDistribucion con el valor que viene de la LP 
    var oidCentroDist = get('formulario.hCbCentroDistribucion');
    var descCentroDist = get('formulario.hDescCentroDistribucion');
    set_combo('formulario.cbCentroDistribucion', new Array([oidCentroDist, descCentroDist]));
    set('formulario.cbCentroDistribucion', new Array(oidCentroDist));
    
     onChangeCentroDistribucion();
    
    set('formulario.cbSistemaPicado',new Array(get('formulario.hCbSistemaPicado')));
    
    set('formulario.txtCodigoSublinea',get('formulario.hTxtCodigoSublinea'));
    set('formulario.txtDescripcion',get('formulario.hTxtDescripcion'));
    
    set('formulario.txtBahiasSublineaFrente',get('formulario.hTxtBahiasFrente'));
    set('formulario.txtBahiasSublineaEspalda',get('formulario.hTxtBahiasEspalda'));
    set('formulario.txtNroNivelesFrente',get('formulario.hTxtNivelesFrente'));
    set('formulario.txtNroNivelesEspalda',get('formulario.hTxtNivelesEspalda'));
    set('formulario.txtNroColumnasBahiaFrente',get('formulario.hTxtColumnasBahiaFrente'));
    set('formulario.txtNroColumnasBahiaEspalda',get('formulario.hTxtColumnasBahiaEspalda'));
    set('formulario.txtNroOrdenBalanceo',get('formulario.hTxtNumeroOrdenBalanceo'));    

    set('formulario.txtNroImpresoraPTL',get('formulario.hTxtNroImpresoraPTL'));    

	var iSeleccionado = new Array();
	iSeleccionado[0] = get('formulario.hOidCodigoImpresora')
    set('formulario.cbCodigoImpresora', iSeleccionado);    

	//alert(get('formulario.hOidCodigoImpresora'));
	

    if(get('formulario.hChkPostVenta')=="1"){
        set('formulario.chkSublineaPostVenta','S');    
    }
    if(get('formulario.hChkImprimirListaPicado')=="1"){
        set('formulario.chkImprimirListaPicado','S');    
    }
    if(get('formulario.hChkFrenteEspalda')=="1"){
        set('formulario.chkFrenteEspalda','S');    
    }
    cargaCbLetraAnaquel();
    set('formulario.cbLetraAnaquel', new Array(get('formulario.hDescLetraAnaquel')));
	onCheckChkFrenteEspalda();    
    deshabilitarInputs();

}

function deshabilitarInputs(){
    accion('formulario.cbCentroDistribucion', '.disabled = true');
    accion('formulario.cbLineaArmado', '.disabled = true');
    accion('formulario'+'.'+'cbLetraAnaquel', '.disabled=true');
    accion('formulario'+'.'+'txtCodigoSublinea', '.disabled=true');
    opcionMenu = get('formulario.opcionMenu');
    
    if(opcionMenu == "modificar"){
        deshabilitarDetalles();
    } else if(opcionMenu == "consultar" || opcionMenu == "eliminar"){
        deshabilitarListaBotones();
        deshabilitarDetalles();
        accion('formulario'+'.'+'txtDescripcion', '.disabled=true');
        accion('formulario'+'.'+'chkSublineaPostVenta', '.disabled=true');
        accion('formulario'+'.'+'cbLetraAnaquel', '.disabled=true');
        accion('formulario'+'.'+'chkImprimirListaPicado', '.disabled=true');
        accion('formulario'+'.'+'chkFrenteEspalda', '.disabled=true');
        accion('formulario'+'.'+'txtBahiasSublineaFrente', '.disabled=true');
        accion('formulario'+'.'+'txtBahiasSublineaEspalda', '.disabled=true');
        accion('formulario'+'.'+'txtNroNivelesFrente', '.disabled=true');
        accion('formulario'+'.'+'txtNroNivelesEspalda', '.disabled=true');
        accion('formulario'+'.'+'txtNroColumnasBahiaFrente', '.disabled=true');
        accion('formulario'+'.'+'txtNroColumnasBahiaEspalda', '.disabled=true');
        accion('formulario'+'.'+'txtNroOrdenBalanceo', '.disabled=true');        
        accion('formulario'+'.'+'txtNroImpresoraPTL', '.disabled=true');        
        accion('formulario'+'.'+'cbCodigoImpresora', '.disabled=true');        
    }
}

function deshabilitarDetalles(){  
    
    var codigos = listado1.codigos();
    eval("listado1.preparaCamposDR()");
    
    for(var i=0; i<codigos.length; i++){
        if(listado1.extraeDato(codigos[i], 2)!="BLANCO") {
          accion('frm'+'listado1'+'.'+'comboTipoCajaProducto'+'_'+i, '.disabled=true');
          accion('frm'+'listado1'+'.'+'txtNumCaja'+'_'+i, '.disabled=true');
        }
    }
}

function deshabilitarListaBotones(){  
    //listado1.tiposCol[0][8]=true;
    //listado1.tiposCol[1][8]=true;
    //listado1.tiposCol[2][8]=true;
    //listado1.tiposCol[3][8]=true;
    
    //listado1.actualizaDat();
    //listado1.repinta();
    
    deshabilitarHabilitarBoton('botonContenido','Aniadir','D');
    deshabilitarHabilitarBoton('botonContenido','Eliminar','D');
}




function arrayVacio(){  
    var array = new Array();             
        array[0] = new Array('','');
    return array;
}


function onCheckChkFrenteEspalda(){
     if (get('formulario.chkFrenteEspalda')=='N'){
            set('formulario.txtBahiasSublineaEspalda','');
            set('formulario.txtNroNivelesEspalda','');
            set('formulario.txtNroColumnasBahiaEspalda','');
    
            accion('formulario'+'.'+'txtBahiasSublineaEspalda', '.disabled=true');
            accion('formulario'+'.'+'txtNroNivelesEspalda', '.disabled=true');
            accion('formulario'+'.'+'txtNroColumnasBahiaEspalda', '.disabled=true');
     }else{
            accion('formulario'+'.'+'txtBahiasSublineaEspalda', '.disabled=false');
            accion('formulario'+'.'+'txtNroNivelesEspalda', '.disabled=false');
            accion('formulario'+'.'+'txtNroColumnasBahiaEspalda', '.disabled=false');
     }
}


function validarDatos(){
      if (!sicc_validaciones_generales()) {
         return false;
      }     
      
      var cteMaxBahiasSublinea = parseInt(get('formulario.MAX_BAHIAS_SUBLINEA'));
      var cteMaxNivelesSublinea = parseInt(get('formulario.MAX_NIVELES_SUBLINEA'));
      var cteMaxColumnas = parseInt(get('formulario.MAX_COLUMNAS_SUBLINEA'));
      
      if ( parseInt(get('formulario.txtBahiasSublineaFrente')) < 1  ||
		   parseInt(get('formulario.txtBahiasSublineaFrente')) > cteMaxBahiasSublinea){
            GestionarMensaje('APE033', 1, cteMaxBahiasSublinea );
             focaliza('formulario.txtBahiasSublineaFrente');
             return false;
        //Mostrar el mensaje de error APE033 con el valor ConstantesAPE.BAHIAS_SUBLINEA "No puede haber más de {0] bahias por sublinea"     
      }

      if ( parseInt(get('formulario.txtBahiasSublineaEspalda')) < 1  ||
		  parseInt(get('formulario.txtBahiasSublineaEspalda')) > cteMaxBahiasSublinea) {
            GestionarMensaje('APE033', 1, cteMaxBahiasSublinea);                              
             focaliza('formulario.txtBahiasSublineaEspalda');
             return false;
        //Mostrar el mensaje de error APE033 con el valor ConstantesAPE.BAHIAS_SUBLINEA "No puede haber más de {0] bahias por sublinea"     
      }
  
      if ( parseInt(get('formulario.txtNroNivelesFrente')) < 1  ||
		   parseInt(get('formulario.txtNroNivelesFrente')) > cteMaxNivelesSublinea){
            GestionarMensaje('APE034', 1, cteMaxNivelesSublinea);
             focaliza('formulario.txtNroNivelesFrente');
             return false;
        //Mostrar el mensaje de error APE034 con el valor ConstantesAPE.NIVELES_BAHIAS_SUBLINEA "No puede haber más de {0} niveles"      
      }  
      
      if ( parseInt(get('formulario.txtNroNivelesEspalda')) < 1  ||
  		   parseInt(get('formulario.txtNroNivelesEspalda')) > cteMaxNivelesSublinea ) {
            GestionarMensaje('APE034', 1, cteMaxNivelesSublinea);
             focaliza('formulario.txtNroNivelesEspalda');
             return false;
        //Mostrar el mensaje de error APE034 con el valor ConstantesAPE.NIVELES_BAHIAS_SUBLINEA "No puede haber más de {0} niveles"      
     }
    
      if ( parseInt(get('formulario.txtNroColumnasBahiaFrente')) < 1  ||
		  parseInt(get('formulario.txtNroColumnasBahiaFrente')) > cteMaxColumnas) {
            GestionarMensaje('APE035', 1, cteMaxColumnas);   
             focaliza('formulario.txtNroColumnasBahiaFrente');
             return false;
        //Mostrar mensaje de error APE035 con el valor ConstantesAPE.MAX_COLUMNAS_BAHIA_SUBLINEA "No puede haber más de {0} columnas por bahia"       
      }
      
      if ( parseInt(get('formulario.txtNroColumnasBahiaEspalda')) < 1  ||
		  parseInt(get('formulario.txtNroColumnasBahiaEspalda')) > cteMaxColumnas ) {
            GestionarMensaje('APE035', 1, cteMaxColumnas);
             focaliza('formulario.txtNroColumnasBahiaEspalda');
             return false;
        //Mostrar mensaje de error APE035 con el valor ConstantesAPE.MAX_COLUMNAS_BAHIA_SUBLINEA "No puede haber más de {0} columnas por bahia"       
      }

      var codigos = listado1.codigos();
      if(codigos.length==0){
            GestionarMensaje('3374'); 
            focaliza("formulario.cbCentroDistribucion");
            return false;
      }
      
      for(var i=0; i<codigos.length; i++){
          codigo = codigos[i];
            // Valida obligatoriedad de comboTipoCajaProducto
          if(listado1.extraeDato(codigo, 0)=="") {
             GestionarMensaje('3375');
             eval("listado1.preparaCamposDR()");
             focaliza('frm'+'listado1'+'.'+'comboTipoCajaProducto'+'_'+i,'');
             return false;
          }
            
            // Valida obligatoriedad de txtNumCaja
          if(listado1.extraeDato(codigo, 1)=="") {
                 GestionarMensaje('3376');
                 eval("listado1.preparaCamposDR()");
                 focaliza('frm'+'listado1'+'.'+'txtNumCaja'+'_'+i,'');
                 return false;
          }
            
             // Valida formato de txtNumCaja
          if(!sicc_valida_numero_lista(listado1.extraeDato(codigo, 1), GestionarMensaje('3377'),1, 999)) {
                 eval("listado1.preparaCamposDR()");
                 focaliza('frm'+'listado1'+'.'+'txtNumCaja'+'_'+i,'');
                 return false;
          }
        }
        if(!validarTipoCajaSublineas()){
            return false;
        }        
    return true;
}

function onChangeCentroDistribucion(){
    if(get('formulario.cbCentroDistribucion') != ''){
        accion('formulario.cbLineaArmado', '.disabled=false');
        recargaCombo('formulario.cbLineaArmado', 'APEObtenerLineasArmadoCD', 
          'es.indra.sicc.util.DTOOID', 
          [['oid', get('formulario.cbCentroDistribucion')], 
          ['oidIdioma', get('formulario.idioma')]], 
          'setearCbLineaArmado(datos)' );
    } else {
        set_combo('formulario.cbLineaArmado', arrayVacio());
    }
}

function setearCbLineaArmado(datos) {
            var opcionMenu = get('formulario.opcionMenu');
            var arrayNuevo = new Array();
            if (opcionMenu != 'insertar') {
               arrayNuevo[0]=get("formulario.hCbLineaArmado");
               set_combo('formulario.cbLineaArmado',datos, arrayNuevo);
               return;
            }   
            arrayNuevo[0] = new Array('','');
            arrayNuevo = arrayNuevo.concat(datos);
            set_combo('formulario.cbLineaArmado',arrayNuevo);
        
            /* Se agrega la seleccion de la linea por defecto */
            var longitudCombo = combo_get('formulario.cbLineaArmado', 'L');
            var oidsLineasDef = get('formulario.hOidsLineasArmadoDefecto').split('|');
            // Comienzo desde 1 para obviar la primera linea, que se que esta en blanco
            for (var i = 1; i < longitudCombo; i++) {
                var value = combo_get('formulario.cbLineaArmado', 'V', i);
                for (var j = 0; j < oidsLineasDef.length; j++) {
                    if (value == oidsLineasDef[j]) {
                        set('formulario.cbLineaArmado', new Array(value));
                        // Salgo de los FOR anidados
                        j = oidsLineasDef.length;
                        i = longitudCombo;
                    }
                }
            }
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
        
        deshabilitarDetalles();
     }
}

function actualizarDetallesEliminados(codSeleccionados){
    var detallesEliminados = get('formulario.detallesEliminados');
    //alert("codSeleccionados: " + codSeleccionados);
    for (var i=0; i<codSeleccionados.length ; i++){        
        if(listado1.extraeDato(codSeleccionados[i], 2)!="BLANCO") {
            if(detallesEliminados==""){
               detallesEliminados = detallesEliminados + listado1.extraeDato(codSeleccionados[i], 2); 
            } else {
               detallesEliminados = detallesEliminados + "," + listado1.extraeDato(codSeleccionados[i], 2); 
            }
        }
    }
    //alert("detallesEliminados: " + detallesEliminados);
    set('formulario.detallesEliminados', detallesEliminados);
}

function onClickAyadirDetalle(){
    var oid = listado1.generaCodigo(seq);
    seq = oid;
	var oidTipoCaja = obtenerOidTipoCajaAnt();
    listado1.insertar(new Array(oid, oidTipoCaja , "", "BLANCO" ));   
    deshabilitarDetalles();
}

function obtenerOidTipoCajaAnt(){
	var codigos = listado1.codigos();
	if(codigos.length==0){           
		return "";
	}
	return listado1.extraeDato(codigos[codigos.length-1], 0);
}

function fGuardar(){
    if(validarDatos()) {
            eval('formulario').oculto = 'S';
            set('formulario.listaDetalles', armarListaDetalles());   
            set('formulario.conectorAction', 'LPMantenimientoSublineaArmado');
            set('formulario.accion', 'guardar');
            enviaSICC('formulario');
    }
}

function guardarCorrecto() {
           if (get('formulario.opcionMenu') == "insertar") {
               fLimpiar();   
           }
           else {
                window.close();
           }
}

function guardarError() {
    focaliza("formulario.cbCentroDistribucion");
}

function armarListaDetalles(){    
      var codigos = listado1.codigos();
      var cadena = "";
      var oidTipoCajaSublinea="";
      var tipoCaja="";
      var capacidadAnaquel = "";
      var oidEliminado = "";
      
      for (var i=0; i<codigos.length ; i++){
          if( i!= 0)
            cadena = cadena + "|";

          oidTipoCajaSublinea = codigos[i];
          cadena = cadena + oidTipoCajaSublinea + "#";
          
          tipoCaja = listado1.extraeDato(codigos[i], 0);
          cadena = cadena + tipoCaja + "#";
          
          capacidadAnaquel = listado1.extraeDato(codigos[i], 1);
          cadena = cadena + capacidadAnaquel + "#";
          
          oidEliminado = listado1.extraeDato(codigos[i], 2);
          cadena = cadena + oidEliminado;         
       
      }
      return cadena;
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
    
          eval('formulario').oculto = 'N';
          set('formulario.conectorAction', 'LPInsertarSublineaArmado');
          set('formulario.accion', 'insertar');
          enviaSICC('formulario', null, null, 'N');
    }
    if(opcionMenu == "modificar"){
          eval('formulario').oculto = 'N';
          set('formulario.conectorAction', 'LPMantenimientoSublineaArmado');
          set('formulario.accion', 'guardar');
          enviaSICC('formulario', null, null, 'N');
    }
}

function fVolver(){
  close();
}

//------------------------------------------------------------------------------------------------
function cargaCbLetraAnaquel() {
         set_combo('formulario.cbLetraAnaquel', [[" "," "], 
                                             ["A","A"],["B","B"],
                                             ["C","C"],["D","D"],
                                             ["E","E"],["F","F"],
                                             ["G","G"],["H","H"],
                                             ["I","I"],["J","J"],
                                             ["K","K"],["L","L"],
                                             ["M","M"],["N","N"],
                                             ["O","O"],["P","P"],
                                             ["Q","Q"],["R","R"],                                             
                                             ["S","S"],["T","T"],                                             
                                             ["U","U"],["V","V"],
                                             ["W","W"],["X","X"],
                                             ["Y","Y"],["Z","Z"]
                                             ],
                                            [" "])  
}
function tab(elemento){
            try{
                     for(i=0; i < elementos.length; i++){
                              if( elementos[i] == elemento ){
                                        if( i == elementos.length - 1 )   i = 0;
                                        else   i++;
                                        document.selection.empty();
                                        focaliza('formulario.' + elementos[i]);	
                                        return;
                                }
                     }
                 }
            catch(e){
                     tab(elementos[i]);
            }
}

function shtab(elemento){
            try{
                     for(i=elementos.length - 1; i >= 0 ; i--){
                              if( elementos[i] == elemento ){
                                        if( i == 0 ) i = elementos.length - 1;
                                        else i--;
                                        document.selection.empty();
                                        focaliza('formulario.' + elementos[i]);
                                        return;
                              }
                     }
            }catch(e){
                     shtab(elementos[i]);
            }
}

//--------------------------------------------------------------------------
function focalizaListaTab(FILAEVENTO) {
    if(FILAEVENTO == (listado1.datos.length - 1)) {
      setTimeout("focalizaBotonHTML_XY('Eliminar')",10); 
    }
}

function focalizaListaShTab(FILAEVENTO) {
    if(FILAEVENTO == 0){     	
        if(comboTipoCajaProducto.disabled == true){
            setTimeout("focaliza('formulario.txtNumCaja','')",10);       
        } else {
            setTimeout("focaliza('formulario.comboTipoCajaProducto','')",10);  
        }           
    }        
}

function focalizaListaShTabMod(FILAEVENTO) {
    if(FILAEVENTO == 0 && get('formulario.opcionMenu')=='modificar'){  
        if(comboTipoCajaProducto.disabled == true){
            setTimeout("focaliza('formulario.txtNumCaja','')",10);       
        } else {
            setTimeout("focaliza('formulario.comboTipoCajaProducto','')",10);  
        }  
    }
}

//--------------------------------------------------------------------------

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

//Valida que no se repitan los tiposCajaProducto en mas de una linea
function validarTipoCajaSublineas(){

	var codigos = listado1.codigos();

	for(var i=0; i<codigos.length; i++){
		codigo = codigos[i];
		tipoCajaProductoABuscar = listado1.extraeDato(codigo, 0);
		for(var j=i+1; j<codigos.length; j++){
			codigo1 = codigos[j];
			tipoCajaProducto = listado1.extraeDato(codigo1, 0);
			if(tipoCajaProducto==tipoCajaProductoABuscar){
                //Si se repite alguno mostrar mensaje de error APE36 "No se puede repetir el tipo de caja." 
                GestionarMensaje('APE36');
				return false;
			}
		}
	}
	return true;
}

function sistemaPicadoOnChange() {
	if (get("formulario.cbSistemaPicado", "T") == "PTL") {
        accion('formulario.txtNroImpresoraPTL', '.disabled=false');
	} else {
        accion('formulario.txtNroImpresoraPTL', '.disabled=true');
		set('formulario.txtNroImpresoraPTL','');
	}
}


function focoNext(elemento) {
	if (elemento == "txtNroOrdenBalanceo") focalizaBotonHTML_XY("Eliminar");
	else if (elemento == "Aniadir") focaliza('formulario.cbCentroDistribucion');
	else if (elemento == "cbCentroDistribucion") focalizaBotonHTML_XY("Aniadir");
}
