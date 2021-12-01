import java.util.Collection;

/**
 * Un {@link DevicePool} ha il compito di tenere un elenco dei vari {@link Device}  presenti nel sistema e agiornarli in base ai valori ricevui
 * dalla rete grazie al {@link DataCollector}
 * @param <E> Il tipo di valori che è possibile memorizzare nei dispositivi.
 */
public interface DevicePool<E> {
    /**
     * Aggiorna lo stato di un {@link Device} della lista
     * @param NetworkID Informazioni di rete del {@link Device}
     * @param value nuovo valore da inserire
     */
    void update (String NetworkID,E value);

    /**
     * Restituisce una {@link Collection} contenente tutti i {@link Device} nella {@link DevicePool}
     * @return
     */
    Collection<Device<E>> getDevices();
}
