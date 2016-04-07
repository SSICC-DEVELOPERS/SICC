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
package es.indra.sicc.logicanegocio.intsys.PaqueteDeAyudaIdioma;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.MONI18n;
import es.indra.sicc.cmn.negocio.i18n.MONI18nHome;
import es.indra.sicc.logicanegocio.intsys.IGEN;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;
import java.util.Vector;
import javax.ejb.SessionContext;

public class GestorIdiomasINT implements IGEN
{
    //************* CREADO POR INCIDENCIA 20408 *****************
    private SessionContext ctx=null;
    
    public GestorIdiomasINT()
    {
    }
    
    public void setSessionContext(SessionContext ctx) {
      this.ctx=ctx;
    }
    
    public void generarDescripcionIdiomaNoES(Long oidEntidad , 
                                             String entidad , 
                                             Long idioma , 
                                             String descripcion ) throws MareException 
    {
        UtilidadesLog.info("GestorIdiomasINT.generarDescripcionIdiomaNoES(Long oidEntidad , String entidad , Long idioma , String descripcion): Entrada");
        MONI18n monI18n=this.getMONI18n();
        Vector vector=new Vector();
        DTOI18nSICC dto = new DTOI18nSICC();
        dto.setOidAtriuto(new Long(1));
        dto.setOidIdioma(idioma);
        dto.setValorI18n(descripcion);
        vector.add(dto);
        try 
        {
            monI18n.insertarTraducciones(entidad,oidEntidad,vector);
            UtilidadesLog.info("GestorIdiomasINT.generarDescripcionIdiomaNoES(Long oidEntidad , String entidad , Long idioma , String descripcion): Salida");
        }catch (RemoteException re)
        {            
            throw new MareException(re,
            UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }
    
     private MONI18n getMONI18n() throws MareException {
	    // Se obtiene el interfaz home
        UtilidadesLog.info("GestorIdiomasINT.getMONI18n(): Entrada");
        MONI18nHome home = (MONI18nHome)UtilidadesEJB.getHome("MONI18n", MONI18nHome.class);
        // Se obtiene el interfaz remoto
        MONI18n ejb = null;
        try {
			ejb = home.create();
		} catch (Exception e) {
		
			UtilidadesLog.error("*** Error en getMONI18n",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
		UtilidadesLog.info("GestorIdiomasINT.getMONI18n(): Salida");        
        return ejb;
	}
}