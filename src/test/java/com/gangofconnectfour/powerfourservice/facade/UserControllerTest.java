package com.gangofconnectfour.powerfourservice.facade;

import com.gangofconnectfour.powerfourservice.model.User;
import com.gangofconnectfour.powerfourservice.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository users;

    @Test
    public void should_create_a_user() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("email", "legend@korra.com");
        params.put("password", "P@ssword");
        params.put("nickname", "Korra");
        User user = new User(params.get("email"), params.get("password"), false);

        when(users.save(any(User.class))).thenReturn(user);
        mockMvc.perform(post("/api/users")
                .param("mail", params.get("email"))
                .param("password", params.get("password"))
        )
                .andExpect(status().isCreated())
                .andExpect(content().string("sAS"));

    }

    @Test
    public void should_get_a_user() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("email", "legend@korra.com");
        params.put("password", "P@ssword");
        params.put("uuid", "1600738758471650737");
        User user = new User(params.get("email"), params.get("password"), false);

        when(users.findByUuid(Long.parseLong(params.get("uuid")))).thenReturn(user);
        mockMvc.perform(post("/api/users")
                .param("mail", params.get("email"))
                .param("password", params.get("password"))
        )
                .andExpect(status().isCreated())
                .andExpect(content().string("sAS"));

    }
}
