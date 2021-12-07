package it.unicam.quasylab.gpmonitor;

/**
 * Rappresenta un {@link DataLogObject}, ovvero una riga del {@link DataLog}
 * contenente il valore di un {@link Device} e ha la responsabilità di sapere quando è stata creata.
 * La sua data di creazione verrà presa come riferimento del valore.
 */
public final class LogRow implements DataLogObject{
        private long time;
        private double [] value;

        public LogRow(long time, double ... value) {
            this.time = time;
            this.value = value;
        }

        @Override
        public final long getTime() {
            return time;
        }

        @Override
        public final double[] getValue() {
            return value;
        }
    }

