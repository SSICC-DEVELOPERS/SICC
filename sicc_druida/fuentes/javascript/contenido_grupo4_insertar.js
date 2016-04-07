var formName = "frmInsertarCliente";

//-----------------------------------------------------------------------------------------------------------
function onLoadPag() {
    DrdEnsanchaConMargenDcho('listado1',12);    
    DrdEnsanchaConMargenDcho('listado2',12);
    DrdEnsanchaConMargenDcho('listado3',12);         	    
    DrdEnsanchaConMargenDcho('listado4',12);
    var onrsz = ON_RSZ + "habilitaDeshabilitaCampos();";
    setTimeout('eval (ON_RSZ+"habilitaDeshabilitaCampos()")',200);
    
    if(!fMostrarMensajeError()) {
         configurarMenuSecundario(formName);
         var casoDeUso = get(formName + ".casoDeUso");
         if(casoDeUso == "Insertar Cliente") {
             cambiosPaginaInsertar();
             CargarValoresPosiblesMarca();// cargo las marcas de la pantalla anterior
             if(get(formName + ".elementosP4")!="") {
                  // si los habia los recarga
                  recargarValoresP4();
             }
         } else if (casoDeUso == "ModificarCliente") {
             var tarjetas = get(formName + ".hidListaTarjetas");
             if (tarjetas != "") {
                  cargaLista("listado1", tarjetas);
             }

             var clasi = get(formName + ".hidListaClasificacion");
                           if (clasi != "") {
                                    stringClasificacionesToListado(clasi);
                  var reentrando = get("frmInsertarCliente.hI18N");
                  
                  if (reentrando == "") {
                      seteaNombresClasi();
                  }
             } 
             
             var prob = get(formName + ".hidListaProbSolu");
             if (prob != "") {
                  cargaLista("listado3", prob);
             }
             habilitaDeshabilitaCampos();
             
             var psico = get(formName + ".hidListaPsico");
             if (psico != "") {
                  cargaLista("listado4", psico);
             }
         }
         
         focalizarComponente();
         seteaVarsLimpiar();
         
         accion(formName + ".comboTipoClasificacion", ".disabled=true");
         accion(formName + ".comboClasificacion", ".disabled=true");
         
         //Utilizado por applet
         if( get("frmInsertarCliente.hCerrarVentana") == 'S') {
             retornoCerrarModal();
         }
    }

         if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
                           btnProxy(2,1);  // boton 'volver', habilitado
                           btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
         }

}
//-----------------------------------------------------------------------------------------------------------

function CargarValoresPosiblesMarca(){
         // saco del campo hidden marca_valores los valores de marcas posibles
         var MarcaValores = get(formName + ".hidMarcaValor");
         var listaValores = MarcaValores.split(";");
         var opciones = new Array();
         opciones[0]=['','         '];
         for(var g=0;g<listaValores.length-1;g++){
                  var linea = listaValores[g];
                  var desc_value = new Array();
                  desc_value = linea.split("|");
                  opciones[g+1]=[desc_value[1],desc_value[0]];
         }


  set_combo(formName + ".comboMarca", opciones,-1);
  var combo = document.getElementById('comboMarca');
  ordenaCombo_SICC(combo);
 
 
}
//--------------------------------------------------------------------------------------------------------
function cambiaCbxSolucion(){
         ////alert("cambiaCbxSolucion");
          var radio=window.event.srcElement;
          var ind=Math.abs(radio.name.split("_")[1]);

          // Seteo la "g" para simular que es una fila nueva en el caso de no tenerla ya seteada.
          //alert("indice: " + ind);
          var datosListado = listado3.datos;
          if ( datosListado[ind][0] != "g"){
                            var codigoOculto = datosListado[ind][0];
                            var elemToDel = get("frmInsertarCliente.elemEliminadosProblema");
                            //alert("elemToDel Antes: " + elemToDel);
                            if (elemToDel != "")
                                    elemToDel = elemToDel + "," + codigoOculto;
                            else
                                    elemToDel = codigoOculto;

                           //alert("elemToDel Ahora: " + elemToDel );
                           set("frmInsertarCliente.elemEliminadosProblema", elemToDel);

           	   datosListado[ind][0] = "g";
         }

/*
          if(radio.checked==true){
                  //lo transformo en solucion
                   activarSolucion(ind)
          }else{
          	//lo transformo en problema
                   activarProblema(ind)
          }
*/
}
//-----------------------------------------------------------------------------------------------------------
function TipoViaOnChange(){
         var elComboTipo = window.event.srcElement;
         var elComboClasi = document.getElementById("comboClasificacion");
         //alert("onchange");
         if(elComboTipo.value!=-1){
                 borrarCombo("comboClasificacion");
                  //filtro lista oculto por codigo del tipo de clasificacion
             var optionVacia = document.createElement("OPTION")
             elComboClasi.options.add(optionVacia);
             optionVacia.innerText='';
             optionVacia.value='-1';

             for(var k=0;k<Lista1.datos.longitud;k++) 
                                    {
                  if (Lista1.datos.ij(k,1) == elComboTipo.value) 
                                              {
                     var option = document.createElement("OPTION");
                   
                     elComboClasi.options.add(option);
                     
                     option.innerText=Lista1.datos.ij(k,2);
                     option.value= Lista1.datos.ij(k,0);
                  }
             }
             
         }else{
                  //seleccion vacia, borrar el combo clasificaciones
                 borrarCombo("comboClasificacion");
         }
}

//---------------------------------------------------------------------------
/*function borrarComboClasificacion()
{
         var elComboClasi = document.getElementById("comboClasificacion");
         var optis = elComboClasi.options;
         var cant = optis.length-1;
         for(var z=cant;z>=0;z--){
                  optis.remove(z);
         }
}*/

//---------------------------------------------------------------------------
function borrarCombo(nombreCombo)
{
         var elCombo = document.getElementById(nombreCombo);
         var optis = elCombo.options;
         var cant = optis.length-1;
         for(var z=cant;z>=0;z--)
                  optis.remove(z);
}

