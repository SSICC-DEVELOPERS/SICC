package es.indra.sicc.entidades.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.auditoria.EntidadSICCAuditableBean;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.SecuenciadorOID;


import java.math.BigDecimal;


import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;


public class DetalleMAVBean extends EntidadSICCAuditableBean {
    private EntityContext context;
    public Long oid;
    public Double precioEstandar;
    public Double precio;
    public Double precioContable;
    public String observaciones;
    public Long baseEstimadosDestinatarios;
    public Double factorCorreccion;
    public BigDecimal unidadesEstimadas;
    public Long unidadesTotalesEstimadas;
    public String criterio;
    public Integer campagnaEvaluacion;
    public Double monto;
    public String numeroAniversario;
    public Long unidadesPorCliente;
    public Long unidadesTotales;
    public Boolean enviarMensaje;
    public Integer edadDesde;
    public Integer edadHasta;
	public Long oidTipoCliente;
    public Long oidCatalogo;
    public Long oidNegocio;
    public Long oidUnidadNegocio;
    public Long oidMensaje;
    public Long oidActividad;
    public Long oidFormaCobro;
    public Long oidCurso;
    public Long oidEstadoProceso;
    public Long oidFormaPago;
    public Long oidSubcriterio;
    public Long oidTipoDespacho;
    public Long oidCicloVida;
    public Long oidTipoOferta;
//    public Long oidEstadoMAV;
    public Long oidEstadoActividad;
    public Long oidListaClientes;
    public Long oidPeriodo;
    public Long oidPeriodoFinMonto;
    public Long oidPeriodoIniMonto;
    public Long oidPeriodoFin;
  public Long oidMarcaCondicion;
    public Long oidClasificacion;
    public Long oidProducto;
    public Long oidProcedencia;
	public Long oidTipoClasificacion;
	public Long oidPeriodoCurso;

    // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
    public Boolean indExclusionTipoClasificacion;
    
    // sapaza -- PER-SiCC-2010-0674 -- 25/11/2010
    private Long oidTipoClienteCriterio;
    private Long oidSubTipoCliente;
    
    public void ejbPostCreate() {
    }

    public Long ejbCreate(Double precioEstandar, Double precio, Long oidTipoCliente, Long oidPeriodo, Double precioContable) throws MareException 
    {
        
        try {        

        this.oid = SecuenciadorOID.obtenerSiguienteValor("MAV_DENV_SEQ");
        this.precioEstandar = precioEstandar;
        this.precio = precio;
//        this.precioContable = precioContable;
        this.oidTipoCliente = oidTipoCliente;
        this.oidPeriodo = oidPeriodo;
        this.precioContable = precioContable;


            BelcorpService rs = BelcorpService.getInstance();
            //String sql = " INSERT INTO MAV_DETAL_MAV ( OID_DETA_MAV, VAL_PREC_STND, VAL_PREC, TICL_OID_TIPO_CLIE, PERD_OID_PERI ) VALUES ( ?, ?, ?, ?, ? ) ";
            
            // Modificado por ssantana, 8/2/2005
            // Se agrega VAL_PREC_CONT como Atributo NOT NULL.
            String sql = " INSERT INTO MAV_DETAL_MAV ( OID_DETA_MAV, VAL_PREC_STND, VAL_PREC, TICL_OID_TIPO_CLIE, PERD_OID_PERI, VAL_PREC_CONT) VALUES ( ?, ?, ?, ?, ?, ? ) ";            
            Vector vec = new Vector();
            vec.add(this.oid);
            vec.add(this.precioEstandar);
            vec.add(this.precio);
            vec.add(this.oidTipoCliente);
            vec.add(this.oidPeriodo);
            vec.add(this.precioContable);
            rs.dbService.executePreparedUpdate(sql, vec);
            //super.ejbCreate();
            
            return this.oid;
			
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(
                "DetalleMAV.  No se pudo crear el Entity Bean: " +
                ex.getMessage());
        }
    }

