package es.indra.sicc.logicanegocio.inc;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class MONConsultaIntegralParticularBean implements SessionBean {
    private SessionContext sessionContext;
    
    public void ejbCreate()  {   }
    public void ejbActivate()   {   }
    public void ejbPassivate()   {   }
    public void ejbRemove()  {   }

    public void setSessionContext(SessionContext ctx) {
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
        consultarDetalleConcursoSeleccionado(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("MONConsultaIntegralParticularBean.consultarDetalle"+ 
        "ConcursoSeleccionado(DTOCabeceraConsultaIntegral dto): Entrada");		
		DTOSalida dtoSalida = new DTOSalida();
		DAOConsultaIntegralParticular dao = new DAOConsultaIntegralParticular();
		RecordSet rs = dao.consultarDetalleConcursoSeleccionado(dto);
		dtoSalida.setResultado(rs);
		UtilidadesLog.info("MONConsultaIntegralParticularBean.consultarDetalle"+
        "ConcursoSeleccionado(DTOCabeceraConsultaIntegral dto): Salida");        
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
        consultarConcursoSeleccionado(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("MONConsultaIntegralParticularBean.consultar"+
        "ConcursoSeleccionado(DTOCabeceraConsultaIntegral dto): Entrada");		
		DTOSalida dtoSalida = new DTOSalida();
		DAOConsultaIntegralParticular dao = new DAOConsultaIntegralParticular();
		RecordSet rs = dao.consultarConcursoSeleccionado(dto);
		dtoSalida.setResultado(rs);
		UtilidadesLog.info("MONConsultaIntegralParticularBean.consultar"+
        "ConcursoSeleccionado(DTOCabeceraConsultaIntegral dto): Salida");        
		return dtoSalida;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public DTOSalida consultarDetalleMultinivel(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("MONConsultaIntegralParticularBean.consultar"+
        "DetalleMultinivel(DTOCabeceraConsultaIntegral dto): Entrada");		
		DTOSalida dtoSalida = new DTOSalida();
		DAOConsultaIntegralParticular dao = new DAOConsultaIntegralParticular();
		RecordSet rs = dao.consultarDetalleMultinivel(dto);
		dtoSalida.setResultado(rs);
		UtilidadesLog.info("MONConsultaIntegralParticularBean.consultar"+
        "DetalleMultinivel(DTOCabeceraConsultaIntegral dto): Salida");        
		return dtoSalida;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public DTOSalida consultarMultinivel(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("MONConsultaIntegralParticularBean.consultar"+
        "Multinivel(DTOCabeceraConsultaIntegral dto): Entrada");		
		DTOSalida dtoSalida = new DTOSalida();
		DAOConsultaIntegralParticular dao = new DAOConsultaIntegralParticular();
		RecordSet rs = dao.consultarMultinivel(dto);
		dtoSalida.setResultado(rs);
		UtilidadesLog.info("MONConsultaIntegralParticularBean.consultar"+
        "Multinivel(DTOCabeceraConsultaIntegral dto): Salida");        
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
        consultarDetallePremioArticulo(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("MONConsultaIntegralParticularBean.consultar"+
        "DetallePremioArticulo(DTOCabeceraConsultaIntegral dto): Entrada");		
		DTOSalida dtoSalida = new DTOSalida();
		DAOConsultaIntegralParticular dao = new DAOConsultaIntegralParticular();
		RecordSet rs = dao.consultarDetallePremioArticulo(dto);
		dtoSalida.setResultado(rs);
		UtilidadesLog.info("MONConsultaIntegralParticularBean.consultar"+
        "DetallePremioArticulo(DTOCabeceraConsultaIntegral dto): Salida");        
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
        consultarDetallePremioMonetario(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("MONConsultaIntegralParticularBean.consultar"+
        "DetallePremioMonetario(DTOCabeceraConsultaIntegral dto): Entrada");		
		DTOSalida dtoSalida = new DTOSalida();
		DAOConsultaIntegralParticular dao = new DAOConsultaIntegralParticular();
		RecordSet rs = dao.consultarDetallePremioMonetario(dto);
		dtoSalida.setResultado(rs);
		UtilidadesLog.info("MONConsultaIntegralParticularBean.consultar"+
        "DetallePremioMonetario(DTOCabeceraConsultaIntegral dto): Salida");        
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
        consultarDetallePremioPuntos(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("MONConsultaIntegralParticularBean.consultar"+
        "DetallePremioPuntos(DTOCabeceraConsultaIntegral dto): Entrada");		
		DTOSalida dtoSalida = new DTOSalida();
		DAOConsultaIntegralParticular dao = new DAOConsultaIntegralParticular();
		RecordSet rs = dao.consultarDetallePremioPuntos(dto);
		dtoSalida.setResultado(rs);
		UtilidadesLog.info("MONConsultaIntegralParticularBean.consultar"+
        "DetallePremioPuntos(DTOCabeceraConsultaIntegral dto): Salida");        
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
        consultarDetallePremioDescuento(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("MONConsultaIntegralParticularBean.consultar"+
        "DetallePremioDescuento(DTOCabeceraConsultaIntegral dto): Entrada");		
		DTOSalida dtoSalida = new DTOSalida();
		DAOConsultaIntegralParticular dao = new DAOConsultaIntegralParticular();
		RecordSet rs = dao.consultarDetallePremioDescuento(dto);
		dtoSalida.setResultado(rs);
		UtilidadesLog.info("MONConsultaIntegralParticularBean.consultar"+
        "DetallePremioDescuento(DTOCabeceraConsultaIntegral dto): Salida");        
		return dtoSalida;
	}

    // vbongiov -- Cambio RI 20080810 -- 6/01/2009
    public DTOSalida consultarDetalleSolicitudes(DTOCabeceraConsultaIntegral dto) throws MareException {
        UtilidadesLog.info("MONConsultaIntegralParticularBean.consultarDetalleSolicitudes(DTOCabeceraConsultaIntegral dto): Entrada");          
        DTOSalida dtoSalida = new DTOSalida();
        DAOConsultaIntegralParticular dao = new DAOConsultaIntegralParticular();
        RecordSet rs = dao.consultarDetalleSolicitudes(dto);
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("MONConsultaIntegralParticularBean.consultarDetalleSolicitudes(DTOCabeceraConsultaIntegral dto): Salida");        
        return dtoSalida;
    }
}
