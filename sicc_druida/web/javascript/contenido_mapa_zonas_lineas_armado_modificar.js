function onLoadPag(){  
	
    configurarMenuSecundario('formulario');
    
    btnProxy(1,0);
    if(get('formulario.opcionMenu')=="eliminar"){
        btnProxy(4,1);
    }
    focaliza("formulario.cbCentroDistribucion");     
    
    visualizaBotones();
    
    if(!fMostrarMensajeError()){
 
        accion('formulario.cbMapaCentroDistribucion', '.disabled=true');
        accion('formulario.cbMapaZonas', '.disabled=true');
      
        set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);
        
        if (get('formulario.hCbCentroDistribucion')!=''){
            onChangeCentroDistribucion();    
        }        
    }
    
    focaliza("formulario.cbCentroDistribucion");  	
}

function visualizaBotones(){  

    opcionMenu = get('formulario.opcionMenu');
    
    if(opcionMenu == "modificar"){
        document.all["ModificarDiv"].style.visibility='';
        document.all["EliminarDiv"].style.visibility='hidden';
        document.all["ConsultarDiv"].style.visibility='hidden';
   } else if(opcionMenu == "consultar"){
        document.all["ModificarDiv"].style.visibility='hidden';
        document.all["EliminarDiv"].style.visibility='hidden';
        document.all["ConsultarDiv"].style.visibility='';
    } else if(opcionMenu == "eliminar"){
        document.all["ModificarDiv"].style.visibility='hidden';
        document.all["EliminarDiv"].style.visibility='';
        document.all["ConsultarDiv"].style.visibility='';
    }
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
      
        accion('formulario.cbMapaCentroDistribucion', '.disabled=false');
        
        set_combo('formulario.cbMapaZonas', arrayVacio());
        accion('formulario.cbMapaZonas', '.disabled=true');
        
        recargaCombo('formulario.cbMapaCentroDistribucion', 'APEObtenerMapasCDPorCD', 
          'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbCentroDistribucion')], ['oidIdioma', get('formulario.hIdioma')]]);
    } else {
        set_combo('formulario.cbMapaCentroDistribucion', arrayVacio());
        accion('formulario.cbMapaCentroDistribucion', '.disabled=true');
        set_combo('formulario.cbMapaZonas', arrayVacio());
        accion('formulario.cbMapaZonas', '.disabled=true');
        
    } 
}

function onChangeMapaCentro(){

    if(get('formulario.cbMapaCentroDistribucion') != ''){
        accion('formulario.cbMapaZonas', '.disabled=false');
        recargaCombo('formulario.cbMapaZonas', 'APEObtenerMapaZonaPorMapaCD', 
          'es.indra.sicc.dtos.ape.DTOMapaZonaCombo', [['oid', get('formulario.cbMapaCentroDistribucion')], ['oidIdioma', get('formulario.hIdioma')]]);
    } else {
        set_combo('formulario.cbMapaZonas', arrayVacio());
        accion('formulario.cbMapaZonas', '.disabled=true');
    } 
}


function onClickModificar(){
    if(sicc_validaciones_generales("gMapZona")){
         var obj = new Object();
         obj.opcionMenu = get('formulario.opcionMenu')
         obj.accion = 'modificar';
         
         var mapaZona = get('formulario.cbMapaZonas');
         mapaArr = mapaZona[0].split("|");
         obj.oidMapaZona= mapaArr[0];
         
         var retorno = mostrarModalSICC('LPMantenimientoMapaZonasLineasArmado', 'modificar', obj, '795', '595');
         
         if(retorno!=null){
            fLimpiar();
         }
    }
}

function onClickConsultar(){
    if(sicc_validaciones_generales("gMapZona")){
         var obj = new Object();
         
         if(get('formulario.opcionMenu')=='eliminar'){
            opcionMenu = "consultar"
            accionModal = 'detalleEliminar';
         } else {
            opcionMenu = get('formulario.opcionMenu');
            accionModal = 'detalle';
         }
         
         obj.opcionMenu = opcionMenu;
         obj.accion = accionModal;
         
         var mapaZona = get('formulario.cbMapaZonas');
         mapaArr = mapaZona[0].split("|");
         obj.oidMapaZona= mapaArr[0];
         
         var retorno = mostrarModalSICC('LPMantenimientoMapaZonasLineasArmado', accionModal, obj, '795', '595');
    }
}

function onClickEliminar(){
    if(sicc_validaciones_generales("gMapZona")){
    
        var mapaZona = get('formulario.cbMapaZonas');
        mapaArr = mapaZona[0].split("|");
        
        if(mapaArr[1]==1){
            GestionarMensaje('APEUI058');
        }
    
        eval('formulario').oculto = 'S';       
        set('formulario.conectorAction', 'LPMantenimientoMapaZonasLineasArmado');
        set('formulario.accion', 'eliminar');
        enviaSICC('formulario', null, null, 'N');
    }
}


function fLimpiar(){

    onChangeCentroDistribucion();
    
    set_combo('formulario.cbMapaZonas', arrayVacio());
    accion('formulario.cbMapaZonas', '.disabled=true');
    
    btnProxy(1,0);
    if(get('formulario.opcionMenu')=="eliminar"){
        btnProxy(4,1);
    }
    
    focaliza("formulario.cbCentroDistribucion");
}

function fBorrar(){
    onClickEliminar();
}

function focalizaCD(){
    focaliza('formulario.cbCentroDistribucion','');
}


function focalizaBotonTab(boton){
    opcionMenu = get('formulario.opcionMenu');
    
    if(opcionMenu=='modificar' || opcionMenu== 'consultar' 
       ||(opcionMenu=='eliminar' && boton=='2') ){
        focaliza("formulario.cbCentroDistribucion");
    } else if(opcionMenu=='eliminar' && boton=='1'){
        focalizaBotonHTML('botonContenido','Eliminar');
    } 
}

function focalizaShTab(){
    opcionMenu = get('formulario.opcionMenu');
    
    if(opcionMenu== 'consultar'){
        focalizaBotonHTML('botonContenido','Consultar');
    } else if(opcionMenu=='modificar'){
        focalizaBotonHTML('botonContenido','Modificar');
    } else if(opcionMenu=='eliminar'){
        focalizaBotonHTML('botonContenido','Eliminar');
    } 
}

