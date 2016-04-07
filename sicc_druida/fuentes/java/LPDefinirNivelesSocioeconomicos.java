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
 * Modulo:            SEG
 * Submódulo:         Seguridad
 * Componente:        LP
 * Fecha:             30/10/2003
 * Observaciones:     
 * @version           
 * @autor             Viviana Bongiovanni
 */

 /*$Id: LPDefinirNivelesSocioeconomicos.java,v 1.1 2009/12/03 18:38:32 pecbazalar Exp $*/

import LPSICCBase;
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.dtos.seg.DTOInternacional;
import es.indra.sicc.dtos.seg.AsociacionNivelesDTO;
import es.indra.sicc.dtos.seg.DTOListaAsociacionNiveles;

import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;

import java.lang.reflect.InvocationTargetException;
import com.evermind.server.rmi.OrionRemoteException;

import java.util.Vector;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.sql.Date;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;


// Definicion de la clase
public class LPDefinirNivelesSocioeconomicos extends LPSICCBase {
	// Definicion del constructor
	public LPDefinirNivelesSocioeconomicos() {
		super();
	}

	// Definicion del metodo abstracto inicio
	public void inicio() throws Exception {
		// Defino el nombre de la vista

    setTrazaFichero();

    traza("pase por inicio............");
    
		pagina("contenido_niveles_socioeconomicos_definir");
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {

    asignarAtributoPagina("cod", "08");
    
		setTrazaFichero();

		try	{
			
			// Rastreo
			rastreo();

			String sAccion = conectorParametroLimpia("accion","",true);      

			String sPais = conectorParametroLimpia("hidPais","",true);      
			String sNSEBelcorp = conectorParametroLimpia("comboNSEBelcorp","",true);        
			String sNSEPais = conectorParametroLimpia("comboNSEPais","",true);   

			Vector paramEntrada = new Vector();
			Vector paramEntradaDefAsocNiv = new Vector();
			Vector paramEntradaRec = new Vector();
			
			DruidaConector conectorCargarPaginaDefinirNiveles  = null;
			DruidaConector conectorDefinirAsociacionNiveles   = null;

			DTOInternacional dtoeInter = new DTOInternacional();	  
			DTOListaAsociacionNiveles dtoeAsociNiv = new DTOListaAsociacionNiveles();	  

			StringTokenizer stkNSEBelcorp = null;
			StringTokenizer stkNSEPais = null;

			traza("accion: " + sAccion);

      traza("sPais: " + sPais);
			traza("sNSEBelcorp: " + sNSEBelcorp);
			traza("sNSEPais: " + sNSEPais);

			if (sAccion.equals("") || sAccion.equals("seleccion de pais")) { 
				
				dtoeInter.setOidPais(sAccion.equals("")?UtilidadesSession.getPais(this):Long.valueOf(sPais));			
				
				dtoeInter.setOidIdioma(UtilidadesSession.getIdioma(this));				
				
				asignarAtributo("VAR","hidPais","valor", sAccion.equals("")?UtilidadesSession.getPais(this).toString():sPais);		
				
				traza("dtoeInter: " + dtoeInter);

				paramEntrada.add(dtoeInter);
				paramEntrada.add(new MareBusinessID("SEGCargarPaginaDefinirNiveles"));
            
				traza("antes 1.1");
				conectorCargarPaginaDefinirNiveles  = conectar("ConectorCargarPaginaDefinirNiveles", paramEntrada);
				traza("despues 1.1");

				traza("ConectorCargarPaginaDefinirNiveles: " + conectorCargarPaginaDefinirNiveles.getXML().toString());

        asignar("COMBO","comboPais",conectorCargarPaginaDefinirNiveles,"dtoSalida.paises_ROWSET");			
				asignar("COMBO","comboNSEBelcorp",conectorCargarPaginaDefinirNiveles,"dtoSalida.nivelesSocioeconomicosBelcorp_ROWSET");			
				asignar("COMBO","comboNSEPais",conectorCargarPaginaDefinirNiveles,"dtoSalida.tiposNivelesSocioeconomicosPersonal_ROWSET");			

			} else if (sAccion.equals("guardar")) {

        pagina("salidaGenerica");

				stkNSEBelcorp = new StringTokenizer(sNSEBelcorp,"|");
				stkNSEPais = new StringTokenizer(sNSEPais,",|");

				ArrayList arrLstAsociaciones = new ArrayList();
				AsociacionNivelesDTO asociacion = null;
							
				while (stkNSEBelcorp.hasMoreTokens()) {

					Long oidNivelSocioeconomicoBelcorp = Long.valueOf(stkNSEBelcorp.nextToken());
					stkNSEPais = new StringTokenizer(sNSEPais,",|");
					
					while (stkNSEPais.hasMoreTokens()) {

						asociacion = new AsociacionNivelesDTO();
						asociacion.setOidNivelSocioeconomicoBelcorp(oidNivelSocioeconomicoBelcorp);
						asociacion.setOidTipoNivelSocioeconomicoPersonal(Long.valueOf(stkNSEPais.nextToken()));

						arrLstAsociaciones.add(asociacion);	
					}
				}

				traza("arrLstAsociaciones " + arrLstAsociaciones);

				dtoeAsociNiv.setAsociaciones((AsociacionNivelesDTO[])arrLstAsociaciones.toArray(new AsociacionNivelesDTO[0]));

				dtoeAsociNiv.setIpCliente(UtilidadesBelcorp.getIPCliente(this));				
                dtoeAsociNiv.setPrograma(UtilidadesSession.getFuncion(this));
				traza("encontro IP Cliente y funcion");

				paramEntradaDefAsocNiv.add(dtoeAsociNiv);            
				paramEntradaDefAsocNiv.add(new MareBusinessID("SEGDefinirAsociacionNiveles"));
            
				traza("antes 3.1");
				conectorDefinirAsociacionNiveles = conectar("ConectorDefinirAsociacionNiveles", paramEntradaDefAsocNiv);
				traza("despues 3.1");

				// Vuelve a la pantalla inicial
				dtoeInter.setOidPais(UtilidadesSession.getPais(this));			
				dtoeInter.setOidIdioma(UtilidadesSession.getIdioma(this));				
				traza("dtoeInter: " + dtoeInter);

				paramEntradaRec.add(dtoeInter);
				paramEntradaRec.add(new MareBusinessID("SEGCargarPaginaDefinirNiveles"));
            
				conectorCargarPaginaDefinirNiveles  = conectar("ConectorCargarPaginaDefinirNiveles", paramEntradaRec);

        asignarAtributo("VAR","ejecutar","valor","persistioOk('" + UtilidadesSession.getPais(this).toString()+"');");

			}

		}catch (Exception ex){
          
			logStackTrace(ex); 

			this.lanzarPaginaError(ex);
      asignarAtributo("VAR","ejecutarError","valor","noPersistio();");
	    }

		getConfiguracionMenu("LPDefinirNivelesSocioeconomicos");
	}


	public void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream pila = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(pila);
		if (e instanceof MareException)
		{
			
			MareException e2=(MareException)e;
			traza("Es una mare Exception con codigo de error: "+e2.getCode());
		
		}
		e.printStackTrace(out);
		traza("stack Trace : " +  pila.toString());
	}


	private void traza(String s) throws Exception {
        super.traza(s);
        System.out.println(s);
	}

}
