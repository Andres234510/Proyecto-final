import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.AdminController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Administrador;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Medico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class AdminControllerTest {

    private AdminController adminController;
    private Administrador administradorMock;

    @BeforeEach
    void setUp() {
        administradorMock = mock(Administrador.class);
        adminController = new AdminController(administradorMock);
    }

    @Test
    void registrarMedico_conMedicoValido_debeInvocarRegistro() {
        Medico medico = new Medico(); // Se puede inicializar con atributos si es necesario

        adminController.registrarMedico(medico);

        verify(administradorMock, times(1)).registrarMedico(medico);
    }

    @Test
    void registrarMedico_conMedicoNulo_noDebeInvocarRegistro() {
        adminController.registrarMedico(null);

        verify(administradorMock, never()).registrarMedico(any());
    }
}
