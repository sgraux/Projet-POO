package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class PanelDames extends JPanel implements MouseListener {

	public PanelDames() {
		this.setLayout(new GridLayout(0, 25));
		dessineCase();

	}

	public void dessineCase() {
		PanelCase panel;
		// LIGNE 1
		for (int i = 0; i < 25; i++) {
			if (i == 12) {
				panel = new PanelCase(Color.red);
				this.add(panel);
				panel.addMouseListener(this);
			} else
				this.add(new JPanel());
		}
		// LIGNE 2
		for (int i = 0; i < 25; i++) {
				switch (i) {
				case 11:
					panel = new PanelCase(Color.red);
					this.add(panel);
					panel.addMouseListener(this);
					break;
				case 13:
					panel = new PanelCase(Color.red);
					this.add(panel);
					panel.addMouseListener(this);
					break;
				default:
					this.add(new JPanel());
					break;
				}
		}

		// LIGNE 3
		for (int i = 0; i < 25; i++) {
			switch (i) {
			case 10:
				panel = new PanelCase(Color.red);
				this.add(panel);
				panel.addMouseListener(this);
				break;
			case 12:
				panel = new PanelCase(Color.red);
				this.add(panel);
				panel.addMouseListener(this);
				break;
			case 14:
				panel = new PanelCase(Color.red);
				this.add(panel);
				panel.addMouseListener(this);
				break;
			default:
				this.add(new JPanel());
				break;
			}
		}
		// LIGNE 4
		for (int i = 0; i < 25; i++) {

			switch (i) {
			case 9:
				panel = new PanelCase(Color.red);
				this.add(panel);
				panel.addMouseListener(this);
				break;
			case 11:
				panel = new PanelCase(Color.red);
				this.add(panel);
				panel.addMouseListener(this);
				break;
			case 13:
				panel = new PanelCase(Color.red);
				this.add(panel);
				panel.addMouseListener(this);
				break;
			case 15:
				panel = new PanelCase(Color.red);
				this.add(panel);
				panel.addMouseListener(this);
				break;
			default:
				this.add(new JPanel());
				break;
			}
		}

		// LIGNE 5
		for (int i = 0; i < 25; i++) {

			switch (i) {
			case 0:
				this.add(new PanelCase(Color.blue));
				break;
			case 2:
				this.add(new PanelCase(Color.blue));
				break;
			case 4:
				this.add(new PanelCase(Color.blue));
				break;
			case 6:
				this.add(new PanelCase(Color.blue));
				break;
			case 8:
				this.add(new PanelCase(Color.gray));
				break;
			case 10:
				this.add(new PanelCase(Color.gray));
				break;
			case 12:
				this.add(new PanelCase(Color.gray));
				break;
			case 14:
				this.add(new PanelCase(Color.gray));
				break;
			case 16:
				this.add(new PanelCase(Color.gray));
				break;
			case 18:
				this.add(new PanelCase(Color.green));
				break;
			case 20:
				this.add(new PanelCase(Color.green));
				break;
			case 22:
				this.add(new PanelCase(Color.green));
				break;
			case 24:
				this.add(new PanelCase(Color.green));
				break;
			default:
				this.add(new JPanel());
				break;
			}
		}

		// LIGNE 6
		for (int i = 0; i < 25; i++) {

			switch (i) {
			case 1:
				this.add(new PanelCase(Color.blue));
				break;
			case 3:
				this.add(new PanelCase(Color.blue));
				break;
			case 5:
				this.add(new PanelCase(Color.blue));
				break;
			case 7:
				this.add(new PanelCase(Color.gray));
				break;
			case 9:
				this.add(new PanelCase(Color.gray));
				break;
			case 11:
				this.add(new PanelCase(Color.gray));
				break;
			case 13:
				this.add(new PanelCase(Color.gray));
				break;
			case 15:
				this.add(new PanelCase(Color.gray));
				break;
			case 17:
				this.add(new PanelCase(Color.gray));
				break;
			case 19:
				this.add(new PanelCase(Color.green));
				break;
			case 21:
				this.add(new PanelCase(Color.green));
				break;
			case 23:
				this.add(new PanelCase(Color.green));
				break;
			default:
				this.add(new JPanel());
				break;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("clique");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
