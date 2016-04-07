/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

	/**
	 * Sistema:		Belcorp
	 * Modulo:	   	EDU 
	 * Submódulo:		
	 * Componente:		ENTIDADES
	 * Fecha:05/03/2003
	 * Observaciones:     	Componente construido de acuerdo a la especificación del 
	 *          Modelo de Componentes SICC-DMCO-EDU-201-301 EDU Paquete 
     *          Educacion v1.1 (Subido al portal el //2004)
	 * Descripcion:		Este componente mapea a la tabla EDU_MATRI_CURSO 
	 * @version		1.0
	 * @autor		Gracia Torres
   * @cambio  Emilio Iraola 22/09/2006 MAE-015 "Integridad referencial" BELC300024082:
   *          Ya no utilizo el atributo capacitador (clasif capac) pero agrego
   *          clienteCapacitador, tipoClasificacionCapacitador y subtipoClienteCapacitador
	 */
 
package es.indra.sicc.entidades.edu;

import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.BelcorpService;
import java.util.Iterator;
import java.util.Vector;
import java.util.Collection;
import java.sql.Date;
import java.math.BigDecimal;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.exception.MareException;
import org.apache.commons.logging.Log;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.FinderException;
import javax.ejb.EJBException;
import javax.ejb.RemoveException;

public class MatrizCursosBean implements EntityBean {
    public EntityContext context;
    public Long oid;
    public Long pais;
    public Long plantilla;
    public Long capacitador;
    public Long canal;
    public Long marca;
    public Long subgerencia;
    public Long territorio;
    public Long clasificacion;
    public Long frecuencia;
    public Long regalo;
    public Long region;
    public Integer codigo;
    public Integer numeroParticipantes;
    public Boolean accesoDataMart;
    public String objetivo;
    public String contenido;
    public Date fechaDisponible;
    public Date fechaLanzamiento;
    public Date fechaFin;
    public Boolean alcance;
    public Boolean bloqueoExtemporaneas;
    public String relacionMaterial;
    public Integer numeroOrdenes;
    public BigDecimal montoVentas;
    public Integer numeroCampanyas;
    public Date fechaUltimo;
    public Date fechaConcreta;
    public Integer numeroUnidades;
    public Long momentoEntrega;
    public Boolean condicionPedido;
    public Boolean controlMorosidad;
    public Date fechaIngreso;
    public String descripcion;
    public Long zona;
    public Long seccion;
    public Long periodoIniComparativo;
    public Long periodoFinComparativo;
    public Long periodoIniConstancia;
    public Long periodoFinConstancia;
    public Long periodoIngreso;
    public Long tipo;
    public Long tipoClasificacion;
    public Long tipoCliente;
    public Long subtipoCliente;
    public Long statusCliente;
    public Long acceso;
    public Boolean controlFuncion;
    public Long clienteCapacitador;
    public Long subtipoClienteCapacitador;
    public Long tipoClasificacionCapacitador;
    
    
    
    public Long ejbCreate() {
        return null;
    }

    public void ejbPostCreate() {
    }

