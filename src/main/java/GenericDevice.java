import java.util.Objects;

/**
 * Un {@link Device} generico che lascia all'implementazione il compito di definire
 * il tipo di dato all'interno del dispositivo e il valore neutro per quel tipo di dato.
 *
 * @param <E> tipo di dato
 */
public abstract class GenericDevice<E> implements Device<E>{
    private final String name;
    private E value;
    private final String networkID;



    public GenericDevice(String name, String networkID) {
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
    public final E getValue() {
        return value;
    }

    @Override
    public final String getNetworkID() {
        return networkID;
    }

    @Override
    public final void update(E value) {
        this.value=value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenericDevice)) return false;
        GenericDevice<?> that = (GenericDevice<?>) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getNetworkID(), that.getNetworkID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getNetworkID());
    }

    /**
     * Restituisce il valore neutro per il tipo di valori in input
     * @return valore neutro
     */
    protected abstract E neutralValue();

}

