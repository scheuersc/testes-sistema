package br.com.nectar.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOnSupplier;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import br.com.nectar.autentication.Login;
import br.com.nectar.financial.Cashier;
import br.com.nectar.register.Users;
import br.com.nectar.utils.Util;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTextField txtUrl;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtDescription;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static final String projectLocation = System.getProperty("user.dir");
	private JPanel panelBrowser = new JPanel();
	private JPanel panelForm = new JPanel();
	private JPanel panelSeg = new JPanel();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final Integer itensForms = 2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	public void initComponent (){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(2, 2, 736, 184);
		contentPane.add(textArea, BorderLayout.CENTER);
		
		JScrollPane sp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(5, 5, 740, 188);
		contentPane.add(sp);
		
		JPanel panelTestForm = new JPanel();
		panelTestForm.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Teste do fomul\u00E1rio:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTestForm.setBounds(368, 392, 377, 61);
		contentPane.add(panelTestForm);
		GridBagLayout gbl_panelTestForm = new GridBagLayout();
		gbl_panelTestForm.columnWidths = new int[]{87, 81, 74, 87, 0};
		gbl_panelTestForm.rowHeights = new int[]{29, 0};
		gbl_panelTestForm.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelTestForm.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelTestForm.setLayout(gbl_panelTestForm);
		
		JButton btnTodosDoFomulario = new JButton("Todos");
		GridBagConstraints gbc_btnTodosDoFomulario = new GridBagConstraints();
		gbc_btnTodosDoFomulario.insets = new Insets(0, 0, 0, 5);
		gbc_btnTodosDoFomulario.gridx = 0;
		gbc_btnTodosDoFomulario.gridy = 0;
		panelTestForm.add(btnTodosDoFomulario, gbc_btnTodosDoFomulario);
		
		JButton btnSalvar = new JButton("Salvar");
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 1;
		gbc_btnSalvar.gridy = 0;
		panelTestForm.add(btnSalvar, gbc_btnSalvar);
		
		JButton btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuscar.gridx = 2;
		gbc_btnBuscar.gridy = 0;
		panelTestForm.add(btnBuscar, gbc_btnBuscar);
		
		JButton btnValidarObrigatoriedade = new JButton("Validar");
		GridBagConstraints gbc_btnValidarObrigatoriedade = new GridBagConstraints();
		gbc_btnValidarObrigatoriedade.gridx = 3;
		gbc_btnValidarObrigatoriedade.gridy = 0;
		panelTestForm.add(btnValidarObrigatoriedade, gbc_btnValidarObrigatoriedade);
		btnValidarObrigatoriedade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String formsList[] = formsList();
				int i = 0;
				int forms = 0;
				if (formsList[0].equals("Todos"))
					forms = itensForms; 
				else
					forms = formsList.length;
				String result = "";
				while(i < forms) {
					if (formsList[i].equals("Todos") || formsList[i].equals("Caixa")) {
						result += testValidateSaveCaixa();
					}
					if (formsList[i].equals("Todos") || formsList[i].equals("Usuário")) {
						result += testValidateSaveUsers();
					}
					i++;
				}
				textArea.setText(result);
			}
		});
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String formsList[] = formsList();
				int i = 0;
				int forms = 0;
				if (formsList[0].equals("Todos"))
					forms = itensForms; 
				else
					forms = formsList.length;
				String result = "";
				while(i < forms) {
					if (formsList[i].equals("Todos") || formsList[i].equals("Caixa")) {
						result += testSearchCaixa();
					}
					if (formsList[i].equals("Todos") || formsList[i].equals("Usuário")) {
						result += testSearchUsers();
					}
					i++;
				}
				textArea.setText(result);
			}
		});
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String formsList[] = formsList();
				int i = 0;
				int forms = 0;
				if (formsList[0].equals("Todos"))
					forms = itensForms; 
				else
					forms = formsList.length;
				String result = "";
				while(i < forms) {
					if (formsList[i].equals("Todos") || formsList[i].equals("Caixa")) {
						result += testSaveCaixa();
					}
					if (formsList[i].equals("Todos") || formsList[i].equals("Usuário")) {
						result += testSaveUsers();
					}
					i++;
				}
				textArea.setText(result);
			}
		});
		btnTodosDoFomulario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String formsList[] = formsList();
				
				int i = 0;
				int forms = 0;
				if (formsList[0].equals("Todos"))
					forms = itensForms; 
				else
					forms = formsList.length;
				String result = "";
				while(i < forms) {
					if (formsList[i].equals("Todos") || formsList[i].equals("Caixa")) {
						try {
							//JOptionPane.showMessageDialog(null, "Caixa: " + formsList[i]);
							result += testSearchCaixa();
							result += testSaveCaixa();
							result += testValidateSaveCaixa();
						} catch (Exception e1) {
							// TODO: handle exception
						}
					}
					if (formsList[i].equals("Todos") || formsList[i].equals("Usuário")) {
						try {
							//JOptionPane.showMessageDialog(null, "Usuário: " + formsList.length);
							result += testSearchUsers();
							result += testSaveUsers();
							result += testValidateSaveUsers();
						} catch (Exception e1) {
							// TODO: handle exception
						}
					}
					i++;
				}
				textArea.setText(result);
			}
		});
		
		panelForm.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Formulario:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelForm.setBounds(368, 195, 377, 195);
		contentPane.add(panelForm);
		GridBagLayout gbl_panelForm = new GridBagLayout();
		gbl_panelForm.columnWidths = new int[]{71, 80, 71, 0, 0, 0, 0};
		gbl_panelForm.rowHeights = new int[]{23, 0, 0, 0, 0, 0};
		gbl_panelForm.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelForm.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelForm.setLayout(gbl_panelForm);
		
		JCheckBox chckbxTodos = new JCheckBox("Todos");
		chckbxTodos.setSelected(true);
		GridBagConstraints gbc_chckbxTodos = new GridBagConstraints();
		gbc_chckbxTodos.anchor = GridBagConstraints.NORTHWEST;
		gbc_chckbxTodos.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxTodos.gridx = 0;
		gbc_chckbxTodos.gridy = 0;
		panelForm.add(chckbxTodos, gbc_chckbxTodos);
		
		JCheckBox chckbxUsurio = new JCheckBox("Usuário");
		GridBagConstraints gbc_chckbxUsurio = new GridBagConstraints();
		gbc_chckbxUsurio.anchor = GridBagConstraints.NORTHWEST;
		gbc_chckbxUsurio.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxUsurio.gridx = 1;
		gbc_chckbxUsurio.gridy = 0;
		panelForm.add(chckbxUsurio, gbc_chckbxUsurio);
		
		JCheckBox chckbxCaixa = new JCheckBox("Caixa");
		GridBagConstraints gbc_chckbxCaixa = new GridBagConstraints();
		gbc_chckbxCaixa.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxCaixa.anchor = GridBagConstraints.NORTH;
		gbc_chckbxCaixa.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxCaixa.gridx = 2;
		gbc_chckbxCaixa.gridy = 0;
		panelForm.add(chckbxCaixa, gbc_chckbxCaixa);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es necess\u00E1rias:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfo.setBounds(6, 306, 359, 147);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBounds(42, 27, 28, 16);
		panelInfo.add(lblUrl);
		
		txtUrl = new JTextField();
		txtUrl.setText("http://172.16.101.128:10100");
		txtUrl.setBounds(76, 22, 260, 26);
		panelInfo.add(txtUrl);
		txtUrl.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setBounds(18, 47, 52, 16);
		panelInfo.add(lblUsurio);
		
		txtUsername = new JTextField();
		txtUsername.setText("suporte@marconsoft.com.br");
		txtUsername.setBounds(76, 47, 260, 26);
		panelInfo.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(29, 75, 41, 16);
		panelInfo.add(lblSenha);
		
		txtPassword = new JTextField();
		txtPassword.setText("!efacil#rul3z");
		txtPassword.setBounds(76, 75, 260, 26);
		panelInfo.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblLocalizar = new JLabel("Localizar:");
		lblLocalizar.setBounds(10, 103, 60, 16);
		panelInfo.add(lblLocalizar);
		
		txtDescription = new JTextField();
		txtDescription.setText("caixa loia");
		txtDescription.setBounds(76, 100, 260, 26);
		panelInfo.add(txtDescription);
		txtDescription.setColumns(10);
		
		panelBrowser.setBorder(new TitledBorder(null, "Browser", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBrowser.setBounds(10, 196, 355, 62);
		contentPane.add(panelBrowser);
		GridBagLayout gbl_panelBrowser = new GridBagLayout();
		gbl_panelBrowser.columnWidths = new int[]{91, 91, 91, 0};
		gbl_panelBrowser.rowHeights = new int[]{38, 0};
		gbl_panelBrowser.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelBrowser.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelBrowser.setLayout(gbl_panelBrowser);
		
		JCheckBox chkTodos = new JCheckBox("Todos");
		GridBagConstraints gbc_chkTodos = new GridBagConstraints();
		gbc_chkTodos.insets = new Insets(0, 0, 0, 5);
		gbc_chkTodos.gridx = 0;
		gbc_chkTodos.gridy = 0;
		panelBrowser.add(chkTodos, gbc_chkTodos);
		
		JCheckBox chkChrome = new JCheckBox("Chrome");
		chkChrome.setSelected(true);
		GridBagConstraints gbc_chkChrome = new GridBagConstraints();
		gbc_chkChrome.insets = new Insets(0, 0, 0, 5);
		gbc_chkChrome.gridx = 1;
		gbc_chkChrome.gridy = 0;
		panelBrowser.add(chkChrome, gbc_chkChrome);
		
		JCheckBox chkFirefox = new JCheckBox("Firefox");
		GridBagConstraints gbc_chkFirefox = new GridBagConstraints();
		gbc_chkFirefox.gridx = 2;
		gbc_chkFirefox.gridy = 0;
		panelBrowser.add(chkFirefox, gbc_chkFirefox);
		
		panelSeg.setBorder(new TitledBorder(null, "Seguran\u00E7a", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSeg.setBounds(6, 258, 359, 48);
		contentPane.add(panelSeg);
		panelSeg.setLayout(null);
		
		JButton btnAutenticao = new JButton("Autenticação");
		btnAutenticao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String result = "";
				try {
					//JOptionPane.showMessageDialog(null, "Caixa: " + formsList[i]);
					result += testLoginCorrect();
					result += testLoginIvalid();
				} catch (Exception e1) {
					// TODO: handle exception
				}
				textArea.setText(result);
			}
		});
		btnAutenticao.setBounds(6, 13, 117, 29);
		panelSeg.add(btnAutenticao);
		
		JButton btnBruteForce = new JButton("Brute Force");
		btnBruteForce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String result = "";
				try {
					//JOptionPane.showMessageDialog(null, "Caixa: " + formsList[i]);
					result += testBruteForce();
				} catch (Exception e1) {
					// TODO: handle exception
				}
				textArea.setText(result);
			}
		});
		btnBruteForce.setBounds(119, 13, 117, 29);
		panelSeg.add(btnBruteForce);
		
		JButton btnSqlIjection = new JButton("SQL Injection");
		btnSqlIjection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String result = testSqlInjectionLogin();
				textArea.setText(result);
			}
		});
		btnSqlIjection.setBounds(236, 13, 117, 29);
		panelSeg.add(btnSqlIjection);
		
		/*
		JCheckBox chkSafari = new JCheckBox("Safari");
		GridBagConstraints gbc_chkSafari = new GridBagConstraints();
		gbc_chkSafari.gridx = 3;
		gbc_chkSafari.gridy = 0;
		panelBrowser.add(chkSafari, gbc_chkSafari);
		*/
	}
	
	/*
	 * Indentify Panel Segurança
	 * 
	 * */
	public String[] listPanelSeg() {
		String buffer = "";
		String[] result;
		for (Component c :  panelSeg.getComponents()){
			if(c.getClass().equals(JCheckBox.class)){
				JCheckBox jck = (JCheckBox) c;
				if(jck.isSelected()){
					buffer += jck.getText() + ";";  
				}
			}
		}
		result = buffer.split(";");
		//JOptionPane.showMessageDialog(null, result);
		return result;
	}
	
	/*
	 * Indentify browser
	 * 
	 * */
	public String[] browserList() {
		String buffer = "";
		String[] result;
		for (Component c :  panelBrowser.getComponents()){
			if(c.getClass().equals(JCheckBox.class)){
				JCheckBox jck = (JCheckBox) c;
				if(jck.isSelected()){
					buffer += jck.getText() + ";";  
				}
			}
		}
		result = buffer.split(";");
		//JOptionPane.showMessageDialog(null, result);
		return result;
	}
	
	/*
	 * Identify Forms
	 * 
	 * */
	public String[] formsList() {
		String buffer = "";
		String[] result;
		for (Component c :  panelForm.getComponents()){
			if(c.getClass().equals(JCheckBox.class)){
				JCheckBox jck = (JCheckBox) c;
				if(jck.isSelected()){
					buffer += jck.getText() + ";";  
				}
			}
		}
		result = buffer.split(";");
		//JOptionPane.showMessageDialog(null, result);
		return result;
	}
	
	
	/*
	 * Tests methods User
	 */
	
	public String testLoginIvalid() {
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
		
		String result = "";
		String viewResult = "\nAutenticação inválida!\n";
		Login objLogin;
		String browsers[] = browserList();
		int i = 0;
		int repeat = (browsers[0].equals("Todos") ? 1 : browsers.length);
		while (i < repeat) {
			if (browsers[i].equals("Todos") || browsers[i].equals("Firefox")) {
				try {
					objLogin = new Login(new FirefoxDriver());
					result = objLogin.testInvalidLogin(txtUrl.getText(), txtUsername.getText(), "erro");
					viewResult += "APROVADO: Teste de autenticão inválida no Firefox!\n";
				} catch (Exception e) {
					viewResult += "REPROVADO: Erro ao testar a Autenticação Inválida no Firefox: " + e.getMessage() + "\n";
				}
			}
			
			if (browsers[i].equals("Todos") || browsers[i].equals("Chrome")) {
				try {
					objLogin = new Login(new ChromeDriver());
					result = objLogin.testInvalidLogin(txtUrl.getText(), txtUsername.getText(), "error");
					viewResult += "APROVADO: Teste de autenticão inválida no Chrome!\n";
				} catch (Exception e) {
					viewResult += "REPROVADO: Erro ao testar a Autenticação Inválida no Chrome: " + e.getMessage() + "\n";
				}
			}
			i++;
		}
		return viewResult;
	}

	public String testLoginCorrect() {
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
		
		String viewResult = "Autenticação válida!\n";
		String result = "";
		Login objLogin;
		String browsers[] = browserList();
		int i = 0;
		int repeat = (browsers[0].equals("Todos") ? 1 : browsers.length);
		while (i < repeat) {
			if (browsers[i].equals("Todos") || browsers[i].equals("Firefox")) {
				try {
					objLogin = new Login(new FirefoxDriver());
					result = objLogin.testCorrectLogin(txtUrl.getText(), txtUsername.getText(), txtPassword.getText());
					viewResult += "APROVADO: Teste de autenticão válida no Firefox!\n ";

				} catch (Exception e) {
					viewResult += "Erro ao aplicar teste de Autenticação Válida no Firefox: " + e.getMessage() + "\n";
				}
			}
			
			if (browsers[i].equals("Todos") || browsers[i].equals("Chrome")) {
				try {
					objLogin = new Login(new ChromeDriver());
					result = objLogin.testCorrectLogin(txtUrl.getText(), txtUsername.getText(), txtPassword.getText());
					if (result.contains("Clique na banca que deseja acessar:"))
						viewResult += "APROVADO: Teste de autenticão válida no Chrome!\n ";

				} catch (Exception e) {
					viewResult += "Erro ao aplicar teste de Autenticação Válida no Chrome: " + e.getMessage() + "\n";
				}
			}
			i++;
		}
		return viewResult;
	}

	public String testSqlInjectionLogin() {
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
		
		String viewResult = "Teste de segurança de SQL Injection!\n";
		String result = "";
		Login objLogin;
		String browsers[] = browserList();
		int i = 0;
		int repeat = (browsers[0].equals("Todos") ? 1 : browsers.length);
		while (i < repeat) {
			if (browsers[i].equals("Todos") || browsers[i].equals("Firefox")) {
				try {
					objLogin = new Login(new FirefoxDriver());
					result = objLogin.testFormSqlInjectLogin(txtUrl.getText(), txtUsername.getText(),  "' 1 = 1; --");
					viewResult += "APROVADO: O sistema não está sucetível ao Ataque de Injeção de SQL no Firefox! \n";
				} catch (Exception e) {
					viewResult += "REPROVADO: Erro ao aplicar teste de segurança SQL Injection no Firefox: " + e.getMessage() + "\n";
				}
			}
			
			if (browsers[i].equals("Todos") || browsers[i].equals("Chrome")) {
				objLogin = new Login(new ChromeDriver());
				try {
					result = objLogin.testFormSqlInjectLogin(txtUrl.getText(), txtUsername.getText(), "' 1 = 1; --");
					viewResult += "APROVADO: O sistema não está sucetível ao Ataque de Injeção de SQL no Chrome! \n";
					Assert.assertEquals(result, "Usuário ou senha invalidos!");
				} catch (Exception e) {
					viewResult += "Erro ao aplicar teste de segurança SQL Injection no Chrome: " + e.getMessage() + "\n";
				}
			}
			i++;
		}
		return viewResult;
	}

	public String testBruteForce() {
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
		
		String viewResult = "Testede segurança de autenticação com Brute Force!\n";
		Login objLogin;
		String result = "";

		String browsers[] = browserList();
		int i = 0;
		int repeat = (browsers[0].equals("Todos") ? 1 : browsers.length);
		while (i < repeat) {
			if (browsers[i].equals("Todos") || browsers[i].equals("Chrome")) {
				try {
					objLogin = new Login(new ChromeDriver());
					result = objLogin.testBruteForce(txtUrl.getText(), txtUsername.getText(), txtPassword.getText());
					
					viewResult += "APROVADO: o sistema está sucetível ao ataque de Força bruta no Chrome!\n";
				} catch (Exception e) {
					viewResult += "REPROVADO: Erro ao aplicar o ataque de segurança Brute Force no Chrome: " + e.getMessage() + "\n";
				}
			}

			if (browsers[i].equals("Todos") || browsers[i].equals("Firefox")) {
				try {
					objLogin = new Login(new FirefoxDriver());
					result = objLogin.testBruteForce(txtUrl.getText(), txtUsername.getText(), txtPassword.getText());
					
					viewResult += "APROVADO: o sistema está sucetível ao ataque de Força bruta no Firefox!\n";
				} catch (Exception e) {
					viewResult += "REPROVADO: Erro ao aplicar o ataque de segurança Brute Force no Firefox: " + e.getMessage() + "\n";
				}
			}
			i++;
		}
		return viewResult;
	}
	
	//////////////////////////////////////////////////////////////
	
	public String testSaveUsers() {
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
		
		String result;
		String showResult = "\nTeste automatizado da funcionalidade Salvar do cadastro: Usuário!\n";
		String name = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
		String email = Util.gerarString(10, "abcfefghijklmnopqrstuvwxyz") + "@"
				+ Util.gerarString(10, "abcfefghijklmnopqrstuvwxyz") + ".com";
		String phone = Util.gerarString(1, "123456789") + Util.gerarString(10, "0123456789");
		String group = "CAIXA";
		String disLimit = "20";
		String cpf = "";
		Users objUsers;
		String browsers[] = browserList();
		int i = 0;
		int repeat = (browsers[0].equals("Todos") ? 1 : browsers.length);
		while (i < repeat) {
			if (browsers[i].equals("Todos") || browsers[i].equals("Chrome")) {
				try {
					objUsers = new Users(new ChromeDriver());
					cpf = Util.gerarCPFValido();
					result = objUsers.testSave(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), name, email, cpf, group, phone,
							disLimit);
		
					if (result.contains("Cadastro de Usuario, ID"))
						showResult += "APROVADO: Usuário salvo no Chrome!\n";
					
				} catch (Exception e) {
					showResult += "\nREPROVADO!\nErro ao salvar Caixa no Chrome: " + e.getMessage() + "\n";
				}
			}
		
			if (browsers[i].equals("Todos") || browsers[i].equals("Firefox")) {
				try {
					name = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
					email = Util.gerarString(10, "abcfefghijklmnopqrstuvwxyz") + "@"
							+ Util.gerarString(10, "abcfefghijklmnopqrstuvwxyz") + ".com";
					phone = Util.gerarString(1, "123456789") + Util.gerarString(10, "0123456789");
					group = "CAIXA";
					disLimit = "20";
					objUsers = new Users(new FirefoxDriver());
					cpf = Util.gerarCPFValido();
					result = objUsers.testSave(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), name, email, cpf, group, phone,
							disLimit);
		
					if (result.contains("Cadastro de Usuario, ID"))
						showResult += "APROVADO: Usuário salvo no Firefox!\n";
					
				} catch (Exception e) {
					showResult += "\nREPROVADO!\nErro ao salvar Usuário no Firefox: " + e.getMessage() + "\n";
				}
			}
			i++;
		}
		return showResult;
	}
	
	public String testSearchUsers() {
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
		
		//JOptionPane.showMessageDialog(null, "Usuário Search!");
		
		String name = "TESTE AUTOMATIZADO V2.0.2.1";
		Users objUsers;
		String showResult = "\nTeste automatizado da funcionalidade Buscar do cadastro: Usuário!\n";
		String result = "";
		boolean booResult = false;
		String browsers[] = browserList();
		int i = 0;
		int repeat = (browsers[0].equals("Todos") ? 1 : browsers.length);
		while (i < repeat) {
			if (browsers[i].equals("Todos") || browsers[i].equals("Chrome")) {
				try {
					objUsers = new Users(new ChromeDriver());
					result = objUsers.testSearch(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), name);
				
					if (result.contains("Cadastro de Usuario, ID")) {
						booResult = true;
					}
					if (booResult)
						showResult += "APROVADO: A funcionalidade Buscar Usuário no Firefox!\n";
					Assert.assertEquals(booResult, true);
				} catch (Exception e) {
					showResult = "Erro ao testar funcionalidade Buscar Usuário no Chrome: " + e.getMessage() + "\n";
				}
			}
	
			if (browsers[i].equals("Todos") || browsers[i].equals("Firefox")) {
				try {
					objUsers = new Users(new FirefoxDriver());
					result = objUsers.testSearch(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), name);
					System.out.println("Teste de Buscar usuário no Firefox: "
							+ (result.contains("Cadastro de Usuario, ID") ? "APROVADO" : "REPROVADO"));
					booResult = false;
					if (result.contains("Cadastro de Usuario, ID")) {
						booResult = true;
					}
					if (booResult)
						showResult += "APROVADO: A funcionalidade Buscar Usuário no Firefox!\n";
					Assert.assertEquals(booResult, true);
				} catch (Exception e) {
					showResult = "Erro ao testar funcionalidade Buscar Usuário no Firefox: " + e.getMessage() + "\n";
				}
			}
			i++;
		}
		return showResult;
	}
	
	public String testValidateSaveUsers(){
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
		
		String showResult = "\nTeste automatizado da funcionalidade Validar ao Salvar do cadastro: Usuário!\n";
		String name = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
		String email = Util.gerarString(10, "abcfefghijklmnopqrstuvwxyz") + "@"
				+ Util.gerarString(10, "abcfefghijklmnopqrstuvwxyz") + ".com";
		String phone = Util.gerarString(10, "0123456789");
		String group = "CAIXA";
		String disLimit = "20";
		String cpf = "";// Util.gerarCPFValido();
		Boolean booResult = false;
		Users objUsers;
		String browsers[] = browserList();
		int i = 0;
		int repeat = (browsers[0].equals("Todos") ? 1 : browsers.length);
		while (i < repeat) {
			if (browsers[i].equals("Todos") || browsers[i].equals("Firefox")) {
				try {
					objUsers = new Users(new FirefoxDriver());
					booResult = objUsers.testValidadeSave(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), name, email, cpf, group, disLimit, phone);
					
					showResult += "APROVADO: Caixa salvo no Firefox!\n";
					Assert.assertEquals(true, booResult);
				} catch (Exception e) {
					showResult = "Esso ao testar a funcionalidade Validar Campo Obrigatório no momento de Salvar no Firefox: " + e.getMessage();
				}
			}
			
			if (browsers[i].equals("Todos") || browsers[i].equals("Chrome")) {
				try {
					objUsers = new Users(new ChromeDriver());
					booResult = objUsers.testValidadeSave(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), name, email, cpf, group, disLimit, phone);
					
					showResult += "APROVADO: Caixa salvo no Chrome!\n";
					Assert.assertEquals(true, booResult);
				} catch (Exception e) {
					showResult = "Esso ao testar a funcionalidade Validar Campo Obrigatório no momento de Salvar no Chrome: " + e.getMessage();
				}
			}
			i++;
		}
		return showResult;
	}
	
	/*
	 * Method Cashier
	 * */
	
	public String testSaveCaixa() {
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
		
		String browsers[] = browserList();
		//JOptionPane.showMessageDialog(null, browsers.length);
		
		String showResult = "\nTeste automatizado da funcionalidade Salvar do cadastro: Caixa!\n";
		String result;
		String description;
		String code;
		String cpf;
		boolean booResult = false;
		Cashier objCashier;
		int i = 0;
		int repeat = (browsers[0].equals("Todos") ? 1 : browsers.length);
		while (i < repeat) {
			if (browsers[i].equals("Todos") || browsers[i].equals("Firefox")) {
				try {
					description = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
					code = Util.gerarString(50, "123456789");// "2";
					cpf = Util.gerarCPFValido();
					objCashier = new Cashier(new FirefoxDriver());
					result = objCashier.testSave(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), description, code, cpf);
					if (result.contains("Caixa, ID")) {
						booResult = true;
						showResult += "APROVADO: Caixa salvo no Firefox!\n";
					}
					Assert.assertEquals(booResult, true);
				} catch (Exception e) {
					showResult += "REPROVADO!\nErro ao salvar Caixa no Firefox: " + e.getMessage() + "\n";
				}
				
			}
			if (browsers[i].equals("Todos") || browsers[i].equals("Chrome")) {
				description = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
				code = Util.gerarString(50, "123456789");// "2";
				cpf = Util.gerarCPFValido();
				objCashier = new Cashier(new ChromeDriver());
				try {
					booResult = false;
					result = objCashier.testSave(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), description, code, cpf);
					if (result.contains("Caixa, ID")) {
						showResult += "APROVADO: Caixa salvo no Chrome!\n";
						booResult = true;
					}
					Assert.assertEquals(booResult, true);
				} catch (Exception e) {
					showResult += "REPROVADO!\nErro ao salvar Caixa no Chrome: " + e.getMessage() + "\n";
				}
				
			}
			/*
			if (browsers[i].equals("Todos") || browsers[i].equals("Safari")) {
				
			}
			*/
			i++;
		}
		return showResult;
	}
	
	public String testSearchCaixa() {
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
		
		String result = "\nTeste automatizado da funcionalidade Buscar do cadastro: Caixa!\n";
		String browsers[] = browserList();
		Boolean booResult;
		String description = txtDescription.getText();
		Cashier objCashier;
		int i = 0;
		int repeat = (browsers[0].equals("Todos") ? 1 : browsers.length);
		while (i < repeat) {
			if (browsers[i].equals("Todos") || browsers[i].equals("Firefox")) {
				try {
					objCashier = new Cashier(new FirefoxDriver());
					booResult = objCashier.testSearch(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), description);
					if (booResult) {
						result += "APROVADO: A funcionalidade Buscar Caixa no Firefox!\n";
					}
					Assert.assertEquals(booResult, true);
				} catch (Exception e) {
					result += "REPROVADO!\nErro quando executa a funcionalidade Buscar caixa no Chrome: " + e.getMessage() + "\n";
				}
			}
			if (browsers[i].equals("Todos") || browsers[i].equals("Chrome")) {
				try {
					objCashier = new Cashier(new ChromeDriver());
					booResult = false;
					booResult = objCashier.testSearch(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), description);
					if (booResult) {
						result += "APROVADO: A funcionalidade Buscar Caixa no Chrome!\n";
					}
					Assert.assertEquals(booResult, true);
				} catch (Exception e) {
					result += "REPROVADO!\nErro quando executa a funcionalidade Buscar caixa no Chrome: " + e.getMessage() + "\n";
				}
			}
			/*
			if (browsers[i].equals("Todos") || browsers[i].equals("Safari")) {
				
			}
			*/
			i++;
		}
		return result;
	}
	
	public String testValidateSaveCaixa() {
		String result = "\nTeste automatizado da funcionalidade Validar ao Salvar do cadastro: Caixa!\n";
		String browsers[] = browserList();
		String description = "";
		String code = "";
		String cpf = "";
		boolean booResult = false;
		Cashier objCashier;
		int i = 0;
		int repeat = (browsers[0].equals("Todos") ? 1 : browsers.length);
		while (i < repeat) {
			if (browsers[i].equals("Todos") || browsers[i].equals("Firefox")) {
				try {
					objCashier = new Cashier(new FirefoxDriver());;
					description = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
					code = Util.gerarString(50, "123456789");
					cpf = Util.gerarCPFValido();
					booResult = objCashier.testValidadeSave(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), description, code, cpf);
					if (!booResult)
						result += "APROVADO: Caixa validado no Firefox!\n";
					Assert.assertEquals(booResult, false);
				} catch (Exception e) {
					result += "REPROVADO!\nErro quando valida ao salvar Caixa no Firefox: " + e.getMessage() + "\n";
				}
			}
	
			if (browsers[i].equals("Todos") || browsers[i].equals("Chrome")) {
				try {
					objCashier = new Cashier(new ChromeDriver());
					description = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
					code = Util.gerarString(50, "123456789");
					cpf = Util.gerarCPFValido();
					booResult = objCashier.testValidadeSave(txtUrl.getText(), txtUsername.getText(), txtPassword.getText(), description, code, cpf);
					if (!booResult)
						result += "APROVADO: Caixa validado no Chrome!\n";
					Assert.assertEquals(booResult, false);
				} catch (Exception e) {
					result += "REPROVADO!\nErro quando valida ao salvar Caixa no Chrome: " + e.getMessage() + "\n";
				}
			}
			/*
			if (browsers[i].equals("Todos") || browsers[i].equals("Safari")) {
				
			}
			*/
			i++;
		}
		return result;
	}
	
	/**
	 * Create the frame.
	 */
	public MainView() {
		initComponent();
	}

}