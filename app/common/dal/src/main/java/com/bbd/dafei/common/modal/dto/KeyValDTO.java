package com.bbd.dafei.common.modal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Ian.Su
 * @version $Id: KeyValDTO.java, v 0.1 2017/4/19 18:29 Ian.Su Exp $
 */
@ApiModel(value = "键值对数据")
public class KeyValDTO<K,V> {

    @ApiModelProperty("键")
    private K k;

    @ApiModelProperty("值")
    private V v;


    public KeyValDTO(){

    }

    public KeyValDTO(K k,V v){
        setK(k);
        setV(v);
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}
