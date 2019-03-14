import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class Tela {

	protected Shell shell;
	private Text n2;
	private Text n1;
	private Text result;
	private Text cepori;
	private Text cepdest;
	private Text prazotxt;
	private Text datatxt;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblNumeroUm = new Label(shell, SWT.NONE);
		lblNumeroUm.setBounds(10, 10, 55, 15);
		lblNumeroUm.setText("numero um");
		
		Label lblNumeroDois = new Label(shell, SWT.NONE);
		lblNumeroDois.setBounds(10, 59, 55, 15);
		lblNumeroDois.setText("numero dois");
		
		Label lblResultado = new Label(shell, SWT.NONE);
		lblResultado.setBounds(10, 121, 55, 15);
		lblResultado.setText("resultado");
		
		Button btnSomar = new Button(shell, SWT.NONE);
		btnSomar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//executado no clique do botao
				//capturar os dois valores
				
				int num1 = Integer.parseInt(n1.getText());
				int num2 = Integer.parseInt(n2.getText());
				//somar
				
				int soma  = num1 + num2;
				
				//exibir resposta
				result.setText(Integer.toString(soma));
				
				
			}
		});
		btnSomar.setBounds(10, 91, 75, 25);
		btnSomar.setText("somar");
		
		n2 = new Text(shell, SWT.BORDER);
		n2.setBounds(119, 59, 76, 21);
		
		n1 = new Text(shell, SWT.BORDER);
		n1.setBounds(119, 10, 76, 21);
		
		result = new Text(shell, SWT.BORDER);
		result.setBounds(119, 121, 76, 21);
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(229, 10, 2, 241);
		
		Label cepo = new Label(shell, SWT.NONE);
		cepo.setBounds(237, 10, 55, 15);
		cepo.setText("CEP Origem");
		
		Label cepd = new Label(shell, SWT.NONE);
		cepd.setBounds(237, 59, 55, 15);
		cepd.setText("CEP Destino");
		
		cepori = new Text(shell, SWT.BORDER);
		cepori.setBounds(312, 10, 76, 21);
		
		cepdest = new Text(shell, SWT.BORDER);
		cepdest.setBounds(312, 59, 76, 21);
		
		Button calc = new Button(shell, SWT.NONE);
		calc.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					//OBJETO QUE CHAMA O WEB SERVICE
					CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
					CalcPrazo valor = new CalcPrazo();
					
					//PARAMETROS QUE SERAO ENVIADOS AO WEB SERVICE
					valor.setNCdServico("40010");
					valor.setSCepOrigem(cepori.getText());
					valor.setSCepDestino(cepdest.getText());
					
					//CHAMANDO O WEB SERVICE E OBTENDO A RESPOSTA
					CalcPrazoResponse resp = stub.calcPrazo(valor);
					
					//EXIBIR A RESPOSTA NA TELA
					prazotxt.setText(resp.getCalcPrazoResult().getServicos().getCServico()[0].getPrazoEntrega());
					datatxt.setText(resp.getCalcPrazoResult().getServicos().getCServico()[0].getDataMaxEntrega());
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		calc.setBounds(271, 102, 75, 25);
		calc.setText("CALCULAR");
		
		Label prazo = new Label(shell, SWT.NONE);
		prazo.setBounds(237, 147, 55, 15);
		prazo.setText("Prazo");
		
		prazotxt = new Text(shell, SWT.BORDER);
		prazotxt.setBounds(312, 147, 76, 21);
		
		Label maxdata = new Label(shell, SWT.NONE);
		maxdata.setBounds(237, 197, 55, 15);
		maxdata.setText("Data M\u00E1xima");
		
		datatxt = new Text(shell, SWT.BORDER);
		datatxt.setBounds(312, 191, 76, 21);

	}
}
