var seqPart = 1;
var seqTrasv = 1;

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
     accion('formulario.cbTerrPartir', '.disabled=true');
     accion('formulario.cbTerrOrigTrasv', '.disabled=true');
}

function deshabilitarCamposTrasv(){
     accion('formulario.cbRegionTrasv', '.disabled=true');
     accion('formulario.cbZonaTrasv', '.disabled=true');
     accion('formulario.cbSeccionTrasv', '.disabled=true');
     accion('formulario.cbTerrDest', '.disabled=true');
}


function fGuardar(){

     if((get('formulario.cbTipoOperacion')!='F' && validarConsultorasAsignadas()) || 
         (get('formulario.cbTipoOperacion')=='F' && sicc_validaciones_generales("gGuardarFusion") && validaTerrAFusionar())){
         
         eval('formulario').oculto = 'S';
         set('formulario.codTerrPartir', get('formulario.cbTerrPartir','T'));   
         set('formulario.codTerrOrigTrasv', get('formulario.cbTerrOrigTrasv','T'));   
         set('formulario.codTerr1Fusionar', get('formulario.cbTerr1Fusionar','T'));   
         set('formulario.codTerr2Fusionar', get('formulario.cbTerr2Fusionar','T'));   
         set('formulario.listaDetalles', armarListaDetalles());   
         set('formulario.conectorAction', 'LPEjecutarReterritorializacion');
         set('formulario.accion', 'guardar');
         enviaSICC('formulario', null, null, 'N');
         
     }
}

function validaTerrAFusionar(){  

   var terr1Fusionar= get('formulario.cbTerr1Fusionar');
   var terr2Fusionar= get('formulario.cbTerr2Fusionar');

  if(Number(terr1Fusionar)==Number(terr2Fusionar)){
      GestionarMensaje('2603');      
      return false;
      
  } else {
      return true;
  }
}

function validarConsultorasAsignadas(){  
    if(get('formulario.cbTipoOperacion')=='P'){
         cantClientes = combo_get('formulario.cbConsultorasPart','L');    
         
         if(cantClientes!=1){
             GestionarMensaje('2600');
             return false;
         }
         
    } else if(get('formulario.cbTipoOperacion')=='T'){
         if(listado2.codigos().length==0){
             GestionarMensaje('2601');
             return false;
         }
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

           terrAsig = listado1.extraeDato(codigos[i], 0);
           cadena = cadena + terrAsig + "#";
           
           cliente = listado1.extraeDato(codigos[i], 3);
           cadena = cadena + cliente + "#";
           
           nse1 = listado1.extraeDato(codigos[i], 5);
           cadena = cadena + nse1 + "#";
           
           nse2 = listado1.extraeDato(codigos[i], 6);
           cadena = cadena + nse2;           
      }
      
  } else if(get('formulario.cbTipoOperacion')=='T'){
  
      codigos = listado2.codigos();
      
      for (var i=0; i<codigos.length ; i++){
           if( i!= 0)
             cadena = cadena + "|";

           terrAsig = listado2.extraeDato(codigos[i], 0);
           cadena = cadena + terrAsig + "#";
           
           cliente = listado2.extraeDato(codigos[i], 1);           
           cadena = cadena + cliente;        
      }
  }
  
  return cadena;
}
                          

