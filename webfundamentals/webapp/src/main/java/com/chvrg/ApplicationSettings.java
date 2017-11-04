package com.chvrg;

import java.util.List;

public class ApplicationSettings {

	private CssClass formClass;
	private List<Tab> tabs;

	public CssClass getFormClass() {
		return formClass;
	}

	public void setFormClass(CssClass formClass) {
		this.formClass = formClass;
	}

	public List<Tab> getTabs() {
		return tabs;
	}

	public void setTabs(List<Tab> tabs) {
		this.tabs = tabs;
	}
	
}
