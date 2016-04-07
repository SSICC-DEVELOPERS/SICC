function onLoad() {
         configurarMenuSecundario('formulario');
         var acc = get('formulario.accion');
         var opcionMenu = get('formulario.opcionMenu');
        
         if ((opcionMenu == 'insertar')) {
                 var oidCentroVD = get('formulario.centroDistribucionVD');
                  set('formulario.cbCentroDistribucion', [get('formulario.centroDistribucionVD')]);
                  if (oidCentroVD!=''){
                    onChangeCbCentroDistribucion();    
                  }
                  focaliza('formulario.cbCentroDistribucion');
         }
         if (acc == 'modificar') {
                  btnProxy(2,1);
                  btnProxy(3,0);
                  btnProxy(5,0);
                  set('formulario.cbCentroDistribucion', [get('formulario.oidCentroDistribucion')]);
                  set('formulario.cbLineaArmado', [get('formulario.oidLineaArmado')]);
                  onChangeCbLineaArmado(); 

                  accion('formulario.cbCentroDistribucion', '.disabled = true');
                  accion('formulario.cbLineaArmado', '.disabled = true');
                  accion('formulario.txtCodigoAgrupacion', '.disabled = true');
         }
         if (acc == 'detalle') {
                  btnProxy(2,1);
                  btnProxy(3,0);
                  set('formulario.cbCentroDistribucion', [get('formulario.oidCentroDistribucion')]);
                  set('formulario.cbLineaArmado', [get('formulario.oidLineaArmado')]);
                  onChangeCbLineaArmado(); 

                  accion('formulario.cbCentroDistribucion', '.disabled = true');
                  accion('formulario.cbLineaArmado', '.disabled = true');
                  accion('formulario.cbTipoSolicitud', '.disabled = true');
                  accion('formulario.txtNroPedidoArmado', '.disabled = true');
                  accion('formulario.txtNroUnidades', '.disabled = true');
                  accion('formulario.txtParamDistrib', '.disabled = true');

                  accion('formulario.txtCodigoAgrupacion', '.disabled = true');
                  accion('formulario.txtHoraDia', '.disabled = true');
         }
    //focaliza('formulario.txtCodigoCaja');
}


function onClickGuardar() { // Equivale a onClickGuardar
    if (!sicc_validaciones_generales()) {
         return false;
    }
    
    /* BELC400000725 - dmorello, 07/09/2007
	 * La validación de txtHoraDia entre 0 y 24 se hará en la página XML */

	//horaDia = get('formulario.txtHoraDia');

    //formatoDef = get('formulario.hFormatoDef');

	//if(numeroDeFormatoSICC(horaDia, formatoDef) > Number(24)){
    //    GestionarMensaje('2595');
    //    focaliza("formulario.txtHoraDia");
    //    return;
    //}
	/* Fin BELC400000725 dmorello 07/09/2007 */

         // Envio el formulario
		 set('formulario.solicitudesLinea', armarSolicitudesLinea());

     eval('formulario').oculto = 'S';
     set('formulario.conectorAction', 'LPMantenerParamBalanceoAreaChequeo');
     set('formulario.accion', 'guardar');
     //enviaSICC('formulario');
		 var opcionMenu = get('formulario.opcionMenu');
		 if ((opcionMenu == 'insertar')) {
			enviaSICC('formulario');
			return;
         }
         else if (opcionMenu == 'modificar') {
			 enviaSICC('formulario', null, null, 'N');
			 return;
		 }
}

