/*
 * Copyright (c) 1997, 2020 Oracle and/or its affiliates.
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

package org.omg.CORBA;


/**
* The Holder for <tt>LongSeq</tt>.  For more information on 
* Holder files, see <a href="doc-files/generatedfiles.html#holder">
* "Generated Files: Holder Files"</a>.<P>
* org/omg/CORBA/LongSeqHolder.java
* Generated by the IDL-to-Java compiler (portable), version "3.0"
* from streams.idl
* 13 May 1999 22:41:36 o'clock GMT+00:00
*/

public final class LongSeqHolder implements org.omg.CORBA.portable.Streamable
{
    public int value[] = null;

    public LongSeqHolder ()
    {
    }

    public LongSeqHolder (int[] initialValue)
    {
        value = initialValue;
    }

    public void _read (org.omg.CORBA.portable.InputStream i)
    {
        value = org.omg.CORBA.LongSeqHelper.read (i);
    }

    public void _write (org.omg.CORBA.portable.OutputStream o)
    {
        org.omg.CORBA.LongSeqHelper.write (o, value);
    }

    public org.omg.CORBA.TypeCode _type ()
    {
        return org.omg.CORBA.LongSeqHelper.type ();
    }

}
