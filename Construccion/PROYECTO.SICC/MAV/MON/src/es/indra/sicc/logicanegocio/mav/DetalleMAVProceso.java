package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.mav.BPSInterfaceMAVLocal;
import es.indra.sicc.entidades.mav.BPSInterfaceMAVLocalHome;
import es.indra.sicc.entidades.mav.DetalleMAVLocal;
import es.indra.sicc.entidades.mav.DetalleMAVLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.entidades.mav.AccesosSubaccesosPorDetalleMAVLocalHome;

import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.CreateException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

import java.math.BigDecimal;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class DetalleMAVProceso {
    private Long oidBPS;
    //private BPSProceso registroBPS;

    public DetalleMAVProceso(Long oid) {
        oidBPS = oid;
    }

    public void cargarRegistro() throws MareException {
        UtilidadesLog.info("DetalleMAVProceso.cargarRegistro():Entrada");
        try {
          
            BPSProceso registroBPS = new BPSProceso(oidBPS);

            if(registroBPS.registroValido())
            {
                UtilidadesLog.debug("Es registro Valido");
                BPSInterfaceMAVLocalHome instanciaBPS = new BPSInterfaceMAVLocalHome();
                BPSInterfaceMAVLocal periOid = instanciaBPS.findByPrimaryKey(this.oidBPS);

                DetalleMAVLocalHome detalleMAV = this.getDetalleMAVLocalHome();
        				DetalleMAVLocal detalleMAVLocal = null;

                //creo
                //Double precioEstandar, Double precio,
                //Double precioContable, Long oidTipoCliente, Long oidPeriodo
/*                detalleMAVLocal = detalleMAV.create(periOid.getPrecioStandar(),
                                                    periOid.getPrecioStandar(),  // Antes estaba Promedio
                                                    periOid.getFactorCorreccion(),
                                                    periOid.getOidTipoCliente(), 
                                                    periOid.getOidPeriodo()
                                                    );*/
                                                    
                detalleMAVLocal = detalleMAV.create(periOid.getPrecioStandar(),
                                                    periOid.getPrecioStandar(),
                                                    //new Double(5),  // NO FUNKA
                                                    periOid.getOidTipoCliente(), 
                                                    periOid.getOidPeriodo(), 
                                                    periOid.getPrecioStandar()
                                                    );                                                    

                // Agregado por  ssantana, 27/7/2005, inc. 19624. 
                detalleMAVLocal.setOidPeriodoFin(periOid.getOidPeriodo());
                // Fin agregado ssantana, 27/7/2005.
                
                detalleMAVLocal.setCriterio( periOid.getCriterio() );
                detalleMAVLocal.setObservaciones( periOid.getObservaciones() );
                detalleMAVLocal.setOidProducto( periOid.getOidProducto() );
                detalleMAVLocal.setFactorCorreccion( periOid.getFactorCorreccion());
                //11/12/2004 rgiorgi, se setea el estado según el DECU.
                detalleMAVLocal.setOidEstadoProceso( 
                  new Long(ConstantesMAV.T_ESTAD_PROCESO_PENDIENTE) );

                detalleMAVLocal.setOidCicloVida(periOid.getOidCicloVida());
                detalleMAVLocal.setOidTipoOferta(periOid.getOidTipoOferta());

                // 16/12/2004 ssantana, por inc. 11463
                detalleMAVLocal.setBaseEstimadosDestinatarios(periOid.getBaseDestinatarios());
                detalleMAVLocal.setUnidadesTotalesEstimadas(periOid.getUnidades());

                // Falta acá, el script que cambie UnidadesEstimadas a NUMBER(16,2)
                Double dUnidadesEstimadas = periOid.getPromedio();
                if (dUnidadesEstimadas != null)
                {
                    BigDecimal buffer = new BigDecimal(dUnidadesEstimadas.doubleValue());
                    UtilidadesLog.debug("UnidadeEstimadas: " + buffer);
                    detalleMAVLocal.setUnidadesEstimadas(buffer);
                } else {
                  detalleMAVLocal.setUnidadesEstimadas(null);
                }

                // Crea la entrada correspondiente en Entidad AccesosSubaccesosPorDetalleMAV
                // Solamente si es NULL
                Long oidSubacceso = periOid.getOidSubacceso();
                
                if (oidSubacceso != null){
                    UtilidadesLog.debug("Pasando Subacceso... NO ES NULL");
                    AccesosSubaccesosPorDetalleMAVLocalHome accesoLocalHome = new AccesosSubaccesosPorDetalleMAVLocalHome();
                    accesoLocalHome.create(detalleMAVLocal.getOid(), periOid.getOidSubacceso());
                }  else {
                  UtilidadesLog.debug("Subacceso en MAV_BPS_INTER es NULL, no graba en MAV_DETAL_MAV_ACCES_SUBAC");
                }
                //atributo a true
                periOid.setCargado(Boolean.valueOf(true));
                UtilidadesLog.info("DetalleMAVProceso.cargarRegistro():Salida");
            }
        } catch(CreateException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(NoResultException ne) {
            UtilidadesLog.error(ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(PersistenceException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(NamingException ne) {
            UtilidadesLog.error(ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }
    
    private DetalleMAVLocalHome getDetalleMAVLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (DetalleMAVLocalHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/DetalleMAV"), DetalleMAVLocalHome.class);
    }
    
}