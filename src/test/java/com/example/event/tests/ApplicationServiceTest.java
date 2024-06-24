package com.example.event.tests;

import com.example.event.entity.Application;
import com.example.event.repository.ApplicationRepository;
import com.example.event.services.ApplicationService;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceTest {
    @Mock
    private ApplicationRepository applicationRepository;
    @InjectMocks
    private ApplicationService applicationService;

    @Test
    public void testAddApplication() {
        Application application = new Application("Test", "Desc");
        when(applicationRepository.save(application))
                .thenReturn(application);
        applicationService.addApplication(application);
        verify(applicationRepository).save(application);
    }
}
