package com.klg.interview;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.klg.interview.controller.ReservationController;
import com.klg.interview.date.LocalDateAdapter;
import com.klg.interview.domain.Reservation;
import com.klg.interview.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@WebMvcTest(ReservationController.class)
@SpringJUnitWebConfig
public class TestController {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationService reservationService;

    @Test
    void shouldUpdateReservationControllerTest() throws Exception {
        // GIVEN
        Reservation reservation1 = new Reservation(5L, 3L, 2L, 4L, LocalDate.of(2022, 5, 1), LocalDate.of(2022, 7, 31), BigDecimal.valueOf(5000.00));
        List<Reservation> reservationList = Arrays.asList(reservation1);

        Mockito.when(reservationService.getAllReservations()).thenReturn(reservationList);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter()) //added in order to read 'LocalDate.of' in JSON from line 38 as simple "yyyy-MM-dd"
                .create();
        String jsonConvert = gson.toJson(reservation1);

        // WHEN & THEN
        mockMvc
                .perform(MockMvcRequestBuilders
                    .put("/v1/reservation/updateReservation")
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("UTF-8")
                    .content(jsonConvert))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
