package com.mjuillard.keycloaksecurityappserver;


import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.test.context.junit4.SpringRunner;

import com.mjuillard.keycloaksecurityappserver.config.CommonSecurityConfigurerAdapter;
import com.mjuillard.keycloaksecurityappserver.controller.KeycloakSecurityAppController;

@RunWith(SpringRunner.class)
@Import(SecurityTestConfiguration.class)
@WebMvcTest(value = KeycloakSecurityAppController.class)
public class KeycloakSecurityAppServerSecurityTests {

//    @Autowired
//    MockMvc mockMvc;
//    
//    @Test
//    public void testUnsecuredPathIsAllowedForAll() throws Exception {
//        mockMvc.perform( MockMvcRequestBuilders.get("/unsecured"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").value("This is an unsecured endpoint payload"));
//    }
//
//    @Test
//    @WithMockUser
//    public void testAdminPathIsNotAllowedForAll() throws Exception {
//        mockMvc.perform( MockMvcRequestBuilders.get("/admin"))
//                .andExpect(status().isForbidden());
//    }
//
//    @Test
//    @WithMockUser(roles = "ADMIN")
//    public void testAdmindPathIsOnlyAllowedForAdminProfil() throws Exception {
//        mockMvc.perform( MockMvcRequestBuilders.get("/admin"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").value("This is an ADMIN endpoint payload"));
//    }
//
//    @Test
//    @WithMockUser(roles = "USER")
//    public void testAdmindPathIsNotAllowedForUserProfil() throws Exception {
//        mockMvc.perform( MockMvcRequestBuilders.get("/admin"))
//                .andExpect(status().isForbidden());
//    }
}

@TestConfiguration
@EnableWebSecurity
@Order(1000)
 class SecurityTestConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // use the common configuration to validate matchers
        http.apply(new CommonSecurityConfigurerAdapter());

    }
}

