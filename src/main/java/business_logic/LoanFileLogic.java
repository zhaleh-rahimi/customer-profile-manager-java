package business_logic;

import data_access.LoanFileCRUD;
import data_access.entity.LoanFile;
import data_access.entity.LoanType;
import data_access.entity.NaturalCustomer;

import java.util.ArrayList;

/**
 * Created by dotinschool3 on 10/15/2016.
 */
public class LoanFileLogic {


    public static ArrayList<LoanType> findLoanTypes() {
        return LoanFileCRUD.findLoanTypes();
    }

    public static void create(Integer customerId, Integer loanTypeId, LoanFile loanFile) {
        LoanFileCRUD.create(customerId,loanTypeId,loanFile);
    }
}
