FORMULARIO = 'frmFormulario';

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onLoad(){ 
         
         if (get(FORMULARIO+'.errDescripcion')!='') {                      
                      var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
         } 
         
         focaliza( FORMULARIO + '.txtCodigoOperacion' );
         configurarMenuSecundario(FORMULARIO);
         
         var opcionMenu = get( FORMULARIO + '.opcionMenu');
         
         if ( opcionMenu == 'crear operacion' || opcionMenu == 'modificar operacion'){	
                  visibilidad('capa2', 'V');
                  visibilidad('capa3', 'O'); 
                  ingresaEnvia(); 
                  generaEnvia();
                  anulacion(); 
                  ingresaDevuelve(); 
                  generaDevuelve(); 
    deshabilitaRecojo();                  
         } 
         
         if ( opcionMenu == 'consultar operacion' ){	
                   btnProxy(1,0); //Deshabilitamos guardar
                   btnProxy(5,0); //Deshabilitamos limpiar
                   visibilidad('capa2', 'O');
                   visibilidad('capa3', 'V'); 
                   document.all['btnConsultarTiposOperaciones'].focus();
         }
         
         if ( opcionMenu == 'consultar operacion' || opcionMenu == 'modificar operacion'){	
                  
                  //asignamos el valor de los hiddens a los combos
                  set(FORMULARIO+'.cbPrecios',[get(FORMULARIO+'.oidPrecios')]);
                  set(FORMULARIO+'.cbTipoSolicitudPerdida',[get(FORMULARIO+'.oidTipoSolicitudPerdida')]);
                  set(FORMULARIO+'.cbPrecioEnvia',[get(FORMULARIO+'.oidPrecioEnvia')]);
                  set(FORMULARIO+'.cbBloqueoChequeo',[get(FORMULARIO+'.oidBloqueoChequeo')]);
                  set(FORMULARIO+'.cbTipoSolicitud1',[get(FORMULARIO+'.oidTipoSolicitud1')]);
                  set(FORMULARIO+'.cbTipoSolicitud2',[get(FORMULARIO+'.oidTipoSolicitud2')]);
                  set(FORMULARIO+'.cbCodigoMensajeGenerar',[get(FORMULARIO+'.oidCodigoMensajeGenerar')]);
                  set(FORMULARIO+'.cbTipoSolicitudGenera',[get(FORMULARIO+'.oidTipoSolicitudGenera')]);
                  set(FORMULARIO + '.cbAlmacen',[get(FORMULARIO+'.oidAlmacen')]);
                  set(FORMULARIO + '.cbMovimientoAlmacen',[get(FORMULARIO+'.oidMovimientoAlmacen')]);
    
    //vbongiov -- GCC-COL-REC-001-- 17/12/2007   
    set(FORMULARIO + '.cbTipoSolicitudRecojoInicial',[get(FORMULARIO+'.hOidTipoSolicitudRecojoInicial')]);
    set(FORMULARIO + '.cbTipoSolicitudPrimerRecojoNoExitoso',[get(FORMULARIO+'.hOidTipoSolicitudPrimerRecojoNoExitoso')]);
    set(FORMULARIO + '.cbTipoSolicitudSegundoRecojoNoExitoso',[get(FORMULARIO+'.hOidTipoSolicitudSegundoRecojoNoExitoso')]);
    set(FORMULARIO + '.cbAlmacenPostVenta',[get(FORMULARIO+'.hOidAlmacenPostVenta')]);
    set(FORMULARIO + '.cbMovimientoAlmacenRecojoInicial',[get(FORMULARIO+'.hOidMovimientoAlmacenRecojoInicial')]);
    set(FORMULARIO + '.cbMovimientoAlmacenRecojoExitoso',[get(FORMULARIO+'.hOidMovimientoAlmacenRecojoExitoso')]);
    set(FORMULARIO + '.cbMovimientoAlmacenRecojoNoExitoso',[get(FORMULARIO+'.hOidMovimientoAlmacenRecojoNoExitoso')]);
         
                  //asignamos el valor de los hiddens a los check
                  set(FORMULARIO+'.Anulacion',get(FORMULARIO+'.anulacion'));
                  set(FORMULARIO+'.Perdida',get(FORMULARIO+'.perdida'));
                  set(FORMULARIO+'.EsperarMercanciaFisica',get(FORMULARIO+'.esperarMercanciaFisica'));
                  set(FORMULARIO+'.DevueltoFisicoFactura',get(FORMULARIO+'.devueltoFisicoFactura'));
                  set(FORMULARIO+'.FaltanteMercaderia',get(FORMULARIO+'.faltanteMercaderia'));
                  set(FORMULARIO+'.IngresaEnvia',get(FORMULARIO+'.ingresaEnvia'));
                  set(FORMULARIO+'.EnviaGeneraDevuelve',get(FORMULARIO+'.enviaGeneraDevuelve'));
                  set(FORMULARIO+'.IngresaDevuelve',get(FORMULARIO+'.ingresaDevuelve'));
                  set(FORMULARIO+'.DevuelveGeneraEnvia',get(FORMULARIO+'.devuelveGeneraEnvia'));
                  
         } 
  
  //vbongiov -- GCC-COL-REC-001-- 17/12/2007   
  deshabilitaRecojo();
                  
}

