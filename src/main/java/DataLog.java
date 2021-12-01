import java.util.List;

/**
 * Le classi che implementano questa interfaccia istanziano oggetti che hanno il compito di rappresentare uno storico dei valori letti dal {@link Reader}
 * riguardante vari dispositivi, diviso per dispositivo.
 * @param <E> Il tipo di dati che verranno collezionati
 */
public interface DataLog<E> {
    /**
     * Memorizza lo stato del {@link Device} inserito aggiungendolo allo storico
     * @param device il {@link Device} di riferimento
     */
    void add(Device<E> device);

    /**
     * Restituisce lo storico relativo a un {@link Device}
     * @param device il {@link Device} di riferimento
     * @return storico dei dati
     */
    List<DataLogObject<E>> get(Device<E> device);

    /**
     * Restituisce lo storico relativo a un {@link Device} entro un dato {@link TimeInterval}
     * @param device il {@link Device} di riferimento
     * @param interval il {@link TimeInterval} di riferimento
     * @return storico dei dati
     */
    List<DataLogObject<E>> get(Device<E> device, TimeInterval interval);

    /**
     * Cancella l'intero contenuto del DataLog
     */
    void clear();
}
