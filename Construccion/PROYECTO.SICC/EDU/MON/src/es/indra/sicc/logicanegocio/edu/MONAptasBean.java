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

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.ConstantesCMN;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.edu.DTOApta;
import es.indra.sicc.dtos.edu.DTOAptaAsignada;
import es.indra.sicc.dtos.edu.DTOAsignarAptas;
import es.indra.sicc.dtos.edu.DTOInsertaApta;
import es.indra.sicc.dtos.edu.DTOOIDApta;
import es.indra.sicc.dtos.edu.DTOObtenerAptas;
import es.indra.sicc.dtos.edu.DTOSegundaConvocatoria;
import es.indra.sicc.dtos.mae.DTOClienteSubtipos;
import es.indra.sicc.dtos.mae.DTOClientesAsignarAptas;
import es.indra.sicc.dtos.mae.DTOCodigoCliente;
import es.indra.sicc.entidades.edu.AptasACursosLocal;
import es.indra.sicc.entidades.edu.AptasACursosLocalHome;
import es.indra.sicc.entidades.edu.AptasAsignadasLocal;
import es.indra.sicc.entidades.edu.AptasAsignadasLocalHome;
import es.indra.sicc.entidades.edu.AsignaAptasLocal;
import es.indra.sicc.entidades.edu.AsignaAptasLocalHome;
import es.indra.sicc.entidades.edu.MatrizCursosLocal;
import es.indra.sicc.entidades.edu.MatrizCursosLocalHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.edu.ConstantesEDU;
import es.indra.sicc.logicanegocio.edu.DAOAptas;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesFiles;
import es.indra.sicc.util.UtilidadesLog;

