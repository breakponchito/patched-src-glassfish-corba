/*
 * Copyright (c) 2020 Oracle and/or its affiliates. All rights reserved.
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

package org.omg.CORBA.InterfaceDefPackage;

/**
* org/omg/CORBA/InterfaceDefPackage/FullInterfaceDescription.java .
* IGNORE Generated by the IDL-to-Java compiler (portable), version "3.2"
* from idlj/src/main/java/com/sun/tools/corba/ee/idl/ir.idl
* IGNORE Sunday, January 21, 2018 1:54:23 PM EST
*/

public final class FullInterfaceDescription implements org.omg.CORBA.portable.IDLEntity
{
  public String name = null;
  public String id = null;
  public String defined_in = null;
  public String version = null;
  public boolean is_abstract = false;
  public org.omg.CORBA.OperationDescription operations[] = null;
  public org.omg.CORBA.AttributeDescription attributes[] = null;
  public String base_interfaces[] = null;
  public org.omg.CORBA.TypeCode type = null;

  public FullInterfaceDescription ()
  {
  } // ctor

  public FullInterfaceDescription (String _name, String _id, String _defined_in, String _version, boolean _is_abstract, org.omg.CORBA.OperationDescription[] _operations, org.omg.CORBA.AttributeDescription[] _attributes, String[] _base_interfaces, org.omg.CORBA.TypeCode _type)
  {
    name = _name;
    id = _id;
    defined_in = _defined_in;
    version = _version;
    is_abstract = _is_abstract;
    operations = _operations;
    attributes = _attributes;
    base_interfaces = _base_interfaces;
    type = _type;
  } // ctor

} // class FullInterfaceDescription
