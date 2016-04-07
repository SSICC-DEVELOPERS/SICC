package es.indra.sicc.cmn.negocio.interfaces.notificacion;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.util.UtilidadesLog;


import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NotificadorSAPJCO extends Notificador {
	private String servidor;
    private String usuario;
    private String contrasena;
    private String mandante;
    private String centro;
    private String repositorio;
    private String funcion;    
    private HashMap funcion_parametros;    
    
    /* ------------------------------------------------  */
	
    private JCO.Client jcConexion=null;
	private JCO.Repository jcRepositorio = null;
	private JCO.Function funcionSAP = null;
	private JCO.ParameterList parametrosEntrada=null;
	private IFunctionTemplate ft=null;

    /* ------------------------------------------------  */
    
	public NotificadorSAPJCO(DTONotificacion dto)  throws InterfacesException {
        if(!(dto instanceof DTONotificacionSAPJCO)) {
            throw new InterfacesException("DTO Incorrecto, no es de tipo DTONotificacionSAPJCO");
        }
        
        this.setCodigoInt(dto.getCodigoInt());
        
        this.servidor=((DTONotificacionSAPJCO)dto).getServidor();
        this.usuario=((DTONotificacionSAPJCO)dto).getUsuario();
        this.contrasena=((DTONotificacionSAPJCO)dto).getContrasena();
        this.mandante=((DTONotificacionSAPJCO)dto).getMandante();
        this.centro=((DTONotificacionSAPJCO)dto).getCentro();        
        this.repositorio=((DTONotificacionSAPJCO)dto).getRepositorio();
        this.funcion=((DTONotificacionSAPJCO)dto).getFuncion();
        this.funcion_parametros=((DTONotificacionSAPJCO)dto).getFuncion_parametros();        
	}
	   
    public void notificar() throws InterfacesException {
        try {
            UtilidadesLog.info(this.toString());
         
            //Preparar la conexión
            jcConexion=JCO.createClient(this.mandante,              //mandante en SAP
                                        this.usuario,       // Usuario de acceso
                                        this.contrasena,   // Contrasenia de acceso
                                        null,
                                        this.servidor,     // IP del Servidor SAP
                                        this.centro);
            
            //Realizar la conexión vía RFC
            jcConexion.connect();
            
            // Crear un respositorio
            jcRepositorio = new JCO.Repository(this.repositorio, jcConexion);
            
            // Crear la función a llamar
            ft = jcRepositorio.getFunctionTemplate(this.funcion);
            
            //Invoca a la función SAP
            funcionSAP = ft.getFunction();            
            if (funcionSAP==null) {
               jcConexion.disconnect();
               return;
            }
            
            //Lista de Parámetros de Entrada
            parametrosEntrada = funcionSAP.getImportParameterList();            
            Set setPar = funcion_parametros.entrySet();
            Iterator itPar = setPar.iterator();
            while (itPar.hasNext()) {
                Map.Entry mapEnt=(Map.Entry)itPar.next();
                parametrosEntrada.setValue((String)mapEnt.getKey(),(String)mapEnt.getValue());  
            }
                 
            //Ejecutar la función en SAP
            jcConexion.execute(funcionSAP);            

		}catch(Exception ex) {
            throw new InterfacesException("Error enviando notificacion SAP-JCO", ex);
        }
        finally {
            try {
                UtilidadesLog.info("Desconectando de SAP...");
                // Desconexión de SAP
                if (jcConexion!=null) jcConexion.disconnect();
            } catch(Exception ex2){}
        }

    }
    
    public String toString() {
        StringBuffer sb=new StringBuffer("NOTIFICACION SAP-JCO -> Codigo Int:" + super.getCodigoInt());
        sb.append("Servidor:" + this.servidor);
        sb.append("Mandante:" + this.mandante);
        sb.append("Usuario:" + this.usuario);
        sb.append("Contrasena:" + this.contrasena);
        sb.append("Centro:" + this.centro);
        sb.append("Repositorio:" + this.repositorio);
        sb.append("Funcion:" + this.funcion);
        
        sb.append("Funcion_parametros:");
        Set setPar = this.funcion_parametros.entrySet();
        Iterator itPar = setPar.iterator();
         while (itPar.hasNext()) {
            Map.Entry mapEnt=(Map.Entry)itPar.next();
            
            sb.append((String)mapEnt.getKey());
            sb.append((String)mapEnt.getValue());  
        }        
        
        return sb.toString();
    } 
}