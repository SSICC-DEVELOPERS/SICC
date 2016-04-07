//---------------------------------------------------------------------------------

function onLoadPag(){

         var errDescripcion = get('formulario.errDescripcion');
         if (errDescripcion !='') {		
                    var errCodigo = get('formulario.errCodigo');
                    var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
          }
         
         if (get('formulario.opcionMenu')=='ConsultarParametrosContables'|| get('formulario.opcionMenu')=='ModificarParametrosContables'){ 

                  if(get('formulario.accion')=='detalle' || get('formulario.accion')=='modificar'){
                           cargarCombos();	
                  }
         }
         
         if (get('formulario.hCbProceso') == "N") {
             accion('formulario.cbProceso','.disabled=true');             
         }
         if (get('formulario.hCbSubprocesoContable') == "N") {
           accion('formulario.cbSubprocesoContable','.disabled=true');             
         }
         if (get('formulario.hRbDebeHaber') == "N") {
                  document.all.rbDebeHaber[0].disabled=true;

                  document.all.rbDebeHaber[1].disabled=true;
         }
         if (get('formulario.hCbObtencionCuenta') == "N") {
           accion('formulario.cbObtencionCuenta','.disabled=true');             
         }

	 onChangeObtencionCuenta();
	 
         if (get('formulario.hCbCuentaDirecta') == "N") {
           accion('formulario.cbCuentaDirecta','.disabled=true');             
         }
         if (get('formulario.hTxtTextoApunte') == "N") {
           accion('formulario.txtTextoApunte','.disabled=true');             
         }
         if (get('formulario.hRbConcatenar') == "N") {
                  document.all.rbConcatenar[0].disabled=true;
                  document.all.rbConcatenar[1].disabled=true;
         }	
         configurarMenuSecundario("formulario");
         eval (ON_RSZ);  
         focaliza('formulario.cbProceso');
         
}

//---------------------------------------------------------------------------------

function cargarCombos(){
         
         var oidParamContab = get('formulario.oidParametrosContables');
//         alert("En cargarCombos() oidParamContab " + oidParamContab);
         //set('formulario.oidParametrosContables',oidParamContab); 
         
         
         var iSeleccionado = new Array(); 
         iSeleccionado[0] = get('formulario.vCbProceso'); 
         set('formulario.cbProceso',iSeleccionado); 
         
         onChangeProceso();
         
         var iSeleccionado = new Array(); 
         iSeleccionado[0] = get('formulario.vCbObtencionCuenta'); 
         set('formulario.cbObtencionCuenta',iSeleccionado); 
         
         var iSeleccionado = new Array(); 
         iSeleccionado[0] = get('formulario.vCbCuentaDirecta'); 
         set('formulario.cbCuentaDirecta',iSeleccionado); 
         
         //setSubProcesoContable();

         if (get('formulario.vRbDebeHaber') == 'D') {
                  document.all.rbDebeHaber[0].checked=true;
                  document.all.rbDebeHaber[1].checked=false;
         } else {
                  document.all.rbDebeHaber[0].checked=false;
                  document.all.rbDebeHaber[1].checked=true;
         }
         
         var rbConcatenar = get('formulario.vRbConcatenar');
//         alert(rbConcatenar);
         
         if (get('formulario.vRbConcatenar') == '1') {
                  document.all.rbConcatenar[0].checked=true;
                  document.all.rbConcatenar[1].checked=false;
         } else {
                  document.all.rbConcatenar[0].checked=false;
                  document.all.rbConcatenar[1].checked=true;
         }

}
//---------------------------------------------------------------------------------

function onChangeProceso(){
         if (get('formulario.cbProceso')!='') {
                  var paramDTO = new Array();
                  paramDTO[0] = ["oidPais",get('formulario.pais')];
                  paramDTO[1] = ["oidIdioma",get('formulario.idioma')];      
                  paramDTO[2] = ["oid",get('formulario.cbProceso')];
                  recargaCombo("formulario.cbSubprocesoContable","CCCObtenerSubProcesosPorProceso","es.indra.sicc.util.DTOOID",paramDTO, "setSubProceso(datos)");
         } else {
                  set_combo('formulario.cbSubprocesoContable',['','']);
         }
}

