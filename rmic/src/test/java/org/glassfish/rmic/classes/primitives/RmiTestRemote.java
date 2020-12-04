/*
 * Copyright (c) 2018, 2020 Oracle and/or its affiliates.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0, or the Eclipse Distribution License
 * v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License v2.0
 * w/Classpath exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause OR GPL-2.0 WITH
 * Classpath-exception-2.0
 */

package org.glassfish.rmic.classes.primitives;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiTestRemote extends Remote {
	public static final String JNDI_NAME = "IIOP_RmiTestRemote";
	public static final boolean A_BOOLEAN = true;
	public static final char A_CHAR = 'x';
	public static final byte A_BYTE = 0x34;
	public static final short A_SHORT = 12;
	public static final int AN_INT = 17;
	public static final long A_LONG = 1234567;
	public static final float A_FLOAT = 123.5f;
	public static final double A_DOUBLE = 123.567;

   	void test_ping() throws RemoteException;

   	int test_int(int x) throws RemoteException;
}