//---------------------------------------------------------------------------
function accionP3(){

         if(get(formName + ".casoDeUso")=="Insertar Cliente"){
                           recolectarValoresP4();
                           set(formName + ".conectorAction","LPInsertarCliente");
                           set(formName + ".accion", "Siguiente3");
                  
                           // aviso que voy volviendo, por lo que el foco va en el ultimo campo
                           set(formName + ".hidFocusPrimerComponente","false");
                           //copiar de uno al otro
                           duplicarFormulario();
                           set(formName + "Volver.conectorAction","LPInsertarCliente");
                           set(formName + "Volver.accion", "Siguiente3");
                           //enviar el  formName + "Volver"
                           enviaSICC(formName + "Volver");
         } else if ( get(formName + ".casoDeUso") == "ModificarCliente" )
         {
                           tomaValoresListas();
                           set(formName + ".conectorAction","LPModificarCliente");
                           set(formName + ".accion", "Siguiente3");

                           // aviso que voy volviendo, por lo que el foco va en el ultimo campo
                           set(formName + ".hidFocusPrimerComponente","false");
                           //copiar de uno al otro
                           duplicarFormulario();

                           //enviar el  formName + "Volver"
                           enviaSICC(formName + "Volver");

         }
}
//-------------------------------------------------------------------------------------------------
function fGuardar(){
         // valido que existan al menos un grupo Clasificacion
         if (listado2.datos.length < 1){
                  GestionarMensaje("MAE0010");
                  return false;
         }
         // valido que tipo de tarjeta no sea vacio si hay lineas
         for(var u=0;u<listado1.datos.length;u++){
                  var tipoTarje = document.getElementById("comboTipoTarjeta_"+u);
                  if(tipoTarje.selectedIndex==-1||tipoTarje.value==-1){
                           ////alert("tipo tarjeta no puede ser vacio");
                           GestionarMensaje("2549");
                           tipoTarje.focus();
                           return false;
                  }
         }

         // Valida que no haya mas de una linea con un tipo de tarjetas. 
         var valida = validaTipoTarjetas();
         if (valida == false){
                           //GestionarMensaje("1104", null, null, null);
                           return false;
         }

    /* BELC300014757   +   BELC300023061 */
         if(listado2.datos.length == 0 && get(formName + ".usaGeoreferenciador") != "true") {
                  GestionarMensaje("MAE0010"); // MAE-0010 (El cliente debe tener por lo menos una linea de clasificacion)
                  document.getElementById("comboMarca").focus();
                  return false;
         }

         //Validacion segun incidencia 10977.
         if (!validarTiposSubtipos()) {
         GestionarMensaje("MAE0033");
         return false;
    }  

         // valido que tipo problema o tipo solucion no sean vacio si hay lineas
         for(var u=0;u<listado3.datos.length;u++)
         {
     /*
             listado3.actualizaDat();
                  var datosPS = listado3.datos;
                  var checkbox = datosPS[u][3];
                  alert("Valor checkbox linea " + u + ": " + checkbox);
                  */

                  var tipoDato = document.getElementById("cbxSolucion_"+u);

                  var tipoProb = document.getElementById("comboTipoProblema_"+u);

                  if(tipoProb.selectedIndex==""||tipoProb.value==""){
                  ////alert("tipo proble no puede ser vacio");
                     GestionarMensaje("2551");
                           tipoProb.focus();
                           return false;
                  }

                  if(tipoDato.checked==true){
                           var tipoSolu = document.getElementById("comboTipoSolucion_"+u);
                           if(tipoSolu.selectedIndex=="-1"||tipoSolu.value==""){
                                    ////alert("tipo solu no puede ser vacio");
                                    GestionarMensaje("2550");
                                    tipoSolu.focus();
                                    return false;
                           }
                                             
                  }
         }

		 // vbongiov -- 17/10/2008
		 // Valida fecha psicografias
		 var fecha;

         listado4.actualizaDat(); // Me aseguro que los datos coincidan con lo que se muestra en pantalla. 
         var datosLista = listado4.datos;

         continuar = true;
         var i = 0;
         var formatoFecha = get("frmInsertarCliente.hFormatoFechaPais");

		 while( i < datosLista.length && continuar == true){
			  fecha = datosLista[i][4];
			  listado4.preparaCamposDR();

			  if(EsFechaValida( fecha, fecha, "frmInsertarCliente", "N")==1){
				  GestionarMensaje("1006", formatoFecha, null, null);
				  continuar = false;
				  focaliza("frmlistado4.TextoFecha_"+ i, "");
				  return false;
			  }
					  
			  i++;
		 }

   
         var casoUso = get("frmInsertarCliente.casoDeUso");

         if( casoUso =="Insertar Cliente"){
                  recolectarValoresP4();
                  set(formName + ".conectorAction","LPInsertarCliente");
         } 

         if(casoUso == "ModificarCliente"){
                  tomaValoresListas();
                  set("frmInsertarCliente.conectorAction", "LPModificarCliente");
         }

         set(formName + ".accion", "Guardar");

         enviaSICC('frmInsertarCliente', '', '', 'N');
         //window.close();

}

function retorna(recomendado, recomendante, problemasEstatus) {

         if(problemasEstatus=="0000042"){
                  GestionarMensaje('2616');
         }
         
         /* inicio Modificado incidencia DBLG700000052 */
         var arrayParaDevolver = new Array();
                  
         arrayParaDevolver[0] = recomendado;
         arrayParaDevolver[1] = recomendante;

         window.returnValue = arrayParaDevolver;
         /* fin Modificado incidencia DBLG700000052 */
         window.close();
}

function retornoCerrarModal(){
         var codCli = get("frmInsertarCliente.hidCodigoCliente");
         window.returnValue = codCli;
         window.close();
}

function validarTiposSubtipos(){
    /* Validacion segun incidencia 10977. Si el usuario elimina tipo/subtipo de la pestaña 2
        no debe poder guardar una clasificacion que use ese tipo/subtipo */
    
    //Aca cargo en un array todos los valores del combo de tipoCLiente
    var cantTipoClienteCombo = combo_get('frmInsertarCliente.cbTipoCliente', 'L');
    var oidTipos = new Array();
    
    for (var i = 1; i < cantTipoClienteCombo; i++) {
         oidTipos[oidTipos.length] = combo_get('frmInsertarCliente.cbTipoCliente', 'V', i); 
    }
    
    //Aca cargo en un array los valores de la lista oculta ListaSubtipo
    var cantFilasListaSubtipo = ListaSubtipo.datos.longitud;
    var oidSubTipos = new Array();
    for (var j = 0; j < cantFilasListaSubtipo; j++) {
         oidSubTipos[oidSubTipos.length] = ListaSubtipo.datos.ij(j,1);  
    }
         
         // Ahora recorro la lista de clasificaciones y verifico los tipo/subtipo cliente
         var cantClasificaciones = listado2.datos.length;
         var tipoNoDisponible = true;
         var subtipoNoDisponible = true;

         for (var k = 0; k < cantClasificaciones; k++) {
        tipoClienteLista = listado2.datos[k][11];
            subtipoClienteLista = listado2.datos[k][12];
        
            for (var m = 0; m < cantTipoClienteCombo ; m++) {
                     if (tipoClienteLista == oidTipos[m] || tipoClienteLista == '') {
                 tipoNoDisponible = false;
            }
            }
            if (tipoNoDisponible) {
                     return false;
            }

            for (var n = 0; n < cantFilasListaSubtipo; n++) {
                     if (subtipoClienteLista == oidSubTipos[n] || subtipoClienteLista == '') {
                 subtipoNoDisponible = false;
            }
            }
            if (subtipoNoDisponible) {
                     return false;
            }
    }
         return true;

}