function onClickBtnAniadirTrasv(){  

  if(sicc_validaciones_generales("gAniadirTrasv")) {
   
         oidClientes = get('formulario.cbConsultorasTrasv');
         codClientes = get('formulario.cbConsultorasTrasv', 'T');
         
         for(i=0; i < oidClientes.length; i++){
             oid = listado2.generaCodigo(seqTrasv);
             seqTrasv = oid;
             
            // alert("oid: "+ oidClientes[i]+ " cod:" + codClientes[i]);
             
             listado2.insertar(new Array(oid, get('formulario.cbTerrDest','T'),
                                             codClientes[i], oidClientes[i]));  
             // Borrar consultora                 
             borrarConsultoraTrasv(oidClientes[i]);
         }
                  
         set_combo('formulario.cbRegionTrasv', arrayVacio());
         accion('formulario.cbRegionTrasv', '.disabled=true');
          
         set_combo('formulario.cbZonaTrasv', arrayVacio());
         accion('formulario.cbZonaTrasv', '.disabled=true');
          
         set_combo('formulario.cbSeccionTrasv', arrayVacio());
         accion('formulario.cbSeccionTrasv', '.disabled=true');
          
         set_combo('formulario.cbTerrDest', arrayVacio());
         accion('formulario.cbTerrDest', '.disabled=true');
                  
         set('formulario.cbSubgerenciaVentasTrasv', '');  
   }
}

function borrarConsultoraTrasv(oidCliente){      
    // Borrar consultora
    cantConsult = combo_get('formulario.cbConsultorasTrasv','L');    
    
    for(j=0; j<cantConsult; j++){
         if(combo_get('formulario.cbConsultorasTrasv','V',j) == oidCliente){
             del_combo('formulario.cbConsultorasTrasv',j);
             break;
         }
    }    
}


function onClickEliminarTrasv(){ 
    var codSeleccionados = listado2.codSeleccionados();

    for (var i=0; i<codSeleccionados.length ; i++){         
         combo_add('formulario.cbConsultorasTrasv',listado2.extraeDato(codSeleccionados[i], 2),listado2.extraeDato(codSeleccionados[i], 1));              
    }
    listado2.eliminarSelecc();
}
     

function onClickBtnAniadirPart(){  

  if(sicc_validaciones_generales("gAniadirPart")) {
    if(validarIgualNSE()){
   
         oidClientes = get('formulario.cbConsultorasPart');
         codClientes = get('formulario.cbConsultorasPart', 'T');
         
         for(i=0; i < oidClientes.length; i++){
             oid = listado1.generaCodigo(seqPart);
             seqPart = oid;
             
            // alert("oid: "+ oidClientes[i]+ " cod:" + codClientes[i]);
             
             listado1.insertar(new Array(oid, get('formulario.txtTerrCrear'),
                                             get('formulario.cbNSE1','T') , get('formulario.cbNSE2','T'), 
                                             codClientes[i], oidClientes[i],
                                             get('formulario.cbNSE1'), get('formulario.cbNSE2')));  
             // Borrar consultora                 
             borrarConsultoraPart(oidClientes[i]);
         }
                  
         set('formulario.txtTerrCrear', '');    
         set('formulario.cbNSE1', '');    
         set('formulario.cbNSE2', '');  
     }
   }
}

function validarIgualNSE(){    
    var terrCrear = get('formulario.txtTerrCrear');
    var nse1 = get('formulario.cbNSE1');
    var nse2 = get('formulario.cbNSE2');

    var codigos = listado1.codigos();
         
    for(var i=0; i<codigos.length; i++){
         codigo = codigos[i];         
         
        if(terrCrear == listado1.extraeDato(codigo, 0) && (nse1!=listado1.extraeDato(codigo, 5) || nse2!=listado1.extraeDato(codigo, 6))){
           GestionarMensaje('2599');
           return false;
        }
    }

    return true;
}

function borrarConsultoraPart(oidCliente){      
    // Borrar consultora
    cantConsult = combo_get('formulario.cbConsultorasPart','L');    
    
    for(j=0; j<cantConsult; j++){
         if(combo_get('formulario.cbConsultorasPart','V',j) == oidCliente){
             del_combo('formulario.cbConsultorasPart',j);
             break;
         }
    }    
}

