package data_vetor;

public class AppData {
    public static void main(String[] args) {
        Data[] datas = new Data[3];

        datas[0] = new Data(10, 5, 2024);
        datas[1] = new Data(25, 12, 2023);
        datas[2] = new Data(1, 1, 2025);

        System.out.println("Datas cadastradas:");
        for (Data data : datas) {
            data.exibirData();
        }
    }
}
