package ex03_version2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class Corrida implements TermineiCorridaListener {
	public static final int FIM_CORRIDA = 800;
	private final int TOTAL_SAPOS = 5;

	private JLabel[] saposLabel;

	private DefaultTableModel rankingTable;
	private JLabel winningSapoLabel;

	private int counter_sapos;

	private JButton button;

	public Corrida() {
	}

	public Corrida(JLabel[] saposLabel, JLabel winningSapoLabel, DefaultTableModel rankingTable, JButton button) {
		this.saposLabel = saposLabel;
		this.winningSapoLabel = winningSapoLabel;
		this.rankingTable = rankingTable;
		this.button = button;
	}

	public void create() {
		counter_sapos = 0;
		winningSapoLabel.setVisible(false);

		for (int i = 0; i < TOTAL_SAPOS; i++)
			saposLabel[i].setVisible(true);

		saposLabel[0].setBounds(10, 145, 100, 73);
		saposLabel[1].setBounds(10, 229, 100, 73);
		saposLabel[2].setBounds(10, 315, 100, 73);
		saposLabel[3].setBounds(10, 414, 100, 73);
		saposLabel[4].setBounds(10, 498, 100, 73);

		button.setText("START!");
		rankingTable.setColumnCount(0);
		rankingTable.setRowCount(0);
	}

	public void start() {
		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < TOTAL_SAPOS; i++)
			executorService.execute(new Sapo(i + 1, saposLabel[i], this));

		executorService.shutdown();

		rankingTable.addColumn("POSIÇÃO");
		rankingTable.addColumn("SAPO");

		button.setVisible(false);
	}

	public void stop() {
		winningSapoLabel.setVisible(true);
		button.setText("RESET");
		button.setVisible(true);
	}

	@Override
	public void terminei(Sapo sapo) {
		counter_sapos++;

		rankingTable.addRow(new Object[] { counter_sapos + "º", sapo.getId() });

		if (counter_sapos == TOTAL_SAPOS)
			stop();
	}
}