function onClickEliminarPart(){ 
    var codSeleccionados = listado1.codSeleccionados();

    for (var i=0; i<codSeleccionados.length ; i++){         
      //  alert("oid: "+listado1.extraeDato(codSeleccionados[i], 4)+ " cod:" + listado1.extraeDato(codSeleccionados[i], 3));
        /* 
         alert(listado1.extraeDato(codSeleccionados[i], 1));
         alert(listado1.extraeDato(codSeleccionados[i], 2));
         alert(listado1.extraeDato(codSeleccionados[i], 3));
         alert(listado1.extraeDato(codSeleccionados[i], 4));
         alert(listado1.extraeDato(codSeleccionados[i], 5));
         alert(listado1.extraeDato(codSeleccionados[i], 6));
         alert(listado1.extraeDato(codSeleccionados[i], 7));
         */
         
         combo_add('formulario.cbConsultorasPart',listado1.extraeDato(codSeleccionados[i], 4),listado1.extraeDato(codSeleccionados[i], 3));              
    }
    listado1.eliminarSelecc();
}

function onClickBtnBuscar(){  

  if(sicc_validaciones_generales("gBuscar")) {
      if((get('formulario.cbTipoOperacion')=='P' && sicc_validaciones_generales("gBuscarPart")) 
           || get('formulario.cbTipoOperacion')=='T' && sicc_validaciones_generales("gBuscarTrav")) {
           
           deshabilitarCab();
           
           var combo = "";
           var territorio = "";
           
           if(get('formulario.cbTipoOperacion')=='P'){
                visibilidad('capaParticion','V');
                mostrarLista1();
                visibilidad('capaLista1','V');
                
                combo = 'formulario.cbConsultorasPart';
                territorio = get('formulario.cbTerrPartir');
                
           } else if(get('formulario.cbTipoOperacion')=='T'){
                deshabilitarCamposTrasv();
                visibilidad('capaTrasvase','V');
                mostrarLista2();
                visibilidad('capaLista2','V');
                
                combo = 'formulario.cbConsultorasTrasv';   
                territorio = get('formulario.cbTerrOrigTrasv');          
                
                recargaCombo('formulario.cbSubgerenciaVentasTrasv', 'ZONRecargaSubgerenciaVentas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
                armarArrayDTOSGV());
           }
           
           // Habilita boton guardar
           btnProxy(1, '1');
           
           recargaCombo(combo, 'ZONRecargaConsultoras', 'es.indra.sicc.util.DTOOID', 
           [['oid', territorio]]);
           
           eval('formulario').oculto = 'S';             
           set('formulario.conectorAction', 'LPEjecutarReterritorializacion');
           set('formulario.accion', 'buscar');
           enviaSICC('formulario', null, null, 'N');
           
      } else if(get('formulario.cbTipoOperacion')=='F'){
           deshabilitarCab();
           visibilidad('capaFusion','V');
      }
  }
}


function guardarUAPadre(uaPadre){ 
    set('formulario.UAPadre', uaPadre);
}

