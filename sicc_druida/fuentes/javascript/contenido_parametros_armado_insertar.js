function onLoadPag(){  
    configurarMenuSecundario('formulario');    
    opcionMenu = get('formulario.opcionMenu');
    
    if(!fMostrarMensajeError()){
       if(opcionMenu == "InsertarParametrosArmado"){
          onLoadPagInsertar();
       } if(opcionMenu == "ModificarParametrosArmado" || opcionMenu == "ConsultarParametrosArmado" ||
          opcionMenu == "EliminarParametrosArmado"){
          
          onLoadPagModificarConsultar();
       }
    }
}

function onLoadPagModificarConsultar(){  

     opcionMenu = get('formulario.opcionMenu');

     set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucionModif')]);
     accion('formulario.cbCentroDistribucion', '.disabled=true');
     
     set('formulario.txtAgrupacioEspecifica', get('formulario.hTxtAgrupacioEspecificaModif'));
     accion('formulario.txtAgrupacioEspecifica', '.disabled=true');
     
     set('formulario.cbMarca', [get('formulario.hCbMarcaModif')]);
     accion('formulario.cbMarca', '.disabled=true');
     
     set('formulario.cbCanal', [get('formulario.hCbCanalMoidf')]);
     accion('formulario.cbCanal', '.disabled=true');
    
     // Llenar la lista de detalles
     var arr = new Array();         
     var pais = get("formulario.hPais");
     var idioma = get("formulario.hIdioma");
     
     arr[arr.length] = new Array("oidPais", pais);
     arr[arr.length] = new Array("oidIdioma", idioma);
     
     arr[arr.length] = new Array("oidConfiguracionListaAFPCabecera", get("formulario.hOidCabeceraListaAFP"));  
     
     configurarPaginado(mipgndo,"APERecuperarAgrupacionesAFP","ConectorRecuperarAgrupacionesAFP",
                        "es.indra.sicc.dtos.ape.DTOAgrupacionEspecifica",arr);
                        
     // Rellena el combo region
     if(opcionMenu == "ModificarParametrosArmado"){
        recargaRegion();
        
        focaliza('formulario.cbRegion','');
        
     } else if (opcionMenu == "ConsultarParametrosArmado" || opcionMenu == "EliminarParametrosArmado"){
     
        set_combo('formulario.cbRegion', arrayVacio());
        accion('formulario.cbRegion', '.disabled=true');
        
        set_combo('formulario.cbZona', arrayVacio());
        accion('formulario.cbZona', '.disabled=true');
        
        set_combo('formulario.cbSeccion', arrayVacio());
        accion('formulario.cbSeccion', '.disabled=true');
        
		/* BELC400000699 - dmorello, 30/08/2007 */
		//deshabilitarHabilitarBoton('botonContenido','Aniadir','D');
        //deshabilitarHabilitarBoton('botonContenido','Elimiar','D');
		document.getElementById("Aniadir").style.visibility = 'hidden';
		document.getElementById("Elimiar").style.visibility = 'hidden';
		/* Fin BELC400000699 - dmorello, 30/08/2007 */
     }                      
}

function muestraLista(ultima, rowset) {
    listaDetalles();
    return true;
} 

function onLoadPagInsertar(){  

    listaDetalles();
        
    accion('formulario.cbRegion', '.disabled=true');
    accion('formulario.cbZona', '.disabled=true');
    accion('formulario.cbSeccion', '.disabled=true');
  
    set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);
        
    focaliza("formulario.cbCentroDistribucion");
}

function arrayVacio(){  
    var array = new Array();             
        array[0] = new Array('','');
  
    return array;
}

function cbMarcaOnChange(){

    var codigos = listado1.codigos();
        
    if(codigos.length!=0){
      if(GestionarMensaje("APEUI050", null, null, null)){
          // ¿Desea cambiar?    
          listado1.limpia();          
          recargaRegion();
          
      } else {
          set('formulario.cbMarca', [get('formulario.hCbMarca')]);
      }
      
    } else {
        recargaRegion();
    }
}

