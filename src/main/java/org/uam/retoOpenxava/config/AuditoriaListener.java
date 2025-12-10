package org.uam.retoOpenxava.config;

import org.uam.retoOpenxava.model.Auditable;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;

public class AuditoriaListener {

    @PrePersist
    public void prePersist(Object auditable) {
        if (auditable instanceof Auditable) {
            Auditable e = (Auditable) auditable;
            e.getAuditoria().setUsuarioIng("AdmonIng");
            e.getAuditoria().setFechaIng(LocalDate.now());
        }
    }

    @PreUpdate
    public void preUpdate(Object auditable) {
        if (auditable instanceof Auditable) {
            Auditable e = (Auditable) auditable;
            e.getAuditoria().setUsuarioAct("AdmonMod");
            e.getAuditoria().setFechaAct(LocalDate.now());
        }

    }

}
