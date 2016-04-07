import LPSICCBase;

import es.indra.druida.DruidaConector;

//import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.mln.MareBusinessID;

//import es.indra.sicc.dtos.pre.DTOSCargarCriteriosBusquedaProductos;
import es.indra.sicc.util.DTOBelcorp;
//import es.indra.sicc.util.UtilidadesBelcorp;

import java.util.Vector;


public class LPProductoPrueba extends LPSICCBase
{
      private static final String nombreLogica = "LPBuscarProducto";
      private String oid = "";
      private String pais = "";
      private String oidCabeceraMF = "";
      private String oidEstrategia = "";
      private String oidAcceso = "";
      private String oidSubacceso = "";
      private String accion = "";
      private String casoDeUso = "";
		// Pantalla Buscar Producto
      private String codSap = "";
      private String descripcion = "";
      private String catalogo = "";
      private String paginaDesde = "";
      private String paginaHasta = "";
      private String marca = "";
      private String lineaProducto = "";
      private String unidadNegocio = "";
      private String negocio = "";
      private String generico = "";
      private String superGenerico = "";

	   // Constructor, siempre igual
	   public LPProductoPrueba()
	   {
			super();
	   }

      // Va siempre, se invoca a la pagina involucrada	
      public void inicio() throws Exception
		{
        setTrazaFichero();
        pagina("contenido_producto_buscar");
      }

      // Va siempre - Metodo ejecucion()
      public void ejecucion() throws Exception
		{
     		  accion = conectorParametroLimpia("accion","buscar",true);
   		  try
			  {
					//rastreo();
					traza("Accion: " + accion);
					traza("Voy a cargarCombos() !!");
					cargarCombos();
					traza("Volvi cargarCombos() !!");
					if (accion.equals("")) 
						 {
							traza ("entra al if teoria----------------------------");
						  //
						 } else 
							{
								  if(accion.equals("buscar"))
									  {
											 //Buscamos los productos en base a la seleccion del usuario
											 /*
											 set("frmContenido.varCbSuperGenerico",get("frmContenido.cbSuperGenerico").toString());
											 */
											traza ("Despues de cargar combos -- accion = " + accion);
											catalogo = conectorParametroLimpia("varCbCatalogo","",true);
											marca = conectorParametroLimpia("varCbMarca","",true);
											lineaProducto = conectorParametroLimpia("varCbLineaProducto","",true);
											unidadNegocio = conectorParametroLimpia("varCbUnNegocio","",true);
											negocio = conectorParametroLimpia("varCbNegocio","",true);
											generico = conectorParametroLimpia("varCbGenerico","",true);
											superGenerico = conectorParametroLimpia("varCbSuperGenerico","",true);
											codSap = conectorParametroLimpia("vartxtCodSAP","",true);
											descripcion = conectorParametroLimpia("vartxtDescripcion","",true);
											paginaDesde = conectorParametroLimpia("vartxtPagDesde","",true);
											paginaHasta = conectorParametroLimpia("vartxtPagHasta","",true);
											//devolvemos el valor a la pantalla para seleccionar los filtros utilizados
											asignarAtributo("VAR","varCbCatalogo","valor",catalogo);
											asignarAtributo("VAR","varCbMarca","valor",marca);
											asignarAtributo("VAR","varCbLineaProducto","valor",lineaProducto);
											asignarAtributo("VAR","varCbNegocio","valor",negocio);
											asignarAtributo("VAR","varCbGenerico","valor",generico);
											asignarAtributo("VAR","varCbSuperGenerico","valor",superGenerico);
											asignarAtributo("VAR","vartxtCodSAP","valor",codSap);
											asignarAtributo("VAR","vartxtDescripcion","valor",descripcion);
											asignarAtributo("VAR","vartxtPagDesde","valor",paginaDesde);
											asignarAtributo("VAR","vartxtPagHasta","valor",paginaHasta);
											//asignarAtributo("CAPA","capaContenido","visibilidad","hidden");
											//asignarAtributo("CAPA","capaTitulo","visibilidad","hidden");
											//asignarAtributo("CAPA","capaTitulo2","visibilidad","hidden");
											
										}else
											{
												 if (accion.equals("Añadir Producto"))
													 { accionAniadirProducto(); }
											}
							}
			  } catch (Exception ex)
				 {
					traza("exception: " + ex);

					java.io.StringWriter sw = new java.io.StringWriter();
					java.io.PrintWriter pw = new java.io.PrintWriter(sw);
					ex.printStackTrace(pw);
					pw.flush();
					traza("trace:" + sw);
					this.lanzarPaginaError(ex);
				 }
      }// Fin metodo ejecucion()

