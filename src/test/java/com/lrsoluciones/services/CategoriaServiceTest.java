package com.lrsoluciones.services;

import com.lrsoluciones.models.Categoria;
import com.lrsoluciones.repositories.CategoriaRepository;
import com.lrsoluciones.resources.request.CategoriaRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoriaServiceTest {

    CategoriaRequest categoriaRequest;
    ResponseEntity <?> responseEntity;
    @Mock
    CategoriaRepository categoriaRepository;

    @InjectMocks
    CategoriaService categoriaService;

    @BeforeEach
     void setUp () {
        categoriaRequest = new CategoriaRequest(20L, "jabon");
    }

    @Test
    void saveCategoria() {
        ResponseEntity <?> responseEntity = categoriaService.saveCategoria(categoriaRequest);
        assertEquals(200, responseEntity.getStatusCodeValue(), "no funciona");
    }

    @Test
    void getAllCategorias() {
        responseEntity = categoriaService.getAllCategorias();
        assertEquals(404, responseEntity.getStatusCodeValue(), "no funciona mamerto");
    }

    @Test
    void getCategoriaByCategoria() {
    }

    @Test
    void deleteCategoria() {
    }

    @Test
    void updateCategoria() {
    }
}