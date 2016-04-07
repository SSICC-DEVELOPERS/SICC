import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.druida.DruidaConector;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesConcurso;
import es.indra.sicc.dtos.inc.DTOPlantilla;
import es.indra.sicc.dtos.inc.DTOParametrosConsultoras;
import es.indra.sicc.dtos.inc.DTOParametrosConsultorasRanking;
import es.indra.sicc.dtos.inc.DTOListaEstatusVenta;
import es.indra.sicc.dtos.inc.DTOEstatusVenta;
import es.indra.sicc.dtos.inc.DTOClasificacionParticipantes;
import es.indra.sicc.dtos.inc.DTOParticipante;
import es.indra.sicc.dtos.inc.DTOClasificacion;
import es.indra.sicc.dtos.inc.DTOMontoVentaRecomendadas;
import es.indra.sicc.dtos.inc.DTOListaMontoVentaRecomendadas;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer; 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.math.BigDecimal;
import es.indra.sicc.util.DTOOID;

public class LPMantenerParametrosConsultorasRanking  extends LPIncentivosRanking{
    
    private DTOListaEstatusVenta dtoListaEstatusVtaAuxiliar = new DTOListaEstatusVenta();
    private DTOListaMontoVentaRecomendadas dtoListaMVRAuxiliar = new DTOListaMontoVentaRecomendadas();
    private DTOClasificacionParticipantes dtoListaClasParticipantesAux = new DTOClasificacionParticipantes();
    private String valorOid = null;
    private String valorOidPart = null;
    private  int cantidad;  
    
    
    public LPMantenerParametrosConsultorasRanking() {
      super(); 
    }

    public void inicio() throws Exception {
        this.obtenerFlagsPestanyas();
        pagina("contenido_parametros_consultoras_ranking_mantener");        
        
        
        this.getFormatosValidaciones();
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();
        try{
            accion = conectorParametro("accion")==null?"":conectorParametro("accion");
            opcionMenu = conectorParametro("opcionMenu")==null?"":conectorParametro("opcionMenu");
            
            DTOConcurso dtoConcurso = this.getConcurso();
                      
            Long lMarca = UtilidadesSession.getMarcaPorDefecto(this);
            Long lCanal = UtilidadesSession.getCanalPorDefecto(this);
            traza(">>>> Entro a LPMantenerParametrosConsultorasRanking");        
            traza(">>>> Acción................" + accion);            
            traza(">>>> opcionMenu............" + opcionMenu);           
            traza(">>>> Marca................." + lMarca);            
            traza(">>>> Canal................." + lCanal);

            cargaConstantesEnPantalla();
            if (accion.equals("")){
                cargarPantalla();
            }
            else if (accion.equals("cargar estatus venta ranking")) {
                cargarPantallaEstatusVentaRanking(); 
            }
            else if (accion.equals("almacenar")) {                  
                almacenar();
                this.redirigir();
            }
           else if (accion.equals("cargar clasificacion participantes ranking")){
                cargarPantallaClasificacionParticipantesRanking(); 
           }
           
           else if (accion.equals("almacenar clasificacion participantes ranking")){
                pagina("salidaGenerica");	
				asignarAtributo("VAR", "cerrarVentana", "valor", "false");
                //String sLstClasifConsul = this.conectorParametroLimpia("hidLstClasConsul", "", true);  
                
                String sLstClasifConsul = this.conectorParametroLimpia("hidLstClasConsul", "", true);    
                String sListaClasif = this.conectorParametroLimpia("hidListaClasif", "", true);
                                                                   
            /*    traza("sLstClasifConsul: " + sLstClasifConsul);
                traza("sListaClasif: " + sListaClasif);*/
                
               // almacenarClasificacionParticipantesRanking(sLstClasifConsul, sListaClasif);
               almacenarClasificacionParticipantesRanking();
                asignarAtributo("VAR","ejecutar","valor","accionExitosa()");
                //asignarAtributo("VAR","ejecutarError","valor","accionError()");
            }
            else if (accion.equals("almacenar estatus venta ranking")){
                String sListaEstatusVta = this.conectorParametroLimpia("hidLstEstatusVta", "", true);                
                pagina("salidaGenerica");	
				asignarAtributo("VAR", "cerrarVentana", "valor", "false");

                almacenarEstatusVenta(sListaEstatusVta);
                asignarAtributo("VAR","ejecutar","valor","accionExitosa()");
                //asignarAtributo("VAR","ejecutarError","valor","accionError()");
            }
            
            else if (accion.equals("guardar")){
                almacenar(); 
                guardar();
            }
            else if (accion.equals("redirigir")){
                redirigir(); 
            }            
			else if(accion.equals("detalleParticipante")) {
				detalleParticipante();
			}
         
			if (opcionMenu.equals("Crear Concurso Ranking")){
              asignarAtributoPagina("cod", "0508");  
            }else if (opcionMenu.equals("Consultar Concurso Ranking")){
			// getConfiguracionMenu("LPMantenerParametrosConsultorasRanking","Consultar Concurso Ranking");
              asignarAtributoPagina("cod", "0525");
            }else if (opcionMenu.equals("Modificar Concurso Ranking")){
			//  getConfiguracionMenu("LPMantenerParametrosConsultorasRanking","Modificar Concurso Ranking");
              asignarAtributoPagina("cod", "0524");
            }
            
         }catch(Exception ex) {
            logStackTrace(ex);
            this.lanzarPaginaError(ex);
        }
  }//--fin de ejecucion


