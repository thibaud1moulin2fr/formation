package fr.thibaud.gestionparking.view;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import fr.thibaud.gestionparking.dal.DAO;
import fr.thibaud.gestionparking.dal.PersonneDAO;
import fr.thibaud.gestionparking.dal.VoitureDAO;
import fr.thibaud.gestionparking.model.Personne;
import fr.thibaud.gestionparking.model.Voiture;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionParking extends JFrame {

	private JPanel contentPane;
	private JTextField textNomVoiture;
	private JTextField textPIVoiture;
	private JTextField textNomPersonne;
	private JTextField textPrenomPersonne;
	private JTable tableVoitures;
	private JTable tablePersonnes;
	private DefaultTableModel modelP = null;
	private DefaultTableModel modelV = null;
	private List<Personne> tabPersonne = new ArrayList<Personne>();
	private List<Voiture> tabVoiture = new ArrayList<Voiture>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionParking frame = new GestionParking();
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
	public GestionParking() {
		
		JComboBox<String> comboBoxPersonnes = new JComboBox<String>();
		comboBoxPersonnes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				DAO<Personne> daoP = null;
				Object[] obj = null;
				try {
					daoP = new PersonneDAO();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				obj = new Object[2];
				obj[0] = "Nom";
				obj[1] = "Prenom";
				modelP = new DefaultTableModel();
				modelP.setColumnCount(obj.length);
				modelP.setColumnIdentifiers(obj);
				tablePersonnes.setModel(modelP);
				List<Personne> personnes = null;
				try {
					personnes = daoP.find();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (!personnes.isEmpty()) {
					for (Personne personne : personnes) {
						tabPersonne.add(personne);
						obj[0] = personne.getNom();
						obj[1] = personne.getPrenom();
						modelP.addRow(obj);
						comboBoxPersonnes.addItem(personne.getNom() + " " + personne.getPrenom());
					}
				}
				DAO<Voiture> daoV = null;
				List<Voiture> voitures = null;
				obj = new Object[3];
				obj[0] = "Nom";
				obj[1] = "PI";
				obj[2] = "Personne";
				modelV = new DefaultTableModel();
				modelV.setColumnCount(obj.length);
				modelV.setColumnIdentifiers(obj);
				tableVoitures.setModel(modelV);
				try {
					daoV = new VoitureDAO();
					voitures = daoV.find();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (!voitures.isEmpty()) {
					for (Voiture voiture : voitures) {
						tabVoiture.add(voiture);
						obj[0] = voiture.getNom();
						obj[1] = voiture.getpI();
						obj[2] = (voiture.getPersonne() != null) ? 
								voiture.getPersonne().getNom() + " " + voiture.getPersonne().getPrenom() : "Vide";
								modelV.addRow(obj);
					}
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 171, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblPi = new JLabel("PI");
		lblPi.setBounds(10, 202, 46, 14);
		contentPane.add(lblPi);
		
		textNomVoiture = new JTextField();
		textNomVoiture.setBounds(66, 168, 187, 20);
		contentPane.add(textNomVoiture);
		textNomVoiture.setColumns(10);
		
		textPIVoiture = new JTextField();
		textPIVoiture.setBounds(66, 199, 187, 20);
		contentPane.add(textPIVoiture);
		textPIVoiture.setColumns(10);
		comboBoxPersonnes.setToolTipText("Nom de la personne");
		comboBoxPersonnes.setBounds(66, 230, 187, 20);
		contentPane.add(comboBoxPersonnes);
		
		JLabel lblNomPersonne = new JLabel("Nom");
		lblNomPersonne.setBounds(344, 171, 46, 14);
		contentPane.add(lblNomPersonne);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(344, 202, 46, 14);
		contentPane.add(lblPrenom);
		
		textNomPersonne = new JTextField();
		textNomPersonne.setBounds(400, 168, 174, 20);
		contentPane.add(textNomPersonne);
		textNomPersonne.setColumns(10);
		
		textPrenomPersonne = new JTextField();
		textPrenomPersonne.setBounds(400, 199, 174, 20);
		contentPane.add(textPrenomPersonne);
		textPrenomPersonne.setColumns(10);
		
		JButton btnAjouterVoiture = new JButton("Ajouter");
		btnAjouterVoiture.setBounds(173, 261, 80, 23);
		contentPane.add(btnAjouterVoiture);
		
		JButton btnModifierVoiture = new JButton("Modifier");
		btnModifierVoiture.setBounds(173, 295, 80, 23);
		contentPane.add(btnModifierVoiture);
		
		JButton btnSupprimerVoiture = new JButton("Supprimer");
		btnSupprimerVoiture.setBounds(173, 329, 80, 23);
		contentPane.add(btnSupprimerVoiture);
		
		JButton btnAjouterPersonne = new JButton("Ajouter");
		btnAjouterPersonne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tablePersonnes.getSelectedRow() != -1) {
					String nomOld = null, prenomOld = null, nom = null, prenom = null;
					nomOld = ((String) tablePersonnes.getValueAt(tablePersonnes.getSelectedRow(), 0)).trim();
					prenomOld = ((String) tablePersonnes.getValueAt(tablePersonnes.getSelectedRow(), 1)).trim();
					nom = textNomPersonne.getText().trim();
					prenom = textPrenomPersonne.getText().trim();
					if (!nomOld.equals(nom) || !prenomOld.equals(prenom)){
						DAO<Personne> daoP = null;
						Personne personne = new Personne(nom, prenom);
						try {
							daoP = new PersonneDAO();
							personne = daoP.create(personne);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (personne != null) {
							tabPersonne.add(personne);
							comboBoxPersonnes.addItem(nom + " " + prenom);
							Object[] obj = new Object[2];
							obj[0] = nom;
							obj[1] = prenom;
							modelP.addRow(obj);
						}
					}
				}
			}
		});
		btnAjouterPersonne.setBounds(485, 229, 89, 23);
		contentPane.add(btnAjouterPersonne);
		
		JButton btnModifierPersonne = new JButton("Modifier");
		btnModifierPersonne.setBounds(485, 261, 89, 23);
		contentPane.add(btnModifierPersonne);
		
		JButton btnSupprimerPersonne = new JButton("Supprimer");
		btnSupprimerPersonne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DAO<Personne> daoP = null;
				daoP = new PersonneDAO();
				int ind = tablePersonnes.getSelectedRow();
				if(daoP.delete(tabPersonne.get(ind))) {
					tabPersonne.remove(ind);
					tablePersonnes.remove(ind);
					comboBoxPersonnes.remove(ind);
				}
			}
		});
		btnSupprimerPersonne.setBounds(485, 295, 89, 23);
		contentPane.add(btnSupprimerPersonne);
		
		JButton btnExportXml = new JButton("Export XML");
		btnExportXml.setBounds(10, 377, 89, 23);
		contentPane.add(btnExportXml);
		
		JButton btnExportCsv = new JButton("Export CSV");
		btnExportCsv.setBounds(109, 377, 89, 23);
		contentPane.add(btnExportCsv);
		
		JScrollPane scrollPaneVoitures = new JScrollPane();
		scrollPaneVoitures.setBounds(10, 11, 327, 149);
		contentPane.add(scrollPaneVoitures);
		
		tableVoitures = new JTable();
		tableVoitures.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textNomVoiture.setText((String) tableVoitures.getValueAt(tableVoitures.getSelectedRow(), 0));
				textPIVoiture.setText((String) tableVoitures.getValueAt(tableVoitures.getSelectedRow(), 1));
			}
		});
		scrollPaneVoitures.setViewportView(tableVoitures);
		
		JScrollPane scrollPanePersonnes = new JScrollPane();
		scrollPanePersonnes.setBounds(344, 11, 230, 149);
		contentPane.add(scrollPanePersonnes);
		
		tablePersonnes = new JTable();
		tablePersonnes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textNomPersonne.setText((String) tablePersonnes.getValueAt(tablePersonnes.getSelectedRow(), 0));
				textPrenomPersonne.setText((String) tablePersonnes.getValueAt(tablePersonnes.getSelectedRow(), 1));
			}
		});
		scrollPanePersonnes.setViewportView(tablePersonnes);
	}
}
