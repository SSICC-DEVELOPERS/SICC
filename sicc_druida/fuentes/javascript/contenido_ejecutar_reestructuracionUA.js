var seqPart = 1;
var seqTrasv = 1;

var atribBuscUAInferior = ""
var oidBuscUAInferior = "";
var UASuperior = ""
var oidUASuperior = "";

function onLoadPag(){  
  configurarMenuSecundario('formulario');
  fMostrarMensajeError();
  
  deshabilitarCamposCab();
  
  cargarTipoOpe();

  visibilidad('capaParticion','O');
  visibilidad('capaLista1','O');
  
  visibilidad('capaTrasvase','O');
  visibilidad('capaLista2','O');
  
  visibilidad('capaFusion','O');
  
  seqPart = 1;
  seqTrasv = 1;
  
  focaliza("formulario.cbMarca");
}

function deshabilitarCamposCab(){
     accion('formulario.cbPeriodo', '.disabled=true');
     accion('formulario.cbSubgerenciaVentas', '.disabled=true');
     accion('formulario.cbRegion', '.disabled=true');
     accion('formulario.cbZona', '.disabled=true');
     accion('formulario.cbSeccion', '.disabled=true');
}

function deshabilitarCamposTrasv(){
     accion('formulario.cbRegionTrasv', '.disabled=true');
     accion('formulario.cbZonaTrasv', '.disabled=true');
     accion('formulario.cbSeccionTrasv', '.disabled=true');
}


function fGuardar(){

     if((get('formulario.cbTipoOperacion')!='F' && validarUAAsignadas()) || 
          (get('formulario.cbTipoOperacion')=='F' && sicc_validaciones_generales("gGuardarFusion") 
           && validaUAAFusionar() && validarLongitudUA('txtUACrearFusion'))){
          
          eval('formulario').oculto = 'S';
          set('formulario.listaDetalles', armarListaDetalles());   
          set('formulario.conectorAction', 'LPEjecutarReestructuracionUA');
          set('formulario.accion', 'guardar');
          enviaSICC('formulario', null, null, 'N');
          
          
     }
}

function validaUAAFusionar(){  

   var UA1Fusionar= oidBuscUAInferior;
   var UA2Fusionar= get('formulario.cbUA2Fusionar');
   
   if(Number(UA1Fusionar)==Number(UA2Fusionar)){
      GestionarMensaje('2607');      
      return false;
      
   } else {
      return true;
   }
}

function validarUAAsignadas(){  
    if(get('formulario.cbTipoOperacion')=='P'){
          cantUAs = combo_get('formulario.cbUAIncluirPart','L');    
          
          if(cantUAs!=1){
              GestionarMensaje('2605');
              return false;
          }
          
    } else if(get('formulario.cbTipoOperacion')=='T'){
          if(listado2.codigos().length==0){
              GestionarMensaje('2606');
              return false;
          }
    } 
    
    return true;
}

function validarLongitudUA(campoTexto){
    if(atribBuscUAInferior == "oidSGV" && get('formulario.' + campoTexto).length!=2){
         GestionarMensaje("2608", GestionarMensaje("2609"), 2);
         focaliza("formulario." + campoTexto);
         return false;
    } else if(atribBuscUAInferior == "oidRegion" && get('formulario.' + campoTexto).length!=2){
         GestionarMensaje("2608", GestionarMensaje("2609"), 2);
         focaliza("formulario." + campoTexto);
         return false;
    } else if(atribBuscUAInferior == "oidZona" && get('formulario.' + campoTexto).length!=4){
         GestionarMensaje("2608", GestionarMensaje("2609"), 4);
         focaliza("formulario." + campoTexto);
         return false;
    } else if(atribBuscUAInferior == "oidSeccion" && get('formulario.' + campoTexto).length!=1){         
         GestionarMensaje("2608", GestionarMensaje("2609"), 1);
         focaliza("formulario." + campoTexto);
         return false;
    } 
    
    return true;
}

