package com.klg.interview;

import com.klg.interview.controller.ReservationController;
import com.klg.interview.domain.Reservation;
import com.klg.interview.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TestService {
    @MockBean
    private ReservationService reservationService;

    @InjectMocks
    private ReservationController reservationController;

    @Test
    void shouldUpdateReservationServiceTest() throws Exception {
        // GIVEN
        Reservation reservation1 = new Reservation(10L, 3L, 2L, 4L, LocalDate.of(2022, 5, 1),
                LocalDate.of(2022, 7, 31), BigDecimal.valueOf(5000.00));

        reservationController.updateReservation(reservation1);

        // WHEN & THEN
        verify(reservationService, times(1)).saveReservation(reservation1);
    }
}
