package org.uam.retoOpenxava.model;

import lombok.Getter;
import lombok.Setter;
import org.uam.retoOpenxava.config.AuditoriaListener;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Entity
@Getter @Setter
@EntityListeners(AuditoriaListener.class)
public class Categoria extends BaseEntity implements Auditable {
    private String nombre;
    private String descripcion;
    @Embedded
    private Auditoria auditoria;


}
