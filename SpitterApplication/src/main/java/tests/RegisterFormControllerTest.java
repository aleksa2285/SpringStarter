//package tests;
//
//import com.spitter.repository.repositoryDefinition.SpitterRepository;
//import com.spitter.util.Spitter;
//import org.junit.Test;
//
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//public class RegisterFormControllerTest {
//
//    @Test
//    public void shouldProcessRegistration() throws Exception{
//        SpitterRepository mockRepository = mock(SpitterRepository.class);
//        Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer");
//        Spitter saved = new Spitter("24L", "jbauer", "24hours", "Jack", "Bauer");
//        when(mockRepository.save(unsaved)).thenReturn(saved);
//    }
//}