  private void logStackTrace(Throwable e) throws Exception {
       traza("Se produjo la excepcion, en LPMantenerParametrosConsultorasRanking: " + e.getMessage());
       ByteArrayOutputStream pila = new ByteArrayOutputStream();
       PrintStream out = new PrintStream(pila);
       
       if (e instanceof MareException){
         MareException e2=(MareException)e;
         traza("Es una mare Exception con codigo de error: "+e2.getCode());
       }
       
       e.printStackTrace(out);
       traza("stack Trace : " +  pila.toString());
  }
    
    public void cargarPantalla() throws Exception {
        traza("*********** Entro a cargarPantalla");
        this.cargarFlagsPestanyas();

		//Comienza Carga de combos
        DTOConcurso dtoConcurso = getConcurso();
		
        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoe.setOidPais(UtilidadesSession.getPais(this));

        DTOPeriodo dtop = new DTOPeriodo();
        dtop.setOidPais(UtilidadesSession.getPais(this));
        dtop.setMarca(dtoConcurso.getParamGenerales().getOidMarca());
        dtop.setCanal(dtoConcurso.getParamGenerales().getOidCanal());
       
        ComposerViewElementList cvEL = new ComposerViewElementList();
    
        ComposerViewElement ci1 = new ComposerViewElement();
        ci1.setIDBusiness("INCConsultaBasesCalculo");
        ci1.setDTOE(dtoe);		
        cvEL.addViewElement(ci1);               
    
        ComposerViewElement ci2 = new ComposerViewElement();
        ci2.setIDBusiness("INCConsultaTiposVenta");
        ci2.setDTOE(dtoe);		
        cvEL.addViewElement(ci2);
    
        ComposerViewElement ci3 = new ComposerViewElement();
        ci3.setIDBusiness("CRAObtienePeriodos");
        ci3.setDTOE(dtop);		
        cvEL.addViewElement(ci3);
        
        
        ConectorComposerView conector = new ConectorComposerView(cvEL, this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();

        asignar("COMBO", "cbBaseCalculo", resultados, "INCConsultaBasesCalculo");
        asignar("COMBO", "cbTipoVenta", resultados, "INCConsultaTiposVenta");
        asignar("COMBO", "cbPeriodoDesde", resultados, "CRAObtienePeriodos");
        asignar("COMBO", "cbPeriodoHasta", resultados, "CRAObtienePeriodos");
       
       //Comienza Seleccion del valor elegido en el combo base de calculo
        
        DTOParametrosConsultorasRanking dtoPC = new DTOParametrosConsultorasRanking();
        
        //Si es true el indicador de que ya se había rellenado la pestaña, se carga la página con esos datos 
        if (dtoConcurso.getIndConsultoras()!=null && dtoConcurso.getIndConsultoras().booleanValue() ){
         
            traza("Ya se habian cargado datos en la pestaña Consultora. IndConsultoras es TRUE");        
            asignarAtributo("VAR","hidIndConsultoras","valor", "1");
            
            dtoPC = dtoConcurso.getParamConsultorasRanking();
          
            
            //--Para seleccionar este valor en el combo
            if (dtoPC.getOidParametrosConsultoras() != null)
                asignarAtributo("VAR","oidParamConsultoras","valor", dtoPC.getOidParametrosConsultoras().toString());
        
            
            //--PAra seleccionar la base de calculo
            if (dtoPC.getOidBaseCalculo() != null) {
                Long lPConsultoraOidBC = dtoPC.getOidBaseCalculo();
                    
             //   traza("paramConsultoras.oidBaseCalculo   " + lPConsultoraOidBC.toString());
                asignarAtributo("VAR","oidBaseCalculo","valor", lPConsultoraOidBC.toString());
                        
                //Si dtoConcurso.paramConsultoras.oidBaseCalculo == ConstantesINC.OID_BASE_CALCULO_MONTO { 
                if (lPConsultoraOidBC.equals(ConstantesINC.OID_BASE_CALCULO_MONTO)){  
                    
                    //--Habilitar cbVenta
                    asignarAtributo("VAR","habilita","valor", "SI");        
                    
                    if (dtoPC.getOidTipoVenta() != null)
                        asignarAtributo("VAR","oidTipoVenta","valor", dtoPC.getOidTipoVenta().toString());
        
        
                }else if(lPConsultoraOidBC.equals(ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS)){  
                      asignarAtributo("VAR","habilitaPeriodos","valor", "SI");   
                    
                }
        
        
            } 
            
            if (dtoPC.getOidPeriodoDesde()!=null){
                asignarAtributo("VAR","oidPerDesde","valor", dtoPC.getOidPeriodoDesde().toString());   
            }
            
            if (dtoPC.getOidPeriodoHasta() !=null){
                asignarAtributo("VAR","oidPerHasta","valor", dtoPC.getOidPeriodoHasta().toString());   
            }
            
            
    
        }// si no hay información en el dto 
        else{
             dtoPC.setOidParametrosConsultoras(null);
             dtoConcurso.setParamConsultorasRanking(dtoPC);
        }
       
        if (dtoConcurso.getClasificParticipantes()!= null) {
             dtoListaClasParticipantesAux = dtoConcurso.getClasificParticipantes();
             this.getSessionCache().put("dtoLstClasParG", dtoListaClasParticipantesAux);
        } else{
                dtoListaClasParticipantesAux = null;
                this.getSessionCache().put("dtoLstClasParG", dtoListaClasParticipantesAux);
        }
       
        if (dtoConcurso.getEstatusVenta() != null){
			dtoListaEstatusVtaAuxiliar = dtoConcurso.getEstatusVenta();
            this.getSessionCache().put("dtoLstEVta", dtoListaEstatusVtaAuxiliar);
        }else{
            dtoListaEstatusVtaAuxiliar = null;
            this.getSessionCache().put("dtoLstEVta", dtoListaEstatusVtaAuxiliar);
        
        }
       
       
          
        asignarAtributo("VAR","opcionMenu","valor", this.opcionMenu);        
        asignarAtributo("VAR","accion","valor", this.accion);

        getConfiguracionMenu("LPMantenerParametrosConsultorasRanking","");
    }
    
    public void cargarPantallaEstatusVentaRanking() throws Exception{
    
        traza("Entrando a cargarPantallaEstatusVentaRanking");
        pagina("contenido_estatus_venta_ranking_mantener");
        getConfiguracionMenu("LPMantenerParametrosConsultorasRanking","cargarEstatusVentaRanking");
        
        
        DTOConcurso concurso = this.getConcurso();

        DTOBelcorp dtob = new DTOBelcorp();
        dtob.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtob.setOidPais(UtilidadesSession.getPais(this));
        
        DTOPeriodo dtop = new DTOPeriodo();
        dtop.setOidPais(UtilidadesSession.getPais(this));
        dtop.setMarca(concurso.getParamGenerales().getOidMarca());
        dtop.setCanal(concurso.getParamGenerales().getOidCanal());

        ComposerViewElementList cvEL = new ComposerViewElementList();
        ComposerViewElement c1i = new ComposerViewElement();
        c1i.setIDBusiness("MAEObtenerEstatusCliente");
        c1i.setDTOE(dtob);		
        cvEL.addViewElement(c1i);

        ComposerViewElement cvePD = new ComposerViewElement();
        cvePD.setIDBusiness("CRAObtienePeriodos");
        cvePD.setDTOE(dtop);
        cvEL.addViewElement(cvePD);
        
        
        ConectorComposerView conector = new ConectorComposerView(cvEL, this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();
        
        //Cargamos los combos con los resultados
        asignar("COMBO", "cbEstatusVentaMAE", resultados, "MAEObtenerEstatusCliente");
        asignar("COMBO", "cbPeriodoDesde", resultados, "CRAObtienePeriodos");
        asignar("COMBO", "cbPeriodoHasta", resultados, "CRAObtienePeriodos");        
        
        dtoListaEstatusVtaAuxiliar = (DTOListaEstatusVenta)this.getSessionCache().get("dtoLstEVta");
         
        traza("dtoListaEstatusVtaAuxiliar - " +  dtoListaEstatusVtaAuxiliar);
            
        
        if (dtoListaEstatusVtaAuxiliar !=null){
            String sListaEstatusVenta = CargarListaEstatusVenta(dtoListaEstatusVtaAuxiliar);
            
            traza("CUANDO CARGA LA PANTALLA DE ESTATUS VENTA");
            traza("------------------------------------------");
            traza("EL VALOR DE LA LISTA ES :::: " + sListaEstatusVenta);
            asignarAtributo("VAR","hidLstEstatusVta","valor", sListaEstatusVenta);
        
        
            //Solo se actualiza el indicador si realmente se ingresó a la pestaña
            String sIngresoEVTA = conectorParametro("hidIngresoEVTA")==null?"":conectorParametro("hidIngresoEVTA");
            traza("****sIngresoEVTA ***" + sIngresoEVTA);
            
            if (!sIngresoEVTA.equals("")){
                if (sIngresoEVTA.equals("1")){
                traza("Se actualiza indicador de Estatus Venta");
                    concurso.setIndEstatusVenta(Boolean.TRUE);
                }
            }

        
        
        }
        
        if (this.opcionMenu!= null){
            asignarAtributo("VAR","opcionMenu","valor", this.opcionMenu);
        }
        asignarAtributo("VAR","accion","valor", this.accion);
    }
    
	public void almacenar() throws Exception {
  
  
        Long lOidBaseCalcSel =  null;
        DTOConcurso concurso = getConcurso(); 		
        String sListaEstVta = this.conectorParametroLimpia("hidLstEstatusVta", "", true);        
        traza("sListaEstVta ** " + sListaEstVta);
        
        //--Guardo la lista Estatus Venta
        if (!sListaEstVta.equals("")) {
            concurso.setEstatusVenta(null);
            almacenarEstatusVenta(sListaEstVta);
            concurso.setEstatusVenta(dtoListaEstatusVtaAuxiliar);
        }else {
	          dtoListaEstatusVtaAuxiliar = null;                        
              this.getSessionCache().put("dtoLstEVta", dtoListaEstatusVtaAuxiliar);
        }
        
        //--Lista de Clasificacion Participantes
        String sListaClas = this.conectorParametroLimpia("dtoLstClasParG", "", true);
        String sLstClasifConsul = this.conectorParametroLimpia("hidLstClasConsul", "", true);
        traza("Lista Clasif   " + sListaClas);
        traza("Lista Clasif Consul   " + sLstClasifConsul);
        
        if (!sListaClas.equals("") || !sLstClasifConsul.equals("")) {
            concurso.setClasificParticipantes(null);
            //almacenarClasificacionParticipantesRanking(sLstClasifConsul, sListaClas);
            almacenarClasificacionParticipantesRanking();
            concurso.setClasificParticipantes(dtoListaClasParticipantesAux);
        }
        
        if (!sLstClasifConsul.equals("")){
                concurso.setIndClasificacionParticipantes(Boolean.TRUE);
        }        
        
        //Solo se actualiza el indicador si realmente se ingresó a la pestaña
        String sIngresoEVTA = conectorParametro("hidIngresoEVTA")==null?"":conectorParametro("hidIngresoEVTA");
        traza("****sIngresoEVTA ***" + sIngresoEVTA);
        
        if (!sIngresoEVTA.equals("")){
            if (sIngresoEVTA.equals("1")){
            traza("Se actualiza indicador de Estatus Venta");
                concurso.setIndEstatusVenta(Boolean.TRUE);
            }
        }

        
        String sOidBaseCalculo = conectorParametro("cbBaseCalculo")==null?"":conectorParametro("cbBaseCalculo");
        if (!sOidBaseCalculo.equals("") ) {
            lOidBaseCalcSel =  new Long(sOidBaseCalculo);
            
            if (lOidBaseCalcSel.equals(ConstantesINC.OID_BASE_CALCULO_MONTO)){
                
                String oidTipoVen = conectorParametro("cbTipoVenta")==null?"":conectorParametro("cbTipoVenta");
                
                if ((oidTipoVen !=null) && (oidTipoVen.length()>0))
                      concurso.getParamConsultorasRanking().setOidTipoVenta(Long.valueOf(oidTipoVen));           
                
                concurso.getParamConsultorasRanking().setOidPeriodoDesde(null);
                concurso.getParamConsultorasRanking().setOidPeriodoHasta(null);
            
            } //--En otro caso si oid del valor seleccionado en cbBaseCalculo != OID_BASE_CALCULO_MONTO
            else{
                concurso.getParamConsultorasRanking().setOidTipoVenta(null);
                
                if (lOidBaseCalcSel.equals(ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS)){
                    String desde = conectorParametro("cbPeriodoDesde")==null?"":conectorParametro("cbPeriodoDesde");
                    
                    
                    if ((desde!=null) && (desde.length()>0)){
                        String hasta = conectorParametro("cbPeriodoHasta")==null?"":conectorParametro("cbPeriodoHasta");
                        if ((hasta!=null) && (hasta.length()>0)){
                             concurso.getParamConsultorasRanking().setOidPeriodoDesde(Long.valueOf(desde));
                             concurso.getParamConsultorasRanking().setOidPeriodoHasta(Long.valueOf(hasta));
                         } 
                    }
                }//--En otro si el oid seleccionado en cbBaseCalculo != OID_BASE_CALCULO_RECOMENDADAS
                else{
                    concurso.getParamConsultorasRanking().setOidPeriodoDesde(null);
                    concurso.getParamConsultorasRanking().setOidPeriodoHasta(null);
                }
            }
          
            Boolean bValor = new Boolean(conectorParametro("datosObligatorios"));
            concurso.setIndObligConsultoras(bValor);
            
            // Verifica si hay que registros en la base de datos
            opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
            
            if(opcionMenu.equals("Modificar Concurso Ranking") && !bValor.booleanValue()) {
                traza("borra cons");
                concurso.setIndBorradoConsultorasRanking(Boolean.TRUE);
            }

            String sOidCon = conectorParametro("oidParamConsultoras")==null?"":conectorParametro("oidParamConsultoras");
            String sOidTipoVta = conectorParametro("oidTipoVenta")==null?"":conectorParametro("oidTipoVenta");
           
        
            DTOParametrosConsultorasRanking dtoPC = concurso.getParamConsultorasRanking();
      
            if (dtoPC == null)
              dtoPC = new DTOParametrosConsultorasRanking();
            
            if (!sOidCon.equals(""))
              dtoPC.setOidParametrosConsultoras(Long.valueOf(sOidCon));
           
                
            if (!sOidBaseCalculo.equals(""))
              dtoPC.setOidBaseCalculo(Long.valueOf(sOidBaseCalculo));
          
            if (!sOidTipoVta.equals(""))    
              dtoPC.setOidTipoVenta(Long.valueOf(sOidTipoVta));
           
             
            concurso.setParamConsultorasRanking(dtoPC);  
	  
        }
       
        concurso.setIndConsultoras(Boolean.TRUE);
        traza("aca**** antes de grabar "  + concurso );
        traza("saliendo de almacenar");
        setConcurso(concurso);
    }
    
	public void almacenarEstatusVenta(String sListaEstatusVta) throws Exception {
		traza(" Entrando a almacenarEstatusVenta ");
        traza("Lista Estatus Venta   " + sListaEstatusVta);

        ArrayList arrEV =  null;
        arrEV = aplanarEstatusVenta(sListaEstatusVta);
        dtoListaEstatusVtaAuxiliar.setEstatusVenta(arrEV);
        
        //--para limpiar la lista
        
        //--
        this.getSessionCache().put("dtoLstEVta", dtoListaEstatusVtaAuxiliar);        
    }
    
    
    private void cargaConstantesEnPantalla() throws Exception{
  
        asignarAtributo("VAR","oidBC_Recomendada","valor",ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.toString());
        asignarAtributo("VAR","oidBC_Calculo_Monto","valor", ConstantesINC.OID_BASE_CALCULO_MONTO.toString());
     
    }  
    
 
    private String CargarListaEstatusVenta(DTOListaEstatusVenta dtoEstatusVenta) throws Exception {
        traza("Entrando a CargarListaEstatusVenta");    
        ArrayList arEsVta = dtoEstatusVenta.getEstatusVenta();
        int iIndice = 0;
     
        Iterator itEsVta = arEsVta.iterator();
        String sLstPlana = new String();
      
        while (itEsVta.hasNext()){
            DTOEstatusVenta dtoE =  (DTOEstatusVenta)itEsVta.next();
            
            String sEstVta = iIndice + "|";
            sEstVta = sEstVta +dtoE.getOidEstatus() + "|";
            sEstVta = sEstVta + dtoE.getOidEstatusVentaMae() + "|";
            sEstVta = sEstVta + dtoE.getOidPeriodoDesde() + "|";
            sEstVta = sEstVta + dtoE.getOidPeriodoHasta() + "|";
            
            sEstVta = sEstVta + dtoE.getDesEstatus() + "|";
            sEstVta = sEstVta + dtoE.getDesPeriodoDesde() + "|";
            sEstVta = sEstVta + dtoE.getDesPeriodoHasta() + "$";

            traza("OID Status       "  + dtoE.getOidEstatus());
            traza("OID Vta MAE      "  + dtoE.getOidEstatusVentaMae());
            traza("OID PeriodoD     "  + dtoE.getOidPeriodoDesde());
            traza("OID PeriodoH     "  + dtoE.getOidPeriodoHasta());

            traza("Desc Status      "  + dtoE.getDesEstatus());
            traza("Desc PeriodoD    "  + dtoE.getDesPeriodoDesde());
            traza("Desc PeriodoH    "  + dtoE.getDesPeriodoHasta());
            
            sLstPlana = sLstPlana+ sEstVta;
            iIndice ++;
       }
    traza("Mandando a sesion   " + sLstPlana);        
    return sLstPlana;
  }

     
    ArrayList aplanarEstatusVenta(String listado) throws Exception {
        traza("Entre a aplanarEstatusVenta -----------------------");
        
        traza("QUE LISTA VA A APLANAR ???? " + listado);

        StringTokenizer stRows = new StringTokenizer(listado, "$");
        int rowCount = stRows.countTokens();
        ArrayList lstClasPart = new ArrayList ();
        
       for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
            DTOEstatusVenta dtoE=  new DTOEstatusVenta();
            dtoE.setOidIdioma(UtilidadesSession.getIdioma(this));
            dtoE.setOidPais(UtilidadesSession.getPais(this));
            StringTokenizer stColss = new StringTokenizer(stRows.nextToken(), "|");
          
            for(int conta =  0 ;stColss.hasMoreTokens(); conta++){								
                StringTokenizer stCols = new StringTokenizer(stColss.nextToken(), ":");
              
                for(int contad =  0 ;stCols.hasMoreTokens(); contad++){                  
         
         
                    String desc = stCols.nextToken().toString();
                    String valor = stCols.nextToken().toString();
                    traza("--> " + desc + " " + valor);
                    if ( desc.equals("oEv") ){
                        if (valor!= null && !valor.equals("null"))
                            dtoE.setOidEstatus(new Long(valor));
                    }
                    if ( desc.equals("oEM") ){
                        if (valor!= null && !valor.equals(""))
                            dtoE.setOidEstatusVentaMae(new Long(valor));
                    }
                    if ( desc.equals("oPd") ){
                        if (valor!= null && !valor.equals(""))
                            dtoE.setOidPeriodoDesde(new Long(valor));
                    }
                    if ( desc.equals("oPh") ){
                        if (valor!= null )
                            dtoE.setOidPeriodoHasta(new Long(valor));
                    }
                    if ( desc.equals("dEv") ){
                        if (valor!= null)
                            dtoE.setDesEstatus(valor);
                    }
                    if ( desc.equals("dPd") ){
                        if (valor!= null)
                            dtoE.setDesPeriodoDesde(valor);
                    }
                    if ( desc.equals("dPh") ){
                        if (valor!= null)
                            dtoE.setDesPeriodoHasta(valor);
                    }  
                }
            }
         
         traza("DTO CLAS     " + dtoE);
         lstClasPart.add(dtoE);
        }
        return  lstClasPart;
  }

 
 public void cargarPantallaClasificacionParticipantesRanking() throws Exception{         
    traza("Entrando a cargarPantallaClasificacionParticipantes");     

    DTOConcurso concurso = getConcurso();
    
    pagina("contenido_participantes_seleccionar_ranking");  
    getConfiguracionMenu("LPMantenerParametrosGerentesRanking", "cargar clasificacion participantes ranking");
        
    dtoListaClasParticipantesAux = (DTOClasificacionParticipantes)this.getSessionCache().get("dtoLstClasParG");
     
    traza("dtoListaClasParticipantesAux --" + dtoListaClasParticipantesAux);
   
    if (dtoListaClasParticipantesAux != null ){
        if (dtoListaClasParticipantesAux.getLstClasificacionParticipantes()!= null){
            ArrayList arrClasPar;
            arrClasPar = dtoListaClasParticipantesAux.getLstClasificacionParticipantes();
            String sLstClasPlana = cargarClasificacionParticipantesRanking(arrClasPar);
            traza("sLstClasPlana " + sLstClasPlana);
            asignarAtributo("VAR","lstClasificacionParticipantesConsultoras","valor", sLstClasPlana);
        }
    
        if (dtoListaClasParticipantesAux.getLstParticipantes()!= null){
            ArrayList arrPartic = dtoListaClasParticipantesAux.getLstParticipantes();
            String sLstPlana = cargarParticipantesRanking(arrPartic);
            traza("sLstPlana " + sLstPlana);
            asignarAtributo("VAR","lstClasificacionParticipantes","valor", sLstPlana);
        }
        
        
        
   } 
   
        
   if (opcionMenu!= null){
            asignarAtributo("VAR","opcionMenu","valor", this.opcionMenu);
   }
   
   asignarAtributo("VAR","accion","valor", this.accion);
   getConfiguracionMenu("LPMantenerParametrosConsultorasRanking","cargarClasificacionParticipantesRanking");
        
}


 ArrayList aplanarClasificacionParticipantesRanking(String listado) throws Exception{
      
     traza("* Entre a aplanarClasificacionParticipantesRanking " + listado);
     
     StringTokenizer stRows = new StringTokenizer(listado, "$");
     int rowCount = stRows.countTokens();
     ArrayList lstClasPart = new ArrayList ();
       
     for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
      
         DTOClasificacion dtoC = new DTOClasificacion();
         dtoC.setOidIdioma(UtilidadesSession.getIdioma(this));
         dtoC.setOidPais(UtilidadesSession.getPais(this));
      
         StringTokenizer stColss = new StringTokenizer(stRows.nextToken(), "|");
         for(int conta =  0 ;stColss.hasMoreTokens(); conta++){								
             StringTokenizer stCols = new StringTokenizer(stColss.nextToken(), ":");				

             for(int contad =  0 ;stCols.hasMoreTokens(); contad++){
                 String desc = stCols.nextToken().toString();
                 String valor = stCols.nextToken().toString();
                   
                 traza("desc  " + desc + "  valor   " + valor);                
                   
                 if(desc.equals("oPc")){
                     if (valor!= null && !valor.equals("null")){
                         dtoC.setOidClasificacionParticipante(Long.valueOf(valor));
                     }
                 }
                   
                 if(desc.equals("oPar")){
                     if (valor != null){
                         dtoC.setOidParticipante(Long.valueOf(valor));
                     }    
                 }
                    
                 if(desc.equals("desc")){
                     dtoC.setDescripcion(valor);
                 }      
             }
         }
         lstClasPart.add(dtoC);
    }
    return  lstClasPart;

 }