//-------------------------------------------------------------------------------------------------
function duplicarFormulario(){
            
            var formVolver = formName + "Volver";
         
                  /*var form1 = eval(formVolver);
                  var form2 = eval(formName);

        frmInsertarClienteVolver.innerHTML = frmInsertarCliente.innerHTML;*/

            set(formVolver + ".accion", get(formName + ".accion"));
            set(formVolver + ".conectorAction", get(formName + ".conectorAction"));
            set(formVolver + ".casoDeUso", get(formName + ".casoDeUso"));
            set(formVolver + ".errCodigo", get(formName + ".errCodigo"));
            set(formVolver + ".errDescripcion", get(formName + ".errDescripcion"));
            set(formVolver + ".hFormatoFechaPais", get(formName + ".hFormatoFechaPais"));
            set(formVolver + ".hidPais", get(formName + ".hidPais"));
            set(formVolver + ".hidFocusPrimerComponente", get(formName + ".hidFocusPrimerComponente"));

                  // by ssantana
            set(formVolver + ".hReentrandoP1", get(formName + ".hReentrandoP1"));
                  set(formVolver + ".hReentrandoP2", get(formName + ".hReentrandoP2"));
                  set(formVolver + ".hReentrandoP3", get(formName + ".hReentrandoP3"));
                  set(formVolver + ".hReentrandoP4", get(formName + ".hReentrandoP4"));
                  // end


          //Pestanya 0
            set(formVolver + ".elementos", get(formName + ".elementos"));
            set(formVolver + ".cbTipo", get(formName + ".cbTipo"));
            set(formVolver + ".cbSTipo", get(formName + ".cbSTipo"));
          //Pestanya 1
            set(formVolver + ".hidCodigoAutomatico", get(formName + ".hidCodigoAutomatico"));
            set(formVolver + ".hidDigitoControl", get(formName + ".hidDigitoControl"));
            set(formVolver + ".hidtextCodCliente", get(formName + ".hidtextCodCliente"));
            set(formVolver + ".hidListaIdentificacion", get(formName + ".hidListaIdentificacion"));
          //Pestanya 2
            set(formVolver + ".elementosP2", get(formName + ".elementosP2"));
            set(formVolver + ".hidFechaIngreso", get(formName + ".hidFechaIngreso"));
            set(formVolver + ".hidtextApellido1", get(formName + ".hidtextApellido1"));
            set(formVolver + ".hidtextApellido2", get(formName + ".hidtextApellido2"));
            set(formVolver + ".hidtextApellidoCasada", get(formName + ".hidtextApellidoCasada"));
            set(formVolver + ".hidtextNombre1", get(formName + ".hidtextNombre1"));
            set(formVolver + ".hidtextNombre2", get(formName + ".hidtextNombre2"));
            set(formVolver + ".hidcbTratamiento", get(formName + ".hidcbTratamiento"));
     set(formVolver + ".hidcbTratamientoDesc", get(formName + ".hidcbTratamientoDesc"));
            set(formVolver + ".hidrbSexo", get(formName + ".hidrbSexo"));
            set(formVolver + ".hidcbFormaPago", get(formName + ".hidcbFormaPago"));
            set(formVolver + ".hidtextFechaNacimiento", get(formName + ".hidtextFechaNacimiento"));
            set(formVolver + ".hidEdad", get(formName + ".hidEdad"));
            set(formVolver + ".hidtextCodEmpleado", get(formName + ".hidtextCodEmpleado"));
            set(formVolver + ".hidcbNacionalidad", get(formName + ".hidcbNacionalidad"));
            set(formVolver + ".hidcbEstadoCivil", get(formName + ".hidcbEstadoCivil"));
            set(formVolver + ".hidtextOcupacion", get(formName + ".hidtextOcupacion"));
            set(formVolver + ".hidtextProfesion", get(formName + ".hidtextProfesion"));
            set(formVolver + ".hidtextCentroTrabajo", get(formName + ".hidtextCentroTrabajo"));
            set(formVolver + ".hidtextCargoDesempena", get(formName + ".hidtextCargoDesempena"));
            set(formVolver + ".hidcbNivelEstudios", get(formName + ".hidcbNivelEstudios"));
            set(formVolver + ".hidtextCentroEstudios", get(formName + ".hidtextCentroEstudios"));
            set(formVolver + ".hidtextNHijos", get(formName + ".hidtextNHijos"));
            set(formVolver + ".hidtextNPersonasDependientes", get(formName + ".hidtextNPersonasDependientes"));
            set(formVolver + ".hidcbNivelSocioEconomico", get(formName + ".hidcbNivelSocioEconomico"));
            set(formVolver + ".hidcbCicloVidaFamiliar", get(formName + ".hidcbCicloVidaFamiliar"));
            set(formVolver + ".hidrbDeseaCorrespondencia", get(formName + ".hidrbDeseaCorrespondencia"));
            set(formVolver + ".hidtextImporteIngresoFamiliar", get(formName + ".hidtextImporteIngresoFamiliar"));
            set(formVolver + ".hidcbPaisContactado", get(formName + ".hidcbPaisContactado"));
            set(formVolver + ".hidtextCodClienteContactado", get(formName + ".hidtextCodClienteContactado"));
            set(formVolver + ".hidcbTipoClienteContactado", get(formName + ".hidcbTipoClienteContactado"));
            set(formVolver + ".hidcbCodTipoContactado", get(formName + ".hidcbCodTipoContactado"));
            set(formVolver + ".hidtextFechaContacto", get(formName + ".hidtextFechaContacto"));
            set(formVolver + ".hidtextFecha1PedidoContacto", get(formName + ".hidtextFecha1PedidoContacto"));
            set(formVolver + ".hidtextFechaSiguienteContacto", get(formName + ".hidtextFechaSiguienteContacto"));
            set(formVolver + ".hidtxtFechaIngresoActual", get(formName + ".hidtxtFechaIngresoActual"));
     set(formVolver + ".hidMarcaContacto", get(formName + ".hidMarcaContacto"));
     set(formVolver + ".hidCanalContacto", get(formName + ".hidCanalContacto"));
     set(formVolver + ".hidPeriodoContacto", get(formName + ".hidPeriodoContacto"));
          //String a parsear que contiene la lista vinculos
            set(formVolver + ".hidListaVinculo", get(formName + ".hidListaVinculo"));
            set(formVolver + ".hidListaObservacion", get(formName + ".hidListaObservacion"));
            set(formVolver + ".hidListaPrefe", get(formName + ".hidListaPrefe"));
     set(formVolver + ".codigoCliente", get(formName + ".codigoCliente"));
          //Pestanya 3
            set(formVolver + ".elementosP3", get(formName + ".elementosP3"));
            set(formVolver + ".hidListaDirecciones", get(formName + ".hidListaDirecciones"));
            set(formVolver + ".hidListaComunicacion", get(formName + ".hidListaComunicacion"));
            set(formVolver + ".hidListaMarca", get(formName + ".hidListaMarca"));
            set(formVolver + ".hidMarcaValor", get(formName + ".hidMarcaValor"));
            set(formVolver + ".hidOidClienteCont", get(formName + ".hidOidClienteCont"));
            set(formVolver + ".usaGeoreferenciador", get(formName + ".usaGeoreferenciador"));
            set(formVolver + ".listaVinculosOid", get(formName + ".listaVinculosOid"));

          //Pestanya 4
            set(formVolver + ".elementosP4", get(formName + ".elementosP4"));
            set(formVolver + ".hidListaTarjetas", get(formName + ".hidListaTarjetas"));
            set(formVolver + ".hidListaClasificacion", get(formName + ".hidListaClasificacion"));
            set(formVolver + ".hidListaProbSolu", get(formName + ".hidListaProbSolu"));
            set(formVolver + ".hidListaPsico", get(formName + ".hidListaPsico"));

            set(formVolver + ".elemEliminadosTarjetas", get(formName + ".elemEliminadosTarjetas"));
            set(formVolver + ".elemEliminadosClasificacion", get(formName + ".elemEliminadosClasificacion"));
            set(formVolver + ".elemEliminadosProblema", get(formName + ".elemEliminadosProblema"));
            set(formVolver + ".elemEliminadosPsico", get(formName + ".elemEliminadosPsico"));

/*                if ( (get(formName + ".casoDeUso"))=="ModificarCliente")
                  {

                                    //alert("Duplicar Tarjetas: " + get("frmInsertarClienteVolver.hidListaTarjetas") );
                                    set("frmInsertarClienteVolver.hidListaTarjetas", get("frmInsertarCliente.hidListaTarjetas") );
                                    //alert("Duplicar Tarjetas Luego: " + get("frmInsertarClienteVolver.hidListaTarjetas") );
                                    ////alert("Duplicar Clasif: " + get("frmInsertarClienteVolver.hidListaClasificacion") );
                                    ////alert("Duplicar Prob: " + get("frmInsertarClienteVolver.hidListaProbSolu") ); 
                  }*/
}
//-------------------------------------------------------------------------------------------------

