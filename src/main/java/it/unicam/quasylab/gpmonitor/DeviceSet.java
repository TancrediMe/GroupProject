package it.unicam.quasylab.gpmonitor;

import java.util.Collection;
import java.util.HashSet;

/**
 * Questa classe rappresenta un {@link DevicePool}  che lascia all'implementazione il compito di definire il tipo di
 * dati che può salvare e la tipologia di {@link Collection}
 * nella quale dovranno essere contenuti per poter così modificare il comportamento dell'algoritmo di ricerca degli oggetti.
 */
public final class DeviceSet implements DevicePool{
    private final Collection<Device> devices;
    private final Filter filter;
    public DeviceSet(Filter filter) {
        this.filter = filter;
        devices=new HashSet<>();
    }
    @Override
    public final void update(String networkID, double ... value) {
        for(Device d:devices)
            if (d.getNetworkID().equals(networkID))
            {
                d.update(value);
                filter.filter(d);
            }

    }

    @Override
    public final Collection<Device> getDevices() {
        return devices;
    }

    @Override
    public final Filter getFilter() {
        return filter;
    }

    /**
     * Aggiunge un nuovo dispositivo a questa Pool
     * @param device il dispositivo da aggiungere
     */
    public final void add(Device device){
        devices.add(device);
    }


}
