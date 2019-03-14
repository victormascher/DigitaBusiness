package br.com.fiap.view;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class WSTable {

	protected Shell shell;
	private Table tbProduto;
	private Text pesqcod;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WSTable window = new WSTable();
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
		
		tbProduto = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tbProduto.setBounds(10, 83, 393, 149);
		tbProduto.setHeaderVisible(true);
		tbProduto.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(tbProduto, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("codigo");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(tbProduto, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("descricao");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(tbProduto, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("preco");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(tbProduto, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("qtde");
		
		Label lblPesquisarProduto = new Label(shell, SWT.NONE);
		lblPesquisarProduto.setBounds(10, 10, 107, 15);
		lblPesquisarProduto.setText("Pesquisar Codigo");
		
		pesqcod = new Text(shell, SWT.BORDER);
		pesqcod.setBounds(10, 34, 76, 21);
		
		Button btnPesquisar = new Button(shell, SWT.PUSH);
		btnPesquisar.setText("OK");
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
									try {
					EstoqueBOStub stub = new EstoqueBOStub();
					ConsultarProduto consulta = new ConsultarProduto();
				
					consulta.setCodigo(Integer.parseInt(pesqcod.getText()));
					
					ConsultarProdutoResponse resp = stub.consultarProduto(consulta);
					
					ProdutoTO prod = resp.get_return();
					
					TableItem item = new TableItem(tbProduto, 0); item.setText(new String[] {
							String.valueOf(prod.getCodigo()),
							prod.getDescricao(),
							String.valueOf(prod.getPreco()),
							String.valueOf(prod.getQuantidade())
					});
					
					
				} catch (Exception e1) {
					MessageDialog.openInformation(shell, "SWT", "GoGo Power Rangers!");
					
					MessageBox mb = new MessageBox(shell, SWT.OK|SWT.CANCEL);
					mb.setMessage("Para sair clique em OK");
					int result = mb.open();
					if ( result == SWT.OK) { System.out.println("Sistema finalizado!");
					System.exit(0); //* encerra programa } if (result == SWT.CANCEL) System.out.println(“cancela foi pressionado”);
					}

					e1.printStackTrace();
				}
				
				
			}
		});
		btnPesquisar.setBounds(106, 30, 75, 25);
		btnPesquisar.setText("Pesquisar!");

	}
}
