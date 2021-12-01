import java.util.Collection;
import java.util.HashSet;

/**
 * Questa classe rappresenta un {@link DevicePool}  che lascia all'implementazione il compito di definire il tipo di
 * dati che può salvare e la tipologia di {@link Collection}
 * nella quale dovranno essere contenuti per poter così modificare il comportamento dell'algoritmo di ricerca degli oggetti.
 * @param <E> tipo di dati
 */
public abstract class GenericDevicePool<E> implements DevicePool<E>{
    private final Collection<Device<E>> devices;
    public GenericDevicePool() {
        devices=new HashSet<>();
    }
    @Override
    public void update(String networkID, E value) {
        for(Device<E> d:devices)
            if (d.getNetworkID().equals(networkID))
                d.update(value);
    }

    @Override
    public Collection<Device<E>> getDevices() {
        return devices;
    }

    /**
     * Aggiunge un nuovo dispositivo a questa Pool
     * @param device il dispositivo da aggiungere
     */
    public void add(Device<E> device){
        devices.add(device);
    }


}
