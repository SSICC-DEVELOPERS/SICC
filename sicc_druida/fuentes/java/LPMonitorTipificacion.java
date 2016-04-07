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

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Vector;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.math.BigDecimal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.dtos.ped.DTOTipificacion;
import es.indra.sicc.dtos.ped.DTOListaTipificaciones;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

/**
 * Sistema:       Belcorp
 * Modulo:        PED
 * Submódulo:     Monitor
 * Componente:    LPMonitorTificacion
 * Fecha:         08/09/2004
 * Observaciones:     
 * @version        1.0
 * @autor         
 */

public class LPMonitorTipificacion extends LPSICCBase {

	public LPMonitorTipificacion() {
		super();
	}

	public void inicio() throws Exception {
		pagina("contenido_estados_consolidados_buscar_detalle");
	}

	public void ejecucion() throws Exception {

	  setTrazaFichero();
	  rastreo();

	  try{
			String mAccion = conectorParametroLimpia( "accion", "", true );

			if (mAccion.equals("")) {
        asignarAtributoPagina("cod", "0691");
				cargarPantalla();
			}
      
			if (mAccion.equals("guardar")) {
        pagina("salidaGenerica");
        String sRegistro = conectorParametroLimpia( "elementosLista", "", true );

        //comienzo a pharsear registro.................
        traza("guardar...........registro: " + sRegistro);

        //campos: orden - oidTipoCliente - oidSubtipoCliente - oidTipoClasificacion - oidClasificacion
        int fieldCount = 0; //contador de campos, 4; indica ultimo campo - prox. registro.
        //DTOTipificacion dtoTipi = new DTOTipificacion();
        DTOListaTipificaciones dtoLT = new DTOListaTipificaciones();
        
        String valor = null;

        ArrayList tipificArr = new ArrayList();
        ArrayList aux = new ArrayList();

        StringTokenizer Stok = new StringTokenizer(sRegistro, ";");
        while ( Stok.hasMoreTokens() )
        {

             valor = Stok.nextToken();
             aux.add(valor);
             fieldCount++;

             if (fieldCount == 5) { //ya tengo los 5 campos.

               DTOTipificacion dtoTipi = new DTOTipificacion();

               dtoTipi.setOrden( new Long(aux.get(0).toString()) );
               dtoTipi.setOidTipoCliente( new Long(aux.get(1).toString()) );
               dtoTipi.setOidSubtipoCliente( new Long(aux.get(2).toString()) );
               dtoTipi.setOidTipoClasificacion( new Long(aux.get(3).toString()) );
               dtoTipi.setOidClasificacion( new Long(aux.get(4).toString()) );

               tipificArr.add(dtoTipi);
               fieldCount=0;
               aux.clear();
             
             }
             
        }

        dtoLT.setTipificaciones(tipificArr);

        dtoLT.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
        dtoLT.setOidPais(UtilidadesSession.getPais(this));
        dtoLT.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoLT.setPrograma(UtilidadesSession.getFuncion(this));

        traza("pais :  " + dtoLT.getOidPais());
        
        traza("tipificaciones (SCS)........: " + dtoLT.getTipificaciones());
        
        Vector paramEntrada = new Vector();    
        paramEntrada = new Vector();

        paramEntrada.add(dtoLT);
        paramEntrada.add( new MareBusinessID("PEDGuardarTipificaciones"));
        traza("voy a guardar tipificaciones (SCS)");
        conectar("ConectorGuardarTipificaciones", paramEntrada);
        traza("guarde tipificaciones (SCS)");

        asignarAtributo("VAR","ejecutar","valor","persistioOk();");

			}

	  }catch (Exception ex){
			   
		  logStackTrace(ex); 

		  this.lanzarPaginaError(ex);
			
	  }

		  getConfiguracionMenu();

	}

	public void cargarPantalla() throws Exception {
		cargaInicialCombos();
		String hIdioma = conectorParametroLimpia( "hIdioma", "", true );
		asignarAtributo( "VAR", "hIdioma", "valor", hIdioma);    
	}

	private void cargaInicialCombos() throws Exception{
    traza("Inicio cargaInicialCombos");
		//Preparamos los parametros del subsistema
		ComposerViewElementList cv = crearParametrosEntrada();
		
		//Utilizamos el subsistema
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();

		traza("resultados: "+resultados.getXML());
		//Cargamos los combos con los resultados
		asignar("COMBO", "cbTipoCliente", resultados, "MAEObtenerTipos");
        
    traza("Fin cargaInicialCombos");

	}

	private ComposerViewElementList crearParametrosEntrada() throws Exception {
      ComposerViewElementList lista = new ComposerViewElementList(); 

      DTOBelcorp dtoBel = new DTOBelcorp();
      dtoBel.setOidPais(UtilidadesSession.getPais(this));
      dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
    
      //Primer combo
      ComposerViewElement ci1 = new ComposerViewElement();
      ci1.setIDBusiness("MAEObtenerTipos");
      ci1.setDTOE(dtoBel);
      ci1.setPosOID((byte)0);
      ci1.setPosDesc((byte)1);

      lista.addViewElement(ci1);

      return lista;
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
