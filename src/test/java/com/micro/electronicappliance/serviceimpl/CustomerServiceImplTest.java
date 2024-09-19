package com.micro.electronicappliance.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.micro.electronicappliance.model.Customer;
import com.micro.electronicappliance.repo.CustomerRepo;
@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerRepo repo;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private Customer customer;

    @BeforeEach
     void setUp() {
        customer = new Customer(1, "Jannie", "jane@example.com", "password123", "1234567890", "user", "123 Street", "123456", "State", "District", "City");
    }

    @Test
     void testSaveCustomer() {
        when(repo.save(any(Customer.class))).thenReturn(customer);

        Customer savedCustomer = customerService.saveCustomer(customer);

        assertNotNull(savedCustomer);
        assertEquals(customer.getCid(), savedCustomer.getCid());
        verify(repo, times(1)).save(any(Customer.class));
    }

    @Test
     void testGetCustomerById() {
        when(repo.findById(1)).thenReturn(customer);

        Customer foundCustomer = customerService.getCustomerById(1);

        assertNotNull(foundCustomer);
        assertEquals(customer.getName(), foundCustomer.getName());
        verify(repo, times(1)).findById(1);
    }

    @Test
     void testGetAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        when(repo.findAll()).thenReturn(customers);

        List<Customer> foundCustomers = customerService.getAllCustomers();

        assertFalse(foundCustomers.isEmpty());
        assertEquals(1, foundCustomers.size());
        verify(repo, times(1)).findAll();
    }

    @Test
     void testDeleteCustomerById() {
        doNothing().when(repo).delete(1);

        assertDoesNotThrow(() -> customerService.deleteCustomerById(1));
        verify(repo, times(1)).delete(1);
    }

    @Test
     void testUpdateCustomer() {
        when(repo.findById(1)).thenReturn(customer);
        when(repo.update(any(Customer.class))).thenReturn(customer);

        Customer updatedCustomer = customerService.updateCustomer(1, customer);

        assertNotNull(updatedCustomer);
        assertEquals(customer.getCid(), updatedCustomer.getCid());
        verify(repo, times(1)).update(customer);
    }

    @Test
     void testUpdateCustomer_NotFound() {
        when(repo.findById(1)).thenReturn(null);

        Customer updatedCustomer = customerService.updateCustomer(1, customer);

        assertNull(updatedCustomer);
        verify(repo, never()).update(any(Customer.class));
    }
}