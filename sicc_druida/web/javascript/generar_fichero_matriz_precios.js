function onLoadPag() {
	
	  configurarMenuSecundario("frmGenerarFichero");
      mostrarCodigoError();
      set('frmGenerarFichero.txtDescripcion', get('frmGenerarFichero.descripcionH'));            
      focaliza("frmGenerarFichero.txtDescripcion");    
      if(get('frmGenerarFichero.accion')==""){
          desactivarCombos();
          seleccionarOid();
          focaliza("frmGenerarFichero.txtDescripcion"); 	
      }
}

//----------------------------------------------------------------------------------------
  function mostrarCodigoError()
   {           
      var vErrCodigo = get('frmGenerarFichero.errCodigo');
      var vErrDescrip = get('frmGenerarFichero.errDescripcion');
                   
      if (get('frmGenerarFichero.errDescripcion')!=''){
          var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);
      }	
                     
   }
//-----------------------------------------------------------------------------------------
   //--Disabled Combos--
   function desactivarCombos(){
  
   }

   //---------------------------------------------------------------------------
  //Enabled Combos
  
  function activarCombos(combo){
	document.getElementById(combo).disabled = false;
  }

  //Carga el combo acceso segun los oid
//------------------------------------------------------------------------------
  function loadComboAcceso(combo){
    limpiarCombo(combo);
    activarCombos(combo);
   
    var canal = document.getElementById("cbCanal");
    var optioncalnal = canal.options ;
    var cboAcc = document.getElementById("cbAcc");
    var cboAcceso = document.getElementById("cbAcceso");
   
    //--busca la primera coincidencia con acceso
    for(var i=0;i<cboAcc.length;i++){
       if(cboAcc.item(i).value == optioncalnal.value && optioncalnal.value !="" ){
            
            var oOption = document.createElement("OPTION");
            cboAcceso.options.add(oOption);
            oOption.innerText = cboAcc.item(i).innerText;
            oOption.value = cboAcc.item(i).value;
            break;
        }
      }

    //--busca si existen otras-
    for(var i=0;i<cboAcc.length;i++){
   
       if(cboAcc.item(i).value != optioncalnal.value && optioncalnal.value !=""){
          
            var oOption = document.createElement("OPTION");
           
            cboAcceso.options.add(oOption);
            oOption.innerText = cboAcc.item(i).innerText;
            oOption.value = cboAcc.item(i).innerText;
           
        }
      }
    
    set('frmGenerarFichero.statusAcceso',"1");
  }

  
 
//------------------------------------------------------------------------------------------
function EventoMarca(){
   if(get('frmGenerarFichero.statusPeriodo')== "1")  {
     limpiarCombo("cbPeriodoDesde");
     limpiarCombo("cbPeriodoHasta");
     }
}

//---------------------------------------------------------------------------------------------
  function limpiarCombo(combo){
      var cboEnabled = document.getElementById(combo);
      if( get('frmGenerarFichero.statusAcceso')=="1" || get('frmGenerarFichero.statusPeriodo')=="1" ){
         
        opciones = cboEnabled.options;
        for(var i=0;i<opciones.length-1;i++){
          
          cboEnabled.options.remove(i);
        
        }
        var seleccionado = cboEnabled.selectedIndex;
         if(seleccionado!= -1){
            
            cboEnabled.options.remove(seleccionado);
          }
      }
  }

  //---------------------------------------------------------------------------------
 //Selecciona los oid de los combos auxiliares  
 function seleccionarOid(){
    
    var cboMarcaAux = document.getElementById("cbMarcaAux");
    var cboCanalAux = document.getElementById("cbCanalAux");
    var cboMarca = document.getElementById("cbMarca");
    var cboCanal = document.getElementById("cbCanal");
    var optionMarca = document.createElement("OPTION");
    var optionCanal = document.createElement("OPTION");
    
    for(var i=0;i<cboMarcaAux.length;i++){
      if(i==0){
       optionCanal.value = i;  
      }else{
      
        if(cboMarcaAux.item(i-1).value != cboMarcaAux.item(i).value){
         var optionMarca = document.createElement("OPTION");
         cboMarca.options.add(optionMarca);
         optionMarca.innerText = cboMarcaAux.item(i).innerText;
         optionMarca.value = cboMarcaAux.item(i).value;        
        }
       
        if(cboCanalAux.item(i-1).value != cboCanalAux.item(i).value){
         var optionCanal = document.createElement("OPTION");
         cboCanal.options.add(optionCanal);
         optionCanal.innerText = cboCanalAux.item(i).innerText;  
         optionCanal.value = cboCanalAux.item(i).value;  
        }        
      }
    }
  }
 //---------------------------------------------------------------------------------------------------  

 function fGuardar(){
      
   if (sicc_validaciones_generales()){            
      cargarFichero();
   }
 }




 function cargarFichero(){
    var cboMarca = document.getElementById("cbMarca");
    var cboCanal = document.getElementById("cbCanal");
    var cboAcceso = document.getElementById("cbAcceso");
    var cboDesde = document.getElementById("cbPeriodoDesde");
    var cboHasta = document.getElementById("cbPeriodoHasta");
    var lot = get("frmGenerarFichero.loteH");    
    var item = 0;
      
    items= cboMarca.selectedIndex;
    set("frmGenerarFichero.marca", cboMarca.item(items).value);//innerText

    items= cboCanal.selectedIndex;
    set("frmGenerarFichero.canal", cboCanal.item(items).value);//innerText

    items= cboAcceso.selectedIndex;
    set("frmGenerarFichero.acceso", cboAcceso.item(items).value);//innerText
      

    items= cboDesde.selectedIndex;
    set("frmGenerarFichero.desde", cboDesde.item(items).value);//innerText
     

    items= cboHasta.selectedIndex;
    set("frmGenerarFichero.hasta", cboHasta.item(items).value);//innerText
      
    set("frmGenerarFichero.observacionesH", get("frmGenerarFichero.areatxtObservaciones"));
    set("frmGenerarFichero.descripcionH", get("frmGenerarFichero.txtDescripcion"));
    set("frmGenerarFichero.loteH", lot)

    eval("frmGenerarFichero").oculto= "S";    
    
    if(get('frmGenerarFichero.casoDeUso')=='MatrizPrecios'){
      
      set('frmGenerarFichero.accion',"GenerarFichero");
      set("frmGenerarFichero.conectorAction", "LPGenerarFicheroMatrizPrecios");
		     
    } else if(get('frmGenerarFichero.casoDeUso')=='RangoPeriodos'){
           
      set("frmGenerarFichero.accion", "RangoPeriodos");
      set("frmGenerarFichero.conectorAction", "LPGenerarFicheroRangoPeriodos");
    }
    enviaSICC('frmGenerarFichero');
 }

 //------------------------------------------------------------------------------------------------------
