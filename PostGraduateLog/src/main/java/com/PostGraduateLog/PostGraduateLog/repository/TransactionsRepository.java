package com.PostGraduateLog.PostGraduateLog.repository;

import com.PostGraduateLog.PostGraduateLog.interfaces.TransactionsDisplayInterface;
import com.PostGraduateLog.PostGraduateLog.model.Transactions;
import com.PostGraduateLog.PostGraduateLog.reponses.TransactionsJoinUsersReponse;
import com.PostGraduateLog.PostGraduateLog.reponses.TransactionsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transaction;
import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, String> {

    @Query(value = "SELECT * FROM u_g_student_accounts WHERE apptype=:apptype", nativeQuery = true)
    List<Transactions> fetchTransactionsByApptype(@Param("apptype") String apptype);

    @Query(value = "SELECT * FROM u_g_student_accounts WHERE apptype=:apptype AND (response='Approved Successful' OR response='Transaction Successful')", nativeQuery = true)
    List<Transactions> fetchSuccessfulTransactionsByApptype(@Param("apptype") String apptype);

    @Query(value = "SELECT st.*, us.name,us.surname,us.firstname,us.othername,us.email,us.matric,us.formnumber,us.utme,us.activesession,us.usertype FROM u_g_student_accounts st INNER JOIN users us ON st.matricno = us.matricno WHERE email=:email", nativeQuery = true)
    List<TransactionsDisplayInterface> getUserPaymentDetails(@Param("email") String email);

    @Query(value = "SELECT st.*, us.name,us.surname,us.firstname,us.othername,us.email,us.matric,us.formnumber,us.utme,us.activesession,us.usertype FROM u_g_student_accounts st INNER JOIN users us ON st.matricno = us.matricno WHERE us.activesession=:ses", nativeQuery = true)
    List<TransactionsDisplayInterface> fetchPaymentTransactionsBySession(@Param("ses") String ses);

    @Query(value = "SELECT st.*, us.name,us.surname,us.firstname,us.othername,us.email,us.matric,us.formnumber,us.utme,us.activesession,us.usertype,us.apptype as AppType FROM u_g_student_accounts " +
            "st INNER JOIN users us ON st.matricno = us.matricno WHERE us.activesession=:ses AND us.apptype=:apptype AND (response='Approved Successful' OR response='Transaction Successful')", nativeQuery = true)
    List<TransactionsDisplayInterface> fetchPaymentTransactionsBySessionApptype(@Param("ses") String ses, @Param("apptype") String apptype);

    @Query(value = "SELECT st.*, us.name,us.surname,us.firstname,us.othername,us.email,us.matric,us.formnumber,us.utme,us.activesession,us.usertype FROM u_g_student_accounts st INNER JOIN users us ON st.matricno = us.matricno WHERE email=:email AND  response<>'Approved Successful' AND response <>'Transaction Successful'", nativeQuery = true)
    List<TransactionsDisplayInterface> fetchUserFailedPaymentAttempts(@Param("email") String email);
}
