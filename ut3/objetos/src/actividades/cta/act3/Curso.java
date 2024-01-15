package actividades.cta.act3;

import java.io.Serializable;

public class Curso implements Serializable {
    private String id, descripcion;

    public Curso(String id, String description) {
        this.id = id;
        this.descripcion = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
