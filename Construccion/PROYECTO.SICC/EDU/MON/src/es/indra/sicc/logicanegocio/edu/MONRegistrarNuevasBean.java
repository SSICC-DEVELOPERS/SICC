package es.indra.sicc.logicanegocio.edu;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.edu.DTOConsultaCurso;
import es.indra.sicc.dtos.edu.DTOParticipante;
import es.indra.sicc.dtos.edu.DTOParticipantesValidados;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.edu.DTOValidarParticipantes;

/**
 * @author Rafael Romero
 * @date 13/04/2007
 */
public class MONRegistrarNuevasBean implements SessionBean  {

    private SessionContext ctx;
    
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public DTOSalida consultaCursosRegistrarNuevas(DTOConsultaCurso dtoe) throws MareException {
		UtilidadesLog.debug("MONRegistrarNuevasBean.consultaCursosRegistrarNuevas(DTOConsultaCurso): Entrada");
		DTOSalida dtoS = (new  DAORegistrarNuevas(ctx.getCallerPrincipal().getName())).consultaCursos(dtoe);
		UtilidadesLog.debug("MONRegistrarNuevasBean.consultaCursosRegistrarNuevas(DTOConsultaCurso): Salida");
		return dtoS;
    }

    /**
     * Metodo para determinar que participantes son validos y cuales NO validos.
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @return DTO con listas de validos y NO validos
     * @param dtoe Con la lista de participantes validos en la propiedad <b>validos</b>
     */
    public DTOParticipantesValidados validarParticipantesRegistrarNuevas(DTOValidarParticipantes dtoe) throws MareException {
        DTOParticipantesValidados dtos = new DTOParticipantesValidados();
        try{
            UtilidadesLog.debug("MONRegistrarNuevasBean.validarParticipantesRegistrarNuevas(DTOParticipantesValidados): Entrada");
            ArrayList validos   = new ArrayList();
            ArrayList noValidos = new ArrayList();
            
            RecordSet oidsNoValidos = (new DAORegistrarNuevas(ctx.getCallerPrincipal().getName())).obtenerNoValidos(dtoe);
            
            if(oidsNoValidos!=null){
                // Si el RecordSet de NO VALIDOS no es nulo podemos proceder
                Iterator ite = dtoe.getValidar().iterator();
                Long oidCliente = null;
                boolean hallado = false;
                DTOParticipante participante = null;
                while(ite.hasNext()){
                    participante = (DTOParticipante)ite.next();
                    //UtilidadesLog.debug("OID participante["+participante.getOidCliente()+"]");
                    hallado = false;
                    for(int i=0;i<oidsNoValidos.getRowCount();i++){
                        // Buscamos un cliente en el recordset
                        // si se encuentra, NO es valido
                        oidCliente = new Long(((BigDecimal)oidsNoValidos.getValueAt(i,"OIDCLIENTE")).toString());
                        //UtilidadesLog.debug("OID NO VALIDO comparando["+oidCliente+"]");
                        if(participante.getOidCliente().longValue()==oidCliente.longValue()){
                            //UtilidadesLog.debug("PARTICIPANTE NO VALIDO OID["+participante.getOidCliente()+"]");
                            hallado = true;
                            break;
                        }
                    }
                    if(hallado){
                        noValidos.add(participante);
                    }else{
                        validos.add(participante);
                    }
                }
                
                if(validos.size()>0){
                    // Agregamos los validos al DTO salida
                    dtos.setValidos((DTOParticipante[])validos.toArray(new DTOParticipante[validos.size()]));
                }
                if(noValidos.size()>0){
                    // Agregamos los NO validos al DTO salida
                    dtos.setNoValidos((DTOParticipante[])noValidos.toArray(new DTOParticipante[noValidos.size()]));
                }

            }else{
                //UtilidadesLog.error("RecordSet de NO VALIDOS es NULO");
                dtos.setValidos((DTOParticipante[])(dtoe.getValidar()).toArray(new DTOParticipante[dtoe.getValidar().size()]));
            }
        }finally{
            UtilidadesLog.debug("MONRegistrarNuevasBean.validarParticipantesRegistrarNuevas(DTOParticipantesValidados): Salida");
        }

        return dtos;
    }
}
