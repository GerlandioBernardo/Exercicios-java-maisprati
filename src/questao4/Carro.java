package src.questao4;

public class Carro  implements IMeioTransporte {

    private  int velocidade = 0;
    private final  int velocidadeMax = 200;

    @Override
    public void acelerar() throws Exception {
        if(velocidade + 20 > velocidadeMax){
            throw  new Exception("Velocidade máxima do carro atingida!");
        }
        velocidade += 20;
        System.out.println("Carro acelerou para: " + velocidade + "km/h");

    }

    @Override
    public void frear() throws Exception {
        if (velocidade - 20 < 0){
            throw  new Exception("Carro já está parado");
        }
        velocidade -= 20;
        System.out.println("Carro reduziu para: " + velocidade + "km/h");
    }
}
