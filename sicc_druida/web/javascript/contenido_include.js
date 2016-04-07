function getPravSKlu4(key,arr) {
   for(var x = 0; x < arr.length;x++)
      if(key == arr[x]) return false;
   return true;
}

var first_col = 0;

function isklu4itVibRegistr(tb) {
  first_col=0;var cods=tb.codSeleccionados();var arr=new Array();if(tb.datos.length>0){for(var i=0;i<tb.datos.length;i++){if(getPravSKlu4(tb.datos[i][0],cods)){
  var novReg=new Array();novReg[0]=first_col;for(var j=1;j<tb.datos[i].length;j++){novReg[j]=tb.datos[i][j];}
  arr[first_col]=novReg;first_col++;}}}tb.datos.length=0;tb.setDatos(arr);
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

function chequeaErrores() {
         var codigoError = get(formName + ".errCodigo");
         var descError = get(formName + ".errDescripcion");
         if (codigoError == "") {
               return true;
         } else   {
               fMostrarMensajeError(codigoError, descError);
               //alert("Codigo de error: " +  codigoError);
               if (codigoError == 280050001) {
                   // Envia a la pantalla de inicio
                   set(formName + ".conectorAction", LPName);
                   set(formName + ".accion", "Volver");
                   enviaSICC(formName)
                }
               // *************************************************************************
               // Muestra lo que el usuario ingreso anteriormente, si es el caso
               // *************************************************************************
               return false;
         }
  }

function checkFloatNoEmpty(field) {
   sizeInt=(sizeOfCTEXT-1)-numDecimales;if(_get(field)!=""){if(ValidaFloat(_get(field),sizeInt,numDecimales,entornoSeparador)!="OK"){
   GestionarMensaje("2519", null, null, null); _foc(field); return true;}}
}

function checkNumNoEmpty(field) {
   if(_get(field)!=""){if(ValidaNum(_get(field))!="OK"){GestionarMensaje("2519",null,null,null);_foc(field);return true;}}
}

function _get(id) { return get(formName + '.' + id ).toString(); }
function _foc(id) { focaliza(formName + '.' + id); }

function selectV(id) {
  alert("Control:" + id.substr(0,1));
  if(id.substr(0,1) == "cb") {

    set(formName + "." + id,new Array(_get("hid_" + id)));
  } else  {
   set(formName + "." + id,(_get("hid_" + id) == "True")?1:0);
  }
}
