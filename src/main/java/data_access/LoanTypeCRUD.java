package data_access;

import data_access.entity.LoanType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 * Created by dotinschool3 on 10/15/2016.
 */
public class LoanTypeCRUD {
    public static void insertIntoLoanTypeTable(LoanType loanType) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(loanType);
        transaction.commit();
        session.close();
        System.out.println("successfully inserted into loan type table");
    }


}