function recolectarValoresP4() {
         var datosLista1= new String();
         var datosLista2= new String();
         var datosLista3= new String();
         listado1.actualizaDat();
         for(var x=0;x<listado1.datos.length;x++){
                  datosLista1 = datosLista1 + 'h_comboTipoTarjeta_' + x +  '=' + listado1.datos[x][1] + ';';
                  datosLista1 = datosLista1 + 'h_comboClasesTarjeta_' + x +  '=' + listado1.datos[x][2] + ';';
                  datosLista1 = datosLista1 + 'h_comboEntidadBancaria_' + x +  '=' + listado1.datos[x][3] + ';';
         }
    
         // Tomo los datos de listado2 y los convierto a String mediante los separadores '|', ';' y '='
         datosLista2 = listadoClasificacionesToString();

         listado3.actualizaDat();

    for(var x=0;x<listado3.datos.length;x++){
                  datosLista3 = datosLista3 + 'h_comboTipoProblema_' + x +  '=' +  listado3.datos[x][1]  + ';';
                  datosLista3 = datosLista3 + 'h_AreaTxtDescripcionProblema_' + x +  '=' + listado3.datos[x][2] + ';';
                  datosLista3 = datosLista3 + 'h_cbxSolucion_' + x +  '=' + listado3.datos[x][3] + ';';
                  datosLista3 = datosLista3 + 'h_comboTipoSolucion_' + x +  '=' + listado3.datos[x][4] + ';';
                  datosLista3 = datosLista3 + 'h_AreaTxtDescripcionSolucion_' + x +  '=' + listado3.datos[x][5] + ';';
                  datosLista3 = datosLista3 + 'h_AreaTxtNegocioProducto_' + x +  '=' + listado3.datos[x][6] + ';';
         }

                                         
         set(formName + ".elementosP4",datosLista1 + datosLista2 + datosLista3);
         set(formName + ".hidListaTarjetas",datosLista1);
         set(formName + ".hidListaClasificacion",datosLista2);
         set(formName + ".hidListaProbSolu",datosLista3);

}
//--------------------------------------------------------------------------------------------------
function recargarValoresP4(){

         var datosLista1= new String();
         var datosLista2= new String();
         var datosLista3= new String();
         datosLista1 = get(formName + ".hidListaTarjetas");
         datosLista2 = get(formName + ".hidListaClasificacion");
         datosLista3 = get(formName + ".hidListaProbSolu");

    var arrayTarjeta = new Array();     
         if(datosLista1!=""){
                  var elems = datosLista1.split(";");
                  for(var x=0;x<elems.length - 1;x++){

                           var items = elems[x].split("=");
                           var comp = items[0];
                           var valor =  items[1];
                           var tempArray = comp.split("_");
                           var nombre = tempArray[1];
                           ////alert(tempArray );
                           var indic= Math.abs(tempArray[2]);

                           if(arrayTarjeta[indic]==null){
                                    arrayTarjeta[indic] = new Array();
                                    arrayTarjeta[indic][0] = "cod";
                           //	//alert("arrayTarjeta " + indic + " era null");
                           }
                           if(nombre == "comboTipoTarjeta"){
                                    arrayTarjeta[indic][1] = valor;
                           }else if(nombre == "comboClasesTarjeta"){
                                    arrayTarjeta[indic][2] = valor;
                           }else if(nombre == "comboEntidadBancaria"){
                                    arrayTarjeta[indic][3] = valor;
                           }
                  }
                  
                  for(var j=0;j<arrayTarjeta.length;j++){
                              listado1.insertar(arrayTarjeta[j],true);
                  }
                  listado1.repintaDat();
                  listado1.repinta();
         }
    
    // Metodo que carga la lista de clasificaciones (listado2) a partir del String
         // que hay en el VAR hidListaClasificacion
         stringClasificacionesToListado(datosLista2);

         var arrayProb = new Array();	
         if(datosLista3!=""){
                  var elems = datosLista3.split(";");
                  for(var x=0;x<elems.length - 1;x++){

                           var items = elems[x].split("=");
                           var comp = items[0];
                           var valor =  items[1];
                           var tempArray = comp.split("_");
                           var nombre = tempArray[1];
                           ////alert(tempArray );
                           var indic= Math.abs(tempArray[2]);

                           if(arrayProb[indic]==null){
                                    arrayProb[indic] = new Array();
                                    arrayProb[indic][0] = "cod";
                           //	//alert("arrayProb " + indic + " era null");
                           }
                           if(nombre == "comboTipoProblema"){
                                    arrayProb[indic][1] = valor;
                           }else if(nombre == "AreaTxtDescripcionProblema"){
                                    arrayProb[indic][2] = valor;
                           }else if(nombre == "cbxSolucion"){
                                    arrayProb[indic][3] = valor;
                           }else if(nombre == "comboTipoSolucion"){
                                    arrayProb[indic][4] = valor;
                           }else if(nombre == "AreaTxtDescripcionSolucion"){
                                    arrayProb[indic][5] = valor;
                           }else if(nombre == "AreaTxtNegocioProducto"){
                                    arrayProb[indic][6] = valor;
                           }
                  }
                  for(var j=0;j<arrayProb.length;j++){
                              listado3.insertar(arrayProb[j],true);
                  }
                  listado3.repintaDat();
                  listado3.repinta();

                  /*for(var j=0;j<arrayProb.length;j++){
                           if(arrayProb[j][3]!="S"){
                                    // es problema
                                    //activarProblema(j);
                           }else{
                                    // es solucion
                                    //activarSolucion(j);
                           }
                  }*/
         }
}
//-------------------------------------------------------------------------------------------------
function eliminarLinea(numeroLista){
         var listadoAModificar = getLista(numeroLista);
         if(!listadoAModificar.numSelecc() == 0){

                  if ( get(formName + ".casoDeUso")=="ModificarCliente"  )
                  {
                                    // Guarda los valores eliminados que pertenecen a la BD. Los que tiene "g" en columna oculta, los elimina.
                           guardaEliminados(numeroLista, "a");

                  }
                  listadoAModificar.eliminarSelecc(); 
         }else{
                  GestionarMensaje('50');
         }
}
//---------------------------------------------------------------------------------------------------
function aniadirLinea(numeroLista){
         var listaEditable = getLista(numeroLista);
         var linea = new Array();
      linea[0] = "g";
         if(numeroLista==1)	{	
                  listaEditable.insertar(linea);
                  document.getElementById("comboTipoTarjeta_"+ Math.abs(listaEditable.datos.length -1)).focus();
         }else if(numeroLista==2){
                  aniadirClasificacion();
         }else if(numeroLista==3)  //  Problema
         {
				  // dmorello, 28/10/2008
				  linea[1] = "";
				  linea[2] = "";
				  linea[3] = "";
				  linea[4] = "";
				  linea[5] = "";
				  linea[6] = "";
				  // Fin dmorello 28/10/2008
                  listaEditable.insertar(linea);
                  document.getElementById("comboTipoProblema_"+ Math.abs(listaEditable.datos.length -1)).focus();
                  habilitaDeshabilitaCampos();
                  
         }else if(numeroLista==4)	{
			// vbongiov -- 17/10/2088
				  linea[1] = "";
				  linea[2] = "";
				  linea[3] = "";
				  linea[4] = "";
                  listaEditable.insertar(linea);
         }
}
//-------------------------------------------------------------------------------------------------------------------
function activarSolucion(index)
{
                  //alert("Entro index " + index);
                  listado3.actualizaDat();
                  var checkValor = listado3.datos[index][3];
                  //alert("checkValor: " + checkValor);
                  var cboTipoSolu = document.getElementById("comboTipoSolucion_"+ index);
                  var areaSolu = document.getElementById("AreaTxtDescripcionSolucion_"+ index);
                  if ( checkValor == "S")
                  {
                           cboTipoSolu.disabled = false;
                           areaSolu.disabled=false; 
                  } else
                  {
                     // Blanquea combo tipo Solucion

                           cboTipoSolu.setAttribute("value", "");
                           areaSolu.setAttribute("value", "");
                           cboTipoSolu.disabled = true;
                           areaSolu.disabled=true;
                  }
                  
}

