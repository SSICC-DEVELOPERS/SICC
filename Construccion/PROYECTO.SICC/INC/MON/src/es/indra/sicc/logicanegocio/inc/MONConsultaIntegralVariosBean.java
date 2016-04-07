package es.indra.sicc.logicanegocio.inc;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class MONConsultaIntegralVariosBean implements SessionBean {
    private SessionContext sessionContext;
    
    public void ejbCreate()   {   }
    public void ejbActivate()   {   }
    public void ejbPassivate()   {   }
    public void ejbRemove()   {  }

    public void setSessionContext(SessionContext ctx)   {
        this.sessionContext = ctx;
    }

    /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public DTOSalida 
        consultarDetalleRecomendacion(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("MONConsultaIntegralVariosBean.consultarDetalle"+
        "Recomendacion(DTOCabeceraConsultaIntegral dto): Entrada");		
		DTOSalida dtoSalida = new DTOSalida();
		DAOConsultaIntegralVarios dao = new DAOConsultaIntegralVarios();
		RecordSet rs = dao.consultarDetalleRecomendacion(dto);
		dtoSalida.setResultado(rs);
		UtilidadesLog.info("MONConsultaIntegralVariosBean.consultarDetalle"+
        "Recomendacion(DTOCabeceraConsultaIntegral dto): Salida");        
		return dtoSalida;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public DTOSalida 
        consultarPremiosSeleccionados(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("MONConsultaIntegralVariosBean.consultarPremios"+
        "Seleccionados(DTOCabeceraConsultaIntegral dto): Entrada");		
		DTOSalida dtoSalida = new DTOSalida();
		DAOConsultaIntegralVarios dao = new DAOConsultaIntegralVarios();
		RecordSet rs = dao.consultarPremiosSeleccionados(dto);
		dtoSalida.setResultado(rs);
		UtilidadesLog.info("MONConsultaIntegralVariosBean.consultarPremios"+
        "Seleccionados(DTOCabeceraConsultaIntegral dto): Salida");        
		return dtoSalida;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public DTOSalida 
        consultarDetalleMotivosDescalificacion(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("MONConsultaIntegralVariosBean.consultarDetalle"+
        "MotivosDescalificacion(DTOCabeceraConsultaIntegral dto): Entrada");		
		DTOSalida dtoSalida = new DTOSalida();
		DAOConsultaIntegralVarios dao = new DAOConsultaIntegralVarios();
		RecordSet rs = dao.consultarDetalleMotivosDescalificacion(dto);
		dtoSalida.setResultado(rs);
		UtilidadesLog.info("MONConsultaIntegralVariosBean.consultarDetalle"+
        "MotivosDescalificacion(DTOCabeceraConsultaIntegral dto): Salida");        
		return dtoSalida;
	}
    
    /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       23/12/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */
    public DTOSalida 
        consultarDetallePremiosSeleccionados(DTOCabeceraConsultaIntegral dto) 
        throws MareException {
        UtilidadesLog.info("MONConsultaIntegralVariosBean.consultarDetalle"+
        "PremiosSeleccionados(DTOCabeceraConsultaIntegral dto): Entrada");                
        DTOSalida dtoSalida = new DTOSalida();
		DAOConsultaIntegralVarios dao = new DAOConsultaIntegralVarios();
		RecordSet rs = dao.consultarDetallePremiosSeleccionados(dto);
		dtoSalida.setResultado(rs);    
        UtilidadesLog.info("MONConsultaIntegralVariosBean.consultarDetalle"+
        "PremiosSeleccionados(DTOCabeceraConsultaIntegral dto): Salida");        
        return dtoSalida;
    }

    // vbongiov -- INC 014 -- 20/10/2008
    public DTOSalida consultarRecomendacionPart(DTOCabeceraConsultaIntegral dtoe) throws MareException
    {
        UtilidadesLog.info("MONConsultaIntegralVariosBean.consultarRecomendacionPart(DTOCabeceraConsultaIntegral dto): Entrada");
        DTOSalida dtoSalida = new DTOSalida();
        DAOConsultaIntegralVarios dao = new DAOConsultaIntegralVarios();
        es.indra.mare.common.mii.services.jdbcservice.RecordSet rs = dao.consultarRecomendacionPart(dtoe);
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("MONConsultaIntegralVariosBean.consultarRecomendacionPart(DTOCabeceraConsultaIntegral dto): Salida");
        return dtoSalida;
    }

    // vbongiov -- INC 014 -- 20/10/2008
    public DTOSalida consultarDetallePedidosRecomendadas(DTOCabeceraConsultaIntegral dtoe) throws MareException
    {
        UtilidadesLog.info("MONConsultaIntegralVariosBean.consultarDetallePedidosRecomendadas(DTOCabeceraConsultaIntegral dto): Entrada");
        DTOSalida dtoSalida = new DTOSalida();
        DAOConsultaIntegralVarios dao = new DAOConsultaIntegralVarios();
        es.indra.mare.common.mii.services.jdbcservice.RecordSet rs = dao.consultarDetallePedidosRecomendadas(dtoe);
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("MONConsultaIntegralVariosBean.consultarDetallePedidosRecomendadas(DTOCabeceraConsultaIntegral dto): Salida");
        return dtoSalida;
    }

    // vbongiov -- 9/02/2009 -- Cambio 20080806
    public DTOSalida consultarDetallePedidosRecomendante(DTOCabeceraConsultaIntegral dtoe) throws MareException {
        UtilidadesLog.info("MONConsultaIntegralVariosBean.consultarDetallePedidosRecomendante(DTOCabeceraConsultaIntegral dto): Entrada");
        DTOSalida dtoSalida = new DTOSalida();
        DAOConsultaIntegralVarios dao = new DAOConsultaIntegralVarios();
        es.indra.mare.common.mii.services.jdbcservice.RecordSet rs = dao.consultarDetallePedidosRecomendante(dtoe);
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("MONConsultaIntegralVariosBean.consultarDetallePedidosRecomendante(DTOCabeceraConsultaIntegral dto): Salida");
        return dtoSalida;
    }
}