 public String cargarClasificacionParticipantesRanking(ArrayList arrClasPar) throws Exception{
     
     traza("Cargando lstClasificacionParticipantesConsultoras" );       
     Iterator ClasificPart = arrClasPar.iterator();
     
     traza("ClasificPart " + ClasificPart);
     
     String sLstClasPlana = new String();
     int iIndice = 0;
        
     while (ClasificPart.hasNext()){
        DTOClasificacion dtoP =  (DTOClasificacion)ClasificPart.next();
        traza("OID Clasif. Participante " + dtoP.getOidClasificacionParticipante());
        traza("OID Participante         " + dtoP.getOidParticipante());
        traza("Descripcion              " + dtoP.getDescripcion());
                        
        String sClasificacion = iIndice + "|";
        sClasificacion = sClasificacion + dtoP.getOidClasificacionParticipante()  + "|";
        sClasificacion = sClasificacion + dtoP.getOidParticipante()  + "|";
        sClasificacion = sClasificacion + dtoP.getDescripcion() + "$";
            
        sLstClasPlana = sLstClasPlana + sClasificacion;
        iIndice++;
    }
    
    traza("Mandando a Sesion sLstClasPlana  " +  sLstClasPlana);
    return sLstClasPlana;
  }

 public String cargarParticipantesRanking(ArrayList arrParticipantes) throws Exception{
    
     traza("Entrando a cargarParticipantesRanking" );
     Iterator ClasificPart = arrParticipantes.iterator();
     String sLstParticipantesPlana = new String();
    
     int iIndice = 0;
     while (ClasificPart.hasNext()){
         DTOParticipante dtoP =  (DTOParticipante)ClasificPart.next();
         traza("OID          " + dtoP.getOid());
         traza("Descripcion  " + dtoP.getDescripcion());
           
         String sParticipantes = dtoP.getOid()  + "|";
         sParticipantes = sParticipantes + dtoP.getDescripcion() + "$";
            
         sLstParticipantesPlana = sLstParticipantesPlana + sParticipantes;
         iIndice++;
      }
   
      traza("Mandando a Sesion   " +  sLstParticipantesPlana);
      return sLstParticipantesPlana;
 }
     