    public void ejbPostCreate(Double precioEstandar, Double precio, Long oidTipoCliente, Long oidPeriodo, Double precioContable) throws MareException {
    }

    public Long ejbFindByPrimaryKey(Long primaryKey) throws FinderException {
        try {
            BelcorpService rs = BelcorpService.getInstance();
            String query = " SELECT * FROM MAV_DETAL_MAV WHERE 1=1 AND OID_DETA_MAV = ? ";
            Vector vec = new Vector();
            vec.add(primaryKey);

            RecordSet r = rs.dbService.executePreparedQuery(query, vec);

            if (r.getRowCount() != 1) {
                throw new FinderException("Entidad no existente");
            }

            return primaryKey;
        } catch (Exception ex) {
            throw new FinderException("DetalleMAV. " + ex.getMessage());
        }
    }

    public void ejbActivate() {
    }

    public void ejbLoad() {
        this.oid = new Long(context.getPrimaryKey().toString());

        try {
            BelcorpService rs = BelcorpService.getInstance();
            String query = " SELECT * FROM MAV_DETAL_MAV WHERE OID_DETA_MAV = ? ";
            
            Vector vec = new Vector();
            vec.add(this.oid);

            RecordSet r = rs.dbService.executePreparedQuery(query, vec);
            this.baseEstimadosDestinatarios = cambiarTipoLong((BigDecimal) r.getValueAt(0, "VAL_BASE_ESTI_DEST"));
            this.campagnaEvaluacion = cambiarTipoInteger((BigDecimal) r.getValueAt(0, "VAL_CAMP_EVAL"));
            this.criterio = (String) r.getValueAt(0, "VAL_CRIT");
            this.edadDesde = cambiarTipoInteger((BigDecimal) r.getValueAt(0, "VAL_EDAD_DESD"));
            this.edadHasta = cambiarTipoInteger((BigDecimal) r.getValueAt(0, "VAL_EDAD_HAST"));

            if (r.getValueAt(0, "IND_ENVI_MENS") != null)
            {
                if (((BigDecimal) r.getValueAt(0, "IND_ENVI_MENS")).toString().equals("1")) 
                    this.enviarMensaje = new Boolean(true);
                else 
                    this.enviarMensaje = new Boolean(false);
              
            } else {
              this.enviarMensaje = null;
            }

             // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010                       
             if (r.getValueAt(0, "IND_EXCL_TIPO_CLAS") != null)
             {
                 if (((BigDecimal) r.getValueAt(0, "IND_EXCL_TIPO_CLAS")).toString().equals("1")) 
                     this.indExclusionTipoClasificacion = new Boolean(true);
                 else 
                     this.indExclusionTipoClasificacion = new Boolean(false);
               
             } else {
               this.indExclusionTipoClasificacion = null;
             }            

            this.factorCorreccion = cambiarTipoDouble((BigDecimal) r.getValueAt(0, "VAL_FACT_CORR"));
            this.monto = cambiarTipoDouble((BigDecimal) r.getValueAt(0,"VAL_MONT"));
            this.numeroAniversario = (String) r.getValueAt(0, "NUM_ANIV");
            this.observaciones = (String) r.getValueAt(0, "VAL_OBSE");
            this.oidActividad = cambiarTipoLong((BigDecimal) r.getValueAt(0, "ACTI_OID_ACTI"));
            this.oidCatalogo = cambiarTipoLong((BigDecimal) r.getValueAt(0,"OCAT_OID_CATA"));
            this.oidCicloVida = cambiarTipoLong((BigDecimal) r.getValueAt(0, "CIVI_OID_CICL_VIDA"));
            this.oidClasificacion = cambiarTipoLong((BigDecimal) r.getValueAt( 0, "CLAS_OID_CLAS"));
            this.oidCurso = cambiarTipoLong((BigDecimal) r.getValueAt(0, "MCUR_OID_CURS"));
            this.oidEstadoActividad = cambiarTipoLong((BigDecimal) r.getValueAt( 0, "AEST_OID_ESTA_ACTI"));
            this.oidEstadoProceso = cambiarTipoLong((BigDecimal) r.getValueAt( 0, "TEPR_OID_TIPO_ESTA_PROC"));
            this.oidFormaCobro = cambiarTipoLong((BigDecimal) r.getValueAt(0, "FCOB_OID_FORM_COBR"));
            this.oidFormaPago = cambiarTipoLong((BigDecimal) r.getValueAt(0, "FOPA_OID_FORM_PAGO"));
            this.oidListaClientes = cambiarTipoLong((BigDecimal) r.getValueAt( 0, "LICL_OID_LIST_CLIE"));

            this.oidMarcaCondicion = cambiarTipoLong((BigDecimal) r.getValueAt( 0, "MAPR_OID_MARC_PROD"));            
            
            // Se quita por inc. 15618, ssantana, 2/8/2005
            //this.oidMatrizFacturacion = cambiarTipoLong((BigDecimal) r.getValueAt( 0, "MAFA_OID_MATR_FACT"));
            // Fin inc. 15618
            this.oidMensaje = cambiarTipoLong((BigDecimal) r.getValueAt(0, "MENS_OID_MENS"));
            this.oidNegocio = cambiarTipoLong((BigDecimal) r.getValueAt(0, "NEGO_OID_NEGO"));
            this.oidPeriodo = cambiarTipoLong((BigDecimal) r.getValueAt(0, "PERD_OID_PERI"));
            this.oidPeriodoFin = cambiarTipoLong((BigDecimal) r.getValueAt(0, "PERD_OID_PERI_FINA"));
            this.oidPeriodoFinMonto = cambiarTipoLong((BigDecimal) r.getValueAt(
                        0, "PERD_OID_PERI_FINA_MONT"));
            this.oidPeriodoIniMonto = cambiarTipoLong((BigDecimal) r.getValueAt(
                        0, "PERD_OID_PERI_INIC_MONT"));
            this.oidProcedencia = cambiarTipoLong((BigDecimal) r.getValueAt(0,
                        "PRDN_OID_PROC"));
            this.oidProducto = cambiarTipoLong((BigDecimal) r.getValueAt(0,
                        "PROD_OID_PROD"));
            this.oidSubcriterio = cambiarTipoLong((BigDecimal) r.getValueAt(0,
                        "SCAS_OID_SUBC"));
            this.oidTipoCliente = cambiarTipoLong((BigDecimal) r.getValueAt(0,
                        "TICL_OID_TIPO_CLIE"));
            this.oidTipoDespacho = cambiarTipoLong((BigDecimal) r.getValueAt(
                        0, "ATDE_OID_ACTI_TIPO_DESP"));
            this.oidTipoOferta = cambiarTipoLong((BigDecimal) r.getValueAt(0,
                        "TOFE_OID_TIPO_OFER"));
            this.oidUnidadNegocio = cambiarTipoLong((BigDecimal) r.getValueAt(
                        0, "UNEG_OID_UNID_NEGO"));
            this.precio = cambiarTipoDouble((BigDecimal) r.getValueAt(0,
                        "VAL_PREC"));
            this.precioContable = cambiarTipoDouble((BigDecimal) r.getValueAt(
                        0, "VAL_PREC_CONT"));
            this.precioEstandar = cambiarTipoDouble((BigDecimal) r.getValueAt(
                        0, "VAL_PREC_STND"));
/*            this.unidadesEstimadas = cambiarTipoLong((BigDecimal) r.getValueAt(
                        0, "NUM_UNID_ESTI"));*/
            this.unidadesEstimadas = (BigDecimal) r.getValueAt(0, "NUM_UNID_ESTI");            
            this.unidadesPorCliente = cambiarTipoLong((BigDecimal) r.getValueAt(
                        0, "NUM_UNID_CLIE"));
            this.unidadesTotales = cambiarTipoLong((BigDecimal) r.getValueAt(
                        0, "NUM_UNID_TOTA"));
            this.unidadesTotalesEstimadas = cambiarTipoLong((BigDecimal) r.getValueAt(
                        0, "NUM_UNID_TOTA_ESTI"));
			this.oidTipoClasificacion = cambiarTipoLong((BigDecimal)r.getValueAt(0, "TCCL_OID_TIPO_CLAS"));
			this.oidPeriodoCurso = cambiarTipoLong((BigDecimal)r.getValueAt(0, "PERD_OID_PERI_CURS"));
                        
            // sapaza -- PER-SiCC-2010-0674 -- 25/11/2010            
            this.oidTipoClienteCriterio = cambiarTipoLong((BigDecimal) r.getValueAt(0,
                        "TICL_OID_TIPO_CLIE_CRIT"));
            this.oidSubTipoCliente = cambiarTipoLong((BigDecimal) r.getValueAt(0,
                        "SBTI_OID_SUBT_CLIE"));
                        
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new EJBException("DetalleMAV - ejbLoad() - oid " + this.oid );
        }
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
        Long primaryKey = (Long) context.getPrimaryKey();

        try {
            BelcorpService rs = BelcorpService.getInstance();
            String query =
                " DELETE FROM MAV_DETAL_MAV WHERE 1=1  AND OID_DETA_MAV = " +
                primaryKey + " ";

            if (rs.dbService.executeUpdate(query) != 1) {
                throw new RemoveException(primaryKey + " no se pudo eliminar.");
            }

            //super.ejbRemove();
        } catch (Exception ex) {
            System.out.println("DetalleMAV: " + ex.getMessage());
        }
    }

