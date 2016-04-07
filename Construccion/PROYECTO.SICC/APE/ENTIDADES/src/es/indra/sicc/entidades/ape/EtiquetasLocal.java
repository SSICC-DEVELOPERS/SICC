package es.indra.sicc.entidades.ape;

import es.indra.sicc.logicanegocio.ape.ConstantesAPE;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_ETIQU")
@NamedQueries({
@NamedQuery(name="EtiquetasLocal.FindAll",query="select object(o) from EtiquetasLocal o"),
@NamedQuery(name="EtiquetasLocal.FindByListaPicCabecCaja",query="select object(o) "
+ " from EtiquetasLocal o "
+ " WHERE o.listaPicado = ?1 "
+ " AND o.numeroCaja = ?2")
})
public class EtiquetasLocal implements Serializable {

    public EtiquetasLocal() {}

    public EtiquetasLocal(Long oid, Long numEtiqueta, Long numCaja, Long numTotalCajas,
            Long oidPais, Long oidListaPicado, Long oidCentroDist)	{
    
        this.oid = oid;
        setNumeroEtiqueta(numEtiqueta);
        setNumeroCaja(numCaja);
        setNumeroTotalCajas(numTotalCajas);
        setPais(oidPais);
        setListaPicado(oidListaPicado);
        setCentroDistribucion(oidCentroDist);
        setImpreso(ConstantesAPE.IMPRESION_NO);
    }

    @Id
    @Column(name="OID_ETIQ")
    private Long oid;
    @Column(name="NUM_ETIQ")
    private Long numeroEtiqueta;
    @Column(name="NUM_CAJA")
    private Long numeroCaja;
    @Column(name="NUM_TOTA_CAJA")
    private Long numeroTotalCajas;
    @Column(name="NUM_SECU")
    private Long secuencial;
    @Column(name="VAL_TEXT_CHEQ")
    private String textoChequeo;
    @Column(name="VAL_TEXT_PRIM_PEDI")
    private String textoPrimerPedido;
    @Column(name="VAL_TEXT_VARI")
    private String textoVariable;
    @Column(name="IND_IMPR")
    private Character impreso;
    @Column(name="IND_ESTA")
    private String estado;
    @Column(name="FEC_HORA_INIC_CHEQ")
    private java.sql.Timestamp horaInicioChequeo;
    @Column(name="FEC_HORA_FINA_CHEQ")
    private java.sql.Timestamp horaFinChequeo;
    @Column(name="SOCA_OID_SOLI_CABE")
    private Long solicitudCabecera;
    @Column(name="TCEM_OID_TIPO_CAJA_EMBA")
    private Long tipoCajaEmbalaje;
    @Column(name="ZSCC_OID_SECC")
    private Long seccion;
    @Column(name="ZZON_OID_ZONA")
    private Long zona;
    @Column(name="CCDI_OID_CONF_CENT_DIST")
    private Long centroDistribucion;
    @Column(name="LPCA_OID_LIST_PICA_CABE")
    private Long listaPicado;
    @Column(name="PAIS_OID_PAIS")
    private Long pais;
    @Column(name="VAL_USUA_CHEQ")
    private String usuario;
    @Column(name="ESTP_OID_ESTA_PEDI")
    private Long oidEstado;

    
    public Long getOid() {return oid;}
    
    public Long getNumeroEtiqueta() {return numeroEtiqueta;}
  
    public void setNumeroEtiqueta(Long numeroEtiqueta){this.numeroEtiqueta=numeroEtiqueta;}
            
    public Long getNumeroCaja() {return numeroCaja;}
  
    public void setNumeroCaja(Long numeroCaja){this.numeroCaja=numeroCaja;}
            
    public Long getNumeroTotalCajas() {return numeroTotalCajas;}
  
    public void setNumeroTotalCajas(Long numeroTotalCajas){this.numeroTotalCajas=numeroTotalCajas;}
            
    public Long getSecuencial() {return secuencial;}
  
    public void setSecuencial(Long secuencial){this.secuencial=secuencial;}
            
    public String getTextoChequeo() {return textoChequeo;}
  
    public void setTextoChequeo(String textoChequeo){this.textoChequeo=textoChequeo;}
            
    public String getTextoPrimerPedido() {return textoPrimerPedido;}
  
    public void setTextoPrimerPedido(String textoPrimerPedido){this.textoPrimerPedido=textoPrimerPedido;}
            
    public String getTextoVariable() {return textoVariable;}
  
    public void setTextoVariable(String textoVariable){this.textoVariable=textoVariable;}
            
    public Character getImpreso() {return impreso;}
  
    public void setImpreso(Character impreso){this.impreso=impreso;}
            
    public String getEstado() {return estado;}
  
    public void setEstado(String estado){this.estado=estado;}
            
    public java.sql.Timestamp getHoraInicioChequeo() {return horaInicioChequeo;}
  
    public void setHoraInicioChequeo(java.sql.Timestamp horaInicioChequeo){this.horaInicioChequeo=horaInicioChequeo;}
            
    public java.sql.Timestamp getHoraFinChequeo() {return horaFinChequeo;}
  
    public void setHoraFinChequeo(java.sql.Timestamp horaFinChequeo){this.horaFinChequeo=horaFinChequeo;}
            
    public Long getSolicitudCabecera() {return solicitudCabecera;}
  
    public void setSolicitudCabecera(Long solicitudCabecera){this.solicitudCabecera=solicitudCabecera;}
            
    public Long getTipoCajaEmbalaje() {return tipoCajaEmbalaje;}
  
    public void setTipoCajaEmbalaje(Long tipoCajaEmbalaje){this.tipoCajaEmbalaje=tipoCajaEmbalaje;}
            
    public Long getSeccion() {return seccion;}
  
    public void setSeccion(Long seccion){this.seccion=seccion;}
            
    public Long getZona() {return zona;}
  
    public void setZona(Long zona){this.zona=zona;}
            
    public Long getCentroDistribucion() {return centroDistribucion;}
  
    public void setCentroDistribucion(Long centroDistribucion){this.centroDistribucion=centroDistribucion;}
            
    public Long getListaPicado() {return listaPicado;}
  
    public void setListaPicado(Long listaPicado){this.listaPicado=listaPicado;}
            
    public Long getPais() {return pais;}
  
    public void setPais(Long pais){this.pais=pais;}
            
    public String getUsuario() {return usuario;}
  
    public void setUsuario(String usuario){this.usuario=usuario;}
            
    public Long getOidEstado() {return oidEstado;}
  
    public void setOidEstado(Long oidEstado){this.oidEstado=oidEstado;}
	
}
