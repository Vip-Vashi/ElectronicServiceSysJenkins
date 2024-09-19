package com.micro.electronicappliance.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.micro.electronicappliance.model.Technician;
import com.micro.electronicappliance.repo.TechnicianRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class TechnicianServiceImplTest {

    @Mock
    private TechnicianRepo repo;

    @InjectMocks
    private TechnicianServiceImpl technicianService;

    private Technician technician;

    @BeforeEach
    public void setUp() {
        technician = new Technician(1, "Technician", "John Doe", "1234567890", "johndoe", "password", 
                                    "Electrical", "Repair", "Available", "District", "City", "123456");
    }

    @Test
     void testSaveTech() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        technician.setPassword(encoder.encode(technician.getPassword()));
        when(repo.save(any(Technician.class))).thenReturn(technician);

        Technician savedTech = technicianService.saveTech(technician);

        assertNotNull(savedTech);
        assertEquals(technician.getTname(), savedTech.getTname());
        assertNotEquals("password", savedTech.getPassword());  // Ensure password is encoded
        verify(repo, times(1)).save(any(Technician.class));
    }

    @Test
     void testGetById() {
        when(repo.findById(1)).thenReturn(technician);

        Technician foundTech = technicianService.getById(1);

        assertNotNull(foundTech);
        assertEquals(technician.getUsername(), foundTech.getUsername());
        verify(repo, times(1)).findById(1);
    }

    @Test
     void testGetAll() {
        List<Technician> techs = new ArrayList<>();
        techs.add(technician);
        when(repo.findAll()).thenReturn(techs);

        List<Technician> foundTechs = technicianService.getAll();

        assertFalse(foundTechs.isEmpty());
        assertEquals(1, foundTechs.size());
        assertEquals(technician.getTname(), foundTechs.get(0).getTname());
        verify(repo, times(1)).findAll();
    }

    @Test
     void testDeleteById() {
        doNothing().when(repo).delete(1);

        assertDoesNotThrow(() -> technicianService.deleteById(1));
        verify(repo, times(1)).delete(1);
    }

    @Test
     void testUpdateTech() {
        when(repo.findById(1)).thenReturn(technician);
        when(repo.update(any(Technician.class))).thenReturn(technician);

        Technician updatedTech = technicianService.updateTech(1, technician);

        assertNotNull(updatedTech);
        assertEquals(technician.getTname(), updatedTech.getTname());
        verify(repo, times(1)).findById(1);
        verify(repo, times(1)).update(any(Technician.class));
    }

    @Test
     void testUpdatePwd_Success() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        technician.setPassword(encoder.encode("oldpassword"));
        when(repo.findById(1)).thenReturn(technician);
        when(repo.update(any(Technician.class))).thenReturn(technician);

        Technician updatedTech = technicianService.updatePwd(1, "oldpassword", "newpassword");

        assertNotNull(updatedTech);
        assertNotEquals("oldpassword", updatedTech.getPassword());
        verify(repo, times(1)).findById(1);
        verify(repo, times(1)).update(any(Technician.class));
    }

    @Test
     void testUpdatePwd_Failure() {
        when(repo.findById(1)).thenReturn(technician);

        Technician updatedTech = technicianService.updatePwd(1, "wrongpassword", "newpassword");

        assertNull(updatedTech);
        verify(repo, times(1)).findById(1);
        verify(repo, never()).update(any(Technician.class));
    }}

  
