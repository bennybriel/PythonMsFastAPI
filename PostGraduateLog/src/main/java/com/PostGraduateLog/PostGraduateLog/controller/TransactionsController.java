package com.PostGraduateLog.PostGraduateLog.controller;

import com.PostGraduateLog.PostGraduateLog.dto.UserByAppSessionRequest;
import com.PostGraduateLog.PostGraduateLog.dto.UserRequest;
import com.PostGraduateLog.PostGraduateLog.interfaces.TransactionsDisplayInterface;
import com.PostGraduateLog.PostGraduateLog.model.Transactions;
import com.PostGraduateLog.PostGraduateLog.reponses.TransactionsJoinUsersReponse;
import com.PostGraduateLog.PostGraduateLog.service.TransactionsService;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@SecurityScheme(name = "jwtBearerAuth",type = SecuritySchemeType.HTTP)
@Tag(name="Transaction Controller Handles All Payment Transactions")

public class TransactionsController {
    private  final TransactionsService transactionsService;

    @RequestMapping(value = "/api/v1/transactionByPage/{pageNumber}/{pageSize}/{sortProperty}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Transactions> transactionsByPaging(@PathVariable Integer pageNumber,
                                                   @PathVariable Integer pageSize,
                                                   @PathVariable String sortProperty)
    {
        return transactionsService.getAllTransactionByPage(pageNumber,pageSize, sortProperty);
    }

    @RequestMapping(value = "/api/v1/transactionByPage/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Transactions> transactionsByPaging(@PathVariable Integer pageNumber,
                                                   @PathVariable Integer pageSize
                                                   )
    {
        return transactionsService.getAllTransactionByPage(pageNumber,pageSize, null);
    }
    @RequestMapping("/api/v1/transactionsByApptype/{apptype}")
    @ResponseStatus(HttpStatus.OK)
    public List<Transactions> fetchAllTransactionsByApptype(@PathVariable String apptype)
    {
        return transactionsService.getAllTransactionByApptype(apptype);
    }
    @RequestMapping("/api/v1/transactionsSuccessfulByApptype/{apptype}")
    @ResponseStatus(HttpStatus.OK)
    public List<Transactions> fetchAllSuccessfulTransactionsByApptype(@PathVariable String apptype)
    {
        return transactionsService.getAllSuccessfullTransactionByApptype(apptype);
    }

    @RequestMapping(value = "/api/v1/userPaymentRecord/{email}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionsDisplayInterface> getUserPaymentDetails(@PathVariable String email)
    {
        return transactionsService.getUserPaymentDetailRecord(email);
    }

    @PostMapping
    @RequestMapping("/api/v1/transactionsBySession")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionsDisplayInterface> fetchPaymentsBySession(@RequestBody UserRequest userRequest)
    {
        return transactionsService.fetchPaymentRecordBySession(userRequest.getActivesession());
    }

    @PostMapping
    @RequestMapping("/api/v1/transactionsBySessionApptype")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionsDisplayInterface> fetchPaymentsBySessionApptype(@RequestBody UserByAppSessionRequest userByAppSessionRequest)
    {
        return transactionsService.fetchPaymentRecordBySessionApptype(userByAppSessionRequest.getActivesession(),userByAppSessionRequest.getApptype());
    }

    @RequestMapping(value = "/api/v1/userFailedPaymentAttempts/{email}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionsDisplayInterface> fetchUserFailedPaymentDetails(@PathVariable String email)
    {
        return transactionsService.fetchUserFailedPaymentRecord(email);
    }

}
