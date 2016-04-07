/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import es.indra.sicc.util.BelcorpError;

public class DTORegProcesados extends BelcorpError{
    private Long oid;
    private Boolean pagado;


    public void setOid(Long oid){
        this.oid = oid;
    }


    public Long getOid(){
        return oid;
    }


    public void setPagado(Boolean pagado){
        this.pagado = pagado;
    }


    public Boolean getPagado(){
        return pagado;
    }
}