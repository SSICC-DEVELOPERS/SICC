import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.String;


public class LPBuscarSolicitud extends LPSICCBase {

		public LPBuscarSolicitud(){ 
            super();
      }
      
       public void inicio() throws Exception {
          pagina("contenido_solicitud_buscar");
          this.getFormatosValidaciones();
      }
      
      public void ejecucion() throws Exception { 
         setTrazaFichero();
			try{
				String accion = conectorParametro("accion")==null?"":conectorParametro("accion");
				String casoDeUso = conectorParametro("casoDeUso")==null?"":conectorParametro("casoDeUso");
				String operacion = conectorParametro("operacion")==null?"":conectorParametro("operacion");
				traza("Accion: " + accion);
				traza("casoDeUso: " + casoDeUso);
				traza("operacion: " + operacion);
				
				if (accion.equals("")){
		          traza("accion vacia");

				  pagina("contenido_solicitud_buscar"); 

		          this.generarHiddenFormatoFecha();
		          this.getFormatosValidaciones();
				  asignarAtributoPagina("cod","0439");     
				  cargarCriteriosBusqueda(operacion);
				  asignarAtributo("VAR","operacion","valor", operacion);
				  //scs, agregado por inc.: 22011
				  asignarAtributo("VAR","hidOperacion","valor", operacion);

				  /* Agregado por ssantana, 24/03/2006 */ 
				  this.asignarAtributo("VAR", "constanteGP1", "valor", ConstantesPED.GP1.toString() );
				  asignarAtributo("VAR", "hLongCliente", "valor", this.obtenerLongitudCodigoCliente().toString());

				  /* Fin Agregado por ssantana, 24/03/2006 */ 

				}

				if (accion.equalsIgnoreCase("consultarSolicitud")){
             traza("accion consultarSolicitud");
					   String oidCabeceraSolicitud = conectorParametro("hidOid")==null?"":conectorParametro("hidOid");
						 conectorAction("LPConsultarModificarSolicitud");
						 conectorActionParametro("accion","");
						 conectorActionParametro("operacion","consultar");
						 conectorActionParametro("oidCabeceraSolicitud",oidCabeceraSolicitud);
				}

				if (accion.equalsIgnoreCase("modificarSolicitud")){
					    String oidCabeceraSolicitud = conectorParametro("hidOid")==null?"":conectorParametro("hidOid");
						 conectorAction("LPConsultarModificarSolicitud");
						 conectorActionParametro("accion","");
						 conectorActionParametro("operacion","modificar");
						 conectorActionParametro("oidCabeceraSolicitud",oidCabeceraSolicitud);
				}
				getConfiguracionMenu(); 
      }catch(Exception e){
         lanzarPaginaError(e);
         logStackTrace(e);
		}
	}

	private void cargarCriteriosBusqueda (String operacion) throws Exception {
	  cargaCombos(operacion);
	}
  
  private void cargaCombos(String operacion) throws Exception{
      traza("en carga combos");
  		ComposerViewElementList cv = crearParametrosEntrada(operacion);
      traza("aca");      
			ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      traza("aca 1");      
    	conector.ejecucion();
      traza("aca 2");            
      DruidaConector resultados = conector.getConector();
      traza("0");      
			asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
      traza("1");
      if(!operacion.equals("modificar"))      
        asignar("COMBO", "cbTipoSolicitud", resultados, "PEDobtieneTiposSolicitudPorPais");
      else{
        asignar("COMBO", "cbTipoSolicitud", resultados, "PEDObtenerTiposSolicitudModificar"); 
        //scs, inc.:  22011    asignarAtributo("VAR","obli","valor","S");
      }
      traza("2");      
      
      // Por incidencia 12762
      //  if(operacion.equals("modificar"))      
        asignar("COMBO", "cbGrupoProcesos", resultados, "PEDconsultaGruposProceso");
      
      traza("3");        
      asignar("COMBO", "cbProcesoValidacion", resultados, "PEDconsultaCodigosProcesos");
      asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
      asignar("COMBO", "cbEstadoSolicitud", resultados, "PEDObtenerEstadosSolicitud");
      
      asignarAtributo("VAR","oidPais","valor",UtilidadesSession.getPais(this).toString());
      asignarAtributo("VAR","oidIdioma","valor",UtilidadesSession.getIdioma(this).toString());      
    }

    private ComposerViewElementList crearParametrosEntrada(String operacion)throws Exception {
        traza("en crearParamentrosEntrada");
        DTOBelcorp dtoBel =  new DTOBelcorp();
        DTOOID dtoOid = new DTOOID();
        dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoOid.setOidPais(UtilidadesSession.getPais(this));
        dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoBel.setOidPais(UtilidadesSession.getPais(this));
        
        ComposerViewElementList lista = new ComposerViewElementList();
    
        //Combo canal
        ComposerViewElement ci1 = new ComposerViewElement();
        ci1.setIDBusiness("SEGConsultaCanales");
        ci1.setDTOE(dtoBel);
        //Combo tipo solicitud
        ComposerViewElement ci2 = new ComposerViewElement();
        if(!operacion.equals("modificar")) ci2.setIDBusiness("PEDobtieneTiposSolicitudPorPais");
           else ci2.setIDBusiness("PEDObtenerTiposSolicitudModificar");
        ci2.setDTOE(dtoBel);
        //Combo grupo procesos
        ComposerViewElement ci3 = new ComposerViewElement();
        ci3.setIDBusiness("PEDconsultaGruposProceso");
        ci3.setDTOE(dtoBel);
        //Combo proceso
        ComposerViewElement ci4 = new ComposerViewElement();
        ci4.setIDBusiness("PEDconsultaCodigosProcesos");
        if(!operacion.equals("modificar")){ 
          dtoOid.setOid(ConstantesPED.GP1);
          ci4.setDTOE(dtoOid);
        }else ci4.setDTOE(dtoOid);
        //Combo marca
        ComposerViewElement ci5 = new ComposerViewElement();
    		ci5.setIDBusiness("SEGConsultaMarcas");
        ci5.setDTOE(dtoBel);
        //ci5.setPosOID(Byte.parseByte("1"));
        //ci5.setPosDesc(Byte.parseByte("3"));
        ci5.setPosOID(Byte.parseByte("0"));
        ci5.setPosDesc(Byte.parseByte("1"));
        //Combo estado solicitud
        ComposerViewElement ci6 = new ComposerViewElement();
        ci6.setIDBusiness("PEDObtenerEstadosSolicitud");
        ci6.setDTOE(dtoBel);

        lista.addViewElement(ci1);
        lista.addViewElement(ci2);
        lista.addViewElement(ci3);
        lista.addViewElement(ci4);
        lista.addViewElement(ci5);
        lista.addViewElement(ci6);
        
        traza("saliendo de crearParamentrosEntrada");        
        return lista;
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

}
