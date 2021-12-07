package it.unicam.quasylab.gpmonitor;

import java.util.Objects;

/**
 * Un {@link Device} generico che lascia all'implementazione il compito di definire
 * il tipo di dato all'interno del dispositivo e il valore neutro per quel tipo di dato.
 */
public abstract class DefaultDevice implements Device{
    private final String name;
    private double[] value;
    private final String networkID;



    public DefaultDevice(String name, String networkID) {
        if(name==null || networkID==null) throw new NullPointerException("I dati del dispositivo sono stati impostati a @null!");
        this.name = name;
        this.networkID = networkID;
        value=neutralValue();
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final double [] getValue() {
        return value;
    }

    @Override
    public final String getNetworkID() {
        return networkID;
    }

    @Override
    public final void update(double ... value) {
        this.value=value;
    }

    /**
     * 2 {@link Device} sono uguali se hanno lo stesso NetworkID
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DefaultDevice)) return false;
        DefaultDevice that = (DefaultDevice) o;
        return getNetworkID().equals(that.getNetworkID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNetworkID());
    }

    /**
     * Restituisce il valore neutro per il tipo di dispositivo.
     * Se il sensore è
     * @return valore neutro
     */
    protected abstract double [] neutralValue();

}

