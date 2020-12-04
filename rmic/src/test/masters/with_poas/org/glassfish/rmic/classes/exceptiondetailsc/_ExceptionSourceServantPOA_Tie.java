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

package org.glassfish.rmic.classes.exceptiondetailsc;

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
import org.omg.PortableServer.Servant;


public class _ExceptionSourceServantPOA_Tie extends Servant implements Tie {
    
    volatile private ExceptionSourceServantPOA target = null;
    
    private static final String[] _type_ids = {
        "RMI:org.glassfish.rmic.classes.exceptiondetailsc.ExceptionSource:0000000000000000"
    };
    
    public void setTarget(Remote target) {
        this.target = (ExceptionSourceServantPOA) target;
    }
    
    public Remote getTarget() {
        return target;
    }
    
    public org.omg.CORBA.Object thisObject() {
        return _this_object();
    }
    
    public void deactivate() {
        try{
        _poa().deactivate_object(_poa().servant_to_id(this));
        }catch (org.omg.PortableServer.POAPackage.WrongPolicy exception){
        
        }catch (org.omg.PortableServer.POAPackage.ObjectNotActive exception){
        
        }catch (org.omg.PortableServer.POAPackage.ServantNotActive exception){
        
        }
    }
    
    public ORB orb() {
        return _orb();
    }
    
    public void orb(ORB orb) {
        try {
            ((org.omg.CORBA_2_3.ORB)orb).set_delegate(this);
        }
        catch(ClassCastException e) {
            throw new org.omg.CORBA.BAD_PARAM
                ("POA Servant requires an instance of org.omg.CORBA_2_3.ORB");
        }
    }
    
    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] objectId){
        return (String[]) _type_ids.clone();
    }
    
    public OutputStream  _invoke(String method, InputStream _in, ResponseHandler reply) throws SystemException {
        try {
            ExceptionSourceServantPOA target = this.target;
            if (target == null) {
                throw new java.io.IOException();
            }
            org.omg.CORBA_2_3.portable.InputStream in = 
                (org.omg.CORBA_2_3.portable.InputStream) _in;
            switch (method.length()) {
                case 18: 
                    if (method.equals("raiseUserException")) {
                        String arg0 = (String) in.read_value(String.class);
                        try {
                            target.raiseUserException(arg0);
                        } catch (RmiIException ex) {
                            String id = "IDL:org/glassfish/rmic/classes/exceptiondetailsc/RmiIEx:1.0";
                            org.omg.CORBA_2_3.portable.OutputStream out = 
                                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
                            out.write_string(id);
                            out.write_value(ex,RmiIException.class);
                            return out;
                        }
                        OutputStream out = reply.createReply();
                        return out;
                    }
                case 20: 
                    if (method.equals("raiseSystemException")) {
                        String arg0 = (String) in.read_value(String.class);
                        target.raiseSystemException(arg0);
                        OutputStream out = reply.createReply();
                        return out;
                    }
                case 21: 
                    if (method.equals("raiseRuntimeException")) {
                        String arg0 = (String) in.read_value(String.class);
                        target.raiseRuntimeException(arg0);
                        OutputStream out = reply.createReply();
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
