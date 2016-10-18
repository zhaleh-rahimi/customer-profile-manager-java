package data_access;

import data_access.entity.LoanFile;
import data_access.entity.LoanType;
import data_access.entity.NaturalCustomer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dotinschool3 on 10/15/2016.
 */
public class LoanFileCRUD {

    public static ArrayList<LoanType> findLoanTypes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From LoanType");
        ArrayList<LoanType> loanTypes = (ArrayList<LoanType>) query.list();
        transaction.commit();
        session.close();
        System.out.println("successfully Read from table" + loanTypes);
        return loanTypes;
    }

    public static void main(String[] s) {
    }

    public static void create(Integer customerId, Integer loanTypeId, LoanFile loanFile) {

    }
}
