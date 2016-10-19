package business_logic;

import business_logic.exceptions.DataNotFoundException;
import business_logic.exceptions.InputNotInRangeException;
import data_access.GrantConditionCRUD;
import data_access.LoanFileCRUD;
import data_access.LoanTypeCRUD;
import data_access.entity.GrantCondition;
import data_access.entity.LoanFile;
import data_access.entity.LoanType;
import data_access.entity.NaturalCustomer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dotinschool3 on 10/15/2016.
 */
public class LoanFileLogic {
    private static Boolean validateLoanFile(LoanFile loanFile, Integer loanTypeId) throws InputNotInRangeException {
        int foundACondition=0;
        List<GrantCondition> grantConditions = GrantConditionLogic.retrieveConditionsByLoanTypeId(loanTypeId);
        for (GrantCondition grantCondition : grantConditions) {
            if ((loanFile.getDuration() <= grantCondition.getMaxDuration() && loanFile.getDuration() >= grantCondition.getMinDuration()) &&
                    (loanFile.getAmount().compareTo(grantCondition.getMaxAmount()) == -1 && loanFile.getAmount().compareTo(grantCondition.getMinAmount()) == 1))
            {
                foundACondition = 1;
                break;
            }
        }
        if(foundACondition==0){throw new InputNotInRangeException("مقادیر وارد شده در محدوده شرایط تسهیلات نمیباشد.");}
        return true;
    }

    public static ArrayList<LoanType> findLoanTypes() {
        return LoanTypeCRUD.findLoanTypes();
    }

    public static void create(Integer customerId, Integer loanTypeId, LoanFile loanFile) {
        if (validateLoanFile(loanFile, loanTypeId)) {
            NaturalCustomer naturalCustomer = NaturalCustomerLogic.retrieveCustomer(String.valueOf(customerId));
            LoanType loanType = LoanTypeLogic.retrieveLoanType(loanTypeId);
            loanFile.setNaturalCustomer(naturalCustomer);
            loanFile.setLoanType(loanType);
            LoanFileCRUD.create(loanFile);
        }
    }
}