 ArrayList aplanarParticipantes(String listado) throws Exception{
       
     traza("**** Entre a aplanarParticipantes " + listado);
    
     StringTokenizer stRows = new StringTokenizer(listado, "$");
     int rowCount = stRows.countTokens();
     ArrayList lstClasPart = new ArrayList ();
        
     for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
         DTOParticipante dto = new DTOParticipante();
         dto.setOidIdioma(UtilidadesSession.getIdioma(this));
         dto.setOidPais(UtilidadesSession.getPais(this));
         StringTokenizer stColss = new StringTokenizer(stRows.nextToken(), "|");
         
         for(int conta =  0 ;stColss.hasMoreTokens(); conta++) {								
             StringTokenizer stCols = new StringTokenizer(stColss.nextToken(), ":");				

             for(int contad =  0 ;stCols.hasMoreTokens(); contad++){
                 String desc = stCols.nextToken().toString();
                 String valor = stCols.nextToken().toString();
                
                 traza("desc  " + desc + "  valor   " + valor);                
                
                 if(desc.equals("oPar")){
                     dto.setOid(Long.valueOf(valor));
                  }  
                  
                 if(desc.equals("desc")){
                    dto.setDescripcion(valor);
                 }  
                  
             }
          }
          lstClasPart.add(dto);
     }
        
