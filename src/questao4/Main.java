package src.questao4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IMeioTransporte> meioTransportes = new ArrayList<>();

        meioTransportes.add(new Carro());
        meioTransportes.add(new Bicicleta());
        meioTransportes.add(new Trem());

        for (IMeioTransporte transporte : meioTransportes){
            try {
                transporte.acelerar();
                transporte.acelerar();
                transporte.frear();

                System.out.println();

            }catch (Exception exception){
                System.out.println("Erro: " + exception.getMessage());
            }
        }

    }
}
