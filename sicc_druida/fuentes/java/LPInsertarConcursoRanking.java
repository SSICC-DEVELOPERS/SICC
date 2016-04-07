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
public class LPInsertarConcursoRanking extends LPSICCBase{

	public LPInsertarConcursoRanking(){
		super();
	}

	public void inicio() throws Exception {
		this.pagina("contenido_concurso_ranking_insertar");
	}

	public void ejecucion() throws Exception{

		this.setTrazaFichero();

		try{
		  this.rastreo();
		  this.conectorAction("LPMantenerConcursosRanking");
		  this.conectorActionParametro("opcionMenu", "Crear Concurso Ranking");
		  this.conectorActionParametro("accion", "");

		}catch(Exception e){
		  traza("Excepcion en LPInsertarConcursoRanking: " + e.toString());
		  traza(e);
		  this.lanzarPaginaError(e);
		}
	}

}
