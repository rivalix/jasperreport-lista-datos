package beneficiarios;

import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Raul Portillo
 */
public class BeneficiarioJasper {

    public BeneficiarioJasper(){
        
        try{
        
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/reports/beneficiarios.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, null, BeneficiariosDataSource.getDataSource());
            
            //Si lo queremos en PDF usar esta linea
            JasperExportManager.exportReportToPdfFile(jprint, "C:/Java/Beneficiarios.pdf");
            
            //Si lo queremos ver en el visor de Jasper usar estas lineas y comentar la anterior
            /*JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);*/
            
            
        }catch(JRException ex){
            ex.getMessage();
        }
        
    
    
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        BeneficiarioJasper jasper = new BeneficiarioJasper();
        

    }
    
}
