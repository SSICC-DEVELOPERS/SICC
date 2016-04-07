/**
* Copyright 2005 � por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* Espa�a
*
* Privado y Confidencial.
* La informaci�n contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permiti�ndose
* la distribuci�n de este c�digo sin permiso expreso.
*/

package es.indra.sicc.dtos.intsys;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * 
 * @date 
 * @author pperanzola
 */
public class DTOCodProdOid extends DTOAuditableSICC 
{
    private Long oidProducto;
    private String codProducto;

    /**
     * 
     * @date 
     */
    public DTOCodProdOid()
    {
    }

    public Long getOidProducto()
    {
        return oidProducto;
    }

    public void setOidProducto(Long oidProducto)
    {
        this.oidProducto = oidProducto;
    }

    public String getCodProducto()
    {
        return codProducto;
    }

    public void setCodProducto(String codProducto)
    {
        this.codProducto = codProducto;
    }
}