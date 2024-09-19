package com.micro.electronicappliance.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.micro.electronicappliance.model.AdministrativeUser;
import com.micro.electronicappliance.repo.AdminuserRepo;

@ExtendWith(MockitoExtension.class)
class AdminServiceImplTest {
	 @Mock
	    private AdminuserRepo adminuserRepo;

	    @InjectMocks
	    private AdminServiceImpl adminService;

	    private AdministrativeUser adminUser;
	    @BeforeEach
	    public void setUp() {
	        adminUser = new AdministrativeUser(1, "John Doe", "john@example.com", "password123", "ADMIN", new Date(0));
	    }

	@Test
	void testSaveAdministrativeUser() {
		when(adminuserRepo.save(any(AdministrativeUser.class))).thenReturn(adminUser);

        AdministrativeUser savedUser = adminService.saveAdministrativeUser(adminUser);

        assertNotNull(savedUser);
        assertEquals(adminUser.getAdminUserId(), savedUser.getAdminUserId());
        verify(adminuserRepo, times(1)).save(adminUser);
	}

	@Test
     void testGetAdministrativeUserById() {
        when(adminuserRepo.findById(1)).thenReturn((adminUser));

        AdministrativeUser foundUser = adminService.getAdministrativeUserById(1);

        assertNotNull(foundUser);
        assertEquals(adminUser.getUserName(), foundUser.getUserName());
        verify(adminuserRepo, times(1)).findById(1);
    }

    @Test
     void testGetAllAdministrativeUsers() {
        List<AdministrativeUser> users = new ArrayList<>();
        users.add(adminUser);
        when(adminuserRepo.findAll()).thenReturn(users);

        List<AdministrativeUser> foundUsers = adminService.getAllAdministrativeUsers();

        assertFalse(foundUsers.isEmpty());
        assertEquals(1, foundUsers.size());
        verify(adminuserRepo, times(1)).findAll();
    }

  
    

    @Test
     void testUpdateAdministrativeUser() {
        when(adminuserRepo.findById(1)).thenReturn(adminUser);
        when(adminuserRepo.save(any(AdministrativeUser.class))).thenReturn(adminUser);

        AdministrativeUser updatedUser = adminService.updateAdministrativeUser(adminUser);

        assertNotNull(updatedUser);
        assertEquals(adminUser.getAdminUserId(), updatedUser.getAdminUserId());
        verify(adminuserRepo, times(1)).save(adminUser);
    }

    @Test
     void testUpdateAdministrativeUser_NotFound() {
        when(adminuserRepo.findById(1)).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            adminService.updateAdministrativeUser(adminUser);
        });

        assertEquals("AdministrativeUser with ID 1 does not exist.", exception.getMessage());
        verify(adminuserRepo, never()).save(any(AdministrativeUser.class));
    }
}