    public void ejbStore() {
        try {
            BelcorpService rs = BelcorpService.getInstance();
            StringBuffer statement = new StringBuffer();
            String values = new String();
            statement.append("UPDATE MAV_DETAL_MAV SET ");

            Vector vec = new Vector();

            statement.append(cargaCampo(vec, "VAL_BASE_ESTI_DEST",
            this.baseEstimadosDestinatarios));
            statement.append(cargaCampo(vec, "VAL_CAMP_EVAL",
            this.campagnaEvaluacion));
            statement.append(cargaCampo(vec, "VAL_CRIT", this.criterio));
            statement.append(cargaCampo(vec, "VAL_EDAD_DESD", this.edadDesde));
            statement.append(cargaCampo(vec, "VAL_EDAD_HAST", this.edadHasta));
            statement.append(cargaCampo(vec, "IND_ENVI_MENS", this.enviarMensaje));
            statement.append(cargaCampo(vec, "VAL_FACT_CORR",
            this.factorCorreccion));
            statement.append(cargaCampo(vec, "VAL_MONT", this.monto));
            statement.append(cargaCampo(vec, "NUM_ANIV", this.numeroAniversario));
            statement.append(cargaCampo(vec, "VAL_OBSE", this.observaciones));
            statement.append(cargaCampo(vec, "OID_DETA_MAV", this.oid));
            statement.append(cargaCampo(vec, "ACTI_OID_ACTI", this.oidActividad));
            statement.append(cargaCampo(vec, "OCAT_OID_CATA", this.oidCatalogo));
            statement.append(cargaCampo(vec, "CIVI_OID_CICL_VIDA",
                    this.oidCicloVida));
            statement.append(cargaCampo(vec, "CLAS_OID_CLAS",
                    this.oidClasificacion));
            statement.append(cargaCampo(vec, "MCUR_OID_CURS", this.oidCurso));
            statement.append(cargaCampo(vec, "AEST_OID_ESTA_ACTI",
                    this.oidEstadoActividad));
//            statement.append(cargaCampo(vec, "EMAV_OID_ESTA_MAV",
//                    this.oidEstadoMAV));
            statement.append(cargaCampo(vec, "TEPR_OID_TIPO_ESTA_PROC",
                    this.oidEstadoProceso));
            statement.append(cargaCampo(vec, "FCOB_OID_FORM_COBR",
                    this.oidFormaCobro));
            statement.append(cargaCampo(vec, "FOPA_OID_FORM_PAGO",
                    this.oidFormaPago));
            statement.append(cargaCampo(vec, "LICL_OID_LIST_CLIE",
                    this.oidListaClientes));
/*          statement.append(cargaCampo(vec, "MARC_OID_MARC",
                    this.oidMarcaCondicion));*/
            statement.append(cargaCampo(vec, "MAPR_OID_MARC_PROD",
                    this.oidMarcaCondicion));     
                    
            // Se quita por inc. 15618, ssantana, 2/8/2005
            /*statement.append(cargaCampo(vec, "MAFA_OID_MATR_FACT",
                    this.oidMatrizFacturacion));*/
            // Fin inc. 15618, ssantana, 2/8/2005                    
            
            statement.append(cargaCampo(vec, "MENS_OID_MENS", this.oidMensaje));
            statement.append(cargaCampo(vec, "NEGO_OID_NEGO", this.oidNegocio));
            statement.append(cargaCampo(vec, "PERD_OID_PERI", this.oidPeriodo));
            statement.append(cargaCampo(vec, "PERD_OID_PERI_FINA",
                    this.oidPeriodoFin));
            statement.append(cargaCampo(vec, "PERD_OID_PERI_FINA_MONT",
                    this.oidPeriodoFinMonto));
            statement.append(cargaCampo(vec, "PERD_OID_PERI_INIC_MONT",
                    this.oidPeriodoIniMonto));
            statement.append(cargaCampo(vec, "PRDN_OID_PROC",
                    this.oidProcedencia));
            statement.append(cargaCampo(vec, "PROD_OID_PROD", this.oidProducto));
            statement.append(cargaCampo(vec, "SCAS_OID_SUBC",
                    this.oidSubcriterio));
            statement.append(cargaCampo(vec, "TICL_OID_TIPO_CLIE",
                    this.oidTipoCliente));
            statement.append(cargaCampo(vec, "ATDE_OID_ACTI_TIPO_DESP",
                    this.oidTipoDespacho));
            statement.append(cargaCampo(vec, "TOFE_OID_TIPO_OFER",
                    this.oidTipoOferta));
            statement.append(cargaCampo(vec, "UNEG_OID_UNID_NEGO",
                    this.oidUnidadNegocio));
            statement.append(cargaCampo(vec, "VAL_PREC", this.precio));
            statement.append(cargaCampo(vec, "VAL_PREC_CONT",
                    this.precioContable));
            statement.append(cargaCampo(vec, "VAL_PREC_STND",
                    this.precioEstandar));
            statement.append(cargaCampo(vec, "NUM_UNID_ESTI",
                    this.unidadesEstimadas));
            statement.append(cargaCampo(vec, "NUM_UNID_CLIE",
                    this.unidadesPorCliente));
            statement.append(cargaCampo(vec, "NUM_UNID_TOTA",
                    this.unidadesTotales));
            statement.append(cargaCampo(vec, "NUM_UNID_TOTA_ESTI",
                    this.unidadesTotalesEstimadas));
			statement.append(cargaCampo(vec, "PERD_OID_PERI_CURS", this.oidPeriodoCurso));
			statement.append(cargaCampo(vec, "TCCL_OID_TIPO_CLAS", this.oidTipoClasificacion));

            // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010			
            statement.append(cargaCampo(vec, "IND_EXCL_TIPO_CLAS", this.indExclusionTipoClasificacion));                        
                        
            // sapaza -- PER-SiCC-2010-0674 -- 25/11/2010            
            statement.append(cargaCampo(vec, "TICL_OID_TIPO_CLIE_CRIT",
                     this.oidTipoClienteCriterio));
            statement.append(cargaCampo(vec, "SBTI_OID_SUBT_CLIE",
                    this.oidSubTipoCliente));
            
            statement.deleteCharAt(statement.length() - 1);
            statement.append(" WHERE 1=1 AND OID_DETA_MAV = ? ");
            vec.add(this.oid);

            if (rs.dbService.executePreparedUpdate(statement.toString(), vec) == 0) {
                throw new Exception("Error en el EJBStore de DetalleMAV");
            }

            //super.ejbStore();
        } catch (Exception ex) {
            throw new EJBException("DetalleMAV. " + ex.getMessage());
        }
    }

