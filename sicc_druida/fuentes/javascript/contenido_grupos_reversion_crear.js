var llamoElimina = false;
  
	function onLoadPag()   
	{
	   
	    DrdEnsanchaConMargenDcho('listado1',12);
		eval (ON_RSZ);
		ON_RSZ = '';
		configurarMenuSecundario("frmFormulario");
		 var hayErrores = false;
		 hayErrores = chequeaErrores();
		 if (hayErrores != true)
		 {
			// muestraSeleccionAnterior();
	  		// cargaComboDias();
             ocultarLista();
	 		 focaliza("frmFormulario.cbTipoSolicitud", "");
			 //return;
		 } else {
		      window.close();
			  return;
		 }

  		txt_to('lblTotalSolicitudesX', get('frmFormulario.hNumSol'));
		  focaliza("frmFormulario.cbTipoSolicitud");
      document.all.CpScrolllistado1.attachEvent ('onpropertychange', verificaResultado);
		  //if(get('frmFormulario.accion')=="agregar"){
		  if(parseInt(get('frmFormulario.hNumSol'),10) > 0){
    			configurarPaginado(mipgndo, "PEDCargarGrupoReversion", "ConectorCargarGrupoReversion", "es.indra.sicc.dtos.ped.DTOEGrupoReversion",armarArray());
        	cargarCombos();
    			mostrarLista();
		  } else {
          ocultarLista();
      }
	    
	      
	}

	//*********************OCULTAR LISTA*****************************************
	function ocultarLista(){
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';

    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';
    document.all["btnEliminarDiv"].style.visibility='hidden';
	
}

//*************************************************************

//*****************MOSTRAR LISTA********************************************
function mostrarLista(){
   
    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';

    document.all["primera1Div"].style.visibility='';
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';
    document.all["separaDiv"].style.visibility='';
   // document.all["DetalleDiv"].style.visibility='';
	document.all["btnEliminarDiv"].style.visibility='';
	
}

//*************************************************************
//****************AGREGAR*********************************************

function Agregar(){
  set('frmFormulario.accion','agregar');
  //alert(getValIndexCombo(0));
  set('frmFormulario.cTipoSolic',getValIndexCombo(0));
  //alert(getValIndexCombo(1));
  set('frmFormulario.cSubac',getValIndexCombo(1));
  set('frmFormulario.conectorAction','LPCrearGrupoReversion');
  eval("frmFormulario.oculto = 'N'");
  
  enviaSICC('frmFormulario');
}

//*************************************************************
//****************ARMAR ARRAY *********************************************
function armarArray(){
            
			var hh = new Array();
			hh[0] = new Array('grupoReversion',get('frmFormulario.grupoReversion'));
			
            return hh;
}
//*****************************************************************

function fVolver() {
    window.close();
}

function fEliminar() {
    eliminar();
}
//********************ELIMINAR********************************************

function eliminar(){
	codigos = listado1.codSeleccionados();
	filasSelec = listado1.numSelecc();
	val = 0;
	//alert(codigos);
	if(codigos.length == 0){
			GestionarMensaje('1021', null , null, null);
			//focaliza("frmFormulario.txtCodGrupoSolicitud");
			return;
		}
			eliminarFilas(listado1.codSeleccionados(),'PEDEliminarSolicitudesGrupoReversion',mipgndo);

			//val = Math.abs(parseInt(get('frmFormulario.hNumSol'),10))- Math.abs(filasSelec);
			//set('frmFormulario.hNumSol',val);
  		//txt_to('lblTotalSolicitudesX', get('frmFormulario.hNumSol'));
			
			
}


function verificaResultado() {
      //alert(listado1.datos.length);
      if (event.propertyName == "innerHTML") {
          var cant = listado1.datos.length;
          set('frmFormulario.hNumSol',cant);
          txt_to('lblTotalSolicitudesX', cant);
      }

}

//*****************************************************************

function muestraLista( ultima, rowset){
	var tamano = rowset.length;
	//alert(tamano + "******muestraLista*******");
	if (tamano > 0) {
	
		//mostrarLista();
		eval (ON_RSZ);
		ON_RSZ = '';
		focaliza("frmFormulario.cbTipoSolicitud");
		
		return true;
	
	} else {

		ocultarLista();
		focaliza("frmFormulario.cbTipoSolicitud");	
		//set('frmFormulario.flag','');
		return false;
	}
	
}
//********************************************************************

function  chequeaErrores()
	{
		var errCod = get("frmFormulario.errCodigo");

		if ((errCod != null) && (errCod != ''))
		{
				fMostrarMensajeError();
				return true;
		}

		return false;

	}
//***********************Cargar Combos*********************************************

function cargarCombos(){
   
    var coll = document.all.tags("SELECT");
	var it = coll(0).options;
	
	coll.item(0).options(Math.abs(get('frmFormulario.cTipoSolic'))).selected=true
	coll.item(1).options(Math.abs(get('frmFormulario.cSubac'))).selected=true
	
}

//********************************************************************

function getValIndexCombo(pcombo){
  var combos = document.all.tags("SELECT");
  var indice = combos.item(Math.abs(pcombo)).selectedIndex;
  return indice;
}


function TabUp(){
    //alert("TABUP");
	var botones = window.event.srcElement;
	
	if(botones.name == "btnAgregar"){
	   //alert(botones.name);
	   if(get('frmFormulario.accion')==''){
	      focaliza("frmFormulario.cbTipoSolicitud");
	   }else{
	      var obj=document.getElementsByName("btnEliminar");
			obj.item(0).focus();
	    }
	}
	if(botones.name =="btnEliminar"){
	   focaliza("frmFormulario.cbTipoSolicitud");
	}
	
		
	
}

function TabShift(){
    var botones = window.event.srcElement;
	if(botones.name == "cbTipoSolicitud"){
	   if(get('frmFormulario.accion')==''){
	      var obj=document.getElementsByName("btnAgregar");
			obj.item(0).focus();
	   }else{
	                var obj=document.getElementsByName("btnEliminar");
					obj.item(0).focus();
	   }
	}
	if(botones.name =="btnEliminar"){
	   
	      var obj=document.getElementsByName("btnAgregar");
			obj.item(0).focus();
	   
	}

	if(botones.name == "btnAgregar"){
	   
		focaliza("frmFormulario.txtNumeroSolicitud");
		
	   
	}
	
}