//package tests;
//
//import com.spitter.controller.SpitterController;
//import org.junit.Test;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//public class RegisterFormTest {
//
//    @Test
//    public void shouldShowRegistration() throws Exception{
//        SpitterController controller = new SpitterController();
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//
//        mockMvc.perform(get("/spitter/register")).andExpect(view().name("RegisterForm"));
//    }
//}
