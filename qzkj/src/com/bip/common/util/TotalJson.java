package com.bip.common.util;

import java.util.List;
import net.sf.json.JSONArray;

/**
 * @description: Interface for the page utils
 * @copyright: Copyright (c) 2009
 * @author cheng fengling
 * @version 1.0
 */
public class TotalJson {
	private int results;
	private List items;

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}

	public int getResults() {
		return results;
	}

	public void setResults(int results) {
		this.results = results;
	}

	public String toString(int total) {
		String jsonList = (items instanceof JSONArray) ? items.toString()
				: JSONArray.fromObject(items).toString();
		return new StringBuffer("{\"total\":").append(total).append(",\"rows\":").append(jsonList).append("}").toString();
	}
}