function armarListaDetalles(){    

  var codigos;
  var cadena = "";
      
  if(get('formulario.cbTipoOperacion')=='P'){
      codigos = listado1.codigos();
      
      for (var i=0; i<codigos.length ; i++){
            if( i!= 0)
              cadena = cadena + "|";

            UACrear = listado1.extraeDato(codigos[i], 1);
            cadena = cadena + UACrear + "#";
            
            oidUAInferior = listado1.extraeDato(codigos[i], 5);
            cadena = cadena + oidUAInferior + "#";
            
            nse1 = listado1.extraeDato(codigos[i], 6);
            cadena = cadena + nse1 + "#";
            
            nse2 = listado1.extraeDato(codigos[i], 7);
            cadena = cadena + nse2;            
      }
      
  } else if(get('formulario.cbTipoOperacion')=='T'){
  
      codigos = listado2.codigos();
      
      for (var i=0; i<codigos.length ; i++){
            if( i!= 0)
              cadena = cadena + "|";

            oidUADestino = listado2.extraeDato(codigos[i], 2);
            cadena = cadena + oidUADestino + "#";
            
            codUAInferior = listado2.extraeDato(codigos[i], 3);            
            cadena = cadena + codUAInferior;         
      }      
  }
  
  return cadena;
}
                             

function onClickBtnAniadirTrasv(){  

  if(sicc_validaciones_generales("gAniadirTrasv")) {
        if(atribBuscUAInferior == "oidSGV" ||
          (atribBuscUAInferior == "oidRegion" && sicc_validaciones_generales("gAniadirRegTrasv")) ||
          (atribBuscUAInferior == "oidZona" && sicc_validaciones_generales("gAniadirZonTrasv")) ||
          (atribBuscUAInferior == "oidSeccion" && sicc_validaciones_generales("gAniadirSeccTrasv"))) {

          oidUAIncluirTrasv = get('formulario.cbUAIncluirTrasv');
          codUAIncluirTrasv = get('formulario.cbUAIncluirTrasv', 'T');
          
          if(cbSeccionTrasv.disabled == false && get('formulario.cbSeccionTrasv')!=""){
                UAOrigen= get('formulario.cbSeccion','T');
                UADestino= get('formulario.cbSeccionTrasv','T');
                oidUADestino= get('formulario.cbSeccionTrasv');
                
          } else if(cbZonaTrasv.disabled == false && get('formulario.cbZonaTrasv')!=""){
                 UAOrigen= get('formulario.cbZona','T');
                 UADestino= get('formulario.cbZonaTrasv','T');
                 oidUADestino= get('formulario.cbZonaTrasv');
                
          } else if(cbRegionTrasv.disabled == false && get('formulario.cbRegionTrasv')!=""){
                 UAOrigen= get('formulario.cbRegion','T');
                 UADestino= get('formulario.cbRegionTrasv','T');
                 oidUADestino= get('formulario.cbRegionTrasv');
                
          } else if(cbSubgerenciaVentasTrasv.disabled == false && get('formulario.cbSubgerenciaVentasTrasv')!=""){
                 UAOrigen= get('formulario.cbSubgerenciaVentas','T');
                 UADestino= get('formulario.cbSubgerenciaVentasTrasv','T');
                 oidUADestino= get('formulario.cbSubgerenciaVentasTrasv');
          } 
          
          for(i=0; i < oidUAIncluirTrasv.length; i++){
              
              if(oidUAIncluirTrasv[i]!=""){
              
                   oid = listado2.generaCodigo(seqTrasv);
                   seqTrasv = oid;
                                  
                   listado2.insertar(new Array(oid, UAOrigen, UADestino, oidUADestino,
                                                        codUAIncluirTrasv[i], oidUAIncluirTrasv[i]));  
                   // Borrar UA            
                   borrarUATrasv(oidUAIncluirTrasv[i]);
              }
          }
                    
          set_combo('formulario.cbRegionTrasv', arrayVacio());
          accion('formulario.cbRegionTrasv', '.disabled=true');
           
          set_combo('formulario.cbZonaTrasv', arrayVacio());
          accion('formulario.cbZonaTrasv', '.disabled=true');
           
          set_combo('formulario.cbSeccionTrasv', arrayVacio());
          accion('formulario.cbSeccionTrasv', '.disabled=true');
                    
          set('formulario.cbSubgerenciaVentasTrasv', '');  
      
      }      
   }
}

