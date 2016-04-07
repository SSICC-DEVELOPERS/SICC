/** 
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 * 
 * Autor: Viviana Bongiovanni
 */
public class LPModificarConcursoRanking extends LPSICCBase{

	public LPModificarConcursoRanking(){
		super();
	}

	public void inicio() throws Exception {
		this.pagina("contenido_concurso_ranking_buscar");
	}

	public void ejecucion() throws Exception{

		this.setTrazaFichero();

		try{
		  this.rastreo();
		  this.conectorAction("LPBuscarConcursoRanking");
		  this.conectorActionParametro("opcionMenu", "Modificar Concurso Ranking");
		  this.conectorActionParametro("accion", "");

		}catch(Exception e){
		  traza("Excepcion en LPModificarConcursoRanking: " + e.toString());
		  traza(e);
		  this.lanzarPaginaError(e);
		}
	}

}
