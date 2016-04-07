/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Españaamo
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
 
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.druida.DruidaConector;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOSalida;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer; 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.math.BigDecimal;

public class LPConsultaIntegralVarios extends LPConsultaIntegralInc {    
    
    public LPConsultaIntegralVarios() { super(); }

    public void inicio() throws Exception {	}

    public void ejecucion() throws Exception {
        setTrazaFichero();
		traza("LPConsultaIntegralVarios.ejecucion - Entrada");

        try{
            accion = conectorParametroLimpia("accion", "", true);
			
            if (accion.equals("consultarRecomendacionGral") ||
				accion.equals("consultarRecomendacionPart")){
                cargarPantallaRecomendacion();
            }
			else if (accion.equals("consultarPremiosSeleccionadosGral") ||
				accion.equals("consultaPremiosSeleccionadosPart")){
                cargarPantallaPremiosSeleccionados();
            }
			else if (accion.equals("consultarMotivosDescalificacionGral") ||
				accion.equals("consultarMotivosDescalificacionPart")){
                cargarPantallaMotivosDescallificacion();
            }

			cargarMenuSecundario();

			traza("LPConsultaIntegralVarios.ejecucion - Salida");
         }
		 catch(Exception ex) {
             logStackTrace(ex);
             this.lanzarPaginaError(ex);
        }
    }

	private void cargarMenuSecundario() throws Exception {     
		traza("LPConsultaIntegralVarios.cargarMenuSecundario - Entrada");
		getConfiguracionMenu("LPConsultaGeneralConcurso","");   

		if (accion.equals("consultarRecomendacionGral") ||
		accion.equals("consultarRecomendacionPart")){
			asignarAtributoPagina("cod", "2872");  
        }
		else if (accion.equals("consultarPremiosSeleccionadosGral") ||
		accion.equals("consultaPremiosSeleccionadosPart")){
			asignarAtributoPagina("cod", "2873");  
        }
		else if (accion.equals("consultarMotivosDescalificacionGral") ||
		accion.equals("consultarMotivosDescalificacionPart")){
			asignarAtributoPagina("cod", "2874");  
        }		

		traza("LPConsultaIntegralVarios.cargarMenuSecundario - Salida");
	}

