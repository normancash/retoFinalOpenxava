package org.uam.retoOpenxava.calculators;

import lombok.Getter;
import lombok.Setter;
import org.openxava.calculators.ICalculator;
import org.uam.retoOpenxava.model.Producto;

import static org.openxava.jpa.XPersistence.getManager;

public class CalculadorPrecioPorUnidad implements ICalculator {

    @Getter
    @Setter
    String numeroProducto;

    @Override
    public Object calculate() throws Exception {
        Producto producto = getManager() // getManager() de XPersistence
                .find(Producto.class, numeroProducto); // Busca el producto
        return producto.getPrecio();    // Retorna su precio
    }

}
