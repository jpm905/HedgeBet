
import java.util.*;

public class hedge{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Initial amount wagered: ");
        double initialBet = scan.nextDouble();
        System.out.println("Odds on the wager: ");
        double initialOdds = scan.nextDouble();

        double initialPayout;

        if(initialOdds < 0){
            initialPayout = 100 / Math.abs(initialOdds) * initialBet;
        }else{
            initialPayout = (initialOdds / 100) * initialBet;
        }


        System.out.println("Odds on the final wager: ");
        double hedgeOdds = scan.nextDouble();

       double hedgeDecimalOdds = americanToDecimal(hedgeOdds);
       double hedgeAmount = (initialBet + initialPayout) / hedgeDecimalOdds;
    
        hedgeAmount = Math.round(hedgeAmount * 100.0)/100.0;
        double netProfit = initialPayout - hedgeAmount;
        netProfit = Math.round(netProfit * 100.0)/100.0;


        System.out.println("Amount you should wager: $" + hedgeAmount);
        System.out.println("Net Profit: $" + (netProfit));

        scan.close();
    }
    
    
    public static double americanToDecimal(double x){
        double val;
        if(x > 0){
            val = (x / 100) + 1;
        }else{
            val = 1 + (100 / Math.abs(x));
        }
        return val;
    }

}




