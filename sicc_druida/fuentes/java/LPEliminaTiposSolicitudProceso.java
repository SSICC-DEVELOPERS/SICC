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
 * Sistema:           Belcorp
 * Modulo:            PED
 * Submódulo:         Pedidos
 * Componente:        LP
 * Fecha:             13/07/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes
 *
 * @version           1.0
 * @author            Hugo Andrés Mansi
 */

	import LPSICCBase;
	import es.indra.sicc.util.UtilidadesSession;
	import java.io.ByteArrayOutputStream;
	import java.io.PrintStream;

	public class LPEliminaTiposSolicitudProceso  extends LPSICCBase {
		private String accion;
		private Long idioma = null;
		private Long pais = null;

		public LPEliminaTiposSolicitudProceso () {
			super();
		}

		public void inicio() throws Exception {
		}

		public void ejecucion() throws Exception {
			setTrazaFichero();
            this.rastreo();
			accion = conectorParametroLimpia("accion", "", true);
          
			try {
				
				if (accion.equals("")) {
                  ///setea la última LP
				  conectorParametroSesion("UltimaLP","LPEliminaTiposSolicitudProceso "); 
                  //llama a LPMantieneTiposSolicitudProceso
				  conectorAction("LPMantieneTiposSolicitudProceso");
                  //setea la accion  
				  conectorActionParametro("accion", "muestraBorrado");
                  //setea la caso de uso  
         	      conectorActionParametro("casoDeUso", "eliminar");                   
				}
			} catch (Exception ex) {
				logStackTrace(ex);
				this.lanzarPaginaError(ex);
			}
		}
		 //fin de ejecución

		/* ************** logStackTrace ******************* */
		private void logStackTrace(Throwable e) {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(os);
			e.printStackTrace(ps);

			try {
				traza(os.toString());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}//fin de logStackTrace
	}
	 //Fin LPEliminaTiposSolicitudProceso 
