package com.iweb2b.api.integration.service;

import com.iweb2b.api.integration.controller.exception.BadRequestException;
import com.iweb2b.api.integration.model.customer.*;
import com.iweb2b.api.integration.repository.CustomerRepository;
import com.iweb2b.api.integration.repository.Specification.CustomerSpecification;
import com.iweb2b.api.integration.util.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    /**
     * getCustomers
     * @return
     */
    public List<Customer> getCustomers(){
      List<Customer> customerList=customerRepository.findAll();
      customerList = customerList.stream().filter(n -> n.getDeletionIndicator() == 0).collect(Collectors.toList());
      return customerList;
    }
    /**
     * getCustomer
     *
     * @param customerId
     * @return
     */
    public Customer getCustomer(Long customerId,String companyId,String languageId){
        Optional<Customer> dbCustomer=
                     customerRepository.findByCompanyIdAndCustomerIdAndLanguageIdAndDeletionIndicator(
                             companyId,
                             customerId,
                             languageId,
                             0l
                     );
        if (dbCustomer.isEmpty()) {
            throw new BadRequestException("The given values : " +
                      "customerId - " + customerId +
                    "doesn't exist.");
        }
        return dbCustomer.get();
    }
    /**
     * createCustomer
     * @param newCustomer
     * @param loginUserID
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public Customer createCustomer (AddCustomer newCustomer, String loginUserID)
            throws IllegalAccessException, InvocationTargetException {
        Customer dbCustomer = new Customer();
        BeanUtils.copyProperties(newCustomer, dbCustomer, CommonUtils.getNullPropertyNames(newCustomer));
        dbCustomer.setDeletionIndicator(0L);
        dbCustomer.setCreatedBy(loginUserID);
        dbCustomer.setUpdatedBy(loginUserID);
        dbCustomer.setCreatedOn(new Date());
        dbCustomer.setUpdatedOn(new Date());
        return customerRepository.save(dbCustomer);
    }
    /**
     * updateCustomer
     * @param loginUserID
     * @param customerId
     * @param updateCustomer
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public Customer updateCustomer(Long  customerId,String companyId,String languageId, String loginUserID,
                                 UpdateCustomer updateCustomer)
            throws IllegalAccessException, InvocationTargetException {
        Customer dbCustomer = getCustomer(customerId,companyId,languageId);
        BeanUtils.copyProperties(updateCustomer, dbCustomer, CommonUtils.getNullPropertyNames(updateCustomer));
        dbCustomer.setUpdatedBy(loginUserID);
        dbCustomer.setUpdatedOn(new Date());
        return customerRepository.save(dbCustomer);
    }
    /**
     * deleteCustomer
     * @param loginUserID
     * @param customerId
     */
    public void deleteCustomer(Long  customerId,String companyId,String languageId,String loginUserID) {
        Customer dbCustomer = getCustomer(customerId,companyId,languageId);
        if ( dbCustomer != null) {
            dbCustomer.setDeletionIndicator(1L);
            dbCustomer.setUpdatedBy(loginUserID);
            customerRepository.save(dbCustomer);
        } else {
            throw new EntityNotFoundException("Error in deleting Id: " + customerId);
        }
    }

    //Find Customer
    public List<Customer> findCustomer(FindCustomer findCustomer) throws ParseException {

        CustomerSpecification spec = new CustomerSpecification(findCustomer);
        List<Customer> results = customerRepository.findAll(spec);
        return results;
    }

  }
