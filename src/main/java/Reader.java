/**
 * Gli oggetti della classe {@link Reader} sono sei lettori che leggono il valore dei {@link Device} ogni n (definito dall'utente) millesimi di secondo e compilano un {@link DataLog}
 */
public interface Reader {
    /**
     * avvia un processo indipendente dall'esecuzione del resto del programma che, ogni n (Definito dall'utente: millis)
     * millesimi di secondo, salva in un {@link DataLog} il valore di ogni {@link Device} nel sistema.
     * @param millis
     */
    void startReading(long millis);

    /**
     * Ferma il processo di lettura
     */
    void stopReading();
}