function onChangeCbCentroDistribucion() {
         var oidCentro = get('formulario.cbCentroDistribucion', 'V');
         set('formulario.oidCentroDistribucion', oidCentro); 
         if (oidCentro != '') {
                  var array = new Array();
                  array[0] = new Array('oid',oidCentro);
                  array[1] = new Array('oidIdioma',get('formulario.varIdioma'));
				  set_combo('formulario.cbTipoSolicitud', arrayVacio());
                  recargaCombo('formulario.cbLineaArmado',
                                             'APEObtenerLineasArmadoCD',
                                             'es.indra.sicc.util.DTOOID',
                                             array,
                                             'setearCbLineaArmado(datos)');
         } else {
                  set_combo('formulario.cbLineaArmado', new Array(['','']));
				  set_combo('formulario.cbTipoSolicitud', arrayVacio());
         }
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

function onChangeCbLineaArmado() {
         var oidLinea = get('formulario.cbLineaArmado', 'V');
         set('formulario.oidLineaArmado', oidLinea); 
         if (oidLinea != '') {

                  set_combo('formulario.cbTipoSolicitud', arrayVacio());
				  
				  var array = new Array();
                  array[0] = new Array('oid',oidLinea);
                  array[1] = new Array('oidIdioma',get('formulario.varIdioma'));

                  recargaCombo('formulario.cbTipoSolicitud',
                                             'APERecuperarTiposSolicitudLinea',
                                             'es.indra.sicc.util.DTOOID',
                                             array,
                                             'setearCbTipoSolicitud(datos)');
         } else {
                  set_combo('formulario.cbTipoSolicitud', arrayVacio());
         }
}

function arrayVacio(){  
    var array = new Array();             
        array[0] = new Array('','');
  
    return array;
}

function fLimpiar() {
	set('formulario.cbCentroDistribucion', '');        
    set_combo('formulario.cbLineaArmado', arrayVacio());
	set_combo('formulario.cbTipoSolicitud', arrayVacio());
	set('formulario.txtNroPedidoArmado', '');
	set('formulario.txtNroUnidades', '');
	set('formulario.txtParamDistrib', '');
	set('formulario.txtCodigoAgrupacion', '');
	set('formulario.txtHoraDia', '');

    var oidCentroVD = get('formulario.centroDistribucionVD');
    set('formulario.cbCentroDistribucion', [get('formulario.centroDistribucionVD')]);
    if (oidCentroVD!=''){
        onChangeCbCentroDistribucion();
    }
    focaliza('formulario.cbCentroDistribucion');

}

function setearCbLineaArmado(datos) {
         lineaDef = obtenerLineaDef(datos);
         
         var arrayNuevo = new Array();
         arrayNuevo[0] = new Array('','');
         arrayNuevo = arrayNuevo.concat(datos);
         set_combo('formulario.cbLineaArmado',arrayNuevo);
         set('formulario.cbLineaArmado', [lineaDef]);
		 set('formulario.oidLineaArmado', get('formulario.cbLineaArmado'));   // dmorello, 07/09/2007

		 // BELC400000732 - dmorello, 13/09/2007
		 if (get('formulario.opcionMenu') == 'insertar') {
			onChangeCbLineaArmado();
		 }
}

function setearCbTipoSolicitud(datos) {
  var arrayNuevo = new Array();
  arrayNuevo[0] = new Array('','');
  arrayNuevo = arrayNuevo.concat(datos);
  set_combo('formulario.cbTipoSolicitud',arrayNuevo);

  var acc = get('formulario.accion');
  if ( (acc == 'modificar') || (acc == 'detalle') ) {
    //Obtengo los valores que mando la LP
    var solicitudesLinea = get('formulario.solicitudesLinea');
    if(solicitudesLinea!=''){
      // Asigno los valores
      set('formulario.cbTipoSolicitud', solicitudesLinea.split(","));
    }
  }

}

function fVolver() {
    this.close();
}

function fGuardar(){
	set("formulario.txtHoraDia",get("formulario.txtHoraDia"));
	onClickGuardar();
}

function armarSolicitudesLinea(){
    var codigos = get('formulario.cbTipoSolicitud','V');
    
    if((codigos.length==1)&&(codigos[0].length==0)){
        var lng = combo_get('formulario.cbTipoSolicitud','L');
        for(var ind=1; ind < lng; ind++){
            codigos[ind-1]=combo_get('formulario.cbTipoSolicitud','V',ind);
        }
    }
      
	  var scodigo= "";
      var cadena = "";
      for (var i=0; i<codigos.length ; i++){
		if( i!= 0) cadena = cadena + ",";
		scodigo = codigos[i];
		if(scodigo !=  '' ){
			cadena = cadena + scodigo;
		}
      }	 
	  //alert("cadena: [" + cadena + "]");
      return cadena;
}

function cerrarModal(){
   
     var retorno = new Array();
     retorno[0] = "OK";
    
     returnValue = retorno;
     close();
}
