package ex03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class Corrida implements TermineiCorridaListener {
	public static final int FIM_CORRIDA = 800;
	private final int TOTAL_SAPOS = 5;

	private JLabel[] saposLabel;

	private Sapo winningSapo;
	private DefaultTableModel rankingTable;
	private JLabel winningSapoLabel;

	private int counter_sapos;

	private JButton button;

	public Corrida() {
	}

	public Corrida(JLabel[] saposLabel, JLabel winningSapoLabel, DefaultTableModel rankingTable, JButton button) {
		this.saposLabel = saposLabel;

		this.rankingTable = rankingTable;

		this.winningSapoLabel = winningSapoLabel;
		this.button = button;
	}

	public void create() {
		counter_sapos = 0;
		winningSapoLabel.setVisible(false);

		int y = 190;

		for (int i = 0; i < TOTAL_SAPOS; i++) {
			saposLabel[i].setVisible(true);
			saposLabel[i].setBounds(21, y, 100, 41);
			y += 60;
		}

		saposLabel[0].setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo1.png")));
		saposLabel[1].setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo2.png")));
		saposLabel[2].setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo3.png")));
		saposLabel[3].setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo4.png")));
		saposLabel[4].setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo5.png")));

		button.setText("START!");
		rankingTable.setColumnCount(0);
		rankingTable.setRowCount(0);
	}

	public void start() {
		ExecutorService executorService = Executors.newCachedThreadPool();

		int idSapo;

		for (int i = 0; i < TOTAL_SAPOS; i++) {
			idSapo = i + 1;

			Sapo sapo = new Sapo(saposLabel[i], this);

			switch (idSapo) {
			case 1:
				saposLabel[0].setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo1-running.gif")));
				sapo.setCor(Sapo.COR_VERDE);
				break;
			case 2:
				saposLabel[1].setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo2-running.gif")));
				sapo.setCor(Sapo.COR_VERMELHO);
				break;
			case 3:
				saposLabel[2].setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo3-running.gif")));
				sapo.setCor(Sapo.COR_AZUL);
				break;
			case 4:
				saposLabel[3].setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo4-running.gif")));
				sapo.setCor(Sapo.COR_PRETO);
				break;
			case 5:
				saposLabel[4].setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo5-running.gif")));
				sapo.setCor(Sapo.COR_LARANJA);
				break;
			}

			executorService.execute(sapo);
		}

		executorService.shutdown();

		rankingTable.addColumn("POSIÇÃO");
		rankingTable.addColumn("SAPO");

		button.setVisible(false);
	}

	public void stop() {
		winningSapoLabel.setVisible(true);
		button.setText("RESET");
		button.setVisible(true);

		switch (winningSapo.getCor()) {
		case Sapo.COR_VERDE:
			winningSapoLabel.setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo1-winner.gif")));
			break;
		case Sapo.COR_VERMELHO:
			winningSapoLabel.setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo2-winner.gif")));
			break;
		case Sapo.COR_AZUL:
			winningSapoLabel.setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo3-winner.gif")));
			break;
		case Sapo.COR_PRETO:
			winningSapoLabel.setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo4-winner.gif")));
			break;
		case Sapo.COR_LARANJA:
			winningSapoLabel.setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo5-winner.gif")));
			break;
		}
	}

	@Override
	public void terminei(Sapo sapo) {
		counter_sapos++;

		rankingTable.addRow(new Object[] { counter_sapos, sapo.getCor() });

		if (counter_sapos == 1)
			winningSapo = sapo;
		else if (counter_sapos == TOTAL_SAPOS)
			stop();
	}
}