function buscarUAParaTrasv(){ 
    if(cbSeccionTrasv.disabled == false && get('formulario.cbSeccionTrasv')!=""){
         return get('formulario.cbSeccionTrasv','T');
         
    } else if(cbZonaTrasv.disabled == false && get('formulario.cbZonaTrasv')!=""){
         return get('formulario.cbZonaTrasv','T');
         
    } else if(cbRegionTrasv.disabled == false && get('formulario.cbRegionTrasv')!=""){
         return get('formulario.cbRegionTrasv','T');
         
    } else if(cbSubgerenciaVentasTrasv.disabled == false && get('formulario.cbSubgerenciaVentasTrasv')!=""){
         return get('formulario.cbSubgerenciaVentasTrasv','T');
    } 
}

function borrarUATrasv(oidUAIncluirTrasv){      
    // Borrar UA
    cantUAs = combo_get('formulario.cbUAIncluirTrasv','L');    
    
    for(j=0; j<cantUAs; j++){
          if(combo_get('formulario.cbUAIncluirTrasv','V',j) == oidUAIncluirTrasv){
              del_combo('formulario.cbUAIncluirTrasv',j);
              break;
          }
    }    
}


function onClickEliminarTrasv(){ 
    var codSeleccionados = listado2.codSeleccionados();

    for (var i=0; i<codSeleccionados.length ; i++){          
          combo_add('formulario.cbUAIncluirTrasv',listado2.extraeDato(codSeleccionados[i], 2),listado2.extraeDato(codSeleccionados[i], 1));                
    }
    listado2.eliminarSelecc();
}
     

function onClickBtnAniadirPart(){  

  if(sicc_validaciones_generales("gAniadirPart") &&  validarLongitudUA('txtUACrear')) {
    if(validarIgualNSE()){
   
          oidUAs = get('formulario.cbUAIncluirPart');
          codUAs = get('formulario.cbUAIncluirPart', 'T');
          
          if(atribBuscUAInferior=="oidSeccion"){
             UAOrigen= get('formulario.cbSeccion','T');
             
          } else if(atribBuscUAInferior=="oidZona"){
             UAOrigen= get('formulario.cbZona','T');
             
          } else if(atribBuscUAInferior=="oidRegion"){
             UAOrigen= get('formulario.cbRegion','T');
             
          } else if(atribBuscUAInferior=="oidSGV"){
             UAOrigen= get('formulario.cbSubgerenciaVentas','T');
          }
          
          
          for(i=0; i < oidUAs.length; i++){
          
              if(oidUAs[i]!=""){
              
                   oid = listado1.generaCodigo(seqPart);
                   seqPart = oid;
                   
                   listado1.insertar(new Array(oid, UAOrigen, get('formulario.txtUACrear'),
                                                        get('formulario.cbNSE1','T') , get('formulario.cbNSE2','T'), 
                                                        codUAs[i], oidUAs[i],
                                                        get('formulario.cbNSE1'), get('formulario.cbNSE2')));  
                   // Borrar UA inferior                 
                   borrarUAInferiorPart(oidUAs[i]);
              }
          }
                    
          set('formulario.txtUACrear', '');    
          set('formulario.cbNSE1', '');    
          set('formulario.cbNSE2', '');  
     }
   }
}

function validarIgualNSE(){    
    var terrCrear = get('formulario.txtUACrear');
    var nse1 = get('formulario.cbNSE1');
    var nse2 = get('formulario.cbNSE2');

    var codigos = listado1.codigos();
          
    for(var i=0; i<codigos.length; i++){
          codigo = codigos[i];          
          
         if(terrCrear == listado1.extraeDato(codigo, 1) && (nse1!=listado1.extraeDato(codigo, 6) || nse2!=listado1.extraeDato(codigo, 7))){
            GestionarMensaje('2604');
            return false;
         }
    }

    return true;
}

function borrarUAInferiorPart(oidUA){      
    // Borrar consultora
    cantUAInf = combo_get('formulario.cbUAIncluirPart','L');    
    
    for(j=0; j<cantUAInf; j++){
          if(combo_get('formulario.cbUAIncluirPart','V',j) == oidUA){
              del_combo('formulario.cbUAIncluirPart',j);
              break;
          }
    }    
}

