package org.uam.retoOpenxava.calculators;

import lombok.Getter;
import lombok.Setter;
import org.openxava.calculators.ICalculator;
import org.openxava.jpa.XPersistence;
import javax.persistence.Query;

public class CalculatorNumero implements ICalculator {

    @Getter
    @Setter
    private Integer anioFiscal;


    @Override
    public Object calculate() throws Exception {
        Query query = XPersistence.getManager()
                .createQuery("SELECT MAX(f.numero)" +
                        " FROM Orden f " +
                        " WHERE f.anioFiscal = :anio");
        query.setParameter("anio", anioFiscal);
        Integer numero = (Integer)query.getSingleResult();
        return numero == null ? 1 : numero + 1;
    }
}
