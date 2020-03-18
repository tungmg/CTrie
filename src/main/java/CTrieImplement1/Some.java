/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTrieImplement1;

/**
 *
 * @author admin
 * @param <V>
 */
public class Some<V> extends Option<V>{
    final V value;
    public Some(V v) {
        value = v;
    }
    
    public V get() {
        return value;
    }
    
    public boolean nonEmpty () {
        return value != null;
    }
}
