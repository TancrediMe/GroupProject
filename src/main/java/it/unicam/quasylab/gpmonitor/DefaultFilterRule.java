package it.unicam.quasylab.gpmonitor;

import java.util.Arrays;
import java.util.Objects;

public abstract class DefaultFilterRule implements FilterRule {
    private FilterType type;
    private double[] filtervalue;

    public DefaultFilterRule(FilterType type, double ... than) {
        if(type==null||than==null)throw new NullPointerException("impostare tipo di filtro e valore!");
        this.type = type;
        this.filtervalue = than;
    }

    @Override
    public FilterType getFilterType() {
        return type;
    }

    @Override
    public boolean filter(double... value) {
        if(value.length!=filtervalue.length)
            return false;
        for(int i=0;i<value.length;i++){

            switch (getFilterType()){
                case EQUALS:
                    if(value[i]!=filtervalue[i])
                        return false;
                case HIGHER:
                    if(value[i]<filtervalue[i])
                        return false;
                case LOWER:
                    if(value[i]>filtervalue[i])
                        return false;
            }
        }
        return true;
    }

    /**
     * 2{@link FilterRule} sono uguali se hanno stesso tipo e stesso valore
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DefaultFilterRule)) return false;
        DefaultFilterRule that = (DefaultFilterRule) o;
        return type == that.type &&
                Arrays.equals(filtervalue, that.filtervalue);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(type);
        result = 31 * result + Arrays.hashCode(filtervalue);
        return result;
    }
}
