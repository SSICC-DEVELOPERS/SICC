package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

@Entity
@Table(name="APE_LISTA_PICAD_CABEC")
@NamedQueries({
@NamedQuery(name="ListaPicadoCabeceraLocal.FindAll",query="select object(o) from ListaPicadoCabeceraLocal o")
})
public class ListaPicadoCabeceraLocal implements Serializable {

    public ListaPicadoCabeceraLocal() {}

    public ListaPicadoCabeceraLocal(Long oid, Timestamp fecCrea, Long perdOidPeri, 
            Long ccdiOidConfCentDist, Long liarOidLineArma, Long zorgOidRegi, String indImp1) {
    
        this.oid = oid;
        setImpreso(indImp1);
        setFechaCreacion(fecCrea);
        setPerdOidPeri(perdOidPeri);
        setCcdiOidConfCentDist(ccdiOidConfCentDist);
        setLiarOidLineArma(liarOidLineArma);
        setZorgOidRegi(zorgOidRegi);
    }

    @Id
    @Column(name="OID_LIST_PICA_CABE")
    private Long oid;
    @Column(name="COD_LIST_PICA")
    private Long codigoListaPicado;
    @Column(name="NUM_TOTA_CAJA")
    private Long numeroTotalCajas;
    @Column(name="VAL_SECU")
    private String secuencia;
    @Column(name="IND_IMPR")
    private String indicadorImpresion;
    @Column(name="FEC_CREA")
    private java.sql.Timestamp fechaCreacion;
    @Column(name="NUM_VOLU")
    private Double volumen;
    @Column(name="NUM_UNID_TOTA")
    private Long numeroUnidadesTotales;
    @Column(name="IND_IMP1")
    private String impreso;
    @Column(name="NUM_SECU_ZONA_RUTA")
    private Long secuenciaZonaRuta;
    @Column(name="VAL_TEXT_CHEQ")
    private String textoChequeo;
    @Column(name="VAL_TEXT_PRIM_PEDI")
    private String textoPrimerPedido;
    @Column(name="IND_INTE_ENVI")
    private String indicadorInterfaceEnviada;
    @Column(name="FEC_HORA_INIC_EMBA")
    private java.sql.Timestamp fechaHoraInicioEmbalaje;
    @Column(name="FEC_HORA_FINA_EMBA")
    private java.sql.Timestamp fechaHoraFinEmbalaje;
    @Column(name="PERD_OID_PERI")
    private Long perdOidPeri;
    @Column(name="ZSCC_OID_SECC")
    private Long zsccOidSecc;
    @Column(name="CLIE_OID_CLIE")
    private Long clieOidClie;
    @Column(name="CCDI_OID_CONF_CENT_DIST")
    private Long ccdiOidConfCentDist;
    @Column(name="LIAR_OID_LINE_ARMA")
    private Long liarOidLineArma;
    @Column(name="SOCA_OID_SOLI_CABE")
    private Long socaOidSoliCabe;
    @Column(name="ZZON_OID_ZONA")
    private Long zzonOidZona;
    @Column(name="VAL_NOMB_FACT")
    private String nombreFacturador;
    @Column(name="ZORG_OID_REGI")
    private Long zorgOidRegi;
    @Column(name="FEC_FACTU")
    private java.sql.Timestamp fechaFacturacion;
    @Column(name="IND_ORIG_CHEQ")
    private String origenChequeo;
    @Column(name="INRE_OID_INDI_REVI")
    private Long inreOidIndiRevi;
    @Column(name="LIAC_OID_CONF_LAFP_CABE")
    private Long liacOidConfLafpCabe;

    
    public Long getOid() {return oid;}
    
    public Long getCodigoListaPicado() {return codigoListaPicado;}
  
    public void setCodigoListaPicado(Long codigoListaPicado){this.codigoListaPicado=codigoListaPicado;}
            
    public Long getNumeroTotalCajas() {return numeroTotalCajas;}
  
    public void setNumeroTotalCajas(Long numeroTotalCajas){this.numeroTotalCajas=numeroTotalCajas;}
            
    public String getSecuencia() {return secuencia;}
  
    public void setSecuencia(String secuencia){this.secuencia=secuencia;}
            
    public String getIndicadorImpresion() {return indicadorImpresion;}
  
    public void setIndicadorImpresion(String indicadorImpresion){this.indicadorImpresion=indicadorImpresion;}
            
    public java.sql.Timestamp getFechaCreacion() {return fechaCreacion;}
  
    public void setFechaCreacion(java.sql.Timestamp fechaCreacion){this.fechaCreacion=fechaCreacion;}
            
    public Double getVolumen() {return volumen;}
  
