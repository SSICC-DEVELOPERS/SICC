package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="APE_LISTA_PICAD_DETAL")
@NamedQueries({
@NamedQuery(name="ListaPicadoDetalleLocal.FindAll",query="select object(o) from ListaPicadoDetalleLocal o")
})
public class ListaPicadoDetalleLocal implements Serializable {

    public ListaPicadoDetalleLocal() {}

    public ListaPicadoDetalleLocal(Long oid, Long codigoPosicion, Long unidadesProducto, 
            BigDecimal valorLinea, Long numeroCaja, String indicadorImpresion, 
            String nombrePicador, Long unidadesPicadas, Long unidadesChequeadas, 
            String nombreChequeador, Long cabecera, Long mapaCentroDistribucionDetalle, 
            Long tiposCajaEmbalaje, Long producto, Long sistemaPicado, Long undidadesVerificadas)	{
            
        this.oid = oid;
        setCodigoPosicion(codigoPosicion);
        setUnidadesProducto(unidadesProducto);
        setValorLinea(valorLinea);
        setNumeroCaja(numeroCaja);
        setIndicadorImpresion(indicadorImpresion);
        setNombrePicador(nombrePicador);
        setUnidadesPicadas(unidadesPicadas);
        setUnidadesChequeadas(unidadesChequeadas);
        setNombreChequeador(nombreChequeador);
        setCabecera(cabecera);
        setMapaCentroDistribucionDetalle(mapaCentroDistribucionDetalle);
        setTiposCajaEmbalaje(tiposCajaEmbalaje);
        setProducto(producto);
        setSistemaPicado(sistemaPicado);
        setUnidadesVerificadas(undidadesVerificadas);
    }

    @Id
    @Column(name="OID_LIST_PICA_DETA")
    private Long oid;
    @Column(name="NUM_CODI_POSI")
    private Long codigoPosicion;
    @Column(name="NUM_UNID_PROD")
    private Long unidadesProducto;
    @Column(name="VAL_LINE")
    private java.math.BigDecimal valorLinea;
    @Column(name="NUM_CAJA")
    private Long numeroCaja;
    @Column(name="IND_IMPR")
    private String indicadorImpresion;
    @Column(name="VAL_NOMB_PICA")
    private String nombrePicador;
    @Column(name="NUM_UNID_PICA")
    private Long unidadesPicadas;
    @Column(name="NUM_UNID_CHEQ")
    private Long unidadesChequeadas;
    @Column(name="LPCA_OID_LIST_PICA_CABE")
    private Long cabecera;
    @Column(name="TCEM_OID_TIPO_CAJA_EMBA")
    private Long tiposCajaEmbalaje;
    @Column(name="MCDD_OID_MAPA_CENT_DIST_DETA")
    private Long mapaCentroDistribucionDetalle;
    @Column(name="SIPI_OID_SIST_PICA")
    private Long sistemaPicado;
    @Column(name="PROD_OID_PROD")
    private Long producto;
    @Column(name="VAL_NOMB_CHEQ")
    private String nombreChequeador;
    @Column(name="VAL_OBSE_REVI")
    private String observacionesRevision;
    @Column(name="COEC_OID_CODI_ERRO_CHEQ")
    private Long codigoError;
    //Agregado por cambio 20090839 
    @Column(name="NUM_UNID_VERI")
    private Long unidadesVerificadas;

    
    public Long getOid() {return oid;}
    
    public Long getCodigoPosicion() {return codigoPosicion;}
  
    public void setCodigoPosicion(Long codigoPosicion){this.codigoPosicion=codigoPosicion;}
            
    public Long getUnidadesProducto() {return unidadesProducto;}
  
    public void setUnidadesProducto(Long unidadesProducto){this.unidadesProducto=unidadesProducto;}
            
    public java.math.BigDecimal getValorLinea() {return valorLinea;}
  
    public void setValorLinea(java.math.BigDecimal valorLinea){this.valorLinea=valorLinea;}
            
    public Long getNumeroCaja() {return numeroCaja;}
  
    public void setNumeroCaja(Long numeroCaja){this.numeroCaja=numeroCaja;}
            
    public String getIndicadorImpresion() {return indicadorImpresion;}
  
    public void setIndicadorImpresion(String indicadorImpresion){this.indicadorImpresion=indicadorImpresion;}
            
    public String getNombrePicador() {return nombrePicador;}
  
    public void setNombrePicador(String nombrePicador){this.nombrePicador=nombrePicador;}
            
    public Long getUnidadesPicadas() {return unidadesPicadas;}
  
    public void setUnidadesPicadas(Long unidadesPicadas){this.unidadesPicadas=unidadesPicadas;}
            
    public Long getUnidadesChequeadas() {return unidadesChequeadas;}
  
    public void setUnidadesChequeadas(Long unidadesChequeadas){this.unidadesChequeadas=unidadesChequeadas;}
            
    public Long getCabecera() {return cabecera;}
  
    public void setCabecera(Long cabecera){this.cabecera=cabecera;}
            
    public Long getTiposCajaEmbalaje() {return tiposCajaEmbalaje;}
  
    public void setTiposCajaEmbalaje(Long tiposCajaEmbalaje){this.tiposCajaEmbalaje=tiposCajaEmbalaje;}
            
    public Long getMapaCentroDistribucionDetalle() {return mapaCentroDistribucionDetalle;}
  
    public void setMapaCentroDistribucionDetalle(Long mapaCentroDistribucionDetalle){this.mapaCentroDistribucionDetalle=mapaCentroDistribucionDetalle;}
            
    public Long getSistemaPicado() {return sistemaPicado;}
  
    public void setSistemaPicado(Long sistemaPicado){this.sistemaPicado=sistemaPicado;}
            
    public Long getProducto() {return producto;}
  
    public void setProducto(Long producto){this.producto=producto;}
            
    public String getNombreChequeador() {return nombreChequeador;}
  
    public void setNombreChequeador(String nombreChequeador){this.nombreChequeador=nombreChequeador;}
            
    public String getObservacionesRevision() {return observacionesRevision;}
  
    public void setObservacionesRevision(String observacionesRevision){this.observacionesRevision=observacionesRevision;}
            
    public Long getCodigoError() {return codigoError;}
  
    public void setCodigoError(Long codigoError){this.codigoError=codigoError;}
    
    //Agregado por cambio 20090839
    
     public Long getUnidadesVerificadas() {return unidadesVerificadas;}
     
     public void setUnidadesVerificadas(Long unidadesVerificadas){this.unidadesVerificadas=unidadesVerificadas;}
    
     
                    
	
}
