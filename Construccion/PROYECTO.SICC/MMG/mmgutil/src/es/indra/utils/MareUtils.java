/*
 * Created on 27-may-2004
 *
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
package es.indra.utils;

import javax.naming.Context;
import javax.naming.InitialContext;

import es.indra.mare.enterprise.mln.BusinessFacade;
import es.indra.mare.enterprise.mln.BusinessFacadeHome;
import es.indra.mare.enterprise.mln.BusinessFacadeLocal;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;

/**
 * @author gogomez
 *
 */
public class MareUtils {
	/**
	 * Constante que define el nombre jndi del BusinessFacade local
	 */
	protected static final String BUSINESS_FACADE_JNDI_LOCAL = "java:comp/env/mare.mln.LocalBusinessFacade";
	
	/**
	 * Constante que define el nombre jndi del BusinessFacade local
	 */
	protected static final String BUSINESS_FACADE_JNDI_REMOTE = "mare.mln.BusinessFacade";
	
	/**
	 * El contexto local cacheado para no tener que sacarlo cada vez que se hace una petición
	 */
	protected static Context localContext = null;
	
	/**
	 * Nos permite obtener la instancia local del BusinessFacade
	 * @return el local del BusinessFacade
	 */
	public static BusinessFacadeLocal getLocalBusinessFacade(){
		BusinessFacadeLocal bf = null;
		try{
			if(localContext == null) initLocalContext();
			BusinessFacadeLocalHome home = (BusinessFacadeLocalHome)localContext.lookup(BUSINESS_FACADE_JNDI_LOCAL);
			bf = home.create();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bf;
	}
	
	/**
	 * Nos permite obtener la instacia remota del BusinessFacade
	 * @return el remote del BusinessFacade
	 */
	public static BusinessFacade getRemoteBusinessFacade(){
		BusinessFacade bf = null;
		try{
			if(localContext == null) initLocalContext();
			BusinessFacadeHome home = (BusinessFacadeHome)localContext.lookup(BUSINESS_FACADE_JNDI_REMOTE);
			bf  = home.create(); 
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bf;
	}
	
	/**
	 * Nos permite crear el initial context local
	 *
	 */
	protected static void initLocalContext(){
		try{
			if(localContext == null) localContext =  new InitialContext();
		}catch(Exception e){
			e.printStackTrace();			
		}
	}
}