function borrarTerritorio(territorio){    
    cantTerrDest = combo_get('formulario.cbTerrDest','L');    
    
    for(j=0; j<cantTerrDest; j++){
         if(combo_get('formulario.cbTerrDest','V',j) == territorio){
             del_combo('formulario.cbTerrDest',j);
             break;
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
     accion('formulario.cbTerrPartir', '.disabled=true');
     accion('formulario.cbTerrOrigTrasv', '.disabled=true');
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
          
          set_combo('formulario.cbTerrPartir', arrayVacio());
          accion('formulario.cbTerrPartir', '.disabled=true');
          
          set_combo('formulario.cbTerrOrigTrasv', arrayVacio());
          accion('formulario.cbTerrOrigTrasv', '.disabled=true');
          
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
          
          set_combo('formulario.cbTerrPartir', arrayVacio());
          accion('formulario.cbTerrPartir', '.disabled=true');
          
          set_combo('formulario.cbTerrOrigTrasv', arrayVacio());
          accion('formulario.cbTerrOrigTrasv', '.disabled=true');
    }
}

function onChangeCbRegion(){
    if( get('formulario.cbRegion')!=''){             
          set_combo('formulario.cbSeccion', arrayVacio());
          accion('formulario.cbSeccion', '.disabled=true');
          
          set_combo('formulario.cbTerrPartir', arrayVacio());
          accion('formulario.cbTerrPartir', '.disabled=true');
          
          set_combo('formulario.cbTerrOrigTrasv', arrayVacio());
          accion('formulario.cbTerrOrigTrasv', '.disabled=true');
          
          accion('formulario.cbZona', '.disabled=false');
          
          recargaCombo('formulario.cbZona', 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
          [['oidRegion', get('formulario.cbRegion')]]);
          
    } else {          
          set_combo('formulario.cbZona', arrayVacio());
          accion('formulario.cbZona', '.disabled=true');
          
          set_combo('formulario.cbSeccion', arrayVacio());
          accion('formulario.cbSeccion', '.disabled=true');
          
          set_combo('formulario.cbTerrPartir', arrayVacio());
          accion('formulario.cbTerrPartir', '.disabled=true');
          
          set_combo('formulario.cbTerrOrigTrasv', arrayVacio());
          accion('formulario.cbTerrOrigTrasv', '.disabled=true');
    }
}

function onChangeCbZona(){
    if( get('formulario.cbZona')!=''){             
          set_combo('formulario.cbTerrPartir', arrayVacio());
          accion('formulario.cbTerrPartir', '.disabled=true');
          
          set_combo('formulario.cbTerrOrigTrasv', arrayVacio());
          accion('formulario.cbTerrOrigTrasv', '.disabled=true');
          
          accion('formulario.cbSeccion', '.disabled=false');
          
          recargaCombo('formulario.cbSeccion', 'ZONRecargaSecciones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
          [['oidZona', get('formulario.cbZona')]]);
          
    } else {        
          set_combo('formulario.cbSeccion', arrayVacio());
          accion('formulario.cbSeccion', '.disabled=true');
          
          set_combo('formulario.cbTerrPartir', arrayVacio());
          accion('formulario.cbTerrPartir', '.disabled=true');
          
          set_combo('formulario.cbTerrOrigTrasv', arrayVacio());
          accion('formulario.cbTerrOrigTrasv', '.disabled=true');
    }
}

function onChangeCbSeccion(){
    if( get('formulario.cbSeccion')!='' && get('formulario.cbTipoOperacion')!=''){     
          
          recargaComboTerritorio();
          
    } else {     
          
          set_combo('formulario.cbTerrPartir', arrayVacio());
          accion('formulario.cbTerrPartir', '.disabled=true');
          
          set_combo('formulario.cbTerrOrigTrasv', arrayVacio());
          accion('formulario.cbTerrOrigTrasv', '.disabled=true');
    }
}

function onChangeCbTipoOperacion(){
    if( get('formulario.cbSeccion')!='' && get('formulario.cbTipoOperacion')!=''){     
          
          recargaComboTerritorio();
          
    } else {     
          
          set_combo('formulario.cbTerrPartir', arrayVacio());
          accion('formulario.cbTerrPartir', '.disabled=true');
          
          set_combo('formulario.cbTerrOrigTrasv', arrayVacio());
          accion('formulario.cbTerrOrigTrasv', '.disabled=true');
          
          set_combo('formulario.cbTerr1Fusionar', arrayVacio());
          accion('formulario.cbTerr1Fusionar', '.disabled=true');
          
          set_combo('formulario.cbTerr2Fusionar', arrayVacio());
          accion('formulario.cbTerr2Fusionar', '.disabled=true');
    }
}


function recargaComboTerritorio(){

    if(get('formulario.cbTipoOperacion')=='P'){
         accion('formulario.cbTerrPartir', '.disabled=false');
         
         set_combo('formulario.cbTerrOrigTrasv', arrayVacio());
         accion('formulario.cbTerrOrigTrasv', '.disabled=true');         
              
         recargaCombo('formulario.cbTerrPartir', 'ZONRecargaTerritorios', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
          [['oidSeccion', get('formulario.cbSeccion')]]);
         
    } else if(get('formulario.cbTipoOperacion')=='T'){
         accion('formulario.cbTerrOrigTrasv', '.disabled=false');
         
         set_combo('formulario.cbTerrPartir', arrayVacio());
         accion('formulario.cbTerrPartir', '.disabled=true');
         
         recargaCombo('formulario.cbTerrOrigTrasv', 'ZONRecargaTerritorios', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
          [['oidSeccion', get('formulario.cbSeccion')]], 'recargarTerrTrasv(datos)');
          
    } else if(get('formulario.cbTipoOperacion')=='F'){
    
         set_combo('formulario.cbTerrOrigTrasv', arrayVacio());
         accion('formulario.cbTerrOrigTrasv', '.disabled=true');
         
         set_combo('formulario.cbTerrPartir', arrayVacio());
         accion('formulario.cbTerrPartir', '.disabled=true');
         
         recargaCombo('formulario.cbTerr1Fusionar', 'ZONRecargaTerritorios', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
          [['oidSeccion', get('formulario.cbSeccion')]], 'recargarTerrFusion(datos)');
    } 
}

function recargarTerrTrasv(datos){
    seteo = cargaArray(datos);
    
    set_combo('formulario.cbTerrOrigTrasv', seteo);
}

function recargarTerrFusion(datos){
    seteo = cargaArray(datos);
    
    set_combo('formulario.cbTerr1Fusionar', seteo);
    set_combo('formulario.cbTerr2Fusionar', seteo);
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
          
          set_combo('formulario.cbTerrPartir', arrayVacio());
          accion('formulario.cbTerrPartir', '.disabled=true');
          
          set_combo('formulario.cbTerrOrigTrasv', arrayVacio());
          accion('formulario.cbTerrOrigTrasv', '.disabled=true');
          
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
          
          set_combo('formulario.cbTerrPartir', arrayVacio());
          accion('formulario.cbTerrPartir', '.disabled=true');
          
          set_combo('formulario.cbTerrOrigTrasv', arrayVacio());
          accion('formulario.cbTerrOrigTrasv', '.disabled=true');
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
          
          set_combo('formulario.cbTerrPartir', arrayVacio());
          accion('formulario.cbTerrPartir', '.disabled=true');
          
          set_combo('formulario.cbTerrOrigTrasv', arrayVacio());
          accion('formulario.cbTerrOrigTrasv', '.disabled=true');
          
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
          
          set_combo('formulario.cbTerrPartir', arrayVacio());
          accion('formulario.cbTerrPartir', '.disabled=true');
          
          set_combo('formulario.cbTerrOrigTrasv', arrayVacio());
          accion('formulario.cbTerrOrigTrasv', '.disabled=true');
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

function mensajeProcesando(){
    GestionarMensaje('M00047');
    
    fLimpiar();
}

function fLimpiar(){
    eval('formulario').oculto = 'N';
    set('formulario.conectorAction', 'LPEjecutarReterritorializacion');
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
    if( get('formulario.cbSubgerenciaVentasTrasv')!=''){     
          
          set_combo('formulario.cbZonaTrasv', arrayVacio());
          accion('formulario.cbZonaTrasv', '.disabled=true');
          
          set_combo('formulario.cbSeccionTrasv', arrayVacio());
          accion('formulario.cbSeccionTrasv', '.disabled=true');
          
          set_combo('formulario.cbTerrDest', arrayVacio());
          accion('formulario.cbTerrDest', '.disabled=true');
          
          accion('formulario.cbRegionTrasv', '.disabled=false');
          
          recargaCombo('formulario.cbRegionTrasv', 'ZONRecargaRegiones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
          [['oidSGV', get('formulario.cbSubgerenciaVentasTrasv')]]);
          
    } else {
          set_combo('formulario.cbRegionTrasv', arrayVacio());
          accion('formulario.cbRegionTrasv', '.disabled=true');
          
          set_combo('formulario.cbZonaTrasv', arrayVacio());
          accion('formulario.cbZonaTrasv', '.disabled=true');
          
          set_combo('formulario.cbSeccionTrasv', arrayVacio());
          accion('formulario.cbSeccionTrasv', '.disabled=true');
          
          set_combo('formulario.cbTerrDest', arrayVacio());
          accion('formulario.cbTerrDest', '.disabled=true');
    }
}

function onChangeCbRegionTrasv(){
    if( get('formulario.cbRegionTrasv')!=''){             
          set_combo('formulario.cbSeccionTrasv', arrayVacio());
          accion('formulario.cbSeccionTrasv', '.disabled=true');
          
          set_combo('formulario.cbTerrDest', arrayVacio());
          accion('formulario.cbTerrDest', '.disabled=true');
          
          accion('formulario.cbZonaTrasv', '.disabled=false');
          
          recargaCombo('formulario.cbZonaTrasv', 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
          [['oidRegion', get('formulario.cbRegionTrasv')]]);
          
    } else {          
          set_combo('formulario.cbZonaTrasv', arrayVacio());
          accion('formulario.cbZonaTrasv', '.disabled=true');
          
          set_combo('formulario.cbSeccionTrasv', arrayVacio());
          accion('formulario.cbSeccionTrasv', '.disabled=true');
          
          set_combo('formulario.cbTerrDest', arrayVacio());
          accion('formulario.cbTerrDest', '.disabled=true');
    }
}

function onChangeCbZonaTrasv(){
    if( get('formulario.cbZonaTrasv')!=''){             
          set_combo('formulario.cbTerrDest', arrayVacio());
          accion('formulario.cbTerrDest', '.disabled=true');
          
          accion('formulario.cbSeccionTrasv', '.disabled=false');
          
          recargaCombo('formulario.cbSeccionTrasv', 'ZONRecargaSecciones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
          [['oidZona', get('formulario.cbZonaTrasv')]]);
          
    } else {        
          set_combo('formulario.cbSeccionTrasv', arrayVacio());
          accion('formulario.cbSeccionTrasv', '.disabled=true');
          
          set_combo('formulario.cbTerrDest', arrayVacio());
          accion('formulario.cbTerrDest', '.disabled=true');
    }
}

function onChangeCbSeccionTrasv(){
    if( get('formulario.cbSeccionTrasv')!=''){     
          
         accion('formulario.cbTerrDest', '.disabled=false');     
              
         recargaCombo('formulario.cbTerrDest', 'ZONRecargaTerritorios', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
          [['oidSeccion', get('formulario.cbSeccionTrasv')]], 'recargarTerrDestTrasv(datos)');
          
    } else {     
          
          set_combo('formulario.cbTerrDest', arrayVacio());
          accion('formulario.cbTerrDest', '.disabled=true');
    }
}

function recargarTerrDestTrasv(datos){
    seteo = cargaArray(datos);
    
    set_combo('formulario.cbTerrDest', seteo);
    
    territorio = get('formulario.cbTerrOrigTrasv');     
    borrarTerritorio(territorio);
}

function focalizaBuscarTab(){
  if(get_visibilidad('capaParticion')){
      focaliza("formulario.txtTerrCrear");
  } else if(get_visibilidad('capaTrasvase')){
      focaliza("formulario.cbSubgerenciaVentasTrasv");
  } else if(get_visibilidad('capaFusion')){
      focaliza("formulario.cbTerr1Fusionar");
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
      if(cbTerrOrigTrasv.disabled == false){
           focaliza("formulario.cbTerrOrigTrasv");
      } else if(cbTerrPartir.disabled == false){
           focaliza("formulario.cbTerrPartir");
      } else {
           focaliza("formulario.cbTipoOperacion");
      }
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