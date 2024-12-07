package view;

import javax.swing.JOptionPane;

import controller.ControllerIndia;

public class Principal {

	public static void main(String[] args) {
		int ano;
		ControllerIndia contIndia = new ControllerIndia();
		int opc = 0;

		while (opc != 9) {
			opc = Integer.parseInt(
					JOptionPane.showInputDialog("\tMenu Principal\n1- Buscar população indiana\n9- Finalizar"));

			switch (opc) {

			case 1:
				ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano para busca:",
						"População anual da Índia", JOptionPane.QUESTION_MESSAGE));

				try {
					contIndia.searchPop(ano);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Sem dados de população para este ano", "População não encontrada", JOptionPane.WARNING_MESSAGE);
				}
				break;

			case 9:
				JOptionPane.showMessageDialog(null, "Finalizando...");
				System.exit(0);

			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida", "Erro",JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
	}
}