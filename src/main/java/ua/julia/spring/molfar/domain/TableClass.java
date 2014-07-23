package ua.julia.spring.molfar.domain;

/**
 * Created by julia
 */
public class TableClass {
    boolean isUsed;
    Double priority = 0.;

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public Double getPriority() {
        return priority;
    }

    public void addPriority(Double priority) {
        this.priority += priority;
    }

    public void setPriority(Double priority) {
        this.priority = priority;
    }
}