    public Long ejbCreate(Long pais, Long plantilla, Long canal, Long marca, Long acceso, 
            Long territorio, Long clasificacion, Long frecuencia, Long regalo, 
            Long subgerencia, Long region, Long zona, Long seccion, 
            Long periodoIniComparativo, Long periodoFinComparativo, 
            Long periodoIniConstancia, Long periodoFinConstancia, 
            Long periodoIngreso, Long tipo, String objetivo, String contenido, 
            String relacionMaterial, BigDecimal montoVentas, Date fechaDisponible, 
            Date fechaLanzamiento, Date fechaFin, Date fechaUltimo, Date fechaConcreta, 
            Date fechaIngreso, Integer numeroParticipantes, Integer numeroOrdenes, 
            Integer numeroCampanyas, Integer numeroUnidades, String descripcion, 
            Boolean accesoDataMart, Boolean alcance, Boolean bloqueoExtemporaneas, 
            Long momentoEntrega, Boolean condicionPedido, Boolean controlMorosidad, 
            //Long capacitador, Long subtipoCliente, Long tipoClasificacion, 
            Long clienteCapacitador, Long subtipoCliente, Long tipoClasificacion, 
            Long statusCliente, Long tipoCliente, Boolean controlFuncion, 
            Integer codigoCurso, Long subtipoClienteCapacitador, 
            Long tipoClasificacionCapacitador) throws  CreateException, DuplicateKeyException  {
	
        this.pais = pais;
        this.setPlantilla(plantilla);
        this.setCanal(canal);
        this.setMarca(marca);
        this.setAcceso(acceso);
        this.setTipo(tipo);
        this.setControlFuncion(controlFuncion);

        Vector vector= new Vector();
		try {
			// Asignar el nuevo oid
			setOid(SecuenciadorOID.obtenerSiguienteValor("EDU_MCUR_SEQ"));
		} catch (MareException me) {
			throw new CreateException();
		}

        //cambio por incidencia 19756
        setCodigo(codigoCurso);
        
        StringBuffer query  = new StringBuffer(" INSERT INTO EDU_MATRI_CURSO("+
            "oid_curs, "+
            "pais_oid_pais, "+
            "cplc_oid_cabe_plan_curs, "+
            "cod_curs, "+
            "cana_oid_cana, "+
            "marc_oid_marc, "+
            "acce_oid_acce, "+
            "ticu_oid_tipo_curs, "+
            "ind_ctrl_func");

        vector.add(this.getOid());
        vector.add(this.getPais());
        vector.add(this.getPlantilla());
        vector.add(this.getCodigo());
        vector.add(this.getCanal());
        vector.add(this.getMarca());
        vector.add(this.getAcceso());
        vector.add(this.getTipo());
        vector.add(this.isControlFuncion());

        if (territorio != null) {
            this.setTerritorio(territorio);
            query.append( ", TERR_OID_TERR");
            vector.add(territorio);
        }
        if (clasificacion != null) {
            this.setClasificacion(clasificacion);
            query.append( ", CLAS_OID_CLAS");
            vector.add(clasificacion);
        }
        if (frecuencia != null) {
            this.setFrecuencia(frecuencia);
            query.append( ", FRCU_OID_FREC");
            vector.add(frecuencia);
        }
        if (regalo != null) {
            this.setRegalo(regalo);
            query.append( ", REGA_OID_REGA");
            vector.add(regalo);
        }
        if (subgerencia != null) {
            this.setSubgerencia(subgerencia);
            query.append( ", ZSGV_OID_SUBG_VENT");
            vector.add(subgerencia);
        }
        if (region != null) {
            this.setRegion(region);
            query.append( ", ZORG_OID_REGI");
            vector.add(region);
        }
        if (zona != null) {
            this.zona = zona;
            query.append( ", ZZON_OID_ZONA");
            vector.add(zona);
        }
        if (seccion != null) {
            this.setSeccion(seccion);
            query.append( ", ZSCC_OID_SECC");
            vector.add(seccion);
        }
        if (periodoIniComparativo != null) {
            this.setPeriodoIniComparativo(periodoIniComparativo);
            query.append( ", PERD_OID_PERI_INIC_COMP ");
            vector.add(periodoIniComparativo);
        }

        if (periodoFinComparativo != null) {
            this.setPeriodoFinComparativo(periodoFinComparativo);
            query.append( ", PERD_OID_PERI_FINA_COMP");
            vector.add(periodoFinComparativo);
        }
        if (periodoIniConstancia != null) {
            this.setPeriodoIniConstancia(periodoIniConstancia);
            query.append( ", PERD_OID_PERI_INIC_CONS");
            vector.add(periodoIniConstancia);
        }
        if (periodoFinConstancia != null) {
            this.setPeriodoFinConstancia(periodoFinConstancia);
            query.append( ", PERD_OID_PERI_FINA_CONS");
            vector.add(periodoFinConstancia);
        }
        if (periodoIngreso != null) {
            this.setPeriodoIngreso(periodoIngreso);
            query.append( ", PERD_OID_PERI_INGR");
            vector.add(periodoIngreso);
        }
        if (objetivo != null) {
            this.setObjetivo(objetivo);
            query.append( ", VAL_OBJE_CURS");
            vector.add(objetivo);
        }
        if (contenido != null) {
            this.setContenido(contenido);
            query.append( ", VAL_CONT_CURS");
            vector.add(contenido);
        }
        if (relacionMaterial != null) {
            this.setRelacionMaterial(relacionMaterial);
            query.append( ", VAL_RELA_MATE_CURS");
            vector.add(relacionMaterial);
        }
        if (montoVentas != null) {
            this.setMontoVentas(montoVentas);
            query.append( ", VAL_MONT_VENT");
            vector.add(montoVentas);
        }
        if (fechaDisponible != null) {
            this.setFechaDisponible(fechaDisponible);
            query.append( ", FEC_DISP_CURS");
            vector.add(this.getFechaDisponible());
        }

        if (fechaLanzamiento != null) {
            this.setFechaLanzamiento(fechaLanzamiento);
            query.append( ", FEC_LANZ");
            vector.add(this.getFechaLanzamiento());
        }

        if (fechaFin != null) {
            this.setFechaFin(fechaFin);
            query.append( ", FEC_FIN_CURS");
            vector.add(this.getFechaFin());
        }
        if (fechaUltimo != null) {
            this.setFechaUltimo(fechaUltimo);
            query.append( ", FEC_ULTI_CURS ");
            vector.add(this.getFechaUltimo());
        }
        if (fechaConcreta != null) {
            this.setFechaConcreta(fechaConcreta);
            query.append( ", FEC_CONC_CURS");
            vector.add(this.getFechaConcreta());
        }

        if (fechaIngreso != null) {
            this.setFechaIngreso(fechaIngreso);
            query.append( ", FEC_INGR");
            vector.add(fechaIngreso);
        }
        if (numeroParticipantes != null) {
            this.setNumeroParticipantes(numeroParticipantes);
            query.append( ", NUM_PART");
            vector.add(numeroParticipantes);
        }
        if (numeroOrdenes != null) {
            this.setNumeroOrdenes(numeroOrdenes);
            query.append( ", NUM_ORDE");
            vector.add(numeroOrdenes);
        }
        if (numeroCampanyas != null) {
            this.setNumeroCampanyas(numeroCampanyas);
            query.append( ", NUM_CAMPA");
            vector.add(numeroCampanyas);
        }
        if (numeroUnidades != null) {
            this.setNumeroUnidades(numeroUnidades);
            query.append( ", NUM_UNID");
            vector.add(numeroUnidades);
        }
        if (descripcion != null) {
            this.setDescripcion(descripcion);
            query.append( ", DES_CURS");
            vector.add(descripcion);
        }
        if (accesoDataMart != null) {
            this.setAccesoDataMart(accesoDataMart);
            query.append( ", IND_ACCE_DMRT");
            vector.add(accesoDataMart);
        }
        if (alcance != null) {
            this.setAlcance(alcance);
            query.append( ", IND_ALCA_GEOG");
            vector.add(alcance);
        }
        if (bloqueoExtemporaneas != null) {
            this.setBloqueoExtemporaneas(bloqueoExtemporaneas);
            query.append( ", IND_BLOQ_EXTE");
            vector.add(bloqueoExtemporaneas);
        }
        if (momentoEntrega != null) {
            this.setMomentoEntrega(momentoEntrega);
            query.append( ", MOME_OID_MOME_ENTR");
            vector.add(momentoEntrega);
        }
        if (condicionPedido != null) {
            this.setCondicionPedido(condicionPedido);
            query.append( ", IND_COND_PEDI");
            vector.add(condicionPedido);
        }
        if (controlMorosidad != null) {
            this.setControlMorosidad(controlMorosidad);
            query.append( ", IND_CTRL_MORO");
            vector.add(controlMorosidad);
        }
        /*  if (capacitador != null) {
            this.setCapacitador(capacitador);
            query.append( ", CLCL_OID_CLIE_CLAS_CAPA");
            vector.add(capacitador);
        } */
        if (clienteCapacitador != null) {
			      this.setClienteCapacitador(clienteCapacitador);
            query.append( ", CLIE_OID_CLIE_CAPA");
            vector.add(clienteCapacitador);
        }
        if (subtipoCliente != null) {
            this.setSubtipoCliente(subtipoCliente);
            query.append( ", SBTI_OID_SUBT_CLIE");
            vector.add(subtipoCliente);
        }
        if (tipoClasificacion != null) {
            this.setTipoClasificacion(tipoClasificacion);
            query.append( ", TCCL_OID_TIPO_CLAS");
            vector.add(tipoClasificacion);
        }
        if (statusCliente != null) {
            this.setStatusCliente(statusCliente);
            query.append( ", ESTA_OID_ESTA_CLIE");
            vector.add(statusCliente);
        }
        if (tipoCliente != null) {
            this.setTipoCliente(tipoCliente);
            query.append(", TICL_OID_TIPO_CLIE");
            vector.add(tipoCliente);
        }
        
        if (subtipoClienteCapacitador != null) {
            this.setSubtipoClienteCapacitador(subtipoClienteCapacitador);
            query.append(", SBTI_OID_SUBT_CLIE_CAPA");
            vector.add(subtipoClienteCapacitador);
        }
        
        if (tipoClasificacionCapacitador != null) {
            this.setTipoClasificacionCapacitador(tipoClasificacionCapacitador);
            query.append(", TCCL_OID_TIPO_CLAS_CAPA");
            vector.add(tipoClasificacionCapacitador);
        }
                
        
        int cantElementos = vector.size();
        query.append(") VALUES (?");
        
        for (int i = 1; i < cantElementos; i++) {
            query.append(", ?");
        }
        query.append(")");

        try {
            ejecuta(query.toString(), vector);
		} catch (EJBException ejbe) {
			String falloSQL = (ejbe.getCausedByException()).getMessage();
			if (falloSQL.indexOf("ORA-00001") != -1)
				throw new DuplicateKeyException();
			else if (falloSQL.indexOf("ORA-02291") != -1)
				throw new CreateException();
			else
				throw ejbe;
		}

        return getOid();
    }



