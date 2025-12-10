package org.uam.retoOpenxava.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
public class Auditoria {
    private String usuarioIng;
    private String usuarioAct;
    private LocalDate fechaIng;
    private LocalDate fechaAct;
}
