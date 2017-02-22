package uo.asw.participants.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;



import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import es.uniovi.asw.Application;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ParticipantControllerTest {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private MockMvc mockMvc;


	@SuppressWarnings("rawtypes")
	private HttpMessageConverter mappingJackson2HttpMessageConverter;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {

		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().orElse(null);

		assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
	}

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
    public void wrongPostParticipantInfo() throws Exception {
        mockMvc.perform(post("/user")
                .content("{\"login\":\"berto@doe.com\"")
                .contentType(contentType))
                .andExpect(status().isBadRequest());
    }
	
	@Test
    public void participantNotFound() throws Exception {
        mockMvc.perform(post("/user")
                .content("{\"login\":\"adrian@hotmail.com\", \"password\":\"adrian123\"}")
                .contentType(contentType))
                .andExpect(status().isNotFound());
    }
	
	@Test
    public void participantFound() throws Exception {
        mockMvc.perform(post("/user")
                .content("{\"login\":\"berto@doe.com\", \"password\":\"berto123\"}")
                .contentType(contentType))
                .andExpect(status().isOk());
    }
	
	@Test
    public void okChangePassword() throws Exception {
		//Cambiamos la password a berto
        mockMvc.perform(post("/changePassForm")
                .content("{\"login\":\"berto@doe.com\", \"password\":\"berto123\", \"newPassword\":\"berto123456\"}")
                .contentType(contentType))
                .andExpect(status().isOk());
        
        //Comprobamos que, efectivamente, se ha cambiado su password
        mockMvc.perform(post("/user")
                .content("{\"login\":\"berto@doe.com\", \"password\":\"berto123456\"}")
                .contentType(contentType))
                .andExpect(status().isOk());
    }
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
	
}

	