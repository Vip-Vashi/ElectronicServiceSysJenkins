package com.micro.electronicappliance.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

import com.micro.electronicappliance.model.ServiceRequest;
import com.micro.electronicappliance.model.Technician;
import com.micro.electronicappliance.repo.RequestRepo;
import com.micro.electronicappliance.repo.TechnicianRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceReqServiceImplTest {

    @Mock
    private RequestRepo repo;

    @Mock
    private TechnicianRepo technicianRepo;

    @InjectMocks
    private ServiceReqServiceImpl serviceReqService;

    private ServiceRequest serviceRequest;

    @BeforeEach
     void setUp() {
        serviceRequest = new ServiceRequest();
    }

    @Test
     void testSave() {
        doNothing().when(repo).save(any(ServiceRequest.class));

        assertDoesNotThrow(() -> serviceReqService.save(serviceRequest));
        verify(repo, times(1)).save(any(ServiceRequest.class));
    }

    @Test
     void testFindById() {
        when(repo.findById(1)).thenReturn(serviceRequest);

        ServiceRequest foundRequest = serviceReqService.findById(1);

        assertNotNull(foundRequest);
        assertEquals(serviceRequest.getIssuedes(), foundRequest.getIssuedes());
        verify(repo, times(1)).findById(1);
    }

    @Test
     void testFindAll() {
        List<ServiceRequest> requests = new ArrayList<>();
        requests.add(serviceRequest);
        when(repo.findAll()).thenReturn(requests);

        List<ServiceRequest> foundRequests = serviceReqService.findAll();

        assertFalse(foundRequests.isEmpty());
        assertEquals(1, foundRequests.size());
        assertEquals(serviceRequest.getIssuedes(), foundRequests.get(0).getIssuedes());
        verify(repo, times(1)).findAll();
    }

    @Test
     void testUpdate() {
        doNothing().when(repo).update(any(ServiceRequest.class));

        assertDoesNotThrow(() -> serviceReqService.update(serviceRequest));
        verify(repo, times(1)).update(any(ServiceRequest.class));
    }

    @Test
     void testDelete() {
        doNothing().when(repo).delete(1);

        assertDoesNotThrow(() -> serviceReqService.delete(1));
        verify(repo, times(1)).delete(1);
    }

    @Test
     void testAssignTech() {
        Technician technician = new Technician();
        technician.setTechId(1);
        when(repo.findById(1)).thenReturn(serviceRequest);
        when(technicianRepo.findById(1)).thenReturn(technician);
        doNothing().when(repo).update(any(ServiceRequest.class));

        serviceReqService.assignTech(1, 1);

        assertEquals("Assigned", serviceRequest.getServicests());
        assertEquals(technician, serviceRequest.getTechnician());
        verify(repo, times(1)).findById(1);
        verify(technicianRepo, times(1)).findById(1);
        verify(repo, times(1)).update(any(ServiceRequest.class));
    }

    @Test
     void testChangeStatus() {
        when(repo.findById(1)).thenReturn(serviceRequest);
        doNothing().when(repo).update(any(ServiceRequest.class));

        serviceReqService.changests(1, "Completed");

        assertEquals("Completed", serviceRequest.getServicests());
        verify(repo, times(1)).findById(1);
        verify(repo, times(1)).update(any(ServiceRequest.class));
    }

    @Test
     void testRating() {
        when(repo.findById(1)).thenReturn(serviceRequest);
        doNothing().when(repo).update(any(ServiceRequest.class));

        serviceReqService.rating(1, "5", "Great Service");

        assertEquals("5", serviceRequest.getRating());
        assertEquals("Great Service", serviceRequest.getFeedback());
        verify(repo, times(1)).findById(1);
        verify(repo, times(1)).update(any(ServiceRequest.class));
    }

    @Test
     void testChangePendingStatus() {
        when(repo.findById(1)).thenReturn(serviceRequest);
        doNothing().when(repo).update(any(ServiceRequest.class));

        serviceReqService.changependingsts(1, "Pending", "Awaiting parts");

        assertEquals("Pending", serviceRequest.getServicests());
        assertEquals("Awaiting parts", serviceRequest.getRemark());
        verify(repo, times(1)).findById(1);
        verify(repo, times(1)).update(any(ServiceRequest.class));
    }
}