function onClickEliminarPart(){ 
    var codSeleccionados = listado1.codSeleccionados();

    for (var i=0; i<codSeleccionados.length ; i++){          
                
          combo_add('formulario.cbUAIncluirPart',listado1.extraeDato(codSeleccionados[i], 5),listado1.extraeDato(codSeleccionados[i], 4));                
    }
    listado1.eliminarSelecc();
}

function onClickBtnBuscar(){  

  if(sicc_validaciones_generales("gBuscar")) {
  
      buscarUAParaOperacion();
      
      if(get('formulario.cbTipoOperacion')=='P' || get('formulario.cbTipoOperacion')=='T'){
      
            deshabilitarCab();
            
            var combo = "";
            
            if(get('formulario.cbTipoOperacion')=='P'){
                  
                  visibilidad('capaParticion','V');
                  mostrarLista1();
                  visibilidad('capaLista1','V');
                  
                  combo = 'formulario.cbUAIncluirPart';
                  
            } else if(get('formulario.cbTipoOperacion')=='T'){
                  deshabilitarCamposTrasv();
                  visibilidad('capaTrasvase','V');
                  mostrarLista2();
                  visibilidad('capaLista2','V');
                  
                  combo = 'formulario.cbUAIncluirTrasv';          
                  
                  recargaCombo('formulario.cbSubgerenciaVentasTrasv', 'ZONRecargaSubgerenciaVentas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
                  armarArrayDTOSGV(), 'recargarSGVTrasv(datos)');
            }
                         
            recargaCombo(combo, 'ZONRecargaUAInferior', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
            [[atribBuscUAInferior, oidBuscUAInferior]]);
        
            eval('formulario').oculto = 'S';              
            set('formulario.conectorAction', 'LPEjecutarReestructuracionUA');
            set('formulario.accion', 'buscar');
            enviaSICC('formulario', null, null, 'N');
            
      } else if(get('formulario.cbTipoOperacion')=='F'){
            deshabilitarCab();  
            
            recargarUA2Fusion();            
            
            visibilidad('capaFusion','V');
            
            eval('formulario').oculto = 'S';              
            set('formulario.conectorAction', 'LPEjecutarReestructuracionUA');
            set('formulario.accion', 'buscar');
            enviaSICC('formulario', null, null, 'N');
      }
  }
}

function recargarSGVTrasv(datos){ 
    seteo = cargaArray(datos);
    
    set_combo('formulario.cbSubgerenciaVentasTrasv', seteo);
    borrarUA("SGV");
}

function recargarUA2Fusion(){ 
    // Habilita boton guardar
    btnProxy(1, '1');

    if(UASuperior=="MC"){
         recargaCombo('formulario.cbUA2Fusionar', 'ZONRecargaSubgerenciaVentas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
         armarArrayDTOSGV());
         
    } else if(UASuperior=="S"){
         recargaCombo('formulario.cbUA2Fusionar', 'ZONRecargaRegiones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
           [['oidSGV', oidUASuperior]]);
           
    } else if(UASuperior=="R"){
         recargaCombo('formulario.cbUA2Fusionar', 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
           [['oidRegion', oidUASuperior]]);
           
    } else if(UASuperior=="Z"){
         recargaCombo('formulario.cbUA2Fusionar', 'ZONRecargaSecciones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
           [['oidZona', oidUASuperior]]);
    }
}


function buscarUAParaOperacion(){ 
    if(cbSeccion.disabled == false && get('formulario.cbSeccion')!=""){
         atribBuscUAInferior = "oidSeccion";
         oidBuscUAInferior = get('formulario.cbSeccion');
         UASuperior = "Z"
         oidUASuperior = get('formulario.cbZona');
         
    } else if(cbZona.disabled == false && get('formulario.cbZona')!=""){
         atribBuscUAInferior = "oidZona";
         oidBuscUAInferior = get('formulario.cbZona');
         UASuperior = "R"
         oidUASuperior = get('formulario.cbRegion');
         
    } else if(cbRegion.disabled == false && get('formulario.cbRegion')!=""){
         atribBuscUAInferior = "oidRegion";
         oidBuscUAInferior = get('formulario.cbRegion');
         UASuperior = "S"
         oidUASuperior = get('formulario.cbSubgerenciaVentas');
         
    } else if(cbSubgerenciaVentas.disabled == false && get('formulario.cbSubgerenciaVentas')!=""){
         atribBuscUAInferior = "oidSGV";
         oidBuscUAInferior = get('formulario.cbSubgerenciaVentas');         
         UASuperior = "MC"
    } 
    
    set('formulario.oidUAProcesar', oidBuscUAInferior);
    set('formulario.UAProcesar', atribBuscUAInferior);
}

