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

// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package org.glassfish.rmic.classes.hcks;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.rmi.CORBA.Tie;
import javax.rmi.CORBA.Util;
import org.omg.CORBA.BAD_OPERATION;
import org.omg.CORBA.ORB;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;
import org.omg.CORBA.portable.UnknownException;
import org.omg.CORBA_2_3.portable.ObjectImpl;


public class _RmiIIServant_Tie extends ObjectImpl implements Tie {
    
    volatile private RmiIIServant target = null;
    
    private static final String[] _type_ids = {
        "RMI:org.glassfish.rmic.classes.hcks.RmiII:0000000000000000"
    };
    
    public void setTarget(Remote target) {
        this.target = (RmiIIServant) target;
    }
    
    public Remote getTarget() {
        return target;
    }
    
    public org.omg.CORBA.Object thisObject() {
        return this;
    }
    
    public void deactivate() {
        _orb().disconnect(this);
        _set_delegate(null);
        target = null;
    }
    
    public ORB orb() {
        return _orb();
    }
    
    public void orb(ORB orb) {
        orb.connect(this);
    }
    
    public String[] _ids() { 
        return (String[]) _type_ids.clone();
    }
    
    public OutputStream  _invoke(String method, InputStream _in, ResponseHandler reply) throws SystemException {
        try {
            RmiIIServant target = this.target;
            if (target == null) {
                throw new java.io.IOException();
            }
            org.omg.CORBA_2_3.portable.InputStream in = 
                (org.omg.CORBA_2_3.portable.InputStream) _in;
            switch (method.length()) {
                case 8: 
                    if (method.equals("sayHello")) {
                        String result = target.sayHello();
                        org.omg.CORBA_2_3.portable.OutputStream out = 
                            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
                        out.write_value(result,String.class);
                        return out;
                    }
                case 9: 
                    if (method.equals("sendBytes")) {
                        byte[] arg0 = (byte[]) in.read_value(byte[].class);
                        int result = target.sendBytes(arg0);
                        OutputStream out = reply.createReply();
                        out.write_long(result);
                        return out;
                    }
                case 13: 
                    if (method.equals("sendOneObject")) {
                        Object arg0 = Util.readAny(in);
                        Object result;
                        try {
                            result = target.sendOneObject(arg0);
                        } catch (RmiIMyException ex) {
                            String id = "IDL:org/glassfish/rmic/classes/hcks/RmiIMyEx:1.0";
                            org.omg.CORBA_2_3.portable.OutputStream out = 
                                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
                            out.write_string(id);
                            out.write_value(ex,RmiIMyException.class);
                            return out;
                        }
                        OutputStream out = reply.createReply();
                        Util.writeAny(out,result);
                        return out;
                    }
                case 14: 
                    if (method.equals("sendTwoObjects")) {
                        Object arg0 = Util.readAny(in);
                        Object arg1 = Util.readAny(in);
                        Object result = target.sendTwoObjects(arg0, arg1);
                        OutputStream out = reply.createReply();
                        Util.writeAny(out,result);
                        return out;
                    }
                case 22: 
                    if (method.equals("returnObjectFromServer")) {
                        boolean arg0 = in.read_boolean();
                        Object result = target.returnObjectFromServer(arg0);
                        OutputStream out = reply.createReply();
                        Util.writeAny(out,result);
                        return out;
                    }
                case 24: 
                    if (method.equals("colocatedCallFromServant")) {
                        String arg0 = (String) in.read_value(String.class);
                        String result = target.colocatedCallFromServant(arg0);
                        org.omg.CORBA_2_3.portable.OutputStream out = 
                            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
                        out.write_value(result,String.class);
                        return out;
                    }
                case 25: 
                    if (method.equals("throwThreadDeathInServant")) {
                        String arg0 = (String) in.read_value(String.class);
                        String result = target.throwThreadDeathInServant(arg0);
                        org.omg.CORBA_2_3.portable.OutputStream out = 
                            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
                        out.write_value(result,String.class);
                        return out;
                    }
                case 28: 
                    if (method.equals("makeColocatedCallFromServant")) {
                        String result = target.makeColocatedCallFromServant();
                        org.omg.CORBA_2_3.portable.OutputStream out = 
                            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
                        out.write_value(result,String.class);
                        return out;
                    }
            }
            throw new BAD_OPERATION();
        } catch (SystemException ex) {
            throw ex;
        } catch (Throwable ex) {
            throw new UnknownException(ex);
        }
    }
}
