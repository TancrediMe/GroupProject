/**
 * Gli oggetti di tipo {@link DataCollector} hanno il compito di comunicare con la rete fisica di sensori per leggere i valori che essi trasmettono.
 * Il {@link DataCollector} deve quindi conoscere il protocollo trasmissivo della rete e il formato dei dati che può ricevere da essa.
 * In base alle informazioni ricevute dalla rete aggiorna i Device corrispondenti
 * @param <E> il tipo di dati che verranno collezionati.
 */
public interface DataCollector<E> {
    /**
     * Avvia la lettura dei valori dalla rete in un processo indipendente dall'esecuzione del resto del programma
     */
    void startListening();
}