function guardarCodUAs(codUAPadre, codUA){ 
    set('formulario.codUAPadreOrigen', codUAPadre);
    set('formulario.codUAOrigen', codUA);
    
    // Habilita boton guardar
    btnProxy(1, '1');
}

function borrarUA(UATrasvase){    

    if(UATrasvase =='SGV' && atribBuscUAInferior =='oidSGV'){
         cantSGVTrasv = combo_get('formulario.cbSubgerenciaVentasTrasv','L');    
         
         for(j=0; j<cantSGVTrasv; j++){
              if(combo_get('formulario.cbSubgerenciaVentasTrasv','V',j) == oidBuscUAInferior){
                   del_combo('formulario.cbSubgerenciaVentasTrasv',j);
                   break;
              }
         }   
         
    } else if(UATrasvase =='R' && atribBuscUAInferior =='oidRegion'){
         cantSGVReg = combo_get('formulario.cbRegionTrasv','L');    
         
         for(j=0; j<cantSGVReg; j++){
              if(combo_get('formulario.cbRegionTrasv','V',j) == oidBuscUAInferior){
                   del_combo('formulario.cbRegionTrasv',j);
                   break;
              }
         }   
         
    } else if(UATrasvase =='Z' && atribBuscUAInferior =='oidZona'){
         cantSGVZon = combo_get('formulario.cbZonaTrasv','L');    
         
         for(j=0; j<cantSGVZon; j++){
              if(combo_get('formulario.cbZonaTrasv','V',j) == oidBuscUAInferior){
                   del_combo('formulario.cbZonaTrasv',j);
                   break;
              }
         }   
         
    } else if(UATrasvase =='S' && atribBuscUAInferior =='oidSeccion'){
         cantSGVSecc = combo_get('formulario.cbSeccionTrasv','L');    
         
         for(j=0; j<cantSGVSecc; j++){
              if(combo_get('formulario.cbSeccionTrasv','V',j) == oidBuscUAInferior){
                   del_combo('formulario.cbSeccionTrasv',j);
                   break;
              }
         }   
    }
    
}

function deshabilitarCab(){  
     accion('formulario.cbMarca', '.disabled=true');
     accion('formulario.cbCanal', '.disabled=true');            
     accion('formulario.cbPeriodo', '.disabled=true');
     accion('formulario.cbSubgerenciaVentas', '.disabled=true');
     accion('formulario.cbRegion', '.disabled=true');
     accion('formulario.cbZona', '.disabled=true');
     accion('formulario.cbSeccion', '.disabled=true');
     accion('formulario.cbTipoOperacion', '.disabled=true');
}

function cargarTipoOpe(){  
    var seteo = new Array(4);
    seteo[0] = ['' , '']
    seteo[1] = ['F' , GestionarMensaje("2602")]
    seteo[2] = ['P' , GestionarMensaje("2597")]
    seteo[3] = ['T' , GestionarMensaje("2598")]
    
    set_combo('formulario.cbTipoOperacion', seteo);
}

function arrayVacio(){  
    var array = new Array();                  
           array[0] = new Array('','');
  
    return array;
}

function cargaArray(datos){
    var seteo = new Array(datos.length + 1);
    seteo[0] = ['' , '']
    for(i = 0; i < datos.length; i++){
      seteo[i+1] = [ datos[i][0], datos[i][1] ]
    }
    return seteo;
}

function onChangeCbSVG(){
    if( get('formulario.cbSubgerenciaVentas')!=''){     
           
           set_combo('formulario.cbZona', arrayVacio());
           accion('formulario.cbZona', '.disabled=true');
           
           set_combo('formulario.cbSeccion', arrayVacio());
           accion('formulario.cbSeccion', '.disabled=true');
           
           accion('formulario.cbRegion', '.disabled=false');
           
           recargaCombo('formulario.cbRegion', 'ZONRecargaRegiones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
           [['oidSGV', get('formulario.cbSubgerenciaVentas')]]);
           
    } else {
           set_combo('formulario.cbRegion', arrayVacio());
           accion('formulario.cbRegion', '.disabled=true');
           
           set_combo('formulario.cbZona', arrayVacio());
           accion('formulario.cbZona', '.disabled=true');
           
           set_combo('formulario.cbSeccion', arrayVacio());
           accion('formulario.cbSeccion', '.disabled=true');
    }
}

