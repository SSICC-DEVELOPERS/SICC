package es.indra.sicc.entidades.mav;

import es.indra.sicc.cmn.negocio.auditoria.EJBLocalObjectSICCAuditable;

import javax.ejb.EJBLocalObject;
import java.math.BigDecimal;


public interface DetalleMAVLocal extends EJBLocalObjectSICCAuditable {
    Long getOid();

    void setOid(Long newOid);

    Double getPrecioEstandar();

    void setPrecioEstandar(Double newPrecioEstandar);

    Double getPrecio();

    void setPrecio(Double newPrecio);

    Double getPrecioContable();

    void setPrecioContable(Double newPrecioContable);

    String getObservaciones();

    void setObservaciones(String newObservaciones);

    Long getBaseEstimadosDestinatarios();

    void setBaseEstimadosDestinatarios(Long newBaseEstimadosDestinatarios);

    Double getFactorCorreccion();

    void setFactorCorreccion(Double newFactorCorreccion);

    BigDecimal getUnidadesEstimadas();

    void setUnidadesEstimadas(BigDecimal newUnidadesEstimadas);

    Long getUnidadesTotalesEstimadas();

    void setUnidadesTotalesEstimadas(Long newUnidadesTotalesEstimadas);

    String getCriterio();

    void setCriterio(String newCriterio);

    Integer getCampagnaEvaluacion();

    void setCampagnaEvaluacion(Integer newCampagnaEvaluacion);

    Double getMonto();

    void setMonto(Double newMonto);

    String getNumeroAniversario();

    void setNumeroAniversario(String newNumeroAniversario);

    Long getUnidadesPorCliente();

    void setUnidadesPorCliente(Long newUnidadesPorCliente);

    Long getUnidadesTotales();

    void setUnidadesTotales(Long newUnidadesTotales);

    Boolean getEnviarMensaje();

    void setEnviarMensaje(Boolean newEnviarMensaje);

    Integer getEdadDesde();

    void setEdadDesde(Integer newEdadDesde);

    Integer getEdadHasta();

    void setEdadHasta(Integer newEdadHasta);

    Long getOidTipoCliente();

    void setOidTipoCliente(Long newOidTipoCliente);

    Long getOidCatalogo();

    void setOidCatalogo(Long newOidCatalogo);

    Long getOidNegocio();

    void setOidNegocio(Long newOidNegocio);

    Long getOidUnidadNegocio();

    void setOidUnidadNegocio(Long newOidUnidadNegocio);



    Long getOidMensaje();

    void setOidMensaje(Long newOidMensaje);

    Long getOidActividad();

    void setOidActividad(Long newOidActividad);

    Long getOidFormaCobro();

    void setOidFormaCobro(Long newOidFormaCobro);

    Long getOidCurso();

    void setOidCurso(Long newOidCurso);

    Long getOidEstadoProceso();

    void setOidEstadoProceso(Long newOidEstadoProceso);

    Long getOidFormaPago();

    void setOidFormaPago(Long newOidFormaPago);

    Long getOidSubcriterio();

    void setOidSubcriterio(Long newOidSubcriterio);

    Long getOidTipoDespacho();

    void setOidTipoDespacho(Long newOidTipoDespacho);

    Long getOidCicloVida();

    void setOidCicloVida(Long newOidCicloVida);

    Long getOidTipoOferta();

    void setOidTipoOferta(Long newOidTipoOferta);

//    Long getOidEstadoMAV();

//    void setOidEstadoMAV(Long newOidEstadoMAV);

    Long getOidEstadoActividad();

    void setOidEstadoActividad(Long newOidEstadoActividad);

    Long getOidListaClientes();

    void setOidListaClientes(Long newOidListaClientes);

    Long getOidPeriodo();

    void setOidPeriodo(Long newOidPeriodo);

    Long getOidPeriodoFinMonto();

    void setOidPeriodoFinMonto(Long newOidPeriodoFinMonto);

    Long getOidPeriodoIniMonto();

    void setOidPeriodoIniMonto(Long newOidPeriodoIniMonto);

    Long getOidPeriodoFin();

    void setOidPeriodoFin(Long newOidPeriodoFin);

    Long getOidMarcaCondicion();

    void setOidMarcaCondicion(Long newOidMarcaCondicion);

    Long getOidClasificacion();

    void setOidClasificacion(Long newOidClasificacion);

    Long getOidProducto();

    void setOidProducto(Long newOidProducto);

    Long getOidProcedencia();

    void setOidProcedencia(Long newOidProcedencia);

	Long getOidTipoClasificacion();

	void setOidTipoClasificacion(Long newOidTipoClasificacion);

	Long getOidPeriodoCurso();

	void setOidPeriodoCurso(Long newOidPeriodoCurso);
        
	void setIndExclusionTipoClasificacion(Boolean indExclusionTipoClasificacion);
	
	Boolean getIndExclusionTipoClasificacion();

        void setOidTipoClienteCriterio(Long oidTipoClienteCriterio);
    
        Long getOidTipoClienteCriterio();
    
        void setOidSubTipoCliente(Long oidSubTipoCliente);
    
        Long getOidSubTipoCliente();
        
}
