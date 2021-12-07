package it.unicam.quasylab.gpmonitor;

/**
 * Le classi che implementano questa interfaccia istanziano oggetti che rappresentano dispositivi fisici all'interno della rete di sensori
 * Ogni {@link Device} è un sensore.
 */
public interface Device{
    /**
     * Restituisce un identificativo univoco per il dispositivo rappresentato da questo oggetto
     * @return ID
     */
    String getName();

    /**
     * Restituisce il valore attuale del {@link Device}
     * @return Valore
     */
    double[] getValue();

    /**
     * Restituisce le informazioni identificative che potrebbero essere necessarie ad identificare il dispositivo in base
     * alle informazioni ricevute dalla rete.
     * Gli oggetti che avranno la responsabilità di aggiornare un {@link Device } in base ai valori ottenuti avranno bisogno di questa informazione
     * @return Informazioni di rete
     */
    String getNetworkID();

    /**
     * Aggiorna lo stato del dispositivo con un nuovo valore
     * @param value valore
     */
    void update(double ... value);
}
