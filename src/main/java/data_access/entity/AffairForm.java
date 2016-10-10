package data_access.entity;

import java.math.BigDecimal;

/**
 * Created by dotinschool3 on 10/10/2016.
 */
public class AffairForm {
    private int formId;
    private int duration;
    private BigDecimal amount;
    private FacilityType facilityType;
    private NaturalCustomer naturalCustomer;


    public AffairForm() {
    }

    public AffairForm(int formId, int duration, BigDecimal amount) {
        this.formId = formId;
        this.duration = duration;
        this.amount = amount;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public void setNaturalCustomer(NaturalCustomer naturalCustomer) {
        this.naturalCustomer = naturalCustomer;
    }

    public int getFormId() {
        return formId;
    }

    public int getDuration() {
        return duration;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public NaturalCustomer getNaturalCustomer() {
        return naturalCustomer;
    }
}
