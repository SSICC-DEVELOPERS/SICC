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
 
package es.indra.sicc.logicanegocio.edu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.lang.StringBuffer;
import java.math.BigDecimal;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesLog;
//import es.indra.sicc.util.CodigosModulos;

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;

import es.indra.sicc.dtos.edu.DTOPlantillaCurso;
import es.indra.sicc.dtos.edu.DTODetallePlantillaCurso;
import es.indra.sicc.dtos.edu.DTOCargaCursos;
import es.indra.sicc.dtos.edu.DTOParametro;
import es.indra.sicc.dtos.edu.DTODruidaBusqueda;
import es.indra.sicc.dtos.edu.DTODependientesCarga;

import es.indra.sicc.entidades.edu.CabeceraPlantillaCursosLocalHome;
import es.indra.sicc.entidades.edu.CabeceraPlantillaCursosLocal;

import es.indra.sicc.entidades.edu.MatrizCursosLocalHome;
//import es.indra.sicc.entidades.edu.MatrizCursosLocal;

import es.indra.sicc.entidades.edu.DetallePlantillaCursosLocalHome;
import es.indra.sicc.entidades.edu.DetallePlantillaCursosLocal;

//import es.indra.sicc.entidades.edu.StatusPlantillaCursosLocalHome;
//import es.indra.sicc.entidades.edu.StatusPlantillaCursosLocal;

import es.indra.sicc.entidades.edu.PlantillaTiposCursosExigidosLocalHome;
import es.indra.sicc.entidades.edu.PlantillaTiposCursosExigidosLocal;

import es.indra.sicc.logicanegocio.edu.MONUtilidadesBD;

import java.sql.SQLException;
import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/**
 * Sistema:           Belcorp
 * Modulo:            EDU
 * Submódulo:         
 * Componente:        MONPlantillaCurso
 * Fecha:             10/03/2004917
 * Observaciones:     Este componente se construyó de acuerdo a los siguientes 
 * 					  documentos
 *                    - SICC-DMCO-EDU-201-301 EDU Paquete                      
 *                    
 * @version           1.0
 * @autor             fmunoz
 */

public class MONPlantillaCursoBean implements SessionBean 
{
    private SessionContext sessionContext;
	
    //Constantes para identificar nombres de tablas 
    private static final String EDU_PLANT_CURSO_CABEC = "EDU_PLANT_CURSO_CABEC";
    private static final String EDU_MATRI_CURSO = "EDU_MATRI_CURSO";
    private static final String EDU_TIPO_CURSO = "EDU_TIPO_CURSO";

	//Nombre de propiedades que se deben Validar el Acceso.
    private final static String C_MARCA = "0";
	private final static String C_CANAL = "1";
	private final static String C_ACCESO = "6";
	private final static String C_SUBGERENCIA = "14";
	private final static String C_REGION = "15";  
	private final static String C_ZONA = "16"; 
	private final static String C_SECCION = "17";
	private final static String C_TERRITORIO= "18";

	//Excepcion
	//Creamos esta constante para que sea de tipo int y comparar con e.getCode()
	private final static int ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE = 5;
   
    public void ejbCreate()
    {
    }

    public void ejbActivate()
    {
    }

    public void ejbPassivate()
    {
    }

    public void ejbRemove()
    {
    }

    public void setSessionContext(SessionContext ctx)
    {
        sessionContext = ctx;
    }