    public void ejbPostCreate(Long pais, Long plantilla, Long canal, Long marca, Long acceso, 
                              Long territorio, Long clasificacion, Long frecuencia, Long regalo, 
                              Long subgerencia, Long region, Long zona, Long seccion, 
                              Long periodoIniComparativo, Long periodoFinComparativo, 
                              Long periodoIniConstancia, Long periodoFinConstancia, 
                              Long periodoIngreso, Long tipo, String objetivo, String contenido, 
                              String relacionMaterial, BigDecimal montoVentas, Date fechaDisponible, 
                              Date fechaLanzamiento, Date fechaFin, Date fechaUltimo, Date fechaConcreta, 
                              Date fechaIngreso, Integer numeroParticipantes, Integer numeroOrdenes, 
                              Integer numeroCampanyas, Integer numeroUnidades, String descripcion, 
                              Boolean accesoDataMart, Boolean alcance, Boolean bloqueoExtemporaneas, 
                              Long momentoEntrega, Boolean condicionPedido, Boolean controlMorosidad, 
                              //Long capacitador, Long subtipoCliente, Long tipoClasificacion, 
                              Long clienteCapacitador, Long subtipoCliente, Long tipoClasificacion, 
                              Long statusCliente, Long tipoCliente, Boolean controlFuncion, 
                              Integer codigoCurso, Long subtipoClienteCapacitador,
                              Long tipoClasificacionCapacitador) throws  CreateException, DuplicateKeyException {
        // TODO:  Add custom implementation.
    }


    public Long ejbFindByPrimaryKey(Long primaryKey) throws FinderException{
        Vector vector= new Vector();
        String query  = " SELECT OID_CURS FROM EDU_MATRI_CURSO WHERE OID_CURS = ?";
                   
        RecordSet respuesta;
        BelcorpService bs;
        vector.add(primaryKey);
        try {
            respuesta = ejecutaQuery(query.toString(), vector);
        } catch (EJBException exception) {
                throw new EJBException();
        }

        if (respuesta.esVacio()) {
            throw new FinderException();
        }
        return primaryKey;
    }

    public void ejbActivate() {
    }

