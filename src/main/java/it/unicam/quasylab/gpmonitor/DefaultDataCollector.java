package it.unicam.quasylab.gpmonitor;

/**
 * Il {@link DefaultDataCollector} è un {@link DataCollector} che lascia all'implementazione la possibilità di definire
 * il tipo di dati, il tipo di rete e il {@link Thread} di lettura (in base alla tipologia di rete implementata
 * @param <N> Tipo di rete
 */
public abstract class DefaultDataCollector<N> implements DataCollector{

    private final N network;
    private final Thread listen;
    private final DevicePool devices;

    public DefaultDataCollector(NetworkConfiguration<N> net, DevicePool devices) {
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
     * Al momento della lettura del valore richiamare -> {@code read(NetworkID,value);}
     */
    protected abstract void listenThread();

    /**
     * Riceve un valore letto dalla rete
     * @param networkID Id del dispositivo sulla rete
     * @param value valore ricevuto
     */
    protected final void read(String networkID, double ... value) {
        devices.update(networkID,value);
    }


}