function errorAlGuardar(){ 
    docum.get();
	focaliza("frmGenerarFichero.cbMarca");     
}

function ok(){
  GestionarMensaje('1464');
}
 

function cbCanalOnChange() {

	activarCombos("cbAcceso");
	recargaCombo('frmGenerarFichero.cbAcceso', 
                    'SEGObtenerAccesosPorCanal', 
                    'es.indra.sicc.dtos.seg.DTOAccesosPorCanal', 
                     [ ['oidIdioma', get('frmGenerarFichero.hidIdioma')],
                     ['oidCanal', get('frmGenerarFichero.cbCanal')] ]);

    var pais        = get('frmGenerarFichero.hidPais');
    var marca       = get('frmGenerarFichero.cbMarca');
    var canal       = get('frmGenerarFichero.cbCanal');

    var fechaInicio = obtenerFormatoFecha(get('frmGenerarFichero.hidFechaSistema'));

    vaciaCombo('frmGenerarFichero.cbPeriodoDesde');
    vaciaCombo('frmGenerarFichero.cbPeriodoHasta');
    
    recargaCombo('frmGenerarFichero.cbPeriodoDesde','CRAObtienePeriodosFecha','es.indra.sicc.dtos.cra.DTOPeriodo',[["pais", pais], ["marca", marca], ["canal", canal],["fechaInicio",fechaInicio]]);
    
    recargaCombo('frmGenerarFichero.cbPeriodoHasta','CRAObtienePeriodosFecha','es.indra.sicc.dtos.cra.DTOPeriodo',[["pais", pais], ["marca", marca], ["canal", canal],["fechaInicio",fechaInicio]]);
    
}


  function vaciaCombo(combo) {
     if (eval('document.'+combo) != undefined) 
               set_combo(combo,[['','']],['']);
     return true;
  }

//------------------------------------------------------------------------------------------------------------

function onTab(campoActual) {

         if (campoActual == 'cbMarca') {
                  focaliza('frmGenerarFichero.cbCanal');
         } else if (campoActual == 'cbCanal') {
                  focaliza('frmGenerarFichero.cbAcceso');
         } else if (campoActual == 'cbAcceso') {
                  focaliza('frmGenerarFichero.cbPeriodoDesde');
         } else if (campoActual == 'cbPeriodoDesde') {
                  focaliza('frmGenerarFichero.cbPeriodoHasta');
         } else if (campoActual == 'cbPeriodoHasta') {
                  focaliza('frmGenerarFichero.txtDescripcion');
         } else if (campoActual == 'txtDescripcion') {
                  focaliza('frmGenerarFichero.areatxtObservaciones');
         } else if (campoActual == 'areatxtObservaciones') {
                  focaliza('frmGenerarFichero.cbMarca');
         }
}


//------------------------------------------------------------------------------------------------------------

function onShiftTab(campoActual) {
         if (campoActual == 'cbMarca') {
                  focaliza('frmGenerarFichero.areatxtObservaciones');
         } else if (campoActual == 'cbCanal') {
                  focaliza('frmGenerarFichero.cbMarca');
         } else if (campoActual == 'cbAcceso') {
                  focaliza('frmGenerarFichero.cbCanal');
         } else if (campoActual == 'cbPeriodoDesde') {
                  focaliza('frmGenerarFichero.cbAcceso');
         } else if (campoActual == 'cbPeriodoHasta') {
                  focaliza('frmGenerarFichero.cbPeriodoDesde');
         } else if (campoActual == 'txtDescripcion') {
                  focaliza('frmGenerarFichero.cbPeriodoHasta');
         } else if (campoActual == 'areatxtObservaciones') {
                  focaliza('frmGenerarFichero.txtDescripcion');
         }
}

//------------------------------------------------------------------------------------------------------------



