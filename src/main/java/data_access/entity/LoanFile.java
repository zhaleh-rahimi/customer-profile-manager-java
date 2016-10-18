package data_access.entity;

import java.math.BigDecimal;

/**
 * Created by dotinschool3 on 10/15/2016.
 */
public class LoanFile {
    private int loanFileId;
    private NaturalCustomer naturalCustomer;
    private LoanType loanType;
    private BigDecimal amount;
    private int duration;

    public int getLoanFileId() {
        return loanFileId;
    }

    public NaturalCustomer getNaturalCustomer() {
        return naturalCustomer;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getDuration() {
        return duration;
    }

    public void setLoanFileId(int loadFileId) {
        this.loanFileId = loadFileId;
    }

    public void setNaturalCustomer(NaturalCustomer naturalCustomer) {
        this.naturalCustomer = naturalCustomer;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
