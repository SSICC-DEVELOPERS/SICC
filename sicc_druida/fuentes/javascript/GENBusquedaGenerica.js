var esMultiple=true;
var strConector="";
var strDTO="";
var arrAppend = null;


function cargaPagina(){
	configurarMenuSecundario("frmContenido");
	var objParams = parent.params;
	if(objParams.parametros.datos){
		if(!objParams.parametros.datos.esMultiple){
			esMultiple=false;
		}
		if(objParams.parametros.datos.dto!=null){
			strDTO = objParams.parametros.datos.dto;
		}
		if(objParams.parametros.datos.conector!=null){
			strConector = objParams.parametros.datos.conector;
		}
		
		arrAppend = objParams.parametros.datos.array;
		
		if(objParams.parametros.datos.buscarInicio){
			btnBuscar_onClick();
		}
	}
}

function btnAceptar_onclick(){
	if(listado1.codSeleccionados().length==0){
		GestionarMensaje("50",null,null,null);
		return;
	}
	if(!esMultiple && listado1.codSeleccionados().length>1){
		cdos_mostrarAlert( GestionarMensaje("240",null,null,null) );
		return;
	}
	
	var arrSalida = new Array();
	var arrSel = listado1.codSeleccionados();
	var largoSel = listado1.codSeleccionados().length;
	var largoDatos = listado1.datos.length;
	var largoReg = listado1.datos[0].length;
	for(var i=0;i<largoSel;i++){
		for(var j=0;j<largoDatos;j++){
			if(arrSel[i]==listado1.datos[j][0]){
				var subArr = new Array();
				for(var n=0;n<largoReg;n++){
					subArr[n]=listado1.datos[j][n]
				}
				arrSalida[arrSalida.length] = subArr;
				break;
			}
		}
	}
	window.returnValue = arrSalida;
	window.close();
}

function btnBuscar_onClick(){
	//configuramos el paginado
	configurarPaginado(mipgndo1,"CMNBusquedaGenerica",strConector, strDTO,armaArray());
}

function armaArray(){
	var arrDatos = new Array();
	var objParams = parent.params;

	arrDatos[arrDatos.length] = new Array('oidIdioma',"0");
	arrDatos[arrDatos.length] = new Array('oidPais',"0");
	arrDatos[arrDatos.length] = new Array("esPaginado","true");
	if (get('frmContenido.txtCodigo')!=''){
				if (isNaN(get('frmContenido.txtCodigo'))) {
					arrDatos[arrDatos.length] = new Array('strCodigo',get('frmContenido.txtCodigo'));
				}else{
					arrDatos[arrDatos.length] = new Array('codigo',get('frmContenido.txtCodigo'));
				}
	}
	if (get('frmContenido.txtDescripcion')!=''){
		arrDatos[arrDatos.length] = new Array('descripcion',get('frmContenido.txtDescripcion'));
	}
	
   if(arrAppend != null){
	   for(var i = 0; i < arrAppend.length ;i++){
		   arrDatos[arrDatos.length] = arrAppend[i	];
		}
   }

	return arrDatos;
}

function mostrarListado(rowset){
	if(rowset.length==0){
		mostrarOcultar("hidden");
		return false;
	}else{
		DrdEnsanchaConMargenDcho('listado1',12);
		mostrarOcultar("visible");
		eval (ON_RSZ);  
		return true;
	}
}

function mostrarOcultar(estado){
	document.all["Cplistado1"].style.visibility=estado;
	document.all["CpLin1listado1"].style.visibility=estado;
	document.all["CpLin2listado1"].style.visibility=estado;
	document.all["CpLin3listado1"].style.visibility=estado;
	document.all["CpLin4listado1"].style.visibility=estado;
	document.all["AceptarDiv"].style.visibility=estado;
	document.all["ret1Div"].style.visibility=estado;
	document.all["ava1Div"].style.visibility=estado;
}

function fLimpiar(){
	set("frmContenido.txtCodigo","");
	set("frmContenido.txtDescripcion","");
	mostrarOcultar("hidden");
}
function fVolver(){
	window.close();
}



