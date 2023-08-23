package com.intech.session2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intech.session2.domain.MyTask;
import com.intech.session2.servier.MyTaskServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class Session2ApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@MockBean
	private MyTaskServices myTaskServices;
	@Test
	void contextLoads() throws Exception {
		MyTask myTask=MyTask.builder()
				.title("my task")
				.author("dev3")
				.description("my description")
				.build();
		given(myTaskServices.save(any(MyTask.class)))
				.willAnswer((invocation -> invocation.getArgument(0)));
		ResultActions response=mockMvc.perform(post("/api/v1/task")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(myTask)));

		response.andDo(print())
				.andExpect(status().isCreated());
	}

}
