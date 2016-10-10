package data_access;

import data_access.entity.NaturalCustomer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import util.HibernateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by DOTIN SCHOOL 4 on 9/28/2016.
 */
public class NaturalCustomerCRUD {
    private static ArrayList<NaturalCustomer> naturalCustomers = null;


 /*   public static void main(String[] args) {

        //creating configuration object
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

        //creating session factory object
        SessionFactory factory = cfg.buildSessionFactory();

        //creating session object
        Session session = factory.openSession();

        //creating transaction object
        Transaction transaction = session.beginTransaction();

        NaturalCustomer naturalCustomer = new NaturalCustomer();
        naturalCustomer.setFirstName("مهلا");
        naturalCustomer.setLastName("محمدی");
        naturalCustomer.setFatherName("حمید");
        naturalCustomer.setDateOfBirth("2010-2-2");
        naturalCustomer.setNationalCode("557");
        //naturalCustomer.setCustomerId(179);

        session.persist(naturalCustomer);//persisting the object

        transaction.commit();//transaction is committed
        session.close();

        System.out.println("successfully saved");

    }*/

    public static void insertIntoNaturalCustomerTable(NaturalCustomer naturalCustomer) throws SQLException {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.save(naturalCustomer);
        transaction.commit();
        session.close();
        System.out.println("successfully inserted into table");

    }

    private static ArrayList<NaturalCustomer> setSearchResult(ResultSet resultSet) throws SQLException {
        return null;
    }

    public static ArrayList<NaturalCustomer> findCustomerByFirstName(String name) throws SQLException {
        return null;
    }

    public static ArrayList<NaturalCustomer> findCustomerByLastName(String lastName) throws SQLException {
        return null;
    }

    public static ArrayList<NaturalCustomer> findCustomerById(String id) throws SQLException {
        return null;
    }

    public static ArrayList<NaturalCustomer> findCustomerByNationalCode(String nationalCode) throws SQLException {
        return null;
    }

    public static NaturalCustomer updateNaturalCustomerInTable(NaturalCustomer naturalCustomer) {
        return null;
    }

    public static void deleteFromNaturalCustomerTable(int customerId) throws SQLException {

    }

    public static Boolean duplicatedNumber(String nationalCode) throws SQLException {
        return true;
    }

    public static Boolean noDuplicateNumberInTable(String nationalCode, int idOfNew) throws SQLException {
        return true;
    }


    //Main Test
    /*public static void main(String[] argv) throws SQLException {
        NaturalCustomer naturalCustomer = new NaturalCustomer();
        *//*naturalCustomer.setFirstName("مهلا");
        naturalCustomer.setLastName("محمدی");
        naturalCustomer.setFatherName("حمید");
        naturalCustomer.setDateOfBirth("2010-2-2");
        naturalCustomer.setNationalCode("557");*//*
        //naturalCustomer.setCustomerId(179);
        *//*try {
            insertIntoNaturalCustomerTable(naturalCustomer);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*//*

       deleteFromNaturalCustomerTable(179);
    }*/

}