	private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());
        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);
        if (e instanceof MareException) {
          MareException e2=(MareException)e;
          traza("Es una mare Exception con codigo de error: "+e2.getCode());
        }
        e.printStackTrace(out);
        traza("stack Trace : " +  pila.toString());
    }
    
	public void cargarPantallaRecomendacion() throws Exception {
		traza("LPConsultaIntegralVarios.cargarPantallaRecomendacion - Entrada");
		pagina("contenido_recomendacion");
		dtoCabecera = getCabecera();

		if (dtoCabecera.getCodigoCliente() != null)	{
			String laCodigoCliente = dtoCabecera.getCodigoCliente();
			traza("laCodigoCliente" + laCodigoCliente);
			asignarAtributo("VAR", "laCodigoCliente", "valor", laCodigoCliente); 
		}
		if (dtoCabecera.getNombreApellidos() != null) {
			String laNombreApellidos = dtoCabecera.getNombreApellidos();
			traza("laNombreApellidos" + laNombreApellidos);
			asignarAtributo("VAR", "laNombreApellidos", "valor", laNombreApellidos); 
		}
		if (dtoCabecera.getOidCliente() != null) {
			String oidCliente = dtoCabecera.getOidCliente().toString();
			traza("oidCliente" + oidCliente);
			asignarAtributo("VAR", "oidCliente", "valor", oidCliente); 
		}

		if (dtoCabecera.getOidPais() != null) {
			String oidPais = dtoCabecera.getOidPais().toString();
			traza("oidPais" + oidPais);
			asignarAtributo("VAR", "oidPais", "valor", oidPais); 
		}

		if (dtoCabecera.getOidIdioma() != null)	{
			String oidIdioma = dtoCabecera.getOidIdioma().toString();
			traza("oidIdioma" + oidIdioma);
			asignarAtributo("VAR", "oidIdioma", "valor", oidIdioma); 
		}

		asignarAtributo("VAR", "accion", "valor", accion); 	
		
		if (accion.equals("consultarRecomendacionGral")) {
			asignarAtributo("VAR", "ocultaCabecera", "valor", "true");

			traza("*************** CAMBIANDO POSICION DE LISTA EDITABLE");
			asignarAtributo("LISTAEDITABLE", "listado1", "y", "120");
			asignarAtributo("BOTON", "ret1", "y", "418");
			asignarAtributo("BOTON", "ava1", "y", "418");
			asignarAtributo("BOTON", "primera1", "y", "418");
			asignarAtributo("BOTON", "separa", "y", "414");
			asignarAtributo("CAPA", "capaEspacio", "y", "0");
		}
		else if (accion.equals("consultarRecomendacionPart")) {
			asignarAtributo("VAR", "ocultaColumnas", "valor", "true");

			if (dtoCabecera.getNombreConcurso() != null) {
				String laDescripcionConcurso = dtoCabecera.getNombreConcurso();
				traza("laDescripcionConcurso" + laDescripcionConcurso);
				asignarAtributo("VAR", "laDescripcionConcurso", "valor", 
				laDescripcionConcurso); 
			}
			if (dtoCabecera.getNumeroConcurso() != null) {
				String laNumeroConcurso = dtoCabecera.getNumeroConcurso();
				traza("laNumeroConcurso" + laNumeroConcurso);
				asignarAtributo("VAR", "laNumeroConcurso", "valor", 
				laNumeroConcurso); 
			}
			if (dtoCabecera.getOidConcurso() != null) {
				String oidConcurso = dtoCabecera.getOidConcurso().toString();
				traza("oidConcurso" + oidConcurso);
				asignarAtributo("VAR", "oidConcurso", "valor", 
				oidConcurso); 
			}
			if (dtoCabecera.getOidRegion() != null) {
				String oidRegion = dtoCabecera.getOidRegion().toString();
				traza("oidRegion" + oidRegion);
				asignarAtributo("VAR", "oidRegion", "valor", 
				oidRegion); 
			}
			if (dtoCabecera.getOidZona() != null) {
				String oidZona = dtoCabecera.getOidZona().toString();
				traza("oidZona" + oidZona);
				asignarAtributo("VAR", "oidZona", "valor", oidZona); 
			}
			if (dtoCabecera.getOidSeccion() != null) {
				String oidSeccion = dtoCabecera.getOidSeccion().toString();
				traza("oidSeccion" + oidSeccion);
				asignarAtributo("VAR", "oidSeccion", "valor", oidSeccion); 
			}


			// vbongiov -- INC-014 -- 14/10/2008
			MareBusinessID businessID = 
			new MareBusinessID("INCConsultarRecomendacionPart");
			Vector parametros = new Vector();      
			parametros.add(dtoCabecera);
			parametros.add(businessID);

			traza("******************* Antes de conectar");
			DruidaConector con = conectar("ConectorConsultarRecomendacionPart", 
			parametros);			
			traza("******************* Despues de conectar");
				
			DTOSalida dtoSalida = (DTOSalida)con.objeto("DTOSalida"); 			
			traza("******************* dtoSalida " + dtoSalida);
			RecordSet rs = dtoSalida.getResultado();
			traza("******************* rs " + rs);

			BigDecimal numPedSolicitadosRecomendada = 
			(BigDecimal) rs.getValueAt(0,"NUM_MINI_PEDI_RECO");
			traza("******************* numPedSolicitadosRecomendada" + numPedSolicitadosRecomendada);
			if(numPedSolicitadosRecomendada!=null) {
				asignarAtributo("VAR", "numPedSolicitadosRecomendada", "valor", 
				numPedSolicitadosRecomendada.toString()); 
			}

			BigDecimal numPedSolicitadosRecomendante = 
			(BigDecimal) rs.getValueAt(0,"NUM_MINI_PEDI");
			traza("******************* numPedSolicitadosRecomendante" + numPedSolicitadosRecomendante);
			if(numPedSolicitadosRecomendante!=null) {
				asignarAtributo("VAR", "numPedSolicitadosRecomendante", "valor", 
				numPedSolicitadosRecomendante.toString()); 
			}

			BigDecimal montoPedSolicitadosRecomendada = 
			(BigDecimal) rs.getValueAt(0,"IMP_MONT_MINI_PEDI");
			traza("******************* montoPedSolicitadosRecomendada" + montoPedSolicitadosRecomendada);
			if(montoPedSolicitadosRecomendada!=null) {
				asignarAtributo("VAR", "montoPedSolicitadosRecomendada", "valor", 
				montoPedSolicitadosRecomendada.toString()); 
			}

			String periodoInicio = 
			(String) rs.getValueAt(0,"COD_PERI_DESDE");
			traza("******************* periodoInicio" + periodoInicio);
			if(periodoInicio!=null) {
				asignarAtributo("VAR", "periodoInicio", "valor", 
				periodoInicio); 
			}

			String periodoFin = 
			(String) rs.getValueAt(0,"COD_PERI_HASTA");
			traza("******************* periodoFin" + periodoFin);
			if(periodoFin!=null) {
				asignarAtributo("VAR", "periodoFin", "valor", 
				periodoFin); 
			}

			// vbongiov -- 9/02/2009 -- Cambio 20080806
			BigDecimal montoMinRecomendada = 
			(BigDecimal) rs.getValueAt(0,"MONT_MIN_RECOMENDADA");
			traza("******************* montoMinRecomendada" + montoMinRecomendada);
			if(montoMinRecomendada!=null) {
				asignarAtributo("VAR", "montoMinRecomendada", "valor", 
				montoMinRecomendada.toString()); 
			}

			traza("*************** CAMBIANDO POSICION DE LISTA EDITABLE");
			asignarAtributo("LISTAEDITABLE", "listado1", "y", "272");
			asignarAtributo("BOTON", "ret1", "y", "570");
			asignarAtributo("BOTON", "ava1", "y", "570");
			asignarAtributo("BOTON", "primera1", "y", "570");
			asignarAtributo("BOTON", "separa", "y", "566");
			asignarAtributo("CAPA", "capaEspacio", "y", "589");

		}		
		traza("LPConsultaIntegralVarios.cargarPantallaRecomendacion - Salida");
	}	 

	public void cargarPantallaPremiosSeleccionados() throws Exception {
		traza("LPConsultaIntegralVarios.cargarPantallaPremiosSeleccionados - Entrada");
		pagina("contenido_premios_seleccionados");
		dtoCabecera = getCabecera();

		if (accion.equals("consultarPremiosSeleccionadosGral")) {
			asignarAtributo("VAR", "ocultarCabeceraDatosConcurso", "valor", "true");
			asignarAtributo("VAR", "ocultarDatosAdicionales", "valor", "true"); 				
			asignarAtributo("VAR", "ocultarColumnaFaltante", "valor", "true"); 			
			
			traza("*************** CAMBIANDO POSICION DE LISTA EDITABLE");
			asignarAtributo("LISTAEDITABLE", "listado1", "y", "120");
			asignarAtributo("BOTON", "ret1", "y", "418");
			asignarAtributo("BOTON", "ava1", "y", "418");
			asignarAtributo("BOTON", "primera1", "y", "418");
			asignarAtributo("BOTON", "separa", "y", "414");
			asignarAtributo("CAPA", "capaEspacio", "y", "0");
		}
		else if (accion.equals("consultaPremiosSeleccionadosPart")) {
			asignarAtributo("VAR", "ocultarColumNumDesConcurso", "valor", "true"); 				

			if (dtoCabecera.getNumeroConcurso() != null) {
				String laNumeroConcurso = dtoCabecera.getNumeroConcurso();
				traza("laNumeroConcurso" + laNumeroConcurso);
				asignarAtributo("VAR", "laNumeroConcurso", "valor", 
				laNumeroConcurso); 
			}
			if (dtoCabecera.getNombreConcurso() != null) {
				String laDescripcionConcurso = dtoCabecera.getNombreConcurso();
				traza("laDescripcionConcurso" + laDescripcionConcurso);
				asignarAtributo("VAR", "laDescripcionConcurso", "valor", 
				laDescripcionConcurso); 
			}
		}

		if (dtoCabecera.getCodigoCliente() != null)	{
			String laCodigoCliente = dtoCabecera.getCodigoCliente();
			traza("laCodigoCliente" + laCodigoCliente);
			asignarAtributo("VAR", "laCodigoCliente", "valor", 
			laCodigoCliente); 
		}
		if (dtoCabecera.getNombreApellidos() != null) {
			String laNombreApellidos = dtoCabecera.getNombreApellidos();
			traza("laNombreApellidos" + laNombreApellidos);
			asignarAtributo("VAR", "laNombreApellidos", "valor", 
			laNombreApellidos); 
		}

		if (dtoCabecera.getOidCliente() != null) {
			String oidCliente = dtoCabecera.getOidCliente().toString();
			traza("oidCliente" + oidCliente);
			asignarAtributo("VAR", "oidCliente", "valor", oidCliente); 
		}
		if (dtoCabecera.getOidPais() != null) {
			String oidPais = dtoCabecera.getOidPais().toString();
			traza("oidPais" + oidPais);
			asignarAtributo("VAR", "oidPais", "valor", oidPais); 
		}
		if (dtoCabecera.getOidIdioma() != null)	{
			String oidIdioma = dtoCabecera.getOidIdioma().toString();
			traza("oidIdioma" + oidIdioma);
			asignarAtributo("VAR", "oidIdioma", "valor", oidIdioma); 
		}
		asignarAtributo("VAR", "accion", "valor", accion); 				

		if (accion.equals("consultarRecomendacionPart")) {
			if (dtoCabecera.getOidConcurso() != null) {
				String oidConcurso = dtoCabecera.getOidConcurso().toString();
				traza("oidConcurso" + oidConcurso);
				asignarAtributo("VAR", "oidConcurso", "valor", oidConcurso); 
			}
			if (dtoCabecera.getOidRegion() != null) {
				String oidRegion = dtoCabecera.getOidRegion().toString();
				traza("oidRegion" + oidRegion);
				asignarAtributo("VAR", "oidRegion", "valor", oidRegion); 
			}
			if (dtoCabecera.getOidZona() != null) {
				String oidZona = dtoCabecera.getOidZona().toString();
				traza("oidZona" + oidZona);
				asignarAtributo("VAR", "oidZona", "valor", oidZona); 
			}
			if (dtoCabecera.getOidSeccion() != null) {
				String oidSeccion = dtoCabecera.getOidSeccion().toString();
				traza("oidSeccion" + oidSeccion);
				asignarAtributo("VAR", "oidSeccion", "valor", oidSeccion); 
			}
		}

		if (accion.equals("consultaPremiosSeleccionadosPart")) {
			MareBusinessID businessID = new MareBusinessID("INCConsultarPremiosSeleccionadosPartl");
			Vector parametros = new Vector();      
      	    parametros.add(dtoCabecera);
			parametros.add(businessID);

		    traza("******************* Antes de conectar");
			DruidaConector con = conectar("ConectorConsultarPremiosSeleccionadosPart", parametros);			
			traza("******************* Despues de conectar");			
			DTOSalida dtoSalida = (DTOSalida)con.objeto("DTOSalida"); 			
			traza("******************* dtoSalida " + dtoSalida);
			RecordSet rs = dtoSalida.getResultado();
			traza("******************* rs " + rs);

			if(!rs.esVacio()) {
				
				String observaciones = (String) rs.getValueAt(0,"OBSERVACIONES");
				traza("observaciones" + observaciones);
				if(observaciones!=null) {
					asignarAtributo("VAR", "observaciones", "valor", 
					observaciones); 
				}

				BigDecimal laTotalPuntajeObtenido = (BigDecimal) rs.getValueAt(0,"TOTAL_PUNTAJE_OBTENIDO");
				traza("laTotalPuntajeObtenido" + laTotalPuntajeObtenido);
				if(laTotalPuntajeObtenido!=null) {
					asignarAtributo("VAR", "laTotalPuntajeObtenido", "valor", 
					laTotalPuntajeObtenido.toString()); 
				}

				BigDecimal laTotalPuntajeUtilizado = (BigDecimal) rs.getValueAt(0,"TOTAL_PUNTAJE_UTILIZADO");
				traza("laTotalPuntajeUtilizado" + laTotalPuntajeUtilizado);
				if(laTotalPuntajeUtilizado!=null) {
					asignarAtributo("VAR", "laTotalPuntajeUtilizado", "valor", 
					laTotalPuntajeUtilizado.toString()); 
				}

				BigDecimal laTotalPuntajeDigitado = (BigDecimal) rs.getValueAt(0,"TOTAL_PUNTAJE_DIGITADO");
				traza("laTotalPuntajeDigitado" + laTotalPuntajeDigitado);
				if(laTotalPuntajeDigitado!=null) {
					asignarAtributo("VAR", "laTotalPuntajeDigitado", "valor", 
					laTotalPuntajeDigitado.toString()); 
				}

				BigDecimal laTotalSaldoPuntaje = (BigDecimal) rs.getValueAt(0,"SALDO_PUNTAJE");
				traza("laTotalSaldoPuntaje" + laTotalSaldoPuntaje);
				if(laTotalSaldoPuntaje!=null) {
					asignarAtributo("VAR", "laTotalSaldoPuntaje", "valor", 
					laTotalSaldoPuntaje.toString()); 
				}

				BigDecimal laPuntajeDisponible = (BigDecimal) rs.getValueAt(0,"PUNTAJE_DISPONIBLE");
				traza("laPuntajeDisponible" + laPuntajeDisponible);
				if(laPuntajeDisponible!=null) {
					asignarAtributo("VAR", "laPuntajeDisponible", "valor", 
					laPuntajeDisponible.toString()); 
				}
			}			
		}

		traza("LPConsultaIntegralVarios.cargarPantallaPremiosSeleccionados - Salida");
	}	 

	public void cargarPantallaMotivosDescallificacion() throws Exception {
		traza("LPConsultaIntegralVarios.cargarPantallaMotivosDescallificacion - Entrada");
		pagina("contenido_motivos_descalificacion");

		dtoCabecera = getCabecera();

		if (accion.equals("consultarMotivosDescalificacionGral")) {
			asignarAtributo("VAR", "ocultarCabecera", "valor", "true"); 				
		}
		else if (accion.equals("consultarMotivosDescalificacionPart")) {
			asignarAtributo("VAR", "ocultarColumnas", "valor", "true"); 				
		}
		
		if (dtoCabecera.getCodigoCliente() != null)	{
			String laCodigoCliente = dtoCabecera.getCodigoCliente();
			traza("laCodigoCliente" + laCodigoCliente);
			asignarAtributo("VAR", "laCodigoCliente", "valor", 
			laCodigoCliente); 
		}
		if (dtoCabecera.getNombreApellidos() != null) {
			String laNombreApellidos = dtoCabecera.getNombreApellidos();
			traza("laNombreApellidos" + laNombreApellidos);
			asignarAtributo("VAR", "laNombreApellidos", "valor", 
			laNombreApellidos); 
		}

		if (dtoCabecera.getOidConcurso() != null) {
			String oidConcurso = dtoCabecera.getOidConcurso().toString();
			traza("oidConcurso" + oidConcurso);
			asignarAtributo("VAR", "oidConcurso", "valor", oidConcurso); 
		}
		
		if (accion.equals("consultarMotivosDescalificacionPart")) {
			if (dtoCabecera.getNombreConcurso() != null) {
				String laDescripcionConcurso = dtoCabecera.getNombreConcurso();
				traza("laDescripcionConcurso" + laDescripcionConcurso);
				asignarAtributo("VAR", "laDescripcionConcurso", "valor", 
				laDescripcionConcurso); 
			}

			if (dtoCabecera.getNumeroConcurso() != null) {
				String laNumeroConcurso = dtoCabecera.getNumeroConcurso();
				traza("laNumeroConcurso" + laNumeroConcurso);
				asignarAtributo("VAR", "laNumeroConcurso", "valor", 
				laNumeroConcurso); 
			}
		}

		if (dtoCabecera.getOidCliente() != null) {
			String oidCliente = dtoCabecera.getOidCliente().toString();
			traza("oidCliente" + oidCliente);
			asignarAtributo("VAR", "oidCliente", "valor", oidCliente); 
		}

		if (dtoCabecera.getOidPais() != null) {
			String oidPais = dtoCabecera.getOidPais().toString();
			traza("oidPais" + oidPais);
			asignarAtributo("VAR", "oidPais", "valor", oidPais); 
		}

		if (dtoCabecera.getOidIdioma() != null)	{
			String oidIdioma = dtoCabecera.getOidIdioma().toString();
			traza("oidIdioma" + oidIdioma);
			asignarAtributo("VAR", "oidIdioma", "valor", oidIdioma); 
		}

		asignarAtributo("VAR", "accion", "valor", accion); 				
		
		if (accion.equals("consultarRecomendacionPart")) {			
			if (dtoCabecera.getOidRegion() != null) {
				String oidRegion = dtoCabecera.getOidRegion().toString();
				traza("oidRegion" + oidRegion);
				asignarAtributo("VAR", "oidRegion", "valor", oidRegion); 
			}
			if (dtoCabecera.getOidZona() != null) {
				String oidZona = dtoCabecera.getOidZona().toString();
				traza("oidZona" + oidZona);
				asignarAtributo("VAR", "oidZona", "valor", oidZona); 
			}
			if (dtoCabecera.getOidSeccion() != null) {
				String oidSeccion = dtoCabecera.getOidSeccion().toString();
				traza("oidSeccion" + oidSeccion);
				asignarAtributo("VAR", "oidSeccion", "valor", oidSeccion); 
			}
		}
	
		traza("LPConsultaIntegralVarios.cargarPantallaMotivosDescallificacion - Salida");
	}	 
}