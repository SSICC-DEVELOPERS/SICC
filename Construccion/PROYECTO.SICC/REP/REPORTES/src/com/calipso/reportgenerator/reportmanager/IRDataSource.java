package com.calipso.reportgenerator.reportmanager;

import java.util.Collection;

import es.indra.mare.common.info.InfoException;

/**
 * IRDataSource
 *  
 *
 */
public interface IRDataSource {
	
	/**
	 * Devuleve el valor indicado en la fila y la columna.
	 * @param row
	 * @param col
	 * @return
	 */
	public Object getValueAt(int row, int col);// throws InfoException;

	/**
	 * Agrega una fila a la coleccion principal
	 * @param row
	 * @throws InfoException
	 */
	public void addRow(Collection row) throws InfoException;

	/**
	 * Devuelve una coleccion que representa la fila indicada.
	 * @param row
	 * @return
	 * @throws InfoException
	 */
	public Collection getRowValues(int row) throws InfoException;

	/**
	 * Debuelve el nombre de la columna.
	 * @param index
	 * @return
	 */
	public String getColumName(int index);// throws InfoException;

	/**
	 * Setea el nombre de la columna indicada
	 * @param index
	 * @param name
	 * @throws InfoException
	 */
	public void setColumName(int index, String name) throws InfoException;

	/**
	 * Cuenta la cantidad de columnas.
	 * @return
	 */
	public int getColumCount();// throws InfoException;

	/**
	 * Cuenta la canidad de filas
	 * @return
	 */
	public int getRowCount();
}