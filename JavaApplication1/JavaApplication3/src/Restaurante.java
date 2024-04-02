import javax.swing.JOptionPane;

class Pessoa {
    public String nome;
    public String telefone;
    public int idade;
    public String cpf;

    Pessoa(String _nome, String _cpf, String _telefone, int _idade) {
        this.nome = _nome;
        this.cpf = _cpf;
        this.idade = _idade;
        this.telefone = _telefone;
    }
}

class Funcionario extends Pessoa {
    public float salario;
    public String beneficios;
    public String folga;
    public String horasdetrabalho;

    Funcionario(String _nome, String _cpf, String _telefone, int _idade) {
        super(_nome, _cpf, _telefone, _idade);
    }
}

class Cliente extends Pessoa {
    public float valordaconta;
    public int numerodamesa;

    Cliente(String _nome, String _cpf, String _telefone, int _idade) {
        super(_nome, _cpf, _telefone, _idade);
    }

    public void fazerPedido(String pedido) {
        JOptionPane.showMessageDialog(null, "Pedido do cliente " + this.nome + ": " + Pedidonome (pedido));
    }

    public float calcularPreco(String pedido) {
        // Definindo os preços dos itens
        float preco = 0;
        switch (pedido) {
            case "1":
                preco = 19.99f;
                break;
            case "2":
                preco = 24.99f;
                break;
            case "3":
                preco = 35.99f;
                break;
            case "4":
                preco = 49.99f;
                break;
            case "5":
                preco = 69.99f;
                break;
        }
        return preco;
    }
    public String Pedidonome(String pedido) {
        // Definindo os preços dos itens
        switch (pedido) {
            case "1":
                return "Pizza Broto";
            case "2":
                return "Pizza Pequena";
            case "3":
                return "Pizza Média";
            case "4":
                return "Pizza Grande";
            case "5":
                return "Pizza Gigante";
        }
        return "código não encontrado";
    }
    public void mostrarConta(float total) {
        JOptionPane.showMessageDialog(null, "Conta do cliente " + this.nome + ": R$" + total);
    }

    public void pagar(float valorPago) {
        float troco = valorPago - this.valordaconta;
        if (troco >= 0) {
            JOptionPane.showMessageDialog(null, "Troco: R$" + troco);
        } else {
            JOptionPane.showMessageDialog(null, "Valor insuficiente. Faltam R$" + (-troco) + " para pagar a conta.");
        }
    }
}

public class Restaurante {
    public static void main(String[] args) {
        String nome, cpf, telefone, pedido;
        int idade;

        nome = JOptionPane.showInputDialog("Nome do cliente:");
        idade = Integer.parseInt(JOptionPane.showInputDialog("Idade do cliente:"));
        cpf = JOptionPane.showInputDialog("CPF do cliente:");
        telefone = JOptionPane.showInputDialog("Telefone do cliente:");

        Cliente cliente = new Cliente(nome, cpf, telefone, idade);

        pedido = JOptionPane.showInputDialog("Qual é o seu pedido?\n" +
                "Cardápio:\n" +
                "1: Pizza Broto\n" +
                "2: Pizza Pequena\n" +
                "3: Pizza Média\n" +
                "4: Pizza Grande\n" +
                "5: Pizza Gigante");

        // Calcular o preço do pedido
        float preco = cliente.calcularPreco(pedido);
        cliente.valordaconta += preco;

        cliente.fazerPedido(pedido);

        // Mostrar a conta
        cliente.mostrarConta(cliente.valordaconta);

        // Interface para o cliente pagar
        float valorPago = Float.parseFloat(JOptionPane.showInputDialog("Por favor, informe o valor pago pelo cliente:"));
        cliente.pagar(valorPago);
    }
}
