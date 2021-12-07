package it.unicam.quasylab.gpmonitor;

/**
 * Un {@link DataLogObject} è una riga del {@link DataLog}
 */
public interface DataLogObject {
    /**
     * Restituisce il momento in cui è stato letto il valore in formato UNIX_TIME_STAMP
     * @return momento della lettura
     */
    long getTime();

    /**
     * Restituisce il valore
     * @return value
     */
    double[] getValue();
}
