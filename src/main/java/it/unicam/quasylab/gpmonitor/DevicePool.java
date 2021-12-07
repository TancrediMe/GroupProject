package it.unicam.quasylab.gpmonitor;

import java.util.Collection;

/**
 * Un {@link DevicePool} ha il compito di tenere un elenco dei vari {@link Device}  presenti nel sistema e agiornarli in base ai valori ricevui
 * dal {@link DataCollector} e di aggiornare il {@link DataLog} con questi valori mediante un {@link Filter}.
 *
 */
public interface DevicePool {
    /**
     * Aggiorna lo stato di un {@link Device} della lista
     * @param NetworkID Informazioni di rete del {@link Device}
     * @param value nuovo valore da inserire
     */
    void update (String NetworkID,double ... value);

    /**
     * Restituisce una {@link Collection} contenente tutti i {@link Device} nella {@link DevicePool}
     * @return
     */
    Collection<Device> getDevices();

    /**
     * Restituisce il {@link Filter} associatoa  questo {@link DataCollector}
     * @return
     */
    Filter getFilter();
}
