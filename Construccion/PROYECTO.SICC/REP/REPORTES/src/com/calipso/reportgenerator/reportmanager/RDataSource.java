package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.common.LanguageTraslator;

import java.util.Collection;
import java.util.Vector;
import java.util.Iterator;

import es.indra.mare.common.info.InfoException;

/**
 * Almacena y permite modificar datos en una matriz de objetos de dos
 * dimensiones. 
 * Sólo permite introducir valores fila a fila. 
 * No permite introducir filas de longitud variable. 
 * El nombre de las columnas tienen que ser objetos de tipo String 
 * y no pueden ser valores nulos 
 * El objeto DataSource se contruye a partir de un número de columnas 
 * o a partir de una collection de strings que identifica los nombres de cada columna.
 * 
 */
public class RDataSource implements IRDataSource {
	
	/**
	 * Nombres de las columnas.
	 */
	private Vector names;

	private Vector rows;

	private int columsCount = 0;

	private final String COLUMNS_DEFAULT_NAME = "NONAME";

	/**
	 * Inicializa el objeto matriz de dos dimensiones con el número de columnas
	 * indicado en el parámetro No se indica nombre para las columnas.
	 * 
	 * @param columns -
	 *            número de columnas
	 * @throws InfoException -
	 *             Si el número de columnas es <= 0
	 */
	public RDataSource(int columns) throws InfoException {
		if (columns <= 0) {
			throw new InfoException(
					"INFO - No se puede crear una matriz DataSource. "
							+ columns + "<=0");
		} else {
			this.columsCount = columns;
			this.names = this
					.generateVector(this.COLUMNS_DEFAULT_NAME, columns);
			this.rows = new Vector(this.columsCount);
		}
	}

	/**
	 * Inicializa el objeto matriz de dos dimensiones con el mismo número de
	 * columnas que el tamaño de la collection de nombres. El nombre de las
	 * columnas es el que se indica en el parámetro names manteniendo el orden.
	 * 
	 * @param names -
	 *            Nombres de las columnas
	 * @throws InfoException -
	 *             Si la colección de nombre es nula, contiene elementos nulos o
	 *             no contiene objetos de tipo String
	 */
	public RDataSource(Collection names) throws InfoException {
		if (names == null) {
			throw new InfoException(
					"INFO - No se puede construir una matriz DataSource a partir de una colección de nombres nula");
		} else if (this.namesEmpty(names)) {
			throw new InfoException(
					"INFO - No se puede construir una matriz DataSource a partir de un names vacío");
		} else if (this.namesWithNullElements(names)) {
			throw new InfoException(
					"INFO - No se puede construir una matriz DataSource con elementos null en los nombres");
		} else if (this.namesWithNoStringElements(names)) {
			throw new InfoException(
					"INFO - No se puede construir una matriz DataSource con nombres que no son de tipo String");
		} else {
			this.columsCount = names.size();
			this.names = new Vector(names);
			this.rows = new Vector(this.columsCount);
		}

	}

	/**
	 * Devuelve el número de filas de esta matriz de objetos
	 * 
	 * @return número de filas
	 */
	public int getRowCount() {
		return this.rows.size();
	}

	/**
	 * Devuelve el número de columnas de esta matriz de objetos
	 * 
	 * @return número de columnas
	 */
	public int getColumCount() {
		return this.columsCount;
	}

	/**
	 * Devuelve el nombre de la columna
	 * 
	 * @param colum -
	 *            número de columna
	 * @return Nombre de la columna
	 * @throws IndexOutOfBoundsException -
	 *             Si la posición solicitada no se encuadra en las dimensiones
	 *             de la matriz
	 */
	public String getColumName(int colum) throws IndexOutOfBoundsException {
		if (!this.validateColumNumber(colum)) {
			throw new IndexOutOfBoundsException(
					"INFO - La columna "
							+ colum
							+ " esta fuera de las coordenadas de este DataSource. Rango permitido [0.."
							+ (this.columsCount - 1) + "]");
		} else {
			return this.names.elementAt(colum).toString();
		}
	}

