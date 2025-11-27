package org.uam.retoOpenxava.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.uam.retoOpenxava.calculators.CalculadorPrecioPorUnidad;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;


@Getter
@Setter
@Embeddable
public class DetalleOrden {

    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;

    private int cantidad;

    @Money
    @Depends("precioPorUnidad, cantidad")
    public BigDecimal getImporte() {
        if (precioPorUnidad == null) return BigDecimal.ZERO;
        return new BigDecimal(cantidad).multiply(precioPorUnidad);
    }

    @DefaultValueCalculator(
            value= CalculadorPrecioPorUnidad.class,
            properties=@PropertyValue(
                    name="numeroProducto",
                    from="producto.id")
    )
    @Money
    @ReadOnly
    private BigDecimal precioPorUnidad;
}
