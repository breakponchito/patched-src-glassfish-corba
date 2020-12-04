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

package org.glassfish.rmic.classes.giopheaderpadding;

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


public class _FooServantPOA_Tie extends Servant implements Tie {
    
    volatile private FooServantPOA target = null;
    
    private static final String[] _type_ids = {
        "RMI:org.glassfish.rmic.classes.giopheaderpadding.Foo:0000000000000000"
    };
    
    public void setTarget(Remote target) {
        this.target = (FooServantPOA) target;
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
            FooServantPOA target = this.target;
            if (target == null) {
                throw new java.io.IOException();
            }
            org.omg.CORBA_2_3.portable.InputStream in = 
                (org.omg.CORBA_2_3.portable.InputStream) _in;
            switch (method.charAt(3)) {
                case 65: 
                    if (method.equals("fooA")) {
                        byte arg0 = in.read_octet();
                        byte result = target.fooA(arg0);
                        OutputStream out = reply.createReply();
                        out.write_octet(result);
                        return out;
                    }
                case 66: 
                    if (method.equals("fooB")) {
                        target.fooB();
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
