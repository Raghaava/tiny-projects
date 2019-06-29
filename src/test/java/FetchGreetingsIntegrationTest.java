//import learning.Application;
//import learning.service.DataService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest(classes = Application.class)
//@AutoConfigureMockMvc
//@RunWith(value = SpringRunner.class)
//@ActiveProfiles("local")
//public class FetchGreetingsIntegrationTest {
//    @Autowired
//    private MockMvc mockMVc;
//
//    @Value("${foo}")
//    private String foo;
//
//    @Test
//    public void testFooValue(){
//    Assert.assertTrue("bar".equalsIgnoreCase(foo));
//    }
//
//    @Test
//    public void testFetchGreetings() throws Exception {
//        mockMVc.perform(get("/greetings"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Hello, World!"));
//    }
//}