function onChangeCbRegion(){
    if( get('formulario.cbRegion')!=''){              
           set_combo('formulario.cbSeccion', arrayVacio());
           accion('formulario.cbSeccion', '.disabled=true');
           
           accion('formulario.cbZona', '.disabled=false');
           
           recargaCombo('formulario.cbZona', 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
           [['oidRegion', get('formulario.cbRegion')]]);
           
    } else {           
           set_combo('formulario.cbZona', arrayVacio());
           accion('formulario.cbZona', '.disabled=true');
           
           set_combo('formulario.cbSeccion', arrayVacio());
           accion('formulario.cbSeccion', '.disabled=true');
    }
}

function onChangeCbZona(){
    if( get('formulario.cbZona')!=''){     
                      
           accion('formulario.cbSeccion', '.disabled=false');
           
           recargaCombo('formulario.cbSeccion', 'ZONRecargaSecciones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
           [['oidZona', get('formulario.cbZona')]]);
           
    } else {         
           set_combo('formulario.cbSeccion', arrayVacio());
           accion('formulario.cbSeccion', '.disabled=true');
    }
}


function onChangeCbCanal(){
    if( get('formulario.cbMarca')!='' && get('formulario.cbCanal')!='' ){
           set_combo('formulario.cbSubgerenciaVentas', arrayVacio());
           accion('formulario.cbSubgerenciaVentas', '.disabled=true');
           
           set_combo('formulario.cbRegion', arrayVacio());
           accion('formulario.cbRegion', '.disabled=true');
           
           set_combo('formulario.cbZona', arrayVacio());
           accion('formulario.cbZona', '.disabled=true');
           
           set_combo('formulario.cbSeccion', arrayVacio());
           accion('formulario.cbSeccion', '.disabled=true');
           
           recargaComboPeriodoSGV();
    } else {
           set_combo('formulario.cbPeriodo', arrayVacio());
           accion('formulario.cbPeriodo', '.disabled=true');
           
           set_combo('formulario.cbSubgerenciaVentas', arrayVacio());
           accion('formulario.cbSubgerenciaVentas', '.disabled=true');
           
           set_combo('formulario.cbRegion', arrayVacio());
           accion('formulario.cbRegion', '.disabled=true');
           
           set_combo('formulario.cbZona', arrayVacio());
           accion('formulario.cbZona', '.disabled=true');
           
           set_combo('formulario.cbSeccion', arrayVacio());
           accion('formulario.cbSeccion', '.disabled=true');
    }
}

function onChangeCbMarca(){
    if( get('formulario.cbMarca')!='' && get('formulario.cbCanal')!='' ){
           set_combo('formulario.cbSubgerenciaVentas', arrayVacio());
           accion('formulario.cbSubgerenciaVentas', '.disabled=true');
           
           set_combo('formulario.cbRegion', arrayVacio());
           accion('formulario.cbRegion', '.disabled=true');
           
           set_combo('formulario.cbZona', arrayVacio());
           accion('formulario.cbZona', '.disabled=true');
           
           set_combo('formulario.cbSeccion', arrayVacio());
           accion('formulario.cbSeccion', '.disabled=true');
           
           recargaComboPeriodoSGV();
    } else {
           set_combo('formulario.cbPeriodo', arrayVacio());
           accion('formulario.cbPeriodo', '.disabled=true');
           
           set_combo('formulario.cbSubgerenciaVentas', arrayVacio());
           accion('formulario.cbSubgerenciaVentas', '.disabled=true');
           
           set_combo('formulario.cbRegion', arrayVacio());
           accion('formulario.cbRegion', '.disabled=true');
           
           set_combo('formulario.cbZona', arrayVacio());
           accion('formulario.cbZona', '.disabled=true');
           
           set_combo('formulario.cbSeccion', arrayVacio());
           accion('formulario.cbSeccion', '.disabled=true');
    }
}