		// Metodo cargarCombos()
      private void cargarCombos()throws Exception
		{
			 oid = conectorParametroLimpia("hOid","",true);
			 pais = new Long(1).toString(); //UtilidadesSession.getPais(this);

			 if(conectorParametroSesion("oidCabeceraMF")!=null)
			 {
				oidCabeceraMF = "1";//conectorParametroSesion("oidCabeceraMF").toString();  
			 }
			 if(conectorParametroSesion("oidEstrategia")!=null)
			 {
				oidEstrategia = conectorParametroSesion("oidEstrategia").toString();  
			 }
			 if(conectorParametroSesion("oidAcceso")!=null)
			 {
				oidAcceso = conectorParametroSesion("oidAcceso").toString();  
			 }
			 if(conectorParametroSesion("oidSubacceso")!=null)
			 {
				oidSubacceso = conectorParametroSesion("oidSubacceso").toString();  
			 }

			 Vector paramEntrada = new Vector();
			 // Crea el idBusiness = "PRECargarCriteriosBusquedaProducto"
			 MareBusinessID idBuss = new MareBusinessID("PRECargarCriteriosBusquedaProducto");

			 // Crea DTOBelcorp con oidPais
			 DTOBelcorp dtoEntrada = new DTOBelcorp();
			 dtoEntrada.setOidPais(new Long(pais));
			 paramEntrada.addElement(dtoEntrada);
			 paramEntrada.addElement(idBuss);

			 traza("Antes del conector");

			 // Invocar al conector - ConectorCargarCriteriosBusquedaProductos
			 //DruidaConector conectorCargarCriteriosBusquedaProducto = conectar("ConectorCargarCriteriosBusquedaProductos", paramEntrada);
			 DruidaConector con = conectar("ConectorProductosPrueba",  paramEntrada);

			 traza("Despues del conector");

			 // Recoge el DTOSCargarCriterioBusquedaProductos devuelto por el conector
			 //IMareDTO dto = (IMareDTO) conectorCargarCriteriosBusquedaProducto.objeto("dtoSalida");
			 //DTOSCargarCriteriosBusquedaProductos dtoS = (DTOSCargarCriteriosBusquedaProductos) dto.getProperty("resultado");
			 // Guardar en sesion el DTOSCargarCriteriosBusquedaProductos
			 //conectorParametroSesion("DTOSCargarCriteriosBusquedaProductos",dtoS);
			 // Cargar Combos

			 traza("Armado de los combos");

			 //DruidaConector con = UtilidadesBelcorp.generarConector("dtoSalida.catalogo_ROWSET",dtoS.getCatalogos(),dtoS.getCatalogos().getColumnIdentifiers());
			 asignar("COMBO", "cbCatalogo", con, "dtoSalida.catalogo_ROWSET");

			 //con = UtilidadesBelcorp.generarConector("dtoSalida.marca_ROWSET", dtoS.getMarcas(), dtoS.getMarcas().getColumnIdentifiers());
			 asignar("COMBO", "cbMarca", con, "dtoSalida.marca_ROWSET");

			 //con = UtilidadesBelcorp.generarConector("dtoSalida.lineaProducto_ROWSET", dtoS.getLineasProducto(), dtoS.getLineasProducto().getColumnIdentifiers());
			 asignar("COMBO", "cbLineaProducto", con,
				  "dtoSalida.lineaProducto_ROWSET");

			 //con = UtilidadesBelcorp.generarConector("dtoSalida.uniNegocio_ROWSET", dtoS.getUnidadesNegocio(), dtoS.getUnidadesNegocio().getColumnIdentifiers());
			 asignar("COMBO", "cbUniNegocio", con,
				  "dtoSalida.uniNegocio_ROWSET");

			 //con = UtilidadesBelcorp.generarConector("dtoSalida.negocio_ROWSET", dtoS.getNegocios(), dtoS.getNegocios().getColumnIdentifiers());
			 asignar("COMBO", "cbNegocio", con, "dtoSalida.negocio_ROWSET");

			 //con = UtilidadesBelcorp.generarConector("dtoSalida.generico_ROWSET", dtoS.getGenericos(), dtoS.getGenericos().getColumnIdentifiers());
			 asignar("COMBO", "cbGenerico", con, "dtoSalida.generico_ROWSET");

			 //con = UtilidadesBelcorp.generarConector("dtoSalida.supergenerico_ROWSET", dtoS.getSupergenericos(), dtoS.getSupergenericos().getColumnIdentifiers());
			 asignar("COMBO", "cbSupergenerico", con,
				  "dtoSalida.supergenerico_ROWSET");

			 asignarAtributo("VAR","oidCabeceraMF","valor",oidCabeceraMF);
			 asignarAtributo("VAR","oidEstrategia","valor",oidEstrategia);
			 asignarAtributo("VAR","oidAcceso","valor",oidAcceso);
			 asignarAtributo("VAR","oidSubacceso","valor",oidSubacceso);
			 traza("Fin de asignar y cargarCombos()");
		  } // Fin metodo cargarCombos()

			// Metodo accionAniadirProducto()
		  public void accionAniadirProducto() throws Exception 
		  {
				 traza("Entro en accionAñadirProducto");

				 // Comprueba que se ha seleccionado al menos un producto
				 // Si no, muestra un mensaje de error: PRE-0025
				 // Crear una Hashtable "Productos". (La clave será el oid de cada producto)
				 // Guardar la Hashtable "Productos" en sesion
				 // Comprobar que hemos llegado a este caso de uso desde el caso de uso 
				 // "definir oferta" o "crear grupo"
				casoDeUso = (conectorParametro("casoDeUso") == null) ? "": conectorParametro("casoDeUso");

						 if ((casoDeUso == "definir oferta") ||
									(casoDeUso == "crear grupo")) 
						{
							  // Si mostrarValoresAdicionales == True (Se invocado esta LP con este parametro)
                  }
        }// Fin metodo accionAniadirProducto 
    
}// Fin clase LPBuscarProducto
