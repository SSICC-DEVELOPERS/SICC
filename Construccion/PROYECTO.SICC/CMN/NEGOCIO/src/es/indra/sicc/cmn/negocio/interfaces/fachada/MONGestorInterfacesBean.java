package es.indra.sicc.cmn.negocio.interfaces.fachada;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.interfaces.GestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.InfoRegistroLote;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;



/*
 * 16-05-2005 - rgiorgi: cambio por inc. 18257
 * */
public class MONGestorInterfacesBean implements SessionBean 
{
  private static final String ID_NUM_LOTE = "idNumeroLote";
  private static final int ANCHO_DESCRIPCION = 40;
  private static final int ANCHO_CRITERIOS = 256;
  private static final int ANCHO_OBSERVACIONES = 500;

  private GestorInterfaces gestor;

  public void ejbCreate() throws  MareException, InterfacesException
  {
      UtilidadesLog.info("MONGestorInterfacesBean.ejbCreate(): Entrada");
      
    try 
    {
      UtilidadesLog.debug("HACE UN NEW DE GestorInterfaces");
      gestor = new GestorInterfaces();
    } catch( InterfacesException iex ) 
    {
      UtilidadesLog.debug("InterfacesException");
      UtilidadesLog.error( iex.getMotivo() );
	  UtilidadesLog.error( iex.getEx().getCause() );
	  throw iex;
    }
     UtilidadesLog.info("MONGestorInterfacesBean.ejbCreate(): Salida");
  }


  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx)
  {
  }

  public InterfazInfo crearInterfaz(String codigo, Long pais) throws InterfacesException, MareException {
    UtilidadesLog.info("MONGestorInterfacesBean.crearInterfaz(String codigo, Long pais): Entrada");
    InterfazInfo ii = gestor.crearInterfaz( codigo, obtenerNumeroLoteInterno(), pais );
    UtilidadesLog.info("MONGestorInterfacesBean.crearInterfaz(String codigo, Long pais): Salida");
    return ii;
  }

  public void anyadirRegistro(InterfazInfo interfaz, IRegistroSicc registro) throws InterfacesException, MareException {
    UtilidadesLog.info("MONGestorInterfacesBean.anyadirRegistro(): Entrada");
    gestor.anyadirRegistro( interfaz, registro );
    UtilidadesLog.info("MONGestorInterfacesBean.anyadirRegistro(): Salida");
  }

  public void enviarInterfaz(InterfazInfo interfazInfo) throws InterfacesException, MareException {
    UtilidadesLog.info("MONGestorInterfacesBean.enviarInterfaz(): Entrada");
    gestor.enviarInterfaz( interfazInfo );
    InfoRegistroLote infoLote = gestor.obtenerInfoRegistroLote( interfazInfo );
    registrarLote( infoLote );
    UtilidadesLog.info("MONGestorInterfacesBean.enviarInterfaz(): Salida");
  }

  public void recargarInterfaces() throws InterfacesException, MareException {
    UtilidadesLog.info("MONGestorInterfacesBean.recargarInterfaces(): Entrada");
    gestor.recargarInterfaces();
    UtilidadesLog.info("MONGestorInterfacesBean.recargarInterfaces(): Salida");
  }

	public void registrarError(DTOINTError dtoError) throws InterfacesException {
        UtilidadesLog.info("MONGestorInterfacesBean.registrarError(): Entrada");
		gestor.registrarError( dtoError );
        UtilidadesLog.info("MONGestorInterfacesBean.registrarError(): Salida");
	}


  /**
   * Obtencion del numeto de lote interno de forma exclusiva.
   * @cambio RI 20090892
   * @autor gdmarzi
   */
  public String obtenerNumeroLoteInterno() throws MareException {
        UtilidadesLog.info("MONGestorInterfacesBean.obtenerNumeroLoteInterno(): Entrada");
        StringBuffer consulta = new StringBuffer();
        StringBuffer insert = new StringBuffer();
        StringBuffer update = new StringBuffer();
        RecordSet rs = null;        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String cadenaFechaActual;
        String cadenaFechaCmn;
        Integer contador;
        String numeroLote;
        
        consulta.append(" SELECT OID_NUME_LOTE, NUM_CONT, VAL_CADE_FECH ");
        consulta.append(" FROM CMN_NUMER_LOTE ");
        consulta.append(" WHERE OID_NUME_LOTE = '" + ID_NUM_LOTE + "' " );
        consulta.append(" FOR UPDATE ");
        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        cadenaFechaActual = this.obtenerCadenaFechaActual();

        if (rs.esVacio()) {
            cadenaFechaCmn = cadenaFechaActual;
            contador = 1;

            insert.append(" INSERT INTO CMN_NUMER_LOTE ( ");
            insert.append("   OID_NUME_LOTE, ");
            insert.append("   NUM_CONT, ");
            insert.append("   VAL_CADE_FECH ");
            insert.append(" ) VALUES ( '" + ID_NUM_LOTE + "' " );
            insert.append(" , " + contador );
            insert.append(" , '" + cadenaFechaCmn + "' " );
            insert.append("  ) ");
            try {
                bs.dbService.executeUpdate(insert.toString());
            } catch (Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

        } else {
            cadenaFechaCmn = (String)rs.getValueAt(0, "VAL_CADE_FECH");
            contador = new Integer(((BigDecimal)rs.getValueAt(0, "NUM_CONT")).intValue());

            if( ! cadenaFechaActual.equals( cadenaFechaCmn ) ) {
                cadenaFechaCmn = cadenaFechaActual;
                contador = 0;
            }

            contador = contador + 1;
            
            update.append(" UPDATE CMN_NUMER_LOTE ");
            update.append(" SET NUM_CONT = " + contador + ", ");
            update.append(" VAL_CADE_FECH = '" + cadenaFechaCmn + "' " );
            update.append(" WHERE OID_NUME_LOTE = '" + ID_NUM_LOTE + "' " );
            try {
                bs.dbService.executeUpdate(update.toString());
            } catch (Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        numeroLote = cadenaFechaCmn + this.formatearContador(contador);

        UtilidadesLog.info("MONGestorInterfacesBean.obtenerNumeroLoteInterno(): Salida");

        return numeroLote;
    }


    private String obtenerCadenaFechaActual() {
            Calendar calendar = Calendar.getInstance();
            String anyo = new Integer( calendar.get(Calendar.YEAR) ).toString();
            String mes = new Integer( calendar.get(Calendar.MONTH) + 1 ).toString();
            String dia = new Integer( calendar.get(Calendar.DATE) ).toString();
            if( mes.length() == 1 )
                    mes = "0" + mes;
            if( dia.length() == 1 )
                    dia = "0" + dia;

            return anyo + mes + dia;
    }

    private String formatearContador(Integer contador) {
            String contadorStr = contador.toString();
            int numCeros = 4 - contadorStr.length();
            for( int i = 0; i < numCeros; i++ ) {
                contadorStr = "0" + contadorStr;
            }
            return contadorStr;
    }
  
    
  
  /**
   * CHANGELOG
   * ---------
   * dmorello, 01/07/2009 - Se reemplaza uso de entity bean HistoricoLotesLocal por JDBC
   */
  private void registrarLote( InfoRegistroLote info ) throws InterfacesException, MareException {
    UtilidadesLog.info("MONGestorInterfacesBean.registrarLote(): Entrada");
    String descripcionLote = null;
    String criteriosConsulta = null;
    String observaciones = null;
      
    if (info.getDescripcionLote() != null) {
        if (info.getDescripcionLote().length() > ANCHO_DESCRIPCION){
            descripcionLote = info.getDescripcionLote().substring( 0, ANCHO_DESCRIPCION );        
        } else {
            descripcionLote = info.getDescripcionLote();
        }      
    }
    
    if (info.getCriteriosConsulta() != null) {
        if (info.getCriteriosConsulta().length() > ANCHO_CRITERIOS){
            criteriosConsulta = info.getCriteriosConsulta().substring( 0, ANCHO_CRITERIOS );        
        } else {
            criteriosConsulta = info.getCriteriosConsulta();
        }      
    }

    // sapaza -- PER-SiCC-2010-0432 -- 08/07/2010
    if (info.getObservaciones() != null) {
        if (info.getObservaciones().length() > ANCHO_OBSERVACIONES){
            observaciones = info.getObservaciones().substring( 0, ANCHO_OBSERVACIONES );        
        } else {
            observaciones = info.getObservaciones();
        }      
    }
    
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
    StringBuffer insert = new StringBuffer();
    Vector params = new Vector();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    insert.append("INSERT INTO INT_HISTO_LOTES ");
    insert.append("(COD_INTE");
    insert.append(", NUM_LOTE");
    insert.append(", PAIS_OID_PAIS");
    insert.append(", FEC_INIC_PROC");
    insert.append(", FEC_FIN_PROC");
    insert.append(", VAL_DESC_LOTE");
    insert.append(", NUM_REGI_PROC");
    insert.append(", NUM_REGI_ERRO");
    insert.append(", VAL_OBSE");
    insert.append(", VAL_CRIT_CONS");
    insert.append(", PERI_OID_PERI");
    if(info.getNumeroRegistrosErroneos()>0){
        insert.append(", IND_LOG_ERRO");
    }
    insert.append(") VALUES ");
    insert.append("(?");
    params.add(info.getCodigoInterfaz());
    insert.append(",?");
    params.add(info.getNumeroLote());
    insert.append(",?");
    params.add(info.getPais());
    insert.append(", TO_DATE(?, 'DD/MM/YYYY HH24:MI:SS')");
    params.add(sdf.format(info.getFechaInicio()));
    insert.append(", TO_DATE(?, 'DD/MM/YYYY HH24:MI:SS')");
    params.add(sdf.format(info.getFechaFin()));
    insert.append(",?");
    params.add(descripcionLote);
    insert.append(",?");
    params.add(info.getNumeroRegistrosProcesados());
    insert.append(",?");
    params.add(info.getNumeroRegistrosErroneos());
    insert.append(",?");
    params.add(observaciones);
    insert.append(",?");
    params.add(info.getCriteriosConsulta());
    insert.append(",?");
    params.add(info.getPeriodo());
    if(info.getNumeroRegistrosErroneos()>0){
        insert.append(",?");
        params.add(new Integer(1));
    }
    insert.append(")");
    
    try {
        bs.dbService.executePreparedUpdate(insert.toString(), params);
    } catch (Exception e) {
        String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
        throw new MareException(e, UtilidadesError.armarCodigoError(error));
    }
    
    UtilidadesLog.info("MONGestorInterfacesBean.registrarLote(): Salida");
  }


  public InterfazInfo obtenerInterfazInfo(String codigoInterfaz, Long pais) throws InterfacesException, MareException {
    UtilidadesLog.info("MONGestorInterfacesBean.obtenerInterfazInfo(): Entrada");
    UtilidadesLog.debug("antes de GestorInterfaces.obtenerInterfazInfo");
	InterfazInfo info = gestor.obtenerInterfazInfo( codigoInterfaz );
    UtilidadesLog.debug("despues de GestorInterfaces.obtenerInterfazInfo");
	info.setNumeroLote( obtenerNumeroLoteInterno() );
	info.setPais( pais );
    UtilidadesLog.info("MONGestorInterfacesBean.obtenerInterfazInfo(): Salida");
    return info;
  }


	public String obtenerNumeroLote() throws  MareException, InterfacesException {
		return obtenerNumeroLoteInterno();
	}

	public InterfazInfo crearInterfaz(InterfazInfo interfazInfo) throws MareException, InterfacesException {
        UtilidadesLog.info("MONGestorInterfacesBean.crearInterfaz(): Entrada");
		InterfazInfo ii = gestor.crearInterfaz( 	interfazInfo.getCodigoInterfaz(), 
										interfazInfo.getNumeroLote(), 
										interfazInfo.getPais() );
        UtilidadesLog.info("MONGestorInterfacesBean.crearInterfaz(): Salida");
        return ii;
	}

  /*
   * 12-05-2005 - rgiorgi: inc.18111
   * */
	public InterfazInfo importarInterfaz(String codigoInterfaz, Long pais) throws MareException, InterfacesException {
        UtilidadesLog.info("MONGestorInterfacesBean.importarInterfaz(String codigoInterfaz, Long pais): Entrada");
        InterfazInfo ii = gestor.importarInterfaz(new InterfazInfo( codigoInterfaz, obtenerNumeroLoteInterno(), pais ));
        UtilidadesLog.info("MONGestorInterfacesBean.importarInterfaz(String codigoInterfaz, Long pais): Salida");
        return ii;
	}
  
  /*
   * 12-05-2005 - rgiorgi: inc.18111
   * */
	public InterfazInfo importarInterfaz(InterfazInfo info) throws MareException, InterfacesException {
        UtilidadesLog.info("MONGestorInterfacesBean.importarInterfaz(InterfazInfo info): Entrada");
		InterfazInfo ii = gestor.importarInterfaz( info );
        UtilidadesLog.info("MONGestorInterfacesBean.importarInterfaz(InterfazInfo info): Salida");
        return ii;
	}


	public IRegistroSicc cargarRegistro(InterfazInfo interfazInfo) throws InterfacesException, MareException {
        UtilidadesLog.info("MONGestorInterfacesBean.cargarRegistro(InterfazInfo interfazInfo): Entrada");
		IRegistroSicc irs = cargarRegistro(interfazInfo, true);
        UtilidadesLog.info("MONGestorInterfacesBean.cargarRegistro(InterfazInfo interfazInfo): Salida");
        return irs;
	}

	
	public IRegistroSicc cargarRegistro(InterfazInfo interfazInfo, boolean bCerrarInterfaz) throws  InterfacesException, MareException {
        UtilidadesLog.info("MONGestorInterfacesBean.cargarRegistro(InterfazInfo interfazInfo, boolean bCerrarInterfaz): Entrada");
		IRegistroSicc reg = gestor.cargarRegistro( interfazInfo, bCerrarInterfaz );
		if( reg == null ) {
			if (bCerrarInterfaz){
				InfoRegistroLote infoLote = gestor.obtenerInfoRegistroLote( interfazInfo );
				registrarLote( infoLote );
			}
		}
        UtilidadesLog.info("MONGestorInterfacesBean.cargarRegistro(InterfazInfo interfazInfo, boolean bCerrarInterfaz): Salida");
		return reg;
	}


	public void cerrarInterfaz(InterfazInfo interfazInfo) throws  InterfacesException, MareException {
        UtilidadesLog.info("MONGestorInterfacesBean.cerrarInterfaz(InterfazInfo interfazInfo): Entrada");
		gestor.cerrarInterfaz(interfazInfo);
		InfoRegistroLote infoLote = gestor.obtenerInfoRegistroLote( interfazInfo );
		registrarLote( infoLote );
        UtilidadesLog.info("MONGestorInterfacesBean.cerrarInterfaz(InterfazInfo interfazInfo): Salida");
	}

    //Agregado por Cristian Valenzuela - 17/10/2005
    public void reset(InterfazInfo interfazInfo) throws  MareException, InterfacesException {
        UtilidadesLog.info("MONGestorInterfacesBean.reset(InterfazInfo interfazInfo): Entrada");        
        gestor.reset(interfazInfo);        
        UtilidadesLog.info("MONGestorInterfacesBean.reset(InterfazInfo interfazInfo): Salida");
    }
    //FIN - Agregado por Cristian Valenzuela - 17/10/2005
    
    public InterfazInfo importarInterfaz(InterfazInfo info, String nombreArchivo) throws  InterfacesException, MareException {
        UtilidadesLog.info("MONGestorInterfacesBean.importarInterfaz(InterfazInfo info, String nombreArchivo): Entrada");
		InterfazInfo ii = gestor.importarInterfaz( info, nombreArchivo );
        UtilidadesLog.info("MONGestorInterfacesBean.importarInterfaz(InterfazInfo info, String nombreArchivo): Salida");
        return ii;
	}

    
}