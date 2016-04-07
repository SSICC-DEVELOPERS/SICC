// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag(){
	 configurarMenuSecundario("frmFormulario");     
	 showError();
     // Modificado SiCC 20070316 - Rafael Romero - 18/07/2007
     document.all["ConsultarDiv"].style.visibility='hidden';
     document.all["Consultar2Div"].style.visibility='hidden';
     // fin modificado SiCC 20070316
	 ckVentaExclusivaOnChange();
	 posicionaRadioButtons();     
	 if(get('frmFormulario.hidCKDespachoCompleto')!=""){
		  set('frmFormulario.ckDespachoCompleto', get('frmFormulario.hidCKDespachoCompleto'));
	 }
	 if(get('frmFormulario.hidCKDespachoAutomatico')!=""){
		  set('frmFormulario.ckDespachoAutomatico', get('frmFormulario.hidCKDespachoAutomatico'));
	 }    
	 if(get('frmFormulario.hidCKRecuperacionObligatoria')!=""){
		  set('frmFormulario.ckRecObligPedido', get('frmFormulario.hidCKRecuperacionObligatoria'));
	 }              
	 posicionaCombos();
	 configuraPantalla();
	 if(get('frmFormulario.hDeshabilitaTodo') == 'S'){
		  deshabilitaTodo();
	 }
  
	 DrdEnsanchaConMargenDcho('listado1',12);
	 DrdEnsanchaConMargenDcho('listado2',12);     
	 DrdEnsanchaConMargenDcho('listado5',36);

	 eval (ON_RSZ);
	 if (get('frmFormulario.casoDeUso')=='consultar'){
		  btnProxy(4,0);
		  btnProxy(2,1);
	 }else{
		  btnProxy(4,1);
		  btnProxy(2,0);
		  focaliza('frmFormulario.cbArgumentoVenta','');                  
	 }
	 btnProxy(7,0);
	 btnProxy(8,0);
	 btnProxy(9,0);
	 ensanchaListaEditables();
 }

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
 function ensanchaListaEditables(){
	 var nombresListas = get('frmFormulario.varNombresListasDinamicas');
	 if (nombresListas!=null && nombresListas != ""){
		  arrayNombres = nombresListas.split("|");
		  for(i = 0; i < arrayNombres.length; ++i) {
			  DrdEnsanchaConMargenDcho(arrayNombres[i],40);
		  }         
		  eval (ON_RSZ);
	 }
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function metodoListaEditable(){
	 var arrayNomListas = get('frmFormulario.hNombreListas').split("|"); 
	 for ( i = 0 ; i < arrayNomListas.length; i++) {             
		  DrdEnsanchaConMargenDcho(arrayNomListas[i],12); 
		  //document.all[arrayNomListas[i]+"_pri1Div"].style.visibility='hidden';
		  //document.all[arrayNomListas[i]+"_ret1Div"].style.visibility='hidden';
		  //document.all[arrayNomListas[i]+"_ava1Div"].style.visibility='hidden';                            
	 }     
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function showError(){
	 if( get('frmFormulario.casoDeUso')=='consultar' ){
		  fMostrarMensajeError();
		  //window.close();
	 }else{
		  if (get('frmFormulario.errCodigo') != ''){
			  fMostrarMensajeError();
			  /*set("frmFormulario.conectorAction", "LPModificarOferta");
			  set("frmFormulario.accion", "vuelveError");
			  enviaSICC("frmFormulario");*/
		  }else if (get('frmFormulario.hValorError') == 'PRE0014'){
			  GestionarMensaje('PRE0014'); 
		  } else if (get('frmFormulario.hValorError') == 'PRE0011'){
			  GestionarMensaje('PRE0011'); 
			  deshabilitaTodo();
		  }
				   }
 }

 // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function fBorrar(){
	 accionEliminarOferta();
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function accionEliminarOferta(){
	 set("frmFormulario.conectorAction", "LPModificarOferta");
	 set("frmFormulario.accion", "EliminarOferta");
	 enviaSICC("frmFormulario");
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function accionBuscarProducto(){
	 set("frmFormulario.conectorAction", "LPModificarOferta");
	 set("frmFormulario.accion", "BuscarProducto");
	 enviaSICC("frmFormulario");
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function accionBuscarProductoAsoc(){
	 set("frmFormulario.conectorAction", "LPModificarOferta");
	 set("frmFormulario.accion", "BuscarProductoAsoc");
	 enviaSICC("frmFormulario");
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function accionEliminarProductos(){
	 if (listado2.numSelecc()>0){
		  if(GestionarMensaje("5")){
			  set('frmFormulario.accion','eliminarProductos');
			  set("frmFormulario.conectorAction", "LPModificarOferta");
			  set('frmFormulario.elemSelecc',listado2.codSeleccionados());
			  enviaSICC('frmFormulario');
		  }
	 }
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function accionModificarGrupo(codigo){
	 set("frmFormulario.hidNroGrupo", codigo);             
	 set("frmFormulario.conectorAction", "LPModificarOferta");
	 set("frmFormulario.accion", "ModificarGrupo");
	 enviaSICC("frmFormulario");
 }
 
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionAniadirGrupo(){

		if (get('frmFormulario.cbTipoGrupo2')=='2'){
			 if((get('frmFormulario.txtNumeroPaquetes')<get('frmFormulario.maxGrupo'))||
				  (get('frmFormulario.maxGrupo')=='')){
					set("frmFormulario.conectorAction", "LPModificarOferta");
					set("frmFormulario.accion", "AnadirGrupo");
					enviaSICC("frmFormulario");                  
			 } else {
					GestionarMensaje("715");
			 }
		} else {
			 if((get('frmFormulario.txtNumeroGrupos')<get('frmFormulario.maxGrupo'))||
				  (get('frmFormulario.maxGrupo')=='')){
				   if (get('frmFormulario.cbTipoGrupo2')=='4'){
					   if((get('frmFormulario.txtNumeroGruposCondicionantes')<get('frmFormulario.maxGruposCondicionantes'))||
							(get('frmFormulario.maxGruposCondicionantes')=='')){
							  set("frmFormulario.conectorAction", "LPModificarOferta");
							  set("frmFormulario.accion", "AnadirGrupo");
							  enviaSICC("frmFormulario");
					   } else {
						GestionarMensaje("713");
					   }
				   } else if (get('frmFormulario.cbTipoGrupo2')=='3'){
					   if((get('frmFormulario.txtNumeroGruposCondicionados')<get('frmFormulario.maxGruposCondicionados'))||
							(get('frmFormulario.maxGruposCondicionados')=='')){
							  set("frmFormulario.conectorAction", "LPModificarOferta");
							  set("frmFormulario.accion", "AnadirGrupo");
							  enviaSICC("frmFormulario");                            
					   } else {
						GestionarMensaje("714");
					   }
				   } else {         
					  set("frmFormulario.conectorAction", "LPModificarOferta");
					  set("frmFormulario.accion", "AnadirGrupo");
					  enviaSICC("frmFormulario");
				  }
			 }else{
				  GestionarMensaje("712");             
			 }
		}
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function accionAniadirCondicion(){
	 set("frmFormulario.conectorAction", "LPModificarOferta");
	 set("frmFormulario.accion", "AnadirCondicion");
	 enviaSICC("frmFormulario");
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function accionModificarCondicion(codigo){
	 set("frmFormulario.hidNroCondicion", codigo);             
	 set("frmFormulario.conectorAction", "LPModificarOferta");
	 set("frmFormulario.accion", "ModificarCondicion");
	 enviaSICC("frmFormulario");
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function accionEliminarCondicion(boton) {
	 set("frmFormulario.conectorAction", "LPModificarOferta");
		  if (get('frmFormulario.nroPromociones') == 1){
			  GestionarMensaje("185");
			  return;
	 }else {
		  set("frmFormulario.accion", "EliminarCondicion");
		  set("frmFormulario.hOidCondicion", eval(boton).codigo);
		  enviaSICC("frmFormulario");
	 }
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function accionEliminarGrupo(boton){
	 if (get('frmFormulario.hidNroGrupos') == 1){
		  if (get('frmFormulario.hidECondicionada' ) == 'S' ){
			  GestionarMensaje("183");
			  return;
		  }else{
			  GestionarMensaje("1110");
			  return;
		  }           
	 }else{
		 if (get('frmFormulario.hidNroPaquetes' ) == 1 ){
				 GestionarMensaje("184");
				 return;
		 }
		 var ngrp;
		 if (get('frmFormulario.hidNroPaquetes' ) > 1 ){                 
		  ngrp = new Number(get('frmFormulario.txtNumeroPaquetes'));
		  var res = ngrp-new Number('1');
		  set('frmFormulario.txtNumeroPaquetes',res);   
		 } else { 
		  ngrp = new Number(get('frmFormulario.txtNumeroGrupos'));
		  var res = ngrp-new Number('1');
		  set('frmFormulario.txtNumeroGrupos',res);
		 }
	 
		  set("frmFormulario.conectorAction", "LPModificarOferta");
		  set("frmFormulario.accion", "EliminarGrupo");
		  set("frmFormulario.hidNroGrupo", eval(boton).codigo);
		  enviaSICC("frmFormulario");
	 }
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function accionAniadirVentaExclusiva(){ 
	 if (sicc_validaciones_generales("ventaExclusiva")){
		  set('frmFormulario.hDesTipoCliente',get('frmFormulario.cbTipoCliente','T'));
		  set('frmFormulario.hDesSubtipoCliente',get('frmFormulario.cbSubTipoCliente','T'));
		  set('frmFormulario.hDesTipoClasificacion',get('frmFormulario.cbTipoClasificacionCliente','T'));
		  set('frmFormulario.hDesClasificacion',get('frmFormulario.cbClasificacionCliente','T'));
		  set('frmFormulario.hDesEstatusCliente',get('frmFormulario.cbEstatusCliente','T'));
		  set('frmFormulario.txtEstatus2',get('frmFormulario.txtEstatus2Cliente'));

		  set("frmFormulario.conectorAction", 'LPModificarOferta');      
		  set('frmFormulario.accion','aniadirVentaExclusiva');
		  enviaSICC('frmFormulario');
	 }         
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function accionEliminarVentaExclusiva(){
	 if (listado5.numSelecc()>0){
		  if(GestionarMensaje("5")){
			  set("frmFormulario.conectorAction", "LPModificarOferta");
			  set("frmFormulario.accion", "eliminarVentaExclusiva");
			  set('frmFormulario.elemSelecc',listado5.codSeleccionados());
			  enviaSICC('frmFormulario');
		  }
	 } 
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function ckVentaExclusivaOnChange(){
	 if (listado5.codigos().length >0){
		  set('frmFormulario.ckVentaExclusiva4','S');
	 }           
	 if ((get('frmFormulario.ckVentaExclusiva4')=='S')){   
		  //deshabilitarHabilitarBoton('botonContenido','btnAnadir5','A')
		  document.all["btnAnadir5"].style.visibility='visible'
		  accion('frmFormulario.cbTipoCliente','.disabled=false');
		  accion('frmFormulario.cbSubTipoCliente','.disabled=false');
		  accion('frmFormulario.cbTipoClasificacionCliente','.disabled=false');
		  accion('frmFormulario.cbClasificacionCliente','.disabled=false');
		  accion('frmFormulario.cbEstatusCliente','.disabled=false');
		  accion('frmFormulario.txtEstatus2Cliente','.disabled=false');
		//Unidad Administrativa
		accion('frmFormulario.cbRegion','.disabled=false');
		accion('frmFormulario.cbZona','.disabled=true');
		accion('frmFormulario.rbRegion','.disabled=false');
		accion('frmFormulario.rbZona','.disabled=false');
		accion('frmFormulario.rbRegion','.checked=true');
		  document.all["Eliminar5Div"].style.visibility='visible'
	 }else if ((get('frmFormulario.ckVentaExclusiva4')=='N')){             
		  accion('frmFormulario.cbTipoCliente','.disabled=true');
		  accion('frmFormulario.cbSubTipoCliente','.disabled=true');
		  accion('frmFormulario.cbTipoClasificacionCliente','.disabled=true');
		  accion('frmFormulario.cbClasificacionCliente','.disabled=true');
		  accion('frmFormulario.cbEstatusCliente','.disabled=true');
		  accion('frmFormulario.txtEstatus2Cliente','.disabled=true');                  
		  //deshabilitarHabilitarBoton('botonContenido','btnAnadir5','D')
		//Unidad Administrativa
		accion('frmFormulario.cbRegion','.disabled=true');
		accion('frmFormulario.cbZona','.disabled=true');
		accion('frmFormulario.rbRegion','.disabled=true');
		accion('frmFormulario.rbZona','.disabled=true');
		iRegion = new Array();
		iZona = new Array();
		set('frmFormulario.cbRegion', iRegion);
		set('frmFormulario.cbZona', iZona);
		  document.all["btnAnadir5"].style.visibility='hidden'
		  document.all["Eliminar5Div"].style.visibility='hidden'             
	 }
 }
 
 // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function deshabilitaTodo(){   
	 visibilidad('btnAnadir5','O');
	 document.all["BuscarDiv"].style.visibility='hidden';
     document.all["ModificarDiv"].style.visibility='hidden';
	 document.all["Eliminar5Div"].style.visibility='hidden';
	 accion('frmFormulario.cbArgumentoVenta','.disabled=true');
//	 accion('frmFormulario.txtNumeroOrden','.disabled=true'); se eliminar por pedido de cambio PRE-003
	 accion('frmFormulario.txtNumeroGrupos','.disabled=true');
	 accion('frmFormulario.txtNumeroPaquetes','.disabled=true');
	 accion('frmFormulario.cbIndicadorCuadre','.disabled=true');
	 accion('frmFormulario.txtNumeroGruposCondicionantes','.disabled=true');
		  
	 accion('frmFormulario.txtNumeroGruposCondicionados','.disabled=true');                
	 document.all.rbCondicionCondicionantes[0].disabled=true;
	 document.all.rbCondicionCondicionantes[1].disabled=true;
	 document.all.rbCondicionCondicionados[0].disabled=true; 
	 document.all.rbCondicionCondicionados[1].disabled=true;  
	 
	 accion('frmFormulario.cbFormasPago','.disabled=true');
	 accion('frmFormulario.ckDespachoCompleto','.disabled=true');
	 accion('frmFormulario.ckDespachoAutomatico','.disabled=true');
	 accion('frmFormulario.ckRecObligPedido','.disabled=true');  
	 accion('frmFormulario.ckVentaExclusiva4','.disabled=true');
	 accion('frmFormulario.cbTipoCliente','.disabled=true');
	 accion('frmFormulario.cbSubTipoCliente','.disabled=true');
	 accion('frmFormulario.cbTipoClasificacionCliente','.disabled=true');
	 accion('frmFormulario.cbClasificacionCliente','.disabled=true');
	 accion('frmFormulario.cbEstatusCliente','.disabled=true');
	 accion('frmFormulario.txtEstatus2Cliente','.disabled=true');        
	 document.all.rbRegion[0].disabled=true;
	 document.all.rbRegion[1].disabled=true;
	 document.all.rbZona[0].disabled=true; 
	 document.all.rbZona[1].disabled=true;  	 
	 accion('frmFormulario.cbRegion','.disabled=true');
	 accion('frmFormulario.cbZona','.disabled=true');
 }
	 
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function tipoClienteOnChange(){
	 accion('frmFormulario.cbSubTipoCliente','.disabled=false');
	 recargaCombo('frmFormulario.cbSubTipoCliente', 'MAEobtenerSubtipos', 
	 'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormulario.cbTipoCliente')));
						   
	 set('frmFormulario.cbTipoClasificacionCliente','');
	 accion('frmFormulario.cbTipoClasificacionCliente','.disabled=true');

	 set('frmFormulario.cbClasificacionCliente','');
	 accion('frmFormulario.cbClasificacionCliente','.disabled=true');
 }
		 
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function subtipoClienteOnChange(){
	 accion('frmFormulario.cbTipoClasificacionCliente','.disabled=false');
	 recargaCombo('frmFormulario.cbTipoClasificacionCliente', 'MAEobtenerTipoClasificacion', 
	 'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormulario.cbSubTipoCliente')));
 }
		 
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function tipoClasificacionOnChange(){
	 accion('frmFormulario.cbClasificacionCliente','.disabled=false');
	 recargaCombo('frmFormulario.cbClasificacionCliente', 'MAEobtenerClasificacionesPorTipo', 
	 'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormulario.cbTipoClasificacionCliente')));
 }
 
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function posicionaCombos(){
	 array = new Array();
	 array[0] = get('frmFormulario.hFormaPago');
	 set('frmFormulario.cbFormasPago',array);
	 array = new Array();
	 array[0] = get('frmFormulario.hIndCuadre');
	 set('frmFormulario.cbIndicadorCuadre',array);
	 array = new Array();
	 array[0] = get('frmFormulario.hidOidArgVenta');
	 set('frmFormulario.cbArgumentoVenta',array);
	 if (!get('frmFormulario.hValorError') == 'PRE0011'){
		  focaliza('frmFormulario.cbArgumentoVenta','');
	 }                  
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function posicionaRadioButtons(){
	 //alert('condtes:'+get('frmFormulario.hidRDCondicionantes'));
	 set('frmFormulario.rbCondicionCondicionantes', get('frmFormulario.hidRDCondicionantes')); 
	 set('frmFormulario.rbCondicionCondicionados', get('frmFormulario.hidRDCondicionados'));              
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		 
 function configuraPantalla(){
	 accion('frmFormulario.txtNumeroGrupos','.disabled=true');
	 accion('frmFormulario.txtNumeroGruposCondicionantes','.disabled=true');
	 accion('frmFormulario.txtNumeroGruposCondicionados','.disabled=true');
	 accion('frmFormulario.txtNumeroPaquetes','.disabled=true');

  
	 if (get('frmFormulario.hidHabilitaIndicadorCuadre')=='N'){
		  accion('frmFormulario.cbIndicadorCuadre','.disabled=true');  
	 }

	 if (listado1.codigos().length >0){
        // Modificado por SICC 20070316 - Rafael Romero - 17/07/2007
        if (get('frmFormulario.casoDeUso')=='consultar'){
            document.all["ConsultarDiv"].style.visibility='visible';
        }else{
            document.all["BuscarDiv"].style.visibility='visible'
            document.all["ModificarDiv"].style.visibility='visible'
        }
        // fin SiCC 20070316
	 }else{
		  document.all["BuscarDiv"].style.visibility='hidden'
      document.all["ModificarDiv"].style.visibility='hidden'
	 }
	 
	 if (get('frmFormulario.btnBPAsoc')=='true'){
		  document.all["Buscar2Div"].style.visibility='visible'
		  document.all["Eliminar2Div"].style.visibility='visible'
	 }else{
		  document.all["Buscar2Div"].style.visibility='hidden'
		  document.all["Eliminar2Div"].style.visibility='hidden'
	 }

		 // Agregado por ssantana, 6/10/2005, cambio SICC-GCC-PRE-001
		 var estadoBotonModificar = get('frmFormulario.btnMPAsoc');
		 //alert("estadoBotonModificar: " + estadoBotonModificar);
		 //estadoBotonModificar = 'true'; // Quitar!!!! Hardcodeado. Solo para testeo, por el momento

		 if ( estadoBotonModificar == 'true') {
				//alert("habilita");
                // Modificado SiCC 20070316 - Rafael Romero - 18/07/2007
                if (get('frmFormulario.casoDeUso')=='consultar'){
                    document.all["Consultar2Div"].style.visibility='visible';
                }else{
                    document.all['Modificar2Div'].style.visibility = 'visible';
                }
                // fin modificado SiCC 20070316
		 } else {
				//alert("Deshabilita");
				document.all['Modificar2Div'].style.visibility = 'hidden';
                // Agregado por SICC20070316 - Rafael Romero - 19/07/2007
                if (get('frmFormulario.casoDeUso')=='consultar' && listado2.codigos().length >0){
                    document.all["Consultar2Div"].style.visibility='visible';
                }
         }
		 // Fin Agregado por ssantana, 6/10/2005, cambio SICC-GCC-PRE-001

	 // inhabilito si la estrategia no es de tipo condicionada
	 if (get('frmFormulario.hidECondicionada')=='N'){
		  /*accion('frmFormulario.txtNumeroGruposCondicionantes','.disabled=true');  
		  accion('frmFormulario.txtNumeroGruposCondicionados','.disabled=true');*/
		  //para las esrtategias de tipo Vs
		  if (get('frmFormulario.hidEstrategiaVS')=='N'){
			  document.all.rbCondicionCondicionantes[0].disabled=true;
			  document.all.rbCondicionCondicionantes[1].disabled=true;
			  document.all.rbCondicionCondicionados[0].disabled=true; 
			  document.all.rbCondicionCondicionados[1].disabled=true;
		  }else{
			  document.all.rbCondicionCondicionantes[0].disabled=false;
			  document.all.rbCondicionCondicionantes[1].disabled=false;
			  document.all.rbCondicionCondicionados[0].disabled=true; 
			  document.all.rbCondicionCondicionados[1].disabled=true;
		  }             
	 }else{
		  /*accion('frmFormulario.txtNumeroGruposCondicionantes','.disabled=false');  
		  accion('frmFormulario.txtNumeroGruposCondicionados','.disabled=false');*/
		  document.all.rbCondicionCondicionantes[0].disabled=false;
		  document.all.rbCondicionCondicionantes[1].disabled=false;
		  document.all.rbCondicionCondicionados[0].disabled=false; 
		  document.all.rbCondicionCondicionados[1].disabled=false;
	 }


	 if (get('frmFormulario.hidHabiDesAutomatico')=='N'){
		  accion('frmFormulario.ckDespachoAutomatico','.disabled=true');
	 }
	 if (get('frmFormulario.hidHabiDesCompleto')=='N'){
		  accion('frmFormulario.ckDespachoCompleto','.disabled=true');
	 }
	 
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function fGuardar(){            
	 if (sicc_validaciones_generales("guardar")){
		  set('frmFormulario.hidOidArgumentoVenta', get('frmFormulario.cbArgumentoVenta'));
//		  set('frmFormulario.hidNroOrden', get('frmFormulario.txtNumeroOrden'));se eliminar por pedido de cambio PRE-003
		  set('frmFormulario.hFormaPago', get('frmFormulario.cbFormasPago'));
		  
		  if (get('frmFormulario.hidHabilitaIndicadorCuadre')=='S'){
			  if (sicc_validaciones_generales("cbIndicadorCuadre")){
				   set('frmFormulario.hidOidIndicadorCuadre',get('frmFormulario.cbIndicadorCuadre'));
			  }else{
				   return false;
			  }
		  }
		  if( get('frmFormulario.hidECondicionada')=='S' ){                 
			  if( sicc_validaciones_generales("condicionante,condicionado,condicionadatexto") ){
				   set('frmFormulario.hidRDCondicionantes',get('frmFormulario.rbCondicionCondicionantes'));
				   set('frmFormulario.hidRDCondicionados',get('frmFormulario.rbCondicionCondicionados'));
				   set('frmFormulario.hidGruposCnantes',get('frmFormulario.txtNumeroGruposCondicionantes'));
				   set('frmFormulario.hidGruposCnados',get('frmFormulario.txtNumeroGruposCondicionados'));
			  }else{
				   return false;
			  }
		  }             
		  if (get('frmFormulario.hidEstrategiaVS')=='S'){
			  if( sicc_validaciones_generales("condicionante") ){
				   set('frmFormulario.hidRDCondicionantes', get('frmFormulario.rbCondicionCondicionantes'));                          
				   set('frmFormulario.hidRDCondicionados', get('frmFormulario.rbCondicionCondicionados'));
			  }else{
				   return false;
			  }
		  }
	 }else{
		  return false;
	 }

	 if (get('frmFormulario.hidHabiDesCompleto')=='S'){
		  set('frmFormulario.hidCKDespachoCompleto', get('frmFormulario.ckDespachoCompleto'));
	 }

	 if (get('frmFormulario.hidHabiDesAutomatico')=='S'){
		  set('frmFormulario.hidCKDespachoAutomatico', get('frmFormulario.ckDespachoAutomatico'));
	 }
	 
	 set('frmFormulario.hidCKRecuperacionObligatoria', get('frmFormulario.ckRecObligPedido'));

	 if (get('frmFormulario.ckVentaExclusiva4')=='S'){//verifico que haya al menos una venta exclusiva
		  if (listado5.codigos().length<1){
			  GestionarMensaje('2524');
			  return;
		  }
	 }                     
	 set("frmFormulario.conectorAction", "LPModificarOferta");
	 set("frmFormulario.accion", "Guardar");
	 enviaSICC("frmFormulario");
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		 
 function recargaCombo(combo, idBusiness, dto, parametros) {
	 asignar([['COMBO', combo, 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET',
	 formarCadena(idBusiness, dto, parametros)]]);
 }
 
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function formarCadena(idBusiness , dto, parametros) {
	 var cadena = idBusiness + "|" + dto + "|"; 
	 for(i=0;i<parametros.length;i++) {
		  cadena += parametros[i][0] + "=" + parametros[i][1];
		  if (i!= parametros.length-1) {
			  cadena += "&";
		  }
	 }
	 return cadena;
 }
		
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function makeParameter(nombre, oid){
	 var array = new Array();
	 var i=0;
	 array[i] = new Array('oidPais','1');
	 i++;
	 array[i] = new Array('oidIdioma','1');
	 i++;
	 array[i] = new Array(nombre,oid)
	 return array;
 }

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
 function fLimpiar(){
	 set("frmFormulario.accion","ObtenerOfertaModificacion");
	 enviaSICC("frmFormulario");
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function fVolver(){
	 window.close();
	 set('frmFormulario.casoDeUso','consultar');
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function tabGenerico(nombreComp, tipotab){        
	 var arr = arrayComponentes();
	 var tabular = false;
	 var nombreFormulario = getFormularioSICC();
	 var j = 0;
	 var k = arr.length;
	 if (tipotab != "sh") {
		  j = j-1;                  
		  k = k-1;
	 }

	 while(j<k){
		  var t;
		  if(tipotab == "sh"){
			k--;
			t = k;
		  } else{
			j++;
			t = j;                    
		  }
			
		  var nombre = arr[t][0];
		  var tipo = arr[t][1];
		  if (tabular==false){
			if (nombreComp==nombre){
				 tabular=true;
				 if (tipotab == "sh"){
				   if (k==0) k= arr.length;
				 } else {
				   if ((j+1)==arr.length)  j = -1;
				 }
			}                  
		  } else {
			try {
			  var name = nombreFormulario+"."+nombre;
			  if (tipo=="BOTONXY"){
				  focalizaBotonHTML_XY(nombre);
			  } else if (tipo=="BOTON") {
				  focalizaBotonHTML("botonContenido",nombre)
			  } else {
				  focaliza(name);
			  }
			  return;
			} catch (e) {
			  if ((j+1)==arr.length)  j = -1;
			}
		  }
	 }
   }    

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   function arrayComponentes(){
		var arr = new Array();
		//arr[arr.length]= new Array("cbAcceso","");
		//arr[arr.length]= new Array("cbSubacceso","");
		arr[arr.length]= new Array("cbArgumentoVenta","");
//		arr[arr.length]= new Array("txtNumeroOrden","");se eliminar por pedido de cambio PRE-003

		arr[arr.length]= new Array("Buscar","BOTONXY");
        arr[arr.length]= new Array("Modificar","BOTONXY");
        arr[arr.length]= new Array("Consultar","BOTONXY");
		arr[arr.length]= new Array("Buscar2","BOTONXY");
        arr[arr.length]= new Array("Modificar2","BOTONXY");
        arr[arr.length]= new Array("Consultar2","BOTONXY");
		arr[arr.length]= new Array("Eliminar2","BOTONXY");                

		arr[arr.length]= new Array("txtNGrupos","");
		arr[arr.length]= new Array("txtNPaquetes","");
		arr[arr.length]= new Array("cbIndicadorCuadre","");           

		arr[arr.length]= new Array("txtNGrupCondicionantes","");
		arr[arr.length]= new Array("rbCondicionCondicionantes","");
		arr[arr.length]= new Array("txtNGrupCondicionados","");
		arr[arr.length]= new Array("rbCondicionCondicionados","");

		arr[arr.length]= new Array("ckDespachoCompleto","");
		arr[arr.length]= new Array("ckDespachoAutomatico","");                     

		arr[arr.length]= new Array("ckRecObligPedido","");
		arr[arr.length]= new Array("cbFormasPago","");

		//aca las promociones
		var npro = new Number(get('frmFormulario.hidNroPromo'));

		if (npro>0){
		  for (var i=0; i<npro;i++){                      
			  arr[arr.length]= new Array("Modificar8"+i,"BOTONXY");
			  arr[arr.length]= new Array("btnEliminar8"+i,"BOTON");
		  }
		  arr[arr.length]= new Array("btnAnadir","BOTON");
		}
		
		//aca los grupos
		var ngr = new Number(get('frmFormulario.hidNroGrupos'));
		var ngrcondos = new Number(get('frmFormulario.hidNroCondicionados'));
		var ngrcondtes = new Number(get('frmFormulario.hidNroCondicionantes'));
		var npaq = new Number(get('frmFormulario.hidNroPaquetes'));

		var ntotgr = ngr + npaq;
		if (ntotgr>0){
		  for (var i=0; i<ntotgr;i++){                      
			  arr[arr.length]= new Array("Modificar4"+i,"BOTONXY");
			  arr[arr.length]= new Array("btnEliminar"+i,"BOTON");
		  }
		  arr[arr.length]= new Array("cbTipoGrupo2","");
		  arr[arr.length]= new Array("btnAnadir2","BOTON");
		}
		
		arr[arr.length]= new Array("ckVentaExclusiva4","");
		arr[arr.length]= new Array("cbTipoCliente","");
		arr[arr.length]= new Array("cbSubtipoCliente","");
		arr[arr.length]= new Array("cbTipoClasificacionCliente","");
		arr[arr.length]= new Array("cbClasificacionCliente","");
		arr[arr.length]= new Array("cbEstatusCliente","");
		arr[arr.length]= new Array("txtEstatus2Cliente","");

		arr[arr.length]= new Array("btnAnadir5","BOTON");

		arr[arr.length]= new Array("Eliminar5","BOTONXY");              
		
		return arr;
   }    


// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Añadido por ssantana, 5/10/2005
// Por cambio GCC-PRE-001.
  function accionModificarProducto() {
	  listado1.actualizaDat();
	  // Nos fijamos si hay algún producto seleccionado para listado1.
	  var numSelec = listado1.numSelecc();
	  if ( numSelec < 1) {
		  GestionarMensaje("PRE0025", null, null, null);   // Debe seleccionar un producto.
	  } else {
		  var codSeleccionados = listado1.codSeleccionados();
		  var arrayDatos = obtieneLineasSeleccionadas(codSeleccionados, 'listado1'); 
		  var cadenaLista = serializaLineasDatos(arrayDatos);

          set("frmFormulario.hidCodSeleccionadosLE", "[" + codSeleccionados + "]");

		  //alert("cod seleccionados: " + get("frmFormulario.hidCodSeleccionadosLE") );
		  set("frmFormulario.hidListaEditable", cadenaLista);
		  set("frmFormulario.conectorAction", "LPModificarOferta");
		  set("frmFormulario.accion", "Modificar producto");
		  enviaSICC("frmFormulario");
	  }
  }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Añadido por ssantana, 5/10/2005
// Por cambio GCC-PRE-001.
  function accionModificarProductoAsociado() {
	  listado2.actualizaDat();
	  // Nos fijamos si hay algún producto seleccionado para listado2
	  var numSelec = listado2.numSelecc();
	  if ( numSelec < 1) {
		  GestionarMensaje("PRE0025", null, null, null);   // Debe seleccionar un producto.
	  } else {
		  var codSeleccionados = listado2.codSeleccionados();
		  var arrayDatos = obtieneLineasSeleccionadas(codSeleccionados, 'listado2'); 
		  var cadenaLista = serializaLineasDatos(arrayDatos);

          set("frmFormulario.hidCodSeleccionadosLE", "[" + codSeleccionados + "]");
		  //alert("cod seleccionados: " + get("frmFormulario.hidCodSeleccionadosLE") );
		  set("frmFormulario.hidListaEditable", cadenaLista);
		  set("frmFormulario.conectorAction", "LPModificarOferta");
		  set("frmFormulario.accion", "Modificar producto");
		  enviaSICC("frmFormulario");
	  }
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Añadido por ssantana, 6/10/2005
// Por cambio GCC-PRE-001.
  function serializaLineasDatos(arrayDatos) {
		// Arma una cadena serializando los datos del array recibido por parametro. 
		// Se usa "!" para separar los campos individuales, y "@" para separar las lineas. 
		// Nota: arrayDatos es un array donde cada elemento es un subArray.

		var cadenaSerializada = "[";

		// Defino los separadores. 
		var sepCampos = '!';
		var sepLineas = '@';
		var longArray = arrayDatos.length;

		// Por cada linea de la listaEditable. 
		for (var i = 0; i < longArray; i++) {
				// Tomamos la Linea. 
				var linea = arrayDatos[i]; 
				//alert("Linea " + i + ": " + linea);

				// Nos fijamos si es la primer cadena. Si no es así, le agregamos un separador de Linea a la 
				// cadena. 
				if ( i != 0) {
					 cadenaSerializada = cadenaSerializada + sepLineas;
				}

				// Por cada elemento de la linea. 
				for (var j = 0; j < linea.length; j++ ) {
					 // Tomamos el elemento. 
					 var elemento = linea[j];

					 // Nos fijamos si es el primer elemento. Si no es así, le agregamos un separador de Campos a la 
					 // cadena. 
					 if ( j != 0 ) {
					     cadenaSerializada = cadenaSerializada + sepCampos;
					 }
					 // Ahora añadimos el elemento que corresponde. 
					 if (elemento == "") { 
					     cadenaSerializada = cadenaSerializada + " ";
					 } else { 
					     cadenaSerializada = cadenaSerializada + elemento;
					 }
				} // Fin For j 
		} // Fin For i 

		cadenaSerializada = cadenaSerializada + "]";

		//alert("cadenaSerializada: " + cadenaSerializada);
		return cadenaSerializada;

  }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Añadido por ssantana, 6/10/2005
// Por cambio GCC-PRE-001.
function obtieneLineasSeleccionadas(codSeleccionados, nombreLista) {
	// Recibe un array de codigos, y a partir de ellos, retorna un array con el contenido
	// de cada línea que matchea con esos codigos.

	eval(nombreLista + ".actualizaDat();");

	var datosLista = eval(nombreLista + ".datos;");
	var longLista = datosLista.length;
	var cantCodigos = codSeleccionados.length; 
	var arrayRetorno = new Array(); 
	var match = false; 

	for ( var i = 0; i < cantCodigos; i++ )
	{
		var codigoABuscar = codSeleccionados[i];
		match = false;

		for ( var j = 0; (j < longLista) && (!match); j++)
		{
			var codigoLista = datosLista[j][0]; 
			//if ( parseInt(codigoABuscar, 10) == parseInt(codigoLista, 10) )	// Comentado por HRCS
			if ( codigoABuscar == codigoLista )	// Modificado por HRCS - Fecha 22/03/2007 - Incidencia Sicc20070106
			{
				// Match. tomo la fila y la añado al nuevo array. 
				var fila = datosLista[j]; 
				arrayRetorno[arrayRetorno.length]  = fila;
				match = true;
			}
		} // Fin for j (recorrido de datos de Lista);
	} // Fin for i ( recorrido de codigos a buscar.


	return arrayRetorno;

}


    // Agregado por SiCC20070316 - Rafael Romero - 19/07/2007
    function accionConsultarProducto() {
        listado1.actualizaDat();
        var numSelec = listado1.numSelecc();
        if ( numSelec < 1) {
            GestionarMensaje("PRE0025", null, null, null);   // Debe seleccionar un producto.
        } else {
            var codSeleccionados = listado1.codSeleccionados();
            var arrayDatos = obtieneLineasSeleccionadas(codSeleccionados, 'listado1'); 
            var cadenaLista = serializaLineasDatos(arrayDatos);
            var obj = new Object();
            obj.hidCodSeleccionadosLE = "[" + codSeleccionados + "]";
            obj.hidListaEditable =  cadenaLista;
            mostrarModalSICC('LPModificarOferta','Consultar producto',obj,795,495);
        }
    }

    function accionConsultarProductoAsociado(){
        listado2.actualizaDat();
        var numSelec = listado2.numSelecc();
        if ( numSelec < 1) {
            GestionarMensaje("PRE0025", null, null, null);   // Debe seleccionar un producto.
        } else {
            var codSeleccionados = listado2.codSeleccionados();
            var arrayDatos = obtieneLineasSeleccionadas(codSeleccionados, 'listado2'); 
            var cadenaLista = serializaLineasDatos(arrayDatos);
            var obj = new Object();
            obj.hidCodSeleccionadosLE = "[" + codSeleccionados + "]";
            obj.hidListaEditable =  cadenaLista;
            mostrarModalSICC('LPModificarOferta','Consultar producto',obj,795,495);
        }
    }
    
    function accionConsultarGrupo(codigo){
        //set("frmFormulario.hidNroGrupo", codigo);             
        //set("frmFormulario.conectorAction", "LPModificarOferta");
        //set("frmFormulario.accion", "ConsultarGrupo");
        //enviaSICC("frmFormulario");
        var obj = new Object();
        obj.hidNroGrupo = codigo;
        mostrarModalSICC('LPModificarOferta','ConsultarGrupo',obj,795,495);
    }
    // fin agregado SICC20070316

    function onClickRegion(){
    	set('frmFormulario.cbRegion', '');
		set('frmFormulario.hZona', '');
		set('frmFormulario.hRegion', 'S');
		accion('frmFormulario.rbZona', '.checked=false');
		set('frmFormulario.cbZona', '');	
		accion('frmFormulario.cbZona', '.disabled=true');	
		accion('frmFormulario.cbRegion', '.disabled=false');
	}

	function onClickZona(){
		accion('frmFormulario.rbRegion', '.checked=false');
		set('frmFormulario.hZona', 'S');
		set('frmFormulario.hRegion', '');
		set('frmFormulario.cbRegion', '');
		accion('frmFormulario.cbRegion', '.disabled=true');
		accion('frmFormulario.cbZona', '.disabled=false');	
	}