	/**
	 * Asigna un nombre a una columna
	 * 
	 * @param colum -
	 *            número de columna
	 * @param name -
	 *            nombre que se asigna a la columna
	 * @throws IndexOutOfBoundsException -
	 *             Si la posición solicitada no se encuadra en las dimensiones
	 *             de la matriz
	 * @throws InfoException -
	 *             Si el nombre que se desea asignar a la columna es null
	 */
	public void setColumName(int colum, String name)
			throws IndexOutOfBoundsException, InfoException {
		if (!this.validateColumNumber(colum)) {
			throw new IndexOutOfBoundsException(
					"INFO - La columna "
							+ colum
							+ " esta fuera de las coordenadas de este DataSource. Rango permitido [0.."
							+ (this.columsCount - 1) + "]");
		} else if (name == null) {
			throw new InfoException(
					"INFO - Las columnas no permiten valores nulos");
		} else {
			this.names.setElementAt(name, colum);
		}
	}

	/**
	 * Devuelve el objeto posicionado en la fila y columna especificada
	 * 
	 * @param row -
	 *            Número de fila
	 * @param colum -
	 *            Número de columna
	 * @return Object posicionado en la fila row y columna colum
	 * @throws IndexOutOfBoundsException -
	 *             Si la posición solicitada no se encuadra en las dimensiones
	 *             de la matriz
	 */
	public Object getValueAt(int row, int colum)
			throws IndexOutOfBoundsException {
		if (this.validateRowNumber(row) && this.validateColumNumber(colum)) {
			return ((Vector) this.rows.elementAt(row)).elementAt(colum);
		} else {
			throw new IndexOutOfBoundsException(
					"INFO - La fila "
							+ row
							+ " y la columna "
							+ colum
							+ " esta fuera de las coordenadas de este DataSource. Rango permitido [0.."
							+ (this.getRowCount() - 1) + "],[0.."
							+ (this.columsCount - 1) + "]");
		}
	}

	/**
	 * Devuelve los objetos posicionados en la columna especificada
	 * 
	 * @param colum -
	 *            número de columna
	 * @return Collection con los objetos seleccionados
	 * @throws IndexOutOfBoundsException -
	 *             Si la posición solicitada no se encuadra en las dimensiones
	 *             de la matriz
	 */
	public Collection getColumValues(int colum)
			throws IndexOutOfBoundsException {
		if (this.validateColumNumber(colum)) {
			Vector data;
			Vector values = new Vector();

			for (int i = 0; i < this.rows.size(); i++) {
				data = (Vector) this.rows.elementAt(i);
				values.addElement(data.elementAt(colum));
			}

			return values;
		} else {
			throw new IndexOutOfBoundsException(
					"INFO - La columna "
							+ colum
							+ " esta fuera de las coordenadas de este DataSource. Rango permitido [0.."
							+ (this.columsCount - 1) + "]");
		}
	}

	/**
	 * Devuelve los objetos posicionados en la columna especificada
	 * 
	 * @param row -
	 *            número de fila
	 * @return Collection con los objetos seleccionados
	 * @throws IndexOutOfBoundsException -
	 *             Si la posición solicitada no se encuadra en las dimensiones
	 *             de la matriz
	 */
	public Collection getRowValues(int row) throws IndexOutOfBoundsException {
		if (this.validateRowNumber(row)) {
			return (Vector) this.rows.elementAt(row);
		} else {
			throw new IndexOutOfBoundsException(
					"INFO - La fila "
							+ row
							+ " esta fuera de las coordenadas de este DataSource. Rango permitido [0.."
							+ (this.getRowCount() - 1) + "]");
		}
	}