import java.io.BufferedReader;
import java.io.IOException;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONAptasBean implements SessionBean  {

	private SessionContext ctx;
	protected BufferedReader bufReader;
	private final static String MON_CLIENTES = "MONClientes";

	public void ejbCreate() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void ejbRemove() {
	}

	public void setSessionContext(SessionContext ctx) {
		this.ctx = ctx;
	}

	public void insertaAptas(DTOInsertaApta dtoe) throws MareException {
		UtilidadesLog.info(" MONAptas.insertaAptas(DTOInsertaApta): Entrada");
		this.validaAcceso(dtoe.getOidPais(),null,null, null, null, null, null, null, null, null, null);
		
		AptasAsignadasLocalHome home=null;
		AptasAsignadasLocal local=null;

		Collection collection=null;
		try{

			home=new AptasAsignadasLocalHome();

			collection=home.findfindByCurso(dtoe.getOidAsigna());
		
			AptasACursosLocalHome homeAptas=null;
			AptasACursosLocal localAptas=null;
		
			if (collection!=null && collection.size()>0) {
				Iterator iterador = collection.iterator();//Elementos de AptasAsignadas
				while(iterador.hasNext()) {
								
					local=(AptasAsignadasLocal)iterador.next();
					homeAptas= new AptasACursosLocalHome();
										//PARA PROBARLO ConstantesCMN.VAL_FALSE   ConstantesCMN.VAL_TRUE							

                    try{
                        //localAptas = homeAptas.findByUK(local.getCurso(),local.getCliente());
                        localAptas = homeAptas.findByUK(dtoe.getOidCurso(),local.getCliente());
                        
                                localAptas.setCurso(dtoe.getOidCurso());
                                localAptas.setNumConvocatoria(local.getNumConvocatoria());
                                localAptas.setCliente(local.getCliente());
                                localAptas.setSubtipo(local.getSubtipo());                        
                                localAptas.setFechaAsistencia(null);
                                localAptas.setDataMart(local.getDataMart());
                                localAptas.setApta(local.getApta());
                                localAptas.setInvitadaCurso(new Boolean(!local.getApta().booleanValue()));
                                localAptas.setAsistenciaCurso(ConstantesEDU.NO_ASIS);
                                
                                if (dtoe.getIndOrigen().equals(ConstantesEDU.ORIG_APTAS)){
                                    localAptas.setPruebas(obtieneBoolean(ConstantesCMN.VAL_FALSE));                                
                                }else{
                                    localAptas.setPruebas(obtieneBoolean(ConstantesCMN.VAL_TRUE));                                
                                }
                        homeAptas.merge(localAptas);

                    }catch(NoResultException e){
                        UtilidadesLog.debug("No se encontro el registro - procedemos a crearlo");
                        if (dtoe.getIndOrigen().equals(ConstantesEDU.ORIG_APTAS)){
                            homeAptas.create(dtoe.getOidCurso(),	//1.-Long curso,              
                                local.getNumConvocatoria(),			//2.-Integer numConvocatoria,
                                local.getCliente(),					//3.-Long cliente,
                                local.getSubtipo(), 				//4.-Long subtipo, 
                                null, 								//5.-Date fechaAsistencia, 
                                local.getDataMart(), 				//6.-Boolean dataMart, 
                                local.getApta(), 					//7.-Boolean apta,  
                                new Boolean(!local.getApta().booleanValue()), //8.-Boolean invitadaCurso,
                                ConstantesEDU.NO_ASIS, 				//9.-nteger asistenciaCurso,  
                                obtieneBoolean(ConstantesCMN.VAL_FALSE));//10.-Boolean pruebas 
                        }else{
                            homeAptas.create(dtoe.getOidCurso(),	//1.-Long curso,              
                                local.getNumConvocatoria(),			//2.-Integer numConvocatoria,
                                local.getCliente(),					//3.-Long cliente,
                                local.getSubtipo(), 				//4.-Long subtipo, 
                                null, 								//5.-Date fechaAsistencia, 
                                local.getDataMart(), 				//6.-Boolean dataMart, 
                                local.getApta(), 					//7.-Boolean apta,  
                                new Boolean(!local.getApta().booleanValue()), //8.-Boolean invitadaCurso,
                                ConstantesEDU.NO_ASIS, 				//9.-nteger asistenciaCurso,  
                                obtieneBoolean(ConstantesCMN.VAL_TRUE));//10.-Boolean pruebas 
                        }
                    }

					
				
				//Elimina el objeto de AptasAsignadas (EJB Entity) 
					home.remove(local);
				
			}//while
			
			//Elimina el objeto AsignaAptas (EJB Entity) cuyo oid es dtoe.oidAsigna
			AsignaAptasLocalHome homeAsignaAptas=null;
			AsignaAptasLocal localAsignaAptas=null;
                        try {
                            homeAsignaAptas=new AsignaAptasLocalHome();
                            localAsignaAptas = homeAsignaAptas.findByPrimaryKey(dtoe.getOidAsigna());
                            homeAsignaAptas.remove(localAsignaAptas);
                        } catch (NoResultException nre) {
                            UtilidadesLog.error(nre);
                            UtilidadesLog.error("insertaAptas: ",nre);
                            throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                            
                        }
			
		}//if !collection.isEmpty()
		
		/*
		Elimina el objeto de AptasAsignadas (EJB Entity) 
		Fin del Bucle 
		Elimina el objeto AsignaAptas (EJB Entity) cuyo oid es dtoe.oidAsigna
		*/
		}catch(PersistenceException ce){
			UtilidadesLog.error("insertaAptas: RemoveException",ce);
			throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
		}
		UtilidadesLog.info(" MONAptas.insertaAptas(DTOInsertaApta): Salida");
		
	}//metdo
	
	public DTOSalida cargaAsignarAptas(DTOAsignarAptas dtoe) throws MareException {
		//Se crea DAOAptas Se invoca al método DAOAptas.consultaCursos pasando 
		 //* como parámetro de entrada el parámetro recibido (dtoe). 
		//Se retorna el DTO retornado por el método invocado.
		//
		UtilidadesLog.info(" MONAptas.cargaAsignarAptas(DTOAsignarAptas): Entrada");
		
		DTOSalida dtoSalida=new DTOSalida();
		String usuario=ctx.getCallerPrincipal().getName();
		DAOAptas daoAptas= new DAOAptas(usuario);//hay que pasarle el usuario
		dtoSalida=daoAptas.consultaCursos(dtoe);
		RecordSet rs=new RecordSet();
		rs=dtoSalida.getResultado();
		 if (rs.esVacio()) {
            //GEN-0007 --> 005
			UtilidadesLog.debug("****cargaAsignarAptas: no hay datos ");				
			//this.loguearError("cargaAsignarAptas: ",ce);
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		
        }


		UtilidadesLog.info(" MONAptas.cargaAsignarAptas(DTOAsignarAptas): Salida");
		return dtoSalida;
		
	}

	public DTOSalida cargaAptasCurso(DTOOIDApta dtoe) throws MareException {
///*Se crea DAOAptas 
//Se invoca al método DAOAptas.consultaAptas pasando como parámetro de entrada dtoe.oid 
//Se retorna el DTO retornado por el método invocado.

		UtilidadesLog.info(" MONAptas.cargaAptasCurso(DTOOIDApta): Entrada");
		DTOSalida dtoSalida=new DTOSalida();
		String usuario=this.ctx.getCallerPrincipal().getName();
		DAOAptas daoAptas= new DAOAptas(usuario);
		dtoSalida=daoAptas.consultaAptas(dtoe);//BELC300007000 cambio parametro de entrada
		RecordSet rs=new RecordSet();
		rs=dtoSalida.getResultado();
		 if (rs.esVacio()) {
            //GEN-0007 --> 005
			UtilidadesLog.debug("****cargaAsignarAptas: no hay datos ");				
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
    UtilidadesLog.info(" MONAptas.cargaAptasCurso(DTOOIDApta): Salida");
		return dtoSalida;
	}

	public DTOOID obtieneAptas(DTOObtenerAptas dtoe) throws MareException {
		UtilidadesLog.info(" MONAptas.obtieneAptas(DTOObtenerAptas): Entrada");
		/*Se crea un objeto AsignaAptas (EJB Entity) con los siguientes valores: 
		AsignaAptas.oid = se genera automáticamente 
		AsignaAptas.curso = dtoe.oidCurso 
		AsignaAptas.fecha = fecha del sistema 

		Si dtoe.path = "" (no hay acceso a Data Mart) 
		Llama al método obtieneClientes(dtoe, AsignaAptas.oid) 
		Si no (hay acceso a Data Mart) 
		Llama al método obtieneFichero(dtoe, AsignaAptas.oid) 
		Fin del Si 

		El método retorna el oid del objeto creado en AsignarAptas (EJB Entity): 
		DTOOID.oid = AsignaAptas.oid
		*/
		
		this.validaAcceso(dtoe.getOidPais(), null,null,null, null, null, null, null, null, null, null);
		AsignaAptasLocalHome home=null;
		AsignaAptasLocal local=null;

		home=new AsignaAptasLocalHome();
		try{
			local = home.create(dtoe.getOidCurso(), new Timestamp(System.currentTimeMillis()));
		}catch(PersistenceException ce){
			UtilidadesLog.error("obtieneAptas: CreateException",ce);
			throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
		}
		if(dtoe.getPath()!=null){	
			if(dtoe.getPath().equals("")){
				obtieneClientes(dtoe,local.getOid()); 
			}else{
				obtieneFichero(dtoe,local.getOid());  
			}
		}
		DTOOID dtoOid= new DTOOID();
		dtoOid.setOid(local.getOid());
					
		UtilidadesLog.info(" MONAptas.obtieneAptas(DTOObtenerAptas): Salida");
		return dtoOid;
	}

	public void eliminaAptas(DTOApta dtoe) throws MareException {
		/*Por cada elemento del array dtoe.aptas() 
		Elimina el objeto AptasAsignadas (EJB Entity) cuyo oid es dtoe.aptas(i).oid 
		Fin del Bucle*/
		UtilidadesLog.info(" MONAptas.eliminaAptas(DTOApta): Entrada");
		this.validaAcceso(dtoe.getOidPais(), null,null,null, null, null, null, null, null, null, null);
	
		AptasAsignadasLocalHome home=null;
		AptasAsignadasLocal local=null;
		
		DTOOID[] arrayDtos = dtoe.getAptas();

		for(int i=0;i<arrayDtos.length;i++){
		 
			home=new AptasAsignadasLocalHome();
			try{
                                local = home.findByPrimaryKey(arrayDtos[i].getOid());
				home.remove(local);
			}catch(NoResultException ce){
				UtilidadesLog.error("eliminaAptas: RemoveException",ce);
				throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
			}catch(PersistenceException ce){
				UtilidadesLog.error("eliminaAptas: RemoveException",ce);
				throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
			}
		}//for
		UtilidadesLog.info(" MONAptas.eliminaAptas(DTOApta): Salida");

	}// eliminaAptas

	public void segundaConvocatoria(DTOSegundaConvocatoria dtoe) throws MareException {
		UtilidadesLog.info(" MONAptas.segundaConvocatoria(DTOSegundaConvocatoria): Entrada");
		/*Se crea DAOAptas y se invoca al método obtieneSegundaConvocatoria pasándole 
		 * como parámetros de entrada:
		 * dtoe.codCurso
		 * dtoe.pais */
		this.validaAcceso(dtoe.getOidPais(),null,null, null, null, null, null, null, null, null, null);
		
        MatrizCursosLocalHome mclh = this.getMatrizCursosLocalHome();
        //MatrizCursosLocal mcl =  null;
        /*
        Se valida que el curso recibido exista 
        curso = MatrizCursos.findByPaisMarcaCanalCurso(dto.pais, dto.oidMarca, dto.oidCanal, dto.codCurso) 
        Si se captura una Excepción 
        */        
        try{
            //Long pais, Long marca, Long canal, Integer curso        
            mclh.findByPaisMarcaCanalCurso(dtoe.getOidPais(),dtoe.getOidMarca(), dtoe.getOidCanal(), dtoe.getCodCurso());
        }catch(FinderException fe){
            //Lanzar Excepción con código de error: 1002 "El curso seleccionado no existe"     
            UtilidadesLog.debug("No se encontro registros la hacer findByPaisMarcaCanalCurso");            
            throw new MareException(null, new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_EDU, "", ErroresNegocio.EDU_1002));
        }catch(Exception e){
            //Lanzar Excepción con código de error: 1002 "El curso seleccionado no existe"     
            UtilidadesLog.error("Fallo en el ejb");            
            throw new MareException(null, new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_EDU, "", ErroresNegocio.EDU_1002));
        }
  
        
        String usuario=this.ctx.getCallerPrincipal().getName();
		DAOAptas daoAptas= new DAOAptas(usuario);
		RecordSet rs = null;
		rs=daoAptas.obtieneSegundaConvocatoria(dtoe.getCodCurso(),dtoe.getOidPais());//falta incidencia
		if(rs==null){
			rs=new RecordSet();
		}
		
		 if (rs.esVacio()) {
            //GEN-0007 --> 005
			UtilidadesLog.debug("****segundaConvocatoria: no hay datos ");				
            /*
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            */
        }
		
		if(!rs.esVacio()){
			AptasAsignadasLocalHome home=null;
			AptasAsignadasLocal local=null;
			//Vector vector=new Vector();
			for(int i=0;i<rs.getRowCount();i++){

				//this.getLog().info("****vector= " + vector.toString());
				home=new AptasAsignadasLocalHome();
				Boolean banderaApta=Boolean.valueOf(false);
				Boolean banderaData=Boolean.valueOf(false);
				
					if(rs.getValueAt(i,2)!=null){
						Long longi=new Long((rs.getValueAt(i,2)).toString());
						if(longi.intValue()==1){
							banderaApta=Boolean.TRUE;
						}
					}
					if(rs.getValueAt(i,3)!=null){
						Long longi=new Long((rs.getValueAt(i,3)).toString());
						if(longi.intValue()==1){
							banderaData=Boolean.TRUE;
						}
					}
					
		
					try{
					/*	1.Integer numConvocatoria, 
						2.Long cliente, 
						3.Long curso, 
						4.Long subtipo,
						5. Boolean apta, 
						6. Boolean dataMart*/
					local = home.create(ConstantesEDU.SEG_CONV, 
										new Long((rs.getValueAt(i,0)).toString()), //cliente
										dtoe.getOidAsigna(),//curso	
										new Long((rs.getValueAt(i,1)).toString()), //subtipo
										banderaApta,//apta
										banderaData);//dataMArk
					
					}catch(PersistenceException ce){
						UtilidadesLog.error("segundaConvocatoria: CreateException",ce);
						ctx.setRollbackOnly();
						throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
					}
			}//existefila
	
		}//if vacio
		
		UtilidadesLog.info(" MONAptas.segundaConvocatoria(DTOSegundaConvocatoria): Salida");
	}

	private void obtieneFichero(DTOObtenerAptas dtoe, Long oidAsigna) throws MareException {
		
		UtilidadesLog.info(" MONAptas.obtieneFichero(DTOObtenerAptas, oidAsigna): Entrada");
		//MatrizCursosLocalHome homeMatriz=null;
		MatrizCursosLocal	LocalMatriz=null;
		//Se llama al método obtieneCurso pasándole como parámetro de entrada dtoe.oidCurso.
		//El método retorna un objeto MatrizCursos (EJB Entity) 

		LocalMatriz=obtieneCurso(dtoe.getOidCurso());
		//Vector datos=null;
		/*Abre el fichero indicado en el parámetro de entrada dtoe.path 
		Lee el fichero 
		Mientras no se llegue al final del fichero */

        try {
			UtilidadesLog.debug("++ Antes de abrir el fichero: "+dtoe.getPath()+" ++");
            bufReader = UtilidadesFiles.abrirFichero(dtoe.getPath());
        } catch(MareException mEx) {
			UtilidadesLog.error("obtieneFichero: MareException",mEx);
            throw new MareException(mEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
        }
            
			UtilidadesLog.debug("bufReader: "+bufReader);
			UtilidadesLog.debug("++ Despues de abrir el fichero ++");
			String str=null;
			UtilidadesLog.debug("++ Antes del while ++");
        try{
			while ((str = bufReader.readLine()) != null) {//por cada linea.
				UtilidadesLog.debug("*****++++  Entra en el while");
                 UtilidadesLog.debug("str: " + str);
				 StringTokenizer st = new StringTokenizer(str, ",");
				 String[] dat=new String[st.countTokens()];
				 int x=0;	
				 while(st.hasMoreTokens()) {
					dat[x]=st.nextToken();
					UtilidadesLog.debug("Dat["+x+"]: "+dat[x]);
					x++;
				}
				
				/*Cod. De País; Cod. de Cliente	;Cod. De Curso;	Fec. del Filtro;Cod. De Apta al curso;Cod de Invitación	;*/		
				/*Si el código del curso leído en el fichero es igual a MatrizCursos.codigo 
					Se llama al método obtieneClienteSubtipos pasándole como entrada dtoe.pais
					y el código de cliente leído en el fichero. El método retorna DTOClienteSubtipos */
				//DTOClienteSubtipos dtoClienteS=	new DTOClienteSubtipos();						//el codigo no es nulable
				//dtoClienteS=obtieneClienteSubtipos(dtoe.getOidPais(),dat[1]);
				UtilidadesLog.debug("LocalMatriz.getCodigo: "+ LocalMatriz.getCodigo());
				UtilidadesLog.debug("DAT[2]: "+dat[2]);
				if(dat[2].equals(LocalMatriz.getCodigo().toString())){//dat[2]es el codigo curso
					DTOClienteSubtipos dtoClienteS=	new DTOClienteSubtipos();							//código de cliente leído en el fichero
                    
					dtoClienteS=obtieneClienteSubtipos(dtoe.getOidPais(),dat[1]);
					/*Para cada elemento en el recordset DTOClienteSubtipos.subtipos 
					Se crea DTOAptaAsignada (dto) y se carga con la siguiente información: 
					dto.curso = oidAsigna (parámetro de entrada) 
					dto.cliente = DTOClienteSubtipos.oidCliente 
					dto.subtipo = DTOClienteSubtipos.subtipos.oidSubtipoCliente 
					Si el campo Cond. Apta leído en el fichero es igual a ConstantesCMN.VAL_TRUE 
					dto.apta = ConstantesCMN.VAL_TRUE 
					Si no 
					dto.apta = ConstantesCMN.VAL_FALSE 
					Fin del Si 
					dto.dataMart = ConstantesCMN.VAL_TRUE 
					dto.numConvocatoria = ConstantesEDU.PRIM_CONV 
					Se llama al método insertaAptaAsignada pasándole como parámetro de entrada dto */
					RecordSet rs=dtoClienteS.getSubtipos();
					if(!rs.esVacio()){
						UtilidadesLog.debug("RecordSet no es vacio");
						for(int i=0;i<rs.getRowCount();i++){
							DTOAptaAsignada dtoAptaAsignada=new DTOAptaAsignada();
							dtoAptaAsignada.setCurso(oidAsigna);
							dtoAptaAsignada.setCliente(dtoClienteS.getOidCliente());
							dtoAptaAsignada.setSubtipo(new Long((rs.getValueAt(i,0)).toString()));
							if(dat[4].equals(obtieneBoolean(ConstantesCMN.VAL_TRUE).toString())){//ConstantesCMN.VAL_TRUE 
								dtoAptaAsignada.setApta(obtieneBoolean(ConstantesCMN.VAL_TRUE ));//ConstantesCMN.VAL_TRUE 
							}else{
								dtoAptaAsignada.setApta(obtieneBoolean(ConstantesCMN.VAL_FALSE));//ConstantesCMN.VAL_FALSE
							}
							dtoAptaAsignada.setDataMart(obtieneBoolean(ConstantesCMN.VAL_TRUE));//ConstantesCMN.VAL_TRUE 
							dtoAptaAsignada.setNumConvocatoria(ConstantesEDU.PRIM_CONV);
							insertaAptaAsignada(dtoAptaAsignada);
						}
					}//if(!rs.esVacio()){
				}//if(dat[2].equals
			}//while lineas
			/*Fin del Bucle 
			Fin del Si 
			Lee el fichero 
			Fin del Mientras 

			Se cierra el fichero*/
			bufReader.close();
        //Se cambia el orden de los try y catch para solucionar la incidencia BELC300011921
        /*
        } catch(MareException mEx) {
			UtilidadesLog.error("Fallo al obtener subtipos cliente: MareException",mEx);
            //throw new MareException(mEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
        */
        }catch(IOException ioe){//BufferedReader
				UtilidadesLog.error("obtieneFichero: IOException",ioe);
				throw new MareException(ioe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
		}
		UtilidadesLog.info(" MONAptas.obtieneFichero(DTOObtenerAptas, oidAsigna): Salida");
		
/*
		try {
			BufferedReader br = new BufferedReader(new FileReader(dtoe.getPath()));
			String str;
			while ((str = br.readLine()) != null) {//por cada linea.
				 StringTokenizer st = new StringTokenizer(str, ",");
				 String[] dat=new String[st.countTokens()];
				 int x=0;	
				 while(st.hasMoreTokens()) {
					dat[x]=st.nextToken();
					x++;
				}
				//Cod. De País; Cod. de Cliente	;Cod. De Curso;	Fec. del Filtro;Cod. De Apta al curso;Cod de Invitación	;
				//Si el código del curso leído en el fichero es igual a MatrizCursos.codigo 
				//	Se llama al método obtieneClienteSubtipos pasándole como entrada dtoe.pais
				//	y el código de cliente leído en el fichero. El método retorna DTOClienteSubtipos 
				//DTOClienteSubtipos dtoClienteS=	new DTOClienteSubtipos();						//el codigo no es nulable
				//dtoClienteS=obtieneClienteSubtipos(dtoe.getOidPais(),dat[1]);
				if(dat[2].equals(LocalMatriz.getCodigo())){//dat[2]es el codigo curso
					DTOClienteSubtipos dtoClienteS=	new DTOClienteSubtipos();							//código de cliente leído en el fichero
					dtoClienteS=obtieneClienteSubtipos(dtoe.getOidPais(),dat[1]);
					/*Para cada elemento en el recordset DTOClienteSubtipos.subtipos 
					Se crea DTOAptaAsignada (dto) y se carga con la siguiente información: 
					dto.curso = oidAsigna (parámetro de entrada) 
					dto.cliente = DTOClienteSubtipos.oidCliente 
					dto.subtipo = DTOClienteSubtipos.subtipos.oidSubtipoCliente 
					Si el campo Cond. Apta leído en el fichero es igual a ConstantesCMN.VAL_TRUE 
					dto.apta = ConstantesCMN.VAL_TRUE 
					Si no 
					dto.apta = ConstantesCMN.VAL_FALSE 
					Fin del Si 
					dto.dataMart = ConstantesCMN.VAL_TRUE 
					dto.numConvocatoria = ConstantesEDU.PRIM_CONV 
//					Se llama al método insertaAptaAsignada pasándole como parámetro de entrada dto 
					RecordSet rs=dtoClienteS.getSubtipos();
					if(!rs.esVacio()){
						for(int i=0;i<rs.getRowCount();i++){
							DTOAptaAsignada dtoAptaAsignada=new DTOAptaAsignada();
							dtoAptaAsignada.setCurso(oidAsigna);
							dtoAptaAsignada.setCliente(dtoClienteS.getOidCliente());
							dtoAptaAsignada.setSubtipo(new Long((rs.getValueAt(i,0)).toString()));
							if(dat[4].equals(obtieneBoolean(ConstantesCMN.VAL_TRUE))){//ConstantesCMN.VAL_TRUE 
								dtoAptaAsignada.setApta(obtieneBoolean(ConstantesCMN.VAL_TRUE ));//ConstantesCMN.VAL_TRUE 
							}else{
								dtoAptaAsignada.setApta(obtieneBoolean(ConstantesCMN.VAL_FALSE));//ConstantesCMN.VAL_FALSE
							}
							dtoAptaAsignada.setDataMart(obtieneBoolean(ConstantesCMN.VAL_TRUE));//ConstantesCMN.VAL_TRUE 
							dtoAptaAsignada.setNumConvocatoria(ConstantesEDU.PRIM_CONV);
							insertaAptaAsignada(dtoAptaAsignada);
						}
					}//if(!rs.esVacio()){
				}//if(dat[2].equals
			}//while lineas
			/*Fin del Bucle 
			Fin del Si 
			Lee el fichero 
			Fin del Mientras 

			Se cierra el fichero
			br.close();
			}catch(NoSuchElementException nse){
				UtilidadesLog.error("obtieneFichero: NoSuchElementException",nse);
				throw new MareException(nse, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
			}catch(FileNotFoundException fnf){//FileReader
				UtilidadesLog.error("obtieneFichero: FileNotFoundException",fnf);
				throw new MareException(fnf, UtilidadesError.armarCodigoError(CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
				
			}catch(IOException ioe){//BufferedReader
				UtilidadesLog.error("obtieneFichero: IOException",ioe);
				throw new MareException(ioe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
			}*/

		

		}

	private void obtieneClientes(DTOObtenerAptas dtoe, Long oidAsigna) throws MareException {
		UtilidadesLog.info(" MONAptas.obtieneClientes(DTOObtenerAptas, oidAsigna): Entrada");
		/*Se llama al método obtieneCurso pasándole como parámetro
		 * de entrada dtoe.oidCurso. El método retorna un objeto MatrizCursos (EJB Entity) 
		Se crea DTOClientesAsignarAptas (dto) y se carga con la siguiente información: 
		dto.pais = dtoe.pais 
		dto.marca = MatrizCursos.marca 
		dto.canal = MatrizCursos.canal 
		*/
		//MatrizCursosLocalHome homeMatriz=null;
		MatrizCursosLocal	LocalMatriz=null;

		LocalMatriz=obtieneCurso(dtoe.getOidCurso());
		//this.validaAcceso(dtoe.getOidPais(), LocalMatriz.getMarca(),LocalMatriz.getCanal(),LocalMatriz.getAcceso(), LocalMatriz.getSubgerencia(), LocalMatriz.getRegion(), LocalMatriz.getZona(), LocalMatriz.getSeccion(), LocalMatriz.getTerritorio());
	
		DTOClientesAsignarAptas dtoClientesAsigptas =new DTOClientesAsignarAptas();
		dtoClientesAsigptas.setPais(dtoe.getOidPais());
		dtoClientesAsigptas.setMarca(LocalMatriz.getMarca());
		dtoClientesAsigptas.setCanal(LocalMatriz.getCanal());
		dtoClientesAsigptas.setOidPais(dtoe.getOidPais());
		dtoClientesAsigptas.setOidIdioma(dtoe.getOidIdioma());
		/*Se llama al método obtieneClientesAsignarAptas 
		 * de la interface IMaestroClientes pasándole como entrada dto.
		 * El método devuelve un DTOSalida (dtos) con los clientes a analizar.
		 * */
		MONClientes monClientes = null; //Es un mon de mae
        int retorno = -1;
		
		monClientes = this.getMONClientes();//este ya lanza una Mare
		try  {
			retorno = monClientes.obtieneClientesAsignarAptasInBD(LocalMatriz,dtoClientesAsigptas,oidAsigna);
		}catch(RemoteException e) {
			UtilidadesLog.error("obtieneClientesAsignarAptas: RemoteException",e);
			ctx.setRollbackOnly(); 
			throw new MareException(e,UtilidadesError.armarCodigoError(
			CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			 
		}

		 UtilidadesLog.info(" MONAptas.obtieneClientes(DTOObtenerAptas, oidAsigna): Salida");
	}

	private MatrizCursosLocal  obtieneCurso(Long oidCurso) throws MareException {
		 UtilidadesLog.info(" MONAptas.obtieneCurso(oidCurso): Entrada");
		/*Obtiene el objeto MatrizCursos (EJB Entity) cuyo oid es oidCurso 
		Se retorna el objeto obtenido */
		MatrizCursosLocalHome home=null;
		MatrizCursosLocal localMatriz=null;
		
		home=this.getMatrizCursosLocalHome();
		try{
			localMatriz = home.findByPrimaryKey(oidCurso);
		}catch(FinderException ce){
			UtilidadesLog.error("obtieneCurso: FinderException",ce);
			throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		}
		UtilidadesLog.info(" MONAptas.obtieneCurso(oidCurso): Salida");
		return localMatriz;
	}

	private void evaluaClientes(MatrizCursosLocal obj, DTOSalida dtoe, Long oidAsigna) throws MareException  { 
        UtilidadesLog.info(" MONAptas.evaluaClientes(MatrizCursosLocal, DTOSalida, oidAsigna): Entrada");
        String usuario=this.ctx.getCallerPrincipal().getName(); 
        DAOAptas daoAptas= new DAOAptas(usuario); 
        Boolean bValido=null; 
        //Integer numReci=null; 

        // Se obtiene una lista de los oid de los tipos de curso exigidos para el curso que se está tratando
        ArrayList tipoCursosExigidos = daoAptas.tipoCursosExigidos(obj.getOid()); 
                
        RecordSet rs=null; 
        rs = dtoe.getResultado(); 

        if ( ! rs.esVacio() ) {
            UtilidadesLog.debug("rs  " + rs);
            for (int i=0;i<rs.getRowCount();i++) {
                UtilidadesLog.debug("oidCliente a validar: " + (rs.getValueAt(i,0)).toString());
                if (rs.getValueAt(i,8)==null){
                    bValido = validaMorosidad(obj, null);//bloqueoFinanciero				
                    UtilidadesLog.debug("SCS validaMorosidad A, da: " + bValido);
                }else{
                    bValido = validaMorosidad(obj, new Long((rs.getValueAt(i,8)).toString()));//bloqueoFinanciero					
                    UtilidadesLog.debug("SCS validaMorosidad B, da: " + bValido);
                }
                
                if(bValido.booleanValue()) {
                    bValido = validaEstatus(obj, new Long((rs.getValueAt(i,9)).toString()));
                    UtilidadesLog.debug("SCS validaEstatus, da: " + bValido);
                }
                
                if(bValido.booleanValue()) {
                    bValido = validaCarrera(obj, 
                                new Long((rs.getValueAt(i,10)).toString()),// dtoe.registro.tipoCliente
                                new Long((rs.getValueAt(i,11)).toString()),//dtoe.registro.subtipoCliente, 
                                new Long((rs.getValueAt(i,12)).toString()),//dtoe.registro.clasificacion, 
                                new Long((rs.getValueAt(i,13)).toString()));//dtoe.registro.tipoClasificacion 
                    UtilidadesLog.debug("SCS validaCarrera, da: " + bValido);
                }
                if(bValido.booleanValue()){
                    bValido = validaUnidadAdministrativa(obj, 
                                new Long((rs.getValueAt(i,3)).toString()),//dtoe.registro.territorio, 
                                new Long((rs.getValueAt(i,4)).toString()),//dtoe.registro.seccion, 
                                new Long((rs.getValueAt(i,5)).toString()),//dtoe.registro.zona,  
                                new Long((rs.getValueAt(i,6)).toString()),//dtoe.registro.region,
                                new Long((rs.getValueAt(i,7)).toString())); //dtoe.registro.subgerencia) 
                    UtilidadesLog.debug("SCS validaUnidadAdministrativa, da: " + bValido);                                     
                }
                
                if (bValido.booleanValue()) {
                    // Se obtiene una lista de los oid de los tipos de curso recibidos por el cliente que se está tratando
                    Long oidCliente = new Long((rs.getValueAt(i,0)).toString());
                    ArrayList tipoCursosRecibidos = daoAptas.tipoCursosRecibidos(oidCliente);
                    UtilidadesLog.debug("tipoCursosExigidos " + tipoCursosExigidos );
                    UtilidadesLog.debug("tipoCursosRecibidos " + tipoCursosRecibidos );
                    Long oidTipoCursoExigido, oidTipoCursoRecibido;
                    Iterator iterExig = tipoCursosExigidos.iterator();
                    while (iterExig.hasNext() && bValido.booleanValue()) {
                        oidTipoCursoExigido = (Long)iterExig.next();
                        bValido = Boolean.FALSE;
                        for (int pos=0; pos < tipoCursosRecibidos.size(); pos++ ) {
                            oidTipoCursoRecibido = (Long)tipoCursosRecibidos.get(pos);
                            if (oidTipoCursoExigido.equals(oidTipoCursoRecibido)) {
                                bValido = Boolean.TRUE;
                            }
                        }
                    }    
                }
                UtilidadesLog.debug(" validacion tipos cursos exigidos contra tipos cursos recibidos, da: " + bValido); 
                
                //modificado por incidencia 19068
				//if(bValido.booleanValue()){
                if( (bValido.booleanValue()) && (obj.getPeriodoIniConstancia()!=null) && (obj.getPeriodoFinConstancia()!=null) ){
					bValido = validaConstancia(obj, new Long((rs.getValueAt(i,0)).toString())); //oidCliente
                    UtilidadesLog.debug("SCS validaConstancia, da: " + bValido);                                     
				}

                //modificacio por incidencia 19068
				//if(bValido.booleanValue()){
                if( (bValido.booleanValue()) && (obj.getPeriodoIniComparativo()!=null) && (obj.getPeriodoFinComparativo()!=null) ){
					bValido = validaVentas(obj, new Long((rs.getValueAt(i,0)).toString())); //oidCliente
                    UtilidadesLog.debug("SCS validaVentas, da: " + bValido);                                     
				}

				if(bValido.booleanValue()){
						Date fecha = new Date();
						if (rs.getValueAt(i,1)!=null){
							//SCS, se relaciona con Inc.: BELC300019065
                            fecha=(Date)rs.getValueAt(i,1);
						}
						if(rs.getValueAt(i,2)==null){
							bValido = validaIngreso(obj, 
									new Long((rs.getValueAt(i,0)).toString()),//dtoe.registro.oidCliente, 
									null,//dtoe.registro.periodoPrimerContacto, 
									fecha); //dtoe.registro.fechaIngreso 
                                    UtilidadesLog.debug("SCS validaIngreso A, da: " + bValido);                                     
						}else{
							bValido = validaIngreso(obj, 
									new Long((rs.getValueAt(i,0)).toString()),//dtoe.registro.oidCliente, 
									new Long((rs.getValueAt(i,2)).toString()),//dtoe.registro.periodoPrimerContacto, 
									fecha); //dtoe.registro.fechaIngreso 
                                    UtilidadesLog.debug("SCS validaIngreso B, da: " + bValido);                                     
						}
				}
                
                // INCIDENCIA BELC300014235
                if(bValido.booleanValue()){
                    AptasACursosLocalHome aptasCursoHome = new AptasACursosLocalHome();
                    try{
                        Long oidCliente = new Long((rs.getValueAt(i,0)).toString());
                        UtilidadesLog.debug("OID Cliente: "+oidCliente.longValue());
                        aptasCursoHome.findByUK(obj.getOid(),oidCliente);
                        bValido=Boolean.valueOf(false);
                        UtilidadesLog.debug("SCS aptasCursoHome, da: " + bValido);
                    }catch ( NoResultException fe ){
                        UtilidadesLog.debug("No se encontraron registros en APTASCURSO (OK)");
                    }
                }
                
                // INCIDENCIA V-EDU-03
                // 2007-01-13 Rafael Romero
                if(bValido.booleanValue()){
                    Long oidCliente = new Long((rs.getValueAt(i,0)).toString());
                    UtilidadesLog.debug("OID Curso: "+oidAsigna.longValue());
                    UtilidadesLog.debug("OID Cliente: "+oidCliente.longValue());
                    UtilidadesLog.debug("SubTipo Cliente: "+(rs.getValueAt(i,11)).toString());
                    //aptasAsignadas.findByCursoCliente(oidAsigna,oidCliente);
                    //DAOAptas daoAptas = new DAOAptas("");
                    if(daoAptas.clienteAsignadoACurso(oidCliente,oidAsigna).booleanValue()){
                        bValido=Boolean.valueOf(false);
                        UtilidadesLog.debug("Cliente ya registrado en APTASASIGNADAS con otro subtipo para el curso");
                    }
                    else{
                        bValido=Boolean.valueOf(true);
                        UtilidadesLog.debug("Cliente sera registrado en APTASASIGNADAS");
                    }
                }

                UtilidadesLog.debug("bValido.booleanValue() " + bValido.booleanValue());
                
				if(bValido.booleanValue()){
					DTOAptaAsignada dtoAptaAsignada= new DTOAptaAsignada();
					dtoAptaAsignada.setCurso(oidAsigna);
					dtoAptaAsignada.setCliente(new Long((rs.getValueAt(i,0)).toString()));
					dtoAptaAsignada.setSubtipo(new Long((rs.getValueAt(i,11)).toString()));
					dtoAptaAsignada.setApta(obtieneBoolean(ConstantesCMN.VAL_TRUE));//ConstantesCMN.VAL_TRUE 
					dtoAptaAsignada.setDataMart(obtieneBoolean(ConstantesCMN.VAL_TRUE));////ConstantesCMN.VAL_TRUE
					dtoAptaAsignada.setNumConvocatoria(ConstantesEDU.PRIM_CONV);
                    
                    UtilidadesLog.debug("antes de llamar a insertaAptaAsignada(dtoAptaAsignada) " + dtoAptaAsignada);
                    
					insertaAptaAsignada(dtoAptaAsignada);
				}

			}//for
		}//if !rs.esVacio()

		UtilidadesLog.info(" MONAptas.evaluaClientes(MatrizCursosLocal, DTOSalida, oidAsigna): Salida");
	
	}

	
	private Boolean validaMorosidad(MatrizCursosLocal obj, Long bloqueo) throws MareException {
			UtilidadesLog.info(" MONAptas.validaMorosidad(MatrizCursosLocal, bloqueo): Entrada");
		/*Proceso 
			======== 
			Se crea la variable boolean bValido que se inicializa a True 
			Si dtoe.registro.bloqueoFinanciero <> null 
			Si obj.controlMorosidad 
			bValido = False 
			Fin del Si 
			Fin del Si 
			Se retorna bValido
		*/
			Boolean bValido=Boolean.valueOf(true);
			if((bloqueo!=null)&&(obj.isControlMorosidad()!=null)){
				if(obj.isControlMorosidad().booleanValue()){
					bValido=Boolean.valueOf(false);
				}

			}
			UtilidadesLog.info(" MONAptas.validaMorosidad(MatrizCursosLocal, bloqueo): Salida");
			return bValido;
				
	}

	private Boolean validaEstatus(MatrizCursosLocal obj, Long estatus) throws MareException {
		/*Proceso 
			======== 
			Se crea la variable boolean bValido que se inicializa a True 
			Si obj.statusCliente <> null 
			Si obj.statusCliente <> dtoe.registro.estatus 
			bValido = False 
			Fin del Si 
			Fin del Si 
			Se retorna bValido
			*/
			UtilidadesLog.info(" MONAptas.validaEstatus(MatrizCursosLocal, estatus): Entrada");
			Boolean bValido=Boolean.valueOf(true);
			if(obj.getStatusCliente()!=null){
				if(obj.getStatusCliente().longValue()!=estatus.longValue()){
					bValido=Boolean.valueOf(false);
				}

			}
			UtilidadesLog.info(" MONAptas.validaEstatus(MatrizCursosLocal, estatus): Salida");
			return bValido;
			
	}

	private Boolean validaCarrera(MatrizCursosLocal obj, Long tipo, Long subtipo, Long clasificacion, Long tipoClasificacion) throws MareException {
		UtilidadesLog.info(" MONAptas.validaCarrera(MatrizCursosLocal, ttipo, subtipo, clasificacion, tipoClasificacion): Entrada");
    
    UtilidadesLog.debug(" obj.getTipoCliente(): " + obj.getTipoCliente());
    UtilidadesLog.debug(" obj.getSubtipoCliente(): " + obj.getSubtipoCliente());
    UtilidadesLog.debug(" obj.getTipoClasificacion(): " + obj.getTipoClasificacion());
    UtilidadesLog.debug(" obj.getClasificacion(): " + obj.getClasificacion());
    
    UtilidadesLog.debug(" tipo: " + tipo);
    UtilidadesLog.debug(" subtipo: " + subtipo);
    UtilidadesLog.debug(" tipoClasificacion: " + tipoClasificacion);
    UtilidadesLog.debug(" clasificacion: " + clasificacion);

		Boolean bValido=Boolean.valueOf(true);
		if((obj.getTipoCliente()!=null)&&(!obj.getTipoCliente().equals(tipo))) {
      UtilidadesLog.debug(" No cumple tipo");
			bValido=Boolean.valueOf(false);
		}
		if((obj.getSubtipoCliente()!=null)&&(!obj.getSubtipoCliente().equals(subtipo))){  //(obj.getSubtipoCliente()!=subtipo)){
      UtilidadesLog.debug(" No cumple subtipo");
			bValido=Boolean.valueOf(false);
		}
		if((obj.getClasificacion()!=null)&&(!obj.getClasificacion().equals(clasificacion))) {
      UtilidadesLog.debug(" No cumple tipo clasificacion");
			bValido=Boolean.valueOf(false);
		}
		if((obj.getTipoClasificacion()!=null)&&(!obj.getTipoClasificacion().equals(tipoClasificacion))) {
      UtilidadesLog.debug(" No cumple clasificacion");
			bValido=Boolean.valueOf(false);
		}
		UtilidadesLog.info(" MONAptas.validaCarrera(MatrizCursosLocal, ttipo, subtipo, clasificacion, tipoClasificacion): Salida");
		return bValido;
	}

	private Boolean validaUnidadAdministrativa(MatrizCursosLocal obj, Long territorio, Long seccion, Long zona, Long region, Long subgerencia) throws MareException {
		UtilidadesLog.info(" MONAptas.validaUnidadAdministrativa(MatrizCursosLocal, territorio, seccion, zona, region, subgerencia): Entrada");
		
		Boolean bValido=Boolean.valueOf(true);
		if (obj.isAlcance()!=null){
            if(!(obj.isAlcance().booleanValue())){
                if(obj.getTerritorio()!=null){
                    if(!obj.getTerritorio().equals(territorio)){
                        bValido=Boolean.valueOf(false);
                    }
                }
                if(obj.getSeccion()!=null){
                    if(!obj.getSeccion().equals(seccion)){
                        bValido=Boolean.valueOf(false);
                    }
                }
                if(obj.getZona()!=null){
                    if(!obj.getZona().equals(zona)){
                        bValido=Boolean.valueOf(false);
                    }
                }
                if(obj.getRegion()!=null){
                    if(!obj.getRegion().equals(region)){
                        bValido=Boolean.valueOf(false);
                    }
                }
                if(obj.getSubgerencia()!=null){
                    if(!obj.getSubgerencia().equals(subgerencia)){
                        bValido=Boolean.valueOf(false);
                    }
                }
                
            }//if(!(obj.isAlcance
		}
	UtilidadesLog.info(" MONAptas.validaUnidadAdministrativa(MatrizCursosLocal, territorio, seccion, zona, region, subgerencia): Salida");
	return bValido;	
	}

	private Boolean validaConstancia(MatrizCursosLocal obj, Long oidCliente) throws MareException {
		UtilidadesLog.info(" MONAptas.validaConstancia(MatrizCursosLocal, oidCliente): Entrada");
		Boolean bValido=Boolean.valueOf(true);
		DTOOIDs dtoOids=null;
		if(obj.getNumeroOrdenes()!=null){
				MONPeriodos monPeriodos = null;
				monPeriodos = this.getMONPeriodos();
				try  {							
                    UtilidadesLog.debug("Periodo Ini const: "+obj.getPeriodoIniConstancia());
                    UtilidadesLog.debug("Periodo Fin const: "+obj.getPeriodoFinConstancia());
					 dtoOids = monPeriodos.obtienePeriodosEntre(obj.getPeriodoIniConstancia(),obj.getPeriodoFinConstancia());
				}catch(RemoteException e) {
						UtilidadesLog.error("obtienePeriodosEntre: RemoteException",e);
					//	ctx.setRollbackOnly(); //es consulta pues no se pone
									throw new MareException(e,
						UtilidadesError.armarCodigoError(
										CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			 
				}	
			Long numPedid=null;
			//String usuario=this.ctx.getCallerPrincipal().getName();
			DAOSolicitud daoSolicitud= new DAOSolicitud();	
            UtilidadesLog.debug("OidCliente: "+oidCliente);
            UtilidadesLog.debug("dtoOids: "+dtoOids);
			numPedid=daoSolicitud.obtenerNumeroPedidosConsultoraPeriodos(oidCliente,dtoOids);
			if((numPedid!=null)&&(obj.getNumeroOrdenes()!=null)){
				if(numPedid.intValue() >obj.getNumeroOrdenes().intValue()){
					bValido=Boolean.valueOf(false);	
				}
			}
		}//if(!(obj.getNumeroOrdenes(
		/*Proceso 
		======== 
		Se crea la variable boolean bValido que se inicializa a True 

		Si obj.numeroOrdenes <> null 
		Se llama al método obtienePeriodosEntre de la interface IPeriodos: 
		DTOOIDs = IPeriodos.obtienePeriodosEntre(obj.periodoIniConstancia, obj.periodoFinConstancia) 

		Se llama al método obtenerNumeroPedidosConsultoraPeriodos de
		DAOSolicitud pasándole como parámetros de entrada: 
		oidCliente 
		DTOOIDs 

		El método retorna el número de pedidos realizados entre los periodos indicados (numPedid). 

		Si numPedid < obj.numeroOrdenes 
		bValido = False 
		Fin del Si 
		Fin del Si 

		Se retorna bValido
		*/
		
		UtilidadesLog.info(" MONAptas.validaConstancia(MatrizCursosLocal, oidCliente): Salida");
		return bValido;
	}

	private Boolean validaVentas(MatrizCursosLocal obj, Long oidCliente) throws MareException {
		UtilidadesLog.info(" MONAptas.validaVentas(MatrizCursosLocal, oidCliente): Entrada");
		Boolean bValido=Boolean.valueOf(true);
		
		DTOOIDs dtoOids=null;
		if(obj.getMontoVentas()!=null){
			//llamada obtienePeriodoActual de la interface IPeriodos - parámetros: dtoe.pais, dtoe.marca y dtoe.canal. El método retorna DTOPeriodo (dtoP). 
			MONPeriodos monPeriodos = null;
			monPeriodos = this.getMONPeriodos();
			try  {								
                    UtilidadesLog.debug("Periodo Ini comp: "+obj.getPeriodoIniComparativo());
                    UtilidadesLog.debug("Periodo Fin comp: "+obj.getPeriodoFinComparativo());
				 dtoOids = monPeriodos.obtienePeriodosEntre(obj.getPeriodoIniComparativo(),obj.getPeriodoFinComparativo());
			}catch(RemoteException e) {
				UtilidadesLog.error("obtienePeriodosEntre: RemoteException",e);
				//	ctx.setRollbackOnly(); //es consulta pues no se pone
				throw new MareException(e,UtilidadesError.armarCodigoError(
				CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			 
			}	
			BigDecimal monto=null;
			//String usuario=this.ctx.getCallerPrincipal().getName();
			DAOSolicitud daoSolicitud= new DAOSolicitud();	
			//	El método retorna el monto de las ventas realizadas entre los periodos indicados (monto). 
           UtilidadesLog.debug("OidCliente: "+oidCliente);
           UtilidadesLog.debug("dtoOids: "+dtoOids);
    		monto=daoSolicitud.obtenerMontoVentasConsultoraPeriodos(oidCliente,dtoOids);
			//El método retorna el monto de las ventas realizadas entre los periodos indicados (monto). 
      UtilidadesLog.debug("MontoVentaMinimo del Curso:"+obj.getMontoVentas());
      UtilidadesLog.debug("MontoVentaActual del Cliente:"+monto);
			if((monto!=null)&&(obj.getMontoVentas()!=null)){
        //enozigli 04/07/2005 cambio por incidencia BELC300019068 en
        //SICC-DMCO-EDU-201-334-N025 se indica que debe ir "monto < obj.montoVentas" "<" y NO ">"
				if(monto.intValue() < obj.getMontoVentas().intValue()){
					bValido=Boolean.valueOf(false);	
				}
			} else if ((monto==null)&&(obj.getMontoVentas()!=null)){
          //enozigli 19/07/2005 cambio por incidencia BELC300019068
          //faltaba contemplar el caso de que la matriz de curso tenga un monto minimo de venta
          //y el cliente tenfa el monto en null
          bValido=Boolean.valueOf(false);	
      }
		
		}//if(!(obj.getNumeroOrdenes(


		UtilidadesLog.info(" MONAptas.validaVentas(MatrizCursosLocal, oidCliente): Salida");
		return bValido;
	}

	private Boolean validaIngreso(MatrizCursosLocal obj, Long oidCliente, Long periodo, Date fechaIngreso) throws MareException {
		UtilidadesLog.info(" MONAptas.validaIngreso(MatrizCursosLocal, oidCliente, oidPeriodo, fechaIngreso): Entrada");
		Boolean bValido = Boolean.valueOf(true);
		/*Se crea la variable boolean bValido que se inicializa a True 
		Si obj.periodoIngreso <> null 
		Si periodo == null 
		bValido = False 
		Si periodo <> obj.periodoIngreso 
		bValido = False 
		Fin del Si 
		Fin del Si 

		Si obj.fechaIngreso <> null 
		Si fechaIngreso <> obj.fechaIngreso 
		bValido = False 
		Fin del Si 
		Fin del Si 
		*/
      UtilidadesLog.debug("Periodo ingreso: "+obj.getPeriodoIngreso()+" - Periodo: "+periodo);
		if (obj.getPeriodoIngreso()!=null){
			if(periodo==null){
            UtilidadesLog.debug("No valido la fecha en paso 1");
				bValido=Boolean.valueOf(false);	
			}
			if ((periodo!=null) && (!(periodo.longValue() == (obj.getPeriodoIngreso().longValue())))) {
            UtilidadesLog.debug("No valido la fecha en paso 2");
				bValido=Boolean.valueOf(false);	
			}
		}
        
        UtilidadesLog.debug("SCS, a punto de comparar fechas.....");

		if(obj.getFechaIngreso()!=null){
			java.sql.Date fechaSQL = new java.sql.Date(fechaIngreso.getTime());
			/* Modificado por incidencia 11871 
			 * if(fechaIngreso.compareTo(obj.getFechaIngreso())!=0){
			 */
             
             UtilidadesLog.debug("SCS, fechaSQL es: " + fechaSQL.toString());
             UtilidadesLog.debug("SCS, obj.getFechaIngreso() es: " + obj.getFechaIngreso().toString());
             
			if(!fechaSQL.toString().equals(obj.getFechaIngreso().toString())){
            UtilidadesLog.debug("No valido la fecha en paso 3");
				bValido=Boolean.valueOf(false);	
			}
		}
	/*Si obj.numeroCampanyas <> null 
		Si periodo == null 
			bValido = False 
		Si no 
			Se llama al método obtienePeriodoActual de la interface IPeriodos: 
			DTOPeriodo = IPeriodos.obtienePeriodoActual(obj.pais, obj.marca, obj.canal) 

			Se llama al método obtienePeriodosEntre de la interface IPeriodos: 
			DTOOIDs = IPeriodos.obtienePeriodosEntre(periodo, DTOPeriodo.oid) 
			Si el número de periodos retornados <> obj.numeroCampanyas 
				bValido = False 
			Fin del Si 
		Fin del Si 
	Fin del Si 
		*/
		DTOPeriodo dtoPeriodo= new DTOPeriodo();
		DTOOIDs dtoOids= new DTOOIDs();
      UtilidadesLog.debug("obj.getNumeroCampanyas(): "+obj.getNumeroCampanyas());
		if(obj.getNumeroCampanyas()!=null){
			if(periodo==null){
            UtilidadesLog.debug("No valido la fecha en paso 4");
				bValido=Boolean.valueOf(false);	
			}else{	
						MONPeriodos monPeriodos = null;
						monPeriodos = this.getMONPeriodos();
						try  {										
								 dtoPeriodo = monPeriodos.obtienePeriodoActual(obj.getPais(),obj.getMarca(), obj.getCanal());
								 dtoOids = monPeriodos.obtienePeriodosEntre(periodo,dtoPeriodo.getOid());
						}catch(RemoteException e) {
							UtilidadesLog.error("obtienePeriodosEntre: RemoteException",e);
							//	ctx.setRollbackOnly(); //es consulta pues no se pone
							throw new MareException(e,UtilidadesError.armarCodigoError(
							CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			 
						}//catch
						Long [] arrayLong=dtoOids.getOids();
						int tamano=arrayLong.length;
						if(obj.getNumeroCampanyas()!=null){
							if(tamano!=obj.getNumeroCampanyas().intValue()){
                        UtilidadesLog.debug("No valido la fecha en paso 5");
								bValido=Boolean.valueOf(false);		
							}
						}
				}//else
			
		}//if(obj.getNumeroCampanyas()!=null){

		/*Si obj.fechaUltimo <> null 
		Se crea DAOAptas y se llama al método ultimoCurso pasando como parámetro de entrada oidCliente 
		Si la fecha retornada por el método > obj.fechaUltimo 
		bValido = False 
		Fin del Si 
		Fin del Si 

		Se retorna bValido
		*/
		Date date=new Date();
		String usuario=this.ctx.getCallerPrincipal().getName();
		
		UtilidadesLog.debug("obj.getFechaUltimo(): "+obj.getFechaUltimo());
		if(obj.getFechaUltimo()!=null){
                DAOAptas daoAptas= new DAOAptas(usuario);//hay que pasarle el usuario
				date = daoAptas.ultimoCurso(oidCliente);
                if(date!=null){
                    if(date.after(obj.getFechaUltimo())){
                        UtilidadesLog.debug("No valido la fecha en paso 6");
                        bValido = Boolean.valueOf(false);
                    }	
                } else { 
                  //agregado enozigli 08/09/2005 a pedido de jarivas en Perú
                  //Faltaba contemplar que si no hay fecha no valide tampoco
                  UtilidadesLog.debug("No valido la fecha en paso 7");
                  bValido = Boolean.valueOf(false);
                }
		}


		UtilidadesLog.info(" MONAptas.validaIngreso(MatrizCursosLocal, oidCliente, oidPeriodo, fechaIngreso): Salida");
		return bValido;
	}

	public DTOClienteSubtipos obtieneClienteSubtipos(Long pais, String codCliente) throws MareException {
		UtilidadesLog.info(" MONAptas.obtieneClienteSubtipos(pais, codigoCliente): Entrada");
		this.validaAcceso(pais,null,null,null,null,null,null,null,null,null,null);
		DTOClienteSubtipos dtoClienteS=new DTOClienteSubtipos();
		DTOCodigoCliente dtoCodCliente= new DTOCodigoCliente();
		dtoCodCliente.setCodigoCliente(codCliente);
		dtoCodCliente.setOidPais(pais);
		/*Se crea DTOCodigoCliente (dto) y se carga con los datos: 
			dto.codCliente = codCliente (parámetro entrada) 
			dto.pais = pais (parámetro de entrada) 

			Se llama al método obtieneClienteSubtiposAptas de la interface
			IMaestroClientes pasándole como entrada dto. 

		El método retorna el DTOClienteSubtipos retornado 
		por el método de la interface invocado. 
*/
		//this.getLog().info("****codCliente= "+ dtoCodCliente.getCodigoCliente());
		//this.getLog().info("****pais= "+ dtoCodCliente.getOidPais());
		MONClientes monClientes = null; //Es un mon de mae
		//DTOSalida dtoSalida = new DTOSalida();
		monClientes = this.getMONClientes();//este ya lanza una Mare
		try  {
			UtilidadesLog.debug("****Entro en monClientes.obtieneClienteSubtiposAptas");
            UtilidadesLog.debug("Parametros obtieneClienteSubtiposAptas: "+dtoCodCliente.getCodigoCliente()+" "+dtoCodCliente.getOidPais());
			dtoClienteS = monClientes.obtieneClienteSubtiposAptas(dtoCodCliente);
			UtilidadesLog.debug("****SAlgo  en monClientes.obtieneClienteSubtiposAptas");
        }catch(MareException e) {
			UtilidadesLog.error("obtieneClientesAsignarAptas: MareException del monclientes, No se encuetra el cliente");
			//	ctx.setRollbackOnly(); es consulta pues no se pone
            //GEN-0007 --> 005
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		}
        catch(RemoteException e) {
			UtilidadesLog.error("obtieneClientesAsignarAptas: RemoteException",e);
			//	ctx.setRollbackOnly(); es consulta pues no se pone
			throw new MareException(e,UtilidadesError.armarCodigoError(
			CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			 
		}
		
		UtilidadesLog.info(" MONAptas.obtieneClienteSubtipos(pais, codigoCliente): Salida");
		return dtoClienteS;
	}

	private void insertaAptaAsignada(DTOAptaAsignada dtoe) throws MareException {
		UtilidadesLog.info(" MONAptas.insertaAptaAsignada(DTOAptaAsignada): Entrada");
		/*Se crea un objeto en la entidad AptasAsignadas 
		Proceso 
		======= 
		Se crea un objeto AptasAsignadas (EJB Entity) con los valores: 

			-AptasAsignadas.oid = generado automáticamente 
			-AptasAsignadas.curso = dtoe.curso 
			-AptasAsignadas.cliente = dtoe.cliente 
			-AptasAsignadas.subtipo = dtoe.subtipo 
			-AptasAsignadas.apta = dtoe.apta 
			-AptasAsignadas.numConvocatoria = dtoe.numConvocatoria 
			-AptasAsignadas.dataMart = dtoe.dataMart
		*/
		this.validaAcceso(dtoe.getOidPais(),null,null,null,null,null,null,null,null,null,null);
		AptasAsignadasLocalHome home=null;
		//AptasAsignadasLocal local=null;
		
		home=new AptasAsignadasLocalHome();
		try{	
			home.create(dtoe.getNumConvocatoria(), //Integer numConvocatoria, 1
						dtoe.getCliente(), 					//Long cliente, 2
						dtoe.getCurso(),					//Long curso, 3
						dtoe.getSubtipo(), 					//Long subtipo,4
						dtoe.getApta(),//.booleanValue(), 		//Boolean apta,5
						dtoe.getDataMart());//.booleanValue(),	// Boolean dataMart,6								// Boolean pruebas 10	
							 		 				
		}catch(PersistenceException ce){
			UtilidadesLog.debug("Posible error de datos. Verificar que no tenemos mas de dos unidades administrativas activas para el mismo cliente.");
            UtilidadesLog.debug("Cliente " + dtoe.getCliente());
			UtilidadesLog.error("insertaAptaAsignada: CreateException",ce);
			ctx.setRollbackOnly();
			throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		}
		
		UtilidadesLog.info(" MONAptas.insertaAptaAsignada(DTOAptaAsignada): Salida");
	}


    private MatrizCursosLocalHome getMatrizCursosLocalHome() throws MareException {
		//final InitialContext context = new InitialContext();
		//return (MatrizCursosLocalHome)context.lookup("java:comp/env/MatrizCursos");
		return (MatrizCursosLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/MatrizCursos");
	}

	 private MONClientes getMONClientes() throws MareException {
        // Se obtiene el interfaz home
		   UtilidadesLog.info(" MONAptas.getMONClientes(): Entrada");		
        MONClientesHome home = (MONClientesHome)UtilidadesEJB.getHome("MONClientes", MONClientesHome.class);
            
        // Se obtiene el interfaz remoto
        MONClientes ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			
			UtilidadesLog.error("*** Error en getMONClientes",e);
			ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info(" MONAptas.getMONClientes(): Salida");		
        return ejb;
	}  
		
	private MONPeriodos getMONPeriodos() throws MareException {
        // Se obtiene el interfaz home
		  UtilidadesLog.info(" MONAptas.getMONPeriodos(): Entrada");		
        MONPeriodosHome home = (MONPeriodosHome)UtilidadesEJB.getHome(
            "MONPeriodos", MONPeriodosHome.class);
            
        // Se obtiene el interfaz remoto
        MONPeriodos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONPeriodos",e);
			ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info(" MONAptas.getMONPeriodos(): Salida");		
        return ejb;
	}   


	private MONValidacion getMONValidacion() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info(" MONAptas.getMONValidacion(): Entrada");		
        MONValidacionHome home = (MONValidacionHome)UtilidadesEJB.getHome(
            "MONValidacion", MONValidacionHome.class);
            
        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONValidacion",e);
			ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info(" MONAptas.getMONValidacion(): Salida");		
        return ejb;
	}	
	private void validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, 
        Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio)
        throws MareException {
        UtilidadesLog.info(" MONAptas.validaAcceso(pais, sociedad, marca, canal, acceso, subacceso, subgerencia, region, zona, seccion, territorio): Entrada");		
        
        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = Boolean.valueOf(true);

        UtilidadesLog.debug("****Llamada a validaAcceso(pais= " + pais + ",sociedad = " + sociedad +
            ", marca=" + marca + ", canal= " + canal + ", acceso=" + acceso + ",subacceso = "
	        + subacceso +  ", subgerencia=" + subgerencia + ", region=" + region + ", zona=" +
            zona + ", seccion=" + seccion + ", territorio=" + territorio);

        try {
            b = monValidacion.validarAccesos(pais, sociedad, marca, canal, acceso,
                    subacceso, subgerencia, region, zona, seccion, territorio);
        } catch (RemoteException rExc) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "**** validaAccesoVinculos: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());

        if (!b.booleanValue()) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "**** validaAccesoVinculos: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
        }

        UtilidadesLog.info(" MONAptas.validaAcceso(pais, sociedad, marca, canal, acceso, subacceso, subgerencia, region, zona, seccion, territorio): Salida");		
    }

		
	
	private Boolean obtieneBoolean(Integer constantes){

		if(constantes.equals(new Integer("0"))){
			return Boolean.FALSE;
		}else{
			if(constantes.equals(new Integer("1"))){
				return Boolean.TRUE;
			}
		}//si no es cero que devuelva true
		return Boolean.TRUE;
		
	}//
	
}//clase MON