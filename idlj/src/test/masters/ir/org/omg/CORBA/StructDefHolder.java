package org.omg.CORBA;

/**
* org/omg/CORBA/StructDefHolder.java .
* IGNORE Generated by the IDL-to-Java compiler (portable), version "3.2"
* from idlj/src/main/java/com/sun/tools/corba/ee/idl/ir.idl
* IGNORE Sunday, January 21, 2018 1:54:23 PM EST
*/

public final class StructDefHolder implements org.omg.CORBA.portable.Streamable
{
  public org.omg.CORBA.StructDef value = null;

  public StructDefHolder ()
  {
  }

  public StructDefHolder (org.omg.CORBA.StructDef initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.omg.CORBA.StructDefHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.omg.CORBA.StructDefHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.omg.CORBA.StructDefHelper.type ();
  }

}
