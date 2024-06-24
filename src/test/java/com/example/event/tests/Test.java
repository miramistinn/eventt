package com.example.event.tests;

import com.example.event.entity.User;
import com.example.event.repository.ClientRepository;
import com.example.event.repository.RejectedRepository;
import com.example.event.services.ClientService;
import com.example.event.services.Smetaservice;
import org.apache.catalina.connector.Request;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class Test1 {
        @Mock
        private ClientRepository clientRepository;
    @Mock
    private ClientService clientService;
        @Mock
        private RejectedRepository requestRepository;
        @InjectMocks
        private Smetaservice requestService;
        @Test
        public void endToEndTest() {
            User user = new User("user", "pass");
            when(clientService.register(user.getUsername(), user.getPassword()))
                    .thenReturn(true);
            when(clientService.create(user.getUsername(), user.getPassword()))
                    .thenReturn(true);
            Request request = new Request();
            when(requestService.createSmeta(request))
                    .thenReturn(request);
            requestService.addRequest(request);
            assertTrue(requestService.getRequests().contains(request));
            requestService.openRequest(request);
            assertEquals(request, requestService.getCurrentRequest());
            requestService.handleRequest(request, RequestStatus.APPROVED);
            assertEquals(RequestStatus.APPROVED, request.getStatus());
        }}
    @Test
    public void testViewAndEditEstimate() {
        Request request = new Request();
        requestService.openRequest(request);
        requestService.openEstimateSection();
        assertEquals(estimate, request.getEstimate());
        EstimateItem item = new EstimateItem();
        request.getEstimate().addOrUpdateItem(item);
        verify(estimateRepository).save(request.getEstimate());
        assertEquals(item, request.getEstimate().getLastItem());
        11
    }
    @Test
    public void testViewAndEditSchedule() {
        Request request = new Request();
        requestService.openRequest(request);
        requestService.openScheduleSection();
        Schedule schedule = request.getSchedule();
        assertNotNull(schedule);
        schedule.addTask(new Task());
        requestService.saveSchedule(schedule);
        Schedule savedSchedule = requestRepository.getSchedule(request);
        assertEquals(schedule, savedSchedule);
    }
    @Test
    public void testNewRequestsScreen() {
        requestService.openNewRequestsSection();
        Request req1 = new Request();
        Request req2 = new Request();
        requestService.addRequests(req1, req2);
        assertTrue(requestService.getNewRequests().containsAll(Arrays.asList(req1,
                req2)));
        requestService.viewRequest(req1);
        requestService.rejectRequest(req1);
        assertEquals(RequestStatus.REJECTED, req1.getStatus());
    }
    @Test
    public void testAddOrganizer() {
        organizerService.openAdministratorsPage();
        organizerService.clickAddButton();
        Organizer organizer = new Organizer(“email”, “password”);
        when(organizerRepository.findByEmail(organizer.getEmail()))
                .thenReturn(null);
        organizerService.createOrganizer(organizer);
        12
        verify(organizerRepository).save(organizer);
        assertNotNull(organizerService.getOrganizers().stream()
                .filter(o -> o.getEmail().equals(organizer.getEmail())));
    }




}
