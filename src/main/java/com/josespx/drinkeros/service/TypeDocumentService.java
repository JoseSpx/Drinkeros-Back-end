package com.josespx.drinkeros.service;

import com.josespx.drinkeros.dao.Dao;
import com.josespx.drinkeros.model.TypeDocument;

import java.util.List;

public interface TypeDocumentService extends Dao<TypeDocument, Long> {

    @Override
    void save(TypeDocument typeDocument);

    @Override
    TypeDocument findById(Long id);

    @Override
    List<TypeDocument> findAll();

    @Override
    void delete(Long id);
}
