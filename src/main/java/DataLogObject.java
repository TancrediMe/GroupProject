/**
 * Un {@link DataLogObject} è una riga del {@link DataLog}
 * @param <E> tipo di valore che può essere contenuto nel {@link DataLog}
 */
public interface DataLogObject <E>{
    /**
     * Restituisce il momento in cui è stato letto il valore in formato UNIX_TIME_STAMP
     * @return momento della lettura
     */
    long getTime();

    /**
     * Restituisce il valore
     * @return value
     */
    E getValue();
}
