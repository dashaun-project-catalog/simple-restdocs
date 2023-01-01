package dev.dashaun.rest.simple.simplerest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
// import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.resourceDetails;
// import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
// import static com.epages.restdocs.apispec.ResourceDocumentation.parameterWithName;
// import static com.epages.restdocs.apispec.ResourceDocumentation.resource;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(GreetingController.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
class WebLayerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/greeting"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, World")))
				.andDo(document("greeting"));
	}
}