    public void ejbLoad() {
        Long primaryKey = (Long)context.getPrimaryKey();
        Vector vector= new Vector();
        String query  = " SELECT * FROM EDU_MATRI_CURSO WHERE OID_CURS = " + primaryKey.longValue();
                   
        RecordSet respuesta;
        BelcorpService bs;
        try {
                bs = BelcorpService.getInstance();
                respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
                throw new EJBException(e);
        } catch (Exception exception) {
                throw new EJBException(exception);
        }

        if (!respuesta.esVacio()) {
            setOid( new Long(((BigDecimal)respuesta.getValueAt(0, "OID_CURS")).longValue()));
            setCodigo( new Integer(((BigDecimal)respuesta.getValueAt(0, "COD_CURS")).intValue()));

            if (respuesta.getValueAt(0, "IND_ACCE_DMRT") != null) {
                if (((BigDecimal)respuesta.getValueAt(0, "IND_ACCE_DMRT")).intValue()==1)
                    setAccesoDataMart(new Boolean(true));
                else
                    setAccesoDataMart(new Boolean(false));
            } else
                setAccesoDataMart(null);

            if (respuesta.getValueAt(0, "IND_ALCA_GEOG") != null) {
                if (((BigDecimal)respuesta.getValueAt(0, "IND_ALCA_GEOG")).intValue()==1)
                    setAlcance(new Boolean(true));
                else
                    setAlcance(new Boolean(false));
            } else
                setAlcance(null);

            if (respuesta.getValueAt(0, "IND_BLOQ_EXTE") != null) {
                if (((BigDecimal)respuesta.getValueAt(0, "IND_BLOQ_EXTE")).intValue()==1)
                    setBloqueoExtemporaneas(new Boolean(true));
                else
                    setBloqueoExtemporaneas(new Boolean(false));
            } else
                setBloqueoExtemporaneas(null);

            setMomentoEntrega(respuesta.getValueAt(0, "MOME_OID_MOME_ENTR") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "MOME_OID_MOME_ENTR")).longValue()):null);
            
            if (respuesta.getValueAt(0, "IND_COND_PEDI") != null) {
                if (((BigDecimal)respuesta.getValueAt(0, "IND_COND_PEDI")).intValue()==1)
                    setCondicionPedido(new Boolean(true));
                else
                    setCondicionPedido(new Boolean(false));
            } else
                 setCondicionPedido(null);

            if (respuesta.getValueAt(0, "IND_CTRL_MORO") != null) {
                if (((BigDecimal)respuesta.getValueAt(0, "IND_CTRL_MORO")).intValue()==1)
                    setControlMorosidad(new Boolean(true));
                else
                    setControlMorosidad(new Boolean(false));
            } else
                setControlMorosidad(null);

            if (respuesta.getValueAt(0, "IND_CTRL_FUNC") != null) {
                if (((BigDecimal)respuesta.getValueAt(0, "IND_CTRL_FUNC")).intValue()==1)
                    setControlFuncion(new Boolean(true));
                else
                    setControlFuncion(new Boolean(false));
            } else
                 setControlFuncion(null);

            setObjetivo(respuesta.getValueAt(0, "VAL_OBJE_CURS") != null?(String)respuesta.getValueAt(0, "VAL_OBJE_CURS"):null);
            setContenido(respuesta.getValueAt(0, "VAL_CONT_CURS") != null?(String)respuesta.getValueAt(0, "VAL_CONT_CURS"):null);
            setFechaDisponible(respuesta.getValueAt(0, "FEC_DISP_CURS") != null?(Date)respuesta.getValueAt(0, "FEC_DISP_CURS"):null);
            setFechaLanzamiento(respuesta.getValueAt(0, "FEC_LANZ") != null?(Date)respuesta.getValueAt(0, "FEC_LANZ"):null);
            setFechaFin(respuesta.getValueAt(0, "FEC_FIN_CURS") != null?(Date)respuesta.getValueAt(0, "FEC_FIN_CURS"):null);
            setNumeroParticipantes(respuesta.getValueAt(0, "NUM_PART") != null?new Integer(((BigDecimal)respuesta.getValueAt(0, "NUM_PART")).intValue()):null);
            setRelacionMaterial(respuesta.getValueAt(0, "VAL_RELA_MATE_CURS") != null?(String)respuesta.getValueAt(0, "VAL_RELA_MATE_CURS"):null);
            setNumeroOrdenes(respuesta.getValueAt(0, "NUM_ORDE") != null?new Integer(((BigDecimal)respuesta.getValueAt(0, "NUM_ORDE")).intValue()):null);
            setMontoVentas(respuesta.getValueAt(0, "VAL_MONT_VENT") != null?(BigDecimal)respuesta.getValueAt(0, "VAL_MONT_VENT"):null);
            setNumeroCampanyas(respuesta.getValueAt(0, "NUM_CAMPA") != null?new Integer(((BigDecimal)respuesta.getValueAt(0, "NUM_CAMPA")).intValue()):null);
            setFechaUltimo(respuesta.getValueAt(0, "FEC_ULTI_CURS") != null?(Date)respuesta.getValueAt(0, "FEC_ULTI_CURS"):null);
            setFechaConcreta(respuesta.getValueAt(0, "FEC_CONC_CURS") != null?(Date)respuesta.getValueAt(0, "FEC_CONC_CURS"):null);
            setNumeroUnidades(respuesta.getValueAt(0, "NUM_UNID") != null?new Integer(((BigDecimal)respuesta.getValueAt(0, "NUM_UNID")).intValue()):null);
            setFechaIngreso(respuesta.getValueAt(0, "FEC_INGR") != null?(Date)respuesta.getValueAt(0, "FEC_INGR"):null);
            setDescripcion(respuesta.getValueAt(0, "DES_CURS") != null?(String)respuesta.getValueAt(0, "DES_CURS"):null);
            setTipo(respuesta.getValueAt(0, "TICU_OID_TIPO_CURS") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "TICU_OID_TIPO_CURS")).longValue()):null);
            setMarca(respuesta.getValueAt(0, "MARC_OID_MARC") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "MARC_OID_MARC")).longValue()):null);
            setCanal(respuesta.getValueAt(0, "CANA_OID_CANA") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "CANA_OID_CANA")).longValue()):null);
            setAcceso(respuesta.getValueAt(0, "ACCE_OID_ACCE") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "ACCE_OID_ACCE")).longValue()):null);
            setClasificacion(respuesta.getValueAt(0, "CLAS_OID_CLAS") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "CLAS_OID_CLAS")).longValue()):null);
            setTipoClasificacion(respuesta.getValueAt(0, "TCCL_OID_TIPO_CLAS") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "TCCL_OID_TIPO_CLAS")).longValue()):null);
            setTipoCliente(respuesta.getValueAt(0, "TICL_OID_TIPO_CLIE") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "TICL_OID_TIPO_CLIE")).longValue()):null);
            setSubtipoCliente(respuesta.getValueAt(0, "SBTI_OID_SUBT_CLIE") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "SBTI_OID_SUBT_CLIE")).longValue()):null);
            //setCapacitador(respuesta.getValueAt(0, "CLCL_OID_CLIE_CLAS_CAPA") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "CLCL_OID_CLIE_CLAS_CAPA")).longValue()):null);
            setClienteCapacitador(respuesta.getValueAt(0, "CLIE_OID_CLIE_CAPA") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "CLIE_OID_CLIE_CAPA")).longValue()):null);
            setFrecuencia(respuesta.getValueAt(0, "FRCU_OID_FREC") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "FRCU_OID_FREC")).longValue()):null);
            this.pais = respuesta.getValueAt(0, "PAIS_OID_PAIS") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "PAIS_OID_PAIS")).longValue()):null;
            setPeriodoFinComparativo(respuesta.getValueAt(0, "PERD_OID_PERI_FINA_COMP") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "PERD_OID_PERI_FINA_COMP")).longValue()):null);
            setPeriodoIniComparativo(respuesta.getValueAt(0, "PERD_OID_PERI_INIC_COMP") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "PERD_OID_PERI_INIC_COMP")).longValue()):null);
            setPeriodoIngreso(respuesta.getValueAt(0, "PERD_OID_PERI_INGR") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "PERD_OID_PERI_INGR")).longValue()):null);
            setPeriodoIniConstancia(respuesta.getValueAt(0, "PERD_OID_PERI_INIC_CONS") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "PERD_OID_PERI_INIC_CONS")).longValue()):null);
            setPeriodoFinConstancia(respuesta.getValueAt(0, "PERD_OID_PERI_FINA_CONS") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "PERD_OID_PERI_FINA_CONS")).longValue()):null);
            setPlantilla(respuesta.getValueAt(0, "CPLC_OID_CABE_PLAN_CURS") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "CPLC_OID_CABE_PLAN_CURS")).longValue()):null);
            setRegalo(respuesta.getValueAt(0, "REGA_OID_REGA") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "REGA_OID_REGA")).longValue()):null);
            setSubgerencia(respuesta.getValueAt(0, "ZSGV_OID_SUBG_VENT") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "ZSGV_OID_SUBG_VENT")).longValue()):null);
            setRegion(respuesta.getValueAt(0, "ZORG_OID_REGI") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "ZORG_OID_REGI")).longValue()):null);
            this.zona = respuesta.getValueAt(0, "ZZON_OID_ZONA") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "ZZON_OID_ZONA")).longValue()):null;
            setTerritorio(respuesta.getValueAt(0, "TERR_OID_TERR") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "TERR_OID_TERR")).longValue()):null);
            setSeccion(respuesta.getValueAt(0, "ZSCC_OID_SECC") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "ZSCC_OID_SECC")).longValue()):null);
            setStatusCliente(respuesta.getValueAt(0, "ESTA_OID_ESTA_CLIE") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "ESTA_OID_ESTA_CLIE")).longValue()):null);
            setSubtipoClienteCapacitador(respuesta.getValueAt(0, "SBTI_OID_SUBT_CLIE_CAPA") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "SBTI_OID_SUBT_CLIE_CAPA")).longValue()):null);
            setTipoClasificacionCapacitador(respuesta.getValueAt(0, "TCCL_OID_TIPO_CLAS_CAPA") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "TCCL_OID_TIPO_CLAS_CAPA")).longValue()):null);            
        } else {
            throw new EJBException();
        }
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
        /*Vector vector= new Vector();
        String query  = " DELETE FROM EDU_MATRI_CURSO WHERE OID_CURS = ?";
                   
        BelcorpService bs;
        vector.add(this.getOid());
        try {
            ejecuta(query.toString(), vector);
        } catch (Exception exception) {
                throw new EJBException(exception);
        }*/

    }
    public void ejbStore()  {
	}


    public void setEntityContext(EntityContext ctx) {
        this.context = ctx;
    }

    public void unsetEntityContext() {
        this.context = null;
    }

    public Long getOid() {
        return this.oid;
    }

    public void setOid(Long newOid) {
        this.oid = newOid;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Integer newCodigo) {
        this.codigo = newCodigo;
    }

    public Integer getNumeroParticipantes() {
        return this.numeroParticipantes;
    }

    public void setNumeroParticipantes(Integer newNumeroParticipantes) {
        this.numeroParticipantes = newNumeroParticipantes;
    }
    
    public Long getPais() {
        return this.pais;
    }

    public void setPais(Long newPais) {
        this.pais = newPais;
    }
    public Long getPlantilla(){
        return this.plantilla;
    }

    public void setPlantilla(Long newPlantilla) {
        this.plantilla = newPlantilla;
    }

    public Long getTerritorio(){
        return this.territorio;
    }

    public void setTerritorio(Long newTerritorio){
        this.territorio = newTerritorio;
    }

    public Long getClasificacion(){
        return this.clasificacion;
    }

    public void setClasificacion(Long newClasificacion){
        this.clasificacion = newClasificacion;
    }

    public Long getFrecuencia(){
        return this.frecuencia;
    }

    public void setFrecuencia(Long newFrecuencia){
        this.frecuencia = newFrecuencia;
    }

    public Long getRegalo(){
        return this.regalo;
    }

    public void setRegalo(Long newRegalo){
        this.regalo = newRegalo;
    }

    public Long getSubgerencia(){
        return this.subgerencia;
    }

    public void setSubgerencia(Long newSubgerencia){
        this.subgerencia = newSubgerencia;
    }

    public Long getRegion(){
        return this.region;
    }

    public void setRegion(Long newRegion){
        this.region = newRegion;
    }

    public String getObjetivo() {
        return this.objetivo;
    }

    public void setObjetivo(String newObjetivo){
        this.objetivo = newObjetivo;
    }

    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String newContenido){
        this.contenido = newContenido;
    }

    public String getRelacionMaterial() {
        return this.relacionMaterial;
    }

    public void setRelacionMaterial(String newRelacionMaterial){
        this.relacionMaterial = newRelacionMaterial;
    }

    public BigDecimal getMontoVentas() {
        return this.montoVentas;
    }

    public void setMontoVentas(BigDecimal newMontoVentas){
        this.montoVentas = newMontoVentas;
    }

    public Date  getFechaDisponible() {
        return this.fechaDisponible;
    }

    public void setFechaDisponible(Date newFechaDisponible){
        this.fechaDisponible = newFechaDisponible;
    }

    public Date getFechaLanzamiento() {
        return this.fechaLanzamiento;
    }

    public void setFechaLanzamiento( Date newFechaLanzamiento){
        this.fechaLanzamiento = newFechaLanzamiento;
    }

    public Date getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(Date newFechaFin){
        this.fechaFin = newFechaFin;
    }

    public Date getFechaUltimo() {
        return this.fechaUltimo;
    }

    public void setFechaUltimo(Date newFechaUltimo){
        this.fechaUltimo = newFechaUltimo;
    }

    public Date getFechaConcreta() {
        return this.fechaConcreta;
    }

    public void setFechaConcreta(Date newFechaConcreta){
        this.fechaConcreta = newFechaConcreta;
    }

    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }

    public void setFechaIngreso(Date newFechaIngreso){
        this.fechaIngreso = newFechaIngreso;
    }

    public Integer getNumeroOrdenes() {
        return this.numeroOrdenes;
    }

    public void setNumeroOrdenes(Integer newNumeroOrdenes){
        this.numeroOrdenes = newNumeroOrdenes;
    }

    public Integer getNumeroCampanyas() {
        return this.numeroCampanyas;
    }

    public void setNumeroCampanyas(Integer newNumeroCampanyas){
        this.numeroCampanyas = newNumeroCampanyas;
    }

    public Integer getNumeroUnidades() {
        return this.numeroUnidades;
    }

    public void setNumeroUnidades(Integer newNumeroUnidades){
        this.numeroUnidades = newNumeroUnidades;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String newDescripcion){
        this.descripcion = newDescripcion;
    }

    public Boolean isAccesoDataMart() {
        return this.accesoDataMart;
    }

    public void setAccesoDataMart(Boolean newAccesoDataMart){
        this.accesoDataMart = newAccesoDataMart;
    }

    public Boolean isAlcance() {
        return this.alcance;
    }

    public void setAlcance(Boolean newAlcance) {
        this.alcance = newAlcance;
    }

    public Boolean isBloqueoExtemporaneas() {
        return this.bloqueoExtemporaneas;
    }

    public void setBloqueoExtemporaneas(Boolean newBloqueoExtemporaneas) {
        this.bloqueoExtemporaneas = newBloqueoExtemporaneas;
    }

    public Long getMomentoEntrega() {
        return this.momentoEntrega;
    }

    public void setMomentoEntrega(Long newMomentoEntrega) {
        this.momentoEntrega = newMomentoEntrega;
    }

    public Boolean isCondicionPedido() {
        return this.condicionPedido;
    }

    public void setCondicionPedido(Boolean newCondicionPedido) {
        this.condicionPedido = newCondicionPedido;
    }

    public Boolean isControlMorosidad() {
        return this.controlMorosidad;
    }

    public void setControlMorosidad(Boolean newControlMorosidad) {
        this.controlMorosidad = newControlMorosidad;
    }

    public Long getCapacitador(){
        return this.capacitador;
    }

    public void setCapacitador(Long newCapacitador){
        this.capacitador = newCapacitador;
    }

    public Long getCanal(){
        return this.canal;
    }

    public void setCanal(Long newCanal){
        this.canal = newCanal;
    }

    public Long getMarca(){
        return this.marca;
    }

    public void setMarca(Long newMarca){
        this.marca = newMarca;
    }

    public Long getZona() {
        return this.zona;
    }

    public void setZona(Long newZona) {
        this.zona = newZona;
		this.ejbStore();
    }

    public Long getSeccion() {
        return this.seccion;
    }

    public void setSeccion(Long newSeccion) {
        this.seccion = newSeccion;
    }

    public Long getPeriodoIniComparativo() {
        return this.periodoIniComparativo;
    }

    public void setPeriodoIniComparativo(Long newPeriodoIniComparativo) {
        this.periodoIniComparativo = newPeriodoIniComparativo;
    }

    public Long getPeriodoFinComparativo() {
        return this.periodoFinComparativo;
    }

    public void setPeriodoFinComparativo(Long newPeriodoFinComparativo) {
        this.periodoFinComparativo = newPeriodoFinComparativo;
    }

    public Long getPeriodoIniConstancia() {
        return this.periodoIniConstancia;
    }

    public void setPeriodoIniConstancia(Long newPeriodoIniConstancia) {
        this.periodoIniConstancia = newPeriodoIniConstancia;
    }

    public Long getPeriodoFinConstancia() {
        return this.periodoFinConstancia;
    }

    public void setPeriodoFinConstancia(Long newPeriodoFinConstancia) {
        this.periodoFinConstancia = newPeriodoFinConstancia;
    }

    public Long getPeriodoIngreso() {
        return this.periodoIngreso;
    }

    public void setPeriodoIngreso(Long newPeriodoIngreso) {
        this.periodoIngreso = newPeriodoIngreso;
    }

    public Long getTipo() {
        return this.tipo;
    }

    public void setTipo(Long newTipo) {
        this.tipo = newTipo;
    }

    public Long getTipoClasificacion() {
        return this.tipoClasificacion;
    }

    public void setTipoClasificacion(Long newTipoClasificacion) {
        this.tipoClasificacion = newTipoClasificacion;
    }

    public Long getTipoCliente() {
        return this.tipoCliente;
    }

    public void setTipoCliente(Long newTipoCliente) {
        this.tipoCliente = newTipoCliente;
    }

    public Long getSubtipoCliente() {
        return this.subtipoCliente;
    }

    public void setSubtipoCliente(Long newSubtipoCliente) {
        this.subtipoCliente = newSubtipoCliente;
    }

    public Long getStatusCliente() {
        return this.statusCliente;
    }

    public void setStatusCliente(Long newStatusCliente) {
        this.statusCliente = newStatusCliente;
    }

    public Long getAcceso() {
        return this.acceso;
    }

    public void setAcceso(Long newAcceso) {
        this.acceso = newAcceso;
    }

    public Boolean isControlFuncion() {
        return this.controlFuncion;
    }

    public void setControlFuncion(Boolean newControlFuncion) {
        this.controlFuncion = newControlFuncion;
    }
    
    public Long getClienteCapacitador() {
        return clienteCapacitador;
    }

    public void setClienteCapacitador(Long clienteCapacitador) {
        this.clienteCapacitador = clienteCapacitador;
    }

    public Long getSubtipoClienteCapacitador() {
        return subtipoClienteCapacitador;
    }

    public void setSubtipoClienteCapacitador(Long subtipoClienteCapacitador) {
        this.subtipoClienteCapacitador = subtipoClienteCapacitador;
    }

    public Long getTipoClasificacionCapacitador() {
        return tipoClasificacionCapacitador;
    }

    public void setTipoClasificacionCapacitador(Long tipoClasificacionCapacitador) {
        this.tipoClasificacionCapacitador = tipoClasificacionCapacitador;
    }

    /** Metodo privado, para realizar consultas directo a la base por JDBC
     * @param query sentencia SQL con la consulta
     * @param argumentos valores de los parametros de la consulta
     * @return RecordSet con la respuesta a la consulta realizada */

    private RecordSet ejecutaQuery(String query, Vector argumentos)
        throws EJBException {
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new EJBException(e);
        }

        RecordSet res;

        try {
            res = bs.dbService.executePreparedQuery(query, argumentos);
        } catch (Exception e) {
            throw new EJBException(e);
        }
		loguearSql("**** BMP MatrizCursos: ", query, argumentos);
        return res;
    }
    /** Metodo privado, para realizar consultas directo a la base por JDBC
     * @param query sentencia SQL con la consulta
     * @param argumentos valores de los parametros de la consulta
     * @return RecordSet con la respuesta a la consulta realizada */

    private int ejecuta(String query, Vector argumentos) throws EJBException {
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new EJBException(e);
        }
        try {
			loguearSql("**** BMP MatrizCursos: ", query, argumentos);		
		    return bs.dbService.executePreparedUpdate(query, argumentos);
        } catch (Exception e) {
            throw new EJBException(e);
        }
    }
    /** Metodo privado, para asignar codigo
     * @return Integer con el valor del codigo generado */

    private Integer obtieneCodigo() throws EJBException {
		Integer codigo = new Integer(1);
        // Asignar el nuevo codigo
        String query  = " SELECT MAX(cod_curs)" +
			" FROM edu_matri_curso" +
			" WHERE pais_oid_pais = " + pais +
			" AND cplc_oid_cabe_plan_curs = " + plantilla +
			" AND cana_oid_cana = " + canal +
			" AND marc_oid_marc = " + marca;
        RecordSet respuesta;
        BelcorpService bs;
        try {
                bs = BelcorpService.getInstance();
                respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
                throw new EJBException(e);
        }

        if (!respuesta.esVacio()) {
            if(respuesta.getValueAt(0,0) != null)
                codigo = new Integer(((BigDecimal)respuesta.getValueAt(0,0)).intValue()+1);
        }
		return codigo;
    }

	private Log getLog() {
		Log log = null;
		try {
			return (((LoggingService)MareMii.getService(new MareTopic("LoggingService"))).getMareLog());
		} catch (Exception e) {
			e.printStackTrace();
			UtilidadesLog.debug("No se pudo obtener el objeto Log");
      throw new RuntimeException ("No se pudo obtener el objeto Log");
		}
	}  

	private void loguearSql(String metodo, String sql, Vector params){
		this.getLog().info(metodo + sql);
		if (params!=null && params.size()>0){
			String sParams="";
			for (int i=0; i<params.size();i++){
				if (params.elementAt(i)!=null)
					sParams+="param "+ (i+1) + ": " +  (params.elementAt(i)).toString() + ", ";
				else
					sParams+="param "+ (i+1) + ": es nulo, ";
			}
			this.getLog().info(metodo + sParams);
		}		
	}	

	public void modifica() throws  CreateException, DuplicateKeyException,  EJBException {
        Vector vector= new Vector();
        StringBuffer query  = new StringBuffer(" UPDATE EDU_MATRI_CURSO SET "+
            "PAIS_OID_PAIS = ?, "+
            "CPLC_OID_CABE_PLAN_CURS = ?, "+			
            "CANA_OID_CANA = ?, "+
            "MARC_OID_MARC = ?, "+
            "ACCE_OID_ACCE = ?, "+
            "TICU_OID_TIPO_CURS = ?, "+
            "IND_CTRL_FUNC = ? ");
        vector.add(this.getPais());
        vector.add(this.getPlantilla());		
        vector.add(this.getCanal());
        vector.add(this.getMarca());
        vector.add(this.getAcceso());
        vector.add(this.getTipo());
        vector.add(this.isControlFuncion());

        if (this.getTerritorio() != null) {
            query.append( ", TERR_OID_TERR = ? ");
            vector.add(this.getTerritorio());
        } else {
            query.append( ", TERR_OID_TERR = null ");
        }
        
        if (this.getClasificacion() != null) {
            query.append( ", CLAS_OID_CLAS = ? ");
            vector.add(this.getClasificacion());
        } else {
            query.append( ", CLAS_OID_CLAS = null ");
        }
        
        if (this.getFrecuencia() != null) {
            query.append( ", FRCU_OID_FREC = ? ");
            vector.add(this.getFrecuencia());
        } else {
            query.append( ", FRCU_OID_FREC = null ");
        }
        
        if (this.getRegalo() != null) {
            query.append( ", REGA_OID_REGA = ? ");
            vector.add(this.getRegalo());
        } else {
            query.append( ", REGA_OID_REGA = null ");
        }
        
        if (this.getSubgerencia() != null) {
            query.append( ", ZSGV_OID_SUBG_VENT = ? ");
            vector.add(this.getSubgerencia());
        } else {
            query.append( ", ZSGV_OID_SUBG_VENT = null ");
        }
        
        if (this.getRegion() != null) {
            query.append( ", ZORG_OID_REGI = ? ");
            vector.add(this.getRegion());
        } else {
            query.append( ", ZORG_OID_REGI = null ");
        }
        
        if (this.getZona() != null) {
            query.append( ", ZZON_OID_ZONA = ? ");
            vector.add(this.getZona());
        } else {
            query.append( ", ZZON_OID_ZONA = null ");
        }
        
        if (this.getSeccion() != null) {
            query.append( ", ZSCC_OID_SECC = ? ");
            vector.add(this.getSeccion());
        } else {
            query.append( ", ZSCC_OID_SECC = null ");
        }
        
        if (this.getPeriodoIniComparativo() != null) {
            query.append( ", PERD_OID_PERI_INIC_COMP = ? ");
            vector.add(this.getPeriodoIniComparativo());
        } else {
            query.append( ", PERD_OID_PERI_INIC_COMP = null ");
        }
        

        if (this.getPeriodoFinComparativo() != null) {
            query.append( ", PERD_OID_PERI_FINA_COMP = ? ");
            vector.add(this.getPeriodoFinComparativo());
        } else {
            query.append( ", PERD_OID_PERI_FINA_COMP = null ");
        }
        
        if (this.getPeriodoIniConstancia() != null) {
            query.append( ", PERD_OID_PERI_INIC_CONS = ? ");
            vector.add(this.getPeriodoIniConstancia());
        } else {
            query.append( ", PERD_OID_PERI_INIC_CONS = null ");
        }
        
        if (this.getPeriodoFinConstancia() != null) {
            query.append( ", PERD_OID_PERI_FINA_CONS = ? ");
            vector.add(this.getPeriodoFinConstancia());
        } else {
            query.append( ", PERD_OID_PERI_FINA_CONS = null ");
        }
        
        if (this.getPeriodoIngreso() != null) {
            query.append( ", PERD_OID_PERI_INGR = ? ");
            vector.add(this.getPeriodoIngreso());
        } else {
            query.append( ", PERD_OID_PERI_INGR = null ");
        }
                
        if (this.getObjetivo() != null) {
            query.append( ", VAL_OBJE_CURS = ? ");
            vector.add(this.getObjetivo());
        } else {
            query.append( ", VAL_OBJE_CURS = null ");
        }
        
        if (this.getContenido() != null) {
            query.append( ", VAL_CONT_CURS = ? ");
            vector.add(this.getContenido());
        } else {
            query.append( ", VAL_CONT_CURS = null ");
        }
        
        if (this.getRelacionMaterial() != null) {
            query.append( ", VAL_RELA_MATE_CURS = ? ");
            vector.add(this.getRelacionMaterial());
        } else {
            query.append( ", VAL_RELA_MATE_CURS = null ");
        }
        
        if (this.getMontoVentas() != null) {
            query.append( ", VAL_MONT_VENT = ? ");
            vector.add(this.getMontoVentas());
        } else {
            query.append( ", VAL_MONT_VENT = null ");
        }
        
        if (this.getFechaDisponible() != null) {
            query.append( ", FEC_DISP_CURS = ? ");
            vector.add(this.getFechaDisponible());
        } else {
            query.append( ", FEC_DISP_CURS = null ");
        }
        

        if (this.getFechaLanzamiento() != null) {
            query.append( ", FEC_LANZ = ? ");
            vector.add(this.getFechaLanzamiento());
        } else {
            query.append( ", FEC_LANZ = null ");
        }
        
        if (this.getFechaFin() != null) {
            query.append( ", FEC_FIN_CURS = ? ");
            vector.add(this.getFechaFin());
        } else {
            query.append( ", FEC_FIN_CURS = null ");
        }
        
        if (this.getFechaUltimo() != null) {
            query.append( ", FEC_ULTI_CURS = ? ");
            vector.add(this.getFechaUltimo());
        } else {
            query.append( ", FEC_ULTI_CURS = null ");
        }
        
        if (this.getFechaConcreta() != null) {
            query.append( ", FEC_CONC_CURS = ? ");
            vector.add(this.getFechaConcreta());
        } else {
            query.append( ", FEC_CONC_CURS = null ");
        }
        
        if (this.getFechaIngreso() != null) {
            query.append( ", FEC_INGR = ? ");
            vector.add(this.getFechaIngreso());
        } else {
            query.append( ", FEC_INGR = null ");
        }
        
        if (this.getNumeroParticipantes() != null) {
            query.append( ", NUM_PART = ? ");
            vector.add(this.getNumeroParticipantes());
        } else {
            query.append( ", NUM_PART = null ");
        }
        
        if (this.getNumeroOrdenes() != null) {
            query.append( ", NUM_ORDE = ? ");
            vector.add(this.getNumeroOrdenes());
        } else {
            query.append( ", NUM_ORDE = null ");
        }
        
        if (this.getNumeroCampanyas() != null) {
            query.append( ", NUM_CAMPA = ? ");
            vector.add(this.getNumeroCampanyas());
        } else {
            query.append( ", NUM_CAMPA = null ");
        }
        
        if (this.getNumeroUnidades() != null) {
            query.append( ", NUM_UNID = ? ");
            vector.add(this.getNumeroUnidades());
        } else {
            query.append( ", NUM_UNID = null ");
        }
        
        if (this.getDescripcion() != null) {
            query.append( ", DES_CURS = ? ");
            vector.add(this.getDescripcion());
        } else {
            query.append( ", DES_CURS = null ");
        }
        
        if (this.isAccesoDataMart() != null) {
            query.append( ", IND_ACCE_DMRT = ? ");
            vector.add(this.isAccesoDataMart());
        } else {
            query.append( ", IND_ACCE_DMRT = null ");
        }
        
        if (this.isAlcance() != null) {
            query.append( ", IND_ALCA_GEOG = ? ");
            vector.add(this.isAlcance());
        } else {
            query.append( ", IND_ALCA_GEOG = null ");
        }
        
        if (this.isBloqueoExtemporaneas() != null) {
            query.append( ", IND_BLOQ_EXTE = ? ");
            vector.add(this.isBloqueoExtemporaneas());
        } else {
            query.append( ", IND_BLOQ_EXTE = null ");
        }
        
        if (this.getMomentoEntrega() != null) {
            query.append( ", MOME_OID_MOME_ENTR = ?");
            vector.add(this.getMomentoEntrega());
        } else {
            query.append( ", MOME_OID_MOME_ENTR = null ");
        }
        
        if (this.isCondicionPedido() != null) {
            query.append( ", IND_COND_PEDI = ? ");
            vector.add(this.isCondicionPedido());
        } else {
            query.append( ", IND_COND_PEDI = null ");
        }
        
        if (this.isControlMorosidad() != null) {
            query.append( ", IND_CTRL_MORO = ? ");
            vector.add(this.isControlMorosidad());
        } else {
            query.append( ", IND_CTRL_MORO = null ");
        }
        /* Elimina MAE-015
        if (this.getCapacitador() != null) {
            query.append( ", CLCL_OID_CLIE_CLAS_CAPA = ? ");
            vector.add(this.getCapacitador());
        } else {
            query.append( ", CLCL_OID_CLIE_CLAS_CAPA = null ");
        }*/
        
        if (this.getClienteCapacitador() != null) {
            query.append( ", CLIE_OID_CLIE_CAPA = ? ");
            vector.add(this.getClienteCapacitador());
        } else {
            query.append( ", CLIE_OID_CLIE_CAPA = null ");
        }
        
        if (this.getSubtipoCliente() != null) {
            query.append( ", SBTI_OID_SUBT_CLIE = ? ");
            vector.add(this.getSubtipoCliente());
        } else {
            query.append( ", SBTI_OID_SUBT_CLIE = null ");
        }
        
        if (this.getTipoClasificacion() != null) {
            query.append( ", TCCL_OID_TIPO_CLAS = ? ");
            vector.add(this.getTipoClasificacion());
        } else {
            query.append( ", TCCL_OID_TIPO_CLAS = null ");
        }
        
        if (this.getStatusCliente() != null) {
            query.append( ", ESTA_OID_ESTA_CLIE = ? ");
            vector.add(this.getStatusCliente());
        } else {
            query.append( ", ESTA_OID_ESTA_CLIE = null ");
        }
        
        if (this.getTipoCliente() != null) {
            query.append( ", TICL_OID_TIPO_CLIE = ? ");
            vector.add(this.getTipoCliente());
        } else {
            query.append( ", TICL_OID_TIPO_CLIE = null ");
        }
        
        if (this.getSubtipoClienteCapacitador() != null) {
            query.append( ", SBTI_OID_SUBT_CLIE_CAPA = ? ");
            vector.add(this.getSubtipoClienteCapacitador());
        } else {
            query.append( ", SBTI_OID_SUBT_CLIE_CAPA = null ");
        }
        
        if (this.getTipoClasificacionCapacitador() != null) {
            query.append( ", TCCL_OID_TIPO_CLAS_CAPA = ? ");
            vector.add(this.getTipoClasificacionCapacitador());
        } else {
            query.append( ", TCCL_OID_TIPO_CLAS_CAPA = null ");
        }
        
        
        query.append("WHERE oid_curs = ?"); 

        vector.add(this.getOid());
        try {   
            ejecuta(query.toString(), vector);
        } catch (EJBException ejbe) {
            String falloSQL = (ejbe.getCausedByException()).getMessage();
            if (falloSQL.indexOf("ORA-00001") != -1)
                throw new DuplicateKeyException();
            else if (falloSQL.indexOf("ORA-02291") != -1)
                throw new CreateException("ORA-02291");
            else
                throw ejbe;
        }
	}

	public void elimina() throws EJBException, RemoveException {
		Vector vector= new Vector();
        String query  = " DELETE FROM EDU_MATRI_CURSO WHERE OID_CURS = ?";
                   
        BelcorpService bs;
        vector.add(this.getOid());
        try {
            ejecuta(query.toString(), vector);
        } catch (EJBException ejbe) {
			String falloSQL = (ejbe.getCausedByException()).getMessage();
			if (falloSQL.indexOf("ORA-02292") != -1)
				throw new RemoveException();
			else
				throw ejbe;
		}
	}

    public Collection ejbFindByPaisMarcaCanalCurso(Long pais, Long marca, Long canal, Integer curso) throws FinderException, MareException {

		Vector resultado = new Vector();
		Vector parametros = new Vector();
        RecordSet respuesta;

		// se busca por campos: CCBA_OID_CC_BANC, FEC_PAGO, IMP_PAGO, CLIE_OID_CLIE
		String consulta = " SELECT OID_CURS FROM EDU_MATRI_CURSO EMC "+
                          "  WHERE EMC.CANA_OID_CANA = ? "+
                          "  AND EMC.MARC_OID_MARC = ? "+
                          "  AND EMC.PAIS_OID_PAIS = ? "+
                          "  AND EMC.COD_CURS = ? ";

		parametros.add(canal);
		parametros.add(marca);		
		parametros.add(pais);
		parametros.add(curso);

        try {
            respuesta = this.ejecutaQuery(consulta, parametros);
        } catch (EJBException exception) {
                throw new EJBException();
        }

        if (respuesta.esVacio()) {
            throw new FinderException();
        }

		Iterator iter = respuesta.getRecords().iterator();
		
		Long clavePrimaria = null;
		Vector tempEncontrado = null;

		while (iter.hasNext()) {
			tempEncontrado = (Vector)iter.next();
			clavePrimaria = new Long( ( (BigDecimal)tempEncontrado.get(0) ).longValue() );
			resultado.add(clavePrimaria);
		}
		
		return resultado;
    }

    public Collection ejbFindByPlantilla(Long plantilla) throws  FinderException, MareException
    {
		Vector resultado = new Vector();
		Vector parametros = new Vector();
        RecordSet respuesta;

		String consulta = " SELECT OID_CURS, PAIS_OID_PAIS, CPLC_OID_CABE_PLAN_CURS, COD_CURS "+
                          " FROM EDU_MATRI_CURSO MC" +
                          " WHERE MC.CPLC_OID_CABE_PLAN_CURS = ? ";

		parametros.add(plantilla);

        try {
            respuesta = this.ejecutaQuery(consulta, parametros);
        } catch (EJBException exception) {
                throw new EJBException();
        }

        if (respuesta.esVacio()) {
            throw new FinderException();
        }

		Iterator iter = respuesta.getRecords().iterator();
		
		Long clavePrimaria = null;
		Vector tempEncontrado = null;

		while (iter.hasNext()) {
			tempEncontrado = (Vector)iter.next();
			clavePrimaria = new Long( ( (BigDecimal)tempEncontrado.get(0) ).longValue() );
			resultado.add(clavePrimaria);
		}
		
		return resultado;
    }


 }