    private Boolean validaAccesos(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio) throws RemoteException, MareException {
		UtilidadesLog.info(" MONPlantillaCurso.validaAcceso(pais, marca, canal, acceso,  subgerencia, region, zona, seccion, territorio): Entrada");	
        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = Boolean.valueOf(true);
        //Valida que el usuario tenga acceso al Pais, Marca y Canal que se pasan
        //como parametro.
		UtilidadesLog.debug("**** Llamada a validaAcceso(pais= "+ pais+", marca="+marca+", canal= "+canal+", acceso="+acceso+", subgerencia="+subgerencia+", region="+region+", zona="+zona+", seccion="+seccion+", territorio="+territorio);		
		b = monValidacion.validarAccesos( pais, null, marca, canal, acceso, null, subgerencia, region, zona, seccion, territorio);
		UtilidadesLog.debug("**** Retorno validaAcceso: " + b.toString());
		if (!b.booleanValue()){	
			this.sessionContext.setRollbackOnly();
			UtilidadesLog.error("**** validaAcceso: ERROR_ASOCIACION_ESTRUCTURAL");	
			throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL) );
		}
		
		UtilidadesLog.info(" MONPlantillaCurso.validaAcceso(pais, marca, canal, acceso,  subgerencia, region, zona, seccion, territorio): Salida");	
		return b;

   }
	
    private Boolean validaAccesoVinculos(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio, boolean vinculos) throws RemoteException, MareException {
		   UtilidadesLog.info(" MONPlantillaCurso.validaAccesoVinculos(pais, marca, canal, acceso,  subgerencia, region, zona, seccion, territorio, boolean vinculos): Entrada");	
        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = Boolean.valueOf(true);
        //Valida que el usuario tenga acceso al Pais, Marca y Canal que se pasan
        //como parametro.
		UtilidadesLog.debug("**** Llamada a validaAcceso(pais= "+ pais+", marca="+marca+", canal= "+canal+", acceso="+acceso+", subgerencia="+subgerencia+", region="+region+", zona="+zona+", seccion="+seccion+", territorio="+territorio);		
		b = monValidacion.validarAccesos( pais, null, marca, canal, acceso, null, subgerencia, region, zona, seccion, territorio);
		UtilidadesLog.debug("**** Retorno validaAcceso: " + b.toString());
		if (!b.booleanValue()){	
			this.sessionContext.setRollbackOnly();
			UtilidadesLog.error("**** validaAccesoVinculos: ERROR_ASOCIACION_ESTRUCTURAL");	
			throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL) );
		}
		

		if(b.booleanValue() && vinculos){
			UtilidadesLog.debug("**** Llamada a validaVinculos(pais= "+ pais + ", marca= "+marca + ", canal= " + canal + ", acceso= "+ acceso+ ")");			
			b = monValidacion.validarVinculos( pais, null, marca, canal, acceso, null);
			UtilidadesLog.debug("**** Retorno validaAccesoVinculos: " + b.toString());
			if (!b.booleanValue()){
				UtilidadesLog.error("**** validaAccesoVinculos: ERROR_VINCULOS_INVALIDOS");	
				this.sessionContext.setRollbackOnly();			
				throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_VINCULOS_INVALIDOS) );
			}
		}
		UtilidadesLog.info(" MONPlantillaCurso.validaAccesoVinculos(pais, marca, canal, acceso,  subgerencia, region, zona, seccion, territorio, boolean vinculos): Salida");	
		return b;

   }
	
    /** 
     * Método para insertar la plantilla de un curso
     * @param dto DTOPlantillaCurso 
     * @return void    
	 * @exception MareException 
     * 
     * @ssaavedr Se modifica segun modelo: SICC-DMCO-EDU-GCC-008 - 29/11/2005
     * 
     * @CHANGELOG 
     * 2005.11.16 GMIOTTI DT Se reemplaza la Entidad StatusPlantillaCursos por la Entidadad 
     * PlantillaTiposCursosExigidos.
     */
    public void insertaPlantilla (DTOPlantillaCurso dto) throws MareException {
		    UtilidadesLog.info(" MONPlantillaCurso.insertaPlantilla(DTOPlantillaCurso): Entrada");	
        try {
			/* Comentado por incidencia 10577
	        if( this.validaAccesoVinculos( dto.getOidPais(), 
					obtenerParametro(dto,C_MARCA), 
					obtenerParametro(dto,C_CANAL), 
					obtenerParametro(dto,C_ACCESO), 
					obtenerParametro(dto,C_SUBGERENCIA), 
					obtenerParametro(dto,C_REGION), 
					obtenerParametro(dto,C_ZONA), 
					obtenerParametro(dto,C_SECCION), 
					obtenerParametro(dto,C_TERRITORIO), false).booleanValue() ){
					
				UtilidadesLog.info(" insertaPlantilla: Acceso concedido");
			}*/
			if( this.validaAccesos( dto.getOidPais(), 
					obtenerParametro(dto,C_MARCA), 
					obtenerParametro(dto,C_CANAL), 
					obtenerParametro(dto,C_ACCESO), 
					obtenerParametro(dto,C_SUBGERENCIA), 
					obtenerParametro(dto,C_REGION), 
					obtenerParametro(dto,C_ZONA), 
					obtenerParametro(dto,C_SECCION), 
					obtenerParametro(dto,C_TERRITORIO)).booleanValue() ){
					
				UtilidadesLog.debug(" insertaPlantilla: Acceso concedido");
			}

            // Obtenemos la interfaz local home de los entity que utilizamos
            CabeceraPlantillaCursosLocalHome cabeceraPlantillaCursosLocalHome = 
                                             new CabeceraPlantillaCursosLocalHome();
            Entidadi18nLocalHome entidadi18nLocalHome = 
                                             new Entidadi18nLocalHome();
            DetallePlantillaCursosLocalHome detallePlantillaCursosLocalHome = 
                                            new DetallePlantillaCursosLocalHome();                        
            PlantillaTiposCursosExigidosLocalHome plantillaTiposCursosExigidosLocalHome = 
            new PlantillaTiposCursosExigidosLocalHome();
            
            CabeceraPlantillaCursosLocal cabeceraPlantillaCursosLocal = null;
            Entidadi18nLocal entidadi18nLocal = null;
            DetallePlantillaCursosLocal detallePlantillaCursosLocal = null;
            
            //StatusPlantillaCursosLocal statusPlantillaCursosLocal = null;
            PlantillaTiposCursosExigidosLocal plantillaTiposCursosExigidosLocal = null;
            
            //a.- EJB CabeceraPlantillaCursos: se crea con la información de dto 
            //(codigo y nombre) (no con dto.oid ya que este oid se genera automáticamente). 

            // Se crea en la tabla CabeceraPlantillasCursos para obtener el oid y le almacenamos
            cabeceraPlantillaCursosLocal = cabeceraPlantillaCursosLocalHome.create();
			dto.setOid(cabeceraPlantillaCursosLocal.getOid());
            
            //b.- EJB DetallePlantillaCursos: Para cada elemento de dto.detalles se 
            //crea un nuevo registro con toda la información dto.detalles.* y la 
            //relación con la plantilla (oid generado en a) 
            //y con el parámetro (entidad Parametros) que está en dto.detalles[i].oidParametro
            ArrayList detallesList = dto.getDetalles();
            Iterator iterator = detallesList.iterator();
            while (iterator.hasNext()) {
            
                DTODetallePlantillaCurso dtoDetallePlantillaCurso = 
                (DTODetallePlantillaCurso)iterator.next();
                
                UtilidadesLog.debug("SCS, inserto en detalle, con: " + 
                cabeceraPlantillaCursosLocal.getOid() + " - " +
                dtoDetallePlantillaCurso.getVisible() + " - " +
                dtoDetallePlantillaCurso.getModificable() + " - " +
                dtoDetallePlantillaCurso.getObligatorio() + " - " +
                dtoDetallePlantillaCurso.getParametro().getOid() + " - " +
                dtoDetallePlantillaCurso.getValor());
                
                detallePlantillaCursosLocal = detallePlantillaCursosLocalHome.create(
                cabeceraPlantillaCursosLocal.getOid(),
                dtoDetallePlantillaCurso.getVisible(),
                dtoDetallePlantillaCurso.getModificable(),
                dtoDetallePlantillaCurso.getObligatorio(),
                dtoDetallePlantillaCurso.getParametro().getOid(),
                dtoDetallePlantillaCurso.getValor());
                
                //c.- EJB StatusPlantillaCursos: si algún dto.detalles[i].cursosRequisito es una lista no vacía 
                //con cada elemento de esa lista se crea un registro relacionado con el oid de curso en 
                //la tabla de status. También habrá que incluir la relación con el 
                //detalle la plantilla (oid generado en b) 
                
                Long[] cursosRequisito = dtoDetallePlantillaCurso.getCursosRequisito();
                
                if (cursosRequisito!=null)
                {
                    UtilidadesLog.debug("SCS, cursosRequisito mide: " + 
                    cursosRequisito.length);
                } else {               
                    UtilidadesLog.debug("SCS, cursosRequisito es nulo");
                }
                if(cursosRequisito != null && cursosRequisito.length > 0) {
                    
                    //BelcorpService bs = getBelcorpService();
                    for (int j = 0; j <cursosRequisito.length ; j++) {
                        UtilidadesLog.debug("SCS, a punto de create en Plantilla Tipos Cursos Exigidos, con: " + detallePlantillaCursosLocal.getOid() + " - " + cursosRequisito[j]);
                        plantillaTiposCursosExigidosLocal = 
                        plantillaTiposCursosExigidosLocalHome.create(
                        detallePlantillaCursosLocal.getOid(),
                        cursosRequisito[j]);
                        
                        /*StringBuffer query = new StringBuffer();
                        
                        Long oid = SecuenciadorOID.obtenerSiguienteValor("EDU_ESPC_SEQ");
                
                        query.append(" INSERT INTO EDU_PLANT_TIPOS_CURSO_EXIGI (OID_ESTA,DPCU_OID_DETA_PLAN_CURS,MCUR_OID_CURS ");
                        query.append(" ) VALUES ( ");
                        query.append(oid + ", ");
                        query.append(detallePlantillaCursosLocal.getOid() + ", ");
                        query.append(cursosRequisito[j]);
                        query.append(" ) "); 
                        
                        UtilidadesLog.info("SCS, a punto de insertar en Plantilla Tipos Cursos Exigidos: " + query.toString());
                        
                        try {
                            bs.dbService.executeUpdate(query.toString());
                        } catch (Exception e) {
                            UtilidadesLog.error("insertaPlantilla: except.",e);
                            throw new MareException(e,
                                UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }*/
                    }   
                }
            } 
            
            //d.- Para cada DTO del vector dto.attriTraducible se debe hacer una llamada al 
            //método "create" del Entity Bean: "Entidadi18n". El oid es del registro de 
            //CabeceraPlantillaCursos afectado (paso a). 

            DTOI18nSICC[] dtoAttrTraducible = dto.getAttriTraducible();
            for (int i = 0; i <dtoAttrTraducible.length ; i++) {
                
                entidadi18nLocal = entidadi18nLocalHome.create(
                EDU_PLANT_CURSO_CABEC,
                new Long(1),
                dtoAttrTraducible[i].getOidIdioma(),
                dtoAttrTraducible[i].getValorI18n(), 
                cabeceraPlantillaCursosLocal.getOid());   
            }
            
        } catch (PersistenceException exception){
            sessionContext.setRollbackOnly();
			UtilidadesLog.error("insertaPlantilla: CreateException",exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } /* Comentado por incidencia 10577
		    catch (RemoteException exception){
            sessionContext.setRollbackOnly();
			UtilidadesLog.error("insertaPlantilla: RemoteException",exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			
		
		}*/ catch (MareException e){
			//Si viene una MareException porque no se ha validado accesos, la lanzo.
			//Es para que no entre en el catch de Exception y la encapsule más
			throw e;
		} catch (Exception exception){
            sessionContext.setRollbackOnly();		
			UtilidadesLog.error("insertaPlantilla: Exception",exception);
            throw new MareException(exception,
			UtilidadesError.armarCodigoError(this.obtenerErrorSql(exception,"insertar")));
        }
		UtilidadesLog.info(" MONPlantillaCurso.insertaPlantilla(DTOPlantillaCurso): Salida");	
    }
    /** 
     * Método para eliminar la plantilla de un curso
     * @param dto DTOOIDs
     * @return void    
	 * @exception MareException 
     * 
     * @ssaavedr Se modifica segun modelo: SICC-DMCO-EDU-GCC-008 - 29/11/2005
     * 
     * @CHANGELOG 
     * 2005.11.16 GMIOTTI DT Se incorpora la eliminacion de las Entidades DetallePlantillaCursos 
     * y PlantillaTiposCursosExigidos
     */
    public void eliminaPlantilla (DTOOIDs dto) throws MareException{
        UtilidadesLog.info(" MONPlantillaCurso.eliminaPlantilla(DTOOIDs): Entrada");	

        //Validar acceso según lo especificado en incidencia 2296
        
        int i,j;
        MatrizCursosLocalHome matrizCursosLocalHome = null;
        try{
            matrizCursosLocalHome = this.getMatrizCursosLocalHome();
        } catch (NamingException nex) {
            UtilidadesLog.error("NamingException: ", nex);
            throw new MareException(nex, 
            UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        //Por cada oid dto.oid[i] recibido por parámetro se hace:
        Long oids[] = dto.getOids();
        for ( i=0; i< oids.length ; i++) {
        
            Long oid = oids[i];
            //1.- Para cada elemento del siguiente vector:
            //{'Marca','Canal','Acceso Información','Subgerencia de Ventas',
            //'Región','Zona','Sección','Territorio'}
            String parametros[] = 
            {C_MARCA,C_CANAL,C_ACCESO,C_SUBGERENCIA,C_REGION,C_ZONA,C_SECCION,C_TERRITORIO};
            Long valores[] = new Long[parametros.length];
            
            for( j=0; j< parametros.length ; j++) {
                
                //Se hace la siguiente query:
                StringBuffer consulta = new StringBuffer();
                consulta.append(" SELECT edu_plant_curso_detal.val_deta ");
                consulta.append(" FROM edu_plant_curso_cabec, ");
                consulta.append(" edu_plant_curso_detal, edu_param ");
                consulta.append(" WHERE ((edu_plant_curso_cabec.oid_cabe = edu_plant_curso_detal.cplc_oid_cabe) ");
                consulta.append(" AND (edu_param.oid_para = edu_plant_curso_detal.paed_oid_para) ");
                consulta.append(" AND (edu_plant_curso_cabec.oid_cabe = ?) ");
                consulta.append(" AND (edu_param.val_nomb_para = ?))");
                
                BelcorpService bs;
                RecordSet resultado;
                Vector vParam = new Vector();
                vParam.add(oid);
                vParam.add(parametros[j]);
                try {
                     bs = BelcorpService.getInstance ();
                } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
                    UtilidadesLog.error(
                    "eliminaPlantilla: MareMiiServiceNotFoundException",
                    serviceNotFoundException);
                    throw new MareException(serviceNotFoundException,
                    UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                }
                
                try {
                    resultado = bs.dbService.executePreparedQuery(consulta.toString(),vParam);
                } catch (Exception exception) {
                    UtilidadesLog.error("eliminaPlantilla: Exception",exception);
                    throw new MareException(exception,
                    UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                }
                //Almacenamos el valor del parametro
                if (!resultado.esVacio())
                     valores[j] = new Long((String)resultado.getRow(0).firstElement());
                else
                     valores[j] = null;
            }
            //Inicializamos el contador de valores
            j=0;
            
            //Se llama a MONValidacion.validarAcceso(pais del dto,null,valorMarca,
            //valorCanal,valorAcceso,null,...,valorTerritorio) 			
            //a.- Si devuelve true se elimina el registro de CabeceraPlantillaCursos 
            //identificado por el oid.
            //b.- Si devuelve false sigue con el siguiente oid de la lista.
            try {   
                    /*Comentado por incidencia 10577
                    if(this.validaAccesoVinculos(dto.getOidPais(),  
                    valores[j++], 
                    valores[j++], 
                    valores[j++], 
                    valores[j++], 
                    valores[j++], 
                    valores[j++], 
                    valores[j++], 
                    valores[j++], false).booleanValue() ) {
                    
                    UtilidadesLog.info("**** eliminarPlantilla: Acceso concedido");
                    }*/
                    if(this.validaAccesos(dto.getOidPais(),  
                        valores[j++], 
                        valores[j++], 
                        valores[j++], 
                        valores[j++], 
                        valores[j++], 
                        valores[j++], 
                        valores[j++], 
                        valores[j++]).booleanValue() ) {
                    
                            UtilidadesLog.debug("**** eliminarPlantilla: Acceso concedido");
                    }
                    
                    // @ssaavedr, textual DECU
                    //Antes de eliminar Plantillas el Sistema accede a la entidad “Matriz de Cursos” y 
                    //comprueba si la plantilla tiene cursos asignados. En caso afirmativo no se 
                    //permite eliminar la plantilla. 
                    
                    if (!this.plantillaConCursosAsig(oid, matrizCursosLocalHome)) {
                    
                        //Eliminamos el registro con el oid 	
                        //Obtenemos la interfaz local home de los entity que utilizamos
                        CabeceraPlantillaCursosLocalHome 
                        cabeceraPlantillaCursosLocalHome = new CabeceraPlantillaCursosLocalHome();
                        CabeceraPlantillaCursosLocal cabeceraPlantillaCursosLocal = null;
                        //Buscamos el seleccionado
                        cabeceraPlantillaCursosLocal = 
                        cabeceraPlantillaCursosLocalHome.findByPrimaryKey(oid);
                        
                        // Si existe el oid le eliminamos 
                        if(cabeceraPlantillaCursosLocal != null) {
                            cabeceraPlantillaCursosLocalHome.remove(cabeceraPlantillaCursosLocal);
                        }
                        
                        //Eliminamos las traducciones
                        eliminaTraducciones(oid);	
                        
                        //@ssaavedr - inc:21902 / 22062
                        //al eliminar la cabecera de plantilla, automaticamente se eliminan el/los registros
                        //de: detalle y de plantilla tipos cursos exigidos.
                        
                    }        
                
            } catch (NoResultException fe) {	        	
                //no se encontro gen-006
                sessionContext.setRollbackOnly();
                UtilidadesLog.error("eliminarPlantilla: FinderException",fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_ELIMINAR_NO_EXISTE));
            } catch (PersistenceException exception){
                sessionContext.setRollbackOnly();			
                UtilidadesLog.error("eliminarPlantilla: RemoteException",exception);
                throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            } catch (MareException e){
                //Si viene una MareException porque no se ha validado accesos, la lanzo.
                //Es para que no entre en el catch de Exception y la encapsule más
                throw e;			
            } catch (Exception exception){
                sessionContext.setRollbackOnly();
                UtilidadesLog.error("eliminarPlantilla: Exception",exception);
                throw new MareException(exception,UtilidadesError.armarCodigoError(this.obtenerErrorSql(exception,"eliminar")));
            }        
        
        }// fin for

		UtilidadesLog.info(" MONPlantillaCurso.eliminaPlantilla(DTOOIDs): Salida");	
    }
    
    /** 
     * Método para modificar la plantilla de un curso
     * @param dto DTOPlantillaCurso 
     * @return void    
	 * @exception MareException 
     * 
     * @ssaavedr Se modifica segun modelo: SICC-DMCO-EDU-GCC-008 - 29/11/2005
     * 
     * @CHANGELOG 
     * 2005.11.16 GMIOTTI DT Se reemplaza la Entidad StatusPlantillaCursos por la Entidadad 
     * PlantillaTiposCursosExigidos
     */
    public void modificaPlantilla (DTOPlantillaCurso dto) throws MareException, RemoteException {
		UtilidadesLog.info(" MONPlantillaCurso.modificaPlantilla(DTOPlantillaCurso): Entrada");	
        try {
        
             CabeceraPlantillaCursosLocalHome cpcLH = new CabeceraPlantillaCursosLocalHome();
             
             try {
                 cpcLH.findByPrimaryKey(dto.getOid());
             } catch (NoResultException exception){
                 sessionContext.setRollbackOnly();
			     UtilidadesLog.error("modificarPlantilla: FinderException",exception);
                 throw new MareException(exception, UtilidadesError.armarCodigoError(
                 CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
             }    

			/*
			 * public Boolean validarAccesos(Long pais, Long *sociedad, Long marca, Long canal, 
			 * Long acaceso, Long *subAcceso, Long subgerencia, Long region, Long zona,
			 * Long seccion, Long territorio) 
			 */
		/* Comentado por incidencia 10577
			if(this.validaAccesoVinculos( dto.getOidPais(), 
					obtenerParametro(dto,C_MARCA), 
					obtenerParametro(dto,C_CANAL), 
					obtenerParametro(dto,C_ACCESO), 
					obtenerParametro(dto,C_SUBGERENCIA), 
					obtenerParametro(dto,C_REGION), 
					obtenerParametro(dto,C_ZONA), 
					obtenerParametro(dto,C_SECCION), 
					obtenerParametro(dto,C_TERRITORIO), false).booleanValue() ) {

				UtilidadesLog.info("**** modificaPlantilla: Acceso concedido");
			}*/
            
            
			if( this.validaAccesos( dto.getOidPais(), 
					obtenerParametro(dto,C_MARCA), 
					obtenerParametro(dto,C_CANAL), 
					obtenerParametro(dto,C_ACCESO), 
					obtenerParametro(dto,C_SUBGERENCIA), 
					obtenerParametro(dto,C_REGION), 
					obtenerParametro(dto,C_ZONA), 
					obtenerParametro(dto,C_SECCION), 
					obtenerParametro(dto,C_TERRITORIO)).booleanValue() ){
					
				UtilidadesLog.debug(" modifica: Acceso concedido");
			}			
			
            // Obtenemos la interfaz local home de los entity que utilizamos
            Entidadi18nLocalHome entidadi18nLocalHome = new Entidadi18nLocalHome();
            DetallePlantillaCursosLocalHome detallePlantillaCursosLocalHome = 
            new DetallePlantillaCursosLocalHome();
            
            //StatusPlantillaCursosLocalHome statusPlantillaCursosLocalHome = this.getStatusEntityLocalHome();
            PlantillaTiposCursosExigidosLocalHome plantillaTiposCursosExigidosLocalHome = 
            new PlantillaTiposCursosExigidosLocalHome();
            
            Entidadi18nLocal entidadi18nLocal = null;
            DetallePlantillaCursosLocal detallePlantillaCursosLocal = null;
            
            //StatusPlantillaCursosLocal statusPlantillaCursosLocal = null;
            PlantillaTiposCursosExigidosLocal plantillaTiposCursosExigidosLocal = null;
            
            //a.- EJB CabeceraPlantillaCursos: se modifica con la información de dto (codigo y nombre) 
            //b.- Haciendo uso de los EJB entity DetallePlantillaCursos se eliminan todos los registros de
            //DetallePlantillaCursos que estén relacionados con la CabeceraPlantillaCursos identificada en a.
            //Es decir, no se elimina la cabecera, la cabecera se modifica y se eliminan todos los detalles
            //relacionados con la cabecera haciendo uso del EJB entity DetallePlantillaCurso.
            
            // Utilizando DBService obtenemos todos los oids de los detalles relacionados con la cabecera
            Collection myColectionDetalles = 
            detallePlantillaCursosLocalHome.findByPlantilla(dto.getOid());
            Iterator myIteratorDetalles=myColectionDetalles.iterator();
            while(myIteratorDetalles.hasNext()){
                    detallePlantillaCursosLocal=(DetallePlantillaCursosLocal)
                    myIteratorDetalles.next();					
                    detallePlantillaCursosLocalHome.remove(detallePlantillaCursosLocal);			
            }            
            //c.- EJB DetallePlantillaCursos: Para cada elemento de dto.detalles se crea un nuevo 
            //registro con toda la información dto.detalles.* y la relación con la plantilla 
            //(oid generado en a) y con el parámetro (entidad Parametros) que está en dto.detalles[i].oidParametro
            ArrayList detallesList = dto.getDetalles();
            Iterator iterator = detallesList.iterator();
            while (iterator.hasNext()) {           
                DTODetallePlantillaCurso dtoDetallePlantillaCurso = 
                (DTODetallePlantillaCurso)iterator.next();
				detallePlantillaCursosLocal = detallePlantillaCursosLocalHome.create(
                dto.getOid(),
                dtoDetallePlantillaCurso.getVisible(),
                dtoDetallePlantillaCurso.getModificable(),
                dtoDetallePlantillaCurso.getObligatorio(),
                dtoDetallePlantillaCurso.getParametro().getOid(),
                dtoDetallePlantillaCurso.getValor());
            
                //d.- EJB StatusPlantillaCursos: si algún dto.detalles[i].cursosRequisito es una lista no vacía 
                //con cada elemento de esa lista se crea un registro relacionado con el oid de curso en 
                //la tabla de status. También habrá que incluir la relación con el 
                //detalle la plantilla (oid generado en b) 
                Long[] cursosRequisito = dtoDetallePlantillaCurso.getCursosRequisito();
                if(cursosRequisito != null && cursosRequisito.length > 0) {
                    UtilidadesLog.info(" cursosRequisito.length " + cursosRequisito.length);	
                    for (int j = 0; j <cursosRequisito.length ; j++) {
						plantillaTiposCursosExigidosLocal = 
                        plantillaTiposCursosExigidosLocalHome.create(
                        detallePlantillaCursosLocal.getOid(),
                        cursosRequisito[j]);
                    }   
                }
            } 
            
            //e.- Para cada DTO del vector dto.attriTraducible se debe hacer una llamada a los métodos "find..."
            //y "set..."del Entity Bean: "Entidadi18n". El oid es del registro de MatrizCursos afectado (paso a).
            //En la Entidadi18n no se borra nada, sólo se actualiza.

			// Modificado por fmunoz - Se eliminan todas las traducciones y se insertan de nuevo
			this.eliminaTraducciones(dto.getOid());
			DTOI18nSICC[] dtoAttrTraducible = dto.getAttriTraducible();
            for (int i = 0; i <dtoAttrTraducible.length ; i++) {
                
                entidadi18nLocal = entidadi18nLocalHome.create(
                EDU_PLANT_CURSO_CABEC,
                new Long(1),
                dtoAttrTraducible[i].getOidIdioma(),
                dtoAttrTraducible[i].getValorI18n(), 
                dto.getOid());   
            }            
        }  catch (NoResultException exception){
            sessionContext.setRollbackOnly();
			UtilidadesLog.error("modificarPlantilla: FinderException",exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException exception){
            sessionContext.setRollbackOnly();
			UtilidadesLog.error("modificarPlantilla: RemoveException",exception);
			/*throw new MareException(exception,
            UtilidadesError.armarCodigoError(this.obtenerErrorSql(exception,"modificar")));*/
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_EDU,ErroresNegocio.EDU_1005));
            
		} catch (MareException e){
			//Si viene una MareException porque no se ha validado accesos, la lanzo.
			//Es para que no entre en el catch de Exception y la encapsule más
			throw e;
        } catch (Exception exception){
            sessionContext.setRollbackOnly();
			UtilidadesLog.error("modificarPlantilla: Exception",exception);
            throw new MareException(exception,
            UtilidadesError.armarCodigoError(this.obtenerErrorSql(exception,"modificar")));
            
        }
	UtilidadesLog.info(" MONPlantillaCurso.modificaPlantilla(DTOPlantillaCurso): Salida");	
    }
	/** 
     * Método para obtener las plantillas 
     * @param dto DTOPlantillaCurso 
     * @return DTOSalida Plantillas    
	 * @exception MareException 
     */
     public DTOSalida obtienePlantillas(DTOPlantillaCurso dto) throws MareException {
	   UtilidadesLog.info(" MONPlantillaCurso.obtienePlantillas(DTOPlantillaCurso): Entrada");	
	   BelcorpService bs;
       RecordSet resultado;
       try
       {
        //Filtrando por los elementos (sólo nombre y oid) no nulos que contiene el dto se 
        //hace una consulta a través de DBService de la entidad CabeceraPlantillaCursos 
        //devolviendo los registros (encapsulados en un DTOSalida) que cumplan la condición. 
        //Esta búsqueda es paginada, por tanto habra que tener en cuenta las siguientes consideraciones: 
        //1.- oid del registro encontrado -> dto.indicadorSituacion 
        //2.- ROWNUM <- dto.tamañoPagina 

			StringBuffer consulta = new StringBuffer();
			Vector parametros = new Vector();
        
			consulta.append("SELECT val_oid OID, val_oid, val_i18n FROM v_gen_i18n_sicc "); 
			//Comprobamos los valores no nulos para realizar la sql
        
			//Si el oid no es nulo 
			if ( dto.getOid() != null ) {
				//Si el oid no es nulo
				consulta.append("WHERE val_oid = ? AND attr_enti = ? "); 
				parametros.add(dto.getOid());
				parametros.add(EDU_PLANT_CURSO_CABEC);   
			}
			else {
				if ( dto.getNombre() != null ) {
					//Si el nombre no es nulo, cogemos el idioma
					consulta.append("WHERE idio_oid_idio = ? AND val_i18n like ? AND attr_enti = ? ");
					parametros.add(dto.getOidIdioma());
					parametros.add(dto.getNombre());
					parametros.add(EDU_PLANT_CURSO_CABEC);
				}
				else {
					//El nombre y el oid son nulos, obtengo todas las plantillas
					consulta.append("WHERE idio_oid_idio = ? AND attr_enti = ? ");
					parametros.add(dto.getOidIdioma());
					parametros.add(EDU_PLANT_CURSO_CABEC);
				}
            
			}
			//Construimos la consulta
			String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dto);
			// Realizamos la consulta	
				try {
					bs = BelcorpService.getInstance ();
				} catch (MareMiiServiceNotFoundException serviceNotFoundException) {
					UtilidadesLog.error("obtienePlantillas: MareMiiServiceNotFoundException",serviceNotFoundException);				
		            throw new MareException(serviceNotFoundException,
		                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
				}
    
				try {
					 resultado = bs.dbService.executePreparedQuery(sql,parametros);
				} catch (Exception exception) {
					UtilidadesLog.error("obtienePlantillas: Exception",exception);
					throw new MareException(exception,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
				}  
       
			if( resultado.esVacio() ) {
				throw new MareException("",
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
			}
		} catch (MareException e){
			//Si viene una MareException porque el resultado es vacío, la lanzo.
			//Es para que no entre en el catch de Exception y la encapsule más
			throw e;
		}catch (Exception exception){           
			UtilidadesLog.error("obtienePlantillas: Exception",exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
		UtilidadesLog.info(" MONPlantillaCurso.obtienePlantillas(DTOPlantillaCurso): Salida");	
       return new DTOSalida(resultado);
   }

    /** 
     * Método para obtener los detalles de una plantillade un curso
     * @param dto DTOOID 
     * @return DTOCargaCursos    
	 * @exception MareException 
     * 
     * @ssaavedr Se modifica segun modelo: SICC-DMCO-EDU-GCC-008 - 29/11/2005
     * 
     * @CHANGELOG 
     * 2005.11.16 GMIOTTI DT Se reemplaza la Entidad StatusPlantillaCursos por la Entidadad 
     * PlantillaTiposCursosExigidos
     */
   public DTOCargaCursos obtieneDetallesPlantilla (DTOOID dto) throws MareException {
       UtilidadesLog.info(" MONPlantillaCurso.obtieneDetallesPlantilla(DTOOID): Entrada");	
	   DTOCargaCursos dtoSalida = new DTOCargaCursos();
       try
       {

		   //El dto contiene el oid del registro CabeceraPlantillaCursos sobre el 
		   //que se desea buscar sus detalles, el proceso es el siguiente y se 
		   //realiza a través de DBService: 

		   //1.- Se obtiene el registro CabeceraPlantillaCursos que cumple el oid
		   //del dto y se instancia un DTOPlantillaCurso que llamaremos dtoP 
		   //rellenándose con esa información: oid y nombre. 
        
		   DTOPlantillaCurso dtoP = new DTOPlantillaCurso(); 
		   //Almacenamos el oid
		   dtoP.setOid(dto.getOid());
       
		   //Obtenemos el nombre de la tabla geni18n, mediante DBService
		   StringBuffer consulta = new StringBuffer();
		   consulta.append("SELECT val_i18n FROM v_gen_i18n_sicc WHERE val_oid = ? ");
           consulta.append(" AND idio_oid_idio = ? AND attr_enti = ? ");
 
			BelcorpService bs;        
			RecordSet resultadoNombre;
			RecordSet resultadoDetalles;
			Vector parametros = new Vector();
			parametros.add(dto.getOid());
			parametros.add(dto.getOidIdioma());
			parametros.add(EDU_PLANT_CURSO_CABEC);
			try {
				bs = BelcorpService.getInstance ();
			} catch (MareMiiServiceNotFoundException serviceNotFoundException) {
				UtilidadesLog.error("obtieneDetallesPlantilla: MareMiiServiceNotFoundException",serviceNotFoundException);
				throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
			}
    
			try {
				resultadoNombre = bs.dbService.executePreparedQuery(consulta.toString(),
                parametros);
			} catch (Exception exception) {
				UtilidadesLog.error("obtieneDetallesPlantilla: Exception",exception);
				throw new MareException(exception,UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
			}
			if(resultadoNombre.esVacio()){
				UtilidadesLog.debug("**** obtieneDetallesPlantilla: ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE");
				throw new MareException("",
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
			}
		   //Almacenamos el nombre,solo devuelve una fila,cojemos el primer elemento, que es el valor
		   dtoP.setNombre((String)resultadoNombre.getRow(0).firstElement());
       
		   //2.- Se obtienen todos los registros de DetallePlantillaCursos relacionados 
		   //con el oid de CabeceraPlantillaCursos y por cada registro devuelto se 
		   //añadirá una nueva instancia de DTODetallePlantillaCurso a la lista 
		   //dtoP.detalles (que en un principio está vacía). 
       
		   //Vaciamos la consulta y creamos la nueva
		   consulta.delete(0,consulta.length());
		   consulta.append("SELECT oid_deta_plan_curs,");
		   consulta.append("val_deta,ind_visi,ind_modi,ind_obli,paed_oid_para,");
		   consulta.append("val_nomb_para,val_tipo_para,val_nomb_tabl,val_tipo_dato ");
		   consulta.append("FROM edu_plant_curso_detal,edu_param "); 
		   consulta.append("WHERE paed_oid_para = oid_para AND cplc_oid_cabe = ? ");
		   consulta.append(" ORDER BY paed_oid_para ");
		   //Vaciamos los parametros e insertamos los nuevos
		   parametros.clear();
		   parametros.add(dto.getOid());
		   try {
				bs = BelcorpService.getInstance ();
			} catch (MareMiiServiceNotFoundException serviceNotFoundException) {
				UtilidadesLog.error("modificarPlantilla: MareMiiServiceNotFoundException",
                serviceNotFoundException);
				throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
			}
    
			try {
				resultadoDetalles = bs.dbService.executePreparedQuery(
                consulta.toString(),parametros);
                	UtilidadesLog.debug("La consulta es " + consulta.toString());
                  UtilidadesLog.debug("Los parametros son " + parametros.toString());
			} catch (Exception exception) {
				UtilidadesLog.error("modificarPlantilla: Exception",exception);
				throw new MareException(exception,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
			}
			//Creamos la lista de detalles
			ArrayList detalles = new ArrayList();
        
			//Recorremos los registros
			if( resultadoDetalles != null) {
				RecordSet resultadoCursos;
                int rowCount = resultadoDetalles.getRowCount();
				for (int i=0;i<rowCount;i++) {
					Vector vAux = resultadoDetalles.getRow(i);
          UtilidadesLog.debug("vaux en i =  " + i  + vAux.toString());
					//Para cada oid instanciamos un DTODetallePlantillaCurso y lo añadimos
					//a la lista
					DTODetallePlantillaCurso dtoDetalle = new DTODetallePlantillaCurso();
					//Recorremos todas las columnas para obtener los valores
					int j=0;
					dtoDetalle.setOid(new Long(((BigDecimal)vAux.elementAt(j++)).longValue()));
					dtoDetalle.setValor((String)vAux.elementAt(j++));
					Boolean visible = new Boolean("True");
					Boolean modificable = new Boolean("True");
					Boolean obligatorio = new Boolean("True");
					if ( ((BigDecimal)vAux.elementAt(j++)).intValue() == 0) {
						visible = new Boolean("False"); 
					}
					dtoDetalle.setVisible(visible);
					if ( ((BigDecimal)vAux.elementAt(j++)).intValue() == 0) {
						modificable = new Boolean("False"); 
					}
					dtoDetalle.setModificable(modificable);
					if ( ((BigDecimal)vAux.elementAt(j++)).intValue() == 0) {
						obligatorio = new Boolean("False"); 
					}    
					dtoDetalle.setObligatorio(obligatorio);
                
					//Obtenemos los valores del parametro para el detalle
					DTOParametro dtoParam = new DTOParametro();
					dtoParam.setOid(new Long(((BigDecimal)vAux.elementAt(j++)).longValue()));
					dtoParam.setNombre((String)vAux.elementAt(j++));
					dtoParam.setTipo(new Integer(((BigDecimal)vAux.elementAt(j++)).intValue()));
					dtoParam.setNombreTabla((String)vAux.elementAt(j++));
					dtoParam.setTipoDato((String)vAux.elementAt(j++));
                
					//Almacenamos el parametro en el dto detalle
					dtoDetalle.setParametro(dtoParam);
					UtilidadesLog.debug("**** obtieneDetallesPlantilla: Detalle -" + dtoDetalle.toString());
					UtilidadesLog.debug("**** obtieneDetallesPlantilla: Parametro - " + dtoParam.toString());
                
					/* 3.- Si algún registro de PlantillaTiposCursosExigidos está relacionado con DetallePlantillaCursos 
                     * se rellenará la lista de oids de tipos de curso (dtoP.detalle[i].cursosRequisitos) con los oids 
                     * de tipos de curso (relación PlantillaTiposCursosExigidos-TiposCurso) y de igual modo obtenemos 
                     * el nombre de cada tipo de curso (de TiposCurso) y se rellena dtoP.detalle[i].nombresCursosRequisito.
					*/
					//Vaciamos la consulta y creamos la nueva
					consulta.delete(0,consulta.length());
					UtilidadesLog.debug(" Busca tipos cursos exigidos ");
					consulta.append(" SELECT  TICU_OID_TIPO_CURS,val_i18n ");
					consulta.append(" FROM EDU_PLANT_TIPOS_CURSO_EXIGI, v_gen_i18n_sicc ");
					consulta.append(" WHERE DPCU_OID_DETA_PLAN_CURS = ? ");
					consulta.append(" AND TICU_OID_TIPO_CURS = val_oid ");
					consulta.append(" AND attr_enti = ? ");
					consulta.append(" AND idio_oid_idio = ? ");
					//Vaciamos los parametros e insertamos los nuevos
					parametros.clear();
					parametros.add(dtoDetalle.getOid());
					parametros.add(EDU_TIPO_CURSO);                
					parametros.add(dto.getOidIdioma());
					try {
						bs = BelcorpService.getInstance ();
					} catch (MareMiiServiceNotFoundException serviceNotFoundException) {
						UtilidadesLog.error("modificarPlantilla: MareMiiServiceNotFoundException",
                        serviceNotFoundException);
						throw new MareException(serviceNotFoundException,
                        UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
					}
            
					try {
						resultadoCursos = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
					} catch (Exception exception) {
						UtilidadesLog.error("modificarPlantilla: Exception",exception);
						throw new MareException(exception,UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
					}
        
					//Obtenemos los oids y los nombres de los cursos
					Long oidsTiposCursos[] = new Long[resultadoCursos.getRowCount()];
					String nombresTiposCursos[] = new String[resultadoCursos.getRowCount()];
                
					for (j=0;j<resultadoCursos.getRowCount();j++) {
                    
						Vector vCursos = resultadoCursos.getRow(j);
						int k=0;
						//Almacenamos los valores en los dos arrays
						oidsTiposCursos[j]= new Long(((BigDecimal)vCursos.elementAt(k++)).longValue());
						nombresTiposCursos[j]=(String)vCursos.elementAt(k++);
					}
                    UtilidadesLog.debug("oidsTiposCursos " + oidsTiposCursos.toString());
                    UtilidadesLog.debug("nombresTiposCursos " + nombresTiposCursos.toString());
                
					//Almacenamos los arrays en el dto detalles
					dtoDetalle.setCursosRequisito(oidsTiposCursos);
					dtoDetalle.setNombresCursoRequisito(nombresTiposCursos);
                
					//Almacenamos el detalle en el arraylis
					detalles.add(dtoDetalle);
                
				}//Fin FOR lista de detalles 
			}//Fin IF resultado!=null
           
			//Almacenamos la lista de detalles en el dto Plantilla
		   dtoP.setDetalles(detalles);     
       
		   //Obtenemos los valores de los atributos internacionalizables para
		   //el la plantilla de cursos (fmunoz)
		   //Vaciamos la consulta y creamos la nueva
		   consulta.delete(0,consulta.length());
		   consulta.append("SELECT val_i18n,idio_oid_idio,oid_i18n FROM v_gen_i18n_sicc ");
           consulta.append(" WHERE val_oid = ? AND attr_enti = ? ");
		   //Vaciamos los parametros e insertamos los nuevos
		   parametros.clear();
		   parametros.add(dto.getOid());
		   parametros.add(EDU_PLANT_CURSO_CABEC);
		   RecordSet resultadoI18n = null;
			try {
				bs = BelcorpService.getInstance ();
			} catch (MareMiiServiceNotFoundException serviceNotFoundException) {
				UtilidadesLog.error("modificarPlantilla: MareMiiServiceNotFoundException",
                serviceNotFoundException);
				throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
			}
    
			try {
				resultadoI18n = bs.dbService.executePreparedQuery(
                consulta.toString(),parametros);
			} catch (Exception exception) {
				UtilidadesLog.error("modificarPlantilla: Exception",exception);
				throw new MareException(exception,UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
			}
        
		   //Creamos el array de atributos traducibles de la plantilla 
		   DTOI18nSICC dtoI18n[] = null;
       
		   //Recorremos los registros y almacenamos los valores
		   if (resultadoI18n != null) {
				dtoI18n = new DTOI18nSICC[resultadoI18n.getRowCount()];
				for (int j=0;j<resultadoI18n.getRowCount();j++) {
                    
					Vector vAtributos = resultadoI18n.getRow(j);
					int k=0;
					dtoI18n[j] = new DTOI18nSICC();
					//Almacenamos los valores en los dos arrays
					dtoI18n[j].setValorI18n((String)vAtributos.elementAt(k++));
					dtoI18n[j].setOidIdioma(new Long(((BigDecimal)vAtributos.elementAt(k++)).longValue()));
					dtoI18n[j].setOidAtriuto(new Long(((BigDecimal)vAtributos.elementAt(k++)).longValue()));
				}
		   }
       
		   //Almacenamos el array en la plantilla de cursos
		   dtoP.setAttriTraducible(dtoI18n);
       
		   //4.- Se instancia un objeto DTOCargaCursos que llamaremos dtoSalida de tal 
		   //modo que tan sólo rellenamos 2 atributos: 
		   //- parametros <- (MONUtilidadesBD.obtieneParametros(null)).resultado 
		   //- plantilla <- dtoP 
		   //5.- Se devuelve dtoSalida. 

			dtoSalida.setPlantilla(dtoP);
			

			DTODruidaBusqueda dtoB = new DTODruidaBusqueda();
			dtoB.setOidPais(dto.getOidPais());
			dtoB.setOidIdioma(dto.getOidIdioma());
			obtieneRecordSets(dtoSalida,dtoB);

			MONUtilidadesBD monUtilidadesBD= this.getMONUtilidadesBD();

			dtoSalida.setOidPais(dto.getOidPais());
			dtoSalida.setOidIdioma(dto.getOidIdioma());
			//6. Obtiene dependientes
      UtilidadesLog.debug("dto salida antes de dependientes es - " + dtoSalida.toString());
			DTODependientesCarga dependientes = monUtilidadesBD.obtieneDependientes(dtoSalida);
			UtilidadesLog.debug("**** obtieneDetallesPlantilla: Dependientes -" + 
            dependientes.toString());
			dtoSalida.setDependientes(dependientes);

		   if( resultadoDetalles.esVacio() ) {
				UtilidadesLog.error(
                "****Error : obtieneDetallesPlantilla: ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE");
				throw new MareException("",
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		   }
	   } catch (MareException e){
			//Si viene una MareException porque el resultado es vacío, la lanzo.
			//Es para que no entre en el catch de Exception y la encapsule más
			throw e;	   
       }catch (Exception exception){
			UtilidadesLog.error("obtieneDetallesPlantilla: Exception",exception);
            sessionContext.setRollbackOnly();
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
   	   UtilidadesLog.info(" MONPlantillaCurso.obtieneDetallesPlantilla(DTOOID): Salida");	
       return dtoSalida;
   }
    /** 
     * Método para realizar la carga de cursos
     * @param dto DTOBelcorp 
     * @return DTOCargaCursos    
	 * @exception MareException 
     */
    public DTOCargaCursos cargaPantalla (DTOBelcorp dto) throws MareException {
		UtilidadesLog.info(" MONPlantillaCurso.cargaPantalla(DTOBelcorp): Entrada");	
	    DTOCargaCursos dtoS = new DTOCargaCursos();
	    try{
		
			//Obtiene toda la información para cargar una nueva plantilla todas 
			//los accesos a base de datos se hacen a través de DBService: 

			//1.- Instancia un objeto DTODruidaBusqueda que llamaremos dtoB y se 
			//rellenan los que hereda de DTOBelcorp con el contenido de dto. 
			DTODruidaBusqueda dtoB = new DTODruidaBusqueda();
			dtoB.setOidPais(dto.getOidPais());
			dtoB.setOidIdioma(dto.getOidIdioma());
        
			//2.- Instancia un objeto DTOCargaCursos que llamaremos dtoS. Y se rellena
			//de la siguiente manera: 
			//- Para todos los atributos x del DTOCargaCursos que sean de tipo RecordSet: 
			//dtoS.x <- (MONUtilidadesBD.obtieneX(dtoB)).resultado 
			obtieneRecordSets(dtoS, dtoB);
		} catch (MareException e){
			//Si viene una MareException porque el resultado es vacío, la lanzo.
			//Es para que no entre en el catch de Exception y la encapsule más
			throw e;        
		} catch(Exception exception){
			UtilidadesLog.error("cargaPantalla: Exception",exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
		UtilidadesLog.info(" MONPlantillaCurso.cargaPantalla(DTOBelcorp): Salida");	
		return dtoS;
    } 
    /** 
     * Método para copiar una plantilla
     * @param dto DTOOIDs 
     * @return DTOOID   
	 * @exception MareException 
     */
    public DTOOID copiaPlantilla (DTOOIDs dto) throws MareException {
		UtilidadesLog.info(" MONPlantillaCurso.copiaPlantilla(DTOOIDs): Entrada");	
		DTOOID oidCopia = null;
        try {
        //Cada oid de la lista incluída en dto.oids identifica a una plantilla 
        //(un registro de CabeceraPlantillaCursos) de este modo lo que se hace es 
        //copiar toda la información relacionada con ese registro. El proceso es el siguiente para cada oid: 
        //1.- El oid identifica la CabeceraPlantillaCursos que se desea copiar, lo llamaremos plantillaOrigen. 
        //2.- Se inserta un nuevo registro en CabeceraPlantillaCursos con el oid generado automáticamente y ese oid lo llamamos plantillaCopia. 
        //3.- En la tabla de internacionalización GEN_I18N_SICC se inserta una copia de los registros que apuntaban a CabeceraPlantillaCursos con el oid plantillaOrigen para un oid plantillaCopia. 
        //4.- Se copian exactamente todos los registros de DetallePlantillaCursos que apuntaban a plantillaOrigen (detallesOrigen) y ahora los nuevos registros insertados (detallesCopia) apuntan a plantillaCopia. 
        //5.- Se copian exactamente todos los registros de StatusPlantillaCursos que apuntaban a cualquier registro detallesOrigen[i] y ahora los nuevos registros insertados apuntan a detallesCopia[i]. 

        //La documentacion anterior es la que aparece en el documento tecnico, esta es equivalente
        //al proceso abajo implementado (fmunoz)

        //Obtenemos la lista de los oids 
        Long oids[] = dto.getOids();

		//En este método no se valida accesos porque ya lo hace en insertar, al cual se le llama 
        
        for ( int i=0; i<oids.length; i++) {
            
            //Obtenemos la plantilla con todos sus detalles 
            DTOOID oid = new DTOOID();
			//Almacenamos el oid
            oid.setOid(oids[i]);
			//Almacenamos el idioma y el pais
			oid.setOidIdioma(dto.getOidIdioma());
			oid.setOidPais(dto.getOidPais());
			
            DTOCargaCursos dtoCargaCursos = obtieneDetallesPlantilla(oid);            
            //Obtenemos la plantilla
            DTOPlantillaCurso plantillaOrigen = dtoCargaCursos.getPlantilla();
            UtilidadesLog.debug("**** copiaPlantilla: plantillaOrigen :"+plantillaOrigen.toString());
            //Insertamos una nueva plantilla, con todos los valores de plantillaOrigen
            insertaPlantilla(plantillaOrigen);

			//Retornamos el oid de la copia creada
			oidCopia = new DTOOID();
			oidCopia.setOid(plantillaOrigen.getOid());
        }  

		} catch (MareException e){
			//Si viene una MareException porque no se ha validado accesos, la lanzo.
			//Es para que no entre en el catch de Exception y la encapsule más
			throw e;
        } catch (Exception exception){
			UtilidadesLog.error("copiaPlantilla: Exception",exception);
            sessionContext.setRollbackOnly();
            throw new MareException(exception,UtilidadesError.armarCodigoError(this.obtenerErrorSql(exception,"insertar")));
        }	
		UtilidadesLog.info(" MONPlantillaCurso.copiaPlantilla(DTOOIDs): Salida");	
		return oidCopia;
    }
        
    
    private MONUtilidadesBD getMONUtilidadesBD() throws MareException{
		UtilidadesLog.info(" MONPlantillaCurso.getMONUtilidadesBD(): Entrada");	
        // Se obtiene el interfaz home
        MONUtilidadesBDHome home = (MONUtilidadesBDHome)UtilidadesEJB.getHome(
            "MONUtilidadesBD", MONUtilidadesBDHome.class);

        // Se obtiene el interfaz remoto
        MONUtilidadesBD ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("getMONUtilidadesBD: Exception"+e.getMessage());	
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
		UtilidadesLog.info(" MONPlantillaCurso.getMONUtilidadesBD(): Salida");	
        // Se devuelve el interfaz remoto
        return ejb;
    }

	// para obtener el mon de validaciones
    private MONValidacion getMONValidacion() throws MareException {
		UtilidadesLog.info(" MONPlantillaCurso.getMONValidacion(): Entrada");	
        // Se obtiene el interfaz home
        MONValidacionHome home = (MONValidacionHome)UtilidadesEJB.getHome(
            "MONValidacion", MONValidacionHome.class);
            
        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("getMONValidacion: Exception"+e.getMessage());	
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info(" MONPlantillaCurso.getMONValidacion(): Salida");	
        return ejb;
	}

	private Long obtenerParametro (DTOPlantillaCurso dto, String oidParametro) throws MareException {
		UtilidadesLog.info(" MONPlantillaCurso.obtenerParametro(DTOPlantillaCurso, oidParametro): Entrada");	
		//Resultado		
		Long resultado = null;		
		//Oid del parametro que buscamos
		Long oidParam = new Long(oidParametro);
		//Obtenemos la lista de detalles del dto
		ArrayList detallesList = dto.getDetalles();
        Iterator iterator = detallesList.iterator();
        while (iterator.hasNext()) {
           
                DTODetallePlantillaCurso dtoDetallePlantillaCurso = (DTODetallePlantillaCurso)iterator.next();
				//Obtenemos el parametro del detalle
				DTOParametro param = dtoDetallePlantillaCurso.getParametro();
				if( oidParam.longValue() == param.getOid().longValue()) {
					//Obtenemos el valor del oid deseado
					if (dtoDetallePlantillaCurso.getValor() != null && !dtoDetallePlantillaCurso.getValor().equals("")) {
						UtilidadesLog.debug("**** obtenerParametro: Nombre-Valor : "+param.getNombre()+"-"+dtoDetallePlantillaCurso.getValor());
						resultado = new Long(dtoDetallePlantillaCurso.getValor());
					}
				}
			}
		UtilidadesLog.info(" MONPlantillaCurso.obtenerParametro(DTOPlantillaCurso, oidParametro): Salida");	
		return resultado;
	}

	/** 
     * Método para eliminar las atributos traducibles de una plantilla
     * @param oid Long
     * @return void    
	 * @exception MareException 
     */
    private void eliminaTraducciones (Long oid) throws MareException {
		   UtilidadesLog.info(" MONPlantillaCurso.eliminaTraducciones(oid): Entrada");	
        try {
				Collection myCollectionI18n=null;
				//Eliminamos el registro con el oid 	
				//Obtenemos la interfaz local home de los entity que utilizamos
				Entidadi18nLocalHome  entidadi18nLocalHome = new Entidadi18nLocalHome();
				Entidadi18nLocal entidadi18nLocal = null;
				//Buscamos el seleccionado				
				myCollectionI18n = entidadi18nLocalHome.findByEntPK(EDU_PLANT_CURSO_CABEC,oid);
				Iterator myIteratorE18=myCollectionI18n.iterator();
				while(myIteratorE18.hasNext()){
					entidadi18nLocal=(Entidadi18nLocal)myIteratorE18.next();					
					entidadi18nLocalHome.remove(entidadi18nLocal);								
				}                  
				// Si existe el oid le eliminamos 				
		} catch (NoResultException fe) {
				UtilidadesLog.error("eliminaTraducciones: FinderException: " ,fe);			
                //no se encontro gen-006
                sessionContext.setRollbackOnly();
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_ELIMINAR_NO_EXISTE));		
		} catch (PersistenceException exception){
            sessionContext.setRollbackOnly();
			UtilidadesLog.error("eliminaTraducciones: RemoveException",exception);	
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        } catch (Exception exception){
            sessionContext.setRollbackOnly();
			UtilidadesLog.error("eliminaTraducciones: Exception",exception);	
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
		UtilidadesLog.info(" MONPlantillaCurso.eliminaTraducciones(oid): Salida");	
    }

	
	
	private String obtenerErrorSql(Exception exception,String accion){
			UtilidadesLog.info(" MONPlantillaCurso.obtenerErrorSql(exception, accion): Entrada");	
			String codigoDevolver=CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.debug("**** obtenerErrorSql, Accion : "+accion);
			SQLException mySqlException=null;
			if(exception instanceof EJBException){
				EJBException ejbException=(EJBException)exception;
				mySqlException=(SQLException)ejbException.getCausedByException();
			}else if(exception instanceof SQLException){
				mySqlException=(SQLException)exception;	
			}
						
			if (mySqlException!=null){
				
				int codigoMensaje=mySqlException.getErrorCode();
				UtilidadesLog.debug("**** obtenerErrorSql, Codigo SQL de la excepcion: "+codigoMensaje);
				if(codigoMensaje==2291){	
					if(accion.equals("insertar")){
						codigoDevolver=CodigosError.ERROR_INTEGRIDAD_INSERCION;
					}else{
						codigoDevolver=CodigosError.ERROR_INTEGRIDAD_ACTUALIZAR;
					}
				}else if(codigoMensaje==2292){ //registro hijo encontrado al borrar
					if(accion.equals("insertar")){
						codigoDevolver=CodigosError.ERROR_INTEGRIDAD_INSERCION;
					}else if(accion.equals("eliminar")){
						codigoDevolver=CodigosError.ERROR_DE_BORRADO_DE_DATOS;
					}else{
						codigoDevolver=CodigosError.ERROR_INTEGRIDAD_ACTUALIZAR;
					}
				}
					
			}
			UtilidadesLog.debug("**** obtenerErrorSql, Codigo Mare Devuelto: "+codigoDevolver);
			UtilidadesLog.info(" MONPlantillaCurso.obtenerErrorSql(exception, accion): Salida");	
			return codigoDevolver;
	}

	private void obtieneRecordSets(DTOCargaCursos dtoS, DTODruidaBusqueda dtoB) throws Exception {
		UtilidadesLog.info(" MONPlantillaCurso.obtieneRecordSets(DTOCargaCursos, DTODruidaBusqueda): Entrada");	
		MONUtilidadesBD MONUtilidades = getMONUtilidadesBD();       
		try {
			dtoS.setCanales((MONUtilidades.obtieneCanales(dtoB)).getResultado());
		} catch (MareException me) {			
			if (me.getCode() != ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE){ // Si no es GEN-0007 Lanzo Excepcion
				UtilidadesLog.error("obtieneRecordsets: MareException",me);
				throw me;
			} else {
				dtoS.setCanales(new RecordSet());
				UtilidadesLog.debug("**** obtieneRecordsets: no hay Canales");
			}
		}			
		try {
			dtoS.setCursos((MONUtilidades.obtieneCursos(dtoB)).getResultado());
		} catch (MareException me) {	
			if (me.getCode() != ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE){ // Si no es GEN-0007 Lanzo Excepcion
				UtilidadesLog.error("obtieneRecordsets: MareException",me);
				throw me;
			} else {
				dtoS.setCursos(new RecordSet());
				UtilidadesLog.debug("**** obtieneRecordsets: no hay Cursos");
			}
		}
		try {
			dtoS.setFrecuenciasCursos((MONUtilidades.obtieneFrecuenciasCurso(dtoB)).getResultado());
		} catch (MareException me) {
			if (me.getCode() != ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE){ // Si no es GEN-0007 Lanzo Excepcion
				UtilidadesLog.error("obtieneRecordsets: MareException",me);
				throw me;
			} else {
				dtoS.setFrecuenciasCursos(new RecordSet());
				UtilidadesLog.debug("**** obtieneRecordsets: no hay Frecuencias",me);
			}
		}
		try {
			dtoS.setMarcas((MONUtilidades.obtieneMarcas(dtoB)).getResultado());
		} catch (MareException me) {
			if (me.getCode() != ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE){ // Si no es GEN-0007 Lanzo Excepcion
				UtilidadesLog.error("obtieneRecordsets: MareException",me);
				throw me;
			} else {
				dtoS.setMarcas(new RecordSet());
				UtilidadesLog.debug("**** obtieneRecordsets: no hay Marcas");
			}	
		}
		
		try {
			dtoS.setParametros((MONUtilidades.obtieneParametros(dtoB)).getResultado());
		} catch (MareException me) {
			if (me.getCode() != ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE){ // Si no es GEN-0007 Lanzo Excepcion
				UtilidadesLog.error("obtieneRecordsets: MareException",me);
				throw me;
			} else {
				dtoS.setParametros(new RecordSet());
				UtilidadesLog.debug("**** obtieneRecordsets: no hay Parametros");
			}
		}
		
		try {
			dtoS.setRegalos((MONUtilidades.obtieneRegalos(dtoB)).getResultado());
		} catch (MareException me) {
			if (me.getCode() != ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE){ // Si no es GEN-0007 Lanzo Excepcion
				UtilidadesLog.error("obtieneRecordsets: MareException",me);
				throw me;
			} else {
				dtoS.setRegalos(new RecordSet());
				UtilidadesLog.debug("**** obtieneRecordsets: no hay Regalos");
			}
		}
				
		try {
			dtoS.setStatusClientes((MONUtilidades.obtieneStatusClientes(dtoB)).getResultado());
		} catch (MareException me) {
			if (me.getCode() != ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE){ // Si no es GEN-0007 Lanzo Excepcion
				UtilidadesLog.error("obtieneRecordsets: MareException",me);
				throw me;
			} else {
				dtoS.setStatusClientes(new RecordSet());
				UtilidadesLog.debug("**** obtieneRecordsets: no hay Estatus Cliente");
			}
		}
					
		try {
			dtoS.setTiposCliente((MONUtilidades.obtieneTiposCliente(dtoB)).getResultado());
		} catch (MareException me) {
			if (me.getCode() != ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE){ // Si no es GEN-0007 Lanzo Excepcion
				UtilidadesLog.error("obtieneRecordsets: MareException",me);
				throw me;
			} else {
				dtoS.setTiposCliente(new RecordSet());
				UtilidadesLog.debug("**** obtieneRecordsets: no hay Tipos de Cliente");
			}
		}

		try {
			dtoS.setMomentoEntrega((MONUtilidades.obtieneMomentoEntrega(dtoB)).getResultado());
		} catch (MareException me) {
			if (me.getCode() != ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE){ // Si no es GEN-0007 Lanzo Excepcion
				UtilidadesLog.error("obtieneRecordsets: MareException",me);
				throw me;
			} else {
				dtoS.setTiposCliente(new RecordSet());
				UtilidadesLog.debug("**** obtieneRecordsets: no hay Momentos de Entrega");
			}
		}
		UtilidadesLog.info(" MONPlantillaCurso.obtieneRecordSets(DTOCargaCursos, DTODruidaBusqueda): Salida");	
	}

    
    private boolean plantillaConCursosAsig(Long oidPlantilla, MatrizCursosLocalHome lh) throws MareException
    {
        boolean resu = false;
        Collection coll = null;
        try{
            coll = lh.findByPlantilla(oidPlantilla);
		} catch (FinderException fe) {	
            UtilidadesLog.error("**** function: plantillaConCursosAsig, FEx: " + fe);	
            return resu;
		} catch (Exception exception){
            UtilidadesLog.error("**** function: plantillaConCursosAsig, Ex: " + exception);	
            return resu;
        }            
        
        if ((coll == null) || (coll.size() == 0))
        {
            resu = true;
        } else if(coll.size() < 0)
        {
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_EDU,ErroresNegocio.EDU_1004));
        }
        return resu;
    
    }

    private MatrizCursosLocalHome getMatrizCursosLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MatrizCursosLocalHome)context.lookup("java:comp/env/MatrizCursos");
    }
    
    private BelcorpService getBelcorpService() throws MareException {
        try {
            BelcorpService bs = BelcorpService.getInstance();

            return bs;
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    }


}
