package org.zayim;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.zayim.controller.SuperheroController;
import org.zayim.service.SuperheroService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = org.zayim.TestContext.class)
public class SuperheroTest {

    private MockMvc mockMvc;

    @Mock
    private SuperheroService superheroService;

    @InjectMocks
    private SuperheroController superheroController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(superheroController).build();
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/superhero")).andExpect(status().isOk());
    }

    @Test
    public void testGetById() throws Exception {
        mockMvc.perform(get("/superhero/1")).andExpect(status().isNotFound());
    }

    @Test
    public void testAdd() throws Exception {
        mockMvc.perform(
            post("/superhero").
            contentType(MediaType.APPLICATION_JSON).
            content("{\"name\":\"Bruce Wayne\",\"pseudonym\":\"Batman\",\"publisher\":\"Marvel\",\"skills\":[\"Flying\",\"Criminal fight\"],\"allies\":[\"Catwoman\",\"Alfred\",\"Robin\"],\"firstAppearance\":\"1939-05-01\"}")
        ).andExpect(status().isOk());
    }

}