//-------------------------------------------------------------------------------------------------------------------
function aniadirClasificacion() {
    /* Inc.23061
      - El grupo clasificación debe incluir una linea con Marca y Canal obligatoriamente
      - Si además se selecciona TipoCliente entonces Tipo/SubtipoClien y TipoClasi/Clasi son obligatorios todos */
    if (!sicc_validaciones_generales("grupo1")) { // VALIDACIONES "GRUPO 1" !!
         return false;
         } else {
                  var linea = new Array();

             // Marca (obligatorio)
                  var cboMarca = document.getElementById("comboMarca");
                  var strMarca   = cboMarca.options[cboMarca.selectedIndex].text;
         var oidMarca   = cboMarca.options[cboMarca.selectedIndex].value;

                  // Canal (obligatorio)
         var cboCanal = document.getElementById("comboCanal");
                  var strCanal   = cboCanal.options[cboCanal.selectedIndex].text;
         var oidCanal   = cboCanal.options[cboCanal.selectedIndex].value;

             // TipoCliente (es opcional, pero si se elige son obligatorios: TipoCliente, SubtipoClien, TipoClasi y Clasi)
         var cboTipoCliente = document.getElementById("cbTipoCliente");
                  var strTipoCliente = '';
                  var oidTipoCliente = '';

             // SubtipoCliente
                  var cboSubtipoCliente = document.getElementById("cbSubtipoCliente");
                  var strSubtipoCliente = '';
                  var oidSubtipoCliente = '';
                  
             // TipoClasificacion
         var cboTipoClasi      = document.getElementById("comboTipoClasificacion");
                  var strTipoClasificacion = '';
                  var oidTipoClasificacion = '';
         
                  // Clasificacion
         var cboClasi           = document.getElementById("comboClasificacion");
                  var strClasificacion = '';
                  var oidClasificacion = '';

         
         var tipoClienteSeleccionado = cboTipoCliente.selectedIndex;
         

                  //if ( tipoClienteSeleccionado == -1 || tipoClienteSeleccionado == 0 ) {
                  if ( (tipoClienteSeleccionado == -1 || tipoClienteSeleccionado == 0) && (get(formName + ".usaGeoreferenciador") != "true") ) {
                      /* Al no elegir una opcion del combo TipoCliente entonces los otros 3 campos no son obligatorios
                              y sus valores van 'en blanco' como se inicializaron */
         } else {
                      if (!sicc_validaciones_generales("grupo2")) { // VALIDACIONES "GRUPO 2" !!
                                return false;
                           }
                           
                           // TipoCliente, SubtipoCliente, TipoClasificacion y Clasificacion
             strTipoCliente            = cboTipoCliente.options[cboTipoCliente.selectedIndex].text;
             strSubtipoCliente         = cboSubtipoCliente.options[cboSubtipoCliente.selectedIndex].text;
                           oidTipoCliente            = cboTipoCliente.options[cboTipoCliente.selectedIndex].value;
                           oidSubtipoCliente         = cboSubtipoCliente.options[cboSubtipoCliente.selectedIndex].value;
                           strTipoClasificacion     = cboTipoClasi.options[cboTipoClasi.selectedIndex].text;
                           strClasificacion          = cboClasi.options[cboClasi.selectedIndex].text;
                           oidTipoClasificacion     = cboTipoClasi.options[cboTipoClasi.selectedIndex].value;
                           oidClasificacion          = cboClasi.options[cboClasi.selectedIndex].value;
                  }
         
                  linea[0] = "g";
         linea[1] = strMarca;
         linea[2] = strCanal;
         linea[3] = strTipoCliente;
         linea[4] = strSubtipoCliente;
         linea[5] = strTipoClasificacion;
                  linea[6] = strClasificacion;
         linea[7] = oidMarca;
                  linea[8] = oidCanal;
                  linea[9] = oidTipoClasificacion;
                  linea[10] = oidClasificacion;
                  linea[11] = oidTipoCliente;
         linea[12] = oidSubtipoCliente;
         
                  //alert("linea[] " + linea);
         
         var listaEditable = getLista(2);
         
                  if (validarLineaClasificacion()) {
                      listaEditable.insertar(linea);
             cboMarca.value= -1;
             cboCanal.value= -1;
             cboTipoCliente.value = -1;
             cboTipoClasi.value = -1;
             borrarCombo("comboClasificacion");
             borrarCombo("cbSubtipoCliente");

                           accion(formName + ".comboTipoClasificacion", ".disabled=true");
             accion(formName + ".comboClasificacion", ".disabled=true");
                  }
         

         focaliza(formName + ".comboMarca");

         }

}
//-------------------------------------------------------------------------------------------------------------------
function validarLineaClasificacion(){
 
         var cboTipoClasi = document.getElementById("comboTipoClasificacion"); 
         //verificar si no esta repetido ya  el tipo clasi
         for(var g=0;g<listado2.datos.length;g++){
                  if(cboTipoClasi.value==listado2.datos[g][9]){
                           ////alert("tipo de clasi repetido");
                           GestionarMensaje("1051");
                           //cboTipoClasi.focus();
                           return false;
                  }
                  
         }

         
         return true;
}
//--------------------------------------------------------------------------------------------------------------------
function getLista(numero){
          var listadoAModificar;
          switch(numero){
                    case 1: {
                              return listado1;
                    }
                    break;
                    case 2: {
                              return listado2;              
                    }
                    break;
                    case 3: {
                              return listado3;
                    }
                    break;
                           case 4: {
                              return listado4;
                    }
                    break;
          }
        //  return listadoAModificar;
}
//-----------------------------------------------------------------------------------------------------------
function cambiosPaginaInsertar(){
         // Oculto la lista psicografias
         // TODO: mover psicografias
         document.all["Cplistado4"].style.visibility="hidden";
         document.all["CpLin1listado4"].style.visibility="hidden";
         document.all["CpLin2listado4"].style.visibility="hidden";
         document.all["CpLin3listado4"].style.visibility="hidden";
         document.all["CpLin4listado4"].style.visibility="hidden";
         document.all["masDatos4"].style.visibility="hidden";
         document.all["Eliminar4"].style.visibility="hidden";

         document.all["capaEspacio3"].style.top="936";
//      document.all["Cplistado4"].style.top="0";
//      document.all["CpLin1listado4"].style.top="0";
//      document.all["CpLin2listado4"].style.top="0";
//      document.all["CpLin3listado4"].style.top="0";
//      document.all["CpLin4listado4"].style.top="0";

         //document.all["btnAnterior"].style.visibility="hidden";
         
         //document.all["frmlistado4"].style.visibility="hidden";
}
//-----------------------------------------------------------------------------------------------------------

function shift_tab(nombreComp){
         //preparo las cosas para volver
         ////alert("shifttab");
         //set(formName + ".hidFocusPrimerComponente","false");
         accionP3();

}
//-----------------------------------------------------------------------------------------------------------
function focalizarComponente(){
         if(listado1.datos.length==0){
                  //focaliza comboMarca
                  document.getElementById("comboMarca").focus();
         }else{
                  document.getElementById("comboTipoTarjeta_0").focus();
         }
}
//-----------------------------------------------------------------------------------------------------------

