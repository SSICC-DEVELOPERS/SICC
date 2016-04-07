package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="REC_LINEA_OPERA_RECLA")
@NamedQueries({
@NamedQuery(name="LineasOperacionReclamoLocal.FindAll",query="select object(o) from LineasOperacionReclamoLocal o"),
@NamedQuery(name="LineasOperacionReclamoLocal.FindByOperacion",query="SELECT OBJECT(o) FROM LineasOperacionReclamoLocal o WHERE o.operacion = ?1"),
@NamedQuery(name="LineasOperacionReclamoLocal.FindByUK",query="SELECT OBJECT(o) FROM LineasOperacionReclamoLocal o WHERE o.operacion = ?1 AND o.numeroLinea = ?2")
})
public class LineasOperacionReclamoLocal implements Serializable {

	public LineasOperacionReclamoLocal() {}

	public LineasOperacionReclamoLocal(Long oid, Integer numeroLinea, Long operacion, Long tipoOferta, Long tipoPosicion, Long tipoMovimiento, Long motivoDevolucion)	{
	
		this.oid=oid;
                this.numeroLinea=numeroLinea;
                this.operacion=operacion;
                this.tipoOferta=tipoOferta;
                this.tipoPosicion=tipoPosicion;
                this.tipoMovimiento=tipoMovimiento;
                this.motivoDevolucion=motivoDevolucion;
	
	}

	@Id
	@Column(name="OID_LINE_OPER_RECL")
	private Long oid;
	@Column(name="NUM_LINE")
	private Integer numeroLinea;
	@Column(name="NUM_UNID_RECL")
	private Integer unidadesReclamadas;
	@Column(name="VAL_PREC")
	private BigDecimal precio;
	@Column(name="IMP_ABON")
	private BigDecimal importeAbono;
	@Column(name="IMP_CARG")
	private BigDecimal importeCargo;
	@Column(name="NUM_UNID_DEVU")
	private Integer numeroUnidadesDevueltas;
	@Column(name="IND_ESTA")
	private Character indicadorEstado;
	@Column(name="IMP_MONT_PERD")
	private BigDecimal montoPerdida;
	@Column(name="IND_ATEN")
	private Boolean atendido;
	@Column(name="OPRE_OID_OPER_RECL")
	private Long operacion;
	@Column(name="TOFE_OID_TIPO_OFER")
	private Long tipoOferta;
	@Column(name="PPER_OID_PREC_PERD")
	private Long precioPerdida;
	@Column(name="TPOS_OID_TIPO_POSI")
	private Long tipoPosicion;
	@Column(name="TIMO_OID_TIPO_MOVI")
	private Long tipoMovimiento;
	@Column(name="PROD_OID_PROD")
	private Long producto;
	@Column(name="MAFA_OID_MATR_FACT")
	private Long codigoVenta;
	@Column(name="MODV_OID_MOTI_DEVO")
	private Long motivoDevolucion;
	@Column(name="MRDB_OID_MOTI_RECH_DESB")
	private Long motivoDesbloqueo;
	@Column(name="TSPA_OID_TIPO_SOLI_PAIS")
	private Long tipoSolicitud;
	@Column(name="SOPO_OID_SOLI_POSI")
	private Long posicionReferencia;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long oidConcurso;
	@Column(name="PANP_OID_PARA_NIVE_PREM")
	private Long oidNivel;
	@Column(name="LOPA_OID_LOTE_PREM_ARTI")
	private Long oidPremio;
	@Column(name="VAL_PREC_CONT")
	private BigDecimal precioContable;
        @Column(name="IND_RECO")
        private Character indicadorRecogible;        

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroLinea() {return numeroLinea;}
      
	public void setNumeroLinea(Integer numeroLinea){this.numeroLinea=numeroLinea;}
		
	public Integer getUnidadesReclamadas() {return unidadesReclamadas;}
      
	public void setUnidadesReclamadas(Integer unidadesReclamadas){this.unidadesReclamadas=unidadesReclamadas;}
		
