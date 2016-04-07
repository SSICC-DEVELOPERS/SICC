package com.calipso.reportgenerator.services;

import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * DataSourceDefinitionConnectionString Esta clase contine la información del
 * Exernal Connection String del data source definition del data source
 */
public class DataSourceDefinitionConnectionString {

	private Map values;

	private String connectionString = "";

	public DataSourceDefinitionConnectionString(Map values) {
		if (values.containsKey("ExternalConnectionString")) {
			if (values.get("ExternalConnectionString") != null) {
				this.connectionString = values.get("ExternalConnectionString")
						.toString();
				initValuesFromString();
			}
		}
		if (this.connectionString.equals("")) {
			getValues().putAll(values);
		}

	}

	/**
	 * Carga los values parseando los valores del connectionString
	 */
	private void initValuesFromString() {
		String set;
		String key;
		String value;
		int index;
		StringTokenizer stringTokenizer = new StringTokenizer(
				this.connectionString, ";");
		for (int i = 0; stringTokenizer.hasMoreTokens(); i++) {
			set = stringTokenizer.nextToken();
			index = set.indexOf("=");
			key = set.substring(0, index);
			value = set.substring(index + 1, set.length());
			getValues().put(key, value);
		}

	}

	/**
	 * getValues()
	 * 
	 * @return Map
	 */
	public Map getValues() {
		if (values == null) {
			values = new HashMap();
		}
		return values;
	}

	/**
	 * Retorna el valor de una entrada
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		String returnString = "";
		if (getValues().containsKey(key)) {
			returnString = (String) getValues().get(key);
		}
		return returnString;
	}
}
