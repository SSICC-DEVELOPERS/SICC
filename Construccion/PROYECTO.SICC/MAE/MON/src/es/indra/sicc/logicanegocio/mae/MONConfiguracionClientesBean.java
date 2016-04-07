package es.indra.sicc.logicanegocio.mae;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.mae.DTOClasificaciones;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.dtos.mae.DTOTipoSubtipoCliente;
import es.indra.sicc.entidades.mae.ClienteTipoSubTipoLocal;
import es.indra.sicc.entidades.mae.ClienteTipoSubTipoLocalHome;
import es.indra.sicc.entidades.mae.TipoDocumentoLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.UtilidadesLog;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONConfiguracionClientesBean implements SessionBean, IConfiguracionClientes {
    private SessionContext ctx;

    public void ejbCreate() {}

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public DTOTipoSubtipo obtenerTipoSubtipo(DTOBelcorp dto)throws MareException {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTipoSubtipo(DTOBelcorp): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        DTOTipoSubtipo dtoR = dao.obtenerTipoSubtipo(dto);
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTipoSubtipo(DTOBelcorp): Salida"); 
        return dtoR;
    }

    public DTOClasificaciones obtenerClasificaciones(DTOBelcorp dto)throws MareException {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerClasificaciones(DTOBelcorp): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        DTOClasificaciones dtoR = dao.obtenerClasificaciones(dto);
        UtilidadesLog.info("MONConfiguracionClientes.obtenerClasificaciones(DTOBelcorp): Salida"); 
        return dtoR;
    }

    public DTOSalida obtenerSubtipos(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerSubtipos(DTOOID): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        DTOSalida dtoR = dao.obtenerSubtipos(dto);
        UtilidadesLog.info("MONConfiguracionClientes.obtenerSubtipos(DTOOID): Salida"); 
        return dtoR;
    }

    public DTOSalida obtenerTipoClasificacion(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTipoClasificacion(DTOOID): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        DTOSalida dtoR = dao.obtenerTipoClasificacion(dto);
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTipoClasificacion(DTOOID): Salida"); 
        return dtoR;
    }

    public DTOSalida obtenerClasificacionesPorTipo(DTOOID dto)throws MareException {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerClasificacionesPorTipo(DTOOID): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        DTOSalida dtoR = dao.obtenerClasificacionesPorTipo(dto);
        UtilidadesLog.info("MONConfiguracionClientes.obtenerClasificacionesPorTipo(DTOOID): Salida"); 
        return dtoR;
    }

    public RecordSet obtenerClasificacionesCliente(Long tipoClasificacion, String tipoCliente, Long idioma)
        throws MareException {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerClasificacionesCliente(tipoClasificacion, tipoCliente, idioma): Entrada"); 
        UtilidadesLog.info("MONConfiguracionClientes.obtenerClasificacionesCliente(tipoClasificacion, tipoCliente, idioma): Salida"); 
        return DAOMAEConfiguracionClientes.obtenerClasificacionesCliente(tipoClasificacion, tipoCliente, idioma);
    }

    /*
     * Inc. 2259.
     * */
    public DTOClasificaciones obtenerClasificacionesSubtipo(DTOOID subtipo)throws MareException {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerClasificacionesSubtipo(DTOOID): Entrada"); 
        Long[] oids = new Long[1];
        oids[0] = subtipo.getOid();

        DTOOIDs dtos = new DTOOIDs();
        dtos.setOids(oids);
        dtos.setOidIdioma(subtipo.getOidIdioma());

        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        DTOClasificaciones dtoClasificaciones = dao.obtenerClasificacionesSubtipo(dtos);
        UtilidadesLog.info("MONConfiguracionClientes.obtenerClasificacionesSubtipo(DTOOID): Salida"); 

        return dtoClasificaciones;
    }

    public Long obtenerOidClienteTipoSubtipo(Long cliente, Long tipo) throws MareException {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerOidClienteTipoSubtipo(cliente, tipo): Entrada"); 
        ClienteTipoSubTipoLocal tipSubt;

        try {
            if((cliente == null) || (tipo == null))
                throw new IllegalArgumentException("parametros inválidos");

            tipSubt = new ClienteTipoSubTipoLocalHome().findByClienteTipo(cliente, tipo);
            UtilidadesLog.info("MONConfiguracionClientes.obtenerOidClienteTipoSubtipo(cliente, tipo): Salida"); 

            return tipSubt.getOid();
        } catch(NoResultException nre) {
            ctx.setRollbackOnly();
            throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(PersistenceException pe) {
            ctx.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }

    public DTOSalida obtenerTiposDireccion(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTiposDireccion(DTOBelcorp): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        DTOSalida dto = new DTOSalida();
        dto.setResultado(dao.obtenerTiposDireccion(dtoe));
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTiposDireccion(DTOBelcorp): Salida"); 
        return dto;
    }

    public DTOSalida obtenerTipos(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTipos(DTOBelcorp): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        DTOSalida dtoR = new DTOSalida();
        dtoR.setResultado(dao.obtenerTipos(dto));
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTipos(DTOBelcorp): Salida"); 
        return dtoR;
    }

    public DTOSalida obtenerTiposClasificacion(DTOOID subtipo)throws MareException {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTiposClasificacion(DTOOID): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTiposClasificacion(DTOOID): Salida"); 
        return dao.obtenerTipoClasificacion(subtipo);
    }

    public DTOTipoSubtipoCliente obtenerTipoPrincipalCliente(Long cliente)throws MareException {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTipoPrincipalCliente(cliente): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTipoPrincipalCliente(cliente): Salida"); 
        return dao.obtenerTipoPrincipalCliente(cliente);
    }

    public DTOSalida obtenerTiposDocumentoCliente(DTOOID cliente)throws MareException {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTiposDocumentoCliente(DTOOID): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTiposDocumentoCliente(DTOOID): Salida"); 
        return new DTOSalida(dao.obtenerTiposDocumentoCliente(cliente));
    }

    public RecordSet obtenerTipoDocumentoLegal(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTipoDocumentoLegal(DTOOID): Entrada"); 
		    RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = null;
		
        try {
            bs = BelcorpService.getInstance();

        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
		
		try{			

      query.append("   SELECT td.oid_tipo_docu OID, td.des_tipo_docu  ");
      query.append("     FROM fac_tipo_docum td, mae_tipo_docum mtd  ");
      query.append("    WHERE td.oid_tipo_docu = mtd.tido_oid_tipo_docu   ");
      query.append("      AND mtd.oid_tipo_docu = " + dto.getOid());
      query.append(" ORDER BY 2  ");

			respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    UtilidadesLog.info("MONConfiguracionClientes.obtenerTipoDocumentoLegal(DTOOID): Salida"); 

		return respuesta;
    }


    public DTOSalida obtenerTiposTarjeta(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTiposTarjeta(DTOBelcorp): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTiposTarjeta(DTOBelcorp): Salida"); 
        return new DTOSalida(dao.obtenerTiposTarjeta(dto));
    }


    /* private TipoDocumentoLocalHome getTipoDocumentoLocalHome() throws NamingException {
      final InitialContext context = new InitialContext();
      return (TipoDocumentoLocalHome)context.lookup("java:comp/env/TipoDocumento");
     }*/
    private TipoDocumentoLocalHome getTipoDocumentoLocalHome()throws MareException {
        UtilidadesLog.info("MONConfiguracionClientes.getTipoDocumentoLocalHome(): Entrada"); 
        String codigoError;
        TipoDocumentoLocalHome localHome = null;
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            localHome = (TipoDocumentoLocalHome)bs.ejbLocator.getEntityLocalHome("java:comp/env/TipoDocumento");
        } catch(MareServiceException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONConfiguracionClientes.getTipoDocumentoLocalHome(): Salida"); 

        return localHome;
    }

  /**
   * 
   */
  public DTOSalida obtenerTiposDocumentoPorPais(DTOBelcorp DTOE) throws MareException  {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTiposDocumentoPorPais(DTOBelcorp): Entrada"); 
        DTOSalida dtoSalida = new DTOSalida();
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        RecordSet tiposDocumentos = dao.obtenerTiposDocumentoPorPais(DTOE);
        dtoSalida.setResultado(tiposDocumentos);
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTiposDocumentoPorPais(DTOBelcorp): Salida"); 
        
        return dtoSalida;
  }

    public DTOTipoSubtipoCliente obtenerTipoSubtipoCliente(Long cliente) throws MareException   {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTipoSubtipoCliente(DTOBelcorp): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        UtilidadesLog.info("MONConfiguracionClientes.obtenerTipoSubtipoCliente(DTOBelcorp): Salida"); 
        return dao.obtenerTipoSubtipoCliente(cliente);
    }

    public DTOTipoSubtipoCliente obtenerPrimerTipoClienteNoPrincipal(Long cliente) throws MareException {
        UtilidadesLog.info("MONConfiguracionClientes.obtenerPrimerTipoClienteNoPrincipal(cliente): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        UtilidadesLog.info("MONConfiguracionClientes.obtenerPrimerTipoClienteNoPrincipal(cliente): Salida"); 
        return dao.obtenerPrimerTipoClienteNoPrincipal(cliente);
    }

}