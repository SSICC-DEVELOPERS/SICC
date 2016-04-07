/**
     Autor : Pcabrera
**/


function onLoadPag()   {

    focaliza("formulario.cbSubgerencia");  
    configurarMenuSecundario("formulario");
    
    varNoLimpiarSICC = true;      
    DrdEnsanchaConMargenDcho('listado1',12);
    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    document.all["separaDiv"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    btnProxy(3, 0);
    
    
    eval(ON_RSZ);  
	  finCargaPagina = true;  
   
    var opcionMenu = get("formulario.opcionMenu"); 
    var btn = get("formulario.botones");
     
    if((opcionMenu == "Consultar Concurso Ranking") || (btn == "SI")){
    //--se deshabilitan los componentes
    //-- y los botones correspondientes
   
      accion("formulario.cbSubgerencia", ".disabled=true");  
      deshabilitarCampos();
      btnProxy(1, 0);
      btnProxy(2, 1);      
      btnProxy(4, 0);
      btnProxy(5, 0);
      btnProxy(7, 0);
      btnProxy(8, 0);
      btnProxy(9, 0);
      
      deshabilitarHabilitarBoton('botonContenido','btnAnadir','D');
	 }   
   
    if((opcionMenu == "Modificar Concurso Ranking")){
        btnProxy(2, 1);
        btnProxy(7, 0);
        btnProxy(8, 0);
        btnProxy(9, 0);
    
    }
    
   if (get("formulario.errDescripcion")!='') {
		     var wnd = fMostrarMensajeError(get("formulario.errCodigo"), get("formulario.errDescripcion"));
			      //ocultarLista();
	 }
  
   deshabilitarCampos(); 
  
   
   focaliza("formulario.cbSubgerencia"); 
 }
 

   
 function onChangeSubgerencia(){
  
  var valor = get('formulario.cbSubgerencia');

	if (valor!=""){
		var arra = new Array();
	  
    arra[0] = ["oidPais",get('formulario.oidPais')];
		arra[1] = ["oidMarca",get('formulario.hidMarca')];
	  arra[2] = ["oidCanal",get('formulario.hidCanal')];
		arra[3] = ["oidSGV",get('formulario.cbSubgerencia')];      
	      
    recargaCombo("formulario.cbRegion","ZONRecargaRegiones","es.indra.sicc.dtos.zon.DTOUnidadAdministrativa",arra);
    accion("formulario.cbRegion", ".disabled=false");
  
  }else{
          set_combo('formulario.cbRegion',['','']);
          set_combo('formulario.cbZona',['','']);
          set_combo('formulario.cbSeccion',['','']);
          set_combo('formulario.cbTerritorio',['','']);  
          deshabilitarCampos(); 
      }   
 }
 

 function onChangeRegion(){
 
  var valor = get('formulario.cbRegion');

	if (valor!=""){
	
  	 var arra = new Array();
     arra[0] = ["oidPais",get('formulario.oidPais')];
		 arra[1] = ["oidMarca",get('formulario.hidMarca')];
	   arra[2] = ["oidCanal",get('formulario.hidCanal')];
		 arra[3] = ["oidRegion",get('formulario.cbRegion')];      
	   
     recargaCombo("formulario.cbZona","ZONRecargaZonas","es.indra.sicc.dtos.zon.DTOUnidadAdministrativa",arra);
     accion("formulario.cbZona", ".disabled=false");
     
  }else{
          set_combo('formulario.cbZona',['','']);
          set_combo('formulario.cbSeccion',['','']);
          set_combo('formulario.cbTerritorio',['','']);  
	}    
 }
  
 
 function onChangeZona(){
	
  var valor = get('formulario.cbZona');

	if (valor!=""){
		
      var arra = new Array();
	    arra[0] = ["oidPais",get('formulario.oidPais')];
		  arra[1] = ["oidMarca",get('formulario.hidMarca')];
	    arra[2] = ["oidCanal",get('formulario.hidCanal')];
		  arra[3] = ["oidSGV",get('formulario.cbSubgerencia')];      
	    arra[4] = ["oidRegion",get('formulario.cbRegion')];      
		  arra[5] = ["oidZona",get('formulario.cbZona')];      
	    
      recargaCombo("formulario.cbSeccion","ZONRecargaSecciones","es.indra.sicc.dtos.zon.DTOUnidadAdministrativa",arra);
      accion("formulario.cbSeccion", ".disabled=false");
  
  }else{
          set_combo('formulario.cbSeccion',['','']);
          set_combo('formulario.cbTerritorio',['','']);  
    }
 }
  
  
 function onChangeSeccion(){
	
  var valor = get('formulario.cbSeccion');

	if (valor!="") {
	    
      var arra = new Array();
      arra[0] = ["oidPais",get('formulario.oidPais')];
	    arra[1] = ["oidMarca",get('formulario.hidMarca')];
      arra[2] = ["oidCanal",get('formulario.hidCanal')];
	    arra[3] = ["oidSGV",get('formulario.cbSubgerencia')];      
      arra[4] = ["oidRegion",get('formulario.cbRegion')];      
	    arra[5] = ["oidZona",get('formulario.cbZona')];      
      arra[6] = ["oidSeccion",get('formulario.cbSeccion')];
		
      recargaCombo("formulario.cbTerritorio","ZONRecargaTerritorios", "es.indra.sicc.dtos.zon.DTOUnidadAdministrativa",arra);
      accion("formulario.cbTerritorio", ".disabled=false");
      
  }else{
          set_combo('formulario.cbTerritorio',['','']);  
	}  
 }
  

  function accionAnadir(){
  
    var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);
    var codigo = listado1.generaCodigo( posi );
    var subg = '';
    var oidSubg = '';
    var region = '';
    var oidRegion = '';
    var zona = '';
    var oidZona = '';
    var seccion = '';
    var oidSeccion = '';
    var terri = '';  
    var oidTerri = '';  
    
    if(!existeFilaDatos()){
      return;
    }
    
    sicc_cambiar_estado("cbSubgerencia",true);  
    
    if(sicc_validaciones_generales()){

        oidSubg = get('formulario.cbSubgerencia');    
        subg = get('formulario.cbSubgerencia','T');          
    
        if (get('formulario.cbRegion')!=""){
            oidRegion = get('formulario.cbRegion');    
            region = get('formulario.cbRegion','T');          
        }
        
        if (get('formulario.cbZona')!=""){
            oidZona = get('formulario.cbZona');    
            zona = get('formulario.cbZona','T');          
        }
        
        if (get('formulario.cbSeccion')!=""){
            oidSeccion = get('formulario.cbSeccion');    
            seccion = get('formulario.cbSeccion','T');          
        }
        
        if (get('formulario.cbTerritorio')!=""){
           oidTerri = get('formulario.cbTerritorio');    
           terri = get('formulario.cbTerritorio','T');          
        }
        
        var newRow = codigo + ',' + subg + ',' + region + ',' +  
                     zona + ',' + seccion + ',' + terri + ',' + 
                     oidSubg + ',' + oidRegion + ',' + oidZona + ',' + 
                     oidSeccion + ',' + oidTerri;
                     
        newRow = newRow.split(",");
        listado1.insertar(newRow);
        set('formulario.hidUltimoElementoEnLaLista', codigo); 
        
        set("formulario.cbSubgerencia",'');
        var aCombo = new Array(new Array("",""));
      
        set_combo("formulario.cbRegion",aCombo,[]);	
        set_combo("formulario.cbZona",aCombo,[]);  
        set_combo("formulario.cbSeccion",aCombo,[]);
        set_combo("formulario.cbTerritorio",aCombo,[]);
        
        deshabilitarCampos();   
        
        focaliza("formulario.cbSubgerencia"); 
    
    }
  }
  
  //funcion que verifica que no se ingrese datos repetidos en la lista de ambito geografico
  function existeFilaDatos(){
    if(listado1.datos.length > 0){
      var lista = listado1.datos;
      for(var i = 0; i < lista.length; i++ ){
        if(!verificaIgualdad(lista[i])){
          return false;
        }  
      }
    }
    return true;
  }
  
  function verificaIgualdad(dato){
      
      if((dato[1] == get('formulario.cbSubgerencia','T'))&&
         (dato[2] == get('formulario.cbRegion','T'))&&
         (dato[3] == get('formulario.cbZona','T'))&&
         (dato[4] == get('formulario.cbSeccion','T'))&&
         (dato[5] == get('formulario.cbTerritorio','T'))){
       return false;  
     }
    return true;
  }
  
  function accionEliminar(){
  
       var vMostrarMensaje ='';
       var cantElementosL1 = listado1.codSeleccionados();		
       
       if (cantElementosL1.length == 0){
                GestionarMensaje("4", null, null, null);
                return;
       }
       
       if (cantElementosL1.length > 0){
                listado1.eliminarSelecc();
       }         
  }
  
  
  function accionGuardar(){
    
      comprobarDatosObligatorios();      
      
      set('formulario.conectorAction', 'LPMantenerAlcanceGeograficoRanking'); 
      set('formulario.accion', 'guardar');
      eval('formulario').oculto = 'S';
      enviaSICC('formulario',null,null,'N');
    
  }
  
  
 function comprobarDatosObligatorios(){
      var lista = listado1.datos;
      
      if(lista.length == 0){
          set('formulario.indOblig','false');
      } else {
          set('formulario.indOblig','true');    
      }
        
      tomarValoresLista();  
    
      return true;
  }

   
  
  //funcion que toma los datos de la lista editable antes de guardar
  function tomarValoresLista(){
      var lista = listado1.datos;
      var datos = '';
      for(var i = 0; i < lista.length; i++){
          datos = datos + '|' + aplicaUndef(lista[i]);
      }
      
      set('formulario.datos',datos);
  }
  
  function aplicaUndef(dato){
    for(var i = 0; i < dato.length; i++){
        if(dato[i]==''){
          dato[i] = 'undef';
        }  
    }
    return dato;
  }
  
  function fGuardar(){
    accionGuardar();
  }
  
  function fBorrar(){
    accionEliminar();
  }

  function fVolver(){
      window.close();
 }
  
  function fLimpiar(){
  
      if(get('formulario.opcionMenu')!="Modificar Concurso Ranking"){  
  
          set("formulario.cbSubgerencia",'');
          var aCombo = new Array(new Array("",""));
        
          set_combo("formulario.cbRegion",aCombo,[]);	
          set_combo("formulario.cbZona",aCombo,[]);  
          set_combo("formulario.cbSeccion",aCombo,[]);
          set_combo("formulario.cbTerritorio",aCombo,[]);
          
          deshabilitarCampos();   
          
          focaliza("formulario.cbSubgerencia"); 
          
      } else {
          set('formulario.conectorAction', 'LPMantenerAlcanceGeograficoRanking'); 
          set('formulario.accion', '');
          eval('formulario').oculto = 'N';
          enviaSICC('formulario',null,null,'N');
      }
    
  }
  
  function onClickPestanyaH(id,formulario,lp){
    comprobarDatosObligatorios();
    onClickPestanyaHabilitada(id,formulario,lp);
  }
  
  
  function deshabilitarCampos(){    
    accion("formulario.cbRegion", ".disabled=true");
    accion("formulario.cbZona", ".disabled=true");
    accion("formulario.cbSeccion", ".disabled=true");
    accion("formulario.cbTerritorio", ".disabled=true");  
  
  }
  
  
 
  //--Agregado, funcion que sera usada cuando
  // exista algun error al guardar
function guardarKO(){
  
      if(get('formulario.opcionMenu')=="Modificar Concurso Ranking"){  
          btnProxy(1,1);
          btnProxy(2,1);
          btnProxy(3,0);
          btnProxy(4,0);
          btnProxy(5,1);
          btnProxy(7,0);
          btnProxy(8,0);
          btnProxy(9,0);
          
          focaliza("formulario.cbSubgerencia");
          
      } else {
          focaliza("formulario.cbSubgerencia");
      }
          
  }