function setSubProcesoContable() {

         if (get('formulario.cbProceso')!='') {
                  var paramDTO = new Array();
                  paramDTO[0] = ["oidPais",get('formulario.pais')];
                  paramDTO[1] = ["oidIdioma",get('formulario.idioma')];      
                  paramDTO[2] = ["oid",get('formulario.cbProceso')];
                  recargaCombo("formulario.cbSubprocesoContable","CCCObtenerSubProcesosPorProceso","es.indra.sicc.util.DTOOID",paramDTO, "setSubProceso(datos)");
         } else {
                  set('formulario.cbSubprocesoContable','');
         }
}

function setSubProceso(datos) {

         set_combo('formulario.cbSubprocesoContable',datos, []);

         if(get('formulario.vCbSubprocesoContable')!=''){
                  var iSeleccionado = new Array(); 
                  iSeleccionado[0] = get('formulario.vCbSubprocesoContable'); 
//                alert("setSubProcesoContable............."+iSeleccionado);
                  set('formulario.cbSubprocesoContable',iSeleccionado); 
         }
}
//---------------------------------------------------------------------------------

function onChangeObtencionCuenta(){
//Si codObtencionCuenta del valor seleccionado en el combo cbObtencionCuenta == CCCConstantes.CODIGO_CUENTA_DIRECTA // "D" 
// Habilitar el combo cbCuentaDirecta 
//Sino  - Deshabilitar el combo cbCuentaDirecta 

         var seleccionado = get('formulario.cbObtencionCuenta');

         //obtengo el valor de CCCConstantes.CODIGO_CUENTA_DIRECTA seteado en codObtencionCuenta
         if (seleccionado == get('formulario.codObtencionCuenta') ) {
                  accion('formulario.cbCuentaDirecta','.disabled=false');             
         }else{
                  set('formulario.cbCuentaDirecta',''); 
				  accion('formulario.cbCuentaDirecta','.disabled=true');
         }
         
}
//---------------------------------------------------------------------------------

function accionGuardar(){

  if(sicc_validaciones_generales()){
         
         var seleccionado = get('formulario.oidParametrosContables');
//         alert("El oidParametrosContables:  " +seleccionado );
         set('formulario.conectorAction','LPMantenimientoParametrosContables');
         set('formulario.accion','guardar');
         eval('formulario').oculto="S";
         enviaSICC('formulario');
   }else{
                  return false;   
   }                  
}


//---------------------------------------------------------------------------------

function fVolver(){
	window.close();
}
//---------------------------------------------------------------------------------

function fLimpiar(){
         limpiar();
}
//---------------------------------------------------------------------------------

function fEliminar(){
}
//---------------------------------------------------------------------------------

function fGuardar(){
         accionGuardar();
}
//---------------------------------------------------------------------------------

function limpiar() {
         eval('formulario').oculto="N";

         set('formulario.cbProceso','');
         set_combo('formulario.cbSubprocesoContable',['','']);
         set('formulario.cbObtencionCuenta','');
         set('formulario.cbCuentaDirecta','.disabled=true');             
         set('formulario.txtTextoApunte','');             
         document.all.rbDebeHaber[0].checked=false;
         document.all.rbDebeHaber[1].checked=false;
         document.all.rbConcatenar[0].checked=false;
         document.all.rbConcatenar[1].checked=false;
}

function ejecucionError() {
         eval('formulario').oculto="N";
}

//---------------------------------------------------------------------------------

//ON_TAB
function onTab_rbConcatenar(){
         focaliza('formulario.cbProceso');  
}

//---------------------------------------------------------------------------------

//ON_SH_TAB
function onshTab_cbProceso(){
         focaliza('formulario.rbConcatenar');  
}