function cargaLista(nombreLista, param){

                  // Carga la lista correspondiente. Tener en cuenta: 1 - param no debe llegar vacio
                  // 2 - Para el checkbox de la lista de soluciones, ya debe venir el valor corresp. de afuera.

                  var datosLista = new Array();

                  var lineas = param.split("|");  

                  for (var i = 0; i < lineas.length; i++){
                                    var linea = lineas[i].split(";");
                                    datosLista[i] = linea;
                  }

                  ////alert("datosLista: " + datosLista);

                  eval(nombreLista + ".setDatos(datosLista);");
                  eval(nombreLista + ".repintaDat();");

}

//-----------------------------------------------------------------------------------------------------------
function tomaValoresListas() {
         ////alert("Tomar Valores Listas");
         tomarValor("listado1", 4);
         listadoClasificacionesToString();
         tomarValorListado3();
         tomarValor("listado4", 5);
}


//-----------------------------------------------------------------------------------------------------------
function tomarValor(nombreLista, cantCols)
{
                  ////alert("Tomar Valor");
                  eval(nombreLista + ".actualizaDat();");
                  var datosLista = eval(nombreLista + ".datos;");
                  var variableForm = "";
                  if (nombreLista == "listado1"){
                           variableForm = "hidListaTarjetas";
                  }else if (nombreLista == "listado3"){
                           variableForm = "hidListaProbSolu";
                  }else if (nombreLista == "listado4"){
                           variableForm = "hidListaPsico";
                  }


                  ////alert("Datos de lista " + nombreLista + ": " + datosLista);
                  var variableToSet = "";

                  if ( datosLista != "")
                  {
                                    for (var i = 0; i < datosLista.length; i++)
                                    {	
                                                      if (i != 0)
                                                                variableToSet = variableToSet + "|";

                                                      var linea = datosLista[i];
                                                      for (var n = 0; n < cantCols; n++)
                                                      {
                                                                         if (n != 0)
                                                                                  variableToSet = variableToSet + ";";

                                                                         variableToSet = variableToSet + linea[n];
                                                      }
                                    }

                   }

                  eval(   "set('frmInsertarCliente." + variableForm + "', '" + variableToSet + "');"     );

}

// ----------------------------------------------------------------------------------------------------------
function tomarValorListado3()
{
                  listado3.actualizaDat();  
                  var datosLista3 = listado3.datos;
                  //alert("Datos Lista 3 al guardar: "+ datosLista3);
                  var variableToSet = "";

                  if ( datosLista3 != "")
                  {
                                    for (var i = 0; i < datosLista3.length; i++)
                                    {
                                                      if ( i != 0)
                                                                variableToSet = variableToSet + "|";

                                                      for (var j = 0; j < datosLista3[i].length; j++)
                                                      {
                                                                if (j != 0)
                                                                         variableToSet = variableToSet + ";"; 

                                                                if (datosLista3[i][j] == "")
                                                                         variableToSet = variableToSet + " ";
                                                                else
                                                                         variableToSet = variableToSet + datosLista3[i][j];

                                                      }
                                      }
                  }
                  //alert("variableToSet: " + variableToSet);
         

                  set("frmInsertarCliente.hidListaProbSolu", variableToSet);
}

//-----------------------------------------------------------------------------------------------------------

function guardaEliminados(numeroLista, nombreVariable)
{
                  // Obtiene los codigos Seleccionados. Los que esten seleccionados y sean solo "g", 
                  // solamente va a venir un codigo por todos. Solo toma lo que sean numéricos (son los de la BD).

                  var nombreLista = "";
                  var nombreVariable = "";

                  if ( numeroLista == 1)
                  {
                                    nombreLista = "listado1";
                                    nombreVariable = "elemEliminadosTarjetas";
                  }else if ( numeroLista == 2)
                  {
                                    nombreLista = "listado2";
                                    nombreVariable = "elemEliminadosClasificacion";
                  }else if ( numeroLista == 3)
                  {
                                    nombreLista = "listado3";
                                    nombreVariable = "elemEliminadosProblema";
                  }else if ( numeroLista == 4)
                  {
                                    nombreLista = "listado4";
                                    nombreVariable = "elemEliminadosPsico";
                  }

                  ////alert("nombre de Lista de elem a Eliminar: " + nombreLista);
                  ////alert("nombre de variable: " + nombreVariable);

                  // Primero toma el valor existente en la variable de formulario, 
                  // para guardar los cambios antiguos. 

                  
                  ////alert ("get('frmInsertarCliente." + nombreVariable + "');");
                  var variableExistente = eval( "get('frmInsertarCliente." + nombreVariable + "');");
                  //var variableExistente = get("frmInsertarCliente
                  ////alert("Valores en " + nombreVariable + ": " + variableExistente);

                  var codigos = eval(nombreLista + ".codSeleccionados();");
                  ////alert("Codigos seleccionados de " + nombreLista + " a eliminar: " + codigos);

                  for (var i = 0; i < codigos.length; i++)
                  {
                                    if ( codigos[i] != "g" )
                                    {
                                                      if (variableExistente != "")
                                                                variableExistente = variableExistente + ",";
                                                      
                                                      variableExistente = variableExistente + codigos[i];
                                    }
                  }

                  eval(" set('frmInsertarCliente." + nombreVariable + "', '" + variableExistente + "');");

}

//-----------------------------------------------------------------------------------------------------------

function seteaNombresClasi()
{
                  // *************************************************************************************
                  // Modificar Clientes: Setea los nombres de los campos a partir de los oids.
                  // *************************************************************************************

                  var newDatos = listado2.datos;

                  if (newDatos != ""){
                                    for (var i = 0; i < newDatos.length; i++){
                                                      // Recorro Fila por fila

                                                      // Marcas
                                                      var codigoMarca = newDatos[i][1];
                                                      var descMarca = cargaDesc("comboMarca", codigoMarca);
                                                      newDatos[i][1] = descMarca;

                                                      // Canal
                                                      var codigoCanal = newDatos[i][2];
                                                      var descCanal = cargaDesc("comboCanal", codigoCanal);
                                                      newDatos[i][2] = descCanal;

                                                      // Tipo Clasificacion
                                                      var codigoTipoClasificacion = newDatos[i][3];
                                                      var descTipoClasificacion = cargaDesc("comboTipoClasificacion", codigoTipoClasificacion);
                                                      newDatos[i][3] = descTipoClasificacion;

                                                      // Clasificacion
/*                                                    var codigoClasificacion = newDatos[i][4];
                                                      var descClasificacion = cargaDesc("comboClasificacion", codigoClasificacion);
                                                      newDatos[i][4] = descClasificacion;*/

                                    }
                                    listado2.setDatos(newDatos);
                  }

}


//--------------------------------------------------------------------------------------------------------------------
function cargaDesc(combo, codigo)
{
           //eval("frmInsertarCliente." + combo + ".datos") 

           var longCombo = combo_get("frmInsertarCliente." + combo, "L", "" );

           var match = true;
           var desc = "";
           for ( var  i = 0; (i < longCombo) && (match==true); i++)
           {
                           var codigoCombo = combo_get("frmInsertarCliente." + combo, "V", i );
                           ////alert("codigoCombo: " + codigoCombo);
                           ////alert("codigo: " + codigo);
                           if (parseInt(codigoCombo,10) == parseInt(codigo,10))
                           {
                                    match = true;
                                    desc = combo_get("frmInsertarCliente." + combo, "T", i );
                                    ////alert("desc: " + desc);
                           }
           }

           // TODO: Paliativo para evitar vacio en Clasificacion al entrar y estar el COMBO vacio.
           // Setear una variable de Clasificacion y tomar la descripcion de esta.
/*         if (desc == "")
                    desc = "Clasificacion (HardCoded) ";*/



           return desc;

}

//--------------------------------------------------------------------------------------------------------------------
function fVolver()
{
                  // Si es el caso de Uso Modificar Clientes (modal) cierra la ventana actual.
                  //if (get("frmInsertarCliente.casoDeUso") == "ModificarCliente")	
                  //{
                           window.close();
                           return;
                  //}
}

