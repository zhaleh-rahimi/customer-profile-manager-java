package data_access.entity;

import java.math.BigDecimal;

/**
 * Created by dotinschool3 on 10/10/2016.
 */
public class GrantCondition {
    private int id;
    private String name;
    private Integer minDuration, maxDuration;
    private BigDecimal minAmount, maxAmount;
    private Integer loanTypeId;

    public int getId() {
        return id;
    }

    public int getLoanTypeId() {
        return loanTypeId;
    }

    public String getName() {
        return name;
    }

    public int getMinDuration() {
        return minDuration;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLoanTypeId(int loanTypeId) {
        this.loanTypeId = loanTypeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinDuration(int minDuration) {
        this.minDuration = minDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public String toString() {
        return getName()+" ,"+getMinDuration()+" ,"+getMaxDuration()+" ,"+getMinAmount()+" ,"+getMaxAmount();
    }
}