	public BigDecimal getPrecio() {return precio;}
      
	public void setPrecio(BigDecimal precio){this.precio=precio;}
		
	public BigDecimal getImporteAbono() {return importeAbono;}
      
	public void setImporteAbono(BigDecimal importeAbono){this.importeAbono=importeAbono;}
		
	public BigDecimal getImporteCargo() {return importeCargo;}
      
	public void setImporteCargo(BigDecimal importeCargo){this.importeCargo=importeCargo;}
		
	public Integer getNumeroUnidadesDevueltas() {return numeroUnidadesDevueltas;}
      
	public void setNumeroUnidadesDevueltas(Integer numeroUnidadesDevueltas){this.numeroUnidadesDevueltas=numeroUnidadesDevueltas;}
		
	public Character getIndicadorEstado() {return indicadorEstado;}
      
	public void setIndicadorEstado(Character indicadorEstado){this.indicadorEstado=indicadorEstado;}
		
	public BigDecimal getMontoPerdida() {return montoPerdida;}
      
	public void setMontoPerdida(BigDecimal montoPerdida){this.montoPerdida=montoPerdida;}
		
	public Boolean getAtendido() {return atendido;}
      
	public void setAtendido(Boolean atendido){this.atendido=atendido;}
		
	public Long getOperacion() {return operacion;}
      
	public void setOperacion(Long operacion){this.operacion=operacion;}
		
	public Long getTipoOferta() {return tipoOferta;}
      
	public void setTipoOferta(Long tipoOferta){this.tipoOferta=tipoOferta;}
		
	public Long getPrecioPerdida() {return precioPerdida;}
      
	public void setPrecioPerdida(Long precioPerdida){this.precioPerdida=precioPerdida;}
		
	public Long getTipoPosicion() {return tipoPosicion;}
      
	public void setTipoPosicion(Long tipoPosicion){this.tipoPosicion=tipoPosicion;}
		
	public Long getTipoMovimiento() {return tipoMovimiento;}
      
	public void setTipoMovimiento(Long tipoMovimiento){this.tipoMovimiento=tipoMovimiento;}
		
	public Long getProducto() {return producto;}
      
	public void setProducto(Long producto){this.producto=producto;}
		
	public Long getCodigoVenta() {return codigoVenta;}
      
	public void setCodigoVenta(Long codigoVenta){this.codigoVenta=codigoVenta;}
		
	public Long getMotivoDevolucion() {return motivoDevolucion;}
      
	public void setMotivoDevolucion(Long motivoDevolucion){this.motivoDevolucion=motivoDevolucion;}
		
	public Long getMotivoDesbloqueo() {return motivoDesbloqueo;}
      
	public void setMotivoDesbloqueo(Long motivoDesbloqueo){this.motivoDesbloqueo=motivoDesbloqueo;}
		
	public Long getTipoSolicitud() {return tipoSolicitud;}
      
	public void setTipoSolicitud(Long tipoSolicitud){this.tipoSolicitud=tipoSolicitud;}
		
	public Long getPosicionReferencia() {return posicionReferencia;}
      
	public void setPosicionReferencia(Long posicionReferencia){this.posicionReferencia=posicionReferencia;}
		
	public Long getOidConcurso() {return oidConcurso;}
      
	public void setOidConcurso(Long oidConcurso){this.oidConcurso=oidConcurso;}
		
	public Long getOidNivel() {return oidNivel;}
      
	public void setOidNivel(Long oidNivel){this.oidNivel=oidNivel;}
		
	public Long getOidPremio() {return oidPremio;}
      
	public void setOidPremio(Long oidPremio){this.oidPremio=oidPremio;}
		
	public BigDecimal getPrecioContable() {return precioContable;}
      
	public void setPrecioContable(BigDecimal precioContable){this.precioContable=precioContable;}


    public void setIndicadorRecogible(Character indicadorRecogible) {
        this.indicadorRecogible = indicadorRecogible;
    }

    public Character getIndicadorRecogible() {
        return indicadorRecogible;
    }
}
