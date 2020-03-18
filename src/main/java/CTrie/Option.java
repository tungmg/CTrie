/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTrie;

/**
 *
 * @author admin
 * @param <V>
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class Option<V> {
    private static final None NONE = new None();
    public static <V> Option<V> makeOption(V o){
        return o != null ? new Some<V>(o) : NONE;
    }

    public static <V> Option<V> makeOption(){
        return NONE;
    }
    public boolean nonEmpty () {
        return false;
    }
}
