var ultimoValorOidLista = 0; // Ultimo valor del oid en Listas Editables. Se usa para generacion de nuevo registro.
var listaEditableLimpiar = null;
var varNoLimpiarSICC = true;

function onLoadPag()  {
                  DrdEnsanchaConMargenDcho('listado1',12);
                  document.all["Cplistado1"].style.visibility='hidden';
                  document.all["CpLin1listado1"].style.visibility='hidden';
                  document.all["CpLin2listado1"].style.visibility='hidden';
                  document.all["CpLin3listado1"].style.visibility='hidden';
                  document.all["CpLin4listado1"].style.visibility='hidden';
                  document.all["primera1Div"].style.visibility='hidden';
                  document.all["ret1Div"].style.visibility='hidden';
                  document.all["ava1Div"].style.visibility='hidden';
                  document.all["separaDiv"].style.visibility='hidden';


                  DrdEnsanchaConMargenDcho('listado2',12);
                  document.all["Cplistado2"].style.visibility='hidden';
                  document.all["CpLin1listado2"].style.visibility='hidden';
                  document.all["CpLin2listado2"].style.visibility='hidden';
                  document.all["CpLin3listado2"].style.visibility='hidden';
                  document.all["CpLin4listado2"].style.visibility='hidden';
                  document.all["primera2Div"].style.visibility='hidden';
                  document.all["ret2Div"].style.visibility='hidden';
                  document.all["ava2Div"].style.visibility='hidden';
                  document.all["separa2Div"].style.visibility='hidden';

                  DrdEnsanchaConMargenDcho('listado3',12);
                  document.all["Cplistado3"].style.visibility='';
                  document.all["CpLin1listado3"].style.visibility='';
                  document.all["CpLin2listado3"].style.visibility='';
                  document.all["CpLin3listado3"].style.visibility='';
                  document.all["CpLin4listado3"].style.visibility='';
                  document.all["primera3Div"].style.visibility='hidden';
                  document.all["ret3Div"].style.visibility='hidden';
                  document.all["ava3Div"].style.visibility='hidden';
                  document.all["separa3Div"].style.visibility='hidden';

                  DrdEnsanchaConMargenDcho('listado4',12);
                  document.all["Cplistado4"].style.visibility='hidden';
                  document.all["CpLin1listado4"].style.visibility='hidden';
                  document.all["CpLin2listado4"].style.visibility='hidden';
                  document.all["CpLin3listado4"].style.visibility='hidden';
                  document.all["CpLin4listado4"].style.visibility='hidden';
                  document.all["primera4Div"].style.visibility='hidden';
                  document.all["ret4Div"].style.visibility='hidden';
                  document.all["ava4Div"].style.visibility='hidden';
                  document.all["separa4Div"].style.visibility='hidden';

                  eval (ON_RSZ);  
                  i18nPestanyas(); // Internacionaliza los valores de los <DIV> correspondientes a las pestañas.
                  configurarMenuSecundario("formulario");
                  fMostrarMensajeError();
                  
                  cambiaPestanya(1);
                  muestraListaPorTipoProducto();

				  // vbongiov -- Cambio 20080807 -- 15/04/2009
				  cargaComboIndicadorAgrup();

                  ocultaCapaMensajesSegunProducto();
                  obtieneValoresParaLimpiar();
                  recargaControles();


                  var cadena = this.get("formulario.camposDeshabilitados");
                  deshabilitaControles(cadena);
                  deshabilitaTextoMensaje();

				  //Estas dos cajas de texto estaran siempre deshabilitadas
				  accion("formulario.cbSupergenerico", ".disabled=true");
				  accion("formulario.cbGenerico", ".disabled=true");

				  // sapaza -- PER-SiCC-2012-0082 -- 16/05/2012	
				  //setearIndAgrupacion();
				  
                  // vbongiov -- Cambio 20080807 -- 15/04/2009
				  set('formulario.cbIndAgrup', ['T']);

                  focaliza('formulario.cbMarcaProducto');
    
    var menu = get("formulario.opcionMenu");
  
  
  if(menu =="Consultar Concurso"){
   deshabilitaCampos();
    btnProxy(1, 0);
    btnProxy(4, 0);
    btnProxy(5, 0);
  }
 recargaCombosPeriodos();
}

// vbongiov -- Cambio 20080807 -- 15/04/2009
function cargaComboIndicadorAgrup(){

	  var todos = GestionarMensaje('2641', null, null, null);
	  var porLoMenosUno = GestionarMensaje('2636', null, null, null);

	  var carga = new Array(3);
	  carga[0] = ['', ''];
	  carga[1] = ['T', todos];
	  carga[2] = ['U', porLoMenosUno];

	  set_combo('formulario.cbIndAgrup', carga);
}


function recargaCombosPeriodos(){
	     // vbongiov -- 15/09/2006 -- inc DBLG500000020
         var periodoDesde = get('formulario.hOidPeriodoDesde');  

         set('formulario.cbPeriodoDesde', [periodoDesde]);
}

// vbongiov -- 14/09/2006 -- -- inc DBLG500000020
function onChangePeriodoDesde(){

	var pais = get('formulario.hPaisParamGener');
    var marca = get('formulario.hMarcaParamGener');
    var canal = get('formulario.hCanalParamGener');   
	var oidPerDesde = get('formulario.cbPeriodoDesde');   

    var arr = new Array();  
	arr[arr.length]=new Array("pais", pais);
	arr[arr.length]=new Array("marca", marca);
	arr[arr.length]=new Array("canal", canal);
	arr[arr.length]=new Array("oid", oidPerDesde);

	accion("formulario.cbPeriodoHasta", ".disabled=false");

	recargaCombo('formulario.cbPeriodoHasta', 'CRAObtenerPeriodosPosterioresActivos', 'es.indra.sicc.dtos.cra.DTOPeriodo', arr, "valorPerHasta(datos)");
}

function valorPerHasta(datos){
     seteo = cargaArray(datos);
     set_combo('formulario.cbPeriodoHasta', seteo);

	 var periodoHasta = get('formulario.hOidPeriodoHasta');  

     set('formulario.cbPeriodoHasta', [periodoHasta]);
}

function cargaArray(datos){
	  var seteo = new Array(datos.length + 1);
	  seteo[0] = ['' , '']
	  for(i = 0; i < datos.length; i++){
		 seteo[i+1] = [ datos[i][0], datos[i][1] ]
	  }
	  return seteo;
}
        


function deshabilitaCampos(){
  accion("formulario.cbPeriodoDesde", ".disabled=true");
  accion("formulario.cbPeriodoHasta", ".disabled=true");
  accion("formulario.txtPuntosUnidad", ".disabled=true");
  accion("formulario.txtFactorMultiplicidad", ".disabled=true");
  accion("formulario.txtUnidadesExigidas", ".disabled=true");
  accion("formulario.txtMontoExigido", ".disabled=true");
  accion("formulario.txtPuntosExigidos", ".disabled=true");
  accion("formulario.cbMarcaProducto", ".disabled=true");
  accion("formulario.cbUnidadNegocio", ".disabled=true");
  accion("formulario.cbNegocio", ".disabled=true");
  accion("formulario.cbTipoOferta", ".disabled=true");  
  accion("formulario.cbCicloVida", ".disabled=true");
  accion("formulario.txtCodProducto", ".disabled=true");
  accion("formulario.cbTipoOferta2", ".disabled=true");
  accion("formulario.cbCicloVida2", ".disabled=true");
  // vbongiov -- Cambio 20080807 -- 15/04/2009
  accion("formulario.cbIndAgrup", ".disabled=true");

  accion("formulario.ckComunicacion", ".disabled=true");
  accion("formulario.txtMensaje", ".disabled=true");  
  //--Faltan deshabilitar los botones!!!
  deshabilitarHabilitarBoton('botonContenido','btnAnadir1','D');
  deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');
  deshabilitarHabilitarBoton('botonContenido','btnAceptar','D');
  deshabilitarHabilitarBoton('botonContenido','btnBuscarSuperGenerico','D');
  deshabilitarHabilitarBoton('botonContenido','btnBuscarGenerico','D');  
}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function i18nPestanyas()
{
         var lblpBloqueNegocio = document.getElementById("lblpBloqueNegocio");
         var lblpBloqueOferta = document.getElementById("lblpBloqueOferta");
         var lblpBloqueProducto = document.getElementById("lblpBloqueProducto");

         var bloqueNegocio = GestionarMensaje("1554", null, null, null);
         var bloqueOferta = GestionarMensaje("1555", null, null, null);
         var bloqueProducto = GestionarMensaje("1553", null, null, null);

         lblpBloqueNegocio.innerText = bloqueNegocio;
         lblpBloqueOferta.innerText = bloqueOferta;
         lblpBloqueProducto.innerText = bloqueProducto;

}


// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function cambiaPestanya(pestanya)
{

         var capa2 = document.getElementById('capa2');
         var capa3 = document.getElementById('capa3');
         var capa4 = document.getElementById('capa4');

         var tabla1 = document.getElementById("tabla1");
         var tabla2 = document.getElementById("tabla2");
         var tabla3 = document.getElementById("tabla3");

         var celda1 = document.getElementById("celda1");
         var celda2 = document.getElementById("celda2");


         var lblpBloqueNegocio = document.getElementById("lblpBloqueNegocio");
         var lblpBloqueOferta = document.getElementById("lblpBloqueOferta");
         var lblpBloqueProducto = document.getElementById("lblpBloqueProducto");

         if ( parseInt(pestanya, 10) == 1)  // Bloque Negocio
         {

                  capa2.style.visibility = 'visible';
                  capa3.style.visibility = 'hidden';
                  capa4.style.visibility = 'hidden';
                  tabla1.bgColor = "#496A9A";
                  tabla2.bgColor = "";
                  tabla3.bgColor = "";

                  cambiaEstilo(lblpBloqueNegocio, "blanca");
                  cambiaEstilo(lblpBloqueOferta, "negrita");
                  cambiaEstilo(lblpBloqueProducto, "negrita");

                  limpiaBloque("Productos");
                  limpiaBloque("Oferta");
         } 

         if ( parseInt(pestanya, 10) == 2) // Bloque Oferta
         {
         
                  capa2.style.visibility = 'hidden';
                  capa3.style.visibility = 'visible';
                  capa4.style.visibility = 'hidden';

                  tabla1.bgColor = "";
                  tabla2.bgColor = "#496A9A";
                  tabla3.bgColor = "";

                  cambiaEstilo(lblpBloqueNegocio, "negrita");
                  cambiaEstilo(lblpBloqueOferta, "blanca");
                  cambiaEstilo(lblpBloqueProducto, "negrita");


                  limpiaBloque("Productos");
                  limpiaBloque("Negocio");
         }

         if ( parseInt(pestanya, 10) == 3)  // Bloque Productos
         {
                  capa2.style.visibility = 'hidden';
                  capa3.style.visibility = 'hidden';
                  capa4.style.visibility = 'visible';

                  tabla1.bgColor = "";
                  tabla2.bgColor = "";
                  tabla3.bgColor = "#496A9A";

                  cambiaEstilo(lblpBloqueNegocio, "negrita");
                  cambiaEstilo(lblpBloqueOferta, "negrita");
                  cambiaEstilo(lblpBloqueProducto, "blanca");

                  limpiaBloque("Oferta");
                  limpiaBloque("Negocio");
         }

}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function cambiaEstilo(objeto, estilo)
{
         if (estilo == "blanca") {
                  objeto.style.color =  "#FFFFFF"; 
         } else {
                  objeto.style.color =  "#000000"; 
         }
}



// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function deshabilitaControles(cadena)
{
                  // Deshabilita los campos indicados en "cadena".
                  // "cadena" tiene el formato    "campo1,campo2,campo3,.....,campoN"

                  if ( cadena != "")
                  {
                                    var arrayControles = cadena.split(",");

                                    for (var i = 0; i < arrayControles.length; i++)
                                             accion("formulario." + arrayControles[i], ".disabled=true");
                  }
}


// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionAniadir()
{
         // Deshabilita el boton hasta que se añada la fila (para evitar solapamientos)
         deshabilitarHabilitarBoton('botonContenido', 'btnAnadir1', 'D');
         // Primero chequea cuál capa está visible (de esa capa, tomará los datos para añadir)
         var capa2 = document.getElementById('capa2');
         var capa3 = document.getElementById('capa3');
         var capa4 = document.getElementById('capa4');

         var bloqueNegocio = capa2.style.visibility;
         var bloqueOferta = capa3.style.visibility;
         var bloqueProducto = capa4.style.visibility;
         

         // Ahora, añade un registro a la listaEditable en cuestion
         // ***************************************************************
         
         // Primero chequea qué lista Editable corresponde usar. 
         var listaEditable = this.obtenerLEActiva();
         // Obtiene el juego de datos de la LE activa para añadirle un registro
         eval(listaEditable + ".actualizaDat();");
         var datos = eval(listaEditable + ".datos;");
         if (datos == null || datos == undefined || datos ==  "")   // Por las dudas.
                  datos = new Array();

         var nuevoOid = obtenerSiguienteOid();  

         // Valores comunes. 
         var periodoDesde = get("formulario.cbPeriodoDesde");
         var periodoHasta = get("formulario.cbPeriodoHasta");
         var txtPuntosUnidad = get("formulario.txtPuntosUnidad");
         var txtFactorMultiplicidad = get("formulario.txtFactorMultiplicidad");
         var txtUnidadesExigidas = get("formulario.txtUnidadesExigidas");
         var txtMontoExigido = get("formulario.txtMontoExigido");
         var txtPuntosExigidos = get("formulario.txtPuntosExigidos");
         var descPeriodoDesde = get("formulario.cbPeriodoDesde", "T");
         var descPeriodoHasta = get("formulario.cbPeriodoHasta", "T");

         var oidTipoProducto = get("formulario.oidTipoProducto");
         //alert("Tipo Producto: " + oidTipoProducto);

		// BELC300024301 - gPineda - 20/10/2006
		 if( txtFactorMultiplicidad == "" ) 
			txtFactorMultiplicidad = "0";
		 if( txtPuntosUnidad == "" ) 
			txtPuntosUnidad = "0";

		 // sapaza -- PER-SiCC-2012-0082 -- 16/05/2012
		 var indAgrup = get("formulario.cbIndAgrup");
		 var descIndAgrup = get("formulario.cbIndAgrup", "T");

		 
         // ---------------------------------------- Capa Bloque Negocio -------------------------------------------------------------------------------------
         if ( bloqueNegocio == 'visible'  || bloqueNegocio == 'inherit' )  
         {
                  // Valida que se halla seleccionado Marca Producto. 
                  // Por inc. 18900, si Tipo de Producto es "A Calificar", entonces no se valida Marca Producto en la capa
                  // Bloque Negocio.
/*                var oidTipoProductoACalificar = get("formulario.oidTipoProductoACalificar");
                  var oidTipoProductoExcluidoCalif = get("formulario.oidTipoProductoExcluidosCalificacion");
                  var bloqueNegocioAValidar = "bloqueNegocioR"; // Por defecto valida MarcaProducto como requerido. 
                  if (  (parseInt(oidTipoProducto, 10)  == parseInt(oidTipoProductoACalificar, 10)) || 
                             (parseInt(oidTipoProducto, 10)  == parseInt(oidTipoProductoExcluidoCalif, 10)) )
                           bloqueNegocioAValidar = "bloqueNegocio";*/

                  if ( sicc_validaciones_generales("bloqueNegocio") )
                  {
                           // Valida Obligatoriedad y formato de Datos Asociados
                           if (  !validaDatosAsociados(oidTipoProducto) ) {
                                     deshabilitarHabilitarBoton('botonContenido', 'btnAnadir1', 'A');
                                     return;
                           }

                           var marcaProducto = get("formulario.cbMarcaProducto");
                           var uNegocio = get("formulario.cbUnidadNegocio");
                           var negocio = get("formulario.cbNegocio");
						   
						   //El oid ahora se saca de una variable
						   var superGenerico = get("formulario.varCbSuperGenerico");
                           //var superGenerico = get("formulario.cbSupergenerico");
                           
						   //El oid ahora se saca de una variable
						   var generico = get("formulario.varCbGenerico");
						   //var generico = get("formulario.cbGenerico");

                           var descMarcaProducto = get("formulario.cbMarcaProducto", "T");
                           var descUNegocio = get("formulario.cbUnidadNegocio", "T");
                           var descNegocio = get("formulario.cbNegocio", "T");
						 
						   //La descripcion ahora se saca de la caja de texto
						   var descSuperGenerico = get("formulario.cbSupergenerico");
						   //var descSuperGenerico = get("formulario.cbSupergenerico", "T");
                           
						   //La descripcion ahora se saca de la caja de texto
						   var descGenerico = get("formulario.cbGenerico");
						   //var descGenerico = get("formulario.cbGenerico", "T");

                           // **** Arma la nueva linea ************************************
                           var nuevaFila = null;
                           if ( listaEditable == "listado1")  // Lista productos validados
                           {
                                              nuevaFila = ["" + nuevoOid, 
                                                                                                    "" + descMarcaProducto, 
                                                                                                    "" + descUNegocio, 
                                                                                                    "" + descNegocio, 
                                                                                                    "" + descSuperGenerico, 
                                                                                                    "" + descGenerico, 
                                                                                                    "",
                                                                                                    "",
                                                                                                    "", 
                                                                                                    "", 
                                                                                                    "", 
                                                                                                    "" + marcaProducto, 
                                                                                                    "" + uNegocio,
                                                                                                    "" + negocio, 
                                                                                                    "" + superGenerico,
                                                                                                    "" + generico,
                                                                                                    "",
                                                                                                    "",
                                                                                                    "",
                                                                                                    "",
                                                                                                    ""

                                                                                           ];

                           } else if ( listaEditable == "listado2")   // Lista productos excluidos
                           {
                                             nuevaFila = ["" + nuevoOid,
                                                                                     "" + descMarcaProducto,
                                                                                     "" + descUNegocio, 
                                                                                     "" + descNegocio, 
                                                                                     "" + descSuperGenerico, 
                                                                                     "" + descGenerico,				    // Fin Bloque Negocio
                                                                                     "", 
                                                                                     "",											// Fin Bloque Oferta
                                                                                     "",
                                                                                     "",
                                                                                     "",											// Fin Bloque Producto
                                                                                     "" + descPeriodoDesde, 
                                                                                     "" + descPeriodoHasta,			// Fin Datos asociados
                                                                                     "" + marcaProducto,
                                                                                     "" + uNegocio, 
                                                                                     "" + negocio, 
                                                                                     "" + superGenerico, 
                                                                                     "" + generico,							// Fin Bloque Negocio Oculto
                                                                                     "", 
                                                                                     "",											// Fin Bloque Oferta Oculto
                                                                                     "",
                                                                                     "",
                                                                                     "",											// Fin Bloque Producto Oculto
                                                                                     "" + periodoDesde, 
                                                                                     "" + periodoHasta];					// Fin Datos asociados Ocultos

                           } else if ( listaEditable == "listado3")
                           {
                                             nuevaFila = ["" + nuevoOid,
                                                                                           "" + descMarcaProducto, 
                                                                                           "" + descUNegocio, 
                                                                                           "" + descNegocio, 
                                                                                           "" + descSuperGenerico, 
                                                                                           "" + descGenerico,  				 // Fin Bloque Negocio
                                                                                           "",
                                                                                           "",                                              // Fin Bloque Oferta
                                                                                           "", 
                                                                                           "",
                                                                                           "",                                              // Fin Bloque Producto
                                                                                           "" + descPeriodoDesde,
                                                                                           "" + descPeriodoHasta,
                                                                                           "" + txtPuntosUnidad,
                                                                                           "" + txtFactorMultiplicidad,      // Fin Bloque Datos Asociados
                                                                                           "" + marcaProducto, 
                                                                                           "" + uNegocio, 
                                                                                           "" + negocio, 
                                                                                      "" + superGenerico, 
                                                                                      "" + generico,							// Fin Bloque Negocio Oculto
                                                                                      "",
                                                                                           "",                                              // Fin Bloque Oferta Oculto
                                                                                           "", 
                                                                                           "",
                                                                                           "",                                              // Fin Bloque Producto Oculto
                                                                                           "" + periodoDesde,
                                                                                           "" + periodoHasta];

                           } else if ( listaEditable == "listado4")  // Lista Productos Exigidos
                           {
                                             nuevaFila = ["" + nuevoOid,
                                                                                           "" + descMarcaProducto, 
                                                                                           "" + descUNegocio, 
                                                                                           "" + descNegocio, 
                                                                                           "" + descSuperGenerico, 
                                                                                           "" + descGenerico,						  // ---- Hasta aca Bloque Negocio
                                                                                           "", 
                                                                                           "",												  // ----- Hasta acá Bloque Oferta
                                                                         "", 
                                                                         "",    
																						   "",
																						   "" + descIndAgrup,												  // ----- Hasta acá Bloque Producto
                                                                                           "" + descPeriodoDesde,
                                                                                           "" + descPeriodoHasta, 
                                                                                           "" + txtUnidadesExigidas,
                                                                                           "" + txtMontoExigido, 
                                                                                           "" + txtPuntosExigidos,                 //  ---- Hasta acá Datos Asociados
                                                                                           "" + marcaProducto, 
                                                                                           "" + uNegocio, 
                                                                                           "" + negocio, 
                                                                                      "" + superGenerico, 
                                                                                      "" + generico,							// Fin Bloque Negocio Oculto
                                                                                           "", 
                                                                                           "",												// ----- Hasta acá Bloque Oferta oculto
                                                                         "", 
                                                                         "",    
																			               "",
																			               "" + indAgrup,												// ----- Hasta acá Bloque Producto oculto
                                                                                           "" + periodoDesde, 
                                                                                           "" + periodoHasta];
                                                                                     	
                           } // Fin if Lista

                            // Se valida que no se hayan ingresado los mismos datos en otra fila.
                            var cadenaToCheck = "";
                            for ( var n = 1; n < nuevaFila.length; n++ )
                            {
                                     if ( n != 1)
                                              cadenaToCheck = cadenaToCheck + ",";
                           
                                     cadenaToCheck = cadenaToCheck + nuevaFila[n];
                            }

                           //var cadenaToCheck = "" + nuevaFila;
                           var yaExisteFila = validaFilaExistente(cadenaToCheck, listaEditable);
                           if ( yaExisteFila )
                           {
                                    //alert("La combinación de datos que se intenta insertar, ya existe");
                                    deshabilitarHabilitarBoton('botonContenido', 'btnAnadir1', 'A');
                                    return;
                           }

                           datos[datos.length] = nuevaFila;
                           eval(listaEditable + ".setDatos(datos);");
                      // Limpia los campos usados para ingresar datos.
                           limpiarDespuesAnyadir();

                  } // Fin if bloque 


         } 

         // ---------------------------------------- Capa Bloque Oferta -------------------------------------------------------------------------------------
         if ( bloqueOferta == 'visible' || bloqueOferta == 'inherit' )  // Se toman los datos del BloqueOferta
         {
                  if ( sicc_validaciones_generales("bloqueOferta") )
                  {

                           // Valida Obligatoriedad y formato de Datos Asociados
                           if (  !validaDatosAsociados(oidTipoProducto) ) {
                                     deshabilitarHabilitarBoton('botonContenido', 'btnAnadir1', 'A');
                                     return;
                           }

                           var oidTipoOferta = get("formulario.cbTipoOferta");
                           var oidCicloVida = get("formulario.cbCicloVida");
                           var descTipoOferta = get("formulario.cbTipoOferta", "T");
                           var descCicloVida = get("formulario.cbCicloVida", "T");

                           var nuevaFila = null;
                           if ( listaEditable == "listado1")  
                           {
                                    nuevaFila = ["" + nuevoOid,
                                                                          	    "", 
                                                                    "",
                                           			    "",
                                                                                           "",
                                                                                           "",
                                                                                           "" + descTipoOferta,
                                                                                           "" + descCicloVida,	
                                                                                           "", 
                                                                                      "", 
                                                                    "", 
                                                                          	    "", 
                                                                    "",
                                                			    "",
                                                                                           "",
                                                                                           "",
                                                                                           "" + oidTipoOferta,
                                                                    "" + oidCicloVida,
                                                                                           "", 
                                                                    "", 
                                                                         ""];
                            } else if ( listaEditable == "listado2" )   // Lista Productos Excluidos
                            {
                                             nuevaFila = ["" + nuevoOid,
                                                                                     "",
                                                                                     "", 
                                                                                     "", 
                                                                                     "", 
                                                                                     "",									// Fin Bloque Negocio
                                                                                     "" + descTipoOferta, 
                                                                                     "" + descCicloVida,			// Fin Bloque Oferta
                                                                                     "",
                                                                                     "",
                                                                                     "",									// Fin Bloque Producto
                                                                                     "" + descPeriodoDesde, 
                                                                                     "" + descPeriodoHasta,  // Fin Datos asociados
                                                                                     "",
                                                                                     "", 
                                                                                     "", 
                                                                                     "", 
                                                                                     "",    // Fin Bloque Negocio Oculto
                                                                                     "" + oidTipoOferta, 
                                                                                     "" + oidCicloVida,    // Fin Bloque Oferta Oculto
                                                                                     "",
                                                                                     "",
                                                                                     "",   // Fin Bloque Producto Oculto
                                                                                     "" + periodoDesde, 
                                                                                     "" + periodoHasta];  // Fin Datos asociados Ocultos

                            } else if ( listaEditable == "listado3")
                            {
                                             nuevaFila = ["" + nuevoOid,
                                                                                           "", 
                                                                                           "", 
                                                                                           "", 
                                                                                           "", 
                                                                                           "",							  				 // Fin Bloque Negocio
                                                                                           "" + descTipoOferta,
                                                                                           "" + descCicloVida,                   // Fin Bloque Oferta
                                                                                           "", 
                                                                                           "",
                                                                                           "",                                              // Fin Bloque Producto
                                                                                           "" + descPeriodoDesde,
                                                                                           "" + descPeriodoHasta,
                                                                                           "" + txtPuntosUnidad,
                                                                                           "" + txtFactorMultiplicidad,      // Fin Bloque Datos Asociados
                                                                                           "", 
                                                                                           "", 
                                                                                           "", 
                                                                                      "", 
                                                                                      "",											// Fin Bloque Negocio Oculto
                                                                                      "" + oidTipoOferta,
                                                                                           "" + oidCicloVida,                     // Fin Bloque Oferta Oculto
                                                                                           "", 
                                                                                           "",
                                                                                           "",                                              // Fin Bloque Producto Oculto
                                                                                           "" + periodoDesde,
                                                                                           "" + periodoHasta];                  // Fin Bloque Datos Adicionales Oculto

                            } else if ( listaEditable == "listado4")  // Lista Productos Exigidos
                            {
                                             nuevaFila = ["" + nuevoOid,
                                                                                           "", 
                                                                                           "", 
                                                                                           "", 
                                                                                           "", 
                                                                                           "",   // ---- Hasta aca Bloque Negocio
                                                                                           "" + descTipoOferta, 
                                                                                           "" + descCicloVida,    // ----- Hasta acá Bloque Oferta
                                                                         "", 
                                                                         "",    
																			               "",
																			               "" + descIndAgrup,    // ----- Hasta acá Bloque Producto
                                                                                           "" + descPeriodoDesde,
                                                                                           "" + descPeriodoHasta, 
                                                                                           "" + txtUnidadesExigidas,
                                                                                           "" + txtMontoExigido, 
                                                                                           "" + txtPuntosExigidos, // ---------- Hasta acá bloque de 2da cabecera.
                                                                                           "",
                                                                                           "",
                                                                                           "",
                                                                                           "",
                                                                                           "",    // ---- Hasta aca Bloque Negocio oculto
                                                                                           "" + oidTipoOferta, 
                                                                                           "" + oidCicloVida,    // ----- Hasta acá Bloque Oferta oculto
                                                                         "", 
                                                                         "",    
																			               "",
																			               "" + indAgrup,    // ----- Hasta acá Bloque Producto oculto
                                                                                           "" + periodoDesde, 
                                                                                           "" + periodoHasta];
                                                                                     	
                             }  

                             // Se valida que no se hayan ingresado los mismos datos en otra fila.
                             var cadenaToCheck = "";
                             for ( var n = 1; n < nuevaFila.length; n++ )
                             {
                                      if ( n != 1)
                            		  cadenaToCheck = cadenaToCheck + ",";
                           
                                      cadenaToCheck = cadenaToCheck + nuevaFila[n];
                             }

                             //var cadenaToCheck = "" + nuevaFila;
                             var yaExisteFila = validaFilaExistente(cadenaToCheck, listaEditable);
                             if ( yaExisteFila )
                             {
                                      //alert("La combinación de datos que se intenta insertar, ya existe");
                                      deshabilitarHabilitarBoton('botonContenido', 'btnAnadir1', 'A');
                                      return;
                             }


                            datos[datos.length] = nuevaFila;
                            eval(listaEditable + ".setDatos(datos);");
                            // Limpia los campos usados para ingresar datos.
                            limpiarDespuesAnyadir();

                  }

         }

         // ---------------------------------------- Capa Bloque Producto -------------------------------------------------------------------------------------
         if ( bloqueProducto == 'visible' || bloqueProducto == 'inherit' )  // Se toman los datos de Bloque Producto 
         {
                  if ( sicc_validaciones_generales("bloqueProducto") )
                  {

                           // Valida formato de Datos Asociados
                           // Valida Obligatoriedad y formato de Datos Asociados
                           if (  !validaDatosAsociados(oidTipoProducto) ) {
                                     deshabilitarHabilitarBoton('botonContenido', 'btnAnadir1', 'A');
                                     return;
                           }

                            var codigoProducto = get("formulario.txtCodProducto");
                            var oidProducto = get("formulario.hoidProducto");
                            var oidTipoOferta = get("formulario.cbTipoOferta2");
                            var oidCicloVida = get("formulario.cbCicloVida2");
                            var descTipoOferta = get("formulario.cbTipoOferta2", "T");
                            var descCicloVida = get("formulario.cbCicloVida2", "T");

							// vbongiov -- Cambio 20080807 -- 15/04/2009
							/*var indAgrup = get("formulario.cbIndAgrup");
							var descIndAgrup = get("formulario.cbIndAgrup", "T");*/

                            var nuevaFila = null;
                            if ( listaEditable == "listado1" )  // Tipo Producto Valido
                            {
                                              nuevaFila = ["" + nuevoOid, 
                                                                                                             "", 
                                                                                                             "",
                                                                                                             "",
                                                                                                             "",
                                                                                                             "",
                                                                                                             "",
                                                                                                             "",
                                                                                                             "" + codigoProducto, 
                                                                                                             "" + descTipoOferta, 
                                                                                                             "" + descCicloVida, 
                                                                                                             "", 
                                                                                                             "",
                                                                                                             "",
                                                                                                             "",
                                                                                                             "",
                                                                                                             "",
                                                                                                             "",
                                                                                                             "" + oidProducto, 
                                                                                                             "" + oidTipoOferta, 
                                                                                                             "" + oidCicloVida
                                                                                                     ];

                              } else if ( listaEditable == "listado2")  // Lista productos excluidos
                              {
                                             nuevaFila = ["" + nuevoOid,
                                                                                     "",
                                                                                     "", 
                                                                                     "", 
                                                                                     "", 
                                                                                     "",										// Fin Bloque Negocio
                                                                                     "", 
                                                                                     "",										// Fin Bloque Oferta
                                                                                     "" + codigoProducto,
                                                                                     "" + descTipoOferta,
                                                                                     "" + descCicloVida,				// Fin Bloque Producto
                                                                                     "" + descPeriodoDesde, 
                                                                                     "" + descPeriodoHasta,		// Fin Datos asociados
                                                                                     "",
                                                                                     "", 
                                                                                     "", 
                                                                                     "", 
                                                                                     "",										// Fin Bloque Negocio Oculto
                                                                                     "", 
                                                                                     "",										// Fin Bloque Oferta Oculto
                                                                                     "" + oidProducto,
                                                                                     "" + oidTipoOferta,
                                                                                     "" + oidCicloVida,				// Fin Bloque Producto Oculto
                                                                                     "" + periodoDesde, 
                                                                                     "" + periodoHasta];				// Fin Datos asociados Ocultos

           		   } else if ( listaEditable == "listado3")  // Lista productos bonificados
                              {
                                             nuevaFila = ["" + nuevoOid,
                                                                                           "", 
                                                                                           "", 
                                                                                           "", 
                                                                                           "", 
                                                                                           "",							  				 // Fin Bloque Negocio
                                                                                           "",
                                                                                           "",                                              // Fin Bloque Oferta
                                                                                           "" + codigoProducto, 
                                                                                           "" + descTipoOferta,
                                                                                           "" + descCicloVida,                   // Fin Bloque Producto
                                                                                           "" + descPeriodoDesde,
                                                                                           "" + descPeriodoHasta,
                                                                                           "" + txtPuntosUnidad,
                                                                                           "" + txtFactorMultiplicidad,      // Fin Bloque Datos Asociados
                                                                                           "", 
                                                                                           "", 
                                                                                           "", 
                                                                                      "", 
                                                                                      "",											// Fin Bloque Negocio Oculto
                                                                                      "",
                                                                                           "",										    // Fin Bloque Oferta Oculto
                                                                                           "" + oidProducto, 
                                                                                           "" + oidTipoOferta,
                                                                                           "" + oidCicloVida,                    // Fin Bloque Producto Oculto
                                                                                           "" + periodoDesde,
                                                                                           "" + periodoHasta];                  // Fin Bloque Datos Adicionales Oculto

                              } else if ( listaEditable == "listado4")  // Lista productos exigidos
                              {
                                             nuevaFila = ["" + nuevoOid,
                                                                                           "", 
                                                                                           "", 
                                                                                           "", 
                                                                                           "", 
                                                                                           "",   // ---- Hasta aca Bloque Negocio
                                                                                           "", 
                                                                                           "",    // ----- Hasta acá Bloque Oferta
                                                                         "" + codigoProducto, 
                                                                         "" + descTipoOferta,    
                                                                                           "" + descCicloVida,   
																			               "" + descIndAgrup,    // ----- Hasta acá Bloque Producto
                                                                                           "" + descPeriodoDesde,
                                                                                           "" + descPeriodoHasta, 
                                                                                           "" + txtUnidadesExigidas,
                                                                                           "" + txtMontoExigido, 
                                                                                           "" + txtPuntosExigidos, // ---------- Hasta acá bloque de 2da cabecera.
                                                                                           "",
                                                                                           "",
                                                                                           "",
                                                                                           "",
                                                                                           "",    // ---- Hasta aca Bloque Negocio oculto
                                                                                           "", 
                                                                                           "",    // ----- Hasta acá Bloque Oferta oculto
                                                                         "" + oidProducto, 
                                                                         "" + oidTipoOferta,    
                                                                                           "" + oidCicloVida,
																						   "" + indAgrup,	// ----- Hasta acá Bloque Producto oculto
                                                                                           "" + periodoDesde, 
                                                                                           "" + periodoHasta];

                              }  // Fin ifs de listas

                              // Se valida que no se hayan ingresado los mismos datos en otra fila.
                              var cadenaToCheck = "";
                              for ( var n = 1; n < nuevaFila.length; n++ )
                              {
                             	    if ( n != 1)
                                                 cadenaToCheck = cadenaToCheck + ",";
                                    
                                         cadenaToCheck = cadenaToCheck + nuevaFila[n];
                              }

                                    //var cadenaToCheck = "" + nuevaFila;
                                    var yaExisteFila = validaFilaExistente(cadenaToCheck, listaEditable);
                                    if ( yaExisteFila )
                                    {
                                                //alert("La combinación de datos que se intenta insertar, ya existe");
                                                deshabilitarHabilitarBoton('botonContenido', 'btnAnadir1', 'A');
                                                return;
                                    }

                                datos[datos.length] = nuevaFila;
                                eval(listaEditable + ".setDatos(datos);");
                                    // Limpia los campos usados para ingresar datos.
                                    limpiarDespuesAnyadir();

                  }

         }

         // Habilita el botón "añadir" nuevamente
         deshabilitarHabilitarBoton('botonContenido', 'btnAnadir1', 'A');

}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function obtenerLEActiva()
{
         var tipoProductoUsado = get("formulario.listadoAMostrar");
         var LEActiva = "";

         if ( tipoProductoUsado == "pValidos")
                  LEActiva = "listado1";

         if ( tipoProductoUsado == "pExcluidos" )
                  LEActiva = "listado2";

         if ( tipoProductoUsado == "pBonificados" )
                  LEActiva = "listado3";

         if ( tipoProductoUsado == "pExigidos" )
                  LEActiva = "listado4";	


         return LEActiva;

}


// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function muestraListaPorTipoProducto()
{
                  // Muestra la lista Editable correspondiente al tipo de producto. 
         var tipoProductoUsado = get("formulario.listadoAMostrar");
         var LEActiva = "";

         if ( tipoProductoUsado == "pValidos")
         {
                  manejaLista("1", "visible");
                  manejaLista("2", "hidden");
                  manejaLista("3", "hidden");
                  manejaLista("4", "hidden");
                  LEActiva = "listado1";
         }

         if ( tipoProductoUsado == "pExcluidos" )
         {
                  manejaLista("1", "hidden");
                  manejaLista("2", "visible");
                  manejaLista("3", "hidden");
                  manejaLista("4", "hidden");
                  LEActiva = "listado2";
         }

         if ( tipoProductoUsado == "pBonificados" )
         {
                  manejaLista("1", "hidden");
                  manejaLista("2", "hidden");
                  manejaLista("3", "visible");
                  manejaLista("4", "hidden");
                  LEActiva = "listado3";
         }

         if ( tipoProductoUsado == "pExigidos" )
         {
                  manejaLista("1", "hidden");
                  manejaLista("2", "hidden");
                  manejaLista("3", "hidden");
                  manejaLista("4", "visible");
                  LEActiva = "listado4";	
         }
                  
}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function manejaLista(numero, estado)
{
                  document.all["Cplistado" + numero].style.visibility=estado;
                  document.all["CpLin1listado" + numero].style.visibility=estado;
                  document.all["CpLin2listado" + numero].style.visibility=estado;
                  document.all["CpLin3listado" + numero].style.visibility=estado;
                  document.all["CpLin4listado" + numero].style.visibility=estado;
                  document.all["primera" + numero + "Div"].style.visibility='hidden';
                  document.all["ret" + numero + "Div"].style.visibility='hidden';
                  document.all["ava" + numero + "Div"].style.visibility='hidden';
                  document.all["separaDiv"].style.visibility='hidden';
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function obtenerSiguienteOid()
{        
         // Obtiene siguiente a usar para LE (se usa al agregar filas)
         var retorno = "n" + ultimoValorOidLista;
         ultimoValorOidLista++;
         return retorno;

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function limpiarDespuesAnyadir()
{
         // Limpia todos los controles luego de añadir un elemento en la ListaEditable.

         var periodoDesde = get('formulario.hOidPeriodoDesde');  
         var periodoHasta = get('formulario.hOidPeriodoHasta');
         
         var arrayVacio = new Array("","");
         set("formulario.cbPeriodoDesde", [periodoDesde]);
         set("formulario.cbPeriodoHasta", [periodoHasta]);
         set("formulario.txtPuntosUnidad", "");
         set("formulario.txtFactorMultiplicidad", "");
         set("formulario.txtUnidadesExigidas", "");
         set("formulario.txtMontoExigido", "");
         set("formulario.txtPuntosExigidos", "");

         set("formulario.cbMarcaProducto", arrayVacio);
         set("formulario.cbUnidadNegocio", arrayVacio);
         set("formulario.cbNegocio", arrayVacio);

		 //Se limpia la caja de texto
 		 set("formulario.cbSupergenerico", "");
         //set("formulario.cbSupergenerico", arrayVacio);
	
		 //Se limpia la caja de texto
		 set("formulario.cbGenerico", "");
         //set("formulario.cbGenerico", arrayVacio);

         set("formulario.cbTipoOferta", arrayVacio);
         set("formulario.cbCicloVida", arrayVacio);

         set("formulario.txtCodProducto", "");
         set("formulario.cbTipoOferta2", arrayVacio);
         set("formulario.cbCicloVida2", arrayVacio);

		 // vbongiov -- Cambio 20080807 -- 15/04/2009
		 // Se saca debido a que se solicito que se debe seleccionar en el combo de indicador de agrupación el último valor agregado a la lista. 
		 //set("formulario.cbIndAgrup", arrayVacio);


}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fBorrar()
{
                  // Elimina registros en la tabla activa
                  var listaActiva = obtenerLEActiva();

                  var codigos = eval(listaActiva + ".codSeleccionados();");
                  if (codigos != null && codigos.length > 0 )
                           eval(listaActiva + ".eliminarSelecc();");

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function recargaControles()
{
                  // Se usa para recargar el valor de los controles de las capas. 
                  var marcaProducto = get("formulario.hcbMarcaProducto");
                  var uNegocio = get("formulario.hcbUnidadNegocio");
                  var negocio = get("formulario.hcbNegocio");
                  //var sGenerico = get("formulario.hcbSupergenerico");
                  //var generico = get("formulario.hcbGenerico");

                  var tipoOferta = get("formulario.hcbTipoOferta");
                  var cicloVida = get("formulario.hcbCicloVida");

                  var oidProducto = get("formulario.hoidProducto");
                  var codigoProducto = get("formulario.htxtCodigoProducto");

				  // vbongiov -- Cambio 20080807 -- 15/04/2009
				  var indAgrup = get("formulario.hIndAgrup");

                  var periodoDesde = get("formulario.hcbPeriodoDesde");
                  var periodoHasta = get("formulario.hcbPeriodoHasta");
                  var puntosUnidad = get("formulario.htxtPuntosUnidad");
                  var factorMultiplicidad = get("formulario.htxtFactorMultiplicidad");
                  var unidadesExigidas = get("formulario.htxtUnidadesExigidas");
                  var montoExigido = get("formulario.htxtMontoExigido");
                  var puntosExigidos = get("formulario.htxtPuntosExigidos");
                  var chkComunicacion = get("formulario.hchkComunicacion");
                  var codigoMensaje = get("formulario.htxtCodigoMensaje");

                  set("formulario.cbMarcaProducto", new Array(marcaProducto) );
                  set("formulario.cbUnidadNegocio", new Array(uNegocio) );
                  set("formulario.cbNegocio", new Array(negocio) );
                  //set("formulario.cbSupergenerico", new Array(sGenerico) );
                  //set("formulario.cbGenerico", new Array(generico) );

                  set("formulario.cbTipoOferta", new Array(tipoOferta) );
                  set("formulario.cbTipoOferta2", new Array(tipoOferta) );
                  set("formulario.cbCicloVida", new Array(cicloVida) );
                  set("formulario.cbCicloVida2", new Array(cicloVida) );

				  // vbongiov -- Cambio 20080807 -- 15/04/2009
				  set("formulario.cbIndAgrup", new Array(indAgrup) );
                  
                  set("formulario.txtCodProducto", codigoProducto);

                  set("formulario.cbPeriodoDesde", new Array(periodoDesde) );
                  set("formulario.cbPeriodoHasta", new Array(periodoHasta) );
                  set("formulario.txtPuntosUnidad", puntosUnidad );
                  set("formulario.txtFactorMultiplicidad", factorMultiplicidad );
                  set("formulario.txtCodigoMensaje", codigoMensaje); 

                  set("formulario.txtUnidadesExigidas", unidadesExigidas);
                  set("formulario.txtMontoExigido", montoExigido);
                  set("formulario.txtPuntosExigidos", puntosExigidos);

                  if ( chkComunicacion == "1")
                           set("formulario.ckComunicacion", "S");
                  else
                           set("formulario.ckComunicacion", "N");

                  set("formulario.txtMensaje", codigoMensaje);

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionBuscarProducto()
{
         var params = new Object();
         var arrayProductos = this.mostrarModalSICC('LPBuscarProductosDTO', '', params);
         //alert('arrayProductos: '  + arrayProductos);

         if ( arrayProductos != null && arrayProductos != undefined)
         {
                           // ArrayProductos[0] contiene la cadena de Oid|Desc separados por $
                           // Le hago un split por $ para saber cuantos registros tengo.

                           var cadena = arrayProductos[0];
                           //alert("cadena: " + cadena);
                           var arrayNuevo = cadena.split("$");
                           /*alert("arrayNuevo: " + arrayNuevo);
                           alert("arrayNuevo.length: " + arrayNuevo.length);*/
                           if ( arrayNuevo.length != 2){
                                    GestionarMensaje("1497", null, null, null);
                                    focalizaBotonHTML('botonContenido','btnBuscar');
                           } else {
                                    var valores = arrayNuevo[1];
                                    var elementos = valores.split("|");
                                    var oidProducto = elementos[0];
                                    var codProducto = elementos[1];

                                    //oidProducto = oidProducto.substring(1,oidProducto.length);

                                    set("formulario.txtCodProducto", codProducto);
                                    set("formulario.hoidProducto", oidProducto);
                           }
         }

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionAceptar()
{
         var datosObligatorios = comprobarDatosObligatorios();
         var esProdValido = esTipoProductoValido();
         //alert("esProdValido: " + esProdValido);
         // Si la datosObligatorios es false, y se está validando un Producto Valido, entonces
         // quiere decir que la lista Producto Valido no contiene ninguna entrada. 
        // alert("datosObligatorios: " + datosObligatorios);
        // alert("esProdValido: " + esProdValido);
         //Borrar
          //        var lista2 = generarListaParseada();
           //       alert("Antes if - lista: "+lista2);

         //

         if ( datosObligatorios || !esProdValido )
         {
                                    //alert("datosObligatorios: " + datosObligatorios);
                                    var indComunicacion = get("formulario.ckComunicacion");
                                    var codigoMensaje = get("formulario.txtMensaje");
                                    var lista = generarListaParseada();
                                    //alert("lista: "+lista);
                                    // Chequea que si el checkbox comunicacion está habilitado, haya un valor en la caja de texto
                                    // Mensaje. 
                                    if ( indComunicacion == "S") {
                                             var validado = sicc_validaciones_generales("txtMensaje");
                                             if ( !validado ) { return ;}
                                    }

                                    set("formulario.datosObligatorios", datosObligatorios);
                                    set("formulario.conectorAction", "LPMantenerProductos");
                                    set("formulario.accion", "almacenar");
                                    set("formulario.hlstProductos", lista);
                                    set("formulario.hchkComunicacion", indComunicacion);
                                    set("formulario.htxtCodigoMensaje", codigoMensaje);
                                    eval("formulario").oculto = "S";

                                    enviaSICC("formulario", null, null, "N");
         }

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function comprobarDatosObligatorios()
{
         /*var oidTipoProductoValido = get("formulario.oidTipoProductoValidos");
         var tipoProductoActual = get("formulario.oidTipoProducto");*/
         var retorno = false;
         var esProdValido = esTipoProductoValido();

//      if ( parseInt(tipoProductoActual, 10) == parseInt(oidTipoProductoValido, 10)  )
         if ( esProdValido )
         {
                  // Chequea si la Lista de Productos Validas está vacía.
                  listado1.actualizaDat();
                  var datos = listado1.datos;
                  //alert("datos.length: " + datos.length);
                  if ( datos != null && datos.length == 0)
                  {
                           GestionarMensaje("1495", null, null, null);  //alert("La lista de productos válidos debe contener al menos un elemento");
                           retorno = false;
                  }
                  else {
                           retorno = true;
                  }
         } else
         {
                  // Para comrpobar Datos Obligatorios en la otras listas, me fijo si se ha introducido una fila en la lista corresp. 
                  // Si, es así, seteo el ind. por true. Si no, retorno false. 
                  var listaActiva = obtenerLEActiva();

                  eval(listaActiva + ".actualizaDat();");
                  var datos = eval(listaActiva + ".datos;");
                  if ( datos.length > 0 )
                           retorno = true;
                  else
                           retorno = false;

         }

         return retorno;

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function generarListaParseada()
{

         // Obtiene la Lista Activa (la que está mostrando) y luego genera una cadena con el contenido de esta lista. 
         var cadenaGenerada = "[";
         var lista = obtenerLEActiva();

         eval(lista + ".actualizaDat();");
         var datos = eval(lista + ".datos;");

         if ( datos != null && datos.length > 0 )
         {
                  // Procesa filas.
                  for ( var i = 0; i < datos.length; i++ )
                  {
                           var fila = datos[i];
                           if ( i != 0)
                                      cadenaGenerada = cadenaGenerada + "|";

                           // Procesa las celdas. 
                           for ( var j = 0; j < fila.length; j++ )
                           {
                                var valor = fila[j];
                                    if ( j != 0)
                                      cadenaGenerada = cadenaGenerada + "@";
         
                                if ( valor != "")  // Si existe algún valor, lo concatena
                                                cadenaGenerada = cadenaGenerada + valor;
                                    else                 // Si no existe ningún valor, pone espacio. " ".
                                                cadenaGenerada = cadenaGenerada + " ";

                           }
                  }
         }

         cadenaGenerada = cadenaGenerada + "]";
         //alert("cadenaGenerada: " + cadenaGenerada);

         return cadenaGenerada;

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function mouseOver(pestanya)
{
         var objCelda = document.getElementById(pestanya);
         objCelda.style.cursor = "hand";

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/*function mouseOut(pestanya)
{
         var objCelda = document.getElementById(pestanya);
         objCelda.style.cursor = "default";
}*/

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function focalizaAceptar()
{
         focalizaBotonHTML('botonContenido','btnAceptar');	
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function focalizaAnyadir()
{
         focalizaBotonHTML('botonContenido','btnAnadir1');	
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function tabAceptar()
{
                  // Al hacer tab en el Boton Aceptar. 
                  // Determina qué capa se está mostrando en la cabecera, y focaliza su botón correspondiente.

                  var capaActiva = obtieneCapaCabeceraActiva();
                  //alert("capaActiva: " + capaActiva);
                  if (  capaActiva == "capa2") {
                            // Focaliza el combo MarcaProducto
                            focaliza("formulario.cbMarcaProducto");
                  }

                  if ( capaActiva == "capa3") {
                           // Focaliza el Combo TipoOferta de la capa intermedia 
                           focaliza("formulario.cbTipoOferta");
                  }

                  if ( capaActiva == "capa4") {
                           // Focaliza el Combo TipoOferta2 de la capa Bloque Producto
                           focaliza("formulario.txtCodProducto");
                  }

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function obtieneCapaCabeceraActiva()
{
                  var capa2 = document.getElementById('capa2');
                  var capa3 = document.getElementById('capa3');
                  var capa4 = document.getElementById('capa4');

                  if ( capa2.style.visibility == 'visible' || capa2.style.visibility == 'inherit' )
                           return "capa2";

                  if ( capa3.style.visibility == 'visible' || capa3.style.visibility == 'inherit' )
                           return "capa3";

                  if ( capa4.style.visibility == 'visible' || capa4.style.visibility == 'inherit' )
                           return "capa4";
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function tabDatosAsociados()
{
         // ---- Se dispara cuando se intenta focalizar hacie un componente del Frame "Datos Asociados"
         var camposAsociados = new Array();
         camposAsociados[0] = "cbPeriodoDesde";
         camposAsociados[1] = "cbPeriodoHasta";
         camposAsociados[2] = "txtPuntosUnidad";
         camposAsociados[3] = "txtFactorMultiplicidad";
         camposAsociados[4] = "txtUnidadesExigidas";
         camposAsociados[5] = "txtMontoExigido";
         camposAsociados[6] = "txtPuntosExigidos";

         var campoAFocalizar = "";

         for (var i = 0; (i < camposAsociados.length) && (campoAFocalizar == ""); i++) {
                  var obj = document.getElementById(camposAsociados[i]); 			
                  if ( obj.disabled != true) 
                           campoAFocalizar = camposAsociados[i];
         }

         if ( campoAFocalizar == "") {
                  // Focaliza boton
          	focalizaBotonHTML('botonContenido','btnAnadir1');	
         } else {
                  // Focaliza control
                  focaliza("formulario." + campoAFocalizar);
         }


}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function shTabPeriodoDesde()
{
         var capaActiva = obtieneCapaCabeceraActiva();
    if (  capaActiva == "capa2") {
                            // Focaliza la caja de texto cbGenerico
                            focaliza("formulario.cbGenerico");
         }

         if ( capaActiva == "capa3") {
                            // Focaliza el combo cbCicloVida
                           focaliza("formulario.cbCicloVida");
         }

         if  ( capaActiva == "capa4") {
                            // Focaliza el combo cbCicloVida2
                           focaliza("formulario.cbCicloVida2");
         }

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
String.prototype.trim = function()
{
    return this.replace(/(^\s*)|(\s*$)/g, "");
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function obtieneValoresParaLimpiar()
{
         var listaActiva = obtenerLEActiva();

         eval(listaActiva + ".actualizaDat();");
         var datos = eval(listaActiva + ".datos;");
         
         listaEditableLimpiar = duplicaArray(datos);

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
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

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar(){
         // Deja la pantalla tal como estaba al ingresar. 
         set("formulario.cbMarcaProducto", new Array() );
         set("formulario.cbUnidadNegocio", new Array() );
         set("formulario.cbNegocio", new Array() );

		 set("formulario.cbSupergenerico", "");
		 //set("formulario.cbSupergenerico", new Array() );
		 set("formulario.cbGenerico", "");
         //set("formulario.cbGenerico", new Array() );
         
		 set("formulario.cbTipoOferta", new Array() );
         set("formulario.cbCicloVida", new Array() );
         set("formulario.txtCodProducto", new Array() );
         set("formulario.cbTipoOferta2", new Array() );
         set("formulario.cbCicloVida2", new Array() );

	     // vbongiov -- Cambio 20080807 -- 15/04/2009
		 set("formulario.cbIndAgrup", new Array() );

         set("formulario.txtUnidadesExigidas", "");
         set("formulario.txtMontoExigido", "");
         set("formulario.txtPuntosExigidos", "");
         set("formulario.txtPuntosUnidad", "");
         set("formulario.txtFactorMultiplicidad", "");

         set("formulario.cbPeriodoDesde", new Array() );
         set("formulario.cbPeriodoHasta", new Array() );

         var listaActiva = obtenerLEActiva();
         eval(listaActiva + ".setDatos(listaEditableLimpiar);");
         listaEditableLimpiar = duplicaArray(listaEditableLimpiar);

         var chkComunicacion = get("formulario.hchkComunicacion");
         if ( chkComunicacion == "1")
                           set("formulario.ckComunicacion", "S");
                  else
                           set("formulario.ckComunicacion", "N");

         var txtMensaje = get("formulario.htxtCodigoMensaje");
         set("formulario.txtMensaje", txtMensaje);

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fVolver()
{
         window.close();
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function deshabilitaTextoMensaje()
{
         // Si el checkBox esta marcado, entonces habilita la caja de Texto mensaje
         // Si no, lo deshabilita y limpia.

         var valorCheck = get("formulario.ckComunicacion");
         if ( valorCheck == "S") {
                  accion("formulario.txtMensaje", ".disabled=false");
         } else{
                  set("formulario.txtMensaje", "");
                  accion("formulario.txtMensaje", ".disabled=true");
         }
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function limpiaBloque(bloque)
{
         // Limpia todos los campos correspondientes al bloque en cuestion
         if (bloque == "Negocio")  // Limpia Bloque Negocio
         {
                  set("formulario.cbMarcaProducto", new Array() );
                  set("formulario.cbUnidadNegocio", new Array() );
                  set("formulario.cbNegocio", new Array() );
				
				  set("formulario.cbSupergenerico", "");
				  //set("formulario.cbSupergenerico", new Array() );

				  set("formulario.cbGenerico", "");
                  //set("formulario.cbGenerico", new Array() );
         }

         if ( bloque == "Productos" ) // Limpia Bloque Productos
         {
                  set("formulario.txtCodProducto", "");
                  set("formulario.hoidProducto", "");
                  set("formulario.cbTipoOferta2", new Array() );
                  set("formulario.cbCicloVida2", new Array() );

				  // vbongiov -- Cambio 20080807 -- 15/04/2009
				  set("formulario.cbIndAgrup", new Array() );
         }

         if ( bloque == "Oferta") // Limpia Bloque Oferta
         {
                  set("formulario.cbTipoOferta", new Array() );
                  set("formulario.cbCicloVida", new Array() );
         }
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function limpiaOidOculto()
{
         set("formulario.hoidProducto", "");
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function esTipoProductoValido()
{
         // Determina si el tipo de Producto mostrado es Tipo Producto Valido.
         // Si es así, retorna true
         // Si no, false.
         var oidTipoProductoValido = get("formulario.oidTipoProductoValidos");
         var tipoProductoActual = get("formulario.oidTipoProducto");
         var retorno = false;

         if ( parseInt(tipoProductoActual, 10) == parseInt(oidTipoProductoValido, 10)  )
                  retorno = true;

         return retorno; 

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function validaFilaExistente(cadenaToCheck, listado)
{
         // Recorre la lista en listado 
         var datosLista = eval(listado).datos;
         var seRepite = false;

         // Por cada Fila de Lista y mientras no se haya encontrado fila con los mismos valores que "cadenaToCheck". 
         for ( var i = 0; (i < datosLista.length) && (!seRepite); i++ )
         {
                  // Concatena los campos de la fila en un solo string, para luego compararlo con la entrada. 
                  // No tomo el Oid, ya que cadenaToCheck no lo incluye (por eso se empieza con j = 1)
                  var cadenaFila = "";
                  for (var j = 1; j < datosLista[i].length; j++ )
                  {
                           if ( j != 1)
                                    cadenaFila = cadenaFila + ",";

                           var campo = datosLista[i][j];
						   // vbongiov -- RI  20080805 -- 5/12/2008
						   // Elimina el oid del producto de la comparacion
						   if(j!= 18) {
                               cadenaFila = cadenaFila + datosLista[i][j];
						   } 
                  }

                  //alert("cadenaFila: " + cadenaFila + "\n" + "cadenaToCheck: " + cadenaToCheck);
                  if ( cadenaToCheck == cadenaFila ){
                           seRepite = true;
                           //alert("Match - aborta");
                  }

         }

         return seRepite;

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function validaDatosAsociados(tipoProducto)
{
         // De acuerdo al tipo de Producto que se muestre, realiza ciertas validaciones de obligatoriedad
         // en el Frame "Datos Asociados". 
         //alert("Tipo Producto: " + tipoProducto);
         var tipoProductoValidos = get("formulario.oidTipoProductoValidos");
         var tipoProductoExcluidos = get("formulario.oidTipoProductoExcluidos");
         var tipoProductoBonificados = get("formulario.oidTipoProductoBonificados");
         var tipoProductoExigidos = get("formulario.oidTipoProductoExigidos");
         var tipoProductoCalificar = get("formulario.oidTipoProductoACalificar");
         var tipoProductoExcluidosCalificacion = get("formulario.oidTipoProductoExcluidosCalificacion");
         //alert("A");
    var ok = false;
/*      alert("tipoProducto: " + tipoProducto);
         alert("tipoProductoValidos - " + tipoProductoValidos);
         alert("tipoProductoExcluidos - " + tipoProductoExcluidos);
         alert("tipoProductoBonificados - " + tipoProductoBonificados);
         alert("tipoProductoExigidos - " + tipoProductoExigidos);
         alert("tipoProductoCalificar - " + tipoProductoCalificar);
         alert("tipoProductoExcluidosCalificacion - " + tipoProductoExcluidosCalificacion);*/


         if ( parseInt(tipoProducto, 10) == parseInt(tipoProductoBonificados, 10)  )  // Tipo de Producto es Bonificados
         {
                    //alert("Bonificados");
                    // Se valida que Periodo Desde y Hasta sean obligatorios.
                    ok = sicc_validaciones_generales("cbPeriodoDesde");
                    if ( ok )
                           ok = sicc_validaciones_generales("cbPeriodoHasta");

                if ( ok )
                           ok = sicc_validaciones_generales("txtPuntosUnidad");
         
                    if ( ok )
                           ok = sicc_validaciones_generales("txtFactorMultiplicidad");

                    var txtPuntosUnidad = get("formulario.txtPuntosUnidad");
                    var txtFactorMultiplicidad = get("formulario.txtFactorMultiplicidad");
                    // Valida que exista algún valor en txtFactorMultiplicidad o txtPuntosUnidad.
                    if ( ok && txtPuntosUnidad == "" && txtFactorMultiplicidad == "")
                    {
                             GestionarMensaje("1561", null, null, null);
                             focaliza("formulario.txtPuntosUnidad", "");
                             ok = false;
                    }
          }

         if ( parseInt(tipoProducto, 10) == parseInt(tipoProductoExigidos, 10) )   // Tipo Producto Exigidos
         {
                //alert("Exigidos");
                    // Se valida que Periodo Desde y Hasta sean obligatorios.
                    ok = sicc_validaciones_generales("cbPeriodoDesde");
                    if ( ok )
                           ok = sicc_validaciones_generales("cbPeriodoHasta");

                if ( ok )
                           ok = sicc_validaciones_generales("txtUnidadesExigidas");
         
                    if ( ok )
                           ok = sicc_validaciones_generales("txtMontoExigido");

                    if ( ok )
                           ok = sicc_validaciones_generales("txtPuntosExigidos");
                    
                    var multiMarca = get("formulario.hIndMultiMarca");
                    var indAgrup = get("formulario.cbIndAgrup");
                    
                    // Valida si el concurso es MultiMarca, tiene que ingresarse IndAgrup = (T), es decir, que sean obligatorios
                    if ( ok && multiMarca == "S" && indAgrup != "T")
                    {
                             GestionarMensaje("3391", null, null, null);
                             focaliza("formulario.cbIndAgrup");
                             ok = false;
                    }
				
          }

     // Tipo Productos Excluidos Calificacion (Ahora tiene los mismo campos que Productos Excluidos, pero con Periodos Obligatorios).
          if ( parseInt(tipoProducto, 10) == parseInt(tipoProductoExcluidosCalificacion, 10) ) 
          {
                //alert("ExcluidosCalificacion");
                    // Se valida que Periodo Desde y Hasta sean obligatorios.
                    ok = sicc_validaciones_generales("cbPeriodoDesde");
                    if ( ok )
                           ok = sicc_validaciones_generales("cbPeriodoHasta");
          }
          //Cleal - Inc. 21467
          if( parseInt(tipoProducto, 10) == parseInt(tipoProductoExcluidos, 10) ){ //Productos Excluidos
                  ok = sicc_validaciones_generales("cbPeriodoDesde");
          }

         // Para el resto no se validan datos Asociados (dos no los tienen)
         if (  parseInt(tipoProducto, 10) == parseInt(tipoProductoCalificar, 10) || 
                parseInt(tipoProducto, 10) == parseInt(tipoProductoValidos, 10) 
                  //|| parseInt(tipoProducto, 10) == parseInt(tipoProductoExcluidos, 10) 
                  ) { 
                           //alert("Tipo Producto a Calificar");		
                  //alert("Calificar, Validos o Excluidos");
                      ok = true;
         }

         return ok;

}

// -----------------------------------------------------------------------------------------------------------------------------------------------------
function ocultaCapaMensajesSegunProducto()
{
         // Agregado por inc. 19178. Si el producto es "A Calificar" y o "Excluidos Calificación",
         // entonces no se muestra la capa de mensaje. 
         var tipoProductoCalificar = get("formulario.oidTipoProductoACalificar");
         var tipoProductoExcluidosCalificacion = get("formulario.oidTipoProductoExcluidosCalificacion");
         var oidTipoProducto = get("formulario.oidTipoProducto");
         var trMensaje = document.getElementById("trMensajes");

         if ( parseInt(oidTipoProducto, 10) == parseInt(tipoProductoCalificar, 10) ) 
                  trMensaje.style.display = 'none';		


         if ( parseInt(oidTipoProducto, 10) == parseInt(tipoProductoExcluidosCalificacion, 10) ) 
                  trMensaje.style.display = 'none';
         

}

 function buscarSuperGenerico(){
	var datos = new Object();
 	datos.dto = "es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOGenBusquedaSuperGenerico";
	datos.conector = "ConectorGENBusquedaProducto";
	var salida = abrirBusquedaGenerica(datos, "","0075");
	var oid = "";
	var descripcion = "";
	if(salida){
		oid = salida[0][0];
		descripcion = salida [0][2];
	}
	set('formulario.varCbSuperGenerico',oid);
	set('formulario.cbSupergenerico',descripcion);	
	
 }
 
 function buscarGenerico(){
	var datos = new Object();
  	datos.dto = "es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOGenBusquedaGenerico";
	datos.conector = "ConectorGENBusquedaProducto";
	var salida = abrirBusquedaGenerica(datos, "","0075");
	var oid = "";
	var descripcion = "";
	if(salida){
		oid = salida[0][0];
		descripcion = salida [0][2];
	}
	set('formulario.varCbGenerico',oid);
	set('formulario.cbGenerico',descripcion);	
 }

function setearIndAgrupacion() {
	var tipoProducto = get("formulario.oidTipoProducto");
	var tipoProductoExigidos = get("formulario.oidTipoProductoExigidos");
	
	if ( parseInt(tipoProducto, 10) == parseInt(tipoProductoExigidos, 10) )   // Tipo Producto Exigidos
    {
		set('formulario.cbIndAgrup', ['T']);		
    } else {
    	set('formulario.cbIndAgrup', ['']);
    }
	
}

