package it.unicam.quasylab.gpmonitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Questa classe rappresenta un {@link DataLog} per un certo tipo di dati
 */
public class DataPool implements DataLog {

    private final Map<Device,List<DataLogObject>> deviceListmap;

    public DataPool() {
        this.deviceListmap = new HashMap<>();
    }

    @Override
    public final void add(Device device) {
        if(!deviceListmap.containsKey(device))
            deviceListmap.put(device, new ArrayList<>());
        deviceListmap.get(device).add(new LogRow(System.currentTimeMillis(),device.getValue()));
    }

    @Override
    public final List<DataLogObject> get(Device device) {
        return deviceListmap.get(device);
    }

    @Override
    public final List<DataLogObject> get(Device device, TimeInterval interval) {
        List<DataLogObject> devlog=deviceListmap.get(device);
        List<DataLogObject> updated=new ArrayList<>();
        for(DataLogObject row:devlog)
            if(row.getTime()>= interval.getstart()&&row.getTime()<= interval.getStop())
                updated.add(row);
        return updated;
    }

    @Override
    public final void clear() {
        deviceListmap.clear();
    }


}
