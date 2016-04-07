var secErr = 1;

function onLoadPag(){
	
    configurarMenuSecundario('formulario');
    if(!fMostrarMensajeError()){
 
        accion('formulario.cbLineas', '.disabled=true');        
        listaErroresOcultar();
      
        set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);
        
        if (get('formulario.hCbCentroDistribucion')!=''){
            onChangeCentroDistribucion();    
        }        
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

function onChangeCentroDistribucion(){
    if(get('formulario.cbCentroDistribucion') != ''){
        accion('formulario.cbLineas', '.disabled=false');
        recargaCombo('formulario.cbLineas', 'APEObtenerLineasArmadoCD', 
          'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbCentroDistribucion')], ['oidIdioma', get('formulario.hIdioma')]]
          ,'recargaLineas(datos)');
    } else {        
        set_combo('formulario.cbLineas', arrayVacio());
        accion('formulario.cbLineas', '.disabled=true');
    }
}

function recargaLineas(datos){
    lineaDef = obtenerLineaDef(datos);
    
    seteo = cargaArray(datos);
    set_combo('formulario.cbLineas', seteo);
    set('formulario.cbLineas', [lineaDef]);
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

function onClickAceptar(){

    if(sicc_validaciones_generales("gAlarmaCub")) {
        listado1.limpia();
    
        eval('formulario').oculto = 'S';     
        set('formulario.hDescCD', get('formulario.cbCentroDistribucion','T'));  
        set('formulario.hDescLinea', get('formulario.cbLineas','T'));  
        set('formulario.conectorAction', 'LPAlarmas');
        set('formulario.accion', 'comprobarValoresCubicaje');
        enviaSICC('formulario', null, null, 'N');         
    }
}

function llenarListaErrores(listaErrores){
   listado1.limpia();

   if(listaErrores!="null") {
	   reg = listaErrores.split("|");
	   for(var i=0; i<reg.length; i++) {
			//alert(reg[i]);
			regDatos = reg[i].split('#');
			
			oid = listado1.generaCodigo(secErr);
			secErr = oid;
	  
			linea = regDatos[0]=="BLANCO"?"":regDatos[0];        
			
			infProblema = regDatos[1]=="BLANCO"?"":regDatos[1]; 
			if(infProblema=="APE-0041-1"){
				infProblema = GestionarMensaje("APE-0041-1");
			}
			
			errorCod = regDatos[2];     
			
			if(errorCod=="APE-0041"){
				errorMensaj = GestionarMensaje("APE-0041");
        
			} else if(errorCod=="APE-0042"){
				errorMensaj = GestionarMensaje("APE-0042");
        
			} else if(errorCod.indexOf("APE-0043")!=-1){
        errorCodArray =  errorCod.split(';');
				errorMensaj = GestionarMensaje("APE-0043",errorCodArray[1], errorCodArray[2]);
			}
		  
			listado1.insertar(new Array(oid, linea, infProblema, errorMensaj));                                                      
	   }	   
   }
   
   listaErroresVisualizar();
}


function fLimpiar(){

    set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);        
    onChangeCentroDistribucion();    
    
    listaErroresOcultar();
    listado1.limpia();
    
    focaliza('formulario.cbCentroDistribucion','');
}

function focalizaCD(){
    focaliza('formulario.cbCentroDistribucion','');
}

function focalizaShTab(){
    focalizaBotonHTML('botonContenido','btnAceptar');
}

function listaErroresVisualizar(){

    DrdEnsanchaConMargenDcho('listado1',21);
    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    document.all["separaDiv"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
        
    eval (ON_RSZ);     
}

function listaErroresOcultar(){
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
}
