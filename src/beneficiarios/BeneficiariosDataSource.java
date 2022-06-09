package beneficiarios;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Raul Portillo
 * Implementamos JRDataSource, es un tipo de fuente de datos para
 * trabajar con JasperR...
 */
public class BeneficiariosDataSource implements JRDataSource {

    private final Object[][] beneficiarios;
    private int index;

    public BeneficiariosDataSource() {
        index = -1;
        beneficiarios = new Object[][]{
            {"CARLA ESTRADA VALLE", "RESIDENCIAL VERSALLES CASA 12", 000, "MASCULINO", 50},
            {"CARMEN MARIA ORELLANA", "COLONIA LAS MARGARITAS CASA 5", 000, "FEMENINO", 50},
        };
    }

    /**
     * 
     * @return
     * @throws JRException 
     * Para colocarnos en determinado indice del arreglo de datos
     */
    @Override
    public boolean next() throws JRException {
        index++;
        return (index < beneficiarios.length);
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {

        Object value = null;

        String fieldName = jrf.getName();

        switch (fieldName) {

            case "Nombre":
                value = beneficiarios[index][0];
                break;
            case "Direccion":
                value = beneficiarios[index][1];
                break;
            case "Edad":
                value = beneficiarios[index][2];
                break;
            case "Genero":
                value = beneficiarios[index][3];
                break;
            case "Porcentaje":
                value = beneficiarios[index][4];
                break;

        }

        return value;

    }

    public static JRDataSource getDataSource() {
        return new BeneficiariosDataSource();
    }

}
