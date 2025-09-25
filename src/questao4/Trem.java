package src.questao4;

public class Trem implements IMeioTransporte {

    private  int velocidade = 0;
    private final  int velocidadeMax = 300;

    @Override

    public void acelerar() throws Exception {
        if (velocidade + 40 > velocidadeMax){
            throw  new Exception("Velocidade máxima do trem atingida!");
        }
        velocidade += 40;
        System.out.println("Trem acelerou para: " + velocidade + "km/h");

    }

    @Override
    public void frear() throws Exception {
        if (velocidade - 40 < 0){
            throw new Exception("Trem já esta parado");
        }
        velocidade -= 40;
        System.out.println("Trem reduziu para: " + velocidade + "km/h");

    }
}
