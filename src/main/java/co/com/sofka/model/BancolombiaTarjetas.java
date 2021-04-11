package co.com.sofka.model;

import java.util.Objects;

public class BancolombiaTarjetas {


    private final String id;
    private final String nombreTarjeta;
    private final String descripcionTarjeta;
    private final String cuotaDeManejo;


    public BancolombiaTarjetas(String id, String nombreTarjeta, String descripcionTarjeta, String cuotaDeManejo) {
        this.id = id;
        this.nombreTarjeta = nombreTarjeta;
        this.descripcionTarjeta = descripcionTarjeta;
        this.cuotaDeManejo = cuotaDeManejo;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public String getDescripcionTarjeta() {
        return descripcionTarjeta;
    }

    public String getCuotaDeManejo() {
        return cuotaDeManejo;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BancolombiaTarjetas{" +
                "id='" + id + '\'' +
                ", nombreTarjeta='" + nombreTarjeta + '\'' +
                ", descripcionTarjeta='" + descripcionTarjeta + '\'' +
                ", cuotaDeManejo=" + cuotaDeManejo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BancolombiaTarjetas that = (BancolombiaTarjetas) o;
        return Objects.equals(id, that.id) && Objects.equals(nombreTarjeta, that.nombreTarjeta) && Objects.equals(descripcionTarjeta, that.descripcionTarjeta) && Objects.equals(cuotaDeManejo, that.cuotaDeManejo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreTarjeta, descripcionTarjeta, cuotaDeManejo);
    }
}
