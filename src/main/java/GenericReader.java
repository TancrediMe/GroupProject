/**
 * Questa classe rappresenta un {@link Reader} per un determinato tipo di dato da definire nell'implementazione.
 * @param <E> il tipo di dato
 */
public abstract class GenericReader<E> implements Reader{
    private boolean enabled;
    private final Thread reading;
    private long millis;
    protected DevicePool<E> devices;
    protected DataLog<E> log;

    public GenericReader(DevicePool<E> devices, DataLog<E> log) {
        if(devices==null || log==null)
            throw new NullPointerException("La DevicePool e il DataLog non possono essere @null");
        this.devices = devices;
        this.log = log;
        this.enabled = false;
        this.reading = new Thread(()->{
            while (enabled){
                for(Device<E> d: this.devices.getDevices())
                    this.log.add(d);
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public final void startReading(long millis) {
        enabled=true;
        this.millis=millis;
        reading.start();
    }

    @Override
    public final void stopReading() {
        enabled=false;
    }
}