function cbCanalOnChange(){

    var codigos = listado1.codigos();
        
    if(codigos.length!=0){
      if(GestionarMensaje("APEUI050", null, null, null)){
          // ¿Desea cambiar?    
          listado1.limpia();          
          recargaRegion();
          
      } else {
          set('formulario.cbCanal', [get('formulario.hCbCanal')]);
      }
      
    } else {
        recargaRegion();
    }
}

function recargaRegion(){

    set('formulario.hCbMarca', [get('formulario.cbMarca')]);
    set('formulario.hCbCanal', [get('formulario.cbCanal')]);
        
    if(get('formulario.cbMarca')!= '' && get('formulario.cbCanal')!= ''){
    
        accion('formulario.cbRegion', '.disabled=false');
        
        set_combo('formulario.cbZona', arrayVacio());
        accion('formulario.cbZona', '.disabled=true');
        
        set_combo('formulario.cbSeccion', arrayVacio());
        accion('formulario.cbSeccion', '.disabled=true');
        
        recargaCombo('formulario.cbRegion', 'ZONRecargaRegiones', 
          'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', [['oidMarca', get('formulario.cbMarca')], ['oidCanal', get('formulario.cbCanal')], ['oidPais', get('formulario.hPais')]]);
          
    } else {
        set_combo('formulario.cbRegion', arrayVacio());
        accion('formulario.cbRegion', '.disabled=true');
        
        set_combo('formulario.cbZona', arrayVacio());
        accion('formulario.cbZona', '.disabled=true');
        
        set_combo('formulario.cbSeccion', arrayVacio());
        accion('formulario.cbSeccion', '.disabled=true');
    }
}

function cbRegionOnChange(){
    if(get('formulario.cbRegion')!= ''){
            
        accion('formulario.cbZona', '.disabled=false');
        
        set_combo('formulario.cbSeccion', arrayVacio());
        accion('formulario.cbSeccion', '.disabled=true');
        
        recargaCombo('formulario.cbZona', 'ZONRecargaZonas', 
          'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', [['oidRegion', get('formulario.cbRegion')]]);
          
    } else {
        
        set_combo('formulario.cbZona', arrayVacio());
        accion('formulario.cbZona', '.disabled=true');
        
        set_combo('formulario.cbSeccion', arrayVacio());
        accion('formulario.cbSeccion', '.disabled=true');
    }
}

function cbZonaOnChange(){
    if(get('formulario.cbZona')!= ''){
            
        accion('formulario.cbSeccion', '.disabled=false');
        
        recargaCombo('formulario.cbSeccion', 'ZONRecargaSecciones', 
          'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', [['oidZona', get('formulario.cbZona')]]);
          
    } else {
        set_combo('formulario.cbSeccion', arrayVacio());
        accion('formulario.cbSeccion', '.disabled=true');
    }
}

function btnAnyadirOnClick(){
    if(sicc_validaciones_generales("gAniadir")) {
        validarListado();
    }
}

function validarListado(){
    
    oidRegion = get('formulario.cbRegion');
    oidZona = get('formulario.cbZona')!=''?get('formulario.cbZona'):0;
    oidSeccion = get('formulario.cbSeccion')!=''?get('formulario.cbSeccion'):0;
    
    nuevoCod = oidRegion + "-" + oidZona + "-" + oidSeccion;
    
    var codigos = listado1.codigos();
                    
    for (var i=0; i<codigos.length ; i++){
        cod = codigos[i];
        
        // Busca registros iguales
        if(nuevoCod==cod){
            GestionarMensaje('APEUI051');
            focaliza("formulario.cbRegion");
            return;
        }
        
		/* vbongiov -- LG_V400000051  -- 7/11/2007  

        codArray = codigos[i].split("-");
        // Busca registros de mayor jerarquia
        if(oidRegion==codArray[0] && oidZona!='' && codArray[1]==0){
            GestionarMensaje('APEUI053');
            focaliza("formulario.cbRegion");
            return;
        }
        
        if(oidRegion==codArray[0] && oidZona==codArray[1] && oidSeccion!='' && codArray[2]==0){
            GestionarMensaje('APEUI052');
            focaliza("formulario.cbRegion");
            return;
        }    
        
        // Busco registros de menor jerarquia
        if((oidRegion==codArray[0] && oidZona=='' && codArray[1]!=0) 
          || (oidRegion==codArray[0] && oidZona==codArray[1] && oidSeccion=='' && codArray[2]!=0)){
          
          listado1.eliminar(DrIndiceEnArray(listado1.datos, cod, 0),1);
        }
		*/
    }
    
    // Inserto en la lista        
    descRegion = get('formulario.cbRegion', 'T');
    descZona = get('formulario.cbZona','T');
    descSeccion = get('formulario.cbSeccion','T');
    listado1.insertar(new Array(nuevoCod, descRegion, descZona, descSeccion));     
    
    // Limpios los datos para la nueva seleccion    
    set('formulario.cbRegion', '');
    
    set_combo('formulario.cbZona', arrayVacio());
    accion('formulario.cbZona', '.disabled=true');
    
    set_combo('formulario.cbSeccion', arrayVacio());
    accion('formulario.cbSeccion', '.disabled=true');
}

