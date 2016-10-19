package data_access;

import data_access.entity.LoanType;
import data_access.entity.NaturalCustomer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;
import util.LoggerUtil;

import java.util.ArrayList;
import java.util.List;

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

    public static LoanType retrieveLoanTypeById(Integer loanTypeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From LoanType loanType WHERE loanType.loanTypeId= :loanTypeId "  );
        query.setParameter("loanTypeId", loanTypeId);
        List loanType = query.list();
        transaction.commit();
        session.close();
        System.out.println("successfully Read from table loan_type" + loanType );
        return (LoanType) loanType.get(0);
    }
    public static void main(String[] s){
        retrieveLoanTypeById(4);
    }
}
