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

// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package org.glassfish.rmic.classes.primitives;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.UnexpectedException;
import javax.rmi.CORBA.Stub;
import javax.rmi.CORBA.Util;
import org.omg.CORBA.ORB;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.ApplicationException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.RemarshalException;
import org.omg.CORBA.portable.ResponseHandler;
import org.omg.CORBA.portable.ServantObject;


public class _RmiTestRemote_Stub extends Stub implements RmiTestRemote {
    
    private static final String[] _type_ids = {
        "RMI:org.glassfish.rmic.classes.primitives.RmiTestRemote:0000000000000000"
    };
    
        public String[] _ids() { 
            return (String[]) _type_ids.clone();
        }
        
        public void test_ping() throws java.rmi.RemoteException {
            if (!Util.isLocal(this)) {
                try {
                    org.omg.CORBA.portable.InputStream in = null;
                    try {
                        OutputStream out = _request("test_ping", true);
                        _invoke(out);
                    } catch (ApplicationException ex) {
                        in = ex.getInputStream();
                        String $_id = in.read_string();
                        throw new UnexpectedException($_id);
                    } catch (RemarshalException ex) {
                        test_ping();
                    } finally {
                        _releaseReply(in);
                    }
                } catch (SystemException ex) {
                    throw Util.mapSystemException(ex);
                }
            } else {
                ServantObject so = _servant_preinvoke("test_ping",RmiTestRemote.class);
                if (so == null) {
                    test_ping();
                    return ;
                }
                try {
                    ((RmiTestRemote)so.servant).test_ping();
                } catch (Throwable ex) {
                    Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                    throw Util.wrapException(exCopy);
                } finally {
                    _servant_postinvoke(so);
                }
            }
        }
        
        public int test_int(int arg0) throws java.rmi.RemoteException {
            if (!Util.isLocal(this)) {
                try {
                    org.omg.CORBA.portable.InputStream in = null;
                    try {
                        OutputStream out = _request("test_int", true);
                        out.write_long(arg0);
                        in = _invoke(out);
                        return in.read_long();
                    } catch (ApplicationException ex) {
                        in = ex.getInputStream();
                        String $_id = in.read_string();
                        throw new UnexpectedException($_id);
                    } catch (RemarshalException ex) {
                        return test_int(arg0);
                    } finally {
                        _releaseReply(in);
                    }
                } catch (SystemException ex) {
                    throw Util.mapSystemException(ex);
                }
            } else {
                ServantObject so = _servant_preinvoke("test_int",RmiTestRemote.class);
                if (so == null) {
                    return test_int(arg0);
                }
                try {
                    return ((RmiTestRemote)so.servant).test_int(arg0);
                } catch (Throwable ex) {
                    Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                    throw Util.wrapException(exCopy);
                } finally {
                    _servant_postinvoke(so);
                }
            }
        }
    }
