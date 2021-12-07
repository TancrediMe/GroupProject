package it.unicam.quasylab.gpmonitor;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public abstract class DefaultFilter implements Filter {
    Collection<FilterRule> rules;
    DataLog datalog;

    public DefaultFilter(DataLog datalog) {
        if(datalog==null) throw new NullPointerException("impostare un DataLog!");
        this.datalog=datalog;
        this.rules = new HashSet<>();
    }

    @Override
    public boolean filter(Device device) {
        for(FilterRule r:rules)
            if(!r.filter(device.getValue()))
                return false;
        datalog.add(device);
        return true;
    }

    @Override
    public void addFilterRule(FilterRule rule) {
        rules.add(rule);
    }

    @Override
    public DataLog getDataLog() {
        return datalog;
    }

    /**
     * 2 {@link Filter} sono uguali se si riferiscono allo stesso {@link DataLog}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DefaultFilter)) return false;
        DefaultFilter that = (DefaultFilter) o;
        return datalog.equals(that.datalog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datalog);
    }
}
