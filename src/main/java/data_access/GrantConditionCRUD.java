package data_access;

import data_access.entity.GrantCondition;
import data_access.entity.LoanType;
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
public class GrantConditionCRUD {
    public static void insertIntoTable(LoanType loanType, List<GrantCondition> grantConditions) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(loanType);
        int id = loanType.getLoanTypeId();
        for (GrantCondition grantCondition : grantConditions) {
            grantCondition.setLoanTypeId(id);
            session.save(grantCondition);
        }
        transaction.commit();
        session.close();
        System.out.println("successfully inserted into loan type & grant condition tables");
    }

    public static List<GrantCondition> retrieveConditionsByLoanTypeId(Integer loanTypeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From GrantCondition grantCondition WHERE grantCondition.loanTypeId=" + loanTypeId);
        List grantConditions = query.list();
        transaction.commit();
        session.close();
        System.out.println("successfully Read from table loan_type" + grantConditions);
        return grantConditions;
    }
//    public  static void main(String[] args){
//        retrieveConditionsByLoanTypeId(4);
//    }

}
