package com.gameshack.controller;

import com.gameshack.model.Carrito;
import com.gameshack.model.CarritoItem;
import com.gameshack.model.Producto;
import com.gameshack.repository.CarritoRepository;
import com.gameshack.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping("/agregar")
    public CarritoItem agregarProductoAlCarrito(@RequestParam Long carritoId, @RequestParam Long productoId, @RequestParam Integer cantidad) {
        Carrito carrito = carritoRepository.findById(carritoId).orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        Producto producto = productoRepository.findById(productoId).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        CarritoItem item = new CarritoItem();
        item.setCarrito(carrito);
        item.setProducto(producto);
        item.setCantidad(cantidad);

        carrito.getItems().add(item);
        carritoRepository.save(carrito);

        return item;
    }
}
