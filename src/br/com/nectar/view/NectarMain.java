package br.com.nectar.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.nectar.financial.Cashier;
import br.com.nectar.main.RunAllTests;
import br.com.nectar.test.unit.CashierTest;
import br.com.nectar.utils.Util;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class NectarMain extends JFrame {

	private JPanel ctpMain;
	private static final String projectLocation = System.getProperty("user.dir");
	private JTextField txtUrl;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtDescription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NectarMain frame = new NectarMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NectarMain() {
		// Apontar ao driver do Selenium
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");

		initComponents();
		createEvents();
	}
	
	/*
	 * This method contains all of the code for create and initializing components
	 */
	public String testSave() {
		String resultSave = "Teste funcionalidade Salvar!";
		String result;
		String description;
		String code;
		String cpf;
		boolean booResult = false;
		Cashier objCashier;

		description = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
		code = Util.gerarString(50, "123456789");// "2";
		cpf = Util.gerarCPFValido();
		objCashier = new Cashier(new FirefoxDriver());
		try {
			result = objCashier.testSave(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), description, code, cpf);
			if (result.contains("Caixa, ID")) {
				booResult = true;
				resultSave += "\n\nAPROVADO: Caixa salvo no Firefox!";
			}
			Assert.assertEquals(booResult, true);
		} catch (Exception e) {
			resultSave += "\n\n\nREPROVADO!\nErro ao salvar Caixa no Firefox: " + e.getMessage();
		}

		description = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
		code = Util.gerarString(50, "123456789");// "2";
		cpf = Util.gerarCPFValido();
		objCashier = new Cashier(new ChromeDriver());
		try {
			booResult = false;
			result = objCashier.testSave(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), description, code, cpf);
			if (result.contains("Caixa, ID")) {
				resultSave += "\nAPROVADO: Caixa salvo no Chrome!";
				booResult = true;
			}
			Assert.assertEquals(booResult, true);
		} catch (Exception e) {
			resultSave += "\nREPROVADO!\nErro ao salvar Caixa no Chrome: " + e.getMessage();
		}
		return resultSave;
	}
	
	public String testSearch() {
		String result = "Testar funcionalidade Buscar!";
		Boolean booResult;
		String description = txtDescription.getText();
		Cashier objCashier = new Cashier(new FirefoxDriver());

		try {
			booResult = objCashier.testSearch(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), description);
			if (booResult) {
				result += "\nAPROVADO: A funcionalidade Buscar Caixa no Firefox!";
			}
			Assert.assertEquals(booResult, true);
		} catch (Exception e) {
			result += "\nREPROVADO!\nErro quando executa a funcionalidade Buscar caixa no Chrome: " + e.getMessage();
		}

		objCashier = new Cashier(new ChromeDriver());
		try {
			booResult = false;
			booResult = objCashier.testSearch(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), description);
			if (booResult) {
				result += "\nAPROVADO: A funcionalidade Buscar Caixa no Chrome!";
			}
			Assert.assertEquals(booResult, true);
		} catch (Exception e) {
			result += "\nREPROVADO!\nErro quando executa a funcionalidade Buscar caixa no Chrome: " + e.getMessage();
		}
		return result;
	}
	
	public String testValidateSave() {
		String result = "Testar funcionalidade Validar ao salvar!";
		String description = "";
		String code = "";
		String cpf = "";
		boolean booResult = false;
		Cashier objCashier = new Cashier(new FirefoxDriver());;

		try {
			description = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
			code = Util.gerarString(50, "123456789");// "2";
			cpf = Util.gerarCPFValido();
			booResult = objCashier.testValidadeSave(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), description, code, cpf);
			if (!booResult)
				result += "\nAPROVADO: Caixa validado no Firefox!";
			Assert.assertEquals(booResult, false);
		} catch (Exception e) {
			result += "\nREPROVADO!\nErro quando valida ao salvar Caixa no Firefox: " + e.getMessage();
		}

		objCashier = new Cashier(new ChromeDriver());
		try {
			description = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
			code = Util.gerarString(50, "123456789");// "2";
			cpf = Util.gerarCPFValido();
			booResult = objCashier.testValidadeSave(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), description, code, cpf);
			if (!booResult)
				result += "\nAPROVADO: Caixa validado no Chrome!";
			Assert.assertEquals(booResult, false);
		} catch (Exception e) {
			result += "\nREPROVADO!\nErro quando valida ao salvar Caixa no Chrome: " + e.getMessage();
		}
		return result;
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setTitle("Tests Automatizados Selenium Nectar");
		setIconImage(Toolkit.getDefaultToolkit().getImage(NectarMain.class.getResource("/br/com/nectar/resources/test-128.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 468);
		ctpMain = new JPanel();
		ctpMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctpMain);
		final JTextArea txtResult = new JTextArea();
		
		JButton btnAplicarTestes = new JButton("All testes Caixa");
		btnAplicarTestes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = "";
				result += testSave();
				txtResult.setText(result);
				result += "\n\n\n" + testSearch();
				txtResult.setText(result);
				result += "\n\n\n" + testValidateSave();
				txtResult.setText(result);
			}
		});
		
		//JTextArea txtResult = new JTextArea();
		
		JLabel lblResultados = new JLabel("Resultados:");
		
		JLabel lblUrl = new JLabel("URL:");
		
		JLabel lblUsurio = new JLabel("Usuário:");
		
		JLabel lblSenha = new JLabel("Senha:");
		
		txtUrl = new JTextField();
		txtUrl.setColumns(10);
		txtUrl.setText("http://172.16.101.128:10100");
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setText("suporte@marconsoft.com.br");
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setText("!efacil#rul3z");
		
		JLabel lblLocalizar = new JLabel("Localizar:");
		
		txtDescription = new JTextField();
		txtDescription.setColumns(10);
		txtDescription.setText("caixa loia");
		
		JButton btnSaveCaixa = new JButton("Savar");
		btnSaveCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = testSave();
				txtResult.setText(result);
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = testSearch();
				txtResult.setText(result);
			}
		});
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			testValidateSave();
			}
		});
		
		GroupLayout gl_ctpMain = new GroupLayout(ctpMain);
		gl_ctpMain.setHorizontalGroup(
			gl_ctpMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addComponent(lblResultados)
					.addContainerGap(573, Short.MAX_VALUE))
				.addComponent(txtResult, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_ctpMain.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblLocalizar)
								.addComponent(lblSenha)
								.addComponent(lblUsurio)
								.addComponent(lblUrl))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
								.addComponent(txtUrl, GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(txtDescription, Alignment.LEADING)
									.addComponent(txtPassword, Alignment.LEADING)
									.addComponent(txtUsername, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))))
						.addGroup(Alignment.LEADING, gl_ctpMain.createSequentialGroup()
							.addComponent(btnAplicarTestes)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSaveCaixa)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBuscar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnValidar)))
					.addGap(31))
		);
		gl_ctpMain.setVerticalGroup(
			gl_ctpMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUrl)
						.addComponent(txtUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsurio)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocalizar)
						.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAplicarTestes)
						.addComponent(btnSaveCaixa)
						.addComponent(btnBuscar)
						.addComponent(btnValidar))
					.addGap(18)
					.addComponent(lblResultados)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtResult, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
		);
		ctpMain.setLayout(gl_ctpMain);
	}
	
	/*
	 * This method contains all of the code for create Events
	 */

	private void createEvents() {
		// TODO Auto-generated method stub
		
	}
}
