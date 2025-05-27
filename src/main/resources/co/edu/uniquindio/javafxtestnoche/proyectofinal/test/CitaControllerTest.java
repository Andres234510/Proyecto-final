import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.CitaController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.service.CitaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class CitaControllerTest {

    private CitaController citaController;
    private CitaService citaServiceMock;

    @BeforeEach
    void setUp() {
        citaServiceMock = mock(CitaService.class);
        citaController = new CitaController(citaServiceMock);
    }

    @Test
    void registrarCita_conCitaValida_debeAgregarCita() {
        Cita cita = new Cita();

        citaController.registrarCita(cita);

        verify(citaServiceMock, times(1)).agregar(cita);
    }

    @Test
    void registrarCita_conCitaNula_noDebeAgregarCita() {
        citaController.registrarCita(null);

        verify(citaServiceMock, never()).agregar(any());
    }

    @Test
    void eliminarCita_conCitaExistente_debeEliminar() {
        Cita cita = new Cita();
        when(citaServiceMock.listar()).thenReturn(List.of(cita));

        citaController.eliminarCita(cita);

        verify(citaServiceMock, times(1)).eliminar(cita);
    }

    @Test
    void eliminarCita_conCitaInexistente_noDebeEliminar() {
        Cita cita = new Cita();
        when(citaServiceMock.listar()).thenReturn(List.of());

        citaController.eliminarCita(cita);

        verify(citaServiceMock, never()).eliminar(any());
    }
}