//vbongiov -- GCC-COL-REC-001-- 17/12/2007 
function deshabilitaRecojo(){

  var opcionMenu = get( FORMULARIO + '.opcionMenu');

  if(opcionMenu == 'consultar operacion' || opcionMenu == 'crear operacion' || 
    (opcionMenu == 'modificar operacion' && get(FORMULARIO+'.recojo')=="N")){   
    
    accion(FORMULARIO+'.cbTipoSolicitudRecojoInicial','.disabled=true');
    accion(FORMULARIO+'.cbTipoSolicitudPrimerRecojoNoExitoso','.disabled=true');
    accion(FORMULARIO+'.cbTipoSolicitudSegundoRecojoNoExitoso','.disabled=true');
    accion(FORMULARIO+'.cbAlmacenPostVenta','.disabled=true');
    accion(FORMULARIO+'.cbMovimientoAlmacenRecojoInicial','.disabled=true');
    accion(FORMULARIO+'.cbMovimientoAlmacenRecojoExitoso','.disabled=true');
    accion(FORMULARIO+'.cbMovimientoAlmacenRecojoNoExitoso','.disabled=true');    
    
     if(opcionMenu == 'consultar operacion'){
         accion(FORMULARIO+'.recojo','.disabled=true'); 
     }
  } else {
	  var cantRecojo = get(FORMULARIO + '.hcantRecojo');
	  if (cantRecojo==1) {
	      accion(FORMULARIO+'.cbTipoSolicitudPrimerRecojoNoExitoso','.disabled=false');
	  } else {
	      accion(FORMULARIO+'.cbTipoSolicitudSegundoRecojoNoExitoso','.disabled=false');
	  }
  }
}

