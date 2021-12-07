package it.unicam.quasylab.gpmonitor;

/**
 * Gli oggetti di questa interfaccia inizializzano una connessione verso la rete di dispositivi (sensori) in base a istruzioni esterne e avviano la comunicazione su di essa.
 * Un {@link DataCollector} può utilizzare una connessione fornita dalla {@link NetworkConfiguration}.
 * Il compito degli oggetti che implementano questa interfaccia è quello di istanziare un oggetto rappresentante una connessione già inizializzato e renderlo disponibile
 * al {@link DataCollector} che andrà ad utilizzarlo per comunicare coi sensori.
 * @param <E> Il tipo di connessione istanziata
 */
public interface NetworkConfiguration<E> {
    /**
     * Restituisce la connessione istanziata
     * @return connessione
     */
    E getNetwork();

}
