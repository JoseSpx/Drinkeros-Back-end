package com.josespx.drinkeros.service;

import com.josespx.drinkeros.dao.TypeDocumentDao;
import com.josespx.drinkeros.model.TypeDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TypeDocumentServiceImpl implements TypeDocumentService {

    private TypeDocumentDao typeDocumentDao;

    @Autowired
    public TypeDocumentServiceImpl(TypeDocumentDao typeDocumentDao) {
        this.typeDocumentDao = typeDocumentDao;
    }

    @Override
    public void save(TypeDocument typeDocument) {
        this.typeDocumentDao.save(typeDocument);
    }

    @Override
    public TypeDocument findById(Long id) {
        return this.typeDocumentDao.findById(id).orElse(null);
    }

    @Override
    public List<TypeDocument> findAll() {
        return this.typeDocumentDao.findAll();
    }

    @Override
    public void delete(Long id) {
        this.typeDocumentDao.deleteById(id);
    }
}