function recargaComboPeriodoSGV(){
    accion('formulario.cbPeriodo', '.disabled=false');
    accion('formulario.cbSubgerenciaVentas', '.disabled=false');
           
    recargaCombo('formulario.cbPeriodo', 'CRAObtenerPeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', 
    armarArrayDTOPeriodo());
    
    recargaCombo('formulario.cbSubgerenciaVentas', 'ZONRecargaSubgerenciaVentas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
    armarArrayDTOSGV());
}

function armarArrayDTOPeriodo(){
     var marca = get('formulario.cbMarca');
     var canal = get('formulario.cbCanal');
     var array = new Array();
     var index = 0;
     
     array[index] = new Array('marca', marca[0]);
     index++;
     
     array[index] = new Array('canal', canal[0]);
     index++;    

     var pais = get("formulario.hPais");
     array[index] = ["pais", pais];
     
     return array;
}

function armarArrayDTOSGV(){
     var marca = get('formulario.cbMarca');
     var canal = get('formulario.cbCanal');
     var array = new Array();
     var index = 0;
     
     array[index] = new Array('oidMarca', marca[0]);
     index++;
     
     array[index] = new Array('oidCanal', canal[0]);
     index++;    

     var pais = get("formulario.hPais");
     array[index] = ["oidPais", pais];
     
     return array;
}

function continuarConRezonificacion(nombreFichero){
    eval('formulario').oculto = 'N';
    set('formulario.conectorAction', 'LPReestructurarPrimeraFase');
    set('formulario.casoDeUso', 'ProcesarReestructuracionUA');
    set('formulario.seleccion', nombreFichero);
    set('formulario.accion', 'procesar');
    enviaSICC('formulario', null, null, 'N');    
}

function fLimpiar(){
    eval('formulario').oculto = 'N';
    set('formulario.conectorAction', 'LPEjecutarReestructuracionUA');
    set('formulario.accion', '');
    enviaSICC('formulario', null, null, 'N');
}

function mostrarLista1(){

    DrdEnsanchaConMargenDcho('listado1',28);
    document.all["Cplistado1"].style.visibility=''; 
    document.all["CpLin1listado1"].style.visibility='';  
    document.all["CpLin2listado1"].style.visibility=''; 
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';  
    
    eval (ON_RSZ);      
}

function ocultarLista1(){

    DrdEnsanchaConMargenDcho('listado1',28);
    document.all["Cplistado1"].style.visibility='hidden'; 
    document.all["CpLin1listado1"].style.visibility='hidden';  
    document.all["CpLin2listado1"].style.visibility='hidden'; 
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';  
    
    eval (ON_RSZ);      
}

function mostrarLista2(){

    DrdEnsanchaConMargenDcho('listado2',28);
    document.all["Cplistado2"].style.visibility=''; 
    document.all["CpLin1listado2"].style.visibility='';  
    document.all["CpLin2listado2"].style.visibility=''; 
    document.all["CpLin3listado2"].style.visibility='';
    document.all["CpLin4listado2"].style.visibility='';  
    
    eval (ON_RSZ);      
}

function ocultarLista2(){

    DrdEnsanchaConMargenDcho('listado2',28);
    document.all["Cplistado2"].style.visibility='hidden'; 
    document.all["CpLin1listado2"].style.visibility='hidden';  
    document.all["CpLin2listado2"].style.visibility='hidden'; 
    document.all["CpLin3listado2"].style.visibility='hidden';
    document.all["CpLin4listado2"].style.visibility='hidden';  
    
    eval (ON_RSZ);      
}

function focalizaBuscar(){
    focalizaBotonHTML('botonContenido','btnBuscar');
}

function onChangeCbSVGTrasv(){
    if( get('formulario.cbSubgerenciaVentasTrasv')!='' && atribBuscUAInferior != "oidSGV"){     
           
           set_combo('formulario.cbZonaTrasv', arrayVacio());
           accion('formulario.cbZonaTrasv', '.disabled=true');
           
           set_combo('formulario.cbSeccionTrasv', arrayVacio());
           accion('formulario.cbSeccionTrasv', '.disabled=true');
           
           accion('formulario.cbRegionTrasv', '.disabled=false');
           
           recargaCombo('formulario.cbRegionTrasv', 'ZONRecargaRegiones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
           [['oidSGV', get('formulario.cbSubgerenciaVentasTrasv')]], 'recargarRegTrasv(datos)');
           
    } else {
           set_combo('formulario.cbRegionTrasv', arrayVacio());
           accion('formulario.cbRegionTrasv', '.disabled=true');
           
           set_combo('formulario.cbZonaTrasv', arrayVacio());
           accion('formulario.cbZonaTrasv', '.disabled=true');
           
           set_combo('formulario.cbSeccionTrasv', arrayVacio());
           accion('formulario.cbSeccionTrasv', '.disabled=true');
    }
}

