package com.josespx.drinkeros.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.josespx.drinkeros.model.TypeDocument;
import com.josespx.drinkeros.service.TypeDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class TypeDocumentController {

    private TypeDocumentService typeDocumentService;

    @Autowired
    public TypeDocumentController(TypeDocumentService typeDocumentService) {
        this.typeDocumentService = typeDocumentService;
    }

    @JsonView(TypeDocument.Basic.class)
    @RequestMapping(value = "/typedocuments/{id}", method = RequestMethod.GET)
    public ResponseEntity<TypeDocument> findById(@PathVariable("id") Long id) {
        TypeDocument typeDocument = this.typeDocumentService.findById(id);
        if (typeDocument == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(typeDocument, HttpStatus.OK);
    }

    @JsonView(TypeDocument.Basic.class)
    @RequestMapping(value = "/typedocuments", method = RequestMethod.GET)
    public ResponseEntity<List<TypeDocument>> findAll() {
        List<TypeDocument> typeDocumentList = this.typeDocumentService.findAll();
        if (typeDocumentList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(typeDocumentList, HttpStatus.OK);
    }


}
