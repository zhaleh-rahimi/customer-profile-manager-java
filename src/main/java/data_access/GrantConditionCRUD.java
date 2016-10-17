package data_access;

import data_access.entity.GrantCondition;
import data_access.entity.LoanType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

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
        int id= loanType.getLoanTypeId();
        for (GrantCondition grantCondition:grantConditions){
            grantCondition.setLoanTypeId(id);
            session.save(grantCondition);}
        transaction.commit();
        session.close();
        System.out.println("successfully inserted into loan type & grant condition tables");
    }
}