      traza("sale de aplanarParticipantes");
      return  lstClasPart;
  }
    
     public void almacenarClasificacionParticipantesRanking() throws Exception{

     dtoListaClasParticipantesAux.setLstClasificacionParticipantes(null);
     dtoListaClasParticipantesAux.setLstParticipantes(null);

    
     String sLstClasifConsul = conectorParametro("hidLstClasConsul")==null?"":conectorParametro("hidLstClasConsul");
       
     if (sLstClasifConsul!= null){
         ArrayList lstClasPart = new ArrayList();
         traza("Procesando Participantes Consultoras   "  + sLstClasifConsul);
         lstClasPart = aplanarClasificacionParticipantesRanking(sLstClasifConsul);
         dtoListaClasParticipantesAux.setLstClasificacionParticipantes(lstClasPart);
     }
               
  
     String sListaClasif = conectorParametro("hidListaClasif")==null?"":conectorParametro("hidListaClasif");
     if (sListaClasif != null){
         ArrayList lstClasif = new ArrayList();
         traza("Procesando Clasificacion Participantes   " + sListaClasif);
         lstClasif = aplanarParticipantes(sListaClasif);
            
         dtoListaClasParticipantesAux.setLstParticipantes(lstClasif);
     }
       
    this.getSessionCache().put("dtoLstClasParG", dtoListaClasParticipantesAux);
 }

     public void detalleParticipante() throws Exception {
		traza("LPMantenerParametrosConsultorasRanking.detalleParticipante() - Entrada");
		pagina("salidaGenerica");
        this.asignarAtributo("VAR", "cerrarVentana", "valor", "false"); 

        String codigo = this.conectorParametroLimpia("codigo", "", true);    
		
		DTOOID dtoe = new DTOOID();
		dtoe.setOid(new Long(codigo));
		dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoe.setOidPais(UtilidadesSession.getPais(this));		

  	    MareBusinessID businessID = new MareBusinessID("INCObtenerDetalleParticipantes");
		Vector parametros = new Vector();
		parametros.add(dtoe);
		parametros.add(businessID);

		try {
	        traza("******************* Antes de conectar");			
			DruidaConector con = conectar("ConectorObtenerDetalleParticipantes", parametros);
			traza("******************* Despues de conectar");

			DTOSalida dtoSalida = (DTOSalida)con.objeto("dtoSalida");	
			traza("******************* rs: " + dtoSalida.getResultado());

			String strDetalle = transformarRecordSetToString(dtoSalida.getResultado());
			traza("******************* strDetalle: " + strDetalle);
			
			traza("LPMantenerParametrosConsultorasRanking.detalleParticipante() - Salida");
			asignarAtributo("VAR", "ejecutar", "valor", "asignarDetalle('" + strDetalle + "');");
	    }
        catch(Exception e) {
			traza("******************* Entrando al catch...");
			traza("LPMantenerParametrosConsultorasRanking.detalleParticipante() - Salida");
			asignarAtributo("VAR", "ejecutarError", "valor", "asignarDetalleERR()");  
			throw e;
		}     
	}

	private String transformarRecordSetToString(RecordSet rs) throws Exception  {
		traza("LPMantenerParametrosConsultorasRanking.transformarRecordSetToString(RecordSet rs) - Entrada");
		String cadena = "";
		
		for(int i=0; i<rs.getRowCount(); i++){
 			BigDecimal oid = (BigDecimal)rs.getValueAt(i,"OID_PART_CONC_CABE");
			BigDecimal valGrup = (BigDecimal)rs.getValueAt(i,"VAL_GRUP_CLIE");
 			String tipoClie = (String)rs.getValueAt(i,"TIPOCLIENTE");

			String subtipoClie = (String)rs.getValueAt(i,"SUBTIPOCLIENTE");
			if(subtipoClie==null) subtipoClie = "";

 			String clasi = (String)rs.getValueAt(i,"CLASIFICACION");
			if(clasi==null) clasi = "";

			String tipoClasi = (String)rs.getValueAt(i,"TIPOCLASIFICACION");
			if(tipoClasi==null) tipoClasi = "";
			
			if(i==0) {
				cadena = cadena + oid + "," + valGrup + "," + tipoClie + "," 
								+ subtipoClie + "," + clasi + "," + tipoClasi;
			}
			else {
				cadena = cadena + "|" + oid + "," + valGrup + "," + tipoClie + "," 
								+ subtipoClie + "," + clasi + "," + tipoClasi;
			}					
		}
		
		traza("*************** cadena " + cadena);
		traza("LPMantenerParametrosConsultorasRanking.transformarRecordSetToString(RecordSet rs) - Salida");
		return cadena;
	}
}