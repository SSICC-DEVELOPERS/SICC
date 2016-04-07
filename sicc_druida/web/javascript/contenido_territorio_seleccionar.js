var formName = "frmFormulario";
  var pais = "";
  var ult_nivel = "";
  varNoLimpiarSICC = true;
  var nivel1 = '';  

	function LoadBar(){
	
		configurarMenuSecundario(formName);
		
		var niveles = new Array();
		niveles = (get(formName + ".hidComboLabels").toString()).split("_");

    if(niveles.length > 0){
       nivel1 = niveles[0];
    }
		
		if(niveles.length > 9) {
			ult_nivel = 9;
		}else{
			ult_nivel = niveles.length;
		}
		
		for(i = 0; i < ult_nivel;i ++)
			txt_to('lblNivel' + (i+1),niveles[i]);
			
		cargarComboPrincipal();
		
	}

  function cargarComboDeNivel(nivel,codigo){
    var oid = get(formName + '.cbNivel'+(nivel-1)).toString();
    for(var i = nivel; i < 10;i++) {
       set_combo(formName + '.cbNivel'+i,'');
       //accion(formName + '.cbNivel'+i,'.disabled=true');
    }
    if(oid != "") {
        if(nivel <= ult_nivel) {
           //alert(makeParameters(oid));
           recargaCombo(formName + ".cbNivel" + nivel, "MAERecargaComboUBIGEO", "es.indra.sicc.util.DTOOID", makeParameters(oid));
			  //setTimeout("HideCombo(" + nivel + ")", 3000);
        }
    }
  }

  function HideCombo(nivel) {
	  if(document.getElementById("cbNivel" + nivel).options.length > 1) {
				  accion(formName + '.cbNivel'+(nivel-1),'.disabled=false');
				  accion(formName + '.cbNivel'+nivel,'.disabled=false');
				  //document.getElementById("cbNivel" + nivel).setAttribute("width", "30px");
				  //document.getElementById("cbNivel" + nivel).style = "width: 30px";
				  visibilidad('capaCombo'+nivel,'V');
	  }
  }

  function makeParameters(oid) {
    var parametros = new Array([],[]);
     parametros[0][0] = "oid";
     parametros[0][1] = oid;
     parametros[1][0] = "oidPais";
     parametros[1][1] = get(formName + ".hidPais").toString();
    return parametros;
  }

  function formarCadena(idBusiness , dto, parametros) {
    var cadena = idBusiness + "|" + dto + "|";
    //concateno los parámetros en parejas separadas por ampersand (como en una url).
    for(i=0;i<parametros.length;i++) {
        cadena += parametros[i][0] + "=" + parametros[i][1];
        if (i!= parametros.length-1) {
           cadena += "&";
        }
    }
    return cadena;
   }

   function recargaCombo(combo, idBusiness, dto, parametros) {
     asignar([['COMBO', combo, 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET',formarCadena(idBusiness, dto, parametros)]]);
   }

  function cargarComboPrincipal() {
     var parametros = new Array([],[]);
     parametros[0][0] = "oid";
     parametros[0][1] = "";
     parametros[1][0] = "oidPais";
     parametros[1][1] = get(formName + ".hidPais").toString();
     //alert(parametros);
     recargaCombo(formName + ".cbNivel1", "MAERecargaComboUBIGEO", "es.indra.sicc.util.DTOOID", parametros);
   }

  function getUltimoTerritorio(){
    var combosLlenos = 0;
    var descr = "";
    for(var i = 1; i < 11;i++){
       if(get(formName + '.cbNivel'+i).toString() != "")
       {
           combosLlenos++;
       }
    }
    //combosLlenos, contiene la cantidad justamente de combos con valor
    //o dicho de otra manera, el ultimo conbo con data
    return get(formName + '.cbNivel'+ combosLlenos,'T').toString()
  }

  function getCampoTerritorio(b){
    var descr = "";
    for(var i = 1; i < 11;i++){
       
       if(get(formName + '.cbNivel'+i).toString() != "")
         descr += get(formName + '.cbNivel'+ i,'T').toString() + ",";
       if(get(formName + '.cbNivel'+i).toString() == "")
         return (b)?get(formName + '.cbNivel'+(i-1)).toString():descr;
    }
  }

  function accionSeleccionar(){


    if(get(formName + '.cbNivel1').toString() == "") {
      GestionarMensaje("1201",nivel1,null,null)  
    }else{
      var arr = new Array();
      arr[0] = getCampoTerritorio(true);
      arr[1] = getCampoTerritorio(false);
      arr[2] = getUltimoTerritorio();

      //alert("el ultimo combo, contiene: " + arr[2]);

      returnValue = arr;
      close();
    }
  }

  function fVolver(){ 
     this.close(); 
  }

  function chequeaErrores() {
         var codigoError = get(formName + ".errCodigo");

         if (codigoError == "") {
               return true;
         } else {
               fMostrarMensajeError();

               if (codigoError == 280050001) {
                   set(formName + ".conectorAction", "LPSeleccionTerritorio");
                   set(formName + ".accion", "Volver");
                   enviaSICC(formName);
                }

               return false;
         }
  }

  function fLimpiar(){
    var aCombo = new Array(new Array("",""));
    set('frmFormulario.cbNivel1', '');
    set_combo('frmFormulario.cbNivel2',aCombo, []);
    set_combo('frmFormulario.cbNivel2',aCombo, []);
    set_combo('frmFormulario.cbNivel3',aCombo, []);
    set_combo('frmFormulario.cbNivel4',aCombo, []);
    set_combo('frmFormulario.cbNivel5',aCombo, []);
    set_combo('frmFormulario.cbNivel6',aCombo, []);
    set_combo('frmFormulario.cbNivel7',aCombo, []);
    set_combo('frmFormulario.cbNivel8',aCombo, []);
    set_combo('frmFormulario.cbNivel9',aCombo, []);
  }