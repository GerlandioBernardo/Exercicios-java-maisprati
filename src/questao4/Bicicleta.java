package src.questao4;

public class Bicicleta implements IMeioTransporte {

    private  int velocidade = 0;
    private final  int velocidadeMax = 50;

    @Override
    public void acelerar() throws Exception {

        if (velocidade + 5 > velocidadeMax){
            throw  new Exception("Velocidade máxima da bicicleta atingida!");
        }
        velocidade += 5;
        System.out.println("Bicicleta acelerou para: " + velocidade + "km/h");


    }

    @Override
    public void frear() throws Exception {

        if (velocidade - 5 < 0){
            throw  new Exception("Bicicleta já esta parada");
        }
        velocidade -= 5;
        System.out.println("Bicicleta reduziu para: " + velocidade + "km/h");
    }
}
