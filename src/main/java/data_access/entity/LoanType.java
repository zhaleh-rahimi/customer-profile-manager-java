package data_access.entity;

import java.util.List;

/**
 * Created by dotinschool3 on 10/15/2016.
 */
public class LoanType {
    private String loanTypeName;
    private int loanTypeId;
    private Float interestRate;
    private List<GrantCondition> grantConditions;

    public LoanType() {
    }

    public LoanType(String loanTypeName, Float interestRate) {
        this.loanTypeName = loanTypeName;
        this.interestRate = interestRate;
    }

    public LoanType(String loanTypeName, int loanTypeId) {
        this.loanTypeName = loanTypeName;
        this.loanTypeId = loanTypeId;
    }

    public List<GrantCondition> getGrantConditions() {
        return grantConditions;
    }

    public void setGrantConditions(List<GrantCondition> grantConditions) {
        this.grantConditions = grantConditions;
    }

    public String getLoanTypeName() {
        return loanTypeName;
    }

    public int getLoanTypeId() {
        return loanTypeId;
    }

    public Float getInterestRate() {
        return interestRate;
    }

    public void setLoanTypeName(String loanTypeName) {
        this.loanTypeName = loanTypeName;
    }

    public void setLoanTypeId(int loanTypeId) {
        this.loanTypeId = loanTypeId;
    }

    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return getLoanTypeId()+" ,"+getLoanTypeName()+" ,"+getInterestRate();
    }
}

