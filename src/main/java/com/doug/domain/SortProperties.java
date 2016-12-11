package com.doug.domain;

/**
 * Created by Doug on 12/10/16.
 */
public class SortProperties {

	private String sortColumn;
	private String sortDirection;

	public String getsortColumn() {
		return sortColumn;
	}

	public void setsortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public String getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(String sortDirection) {
		this.sortDirection = sortDirection;
	}
}