//vbongiov -- GCC-COL-REC-001-- 17/12/2007   
function onSelectedRecojo(){
    var checkRecojo = get(FORMULARIO + '.recojo');
    
    if (checkRecojo == 'S' ){
      accion(FORMULARIO+'.cbTipoSolicitudRecojoInicial','.disabled=false');
      accion(FORMULARIO+'.cbAlmacenPostVenta','.disabled=false');
      accion(FORMULARIO+'.cbMovimientoAlmacenRecojoInicial','.disabled=false');
	  var cantRecojo = get(FORMULARIO + '.hcantRecojo');
	  if (cantRecojo==1) {
	      accion(FORMULARIO+'.cbTipoSolicitudPrimerRecojoNoExitoso','.disabled=false');
	  } else {
	      accion(FORMULARIO+'.cbTipoSolicitudSegundoRecojoNoExitoso','.disabled=false');
	  }
      accion(FORMULARIO+'.cbMovimientoAlmacenRecojoExitoso','.disabled=false');
      accion(FORMULARIO+'.cbMovimientoAlmacenRecojoNoExitoso','.disabled=false'); 

      
    } else {
         
         set(FORMULARIO+'.cbTipoSolicitudRecojoInicial','');
         set(FORMULARIO+'.cbTipoSolicitudPrimerRecojoNoExitoso','');
         set(FORMULARIO+'.cbTipoSolicitudSegundoRecojoNoExitoso','');
         set(FORMULARIO+'.cbAlmacenPostVenta','');
         set(FORMULARIO+'.cbMovimientoAlmacenRecojoInicial','');
         set(FORMULARIO+'.cbMovimientoAlmacenRecojoExitoso','');
         set(FORMULARIO+'.cbMovimientoAlmacenRecojoNoExitoso','');
    
         deshabilitaRecojo();
    }
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onselectedAnulacion (){
         //Si se selecciona el Check anulacion 
         anulacion();
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onSelectedIngresaEnvia(){
         //Se selecciona el Check ingresaEnvia 
         ingresaEnvia();
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onSelectedGeneraDevuelve(){
         //Si se selecciona el Check enviaGeneraDevuelve 
         generaDevuelve();
} 

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onSelectedIngresaDevuelve(){
         //Si se selecciona el Check ingresaDevuelve 
         ingresaDevuelve();

         // incidencia BELC300018986. El combo cbTipoSolicitudGenera pasa a ser obligatorio 
         // si el check "Ingresa devuelve" está activo 
         for (var i = 0; i < objValidacionSICC.length; i++) {
         if (objValidacionSICC[i].nombre == 'cbTipoSolicitudGenera') {
                  if (get(FORMULARIO + '.IngresaDevuelve') == 'S') { // está activado el combo
                           objValidacionSICC[i].requerido = true;
                  } else {
                           objValidacionSICC[i].requerido = false;
                  }
         }
   }
         
         /*if (get(FORMULARIO + '.IngresaDevuelve') == 'S') { // está activo
                  for (var i = 0; i < objValidacionSICC.length; i++) {
            	if (objValidacionSICC[i].nombre == 'cbTipoSolicitudGenera')
                	objValidacionSICC[i].requerido = true;
                  }
         } else {
                  for (var i = 0; i < objValidacionSICC.length; i++) {
            	if (objValidacionSICC[i].nombre == 'cbTipoSolicitudGenera')
                	objValidacionSICC[i].requerido = false;
                  }
         }*/
                  
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onSelectedGeneraEnvia(){
    //Si se selecciona el Check devuelveGeneraEnvia 
         generaEnvia();
} 

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onClickAniadirTiposOperaciones(){

/*
 * El usuario selecciona el botón anadirTiposOperacion 
 * Se muestra la ventana emergente y modal PgTipoOperacion y activa la LPOperacion con: 
 * accion="mostrar tipos operacion" ,opcionMenu, oidOperacion 
 * Se recupera: arrayListTiposOperacion, arrayListEliminados 
 */ 
         
         var objParams = new Object();
         objParams.opcionMenu = get(FORMULARIO + '.opcionMenu');
         objParams.oidOperacion = get(FORMULARIO + '.oidOperacion');
         objParams.listaTiposSinFormatear = get(FORMULARIO +'.listaTiposSinFormatear');
         objParams.listaEliminados = get(FORMULARIO+'.listaEliminados');
         
         var recuperado = mostrarModalSICC('LPOperacion', 'mostrar tipos operacion', objParams, null, null);
         
         if ( (typeof(recuperado)!='undefined') ){
                  
                  var arrayListTiposOperacion = recuperado[0];
                                    
                  var arrayListEliminados = recuperado[1];
                  var cadena = '';
                  var lista = '';
                  for (i = 0; i < arrayListTiposOperacion.length; i++) {
                  var fila = arrayListTiposOperacion[i];          
                           lista += fila +'#'; //lista para cuando se vuelva a dar al boton aniadir (Incidencia 13620)
                  for (j = 0; j < fila.length; j++) {
                      if (fila[j] == "" ){
                                   fila[j] = "-";
                      }
                           }
                           
                  cadena += fila[0] + "|" + fila[1] + "|" + fila[2]+ "|" + fila[3] 
                           + "|" + fila[4] + "|" + fila[5] + "|" + fila[6]
                           + "|" + fila[7] + "|" + fila[8] + "|" + fila[10]
                           + "|" + fila[12] + "|" + fila[14]
                   	+ "|" + fila[16] + "|" + fila[18] + "|" + fila[19] + "#";
         }
         set(FORMULARIO+'.listaTiposSinFormatear',lista);
                  set(FORMULARIO + '.listaTiposOperaciones', cadena);
         set(FORMULARIO + '.listaEliminados', arrayListEliminados);
         }
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onClickConsultarTiposOperaciones(){

/*
 * El usuario selecciona el botón consultarTiposOperacion 
 * Se muestra la ventana emergente y modal PgTipoOperacion y activa la LPOperacion con: 
 * accion="mostrar tipos operacion" ,opcionMenu, oidOperacion 
 */
         
         var objParams = new Object();
         objParams.opcionMenu = get(FORMULARIO + '.opcionMenu');
         objParams.oidOperacion = get(FORMULARIO + '.oidOperacion');
         mostrarModalSICC('LPOperacion', 'mostrar tipos operacion', objParams, null, null);

} 

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fGuardar(){
                  
/*
 * correcto = Llama al método comprobarTiposOperacion() 
 * perdida = Llama al metodo perdida() 
 * tipoSolicPerdida = Llama al metodo tipoSolicitudPerdida() 
 * almacenMovimiento= Llama al metodo almacenMovimiento() 
 */
 
         // incidencia BELC300018986. El combo cbTipoSolicitudGenera pasa a ser obligatorio 
         // si el check "Ingresa devuelve" está activo  
          
         var opcionMenu = get(FORMULARIO + '.opcionMenu');
         var correcto = false;
         // Modificado by ssantana, inc 21240 	
         
         if ( sicc_validaciones_generales('general') ){
                  var validoOK = false;
                  if(opcionMenu == 'modificar operacion' && (get(FORMULARIO + '.listaTiposOperaciones') == "" )) {
                           validoOK = true;
             } else {
                   	validoOK = comprobarTiposOperacion();
                  }
                  //alert("0 - " + validoOK);
                  
                  if ( validoOK ) {
                           validoOK = perdida();
                  }
                  //alert("1 - " + validoOK);

                  if ( validoOK ) {
                           validoOK = tipoSolicitudPerdida();
                  }
                  //alert("2 - " + validoOK);
                  if ( validoOK ) {
                           var ckIngresaEnvia = get(FORMULARIO + '.IngresaEnvia');
                           var ckEnviaGenerarDevuelve = get(FORMULARIO + '.EnviaGeneraDevuelve' );
                           /*alert("ckIngresaEnvia: " + ckIngresaEnvia);
                           alert("ckEnviaGenerarDevuelve: " + ckEnviaGenerarDevuelve);*/
                           
                           if ( ckIngresaEnvia == 'S' ) {
                                    validoOK = sicc_validaciones_generales('cbTipoSolicitud1');
                                    set(FORMULARIO + '.ingresaEnvia','S'); //mamontie
                           }

                           if (  (validoOK)  && (ckEnviaGenerarDevuelve == 'S') ) 	{
                                    validoOK = sicc_validaciones_generales('cbTipoSolicitudGenera');
                                    set(FORMULARIO + '.enviaGeneraDevuelve','S'); //mamontie

                                    if ( validoOK ) {
                                             validoOK = sicc_validaciones_generales('cbAlmacen');
                                    }

                                    if ( validoOK ) {
                                             validoOK = sicc_validaciones_generales('cbMovimientoAlmacen');
                                    }
                           }

                  }
                  //alert("4 - " + validoOK);

                  if ( validoOK ) {
                           var ckIngresaDevuelve = get(FORMULARIO + '.IngresaDevuelve');
                           var ckDevuelveGeneraEnvia = get(FORMULARIO + '.DevuelveGeneraEnvia');
                           //alert("ckIngresaDevuelve: " + ckIngresaDevuelve);

                           if (ckIngresaDevuelve == 'S' ) {
                                    validoOK = sicc_validaciones_generales('cbTipoSolicitudGenera');
                                    set(FORMULARIO + '.ingresaDevuelve','S'); //mamontie

                                    if ( validoOK ) {
                                             validoOK = sicc_validaciones_generales('cbAlmacen');
                                    }

                                    if ( validoOK ) {
                                             validoOK = sicc_validaciones_generales('cbMovimientoAlmacen');
                                    }
                           }

                           if ( (validoOK) &&  (ckDevuelveGeneraEnvia == 'S') ) {
                                    validoOK = sicc_validaciones_generales('cbTipoSolicitud1'); 
                                    set(FORMULARIO + '.devuelveGeneraEnvia','S'); //mamontie
                           }
                  }
    
    var checkRecojo = get(FORMULARIO + '.recojo');
    
    if ((validoOK) && (checkRecojo == 'S')) {
         validoOK = sicc_validaciones_generales('gRecojo');    
    }
          
                  if ( validoOK ) {
                           
                           set(FORMULARIO + '.anulacion', get(FORMULARIO + '.Anulacion'));

                           set(FORMULARIO + '.accion','insertar operacion');
                  set(FORMULARIO + '.conectorAction',"LPOperacion");
                  enviaSICC(FORMULARIO);         	
                           //alert("aca envia");
                  }

         }
    // Fin Modificado by ssantana, inc 21240             
          
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function comprobarTiposOperacion(){
         
/*
 * Si el arrayListTiposOperaciones viene vacio, 
 * no se debe permitir insertar operaciones 
 * pues no tienen tipos operacion asociado. 
 * mostrar mensaje: REC001 
 */
           
         var devuelve;
         if ( (get(FORMULARIO + '.listaTiposOperaciones')) == "" ) {
                  GestionarMensaje('REC001');
                  devuelve = false;
         }else{
                  devuelve = true;
         }
         return devuelve;
}
 
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function ingresaEnvia(){
         
         var checkIngresaEnvia = get(FORMULARIO + '.IngresaEnvia');
         var checkDevuelveGeneraEnvia = get(FORMULARIO + '.DevuelveGeneraEnvia');
         var checkEnviaGeneraDevuelve = get(FORMULARIO + '.EnviaGeneraDevuelve');
         
         if(( checkIngresaEnvia == 'S' ) && ( checkDevuelveGeneraEnvia == 'N' )){
                  
                  accion(FORMULARIO+'.cbTipoSolicitud1','.disabled=false');
                  accion(FORMULARIO+'.cbTipoSolicitud2','.disabled=false');
                  accion(FORMULARIO+'.cbCodigoMensajeGenerar','.disabled=false');
                  accion(FORMULARIO+'.EnviaGeneraDevuelve','.disabled=false');
                  
         }else if(( checkIngresaEnvia == 'N' ) && ( checkDevuelveGeneraEnvia == 'N' )){
                  
                  if ( checkEnviaGeneraDevuelve == 'S'){
                           set(FORMULARIO+'.EnviaGeneraDevuelve','N');
                           set(FORMULARIO+'.cbTipoSolicitud1',['']);
                           set(FORMULARIO+'.cbTipoSolicitud2',['']);
                           set(FORMULARIO+'.cbCodigoMensajeGenerar',['']);
                           set(FORMULARIO+'.cbTipoSolicitudGenera',['']);
                           set(FORMULARIO+'.cbAlmacen',['']);
                           set(FORMULARIO+'.cbMovimientoAlmacen',['']);
                           accion(FORMULARIO+'.cbTipoSolicitudGenera','.disabled=true');
                           accion(FORMULARIO+'.cbAlmacen','.disabled=true');
                           accion(FORMULARIO+'.cbMovimientoAlmacen','.disabled=true');
                  }
                  
                  accion(FORMULARIO+'.IngresaDevuelve','.disabled=false');
                  accion(FORMULARIO+'.cbTipoSolicitud1','.disabled=true');
                  accion(FORMULARIO+'.cbTipoSolicitud2','.disabled=true');
                  accion(FORMULARIO+'.cbCodigoMensajeGenerar','.disabled=true');
                  accion(FORMULARIO+'.EnviaGeneraDevuelve','.disabled=true');
                  set(FORMULARIO+'.cbTipoSolicitud1',['']);
                  set(FORMULARIO+'.cbTipoSolicitud2',['']);
                  set(FORMULARIO+'.cbCodigoMensajeGenerar',['']);	
         }	
                  
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function generaEnvia(){ 
         
         var checkDevuelveGeneraEnvia = get(FORMULARIO + '.DevuelveGeneraEnvia');
         var checkIngresaEnvia = get(FORMULARIO + '.IngresaEnvia');
         var checkAnulacion = get(FORMULARIO + '.Anulacion');
         
         if ( checkDevuelveGeneraEnvia == 'S' ){
                  accion(FORMULARIO+'.cbTipoSolicitud1','.disabled=false');
                  accion(FORMULARIO+'.cbTipoSolicitud2','.disabled=false');
                  accion(FORMULARIO+'.cbCodigoMensajeGenerar','.disabled=false');
                  accion(FORMULARIO+'.EnviaGeneraDevuelve','.disabled=true');
                  
                  if ( checkIngresaEnvia == 'S'){
                           set(FORMULARIO+'.IngresaEnvia','N')
                  }
                  accion(FORMULARIO+'.IngresaEnvia','.disabled=true');
                  
         } else if(checkIngresaEnvia == 'N') {
                  accion(FORMULARIO+'.cbTipoSolicitud1','.disabled=true');
                  accion(FORMULARIO+'.cbTipoSolicitud2','.disabled=true');
                  accion(FORMULARIO+'.cbCodigoMensajeGenerar','.disabled=true');
                  
                  if ( checkAnulacion == 'S' ){
                           accion(FORMULARIO+'.IngresaEnvia','.disabled=true');
                  }else{
                           accion(FORMULARIO+'.IngresaEnvia','.disabled=false');
                  }
                  
                  set(FORMULARIO+'.cbTipoSolicitud1',['']);
                  set(FORMULARIO+'.cbTipoSolicitud2',['']);
                  set(FORMULARIO+'.cbCodigoMensajeGenerar',['']);
         }	
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function ingresaDevuelve(){
         
         var checkIngresaDevuelve = get(FORMULARIO + '.IngresaDevuelve');
         var checkEnviaGeneraDevuelve = get(FORMULARIO + '.EnviaGeneraDevuelve');
         var checkDevuelveGeneraEnvia = get(FORMULARIO + '.DevuelveGeneraEnvia');
         var checkAnulacion = get(FORMULARIO + '.Anulacion');
         
         if (( checkIngresaDevuelve == 'S' ) && ( checkEnviaGeneraDevuelve == 'N' )){
                  accion(FORMULARIO+'.cbTipoSolicitudGenera','.disabled=false');
                  accion(FORMULARIO+'.cbAlmacen','.disabled=false');
                  accion(FORMULARIO+'.cbMovimientoAlmacen','.disabled=false');
                  accion(FORMULARIO+'.DevuelveGeneraEnvia','.disabled=false');
                  
                  if ( checkAnulacion == 'S' ) {
                           accion(FORMULARIO+'.IngresaEnvia','.disabled=true');
                           accion(FORMULARIO+'.DevuelveGeneraEnvia','.disabled=true');
                           
                  }else if ( checkDevuelveGeneraEnvia == 'S') {
                           accion(FORMULARIO+'.IngresaEnvia','.disabled=true');
                  }
         
         } else if (( checkIngresaDevuelve == 'N' ) && ( checkEnviaGeneraDevuelve == 'N' )){
                  
                  if ( checkDevuelveGeneraEnvia == 'S'){
                           set(FORMULARIO+'.DevuelveGeneraEnvia','N');
                           set(FORMULARIO+'.cbTipoSolicitudGenera',['']);
                           set(FORMULARIO+'.cbAlmacen',['']);
                           set(FORMULARIO+'.cbMovimientoAlmacen',['']);
                           set(FORMULARIO+'.cbTipoSolicitud1',['']);
                           set(FORMULARIO+'.cbTipoSolicitud2',['']);
                           set(FORMULARIO+'.cbCodigoMensajeGenerar',['']);
                           
                           accion(FORMULARIO+'.cbTipoSolicitud1','.disabled=true');
                           accion(FORMULARIO+'.cbTipoSolicitud2','.disabled=true');
                           accion(FORMULARIO+'.cbCodigoMensajeGenerar','.disabled=true');		
                           
                  }
                  
                  if ( checkAnulacion == 'S' ){
                           accion(FORMULARIO+'.IngresaEnvia','.disabled=true');
                           accion(FORMULARIO+'.DevuelveGeneraEnvia','.disabled=true');
                           
                  }else{
                           
                           accion(FORMULARIO+'.DevuelveGeneraEnvia','.disabled=true');
                           accion(FORMULARIO+'.IngresaEnvia','.disabled=false');
                           
                  }
                  
                  accion(FORMULARIO+'.cbTipoSolicitudGenera','.disabled=true');
                  accion(FORMULARIO+'.cbAlmacen','.disabled=true');
                  accion(FORMULARIO+'.cbMovimientoAlmacen','.disabled=true');
                  accion(FORMULARIO+'.DevuelveGeneraEnvia','.disabled=true');
                  set(FORMULARIO+'.cbTipoSolicitudGenera',['']);
                  set(FORMULARIO+'.cbAlmacen',['']);
                  set(FORMULARIO+'.cbMovimientoAlmacen',['']);
         }
         
} 

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function generaDevuelve(){
         
         var checkEnviaGeneraDevuelve = get(FORMULARIO + '.EnviaGeneraDevuelve');
         var checkIngresaDevuelve = get(FORMULARIO + '.IngresaDevuelve');
         
         if ( checkEnviaGeneraDevuelve == 'S' ){
                  accion(FORMULARIO+'.cbTipoSolicitudGenera','.disabled=false');
                  accion(FORMULARIO+'.cbAlmacen','.disabled=false');
                  accion(FORMULARIO+'.cbMovimientoAlmacen','.disabled=false');
                  accion(FORMULARIO+'.DevuelveGeneraEnvia','.disabled=true');
                  
                  if ( checkIngresaDevuelve == 'S'){
                           set(FORMULARIO+'.IngresaDevuelve','N')
                  }
                  accion(FORMULARIO+'.IngresaDevuelve','.disabled=true');
         } else if ( checkIngresaDevuelve == 'N'){
                  accion(FORMULARIO+'.cbTipoSolicitudGenera','.disabled=true');
                  accion(FORMULARIO+'.cbAlmacen','.disabled=true');
                  accion(FORMULARIO+'.cbMovimientoAlmacen','.disabled=true');
                  accion(FORMULARIO+'.IngresaDevuelve','.disabled=false');
                  set(FORMULARIO+'.cbTipoSolicitudGenera',['']);
                  set(FORMULARIO+'.cbAlmacen',['']);
                  set(FORMULARIO+'.cbMovimientoAlmacen',['']);
                  
         }
                  
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
//añadido por incidencia 19565
function perdidaOnClick(){
         var checkPerdida = get(FORMULARIO + '.Perdida');
         
         if ( checkPerdida == 'S' ){
                  accion(FORMULARIO+'.cbTipoSolicitudPerdida','.disabled=false');
         }else if (checkPerdida == 'N' ){
                  accion(FORMULARIO+'.cbTipoSolicitudPerdida','.disabled=true');
                  set(FORMULARIO+'.cbTipoSolicitudPerdida',['']);
         }
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function anulacion(){
         
         set(FORMULARIO + '.anulacion', get(FORMULARIO + '.Anulacion'));
         var checkIngresaEnvia = get(FORMULARIO + '.IngresaEnvia');
         var checkAnulacion = get(FORMULARIO + '.Anulacion');
         var checkEnviaGeneraDevuelve = get(FORMULARIO + '.EnviaGeneraDevuelve');
         var checkIngresaDevuelve = get(FORMULARIO + '.IngresaDevuelve');
         
         if ( checkAnulacion == 'S' ){
                  accion(FORMULARIO+'.EsperarMercanciaFisica','.disabled=true');
                  set(FORMULARIO+'.EsperarMercanciaFisica','N');
                  accion(FORMULARIO+'.DevueltoFisicoFactura','.disabled=true');
                  set(FORMULARIO+'.DevueltoFisicoFactura','N');
                  accion(FORMULARIO+'.cbPrecioEnvia','.disabled=true');
                  set(FORMULARIO+'.cbPrecioEnvia',['']);
                  accion(FORMULARIO+'.cbBloqueoChequeo','.disabled=true');
                  set(FORMULARIO+'.cbBloqueoChequeo',['']);
                  accion(FORMULARIO+'.FaltanteMercaderia','.disabled=true');
                  set(FORMULARIO+'.FaltanteMercaderia','N');
                  accion(FORMULARIO+'.IngresaEnvia','.disabled=true');
                  set(FORMULARIO+'.IngresaEnvia','N');
                  accion(FORMULARIO+'.cbTipoSolicitud1','.disabled=true');
                  accion(FORMULARIO+'.cbTipoSolicitud2','.disabled=true');
                  accion(FORMULARIO+'.cbCodigoMensajeGenerar','.disabled=true');
                  set(FORMULARIO+'.EnviaGeneraDevuelve','N');
                  if ( checkIngresaEnvia == 'S'){
                           set(FORMULARIO+'.IngresaEnvia','N');
                           accion(FORMULARIO+'.cbTipoSolicitud1','.disabled=true');
                           accion(FORMULARIO+'.cbTipoSolicitud2','.disabled=true');
                           accion(FORMULARIO+'.cbCodigoMensajeGenerar','.disabled=true');
                           accion(FORMULARIO+'.EnviaGeneraDevuelve','.disabled=true');
                           set(FORMULARIO+'.EnviaGeneraDevuelve','N');
                           set(FORMULARIO+'.cbTipoSolicitud1',['']);
                           set(FORMULARIO+'.cbTipoSolicitud2',['']);
                           set(FORMULARIO+'.cbCodigoMensajeGenerar',['']);
                           
                           if ( checkEnviaGeneraDevuelve == 'S' ){
                                    accion(FORMULARIO+'.cbTipoSolicitudGenera','.disabled=true');
                                    accion(FORMULARIO+'.cbAlmacen','.disabled=true');
                                    accion(FORMULARIO+'.cbMovimientoAlmacen','.disabled=true');
                                    accion(FORMULARIO+'.IngresaDevuelve','.disabled=false');
                                    set(FORMULARIO+'.cbTipoSolicitudGenera',['']);
                                    set(FORMULARIO+'.cbAlmacen',['']);
                                    set(FORMULARIO+'.cbMovimientoAlmacen',['']);
                           
                           }
                  }
                  if ( checkIngresaDevuelve == 'S' ){
                                                      set(FORMULARIO+'.DevuelveGeneraEnvia','N');
                                                      accion(FORMULARIO+'.DevuelveGeneraEnvia','.disabled=true');
                                                      set(FORMULARIO+'.cbTipoSolicitud1',['']);
                                                      set(FORMULARIO+'.cbTipoSolicitud2',['']);
                                                      set(FORMULARIO+'.cbCodigoMensajeGenerar',['']);
                                                      accion(FORMULARIO+'.cbTipoSolicitud1','.disabled=true');
                                                      accion(FORMULARIO+'.cbTipoSolicitud2','.disabled=true');
                                                      accion(FORMULARIO+'.cbCodigoMensajeGenerar','.disabled=true');
                                                      
                  }		
         }else{
                  accion(FORMULARIO+'.EsperarMercanciaFisica','.disabled=false');
                  accion(FORMULARIO+'.DevueltoFisicoFactura','.disabled=false');
                  accion(FORMULARIO+'.cbPrecioEnvia','.disabled=false');
                  accion(FORMULARIO+'.cbBloqueoChequeo','.disabled=false');
                  accion(FORMULARIO+'.FaltanteMercaderia','.disabled=false');
                  accion(FORMULARIO+'.IngresaEnvia','.disabled=false');
                  accion(FORMULARIO+'.DevuelveGeneraEnvia','.disabled=true');
                  if ( checkIngresaDevuelve == 'S' ){
                           accion(FORMULARIO+'.DevuelveGeneraEnvia','.disabled=false');
                  }
                           
         }
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function perdida(){
         
/*
 * Se selecciona perdida, 
 * pero no se introduce tipoSolicitudPerdida 
 * Mostrar Mensaje REC002 
 */
           
          var checkPerdida = get(FORMULARIO + '.Perdida');
          var cbTipoSolicitudPerdida = get(FORMULARIO + '.cbTipoSolicitudPerdida');
          
          if (( checkPerdida == 'S' ) && ( cbTipoSolicitudPerdida == '')) { 
                   GestionarMensaje('REC002');
                   devuelve = false;
          }else{
                  devuelve = true;
          }
          return devuelve;	 

}


// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function tipoSolicitudPerdida (){
         
/* 
 * Se selecciona un tipoSolicitudPerdida pero sin indicar perdida 
 * mostrar mensaje REC002 
 */
         
         var checkPerdida = get(FORMULARIO + '.Perdida');
         var cbTipoSolicitudPerdida = get(FORMULARIO + '.cbTipoSolicitudPerdida');
         
         if (( checkPerdida == 'N' ) && ( cbTipoSolicitudPerdida != '')) { 
                  GestionarMensaje('REC002');
                  devuelve = false;
         }else{
                  devuelve = true;
         }	
         
         return devuelve; 
         
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function almacenMovimiento(){
         
/*
 * Si no se ha seleccionado nada en la combo cbAlmacen o en cbMovimientoAlmacen  
 * mostrar mensaje: REC004 
 */

          var cbAlmacen = get(FORMULARIO + '.cbAlmacen');
          var cbMovimientoAlmacen  = get(FORMULARIO + '.cbMovimientoAlmacen');
          var checkIngresaDevuelve = get(FORMULARIO + '.IngresaDevuelve');
          var checkEnviaGeneraDevuelve = get(FORMULARIO + '.EnviaGeneraDevuelve');
          // Cambio por ssantana, 18/10/2005, inc. 21240 - El DMCO indica que por defecto se retorna true.
          var devuelve = true;
          // Fin cambio por ssantana, 18/10/2005
          
          //modificado por incidencia 19566
          if (( checkIngresaDevuelve == 'S') || ( checkEnviaGeneraDevuelve == 'S' )) {

          	if (( cbAlmacen != '' ) && ( cbMovimientoAlmacen  != '')) { 
                           devuelve = true;
          	}else{
                           GestionarMensaje('REC004');
                           devuelve = false;
          	}

          }
          
          return devuelve;	 	 
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function ontabbtnConsultarTiposOperaciones(){
         var opcionMenu = get( FORMULARIO + '.opcionMenu');
         if(opcionMenu == 'consultar operacion')
                  document.all['btnConsultarTiposOperaciones'].focus();
                  
         focaliza(FORMULARIO + '.txtCodigoOperacion');

}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onshtabtxtCodigoOperacion(){

         document.all['btnConsultarTiposOperaciones'].focus();

}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fVolver(){
         window.close();
}


// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar(){
         
         //asignamos el valor de los hiddens a los combos
         set( FORMULARIO + '.cbPrecios',[get(FORMULARIO + '.oidPrecios')]);
         set( FORMULARIO + '.cbTipoSolicitudPerdida',[get(FORMULARIO + '.oidTipoSolicitudPerdida')]);
         set( FORMULARIO + '.cbPrecioEnvia',[get(FORMULARIO + '.oidPrecioEnvia')]);
         set( FORMULARIO + '.cbBloqueoChequeo',[get(FORMULARIO + '.oidBloqueoChequeo')]);
         set( FORMULARIO + '.cbTipoSolicitud1',[get(FORMULARIO + '.oidTipoSolicitud1')]);
         set( FORMULARIO + '.cbTipoSolicitud2',[get(FORMULARIO + '.oidTipoSolicitud2')]);
         set( FORMULARIO + '.cbCodigoMensajeGenerar',[get(FORMULARIO + '.oidCodigoMensajeGenerar')]);
         set( FORMULARIO + '.cbTipoSolicitudGenera',[get(FORMULARIO + '.oidTipoSolicitudGenera')]);
         set( FORMULARIO + '.cbAlmacen',[get(FORMULARIO + '.oidAlmacen')]);
         set( FORMULARIO + '.cbMovimientoAlmacen',[get(FORMULARIO + '.oidMovimientoAlmacen')]);
         
         //asignamos el valor de los hiddens a los check
         set(FORMULARIO+'.Anulacion',get(FORMULARIO+'.anulacion'));
         set(FORMULARIO+'.Perdida',get(FORMULARIO+'.perdida'));
         set(FORMULARIO+'.EsperarMercanciaFisica',get(FORMULARIO+'.esperarMercanciaFisica'));
         set(FORMULARIO+'.DevueltoFisicoFactura',get(FORMULARIO+'.devueltoFisicoFactura'));
         set(FORMULARIO+'.FaltanteMercaderia',get(FORMULARIO+'.faltanteMercaderia'));
         set(FORMULARIO+'.IngresaEnvia',get(FORMULARIO+'.ingresaEnvia'));
         set(FORMULARIO+'.EnviaGeneraDevuelve',get(FORMULARIO+'.enviaGeneraDevuelve'));
         set(FORMULARIO+'.IngresaDevuelve',get(FORMULARIO+'.ingresaDevuelve'));
         set(FORMULARIO+'.DevuelveGeneraEnvia',get(FORMULARIO+'.devuelveGeneraEnvia'));
  
  //vbongiov -- GCC-COL-REC-001-- 17/12/2007   
  set(FORMULARIO+'.recojo',get(FORMULARIO+'.hRecojo'));
  set(FORMULARIO + '.cbTipoSolicitudRecojoInicial',[get(FORMULARIO+'.hOidTipoSolicitudRecojoInicial')]);
  set(FORMULARIO + '.cbTipoSolicitudPrimerRecojoNoExitoso',[get(FORMULARIO+'.hOidTipoSolicitudPrimerRecojoNoExitoso')]);
  set(FORMULARIO + '.cbTipoSolicitudSegundoRecojoNoExitoso',[get(FORMULARIO+'.hOidTipoSolicitudSegundoRecojoNoExitoso')]);
  set(FORMULARIO + '.cbAlmacenPostVenta',[get(FORMULARIO+'.hOidAlmacenPostVenta')]);
  set(FORMULARIO + '.cbMovimientoAlmacenRecojoInicial',[get(FORMULARIO+'.hOidMovimientoAlmacenRecojoInicial')]);
  set(FORMULARIO + '.cbMovimientoAlmacenRecojoExitoso',[get(FORMULARIO+'.hOidMovimientoAlmacenRecojoExitoso')]);
  set(FORMULARIO + '.cbMovimientoAlmacenRecojoNoExitoso',[get(FORMULARIO+'.hOidMovimientoAlmacenRecojoNoExitoso')]);
  
  onSelectedRecojo();
    
  ingresaEnvia(); 
         generaEnvia();
         anulacion(); 
         ingresaDevuelve(); 
         generaDevuelve(); 
    
    focaliza( FORMULARIO + '.txtCodigoOperacion' );
}
 
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function aMayusculas(campo){
    if (get(FORMULARIO+'.'+campo)!='') {
          set(FORMULARIO+'.'+campo,get(FORMULARIO+'.'+campo).toUpperCase());
    }
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function insercionCorrecta(){
         set(FORMULARIO+'.txtCodigoOperacion','');
         set(FORMULARIO+'.txtDescripcionCorta','');
         set(FORMULARIO+'.txtDescripcionLarga','');
         set(FORMULARIO+'.txtNumeroCampanas','');
         fLimpiar();
         set(FORMULARIO+'.listaTiposOperaciones','');
         set(FORMULARIO+'.listaTiposSinFormatear','');
         
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
function modificacionCorrecta(){
         
         var codOperacion = get(FORMULARIO+'.txtCodigoOperacion');
         var descCorta = get(FORMULARIO+'.txtDescripcionCorta');
         var descLarga = get(FORMULARIO+'.txtDescripcionLarga');
         window.returnValue = [codOperacion,descCorta,descLarga];
    window.close();
}

