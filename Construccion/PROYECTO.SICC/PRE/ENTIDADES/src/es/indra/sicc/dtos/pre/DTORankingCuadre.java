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

package es.indra.sicc.dtos.pre;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import java.util.ArrayList;

/**
 * 
 * @date 11/08/2005
 * @author pperanzola
 */
public class DTORankingCuadre extends DTOAuditableSICC 
{
    private Long tipoPosicion;
    private Long subtipoPosicion;
    private Long oidOferta;
    private Long primerRanking;
    private Long ultimoRanking;
    private DTOCabeceraSolicitud DTOCabeceraSolicitud;
    private ArrayList posicionesOferta;
    private Long numeroUnidadesA;
    private Long numeroGrupo;

    public DTORankingCuadre()
    {
    }

    public Long getTipoPosicion()
    {
        return tipoPosicion;
    }

    public void setTipoPosicion(Long tipoPosicion)
    {
        this.tipoPosicion = tipoPosicion;
    }

    public Long getSubtipoPosicion()
    {
        return subtipoPosicion;
    }

    public void setSubtipoPosicion(Long subtipoPosicion)
    {
        this.subtipoPosicion = subtipoPosicion;
    }

    public Long getOidOferta()
    {
        return oidOferta;
    }

    public void setOidOferta(Long oidOferta)
    {
        this.oidOferta = oidOferta;
    }

    public Long getPrimerRanking()
    {
        return primerRanking;
    }

    public void setPrimerRanking(Long primerRanking)
    {
        this.primerRanking = primerRanking;
    }

    public Long getUltimoRanking()
    {
        return ultimoRanking;
    }

    public void setUltimoRanking(Long ultimoRanking)
    {
        this.ultimoRanking = ultimoRanking;
    }

    public DTOCabeceraSolicitud getDTOCabeceraSolicitud()
    {
        return DTOCabeceraSolicitud;
    }

    public void setDTOCabeceraSolicitud(DTOCabeceraSolicitud DTOCabeceraSolicitud)
    {
        this.DTOCabeceraSolicitud = DTOCabeceraSolicitud;
    }

    public ArrayList getPosicionesOferta()
    {
        return posicionesOferta;
    }

    public void setPosicionesOferta(ArrayList posicionesOferta)
    {
        this.posicionesOferta = posicionesOferta;
    }

    public Long getNumeroUnidadesA()
    {
        return numeroUnidadesA;
    }

    public void setNumeroUnidadesA(Long numeroUnidadesA)
    {
        this.numeroUnidadesA = numeroUnidadesA;
    }

    public Long getNumeroGrupo()
    {
        return numeroGrupo;
    }

    public void setNumeroGrupo(Long numeroGrupo)
    {
        this.numeroGrupo = numeroGrupo;
    }
    
}