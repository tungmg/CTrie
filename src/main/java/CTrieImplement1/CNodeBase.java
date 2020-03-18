/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTrieImplement1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 *
 * @author admin
 */
abstract class CNodeBase<K, V> extends MainNode<K, V>{
    @SuppressWarnings("rawtypes")
    private static final AtomicIntegerFieldUpdater<CNodeBase> UPDATER = 
            AtomicIntegerFieldUpdater.newUpdater(CNodeBase.class, "csize");
    
    private volatile int csize = -1;
    
    public boolean CAS_SIZE(int oldValue, int newValue) {
        return UPDATER.compareAndSet(this, oldValue, newValue);
    }
    
    public void WRITE_SIZE(int nval) {
        UPDATER.set(this, nval);
    }
    
    public int READ_SIZE() {
        return csize;
    }
}