//--------------------------------------------------------------------------------------------------------------------
function validaTipoTarjetas(){

   listado1.actualizaDat();

          for(var m=0;m<listado1.datos.length;m++){
     for(var n=m+1;n<listado1.datos.length;n++){
      
         if(listado1.datos[m][1] == listado1.datos[n][1]){
            //alert('entro al if');
            GestionarMensaje('1344');
            return false;
         }     
     }
   }
   return true;

}

//--------------------------------------------------------------------------------------------------------------------
function fLimpiar(){
 casoDeUso = get('frmInsertarCliente.casoDeUso');
   if(casoDeUso == 'ModificarCliente'){
      //alert('entro en limpiar modificar');

      set('frmInsertarCliente.hidPestanya', '0'); 
      set('frmInsertarCliente.hPestanya', '-1');
      set('frmInsertarCliente.dtoOid', get('frmInsertarCliente.hiddenOid'));
     // alert('el oid ' + get('frmInsertarCliente.hiddenOid'))
      set('frmInsertarCliente.hidCodigoCliente', get('frmInsertarCliente.hiddenCodigo'));
      //alert('el codigo es '+  get('frmInsertarCliente.hiddenCodigo'));
      set('frmInsertarCliente.accion', '');
      set('frmInsertarCliente.conectorAction', 'LPModificarCliente');
      eval('frmInsertarCliente').oculto = 'N';
      enviaSICC('frmInsertarCliente', '', '', 'N');
   }else{

      listado1.setDatos(lista1Limpiar);
      listado2.setDatos(lista2Limpiar);
      listado3.setDatos(lista3Limpiar);
      listado4.setDatos(lista4Limpiar);

      lista1Limpiar = duplicaArray(lista1Limpiar);
      lista2Limpiar = duplicaArray(lista2Limpiar);
      lista3Limpiar = duplicaArray(lista3Limpiar);
      lista4Limpiar = duplicaArray(lista4Limpiar);
    }

}

//--------------------------------------------------------------------------------------------------------------------
function seteaVarsLimpiar()
{
         // Llena las variables de listas que se usan para el limpiar (para inc. 4904)
         // by ssantana

         lista1Limpiar = duplicaArray(listado1.datos);
         lista2Limpiar = duplicaArray(listado2.datos);
         lista3Limpiar = duplicaArray(listado3.datos);
         lista4Limpiar = duplicaArray(listado4.datos);


}

// -------------------------------------------------------------------------------
function i18nPestanyas()
{
           var div1 = document.getElementById("InsertarP1");
           var div2 = document.getElementById("InsertarP2");
           var div3 = document.getElementById("InsertarP3");
           var div4 = document.getElementById("InsertarP4");

           div1.innerText = GestionarMensaje("1507");
           div2.innerText = GestionarMensaje("1508");
           div3.innerText = GestionarMensaje("1509");
           div4.innerText = GestionarMensaje("1510");

}


// -------------------------------------------------------------------------------------------
function duplicaArray(param)
{
         var valorToReturn = new Array();
         if ( param != "")
         {
                  var cantFilas = param.length;
                  var cantCols = param[0].length;

                  for (var i = 0; i < cantFilas; i++)
                  {
                           var nuevaFila = new Array();
                           for (var j = 0; j < cantCols; j++)
                           {	
                                    var dato = param[i][j];
                                    nuevaFila[j] = dato;
                           }
                           valorToReturn[i] = nuevaFila;
                  }
         }
         return valorToReturn;

}

// -------------------------------------------------------------------------------------------
function deshabilitaTodo()
{
                  listado3.actualizaDat();
                  var datosLista = listado3.datos;
                  var longLista = datosLista.length;

                  if ( longLista > 0 )
                  {
                                    for ( var i = 0; i < longLista; i++)
                                    {
                                             var probSolu = datosLista[i][3];
                                             if (probSolu == "S")  // Deshabilita problema
                                                      activarSolucion(i);
                                             else
                                                      activarProblema(i);

                                    }
          	 }
}


// ------------------------------------------------------------------------------------------------------------
/**************************recarga de subtipo******************************************/

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------           
         function onChangeTipo(){
             var combo=window.event.srcElement.getAttribute("NAME");
             
             var option=window.event.srcElement.options;
             
             for(var i=0;i<option.length;i++){
                if(option.item(i).getAttribute("selected")){
                                  
                                      if(i == 0) {
                                                accion(formName + ".comboTipoClasificacion", ".disabled=true");
                         accion(formName + ".comboClasificacion", ".disabled=true");
                                      } else {
                         accion(formName + ".comboTipoClasificacion", ".disabled=false");
                         accion(formName + ".comboClasificacion", ".disabled=false");
                                      }
                             
                    set('frmInsertarCliente.nameComboSelectedTipo',combo);
                    set('frmInsertarCliente.valueComboSelectedTipo',option.item(i).getAttribute("value"));
                    //alert('el value es ' + get('frmInsertarCliente.valueComboSelectedTipo'));
                    var aCombo = new Array(new Array("",""));
                    set_combo('frmInsertarCliente.cbSubtipoCliente',aCombo, []);
                    set_combo('frmInsertarCliente.comboClasificacion',aCombo, []);
                    set_combo('frmInsertarCliente.comboTipoClasificacion',aCombo, []);
              
                    cargarComboSubtipo();

                 }
             }
         }

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------                      
         function cargarComboSubtipo(){
            var name = get('frmInsertarCliente.nameComboSelectedTipo');
            var cad = new String();
            cad=name;
            var largo = cad.length;
            var Lista  = document.getElementById("cbSubtipoCliente");
          //  var optionVacia = document.createElement("OPTION");
          //  Lista.options.add(optionVacia);
          //  optionVacia.innerText = '';
           // optionVacia.value = -1;
                   
            for(var k=0;k<ListaSubtipo.datos.longitud;k++)
            	  {
             if (ListaSubtipo.datos.ij(k,0) == get('frmInsertarCliente.valueComboSelectedTipo')) 
                                    {
                           
                   var option = document.createElement("OPTION");
                   Lista.options.add(option);
                   option.innerText=ListaSubtipo.datos.ij(k,2);
                   option.value= ListaSubtipo.datos.ij(k,1);
                }
            }
                     
         }
        

/**************************************************************************************/
/**************************recarga de tipo clasificacion******************************************/

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------           
         function onChangeSubtipo()
                    {
         
             var combo=window.event.srcElement.getAttribute("NAME");
             
             var option=window.event.srcElement.options;
             
             for(var i=0;i<option.length;i++){
                if(option.item(i).getAttribute("selected")){
                    set('frmInsertarCliente.nameComboSelectedSubtipo',combo);
                    set('frmInsertarCliente.valueComboSelectedSubtipo',option.item(i).getAttribute("value"));
                    var aCombo = new Array(new Array("",""));
                    set_combo('frmInsertarCliente.comboClasificacion',aCombo, []);
                    set_combo('frmInsertarCliente.comboTipoClasificacion',aCombo, []);
                    
                    cargarComboTipoClasificacion();
                 }
             }
         }

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------           
         function cargarComboTipoClasificacion()
                    {
            var name = get('frmInsertarCliente.nameComboSelectedSubtipo');
            var cad = new String();
            cad=name;
            var largo = cad.length;
            var Lista  = document.getElementById("comboTipoClasificacion");
            
            //alert('esta en cargar');
            
            for(var k=0; k<ListaTipoClasi.datos.longitud; k++) {
             if (ListaTipoClasi.datos.ij(k,1) == get('frmInsertarCliente.valueComboSelectedSubtipo')) {
             
                                                //alert( ListaTipoClasi.datos.ij(k,1) );
                   var option = document.createElement("OPTION");
                   Lista.options.add(option);
                   option.innerText=ListaTipoClasi.datos.ij(k,2);
                   option.value= ListaTipoClasi.datos.ij(k,0);
                }
            }
                     
         }
        

