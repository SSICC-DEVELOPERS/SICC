function onLoadPag() {

		configurarMenuSecundario("frmFormulario");

		DrdEnsanchaConMargenDcho('listado1',28);
		document.all["Cplistado1"].style.visibility=''; 
		document.all["CpLin1listado1"].style.visibility='';  
		document.all["CpLin2listado1"].style.visibility=''; 
		document.all["CpLin3listado1"].style.visibility='';
		document.all["CpLin4listado1"].style.visibility='';  

		document.all["primera1Div"].style.visibility=''; 
		document.all["ret1Div"].style.visibility='';
		document.all["ava1Div"].style.visibility='';  
		document.all["separaDiv"].style.visibility=''; 

		if (get("frmFormulario.casoDeUso")=='modificar') {
			document.all["btnModificarDiv"].style.visibility='';
		} else {
			document.all["btnModificarDiv"].style.visibility='hidden';
		}

		eval (ON_RSZ);

		buscar();
	}

	function buscar(){
		var idioma = get("frmFormulario.idioma");
		var pais = get("frmFormulario.pais");

		var array = armarArray(pais, idioma);

		configurarPaginado(mipgndo,"FACConsultarTiposImpuestosUbigeo", 
				      "ConectorConsultarTiposImpuestosPorUbigeo", "es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion", array);
	}

	function quitaEsp(a){
		if (a == ' '){
			return '';
		}else{
			return a;
	  }
	}

	function modificar(){
		if (listado1.numSelecc() >= 1){
			if (listado1.numSelecc() == 1){                       		
				var parametros = new Object();
				var codigo = listado1.codSeleccionados();
				parametros.oidTipoImpu =  codigo[0];
				parametros.canal = quitaEsp(listado1.extraeDato(codigo[0], 0));//Canal
				parametros.acceso = quitaEsp(listado1.extraeDato(codigo[0], 1));//Acceso
				parametros.subacceso = quitaEsp(listado1.extraeDato(codigo[0], 2));//Subacceso
				parametros.unidadGeografica = quitaEsp(listado1.extraeDato(codigo[0], 3));//Unidad Geografica
				parametros.impuesto = quitaEsp(listado1.extraeDato(codigo[0], 4));//Impuesto

				var res = mostrarModalSICC("LPMantenimientoTiposImpuestosPorUbigeo", "modificar", parametros, 640, 620);

				if (res=='guardo')
					buscar();
			}else{
				GestionarMensaje('8',null,null,null);
			}
		}else{
			GestionarMensaje('4',null,null,null);			
		}	 
	}

	function armarArray(pais, idioma){
		var arrDatos = new Array();
		var i=0;
		arrDatos[i] = new Array("oidPais", pais);   
		i++;
		arrDatos[i] = new Array('oidIdioma', idioma );  

		return arrDatos;
	}

	function fBorrar() {
		if (listado1.numSelecc()== 0) {
			GestionarMensaje('1021',null,null,null);
			return false;
		} else {             
			eliminarFilas(listado1.codSeleccionados(), "FACEliminarTiposImpuestosPorUbigeo", mipgndo, null, false);

			buscar();
		} 		
	}

	function fLimpiar() {
		  
	}

	function muestraLista( ultima, rowset){   
		var tamano = rowset.length;   
		if (tamano == 0) {   
			  return false;
		}else{
			  return true;
		}
	}   
