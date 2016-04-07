package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.correo.DTOCorreoElectronico;
import es.indra.sicc.cmn.negocio.correo.MONServicioCorreoElectronico;
import es.indra.sicc.cmn.negocio.correo.MONServicioCorreoElectronicoHome;
import es.indra.sicc.dtos.ape.DTOAnaqueles;
import es.indra.sicc.dtos.ape.DTOBalanceoLinea;
import es.indra.sicc.dtos.ape.DTOEstimadoSublinea;
import es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles;
import es.indra.sicc.dtos.ape.DTONumeroZonasSublineas;
import es.indra.sicc.dtos.ape.DTOPorcentajeSublinea;
import es.indra.sicc.dtos.ape.DTOSublineaEvaluarCarga;
import es.indra.sicc.dtos.ape.DTOUnidadesProducto;
import es.indra.sicc.dtos.ape.DTOUnidadesSublineas;
import es.indra.sicc.dtos.ape.DTOUnidadesZonasSublineas;
import es.indra.sicc.dtos.ape.DTOZonasEvaluarCarga;
import es.indra.sicc.entidades.ape.AsignacionProductoAnaquelCabeceraLocal;
import es.indra.sicc.entidades.ape.AsignacionProductoAnaquelCabeceraLocalHome;
import es.indra.sicc.entidades.ape.AsignacionProductoAnaquelDetalleLocal;
import es.indra.sicc.entidades.ape.AsignacionProductoAnaquelDetalleLocalHome;
import es.indra.sicc.entidades.ape.LineaArmadoLocal;
import es.indra.sicc.entidades.ape.LineaArmadoLocalHome;
import es.indra.sicc.entidades.ape.UsuarioAlarmaLineaLocal;
import es.indra.sicc.entidades.ape.UsuarioAlarmaLineaLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;

public class MONBalanceoLineaBean implements SessionBean {
    private SessionContext ctx;    
    public void ejbCreate() { }
    public void ejbActivate() {  }
    public void ejbPassivate()  {   }
    public void ejbRemove()  {   }
    public void setSessionContext(SessionContext ctx) { this.ctx = ctx; }