function recargarRegTrasv(datos){ 
    seteo = cargaArray(datos);
    
    set_combo('formulario.cbRegionTrasv', seteo);
    borrarUA("R");
}

function onChangeCbRegionTrasv(){
    if( get('formulario.cbRegionTrasv')!='' && atribBuscUAInferior != "oidRegion"){           
           set_combo('formulario.cbSeccionTrasv', arrayVacio());
           accion('formulario.cbSeccionTrasv', '.disabled=true');
           
           accion('formulario.cbZonaTrasv', '.disabled=false');
           
           recargaCombo('formulario.cbZonaTrasv', 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
           [['oidRegion', get('formulario.cbRegionTrasv')]], 'recargarZonTrasv(datos)');
           
    } else {           
           set_combo('formulario.cbZonaTrasv', arrayVacio());
           accion('formulario.cbZonaTrasv', '.disabled=true');
           
           set_combo('formulario.cbSeccionTrasv', arrayVacio());
           accion('formulario.cbSeccionTrasv', '.disabled=true');
    }
}

function recargarZonTrasv(datos){ 
    seteo = cargaArray(datos);
    
    set_combo('formulario.cbZonaTrasv', seteo);
    borrarUA("Z");
}


function onChangeCbZonaTrasv(){
    if( get('formulario.cbZonaTrasv')!='' && atribBuscUAInferior != "oidZona"){   
           
           accion('formulario.cbSeccionTrasv', '.disabled=false');
           
           recargaCombo('formulario.cbSeccionTrasv', 'ZONRecargaSecciones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
           [['oidZona', get('formulario.cbZonaTrasv')]], 'recargarSeccTrasv(datos)');
           
    } else {         
           set_combo('formulario.cbSeccionTrasv', arrayVacio());
           accion('formulario.cbSeccionTrasv', '.disabled=true');
    }
}

function recargarSeccTrasv(datos){ 
    seteo = cargaArray(datos);
    
    set_combo('formulario.cbSeccionTrasv', seteo);
    borrarUA("S");
}



function focalizaBuscarTab(){
  if(get_visibilidad('capaParticion')){
      focaliza("formulario.txtUACrear");
  } else if(get_visibilidad('capaTrasvase')){
      focaliza("formulario.cbSubgerenciaVentasTrasv");
  } else if(get_visibilidad('capaFusion')){
      focaliza("formulario.cbUA2Fusionar");
  } else {
      focaliza("formulario.cbMarca");
  }  
}

function focalizabuscarShTab(){
  if(get_visibilidad('capaParticion')){
      focalizaBotonHTML_XY('ProcesarPart');
  } else if(get_visibilidad('capaTrasvase')){
      focalizaBotonHTML_XY('ProcesarTrasv');
  } else if(get_visibilidad('capaFusion')){
      focalizaBotonHTML('botonContenido','ProcesarFusion');
  } else {     
      focaliza("formulario.cbTipoOperacion");
  }  
}

function focalizaMarcaShTab(){
    focalizaBotonHTML('botonContenido','btnBuscar');
}

function focalizaTab(tipoOp){
    if(tipoOp=="P"){
          focalizaBotonHTML_XY('EliminarPart');
    } else if(tipoOp=="T"){
          focalizaBotonHTML_XY('EliminarTrasv');
    }
}

function focalizaProcesarTab(){
    focalizaBotonHTML('botonContenido','btnBuscar');
}

function focalizaEliminarShTab(tipoOp){
    if(tipoOp=="P"){
          focalizaBotonHTML('botonContenido','btnAniadirPart');
    } else if(tipoOp=="T"){
          focalizaBotonHTML('botonContenido','btnAniadirTrasv');
    }
}