/**************************************************************************************/

  /*******************************************************************/
         function onChangeTipoClasificacion(){
             var combo=window.event.srcElement.getAttribute("NAME");
                           
             var option=window.event.srcElement.options;
             
             for(var i=0;i<option.length;i++){
                if(option.item(i).getAttribute("selected")){
                                        
                    set('frmInsertarCliente.nameComboSelected',combo);
                    set('frmInsertarCliente.valueComboSelected',option.item(i).getAttribute("value"));
                    var aCombo = new Array(new Array("",""));
                    set_combo('frmInsertarCliente.comboClasificacion',aCombo, []);
                    
                    cargarComboClasificacion();
                 }
             }
         }

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------           
         function cargarComboClasificacion(){
            var name = get('frmInsertarCliente.nameComboSelected');
            var cad = new String();
            cad=name;
            var largo = cad.length;
            var Lista  = document.getElementById("comboClasificacion");
              
            for(var k=0;k<Lista1.datos.longitud;k++) {
             if (Lista1.datos.ij(k,1) == get('frmInsertarCliente.valueComboSelected')) {
                  
                   var option = document.createElement("OPTION");
                   Lista.options.add(option);
                   option.innerText=Lista1.datos.ij(k,2);
                   option.value= Lista1.datos.ij(k,0);
                }
            }
                     
         }
        
// -----------------------------------------------------------------------------------------------------------------
function habilitaDeshabilitaCampos()
{
                  // Recorre la lista y habilita o deshabilita los campos de Solucion de acuerdo al checkbox.
                  var datosLista = listado3.datos;
                  //alert("Ahbilitada");

                  for (var i = 0; i < datosLista.length; i++)
                  {
                                    var solucion = datosLista[i][3];
                                    if (solucion == "S")
                                    {
                                                      var comboTipoSolucion =eval("listado3.form.comboTipoSolucion_" + i);
                                                      comboTipoSolucion.disabled=false; // Lo Habilita
                                                      
                                                      var areaTxtDescripcionSolucion = eval("listado3.form.AreaTxtDescripcionSolucion_" + i);
                                                      areaTxtDescripcionSolucion.disabled = false; // Lo habilita
                                                      listado3.actualizaDat();
            
                                    } else
                                    {
                                                      var comboTipoSolucion =eval("listado3.form.comboTipoSolucion_" + i);
                                                      comboTipoSolucion.disabled=true; // Lo Deshabilita
                                                      
                                                      var areaTxtDescripcionSolucion = eval("listado3.form.AreaTxtDescripcionSolucion_" + i);
                                                      areaTxtDescripcionSolucion.disabled = true; // Lo Deshabilita
                                                      listado3.actualizaDat();
                                    }

                  }
         
}

// -----------------------------------------------------------------------------------------------------------------
function listadoClasificacionesToString() {
    listado2.actualizaDat();
         
         var datosLista2 = new String();
         var cantClasificaciones = listado2.datos.length;
    
         for(var i = 0; i < cantClasificaciones ; i++) {
                  datosLista2 = datosLista2 + 'clasi'                         + '=' + listado2.datos[i][0]  + ';';
                  datosLista2 = datosLista2 + 'comboMarcaDesc'              + '=' + listado2.datos[i][1]  + ';';
                  datosLista2 = datosLista2 + 'comboCanalDesc'              + '=' + listado2.datos[i][2]  + ';';
                  datosLista2 = datosLista2 + 'comboTipoClienteDesc'        + '=' + listado2.datos[i][3]  + ';';
                  datosLista2 = datosLista2 + 'comboSubTipoClienteDesc'    + '=' + listado2.datos[i][4]  + ';';
                  datosLista2 = datosLista2 + 'comboTipoClasificacionDesc' + '=' + listado2.datos[i][5]  + ';';
                  datosLista2 = datosLista2 + 'comboClasificacionDesc'     + '=' + listado2.datos[i][6]  + ';';
                  // Oculto
                  datosLista2 = datosLista2 + 'comboMarca'                   + '=' + listado2.datos[i][7]  + ';';
                  datosLista2 = datosLista2 + 'comboCanal'                   + '=' + listado2.datos[i][8]  + ';';
                  datosLista2 = datosLista2 + 'comboTipoClasificacion'     + '=' + listado2.datos[i][9]  + ';';
                  datosLista2 = datosLista2 + 'comboClasificacion'          + '=' + listado2.datos[i][10] + ';';
         datosLista2 = datosLista2 + 'comboTipoCliente'            + '=' + listado2.datos[i][11] + ';';
                  datosLista2 = datosLista2 + 'comboSubtipoCliente'         + '=' + listado2.datos[i][12];

                  if (i < (cantClasificaciones - 1)) {
                           datosLista2 = datosLista2 + '|'; // Separador de Clasificaciones
                  }
         }
         set(formName + ".hidListaClasificacion", datosLista2);
         
         return datosLista2;
}

// -----------------------------------------------------------------------------------------------------------------
function stringClasificacionesToListado(datosLista2) {
    var arrayClasi = new Array();        
    
         if(datosLista2 != "") {
                  
                  var clasificaciones = datosLista2.split("|");  // Separador de Clasificaciones
         var cantClasificaciones = clasificaciones.length;
                  var campos;
                  var cantCampos;
                  var campo;
                  var dato;
                  var nombre;
                  var valor;
                  
                  for(var i = 0; i < cantClasificaciones; i++) { // Recorro Clasificaciones
                      arrayClasi[i] = new Array(); 
                           campos = clasificaciones[i].split(";")
                      cantCampos =  campos.length;
                           
             for (var j = 0; j < cantCampos ; j++) {    // Recorro campos de una Clasificacion
                                campo = campos[j];
                                dato   = campo.split("=");
                                nombre = dato[0];
                                valor  = dato[1];
                  
                      	if (nombre == "clasi") { 
                                         arrayClasi[i][0] = valor;
                                } else if (nombre == "comboMarcaDesc") {
                                         arrayClasi[i][1] = valor;
                                } else if (nombre == "comboCanalDesc") {
                                         arrayClasi[i][2] = valor;
                                } else if (nombre == "comboTipoClienteDesc") {
                                         arrayClasi[i][3] = valor;
                                } else if (nombre == "comboSubTipoClienteDesc") {
                                         arrayClasi[i][4] = valor;
                                } else if (nombre == "comboTipoClasificacionDesc") {
                                         arrayClasi[i][5] = valor;
                                } else if (nombre == "comboClasificacionDesc"){
                                         arrayClasi[i][6] = valor;
                                } else if (nombre == "comboMarca") {
                                         arrayClasi[i][7] = valor;
                                } else if (nombre == "comboCanal") {
                                         arrayClasi[i][8] = valor;
                                } else if (nombre == "comboTipoClasificacion") {
                                         arrayClasi[i][9] = valor;
                                } else if (nombre == "comboClasificacion") {
                                         arrayClasi[i][10] = valor;
                                } else if (nombre == "comboTipoCliente") {
                                         arrayClasi[i][11] = valor;
                                } else if (nombre == "comboSubtipoCliente") {
                                         arrayClasi[i][12] = valor;
                                }
             }
                  }	

                  for(var k = 0; k < cantClasificaciones; k++) {
                           listado2.insertar(arrayClasi[k], true);
                  }
         }
         listado2.repintaDat();
         listado2.repinta();
}
