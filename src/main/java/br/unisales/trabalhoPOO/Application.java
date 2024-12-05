package br.unisales.trabalhoPOO;

import java.util.List;
import java.util.Scanner;

import br.unisales.trabalhoPOO.impl.DepartamentoDAO;
import br.unisales.trabalhoPOO.impl.FuncionarioDAO;
import br.unisales.trabalhoPOO.models.Departamento;
import br.unisales.trabalhoPOO.models.Funcionario;

public class Application {

    private static final FuncionarioDAO fdao = new FuncionarioDAO();
    private static final DepartamentoDAO ddao = new DepartamentoDAO();
    private static final Scanner scanner = new Scanner(System.in);

    // Método para inserir um novo departamento
    public static void insereDepartamento() {
        System.out.println("Digite o nome do departamento:");
        String nome = scanner.nextLine();
        Departamento d = new Departamento();
        d.setNome(nome);
        ddao.persist(d);
        System.out.println("Departamento inserido com sucesso!");
    }

    // Método para listar todos os departamentos
    public static void listaDepartamentos() {
    List<Departamento> departamentos = ddao.getAll();
    System.out.println("-------------------------------------------------------------");
    System.out.println("|                       DEPARTAMENTOS                       |");
    System.out.println("-------------------------------------------------------------");
    if (departamentos.isEmpty()) {
        System.out.println("Nenhum departamento encontrado.");
    } else {
        //formatação
        System.out.printf("%-10s | %-30s%n", "ID", "NOME");
        System.out.println("---------------------------------------------");
        departamentos.forEach(d -> System.out.printf("%-10d | %-30s%n", d.getId(), d.getNome()));
    }
}

    // Método para remover um departamento
    public static void removeDepartamento() {
        listaDepartamentos();
        System.out.println("Digite o ID do departamento que deseja remover:");
        Long id = Long.parseLong(scanner.nextLine());
        Departamento departamento = ddao.get(id);

        if (departamento != null) {
            ddao.delete(departamento);
            System.out.println("Departamento removido com sucesso!");
        } else {
            System.out.println("Departamento não encontrado!");
        }
    }

    // Método para inserir um novo funcionário
    public static void insereFuncionario() {
        System.out.println("Digite o nome do funcionário:");
        String nome = scanner.nextLine();
        listaDepartamentos();
        System.out.println("Digite o ID do departamento:");
        Long departamentoId = Long.parseLong(scanner.nextLine());
        Departamento departamento = ddao.get(departamentoId);

        if (departamento != null) {
            Funcionario f = new Funcionario();
            f.setNome(nome);
            f.setDepartamento(departamento);
            fdao.persist(f);
            System.out.println("Funcionário inserido com sucesso!");
        } else {
            System.out.println("Departamento não encontrado!");
        }
    }

  // Método para listar todos os funcionários
public static void listaFuncionarios() {
    List<Funcionario> funcionarios = fdao.getAll();
    System.out.println("-------------------------------------------------------------");
    System.out.println("|                        FUNCIONÁRIOS                       |");
    System.out.println("-------------------------------------------------------------");
    if (funcionarios.isEmpty()) {
        System.out.println("Nenhum funcionário encontrado.");
    } else {
        //Alinha o texto
        System.out.printf("%-10s | %-30s | %-30s%n", "ID", "NOME", "DEPARTAMENTO");
        System.out.println("-------------------------------------------------------------");
        funcionarios.forEach(f -> System.out.printf("%-10d | %-30s | %-30s%n",
                f.getId(), f.getNome(), f.getDepartamento().getNome()));
    }
}

    // Método para remover um funcionário
    public static void removeFuncionario() {
        listaFuncionarios();
        System.out.println("Digite o ID do funcionário que deseja remover:");
        Long id = Long.parseLong(scanner.nextLine());
        Funcionario funcionario = fdao.get(id);

        if (funcionario != null) {
            fdao.delete(funcionario);
            System.out.println("Funcionário removido com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado!");
        }
    }

    // Método para exibir o menu principal
    public static void menu() {
        int op;
        do {
            System.out.println("\n*********************** MENU ***********************");
            System.out.println("0 - Sair");
            System.out.println("1 - Inserir Departamento");
            System.out.println("2 - Listar Departamentos");
            System.out.println("3 - Remover Departamento");
            System.out.println("4 - Inserir Funcionário");
            System.out.println("5 - Listar Funcionários");
            System.out.println("6 - Remover Funcionário");
            System.out.println("***************************************************");
            System.out.print("Escolha uma opção: ");
            op = Integer.parseInt(scanner.nextLine());
    
            switch (op) {
                case 1:
                    insereDepartamento();
                    break;
                case 2:
                    listaDepartamentos();
                    break;
                case 3:
                    removeDepartamento();
                    break;
                case 4:
                    insereFuncionario();
                    break;
                case 5:
                    listaFuncionarios();
                    break;
                case 6:
                    removeFuncionario();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (op != 0);
    }

    // Método principal
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Sistema de Gerenciamento!");
        menu();
        scanner.close();
    }
}
