package es.indra.sicc.logicanegocio.mav;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.mav.DTOParametroDBP;
import es.indra.sicc.dtos.mav.DTOValoresDefectoDatosBP;
import es.indra.sicc.entidades.mav.ValorDefectoDatosBPLocal;
import es.indra.sicc.entidades.mav.ValorDefectoDatosBPLocalHome;
import es.indra.sicc.util.UtilidadesLog;

import java.util.ArrayList;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMantenimientoParametrosDBPBean implements SessionBean  {
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

    public DTOValoresDefectoDatosBP obtenerValoresDefectoActividad(DTOValoresDefectoDatosBP dtoe) throws MareException {
        UtilidadesLog.debug("MONMantenimientoParametrosDBPBean.obtenerValoresDefectoActividad(Long pais):Entrada");
        
        DAOMantenimientoParametrosDBP dao = new DAOMantenimientoParametrosDBP();
        
        RecordSet rs = dao.obtenerValoresDefectoPorActividad(dtoe).getResultado();
        
        DTOValoresDefectoDatosBP dtos = new DTOValoresDefectoDatosBP();
        dtos.setOidActividad(new Long(dtoe.getOidActividad().longValue()));
        
        if(rs!=null && !rs.esVacio()){
            ArrayList lista = new ArrayList();
            for(int i = 0; i < rs.getRowCount(); i++){
                DTOParametroDBP dtoi = new DTOParametroDBP();
                dtoi.setOidParametro(new Long(rs.getValueAt(i,"OID").toString()));
                dtoi.setCodigo(new String(rs.getValueAt(i,"COD").toString()));
                dtoi.setValor(new String(rs.getValueAt(i,"VAL")==null ? "" : rs.getValueAt(i,"VAL").toString()));
                dtoi.setOidActividad(new Long(dtoe.getOidActividad().toString()));
                lista.add(dtoi);
            }
            dtos.setValoresDefecto(lista);
        }
        
        UtilidadesLog.debug("MONMantenimientoParametrosDBPBean.obtenerValoresDefectoActividad(Long pais):Salida");
        return dtos;
    }

    public void guardarValoresDefectoActividad(DTOValoresDefectoDatosBP dtoe) throws MareException {
        UtilidadesLog.debug("MONMantenimientoParametrosDBPBean.guardarValoresDefectoActividad(DTOValoresDefectoDatosBP pais):Entrada");
        UtilidadesLog.debug("dtoe:\n"+dtoe);
        
        if(dtoe.getValoresDefecto()!=null && dtoe.getValoresDefecto().size()>0){
            ArrayList lista = dtoe.getValoresDefecto();
            Long actividad = dtoe.getOidActividad();
            for(int i = 0; i < lista.size(); i++){
                UtilidadesLog.debug("Iterando... i["+i+"]");
                DTOParametroDBP dtoP = (DTOParametroDBP)lista.get(i);
                if(actividad==null){
                    actividad = dtoP.getOidActividad();
                }
                String codigo = dtoP.getCodigo();
                String valor = dtoP.getValor();
                Long pais = dtoP.getOidPais();
                UtilidadesLog.debug("Valores actividad["+actividad+"], pais["+pais+"], codigo["+codigo+"], valor["+valor+"]");
                
                ValorDefectoDatosBPLocalHome vdlh = null;
                ValorDefectoDatosBPLocal valDef = null;
                boolean modificar = true;               
                
                vdlh = new ValorDefectoDatosBPLocalHome();                
                try {
                    valDef = vdlh.findByUK(actividad,codigo);
                    // Valor por defecto existe... modificarlo
                    UtilidadesLog.debug("Valor por defecto ["+i+"] existe... va a modificar");
                    modificar = true;
                } catch (NoResultException e) {
                    // Valor por defecto NO existe... crearlo
                    UtilidadesLog.debug("Valor por defecto ["+i+"] NO existe... va a insertar");
                    modificar = false;
                }
                
                if(modificar){
                    valDef.setValorDefecto(valor);
                    UtilidadesLog.debug("Valor por defecto ["+i+"] modificado");
                }else{
                    try {
                        valDef = vdlh.create(actividad, codigo, pais);
                        valDef.setValorDefecto(valor);
                        vdlh.merge(valDef);
                        UtilidadesLog.debug("Valor por defecto ["+i+"] insertado");
                    } catch (PersistenceException e) {
                        UtilidadesLog.error("ERROR al insertar en tabla Valor por Defecto actividad=["+actividad+"],codigo=["+codigo+"]",e);
                        throw new MareException(e);
                    }
                }
            }
        }
        
        UtilidadesLog.debug("MONMantenimientoParametrosDBPBean.guardarValoresDefectoActividad(DTOValoresDefectoDatosBP pais):Salida");
    }


}
