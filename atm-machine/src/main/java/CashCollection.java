import java.util.ArrayList;
import java.util.List;

class CashCollection {
    private final List<CashUnit> cashUnits;

    public CashCollection(List<CashUnit> cashUnits) {
        this.cashUnits = cashUnits;
    }

    public ArrayList<Money> selectDenominationsFor(int withdrawalAmount) {
        ArrayList<Money> withdrawal = new ArrayList<>();

        for (CashUnit cashUnit : cashUnits) {
            while (withdrawalAmount >= cashUnit.value() && cashUnit.isAvailable()) {
                withdrawal.add(cashUnit.takeOne());
                withdrawalAmount -= cashUnit.value();
            }
        }
        return withdrawal;
    }
}
