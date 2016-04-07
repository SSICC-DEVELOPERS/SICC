/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

/**
 * Sistema:             Belcorp - SICC
 * Modulo:              PRE
 * Componente:          LPBuscarMatrizCodigosAlternativos
 * Fecha:               13/02/2004
 * Dcoumentacion:
 * @version             3.0
 */




import es.indra.sicc.dtos.pre.DTOProductoVenta;
import es.indra.sicc.dtos.pre.DTOProductosVenta;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;

import org.jaxen.dom.DOMXPath;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class LPBuscarMatrizCodigosAlternativos extends LPSICCBase {

	private Vector vParamEntrada	= new Vector();
	private String mCasoDeUso = null;
	private String LP;

	public LPBuscarMatrizCodigosAlternativos() {
		super();
	}

	public void inicio() throws Exception {
		pagina("contenido_matriz_codigos_alternativos_eliminar");
	}

	public void ejecucion() throws Exception {

		setTrazaFichero();

		String accion = conectorParametroLimpia("accion", "", true);
		Long pais = UtilidadesSession.getPais(this);
		Long idioma = UtilidadesSession.getIdioma(this);
		mCasoDeUso = conectorParametro("casoDeUso");
		String descripcion = conectorParametro("gDescripcionPVenta");
		String oidMatrizCodigoAlternativo = conectorParametroLimpia("oidMatrizCodigoAlternativo", "", true);
		String oidMatrizFacturacion = conectorParametroLimpia("oidMatrizFacturacion", "", true);
		Vector paramEntrada = new Vector();
		DTOProductosVenta dtoe = null;

		asignarAtributo("VAR", "accion", "valor", accion );

		traza("/* -LPBuscarMatrizCodigosAlternativos" + accion + "*/");

		try{
			traza("antes de cargar menu");
			cargarMenuSecundario();
			traza("despues de cargar menu");	
		 
			rastreo();

			if(accion.equals("")){
		 		conectorAction("LPSeleccionarMF");
				conectorParametroSesion("UltimaLP","LPBuscarMatrizCodigosAlternativos");
			}else if (accion.equals("Matriz seleccionada")) {//8
				/*
				Obtener de la sesión el oid de la matriz seleccionada en la
				actividad anterior 	Mostrar pagina
				"_matriz_codigos_alternativos_registrar" vacía
				*/
				String sOidMatriz = ((Long) conectorParametroSesion("oidCabeceraMF")).toString();				
				traza("contenido del oid de matriz  ::: . " + sOidMatriz);	
			}else if (accion.equals("buscarProductoPrincipal")) {//7
				/*
				Guardar en sesión el nombre de la LP actual en la variable "UltimaLP" y
				llamar a la LP "LPBuscarProductosVenta", accion "buscarProductoPrincipal"
				*/
				traza("%%%%%%% buscarProductoPrincipal");
				conectorParametroSesion("UltimaLP", "LPBuscarMatrizCodigosAlternativos");
				conectorAction("LPBuscarProductosVenta");
				conectorActionParametro("accion","buscarProductoPrincipal");
			}else if (accion.equals("productoPrincipalSeleccionado")) {//6
				/*
				Acción "productoPrincipalSeleccionado" 
				-> Obtener de la sesión el objeto DTOProductoVenta 
				-> Tomar del dto recuperado en la actividad anteirior los atributos 
				"codigoVenta" y "descripcionProducto" y asignarlos en la pantalla a 
				los Label "codigoVenta" y "descripcionProducto" 
				*/
				traza(" productoPrincipalSeleccionado");
				DTOProductoVenta dto  = (DTOProductoVenta)conectorParametroSesion("DTOProductoVenta");

				traza("contendio de dto " + dto);
				String sCampo = dto.getCodigoVenta();
				Long oidMF =  dto.getOidMatrizFacturacion();

				traza("CONTENIDO DE sCampo:::::"+sCampo);			
				asignarAtributo("LABELC", "lblCodigoVentaXX", "valor", sCampo);
				String sDesc =dto.getDescripcion();	
				traza("CONTENIDO DE SDESC:::::"+sDesc);
				asignarAtributo("LABELC", "lblDescripcionXX", "valor", sDesc);
				
				asignarAtributo("VAR", "oidMatrizFacturacion", "valor", dto.getOidMatrizFacturacion().toString());
				asignarAtributo("VAR", "accion", "valor", "productoPrincipalSeleccionado");
				asignarAtributo("VAR", "codigoVenta", "valor", sCampo);	
				asignarAtributo("VAR", "descripcionProducto", "valor", sDesc);	
				asignarAtributo("VAR", "hIdioma", "valor", UtilidadesSession.getIdioma(this).toString());
				asignarAtributo("VAR", "hPais", "valor", UtilidadesSession.getPais(this).toString());
			}	
            
            // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
            agregarMenuComplementario();
            // Fin agregado SICC20070322
            
		}catch ( Exception e )  {
			traza("pincho la lp principal");
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			e.printStackTrace(out);
			traza("EL STACK ES COMO SIGUE : " +  pila.toString());
			e.printStackTrace();
			e.getMessage();
			lanzarPaginaError(e);
		}
	}

	private void cargarMenuSecundario() throws Exception {
		LP = conectorParametroSesion("gLPVolver").toString();
		traza("contenido de LP:::" + LP);
		if(LP.equals("LPEliminarMatrizCodigosAlternativos")){
			traza(" eliminar ::::::");
			getConfiguracionMenu("LPBuscarMatrizCodigosAlternativos","eliminar");
			asignarAtributoPagina("cod","0136");
			asignarAtributo("VAR", "casoDeUso", "valor", "eliminar");
		}

		if(LP.equals("LPConsultarMatricesCodigosAlternativos")){
			traza("en consultar::");
			getConfiguracionMenu("LPBuscarMatrizCodigosAlternativos","consultar");
			asignarAtributoPagina("cod","0176");
			asignarAtributo("VAR", "casoDeUso", "valor", "consultar");
		}
	}
    // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
    private void agregarMenuComplementario() throws Exception{
        if(conectorParametroSesion("descripcionPeriodo")!=null){
            DOMXPath xform = new DOMXPath("//PAGINA/FORMULARIO[VAR[@nombre='conectorAction']]");
            Element formulario = (Element)xform.selectSingleNode(getXML());
            if(formulario != null)
            {
                DOMXPath xpath = new DOMXPath("//VAR[@nombre='SICC_CUSTOM_TITTLE']");
                Node var = (Node)xpath.selectSingleNode(getXML());
                if(var == null)
                {
                    var = getXML().createElement("VAR");
                    ((Element)var).setAttribute("nombre", "SICC_CUSTOM_TITTLE");
                }
                ((Element)var).setAttribute("valor", (String)conectorParametroSesion("descripcionPeriodo"));
                
                formulario.appendChild(var);
            }
        }
    }
    // Fin agregado SICC20070322
}
