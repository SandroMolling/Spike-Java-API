
package fullstack.API;

public class TesteExcecoes {

    public static void main(String[] args) {

        try {
            int idade = -5;

            if (idade < 0) {
                throw new IllegalArgumentException(
                        "A idade não pode ser negativa.");
            }

            System.out.println("Idade válida: " + idade);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());

        } finally {
            System.out.println("Validação finalizada.");
        }
    }
}
