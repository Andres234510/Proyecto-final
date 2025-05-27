import co.edu.uniquindio.javafxtestnoche.proyectofinal.service.MedicoService;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Medico;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MedicoTest{
    @Test
    public void agregarMedico(){
        Medico medico =new Medico("1","Pepe","pepe@pepaping.com.pe","311","PEDIATRIA");
        MedicoService.agregar(medico);
        assertEquals(medico,MedicoService.getMedicos.get(0));
    }
}