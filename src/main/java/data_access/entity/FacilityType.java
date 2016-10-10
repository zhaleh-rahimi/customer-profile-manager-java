package data_access.entity;

import java.math.BigDecimal;

/**
 * Created by dotinschool3 on 10/10/2016.
 */
public class FacilityType {
    private int facilityId;
    private String facilityName;
    private int minDuration, maxDuration;
    private BigDecimal minAmount, maxAmount;

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
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

    public int getFacilityId() {
        return facilityId;
    }

    public String getFacilityName() {
        return facilityName;
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

}
