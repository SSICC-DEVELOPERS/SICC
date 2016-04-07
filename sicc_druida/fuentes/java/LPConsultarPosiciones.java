/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       05/01/2005
 * @version     1.0
 * @autor       idedough
 */

//import LPSICCBase;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.druida.DruidaConector;

public class LPConsultarPosiciones extends LPSICCBase
{
	private Long oidI18N;
	private String accion;
	private Long oidCabeceraSolicitud;
		
	public LPConsultarPosiciones()
	{
		super();
	}

	public void inicio() throws Exception 		
	{
	  
	}
	
	public void ejecucion() throws Exception
	{	
		try
	    {
			this.rastreo();
			setTrazaFichero();

			traza("> Entrando a LPConsultarPosiciones.ejecucion");
			String opcion_menu = conectorParametroLimpia("opcionMenu", "", true);
            String st_oid_cabecera = conectorParametroLimpia("oidCabeceraSolicitud", "", true);
			pagina("contenido_solicitud_visualizar_posicion");
            			
			traza("> pagina -- contenido_solicitud_visualizar_posicion");

			accion = conectorParametro("accion");
			traza("1");
            accion = (accion==null?"":accion);
     		traza("2");

			if( st_oid_cabecera != null && !"".equals(st_oid_cabecera))
                 oidCabeceraSolicitud  = new Long(st_oid_cabecera);
			//else
            //   oidCabeceraSolicitud  = new Long(55);

            if("".equals(accion))
			{							
				traza("3");
			    mostrarPagina(oidCabeceraSolicitud);
		    }            
			traza("4");

			//conectorActionParametro("accion", "muestraConsulta");
			this.getConfiguracionMenu("LPConsultarPosiciones","");
		} 
		catch(Exception e)
		{
			lanzarPaginaError(e);
		}
	}


	private void cargarPaginaPosiciones() throws Exception 
	{
		    /*Crear un DTOBelcorp dtoe con: 
			- pais = Pais activo 
			- idioma = Idioma del usuario  
			 
			Añadir el elemento a la lista 
			Invocar al subsistema GestorCargaPantalla 
			Asigna el combo: 
			- cbBloqueInformacion
			*/

			traza("************ Creando DTOBelcorp");
			DTOBelcorp dtoBelcorp = new DTOBelcorp();
			dtoBelcorp.setOidIdioma(UtilidadesSession.getIdioma(this));
			dtoBelcorp.setOidPais(UtilidadesSession.getPais(this));

			// Crear una lista ComposerViewElementList 
			ComposerViewElementList listaCompView = new ComposerViewElementList();
			
			// BLOQUE INFORMACION
			// Crear un elemento de tipo ComposerViewElement() 
			// elem.IDBusiness="PEDObtenerBloquesInformacionPosicion"; 
			// elem.DTOE=dtoe; 
			// Añadir el elemento a la lista 
			ComposerViewElement elementoCV = new ComposerViewElement();
			elementoCV.setIDBusiness("PEDObtenerBloquesInformacionPosicion");
			elementoCV.setDTOE(dtoBelcorp);
			listaCompView.addViewElement(elementoCV);


			// Invocar al subsistema GestorCargaPantalla 
			traza("************ Llamando a ejecucion");
			ConectorComposerView conector = new ConectorComposerView(listaCompView, this.getRequest());
			conector.ejecucion();
				
			
			/*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
			// DruidaConector conConsultar = conectar("ConectorCargaPantalla", paramEntrada); 
			traza("************ Ante de conectar");
			DruidaConector conConsultar = conector.getConector(); 
			traza("************ Despues de conectar");

		    /*
			  Posterior a la llamada se debe hacer el asignar a los elementos 
			  de la pantalla correspondiente utilizando el String que representa el BusinessID en cada caso. 
		    */
		    asignar("COMBO", "cbBloqueInformacion", conConsultar, "PEDObtenerBloquesInformacionPosicion");		
   
	}

	private void  mostrarPagina (Long oidCabeceraSolicitud) throws Exception   
	{
		traza("************ method mostrarPagina ");
		// Carga la página de las posiciones 
		cargarPaginaPosiciones();
						
	    traza("************ cargarPaginaPosiciones ...................................... [OK] ");
		/*Muestra la página PGInformacionPosicion y le envia: 
		- oidCabeceraSolicitud 
		- ConstantesPED.INFORMACION_BASICA_POSICION 
		- ConstantesPED.INFORMACION_PRODUCTOS_POSICION 
		- ConstantesPED.INFORMACION_CANTIDADES_POSICION 
		- ConstantesPED.INFORMACION_ECONOMICA_POSICION  */

		asignar("VAR", "hOidCabeceraSolicitud", oidCabeceraSolicitud.toString());

		traza("************ asignar hOidCabeceraSolicitud ................................ [OK] ");

		asignar("VAR", "hInformacionBasicaPosicion", (es.indra.sicc.logicanegocio.ped.ConstantesPED.INFORMACION_BASICA_POSICION).toString());
		asignar("VAR", "hInformacionProductosPosicion", (es.indra.sicc.logicanegocio.ped.ConstantesPED.INFORMACION_PRODUCTOS_POSICION).toString());
		asignar("VAR", "hInformacionCantidadesPosicion", (es.indra.sicc.logicanegocio.ped.ConstantesPED.INFORMACION_CANTIDADES_POSICION).toString());
		asignar("VAR", "hInformacionEconomicaPosicion", (es.indra.sicc.logicanegocio.ped.ConstantesPED.INFORMACION_ECONOMICA_POSICION).toString());
        
		traza("************ constantes asignados ......................................... [OK] ");
	}


}
