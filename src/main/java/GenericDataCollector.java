import java.util.Collection;
import java.util.HashSet;

/**
 * Il {@link GenericDataCollector} è un {@link DataCollector} che lascia all'implementazione la possibilità di definire
 * il tipo di dati, il tipo di rete e il Thread di lettura (in base alla tipologia di rete implementata)
 * @param <E> Tipo di dati
 * @param <N> Tipo di rete
 */
public abstract class GenericDataCollector<E, N> implements DataCollector<E>{

    private final N network;
    private final Thread listen;
    private final DevicePool<E> devices;


    public GenericDataCollector(NetworkConfiguration<N> net, DevicePool<E> devices) {
        this.network = net.getNetwork();
        this.listen =new Thread(()->{
            listenThread();
        });
        this.devices = devices;
    }

    @Override
    public final void startListening() {
        listen.start();
    }


    /**
     * Implementare il thread di ascolto in base alla tipologia di rete utilizzata.
     * Al momento della lettura del valore richiamare -> read(NetworkID,value);
     */
    protected abstract void listenThread();

    /**
     * Riceve un valore letto dalla rete
     * @param networkID Id del dispositivo sulla rete
     * @param value valore ricevuto
     */
    protected final void read(String networkID, E value) {
        devices.update(networkID,value);
    }


}
