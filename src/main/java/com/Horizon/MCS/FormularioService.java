package com.Horizon.MCS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FormularioService {

    @Autowired
    private FormRepository productoRepository;

    private static final AtomicInteger contador = new AtomicInteger(1);

    public Formulario guardarFormulario(Formulario formulario) {
        // Generar SKU
        String sku = generarSKU(formulario.getCategoria(), formulario.getColor(), formulario.getTamanio());
        formulario.setSku(sku);
        formulario.setContenidoImagen(decodificarab64(formulario.getImagen()));
        // Guardar producto
        return productoRepository.save(formulario);
    }

    private String generarSKU(String categoria, String color, String tamanio) {
        String cat = categoria.length() >= 3 ? categoria.substring(0, 3).toUpperCase() : categoria.toUpperCase();
        String col = color.length() >= 3 ? color.substring(0, 3).toUpperCase() : color.toUpperCase();
        String tam = tamanio.toUpperCase();
        String sec = String.format("%03d", contador.getAndIncrement());
        return cat + "-" + col + "-" + tam + "-" + sec;
    }

    public byte [] decodificarab64 ( String imagen ){
       return Base64.getDecoder().decode(imagen.substring(imagen.indexOf(",")+1));
    }

    public List<Formulario> getAll(){
        return productoRepository.findAll();
    }
}

