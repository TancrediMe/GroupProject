/**
 * Rappresenta un {@link DataLogObject}, ovvero una riga del {@link DataLog}
 * contenente il valore di un {@link Device} e ha la responsabilità di sapere quando è stata creata.
 * La sua data di creazione verrà presa come riferimento del valore.
 */
public class LogRow <E> implements DataLogObject<E>{
        private long time;
        private E value;

        public LogRow(E value, long time) {
            this.time = time;
            this.value = value;
        }

        @Override
        public long getTime() {
            return time;
        }

        @Override
        public E getValue() {
            return value;
        }
    }