    public void setVolumen(Double volumen){this.volumen=volumen;}
            
    public Long getNumeroUnidadesTotales() {return numeroUnidadesTotales;}
  
    public void setNumeroUnidadesTotales(Long numeroUnidadesTotales){this.numeroUnidadesTotales=numeroUnidadesTotales;}
            
    public String getImpreso() {return impreso;}
  
    public void setImpreso(String impreso){this.impreso=impreso;}
            
    public Long getSecuenciaZonaRuta() {return secuenciaZonaRuta;}
  
    public void setSecuenciaZonaRuta(Long secuenciaZonaRuta){this.secuenciaZonaRuta=secuenciaZonaRuta;}
            
    public String getTextoChequeo() {return textoChequeo;}
  
    public void setTextoChequeo(String textoChequeo){this.textoChequeo=textoChequeo;}
            
    public String getTextoPrimerPedido() {return textoPrimerPedido;}
  
    public void setTextoPrimerPedido(String textoPrimerPedido){this.textoPrimerPedido=textoPrimerPedido;}
            
    public String getIndicadorInterfaceEnviada() {return indicadorInterfaceEnviada;}
  
    public void setIndicadorInterfaceEnviada(String indicadorInterfaceEnviada){this.indicadorInterfaceEnviada=indicadorInterfaceEnviada;}
            
    public java.sql.Timestamp getFechaHoraInicioEmbalaje() {return fechaHoraInicioEmbalaje;}
  
    public void setFechaHoraInicioEmbalaje(java.sql.Timestamp fechaHoraInicioEmbalaje){this.fechaHoraInicioEmbalaje=fechaHoraInicioEmbalaje;}
            
    public java.sql.Timestamp getFechaHoraFinEmbalaje() {return fechaHoraFinEmbalaje;}
  
    public void setFechaHoraFinEmbalaje(java.sql.Timestamp fechaHoraFinEmbalaje){this.fechaHoraFinEmbalaje=fechaHoraFinEmbalaje;}
            
    public Long getPerdOidPeri() {return perdOidPeri;}
  
    public void setPerdOidPeri(Long perdOidPeri){this.perdOidPeri=perdOidPeri;}
            
    public Long getZsccOidSecc() {return zsccOidSecc;}
  
    public void setZsccOidSecc(Long zsccOidSecc){this.zsccOidSecc=zsccOidSecc;}
            
    public Long getClieOidClie() {return clieOidClie;}
  
    public void setClieOidClie(Long clieOidClie){this.clieOidClie=clieOidClie;}
            
    public Long getCcdiOidConfCentDist() {return ccdiOidConfCentDist;}
  
    public void setCcdiOidConfCentDist(Long ccdiOidConfCentDist){this.ccdiOidConfCentDist=ccdiOidConfCentDist;}
            
    public Long getLiarOidLineArma() {return liarOidLineArma;}
  
    public void setLiarOidLineArma(Long liarOidLineArma){this.liarOidLineArma=liarOidLineArma;}
            
    public Long getSocaOidSoliCabe() {return socaOidSoliCabe;}
  
    public void setSocaOidSoliCabe(Long socaOidSoliCabe){this.socaOidSoliCabe=socaOidSoliCabe;}
            
    public Long getZzonOidZona() {return zzonOidZona;}
  
    public void setZzonOidZona(Long zzonOidZona){this.zzonOidZona=zzonOidZona;}
            
    public String getNombreFacturador() {return nombreFacturador;}
  
    public void setNombreFacturador(String nombreFacturador){this.nombreFacturador=nombreFacturador;}
            
    public Long getZorgOidRegi() {return zorgOidRegi;}
  
    public void setZorgOidRegi(Long zorgOidRegi){this.zorgOidRegi=zorgOidRegi;}
            
    public java.sql.Timestamp getFechaFacturacion() {return fechaFacturacion;}
  
    public void setFechaFacturacion(java.sql.Timestamp fechaFacturacion){this.fechaFacturacion=fechaFacturacion;}
            
    public String getOrigenChequeo() {return origenChequeo;}
  
    public void setOrigenChequeo(String origenChequeo){this.origenChequeo=origenChequeo;}
            
    public Long getInreOidIndiRevi() {return inreOidIndiRevi;}
  
    public void setInreOidIndiRevi(Long inreOidIndiRevi){this.inreOidIndiRevi=inreOidIndiRevi;}
            
    public Long getLiacOidConfLafpCabe() {return liacOidConfLafpCabe;}
  
    public void setLiacOidConfLafpCabe(Long liacOidConfLafpCabe){this.liacOidConfLafpCabe=liacOidConfLafpCabe;}
                    
    
}