    public Collection ejbFindAll() throws FinderException, RemoteException {
        try {
            BelcorpService instance = BelcorpService.getInstance();
            String query = "SELECT * FROM MAV_DETAL_MAV WHERE 1=1 ";
            Vector vec = new Vector();
            RecordSet rs = instance.dbService.executePreparedQuery(query, vec);
            ArrayList respuesta = new ArrayList();

            for (int i = 0; i < rs.getRowCount(); i++) {
                this.oid = (Long) rs.getValueAt(i, "OID_DETA_MAV");
                respuesta.add(this.oid);
            }

            return respuesta;
        } catch (Exception ex) {
            throw new FinderException("DetalleMAV. " + ex.getMessage());
        }
    }

    public void setEntityContext(EntityContext ctx) {
        this.context = ctx;
    }

    public void unsetEntityContext() {
        this.context = null;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Double getPrecioEstandar() {
        return precioEstandar;
    }

    public void setPrecioEstandar(Double newPrecioEstandar) {
        precioEstandar = newPrecioEstandar;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double newPrecio) {
        precio = newPrecio;
    }

    public Double getPrecioContable() {
        return precioContable;
    }

    public void setPrecioContable(Double newPrecioContable) {
        precioContable = newPrecioContable;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String newObservaciones) {
        observaciones = newObservaciones;
    }

    public Long getBaseEstimadosDestinatarios() {
        return baseEstimadosDestinatarios;
    }

    public void setBaseEstimadosDestinatarios(
        Long newBaseEstimadosDestinatarios) {
        baseEstimadosDestinatarios = newBaseEstimadosDestinatarios;
    }

    public Double getFactorCorreccion() {
        return factorCorreccion;
    }

    public void setFactorCorreccion(Double newFactorCorreccion) {
        factorCorreccion = newFactorCorreccion;
    }

    public BigDecimal getUnidadesEstimadas() {
        return unidadesEstimadas;
    }

    public void setUnidadesEstimadas(BigDecimal newUnidadesEstimadas) {
        unidadesEstimadas = newUnidadesEstimadas;
    }

    public Long getUnidadesTotalesEstimadas() {
        return unidadesTotalesEstimadas;
    }

    public void setUnidadesTotalesEstimadas(Long newUnidadesTotalesEstimadas) {
        unidadesTotalesEstimadas = newUnidadesTotalesEstimadas;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String newCriterio) {
        criterio = newCriterio;
    }

    public Integer getCampagnaEvaluacion() {
        return campagnaEvaluacion;
    }

    public void setCampagnaEvaluacion(Integer newCampagnaEvaluacion) {
        campagnaEvaluacion = newCampagnaEvaluacion;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double newMonto) {
        monto = newMonto;
    }

    public String getNumeroAniversario() {
        return numeroAniversario;
    }

    public void setNumeroAniversario(String newNumeroAniversario) {
        numeroAniversario = newNumeroAniversario;
    }

    public Long getUnidadesPorCliente() {
        return unidadesPorCliente;
    }

    public void setUnidadesPorCliente(Long newUnidadesPorCliente) {
        unidadesPorCliente = newUnidadesPorCliente;
    }

    public Long getUnidadesTotales() {
        return unidadesTotales;
    }

    public void setUnidadesTotales(Long newUnidadesTotales) {
        unidadesTotales = newUnidadesTotales;
    }

    public Boolean getEnviarMensaje() {
        return enviarMensaje;
    }

    public void setEnviarMensaje(Boolean newEnviarMensaje) {
        enviarMensaje = newEnviarMensaje;
    }

    public Integer getEdadDesde() {
        return edadDesde;
    }

    public void setEdadDesde(Integer newEdadDesde) {
        edadDesde = newEdadDesde;
    }

    public Integer getEdadHasta() {
        return edadHasta;
    }

    public void setEdadHasta(Integer newEdadHasta) {
        edadHasta = newEdadHasta;
    }

    public Long getOidTipoCliente() {
        return oidTipoCliente;
    }

    public void setOidTipoCliente(Long newOidTipoCliente) {
        oidTipoCliente = newOidTipoCliente;
    }

    public Long getOidCatalogo() {
        return oidCatalogo;
    }

    public void setOidCatalogo(Long newOidCatalogo) {
        oidCatalogo = newOidCatalogo;
    }

    public Long getOidNegocio() {
        return oidNegocio;
    }

    public void setOidNegocio(Long newOidNegocio) {
        oidNegocio = newOidNegocio;
    }

    public Long getOidUnidadNegocio() {
        return oidUnidadNegocio;
    }

    public void setOidUnidadNegocio(Long newOidUnidadNegocio) {
        oidUnidadNegocio = newOidUnidadNegocio;
    }



    public Long getOidMensaje() {
        return oidMensaje;
    }

    public void setOidMensaje(Long newOidMensaje) {
        oidMensaje = newOidMensaje;
    }

    public Long getOidActividad() {
        return oidActividad;
    }

    public void setOidActividad(Long newOidActividad) {
        oidActividad = newOidActividad;
    }

    public Long getOidFormaCobro() {
        return oidFormaCobro;
    }

    public void setOidFormaCobro(Long newOidFormaCobro) {
        oidFormaCobro = newOidFormaCobro;
    }

    public Long getOidCurso() {
        return oidCurso;
    }

    public void setOidCurso(Long newOidCurso) {
        oidCurso = newOidCurso;
    }

    public Long getOidEstadoProceso() {
        return oidEstadoProceso;
    }

    public void setOidEstadoProceso(Long newOidEstadoProceso) {
        oidEstadoProceso = newOidEstadoProceso;
    }

    public Long getOidFormaPago() {
        return oidFormaPago;
    }

    public void setOidFormaPago(Long newOidFormaPago) {
        oidFormaPago = newOidFormaPago;
    }

    public Long getOidSubcriterio() {
        return oidSubcriterio;
    }

    public void setOidSubcriterio(Long newOidSubcriterio) {
        oidSubcriterio = newOidSubcriterio;
    }

    public Long getOidTipoDespacho() {
        return oidTipoDespacho;
    }

    public void setOidTipoDespacho(Long newOidTipoDespacho) {
        oidTipoDespacho = newOidTipoDespacho;
    }

    public Long getOidCicloVida() {
        return oidCicloVida;
    }

    public void setOidCicloVida(Long newOidCicloVida) {
        oidCicloVida = newOidCicloVida;
    }

    public Long getOidTipoOferta() {
        return oidTipoOferta;
    }

    public void setOidTipoOferta(Long newOidTipoOferta) {
        oidTipoOferta = newOidTipoOferta;
    }

//    public Long getOidEstadoMAV() {
//        return oidEstadoMAV;
//    }

//    public void setOidEstadoMAV(Long newOidEstadoMAV) {
//        oidEstadoMAV = newOidEstadoMAV;
//    }

    public Long getOidEstadoActividad() {
        return oidEstadoActividad;
    }

    public void setOidEstadoActividad(Long newOidEstadoActividad) {
        oidEstadoActividad = newOidEstadoActividad;
    }

    public Long getOidListaClientes() {
        return oidListaClientes;
    }

    public void setOidListaClientes(Long newOidListaClientes) {
        oidListaClientes = newOidListaClientes;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long newOidPeriodo) {
        oidPeriodo = newOidPeriodo;
    }

    public Long getOidPeriodoFinMonto() {
        return oidPeriodoFinMonto;
    }

    public void setOidPeriodoFinMonto(Long newOidPeriodoFinMonto) {
        oidPeriodoFinMonto = newOidPeriodoFinMonto;
    }

    public Long getOidPeriodoIniMonto() {
        return oidPeriodoIniMonto;
    }

    public void setOidPeriodoIniMonto(Long newOidPeriodoIniMonto) {
        oidPeriodoIniMonto = newOidPeriodoIniMonto;
    }

    public Long getOidPeriodoFin() {
        return oidPeriodoFin;
    }

    public void setOidPeriodoFin(Long newOidPeriodoFin) {
        oidPeriodoFin = newOidPeriodoFin;
    }

    public Long getOidMarcaCondicion() {
        return oidMarcaCondicion;
    }

    public void setOidMarcaCondicion(Long newOidMarcaCondicion) {
        oidMarcaCondicion = newOidMarcaCondicion;
    }

    public Long getOidClasificacion() {
        return oidClasificacion;
    }

    public void setOidClasificacion(Long newOidClasificacion) {
        oidClasificacion = newOidClasificacion;
    }

    public Long getOidProducto() {
        return oidProducto;
    }

    public void setOidProducto(Long newOidProducto) {
        oidProducto = newOidProducto;
    }

    public Long getOidProcedencia() {
        return oidProcedencia;
    }

    public void setOidProcedencia(Long newOidProcedencia) {
        oidProcedencia = newOidProcedencia;
    }

    private Long cambiarTipoLong(BigDecimal newdato) {
        if (newdato != null) {
            return (new Long(newdato.longValue()));
        } else {
            return null;
        }
    }

    private Integer cambiarTipoInteger(BigDecimal newdato) {
        if (newdato != null) {
            return (new Integer(newdato.intValue()));
        } else {
            return null;
        }
    }

    private Double cambiarTipoDouble(BigDecimal newdato) {
        if (newdato != null) {
            return (new Double(newdato.doubleValue()));
        } else {
            return null;
        }
    }

    private String cargaCampo(Vector vec, String campoDB, Object parametro) {
        if (parametro != null) {
            vec.add(parametro);

            return new String(" " + campoDB + " = ?,");
        } else {
            return new String(" " + campoDB + " = NULL,");
        }
    }

	public Long getOidTipoClasificacion() {
		return oidTipoClasificacion;
	}

	public void setOidTipoClasificacion(Long newOidTipoClasificacion) {
		oidTipoClasificacion = newOidTipoClasificacion;
	}

	public Long getOidPeriodoCurso() {
		return oidPeriodoCurso;
	}

	public void setOidPeriodoCurso(Long newOidPeriodoCurso) {
		oidPeriodoCurso = newOidPeriodoCurso;
	}

        public void setIndExclusionTipoClasificacion(Boolean indExclusionTipoClasificacion) {
            this.indExclusionTipoClasificacion = indExclusionTipoClasificacion;
        }
    
        public Boolean getIndExclusionTipoClasificacion() {
            return indExclusionTipoClasificacion;
        }

        public void setOidTipoClienteCriterio(Long oidTipoClienteCriterio) {
            this.oidTipoClienteCriterio = oidTipoClienteCriterio;
        }
    
        public Long getOidTipoClienteCriterio() {
            return oidTipoClienteCriterio;
        }
    
        public void setOidSubTipoCliente(Long oidSubTipoCliente) {
            this.oidSubTipoCliente = oidSubTipoCliente;
        }
    
        public Long getOidSubTipoCliente() {
            return oidSubTipoCliente;
        }
        
}
