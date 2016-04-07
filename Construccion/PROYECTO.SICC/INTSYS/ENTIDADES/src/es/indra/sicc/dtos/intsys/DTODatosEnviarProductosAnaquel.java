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
package es.indra.sicc.dtos.intsys;

public class DTODatosEnviarProductosAnaquel 
{
    private String num_anaq;
    private String cod_sap;
    private Long oid_tipo_caja_emba;
    private Long unmd_oid_unid_medi_caja;
    private Long num_porc_segu;
    private float num_nive_apli;
    private float num_capa_mini;
    private float volumencaja;
    private Long val_volu;
    private Long unmd_oid_unid_medi;
    
    //atributos agregados
    private float volumenProduConvertido;
    private float volumenCajaConvertido;
    private float capacidadMinimaConvertido;
    private float nivelAplicacionConvertido;
    
    public DTODatosEnviarProductosAnaquel()
    {
    }
    public void setNum_anaq(String num_anaq)
    {
        this.num_anaq = num_anaq;
    }


    public String getNum_anaq()
    {
        return num_anaq;
    }


    public void setCod_sap(String cod_sap)
    {
        this.cod_sap = cod_sap;
    }


    public String getCod_sap()
    {
        return cod_sap;
    }


    public void setOid_tipo_caja_emba(Long oid_tipo_caja_emba)
    {
        this.oid_tipo_caja_emba = oid_tipo_caja_emba;
    }


    public Long getOid_tipo_caja_emba()
    {
        return oid_tipo_caja_emba;
    }


    public void setUnmd_oid_unid_medi_caja(Long unmd_oid_unid_medi_caja)
    {
        this.unmd_oid_unid_medi_caja = unmd_oid_unid_medi_caja;
    }


    public Long getUnmd_oid_unid_medi_caja()
    {
        return unmd_oid_unid_medi_caja;
    }


    public void setNum_porc_segu(Long num_porc_segu)
    {
        this.num_porc_segu = num_porc_segu;
    }


    public Long getNum_porc_segu()
    {
        return num_porc_segu;
    }


    public void setNum_nive_apli(float num_nive_apli)
    {
        this.num_nive_apli = num_nive_apli;
    }


    public float getNum_nive_apli()
    {
        return num_nive_apli;
    }


    public void setNum_capa_mini(float num_capa_mini)
    {
        this.num_capa_mini = num_capa_mini;
    }


    public float getNum_capa_mini()
    {
        return num_capa_mini;
    }


    public void setVolumencaja(float volumencaja)
    {
        this.volumencaja = volumencaja;
    }


    public float getVolumencaja()
    {
        return volumencaja;
    }


    public void setVal_volu(Long val_volu)
    {
        this.val_volu = val_volu;
    }


    public Long getVal_volu()
    {
        return val_volu;
    }


    public void setUnmd_oid_unid_medi(Long unmd_oid_unid_medi)
    {
        this.unmd_oid_unid_medi = unmd_oid_unid_medi;
    }


    public Long getUnmd_oid_unid_medi()
    {
        return unmd_oid_unid_medi;
    }


    public void setVolumenCajaConvertido(float volumenCajaConvertido)
    {
        this.volumenCajaConvertido = volumenCajaConvertido;
    }


    public float getVolumenCajaConvertido()
    {
        return volumenCajaConvertido;
    }


    public void setCapacidadMinimaConvertido(float capacidadMinimaConvertido)
    {
        this.capacidadMinimaConvertido = capacidadMinimaConvertido;
    }


    public float getCapacidadMinimaConvertido()
    {
        return capacidadMinimaConvertido;
    }


    public void setNivelAplicacionConvertido(float nivelAplicacionConvertido)
    {
        this.nivelAplicacionConvertido = nivelAplicacionConvertido;
    }


    public float getNivelAplicacionConvertido()
    {
        return nivelAplicacionConvertido;
    }


    public void setVolumenProduConvertido(float volumenProduConvertido)
    {
        this.volumenProduConvertido = volumenProduConvertido;
    }


    public float getVolumenProduConvertido()
    {
        return volumenProduConvertido;
    }
}