	/**
	 * Modifica el objeto posicionado en la coordenada solicitada
	 * 
	 * @param row -
	 *            número de fila
	 * @param colum -
	 *            número de columna
	 * @param newValue -
	 *            nuevo valor a posicionar en la coordenada solicitada
	 * @throws IndexOutOfBoundsException -
	 *             Si la posición solicitada no se encuadra en las dimensiones
	 *             de la matriz
	 */
	public void updateValueAt(int row, int colum, Object newValue)
			throws IndexOutOfBoundsException {
		if (this.validateRowNumber(row) && this.validateColumNumber(colum)) {
			((Vector) this.rows.elementAt(row)).setElementAt(newValue, colum);
		} else {
			throw new IndexOutOfBoundsException(
					"INFO - La fila "
							+ row
							+ " y la columna "
							+ colum
							+ " esta fuera de las coordenadas de este DataSource. Rango permitido [0.."
							+ (this.getRowCount() - 1) + "],[0.."
							+ (this.columsCount - 1) + "]");
		}
	}

	/**
	 * Añade una nueva fila a la matriz
	 * 
	 * @param row -
	 *            Fila a insertar
	 * @throws InfoException -
	 *             Si la fila que se desea introducir no tiene el mismo número
	 *             de columnas que la matriz
	 */
	public void addRow(Collection row) throws InfoException {
		if (row == null) {
			throw new InfoException(LanguageTraslator.traslate("380"));
		} else if (row.size() != this.columsCount) {
			throw new InfoException(LanguageTraslator.traslate("381")
					+ this.columsCount + LanguageTraslator.traslate("382")
					+ row.size());
		} else {
			this.rows.addElement(new Vector(row));
		}
	}

	/**
	 * Genera un vector de tamaño elements con elementos value
	 * 
	 * @param value -
	 *            Valor que se quiere replicar en el vector
	 * @param elements -
	 *            número de elementos que se desea que tenga el vector
	 * @return Vector de tamañan elements con valores value
	 */
	private Vector generateVector(Object value, int elements) {
		Vector vector = new Vector();

		for (int i = 0; i < elements; i++) {
			vector.addElement(value);
		}
		return vector;
	}

	/**
	 * Valida que el número de columna esté en el rango permitido. El rango
	 * deberá estar comprendido entre [1..n]
	 * 
	 * @param number -
	 *            número de columna
	 * @return true si el número de columna es válido. False en caso contrario
	 */
	private boolean validateColumNumber(int number) {
		if ((number < 0) || (number >= this.columsCount)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Valida que el número de fila esté en el rango permitido. El rango deberá
	 * estar comprendido entre [1..n]
	 * 
	 * @param number -
	 *            número de fila
	 * @return true si el número de fila es válido. False en caso contrario
	 */
	private boolean validateRowNumber(int number) {
		if ((number < 0) || (number >= this.rows.size())) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Valida que la collection no sea vacía
	 * 
	 * @param coll -
	 *            Collection a evaluar
	 * @return true si es vacia, false en caso contrario
	 */
	private boolean namesEmpty(Collection coll) {
		return coll.isEmpty();
	}

	/**
	 * Valida que la collection de nombres no contiene elementos nulos.
	 * 
	 * @param coll -
	 *            Collection a evaluar
	 * @return true si contiene elementos nulos, false en caso contrario.
	 */
	private boolean namesWithNullElements(Collection coll) {
		boolean withNulls = false;

		Iterator it = coll.iterator();

		while ((it.hasNext()) && (!withNulls)) {
			if (it.next() == null) {
				withNulls = true;
			}
		}
		return withNulls;
	}

	/**
	 * Valida que la collection tenga elementos de tipo String.
	 * 
	 * @param coll -
	 *            Collection a evaluar
	 * @return true si la collection contiene objetos que no sean de tipo
	 *         String, false si todos son de tipo String
	 */
	private boolean namesWithNoStringElements(Collection coll) {
		boolean withNoStringElements = false;

		Iterator it = coll.iterator();

		while ((it.hasNext()) && (!withNoStringElements)) {
			if (!(it.next() instanceof String)) {
				withNoStringElements = true;
			}
		}
		return withNoStringElements;
	}

}
