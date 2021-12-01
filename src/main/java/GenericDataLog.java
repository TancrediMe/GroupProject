import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Questa classe rappresenta un {@link DataLog} per un certo tipo di dati
 * @param <E> il tipo di dati
 */
public abstract class GenericDataLog<E> implements DataLog<E> {

    private final Map<Device<E>,List<DataLogObject<E>>> deviceListmap;

    public GenericDataLog() {
        this.deviceListmap = new HashMap<>();
    }

    @Override
    public void add(Device<E> device) {
        if(!deviceListmap.containsKey(device))
            deviceListmap.put(device, new ArrayList<>());
        deviceListmap.get(device).add(new LogRow<>(device.getValue(),System.currentTimeMillis()));
    }

    @Override
    public List<DataLogObject<E>> get(Device<E> device) {
        return deviceListmap.get(device);
    }

    @Override
    public List<DataLogObject<E>> get(Device<E> device, TimeInterval interval) {
        List<DataLogObject<E>> devlog=deviceListmap.get(device);
        List<DataLogObject<E>> updated=new ArrayList<>();
        for(DataLogObject<E> row:devlog)
            if(row.getTime()>= interval.getstart()&&row.getTime()<= interval.getStop())
                updated.add(row);
        return updated;
    }

    @Override
    public void clear() {
        deviceListmap.clear();
    }


}
