package Framework.Utils;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String name;
    private double saldo;
    private List<Movement> movement;

    public Account(){
        movement = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Movement> getMovement() {
        return movement;
    }

    public void setMovement(List<Movement> movement) {
        this.movement = movement;
    }

    public void setBalance(Movement movement){
        if(movement.getType().equals("REC")){
            this.saldo = this.saldo + Double.parseDouble(movement.getValue());
        } else {
            this.saldo = this.saldo - Double.parseDouble(movement.getValue());
        }
    }

    public String getSaldotruncado() {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat.format(this.saldo);
    }
}
