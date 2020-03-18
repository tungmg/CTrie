/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTrie;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 *
 * @author admin
 */
public abstract class MainNode<K, V> extends BasicNode{
    public static final AtomicReferenceFieldUpdater<MainNode, MainNode> updater = 
            AtomicReferenceFieldUpdater.newUpdater (MainNode.class, MainNode.class, "prev");
    public volatile MainNode<K, V> prev = null;

    public abstract int cachedSize (Object ct);

    public boolean CAS_PREV (MainNode<K, V> oldValue, MainNode<K, V> newValue) {
        return updater.compareAndSet (this, oldValue, newValue);
    }

    public void WRITE_PREV (MainNode<K, V> nval) {
        updater.set (this, nval);
    }

    public MainNode<K, V> READ_PREV () {
        return updater.get (this);
    }
}
