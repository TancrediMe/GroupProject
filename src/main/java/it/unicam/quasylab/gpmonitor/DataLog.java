package it.unicam.quasylab.gpmonitor;

import java.util.List;

/**
 * Le classi che implementano questa interfaccia istanziano oggetti che hanno il compito di rappresentare uno storico dei
 * valori letti dalla rete di sensori, diviso per dispositivo.
 */
public interface DataLog {
    /**
     * Memorizza lo stato del {@link Device} inserito aggiungendolo allo storico
     * @param device il {@link Device} di riferimento
     */
    void add(Device device);

    /**
     * Restituisce lo storico relativo a un {@link Device}
     * @param device il {@link Device} di riferimento
     * @return storico dei dati
     */
    List<DataLogObject> get(Device device);

    /**
     * Restituisce lo storico relativo a un {@link Device} entro un dato {@link TimeInterval}
     * @param device il {@link Device} di riferimento
     * @param interval il {@link TimeInterval} di riferimento
     * @return storico dei dati
     */
    List<DataLogObject> get(Device device, TimeInterval interval);

    /**
     * Cancella l'intero contenuto del {@link DataLog}
     */
    void clear();
}
