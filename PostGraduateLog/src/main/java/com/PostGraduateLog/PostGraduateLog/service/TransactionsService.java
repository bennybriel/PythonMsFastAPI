package com.PostGraduateLog.PostGraduateLog.service;

import com.PostGraduateLog.PostGraduateLog.interfaces.TransactionsDisplayInterface;
import com.PostGraduateLog.PostGraduateLog.model.Transactions;
import com.PostGraduateLog.PostGraduateLog.reponses.TransactionsJoinUsersReponse;
import com.PostGraduateLog.PostGraduateLog.repository.TransactionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionsService {
    private final TransactionsRepository transactionsRepository;

    public Page<Transactions> getAllTransactionByPage(Integer pageNumber, Integer pageSize, String sortProperty)
    {

        Pageable pageable= null;
        if(null!= sortProperty)
        {
            pageable = PageRequest.of(pageNumber,pageSize, Sort.Direction.ASC, sortProperty);
        }
        else
        {
            pageable = PageRequest.of(pageNumber,pageSize);
        }

        return transactionsRepository.findAll(pageable);
    }
    public List<Transactions> getAllTransactionByApptype(String apptype)
    {
        return transactionsRepository.fetchTransactionsByApptype(apptype);
    }
    public List<Transactions> getAllSuccessfullTransactionByApptype(String apptype)
    {
        return transactionsRepository.fetchSuccessfulTransactionsByApptype(apptype);
    }
    public List<TransactionsDisplayInterface> getUserPaymentDetailRecord(String email)
    {
        return transactionsRepository.getUserPaymentDetails(email);
    }

    public List<TransactionsDisplayInterface> fetchPaymentRecordBySession(String ses)
    {
        return transactionsRepository.fetchPaymentTransactionsBySession(ses);
    }
    public List<TransactionsDisplayInterface> fetchPaymentRecordBySessionApptype(String ses, String apptype)
    {
        return transactionsRepository.fetchPaymentTransactionsBySessionApptype(ses, apptype);
    }

    public List<TransactionsDisplayInterface> fetchUserFailedPaymentRecord(String email)
    {
        return transactionsRepository.fetchUserFailedPaymentAttempts(email);
    }

}
