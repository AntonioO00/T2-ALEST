package Apoio_T2;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.Scanner;


public class APP {

    public static void main(String[] args) throws IOException {
         }




    public void Menu() {
        int option;
        Scanner entrada = new Scanner(System.in);
        System.out.println(
                "Menu:\n" +
                        "[0] Sair\n" +
                        "[1] Consultar dados de uma NF\n" +
                        "[2] Exibir números da NF com maior valor\n" +
                        "[3] Exibir número da NF de menor valor \n" +
                        "[4] Exibir número da NF com mais itens \n" +
                        "[5] Listar todas as NF");
        option = entrada.nextInt();

        do {
            switch (option) {
                case 0:
                    break;
                case 1:
                    lerArquivo();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (option != 0);
    }


    public void consultaNF() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o numero da nota fiscal");
        String numero = entrada.nextLine();
        ListaNotaFiscal lista = new ListaNotaFiscal();
        NotaFiscal fiscal = lista.buscar(numero);
        ListaItemNotaFiscal itens = fiscal.getItens();
        ItemNotaFiscal atual = itens.getInicio();
        while (atual != null) {
            // Aqui você pode acessar os dados do item e realizar ações desejadas
            System.out.println("Item: " + atual.getItemNumero());
            System.out.println("Descrição: " + atual.getDescricao());
            System.out.println("Quantidade: " + atual.getQuantidade());
            System.out.println("Valor Unitário: " + atual.getValorUnitario());
            System.out.println("Valor Total: " + atual.getValorTotalItem());
            // ... adicione mais campos conforme necessário

            // Avance para o próximo nó
            atual = atual.getProximo();
        }

    }


    public static void lerArquivo() throws IOException {
        String linha;
        String arquivo = "notas_fiscais_00500.csv";
        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        ListaNotaFiscal exemploListaNF = new ListaNotaFiscal();
        try {
            System.out.println(leitor.readLine()); //pula a primeira linha do cabecalho
            linha = leitor.readLine();
            String[] colunas = linha.split("[|]");
            String notaAtual = colunas[0];
            String notaAnterior = notaAtual;
            NotaFiscal nf = new NotaFiscal();
            nf.setNumero(colunas[0]);
            exemploListaNF.adicionar(nf);
            nf.setData(Date.valueOf(colunas[1]));
            nf.setCliente(colunas[2]);
            ListaItemNotaFiscal items = new ListaItemNotaFiscal();
            nf.setItens(items);
            while ((linha = leitor.readLine()) != null) {
                colunas = linha.split("[|]");
                notaAtual = colunas[0];
                if (!notaAnterior.equals(notaAtual)) {
                    nf = new NotaFiscal();
                    nf.setNumero(colunas[0]);
                    exemploListaNF.adicionar(nf);
                    nf.setData(Date.valueOf(colunas[1]));
                    nf.setCliente(colunas[2]);
                    items = new ListaItemNotaFiscal();
                    nf.setItens(items);
                    notaAnterior = notaAtual;
                }
                ItemNotaFiscal item = new ItemNotaFiscal(
                        colunas[7],
                        colunas[8],
                        Integer.parseInt(colunas[9]),
                        Double.parseDouble(colunas[10]));
                items.adicionar(item);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }{
            System.out.println("ERRO");
        }
    }





}





