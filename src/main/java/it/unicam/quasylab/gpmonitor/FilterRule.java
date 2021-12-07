package it.unicam.quasylab.gpmonitor;

/**
 * Gli oggetti di questa interfaccia sono parti di un {@link Filter} e rappresentano una regola di filtraggio
 * che confronta il valore ricevuto con quello atteso in base al tipo di {@link FilterType} di cui si compone
 * e decide se quello ricevuto può essere ammesso o meno nel {@link DataLog}
 *
 * Il filtro
 */
public interface FilterRule {

    /**
     * Restituisce il {@link FilterType}
     * @return {@link FilterType}
     */
    FilterType getFilterType();

    /**
     * Filtra il valore inserito
     * @param value il valore inserito
     * @return {@code true} se il filtro accetta il valore inserito.
     */
    boolean filter(double ... value);

}
