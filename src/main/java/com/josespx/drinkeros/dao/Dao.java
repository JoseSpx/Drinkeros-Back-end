package com.josespx.drinkeros.dao;

import java.util.List;

public interface Dao<Obj, Key> {

    void save(Obj object);
    Obj findById(Key key);
    List<Obj> findAll();
    void delete(Key key);

}
