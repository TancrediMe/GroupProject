/**
 * Gli oggetti di questa interfaccia inizializzano una connessione verso la rete di dispositivi (sensori) in base a istruzioni esterne e avviano la comunicazione su di essa.
 * Un DataCollector può utilizzare una connessione fornita dalla NetworkConfiguration
 * @param <E> Il tipo di connessione istanziata
 */
public interface NetworkConfiguration<E> {
    /**
     * Restituisce la connessione istanziata
     * @return connessione
     */
    E getNetwork();

}
