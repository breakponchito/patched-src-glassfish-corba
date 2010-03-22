/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 *
 * Contributor(s):
 *
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package com.sun.corba.se.impl.encoding.fast.bytebuffer ;

import java.nio.ByteBuffer ;

/** Base class for implementing an Allocator.
 * All subclasses must implement dispose, releaseSlab and obtainSlab, as well as the undefined
 * methods in the Allocator interface: maxAllocationSize, bufferType, and close.
 * This class handles allocation of BufferWrappers from the current Slab.
 */
public abstract class AllocatorBase implements Allocator {
    // Typically an Allocator is used by only one thread, so it is not necessary
    // to synchronize the methods of an Allocator.
    private int headerSize ;
    private Slab currentSlab ;
    private boolean closed = false ;

    protected final void checkClosed() {
        if (closed) {
            throw new IllegalStateException( "Allocator is closed" ) ;
        }
    }

    AllocatorBase( int headerSize ) {
        this.headerSize = headerSize ;

        currentSlab = obtainSlab() ;
    }

    public final int headerSize() {
        checkClosed() ;
        return headerSize ;
    }

    // Used only by BufferWrapperImpl
    abstract void dispose( Slab slab, ByteBuffer store ) ;

    abstract void releaseSlab( Slab slab ) ;

    abstract Slab obtainSlab() ; 

    public final BufferWrapper allocate( int size ) {
        checkClosed() ;

        if (size > maxAllocationSize()) {
            throw new IllegalArgumentException( "Request size " + size 
                + " is larger than maximum allocation size " + maxAllocationSize() ) ;
        }

        if (currentSlab.sizeAvailable() < (size + headerSize)) {
            currentSlab.markFull() ;
            releaseSlab( currentSlab ) ;
            currentSlab = obtainSlab() ;
        }

        BufferWrapper result = new BufferWrapper( this, currentSlab, headerSize, size ) ;
        return result ;
    }

    public final BufferWrapper allocate( int minSize, int maxSize ) {
        checkClosed() ;

        if (minSize > maxAllocationSize()) {
            throw new IllegalArgumentException( "Minimum request size " + minSize 
                + " is larger than maximum allocation size " + maxAllocationSize() ) ;
        }

        int remaining = currentSlab.sizeAvailable() - headerSize ; 
        int allocSize = maxSize ;
        if ((remaining >= minSize) && (remaining <= maxSize)) {
            allocSize = remaining ;
        }

        return allocate( allocSize ) ;
    }

    public final void close() {
        checkClosed() ;
        releaseSlab( currentSlab ) ;
        closed = true ;
    }
}
