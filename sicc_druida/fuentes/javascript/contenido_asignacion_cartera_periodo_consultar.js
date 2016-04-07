   
	function onLoadPag()   
	{
      configurarMenuSecundario("frmUnico");
  
	    DrdEnsanchaConMargenDcho('listado1',12);
	
      ocultarLista();
      /*
	    document.all["Cplistado1"].style.visibility='';
	    document.all["CpLin1listado1"].style.visibility='';
	    document.all["CpLin2listado1"].style.visibility='';
	    document.all["CpLin3listado1"].style.visibility='';
	    document.all["CpLin4listado1"].style.visibility='';

	    document.all["primera1Div"].style.visibility='';
	    document.all["ret1Div"].style.visibility='';
	    document.all["ava1Div"].style.visibility='';
	    document.all["separaDiv"].style.visibility='';
      */
	    eval (ON_RSZ);  
      
      focaliza('frmUnico.cbEtapa');
	}
  function ocultarLista() {
      document.all["Cplistado1"].style.visibility='hidden';
      document.all["CpLin1listado1"].style.visibility='hidden';
      document.all["CpLin2listado1"].style.visibility='hidden';
      document.all["CpLin3listado1"].style.visibility='hidden';
      document.all["CpLin4listado1"].style.visibility='hidden';
      document.all["primera1Div"].style.visibility='hidden';
      document.all["ret1Div"].style.visibility='hidden';
      document.all["ava1Div"].style.visibility='hidden';
      document.all["separaDiv"].style.visibility='hidden';
      document.all["DetalleDiv"].style.visibility='hidden';
      //document.all["ModificarDiv"].style.visibility='hidden';
  }
  function mostrarLista() {
      document.all["Cplistado1"].style.visibility='';
      document.all["CpLin1listado1"].style.visibility='';
      document.all["CpLin2listado1"].style.visibility='';
      document.all["CpLin3listado1"].style.visibility='';
      document.all["CpLin4listado1"].style.visibility='';
      document.all["primera1Div"].style.visibility='';
      document.all["ret1Div"].style.visibility='';
      document.all["ava1Div"].style.visibility='';
      document.all["separaDiv"].style.visibility='';
      document.all["DetalleDiv"].style.visibility='';


      //eval (ON_RSZ);  

  }  

function resultadoLista(ultima, rowset){

  rows = rowset.length;
  
  if (rows>0) {
    mostrarLista();
	return true;
  } else {
    ocultarLista();
  }
  
}

  
function fLimpiar(){
  ocultarLista();
  focaliza('frmUnico.cbEtapa');
  accion('frmUnico.cbPeriodo','.disabled=true');    
  set_combo('frmUnico.cbPeriodo',['','']);       
}
function validaFecha(){  
  
  var formatoFecha = get("frmUnico.hFormatoFechaPais" ); 
  var fec = get("frmUnico.textFechaAsignacion"); 
  if (!EsFechaValida_SICC(fec , "frmUnico") )
      { 
            GestionarMensaje("1006", formatoFecha, null, null); 
            focaliza("frmUnico.textFechaAsignacion"); 
            return false; 
      }
      else var OK = true; 
  
}  
  
  function onClickBuscar(){
    ocultarLista();
    
  if(!sicc_validaciones_generales("gr")){
       return false;
    }  
    configurarPaginado(mipgndo,'COBConsultarAsignacionCartera',
      'ConectorConsultarAsignacionCartera',
      "es.indra.sicc.dtos.cob.DTOConsultarAsignacionCartera",
      armaArray());   

  }
  function armaArray(){
      var arrDatos = new Array();
      var i=0;

      if (get('frmUnico.textFechaAsignacion')!=''){
          arrDatos[i] = new Array('fechaAsignacion',get('frmUnico.textFechaAsignacion'));
          i++;
      }
      if (get('frmUnico.cbPeriodo')!=''){
            arrDatos[i] = new Array('oidPeriodo',get('frmUnico.cbPeriodo'));
            i++;
      }
      if (get('frmUnico.cbCanal')!=''){
            arrDatos[i] = new Array('oidCanal',get('frmUnico.cbCanal'));
            i++;
      }
      if (get('frmUnico.cbEtapa')!=''){
            arrDatos[i] = new Array('oidEtapa',get('frmUnico.cbEtapa'));
            i++;
      }      
      if (get('frmUnico.cbMarca')!=''){
            arrDatos[i] = new Array('oidMarca',get('frmUnico.cbMarca'));
            i++;
      }
      if (get('frmUnico.hoidPais')!=''){
            arrDatos[i] = new Array('oidPais',get('frmUnico.hoidPais'));
            i++;
      }    
      if (get('frmUnico.hoidIdioma')!=''){
            arrDatos[i] = new Array('oidIdioma',get('frmUnico.hoidIdioma'));
            i++;
      }           
      return arrDatos;      
  }  
  function onClickDetalle(){        
      if (listado1.numSelecc() >= 1){
          if (listado1.numSelecc() == 1){                         
              set('frmUnico.accion','detalle');
              var parametros = new Object();  
              parametros.oidCobranza = listado1.codSeleccionados();
              parametros.hCasoDetalle = get('frmUnico.casoDeUso');
              mostrarModalSICC("LPConsultarAsignacionCarteraPeriodo", "detalle", parametros, 860, 450);              
          }else{
              GestionarMensaje('8',null,null,null);
          }
      }else{
          GestionarMensaje('4',null,null,null);			
      }    
  }
  
  function recargarCombos(){
        accion('frmUnico.cbPeriodo','.disabled=false');
        var arr = new Array();
        arr[arr.length]=new Array("canal", get("frmUnico.cbCanal"));
        arr[arr.length]=new Array("marca", get("frmUnico.cbMarca"));
        arr[arr.length]=new Array("oidIdioma", get('frmUnico.hoidIdioma'));
        arr[arr.length]=new Array("pais", get('frmUnico.hoidPais'));
        arr[arr.length]=new Array("oidPais", get('frmUnico.hoidPais'));
        recargaCombo('frmUnico.cbPeriodo', 'CRAObtienePeriodos', "es.indra.sicc.dtos.cra.DTOPeriodo",arr);    
  }
  function marcaOnChange(){
    if ((get("frmUnico.cbMarca")=='')&&
        (get("frmUnico.cbCanal")=='')){
        accion('frmUnico.cbPeriodo','.disabled=true');    
        set_combo('frmUnico.cbPeriodo',['','']);        
    } else {  
        recargarCombos();
    }
  }
  function canalOnChange(){
    if ((get("frmUnico.cbMarca")=='')&&
        (get("frmUnico.cbCanal")=='')){
        accion('frmUnico.cbPeriodo','.disabled=true');    
        set_combo('frmUnico.cbPeriodo',['','']);        
    } else {  
        recargarCombos();
    }
  }
  function arrayComponentes(){
    var arr = new Array();
    arr[arr.length]= new Array("cbEtapa","");
    arr[arr.length]= new Array("cbMarca","");
    arr[arr.length]= new Array("cbCanal","");
    arr[arr.length]= new Array("cbPeriodo","");             
    arr[arr.length]= new Array("textFechaAsignacion","");  
  
    arr[arr.length]= new Array("btnBuscar","BOTON");  
    arr[arr.length]= new Array("Detalle","BOTONXY");  
    
    return arr;
  }
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
          }
        }
    }
  }