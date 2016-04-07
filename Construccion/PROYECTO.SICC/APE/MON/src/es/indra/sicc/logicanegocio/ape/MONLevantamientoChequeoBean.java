package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.logicanegocio.ape.DAOLevantamientoChequeos;
import es.indra.sicc.dtos.ape.DTOChequeos;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.SecuenciadorOID;
import java.sql.Date;
import java.util.ArrayList;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.rmi.RemoteException;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;

public class MONLevantamientoChequeoBean implements SessionBean  {
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
    }

    private void generarLogErroresLevantamiento(ArrayList listasErrores, Long oidPais)throws MareException {
        UtilidadesLog.info("MONLevantamientoChequeoBean.generarLogErroresLevantamiento(DTOOIDs listasErrores): Entrada");
        DAOLevantamientoChequeos daoL = new DAOLevantamientoChequeos();
        DTOSalida dtoS = daoL.obtenerDatosErrores(listasErrores);
        RecordSet rs = dtoS.getResultado();
        try{
            MONGestorInterfaces gi = this.getMONGestorInterfaces();
            InterfazInfo info = new InterfazInfo(ConstantesAPE.ERROR_LEVANTAR_CHEQUEO, gi.obtenerNumeroLote(), oidPais);
            InterfazInfo interfaz = gi.crearInterfaz(info);
            
            RegistroSicc ri = new RegistroSicc();
            ri.anyadirCampo(ConstantesAPE.ERROR_L_CHEQ_FECHA, "Fecha");
            ri.anyadirCampo(ConstantesAPE.ERROR_L_CHEQ_NUMSOLI, "N° Consolidado");
            ri.anyadirCampo(ConstantesAPE.ERROR_L_CHEQ_NUMCAJA, "N° Caja");
            gi.anyadirRegistro(interfaz,ri);
            for (int i=0;i< rs.getRowCount();i++)  {
                ri.vaciar();
                ri.anyadirCampo(ConstantesAPE.ERROR_L_CHEQ_FECHA, rs.getValueAt(i,"FECHA")!=null? rs.getValueAt(i,"FECHA").toString():"");
                ri.anyadirCampo(ConstantesAPE.ERROR_L_CHEQ_NUMSOLI, rs.getValueAt(i,"NUMSOLI")!=null? rs.getValueAt(i,"NUMSOLI").toString():"");
                ri.anyadirCampo(ConstantesAPE.ERROR_L_CHEQ_NUMCAJA, rs.getValueAt(i,"NUMCAJA")!=null? rs.getValueAt(i,"NUMCAJA").toString():"");    
                gi.anyadirRegistro(interfaz,ri);
            }
            gi.enviarInterfaz(interfaz);
        
        }catch(RemoteException re){
            throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO.toString()));
        }catch(InterfacesException ie){
            throw new MareException(ie,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO.toString()));
        }
        
        UtilidadesLog.info("MONLevantamientoChequeoBean.generarLogErroresLevantamiento(DTOOIDs listasErrores): Salida");
    }

    public void realizarLevantamientoChequeo (DTOChequeos dtoE) throws MareException {
        UtilidadesLog.info("MONLevantamientoChequeoBean.realizarLevantamientoChequeo(DTOChequeos dtoE): Entrada");
        
        DAOLevantamientoChequeos daoLevantaCheck = new DAOLevantamientoChequeos();
        
        DTOSalida loteDatos = daoLevantaCheck.recuperarListaPicado(dtoE);
        
        ArrayList listasActualizarEstado = new ArrayList();
        ArrayList listasActualizaChequeo = new ArrayList();
        ArrayList listasErrores = new ArrayList();
        
        
        RecordSet lista = loteDatos.getResultado();
        
        if(lista !=null && !lista.esVacio()){
                        
            for(int i=0;i<lista.getRowCount();i++){
                if(lista.getValueAt(i,"ESTADO") != null && (ConstantesAPE.OID_ESTADO_EMBALADO.equals(new Long(lista.getValueAt(i,"ESTADO").toString())) ||
                   ConstantesAPE.OID_ESTADO_PEDIDO_INDUCIDO.equals(new Long(lista.getValueAt(i,"ESTADO").toString())))){
                    // vbongiov -- Cambio 20090935 -- 4/06/2009
                     listasActualizarEstado.add(Long.valueOf((lista.getValueAt(i,"OID_LIST_PICA_CABE").toString())));
                     
                     if(ConstantesPED.OID_REVISION_AMBAS.equals(new Long(lista.getValueAt(i,"INRE_OID_INDI_REVI").toString()))){
                         listasActualizaChequeo.add(Long.valueOf((lista.getValueAt(i,"OID_LIST_PICA_CABE").toString())));    
                     }
                
                }else{
                     listasErrores.add(Long.valueOf((lista.getValueAt(i,"OID_LIST_PICA_CABE").toString())));
                }
                
            }
            
            if(!listasActualizarEstado.isEmpty()){
                
                this.generarLevantamientos(dtoE,listasActualizarEstado);
                daoLevantaCheck.actualizarEstado(listasActualizarEstado);
                
            }
            if(!listasActualizaChequeo.isEmpty()){
                daoLevantaCheck.actualizarChequeo(listasActualizaChequeo);
            }
            if(!listasErrores.isEmpty()){
                this.generarLogErroresLevantamiento(listasErrores,dtoE.getOidPais());
            }
            
        }
        
        UtilidadesLog.info("MONLevantamientoChequeoBean.realizarLevantamientoChequeo(DTOChequeos dtoE): Salida");
    }
    
    private void generarLevantamientos (DTOChequeos dtoE, ArrayList listasActualizarEstado)throws MareException{
        UtilidadesLog.info("MONLevantamientoChequeoBean.generarLevantamientos(DTOChequeos dtoE, ArrayList listasActualizarEstado): Entrada");
        
        StringBuffer insert = new StringBuffer();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try{
            Date fechaActual = null;
            
            Long oidCabecera = this.grabarCabeceraLevantamiento(dtoE);
            
                       
            for (int i=0 ;i<listasActualizarEstado.size() ;i++ )  {
                
                //Long oid, Date fechaHoraSistema, Long oidLevantaChequCabecera, Long oidListaPicadoCabecera
                
                insert.append(" INSERT INTO APE_LEVAN_CHEQU_DETAL ( ");
                insert.append(" OID_LEVA_CHEQ_DETA , ");
                insert.append(" VAL_FECH_HORA_SIST , "); 
                insert.append(" LECC_OID_LEVA_CHEQ_CABE,  ");
                insert.append(" LPCA_OID_LIST_PICA_CABE ");
                insert.append(" ) VALUES (  ");
                insert.append(" APE_LECD_SEQ.NEXTVAL , ");
                insert.append(" SYSDATE , ");
                insert.append(oidCabecera+" , ");
                insert.append(listasActualizarEstado.get(i));
                insert.append(" );");
            }
            
        
             bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", insert.toString());
        
        
        
        }catch(CreateException ce){
            String codigo= CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(ce, UtilidadesError.armarCodigoError(codigo));
        }catch(Exception e){
            String codigo= CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigo));
        }
        
        UtilidadesLog.info("MONLevantamientoChequeoBean.generarLevantamientos(DTOChequeos dtoE, ArrayList listasActualizarEstado): Salida");        
    }
    private MONGestorInterfaces getMONGestorInterfaces() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONLevantamientoChequeoBean.getMONGestorInterfaces(): Entrada");
        MONGestorInterfacesHome home = (MONGestorInterfacesHome)UtilidadesEJB.getHome("MONGestorInterfaces", MONGestorInterfacesHome.class);
            
        // Se obtiene el interfaz remoto
        MONGestorInterfaces ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONGestorInterfaces",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 	        
        UtilidadesLog.info("MONLevantamientoChequeoBean.getMONGestorInterfaces(): Salida");
        return ejb;
	}  

    private Long grabarCabeceraLevantamiento (DTOChequeos dtoE)throws MareException{
        UtilidadesLog.info("MONLevantamientoChequeoBean.grabarCabeceraLevantamiento(DTOChequeos dtoE, ArrayList listasActualizarEstado): Entrada");
        StringBuffer insert = new StringBuffer();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        Long indPedido = dtoE.getPedido().booleanValue()? Long.valueOf("1"):Long.valueOf("0");
        Long indReclamo = dtoE.getReclamo().booleanValue()? Long.valueOf("1"):Long.valueOf("0");
        Long indManual = dtoE.getManual().booleanValue()? Long.valueOf("1"):Long.valueOf("0");
        
        //fechaHora, numeroConsolidado, indEvaluacionReclamo, 
        //indCapturaManual, indPrimerPedido, oidRegion, oidSeccion, oidZona, oidPais, usuario
        Long oidInsertar = SecuenciadorOID.obtenerSiguienteValor("APE_LECC_SEQ");
           
        insert.append(" INSERT INTO APE_LEVAN_CHEQU_CABEC ( ");
        insert.append(" OID_LEVA_CHEQ_CABE, ");
        insert.append(" VAL_FECH_HORA, ");
        insert.append(" NUM_CONS,  ");
        insert.append(" IND_EVAL_RECL, ");
        insert.append(" IND_CAPT_MANU, ");
        insert.append(" IND_PRIM_PEDI, ");
        insert.append(" ZORG_OID_REGI, ");
        insert.append(" ZSCC_OID_SECC, ");
        insert.append(" ZZON_OID_ZONA, "); 
        insert.append(" PAIS_OID_PAIS, ");
        insert.append(" VAL_NOMB_USER ");
        insert.append(" ) VALUES (  ");
        insert.append(oidInsertar+" , ");
        insert.append(" SYSDATE , ");
        insert.append(dtoE.getNroConsolidado()+" , ");
        insert.append(indReclamo+" , ");
        insert.append(indManual+" , ");
        insert.append(indPedido+" , ");
        insert.append(dtoE.getOidRegion()+" , ");
        insert.append(dtoE.getOidSeccion()+" , ");
        insert.append(dtoE.getOidZona()+" , ");
        insert.append(dtoE.getOidPais()+" , ");
        insert.append("'"+dtoE.getUsuario()+"' ");
        
        insert.append(" );");
  
        try {
             bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", insert.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("MONLevantamientoChequeoBean.grabarCabeceraLevantamiento(DTOChequeos dtoE, ArrayList listasActualizarEstado): Salida");        
              
        return oidInsertar;
    }   

}