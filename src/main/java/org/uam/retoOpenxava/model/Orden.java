package org.uam.retoOpenxava.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentLocalDateCalculator;
import org.openxava.calculators.CurrentMonthCalculator;
import org.openxava.calculators.CurrentYearCalculator;
import org.uam.retoOpenxava.calculators.CalculatorNumero;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Orden extends BaseEntity {
    @DefaultValueCalculator(CurrentYearCalculator.class)
    @ReadOnly
    private int anioFiscal;

    @DefaultValueCalculator(value= CalculatorNumero.class,
           properties = @PropertyValue(name="anioFiscal"))
    private Integer numero;

    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    @ReadOnly
    private LocalDate fecha;

    @ElementCollection
    @ListProperties("producto.nombre,precioPorUnidad,cantidad,importe")
    Collection<DetalleOrden> detalles;

    private String descripcion;

}
