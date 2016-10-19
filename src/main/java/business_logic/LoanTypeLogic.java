package business_logic;

import business_logic.exceptions.FieldRequiredException;
import data_access.LoanTypeCRUD;
import data_access.entity.LoanType;

/**
 * Created by dotinschool3 on 10/15/2016.
 */
public class LoanTypeLogic {
    private static Boolean validate(LoanType loanType) {
        if (loanType.getLoanTypeName() == null || loanType.getLoanTypeName().equals("")) {
            throw new FieldRequiredException("وارد کردن نام الزامی است.");
        }
        if (loanType.getInterestRate() == null || loanType.getInterestRate().equals("")){
            throw new FieldRequiredException("وارد کردن نرخ سود الزامی است.");
        }
        return true;
    }
    public static void insertIntoTable(LoanType loanType) {
        if (validate(loanType)) {

               LoanTypeCRUD.insertIntoLoanTypeTable(loanType);

        }
    }


    public static LoanType retrieveLoanType(Integer loanTypeId) {
        return LoanTypeCRUD.retrieveLoanTypeById(loanTypeId);
    }
}
