package business_logic;

import business_logic.exceptions.DataNotFoundException;
import business_logic.exceptions.DuplicateInformationException;
import business_logic.exceptions.FieldRequiredException;
import business_logic.exceptions.NationalCodeFormatException;
import data_access.NaturalCustomerCRUD;
import data_access.entity.NaturalCustomer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dotinschool3 on 10/3/2016.
 */
public class NaturalCustomerLogic {
    private static boolean validate(NaturalCustomer naturalCustomer) throws SQLException {
        if (naturalCustomer.getFirstName() == null || naturalCustomer.getFirstName().equals("")) {
            throw new FieldRequiredException("وارد کردن نام الزامی است.");
        }
        if (naturalCustomer.getLastName() == null || naturalCustomer.getLastName().equals("")) {
            throw new FieldRequiredException("وارد کردن نام خانوادگی الزامی است.");
        }
        if (naturalCustomer.getFatherName() == null || naturalCustomer.getFatherName().equals("")) {
            throw new FieldRequiredException("وارد کردن نام پدر الزامی است.");
        }
        if (naturalCustomer.getDateOfBirth() == null || naturalCustomer.getDateOfBirth().equals("")) {
            throw new FieldRequiredException("وارد کردن تاریخ تولد الزامی است.");
        }
        if (naturalCustomer.getNationalCode() == null || naturalCustomer.getNationalCode().equals("")) {
            throw new FieldRequiredException("وارد کردن کد ملی الزامی است.");
        } else {
            if (naturalCustomer.getNationalCode().trim().length() != 10) {
                throw new NationalCodeFormatException("کد ملی باید دقیقا ده رقم باشد");
            } else {
                String code = naturalCustomer.getNationalCode().trim();
                int sum = 0;
                for (int i = 10; i > 1; i--) {
                    sum += Integer.parseInt(code.substring(10 - i, 11 - i)) * i;
                }
                int rightMostNumber = Integer.parseInt(code.substring(9));
                int reminder = sum % 11;
                if (!(reminder == rightMostNumber) && !(reminder == 11 - rightMostNumber)) {
                    throw new NationalCodeFormatException("کد ملی وارد شده صحیح نیست");
                }
            }
            List<NaturalCustomer> customerByNationalCode = NaturalCustomerCRUD.findCustomerByNationalCode(naturalCustomer.getNationalCode());
            if (customerByNationalCode.size() > 0) {
                for (NaturalCustomer realCustomer1 : customerByNationalCode) {
                    if (naturalCustomer.getCustomerId() != realCustomer1.getCustomerId()) {
                        throw new DuplicateInformationException("کد ملی وارد شده تکراری می باشد");
                    }
                }
            }
        }

        return true;
    }

    public static void insertNaturalCustomer(NaturalCustomer naturalCustomer) throws SQLException {
        if (validate(naturalCustomer)) {
            NaturalCustomerCRUD.insertIntoNaturalCustomerTable(naturalCustomer);
        }
    }

    public static void deleteNaturalCustomerByID(int customerId) throws SQLException {
        NaturalCustomerCRUD.deleteFromNaturalCustomerTable(customerId);
    }

    public static NaturalCustomer updateNaturalCustomer(NaturalCustomer naturalCustomer) throws SQLException {
        if (validate(naturalCustomer)) {
            return NaturalCustomerCRUD.updateNaturalCustomerInTable(naturalCustomer);
        } else
            return naturalCustomer;
    }

    public static NaturalCustomer retrieveCustomer(String customerId) {

        List<NaturalCustomer> naturalCustomers = NaturalCustomerCRUD.retrieveCustomerById(customerId);
        if (naturalCustomers.isEmpty()) {
            System.out.println("not found customer and will be redirected to exception handling");
            throw new DataNotFoundException("مشتری با این شماره یافت نشد! ");
        } else {
            return naturalCustomers.get(0);
        }


    }

    public static ArrayList<NaturalCustomer> search(NaturalCustomer naturalCustomer) {
        try {
            return NaturalCustomerCRUD.search(naturalCustomer);
        } catch (RuntimeException e) {
            throw new DataNotFoundException("no customer found with specified search filters. please try again.");
        }


    }

}
