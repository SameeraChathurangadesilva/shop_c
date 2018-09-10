package com.intellitection_llc.shop.dao;

import com.intellitection_llc.shop.dto.SuperDTO;

import java.util.ArrayList;

public interface SuperDAO <T extends SuperDTO> {

    public boolean add(T dto)throws Exception;

    public boolean update(T dto)throws Exception;

    public T search(String key)throws Exception;

    public boolean delete(String key)throws  Exception;

    public ArrayList<T> getAll()throws  Exception;
}
