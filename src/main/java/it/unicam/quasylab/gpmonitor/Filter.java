package it.unicam.quasylab.gpmonitor;

/**
 * Un {@link Filter} è un oggetto che ha il compito di filtrare il valore di un {@link Device} base ad alcune {@link FilterRule}
 * In caso di esito positivo dell'azione di filtraggio inserirà i dati in un {@link DataLog}.
 */
public interface Filter {
    /**
     * Filtra il valore del {@link Device} ricevuto.
     * Se il {@link Device} ricevuto ha uno stato che supera i controlli del {@link Filter}
     * viene salvato nel {@link DataLog}.
     * @param device il device da filtrare
     * @return {@code true} se è idoneo al salvataggio
     */
    boolean filter(Device device);

    /**
     * Aggiunge una nuova {@link FilterRule} a questo {@link Filter}
     * @param rule la nuova regola da aggiungere
     */
    void addFilterRule(FilterRule rule);

    /**
     * Restituisce il {@link DataLog} relativo a questo {@link Filter}
     * @return {@link DataLog}
     */
    DataLog getDataLog();

}