function btnElminarOnClick(){
     var cantElementos = listado1.codSeleccionados();

     if(cantElementos.length == 0 ){
        GestionarMensaje("4", null, null, null);
     } else {
        listado1.eliminarSelecc();
     }
}

function fGuardar(){
    opcionMenu = get('formulario.opcionMenu');
    
    if(opcionMenu == "ModificarParametrosArmado" || sicc_validaciones_generales("gGuardar")) {
    
        var codigos = listado1.codigos();
        
        if(codigos.length==0){
            GestionarMensaje('1392');
            focaliza("formulario.cbCentroDistribucion");
            return;
        }
        
        eval('formulario').oculto = 'S';
       
        set('formulario.listaDetalles', armarListaDetalles());   
        set('formulario.conectorAction', 'LPMantenimientoParametrosArmado');
        set('formulario.accion', 'guardar');
        enviaSICC('formulario', null, null, 'N');
    }
}

function armarListaDetalles(){    
      var codigos = listado1.codigos();
      var cadena = "";
      
      for (var i=0; i<codigos.length ; i++){
          if( i!= 0)
            cadena = cadena + "|";
            
          cadena = cadena + codigos[i];
      }
      
      //alert("cadena: " + cadena);
      
      return cadena;
}
 
function focalizaCD(){
    focaliza('formulario.cbCentroDistribucion','');
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
    
    if(opcionMenu == "InsertarParametrosArmado"){
    
        set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);
        
        set('formulario.txtAgrupacioEspecifica', '');        
        set('formulario.cbMarca', '');    
        set('formulario.cbCanal', '');    
        
        set_combo('formulario.cbRegion', arrayVacio());
        accion('formulario.cbRegion', '.disabled=true');
        
        set_combo('formulario.cbZona', arrayVacio());
        accion('formulario.cbZona', '.disabled=true');
        
        set_combo('formulario.cbSeccion', arrayVacio());
        accion('formulario.cbSeccion', '.disabled=true');        
        
        listado1.limpia();
        
        focaliza("formulario.cbCentroDistribucion");
        
    } else {
        onLoadPagModificarConsultar();
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

function focalizaRegion(){
    focaliza('formulario.cbRegion','');
}


function focalizaTab(campo){
    opcionMenu = get('formulario.opcionMenu');
    
    if(campo=='1'){
        focalizaBotonHTML_XY('Elimiar');
    } else {
        if(opcionMenu == "ModificarParametrosArmado"){
            focaliza("formulario.cbRegion");
        } else {
            focaliza("formulario.cbCentroDistribucion");
        }
    }
}

function focalizaShTab(campo){
    opcionMenu = get('formulario.opcionMenu');
    
    if(campo=='1'){
        focalizaBotonHTML('botonContenido','Aniadir');
    } else if(campo=='2'){
        focalizaBotonHTML_XY('Elimiar');
    } else {        
        if(opcionMenu == "ModificarParametrosArmado"){
            focalizaBotonHTML_XY('Elimiar');
        } else {
            focaliza("formulario.cbCentroDistribucion");
        }        
    } 
}
