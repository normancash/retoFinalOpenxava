package org.uam.retoOpenxava.actions;

import org.openxava.actions.SaveAction;
import org.openxava.jpa.XPersistence;
import org.openxava.validators.ValidationException;
import org.openxava.view.View;
import org.uam.retoOpenxava.model.Inventario;
import org.uam.retoOpenxava.model.Producto;

import javax.ejb.DuplicateKeyException;
import javax.ejb.ObjectNotFoundException;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class MiSaveAction extends SaveAction {


    @Override
    public void execute() throws Exception {
        try {
            if (getView().isKeyEditable()) {
                //Guardar Inventario.
                saveInventario(this.getValuesToSave());
                Map values = create();
                updateView(values, isResetAfterOnCreate());
            }
            else {
                Map values = modify();
                updateView(values, isResetAfterOnModify());
            }

            resetDescriptionsCache();
        }
        catch (ValidationException ex) {
            addErrors(ex.getErrors());
        }
        catch (ObjectNotFoundException ex) {
            addError("no_modify_no_exists");
        }
        catch (DuplicateKeyException ex) {
            addError("no_create_exists");
        }
    }

    private void saveInventario(Map<String,Object> values) throws Exception {
          List<Map<String,Object>> list = (List<Map<String,Object>>)values.get("detalles");
          for (Map<String,Object> map : list) {
              Inventario inventario = new Inventario();
              String idProducto = (String) map.get("producto.id");
              Query query =XPersistence.getManager()
                      .createQuery("select e from Producto e " +
                              "where e.id = :idProducto", Producto.class);
              query.setParameter("idProducto", idProducto);
              Producto producto = (Producto) query.getSingleResult();
              inventario.setId((String)map.get(""));
          }
    }
}
