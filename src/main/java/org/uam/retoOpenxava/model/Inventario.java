package org.uam.retoOpenxava.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Inventario extends BaseEntity{

    @OneToOne
    private Producto producto;

    private int cantidad;

}
