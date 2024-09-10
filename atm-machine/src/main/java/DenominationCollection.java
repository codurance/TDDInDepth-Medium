import java.util.ArrayList;
import java.util.List;

class DenominationCollection {
    private final List<CashUnit> cashUnits;

    public DenominationCollection(List<CashUnit> cashUnits) {
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