  /** 
   * Autor: Cristian Valenzuela
   * Fecha: 21/2/2007
   */
    public DTOSalida obtenerOrdenacionProductos(DTOBelcorp dtoe) throws MareException {            
        UtilidadesLog.info("MONBalanceoLineaBean.obtenerOrdenacionProductos"+
        "(DTOBelcorp dtoe): Entrada");
        DAOBalanceoLinea dao = new DAOBalanceoLinea();            
        DTOSalida dtoSalida = dao.obtenerOrdenacionProductos(dtoe);
        UtilidadesLog.info("MONBalanceoLineaBean.obtenerOrdenacionProductos"+
        "(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }

  /** 
   * Autor: Cristian Valenzuela
   * Fecha: 21/2/2007
   */
    public DTOSalida obtenerOrigenDatos(DTOBelcorp dtoe) throws MareException {            
        UtilidadesLog.info("MONBalanceoLineaBean.obtenerOrigenDatos"+
        "(DTOBelcorp dtoe): Entrada");
        DAOBalanceoLinea dao = new DAOBalanceoLinea();            
        DTOSalida dtoSalida = dao.obtenerOrigenDatos(dtoe);
        UtilidadesLog.info("MONBalanceoLineaBean.obtenerOrigenDatos"+
        "(DTOBelcorp dtoe): Salida");
        return dtoSalida;        
    }
    
   /** 
    * Autor: Cristian Valenzuela
    * Fecha: 26/2/2007
    */
    public DTOBalanceoLinea ejecutarBalanceo(DTOBalanceoLinea dtoe) throws MareException {
        UtilidadesLog.info("MONBalanceoLineaBean.ejecutarBalanceo"+
        "(DTOBalanceoLinea dtoe): Entrada");
        
        UtilidadesLog.debug("****** DTOBalanceoLinea (Entrada)" + dtoe);
        
        try {
            AsignacionProductoAnaquelCabeceraLocalHome apaclh = new AsignacionProductoAnaquelCabeceraLocalHome();    
            AsignacionProductoAnaquelCabeceraLocal apacl = apaclh.findByPrimaryKey(dtoe.getOidAsignacionProductosAnaqueles());
            
            if(apacl!=null) {
                UtilidadesLog.debug("****** Llamando a eliminarBalanceoPrevio");
                
                // vbongiov -- BELC400000594 -- 13/08/2007
                dtoe.setOidMapaZonas(apacl.getMapaZonaCabecera());
                UtilidadesLog.debug("asignar mapa zona: " + dtoe);
                
                this.eliminarBalanceoPrevio(dtoe.getOidAsignacionProductosAnaqueles());
                //Gpons-Inc. BELC400000163: Se elimina indicador Estado de la cabecera
                //apacl.setEstado(ConstantesAPE.COD_BALANCEO);
            }
            else {                
                UtilidadesLog.debug("****** Llamando al create de AsignacionProductoAnaquelCabecera");
                //Gpons-Inc. BELC400000163: Se elimina indicador Estado de la cabecera
                AsignacionProductoAnaquelCabeceraLocal apacl2;
                try {
                    apacl2 = apaclh.create(dtoe.getVersion(), 
                        new String("N"), dtoe.getOidPeriodo(), 
                        dtoe.getOidMapaCentroDistribucion(), dtoe.getOidMapaZonas());
                } catch (EntityExistsException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Error en create: ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Error en create: ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
                dtoe.setOidAsignacionProductosAnaqueles(apacl2.getOid());                
            }
            
            UtilidadesLog.debug("****** Llamando a ordenarProductos");
            dtoe = this.ordenarProductos(dtoe);
            UtilidadesLog.debug("****** Llamando a ordenarAnaqueles");
            dtoe = this.ordenarAnaqueles(dtoe);
            UtilidadesLog.debug("****** Llamando a distribuirProductosMatching");
            dtoe = this.distribuirProductosMatching(dtoe);
            UtilidadesLog.debug("****** Llamando a evaluarCarga");
            dtoe = this.evaluarCarga(dtoe);
        }
        catch (NoResultException e) {
            UtilidadesLog.error("ERROR ", e);
            ctx.setRollbackOnly();
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      } 
        
        UtilidadesLog.debug("****** DTOBalanceoLinea (Salida)" + dtoe);        
        UtilidadesLog.info("MONBalanceoLineaBean.ejecutarBalanceo"+
        "(DTOBalanceoLinea dtoe): Salida");    
        return dtoe;
    }
    
    /** 
    * Autor: Cristian Valenzuela
    * Fecha: 02/03/2007
    */
    public DTOBalanceoLinea ordenarProductos(DTOBalanceoLinea dtoe) throws MareException  {                
        UtilidadesLog.info("MONBalanceoLineaBean.ordenarProductos"+
        "(DTOBelcorp dtoe): Entrada");        
        DAOBalanceoLinea dao = new DAOBalanceoLinea();            
        DTOSalida dtoSalida = dao.ordenarProductos(dtoe);    
        
        ArrayList listaProductos = new ArrayList();
        RecordSet rs = dtoSalida.getResultado();
        int cant = rs.getRowCount();
        UtilidadesLog.debug("*** cant:" + cant);
        
        for(int i=0; i<cant; i++)  {
            DTOUnidadesProducto dto = new DTOUnidadesProducto();
            
            BigDecimal oidProducto = (BigDecimal)rs.getValueAt(i, "OIDPRODUCTO");
            BigDecimal unidadesEstimadas = (BigDecimal)rs.getValueAt(i, "UNIDADESESTIMADAS");
            String asignado = (String)rs.getValueAt(i, "ASIGNADO");
            BigDecimal oidSublinea = (BigDecimal)rs.getValueAt(i, "OIDSUBLINEA");
            
            if(oidProducto!=null) {
                dto.setOidProducto(new Long(oidProducto.longValue()));    
            }
            
            if(unidadesEstimadas!=null) {
                dto.setUnidadesEstimadas(new Long(unidadesEstimadas.longValue()));    
            }
            
            if(asignado!=null && asignado.equalsIgnoreCase("true")) {
                dto.setAsignado(Boolean.TRUE);
            }
            else {
                dto.setAsignado(Boolean.FALSE);
            }
            
            if(oidSublinea!=null) {
                dto.setOidSublinea(new Long(oidSublinea.longValue()));    
            }     

            listaProductos.add(dto);
        } 
        
        dtoe.setListaProductos(listaProductos);
        UtilidadesLog.info("MONBalanceoLineaBean.ordenarProductos"+
        "(DTOBelcorp dtoe): Salida");
        return dtoe;                    
    }

    /** 
    * Autor: Cristian Valenzuela
    * Fecha: 02/03/2007
    */
    public DTOBalanceoLinea ordenarAnaqueles(DTOBalanceoLinea dtoe) throws MareException  {        
        UtilidadesLog.info("MONBalanceoLineaBean.ordenarAnaqueles"+
        "(DTOBelcorp dtoe): Entrada");        
        ArrayList listaAnaqueles = new ArrayList();
        
        DAOBalanceoLinea dao = new DAOBalanceoLinea();            
        DTOSalida dtoSalida = dao.ordenarAnaqueles(dtoe);                
        
        RecordSet rs = dtoSalida.getResultado();
        int cant = rs.getRowCount();
        UtilidadesLog.debug("*** cant:" + cant);
        
        for(int i=0; i<cant; i++) {
            DTOAnaqueles dto = new DTOAnaqueles();
    
            BigDecimal oidSublinea = (BigDecimal)rs.getValueAt(i, "OID_SUBL_ARMA");
            BigDecimal oidMapa = (BigDecimal)rs.getValueAt(i, "MCDD_OID_MAPA_CENT_DIST_DETA");
            BigDecimal oidAnaquelDetalle = (BigDecimal)rs.getValueAt(i, "OID_ORDE_ANAQ_DETA");
            
            if(oidSublinea!=null) {
                dto.setOidSublinea(new Long(oidSublinea.longValue()));    
            }
            
            if(oidMapa!=null)  {
                dto.setOidMapaCentroDistribucionDetalle(new Long(oidMapa.longValue()));    
            }
            
            if(oidAnaquelDetalle!=null) {
                dto.setOidAnaquelDetalle(new Long(oidAnaquelDetalle.longValue()));    
            }     
            
            listaAnaqueles.add(dto);
        }        
        
        dtoe.setListaAnaqueles(listaAnaqueles);    
        UtilidadesLog.info("MONBalanceoLineaBean.ordenarAnaqueles"+
        "(DTOBelcorp dtoe): Salida");
        return dtoe;           
    }

   /** 
    * Autor: Cristian Valenzuela
    * Fecha: 10/04/2007
    */
    public DTOBalanceoLinea distribuirProductosMatching(DTOBalanceoLinea dtoe) throws MareException  {        
        UtilidadesLog.info("MONBalanceoLineaBean.distribuirProductosMatching"+       
        "(DTOBalanceoLinea dtoe): Entrada");     
        
        UtilidadesLog.debug("************ DTOBalanceoLinea : " + dtoe);    
        
        Float unidadesTotales = new Float(0);
        // LG_V400000057 - dmorello, 13/11/2007
        // Creo un HashMap para guardar separados los num.unid.asig. de cada sublínea
        HashMap hashUnidadesAsignadas = new HashMap();
        //Float unidadesAsignadas = new Float(0);
        
        ArrayList listaProductos = dtoe.getListaProductos();
        int cantListaProductos =  listaProductos.size();                                        
        UtilidadesLog.debug("****** cantListaProductos " + cantListaProductos);                    
        
        //Se recorre listaProductos
        for(int i=0; i<cantListaProductos;i++) {
            DTOUnidadesProducto dtoUnidadesTemp = (DTOUnidadesProducto)listaProductos.get(i);                    
            unidadesTotales = new Float(unidadesTotales.floatValue() + 
            dtoUnidadesTemp.getUnidadesEstimadas().floatValue());                    
            
            if(dtoUnidadesTemp.getAsignado()!=null && 
                dtoUnidadesTemp.getAsignado().booleanValue())  {
                // LG_V400000057 - dmorello, 13/11/2007
                //unidadesAsignadas = new Float(unidadesAsignadas.floatValue() + 
                //dtoUnidadesTemp.getUnidadesEstimadas().floatValue());
                Long sublinea = dtoUnidadesTemp.getOidSublinea();
                if (hashUnidadesAsignadas.containsKey(sublinea)) {
                    float unidades = ((Float)hashUnidadesAsignadas.get(sublinea)).floatValue();
                    unidades += dtoUnidadesTemp.getUnidadesEstimadas().floatValue();
                    hashUnidadesAsignadas.put(sublinea,new Float(unidades));
                } else {
                    hashUnidadesAsignadas.put(sublinea, new Float(dtoUnidadesTemp.getUnidadesEstimadas().floatValue()));
                }
                // Fin LG_V400000057 - dmorello, 13/11/2007
            }                        
        }                 
        
        UtilidadesLog.debug("****** unidadesTotales " + unidadesTotales);     
        UtilidadesLog.debug("****** hashUnidadesAsignadas " + hashUnidadesAsignadas);
        
        // LG_V400000057 - dmorello, 21/11/2007
        int h = 0;
        
        Long oidSublineaActual = null;
        Long oidSublineaAnterior = null;   
        
        //Se recorre listaProductos
        for(int i=0; i<cantListaProductos;i++) {
            UtilidadesLog.debug("****** oidSublineaActual " + oidSublineaActual);     
            UtilidadesLog.debug("****** oidSublineaAnterior " + oidSublineaAnterior); 
                
            DTOUnidadesProducto dtoUnidadesTemp = (DTOUnidadesProducto)listaProductos.get(i);                                
            UtilidadesLog.debug("****** i " + i);   
            UtilidadesLog.debug("****** DTOUnidadesProducto " + dtoUnidadesTemp);   
            
            if(dtoUnidadesTemp.getAsignado()!=null && 
                !dtoUnidadesTemp.getAsignado().booleanValue())  {
                
                DTOAnaqueles dtoAnaquelesUtilizar = null;
            
                ArrayList listaAnaqueles = dtoe.getListaAnaqueles();  
                int cantListaAnaqueles = listaAnaqueles.size();
                UtilidadesLog.debug("****** cantListaAnaqueles " + cantListaAnaqueles);   
                // LG_V400000057 - dmorello, 21/11/2007
                //int h = 0;                
                
                if(oidSublineaActual==null && oidSublineaAnterior==null) {
                    DTOAnaqueles dtoAnaqueles = (DTOAnaqueles)listaAnaqueles.get(0);
                    dtoAnaquelesUtilizar = new DTOAnaqueles();
                    dtoAnaquelesUtilizar.setOidAnaquelDetalle(dtoAnaqueles.getOidAnaquelDetalle());
                    dtoAnaquelesUtilizar.setOidMapaCentroDistribucionDetalle(dtoAnaqueles.getOidMapaCentroDistribucionDetalle());
                    dtoAnaquelesUtilizar.setOidSublinea(dtoAnaqueles.getOidSublinea());
                    
                    oidSublineaActual = dtoAnaqueles.getOidSublinea();
                    UtilidadesLog.debug("****** (1)oidSublineaActual " + oidSublineaActual);   
                }    
                    
                if(oidSublineaActual==null && oidSublineaAnterior!=null) {
                    boolean saleBucleListaAnaqueles = false;
                    // LG_V400000057 - dmorello, 21/11/2007
                    //for(int k=0; k<cantListaAnaqueles && saleBucleListaAnaqueles==false; k++) {
                    for(int k=h; k<cantListaAnaqueles && saleBucleListaAnaqueles==false; k++) {
                        DTOAnaqueles dtoAnaqueles = (DTOAnaqueles)listaAnaqueles.get(k);
                        
                        if(dtoAnaqueles.getOidSublinea()!=null && 
                        !dtoAnaqueles.getOidSublinea().equals(oidSublineaAnterior)) {
                            oidSublineaActual = dtoAnaqueles.getOidSublinea();       
                            dtoAnaquelesUtilizar = new DTOAnaqueles();
                            dtoAnaquelesUtilizar.setOidAnaquelDetalle(dtoAnaqueles.getOidAnaquelDetalle());
                            dtoAnaquelesUtilizar.setOidMapaCentroDistribucionDetalle(dtoAnaqueles.getOidMapaCentroDistribucionDetalle());
                            dtoAnaquelesUtilizar.setOidSublinea(dtoAnaqueles.getOidSublinea());
                            h = k;
                            saleBucleListaAnaqueles = true;
                            UtilidadesLog.debug("****** (2)oidSublineaActual " + oidSublineaActual);   
                        }                        
                        
                        // LG_V400000057 - dmorello, 21/11/2007
                        if (dtoAnaquelesUtilizar == null && k == cantListaAnaqueles - 1) {
                            h = cantListaAnaqueles;
                        }
                    }                    
                }
                
                 // dmorello, 25/02/2008
                // Se elimina el siguiente IF ya que está contemplado en el IF posterior
                // al preguntar por ELSE IF dtoAnaquelesUtilizar == null
                /*
                // LG_V400000057 - dmorello, 13/11/2007
                // Pregunto también por dtoAnaquelesUtilizar para no recorrer dos veces la lista de anaqueles
                if(oidSublineaActual!=null && dtoAnaquelesUtilizar == null) {
                    boolean saleBucleListaAnaqueles = false;
                    // LG_V400000057 - dmorello, 21/11/2007
                    //for(int k=0; k<cantListaAnaqueles && saleBucleListaAnaqueles==false; k++) {
                    for(int k=h; k<cantListaAnaqueles && saleBucleListaAnaqueles==false; k++) {
                        DTOAnaqueles dtoAnaqueles = (DTOAnaqueles)listaAnaqueles.get(k);
                        
                        if(dtoAnaqueles.getOidSublinea()!=null && 
                        dtoAnaqueles.getOidSublinea().longValue()== oidSublineaActual.longValue()) {
                            oidSublineaActual = dtoAnaqueles.getOidSublinea();       
                            dtoAnaquelesUtilizar = new DTOAnaqueles();
                            dtoAnaquelesUtilizar.setOidAnaquelDetalle(dtoAnaqueles.getOidAnaquelDetalle());
                            dtoAnaquelesUtilizar.setOidMapaCentroDistribucionDetalle(dtoAnaqueles.getOidMapaCentroDistribucionDetalle());
                            dtoAnaquelesUtilizar.setOidSublinea(dtoAnaqueles.getOidSublinea());
                            h = k;
                            saleBucleListaAnaqueles = true;
                            UtilidadesLog.debug("****** (3)oidSublineaActual " + oidSublineaActual);  
                        }                        

                        // LG_V400000057 - dmorello, 21/11/2007
                        if (dtoAnaquelesUtilizar == null && k == cantListaAnaqueles - 1) {
                            h = cantListaAnaqueles;
                        }
                    }                        
                }*/
                
                UtilidadesLog.debug("****** dtoAnaquelesUtilizar " + dtoAnaquelesUtilizar);  
                UtilidadesLog.debug("****** h " + h);   
                UtilidadesLog.debug("listaAnaqueles.size: " + listaAnaqueles.size());  
                
                if(dtoAnaquelesUtilizar==null && listaAnaqueles.size()==0) {                    
                    /*UtilidadesLog.debug("****** No se pudieron asignar todos los"+
                    "productos al llenarse todos los anaqueles");   
                    throw new MareException(null, null, 
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE +
                    ErroresDeNegocio.APE_0013));*/
                    
                    UtilidadesLog.debug("****** no quedan anaqueles en todas las sublineas- sale del metodo");   
                    //El mensaje: "No se pudieron asignar todos los
                    //productos al llenarse todos los anaqueles"
                    //se mostrara antes de levantar la pantalla modal
                    dtoe.setCodigoError(ErroresDeNegocio.APE_0013);
                    UtilidadesLog.debug("dtoe salida error: " + dtoe); 
                    UtilidadesLog.info("MONBalanceoLineaBean.distribuirProductosMatching"+
                    "(DTOBalanceoLinea dtoe): Salida");        
                    return dtoe;  
                    
                // LG_V400000057 - dmorello, 13/11/2007
                //} else {
                } else if (dtoAnaquelesUtilizar == null) {
                // Fin LG_V400000057 - dmorello, 13/11/2007
                    // LG_V400000057 - dmorello, 21/11/2007
                    if (h == cantListaAnaqueles) {
                        break;
                    }
                    
                    // vbongiov -- 7/09/2007
                    
                    // LG_V400000057 - dmorello, 21/11/2007
                    //DTOAnaqueles dtoAnaqueles = (DTOAnaqueles)listaAnaqueles.get(0);
                    DTOAnaqueles dtoAnaqueles = (DTOAnaqueles)listaAnaqueles.get(h);
                    
                    dtoAnaquelesUtilizar = new DTOAnaqueles();
                    dtoAnaquelesUtilizar.setOidAnaquelDetalle(dtoAnaqueles.getOidAnaquelDetalle());
                    dtoAnaquelesUtilizar.setOidMapaCentroDistribucionDetalle(dtoAnaqueles.getOidMapaCentroDistribucionDetalle());
                    dtoAnaquelesUtilizar.setOidSublinea(dtoAnaqueles.getOidSublinea());
                    
                    // LG_V400000057 - dmorello, 21/11/2007
                    //h=0;
                    
                    oidSublineaActual = dtoAnaqueles.getOidSublinea();
                    UtilidadesLog.debug("****** nueva oidSublineaActual " + oidSublineaActual);  
                }
                
                UtilidadesLog.debug("****** dtoAnaquelesUtilizar " + dtoAnaquelesUtilizar);  
                UtilidadesLog.debug("****** h " + h);   
                
                ArrayList lstPorcentajeSublineas = dtoe.getLstPorcentajeSublineas();
                int cantPorcenSub = lstPorcentajeSublineas.size(); 
                UtilidadesLog.debug("****** cantPorcenSub " + cantPorcenSub);
                
                DTOPorcentajeSublinea dtoPorcentajeUtilizar = new DTOPorcentajeSublinea();
        
                //Se recorren lstPorcentajeSublineas
                for(int k=0; k<cantPorcenSub; k++) {
                    DTOPorcentajeSublinea dtoPorcentaje = (DTOPorcentajeSublinea)lstPorcentajeSublineas.get(k);            
                    Long oidSublinea = dtoPorcentaje.getOidSublinea();                    
                    Long oidSublineaAnaqueles = dtoAnaquelesUtilizar.getOidSublinea();
                    
                    UtilidadesLog.debug("****** oidSublinea " + oidSublinea);                    
                    UtilidadesLog.debug("****** oidSublineaAnaqueles " + oidSublineaAnaqueles);
                    
                    if(oidSublinea!=null && oidSublineaAnaqueles!=null &&                    
                    oidSublinea.longValue() == oidSublineaAnaqueles.longValue()) {
                        dtoPorcentajeUtilizar.setOidSublinea(dtoPorcentaje.getOidSublinea());
                        dtoPorcentajeUtilizar.setPorcentaje(dtoPorcentaje.getPorcentaje());
                    }                    
                }
                
                UtilidadesLog.debug("****** dtoPorcentajeUtilizar " + dtoPorcentajeUtilizar);
                Float unidadesAAsignar = null;
                
                // LG_V400000057 - dmorello, 13/11/2007
                Float unidadesAsignadas = (Float)hashUnidadesAsignadas.get(dtoAnaquelesUtilizar.getOidSublinea());
                if (unidadesAsignadas == null) {
                    unidadesAsignadas = new Float(0);
                }
                
                if(dtoPorcentajeUtilizar.getPorcentaje()!=null)  {
                    Float res1 = new Float(dtoPorcentajeUtilizar.getPorcentaje().floatValue() / 100);                    
                    unidadesAAsignar = new Float(res1.floatValue() * unidadesTotales.floatValue());                   
                    UtilidadesLog.debug("****** unidadesAAsignar " + unidadesAAsignar);      
                    UtilidadesLog.debug("****** unidadesAsignadas " + unidadesAsignadas);      
                    UtilidadesLog.debug("****** UnidadesEstimadas " + dtoUnidadesTemp.getUnidadesEstimadas());     
                }           
                
                // vbongiov -- LG_V400000035 -- 9/11/2007
                if((unidadesAAsignar!=null) &&           
                (unidadesAAsignar.floatValue() >= (unidadesAsignadas.floatValue() + 
                dtoUnidadesTemp.getUnidadesEstimadas().floatValue()))){
                
                    try  {
                        AsignacionProductoAnaquelDetalleLocalHome apadlh = 
                        new AsignacionProductoAnaquelDetalleLocalHome();      
                        
                        UtilidadesLog.debug("** Llamando al create de AsignacionProductoAnaquelDetalle con:");                                      
                        
                        UtilidadesLog.debug("** IND_PROCE: " + ConstantesAPE.OID_PROCEDENCIA_BALANCEO);                                                              
                        UtilidadesLog.debug("** APAC_OID_ASIG_PROD_ANAQ_CABE: " + dtoe.getOidAsignacionProductosAnaqueles());  
                        UtilidadesLog.debug("** PROD_OID_PROD: " + dtoUnidadesTemp.getOidProducto());                          
                        UtilidadesLog.debug("** NUM_UNIDA: " + dtoUnidadesTemp.getUnidadesEstimadas());                          
                        UtilidadesLog.debug("** MCDD_OID_MAPA_CENT_DIST_DETA: " + dtoAnaquelesUtilizar.getOidMapaCentroDistribucionDetalle());                                                  
                        
                        AsignacionProductoAnaquelDetalleLocal apadl = 
                        apadlh.create(dtoe.getOidAsignacionProductosAnaqueles(),
                        dtoUnidadesTemp.getOidProducto(),
                        ConstantesAPE.OID_PROCEDENCIA_BALANCEO);         
                                        
                        apadl.setUnidades(dtoUnidadesTemp.getUnidadesEstimadas());
                        apadl.setMapaCentroDistribucionDetalle(dtoAnaquelesUtilizar.getOidMapaCentroDistribucionDetalle());
                        
                        apadlh.merge(apadl);
                                        
                        UtilidadesLog.debug("** Seteando asignado = true en DTOUnidadesProducto **");
                        dtoUnidadesTemp.setAsignado(Boolean.TRUE);                                    
                                 
                        UtilidadesLog.debug("** Borrando DTOAnaqueles de DTOBalanceoLinea.listaAnaqueles **");
                        listaAnaqueles.remove(h);                                    
                                        
                        unidadesAsignadas = new Float(unidadesAsignadas.floatValue() + 
                        dtoUnidadesTemp.getUnidadesEstimadas().floatValue());
                        UtilidadesLog.debug("** unidadesAsignadas: " + unidadesAsignadas);
                        
                        // LG_V400000057 - dmorello, 13/11/2007
                        hashUnidadesAsignadas.put(dtoAnaquelesUtilizar.getOidSublinea(), unidadesAsignadas);
                    } catch (EntityExistsException e) {
                        UtilidadesLog.error("ERROR ", e);
                        ctx.setRollbackOnly();
                        throw new MareException(e, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                    } catch (PersistenceException e) {
                        UtilidadesLog.error("ERROR ", e);
                        ctx.setRollbackOnly();
                        throw new MareException(e, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }                                             
                }
                else  {
                    UtilidadesLog.debug("*** seteando null a oidSublineaActual");               
                    oidSublineaAnterior = oidSublineaActual;
                    oidSublineaActual = null;                    
                    
                    // LG_V400000057 - dmorello, 21/11/2007
                    i--;
                }
            }     
        }
        
        UtilidadesLog.debug("dtoe salida bien: " + dtoe); 
        UtilidadesLog.info("MONBalanceoLineaBean.distribuirProductosMatching"+
        "(DTOBalanceoLinea dtoe): Salida");        
        return dtoe;       
    }

    /**
     * Verifica cambios efectuados en la matriz de facturacion y avisa a los 
     * responsables de la linea de armado de los productos afectados desde la
     * ultima ejecucion de la alarma.
     * @autor eiraola
     * @since 27/02/2007
     * Modificado Inc BELC400000525
     */
    public void emitirAlarmas(DTOMantenerAsignacionProductosAnaqueles dtoe) throws MareException {
        UtilidadesLog.info("MONBalanceoLinea.emitirAlarmas(DTOMantenerAsignacionProductosAnaqueles dtoe): Entrada");
        
        try {
            DAOBalanceoLinea daoBalanceoLinea = new DAOBalanceoLinea();
            RecordSet rsProdAsig;
            RecordSet rsProdMatriz;
            
            /* BELC400000711 - dmorello, 05/09/2007 */
            //HashMap oidProdAsig = new HashMap();
            ArrayList oidProdAsig = new ArrayList();
            
            BigDecimal oidProd = null;
            String codSAP = null;
            String descProd = null;
            int cantProdAsig = 0;
            int cantProdMatriz = 0;
            
            // Busca los productos asignados
            DTOSalida dtoProductosAsignados = daoBalanceoLinea.obtenerProductosAsignados(dtoe);
            rsProdAsig = dtoProductosAsignados.getResultado();
            cantProdAsig = rsProdAsig.getRowCount();
            ArrayList productosNoAsig = new ArrayList();
            
            if(!rsProdAsig.esVacio()){
            
                for(int i=0; i < cantProdAsig; i++){
                    /* BELC400000711 - dmorello, 05/09/2007 */
                    //oidProd = (BigDecimal)rsProdAsig.getValueAt(i, "OID_PROD");
                    oidProd = (BigDecimal)rsProdAsig.getValueAt(i, "PROD_OID_PROD");
                    //oidProdAsig.put(oidProd, oidProd);
                    oidProdAsig.add(oidProd);
                    /* Fin BELC400000711 - dmorello, 05/09/2007 */
                }
                
                // Busca los productos de la matriz de facturacion
                DTOSalida dtoProductosMatriz = daoBalanceoLinea.obtenerProductosMatriz(dtoe);
                rsProdMatriz = dtoProductosMatriz.getResultado();
                cantProdMatriz = rsProdMatriz.getRowCount();
                
                for(int j=0;j < cantProdMatriz; j++){
                    oidProd = (BigDecimal)rsProdMatriz.getValueAt(j, "OID_PROD");
                    
                    /* BELC400000711 - dmorello, 05/09/2007 */
                    //if(oidProdAsig.get(oidProd)==null){
                    if(! oidProdAsig.contains(oidProd)){
                      codSAP = (String)rsProdMatriz.getValueAt(j, "COD_SAP");
                      descProd = (String)rsProdMatriz.getValueAt(j, "DES_CORT");
                      productosNoAsig.add(codSAP + " " + descProd);
                    }                    
                }
                
                String mensProductosNoAsig= this.armarMensaje(productosNoAsig);
                
                if(!mensProductosNoAsig.equals("")){
                    UtilidadesLog.debug(" --- Localizando el Servicio de Correo electronico");
                    MONServicioCorreoElectronicoHome monServicioCorreoElectronicoH = getMONServicioCorreoElectronicoHome();
                    MONServicioCorreoElectronico monServicioCorreoElectronico = monServicioCorreoElectronicoH.create();       
                
                    // Obtengo los usuarios a quienes debemos alertar
                    UtilidadesLog.debug(" --- Buscando usuarios para envio de alarma, para la Linea (oid): " 
                                        + dtoe.getOidLineaArmado());
                    UsuarioAlarmaLineaLocalHome ualLH = new UsuarioAlarmaLineaLocalHome();
                    UsuarioAlarmaLineaLocal ualL = null;
                    String emailAdministrador = null;
                    Collection usuarios = ualLH.findByLineaArmado(dtoe.getOidLineaArmado());
                    UtilidadesLog.debug(" --- Se encontraron " + usuarios.size() + " usuarios");
                    DTOCorreoElectronico dtoCorreoElectronico = new DTOCorreoElectronico();
                    dtoCorreoElectronico.setAsunto("Emitir Alarma");
                    dtoCorreoElectronico.setMensaje(mensProductosNoAsig);
                    
                    Iterator itUsu = usuarios.iterator();
                    while (itUsu.hasNext()){
                      ualL = (UsuarioAlarmaLineaLocal)itUsu.next();
                      emailAdministrador = ualL.getValMail();
                      dtoCorreoElectronico.setDireccion(emailAdministrador);
                      UtilidadesLog.debug("     dtoCorreoElectronico: " + dtoCorreoElectronico);
                      monServicioCorreoElectronico.enviarCorreo(dtoCorreoElectronico);                 
                    }  
                }
                
                // Se actualiza la fecha de ejecucion de la alarma en la Linea de Armado
                LineaArmadoLocalHome lineaArmadoLH = new LineaArmadoLocalHome();
                LineaArmadoLocal lineaArmadoL = null;
                UtilidadesLog.debug("--- Actualizando fecha de ejecucion de la Alarma para la Linea");
                lineaArmadoL = lineaArmadoLH.findByPrimaryKey(dtoe.getOidLineaArmado());
                lineaArmadoL.setFechaHoraRevisionAlarma(new Timestamp(System.currentTimeMillis()));                
                
                try {
                    lineaArmadoLH.merge(lineaArmadoL);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Error en merge: ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
            } else {
                // No hay productos asignados
                ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                                             UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",
                                                                              ErroresDeNegocio.APE_0039));
    
                ex.setPosicion(ExcepcionParametrizada.POSICION_INICIAL);
                ex.addParameter(dtoe.getDescripcionCentroDistribucion());
      
                ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                ex.addParameter(dtoe.getDescripcionLineaArmado());
                
                ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                ex.addParameter(dtoe.getDescripcionMarca());
                
                ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                ex.addParameter(dtoe.getDescripcionCanal());
                
                ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                ex.addParameter(dtoe.getDescripcionPeriodo());
                
                ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                ex.addParameter(dtoe.getDescripcionMapaCentroDistribucion());
      
                throw ex;              
            }
          
        } catch (NoResultException ex) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", ex);
          ex.printStackTrace();
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ex) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", ex);
          ex.printStackTrace();
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (Exception ex) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", ex);
          ex.printStackTrace();
          throw new MareException(ex);
        } 
        
        UtilidadesLog.info("MONBalanceoLinea.emitirAlarmas(DTOMantenerAsignacionProductosAnaqueles dtoe): Salida");
    }
    
  /** 
    * Autor: Cristian Valenzuela
    * Fecha: 26/2/2007
    */
    public void eliminarBalanceoPrevio(Long oidAsignacionProductosAnaqueles) throws MareException  {
        UtilidadesLog.info("MONBalanceoLineaBean.eliminarBalanceoPrevio"+
        "(Long oidAsignacionProductosAnaqueles): Entrada");        
        
        UtilidadesLog.debug("*** oidAsignacionProductosAnaqueles " + oidAsignacionProductosAnaqueles);
        BelcorpService bs;
        int respuesta;
        StringBuffer query = new StringBuffer();
        String inOidAsigProdAnaqDet = "";
        
        try  {
            AsignacionProductoAnaquelDetalleLocalHome apadlh = new AsignacionProductoAnaquelDetalleLocalHome();
            Collection registros = apadlh.findByCabeceraBalanceo(oidAsignacionProductosAnaqueles,
            ConstantesAPE.OID_PROCEDENCIA_BALANCEO);   
            
            UtilidadesLog.debug("AsignacionProductoAnaquelDetalle a borrar: " + registros.size());
            
            if(registros.size()!=0){
            
                Iterator it = registros.iterator();
                while(it.hasNext()) {
                    AsignacionProductoAnaquelDetalleLocal apadl = (AsignacionProductoAnaquelDetalleLocal)it.next();
                    inOidAsigProdAnaqDet = inOidAsigProdAnaqDet + "," + apadl.getOid();              
                }            
                
                query.append(" DELETE APE_ASIGN_PRODU_ANAQU_DETAL ");
                query.append(" WHERE OID_ASIG_PROD_ANAQ IN (" + inOidAsigProdAnaqDet.substring(1) + ")");
        
                try{
                     bs = BelcorpService.getInstance();
                     respuesta = bs.dbService.executeUpdate(query.toString());
                     
                } catch (Exception e) {
                    throw new MareException( e, 
                      UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }
        }
        catch (NoResultException e) {
            UtilidadesLog.error("ERROR ", e);
            ctx.setRollbackOnly();
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }        
        
        UtilidadesLog.info("MONBalanceoLineaBean.eliminarBalanceoPrevio"+
        "(Long oidAsignacionProductosAnaqueles): Salida");        
    }

    private MONServicioCorreoElectronicoHome getMONServicioCorreoElectronicoHome() 
            throws MareException {
        try {
            final InitialContext context = new InitialContext();
            return (MONServicioCorreoElectronicoHome)PortableRemoteObject.narrow(context.lookup(
                "java:comp/env/ejb/MONServicioCorreoElectronico"), MONServicioCorreoElectronicoHome.class);
        } catch (NamingException ne) {
            UtilidadesLog.error(" ERROR al localizar CMN MONServicioCorreoElectronico");
            throw new MareException(ne, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    private MONMantenimientoMapasHome getMONMantenimientoMapasHome() 
            throws MareException {
        try {
            final InitialContext context = new InitialContext();
            return (MONMantenimientoMapasHome)PortableRemoteObject.narrow(context.lookup(
                "java:comp/env/ejb/MONMantenimientoMapas"), MONMantenimientoMapasHome.class);
        } catch (NamingException ne) {
            UtilidadesLog.error(" ERROR al localizar APE MONMantenimientoMapas");
            throw new MareException(ne, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }
    
   /** 
    * Autor: Cristian Valenzuela
    * Fecha: 26/03/2007
    */
    public DTOBalanceoLinea evaluarCarga(DTOBalanceoLinea dtoe) throws MareException {
        UtilidadesLog.info("MONBalanceoLineaBean.evaluarCarga"+
        "(DTOBalanceoLinea dtoe): Entrada");        
        UtilidadesLog.debug("****** DTOBalanceoLinea (Entrada)" + dtoe);
        
        DAOBalanceoLinea dao = new DAOBalanceoLinea();
        
        ArrayList estimadosSublineas = dao.obtenerEstimadosSublineas(dtoe);
        ArrayList numeroZonasSublineas = dao.obtenerNumeroZonasSublineas(dtoe);
        ArrayList unidadesZonasSublineas = dao.obtenerUnidadesAsignadasZonasSublineas(dtoe);
        ArrayList unidadesSublineas = dao.obtenerUnidadesSublineas(dtoe);
        
        ArrayList cargaSublineas = new ArrayList();
        
        int cantEstimadosSublineas = estimadosSublineas.size();
        int cantNumeroZonasSublineas = numeroZonasSublineas.size();
        int cantUnidadesZonasSublineas = unidadesZonasSublineas.size();
        int cantUnidadesSublineas = unidadesSublineas.size();
        
        UtilidadesLog.debug("****** cantEstimadosSublineas " + cantEstimadosSublineas);
        UtilidadesLog.debug("****** cantNumeroZonasSublineas " + cantNumeroZonasSublineas);
        UtilidadesLog.debug("****** cantUnidadesZonasSublineas " + cantUnidadesZonasSublineas);
        UtilidadesLog.debug("****** cantUnidadesSublineas " + cantUnidadesSublineas);
        
        DTONumeroZonasSublineas dtoNumeroZonasUtilizar = new DTONumeroZonasSublineas();
        DTOUnidadesSublineas dtoUnidadesUtilizar = new DTOUnidadesSublineas();
        
        // Bucle principal - se recorren estimados sublineas
        for(int i=0; i<cantEstimadosSublineas; i++) {
            DTOEstimadoSublinea dtoEstimados = (DTOEstimadoSublinea)estimadosSublineas.get(i);
            Long oidSublineaEstimados = dtoEstimados.getOidSublinea();
            UtilidadesLog.debug("****** oidSublineaEstimados " + oidSublineaEstimados);
            
            //Bucle auxiliar - se recorren numeroZonasSublineas hasta
            //encontrar el registro que tenga la misma sublinea que el 
            //registro de estimados sublineas que se esta procesando
            for(int j=0; j<cantNumeroZonasSublineas; j++) {
                DTONumeroZonasSublineas dto = (DTONumeroZonasSublineas)numeroZonasSublineas.get(j);
                Long oidSublineaNumeroZonas = dto.getOidSublinea();
                UtilidadesLog.debug("****** oidSublineaNumeroZonas " + 
                oidSublineaNumeroZonas);
                
                if(oidSublineaEstimados.equals(oidSublineaNumeroZonas)) {
                    //Se crea el DTONumeroZonasSublineas que se utilizara
                    dtoNumeroZonasUtilizar.setOidSublinea(dto.getOidSublinea());
                    dtoNumeroZonasUtilizar.setNumero(dto.getNumero());                    
                }            
            }
            
            UtilidadesLog.debug("****** dtoNumeroZonasUtilizar " + 
            dtoNumeroZonasUtilizar);
            
            //Crear una lista unidadesZonasSublinea con todos los
            //registros de unidadesZonasSublineas que tengan oidSublinea == estimadoSublinea.oidSublinea 
            ArrayList unidadesZonasSublineasMismaSublinea = new ArrayList();
            for(int j=0; j<cantUnidadesZonasSublineas; j++) {
                DTOUnidadesZonasSublineas dto = (DTOUnidadesZonasSublineas)unidadesZonasSublineas.get(j);
                Long oidSublineaUnidadesZonasSublineas = dto.getOidSublinea();
                UtilidadesLog.debug("****** oidSublineaUnidadesZonasSublineas " + 
                oidSublineaUnidadesZonasSublineas);
                
                if(oidSublineaEstimados.equals(oidSublineaUnidadesZonasSublineas)) {
                    unidadesZonasSublineasMismaSublinea.add(dto);                    
                }                
            }        
            int cantUnidadesZonasSublineasMismaSublinea = unidadesZonasSublineasMismaSublinea.size();    
            UtilidadesLog.debug("****** cantUnidadesZonasSublineasMismaSublinea " + 
            cantUnidadesZonasSublineasMismaSublinea);
            
            //Bucle auxiliar - se recorren unidadesSublineas hasta
            //encontrar el registro que tenga la misma sublinea que el
            //registro de estimados sublineas que se esta procesando
            for(int j=0; j<cantUnidadesSublineas; j++) {
                DTOUnidadesSublineas dto = (DTOUnidadesSublineas)unidadesSublineas.get(j);
                Long oidSublineaUnidades = dto.getOidSublinea();
                UtilidadesLog.debug("****** oidSublineaUnidades " + oidSublineaUnidades);
                
                if(oidSublineaEstimados.equals(oidSublineaUnidades)) {
                    //Se crea el DTOUnidadesSublineas que se utilizara
                    dtoUnidadesUtilizar.setOidSublinea(dto.getOidSublinea());
                    dtoUnidadesUtilizar.setUnidades(dto.getUnidades());
                }
            }
            
            UtilidadesLog.debug("****** dtoUnidadesUtilizar " + dtoUnidadesUtilizar);
            
            Float error = new Float(0);
            
            //Se crea el DTOSublineaEvaluarCarga
            DTOSublineaEvaluarCarga sublinea = new DTOSublineaEvaluarCarga();
            sublinea.setOidSublinea(dtoEstimados.getOidSublinea());
            sublinea.setDescripcion(dtoEstimados.getDescripcion());
            sublinea.setErrorPromedio(error);
            
            Long total = dtoEstimados.getTotal();
            Long numero = dtoNumeroZonasUtilizar.getNumero();
            float res = total.longValue() / numero.longValue();            
            sublinea.setUnidadesPromedio(new Float(res));           
            
            UtilidadesLog.debug("****** DTOSublineaEvaluarCarga " + sublinea);
            
            Float porcentajePromedio = new Float(100 / 
            dtoNumeroZonasUtilizar.getNumero().floatValue());
            UtilidadesLog.debug("****** porcentajePromedio " + porcentajePromedio);
            
            ArrayList zonas = new ArrayList();      
            //se recorren unidades Zonas Sublineas 
            for(int j=0; j<cantUnidadesZonasSublineasMismaSublinea; j++) {                
                UtilidadesLog.debug("****** j " + j);
                DTOUnidadesZonasSublineas dto = (DTOUnidadesZonasSublineas)unidadesZonasSublineasMismaSublinea.get(j);
                
                Long unidadesAsignadas = dto.getUnidadesAsignadas();                
                Long unidades = dtoUnidadesUtilizar.getUnidades();
                
                UtilidadesLog.debug("****** unidadesAsignadas " + unidadesAsignadas);
                UtilidadesLog.debug("****** unidades " + unidades);               
                
                // LG_V400000059 - dmorello, 21/11/2007
                //Float res1 = new Float(unidadesAsignadas.floatValue() / unidades.floatValue());
                float res1 = (unidades.floatValue() != 0)? unidadesAsignadas.floatValue() / unidades.floatValue() : 0;
                UtilidadesLog.debug("****** res1 " + res1);               
                Float porcentaje = new Float(res1 * 100);                       
                // Fin LG_V400000059 dmorello 20/11/2007
                UtilidadesLog.debug("****** porcentaje " + porcentaje);
                
                // LG_V400000059 - dmorello, 13/11/2007
                //error = new Float((error.floatValue() + porcentaje.floatValue()) 
                //- porcentajePromedio.floatValue());
                //UtilidadesLog.debug("****** (1)error " + error);
                //error = new Float(Math.abs(error.floatValue()));
                //UtilidadesLog.debug("****** (valor absoluto)error " + error);
                float errorParcial = Math.abs(porcentaje.floatValue() - porcentajePromedio.floatValue());
                UtilidadesLog.debug("****** errorParcial: " + errorParcial);
                error = new Float(error.floatValue() + errorParcial);
                UtilidadesLog.debug("****** error (acumulado de los errores parciales): " + error);
                
                //sublinea.setErrorPromedio(error);
                // Fin LG_V400000059 - dmorello, 13/11/2007
                
                DTOZonasEvaluarCarga dtoZonasEvaluarCarga = new DTOZonasEvaluarCarga();
                dtoZonasEvaluarCarga.setIdZona(dto.getIdZona());
                dtoZonasEvaluarCarga.setUnidadesAsignadas(dto.getUnidadesAsignadas());
                dtoZonasEvaluarCarga.setPorcentaje(porcentaje);                
                
                zonas.add(dtoZonasEvaluarCarga);                
            } //FIN - se recorren unidades Zonas Sublineas 
            
            sublinea.setZonas(zonas);
            
            UtilidadesLog.debug("sublinea_" + i + ": " + sublinea);
            
            cargaSublineas.add(sublinea);
            
            error = new Float(error.floatValue() / 
            dtoNumeroZonasUtilizar.getNumero().floatValue());            
            UtilidadesLog.debug("****** (2)error " + error);
            sublinea.setErrorPromedio(error);
        } //FIN - Bucle principal - se recorren estimados sublineas

        //al DTOBalanceoLinea de entrada se le setea el ArrayList cargaSublineas
        //que posee n dtos del tipo DTOSublineaEvaluarCarga,
        //a su vez este dto posee n dtos del tipo DTOZonasEvaluarCarga
        dtoe.setLstCargaSublineas(cargaSublineas);
        UtilidadesLog.debug("****** DTOBalanceoLinea (Salida)" + dtoe);
        
        UtilidadesLog.info("MONBalanceoLineaBean.evaluarCarga"+
        "(DTOBalanceoLinea dtoe): Salida");
        
        return dtoe;
    }

  public String armarMensaje(ArrayList productos) throws MareException {
      UtilidadesLog.info("MONBalanceoLinea.armarMensaje(ArrayList productos): Entrada");
      
      String mensaje = "" ;
      String producto = null;
      int cant = productos.size();
      
      for(int i=0; i < cant; i++){
          producto = (String)productos.get(i);
          
          mensaje = mensaje + producto + "\n";
      }
      
      UtilidadesLog.debug("mensaje: " + mensaje);
      
      UtilidadesLog.info("MONBalanceoLinea.armarMensaje(ArrayList productos): Salida");
      return mensaje;
  }
}