/*******************************************************************************
 * Copyright (c) 2012 Neil Bartlett.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Neil Bartlett - initial API and implementation
 ******************************************************************************/
package org.bndtools.rt.repository.marshall;

public enum ScalarType {
	String, Version, Long, Double;

	public Object parseString(String input) {
		Object result;

		switch (this) {
			case String :
				result = input;
				break;
			case Long :
				result = java.lang.Long.parseLong(input.trim());
				break;
			case Double :
				result = java.lang.Double.parseDouble(input.trim());
				break;
			case Version :
				result = org.osgi.framework.Version.parseVersion(input.trim());
				break;
			default :
				throw new IllegalArgumentException("Cannot parse input for unknown attribute type '" + name() + "'");
		}

		return result;
	}
}
