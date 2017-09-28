/*******************************************************************************
 * Copyright (c) 2012, 2017 Pivotal, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Pivotal, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.eclipse.beans.ui.live.model;

import java.util.Map;

/**
 * A wrapper around a {@link LiveBean} used by the
 * {@link LiveBeansTreeContentProvider} for displaying bean relationships
 * without nesting.
 * 
 * @author Leo Dos Santos
 * @author Alex Boyko
 */
public class LiveBeanRelation extends AbstractLiveBeansModelElement {

	private final LiveBean bean;

	private final boolean isDependency;

	public LiveBeanRelation(LiveBean bean) {
		this(bean, false);
	}

	public LiveBeanRelation(LiveBean bean, boolean isDependency) {
		super();
		this.bean = bean;
		this.isDependency = isDependency;
	}

	@Override
	public void addAttribute(String key, String value) {
		// no-op
	}

	@Override
	public Map<String, String> getAttributes() {
		return bean.getAttributes();
	}

	public String getDisplayName() {
		String label = bean.getDisplayName();
		if (isDependency) {
			return "Depends on: " + label;
		}
		else {
			return "Injected into: " + label;
		}
	}

	public boolean isDependency() {
		return isDependency;
	}

	public boolean isInnerBean() {
		return bean.isInnerBean();
	}

}