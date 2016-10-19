package data_access;

import data_access.entity.LoanFile;
import data_access.entity.LoanType;
import data_access.entity.NaturalCustomer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;
import util.LoggerUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dotinschool3 on 10/15/2016.
 */
public class LoanFileCRUD {

    public static void create(LoanFile loanFile) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(loanFile);
        transaction.commit();
        session.close();
        System.out.println("successfully inserted into table loan_file");
    }
//    public static void main(String[] s) {
//    }
}
