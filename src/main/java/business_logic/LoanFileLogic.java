package business_logic;

import data_access.LoanFileCRUD;
import data_access.entity.LoanType;
import data_access.entity.NaturalCustomer;

import java.util.ArrayList;

/**
 * Created by dotinschool3 on 10/15/2016.
 */
public class LoanFileLogic {
    public static NaturalCustomer findCustomerById(int id) {
        return LoanFileCRUD.findCustomerById(id);
    }

    public static ArrayList<LoanType> findLoanTypes() {
        return LoanFileCRUD.findLoanTypes();
    }
}
