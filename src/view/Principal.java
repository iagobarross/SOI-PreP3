package view;

import javax.swing.JOptionPane;

import controller.ControllerIndia;

public class Principal {

	public static void main(String[] args) {
		int ano;
		ControllerIndia contIndia = new ControllerIndia();
		int opc = 0;

		while (opc != 2) {

			String input = JOptionPane.showInputDialog(null,
					"               Menu Principal\n\n1- Buscar população indiana\n2- Finalizar");

			if (input == null) {
				JOptionPane.showMessageDialog(null, "Finalizando...");
				System.exit(0);
			}

			try {
				opc = Integer.parseInt(input);

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Digite caracteres numéricos inteiros.", "Erro",
						JOptionPane.ERROR_MESSAGE);

			}

			switch (opc) {

			case 1:
				try {
					ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano para busca:",
							"População anual da Índia", JOptionPane.QUESTION_MESSAGE));

					contIndia.searchPop(ano);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Sem dados de população para este ano",
							"População não encontrada", JOptionPane.WARNING_MESSAGE);
				}
				break;

			case 2:
				JOptionPane.showMessageDialog(null, "Finalizando...");
				System.exit(0);

			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida", "Erro", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
	}
}